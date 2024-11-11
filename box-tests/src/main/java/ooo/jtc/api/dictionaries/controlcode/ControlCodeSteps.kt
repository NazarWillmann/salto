package ooo.jtc.api.dictionaries.controlcode

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.controlcode.ControlCodeDto
import ooo.jtc.uaa.User

class ControlCodeSteps(user: User) :
    AbstractDictionarySteps<ControlCodeDto, ControlCodeDto>(
        user = user,
        entity = ControlCodeDto::class.java,
        dictionaryName = "controlCode"
    )