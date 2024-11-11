package ooo.jtc.allure

import io.qameta.allure.Allure
import io.qameta.allure.model.*
import io.qameta.allure.util.ResultsUtils
import io.qameta.allure.util.ResultsUtils.getStatus
import io.qameta.allure.util.ResultsUtils.getStatusDetails
import java.util.*

/**
 * Class for collect common steps of suite.
 * Need to [createSystemSuiteTest] in beforeAll callback function and [finishSystemSuiteTest] in afterAll callback function.
 */
class AllureSystemSuite {

    companion object {
        const val SYSTEM_SUITE_NAME = "SYSTEM PREPARATION"
        const val SYSTEM_EPIC_NAME = "SYSTEM"
        const val ALLURE_SYSTEM_SUITE_NAME = "AllureSystemSuite"
        val testCaseId: String = UUID.randomUUID().toString()
        var isInit: Boolean = false

        fun <T> addSystemStep(stepName: String, runnable: () -> T): T {
            if (!isInit) {
                AllureSystemSuite().createSystemSuiteTest("не отработавшего в beforeAll")
            }
            val uuid = UUID.randomUUID().toString()
            val lifecycle = Allure.getLifecycle()
            val mainTestCase = lifecycle.currentTestCaseOrStep
            lifecycle.startStep(testCaseId, uuid, StepResult().setName(stepName))
            val result: T
            try {
                result = runnable.invoke()
                lifecycle.updateStep(uuid) { step: StepResult -> step.status = Status.PASSED }
            } catch (throwable: Throwable) {
                lifecycle.updateStep { s: StepResult ->
                    s.setStatus(getStatus(throwable).orElse(Status.BROKEN))
                        .statusDetails = getStatusDetails(throwable).orElse(null)
                }
                throw RuntimeException(throwable) //TODO A.Stykalin [18.05.2020] check!
            } finally {
                lifecycle.stopStep(uuid)
                mainTestCase.ifPresent { lifecycle.setCurrentTestCase(it) }
            }
            return result
        }
    }

    fun createSystemSuiteTest(suiteName: String?) {
        if (isInit) {
            return
        }
        val testCase = TestResult()
        testCase.uuid = testCaseId
        testCase.fullName = ALLURE_SYSTEM_SUITE_NAME
        testCase.name = "Подготовка общих данных для $suiteName"
        testCase.labels.add(ResultsUtils.createSuiteLabel(SYSTEM_SUITE_NAME))
        testCase.labels.add(ResultsUtils.createEpicLabel(SYSTEM_EPIC_NAME))

        val lifecycle = Allure.getLifecycle()

        lifecycle.scheduleTestCase(testCaseId, testCase)
        val mainTestCase = lifecycle.currentTestCase
        lifecycle.startTestCase(testCaseId)
        mainTestCase.ifPresent { lifecycle.setCurrentTestCase(it) }
        isInit = true
    }

    fun finishSystemSuiteTest() {
        val lifecycle = Allure.getLifecycle()
        lifecycle.stopTestCase(testCaseId)
        val statusDetails = StatusDetails()
        statusDetails.isKnown = true
        lifecycle.updateTestCase(testCaseId) { result: TestResult ->
            result.stage = Stage.FINISHED
            result.status = Status.PASSED
            result.statusDetails = statusDetails
        }
        lifecycle.stopTestCase(testCaseId)
        lifecycle.writeTestCase(testCaseId)
    }
}

infix fun <T> String.systemStep(runnable: () -> T): T {
    return AllureSystemSuite.addSystemStep(this, runnable)
}