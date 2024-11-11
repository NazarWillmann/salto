package ooo.jtc.api.curtransfer.steps

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps
import ooo.jtc.api.dictionaries.swift.SwiftPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.curtransfer.dto.CurTrBeneficiaryBankDto
import ooo.jtc.curtransfer.dto.CurTrBeneficiaryDto
import ooo.jtc.curtransfer.dto.CurTrIntermediaryBankDto
import ooo.jtc.curtransfer.dto.CurTrPayerBankDto
import ooo.jtc.curtransfer.dto.CurTrPayerDto
import ooo.jtc.curtransfer.dto.CurTransferDto
import ooo.jtc.curtransfer.dto.MoneyAmountDto
import ooo.jtc.curtransfer.model.CurTrChargeType
import ooo.jtc.curtransfer.model.CurTrChargeType.BEN
import ooo.jtc.curtransfer.model.CurTrChargeType.OUR
import ooo.jtc.curtransfer.model.CurTrChargeType.SHA
import ooo.jtc.curtransfer.model.CurTrRateType
import ooo.jtc.curtransfer.model.CurTrUrgencyType
import ooo.jtc.dictionaries.currency.DefaultCurrency
import ooo.jtc.dictionaries.currency.ReducedCurrencyDto
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.nextBigDecimal
import ooo.jtc.random.nextLocalDate
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.curtransfer.CurTransferFilterParams
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import kotlin.random.Random
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

object CurTransferPrepareSteps {

    private val docChecks = ApiDocumentChecks<CurTransferDto>()

    /**
     * Provides filter for getting all CurTransfer with filled 'executionDate'.
     * "LesserOrEqual than current moment" basically means "all existing CurTr's with non-null 'executionDate'"
     */
    val executedCurTransferFilter: FilterData
        get() = CurTransferFilterParams.EXECUTION_DATE.le(ZonedDateTime.now())

    /**
     * Retrieve client user for creation.
     * Because only client user can create CurTransfer.
     */
    fun retrieveClientUser(user: User): User =
        if (user.isClient) user else Users.client

    /**
     * Retrieve bank user for receiving created CurTransfer.
     */
    fun retrieveBankUser(user: User): User =
        if (user.isBank) user else Users.bankOperator


    @Step("Найти или создать документ '${DocumentNames.CUR_TRANSFER}', доступный пользователю {searchingUser.login}")
    fun getOrCreateCurTransferDto(
        searchingUser: User,
        creatorClientUser: User = retrieveClientUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (CurTransferDto) -> Boolean = { true },
        createCurTrFunc: () -> CurTransferDto = { createCurTransferAvailableToUser(targetUser = searchingUser) }
    ): CurTransferDto {
        creatorClientUser.checkIsClientUser()

        val existingAvailableLetters =
            CurTransferSteps(searchingUser).getPage(getPageRequest = getPageRequest.invoke()).page?.filter(additionalFilter)

        val letterToReturn: CurTransferDto = if (!existingAvailableLetters.isNullOrEmpty()) existingAvailableLetters.random()
        else createCurTrFunc.invoke()

        return letterToReturn.attachToAllure("result")
    }

    @Step(
        "Найти набор разных '${DocumentNames.CUR_TRANSFER}' или создать их необходимое количество," +
                " доступные пользователю {searchingUser.login}"
    )
    fun getOrCreateDifferentCurTransferDtoList(
        searchingUser: User,
        creatorClientUser: User = retrieveClientUser(searchingUser),
        getPageRequest: () -> GetPageRequest = { GetPageRequest() },
        additionalFilter: (CurTransferDto) -> Boolean = { true },
        createLtbFunc: () -> CurTransferDto =  { createCurTransferAvailableToUser(targetUser = searchingUser) },
        amount: Long = REQUIRED_DATA_COUNT
    ): List<CurTransferDto> {
        creatorClientUser.checkIsClientUser()
        val resultLettersList: MutableList<CurTransferDto> = mutableListOf()

        val existingAvailableLetters =
            CurTransferSteps(searchingUser).getPage(getPageRequest = getPageRequest.invoke()).page?.filter(additionalFilter)

        existingAvailableLetters?.let { resultLettersList.addAll(it.take(amount.toInt())) }
        while (resultLettersList.size < amount) {
            val newCurTransfer = createLtbFunc.invoke()
            resultLettersList.add(newCurTransfer)
        }

        return resultLettersList.attachToAllure("result")
    }

    @Step("Создать документ '${DocumentNames.CUR_TRANSFER}' доступный пользователю {targetUser.login}")
    fun createCurTransferAvailableToUser(
        targetUser: User,
        creatorClientUser: User = retrieveClientUser(targetUser),
        receiverBankUser: User = retrieveBankUser(targetUser),
        dtoForCreate: CurTransferDto = getCurTransferDtoForCreate(creatorClientUser, receiverBankUser)
    ): CurTransferDto {
        TODO("Not implemented yet [2021.01.23]")
///        return if (targetUser.isClient) createCurTransfer(user, dtoForCreate)
///        else createSentCurTransfer(creatorClientUser, user, dtoForCreate)
    }

