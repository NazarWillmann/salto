package ooo.jtc.api.salary.tests

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteDocumentTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.salary.SalaryRegisterPreExecutions
import ooo.jtc.api.salary.steps.SalaryRegisterPrepareSteps
import ooo.jtc.api.salary.steps.SalaryRegisterSteps
import ooo.jtc.dictionaries.salaryemployee.SalaryRegisterStatus
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.salary.dto.SalaryRegisterDto
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

class ClientSalaryRegisterCreateTest(
    clientUser: User = Users.client,
    dtoForCreation: () -> SalaryRegisterDto = { SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = clientUser) }
) : CreateTestTemplate<SalaryRegisterDto>(
    steps = SalaryRegisterSteps(clientUser),
    preExecution = dtoForCreation,
    expValidationResult = ControlCheckResult.NOT_CHECKED
)

class ClientSalaryRegisterDeleteTest(
    user: User = Users.client,
    preExecutionDto: () -> SalaryRegisterDto = { SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = user) }
) : DeleteDocumentTestTemplate<SalaryRegisterDto>(
    steps = SalaryRegisterSteps(user),
    preExecution = { SalaryRegisterPreExecutions.createSalaryRegisterDto(user, preExecutionDto.invoke()) },
    deletedStatus = SalaryRegisterStatus.DELETED.getUserStatus(user.userType)
)

class ClientSalaryRegisterUpdateTest(
    user: User = Users.client,
    dtoForCreation: () -> SalaryRegisterDto = { SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = user) },
    dtoForUpdate: (SalaryRegisterDto) -> SalaryRegisterDto = { createdDto ->
        SalaryRegisterPrepareSteps.getSalaryRegisterDtoForUpdate(createdDto)
    },
    preCheckingHandling: (SalaryRegisterDto) -> SalaryRegisterDto = { it },
) : UpdateTestTemplate<SalaryRegisterDto, SalaryRegisterDto>(
    steps = SalaryRegisterSteps(user),
    preExecution = {
        val createdCurTransferClient = SalaryRegisterPreExecutions.createSalaryRegisterDto(user, dtoForCreation.invoke())
        dtoForUpdate.invoke(createdCurTransferClient)
    },
    preCheckingHandling = preCheckingHandling
)

class ClientSalaryRegisterGetTest(
    user: User = Users.client
) : GetTestTemplate<SalaryRegisterDto>(
    steps = SalaryRegisterSteps(user),
    preExecution = { SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = user) }
)

class ClientSalaryRegisterGetPageTest(
    user: User = Users.client,
    private val ltbSteps: SalaryRegisterSteps = SalaryRegisterSteps(user)
) : GetPageTestTemplate<SalaryRegisterDto>(
    steps = ltbSteps,
    preExecution = {
        listOf(
            SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = user),
            SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = user),
            SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(clientUser = user),
        )
    },
    postExecution = { list -> list.forEach { it.soft { ltbSteps.delete(it.id!!) } } }
)
