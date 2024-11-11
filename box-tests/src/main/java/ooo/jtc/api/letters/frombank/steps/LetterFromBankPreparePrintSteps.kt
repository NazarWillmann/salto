package ooo.jtc.api.letters.frombank.steps

import io.qameta.allure.Step
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
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
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStampResult
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.dictionaries.bankbic.BankBicData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.time.LocalDate

object LetterFromBankPreparePrintSteps {

    //region Expected print file names
    @Step("Подготовить ожидаемое наименование файла печатной формы (один документ)")
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726909
    fun preparePrintFileNameSingleDoc(docToPrint: LetterFromBankDto): String {
        return "LetterFromBank" +
                "_No_${docToPrint.documentNumber}" +
                "_dated_${docToPrint.documentDate.string(DEFAULT_DATE_FORMAT)}"
    }

    @Step("Подготовить ожидаемое наименование файла печатной формы реестра документов")
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725913
    fun preparePrintTableFileNameRegex(): Regex {
        val dateOfFormation = LocalDate.now().string()
        val timeOfFormation = "\\d{6}"
        val formatMaxLength = PrintExportFormat.maxLength
        val formatMinLength = PrintExportFormat.minLength
        val formatRegex = "\\w{$formatMinLength,$formatMaxLength}"

        return "LettersFromBank_List_${dateOfFormation}_${timeOfFormation}\\.$formatRegex".toRegex()
    }

    @Step("Подготовить ожидаемое наименование файла печатной формы (несколько документов)")
    fun preparePrintFileNameRegexMultipleDocs(): Regex {
        val dateRegex = DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
        val formatMaxLength = PrintExportFormat.maxLength
        val formatMinLength = PrintExportFormat.minLength
        val formatRegex = "\\w{$formatMinLength,$formatMaxLength}"

        return "^LettersFromBank_$dateRegex\\.$formatRegex$".toRegex()
    }
    //endregion

