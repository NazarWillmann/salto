package ooo.jtc.testdata.uaa.scope

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.uaa.scope.dto.ScopeDto

enum class ScopeSortingParams(
    override var field: String,
    override var fieldDataProvider: (ScopeDto) -> Any?
) : ISortingParams<ScopeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    NAME("name", fieldDataProvider = { it.name }),
    AUDIENCE("needApprove", fieldDataProvider = { it.needApprove }),
    RESOURCE_ID("resourceId", fieldDataProvider = { it.resourceId }),
    ;

}