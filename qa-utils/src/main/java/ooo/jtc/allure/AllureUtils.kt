@file:Suppress("UNCHECKED_CAST")

package ooo.jtc.allure

import io.qameta.allure.Allure
import io.qameta.allure.AllureLifecycle
import io.qameta.allure.Attachment
import io.qameta.allure.aspects.StepsAspects
import io.qameta.allure.internal.AllureStorage
import io.qameta.allure.model.FixtureResult
import io.qameta.allure.model.Label
import io.qameta.allure.model.Stage
import io.qameta.allure.model.Status
import io.qameta.allure.model.StatusDetails
import io.qameta.allure.model.StepResult
import io.qameta.allure.model.TestResult
import io.qameta.allure.model.TestResultContainer
import io.qameta.allure.util.ResultsUtils
import ooo.jtc.allure.AllureUtils.allureLifecycle
import ooo.jtc.allure.AllureUtils.aspectLifecycle
import ooo.jtc.allure.AllureUtils.logFile
import ooo.jtc.aspectj.AllureTestInfoCollector.Companion.runningContainersInCurrentThread
import ooo.jtc.aspectj.AllureTestInfoCollector.Companion.runningTestsInCurrentThread
import ooo.jtc.extensions.string
import ooo.jtc.extensions.toLocalDateTime
import org.slf4j.LoggerFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.lang.Thread.sleep
import java.nio.charset.Charset
import java.nio.file.Files
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

/**
 * Объект со статическим утилитными функциями для работы с Allure.
 */
object AllureUtils {

    /**
     * Жизненный цикл Allure, полученный из аспектов для шагов.
     */
    val aspectLifecycle: AllureLifecycle = StepsAspects.getLifecycle()

    /**
     * Жизненный цикл Allure.
     */
    val allureLifecycle: AllureLifecycle = Allure.getLifecycle()

    /**
     * Attach bytes in Allure as application/json, named as 'request'
     *
     * @param stream as [ByteArrayOutputStream]]
     */
    @Attachment(value = "request", type = "application/json")
    fun logRequest(stream: ByteArrayOutputStream): ByteArray {
        return attach(stream)
    }

    /**
     * Attach bytes in Allure as application/json, named as 'response'
     *
     * @param stream as [ByteArrayOutputStream]]
     */
    @Attachment(value = "response", type = "application/json")
    fun logResponse(stream: ByteArrayOutputStream): ByteArray {
        return attach(stream)
    }

    /**
     * Attach file in Allure as text/plain
     *
     * @param file as [File]]
     */
    @Attachment(value = "{file}", type = "text/plain")
    fun logFile(file: File): ByteArray {
        val array: ByteArray?
        try {
            array = Files.readAllBytes(file.toPath())
        } catch (e: IOException) {
            throw RuntimeException("Ошибка при добавлении файла в отчет. $e")
        }

        return array
    }

    /**
     * Attach string in Allure as text/plain
     *
     * @param fileName as [String]], default value is 'Attached'
     * @param attach as [String] - attached data
     * @param charset as [Charset]] - data charser, default value is 'UTF-8'
     */
    @Suppress("UNUSED_PARAMETER")
    @Attachment(value = "{fileName}", type = "text/plain")
    fun logFile(fileName: String = "Attached", attach: String, charset: Charset = Charset.forName("UTF-8")): ByteArray {
        return attach.toByteArray(charset)
    }

    /**
     * Get byte array from logs for attaching to allure report.
     *
     * @param log - log as [ByteArrayOutputStream]
     * @return byte array
     */
    private fun attach(log: ByteArrayOutputStream): ByteArray {
        val array = log.toByteArray()
        log.reset()
        return array
    }

