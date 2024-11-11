package ooo.jtc.testdata.uaa.resource

import ooo.jtc.api.uaa.prepare.ResourcePrepareSteps
import ooo.jtc.api.uaa.steps.ResourceSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.testdata.common.random
import ooo.jtc.uaa.resource.model.Resource

/**
 * Resource data, that loaded from testDataProvider as [TestDataProvider] in [Resource] format.
 */
object ResourceData : TestData<Resource>(Resource::class.java) {
    override var atMarkerPredicate: (Resource) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.OAUTH.db.execSql("SELECT * FROM OAUTH_RESOURCE") }
    override val dataFileName = "resource.json"

    fun searchBy(findBy: FindResourceBy) = findBy.random()

    override var createRecord: (() -> Resource)? = { ResourcePrepareSteps.createResourceDto().toModel() }
    override var removeRecord: ((Resource) -> Unit)? = { ResourceSteps().delete(it.id!!) }

}


/**
 * Enum for searching [Resource] in [ResourceData]
 */
enum class FindResourceBy(override var predicate: (Resource) -> Boolean) : FindEntityBy<Resource, ResourceData> {
    AT_CREATED(ResourceData.atMarkerPredicate),
}