package ooo.jtc.testdata.dictionaries.currency

import ooo.jtc.api.dictionaries.currency.CurrencyPrepareSteps
import ooo.jtc.api.dictionaries.currency.CurrencySteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.currency.Currency
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * Currency data, that loaded from testDataProvider as [CurrencyData] in [Currency] format.
 */
object CurrencyData : TestData<Currency>(Currency::class.java) {
    override var atMarkerPredicate: (Currency) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM currency") }
    override val dataFileName = "currency.json"

    override var createRecord: (() -> Currency)? = null
        get() = {
            val prepCurrencyDto4Client = CurrencyPrepareSteps.getCurrencyDtoForCreate()
            CurrencySteps(Users.bankAdmin).create(prepCurrencyDto4Client).data!!.toModel()
        }

    override var removeRecord: ((Currency) -> Unit)? = { CurrencySteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [Currency] in [CurrencyData]
 */
enum class FindCurrencyBy(override var predicate: (Currency) -> Boolean) :
    FindEntityBy<Currency, CurrencyData> {

    AT_CREATED(CurrencyData.atMarkerPredicate),
    ;
}
