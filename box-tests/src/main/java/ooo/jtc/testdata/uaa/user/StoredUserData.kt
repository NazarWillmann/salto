package ooo.jtc.testdata.uaa.user

import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.uaa.StoredUser
import ooo.jtc.uaa.UserType
import ooo.jtc.uaa.catalog.model.DefaultCatalog
import ooo.jtc.uaa.user.model.getUserDetails

/**
 * Test data about stored users, that loaded from testDataProvider as [TestDataProvider] in format [StoredUser]
 */
object StoredUserData : TestDataAT<StoredUser>(StoredUser::class.java) {
    override var atMarkerPredicate: (StoredUser) -> Boolean = { it.login.endsWith(AT_POSTFIX) }
    override val dbDataConsumer =
        {
            Services.OAUTH.db.execSql(
                "SELECT su.*, cat.name AS cat_name FROM cat_stored_user su " +
                        "join oauth_cat cat on su.id_catalog = cat.id"
            )
        }

    override val dataFileName = "storedUser.json"

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbStoredUserMap ->
            dbStoredUserMap.apply {
                val catalogNameStr = dbStoredUserMap["cat_name"].toString()
                val catalogName = DefaultCatalog.getByValue(catalogNameStr)
                val userType = UserType.getByCatalog(catalogName)
                val userDetails = UaaUserData.find { it.id.toString() == dbStoredUserMap["id_user"].toString() }.getUserDetails()
                dbStoredUserMap["userDetails"] = userDetails
                dbStoredUserMap["userType"] = userType
                dbStoredUserMap["password"] = "1"
                dbStoredUserMap["isBank"] = UserType.BANK == userType
                dbStoredUserMap["isClient"] = UserType.CLIENT == userType
                //TODO A.Stykalin [18.03.2020] подумать, как обруливать когда пароль будет не 1?
                // upd.[14.04.2020] решится, когда будет реализована парольная политика на бэке
            }
        }

    fun getByLogin(login: String): StoredUser {
        return find { (it.login == login) }
    }
}

/**
 * Enum for searching [StoredUser] from [StoredUserData]
 */
enum class FindStoredUserBy(override var predicate: (StoredUser) -> Boolean) : FindEntityBy<StoredUser, StoredUserData> {

    CLIENT_USER(predicate = { it.catalogName == DefaultCatalog.CLIENT.value && it.login == "client_AT" }),
    CLIENT_SECOND_USER(predicate = { it.catalogName == DefaultCatalog.CLIENT.value && it.login == "client_second_AT" }),
    INDIVIDUAL_USER(predicate = { it.catalogName == DefaultCatalog.INDIVIDUAL.value && it.login == "individual_AT" }),
    AUTOTEST_USER(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "autotest" }),
    BANK_ADMIN_USER(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "admin_AT" }),
    BRANCHES_ALMIGHTY(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "admin" }),
    BANK_OPERATOR_USER(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "operator_AT" }),
    SUPER_BANK_OPERATOR(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "super_operator_AT" }),
    SECURITY_ADMIN_USER(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "security_AT" }),
    SYSTEM_SECURITY_USER(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "security" }),
    SYSTEM_BANK_OPERATOR_USER(predicate = { it.catalogName == DefaultCatalog.BANK.value && it.login == "operator" }),

}
