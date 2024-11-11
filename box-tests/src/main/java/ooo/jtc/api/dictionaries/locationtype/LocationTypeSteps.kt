package ooo.jtc.api.dictionaries.locationtype

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.locationtype.LocationTypeDto
import ooo.jtc.uaa.User

class LocationTypeSteps(user: User) :
    AbstractDictionarySteps<LocationTypeDto, LocationTypeDto>(
        user = user,
        entity = LocationTypeDto::class.java,
        dictionaryName = "locationType"
    )