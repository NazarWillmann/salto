package ooo.jtc.api.letters.tobank.steps

import io.qameta.allure.Step
import ooo.jtc.dictionaries.branch.Branch
import ooo.jtc.documents.getByBankStatus
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
import ooo.jtc.extensions.DEFAULT_DATE_FORMAT
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT
import ooo.jtc.extensions.convertToDocStamp
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.ofSystemOffset
import ooo.jtc.extensions.string
import ooo.jtc.generic.attachments.dataSizeInKb
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.generic.print.getStampResult
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStampResult
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.Companion.values
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PARTLY_SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVING_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.dictionaries.bankbic.BankBicData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.time.LocalDate
import java.time.ZonedDateTime

object LetterToBankPreparePrintSteps {

    //region Expected print file names
    @Step("Подготовить ожидаемое наименование файла печатной формы (один документ)")
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171808
    fun preparePrintFileNameSingleDoc(docToPrint: LetterToBankDto): String {
        return "LetterToBank" +
                "_No_${docToPrint.documentNumber}" +
                "_dated_${docToPrint.documentDate.string(DEFAULT_DATE_FORMAT)}"
    }

    @Step("Подготовить ожидаемое наименование файла печатной формы реестра документов")
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171811
    fun preparePrintTableFileNameRegex(): Regex {
        val dateOfFormation = LocalDate.now().string()
        val timeOfFormation = "\\d{6}"
        val formatMaxLength = PrintExportFormat.maxLength
        val formatMinLength = PrintExportFormat.minLength
        val formatRegex = "\\w{$formatMinLength,$formatMaxLength}"

        return "LettersToBank_List_${dateOfFormation}_${timeOfFormation}\\.$formatRegex".toRegex()
    }

    @Step("Подготовить ожидаемое наименование файла печатной формы (несколько документов)")
    fun preparePrintFileNameRegexMultipleDocs(): Regex {
        val dateRegex = DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
        val formatMaxLength = PrintExportFormat.maxLength
        val formatMinLength = PrintExportFormat.minLength
        val formatRegex = "\\w{$formatMinLength,$formatMaxLength}"

        return "^LettersToBank_$dateRegex\\.$formatRegex$".toRegex()
    }
    //endregion

    //region Expected printed document file content
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171738
    @Step("Подготовить ожидаемую информацию печатной формы документа")
    fun preparePrintExpContent(docsToPrint: List<LetterToBankDto>, withSignatures: Boolean, printingUser: User): List<String> {
        val expContent: MutableList<String> = mutableListOf()
        docsToPrint.forEach { letterToPrint ->
            val documentValues = mutableListOf(
                "ПИСЬМО В БАНК № ${letterToPrint.documentNumber} от" +      // 1
                        " ${letterToPrint.documentDate.string(DOTS_DATE_FORMAT)} г.", //2
                letterToPrint.docTypeDescription ?: "",                     // 3
                letterToPrint.docTheme ?: "",                               // 4
                "Отправитель",
                letterToPrint.customerName ?: "",                           // 5
                "Получатель",
                letterToPrint.branchName ?: "",                             // 6
                letterToPrint.docText ?: ""                                 // 7
            )
            val docStampValues = getExpStampDataForLTB(letterToPrint, printingUser)
            documentValues.addAll(docStampValues)

            if (!letterToPrint.attachments.isNullOrEmpty()) {
                documentValues.add("Вложения")
                letterToPrint.attachments!!.forEach {
                    documentValues.add(it.fileName)                         // 8.1
                    documentValues.add("(${it.dataSizeInKb()} ")            // 8.2-1
                    documentValues.add(" Кб)")                              // 8.2-2
                }
            }
            if (!(null == letterToPrint.contactName && null == letterToPrint.contactPhone)) {
                documentValues.add("Ответственный")
                documentValues.add("исполнитель")
                documentValues.add("тел.")
                letterToPrint.contactName?.let { documentValues.add(it) }   // 9
                letterToPrint.contactPhone?.let { documentValues.add(it) }  // 10
            }
            if (withSignatures) {
                val docSignatureValues = getExpSignatureInfoForLTB(letterToPrint, printingUser)
                documentValues.addAll(docSignatureValues)                   // 11.1, 11.2, 11.3
            }
            expContent.addAll(documentValues)
        }
        return expContent
    }

    @Step("Подготовить ожидаемую информацию штампа документа [{letterToBank.id}] в его печатной форме")
    //Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729817
    //Also worth mentioning: https://jira.jtc.ooo/browse/JTCSALTO-3431
    private fun getExpStampDataForLTB(letterToBank: LetterToBankDto, printingUser: User): List<String> {
        val listOfStatusesWithoutStamp = listOf(DRAFT, NEW, PARTLY_SIGNED, SIGNED, DELIVERED, FOR_RECEIVING, RECEIVING_ERROR)
            .map { it.getUserStatus(printingUser.userType) }
        if (letterToBank.status!! in listOfStatusesWithoutStamp)
            return emptyList()

        //common stamp data
        var branch: Branch? = null
        soft { branch = BranchData.byId(letterToBank.branchId!!) }

        val docStampValues = mutableListOf<String>()
        if (null != branch) {
            val bankByBranchBic = BankBicData.searchBy(branch!!.paymentDetailsBic!!.bic!!)
            val expCorrAccountOutput = bankByBranchBic.getSingleOrNullActiveAccount()
                ?.let { "к/с ${it.account}" }
                ?: ""

            docStampValues.add(branch!!.shortName)                          // 4.2.1-1(+)
            docStampValues.add("БИК ${branch!!.paymentDetailsBic!!.bic}")                       // 4.2.1-2(+)
            docStampValues.add(expCorrAccountOutput)                        // 4.2.1-3(+)
        } else {
            docStampValues.add(letterToBank.branchName ?: "")               // 4.2.1-1(-)
            // 4.2.1-2(-), 4.2.1-3(-): пустые строки; метки к полю тоже не выводятся
        }

        //status-specific data
        val statusSpecificStampData = getStatusSpecificStampData(letterToBank, printingUser)
        docStampValues.addAll(statusSpecificStampData)                      // 4.2.2, 4.2.3

        return docStampValues
    }

