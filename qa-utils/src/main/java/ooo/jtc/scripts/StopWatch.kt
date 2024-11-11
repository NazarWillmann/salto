package ooo.jtc.scripts

import io.qameta.allure.Allure
import ooo.jtc.logging.LoggerDelegate
import java.time.Duration
import java.time.LocalDateTime

object StopWatch {
    private val log by LoggerDelegate()

    /**
     * Utility function for measuring the running time of an action.
     * @param actionName - for logging
     * @param action - action for measuring
     */
    fun <T> stopWatch(actionName: String, addToAllure: Boolean = false, action: () -> T): T {
        val start = LocalDateTime.now()
        val res = action.invoke()
        val end = LocalDateTime.now()
        val time = Duration.between(start, end).toMillis()
        log.warn("$actionName complete in $time mills")
        if (addToAllure) Allure.addAttachment(actionName, "$time mills")
        return res
    }
}