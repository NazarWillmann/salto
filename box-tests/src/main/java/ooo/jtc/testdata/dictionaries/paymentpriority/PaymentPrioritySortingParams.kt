package ooo.jtc.testdata.dictionaries.paymentpriority

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityDto

enum class PaymentPrioritySortingParams(
    override var field: String,
    override var fieldDataProvider: (PaymentPriorityDto) -> Any?
) : ISortingParams<PaymentPriorityDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}