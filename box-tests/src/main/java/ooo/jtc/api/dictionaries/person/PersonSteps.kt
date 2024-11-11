package ooo.jtc.api.dictionaries.person

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.person.PersonDto
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

class PersonSteps(user: User = Users.superUser) :
    AbstractDictionarySteps<PersonDto, PersonDto>(
        user = user,
        entity = PersonDto::class.java,
        dictionaryName = "person"
    )
