package ooo.jtc.testdata.dictionaries.bankbic

import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * BankBicAccountData data, that loaded from testDataProvider as [BankBicAccountData] in [BankBicAccount] format.
 */
object BankBicAccountData : TestData<BankBicAccount>(BankBicAccount::class.java) {
    //All actions regarding BankBicAccounts must be conducted via BankBic import
    override var atMarkerPredicate: (BankBicAccount) -> Boolean = { false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_account") }
    override val dataFileName = "bankBicAccount.json"

    override var removeRecord: ((BankBicAccount) -> Unit)? = null
        get() { throw RuntimeException("This dictionary can be updated only by importing BankBic-file!") }



    private val bankBicAccRestrictionData by lazy { BankBicAccRestrictionData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbBankBicAccountMap ->
            dbBankBicAccountMap.apply {
                dbBankBicAccountMap["restrictions"] = bankBicAccRestrictionData
                    .filter { it.accountId == dbBankBicAccountMap["id"] }
            }
        }
}