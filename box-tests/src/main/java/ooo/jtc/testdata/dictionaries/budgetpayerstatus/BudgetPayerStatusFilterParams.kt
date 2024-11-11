package ooo.jtc.testdata.dictionaries.budgetpayerstatus

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto

enum class BudgetPayerStatusFilterParams(
    override var field: String,
    override var fieldDataProvider: (BudgetPayerStatusDto) -> Any
) : IFilterParams<BudgetPayerStatusDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;
}