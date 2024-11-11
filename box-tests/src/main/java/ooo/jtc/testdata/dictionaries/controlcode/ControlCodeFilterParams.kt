package ooo.jtc.testdata.dictionaries.controlcode

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.controlcode.ControlCodeDto

enum class ControlCodeFilterParams(
    override var field: String,
    override var fieldDataProvider: (ControlCodeDto) -> Any
) : IFilterParams<ControlCodeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;

}