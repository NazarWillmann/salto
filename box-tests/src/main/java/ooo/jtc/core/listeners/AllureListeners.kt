package ooo.jtc.core.listeners

import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.listener.StepLifecycleListener
import io.qameta.allure.listener.TestLifecycleListener
import io.qameta.allure.model.Attachment
import io.qameta.allure.model.Status
import io.qameta.allure.model.StepResult
import io.qameta.allure.model.TestResult
import io.qameta.allure.util.ResultsUtils
import ooo.jtc.allure.AllureSystemSuite.Companion.ALLURE_SYSTEM_SUITE_NAME
import ooo.jtc.allure.AllureUtils.aspectLifecycle
import ooo.jtc.allure.AllureUtils.collectStepsLog
import ooo.jtc.allure.AllureUtils.logFile
import ooo.jtc.allure.getChildBrokenSteps
import ooo.jtc.allure.getChildFailedSteps
import ooo.jtc.allure.steps
import ooo.jtc.logging.LoggerDelegate
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

//region TestLifecycleListener
/**
 * Attach steps to Allure report
 */
class AllureTestListener : TestLifecycleListener {

    override fun beforeTestStop(result: TestResult?) {
        if (result?.fullName == ALLURE_SYSTEM_SUITE_NAME) return
        logFile(fileName = "Steps", attach = collectStepsLog(steps = aspectLifecycle.steps()).toString())
    }

}

/**
 * Set test status if some child (inner) steps are failed or broken.
 * If test has issues it will have the status SKIPPED.
 */
class SetTestStatus : TestLifecycleListener {

    override fun afterTestStop(result: TestResult?) {
        if (getChildFailedSteps(mutableListOf(), result!!.steps).isNotEmpty()) {
            result.status = Status.FAILED
        } else {
            if (getChildBrokenSteps(mutableListOf(), result.steps).isNotEmpty()) {
                result.status = Status.BROKEN
            }
        }
        if (hasTestIssues(result)) result.status = Status.SKIPPED
    }

    private fun hasTestIssues(result: TestResult): Boolean {
        return result.links.any { it.type == ResultsUtils.ISSUE_LINK_TYPE }
    }
}
//endregion

//region StepLifecycleListener
/**
 * If step status updated on [Status.FAILED]
 * it will add in [failedSteps].
 * Also attach exceptions as test attach on steps.
 * If steps is failed or broken, parent steps must be failed/broken.
 */
class SetStepStatus : StepLifecycleListener {
    private val failedSteps = mutableMapOf<StepResult, Status>()

    override fun afterStepUpdate(result: StepResult) {
        if (result.status in listOf(Status.FAILED, Status.BROKEN)) {
            failedSteps[result] = result.status
            if (!result.attachments.any { it.name == "Screenshot" }) addScreenshot(result)
        }
    }

    override fun beforeStepStop(result: StepResult) {
        if (result.steps.isEmpty() && result.statusDetails != null)
            logFile(fileName = result.statusDetails.message, attach = result.statusDetails.trace)
    }

    override fun afterStepStop(result: StepResult) {
        if (failedSteps.containsKey(result))
            result.status = failedSteps[result]
        if (getChildFailedSteps(mutableListOf(), result.steps).isNotEmpty()) {
            result.status = Status.FAILED
        }
    }
}

/**
 * Logged allure steps to console
 */
class StepsConsoleLogger : StepLifecycleListener {
    private val log by LoggerDelegate()

    override fun afterStepStart(result: StepResult) {
        processStep(result, "START")
    }

    override fun afterStepStop(result: StepResult) {
        processStep(result, "END")
    }

    private fun processStep(result: StepResult, desc: String) {
        val name = result.name
        log.info("$desc $name")
    }

}
//endregion

private fun addScreenshot(result: StepResult) {
    if (WebDriverRunner.hasWebDriverStarted()) {
        val bytes = (WebDriverRunner.getWebDriver() as TakesScreenshot).getScreenshotAs(OutputType.BYTES)
        val path = Paths.get("target", "allure-results", "${UUID.randomUUID()}-attachment.png")
        System.err.println("Captured screenshot: ${System.getProperty("user.dir")}\\$path")
        Files.createDirectories(path.parent)
        Files.write(path, bytes)
        result.attachments.add(Attachment().apply {
            name = "Screenshot"
            type = "image/png"
            source = path.toFile().absolutePath
        })
    }
}