    private fun getStatusSpecificStampData(letterToBank: LetterToBankDto, printingUser: User): List<String> {
        val ltbStatusInString = letterToBank.status!!
        val stampDate: String
        val stampUserFio: String
        val stampDateConversion: (ZonedDateTime) -> String = { it.ofSystemOffset().convertToDocStamp() }

        val lTBSteps = LetterToBankSteps(printingUser)
        val ltbStatus = LetterToBankStatus.values().getByBankStatus(ltbStatusInString)
        val stampResult = LetterToBankStampResult.values().getStampResult(ltbStatus)
        when (ltbStatus) {
            RECEIVED, IN_PROCESSING, WRONG_ESIGNATURE, DETAILS_ERROR -> {
                // [Sergeyev] 2020.09.24: здесь и далее - неявная связь в ТЗ
                // одинаковые требования к заполнению полей на основе (скрытого) поля Письма в Банк receiveUserId / receiveDate
                val receiveTicket = lTBSteps.getReceiveTicket(letterToBank.id!!)
                    .data.getOrException("Ошибка при получении квитка о приёме Письма")
                stampDate = stampDateConversion(receiveTicket.receiveDate!!)
                stampUserFio = receiveTicket.receiveUserName ?: ""
            }
            PROCESSED, RECALLED -> {
                val processTicket = lTBSteps.getExecutionTicket(letterToBank.id!!)
                    .data.getOrException("Ошибка при получении квитка об обработке Письма")
                stampDate = stampDateConversion(processTicket.executionDate)
                stampUserFio = processTicket.executionUserName
            }
            else -> throw RuntimeException("Unexpected status for LetterToBank: '${ltbStatusInString}'")
        }
        return listOf(stampResult, stampDate, stampUserFio)
    }

    @Step("Подготовить ожидаемую информацию о подписях документа [{letterToBank.id}] в его печатной форме")
    private fun getExpSignatureInfoForLTB(letterToBank: LetterToBankDto, printingUser: User): List<String> {
        val docSignatures = LetterToBankSteps(printingUser).getSignatures(letterToBank.id!!)
            .list.getOrException("Ошибка при получении подписей для документа [${letterToBank.id}]")
        if (docSignatures.isEmpty())
            return emptyList()

        val docSignatureValues = mutableListOf(
            "Информация о подписях",
            "ФИО подписанта", "Тип подписи", "Подпись установлена"
        )
        docSignatures.forEach { docSignature ->
            val signingDateTime = docSignature.createdAt!!.ofSystemOffset()
                .string(DOTS_DATE_WITH_TIME_WITHOUT_SECONDS_FORMAT)
            docSignature.userName?.let { docSignatureValues.add(it) }           // 11.1
            docSignature.signKind?.let { docSignatureValues.add(it) }           // 11.2
            docSignatureValues.add(signingDateTime)                 // 11.3
        }
        return docSignatureValues
    }
    //endregion

    //region Expected print document table file content
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171744
    @Step("Подготовить ожидаемую информацию реестра документов")
    fun preparePrintTableExpContent(docsToPrint: List<LetterToBankDto>, userType: UserType): List<String> {
        // adding common strings for all LetterToBank tables
        val expContent: MutableList<String> = mutableListOf(
            "РЕЕСТР ДОКУМЕНТОВ «ПИСЬМО В БАНК»",
            "№", "п/п", "Дата", "Номер", "Тип письма", "Тема письма", "Отправитель", "Получатель", "Статус",
            "ИТОГО:", "${docsToPrint.size} документ${
                when (docsToPrint.size) {
                    1 -> ""
                    2, 3, 4 -> "а"
                    else -> "ов"
                }
            }",
            "Реестр сформирован"
        )

        // adding document data
        docsToPrint.forEach { letterInTable ->
            val documentValues = getPrintTableContentForLTB(letterInTable, userType)
            expContent.addAll(documentValues)
        }

        // adding string numbers
        for (i in 1..docsToPrint.size) {
            expContent.add(i.toString())
        }
        return expContent
    }

    @Step("Подготовить ожидаемую информацию о документе в реестре документов")
    private fun getPrintTableContentForLTB(letterToBank: LetterToBankDto, userType: UserType): List<String> {
        return listOf(
            letterToBank.documentDate.string(DOTS_DATE_FORMAT),
            letterToBank.documentNumber,
            letterToBank.docTypeDescription ?: "",
            letterToBank.docTheme ?: "",
            letterToBank.customerName ?: "",
            letterToBank.branchName ?: "",
            values.getDescriptionByStatus(letterToBank.status!!, userType)
        )
    }
    //endregion
}