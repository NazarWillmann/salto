package ooo.jtc.aspectj

import io.qameta.allure.model.TestResultContainer
import ooo.jtc.allure.isRunning
import ooo.jtc.allure.isTestResultRunning
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import kotlin.jvm.Throws


@Aspect
class AllureTestInfoCollector {

    @Pointcut("execution(* io.qameta.allure.AllureLifecycle.startTestContainer(*))")
    fun startTestContainer() { //pointcut body, should be empty
    }

    @Pointcut("execution(* io.qameta.allure.AllureLifecycle.startTestCase(*))")
    fun startTest() { //pointcut body, should be empty
    }

    @After("startTestContainer()")
    @Throws(Throwable::class)
    fun catchStartTestContainer(joinPoint: JoinPoint) {
        var list = containers[Thread.currentThread()]
        if (list.isNullOrEmpty()) {
            list = mutableListOf()
        }
        val testContainers = joinPoint.args.filterIsInstance<TestResultContainer>()
        testContainers.forEach { list.add(it) }
        containers[Thread.currentThread()] = list
    }

    @After("startTest()")
    @Throws(Throwable::class)
    fun catchStartTest(joinPoint: JoinPoint) {
        var list = tests[Thread.currentThread()]
        if (list.isNullOrEmpty()) {
            list = mutableListOf()
        }
        val testCaseIds = joinPoint.args.filterIsInstance<String>()
        testCaseIds.forEach { list.add(it) }
        tests[Thread.currentThread()] = list
    }

    companion object {
        private val containers: ConcurrentMap<Thread, MutableList<TestResultContainer>> = ConcurrentHashMap()
        private val tests: ConcurrentMap<Thread, MutableList<String>> = ConcurrentHashMap()

        val runningContainersInCurrentThread
            get() = containers[Thread.currentThread()]?.filter { it.isRunning() } ?: emptyList()

        val runningTestsInCurrentThread
            get() = tests[Thread.currentThread()]?.filter { isTestResultRunning(it) } ?: emptyList()
    }

}