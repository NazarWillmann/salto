package ooo.jtc.testdata.dictionaries.lettertypetobank

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankDto

enum class LetterTypeToBankSortingParams(
    override var field: String,
    override var fieldDataProvider: (LetterTypeToBankDto) -> Any?
) : ISortingParams<LetterTypeToBankDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description })
    ;
}