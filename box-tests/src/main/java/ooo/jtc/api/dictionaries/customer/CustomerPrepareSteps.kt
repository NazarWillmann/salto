package ooo.jtc.api.dictionaries.customer

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps.createNewAccount
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps.getRuPaymentValidAccountDto
import ooo.jtc.api.dictionaries.account.AccountSteps
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps.ensureBankUserIsRelatedToBranch
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.ensureBranchAndCustomerAreRelated
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeSteps
import ooo.jtc.api.dictionaries.common.address.AddressPrepareSteps
import ooo.jtc.api.dictionaries.common.address.AddressPrepareSteps.getRandomAddressType
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps.createCustomerRepresentative
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps.getCustomerRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeSteps
import ooo.jtc.api.dictionaries.ground.GroundSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.dictionaries.account.AccountDto
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.common.address.AddressDto
import ooo.jtc.dictionaries.customer.CustomerDto
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto
import ooo.jtc.dictionaries.customertype.CustomerType
import ooo.jtc.dictionaries.customertype.CustomerTypeShort
import ooo.jtc.extensions.randomAnother
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.random.RandomNameUtils
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.nextLocalDate
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.customer.FindCustomerBy
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeData
import ooo.jtc.testdata.dictionaries.ground.GroundData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.util.*
import kotlin.random.Random

object CustomerPrepareSteps {
    private val almightyUser by lazy { Users.superUser }
    private val aGroundSteps by lazy { GroundSteps(almightyUser) }
    private val aAccountSteps by lazy { AccountSteps(almightyUser) }
    private val aCustomerSteps by lazy { CustomerSteps(almightyUser) }
    private val aBranchCustomerSteps by lazy { BranchCustomerSteps(almightyUser) }
    private val aBranchRepresentativeSteps by lazy { BranchRepresentativeSteps(almightyUser) }
    private val aClientRepresentativeSteps by lazy { CustomerRepresentativeSteps(almightyUser) }

    @Step("Удалить ВСЕ созданные автотестами данные Customer")
    fun cleanAtCreated() {
        FindCustomerBy.AT_CREATED.get(false).forEach { customer ->
            CustomerData.removeRecord?.let { it(customer) }
        }
    }

    //region -=| Generation section |=-
    private fun <T> getForCustomerType(cType: CustomerType, ipFunc: () -> T, otherFunc: () -> T): T =
        if (CustomerTypeShort.IP == cType.systemName) ipFunc.invoke() else otherFunc.invoke()

    private fun getCountryDigitCode(isResident: Boolean): String {
        if (isResident) return "643"

        return CountryData.get(seekAtCreated = false)
            .map { it.digitCode }
            .randomAnother("643")
    }

    private fun generateInn(customerType: CustomerType): String =
        getForCustomerType(customerType,
            ipFunc = { RandomRequisites.generateInnForIp() },
            otherFunc = { RandomRequisites.generateInnForUl() }
        )

    private fun generateOkpo(customerType: CustomerType): String =
        getForCustomerType(customerType,
            ipFunc = { RandomRequisites.generateOkpoForIp() },
            otherFunc = { RandomRequisites.generateOkpoForUl() }
        )

    private fun generateOgrn(customerType: CustomerType): String =
        getForCustomerType(customerType,
            ipFunc = { RandomRequisites.generateOgrnIp() },
            otherFunc = { RandomRequisites.generateOgrnUl() }
        )

    //TODO Khatmullin [06.05.2021]: need to be refactored with RandomNameUtils
    private fun generateDescription(): String = regexWords.random(20, 3500) + AT_POSTFIX
    private fun generateFullName(): String = regexWord.random(100, 180) + AT_POSTFIX
    private fun generateShortName(): String = regexWord.random(30, 40).replace("_", "")
    //endregion


    // -=| DTO creation section |=-

