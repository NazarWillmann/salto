package ooo.jtc.testdata.dictionaries.codevo

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.codevo.CodeVoDto

enum class CodeVoSortingParams(
    override var field: String,
    override var fieldDataProvider: (CodeVoDto) -> Any?
) : ISortingParams<CodeVoDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}