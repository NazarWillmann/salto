package ooo.jtc.testdata.dictionaries.locationtype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.locationtype.LocationTypeDto

enum class LocationTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (LocationTypeDto) -> Any
) : IFilterParams<LocationTypeDto>{
    ID("id", fieldDataProvider = { it.id!! }),
    TYPE("locationType", fieldDataProvider = { it.locationType!! }),
    ;

}