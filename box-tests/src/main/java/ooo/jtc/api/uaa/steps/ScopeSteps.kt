package ooo.jtc.api.uaa.steps

import ooo.jtc.api.common.steps.AbstractUaaManagementSteps
import ooo.jtc.uaa.scope.dto.ScopeDto
import ooo.jtc.uaa.scope.dto.ScopeUpdateRequest

class ScopeSteps : AbstractUaaManagementSteps<ScopeDto, ScopeUpdateRequest>(
    entity = ScopeDto::class.java,
    managementName = "Scope"
)