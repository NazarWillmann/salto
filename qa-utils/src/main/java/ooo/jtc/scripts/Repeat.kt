package ooo.jtc.scripts

import java.time.LocalTime

/**
 * Repeat provided [function] for specified time ([limitSec] sec) with specified delays ([delayMills] milliseconds)
 * until provided [condition] is true
 */
fun <T> repeat(
    function: () -> T,
    condition: (T) -> Boolean,
    limitSec: Long = 30L,
    delayMills: Long = 500L
): T? {
    val endTime = LocalTime.now().plusSeconds(limitSec)
    var result: T? = null
    do {
        try {
            result = function.invoke()
        } catch (e: Exception) {
            //do nothing
        }
        Thread.sleep(delayMills)
    } while (endTime > LocalTime.now() && (result == null || !condition.invoke(result)))

    return result
}