package ooo.jtc.testdata.dictionaries.lettertypefrombank

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankDto

enum class LetterTypeFromBankSortingParams(
    override var field: String,
    override var fieldDataProvider: (LetterTypeFromBankDto) -> Any?
) : ISortingParams<LetterTypeFromBankDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description })
    ;
}