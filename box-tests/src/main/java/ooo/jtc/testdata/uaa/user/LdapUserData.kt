package ooo.jtc.testdata.uaa.user

import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.common.TestDataProvider
import ooo.jtc.uaa.LdapUser
import ooo.jtc.uaa.UserType
import ooo.jtc.uaa.catalog.model.DefaultCatalog
import ooo.jtc.uaa.user.model.getUserDetails

/**
 * Test data about stored users, that loaded from testDataProvider as [TestDataProvider] in format [LdapUser]
 */
object LdapUserData : TestDataAT<LdapUser>(LdapUser::class.java) {
    override var atMarkerPredicate: (LdapUser) -> Boolean = { it.login.endsWith(AT_POSTFIX) }
    override val dbDataConsumer =
        {
            Services.OAUTH.db.execSql(
                "SELECT lu.*, cat.name AS cat_name  FROM cat_ldap_user lu " +
                        "join oauth_cat cat on lu.id_catalog = cat.id"
            )
        }

    override val dataFileName = "ldapUser.json"

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbLdapUserMap ->
            dbLdapUserMap.apply {
                val catalogNameStr = dbLdapUserMap["cat_name"].toString()
                val catalogName = DefaultCatalog.getByValue(catalogNameStr)
                val userType = UserType.getByCatalog(catalogName)
                val userDetails = UaaUserData.find { it.id.toString() == dbLdapUserMap["id_user"].toString() }.getUserDetails()
                dbLdapUserMap["userDetails"] = userDetails
                dbLdapUserMap["userType"] = userType
                dbLdapUserMap["password"] = "123456"
                //TODO A.Stykalin [15.04.2020] подумать, как доставать пароли из ЛДАПа?
            }
        }
}

/**
 * Enum for searching [LdapUser] from [LdapUserData]
 */
enum class FindLdapUserBy(override var predicate: (LdapUser) -> Boolean) : FindEntityBy<LdapUser, LdapUserData> {
    TEST_COLLECTION_1(predicate = { it.login == "test_collection1" }),
}
