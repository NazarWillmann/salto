package ooo.jtc.be

import io.qameta.allure.Step
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.logging.LoggerDelegate
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import kotlin.random.Random

private const val A1 = "Action one"
private const val A2 = "Action two"
private const val A3 = "Action three"

//@formatter:off
@Tag("JTCSALTO-T1629") annotation class T1629
@Tag("JTCSALTO-T1631") annotation class T1631
//@formatter:on


object Tm4jTests {

    @T1629
    @T1631
    @TestFactory
    fun tm4jTests(): List<DynamicTest> {
        val tests = listOf(
            UnitBeTest(
                name = "Тест для проверки интеграции TM4J и Jenkins",
                testBody = { tm4jTestForJenkinsBody() }
            ).withId(T1629::class),
            UnitBeTest(
                name = "Флаки-тест для проверки интеграции TM4J и Jenkins",
                testBody = { tm4jFlakyForJenkinsBody() }
            ).withId(T1631::class)
        )
        return EntityTestGenerator.generate(tests)
    }

    private fun tm4jTestForJenkinsBody() {
        val steps = Tm4jTestSteps()
        val resultOne = steps.actionOne()
        steps.checkAction(A1, resultOne)
    }

    private fun tm4jFlakyForJenkinsBody() {
        val steps = Tm4jTestSteps()
        val resultOne = steps.actionOne()
        steps.checkAction(A1, resultOne)
        val resultTwo = steps.actionTwo()
        steps.checkAction(A2, resultTwo)
    }
}

class Tm4jTestSteps {

    private val log by LoggerDelegate()

    @Step("Выполнить действие 1")
    fun actionOne(): String {
        log.info(A1)
        return A1
    }

    @Step("Выполнить действие 2")
    fun actionTwo(): String {
        val res = if (Random.nextBoolean()) A2 else A3
        log.info(res)
        return res
    }

    @Step("Действие выполнено {exp}")
    fun checkAction(exp: String, act: String) {
        assertThat(act, equalTo(exp))
    }

}