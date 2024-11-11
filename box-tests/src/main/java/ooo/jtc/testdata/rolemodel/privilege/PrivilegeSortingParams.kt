package ooo.jtc.testdata.rolemodel.privilege

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.rolemodel.privilege.PrivilegeDto

enum class PrivilegeSortingParams(
    override var field: String,
    override var fieldDataProvider: (PrivilegeDto) -> Any?
) : ISortingParams<PrivilegeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    UI_NAME("uiName", fieldDataProvider = { it.uiName }),
    ACCESS_OBJECT_ID("accessObjectId", fieldDataProvider = { it.accessObjectId })
}