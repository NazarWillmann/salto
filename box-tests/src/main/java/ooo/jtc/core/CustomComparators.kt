package ooo.jtc.core

/**
 * Provides a comparator of empty string [Comparable] values
 * considering `""` value greater than any other value.
 *
 * @sample samples.comparisons.Comparisons.nullsFirstLastComparator
 */
fun <T : Comparable<T>> emptyLast(): Comparator<T?> = emptyLast(naturalOrder())

/**
 * Extends the given [comparator] of non-nullable values to a comparator of empty string values
 * considering `""` value greater than any other value.
 *
 * @sample samples.comparisons.Comparisons.nullsFirstLastWithComparator
 */
fun <T : Any?> emptyLast(comparator: Comparator<in T>): Comparator<T?> =
    java.util.Comparator { a, b ->
        when {
            a === b -> 0
            a == "" -> 1
            b == "" -> -1
            else -> comparator.compare(a, b)
        }
    }

/**
 *
 */
inline fun <reified T> Comparable<*>.isComparableTypeOf(): Boolean =
    if (this is T)
        @Suppress("UNCHECKED_CAST")
        true else
        false