    /**
     * Set Allure steps status. Step doesn't stop there, it will steps in [StepLifecycleListener].
     *
     * @param stepId - Step id, current step by default
     * @param ex - exception, that throws into step execution
     * @param status - step Status
     */
    fun setStepStatus(stepId: String = allureLifecycle.currentTestCaseOrStep.get(), ex: Throwable? = null, status: Status) {
        allureLifecycle.updateStep(stepId) {
            it.apply {
                ex?.let {
                    this.statusDetails =
                        StatusDetails().apply {
                            this.trace = ex.stackTrace.toList().joinToString("\n")
                            this.message = ex.message ?: ex::class.simpleName
                        }
                }
            }.apply {
                this.status = status
                this.stage = Stage.FINISHED
            }
        }
    }

    /**
     * Remove step from allure report
     *
     * @param stepId as [String], default value is current step id.
     */
    fun removeStep(stepId: String = allureLifecycle.currentTestCaseOrStep.get()) {
        aspectLifecycle.updateTestCase { it.steps.remove(aspectLifecycle.storage().get(stepId, StepResult::class.java).get()) }
        aspectLifecycle.stopStep()
        aspectLifecycle.storage().remove(stepId)
        allureLifecycle.storage().remove(stepId)

    }

    /**
     * Collect all steps form test case into [StringBuilder] result.
     *
     * @param steps - List of [StepResult] from [AllureLifecycle]
     */
    fun collectStepsLog(result: StringBuilder = StringBuilder(""), offset: String = "", steps: List<StepResult>): StringBuilder {
        steps.forEach {
            result.append("${offset}[${it.start.toLocalDateTime().string()}] [${it.status}] START " + it.name + "\n")
            if (it.steps.isNotEmpty()) {
                collectStepsLog(result, "$offset    ", it.steps)
            }
            result.append("${offset}[${it.stop.toLocalDateTime().string()}] [${it.status}] END " + it.name + "\n")
        }
        return result
    }

    fun failedStepsInAllure(testName: String): List<StepResult> {
        val testResults = allureLifecycle.storage().storageMap().filter { it.value is TestResult }.map { it.value as TestResult }
        val testResult = testResults.find { runningTestsInCurrentThread.contains(it.uuid) && it.name == testName }
        return testResult?.let {
            testResult.steps.filter { it.status == Status.FAILED || it.status == Status.BROKEN }
        } ?: emptyList()

    }


}

fun isTestResultRunning(testResultId: String): Boolean {
    val testResult = allureLifecycle.storage().getTestResult(testResultId)
    return if (testResult.isPresent) {
        testResult.get().stage != Stage.FINISHED
    } else {
        false
    }
}

fun TestResultContainer.isRunning(): Boolean = this.stop == null

/**
 * Enum with Allure Fixtures type. Contains test precondition and test postcondition
 */
enum class AllureFixtureType(val fixtureName: String) {
    BEFORE_TEST("Выполнение шагов предусловия для теста"),
    AFTER_TEST("Выполнение шагов постусловия для теста")
}

private val logger by lazy { LoggerFactory.getLogger(AllureUtils::class.java) }

/**
 * Extension for function than has no input params and return  [Any] for invoking it in one of [AllureFixtureType]
 *
 * @param fixtureType - one of [AllureFixtureType]
 */
fun <T : Any> (() -> T).invokeInAllureFixture(curTest: String, fixtureType: AllureFixtureType, fixtureName: String = fixtureType.fixtureName): T {
    return proceedAllureFixture(curTest, fixtureName, fixtureType) { this.invoke() }
}

/**
 * Extension for function than has one [Any] input params and return  [Any] for invoking it in one of [AllureFixtureType]
 *
 * @param fixtureType - one of [AllureFixtureType]
 */
fun <R : Any> ((R) -> Any).invokeInAllureFixture(
    curTest: String,
    value: R,
    fixtureType: AllureFixtureType,
    fixtureName: String = fixtureType.fixtureName
): Any {
    return proceedAllureFixture(curTest, fixtureName, fixtureType) { this.invoke(value) }
}

