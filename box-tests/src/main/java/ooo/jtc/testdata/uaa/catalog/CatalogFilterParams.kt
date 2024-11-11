package ooo.jtc.testdata.uaa.catalog

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.uaa.catalog.dto.CatalogDto

enum class CatalogFilterParams(
    override var field: String,
    override var fieldDataProvider: (CatalogDto) -> Any
) : IFilterParams<CatalogDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    CATALOG_TYPE("catalogType", fieldDataProvider = { it.catalogType }),
    CATALOG_KIND("catalogKind", fieldDataProvider = { it.catalogKind }),
    NAME("name", fieldDataProvider = { it.name }),
    TITLE("title", fieldDataProvider = { it.title ?: "" }),
    APPEARANCE("appearance", fieldDataProvider = { it.appearance ?: "" }),
    DESCRIPTION("description", fieldDataProvider = { it.description ?: "" }),
    ENABLED("enabled", fieldDataProvider = { it.enabled }),
    ;
}