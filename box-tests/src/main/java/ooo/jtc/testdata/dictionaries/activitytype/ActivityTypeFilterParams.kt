package ooo.jtc.testdata.dictionaries.activitytype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.activitytype.ActivityTypeDto

enum class ActivityTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (ActivityTypeDto) -> Any
) : IFilterParams<ActivityTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;

}