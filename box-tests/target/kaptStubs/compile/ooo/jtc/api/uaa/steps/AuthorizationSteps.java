package ooo.jtc.api.uaa.steps;

import java.lang.System;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0003J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u001a\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0003J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0003J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0003J\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0003J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020$H\u0007J\u001c\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0+H\u0007J\u0018\u0010,\u001a\u00020)2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0007J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0007J\u0010\u00100\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 H\u0007R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Looo/jtc/api/uaa/steps/AuthorizationSteps;", "Looo/jtc/api/common/steps/AbstractApiSteps;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "loginApi", "Looo/jtc/core/api/CoreApi;", "getLoginApi", "()Looo/jtc/core/api/CoreApi;", "loginApi$delegate", "Lkotlin/Lazy;", "oauth", "", "authorizeByBank", "newToken", "", "authorizeByClient", "mfaType", "Looo/jtc/uaa/MfaType;", "getAccessToken", "sSession", "chainId", "getAccessTokenFromHeader", "location", "getChainId", "findApplicationBy", "Looo/jtc/testdata/uaa/application/FindApplicationBy;", "responseType", "Looo/jtc/uaa/AuthResponseType;", "getMfaId", "getSSession", "checkMfaTokenDto", "Looo/jtc/uaa/CheckMfaTokenFake;", "getSmsCode", "getTokenId", "payload", "Looo/jtc/uaa/CreateMfaTokenFake;", "mfaCreate", "Looo/jtc/uaa/MfaTokenResponseFake;", "createMfaTokenDto", "oauthAuthorize", "Lio/restassured/response/Response;", "params", "", "oauthFinishLogin", "oauthLogin", "loginByPasswordDto", "Looo/jtc/uaa/LoginByPasswordDto;", "oauthMfaLogin", "box-tests"})
public final class AuthorizationSteps extends ooo.jtc.api.common.steps.AbstractApiSteps {
    private final kotlin.Lazy loginApi$delegate = null;
    private final java.lang.String oauth = null;
    
    private final ooo.jtc.core.api.CoreApi getLoginApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 \u0442\u043e\u043a\u0435\u043d\u0430 \u0430\u0432\u0442\u043e\u0440\u0438\u0437\u0430\u0446\u0438\u0438 \u0434\u043b\u044f {this.user.login}")
    public final ooo.jtc.uaa.User authorizeByBank(boolean newToken) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 \u0442\u043e\u043a\u0435\u043d\u0430 \u0430\u0432\u0442\u043e\u0440\u0438\u0437\u0430\u0446\u0438\u0438 \u0434\u043b\u044f {this.user.login}")
    public final ooo.jtc.uaa.User authorizeByClient(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.MfaType mfaType, boolean newToken) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 ChainId (\u0418\u0434\u0435\u043d\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u043e\u0440 login chain)")
    private final java.lang.String getChainId(ooo.jtc.testdata.uaa.application.FindApplicationBy findApplicationBy, ooo.jtc.uaa.AuthResponseType responseType) {
        return null;
    }
    
    /**
     * Authorize user for resource. This is authorize endpoint from
     * @see <a href="https://tools.ietf.org/html/rfc6749">OAuth2 RFC</a>
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0410\u0432\u0442\u043e\u0440\u0438\u0437\u0430\u0446\u0438\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f \u0434\u043b\u044f \u043e\u043f\u0440\u0435\u0434\u0435\u043b\u0435\u043d\u043d\u043e\u0433\u043e \u0440\u0435\u0441\u0443\u0440\u0441\u0430 {params}")
    public final io.restassured.response.Response oauthAuthorize(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> params) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 MfaId (\u0438\u0434\u0435\u043d\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u043e\u0440\u0430 \u041c\u0424\u0410)")
    private final java.lang.String getMfaId(java.lang.String chainId) {
        return null;
    }
    
    /**
     * Performs user login by userName and password
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0410\u0432\u0442\u043e\u0440\u0438\u0437\u0430\u0446\u0438\u044f \u043f\u043e \u043b\u043e\u0433\u0438\u043d\u0443/\u043f\u0430\u0440\u043e\u043b\u044e \u0434\u043b\u044f {loginByPasswordDto.userName}")
    public final io.restassured.response.Response oauthLogin(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.LoginByPasswordDto loginByPasswordDto) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 TokenId")
    private final java.lang.String getTokenId(ooo.jtc.uaa.CreateMfaTokenFake payload) {
        return null;
    }
    
    /**
     * Starts authentication by additional MFA.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0447\u0430\u0442\u044c \u041c\u0424\u0410 \u043f\u043e mfaId: {createMfaTokenDto.mfaId}")
    public final ooo.jtc.uaa.MfaTokenResponseFake mfaCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.CreateMfaTokenFake createMfaTokenDto) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 s-session")
    private final java.lang.String getSSession(ooo.jtc.uaa.CheckMfaTokenFake checkMfaTokenDto) {
        return null;
    }
    
    /**
     * Finishes authentication by additional MFA.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044c \u041c\u0424\u0410")
    public final io.restassured.response.Response oauthMfaLogin(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.CheckMfaTokenFake checkMfaTokenDto) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u0438\u0435 access_token")
    private final java.lang.String getAccessToken(java.lang.String sSession, java.lang.String chainId) {
        return null;
    }
    
    /**
     * Finish login chain and authorize logged user.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0417\u0430\u0432\u0435\u0440\u0448\u0438\u0442\u044c \u0446\u0435\u043f\u043e\u0447\u043a\u0443 \u0430\u0432\u0442\u043e\u0440\u0438\u0437\u0430\u0446\u0438\u0438")
    public final io.restassured.response.Response oauthFinishLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String chainId, @org.jetbrains.annotations.NotNull()
    java.lang.String sSession) {
        return null;
    }
    
    /**
     * Return sms code for test stands.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSmsCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAccessTokenFromHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String location) {
        return null;
    }
    
    public AuthorizationSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null);
    }
}