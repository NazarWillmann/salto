package ooo.jtc.extensions

inline fun <reified T> Iterable<T>.toArray() = map { it }.toTypedArray()