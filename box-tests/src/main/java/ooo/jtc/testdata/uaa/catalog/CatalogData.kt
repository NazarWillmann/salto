package ooo.jtc.testdata.uaa.catalog

import ooo.jtc.api.uaa.prepare.PrepareCatalogData.prepareCatalogDtoForCreate
import ooo.jtc.api.uaa.steps.CatalogSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.testdata.common.random
import ooo.jtc.uaa.catalog.model.Catalog

/**
 * Catalog data, that loaded from testDataProvider as [TestDataProvider] in [Catalog] format.
 */
object CatalogData : TestData<Catalog>(Catalog::class.java) {
    override var atMarkerPredicate: (Catalog) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.OAUTH.db.execSql("SELECT * FROM OAUTH_CAT") }
    override val dataFileName = "catalog.json"

    fun searchBy(findBy: FindCatalogBy) = findBy.random()

    override var createRecord: (() -> Catalog)? = { CatalogSteps().create(prepareCatalogDtoForCreate()).data!!.toModel() }
    override var removeRecord: ((Catalog) -> Unit)? = { CatalogSteps().delete(it.id!!) }
}


/**
 * Enum for searching [Catalog] in [CatalogData]
 */
enum class FindCatalogBy(override var predicate: (Catalog) -> Boolean) : FindEntityBy<Catalog, CatalogData> {
    AT_CREATED(CatalogData.atMarkerPredicate),
}