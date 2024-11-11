package ooo.jtc.testdata.dictionaries.timezone

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.timezone.TimezoneDto

enum class TimezoneFilterParams(
    override var field: String,
    override var fieldDataProvider: (TimezoneDto) -> Any
) : IFilterParams<TimezoneDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name })
    ;
}