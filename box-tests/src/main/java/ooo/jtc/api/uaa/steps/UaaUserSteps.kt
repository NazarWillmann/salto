package ooo.jtc.api.uaa.steps

import ooo.jtc.api.common.steps.AbstractUaaManagementSteps
import ooo.jtc.uaa.user.dto.UaaUserDto

class UaaUserSteps : AbstractUaaManagementSteps<UaaUserDto, UaaUserDto>(
    entity = UaaUserDto::class.java,
    managementName = "User"
)