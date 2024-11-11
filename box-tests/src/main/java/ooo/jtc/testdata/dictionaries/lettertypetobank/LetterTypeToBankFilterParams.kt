package ooo.jtc.testdata.dictionaries.lettertypetobank

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankDto

enum class LetterTypeToBankFilterParams(
    override var field: String,
    override var fieldDataProvider: (LetterTypeToBankDto) -> Any
) : IFilterParams<LetterTypeToBankDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    DESCRIPTION("description", fieldDataProvider = { it.description })
    ;
}