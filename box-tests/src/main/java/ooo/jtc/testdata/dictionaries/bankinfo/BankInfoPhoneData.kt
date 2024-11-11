package ooo.jtc.testdata.dictionaries.bankinfo

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

/**
 * BankInfoPhone data, that loaded from testDataProvider as [BankInfoPhoneData] in [PhoneInfo] format.
 */
object BankInfoPhoneData : TestDataAT<PhoneInfo>(PhoneInfo::class.java) {
    override var atMarkerPredicate: (PhoneInfo) -> Boolean = { it.phone.endsWith(TestConstants.AT_NUM) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_phone") }
    override val dataFileName = "bankPhoneInfo.json"

    override var removeRecord: ((PhoneInfo) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating BankInfo!") }
}