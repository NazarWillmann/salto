package ooo.jtc.testdata.rolemodel.accessobjecttype

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeDto


enum class AccessObjectTypeFilterParams(
    override var field: String,
    override var fieldDataProvider: (AccessObjectTypeDto) -> Any
) : IFilterParams<AccessObjectTypeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name })
}