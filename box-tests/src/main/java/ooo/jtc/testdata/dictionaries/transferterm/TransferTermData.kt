package ooo.jtc.testdata.dictionaries.transferterm

import ooo.jtc.api.dictionaries.transferterm.TransferTermPrepareSteps.getTransferTermDtoForCreate
import ooo.jtc.api.dictionaries.transferterm.TransferTermSteps
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.transferterm.TransferTerm
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users.autotest
import ooo.jtc.testdata.common.TestData

object TransferTermData : TestData<TransferTerm>(TransferTerm::class.java) {
    override var atMarkerPredicate: (TransferTerm) -> Boolean = { it.code!!.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM transfer_term") }
    override val dataFileName: String = "transferTerm.json"

    override var createRecord: (() -> TransferTerm)? = null
        get() = {
            val transferTermDto = getTransferTermDtoForCreate(textFieldGenerator = RandomData.ruWords)
            TransferTermSteps(user = autotest).create(transferTermDto).data!!.toModel()
        }

    override var removeRecord: ((TransferTerm) -> Unit)? = {
        TransferTermSteps(user = autotest).delete(it.id!!)
    }
}