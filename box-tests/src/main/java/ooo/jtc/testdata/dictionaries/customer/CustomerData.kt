package ooo.jtc.testdata.dictionaries.customer

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.common.address.Address
import ooo.jtc.dictionaries.common.address.ForeignAddress
import ooo.jtc.dictionaries.common.address.RuAddress
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.dictionaries.customertype.CustomerType
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.util.*

/**
 * Customer data, that loaded from testDataProvider as [CustomerData] in [Customer] format.
 */
object CustomerData : TestDataAT<Customer>(Customer::class.java) {

    override var atMarkerPredicate: (Customer) -> Boolean = { it.fullName.endsWith(AT_POSTFIX_RUS_PARENTHESES) }

    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM customer") }
    override val dataFileName: String = "customer.json"

    override var removeRecord: ((Customer) -> Unit)? = { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.id!!) }

    private val customerTypeData by lazy { CustomerTypeData.get() }
    private val customerKppData by lazy { CustomerKppData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbCustomerInfoMap ->
            dbCustomerInfoMap.apply {

                dbCustomerInfoMap["customerType"] = customerTypeData
                    .first { it.id == dbCustomerInfoMap["id_customer_type"] }
                dbCustomerInfoMap["kpp"] = customerKppData
                    .filter { it.idCustomer == dbCustomerInfoMap["id"] }

                val addressRegistration = Address(
                    addressType = dbCustomerInfoMap["add_reg_address_type"] as String,
                    ruAddress = RuAddress(
                        countryDigitCode = dbCustomerInfoMap["add_reg_russian_country_digit_code"] as String?,
                        index = dbCustomerInfoMap["add_reg_russian_c_index"] as String?,
                        regionCode = dbCustomerInfoMap["add_reg_russian_region_code"] as String?,
                        district = dbCustomerInfoMap["add_reg_russian_district"] as String?,
                        city = dbCustomerInfoMap["add_reg_russian_city"] as String?,
                        inhabitedLocality = dbCustomerInfoMap["add_reg_russian_inhabited_locality"] as String?,
                        street = dbCustomerInfoMap["add_reg_russian_street"] as String?,
                        houseNumber = dbCustomerInfoMap["add_reg_russian_house_number"] as String?,
                        housingNumber = dbCustomerInfoMap["add_reg_russian_housing_number"] as String?,
                        buildingNumber = dbCustomerInfoMap["add_reg_russian_building_number"] as String?,
                        apartmentNumber = dbCustomerInfoMap["add_reg_russian_apartment_number"] as String?,
                        roomNumber = dbCustomerInfoMap["add_reg_russian_room_number"] as String?,
                        fullAddress = dbCustomerInfoMap["add_reg_russian_full_address"] as String?,
                    ),
                    foreignAddress = ForeignAddress(
                        countryDigitCode = dbCustomerInfoMap["add_reg_foreign_country_digit_code"] as String?,
                        index = dbCustomerInfoMap["add_reg_foreign_c_index"] as String?,
                        state = dbCustomerInfoMap["add_reg_foreign_state"] as String?,
                        city = dbCustomerInfoMap["add_reg_foreign_city"] as String?,
                        address = dbCustomerInfoMap["add_reg_foreign_district"] as String?,
                    )
                )
                dbCustomerInfoMap["addressRegistration"] = addressRegistration

                val addressLocation = Address(
                    addressType = dbCustomerInfoMap["add_loc_address_type"] as String,
                    ruAddress = RuAddress(
                        countryDigitCode = dbCustomerInfoMap["add_loc_russian_country_digit_code"] as String?,
                        index = dbCustomerInfoMap["add_loc_russian_c_index"] as String?,
                        regionCode = dbCustomerInfoMap["add_loc_russian_region_code"] as String?,
                        district = dbCustomerInfoMap["add_loc_russian_district"] as String?,
                        city = dbCustomerInfoMap["add_loc_russian_city"] as String?,
                        inhabitedLocality = dbCustomerInfoMap["add_loc_russian_inhabited_locality"] as String?,
                        street = dbCustomerInfoMap["add_loc_russian_street"] as String?,
                        houseNumber = dbCustomerInfoMap["add_loc_russian_house_number"] as String?,
                        housingNumber = dbCustomerInfoMap["add_loc_russian_housing_number"] as String?,
                        buildingNumber = dbCustomerInfoMap["add_loc_russian_building_number"] as String?,
                        apartmentNumber = dbCustomerInfoMap["add_loc_russian_apartment_number"] as String?,
                        roomNumber = dbCustomerInfoMap["add_loc_russian_room_number"] as String?,
                        fullAddress = dbCustomerInfoMap["add_loc_russian_full_address"] as String?,
                    ),
                    foreignAddress = ForeignAddress(
                        countryDigitCode = dbCustomerInfoMap["add_loc_foreign_country_digit_code"] as String?,
                        index = dbCustomerInfoMap["add_loc_foreign_c_index"] as String?,
                        state = dbCustomerInfoMap["add_loc_foreign_state"] as String?,
                        city = dbCustomerInfoMap["add_loc_foreign_city"] as String?,
                        address = dbCustomerInfoMap["add_loc_foreign_district"] as String?,
                    )
                )
                dbCustomerInfoMap["addressLocation"] = addressLocation
            }
        }

    fun searchBy(account: Account): Customer {
        val accountBranchCustomer = BranchCustomerData.get { account.branchCustomerId == it.id }.first()
        val accountCustomerId = accountBranchCustomer.customerId
        return get { accountCustomerId == it.id }.first()
    }

    fun searchBy(accountNumber: String): Customer = searchBy(AccountData.searchBy(accountNumber))

    fun searchBy(vararg branchesIds: UUID): List<Customer> {
        val relatedCustomersIds = BranchCustomerData.searchByBranchesIds(*branchesIds).map { it.customerId }
        return get { it.id!! in relatedCustomersIds }
    }

    /**
     * Find available Customers for user.
     * * Customer is available to BANK USER if Customer's id is present in BranchCustomer record,
     * (related to BankRepresentative record,) related to user
     * * Customer is available to CLIENT USER if Customer's id is present in ClientRepresentative record, related to user
     */
    fun searchBy(user: User, customerType: CustomerType? = null, seekAtCreated: Boolean? = null): List<Customer> {
        val availableCustomersIds: List<UUID> =
            when (user.userType) {
                UserType.BANK -> {
                    val availableBranchesIds = BranchRepresentativeData.searchBy(user).map { it.branchId!! }
                    BranchCustomerData.searchByBranchesIds(*availableBranchesIds.toTypedArray()).map { it.customerId }
                }
                UserType.CLIENT -> CustomerRepresentativeData.searchBy(user).map { it.customerId!! }
                else -> throw RuntimeException("Unexpected user type: ${user.userType}")
            }

        return get(seekAtCreated = seekAtCreated) { it.id!! in availableCustomersIds }
            .filter { customerType?.let { it.id == customerType.id  } ?: true }
    }

    @Step("Найти или создать запись ${DictionaryNames.CUSTOMER} для {user.login}")
    fun getOrCreate(
        user: User,
        customerType: CustomerType = CustomerTypeData.randomOrException(),
        additionalFilter: (Customer) -> Boolean = { true }
    ): Customer {
        return getOrCreate(
            { searchBy(user, customerType).filter(additionalFilter).filter { FindCustomerBy.WITH_KPP.predicate.invoke(it) } },
            {
                CustomerPrepareSteps.createCustomerDto(
                    customerUser = user,
                    withBranchCustomer = true,
                    withCustomerRepresentative = true,
                    withLocAddress = true,
                    withRegAddress = true,
                    withKpp = true,
                    withAccount = true
                ).toModel()
            }
        )
    }

    @Step("Получить id клиентов банка, с которыми связаны каждый из пользователей ({firstUser.login}, {secondUser.login})")
    fun getCommonCustomersIds(firstUser: User, secondUser: User): Set<UUID>? {
        val firstCustomerIds = searchBy(firstUser).map { it.id!! }
        val secondCustomerIds = searchBy(secondUser).map { it.id!! }
        return firstCustomerIds.intersect(secondCustomerIds).ifEmpty { null }
    }

    @Step("Найти существующего клиента банка, общего для пользователей ({firstUser.login}, {secondUser.login}), или создать нового")
    fun getOrCreateCommonCustomersId(firstUser: User, secondUser: User): UUID {
        return getCommonCustomersIds(firstUser, secondUser)?.random()
            ?: {
                val clientRelatedCustomer = getOrCreate(firstUser)
                if (secondUser.isClient) {
                    CustomerPrepareSteps.ensureClientUserIsRelatedToCustomer(secondUser, clientRelatedCustomer.id!!)
                } else {
                    CustomerPrepareSteps.ensureBankUserIsRelatedToCustomer(secondUser, clientRelatedCustomer.id!!)
                }
                clientRelatedCustomer.id!!
            }.invoke()
    }
}


/**
 * Enum for searching [Customer] in [CustomerData]
 */
enum class FindCustomerBy(override var predicate: (Customer) -> Boolean) :
    FindEntityBy<Customer, CustomerData> {

    AT_CREATED(predicate = CustomerData.atMarkerPredicate),
    WITH_KPP(predicate = { it.kpp.isNotEmpty() })
}



