package ooo.jtc.testdata.dictionaries.bankinfo

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrl
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * BankInfoPhone data, that loaded from testDataProvider as [BankInfoSocialUrlData] in [BankInfoSocialUrl] format.
 */
object BankInfoSocialUrlData : TestDataAT<BankInfoSocialUrl>(BankInfoSocialUrl::class.java) {
    override var atMarkerPredicate: (BankInfoSocialUrl) -> Boolean = { it.socialUrl.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_social_url") }
    override val dataFileName = "bankInfoSocialUrl.json"

    override var removeRecord: ((BankInfoSocialUrl) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating BankInfo!") }
}