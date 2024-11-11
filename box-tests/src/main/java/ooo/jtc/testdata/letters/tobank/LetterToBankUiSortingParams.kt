package ooo.jtc.testdata.letters.tobank

import ooo.jtc.extensions.toDate
import ooo.jtc.testdata.common.UiDateConverter.convertCreatedAtDateTime
import ooo.jtc.ui.interfaces.UiSortingParam

enum class LetterToBankUiSortingParams(
    override val fieldName: String,
    override val rowDataField: String,
    override val stringToComparable: (String) -> Comparable<*>
) : UiSortingParam {
    DOCUMENT_NUMBER(fieldName = "№ документа", rowDataField = "documentNumber", stringToComparable = { it.replace("№ ", "") }),
    DOCUMENT_DATE(fieldName = "Дата документа", rowDataField = "documentDate", stringToComparable = { it.toDate() }),
    CREATED_AT(fieldName = "Дата/время создания", rowDataField = "createdAt", stringToComparable = { convertCreatedAtDateTime(it) }),

    /* bank side fields*/
    B_DOCUMENT_DATE(fieldName = "Дата документа", rowDataField = "documentDate", stringToComparable = { it.toDate() }),
    B_STATUS(fieldName = "Статус", rowDataField = "status", stringToComparable = { it }),
    B_CUSTOMER_NAME(fieldName = "Клиент", rowDataField = "customerName", stringToComparable = { it }),

    //TODO A.Stykalin [15.09.2020]
    //     Нет возможности проверить эти поля, т.к. они не отображаются в строках на скроллере.
    //     Можно было бы попробовать использовать перехват запросов через прокси, и проверять,
    //     что фронт корректно выводит поля полученного списка.
    //     Но, тут надо подумать стоит ли это потраченного времени? Т.к. сортировка не критичный функционал.
    //     =>
    B_DOC_TYPE_DESCRIPTION(fieldName = "Тип письма", rowDataField = "", stringToComparable = { it }),
    B_RECEIVE_DATE(fieldName = "Дата/время приема", rowDataField = "", stringToComparable = { it }),
    B_EXECUTION_DATE(fieldName = "Дата/время обработки", rowDataField = "", stringToComparable = { it }),
    ;

    companion object {
        val clientFields = listOf(DOCUMENT_NUMBER, DOCUMENT_DATE, CREATED_AT).map { it.fieldName }
        val bankFields = listOf(
            B_DOCUMENT_DATE, B_STATUS, B_CUSTOMER_NAME, B_DOC_TYPE_DESCRIPTION,
            B_RECEIVE_DATE, B_EXECUTION_DATE
        ).map { it.fieldName }
    }
}