    @Step("Подготовить DTO '${DictionaryNames.CUSTOMER}' для создания")
    fun getCustomerDtoForCreate(
        forUi: Boolean = true,
        customerType: CustomerType = CustomerTypeData.get {
            it.systemName in listOf(CustomerTypeShort.IP, CustomerTypeShort.UL)
        }.random(),
        isResident: Boolean = true,
        isBlock: Boolean = false
    ): CustomerDto {
        val isIP = customerType.systemName == CustomerTypeShort.IP
        var shortName: String
        val isShortNameNotUnique: (String) -> Boolean =
            { randomShortName -> CustomerData.get(fromCache = false) { it.shortName == randomShortName }.isNotEmpty() }
        do { //shortName is unique
            shortName = if (forUi) RandomNameUtils.companyShortName(isIP) + AT_POSTFIX_RUS_PARENTHESES else generateShortName()
        } while (isShortNameNotUnique(shortName))

        val fullName: String = if (forUi) RandomNameUtils.companyFullName(shortName, isIP) else generateFullName()
        val intName: String =/*if (forUi) RandomNameUtils.companyInternationalShortName() else TODO check https://jira.jtc.ooo/browse/JTCSALTO-4842 */
            generateShortName()
        val addressReg = AddressPrepareSteps.getFilledAddressDto(getRandomAddressType())
        val addressLoc = AddressPrepareSteps.getFilledAddressDto(getRandomAddressType())
        return CustomerDto(
            id = null,
            version = 0,
            countryDigitCode = getCountryDigitCode(isResident),
            isResident = isResident,
            inn = generateInn(customerType),     // up to 12 symbols (digits only)
            okpo = generateOkpo(customerType),   // up to 10 symbols (digits only)
            ogrn = generateOgrn(customerType),   // up to 15 symbols (digits only)
            block = BlockingInfoDto(isBlock),
            customerType = customerType.toDto(),
            okopf = RandomRequisites.generateOkopf(),
            okfs = RandomRequisites.generateOkfs(),
            fullName = fullName,          // unique, up to 255 symbols
            shortName = shortName,        // unique, up to 160 symbols
            intName = intName,
            phone = RandomRequisites.generatePhoneNumber(),                // up to 50 symbols
            description = generateDescription(),
            kpp = emptyList(),
            ogrnDate = Random.nextLocalDate(maxMinusDays = 366),
            email = RandomRequisites.generateEmail(),   // up to 50 symbols
            addressRegistration = addressReg,
            addressLocation = addressLoc,
            customerTypeId = customerType.id!!
        )
    }

    fun getCustomerDtoForUpdate(createdDto: CustomerDto): CustomerDto =
        createdDto.copy(
            fullName = "Updated ${createdDto.fullName}",
            shortName = "UPD ${createdDto.shortName}",
            phone = RandomRequisites.generatePhoneNumber(),
            description = "updated ${createdDto.description}",
            ogrnDate = Random.nextLocalDate(maxMinusDays = 366),
            email = RandomRequisites.generateEmail()
        )

    fun getCustomerKppDto() = CustomerKppDto(
        id = null,
        version = 0,
        unitName = TestConstants.AT_PREFIX + UUID.randomUUID().toString(),
        kpp = "${digits.random(4, 4)}${TestConstants.AT_NUM}", // up to 9 symbols (digits only)
        isDefault = true
    )

    //todo Khatmullin [2021.07.02] refactor kpp based steps
    /**
     * Create new customer and necessary related entities. Namely, BranchCustomer, and
     * * for a bank user: BankRepresentative
     * * for a client user: ClientRepresentative
     */
    @Step("Создать организацию, связанную с пользователем '{user.login}'")
    fun createCustomerWithRelationsForUser(
        user: User,
        customerDto: CustomerDto = getCustomerDtoForCreate()
    ): CustomerDto {
        val createdCustomer = createCustomerWithNoRelations(customerDto)
        if (user != almightyUser)
            when (user.userType) {
                UserType.BANK -> ensureBankUserIsRelatedToCustomer(user, createdCustomer.id!!)
                UserType.CLIENT -> ensureClientUserIsRelatedToCustomer(user, createdCustomer.id!!)
            }
        user.invokeAuth(newToken = true)
        return createdCustomer
    }

    @Step("Создать организацию, не связанную ни с одним пользователем")
    fun createCustomerWithNoRelations(customerForCreation: CustomerDto = getCustomerDtoForCreate()): CustomerDto {
        val createCustomerResponse = aCustomerSteps.createWithoutBranchCustomer(customerForCreation)
        return createCustomerResponse.data.getOrException()
    }

    @Step("Проверить, связан ли пользователь '{user.login}' с организацией [{customerId}]")
    fun isUserRelatedToCustomer(user: User, customerId: UUID): Boolean {
        if (almightyUser == user)
            return true

        if (user.isClient) {
            val response = CustomerRepresentativeData
                .get(fromCache = false) { (it.customerId!! == customerId) && (it.userId!! == user.uaaUserId) }
            return response.isNotEmpty()
        }

        //if (user.isBank)
        val customersAvailableToUser = BranchCustomerData.searchBy(user)
            .map { it.customerId }
            .distinct()
        return customersAvailableToUser.contains(customerId)
    }

