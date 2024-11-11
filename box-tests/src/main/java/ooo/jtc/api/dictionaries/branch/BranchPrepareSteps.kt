package ooo.jtc.api.dictionaries.branch

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps
import ooo.jtc.api.dictionaries.bankbic.BankBicPrepareSteps.prepareBicPaymentDetails
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.ensureBranchAndCustomerAreRelated
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.api.dictionaries.branchindividual.BranchIndividualPrepareSteps
import ooo.jtc.api.dictionaries.branchindividual.BranchIndividualSteps
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeSteps
import ooo.jtc.api.dictionaries.common.address.AddressPrepareSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.createCustomerWithNoRelations
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.ensureClientUserIsRelatedToCustomer
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.getCustomerDtoForCreate
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.core.TestConstants.AT_NUM
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.dictionaries.bankbic.BankBic
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount
import ooo.jtc.dictionaries.branch.BranchDto
import ooo.jtc.dictionaries.branch.BranchType
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBicDto
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwiftDto
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto
import ooo.jtc.dictionaries.branchindividual.BranchIndividualDto
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomNameUtils
import ooo.jtc.random.RandomRequisites
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.bankbic.BankBicAccountData
import ooo.jtc.testdata.dictionaries.bankbic.BankBicData
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branch.FindBranchBy
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchindividal.BranchIndividualData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.swift.SwiftData
import ooo.jtc.uaa.User
import org.apache.commons.lang3.ArrayUtils.isEmpty
import java.util.*

object BranchPrepareSteps {
    private val almightyUser by lazy { Users.superUser }
    private val aBranchSteps by lazy { BranchSteps(almightyUser) }
    private val aCustomerSteps by lazy { CustomerSteps(almightyUser) }
    private val aBranchCustomerSteps by lazy { BranchCustomerSteps(almightyUser) }
    private val aBranchIndividualSteps by lazy { BranchIndividualSteps(almightyUser) }
    private val aBranchRepresentativeSteps by lazy { BranchRepresentativeSteps(almightyUser) }

    @Step("Удалить созданные автотестами данные Branch из БД")
    fun cleanAtCreated() {
        FindBranchBy.AT_CREATED.get(false).forEach {
            deleteBranchAndRelatedEntities(it.id!!, deleteChildren = true)
        }
    }

    fun getBranchDtoForCreate(forUi: Boolean = true, parentId: UUID? = null): BranchDto {
        val branchData = BranchData.get(fromCache = false)
        val corrAccData = BankBicAccountData.get { it.accountType == "CRSA" && it.status == "ACAC" }
        val existingBranchesBics = branchData.map { it.paymentDetailsBic!!.bic }.distinct()
        val realBankBic = BankBicData.get(fromCache = false)
        val usableBankBics = realBankBic.filter { it.bic !in existingBranchesBics }

        val bicPaymentDetailsDto = prepareBicPaymentDetails(usableBankBics,corrAccData)


        val bic = bicPaymentDetailsDto.bic
        val corrAcc = bicPaymentDetailsDto.corrAcc
        val bankNameBic = bicPaymentDetailsDto.bankNameBic
        val bankPlaceBic = bicPaymentDetailsDto.bankPlaceBic

        val existingBranchesSwifts = branchData.map { it.paymentDetailsSwift!!.swift }.distinct()
        val bankSwift = SwiftData.get(false).filter { it.swift !in existingBranchesSwifts }.random()
        val swift = bankSwift.swift
        val bankNameSwift = bankSwift.name
        val countryCode = CountryData.get(false).first { it.alpha2Code == bankSwift.countryAlpha2Code }
        val countryDigitCodeSwift = countryCode.digitCode //for a while.
        val bankCitySwift = bankSwift.city
        val bankAddressSwift = (bankSwift.address1 + bankSwift.address2 + bankSwift.address3 + bankSwift.address4).replace("null","").trim()

        val isChild = parentId != null
        val shortName = if (forUi) RandomNameUtils.bankShortName(isChild) else regexWord.random(20, 40)
        val fullName = if (forUi) RandomNameUtils.bankFullName(shortName) else regexWord.random(90, 170)
        val name = if (forUi) convertBranchName(shortName) else regexWord.random(90, 170)
        val bankInfoId = BankInfoData.nonAtCreatedBank.id!!
        val atPhoneNumber = "+7" + digits.random(5, 5) + AT_NUM

        val branchLocAddress = AddressPrepareSteps.getFilledRuAddressDto()
        val branchRegAddress = AddressPrepareSteps.getFilledRuAddressDto()


        return BranchDto(
            id = null,
            version = 0,

            branchType = BranchType.WITH_BIC.type,  // "withBic" / "withoutBic"
            kpp = "${digits.random(4, 4)}${AT_NUM}",
            shortName = shortName + AT_POSTFIX,             // unique, up to 50 symbols
            fullName = fullName + AT_POSTFIX,               // unique, up to 200 symbols
            uiName = name + AT_POSTFIX,                     // unique, up to 200 symbols
            paymentDetailsBic = PaymentDetailsBicDto(
                bic = bic,
                bankName = bankNameBic,
                corrAccount = corrAcc,
                bankPlace = bankPlaceBic
            ),
            paymentDetailsSwift = PaymentDetailsSwiftDto(
                swift = swift,
                bankName = bankNameSwift,
                countryDigitCode = countryDigitCodeSwift,
                bankAddress = bankAddressSwift,
                bankCity = bankCitySwift
            ),
            bankId = bankInfoId,
            phoneSupports = listOf(PhoneInfoDto(phone = atPhoneNumber)),    // up to 50 symbols
            email = RandomRequisites.generateEmail(),                       // up to 50 symbols
            addressRegistration = branchRegAddress,
            addressLocation = branchLocAddress,

            extIds = emptyList(),
            description = "${regexWord.random(10, 20)}$AT_POSTFIX",

            parentBranchId = parentId
        )
    }

