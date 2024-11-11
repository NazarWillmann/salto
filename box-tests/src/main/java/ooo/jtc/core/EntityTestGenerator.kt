@file:Suppress("UNCHECKED_CAST")

package ooo.jtc.core

import io.qameta.allure.util.ResultsUtils
import ooo.jtc.allure.AllureFixtureType
import ooo.jtc.allure.AllureUtils.allureLifecycle
import ooo.jtc.allure.addIssues
import ooo.jtc.allure.addTestParams
import ooo.jtc.allure.addTmses
import ooo.jtc.allure.invokeInAllureFixture
import ooo.jtc.allure.storage
import ooo.jtc.allure.systemStep
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.asserts.checkSoftAsserts
import ooo.jtc.core.runner.TagsUtils.idsFromTagsProperty
import ooo.jtc.core.tm4j.Tm4jSteps
import ooo.jtc.core.tm4j.TmsActions
import ooo.jtc.core.tm4j.TmsTestSuite
import ooo.jtc.logging.LoggerDelegate
import org.junit.jupiter.api.DynamicTest
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList

private val needUpdateResults by lazy { System.getProperty("tmsResult", "off") == "on" }

/**
 * Operations for create or update test cases in TMS should be manually control.
 * !Please watch out for value by default it should be FALSE.
 */
val needCreateTmsTestCase by lazy { applicationProperties.tms.createTestCase }
val needUpdateTmsTestCase by lazy { applicationProperties.tms.updateTestCase }

/**
 * Map for collecting info about tests for TMS.
 */
val tmsSuiteMap: ConcurrentHashMap<String, TmsTestSuite> by lazy { ConcurrentHashMap<String, TmsTestSuite>() }

/**
 * List of TmsIds of failed tests.
 * Need for retry.
 */
val failedTestIds: CopyOnWriteArrayList<String> by lazy { CopyOnWriteArrayList<String>() }

/**
 * Object for generating JUnit Dynamic tests from
 */
object EntityTestGenerator {

    private val log by LoggerDelegate()
    private val MAX_RETRY: Int = applicationProperties.maxRetry

    /**
     * Generate [DynamicTest] test from  [AbstractTest]
     *
     * There are adding Tmses and issues links. Add test params.
     *
     * At first execute test precondition function (if it not equals EMPTY_FUNCTION)and store result in preconditionResult in Abstract Test
     *
     * Then will execute execution function from [AbstractTest] and store result in testResult
     *
     * And finally  execute test postcondition function (if it not equals EMPTY_FUNCTION_WITH_INPUT_PARAMS)
     */
    fun <RP : Any, RT : Any> toDynamicTest(test: AbstractTest<RP, RT>): DynamicTest =

        DynamicTest.dynamicTest(test.name())
        {
            if (skipTestWhenCreateTmsTestCase(test)) return@dynamicTest
            val currentTestCaseId = processAllureInfo(test)

            var rootCause: Throwable? = null
            try {
                testPreconditionExecution(test, currentTestCaseId)
                test.execution(test.preconditionResult)
                checkSoftAsserts(test.name())
            } catch (e: Throwable) {
                saveFailedIdForRetry(test)
                rootCause = e
                throw rootCause
            } finally {
                tm4jOperations(test, rootCause)
                test.testPostExecution?.let { testPostExecution(test, rootCause, currentTestCaseId) }
                test.postExecution?.let { postExecution(test, rootCause, currentTestCaseId) }
            }
        }


    fun <T : AbstractTest<*, *>> generate(testList: List<T>): MutableList<DynamicTest> =
        testList
            .filter { test -> idsFromTagsProperty.isEmpty() || test.tmsId in idsFromTagsProperty }
            .map { toDynamicTest(it) }
            .toMutableList()

    fun <T : AbstractTest<*, *>> generate(vararg tests: T): MutableList<DynamicTest> = generate(tests.toList())


    /**
     * Optimization of test run time for tests with issues.
     */
    private fun skipIfHasIssues(currentTestCaseId: String): Boolean {
        val testResult = allureLifecycle.storage().getTestResult(currentTestCaseId)
        if (testResult.isPresent) {
            return testResult.get().links.any { it.type == ResultsUtils.ISSUE_LINK_TYPE }.also { if (it) log.warn("Test has issue and skipped") }
        }
        return false
    }

