package ooo.jtc.testdata.dictionaries.ndspercent

import ooo.jtc.api.dictionaries.ndspercent.NdsPercentPrepareSteps
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentSteps
import ooo.jtc.core.TestConstants.AT_PERCENTAGE
import ooo.jtc.dictionaries.ndspercent.NdsPercent
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * NdsPercent data, that loaded from testDataProvider as [NdsPercentData] in [NdsPercent] format.
 */
object NdsPercentData : TestData<NdsPercent>(NdsPercent::class.java) {
    override var atMarkerPredicate: (NdsPercent) -> Boolean = { it.percent.toString().startsWith(AT_PERCENTAGE.toString().take(3)) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM nds_percent") }
    override val dataFileName = "ndsPercent.json"

    override var createRecord: (() -> NdsPercent)? = null
        get() = { NdsPercentPrepareSteps.createNdsPercentDto().toModel() }

    override var removeRecord: ((NdsPercent) -> Unit)? = { NdsPercentSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [NdsPercent] in [NdsPercentData]
 */
enum class FindNdsPercentBy(override var predicate: (NdsPercent) -> Boolean) :
    FindEntityBy<NdsPercent, NdsPercentData> {

    AT_CREATED(NdsPercentData.atMarkerPredicate),
    ;
}