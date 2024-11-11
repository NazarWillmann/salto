package ooo.jtc.api.dictionaries.okfs

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.okfs.OkfsDto
import ooo.jtc.uaa.User

class OkfsSteps(user: User) :
    AbstractDictionarySteps<OkfsDto, OkfsDto>(
        user = user,
        entity = OkfsDto::class.java,
        dictionaryName = "okfs"
    )