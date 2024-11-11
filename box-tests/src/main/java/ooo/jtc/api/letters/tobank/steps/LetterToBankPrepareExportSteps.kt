package ooo.jtc.api.letters.tobank.steps

import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
import ooo.jtc.extensions.DEFAULT_DATE_FORMAT
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.DOTS_DATE_WITH_TIME_FORMAT
import ooo.jtc.extensions.ofSystemOffset
import ooo.jtc.extensions.string
import ooo.jtc.generic.attachments.dataSizeInKb
import ooo.jtc.generic.print.PrintExportFormat
import ooo.jtc.generic.print.PrintExportFormat.CSV
import ooo.jtc.generic.print.PrintExportFormat.XLSX
import ooo.jtc.generic.print.PrintExportFormat.XML
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus.Companion.values
import ooo.jtc.uaa.UserType
import java.time.ZonedDateTime

object LetterToBankPrepareExportSteps {

    //region Names
    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725843
    fun prepareExportFileNameSingleDoc(docToPrint: LetterToBankDto): String {
        return "LetterToBank" +
                "_No_${docToPrint.documentNumber}" +
                "_dated_${docToPrint.documentDate.string(DEFAULT_DATE_FORMAT)}"
    }

    fun prepareExportFileNameRegexMultipleDocs(): Regex {
        val dateRegex = DEFAULT_DATE_AND_TIME_WITHOUT_DELIMITERS_REGEX_STRING
        val formatMaxLength = PrintExportFormat.maxLength
        val formatMinLength = PrintExportFormat.minLength
        val formatRegex = "\\w{$formatMinLength,$formatMaxLength}"

        return "^LettersToBank_$dateRegex\\.$formatRegex$".toRegex()
    }
    //endregion

    //region Expected export content
    fun getExportExpContentByFormat(
        exportFormat: PrintExportFormat, docsToPrint: List<LetterToBankDto>, userType: UserType
    ): List<String> {
        return when (exportFormat) {
            CSV -> prepareExportCsvExpContent(docsToPrint, userType)
            XLSX -> prepareExportXlsxExpContent(docsToPrint, userType)
            XML -> prepareExportXmlExpContent(docsToPrint, userType)
            else -> throw RuntimeException("Unexpected export format: '$exportFormat'")
        }
    }

    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725887
    // + Common CSV-format export: https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727649
    /**
     * @param docsToPrint - letterFromBank DTO's to print
     * @param userType - user type of printing user (client/bank)
     * @param withRuHeader - boolean flag; column descriptions (localized field names) should be printed.
     *                      Always 'true' in Release 1
     * @param withSysHeader - boolean flag; column fields (system field names) should be printed.
     *                      Always 'false' in Release 1
     */
    private fun prepareExportCsvExpContent(
        docsToPrint: List<LetterToBankDto>,
        userType: UserType,
        withRuHeader: Boolean = true,
        withSysHeader: Boolean = false
    ): List<String> {
        val expContent: MutableList<String> = mutableListOf()
        if (withRuHeader)
            expContent.addAll(getRuHeaderValues())

        if (withSysHeader)
            expContent.addAll(getSysHeaderValues())

        docsToPrint.forEach { letter ->
            val changedDocumentValues = listOf(
                letter.documentNumber,                          // 1 Номер документа
                letter.docTypeDescription,                      // 3 Описание типа письма в банк
                letter.docTheme,                                // 4 Тема письма
                letter.docText,                                 // 5 Текст письма
                letter.customerName,                            // 7 Наименование Клиента
                letter.contactName,                             // 8 ФИО ответственного исполнителя
                letter.branchName,                              // 10 Наименование подразделения Банка
            )
                .map { prepareDocFieldCsvExportValue(it) }
            val nonChangedDocumentValues = listOf(
                letter.documentDate.string(DOTS_DATE_FORMAT),   // 2 Дата документа
                //*Статус - требование ТЗ относительно того, какое должно быть отображение статуса (Клиент/Банк),
                // неявно перекрывается используемым пользователем в тесте. При получении документа по id
                // пользователю вернётся именно то значение статуса, какое и должно попасть в файл экспорта
                values.getDescriptionByStatus(letter.status!!, userType),// 3 Статус
                if (true == letter.isHasAttach) "ДА" else "",   // 6 Признак наличия файлов-вложений
                letter.contactPhone ?: "",                      // 9 Телефон ответственного исполнителя
                exportDateConversion(letter.createdAt),         // 11 Дата/время создания документа
                exportDateConversion(letter.receiveDate),       // 12 Дата/время приема документа
                exportDateConversion(letter.executionDate)      // 13 Дата/время исполнения документа
            )
            expContent.addAll(changedDocumentValues)
            expContent.addAll(nonChangedDocumentValues)
        }
        return expContent
    }

    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725883
    // + Common XLSX-format export: https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727651
    /**
     * @param docsToPrint - letterFromBank DTO's to print
     * @param userType - user type of printing user (client/bank)
     * @param withRuHeader - boolean flag; column descriptions (localized field names) should be printed.
     *                      Always 'true' in Release 1
     * @param withSysHeader - boolean flag; column fields (system field names) should be printed.
     *                      Always 'false' in Release 1
     */
    private fun prepareExportXlsxExpContent(
        docsToPrint: List<LetterToBankDto>,
        userType: UserType,
        withRuHeader: Boolean = true,
        withSysHeader: Boolean = false
    ): List<String> {
        val expContent: MutableList<String> = mutableListOf()
        if (withRuHeader)
            expContent.addAll(getRuHeaderValues())

        if (withSysHeader)
            expContent.addAll(getSysHeaderValues())

        docsToPrint.forEach { letter ->
            val documentValues = listOf(
                letter.documentNumber,                          // 1 Номер документа
                letter.documentDate.string(DOTS_DATE_FORMAT),   // 2 Дата документа
                //*Статус - требование ТЗ относительно того, какое должно быть отображение статуса (Клиент/Банк),
                // неявно перекрывается используемым пользователем в тесте. При получении документа по id
                // пользователю вернётся именно то значение статуса, какое и должно попасть в файл экспорта
                values.getDescriptionByStatus(letter.status!!, userType),// 3 Статус
                letter.docTypeDescription ?: "",                // 3 Описание типа письма в банк
                letter.docTheme ?: "",                          // 4 Тема письма
                letter.docText ?: "",                           // 5 Текст письма
                if (true == letter.isHasAttach) "ДА" else "",   // 6 Признак наличия файлов-вложений
                letter.customerName ?: "",                      // 7 Наименование Клиента
                letter.contactName ?: "",                       // 8 ФИО ответственного исполнителя
                letter.contactPhone ?: "",                      // 9 Телефон ответственного исполнителя
                letter.branchName ?: "",                        // 10 Наименование подразделения Банка
                exportDateConversion(letter.createdAt),         // 11 Дата/время создания документа
                exportDateConversion(letter.receiveDate),       // 12 Дата/время приема документа
                exportDateConversion(letter.executionDate)      // 13 Дата/время исполнения документа
            )
            expContent.addAll(documentValues)
        }
        return expContent
    }

    // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725885
    // + Common XML-format export: https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727653
    private fun prepareExportXmlExpContent(docsToPrint: List<LetterToBankDto>, userType: UserType): List<String> {
        val expContent: MutableList<String> = mutableListOf()
        docsToPrint.forEach { letter ->
            val documentValues = listOf(
                letter.documentNumber,                          // 1 Номер документа
                letter.documentDate.string(DOTS_DATE_FORMAT),   // 2 Дата документа
                //*Статус - требование ТЗ относительно того, какое должно быть отображение статуса (Клиент/Банк),
                // неявно перекрывается используемым пользователем в тесте. При получении документа по id
                // пользователю вернётся именно то значение статуса, какое и должно попасть в файл экспорта
                values.getDescriptionByStatus(letter.status!!, userType),// 3 Статус
                letter.docTypeDescription ?: "",                // 3 Описание типа письма в банк
                letter.docTheme ?: "",                          // 4 Тема письма
                letter.docText ?: "",                           // 5 Текст письма
                if (true == letter.isHasAttach) "ДА" else "",   // 6 Признак наличия файлов-вложений
                letter.customerName ?: "",                      // 7 Наименование Клиента
                letter.contactName ?: "",                       // 8 ФИО ответственного исполнителя
                letter.contactPhone ?: "",                      // 9 Телефон ответственного исполнителя
                letter.branchName ?: "",                        // 10 Наименование подразделения Банка
                exportDateConversion(letter.createdAt),         // 11 Дата/время создания документа
                exportDateConversion(letter.receiveDate),       // 12 Дата/время приема документа
                exportDateConversion(letter.executionDate)      // 13 Дата/время исполнения документа
            )
            expContent.addAll(documentValues)

            letter.attachments?.forEach {                       // 14 Информация о файлах-вложениях
                val docAttach = listOf(
                    it.fileName,                                // 14.1 Файл-вложение → Наименование файла
                    it.dataSizeInKb().toString()                // 14.2 Файл-вложение → Размер файла
                )
                expContent.addAll(docAttach)
            }
        }
        return expContent
    }
    //endregion

    //region Support methods
    private fun exportDateConversion(date: ZonedDateTime?) =
        date?.ofSystemOffset()?.string(DOTS_DATE_WITH_TIME_FORMAT) ?: ""

    private fun prepareDocFieldCsvExportValue(fieldValue: String?): String {
        return (fieldValue ?: "")
            .replace('«', '"')
            .replace('»', '"')
            .replace(';', ',')
        //TODO [Sergeyev]: если в реквизите присутствуют символы, не поддерживаемые кодировкой (ANSI), то они удаляются
    }

    // Sergeyev [2020.10.05]: even if each format should be treated as a completely different case, (!) FOR NOW (!)
    // header values are the same for CSV and XLSX formats
    private fun getRuHeaderValues(): List<String> {
        return listOf(
            "Номер документа", "Дата документа", "Статус", "Тип письма",            //1,2,3,3
            "Тема письма", "Текст письма", "Наличие вложения", "Отправитель",       //4,5,6,7
            "ФИО ответственного исполнителя", "Телефон ответственного исполнителя", //8,9
            "Получатель", "Дата/время создания документа",                          //10,11
            "Дата/время приема в обработку", "Дата/время обработки"                 //12,13
            //, "Наименование файла", "Размер файла" //???
        )
    }

    // Sergeyev [2020.10.05]: even if each format should be treated as a completely different case, (!) FOR NOW (!)
    // header values are the same for CSV and XLSX formats
    private fun getSysHeaderValues(): List<String> {
        return listOf(
            "documentNumber", "documentDate", "status", "docTypeDescription",   //1,2,3,3
            "docTheme", "docText", "isHasAttach", "customerName",               //4,5,6,7
            "contactName", "contactPhone", "branchName", "createdAt",           //8,9,10,11
            "receiveDate", "executionDate"                                      //12,13
            //, "attachments.fileName", "attachments.fileSize" //???
        )
    }
    //
}