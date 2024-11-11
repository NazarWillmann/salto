package ooo.jtc.testdata.dictionaries.okfs

import ooo.jtc.api.dictionaries.okfs.OkfsPrepareSteps
import ooo.jtc.api.dictionaries.okfs.OkfsSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.okfs.Okfs
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * OkfsData data, that loaded from testDataProvider as [OkfsData] in [Okfs] format.
 */
object OkfsData : TestData<Okfs>(Okfs::class.java) {
    override var atMarkerPredicate: (Okfs) -> Boolean = { it.description.endsWith(TestConstants.AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM okfs") }
    override val dataFileName = "okfs.json"

    override var createRecord: (() -> Okfs)? = null
        get() = {
            val preparedDto = OkfsPrepareSteps.getOkfsDtoForCreate()
            OkfsSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((Okfs) -> Unit)? = { OkfsSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [Okfs] in [OkfsData]
 */
enum class FindOkfsBy(override var predicate: (Okfs) -> Boolean) :
    FindEntityBy<Okfs, OkfsData> {

    AT_CREATED(OkfsData.atMarkerPredicate),
    ;
}
