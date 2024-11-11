package ooo.jtc.testdata.dictionaries.account

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.common.extid.ExtId
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * AccountExtId data, that loaded from testDataProvider as [AccountExtIdData] in [ExtId] format.
 */
object AccountExtIdData : TestDataAT<ExtId>(ExtId::class.java) {
    override var atMarkerPredicate: (ExtId) -> Boolean = { it.externalId.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM account_ext_ref") }
    override val dataFileName = "accountExtId.json"

    override var removeRecord: ((ExtId) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating Account!") }
}