package ooo.jtc.testdata.letters.frombank

import ooo.jtc.extensions.toDate
import ooo.jtc.ui.interfaces.UiSortingParam

enum class UiLetterFromBankSortingParams(
    override val fieldName: String,
    override val rowDataField: String,
    override val stringToComparable: (String) -> Comparable<*>
) : UiSortingParam {
    DOCUMENT_NUMBER(fieldName = "№ документа", rowDataField = "documentNumber", stringToComparable = { it.replace("№ ", "") }),
    DOCUMENT_DATE(fieldName = "Дата документа", rowDataField = "documentDate", stringToComparable = { it.toDate() }),

    /* bank side fields*/
    B_DOCUMENT_DATE(fieldName = "Дата документа", rowDataField = "documentDate", stringToComparable = { it.toDate() }),
    B_STATUS(fieldName = "Статус", rowDataField = "status", stringToComparable = { it }),
    B_CUSTOMER_NAME(fieldName = "Клиент", rowDataField = "customerName", stringToComparable = { it }),

    //TODO Sergeyev [2020.10.28] Нет возможности проверить эти поля, т.к. они не отображаются в строках на скроллере [2]
    B_DOC_TYPE_DESCRIPTION(fieldName = "Тип письма", rowDataField = "", stringToComparable = { it }),
    B_CREATE_DATE(fieldName = "Дата/время создания", rowDataField = "", stringToComparable = { it }),
    B_SEND_DATE(fieldName = "Дата/время отправки", rowDataField = "", stringToComparable = { it }),
    ;

    companion object {
        val clientFields = listOf(DOCUMENT_NUMBER, DOCUMENT_DATE).map { it.fieldName }
        val bankFields = listOf(
            B_DOCUMENT_DATE, B_STATUS, B_CUSTOMER_NAME,
            B_DOC_TYPE_DESCRIPTION, B_CREATE_DATE, B_SEND_DATE
        ).map { it.fieldName }
    }
}