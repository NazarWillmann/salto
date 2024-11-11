package ooo.jtc.api.dictionaries.account

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.account.AccountDto
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.currency.DefaultCurrency
import ooo.jtc.extensions.ofUTC
import ooo.jtc.extensions.truncToSeconds
import ooo.jtc.generic.amount
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.nextBigDecimal
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.account.AccountKind
import ooo.jtc.testdata.dictionaries.account.AccountState
import ooo.jtc.testdata.dictionaries.account.BalanceAccount
import ooo.jtc.testdata.dictionaries.account.BalanceAccount.N_40702
import ooo.jtc.testdata.dictionaries.account.BalanceAccount.N_40703
import ooo.jtc.testdata.dictionaries.account.BalanceAccount.N_40802
import ooo.jtc.testdata.dictionaries.account.BalanceAccount.N_40807
import ooo.jtc.testdata.dictionaries.account.FindAccountBy
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeData
import ooo.jtc.testdata.dictionaries.accounttype.FindAccountTypeBy
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData.searchByCustomersIds
import ooo.jtc.testdata.dictionaries.currency.CurrencyData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*
import kotlin.random.Random

object AccountPrepareSteps {

    @Step("Удалить созданные автотестами данные Account из БД")
    fun cleanAtCreated() {
        FindAccountBy.AT_CREATED.get().forEach { acc ->
            AccountData.removeRecord?.let { it(acc) }
        }
    }

    fun getDefaultAccountDtoForCreate(user: User): AccountDto {
        //TODO A.Stykalin [23.06.2020] переделать, т.к. тут мы можем упасть на том, что у нас нет подходящих данных в BranchCustomerData
        val randomBranchCustomer = BranchCustomerData.searchBy(user).random()
        val currency = CurrencyData.randomOrException()
        val branch = BranchData.byId(randomBranchCustomer.branchId)
        val balanceAccount = BalanceAccount.values().random().value
        val generatedAcc = RandomRequisites.generateAccountNumber(balanceAccount, currency.digitCode, branch.paymentDetailsBic!!.bic)

        return getAccountDto(
            branchCustomerId = randomBranchCustomer.id!!,
            customerId = randomBranchCustomer.customerId,
            branchId = branch.id!!,
            currencyAlphaCode = currency.alphaCode,
            currencyDigitCode = currency.digitCode,
            accountNumber = generatedAcc
        )
    }

    /**
     * Create valid RuPayment-valid Account for user as [User] and customer
     */
    fun getRuPaymentValidAccountDto(
        user: User = Users.client,
        customerId: UUID = CustomerData.getOrCreate(user).id!!,
        branchCustomerId: UUID = searchByCustomersIds(customerId).ifEmpty {
            val branchCustomerDtoForCreate = getBranchCustomerDtoForCreate(BranchData.get().random().id!!, customerId)
            val create = BranchCustomerSteps().create(branchCustomerDtoForCreate).data!!
            listOf(create.toModel())
        }.random().id!!
    ): AccountDto {
        val currencyAccountType = FindAccountTypeBy.CURRENT.get().first()

        val branchCustomer = BranchCustomerData.find { it.id == branchCustomerId }
        val branchId = branchCustomer.branchId
        val currency = DefaultCurrency.RUR //CurrencyData.get().first { it.digitCode == DefaultCurrency.RUR.digitCode }
        val branch = BranchData.find { branchId == it.id!! }
        val balanceAccount = listOf(N_40702, N_40703, N_40802, N_40807).random().value
        val generatedAcc = RandomRequisites.generateAccountNumber(balanceAccount, currency.digitCode, branch.paymentDetailsBic!!.bic)

        return getAccountDto(
            branchCustomerId = branchCustomer.id!!,
            customerId = branchCustomer.customerId,
            branchId = branch.id!!,
            currencyAlphaCode = currency.alphaCode,
            currencyDigitCode = currency.digitCode,
            accountNumber = generatedAcc,

            accountTypeId = currencyAccountType.id!!,
            accountKind = AccountKind.PASSIVE,
            state = AccountState.OPEN,
            actualBalance = Random.nextBigDecimal(100000.0, 500000.0),
            isMarkInfoAccount = false,
            isBlock = false
        )
    }

