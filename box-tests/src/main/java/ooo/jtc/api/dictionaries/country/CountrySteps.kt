package ooo.jtc.api.dictionaries.country

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.country.CountryDto
import ooo.jtc.uaa.User

class CountrySteps(user: User) :
    AbstractDictionarySteps<CountryDto, CountryDto>(
        user = user,
        entity = CountryDto::class.java,
        dictionaryName = "country"
    )