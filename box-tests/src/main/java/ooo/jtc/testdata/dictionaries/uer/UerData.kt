package ooo.jtc.testdata.dictionaries.uer

import ooo.jtc.api.dictionaries.uer.UerPrepareSteps
import ooo.jtc.api.dictionaries.uer.UerSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.uer.Uer
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * UerData data, that loaded from testDataProvider as [UerData] in [Uer] format.
 */
object UerData : TestData<Uer>(Uer::class.java) {
    override var atMarkerPredicate: (Uer) -> Boolean = { it.description.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM uer") }
    override val dataFileName = "uer.json"

    override var createRecord: (() -> Uer)? = null
        get() = { UerPrepareSteps.createUerDto().toModel() }

    override var removeRecord: ((Uer) -> Unit)? = { UerSteps(Users.superUser).delete(it.id!!) }

}

/**
 * Enum for searching [Uer] in [UerData]
 */
enum class FindUerBy(override var predicate: (Uer) -> Boolean) :
    FindEntityBy<Uer, UerData> {

    AT_CREATED(UerData.atMarkerPredicate),
    ;
}