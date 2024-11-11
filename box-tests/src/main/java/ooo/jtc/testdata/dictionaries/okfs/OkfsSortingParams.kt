package ooo.jtc.testdata.dictionaries.okfs

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.okfs.OkfsDto

enum class OkfsSortingParams(
    override var field: String,
    override var fieldDataProvider: (OkfsDto) -> Any?
) : ISortingParams<OkfsDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    PARENT_CODE("parentCode", fieldDataProvider = { it.parentCode }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}