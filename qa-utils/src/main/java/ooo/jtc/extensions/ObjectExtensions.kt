package ooo.jtc.extensions

import ooo.jtc.serialization.SerializationUtils


inline fun <reified T> T?.getOrException(message: String = "'${T::class.java.simpleName}' is null"): T {
    return this ?: throw RuntimeException(message)
}

fun toStringAsJson(entityName: String, obj: Any): String {
    return "[$entityName]\n" + SerializationUtils.OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
}