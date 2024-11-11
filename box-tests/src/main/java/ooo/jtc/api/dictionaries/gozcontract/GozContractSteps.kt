package ooo.jtc.api.dictionaries.gozcontract

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.gozcontract.GozContractDto
import ooo.jtc.uaa.User

class GozContractSteps(user: User) :
    AbstractDictionarySteps<GozContractDto, GozContractDto>(
        user = user,
        entity = GozContractDto::class.java,
        dictionaryName = "gozcontract"
    )