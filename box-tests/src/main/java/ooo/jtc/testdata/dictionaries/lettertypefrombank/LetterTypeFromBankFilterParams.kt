package ooo.jtc.testdata.dictionaries.lettertypefrombank

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankDto

enum class LetterTypeFromBankFilterParams(
    override var field: String,
    override var fieldDataProvider: (LetterTypeFromBankDto) -> Any
) : IFilterParams<LetterTypeFromBankDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description })
    ;
}