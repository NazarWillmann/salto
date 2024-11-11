package ooo.jtc.api.dictionaries.activitytype

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.activitytype.ActivityTypeDto
import ooo.jtc.uaa.User

class ActivityTypeSteps(user: User) :
    AbstractDictionarySteps<ActivityTypeDto, ActivityTypeDto>(
        user = user,
        entity = ActivityTypeDto::class.java,
        dictionaryName = "activitytype"
    )