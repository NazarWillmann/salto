package ooo.jtc.testdata.rolemodel.privilegegroup

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto

enum class PrivilegeGroupFilterParams(
    override var field: String,
    override var fieldDataProvider: (PrivilegeGroupDto) -> Any
) : IFilterParams<PrivilegeGroupDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description ?: "" }),
    NAME("name", fieldDataProvider = { it.name }),
    ;
}