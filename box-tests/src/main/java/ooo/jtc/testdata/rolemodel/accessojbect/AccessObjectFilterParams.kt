package ooo.jtc.testdata.rolemodel.accessojbect

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.rolemodel.accessobject.AccessObjectDto

enum class AccessObjectFilterParams(
    override var field: String,
    override var fieldDataProvider: (AccessObjectDto) -> Any
) : IFilterParams<AccessObjectDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    NAME("name", fieldDataProvider = { it.name }),
    UI_NAME("uiName", fieldDataProvider = { it.uiName }),
    PRODUCT_ID("productId", fieldDataProvider = { it.productId }),
    OBJECT_TYPE_ID("objectTypeId", fieldDataProvider = { it.objectTypeId })
}