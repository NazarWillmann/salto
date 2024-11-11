package ooo.jtc.testdata.uaa.resource

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.uaa.resource.dto.ResourceDto

enum class ResourceSortingParams(
    override var field: String,
    override var fieldDataProvider: (ResourceDto) -> Any?
) : ISortingParams<ResourceDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    AUDIENCE("audience", fieldDataProvider = { it.audience })
    ;
}
