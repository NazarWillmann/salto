package ooo.jtc.api.common.checks

import io.qameta.allure.Step
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.core.TestConstants.REPEAT_DELAY_MS
import ooo.jtc.core.TestConstants.REPEAT_LIMIT_SEC
import ooo.jtc.generic.print.IPrintExportFormat
import ooo.jtc.generic.print.PrintExportFormatDto
import ooo.jtc.interfaces.IDocument
import ooo.jtc.scripts.repeat
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

/**
 * Base asserts than can be applied for Document
 */
open class ApiDocumentChecks<D : IDocument> : ApiEntityChecks<D>() {

    @Step("Проверить статусный переход документа '{expDocumentDto.status} -> {expStatuses}'")
    open fun checkDocumentLifecycleTransition(
        expDocumentDto: D,
        actResult: D,
        expStatuses: List<String>,
        additionalHandling: ((preparedDto: D, receivedDto: D) -> Unit)? = null
    ) {
        checkDocumentStatus(actResult, expStatuses)
        additionalHandling?.invoke(expDocumentDto, actResult)
        expDocumentDto.status = null
        expDocumentDto.version = actResult.version
        assertObjectsEqual(expDocumentDto, actResult)
    }

    @Step("Проверить статусный переход документа '{preparedDto.status} -> {expStatuses}' с повторением")
    fun repeatableCheckDocumentLifecycleTransition(
        getActResultFunc: () -> D,
        repeatLimitSec: Long = REPEAT_LIMIT_SEC,
        repeatDelayMs: Long = REPEAT_DELAY_MS,
        preparedDto: D,
        expStatuses: List<String>,
        additionalHandling: ((preparedDto: D, receivedDto: D) -> Unit)? = null
    ): D {
        val actResult = repeat(
            function = getActResultFunc,
            condition = { it.isInStatus(*expStatuses.toTypedArray()) },
            delayMills = repeatDelayMs,
            limitSec = repeatLimitSec
        )!!
        checkDocumentStatus(actResult, expStatuses)
        additionalHandling?.invoke(preparedDto, actResult)
        preparedDto.status = null
        preparedDto.version = actResult.version
        assertObjectsEqual(preparedDto, actResult)
        return actResult
    }

    @Step("Проверить, что документ [{document.id}] находится в одном из статусов {expStatuses}")
    fun checkDocumentStatus(document: D, expStatuses: List<String>) {
        assertThat(
            "Статус '${document.status}' документа [${document.id}] не в списке ожидаемых '$expStatuses'",
            expStatuses.contains(document.status)
        )
    }

    @Step("Проверить набор доступных форматов печати")
    fun checkPrintFormatResponse(
        actResult: List<PrintExportFormatDto>,
        expFormats: List<IPrintExportFormat>
    ) {
        val expResult = expFormats.map { PrintExportFormatDto(it.format, it.description) }
        assertThat(
            "Полученный список форматов не совпадает с ожидаемым",
            actResult, Matchers.containsInAnyOrder(*expResult.toTypedArray())
        )
    }

    @Step("Проверить набор доступных форматов экспорта")
    fun checkExportFormatResponse(
        actResult: List<PrintExportFormatDto>,
        expFormats: List<IPrintExportFormat>
    ) {
        val expResult = expFormats.map { PrintExportFormatDto(it.format, it.description) }
        assertThat(
            "Полученный список форматов не совпадает с ожидаемым",
            actResult, Matchers.containsInAnyOrder(*expResult.toTypedArray())
        )
    }
}