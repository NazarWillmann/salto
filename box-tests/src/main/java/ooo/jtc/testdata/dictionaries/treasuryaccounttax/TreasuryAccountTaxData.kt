package ooo.jtc.testdata.dictionaries.treasuryaccounttax

import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.getTreasuryAccountTaxDtoForCreate
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxSteps
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTax
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users.autotest
import ooo.jtc.testdata.common.TestData

object TreasuryAccountTaxData : TestData<TreasuryAccountTax>(TreasuryAccountTax::class.java) {
    override var atMarkerPredicate: (TreasuryAccountTax) -> Boolean = { it.tofk!!.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM treasury_account_tax") }
    override val dataFileName: String = "treasuryAccountTax.json"

    override var createRecord: (() -> TreasuryAccountTax)? = null
        get() = {
            val treasuryAccountTaxDto = getTreasuryAccountTaxDtoForCreate(textFieldGenerator = RandomData.ruWords)
            TreasuryAccountTaxSteps(user = autotest).create(treasuryAccountTaxDto).data!!.toModel()
        }

    override var removeRecord: ((TreasuryAccountTax) -> Unit)? = { treasuryAccountTax ->
        TreasuryAccountTaxSteps(user = autotest).delete(treasuryAccountTax.id!!)
    }
}