    //region Expected printed document file content
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727032
    @Step("Подготовить ожидаемую информацию печатной формы документа")
    fun preparePrintExpContent(docsToPrint: List<LetterFromBankDto>, withSignatures: Boolean, printingUser: User): List<String> {
        val expContent: MutableList<String> = mutableListOf()
        docsToPrint.forEach { letterToPrint ->
            val documentValues = mutableListOf(
                "ПИСЬМО ИЗ БАНКА № ${letterToPrint.documentNumber} от" +    // 1
                        " ${letterToPrint.documentDate.string(DOTS_DATE_FORMAT)} г.", //2
                letterToPrint.docTypeDescription ?: "",                     // 3
                letterToPrint.docTheme ?: "",                               // 4
                "Отправитель",
                letterToPrint.branchName ?: "",                             // 5
                "Получатель",
                letterToPrint.customerName ?: "",                           // 6
                letterToPrint.docText ?: ""                                 // 7
            )
            val docStampValues = getExpStampDataForLFB(letterToPrint, printingUser)
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
                val docSignatureValues = getExpSignatureInfoForLFB(letterToPrint, printingUser)
                documentValues.addAll(docSignatureValues)                   // 11.1, 11.2, 11.3
            }
            expContent.addAll(documentValues)
        }
        return expContent
    }

    @Step("Подготовить ожидаемую информацию штампа документа [{letterFromBank.id}] в его печатной форме")
    //Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729830
    //Also worth mentioning: https://jira.jtc.ooo/browse/JTCSALTO-3431
    private fun getExpStampDataForLFB(letterFromBank: LetterFromBankDto, printingUser: User): List<String> {
        val listOfStatusesWithoutStamp = listOf(DRAFT, NEW, SIGNED)
            .map { it.getUserStatus(printingUser.userType) }
        if (letterFromBank.status!! in listOfStatusesWithoutStamp)
            return emptyList()

        //common stamp data
        var branch: Branch? = null
        soft { branch = BranchData.byId(letterFromBank.branchId!!) }

        val docStampValues = mutableListOf<String>()
        if (null != branch) {
            val bankByBranchBic = BankBicData.searchBy(branch!!.paymentDetailsBic!!.bic!!)
            val expCorrAccountOutput = bankByBranchBic.getSingleOrNullActiveAccount()
                ?.let { "к/с ${it.account}" }
                ?: ""

            docStampValues.add(branch!!.shortName)                          // 4.2.1(+)
            docStampValues.add("БИК ${branch!!.paymentDetailsBic!!.bic}")                       // 4.2.2(+)
            docStampValues.add(expCorrAccountOutput)                        // 4.2.3(+)
        } else {
            docStampValues.add(letterFromBank.branchName ?: "")             // 4.2.1(-)
            // 4.2.2(-), 4.2.3(-): пустые строки; метки к полю тоже не выводятся
        }

        //status-specific data
        val statusSpecificStampData = getStatusSpecificStampData(letterFromBank, printingUser)
        docStampValues.addAll(statusSpecificStampData)                      // 4.2.4, 4.2.5, 4.2.6

        return docStampValues
    }

    private fun getStatusSpecificStampData(letterFromBank: LetterFromBankDto, printingUser: User): List<String> {
        val lfbStatusInString = letterFromBank.status!!
        val lfbStatus = LetterFromBankStatus.values.getByBankStatus(lfbStatusInString)
        val stampResult = LetterFromBankStampResult.values().getStampResult(lfbStatus)

        // [Sergeyev] 2020.09.25: здесь - неявная связь в ТЗ
        // одинаковые требования к заполнению полей на основе (скрытого) поля Письма из Банк sendUserId / sendDate
        val lfbSteps = LetterFromBankSteps(retrieveBankUser(printingUser))
        val sendTicket = lfbSteps.getSendTicket(letterFromBank.id!!).data.getOrException("Ошибка при получении квитка об отправке Письма")

        val stampDate = sendTicket.sendDate!!.ofSystemOffset().convertToDocStamp()
        val stampUserFio = sendTicket.sendUserName ?: ""
        return listOf(stampResult, stampDate, stampUserFio)
    }

    @Step("Подготовить ожидаемую информацию о подписях документа [{letterFromBank.id}] в его печатной форме")
    private fun getExpSignatureInfoForLFB(letterFromBank: LetterFromBankDto, printingUser: User): List<String> {
        val docSignatures = LetterFromBankSteps(retrieveBankUser(printingUser)).getSignatures(letterFromBank.id!!)
            .list.getOrException("Ошибка при получении подписей для документа [${letterFromBank.id}]")
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
    fun preparePrintTableExpContent(docsToPrint: List<LetterFromBankDto>, userType: UserType): List<String> {
        // adding common strings for all LetterFromBank tables
        val expContent: MutableList<String> = mutableListOf(
            "РЕЕСТР ДОКУМЕНТОВ «ПИСЬМО ИЗ БАНКА»",
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
            val documentValues = getPrintTableContentForLFB(letterInTable, userType)
            expContent.addAll(documentValues)
        }

        // adding string numbers
        for (i in 1..docsToPrint.size) {
            expContent.add(i.toString())
        }
        return expContent
    }

    @Step("Подготовить ожидаемую информацию о документе в реестре документов")
    private fun getPrintTableContentForLFB(letterFromBank: LetterFromBankDto, userType: UserType): List<String> {
        return listOf(
            letterFromBank.documentDate.string(DOTS_DATE_FORMAT),
            letterFromBank.documentNumber,
            letterFromBank.docTypeDescription ?: "",
            letterFromBank.docTheme ?: "",
            letterFromBank.customerName ?: "",
            letterFromBank.branchName ?: "",
            LetterFromBankStatus.values.getDescriptionByStatus(letterFromBank.status!!, userType)
        )
    }
    //endregion
}