package ooo.jtc.testdata.rolemodel.accessobjecttype

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeDto

enum class AccessObjectTypeSortingParams(
    override var field: String,
    override var fieldDataProvider: (AccessObjectTypeDto) -> Any?
) : ISortingParams<AccessObjectTypeDto>{
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name }),
}