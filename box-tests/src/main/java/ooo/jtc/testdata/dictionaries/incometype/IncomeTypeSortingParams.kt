package ooo.jtc.testdata.dictionaries.incometype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.incometype.IncomeTypeDto

enum class IncomeTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (IncomeTypeDto) -> Any?
) : ISortingParams<IncomeTypeDto> {
    
    CODE("code", fieldDataProvider = { it.code }),
    NAME("name", fieldDataProvider = { it.name }),
    DESCRIPTION("description", fieldDataProvider = { it.description });
}