package ooo.jtc.testdata.dictionaries.ndscalculation

import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationPrepareSteps
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.ndscalculation.NdsCalculation
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * NdsCalculation data, that loaded from testDataProvider as [NdsCalculationData] in [NdsCalculation] format.
 */
object NdsCalculationData : TestData<NdsCalculation>(NdsCalculation::class.java) {
    override var atMarkerPredicate: (NdsCalculation) -> Boolean = { it.description.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM nds_calculation") }
    override val dataFileName = "ndsCalculation.json"

    override var createRecord: (() -> NdsCalculation)? = null
        get() = { NdsCalculationPrepareSteps.createNdsCalculationDto().toModel() }

    override var removeRecord: ((NdsCalculation) -> Unit)? = { NdsCalculationSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [NdsCalculation] in [NdsCalculationData]
 */
enum class FindNdsCalculationBy(override var predicate: (NdsCalculation) -> Boolean) :
    FindEntityBy<NdsCalculation, NdsCalculationData> {

    AT_CREATED(NdsCalculationData.atMarkerPredicate),
    ;
}