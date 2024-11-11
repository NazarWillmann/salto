package ooo.jtc.testdata.dictionaries.region

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.region.RuRegionDto

enum class RuRegionFilterParams(
    override var field: String,
    override var fieldDataProvider: (RuRegionDto) -> Any
) : IFilterParams<RuRegionDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    NAME("name", fieldDataProvider = { it.name }),
    ;

}
