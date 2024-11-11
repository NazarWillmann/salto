package ooo.jtc.testdata.dictionaries.budgetpayerstatus

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto

enum class BudgetPayerStatusSortingParams(
    override var field: String,
    override var fieldDataProvider: (BudgetPayerStatusDto) -> Any?
) : ISortingParams<BudgetPayerStatusDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;
}