package ooo.jtc.extensions

fun Map<String, String>.getSafe(key: String): String {
    return this[key].getOrException("Key $key not found in ${this.keys}.")
}