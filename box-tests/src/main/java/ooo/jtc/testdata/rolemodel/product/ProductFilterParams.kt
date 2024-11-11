package ooo.jtc.testdata.rolemodel.product

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.rolemodel.product.ProductDto

enum class ProductFilterParams(
    override var field: String,
    override var fieldDataProvider: (ProductDto) -> Any
) : IFilterParams<ProductDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    NAME("name", fieldDataProvider = { it.name }),
    UI_NAME("uiName", fieldDataProvider = { it.uiName }),
}