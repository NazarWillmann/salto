package ooo.jtc.testdata.dictionaries.kbk

import ooo.jtc.api.dictionaries.kbk.KbkPrepareSteps
import ooo.jtc.api.dictionaries.kbk.KbkSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.kbk.Kbk
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * Kbk data, that loaded from testDataProvider as [KbkData] in [Kbk] format.
 */
object KbkData : TestData<Kbk>(Kbk::class.java) {
    override var atMarkerPredicate: (Kbk) -> Boolean = { it.description?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM kbk") }
    override val dataFileName = "kbk.json"

    override var createRecord: (() -> Kbk)? = { KbkPrepareSteps.createKbkDto().toModel() }

    override var removeRecord: ((Kbk) -> Unit)? = { KbkSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [Kbk] in [KbkData]
 */
enum class FindKbkBy(override var predicate: (Kbk) -> Boolean) :
    FindEntityBy<Kbk, KbkData> {

    AT_CREATED(KbkData.atMarkerPredicate),
    ;
}