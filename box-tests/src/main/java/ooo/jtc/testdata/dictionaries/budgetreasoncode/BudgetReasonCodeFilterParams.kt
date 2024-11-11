package ooo.jtc.testdata.dictionaries.budgetreasoncode

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto

enum class BudgetReasonCodeFilterParams(
    override var field: String,
    override var fieldDataProvider: (BudgetReasonCodeDto) -> Any
) : IFilterParams<BudgetReasonCodeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    PAY_TYPE("payType", fieldDataProvider = { it.payType!! }),
    ;
}