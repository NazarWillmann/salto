package ooo.jtc.testdata.dictionaries.bankinfo

import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.bankinfo.BankInfo
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.util.UUID

/**
 * BankInfo data, that loaded from testDataProvider as [BankInfoData] in [BankInfo] format.
 */
object BankInfoData : TestDataAT<BankInfo>(BankInfo::class.java) {
    override var atMarkerPredicate: (BankInfo) -> Boolean = { it.fullName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_info") }
    override val dataFileName = "bankInfo.json"

    override var removeRecord: ((BankInfo) -> Unit)? = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.id!!) }

    private val bankPhoneData by lazy { BankInfoPhoneData.get() }
    private val bankSocialUrlData by lazy { BankInfoSocialUrlData.get() }
    private val bankApplicationUrlData by lazy { BankInfoApplicationUrlData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbBankInfoMap ->
            dbBankInfoMap.apply {
                dbBankInfoMap["phoneSupports"] = bankPhoneData
                    .filter { it.ownerId!! == dbBankInfoMap["id"] }
                dbBankInfoMap["socialUrls"] = bankSocialUrlData
                    .filter { it.bankId!! == dbBankInfoMap["id"] }
                dbBankInfoMap["applicationUrls"] = bankApplicationUrlData
                    .filter { it.bankId!! == dbBankInfoMap["id"] }
            }
        }

    /**
     * Find available [BankInfo]s for [user].
     * * BankInfo is available to BANK USER if [BankInfo]'s id is present in BankRepresentative record, related to [user]
     * * BankInfo is available to CLIENT USER if [BankInfo]'s id is present in Branch record,
     * (related to BranchCustomer record, related to CustomerRepresentative record,) related to [user]
     */
    fun searchBy(user: User): List<BankInfo> {
        val availableBankInfosIds: List<UUID> =
            when (user.userType) {
                UserType.BANK -> ((BankRepresentativeData.searchBy(user).map { it.bankId!! }) + (BranchData.searchBy(user)
                    .map { it.bankId!! }).distinct())
                UserType.CLIENT -> BranchData.searchBy(user).map { it.bankId!! }.distinct()
                else -> throw RuntimeException("Unexpected user type: ${user.userType}")
            }
        if (availableBankInfosIds.isNotEmpty()) {
            return get(seekAtCreated = true)
            //according to the logic of the back end, if one bank is available, then all of them are available
        }
        return emptyList()
    }

    val nonAtCreatedBank by lazy { get(fromCache = true, seekAtCreated = false).first().toDto() }
}


/**
 * Enum for searching [BankInfo] in [BankInfoData]
 */
enum class FindBankInfoBy(override var predicate: (BankInfo) -> Boolean) :
    FindEntityBy<BankInfo, BankInfoData> {
    AT_CREATED(predicate = BankInfoData.atMarkerPredicate),
    ;
}