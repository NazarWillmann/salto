package ooo.jtc.api.dictionaries.individual

import ooo.jtc.api.common.steps.AbstractDictionarySteps

import ooo.jtc.dictionaries.individual.IndividualDto
import ooo.jtc.uaa.User

class IndividualSteps(user: User) :
    AbstractDictionarySteps<IndividualDto, IndividualDto>(
        user = user,
        entity = IndividualDto::class.java,
        dictionaryName = "individual"
    )