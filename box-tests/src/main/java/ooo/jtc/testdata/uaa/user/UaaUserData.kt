package ooo.jtc.testdata.uaa.user

import ooo.jtc.api.uaa.prepare.PrepareUaaUserData
import ooo.jtc.api.uaa.steps.UaaUserSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.uaa.user.model.UaaUser

/**
 * Test data about stored users, that loaded from testDataProvider as [TestDataProvider] in format [UaaUser]
 */
object UaaUserData : TestDataAT<UaaUser>(UaaUser::class.java) {
    override var atMarkerPredicate: (UaaUser) -> Boolean = { it.lastName?.endsWith(AT_POSTFIX_RUS_PARENTHESES) ?: false }
    private val oauthUserScope by lazy { Services.OAUTH.db.execSql("SELECT * FROM oauth_user_scope") }
    override val dbDataConsumer = { Services.OAUTH.db.execSql("SELECT * FROM uaa_user") }

    override val dataFileName = "uaaUser.json"

    override var createRecord: (() -> UaaUser)? = { UaaUserSteps().create(PrepareUaaUserData.prepareUaaUserDtoForCreate()).data!!.toModel() }
    override var removeRecord: ((UaaUser) -> Unit)? = { UaaUserSteps().delete(it.id!!) }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbUserMap ->
            dbUserMap.apply {
                val userId = dbUserMap["id"].toString()

                dbUserMap["scopes"] = oauthUserScope
                    .filter { it["id_user"].toString() == userId }
                    .map { it["id_scope"] }.toList()
            }
        }

}