    /**
     * Check if provided bank user is related to customer with provided id (through branch with providedId, if specified).
     * Create relation if it doesn't exist.
     *
     * @param bankUser   - user, that has to be related to customer
     * @param customerId - customer, that has to be related to user
     * @param branchId   - if specified, - branch, that will be used to link bankUser to customer
     */
    @Step("Удостовериться, что банковский пользователь '{bankUser.login}' связан с организацией [{customerId}] (через подразделение [{branchId}])")
    fun ensureBankUserIsRelatedToCustomer(bankUser: User, customerId: UUID, branchId: UUID? = null) {
        bankUser.checkIsBankUser()

        branchId?.let { ensureBranchAndCustomerAreRelated(it, customerId) }
        if (isUserRelatedToCustomer(bankUser, customerId))
            return

        branchId?.let { ensureBankUserIsRelatedToBranch(bankUser, branchId) }
        val branchIdForLinking: UUID = branchId ?: BranchData.searchBy(bankUser).map { it.id!! }
            .ifEmpty {
                val newBranchForBankUser = BranchData.getOrCreate { BranchPrepareSteps.createBranchWithRelatedEntitiesForUsers(bankUser).toModel() }
                val branchRepresentativeDto = getBranchRepresentativeDtoForCreate(bankUser.uaaUserId!!, newBranchForBankUser.id!!)
                aBranchRepresentativeSteps.create(branchRepresentativeDto)
                listOf(newBranchForBankUser.id!!)
            }.random()

        val branchCustomerDto = getBranchCustomerDtoForCreate(branchIdForLinking, customerId)
        aBranchCustomerSteps.create(branchCustomerDto)
    }

    /**
     * Check if provided client user is related to customer with provided id (through branch with providedId, if specified).
     * Create relation if it doesn't exist.
     *
     * @param clientUser - user, that has to be related to customer
     * @param customerId - customer, that has to be related to user
     */
    @Step("Удостовериться, что клиентский пользователь '{clientUser.login}' связан с организацией [{customerId}]")
    fun ensureClientUserIsRelatedToCustomer(clientUser: User, customerId: UUID) {
        clientUser.checkIsClientUser()

        if (isUserRelatedToCustomer(clientUser, customerId))
            return

        val clientRepresentativeDto = getCustomerRepresentativeDtoForCreate(clientUser.uaaUserId!!, customerId)
        aClientRepresentativeSteps.create(clientRepresentativeDto)
    }

    @Step("Создать ${DictionaryNames.CUSTOMER}")
    fun createCustomerDto(
        customerUser: User,
        forUi: Boolean = true,
        customerForCreate: CustomerDto = getCustomerDtoForCreate(forUi),
        withBranchCustomer: Boolean = true,
        createBranchCustomer: (UUID) -> BranchCustomerDto = { customerId: UUID ->
            val branch = BranchData.getOrCreate(
                consumer = { BranchData.searchBy(customerUser) },
                provider = {
                    BranchPrepareSteps.createBranchWithBranchRepresentative(Users.bankOperator, Users.bankAdmin).toModel()
                }
            )
            ensureBranchAndCustomerAreRelated(branchId = branch.id!!, customerId = customerId)
        },
        withCustomerRepresentative: Boolean = true,
        createCustomerRepresentative: (UUID) -> CustomerRepresentativeDto =
            { customerId: UUID ->
                if (customerUser.isClient) {
                    createCustomerRepresentative(customerUser.uaaUserId!!, customerId)
                } else createCustomerRepresentative(getCustomerRepresentativeDtoForCreate(customerUser))
            },
        withLocAddress: Boolean = false,
        withRegAddress: Boolean = false,
        prepareAddress: () -> AddressDto = { AddressPrepareSteps.getFilledAddressDto(getRandomAddressType()) },

        withKpp: Boolean = false,
        prepareCustomerKpp: () -> CustomerKppDto = { getCustomerKppDto() },
        withAccount: Boolean = true,
        createAccount: (UUID) -> AccountDto = { customerId: UUID ->
            createNewAccount(getRuPaymentValidAccountDto(customerUser, customerId))
        }
    ): CustomerDto {
        val customerSteps = CustomerSteps(Users.superUser)
        var customerDto = customerSteps.createWithoutBranchCustomer(customerForCreate)
            .data.getOrException("Error: creating customer ${customerForCreate.shortName}")
        val customerId = customerDto.id!!

        if (withBranchCustomer) createBranchCustomer.invoke(customerId)
        if (withCustomerRepresentative) createCustomerRepresentative.invoke(customerId)
        if (withRegAddress) {
            val addressRegDto = prepareAddress()
            customerDto.addressRegistration = addressRegDto
            customerDto = customerSteps.update(customerDto)
                .data.getOrException("Error: updating customer addresses while creating customer [${customerDto.id}]")
        }
        if (withLocAddress) {
            val addressLocDto = prepareAddress()
            customerDto.addressLocation = addressLocDto
            customerDto = customerSteps.update(customerDto)
                .data.getOrException("Error: updating customer addresses while creating customer [${customerDto.id}]")
        }
        if (withKpp) {
            val kppDto = prepareCustomerKpp()
            customerDto.kpp = listOf(kppDto)
            customerDto = customerSteps.update(customerDto)
                .data.getOrException("Error: updating customer kpps while creating customer [${customerDto.id}]")
        }
        if (withAccount) createAccount.invoke(customerId)
        customerUser.invokeAuth(newToken = true)
        return customerSteps.getById(customerId).data.getOrException()
    }

