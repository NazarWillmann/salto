package ooo.jtc.testdata.dictionaries.activitytype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.activitytype.ActivityTypeDto

enum class ActivityTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (ActivityTypeDto) -> Any?
) : ISortingParams<ActivityTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ;
}