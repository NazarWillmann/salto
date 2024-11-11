package ooo.jtc.testdata.dictionaries.codevo

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.codevo.CodeVoDto

enum class CodeVoFilterParams(
    override var field: String,
    override var fieldDataProvider: (CodeVoDto) -> Any
) : IFilterParams<CodeVoDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;

}
