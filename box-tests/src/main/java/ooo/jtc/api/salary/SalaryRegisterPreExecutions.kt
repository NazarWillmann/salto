package ooo.jtc.api.salary

import ooo.jtc.api.salary.steps.SalaryRegisterPrepareSteps
import ooo.jtc.api.salary.steps.SalaryRegisterSteps
import ooo.jtc.extensions.getOrException
import ooo.jtc.salary.dto.SalaryRegisterDto
import ooo.jtc.uaa.User

object SalaryRegisterPreExecutions {
    fun createSalaryRegisterDto(
        ClientUser: User,
        dtoForCreate: SalaryRegisterDto = SalaryRegisterPrepareSteps.getSalaryRegisterDtoForCreate(
            clientUser = ClientUser
        )
    ): SalaryRegisterDto {
        return SalaryRegisterSteps(ClientUser).create(dtoForCreate).data.getOrException()
    }
}