    @Step("Подготовить объект для создания '${DocumentNames.CUR_TRANSFER}'")
    fun getCurTransferDtoForCreate(
        creatorClientUser: User = Users.client,
        receiverBankUser: User = Users.bankOperator
    ): CurTransferDto {
        val availableBranchCustomerId =
                (BranchCustomerData.getCommonBranchCustomersIds(creatorClientUser, receiverBankUser)?.randomOrNull())
                    ?: BranchCustomerData.getOrCreateCommonBranchCustomer(clientUser = creatorClientUser, bankUser = receiverBankUser).id!!
        val availableBranchCustomer = BranchCustomerData.byId(availableBranchCustomerId)

        AccountData.getOrCreate(
            consumer = { AccountData.get(false) { it.branchCustomerId == availableBranchCustomerId } },
            provider = {
                AccountPrepareSteps.createNewAccount(
                    AccountPrepareSteps.getRuPaymentValidAccountDto(
                        user = creatorClientUser,
                        customerId = availableBranchCustomer.customerId,
                        branchCustomerId = availableBranchCustomerId
                    )
                ).toModel()
            }
        )
        return getCurTransferDtoForCreate(
            customerId = availableBranchCustomer.customerId,
            branchId = availableBranchCustomer.branchId
        )
    }

    private fun getCurTransferDtoForCreate(
        customerId: UUID,
        branchId: UUID
    ): CurTransferDto {
        val customer = CustomerData.byId(customerId)
        val branch = BranchData.byId(branchId)

        val debitCurrency = DefaultCurrency.RUB
        val debitDto = MoneyAmountDto(
            amount = Random.nextBigDecimal(100.0, 900.0),
            currency = ReducedCurrencyDto.ofDefaultCurrency(debitCurrency)
        )
        val transferDto = MoneyAmountDto(
            amount = Random.nextBigDecimal(100.0, 200.0),
            currency = ReducedCurrencyDto.ofDefaultCurrency(DefaultCurrency.USD)
        )
        val rateType = CurTrRateType.USER_RATE
        val rate = debitDto.amount / transferDto.amount
        val urgency = CurTrUrgencyType.values().random()

        val chargeType: CurTrChargeType = BEN//CurTrChargeType.values().random()
        val chargeAccount: String?
        val chargeBic: String?
        when (chargeType) {
            BEN -> {
                chargeAccount = null
                chargeBic = null
            }
            OUR, SHA -> { TODO("Not implemented yet [2021.01.23]") }
        }

        val customerAccount = AccountData.searchBy(customer).random()
        val payerDto = CurTrPayerDto(
            name = customer.shortName,
            account = customerAccount.accountNumber,
            inn = customer.inn
        )

        val payerBankDto = CurTrPayerBankDto()

        //TODO Sergeyev [2021.01.25]: international account number generator
        val swiftBenef = SwiftPrepareSteps.prepareAtSwiftDto()//SwiftData.random()
        val benefAccount = digits.random(20, 20)
        val beneficiaryDto = CurTrBeneficiaryDto(
            account = benefAccount,
        )

        val benefBankAccount = digits.random(20, 20)//RandomRequisites.generateCorrAccountNumber()
        val beneficiaryBankDto = CurTrBeneficiaryBankDto(
            name = swiftBenef.branchName,
            //account = benefBankAccount,
            swift = swiftBenef.swift
        )

        val intermediaryBankDto = CurTrIntermediaryBankDto()

        return CurTransferDto(
            id = null,
            version = 0,
            documentNumber = digits.random(6, 6),
            documentDate = LocalDate.now(),
            status = null,
            customerId = customerId,
            customerName = customer.shortName,
            branchId = branchId,
            branchName = branch.shortName,
            debit = debitDto,
            transfer = transferDto,
            rateType = rateType.value,
            rate = rate.toInt(), //TODO Sergeyev [2021.01.23]: currency transfer rate as an integer?!
            valueDate = Random.nextLocalDate(maxPlusDays = 100),
            urgency = urgency.value,

            paymentInformation = "Automatically generated currency transfer$AT_POSTFIX",
            paymentAddInformation = regexWords.random(50, 100),
            chargeType = chargeType,
            chargeAccount = chargeAccount,
            chargeBic = chargeBic,
            regulationInfos = emptyList(),
            contactName = "Contact Name ${RandomData("[а-яА-Я ]*").random(7, 10)}",
            contactPhone = RandomRequisites.generatePhoneNumber(),

            payer = payerDto,
            payerBank = payerBankDto,
            beneficiary = beneficiaryDto,
            beneficiaryBank = beneficiaryBankDto,
            intermediaryBank = intermediaryBankDto
        )
    }

    fun getCurTransferDtoForUpdate(docDto: CurTransferDto): CurTransferDto {
        return docDto.copy(
            paymentInformation = "UPDATED ${docDto.paymentInformation}"
        )
    }
}