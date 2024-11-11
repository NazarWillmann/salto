package ooo.jtc.testdata.dictionaries.okopf

import ooo.jtc.api.dictionaries.okopf.OkopfPrepareSteps
import ooo.jtc.api.dictionaries.okopf.OkopfSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.okopf.Okopf
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * OkopfData data, that loaded from testDataProvider as [OkopfData] in [Okopf] format.
 */
object OkopfData : TestData<Okopf>(Okopf::class.java) {
    override var atMarkerPredicate: (Okopf) -> Boolean = { it.description.endsWith(TestConstants.AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM okopf") }
    override val dataFileName = "okopf.json"

    override var createRecord: (() -> Okopf)? = null
        get() = {
            val preparedDto = OkopfPrepareSteps.getOkopfDtoForCreate()
            OkopfSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((Okopf) -> Unit)? = { OkopfSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [Okopf] in [OkopfData]
 */
enum class FindOkopfBy(override var predicate: (Okopf) -> Boolean) :
    FindEntityBy<Okopf, OkopfData> {

    AT_CREATED(OkopfData.atMarkerPredicate),
    ;
}
