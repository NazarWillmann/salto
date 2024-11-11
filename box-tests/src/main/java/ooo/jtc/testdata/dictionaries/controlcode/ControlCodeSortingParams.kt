package ooo.jtc.testdata.dictionaries.controlcode

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.controlcode.ControlCodeDto

enum class ControlCodeSortingParams(
    override var field: String,
    override var fieldDataProvider: (ControlCodeDto) -> Any?
) : ISortingParams<ControlCodeDto> {
    ID("id", fieldDataProvider = { it.id }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}