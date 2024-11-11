package ooo.jtc.testdata.rolemodel.accessojbect

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.rolemodel.accessobject.AccessObjectDto

enum class AccessObjectSortingParams(
    override var field: String,
    override var fieldDataProvider: (AccessObjectDto) -> Any?
) : ISortingParams<AccessObjectDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    NAME("name", fieldDataProvider = { it.name }),
    UI_NAME("uiName", fieldDataProvider = { it.uiName }),
    PRODUCT_ID("productId", fieldDataProvider = { it.productId }),
    OBJECT_TYPE_ID("objectTypeId", fieldDataProvider = { it.objectTypeId })
}