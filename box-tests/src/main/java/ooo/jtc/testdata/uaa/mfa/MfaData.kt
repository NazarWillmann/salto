package ooo.jtc.testdata.uaa.mfa

import ooo.jtc.api.uaa.prepare.PrepareMfaData
import ooo.jtc.api.uaa.steps.MfaSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.testdata.common.random
import ooo.jtc.uaa.mfa.model.Mfa

/**
 * Mfa data, that loaded from testDataProvider as [TestDataProvider] in [Mfa] format.
 */
object MfaData : TestData<Mfa>(Mfa::class.java) {
    override var atMarkerPredicate: (Mfa) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.OAUTH.db.execSql("SELECT * FROM OAUTH_MFA") }
    override val dataFileName = "mfa.json"

    fun searchBy(findBy: FindMfaBy) = findBy.random()

    override var createRecord: (() -> Mfa)? = { MfaSteps().create(PrepareMfaData.prepareMfaDtoForCreate()).data!!.toModel() }
    override var removeRecord: ((Mfa) -> Unit)? = { MfaSteps().delete(it.id!!) }
}


/**
 * Enum for searching [Mfa] in [MfaData]
 */
enum class FindMfaBy(override var predicate: (Mfa) -> Boolean) : FindEntityBy<Mfa, MfaData> {
    AT_CREATED(MfaData.atMarkerPredicate),
}