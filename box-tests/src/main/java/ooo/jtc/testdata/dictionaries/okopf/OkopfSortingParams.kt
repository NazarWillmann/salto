package ooo.jtc.testdata.dictionaries.okopf

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.okopf.OkopfDto

enum class OkopfSortingParams(
    override var field: String,
    override var fieldDataProvider: (OkopfDto) -> Any?
) : ISortingParams<OkopfDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}