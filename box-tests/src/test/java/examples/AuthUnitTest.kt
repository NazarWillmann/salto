package examples

import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.testdata.common.random
import ooo.jtc.testdata.uaa.user.FindStoredUserBy
import ooo.jtc.uaa.UserType
import org.junit.jupiter.api.Test

class AuthUnitTest {

    @Test
    fun clientUserAuthTest() {
        val notLoggedUser = FindStoredUserBy.CLIENT_USER.random()
        assert(notLoggedUser.bearer.isNullOrBlank())
        val loggedUser = notLoggedUser.invokeAuth()
        loggedUser.bearer.assertIsNotEmpty()
    }

    @Test
    fun bankUserAuthTest() {
        val notLoggedUser = FindStoredUserBy.BANK_OPERATOR_USER.random()
        assert(notLoggedUser.bearer.isNullOrBlank())
        val loggedUser = notLoggedUser.invokeAuth()
        loggedUser.bearer.assertIsNotEmpty()
    }

    @Test
    fun userTypeStoredFromDataBaseTest() {
        val storedUser = FindStoredUserBy.CLIENT_USER.random()
        assert(storedUser.userType == UserType.CLIENT)
        val authUser = storedUser.invokeAuth()
        assert(authUser.userType == UserType.CLIENT)
    }
}
