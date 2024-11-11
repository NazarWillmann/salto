package ooo.jtc.testdata.dictionaries.kbk

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.kbk.KbkDto

enum class KbkSortingParams(
    override var field: String,
    override var fieldDataProvider: (KbkDto) -> Any?
) : ISortingParams<KbkDto> {
    ID("id", fieldDataProvider = { it.id }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}