    /**
     * Delete Customer and related entities:
     * * Contractor - all related to provided Customer (and all Contractor data);
     * * Account - all accounts, related to provided Customer;
     * * CustomerRepresentative - for all Customers, related to provided Customer;
     * * BranchCustomer - all records, related to provided Customer.
     *
     *
     * (!)WARNINGS(!)
     *
     * This method wasn't properly tested yet. Use with caution!
     *
     * @param customerId id of a customer (with related entities)
     */
    @Step("Удалить организацию [{customerId}] и связанные с нею данные, если возможно (нет связанных ПП, писем, ...)")
    fun deleteCustomerAndRelatedEntitiesIfPossible(customerId: UUID, deleteAtOnly: Boolean = true) {
        val customerDto = aCustomerSteps.getById(customerId).data.getOrException()
        if (deleteAtOnly && !CustomerData.atMarkerPredicate(customerDto.toModel()))
            throw RuntimeException("This is not an AT-created Customer")

        /* Sergeyev [2020.12.15]:
         * наличие документов не мешает удалению, т.к. это сущности другого сервиса.
         * Для удаления "ничейных" документов должны использоваться отдельные методы в соотв. классах.
         * [2021.08.03]:
         * Удаление адресов и КПП Клиента ЮЛ происходит в рамках удаления самого Клиента, т.к. они
         * трактуются Системой как вложенные сущности.
         */

        val relatedBranchCustomersIds = BranchCustomerData.searchByCustomersIds(customerId).map { it.id!! }
        val relatedContractorsIds = ContractorData.get { customerId == it.customerId }.map { it.id!! }

        /* 1 */ "Удаляем связанных Контрагентов с их связанными сущностями" {
            relatedContractorsIds.forEach { ContractorPrepareSteps.deleteContractorAndRelatedEntities(it, deleteAtOnly) }
        }
        /*1.1*/ "Удаляем связанные Основания платежа (завязанные на Клиента, а не на его Контрагентов)" {
            val relatedGrounds = GroundData.get { customerId == it.customerId && it.contractorId !in relatedContractorsIds }
            relatedGrounds.forEach { aGroundSteps.delete(it.id!!) }
        }

        /* 2 */ "Удаляем связанные Счета" {
            val relatedAccounts = AccountData.get { it.branchCustomerId in relatedBranchCustomersIds }
            relatedAccounts.forEach { aAccountSteps.delete(it.id!!) }
        }

        /* 3 */ "Удаляем связанных Представителей Клиента" {
            val relatedClientRepresentatives = CustomerRepresentativeData
                .get { it.customerId?.let { custId -> custId == customerId } ?: false }
            relatedClientRepresentatives.forEach { aClientRepresentativeSteps.delete(it.id!!) }
        }

        /* 4 */ "Удаляем Связи Клиента и Подразделения" {
            relatedBranchCustomersIds.forEach { aBranchCustomerSteps.delete(it) }
        }

        /* 5 */ aCustomerSteps.delete(customerId)
    }
}
