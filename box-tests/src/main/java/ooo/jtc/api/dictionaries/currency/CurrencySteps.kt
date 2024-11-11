package ooo.jtc.api.dictionaries.currency

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.currency.CurrencyDto
import ooo.jtc.uaa.User

class CurrencySteps(user: User) :
    AbstractDictionarySteps<CurrencyDto, CurrencyDto>(
        user = user,
        entity = CurrencyDto::class.java,
        dictionaryName = "currency"
    )