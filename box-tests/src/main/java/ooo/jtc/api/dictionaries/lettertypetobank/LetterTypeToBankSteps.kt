package ooo.jtc.api.dictionaries.lettertypetobank

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class LetterTypeToBankSteps(user: User) :
    AbstractDictionarySteps<LetterTypeToBankDto, LetterTypeToBankDto>(
        user = user,
        entity = LetterTypeToBankDto::class.java,
        dictionaryName = "lettertypetobank",
        service = Services.LETTER
    )
