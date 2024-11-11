package ooo.jtc.testdata.common

import ooo.jtc.interfaces.IEntity

/**
 * Predicate for searching entity
 */
interface FindEntityBy<T : IEntity, R : TestData<T>> {

    var predicate: (T) -> Boolean

}

/**
 * Search list of entities as [T] from testData as [TestData] from Entity's Predicate as [FindEntityBy]
 */
inline fun <T : IEntity, reified R : TestData<T>> FindEntityBy<T, R>.get(fromCache: Boolean = true, seekAtCreated: Boolean? = null): List<T> =
    R::class.objectInstance!!.get(fromCache, predicate = predicate)


/**
 * Search random of entities as [T] from testData as [TestData] from Entity's Predicate as [FindEntityBy]
 */
inline fun <T : IEntity, reified R : TestData<T>> FindEntityBy<T, R>.random(fromCache: Boolean = true): T =
    R::class.objectInstance!!.get(fromCache, predicate = predicate).random()

/**
 * Search entities as [T] from testData as [TestData] by list of Entity's Predicates as [List[FindEntityBy]].
 * Returns entities, that match ALL of provided predicates
 */
fun <T : IEntity, R : TestData<T>> List<FindEntityBy<T, R>>.all(): (T) -> Boolean = {
    map { findEntityBy -> findEntityBy.predicate.invoke(it) }.all { it }
}

/**
 * Search entities as [T] from testData as [TestData] by list of Entity's Predicates as [List[FindEntityBy]].
 * Returns entities, that match ANY of provided predicates
 */
fun <T : IEntity, R : TestData<T>> List<FindEntityBy<T, R>>.any(): (T) -> Boolean = {
    map { findEntityBy -> findEntityBy.predicate.invoke(it) }.any { it }
}