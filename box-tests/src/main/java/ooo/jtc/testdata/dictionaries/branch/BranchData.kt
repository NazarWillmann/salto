package ooo.jtc.testdata.dictionaries.branch

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.branch.Branch
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBic
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwift
import ooo.jtc.dictionaries.common.address.RuAddress
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.util.*

/**
 * Branch data, that loaded from testDataProvider as [BranchData] in [Branch] format.
 */
object BranchData : TestDataAT<Branch>(Branch::class.java) {
    override var atMarkerPredicate: (Branch) -> Boolean = { it.fullName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM branch") }
    override val dataFileName = "branch.json"

    override var removeRecord: ((Branch) -> Unit)? = { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.id!!) }

    private val branchExtIdData by lazy { BranchExtIdData.get() }
    private val branchPhoneData by lazy { BranchPhoneData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbBranchInfoMap ->
            dbBranchInfoMap.apply {
                dbBranchInfoMap["extIds"] = branchExtIdData
                    .filter { it.ownerId == dbBranchInfoMap["id"] }
                dbBranchInfoMap["phoneSupports"] = branchPhoneData
                    .filter { it.ownerId == dbBranchInfoMap["id"] }
                
                val addressLocation = RuAddress(
                    countryDigitCode = dbBranchInfoMap["add_loc_country_digit_code"] as String?,
                    index = dbBranchInfoMap["add_loc_c_index"] as String?,
                    regionCode = dbBranchInfoMap["add_loc_region_code"] as String?,
                    district = dbBranchInfoMap["add_loc_district"] as String?,
                    city = dbBranchInfoMap["add_loc_city"] as String?,
                    inhabitedLocality = dbBranchInfoMap["add_loc_inhabited_locality"] as String?,
                    street = dbBranchInfoMap["add_loc_street"] as String?,
                    houseNumber = dbBranchInfoMap["add_loc_house_number"] as String?,
                    housingNumber = dbBranchInfoMap["add_loc_housing_number"] as String?,
                    buildingNumber = dbBranchInfoMap["add_loc_building_number"] as String?,
                    apartmentNumber = dbBranchInfoMap["add_loc_apartment_number"] as String?,
                    roomNumber = dbBranchInfoMap["add_loc_room_number"] as String,
                    fullAddress = dbBranchInfoMap["add_loc_full_address"] as String,
                )
                dbBranchInfoMap["addressLocation"] = addressLocation

                val addressRegistration = RuAddress(
                    countryDigitCode = dbBranchInfoMap["add_reg_country_digit_code"] as String?,
                    index = dbBranchInfoMap["add_reg_c_index"] as String?,
                    regionCode = dbBranchInfoMap["add_reg_region_code"] as String?,
                    district = dbBranchInfoMap["add_reg_district"] as String?,
                    city = dbBranchInfoMap["add_reg_city"] as String?,
                    inhabitedLocality = dbBranchInfoMap["add_reg_inhabited_locality"] as String?,
                    street = dbBranchInfoMap["add_reg_street"] as String?,
                    houseNumber = dbBranchInfoMap["add_reg_house_number"] as String?,
                    housingNumber = dbBranchInfoMap["add_reg_housing_number"] as String?,
                    buildingNumber = dbBranchInfoMap["add_reg_building_number"] as String?,
                    apartmentNumber = dbBranchInfoMap["add_reg_apartment_number"] as String?,
                    roomNumber = dbBranchInfoMap["add_reg_room_number"] as String,
                    fullAddress = dbBranchInfoMap["add_reg_full_address"] as String,
                )
                dbBranchInfoMap["addressRegistration"] = addressRegistration

                val paymentDetailsBic = PaymentDetailsBic(
                    bic = dbBranchInfoMap["pd_bic_bic"] as String?,
                    corrAccount = dbBranchInfoMap["pd_bic_corr_account"] as String?,
                    bankName = dbBranchInfoMap["pd_bic_bank_name"] as String?,
                    bankPlace = dbBranchInfoMap["pd_bic_bank_place"] as String?
                )
                dbBranchInfoMap["paymentDetailsBic"] = paymentDetailsBic

                val paymentDetailsSwift = PaymentDetailsSwift(
                    swift = dbBranchInfoMap["pd_swift_swift"] as String?,
                    bankName = dbBranchInfoMap["pd_swift_bank_name"] as String?,
                    countryDigitCode = dbBranchInfoMap["pd_swift_country_digit_code"] as String?,
                    bankCity = dbBranchInfoMap["pd_swift_bank_city"] as String?,
                    bankAddress = dbBranchInfoMap["pd_swift_bank_address"] as String?
                )
                dbBranchInfoMap["paymentDetailsSwift"] = paymentDetailsSwift
            }
        }

    fun searchBy(account: Account): Branch {
        val accountBranchCustomer = BranchCustomerData.get { account.branchCustomerId == it.id }.first()
        val accountBranchId = accountBranchCustomer.branchId
        return get { accountBranchId == it.id }.first()
    }

    fun searchBy(accountNumber: String): Branch = searchBy(AccountData.searchBy(accountNumber))

    /**
     * Find available [Branch]es for [user].
     * * Branch is available to BANK USER if [Branch]'s id is present in BankRepresentative record, related to [user]
     * * Branch is available to CLIENT USER if [Branch]'s id is present in BranchCustomer record,
     * (related to CustomerRepresentative record,) related to [user]
     */
    fun searchBy(user: User, seekAtCreated: Boolean? = null): List<Branch> {
        val availableBranchesIds: List<UUID> =
            when (user.userType) {
                UserType.BANK -> BranchRepresentativeData.searchBy(user).map { it.branchId!! }.distinct()
                UserType.CLIENT -> BranchCustomerData.searchBy(user).map { it.branchId }.distinct()
                else -> throw RuntimeException("Unexpected user type: ${user.userType}")
            }

        return get(seekAtCreated = seekAtCreated) { it.id!! in availableBranchesIds }
    }

    @Step("Получить id подразделений, с которыми связан каждый из пользователей ({firstUser.login}, {secondUser.login})")
    fun getCommonBranchesIds(firstUser: User, secondUser: User): Set<UUID>? {
        val firstBranchesIds = searchBy(firstUser).map { it.id!! }
        val secondBranchesIds = searchBy(secondUser).map { it.id!! }
        return firstBranchesIds.intersect(secondBranchesIds).ifEmpty { null }
    }
}


/**
 * Enum for searching [Branch] in [BranchData]
 */
enum class FindBranchBy(override var predicate: (Branch) -> Boolean) :
    FindEntityBy<Branch, BranchData> {

    PARENT_BRANCH(predicate = { null == it.parentBranchId }),
    CHILD_BRANCH(predicate = { null != it.parentBranchId }),
    AT_CREATED(predicate = BranchData.atMarkerPredicate)
}