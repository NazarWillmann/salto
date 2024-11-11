package ooo.jtc.api.salary.steps

import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.salary.dto.SalaryRegisterDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

class SalaryRegisterSteps(clientUser: User = Users.client) :
    AbstractDocumentSteps<SalaryRegisterDto, SalaryRegisterDto>(
        user = clientUser,
        service = Services.SALARY,
        document = SalaryRegisterDto::class.java
    ) {
    override val servicePath by lazy { service.baseEndpoint + "/salaryregister/" + user.userType.pathPrefix }
}