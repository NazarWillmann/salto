package ooo.jtc.testdata.rolemodel.privilegegroup

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto

enum class PrivilegeGroupSortingParams(
    override var field: String,
    override var fieldDataProvider: (PrivilegeGroupDto) -> Any?
) : ISortingParams<PrivilegeGroupDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    ;
}