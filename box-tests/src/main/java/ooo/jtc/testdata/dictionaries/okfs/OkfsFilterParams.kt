package ooo.jtc.testdata.dictionaries.okfs

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.okfs.OkfsDto

enum class OkfsFilterParams(
    override var field: String,
    override var fieldDataProvider: (OkfsDto) -> Any
) : IFilterParams<OkfsDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    PARENT_CODE("parentCode", fieldDataProvider = { it.parentCode!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}
