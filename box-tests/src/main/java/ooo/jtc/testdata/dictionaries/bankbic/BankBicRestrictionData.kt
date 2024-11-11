package ooo.jtc.testdata.dictionaries.bankbic

import ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * BankBicRestrictionData data, that loaded from testDataProvider as [BankBicRestrictionData] in [BankBicRestriction] format.
 */
object BankBicRestrictionData : TestData<BankBicRestriction>(BankBicRestriction::class.java) {
    //All actions regarding BankBicRestrictions must be conducted via BankBic import
    override var atMarkerPredicate: (BankBicRestriction) -> Boolean = { false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_restr") }
    override val dataFileName = "bankBicRestriction.json"

    override var removeRecord: ((BankBicRestriction) -> Unit)? = null
        get() { throw RuntimeException("This dictionary can be updated only by importing BankBic-file!") }
}