package examples

import io.qameta.allure.Step
import ooo.jtc.asserts.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Execution(ExecutionMode.CONCURRENT)
object SoftAssertExamples {

    @Step("Step1")
    fun step1() {
        throw RuntimeException("RuntimeException")
    }

    @Test
    fun ft5() {
        "Несколько проверок".allShould(
            { assertThat("true", true) },
            { assertThat("true", false) },
            { assertThat("true", true) },
            { step1() },
            { assertThat("true", true) }
        )

        allShould(
            { assertThat("true", true) },
            { assertThat("true", false) },
            { assertThat("true", true) },
            { step1() },
            { assertThat("true", true) }
        )

        allShouldTrue(
            "true" to { true },
            "false" to { false },
            "RuntimeException" to { throw RuntimeException("RuntimeException") },
            "false" to { false }
        )

        "Несколько проверок".allShouldTrue(
            "true" to { true },
            "false" to { false },
            "RuntimeException" to { throw RuntimeException("RuntimeException") },
            "false" to { false }
        )


        "SoftFailed with Exception" should {
            throw RuntimeException("RuntimeException")
        }

        "SoftFailed" shouldTrue {
            false
        }
        "SoftPassed" shouldTrue {
            true
        }
        "HardPassed" mustTrue {
            true
        }
        "HardFailed" mustTrue {
            false
        }

    }
}