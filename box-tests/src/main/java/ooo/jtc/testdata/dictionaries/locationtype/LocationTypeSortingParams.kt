package ooo.jtc.testdata.dictionaries.locationtype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.locationtype.LocationTypeDto

enum class LocationTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (LocationTypeDto) -> Any?
) : ISortingParams<LocationTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    TYPE("locationType", fieldDataProvider = { it.locationType!! }),
    ;

}