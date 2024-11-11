package ooo.jtc.scripts

import io.qameta.allure.Step
import io.qameta.allure.model.Status
import io.qameta.allure.model.Status.*
import ooo.jtc.allure.AllureUtils


/**
 * Class for invoking lambdas
 *
 * @param isSoft - soft/hard script executing
 * @param target - object on that [script] will executed
 * @param script - lambda script for executing
 *
 */
class Invoke<T : Any, R>(private val isSoft: Boolean, val target: T, val script: T.() -> R) {

    private val title = target.toString()

    var output: R? = null
        private set

    var error: Throwable? = null
        private set

    var status = InvokeStatus.UNDEFINED
        private set

    /**
     * Execute [script]. If [target] is not empty String, script will be execute into new allure step [title], else new step will not created.
     */
    operator fun invoke(): Invoke<T, R> = if (target is String && target.isNotEmpty()) step() else executeScript()

    @Suppress("UNUSED_PARAMETER")
    @Step("{title}")
    private fun step(title: String = this.title): Invoke<T, R> = executeScript()

    /**
     * Execute [script].
     * if there no exception into script, [status] will be [PASSED]
     * if there will be [AssertionError] status will be [FAILED]
     * if there will be [Exception] status will be [BROKEN]
     *
     * After [script] execution status of current allure step will be updated
     *
     * if [isSoft] is true, exceptions won't throws, else it will be throw
     */
    private fun executeScript(): Invoke<T, R> {
        try {
            status = InvokeStatus.RUNNING
            output = script(target)
            status = when (status) {
                InvokeStatus.RUNNING -> InvokeStatus.PASSED
                else -> throw if (status == InvokeStatus.BROKEN)
                    RuntimeException("${this.status} : $this", this.error)
                else
                    AssertionError("${this.status} :$this", this.error)
            }
        } catch (error: Throwable) {
            status = when (error) {
                is AssertionError -> InvokeStatus.FAILED
                else -> InvokeStatus.BROKEN
            }
            this.error = error
            val allureStatus = convertToAllureStatus(status)
            AllureUtils.setStepStatus(ex = error, status = allureStatus)
            if (!isSoft) throw error
        }
        return this
    }

    private fun convertToAllureStatus(invokeStatus: InvokeStatus): Status {
        return when (invokeStatus) {
            InvokeStatus.FAILED -> FAILED
            InvokeStatus.BROKEN -> BROKEN
            InvokeStatus.PASSED -> PASSED
            InvokeStatus.SKIPPED -> SKIPPED
            else -> throw IllegalStateException("Status isn't part of Status ['FAILED', 'BROKEN', 'PASSED', 'SKIPPED']")
        }
    }

}

/**
 * Script executing statuses.
 */
enum class InvokeStatus {
    UNDEFINED, RUNNING, PASSED, FAILED, BROKEN, SKIPPED
}

operator fun <T : Any, R> T.invoke(isSoft: Boolean, script: T.() -> R): Invoke<T, R> = Invoke(isSoft, this, script)()
operator fun <T : Any, R> T.invoke(script: T.() -> R): Invoke<T, R> = Invoke(false, this, script)()
infix fun <T : Any, R> T.soft(script: T.() -> R): Invoke<T, R> = Invoke(true, this, script)()
infix fun <R> String.step(script: String.() -> R): R = Invoke(false, this, script)().output
    ?: throw RuntimeException("Error getting output from lambda. set object for return in lambda.")


