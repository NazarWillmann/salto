package ooo.jtc.testdata.uaa.resource

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.uaa.resource.dto.ResourceDto

enum class ResourceFilterParams(
    override var field: String,
    override var fieldDataProvider: (ResourceDto) -> Any
) : IFilterParams<ResourceDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    VERSION("version", fieldDataProvider = { it.version }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    AUDIENCE("audience", fieldDataProvider = { it.audience })
    ;
}
