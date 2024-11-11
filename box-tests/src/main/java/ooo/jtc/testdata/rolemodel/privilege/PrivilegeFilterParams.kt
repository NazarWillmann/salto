package ooo.jtc.testdata.rolemodel.privilege

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.rolemodel.privilege.PrivilegeDto

enum class PrivilegeFilterParams(
    override var field: String,
    override var fieldDataProvider: (PrivilegeDto) -> Any
) : IFilterParams<PrivilegeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    NAME("name", fieldDataProvider = { it.name }),
    UI_NAME("uiName", fieldDataProvider = { it.uiName }),
    ACCESS_OBJECT_ID("accessObjectId", fieldDataProvider = { it.accessObjectId })
}