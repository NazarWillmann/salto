package ooo.jtc.asserts

import ooo.jtc.scripts.Invoke
import ooo.jtc.scripts.invoke
import org.hamcrest.MatcherAssert

/**
 * Infix function for soft script execution.
 *
 * [script] will be executed with soft errors
 */
infix fun <T : Any, R> T.should(script: T.() -> R) = invoke(true, script)

/**
 * function for soft script execution.
 */
fun <R> should(script: String.() -> R) = Invoke(true, "", script)()

/**
 * Assert all boolean functions from [scripts] in soft mode.
 *
 */
fun allShouldTrue(vararg scripts: Pair<String, () -> Boolean>) = scripts.forEach { assert(true, it.first, it.second) }

/**
 * Assert all boolean functions from [scripts] in soft mode.
 * Can be package into common step
 */
fun String.allShouldTrue(vararg scripts: Pair<String, () -> Boolean>) =
    this.should { scripts.forEach { assert(true, it.first, it.second) } }

/**
 * Execute all [scripts] in soft mode.
 */
fun <R> allShould(vararg scripts: String.() -> R) = scripts.forEach { Invoke(true, "", it)() }

/**
 * Execute all [scripts] in soft mode.
 * Can be package into common step
 */
fun <R> String.allShould(vararg scripts: String.() -> R) =
    this.should { scripts.forEach { Invoke(true, "", it)() } }

/**
 * Infix function for hard script execution.
 */
infix fun <T : Any, R> T.must(script: T.() -> R) = invoke(false, script)

/**
 * Check [script] in hard mode.
 */
fun <R> must(script: String.() -> R) = Invoke(false, "", script)()

/**
 * Check [script] in soft mode.
 */
infix fun String.mustTrue(script: () -> Boolean) = assert(false, this, script)

/**
 * Check boolean [script] in soft mode.
 */
infix fun String.shouldTrue(script: () -> Boolean) = assert(true, this, script)

/**
 * Execute [script] with Hard/Soft assert and [reason]
 */
private fun assert(isSoft: Boolean, reason: String, script: () -> Boolean) {
    val invoke = Invoke(isSoft = true, script = castToExt(script), target = "")()
    val result = invoke.output ?: false
    val ex = invoke.error
    ex?.let {
        reason(true) { throw ex }
    } ?: if (isSoft)
        should { MatcherAssert.assertThat(reason, result) }
    else
        must { MatcherAssert.assertThat(reason, result) }
}

private fun <T> castToExt(infun: () -> Boolean): T.() -> Boolean = { infun.invoke() }


fun checkSoftAsserts(allureTestName: String) {
    val failedStepsInAllure = ooo.jtc.allure.AllureUtils.failedStepsInAllure(allureTestName)
    if (failedStepsInAllure.isNotEmpty())
        throw RuntimeException("Errors into soft asserts. Check Allure Report Steps:\n" +
                failedStepsInAllure.joinToString { "StepName: ${it.name}\nTrace: ${it.statusDetails.trace}\n" })
}