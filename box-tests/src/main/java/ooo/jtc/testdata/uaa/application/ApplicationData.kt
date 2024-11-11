package ooo.jtc.testdata.uaa.application

import ooo.jtc.api.uaa.prepare.ApplicationPrepareSteps
import ooo.jtc.api.uaa.steps.ApplicationSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.testdata.common.random
import ooo.jtc.uaa.application.dto.AllowedFlows
import ooo.jtc.uaa.application.model.Application
import ooo.jtc.uaa.application.model.ApplicationName.BANK
import ooo.jtc.uaa.application.model.ApplicationName.CLIENT
import ooo.jtc.uaa.application.model.ApplicationName.INDIVIDUAL
import ooo.jtc.uaa.application.model.ApplicationName.SERVER
import ooo.jtc.uaa.application.model.ApplicationName.SOME

/**
 * Application data, that loaded from testDataProvider as [TestDataProvider] in [Application] format.
 */
object ApplicationData : TestData<Application>(Application::class.java) {
    override var atMarkerPredicate: (Application) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.OAUTH.db.execSql("SELECT * FROM oauth_app") }

    private val appAuthFlow by lazy { Services.OAUTH.db.execSql("SELECT * FROM app_auth_flow") }
    private val oauthAppRes by lazy { Services.OAUTH.db.execSql("SELECT * FROM oauth_app_res") }
    private val oauthAppCat by lazy { Services.OAUTH.db.execSql("SELECT * FROM oauth_app_cat") }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbApplicationMap ->
            dbApplicationMap.apply {
                val appId = dbApplicationMap["id"].toString()
                val predicate: (MutableMap<String, Any>) -> Boolean = { it["id_application"].toString() == appId }

                dbApplicationMap["allowedFlows"] = appAuthFlow
                    .filter(predicate)
                    .map { AllowedFlows.valueOf(it["auth_flow"].toString()) }.toList()

                dbApplicationMap["availableResources"] = oauthAppRes
                    .filter(predicate)
                    .map { it["id_resource"] }.toList()

                dbApplicationMap["availableCatalogs"] = oauthAppCat
                    .filter(predicate)
                    .map { it["id_catalog"] }.toList()
            }
        }

    override val dataFileName = "application.json"

    fun searchBy(findBy: FindApplicationBy) = findBy.random()

    override var createRecord: (() -> Application)? = { ApplicationPrepareSteps.createTestDto().toModel() }
    override var removeRecord: ((Application) -> Unit)? = { ApplicationSteps().delete(it.id!!) }

}


/**
 * Enum for searching [Application] in [ApplicationData]
 */
enum class FindApplicationBy(override var predicate: (Application) -> Boolean) :
    FindEntityBy<Application, ApplicationData> {
    AT_CREATED(ApplicationData.atMarkerPredicate),
    CUSTOMER_PORTAL({ app: Application -> CLIENT.value == app.name }),
    BANK_PORTAL({ app: Application -> BANK.value == app.name }),
    INDIVIDUAL_PORTAL({ app: Application -> INDIVIDUAL.value == app.name }),
    SERVER_PORTAL({ app: Application -> SERVER.value == app.name }),
    SOME_PORTAL({ app: Application -> SOME.value == app.name });

}



