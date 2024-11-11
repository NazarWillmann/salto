package ooo.jtc.testdata.dictionaries.budgetreasoncode

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto

enum class BudgetReasonCodeSortingParams(
    override var field: String,
    override var fieldDataProvider: (BudgetReasonCodeDto) -> Any?
) : ISortingParams<BudgetReasonCodeDto> {
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    CODE("code", fieldDataProvider = { it.code }),
    PAY_TYPE("payType", fieldDataProvider = { it.payType })
}