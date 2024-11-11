package ooo.jtc.testdata.uaa.scope

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.uaa.scope.dto.ScopeDto

enum class ScopeFilterParams(
    override var field: String,
    override var fieldDataProvider: (ScopeDto) -> Any
) : IFilterParams<ScopeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    VERSION("version", fieldDataProvider = { it.version }),
    DESCRIPTION("description", fieldDataProvider = { it.description ?: "" }),
    NAME("name", fieldDataProvider = { it.name }),
    NEED_APPROVE("needApprove", fieldDataProvider = { it.needApprove }),
    RESOURCE_ID("resourceId", fieldDataProvider = { it.resourceId }),
    ;
}