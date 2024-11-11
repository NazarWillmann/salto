package ooo.jtc.testdata.dictionaries.paymenttype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.paymenttype.PaymentTypeDto

enum class PaymentTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (PaymentTypeDto) -> Any?
) : ISortingParams<PaymentTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}