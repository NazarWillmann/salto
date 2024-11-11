package ooo.jtc.testdata.dictionaries.kbk

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.kbk.KbkDto

enum class KbkFilterParams(
    override var field: String,
    override var fieldDataProvider: (KbkDto) -> Any
) : IFilterParams<KbkDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    ;

}