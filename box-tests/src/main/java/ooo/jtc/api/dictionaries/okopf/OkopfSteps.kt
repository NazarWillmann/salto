package ooo.jtc.api.dictionaries.okopf

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.okopf.OkopfDto
import ooo.jtc.uaa.User

class OkopfSteps(user: User) :
    AbstractDictionarySteps<OkopfDto, OkopfDto>(
        user = user,
        entity = OkopfDto::class.java,
        dictionaryName = "okopf"
    )