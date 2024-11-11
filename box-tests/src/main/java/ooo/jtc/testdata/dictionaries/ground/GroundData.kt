package ooo.jtc.testdata.dictionaries.ground

import ooo.jtc.api.dictionaries.ground.GroundSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.ground.Ground
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT

/**
 * Ground data, that loaded from testDataProvider as [GroundData] in [Ground] format.
 */
object GroundData : TestDataAT<Ground>(Ground::class.java) {
    override var atMarkerPredicate: (Ground) -> Boolean = { it.description?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM ground") }
    override val dataFileName = "ground.json"

    override var removeRecord: ((Ground) -> Unit)? = { GroundSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [Ground] in [GroundData]
 */
enum class FindGroundBy(override var predicate: (Ground) -> Boolean) :
    FindEntityBy<Ground, GroundData> {

    AT_CREATED(GroundData.atMarkerPredicate),
    ;
}