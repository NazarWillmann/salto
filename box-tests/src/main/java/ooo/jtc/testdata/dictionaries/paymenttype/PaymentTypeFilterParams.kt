package ooo.jtc.testdata.dictionaries.paymenttype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.paymenttype.PaymentTypeDto

enum class PaymentTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (PaymentTypeDto) -> Any
) : IFilterParams<PaymentTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;
}