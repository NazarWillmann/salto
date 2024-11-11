package ooo.jtc.testdata.dictionaries.branch

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.common.extid.ExtId
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * BranchExtId data, that loaded from testDataProvider as [BranchExtIdData] in [ExtId] format.
 */
object BranchExtIdData : TestDataAT<ExtId>(ExtId::class.java) {
    override var atMarkerPredicate: (ExtId) -> Boolean = { it.externalId.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM branch_ext_ref") }
    override val dataFileName = "branchExtId.json"

    override var removeRecord: ((ExtId) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating Branch!") }
}