    /**
     * Prevention for fail and performance optimizations when create Tms TestCase.
     */
    private fun <RP : Any, RT : Any> skipTestWhenCreateTmsTestCase(test: AbstractTest<RP, RT>): Boolean {
        if (needCreateTmsTestCase) TmsActions.retrieveComponentName(test) //prevent fail test before execution
        test.tmsId?.let {
            if (needCreateTmsTestCase) return true // skip test execution for tests with id, when tmsCreate=on
        }
        return false
    }

    /**
     * Collects and sets info for Allure report from AbstractTest [test].
     */
    private fun <RP : Any, RT : Any> processAllureInfo(test: AbstractTest<RP, RT>): String {
        test.tmsId?.let { allureLifecycle.addTmses(tmses = listOf(it)) }
        allureLifecycle.addIssues(issues = test.issues)
        return allureLifecycle.currentTestCase.get()
    }

    private fun <RP : Any, RT : Any> testPreconditionExecution(test: AbstractTest<RP, RT>, currentTestCaseId: String) {
        test.preconditionResult = test.preExecution?.invokeInAllureFixture(currentTestCaseId, AllureFixtureType.BEFORE_TEST)
        allureLifecycle.addTestParams(params = test.params())
    }

    /**
     * Actions for postExecution for preExecutionResult (preconditionResult).
     */
    private fun <RP : Any, RT : Any> postExecution(
        test: AbstractTest<RP, RT>,
        rootCause: Throwable?,
        currentTestCaseId: String
    ) {
        if (test.preconditionResult == null) {
            val message = "You MUST initialize `preconditionResult` for invoke `postExecution`."
            rootCause
                ?.let { throw RuntimeException("$message\nCause: ${rootCause.message}", rootCause) }
                ?: throw RuntimeException(message)
        }
        test.postExecution?.invokeInAllureFixture(currentTestCaseId, test.preconditionResult!!, AllureFixtureType.AFTER_TEST)
    }

    /**
     * Actions for postExecution for testExecutionResult (testResult).
     */
    private fun <RP : Any, RT : Any> testPostExecution(
        test: AbstractTest<RP, RT>,
        rootCause: Throwable?,
        currentTestCaseId: String
    ) {
        if (test.testResult == null) {
            val message = "You MUST initialize `testResult` for invoke `testPostExecution`."
            rootCause
                ?.let { throw RuntimeException("$message\nCause: ${rootCause.message}", rootCause) }
                ?: throw RuntimeException(message)
        }
        test.testPostExecution?.invokeInAllureFixture(currentTestCaseId, test.testResult!!, AllureFixtureType.AFTER_TEST)
    }

    private fun saveFailedIdForRetry(test: AbstractTest<*, *>) {
        test.tmsId?.let { failedTestIds.add(it) }
    }

    //region Tm4j Operations
    /**
     * All operations for test with Tm4j.
     */
    private fun <RP : Any, RT : Any> tm4jOperations(test: AbstractTest<RP, RT>, rootCause: Throwable?) {
        createOrUpdateTm4jTestCase(test, rootCause)
        updateTm4jStatus(test, rootCause)
    }

    /**
     * Update status in TM4J when [needUpdateResults] is 'on'.
     */
    private fun updateTm4jStatus(test: AbstractTest<*, *>, error: Throwable?) {
        test.tmsId?.let { if (needUpdateResults) Tm4jSteps().updateTestExecution(test.tmsId, test.name, error) }
    }

    /**
     * Create or update test case in TM4J.
     */
    private fun createOrUpdateTm4jTestCase(test: AbstractTest<*, *>, error: Throwable?) {
        if (needCreateTmsTestCase && test.tmsId == null) {
            "Создать ТК в ТМС для теста '${test.name()}'" systemStep { TmsActions.createTm4jTestCase(test, error) }
        } else if (needUpdateTmsTestCase && test.tmsId != null) {
            "Обновить ТК в ТМС для теста '${test.name()}'" systemStep { TmsActions.updateTm4jTestCase(test, error) }
        }
    }
    //endregion
}

/**
 * Utility function for debug.
 * Allows to run [AbstractTest] from any place of code.
 * e.g.
 *```
 * @Test
 * fun simpleTest(){
 *   UaaUserGetTest().runTest()
 * }
 *```
 */
fun AbstractTest<*, *>.runTest() {
    EntityTestGenerator.toDynamicTest(this).executable.execute()
}

