package ooo.jtc.api.salary.steps

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps
import ooo.jtc.core.kexensions.getClientRepresentativePhone
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.dictionaries.currency.DefaultCurrency
import ooo.jtc.extensions.LOCALE_RU
import ooo.jtc.generic.DocumentNames
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.nextBigDecimal
import ooo.jtc.salary.dto.SalaryRegisterDto
import ooo.jtc.salary.dto.SalaryRegisterPayrollDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*
import kotlin.random.Random

object SalaryRegisterPrepareSteps {

    @Step("Подготовить объект для создания '${DocumentNames.SALARY_REGISTER}'")
    fun getSalaryRegisterDtoForCreate(
        clientUser: User = Users.client,
        bankUser: User = Users.bankOperator
    ): SalaryRegisterDto {
        val availableBranchCustomerId =
            (BranchCustomerData.getCommonBranchCustomersIds(clientUser, bankUser)?.randomOrNull())
                ?: BranchCustomerData.getOrCreateCommonBranchCustomer(clientUser = clientUser, bankUser = bankUser).id!!
        val availableBranchCustomer = BranchCustomerData.byId(availableBranchCustomerId)
        val account = AccountData.getOrCreate(
            consumer = { AccountData.get(false) { it.branchCustomerId == availableBranchCustomerId } },
            provider = {
                AccountPrepareSteps.createNewAccount(
                    AccountPrepareSteps.getRuPaymentValidAccountDto(
                        user = clientUser,
                        customerId = availableBranchCustomer.customerId,
                        branchCustomerId = availableBranchCustomerId
                    )
                ).toModel()
            }
        )
        return getSalaryRegisterDtoForCreate(
            customerId = availableBranchCustomer.customerId,
            branchId = availableBranchCustomer.branchId,
            accountDebet = account.accountNumber,
            accountId = account.id!!,
            official = clientUser.getFio(),
            officialPhone = clientUser.getClientRepresentativePhone(availableBranchCustomerId).toString(),
            userId = clientUser.uaaUserId!!
        )
    }

    private fun getSalaryRegisterDtoForCreate(
        customerId: UUID,
        branchId: UUID,
        accountDebet: String,
        accountId: UUID,
        official: String,
        officialPhone: String,
        userId: UUID
    ): SalaryRegisterDto {
        val customer = CustomerData.byId(customerId)
        val branch = BranchData.byId(branchId)
        val periodMonth = LocalDate.now().month.getDisplayName(TextStyle.FULL, LOCALE_RU)
        val periodYear = LocalDate.now().year.toString()
        val amount = Random.nextBigDecimal(100.0, 900.0).toString()
        val currencyCodeDigits = DefaultCurrency.RUB.digitCode

        val payroll = SalaryRegisterPayrollDto(
            id = null,
            lastName = RandomData("[а-яА-Я ]*").random(7, 10),
            amount = Random.nextBigDecimal(100.0, 900.0).toString(),
            account = null,
            firstName = null,
            middleName = null,
            inn = null,
            bic = null,
            corrAccount = null,
            bankName = null,
            bankAddress = null,
            checkResult = "correct",
            comment = null,
            salaryRegisterId = null,
            employeeId = null
        )
        return SalaryRegisterDto(
            id = null,
            version = 0,
            documentNumber = digits.random(6, 6),
            documentDate = LocalDate.now(),
            status = null,
            customerId = customerId,
            customerName = customer.shortName,
            branchId = branchId,
            branchName = branch.shortName,
            userId = userId,
            customerInn = customer.inn,
            customerOkpo = customer.okpo,
            accountDebet = accountDebet,
            accountId = accountId,
            official = official,
            officialPhone = officialPhone,
            periodMonth = periodMonth,
            periodYear = periodYear,
            amount = amount,
            currencyCode = currencyCodeDigits,
            payDocumentNumber = null,
            payDocumentDate = null,
            payDocumentGround = null,
            paymentId = null,
            payrolls = listOf(payroll),
            createdAt = null,
            schemeVersion = null,
            receiveDate = null,
            executionDate = null,
            executionMessage = null,
            modifiedAt = null,
            isFavorites = false
        )
    }

    fun getSalaryRegisterDtoForUpdate(docDto: SalaryRegisterDto): SalaryRegisterDto {
        return docDto.copy(
            amount = "UPDATED ${docDto.amount}"
        )
    }

}


