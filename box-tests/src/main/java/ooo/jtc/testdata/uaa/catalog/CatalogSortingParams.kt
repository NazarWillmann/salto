package ooo.jtc.testdata.uaa.catalog

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.uaa.catalog.dto.CatalogDto

enum class CatalogSortingParams(
    override var field: String,
    override var fieldDataProvider: (CatalogDto) -> Any?
) : ISortingParams<CatalogDto> {

    ID("id", fieldDataProvider = { it.id!! }),
    CATALOG_TYPE("catalogType", fieldDataProvider = { it.catalogType }),
    CATALOG_KIND("catalogKind", fieldDataProvider = { it.catalogKind }),
    NAME("name", fieldDataProvider = { it.name }),
    TITLE("title", fieldDataProvider = { it.title }),
    APPEARANCE("appearance", fieldDataProvider = { it.appearance }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    ENABLED("enabled", fieldDataProvider = { it.enabled }),
    ;

}