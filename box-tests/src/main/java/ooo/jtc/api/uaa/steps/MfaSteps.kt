package ooo.jtc.api.uaa.steps

import ooo.jtc.api.common.steps.AbstractUaaManagementSteps
import ooo.jtc.uaa.mfa.dto.MfaDto

class MfaSteps : AbstractUaaManagementSteps<MfaDto, MfaDto>(
    entity = MfaDto::class.java,
    managementName = "Mfa"
)