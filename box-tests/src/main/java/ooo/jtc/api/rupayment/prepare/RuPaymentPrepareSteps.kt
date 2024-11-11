package ooo.jtc.api.rupayment.prepare

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.filter.IFilterParams.Companion.or
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps.getContractorDtoForCreate
import ooo.jtc.api.dictionaries.contactor.ContractorSteps
import ooo.jtc.api.rupayment.RuPaymentSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.transferterm.TransferTerm
import ooo.jtc.documents.IDocumentStatus.Companion.NOT_AVAILABLE
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.amount
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Paging
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.random.nextBigDecimal
import ooo.jtc.rupayment.dto.BudgetDto
import ooo.jtc.rupayment.dto.PayerDto
import ooo.jtc.rupayment.dto.PaymentGroundDto
import ooo.jtc.rupayment.dto.ReceiverDto
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.rupayment.dto.RuPaymentPreFilledForUserPaymentType
import ooo.jtc.rupayment.model.BudgetType
import ooo.jtc.rupayment.model.RuPaymentStatus
import ooo.jtc.rupayment.model.UserPaymentType
import ooo.jtc.rupayment.model.UserPaymentType.BUDGET
import ooo.jtc.rupayment.model.UserPaymentType.BUSINESS
import ooo.jtc.rupayment.model.UserPaymentType.CUSTOM
import ooo.jtc.rupayment.model.UserPaymentType.OTHER
import ooo.jtc.rupayment.model.UserPaymentType.OWNACCOUNTS
import ooo.jtc.rupayment.model.UserPaymentType.PERSON
import ooo.jtc.rupayment.model.UserPaymentType.TAX
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.account.BalanceAccount
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermData
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams.STATUS
import ooo.jtc.uaa.User
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.random.Random

object RuPaymentPrepareSteps {
    /**
     * Collects used in tests ruPayment ids.
     */
    private val usedRuPaymentIds = CopyOnWriteArrayList<UUID>()

    @Step("\"Удалить\" платёжки, созданные автотестами (пользователь '{user.login}')")
    fun cleanAtCreated(user: User = Users.client) {
        if (!user.isClient) throw RuntimeException("Only client user can delete RuPayments")

        val steps = RuPaymentSteps(user)
        val limit = 10
        val getPageRequestWithFilter = GetPageRequest(Params(filter = Filter(or(
            { STATUS.eq("New") }, { STATUS.eq("Draft") }
        ))))

        var offset = 0
        var paging: Paging
        var getPageResponse: GenericPageResponseDto<RuPaymentDto>
        var rpListToDelete: List<RuPaymentDto>
        do {
            paging = Paging(offset, limit)
            getPageRequestWithFilter.params.paging = paging
            getPageResponse = steps.getPage(getPageRequestWithFilter)
            rpListToDelete = getPageResponse.page!!
                .filter { it.paymentGround?.description?.endsWith(AT_POSTFIX) ?: false }
            rpListToDelete.forEach { steps.delete(it.id!!) }
            offset += (limit - rpListToDelete.size)
        } while (offset < getPageResponse.size ?: offset)
    }

    @Step("Найти или создать '${DocumentNames.RU_PAYMENT}'")
    fun getOrCreateRuPaymentDto(
        user: User = client,
        searchParams: Params = Params(),
        createFunction: () -> RuPaymentDto = { createRuPaymentDto(user) }
    ): RuPaymentDto {
        val pageResponseDto = RuPaymentSteps(user).getPage(GetPageRequest(searchParams))
        val foundDto = pageResponseDto.page?.filter { it.id!! !in usedRuPaymentIds }?.ifNotEmpty { it.random() }
        val ruPaymentDto = foundDto ?: createFunction.invoke()
        usedRuPaymentIds.add(ruPaymentDto.id)
        return ruPaymentDto.attachToAllure()
    }

