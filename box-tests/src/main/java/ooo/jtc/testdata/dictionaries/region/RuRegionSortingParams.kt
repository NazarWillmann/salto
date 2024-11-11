package ooo.jtc.testdata.dictionaries.region

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.region.RuRegionDto

enum class RuRegionSortingParams(
    override var field: String,
    override var fieldDataProvider: (RuRegionDto) -> Any?
) : ISortingParams<RuRegionDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    NAME("name", fieldDataProvider = { it.name }),
    ;

}