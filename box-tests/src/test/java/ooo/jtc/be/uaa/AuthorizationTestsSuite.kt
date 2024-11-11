package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_AUTHORIZATION
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.uaa.cheks.AuthorizationChecks
import ooo.jtc.api.uaa.steps.AuthorizationSteps
import ooo.jtc.api.uaa.steps.UaaSelfSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.api.responseAs
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.Tm4jComponent
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jPriority
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.common.random
import ooo.jtc.testdata.uaa.application.FindApplicationBy
import ooo.jtc.testdata.uaa.user.FindLdapUserBy
import ooo.jtc.testdata.uaa.user.FindStoredUserBy
import ooo.jtc.uaa.AuthResponseType
import ooo.jtc.uaa.CheckMfaTokenFake
import ooo.jtc.uaa.CreateMfaTokenFake
import ooo.jtc.uaa.LoginByPasswordDto
import ooo.jtc.uaa.LoginPasswordRouteErrorResponse
import ooo.jtc.uaa.User
import ooo.jtc.uaa.resource.model.Audience
import ooo.jtc.uaa.withDomain
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.UAA)
@Story(UaaNames.AUTHORIZATION)
@DisplayName("API '${UaaNames.AUTHORIZATION}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_UAA_AUTHORIZATION
class AuthorizationTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3522") annotation class T3522
@Tag("JTCSALTO-T3523") annotation class T3523
@Tag("JTCSALTO-T3524") annotation class T3524
//@formatter:on
//endregion

    private val authorizationFolder = "${FolderPrefix.UAA} \"${UaaNames.AUTHORIZATION}\" (authorization)"
    private val authorizationTaskIdsCommon = arrayOf(Tm4jEpic.EPIC_UAA, "JTCSALTO-476", "JTCSALTO-472")

    private val redirectUri by lazy {
        val ui = applicationProperties.server.ui.client
        "${ui.host}:${ui.port}/rupayment"
    }

    @TestFactory
    @T3524 //'Авторизация'. Авторизация клиентского пользователя [МФА - SMS]
    internal fun authorizationWithMfaTest(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UnitBeTest(
                    name = "'${UaaNames.AUTHORIZATION}'. Авторизация клиентского пользователя [МФА - SMS]",
                    testBody = {
                        val user = FindStoredUserBy.CLIENT_USER.random().withDomain(Audience.CUSTOMER)
                        val application = FindApplicationBy.CUSTOMER_PORTAL.random()
                        val steps = AuthorizationSteps(user)

                        val params = mapOf(
                            "response_type" to AuthResponseType.TOKEN.value,
                            "client_id" to application.clientId.toString(),
                            "redirect_uri" to redirectUri
                        )
                        val authorizeResponse = steps.oauthAuthorize(params)
                        val chainId = authorizeResponse.getHeader("location").split("=")[1]
                        val loginByPasswordDto = LoginByPasswordDto(chainId, user.password, user.login)
                        val oauthLoginResponse = steps.oauthLogin(loginByPasswordDto)
                        val mfaId = oauthLoginResponse.responseAs(LoginPasswordRouteErrorResponse::class.java).attributes.mfaId
                        val mfaTokenDto = CreateMfaTokenFake(chainId, mfaId)
                        val mfaTokenResponse = steps.mfaCreate(mfaTokenDto)
                        val tokenId = mfaTokenResponse.tokenId
                        val checkMfaTokenParams = mapOf("code" to steps.getSmsCode())
                        val checkMfaTokenDto = CheckMfaTokenFake(tokenId, mfaId, checkMfaTokenParams)
                        val sSession = steps.oauthMfaLogin(checkMfaTokenDto).getCookie("s-session")
                        val finishLoginResponse = steps.oauthFinishLogin(chainId, sSession)
                        val accessToken = steps.getAccessTokenFromHeader(finishLoginResponse.getHeader("location"))

                        user.bearer = accessToken

                        val selfInfoDto = UaaSelfSteps(user).getProfile()
                        AuthorizationChecks.checkUserDetails(selfInfoDto, user)
                    }
                ).withId(T3524::class)
                    .withTaskIds(*authorizationTaskIdsCommon)
                    .withFolder(authorizationFolder)
                    .withComponent(Tm4jComponent.UAA)
                    .withPriority(Tm4jPriority.High)
            )
        )
    }


    @TestFactory
    @T3522 //'Авторизация'. Авторизация банковского пользователя (StoredCatalog) [без МФА]
    @T3523 //'Авторизация'. Авторизация банковского пользователя (LDAP) [без МФА]
    internal fun authorizationWithoutMfaTest(): List<DynamicTest> {
        val bankAdminStoredUser = FindStoredUserBy.BANK_ADMIN_USER.random()
        val ldapUser = FindLdapUserBy.TEST_COLLECTION_1.random()
        val tests = listOf(
            UnitBeTest(
                name = "'${UaaNames.AUTHORIZATION}'. Авторизация банковского пользователя (StoredCatalog) [без МФА]",
                params = { mapOf(PARAM_USER to bankAdminStoredUser) },
                testBody = { authWithoutMfaBankTest(bankAdminStoredUser) }
            ).withId(T3522::class),
            UnitBeTest(
                name = "'${UaaNames.AUTHORIZATION}'. Авторизация банковского пользователя (LDAP) [без МФА]",
                params = { mapOf(PARAM_USER to ldapUser) },
                testBody = { authWithoutMfaBankTest(ldapUser) }
            ).withId(T3523::class)
        ).map {
            it.withTaskIds(*authorizationTaskIdsCommon)
                .withFolder(authorizationFolder)
                .withComponent(Tm4jComponent.UAA)
                .withPriority(Tm4jPriority.High)
        }
        return EntityTestGenerator.generate(tests)
    }

    private fun authWithoutMfaBankTest(user: User) {
        user.withDomain(Audience.BANK)
        val application = FindApplicationBy.BANK_PORTAL.random()
        val steps = AuthorizationSteps(user)


        val params = mapOf(
            "response_type" to AuthResponseType.TOKEN.value,
            "client_id" to application.clientId.toString(),
            "redirect_uri" to redirectUri
        )
        val authorizeResponse = steps.oauthAuthorize(params)
        val chainId = authorizeResponse.getHeader("location").split("=")[1]
        val loginByPasswordDto = LoginByPasswordDto(chainId, user.password, user.login)
        val sSession = steps.oauthLogin(loginByPasswordDto).getCookie("s-session")
        val finishLoginResponse = steps.oauthFinishLogin(chainId, sSession)
        val accessToken = steps.getAccessTokenFromHeader(finishLoginResponse.getHeader("location"))

        user.bearer = accessToken
        val selfInfoDto = UaaSelfSteps(user).getProfile()
        AuthorizationChecks.checkUserDetails(selfInfoDto, user)
    }
}