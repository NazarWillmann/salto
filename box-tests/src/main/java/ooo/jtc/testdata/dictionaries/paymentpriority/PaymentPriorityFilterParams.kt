package ooo.jtc.testdata.dictionaries.paymentpriority

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityDto

enum class PaymentPriorityFilterParams(
    override var field: String,
    override var fieldDataProvider: (PaymentPriorityDto) -> Any
) : IFilterParams<PaymentPriorityDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;
}