    fun getRuPaymentDto(
        user: User,
        userPaymentType: UserPaymentType
    ): RuPaymentDto {
        return when (userPaymentType) {
            BUDGET -> getBudgetRuPaymentDto(user, BudgetType.OTHER)
            CUSTOM -> getBudgetRuPaymentDto(user, BudgetType.CUSTOM)
            TAX -> getBudgetRuPaymentDto(user, BudgetType.TAX)
            BUSINESS -> getNonBudgetRuPaymentDto(user, BalanceAccount.N_40702, BUSINESS, true)
            PERSON -> getNonBudgetRuPaymentDto(user, BalanceAccount.N_40802, PERSON, false)
            OWNACCOUNTS -> getOwnAccountsRuPaymentDto(user)
            OTHER -> throw RuntimeException("User 'getOtherRuPaymentDto' method for create userPaymentType=OTHER payment")
        }
    }

    @Step("Проверить наличие в системе записей ${DocumentNames.RU_PAYMENT} в одном из статусов")
    fun hasRuPaymentsInStatuses(vararg statuses: RuPaymentStatus): Boolean {
        val st = statuses.map { if (it.statusBank == NOT_AVAILABLE) it.statusClient else it.statusBank }.joinToString(separator = ",") { "'$it'" }
        val sql = "SELECT id from RUPAYMENT where status in ($st)"
        return Services.RKO_RU_PAYMENT.db.execSql(sql).isNotEmpty()
    }

    @Step("Создать ${DocumentNames.RU_PAYMENT}")
    fun createRuPaymentDto(
        clientUser: User,
        dtoForCreate: RuPaymentDto = RuPaymentTemplates.getBusinessRuPayment(clientUser)
    ): RuPaymentDto {
        clientUser.checkIsClientUser("Only client users can create RuPayment docs.")
        return RuPaymentSteps(clientUser).create(dtoForCreate).data.getOrException()
    }

    @Step("Создать, подписать и отправить в банк ${DocumentNames.RU_PAYMENT}")
    fun createSentRuPaymentDto(
        clientUser: User,
        dtoForCreate: RuPaymentDto = RuPaymentTemplates.getBusinessRuPayment(clientUser)
    ): RuPaymentDto {
        clientUser.checkIsClientUser("Only client users can create RuPayment docs.")
        val steps = RuPaymentSteps(clientUser)
        val createdDto = steps.create(dtoForCreate).data.getOrException()
        steps.signDocumentBySms(createdDto)
        steps.send(createdDto.id!!)
        return steps.getById(createdDto.id!!).data.getOrException()
    }

    @Step("Удалить '${DocumentNames.RU_PAYMENT}'")
    fun deleteRuPayment(ruPaymentId: UUID, user: User = client) {
        RuPaymentSteps(user).delete(ruPaymentId)
    }

    @Step("Подготовить объект для проверки предзаполнения ({userPaymentType})")
    fun preparePreFilled(userPaymentType: UserPaymentType): RuPaymentPreFilledForUserPaymentType {
        return when (userPaymentType) {
            BUSINESS -> RuPaymentPreFilledForUserPaymentType(
                BUSINESS,
                "5",
                PaymentGroundDto(ndsCalculation = 1, ndsPercent = "20", nds = BigDecimal(0))
            )
            PERSON -> RuPaymentPreFilledForUserPaymentType(PERSON, "3", PaymentGroundDto(ndsCalculation = 1, ndsPercent = "20", nds = BigDecimal(0)))
            BUDGET -> RuPaymentPreFilledForUserPaymentType(
                BUDGET, "5", PaymentGroundDto(ndsCalculation = 5),
                BudgetDto(BudgetType.OTHER, payerStatus = "08", reasonCode = "0", budgetField107 = "0", reasonDocumentDate = "0")
            )
            CUSTOM -> RuPaymentPreFilledForUserPaymentType(CUSTOM, "5", PaymentGroundDto(ndsCalculation = 5), BudgetDto(BudgetType.CUSTOM))
            TAX -> RuPaymentPreFilledForUserPaymentType(TAX, "5", PaymentGroundDto(ndsCalculation = 5), BudgetDto(BudgetType.TAX))
            OWNACCOUNTS -> RuPaymentPreFilledForUserPaymentType(OWNACCOUNTS, "5", PaymentGroundDto(ndsCalculation = 3))
            OTHER -> RuPaymentPreFilledForUserPaymentType(OTHER, "5", PaymentGroundDto(ndsCalculation = 1))
        }.attachToAllure()
    }

