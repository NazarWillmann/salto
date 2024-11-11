package ooo.jtc.api.uaa.steps

import ooo.jtc.api.common.steps.AbstractUaaManagementSteps
import ooo.jtc.uaa.resource.dto.ResourceDto

class ResourceSteps : AbstractUaaManagementSteps<ResourceDto, ResourceDto>(
    entity = ResourceDto::class.java,
    managementName = "Resource"
)