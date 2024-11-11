package ooo.jtc.api.platform.crypto

import io.qameta.allure.Step
import ooo.jtc.core.api.CoreApi
import ooo.jtc.core.api.responseAs
import ooo.jtc.core.applicationProperties
import org.apache.commons.codec.binary.Base64.isBase64
import org.hamcrest.MatcherAssert.assertThat

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
class CryptoPluginStubSteps {

    private val stubApi: CoreApi
        get() = CoreApi(
            baseUri = applicationProperties.cryptoPluginStub.host,
            port = applicationProperties.cryptoPluginStub.port,
            headers = mapOf("Content-Type" to "text/html; charset=utf-8")
        )

    /**
     * Sign data by certificate.
     * The certificate must be installed on the signing machine!
     *
     * @param certThumbprint - certificate thumbprint. Used to find necessary certificate
     * @param dataToSign - data to be signed
     * @return - [dataToSign]'s signature in Base64 format
     */
    @Step("Подписать данные сертификатом '{certThumbprint}'")
    fun signString(
        certThumbprint: String,
        dataToSign: String
    ): String {
        val thumbprintDataDto = ThumbprintDataDto(thumbprint = certThumbprint, dataToSign = dataToSign)
        val signResponse = stubApi.send(
            method = {
                body(thumbprintDataDto)
                post("/signByThumbprint")
            }
        ).responseAs(SignResponseDto::class.java)

        signResponse.error?.let { AssertionError(it) }
        val signature = signResponse.signedData
        assertThat("signature is not a Base64 string", isBase64(signature))
        return signature
    }
}

data class ThumbprintDataDto(val thumbprint: String, val dataToSign: String)

data class SignResponseDto(val signedData: String, val error: String?)