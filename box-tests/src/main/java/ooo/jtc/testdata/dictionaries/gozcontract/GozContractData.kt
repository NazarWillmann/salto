package ooo.jtc.testdata.dictionaries.gozcontract

import ooo.jtc.api.dictionaries.gozcontract.GozContractPrepareSteps
import ooo.jtc.api.dictionaries.gozcontract.GozContractSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.gozcontract.GozContract
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestData

object GozContractData : TestData<GozContract>(GozContract::class.java) {

    override var atMarkerPredicate: (GozContract) -> Boolean = { it.number.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = {
        Services.DICTIONARY.db.execSql(
            "SELECT * FROM goz_contract"
        )
    }
    override val dataFileName = "gozcontract.json"

    override var createRecord: (() -> GozContract)? = null
        get() = { GozContractPrepareSteps.createGozContractDto().toModel() }

    override var removeRecord: ((GozContract) -> Unit)? = { GozContractSteps(Users.superUser).delete(it.id!!) }
}