package ooo.jtc.testdata.dictionaries.agreement

import ooo.jtc.api.dictionaries.agreement.AgreementPrepareSteps
import ooo.jtc.api.dictionaries.agreement.AgreementSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.agreement.Agreement
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestData

object AgreementData : TestData<Agreement>(Agreement::class.java) {
    override var atMarkerPredicate: (Agreement) -> Boolean = { it.description!!.endsWith(TestConstants.AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM agreement") }
    override val dataFileName = "agreement.json"

    override var createRecord: (() -> Agreement)? =
        {
            val preparedDto = AgreementPrepareSteps.getAgreementDtoForCreate()
            AgreementSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }
}
