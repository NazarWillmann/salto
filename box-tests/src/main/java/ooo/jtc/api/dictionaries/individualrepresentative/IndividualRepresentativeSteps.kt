package ooo.jtc.api.dictionaries.individualrepresentative

import ooo.jtc.api.common.steps.AbstractBlockableDictionarySteps
import ooo.jtc.dictionaries.individualrepresentative.IndividualRepresentativeDto
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.uaa.User

class IndividualRepresentativeSteps(user: User = superUser) :
    AbstractBlockableDictionarySteps<IndividualRepresentativeDto, IndividualRepresentativeDto>(
        user = user,
        entity = IndividualRepresentativeDto::class.java,
        dictionaryName = "individualRepresentative"
    )
