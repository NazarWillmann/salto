package ooo.jtc.api.uaa.steps

import ooo.jtc.api.common.steps.AbstractUaaManagementSteps
import ooo.jtc.uaa.application.dto.ApplicationDto

class ApplicationSteps : AbstractUaaManagementSteps<ApplicationDto, ApplicationDto>(
    entity = ApplicationDto::class.java,
    managementName = "Application"
)