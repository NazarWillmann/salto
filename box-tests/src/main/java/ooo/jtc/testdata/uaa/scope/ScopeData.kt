package ooo.jtc.testdata.uaa.scope

import ooo.jtc.api.uaa.prepare.PrepareScopeData
import ooo.jtc.api.uaa.steps.ScopeSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.testdata.common.random
import ooo.jtc.uaa.scope.model.Scope

/**
 * Scope data, that loaded from testDataProvider as [TestDataProvider] in [Scope] format.
 */
object ScopeData : TestData<Scope>(Scope::class.java) {
    override var atMarkerPredicate: (Scope) -> Boolean = { it.description?.endsWith(TestConstants.AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.OAUTH.db.execSql("SELECT * FROM OAUTH_SCOPE") }
    override val dataFileName = "scope.json"

    fun searchBy(findBy: FindScopeBy) = findBy.random()

    override var createRecord: (() -> Scope)? = { ScopeSteps().create(PrepareScopeData.prepareScopeDtoForCreate()).data!!.toModel() }
    override var removeRecord: ((Scope) -> Unit)? = { ScopeSteps().delete(it.id!!) }
}


/**
 * Enum for searching [Scope] in [ScopeData]
 */
enum class FindScopeBy(override var predicate: (Scope) -> Boolean) : FindEntityBy<Scope, ScopeData> {
    AT_CREATED(ScopeData.atMarkerPredicate),
}