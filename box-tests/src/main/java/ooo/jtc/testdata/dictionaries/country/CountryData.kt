package ooo.jtc.testdata.dictionaries.country

import ooo.jtc.api.dictionaries.country.CountryPrepareSteps
import ooo.jtc.api.dictionaries.country.CountrySteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.country.Country
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData


/**
 * Country data, that loaded from testDataProvider as [CountryData] in [Country] format.
 */
object CountryData : TestData<Country>(Country::class.java) {
    override var atMarkerPredicate: (Country) -> Boolean = { it.shortName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM country") }
    override val dataFileName: String = "country.json"

    override var createRecord: (() -> Country)? = null
        get() = {
            val preparedDto = CountryPrepareSteps.getCountryDtoForCreate()
            CountrySteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((Country) -> Unit)? = { CountrySteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [Country] in [CountryData]
 */
enum class FindCountryBy(override var predicate: (Country) -> Boolean) : FindEntityBy<Country, CountryData> {

    AT_CREATED(CountryData.atMarkerPredicate),
    ;
}
