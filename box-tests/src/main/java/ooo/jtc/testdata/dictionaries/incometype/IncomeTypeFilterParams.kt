package ooo.jtc.testdata.dictionaries.incometype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.incometype.IncomeTypeDto

enum class IncomeTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (IncomeTypeDto) -> Any
) : IFilterParams<IncomeTypeDto> {

    CODE("code", fieldDataProvider = { it.code!! }),
    NAME("name", fieldDataProvider = { it.name }),
    DESCRIPTION("description", fieldDataProvider = { it.description });
}