private fun <T : Any> proceedAllureFixture(
    currentTest: String = aspectLifecycle.testResultId(),
    fixtureName: String,
    fixtureType: AllureFixtureType,
    function: () -> T
): T {
    val testContainer = aspectLifecycle.testContainer(currentTest)
    val fixtureId = UUID.randomUUID().toString()
    logger.info("Start Fixture $fixtureName  for ${testContainer.name}")
    when (fixtureType) {
        AllureFixtureType.BEFORE_TEST -> aspectLifecycle.startPrepareFixture(testContainer.uuid, fixtureId, FixtureResult().setName(fixtureName))
        AllureFixtureType.AFTER_TEST -> aspectLifecycle.startTearDownFixture(
            testContainer.uuid,
            fixtureId,
            FixtureResult().setName(fixtureType.fixtureName)
        )
    }
    val result: T
    try {
        result = function.invoke()
        aspectLifecycle.updateFixture(fixtureId) { it.status = Status.PASSED }
    } catch (throwable: Throwable) {
        failFixture(throwable, fixtureId)
        throw throwable
    } finally {
        aspectLifecycle.stopFixture(fixtureId)
        logger.info("Stop Fixture $fixtureName  for ${testContainer.name}")
        if (currentTest.isNotEmpty()) aspectLifecycle.setCurrentTestCase(currentTest)
    }
    return result
}

/**
 * Set FAILED or BROKEN status in fixture.
 */
private fun failFixture(throwable: Throwable, fixtureId: String) {
    val status = if (throwable is AssertionError) Status.FAILED else Status.BROKEN
    val statusDetails = ResultsUtils.getStatusDetails(throwable)
    aspectLifecycle.updateFixture(fixtureId) { fixtureResult ->
        fixtureResult.status = status
        statusDetails.ifPresent { fixtureResult.statusDetails = it }
    }
    statusDetails.ifPresent { logFile(fileName = it.message, attach = it.trace) }
}

/**
 * @return storage as [AllureStorage] from [AllureLifecycle] using reflection
 */
fun AllureLifecycle.storage(): AllureStorage {
    val storageField = this::class.java.getDeclaredField("storage")
    storageField.isAccessible = true
    return storageField.get(StepsAspects.getLifecycle()) as AllureStorage
}

/**
 * @return storage map as [ConcurrentHashMap<String, Object>] from [AllureStorage] using reflection
 */
fun AllureStorage.storageMap(): ConcurrentHashMap<String, Any> {
    val storageField = this::class.java.getDeclaredField("storage")
    storageField.isAccessible = true
    return storageField.get(Allure.getLifecycle().storage()) as ConcurrentHashMap<String, Any>
}

/**
 * @param testCaseId - testCase id as [String], by default current testCase id
 *
 * @return list of [StepResult] from
 */
fun AllureLifecycle.steps(testCaseId: String? = this.currentTestCase.orElse(null)): List<StepResult> =
    testCaseId?.let { this.storage().getTestResult(testCaseId).orElseGet { TestResult() }.steps } ?: emptyList()

/**
 * @return testContainerId as [String] for current testCase
 */
fun AllureLifecycle.testContainer(testResultId: String = this.currentTestCase.get()): TestResultContainer {
/*  Для дебага и для размышлений... $testContainer - это результат этой функции. И на выходе они на всем прогоне были одинаковыми.
    Возможно, нет необходимости замарачиваться с аспектами в AllureTestInfoCollector...
    val tcName = allureLifecycle.storage().storageMap().entries.map { it.value }.filterIsInstance<TestResult>().first { it.uuid == testResultId }.name
    val allureTc = allureLifecycle.storage().storageMap().entries.map { it.value }.filterIsInstance<TestResultContainer>().first { it.name == tcName }
    println("thread: $thread => testContainer: $testContainer | allureTc: $allureTc") */

    val tests = this.storage().storageMap().entries.map { it.value }.filterIsInstance<TestResult>()
    if (testResultId.isEmpty()) {
        logger.warn("No test result found for $testResultId")
        return runningContainersInCurrentThread.minByOrNull { it.start }!!
    }
    val testName = tests.first { it.uuid == testResultId }.name
        ?: throw RuntimeException(
            "Can't found '${this.currentTestCase.get()}' in Storage#testResults: ${tests.map { it.uuid }}"
        )
    return runningContainersInCurrentThread.find { it.name == testName }
        ?: throw RuntimeException(
            "Can't found '$testName' in Storage#TestResultContainer: ${runningContainersInCurrentThread.map { it.name }}"
        )
}

