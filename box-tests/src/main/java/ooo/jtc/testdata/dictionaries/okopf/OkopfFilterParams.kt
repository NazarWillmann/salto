package ooo.jtc.testdata.dictionaries.okopf

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.okopf.OkopfDto

enum class OkopfFilterParams(
    override var field: String,
    override var fieldDataProvider: (OkopfDto) -> Any
) : IFilterParams<OkopfDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}
