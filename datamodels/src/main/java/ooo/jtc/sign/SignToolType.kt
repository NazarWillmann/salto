package ooo.jtc.sign

enum class SignToolType(val type: String) {
    // user sign by sms
    SMS("Sms"),

    // user sign by certificate
    CRYPTO("Crypto"),

    // auto-sign | tech-user
    CRYPTO_AUTO("CryptoAuto"),
    ;
}