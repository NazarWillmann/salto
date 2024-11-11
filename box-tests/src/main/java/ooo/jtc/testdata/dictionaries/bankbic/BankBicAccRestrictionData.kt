package ooo.jtc.testdata.dictionaries.bankbic

import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * BankBicAccRestrictionData data, that loaded from testDataProvider as [BankBicAccRestrictionData] in [BankBicAccRestriction] format.
 */
object BankBicAccRestrictionData : TestData<BankBicAccRestriction>(BankBicAccRestriction::class.java) {
    //All actions regarding BankBicAccRestrictions must be conducted via BankBic import
    override var atMarkerPredicate: (BankBicAccRestriction) -> Boolean = { false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_acc_restr") }
    override val dataFileName = "bankBicAccRestriction.json"

    override var removeRecord: ((BankBicAccRestriction) -> Unit)? = null
        get() { throw RuntimeException("This dictionary can be updated only by importing BankBic-file!") }
}