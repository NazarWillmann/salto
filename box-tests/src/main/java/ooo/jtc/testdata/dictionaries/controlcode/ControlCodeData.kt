package ooo.jtc.testdata.dictionaries.controlcode

import ooo.jtc.api.dictionaries.controlcode.ControlCodePrepareSteps
import ooo.jtc.api.dictionaries.controlcode.ControlCodeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.controlcode.ControlCode
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * ControlCode data, that loaded from testDataProvider as [ControlCodeData] in [ControlCode] format.
 */
object ControlCodeData : TestData<ControlCode>(ControlCode::class.java) {
    override var atMarkerPredicate: (ControlCode) -> Boolean = { it.description?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM control_code") }
    override val dataFileName = "controlCode.json"

    override var createRecord: (() -> ControlCode)? = null
        get() = {
            val preparedDto = ControlCodePrepareSteps.getControlCodeDtoForCreate()
            ControlCodeSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((ControlCode) -> Unit)? = { ControlCodeSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [ControlCode] in [ControlCodeData]
 */
enum class FindControlCodeBy(override var predicate: (ControlCode) -> Boolean) :
    FindEntityBy<ControlCode, ControlCodeData> {

    AT_CREATED(ControlCodeData.atMarkerPredicate),
    ;
}