    private fun getRuPaymentDto(
        documentNumber: String = RandomData("[1-9]{1}[0-9]{5}").random(),
        documentDate: LocalDate = LocalDate.now(),
        amount: BigDecimal? = null,
        payer: PayerDto,
        receiver: ReceiverDto,
        paymentGround: PaymentGroundDto = PaymentGrounds.NO_NDS_PAYMENT_GROUND.getDto(
            payerAccNum = payer.account!!,
            receiverAccNum = receiver.account!!
        ),
        budget: BudgetDto = BudgetDto(),
        budgetType: BudgetType? = null,
        operationType: String = "01",
        priority: String = "5",
        uinUip: String = "0",
        userPaymentType: UserPaymentType = OTHER,
        incomeTypeCode: Int? = if (userPaymentType == PERSON) 3 else null,
        amountRecovery: BigDecimal? = BigDecimal(1.0),
        transferTerm: TransferTerm? = null
    ): RuPaymentDto {
        val branchByAccNumber = BranchData.searchBy(payer.account!!)
        val customerByAccNumber = CustomerData.searchBy(payer.account!!)
        val payerAccount = AccountData.searchBy(payer.account!!)
        val accountAmount: BigDecimal = amount ?: Random.nextBigDecimal(max = payerAccount.actualBalance)

        return RuPaymentDto(
            documentNumber = documentNumber,
            documentDate = documentDate,
            amount = accountAmount,
            payer = payer,
            receiver = receiver,
            paymentGround = paymentGround,
            budget = budget,
            branchId = branchByAccNumber.id!!,
            customerId = customerByAccNumber.id!!,
            operationType = operationType,
            priority = priority,
            uinUip = uinUip,
            userPaymentType = userPaymentType,
            status = null,
            channel = null,
            createdAt = null,
            budgetType = budgetType,
            incomeTypeCode = incomeTypeCode,
            amountRecovery = amountRecovery,
            transferTermCode = transferTerm?.code,
            transferTermDescription = transferTerm?.description
        )
    }

    internal fun getRuPaymentDto(
        documentNumber: String = RandomData("[1-9]{1}[0-9]{5}").random(),
        documentDate: LocalDate = LocalDate.now(),
        amount: BigDecimal? = null,
        payerAccount: Account,
        receiverAccount: Account,
        paymentGround: PaymentGroundDto = PaymentGrounds.NO_NDS_PAYMENT_GROUND.getDto(
            payerAccNum = payerAccount.accountNumber,
            receiverAccNum = receiverAccount.accountNumber
        ),
        budget: BudgetDto = BudgetDto(),
        operationType: String = "01",
        priority: String = "5",
        uinUip: String = "0",
        userPaymentType: UserPaymentType = OTHER,
        incomeTypeCode: Int? = if (userPaymentType == PERSON) 3 else null,
        amountRecovery: BigDecimal? = BigDecimal(1.0),
        transferTerm: TransferTerm? = null
    ): RuPaymentDto {
        val payerByAccount = ParticipantsPrepareSteps.getPayerDto(payerAccount)
        val payerBranchByAccount = BranchData.searchBy(payerAccount)
        val payerCustomerByAccount = CustomerData.searchBy(payerAccount)
        val receiverByAccount = ParticipantsPrepareSteps.getReceiverDto(receiverAccount)
        val accountAmount = amount ?: Random.nextBigDecimal(max = payerAccount.actualBalance)

        return RuPaymentDto(
            documentNumber = documentNumber,
            documentDate = documentDate,
            amount = accountAmount,
            payer = payerByAccount,
            receiver = receiverByAccount,
            paymentGround = paymentGround,
            budget = budget,
            branchId = payerBranchByAccount.id!!,
            customerId = payerCustomerByAccount.id!!,
            operationType = operationType,
            priority = priority,
            uinUip = uinUip,
            userPaymentType = userPaymentType,
            status = null,
            channel = null,
            createdAt = null,
            incomeTypeCode = incomeTypeCode,
            amountRecovery = amountRecovery,
            transferTermCode = transferTerm?.code,
            transferTermDescription = transferTerm?.description
        )
    }

