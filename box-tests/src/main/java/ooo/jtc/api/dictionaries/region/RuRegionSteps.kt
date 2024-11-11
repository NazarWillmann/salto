package ooo.jtc.api.dictionaries.region

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.region.RuRegionDto
import ooo.jtc.uaa.User

class RuRegionSteps(user: User) :
    AbstractDictionarySteps<RuRegionDto, RuRegionDto>(
        user = user,
        entity = RuRegionDto::class.java,
        dictionaryName = "region"
    )