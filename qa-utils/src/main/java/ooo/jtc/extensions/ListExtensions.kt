package ooo.jtc.extensions


/**
 * Create List from provider. Return empty list if it failed.
 *
 * @return created list as [List]
 */
fun <T> createOrEmpty(provider: () -> List<T>) = try {
    provider.invoke()
} catch (ex: Throwable) {
    listOf<T>()
}

/**
 * Get random entity from list, that is not one of [providedEntities].
 * Entities in list can be mapped with [filterByField], if additional mapping is needed
 */
fun <T> List<T>.randomAnother(vararg providedEntities: T, filterByField: ((T) -> Any) = { it as Any }): T {
    val mappedProvided = providedEntities.map { filterByField(it) }
    return this
        .filter { filterByField(it) !in mappedProvided }
        .ifEmpty { throw NoSuchElementException("There are no another elements in list, except $mappedProvided") }
        .random()
}

/**
 * Like [let] for list.
 */
fun <T, R> List<T>.ifNotEmpty(block: (List<T>) -> R): R? {
    return if (this.isNotEmpty()) block(this) else null
}