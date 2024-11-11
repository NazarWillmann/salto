package ooo.jtc.testdata.dictionaries.uer

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.uer.UerDto

enum class UerSortingParams(
    override var field: String,
    override var fieldDataProvider: (UerDto) -> Any?
) : ISortingParams<UerDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    UER("uer", fieldDataProvider = { it.uer }),
    BANK_TYPE("bankType", fieldDataProvider = { it.bankType }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}