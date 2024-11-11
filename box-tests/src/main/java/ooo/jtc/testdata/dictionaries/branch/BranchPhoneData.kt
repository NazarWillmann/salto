package ooo.jtc.testdata.dictionaries.branch

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * BranchPhone data, that loaded from testDataProvider as [BranchPhoneData] in [PhoneInfo] format.
 */
object BranchPhoneData : TestDataAT<PhoneInfo>(PhoneInfo::class.java) {
    override var atMarkerPredicate: (PhoneInfo) -> Boolean = { it.phone.endsWith(TestConstants.AT_NUM) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM branch_phone") }
    override val dataFileName = "branchPhoneInfo.json"

    override var removeRecord: ((PhoneInfo) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating Branch!") }
}