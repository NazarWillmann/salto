package ooo.jtc.testdata.dictionaries.bankinfo

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrl
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * BankInfoPhone data, that loaded from testDataProvider as [BankInfoApplicationUrlData] in [BankInfoApplicationUrl] format.
 */
object BankInfoApplicationUrlData : TestDataAT<BankInfoApplicationUrl>(BankInfoApplicationUrl::class.java) {
    override var atMarkerPredicate: (BankInfoApplicationUrl) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_application_url") }
    override val dataFileName = "bankInfoApplicationUrl.json"

    override var removeRecord: ((BankInfoApplicationUrl) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating BankInfo!") }
}