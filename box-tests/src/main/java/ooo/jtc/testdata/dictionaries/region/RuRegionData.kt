package ooo.jtc.testdata.dictionaries.region

import ooo.jtc.api.dictionaries.region.RuRegionPrepareSteps
import ooo.jtc.api.dictionaries.region.RuRegionSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.region.RuRegion
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * Russian Federation Region data, that loaded from testDataProvider as [RuRegionData] in [RuRegion] format.
 */
object RuRegionData : TestData<RuRegion>(RuRegion::class.java) {
    override var atMarkerPredicate: (RuRegion) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM region") }
    override val dataFileName = "region.json"

    override var createRecord: (() -> RuRegion)? = null
        get() = { RuRegionPrepareSteps.createRuRegionDto().toModel() }

    override var removeRecord: ((RuRegion) -> Unit)? = { RuRegionSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [RuRegion] in [RuRegionData]
 */
enum class FindRuRegionBy(override var predicate: (RuRegion) -> Boolean) :
    FindEntityBy<RuRegion, RuRegionData> {

    AT_CREATED(RuRegionData.atMarkerPredicate),
    ;
}
