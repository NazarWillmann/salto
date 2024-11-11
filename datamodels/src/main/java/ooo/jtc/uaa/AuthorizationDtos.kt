package ooo.jtc.uaa

import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

data class LoginResponseDto(var code: String, var message: String, var attributes: Attributes, var params: List<String> = emptyList())

data class LoginRequestDto(var mfaType: MfaType, var tokenId: UUID, var params: Map<String, Any>)

data class Attributes(var challengeId: UUID, var mfaType: MfaType, var mfa: String)

data class LoginByPasswordDto(val chainId: String, val password: String, val userName: String)

data class LoginPasswordRouteErrorResponse(var attributes: Attributes, var code: Int, var message: String) {
    data class Attributes(var chainId: String, var mfaId: String, var mfaType: String)
}

data class CreateMfaTokenFake(
        val chainId: String,
        val mfaId: String,
        val params: Map<String, Any> = mapOf()
)

data class MfaTokenResponseFake(
        val tokenId: String,
        val params: Map<String, Any>
)

data class CheckMfaTokenFake(
        val tokenId: String,
        val mfaId: String,
        val params: Map<String, Any>
)

enum class MfaType(@get:JsonValue val value: String) {

    CRYPTO("Crypto"),
    SMS("Sms")

}

enum class AuthResponseType(@get:JsonValue val value: String) {

    TOKEN("token")

}