    fun getBranchDtoForUpdate(createdDto: BranchDto): BranchDto =
        createdDto.copy(
            shortName = "upd. ${createdDto.shortName}",
            fullName = "Updated ${createdDto.fullName}",
            uiName = "Updated ${createdDto.uiName}",
            email = "upd8d${createdDto.email}"      // up to 50 symbols
        )

    @Step("Проверить, связан ли пользователь '{user.login}' с подразделением [{branchId}]")
    fun isUserRelatedToBranch(user: User, branchId: UUID): Boolean {
        if (user == almightyUser)
            return true

        if (user.isBank) {
            val response = BranchRepresentativeData
                .get(fromCache = false) { (it.branchId!! == branchId) && (it.userId!! == user.uaaUserId) }
            return response.isNotEmpty()
        }

        //if (user.isClient)
        val branchesAvailableToUser = BranchCustomerData.searchBy(user)
            .map { it.branchId }
            .distinct()
        return branchesAvailableToUser.contains(branchId)
    }

    /**
     * Check if provided bank user is related to branch with provided id.
     * Create relation if it doesn't exist.
     *
     * @param user       - user, that has to be related to customer
     * @param branchId   - branch, that has to be related to user
     */
    @Step("Удостовериться, что банковский пользователь '{user.login}' связан с подразделением [{branchId}]")
    fun ensureBankUserIsRelatedToBranch(user: User, branchId: UUID) {
        user.checkIsBankUser()

        if (isUserRelatedToBranch(user, branchId))
            return

        val bankRepresentativeDto = getBranchRepresentativeDtoForCreate(user.uaaUserId!!, branchId)
        aBranchRepresentativeSteps.create(bankRepresentativeDto)
    }

    /**
     * Check if provided client user is related to branch with provided id.
     * Create relation if it doesn't exist.
     *
     * @param user       client user, that has to be related to customer
     * @param branchId   id of branch, that has to be related to [user]
     * @param customerId (if specified) customer's id, that will be used to link [user] to branch
     */
    @Step("Удостовериться, что клиентский пользователь '{user.login}' связан с подразделением [{branchId}] (через организацию [{customerId}])")
    fun ensureClientUserIsRelatedToBranch(user: User, branchId: UUID, customerId: UUID? = null) {
        user.checkIsClientUser()

        customerId?.let { ensureBranchAndCustomerAreRelated(branchId, customerId) }
        if (isUserRelatedToBranch(user, branchId))
            return

        val customerIdForLinking = customerId ?: CustomerData.searchBy(user).map { it.id!! }.ifEmpty {
            listOf(createCustomerWithNoRelations().id!!)
        }.random()

        ensureClientUserIsRelatedToCustomer(user, customerIdForLinking)
    }

    fun createBranchWithoutRelatedEntities(withParent: Boolean = false): BranchDto {
        val branchForCreation = if (withParent) {
            getChildBranchDtoForCreate()
        } else {
            getBranchDtoForCreate()
        }
        return aBranchSteps.create(branchForCreation).data.getOrException()
    }

    /**
     * Create new Branch and necessary related entities for provided users. Namely:
     * * 0+ BankRepresentative - 1 for each specified bank user (Branch-User relation);
     * + if there were provided clientUsers:
     * * 1 Customer;
     * * 1 BranchCustomer (Branch-Customer relation);
     * * 0+ ClientRepresentative - 1 for each specified client user (Customer-User relation).
     */
    @Step("Создать подразделение с новой связанной организацией и связанное с пользователями '{users}'")
    fun createBranchWithRelatedEntitiesForUsers(vararg users: User, withParent: Boolean = false): BranchDto {
        val providedBankUsers = users.filter { it.isBank && it != almightyUser }
        val providedClientUsers = users.filter { it.isClient }

        // 1) create branch
        val createdBranch = createBranchWithoutRelatedEntities(withParent)

        // 2) create branchRepresentatives for provided bank users
        providedBankUsers.forEach { ensureBankUserIsRelatedToBranch(it, createdBranch.id!!) }

        if (providedClientUsers.isNotEmpty()) {
            // 3) create customer to be related with branch
            val customerForCreation = getCustomerDtoForCreate()
            val createdCustomer = aCustomerSteps.createWithoutBranchCustomer(customerForCreation).data.getOrException()

            // 4) create branchCustomer relation
            val branchCustomerId =
                ensureBranchAndCustomerAreRelated(createdBranch.id!!, createdCustomer.id!!).id!!

            // 5) create account
            val accountDtoForCreate =
                AccountPrepareSteps.getRuPaymentValidAccountDto(customerId = createdCustomer.id!!, branchCustomerId = branchCustomerId)
            AccountPrepareSteps.createNewAccount(accountDtoForCreate)

            // 6) create clientRepresentatives for provided client users
            providedClientUsers.forEach { ensureClientUserIsRelatedToCustomer(it, createdCustomer.id!!) }
        }

        users.forEach { it.invokeAuth(newToken = true) }
        return createdBranch
    }

