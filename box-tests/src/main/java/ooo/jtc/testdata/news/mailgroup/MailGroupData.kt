package ooo.jtc.testdata.news.mailgroup

import ooo.jtc.api.news.mailgroup.MailGroupSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.news.mailgroup.MailGroup
import ooo.jtc.scripts.soft
import ooo.jtc.serialization.convertToMap
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.uaa.user.StoredUserData
import ooo.jtc.uaa.User

/**
 * MailGroup dictionary data, that loaded from testDataProvider as [MailGroupData] in [MailGroup] format.
 */
object MailGroupData : TestDataAT<MailGroup>(MailGroup::class.java) {
    override var atMarkerPredicate: (MailGroup) -> Boolean = { it.name?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.NEWS.db.execSql("SELECT * FROM mail_group") }
    override val dataFileName = "mailGroup.json"

    override var removeRecord: ((MailGroup) -> Unit)? = { mailGroup ->
        soft {
            val creatorUser = StoredUserData.find { it.uaaUserId == mailGroup.createdUserId }
            MailGroupSteps(creatorUser).delete(mailGroup.id!!)
        }
    }

    private val customers by lazy { MailGroupCustomerData.get().map { it.convertToMap() } }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbMailGroupMap ->
            dbMailGroupMap.apply {
                dbMailGroupMap["customers"] = customers
                    .filter { it["id_mail_group"] == dbMailGroupMap["id"].toString() }
            }
        }

    fun searchBy(bankUser: User): List<MailGroup> {
        val availableBranches = BranchData.searchBy(bankUser)
            .map { it.id!! }
        return get { it.branchId!! in availableBranches }
    }
}


/**
 * Enum for searching [MailGroup] in [MailGroupData]
 */
enum class FindMailGroupBy(override var predicate: (MailGroup) -> Boolean) :
    FindEntityBy<MailGroup, MailGroupData> {

    AT_CREATED(MailGroupData.atMarkerPredicate),
    ;
}