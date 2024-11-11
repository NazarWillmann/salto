package ooo.jtc.testdata.dictionaries.timezone

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.timezone.TimezoneDto

enum class TimezoneSortingParams(
    override var field: String,
    override var fieldDataProvider: (TimezoneDto) -> Any?
) : ISortingParams<TimezoneDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name })
    ;
}