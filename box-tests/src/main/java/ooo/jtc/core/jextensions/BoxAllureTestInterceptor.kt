package ooo.jtc.core.jextensions

import ooo.jtc.allure.AllureSystemSuite
import ooo.jtc.allure.systemStep
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.failedTestIds
import ooo.jtc.core.needCreateTmsTestCase
import ooo.jtc.core.tmsSuiteMap
import ooo.jtc.logging.LoggerDelegate
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import tools.TmsTagWriter
import java.io.File

/**
 * Listener that executed before dynamic test start
 */
class BoxAllureTestInterceptor : BeforeAllCallback, AfterAllCallback {
    private val log by LoggerDelegate()

    override fun beforeAll(context: ExtensionContext?) {
        AllureSystemSuite().createSystemSuiteTest(context?.displayName)
    }

    override fun afterAll(context: ExtensionContext?) {
        AllureSystemSuite().finishSystemSuiteTest()
        addTmsIdsToTestSuites()
        saveFailedTestIdsForRetry()
    }

    /**
     * Add [org.junit.jupiter.api.Tag]'s with TmsID to *TestSuites from [tmsSuiteMap].
     */
    private fun addTmsIdsToTestSuites() {
        if (needCreateTmsTestCase) {
            if (tmsSuiteMap.isEmpty()) {
                log.error("tmsSuiteMap is empty. Tags not added to TestSuites. Check tmsSuiteMap initialization.")
            } else {
                "Добавить теги созданных ТК в *TestSuites" systemStep { TmsTagWriter.writeTmsTags() }
            }
        }
    }

    /**
     * Saves failed test ids to file for retry run.
     */
    private fun saveFailedTestIdsForRetry() {
        if (failedTestIds.isNotEmpty()) {
            val failedTestFile = File(applicationProperties.failedTestsFile)
            var result = failedTestIds.joinToString(",")
            if (failedTestFile.exists()) {
                val textInFile = failedTestFile.readText()
                result = result.plus(",").plus(textInFile)
            }
            failedTestFile.writeText(result)
        }
    }
}


