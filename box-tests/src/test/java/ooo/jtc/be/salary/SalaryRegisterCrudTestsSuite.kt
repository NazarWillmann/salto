package ooo.jtc.be.salary


import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_SALARY_REGISTER_CRUD
import ooo.jtc.api.salary.tests.ClientSalaryRegisterCreateTest
import ooo.jtc.api.salary.tests.ClientSalaryRegisterDeleteTest
import ooo.jtc.api.salary.tests.ClientSalaryRegisterGetPageTest
import ooo.jtc.api.salary.tests.ClientSalaryRegisterGetTest
import ooo.jtc.api.salary.tests.ClientSalaryRegisterUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStorySalaryRegister
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.SALARY_REGISTER)
@Story(TestStorySalaryRegister.SALARY_REGISTER_CRUD)
@DisplayName("API '${DocumentNames.SALARY_REGISTER}' CRUD suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_SALARY_REGISTER_CRUD
//todo khatmullin SalaryRegister doc will be changed
class SalaryRegisterCrudTestsSuite {


    private val clientUser = Users.client
    private val bankUser = Users.bankOperator


    internal fun salaryRegisterCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ClientSalaryRegisterCreateTest(clientUser),
                ClientSalaryRegisterGetTest(clientUser),
                ClientSalaryRegisterGetPageTest(clientUser),
                ClientSalaryRegisterUpdateTest(clientUser),
                ClientSalaryRegisterDeleteTest(clientUser)
            )
        )
    }
}