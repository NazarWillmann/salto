package ooo.jtc.aspectj

import io.qameta.allure.model.Parameter
import io.qameta.allure.model.Status
import io.qameta.allure.model.StepResult
import io.qameta.allure.util.ResultsUtils
import io.qameta.allure.util.ResultsUtils.getStatus
import io.qameta.allure.util.ResultsUtils.getStatusDetails
import ooo.jtc.allure.AllureUtils.allureLifecycle
import ooo.jtc.extensions.ellipsis
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import java.util.*

/**
 * Аспекты для динамического добавления шагов в Allure
 */
@Aspect
class AssertSteps {

    /**
     * Перехват MatcherAssert.assertThat(String, boolean)
     */
    @Pointcut("execution(* org.hamcrest.MatcherAssert.assertThat(String, boolean))")
    fun withReason() {
    }

    /**
     * Перехват MatcherAssert.assertThat(String, Object, ..)
     */
    @Pointcut("execution(* org.hamcrest.MatcherAssert.assertThat(String, Object, ..))")
    fun withMatcher() {
    }

    /**
     * Добавление шага в Allure при срабатывании  MatcherAssert.assertThat(String, boolean)
     */
    @Around("withReason()")
    @Throws(Throwable::class)
    fun addStepWithReason(joinPoint: ProceedingJoinPoint) {
        if (!shouldIgnoreStep()) {
            val reason: String = joinPoint.args[0].toString()
            val name = "Проверяем, что отсутствует ошибка: '$reason'"
            addStep(joinPoint, name)
        }
    }

    /**
     * Добавление шага в Allure при срабатывании  MatcherAssert.assertThat(String, Object, ..)
     */
    @Around("withMatcher()")
    @Throws(Throwable::class)
    fun addStepMatherDescription(joinPoint: ProceedingJoinPoint) {
        if (!shouldIgnoreStep()) {
            val actValue: String = joinPoint.args[1]?.toString()?.ellipsis(30) ?: "null"
            val matcherName = joinPoint.args[2].javaClass.simpleName
            val expValue: String = joinPoint.args[2].toString().ellipsis(30)
            val name = "Проверяем, что: \"$actValue\" $matcherName $expValue"
            val params = listOf(
                ResultsUtils.createParameter("actValue", joinPoint.args[1]),
                ResultsUtils.createParameter("expValue", joinPoint.args[2])
            )
            addStep(joinPoint, name, params)
        }
    }

    /**
     * Формирование шага allure.
     */
    private fun addStep(joinPoint: ProceedingJoinPoint, name: String, params: List<Parameter>? = null) {
        val uuid = UUID.randomUUID().toString()
        val result = StepResult().setName(name)
        params?.let { result.setParameters(it) }
        allureLifecycle.startStep(uuid, result)
        try {
            joinPoint.proceed()
            allureLifecycle.updateStep(uuid) { it.status = Status.PASSED }
        } catch (e: Throwable) {
            allureLifecycle.updateStep(uuid) {
                it.status = getStatus(e).orElse(Status.BROKEN)
                it.statusDetails = getStatusDetails(e).orElse(null)
            }
            throw e
        } finally {
            allureLifecycle.stopStep(uuid)
        }
    }


    private fun shouldIgnoreStep(): Boolean {
        //TODO A.Stykalin [20.04.2020] check and fix
        val stack = Thread.currentThread().stackTrace
        val stackTraceElement = stack[3]
        val className = stackTraceElement.className
        val methodName = stackTraceElement.methodName
        val method = Class.forName(className).declaredMethods.find {
            it.isAccessible = true
            it.name == methodName
        }
        val annotation = method?.declaredAnnotations?.find {
            it.annotationClass == IgnoreHamcrestAllureStep::class
        }

        return annotation != null
    }

}