package ooo.jtc.api.uaa.steps


import io.qameta.allure.Step
import io.restassured.RestAssured
import io.restassured.config.RedirectConfig.redirectConfig
import io.restassured.response.Response
import ooo.jtc.api.common.steps.AbstractApiSteps
import ooo.jtc.core.api.CoreApi
import ooo.jtc.core.api.responseAs
import ooo.jtc.core.applicationProperties
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.uaa.application.ApplicationData
import ooo.jtc.testdata.uaa.application.FindApplicationBy
import ooo.jtc.uaa.*

@Suppress("UNCHECKED_CAST")
class AuthorizationSteps(user: User) : AbstractApiSteps(user, Services.OAUTH) {

    private val loginApi by lazy {
        CoreApi(
            applicationProperties.server.api.host,
            service.port,
            config = { this.setConfig(RestAssured.config().redirect(redirectConfig().followRedirects(false))) })
    }
    private val oauth = service.baseEndpoint

    @Step("Получение токена авторизации для {this.user.login}")
    fun authorizeByBank(newToken : Boolean): User {
        if (user.bearer == null || newToken) {
            val chainId = getChainId(FindApplicationBy.BANK_PORTAL)
            val loginByPasswordDto = LoginByPasswordDto(chainId, user.password, user.login)
            val sSession = oauthLogin(loginByPasswordDto).getCookie("s-session")
            user.bearer = getAccessToken(sSession, chainId)
        }
        return user
    }

    @Step("Получение токена авторизации для {this.user.login}")
    fun authorizeByClient(mfaType: MfaType = MfaType.SMS, newToken : Boolean): User {
        if (user.bearer == null || newToken) {
            val chainId = getChainId(FindApplicationBy.CUSTOMER_PORTAL)
            val mfaId = getMfaId(chainId)
            val mfaTokenDto = CreateMfaTokenFake(chainId, mfaId)
            val tokenId = getTokenId(mfaTokenDto)

            val checkMfaTokenParams = when (mfaType) {
                MfaType.SMS -> mapOf("code" to getSmsCode())
                else -> throw Exception("Not handled authorization for $mfaType")
            }
            val checkMfaTokenDto = CheckMfaTokenFake(tokenId, mfaId, checkMfaTokenParams)
            val sSession = getSSession(checkMfaTokenDto)
            user.bearer = getAccessToken(sSession, chainId)
        }
        return user
    }

    @Step("Получение ChainId (Идентификатор login chain)")
    private fun getChainId(
        findApplicationBy: FindApplicationBy,
        responseType: AuthResponseType = AuthResponseType.TOKEN
    ): String {
        val ui = applicationProperties.server.ui.client
        val redirectUri = "${ui.host}:${ui.port}/rupayment"
        val params = mapOf(
            "response_type" to responseType.value,
            "client_id" to ApplicationData.searchBy(findApplicationBy).clientId.toString(),
            "redirect_uri" to redirectUri
        )
        val response = oauthAuthorize(params)
        return response.getHeader("location").split("=")[1]
    }

    /**
     * Authorize user for resource. This is authorize endpoint from
     * @see <a href="https://tools.ietf.org/html/rfc6749">OAuth2 RFC</a>
     */
    @Step("Авторизация пользователя для определенного ресурса {params}")
    fun oauthAuthorize(params: Map<String, String>): Response {
        return loginApi.send(
            method = {
                params(params)
                get("$oauth/authorize")
            }
        )
    }

    @Step("Получение MfaId (идентификатора МФА)")
    private fun getMfaId(chainId: String): String {
        val loginByPasswordDto = LoginByPasswordDto(chainId, user.password, user.login)
        return oauthLogin(loginByPasswordDto)
            .responseAs(LoginPasswordRouteErrorResponse::class.java)
            .attributes.mfaId
    }

    /**
     * Performs user login by userName and password
     */
    @Step("Авторизация по логину/паролю для {loginByPasswordDto.userName}")
    fun oauthLogin(loginByPasswordDto: LoginByPasswordDto): Response {
        return loginApi.send(
            method = {
                body(loginByPasswordDto)
                post("$oauth/login")
            }
        )
    }

    @Step("Получение TokenId")
    private fun getTokenId(payload: CreateMfaTokenFake): String {
        return mfaCreate(payload).tokenId
    }

    /**
     * Starts authentication by additional MFA.
     */
    @Step("Начать МФА по mfaId: {createMfaTokenDto.mfaId}")
    fun mfaCreate(createMfaTokenDto: CreateMfaTokenFake): MfaTokenResponseFake {
        return loginApi.send(
            method = {
                body(createMfaTokenDto)
                post("$oauth/mfa/create")
            }
        ).responseAs(MfaTokenResponseFake::class.java)
    }


    @Step("Получение s-session")
    private fun getSSession(checkMfaTokenDto: CheckMfaTokenFake): String {
        val response = oauthMfaLogin(checkMfaTokenDto)
        return response.getCookie("s-session")
    }

    /**
     * Finishes authentication by additional MFA.
     */
    @Step("Завершить МФА")
    fun oauthMfaLogin(checkMfaTokenDto: CheckMfaTokenFake): Response {
        return loginApi.send(
            method = {
                body(checkMfaTokenDto)
                post("$oauth/mfa/login")
            }
        )
    }

    @Step("Получение access_token")
    private fun getAccessToken(sSession: String, chainId: String): String {
        val response = oauthFinishLogin(chainId, sSession)
        return getAccessTokenFromHeader(response.getHeader("location"))
    }

    /**
     * Finish login chain and authorize logged user.
     */
    @Step("Завершить цепочку авторизации")
    fun oauthFinishLogin(chainId: String, sSession: String): Response {
        return loginApi.send(
            method = {
                param("chain_id", chainId)
                cookie("s-session=$sSession")
                get("$oauth/finishLogin")
            }
        )
    }

    /**
     * Return sms code for test stands.
     */
    fun getSmsCode(): String {
        return "1111"
    }

    fun getAccessTokenFromHeader(location: String): String {
        return location.split("&")
            .find { it.contains("access_token") }!!
            .replace("access_token=", "Bearer ")
    }
}




