package ooo.jtc.testdata.dictionaries.bankbic

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.bankbic.BankBic
import ooo.jtc.extensions.getOrException
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * BankBicData data, that loaded from testDataProvider as [BankBicData] in [BankBic] format.
 */
object BankBicData : TestData<BankBic>(BankBic::class.java) {
    override var atMarkerPredicate: (BankBic) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_bic") }
    override val dataFileName = "bankBic.json"

    override var removeRecord: ((BankBic) -> Unit)? = null
        get() { throw RuntimeException("This dictionary can be updated only by importing BankBic-file!") }



    private val bankBicAccountData by lazy { BankBicAccountData.get() }
    private val bankBicRestrictionData by lazy { BankBicRestrictionData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbBankBicMap ->
            dbBankBicMap.apply {
                dbBankBicMap["accounts"] = bankBicAccountData
                    .filter { it.bicId == dbBankBicMap["id"] }
                dbBankBicMap["restrictions"] = bankBicRestrictionData
                    .filter { it.bicId == dbBankBicMap["id"] }
            }
        }

    fun searchBy(bic: String): BankBic {
        //'bic' is unique
        return get { bic == it.bic }.firstOrNull()
            .getOrException("There is no BankBic with bic = '$bic'!")
    }
}