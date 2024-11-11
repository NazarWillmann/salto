package ooo.jtc.testdata.rolemodel.role

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.rolemodel.role.RoleDto

enum class RoleSortingParams(
    override var field: String,
    override var fieldDataProvider: (RoleDto) -> Any?
) : ISortingParams<RoleDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    RESOURCE_ID("resourceId", fieldDataProvider = { it.resourceId }),
    ;
}