/**
 * @return testContainerId as [String] for current testCase
 */
fun AllureLifecycle.testResultId(timeout: Long = 10000L): String {
    val start = LocalDateTime.now()
    val end = start.plus(timeout, ChronoUnit.MILLIS)
    do {
        val map = this.storage().storageMap()
        val testResult = map.filter { it.key == currentTestCase.get() }.entries.first()
        if (testResult.value is TestResult)
            return testResult.key
        else {
            logger.warn("Wait invoking fixture in other tests")
            sleep(timeout / 5)
        }
    } while (LocalDateTime.now().isBefore(end))
    logger.error("No test result found for ${currentTestCase.get()} ")
    return ""
}

/**
 * Added tmses links for testCase in Allure report
 *
 * @param testCaseId as [String], by default current testCase id
 * @param tmses - list of tms id as [String]
 *
 */
fun AllureLifecycle.addTmses(testCaseId: String = this.currentTestCase.get(), tmses: List<String>) =
    tmses.forEach { tms -> this.updateTestCase(testCaseId) { it.links.add(ResultsUtils.createTmsLink(tms)) } }

/**
 * Added issues links for testCase in Allure report
 *
 * @param testCaseId as [String], by default current testCase id
 * @param issues - list of issues id as [String]
 *
 */
fun AllureLifecycle.addIssues(testCaseId: String = this.currentTestCase.get(), issues: List<String>) =
    issues.forEach { issue -> this.updateTestCase(testCaseId) { it.links.add(ResultsUtils.createIssueLink(issue)) } }

/**

 * Added labels for testCase in Allure report
 *
 * @param testCaseId as [String], by default current testCase id
 * @param labels - list of [Label]
 *
 */
fun AllureLifecycle.addLabels(testCaseId: String = this.currentTestCase.get(), labels: List<Label>) =
    labels.forEach { label -> this.updateTestCase(testCaseId) { it.labels.add(label) } }


/**
 * Added test params for testCase in Allure report
 *
 * @param testCaseId as [String], by default current trstCase id
 * @param params - map of params as [Map]
 *
 */
fun AllureLifecycle.addTestParams(testCaseId: String = this.currentTestCase.get(), params: Map<String, Any>) =
    params.forEach { param -> this.updateTestCase(testCaseId) { it.parameters.add(ResultsUtils.createParameter(param.key, param.value)) } }

fun getChildFailedSteps(list: MutableList<String>, steps: List<StepResult>): List<String> =
    getChildStepsWithStatus(list, steps, Status.FAILED)

fun getChildBrokenSteps(list: MutableList<String>, steps: List<StepResult>): List<String> =
    getChildStepsWithStatus(list, steps, Status.BROKEN)

fun getChildStepsWithStatus(list: MutableList<String>, steps: List<StepResult>, status: Status): List<String> {
    steps.find { it.status == status }?.let { list.add(it.name) }
    steps.forEach { getChildFailedSteps(list, it.steps) }
    return list
}

/**
 * Extension for add any to allure report as attachment
 */
fun <T : Any> T.attachToAllure(attachName: String = "result"): T {
    Allure.addAttachment(attachName, this.toString())
    return this
}

/**
 * Debug function.
 */
fun printStorage() {
    allureLifecycle.storage().storageMap().forEach { (t: String, u: Any) ->
        var name: String = "Object hasn't name"
        when (u) {
            is TestResult -> name = "[TestResult] " + u.name
            is TestResultContainer -> name = "[TestResultContainer] " + u.name
            is FixtureResult -> name = "[FixtureResult] " + u.name
            is StepResult -> name = "[StepResult] " + u.name
        }
        println("$t => $name")
    }
}
