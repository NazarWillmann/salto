package ooo.jtc.api.dictionaries.lettertypefrombank

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class LetterTypeFromBankSteps(user: User) :
    AbstractDictionarySteps<LetterTypeFromBankDto, LetterTypeFromBankDto>(
        user = user,
        entity = LetterTypeFromBankDto::class.java,
        dictionaryName = "lettertypefrombank",
        service = Services.LETTER
    )
