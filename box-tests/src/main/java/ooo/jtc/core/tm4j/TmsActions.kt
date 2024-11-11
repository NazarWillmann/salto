package ooo.jtc.core.tm4j

import io.qameta.allure.model.TestResult
import ooo.jtc.allure.AllureUtils
import ooo.jtc.allure.storage
import ooo.jtc.allure.storageMap
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.tmsSuiteMap
import ooo.jtc.logging.LoggerDelegate
import java.util.concurrent.CopyOnWriteArrayList

//https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727167
object TmsActions {
    private val log by LoggerDelegate()
    private val createdFolders = CopyOnWriteArrayList<String>()

    /**
     * Main function for creating test case in TMS.
     */
    fun createTm4jTestCase(test: AbstractTest<*, *>, error: Throwable?) {
        println("[${test.tmsId}] - ${test.name} start creating in TMS...")
        val tm4jSteps = Tm4jSteps()
        tm4jSteps.findTestCaseByName(test.name())?.let {
            collectTmsAnnotation(it, test.name())
            return
        }

        val componentName = retrieveComponentName(test)
        val folder = retrieveFolder(componentName, test)

        val tc = Tm4jTestCase(
            projectKey = applicationProperties.tms.project,
            name = test.name(),
            folder = folder,
            component = componentName,
            owner = applicationProperties.tms.userId,
            priority = test.priority?.name,
            testScript = prepareTestScript(test.name(), error),
            issueLinks = test.taskIds
        )

        val baseFolder = folder.substringBeforeLast("/")
        if (folder !in createdFolders) {
            tm4jSteps.createFolder(baseFolder).errorMessages?.let { logFolderErrors(it) }
            tm4jSteps.createFolder(folder).errorMessages?.let { logFolderErrors(it) }
        }
        tm4jSteps.createTestCase(tc).key?.let { collectTmsAnnotation(it, test.name()) }
        println("[${test.tmsId}] - ${test.name} successfully created in TMS")
    }

    /**
     * Main function for updating test case in TMS.
     */
    fun updateTm4jTestCase(test: AbstractTest<*, *>, error: Throwable?) {
        println("[${test.tmsId}] - ${test.name} start updating in TMS...")
        val tc = Tm4jTestCase(
            name = test.name(),
            priority = test.priority?.name,
            issueLinks = test.taskIds
        )
        prepareTestScript(test.name(), error)?.let { tc.testScript = it }

        val testCaseKey = test.tmsId!!
        Tm4jSteps().updateTestCase(testCaseKey, tc)
        println("[${test.tmsId}] - ${test.name} successfully updated in TMS")
    }

    private fun retrieveFolder(componentName: String, test: AbstractTest<*, *>): String {
        val testFolder = test.folder ?: ""
        return "/БЭК/$componentName/$testFolder"
    }

    fun retrieveComponentName(test: AbstractTest<*, *>) =
        (test.component
            ?: throw RuntimeException("Для создания ТК в TM4J необходимо для класса ${test::class.simpleName} указать аннотацию ${Component::class}")).ruName

    /**
     * Log create folder error except 'already exist'.
     */
    private fun logFolderErrors(errorList: List<String>) {
        if (!errorList.all { it.contains("already exists") }) {
            log.error(errorList.toString())
        }
    }

    private fun prepareTestScript(testName: String, error: Throwable?): TestScript? {
        error?.let {
            log.warn("Test '$testName' has error. Steps not added to Tm4jTestCase")
            return null
        }
        //TODO A.Stykalin [02.06.2020] convert allure steps to TestScript
        //AllureUtils.aspectLifecycle.steps().map { it.name }
        return null
    }

    /**
     * Collecting and accumulating test info to [tmsSuiteMap]
     */
    private fun collectTmsAnnotation(testCaseKey: String, testName: String) {
        val currentTestCase = AllureUtils.allureLifecycle.currentTestCase.get()
        val testResult = AllureUtils.allureLifecycle.storage().storageMap()[currentTestCase] as TestResult
        val fullName = testResult.fullName.substringBefore("$")
        val suiteClass = fullName.substringBeforeLast(".")
        val testMethod = fullName.substringAfterLast(".")

        val testSuite = tmsSuiteMap.computeIfAbsent(suiteClass) { TmsTestSuite() }
        testSuite.classTags.add(transformClassToTag(testCaseKey))
        val methodTags = testSuite.methodTagsMap.computeIfAbsent(testMethod) { mutableSetOf() }
        methodTags.add(transformMethodToTag(testCaseKey, testName))
    }

    private fun transformClassToTag(testCaseKey: String): String {
        return "@Tag(\"$testCaseKey\") annotation class " + testCaseKey.substringAfterLast("-")
    }

    private fun transformMethodToTag(testCaseKey: String, testName: String): String {
        return "@${testCaseKey.substringAfterLast("-")} //$testName"
    }
}