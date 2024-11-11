package ooo.jtc.api.platform.crypto;

import java.lang.System;

/**
 * CryptoPluginStubSteps
 * Steps for interacting with crypto plugin stub.
 * Stub is basically a script, launched in browser, that awaits POST requests.
 * Use this for signing something (usually - document digest) by a certificate.
 * Thus, for a successful signing the machine that runs a stub must have a necessary
 * (!)certificate with a private key(!) installed!
 *
 * Stub is expected to be up and running on
 * [applicationProperties.cryptoPlugin.host]:[applicationProperties.cryptoPlugin.port].
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Looo/jtc/api/platform/crypto/CryptoPluginStubSteps;", "", "()V", "stubApi", "Looo/jtc/core/api/CoreApi;", "getStubApi", "()Looo/jtc/core/api/CoreApi;", "signString", "", "certThumbprint", "dataToSign", "box-tests"})
public final class CryptoPluginStubSteps {
    
    private final ooo.jtc.core.api.CoreApi getStubApi() {
        return null;
    }
    
    /**
     * Sign data by certificate.
     * The certificate must be installed on the signing machine!
     *
     * @param certThumbprint - certificate thumbprint. Used to find necessary certificate
     * @param dataToSign - data to be signed
     * @return - [dataToSign]'s signature in Base64 format
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c \u0434\u0430\u043d\u043d\u044b\u0435 \u0441\u0435\u0440\u0442\u0438\u0444\u0438\u043a\u0430\u0442\u043e\u043c \'{certThumbprint}\'")
    public final java.lang.String signString(@org.jetbrains.annotations.NotNull()
    java.lang.String certThumbprint, @org.jetbrains.annotations.NotNull()
    java.lang.String dataToSign) {
        return null;
    }
    
    public CryptoPluginStubSteps() {
        super();
    }
}