    /**
     * Create non budget RuPayment
     */
    private fun getNonBudgetRuPaymentDto(
        user: User,
        balanceAccount: BalanceAccount,
        userPaymentType: UserPaymentType,
        forOrganization: Boolean
    ): RuPaymentDto {
        val customer = CustomerData.getOrCreate(user = user)
        val payerAccount = AccountData.getOrCreateForRuPayment(user = user, customer = customer, isResident = true)
        val contractor = ContractorData.getOrCreate(
            consumer = { ContractorData.searchBy(customer, isOrganization = forOrganization, isBudget = false) },
            provider = {
                ContractorSteps(user).create(getContractorDtoForCreate(customerId = customer.id!!, isOrganization = forOrganization)).data!!.toModel()
            }
        )

        return getRuPaymentDto(
            payer = ParticipantsPrepareSteps.getPayerDto(payerAccount),
            receiver = ParticipantsPrepareSteps.getReceiverDto(
                contractor = contractor,
                contractorPayment = ContractorPaymentData.getOrCreate(
                    consumer = {
                        ContractorPaymentData.get().filter {
                            it.contractorId == contractor.id && balanceAccount.isAccountBelong(it.account)
                        }
                    },
                    provider = {
                        ContractorPrepareSteps.getContractorPaymentOrCreate(contractor, balanceAccount)
                    }
                )
            ),
            amount = Random.nextBigDecimal(max = payerAccount.actualBalance),
            userPaymentType = userPaymentType,
            transferTerm = TransferTermData.random()!!
        )
    }

    /**
     * Create budget RuPayment
     */
    private fun getBudgetRuPaymentDto(user: User, budgetType: BudgetType): RuPaymentDto {
        val budgetDto: BudgetDto = BudgetDtoPrepareSteps.getBudgetDto(budgetType)
        val userPaymentType = when (budgetType) {
            BudgetType.CUSTOM -> CUSTOM
            BudgetType.OTHER -> BUDGET
            BudgetType.TAX -> TAX
        }
        val customer = CustomerData.getOrCreate(user = user)
        val payerAccount = AccountData.getOrCreateForRuPayment(user = user, customer = customer, isResident = true)
        val amount = Random.nextBigDecimal(max = payerAccount.actualBalance)
        val contractor = ContractorData.getOrCreate(
            consumer = { ContractorData.searchBy(customer, isOrganization = true, isBudget = true) },
            provider = { ContractorSteps(user).create(getContractorDtoForCreate(customerId = customer.id!!, isOrganization = true)).data!!.toModel() }

        )
        val contractorPaymentData = ContractorPaymentData.getOrCreate(
            consumer = {
                ContractorPaymentData.get().filter {
                    it.contractorId == contractor.id && BalanceAccount.N_40101.isAccountBelong(it.account)
                }
            },
            provider = {
                ContractorPrepareSteps.getContractorPaymentOrCreate(contractor, BalanceAccount.N_40101)
            }
        )
        return getRuPaymentDto(
            payer = ParticipantsPrepareSteps.getPayerDto(payerAccount),
            receiver = ParticipantsPrepareSteps.getReceiverDto(contractor, contractorPaymentData),
            amount = amount,
            userPaymentType = userPaymentType,
            budget = budgetDto,
            budgetType = budgetType
        )
    }