    fun getAccountDto(
        branchCustomerId: UUID,
        customerId: UUID,
        branchId: UUID,
        currencyAlphaCode: String?,
        currencyDigitCode: String,
        accountTypeId: UUID = AccountTypeData.get(predicate = { it.clientType != "INDIVIDUAL" }).random().id!!,

        accountKind: String = listOf(AccountKind.ACTIVE, AccountKind.PASSIVE).random(),
        state: String = AccountState.OPEN,

        accountNumber: String,
        name: String = regexWord.random(20, 50) + AT_POSTFIX,

        actualBalance: BigDecimal = Random.nextBigDecimal(10000.0, 50000.0),
        planBalance: BigDecimal = Random.nextBigDecimal(1000.0, 5000.0),
        blockedAmount: BigDecimal? = null,
        cardAmount: BigDecimal? = null,

        actualDate: ZonedDateTime = ZonedDateTime.now().ofUTC().truncToSeconds(),
        openDate: ZonedDateTime = ZonedDateTime.now().ofUTC().truncToSeconds(),
        closeDate: ZonedDateTime? = null,

        isMarkInfoAccount: Boolean = false,
        isBlock: Boolean = false
    ): AccountDto {
        return AccountDto(
            id = null,
            version = 0,
            branchCustomerId = branchCustomerId,
            customerId = customerId,
            branchId = branchId,
            accountTypeId = accountTypeId,
            currencyAlphaCode = currencyAlphaCode,
            currencyDigitCode = currencyDigitCode,

            accountNumber = accountNumber,
            name = name,
            accountKind = accountKind,
            state = state,
            reserveBeginDate = null,
            reserveEndDate = null,
            openDate = openDate,
            closeDate = closeDate,
            isMarkInfo = isMarkInfoAccount,

            actualBalance = actualBalance,
            planBalance = planBalance,
            blockedAmount = blockedAmount,
            cardAmount = cardAmount,
            actualDate = actualDate,
            block = BlockingInfoDto(isBlock = isBlock),

            extIds = emptyList(),
            description = "desc$AT_POSTFIX",
            branchIndividualId = null,
            individualId = null,

            // can be null in creation
            accountType = null
        )
    }

    fun getMaxFilledAccountDtoForCreate(user: User): AccountDto {
        val dtoForCreate = getDefaultAccountDtoForCreate(user)
        dtoForCreate.closeDate = ZonedDateTime.now().plusDays(10).ofUTC().truncToSeconds()
        dtoForCreate.isMarkInfo = true
        dtoForCreate.planBalance = Random.nextBigDecimal(100.0, 150.0)
        dtoForCreate.blockedAmount = Random.nextBigDecimal(150.0, 200.0)
        dtoForCreate.cardAmount = Random.nextBigDecimal(200.0, 250.0)
        dtoForCreate.block.isBlock = true
        return dtoForCreate
    }

    fun getAccountDtoForUpdate(createdDto: AccountDto): AccountDto {
        return createdDto.copy(
            name = "updated ${createdDto.name}",
            actualBalance = amount(12345.6)
        )
    }

    @Step("Создать новый счёт")
    fun createNewAccount(dtoForCreate: AccountDto): AccountDto {
        val createResponse = AccountSteps(Users.superUser).create(dtoForCreate)
        return createResponse.data!!
    }

    @Step("(createRecord) Создать новый случайный 'Account', доступный пользователю '{user.login}'")
    fun createNewAccountForUser(user: User): Account {
        val prepAccountDto4Client = getMaxFilledAccountDtoForCreate(user)
        val createdDto = AccountSteps(Users.superUser).create(prepAccountDto4Client).data.getOrException()
        val fullCreatedDto = AccountSteps(Users.superUser).getById(createdDto.id!!).data.getOrException()
        return fullCreatedDto.toModel()
    }

    @Step("Удалить счёт, если к нему не привязано документов")
    fun deleteUnusedAccount(accId: UUID) {
        //TODO: "правильное" удаление - только если нет связанных документов
        AccountSteps(Users.superUser).delete(accId)
    }
}