    fun getChildBranchDtoForCreate(
        parentBranchId: UUID = BranchData.getOrCreate(provider = { createBranchWithoutRelatedEntities().toModel() }).id!!
    ): BranchDto {
        return getBranchDtoForCreate(parentId = parentBranchId)
    }

    @Step("Создать подразделение (Branch) с привязкой к банковским пользователям {bankUsers}")
    fun createBranchWithBranchRepresentative(vararg bankUsers: User): BranchDto {
        bankUsers.forEach { it.checkIsBankUser() }

        // 1) create branch
        val createdBranch = createBranchWithoutRelatedEntities()

        // 2) create branchRepresentatives for provided bank users
        bankUsers.forEach { ensureBankUserIsRelatedToBranch(it, createdBranch.id!!) }
        return createdBranch
    }

    /**
     * Delete branch and related entities:
     * * ChildrenBranches - ([deleteChildren] = true) all related to provided branch (and all their related entities);
     *                      ([deleteChildren] = false) children's 'parentBranchId' set to 'null' and all customers and individuals,
     *                      previously related to parent branch are linked to all children;
     * * CustomerRepresentatives - for all Customers, related to provided Branch;
     * * IndividualRepresentatives - for all Individuals, related to provided Branch;
     * * BranchCustomer - all records, related to provided Branch;
     * * BranchIndividual - all records, related to provided Branch;
     * * BranchRepresentatives - all related to provided Branch.
     *
     * Does NOT delete:
     * * Customers;
     * * Individuals.
     *
     * @param branchId  id of a branch with related entities
     */
    @Step("Удалить подразделение со связанными сущностями (клиенты и связи с пользователями)")
    fun deleteBranchAndRelatedEntities(branchId: UUID, deleteAtOnly: Boolean = true, deleteChildren: Boolean = true) {
        val branchDto = aBranchSteps.getById(branchId).data.getOrException()
        if (deleteAtOnly && !BranchData.atMarkerPredicate(branchDto.toModel()))
            throw RuntimeException("This is not an AT-created branch")

        // 1) delete bankUsers' relations to branch
        val relatedBranchRepresentatives = BranchRepresentativeData.get(fromCache = false) { it.branchId!! == branchId }
        relatedBranchRepresentatives.forEach { aBranchRepresentativeSteps.delete(it.id!!) }

        // 2) delete branch-customer and branch-individual relations
        val branchCustomerRelationsForDelete = BranchCustomerData.get(fromCache = false) { it.branchId == branchId }
        branchCustomerRelationsForDelete.forEach { aBranchCustomerSteps.delete(it.id!!) }

        val branchIndividualRelationsForDelete = BranchIndividualData.get(fromCache = false) { it.branchId == branchId }
        branchIndividualRelationsForDelete.forEach { aBranchIndividualSteps.delete(it.id!!) }

        // 3) delete or remove parent link for children branches
        val childrenBranches = BranchData.get(fromCache = false) { br -> br.parentBranchId?.let { it == branchId } ?: false }
        if (deleteChildren) {
            childrenBranches.forEach { deleteBranchAndRelatedEntities(it.id!!, deleteAtOnly, deleteChildren) }
        } else "Preserving children's links to customers and individuals" {
            val parentCustomersIds = branchCustomerRelationsForDelete.map { it.customerId }
            var newBrCustLink: BranchCustomerDto
            val parentIndividualsIds = branchIndividualRelationsForDelete.map { it.individualId }
            var newBrIndLink: BranchIndividualDto
            childrenBranches.forEach { childBranch ->
                aBranchSteps.update(childBranch.toDto().apply { parentBranchId = null })
                parentCustomersIds.forEach { customerId ->
                    newBrCustLink = BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate(childBranch.id!!, customerId)
                    BranchCustomerPrepareSteps.createBranchCustomer(newBrCustLink)
                }
                parentIndividualsIds.forEach { individualId ->
                    newBrIndLink = BranchIndividualPrepareSteps.getBranchIndividualDtoForCreate(childBranch.id!!, individualId)
                    BranchIndividualPrepareSteps.createBranchIndividual(newBrIndLink)
                }
            }
        }

        // 4) delete branch
        aBranchSteps.delete(branchId)
    }

    /**
     * Convert branch short name to expected format for field `name`.
     */
    private fun convertBranchName(branchShortName: String): String {
        return branchShortName.replace("Филиал", "Ф-Л").toUpperCase()
    }
}