package ooo.jtc.logging

import io.qameta.allure.Allure
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val log: Logger by lazy { LoggerFactory.getLogger("LoggingUtils") }

fun <T : Any?> logComparison(act: List<T>, exp: List<T>) {
    val result = act.zip(exp).joinToString("\n") { "act: ${it.first}\nexp: ${it.second}\n-----------" }
    log.info(result)
    Allure.addAttachment("listComparison", result)
}