    fun getDtoForUpdate(ruPaymentDto: RuPaymentDto): RuPaymentDto {
        return ruPaymentDto.copy(
            amount = (amount(ruPaymentDto.amount) / amount(10.0))
        )
    }

    /**
     * Create other budget RuPayment
     */
    internal fun getOtherRuPaymentDto(user: User, budgetType: BudgetType? = null): RuPaymentDto {
        return if (budgetType == null) {
            getNonBudgetRuPaymentDto(
                user = user,
                balanceAccount = listOf(BalanceAccount.N_40702, BalanceAccount.N_40802).random(),
                userPaymentType = BUSINESS,
                forOrganization = true
            )
                .apply { userPaymentType = OTHER }
        } else {
            getBudgetRuPaymentDto(user, budgetType = budgetType)
                .apply { userPaymentType = OTHER }
        }
    }

    /**
     * Payment between accounts on same customer. Try found customer with two acc's, if not found, create id.
     */
    private fun getOwnAccountsRuPaymentDto(user: User): RuPaymentDto {
        val accounts = AccountData.searchBy(user)
            .groupBy { it.customerId }
            .filter { it.value.size > 1 }
            .ifEmpty {
                val customer = CustomerData.searchBy(user).random()
                val payerAccount = AccountData.getOrCreateForRuPayment(user = user, customer = customer, isResident = true)
                val payerSecondAccount =
                    AccountData.getOrCreateForRuPayment(
                        user = user,
                        customer = customer,
                        isResident = true
                    ) { it.accountNumber != payerAccount.accountNumber }
                mapOf(customer.id!! to listOf(payerAccount, payerSecondAccount))
            }.entries.first().value
        val amount = Random.nextBigDecimal(max = accounts[0].actualBalance)
        return getRuPaymentDto(
            payerAccount = accounts[0],
            receiverAccount = accounts[1],
            amount = amount,
            userPaymentType = OWNACCOUNTS
        )
    }
}

object RuPaymentTemplates {
    @Step("Подготовить данные для создания ПП юридическим лицам и ИП (BUSINESS)")
    fun getBusinessRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getRuPaymentDto(user = user, userPaymentType = BUSINESS)

    @Step("Подготовить данные для создания ПП физическому лицу (PERSON)")
    fun getPersonRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getRuPaymentDto(user = user, userPaymentType = PERSON)

    @Step("Подготовить данные для создания ПП в бюджетную организацию (BUDGET)")
    fun getBudgetRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getRuPaymentDto(user = user, userPaymentType = BUDGET)

    @Step("Подготовить данные для создания ПП для оплаты налогов и сборов (TAX)")
    fun getTaxRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getRuPaymentDto(user = user, userPaymentType = TAX)

    @Step("Подготовить данные для создания ПП для оплаты таможенных пошлин (CUSTOM)")
    fun getCustomRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getRuPaymentDto(user = user, userPaymentType = CUSTOM)

    fun getOwnAccountsRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getRuPaymentDto(user = user, userPaymentType = OWNACCOUNTS)

    @Step("Подготовить данные для создания ПП по свободным реквизитам (OTHER) [Платеж в бюджет = Таможенный]")
    fun getOtherCustomRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getOtherRuPaymentDto(user = user, budgetType = BudgetType.CUSTOM)

    @Step("Подготовить данные для создания ПП по свободным реквизитам (OTHER) [Платеж в бюджет = Налоговый]")
    fun getOtherTaxRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getOtherRuPaymentDto(user = user, budgetType = BudgetType.TAX)

    @Step("Подготовить данные для создания ПП по свободным реквизитам (OTHER) [Платеж в бюджет = Иной]")
    fun getOtherOtherRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getOtherRuPaymentDto(user = user, budgetType = BudgetType.OTHER)

    @Step("Подготовить данные для создания ПП по свободным реквизитам (OTHER) [Платеж в бюджет = Нет]")
    fun getOtherRuPayment(user: User = client): RuPaymentDto =
        RuPaymentPrepareSteps.getOtherRuPaymentDto(user = user)

}