package ooo.jtc.core

/**
 * Convert phone from +71234567890 to format `1234567890`
 */
fun getPhoneWithoutCountryCode(source: String?): String {
    return source?.substringAfter("+7") ?: ""
}