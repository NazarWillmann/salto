package ooo.jtc.ui.common.templates

import ooo.jtc.api.common.tests.AbstractTest

open class AbstractUiTest<PR : Any, TR : Any>(
    name: String,
    preExecution: (() -> PR)? = null,
    postExecution: ((PR) -> Unit)? = null,
    testPostExecution: ((TR) -> Unit)? = null,
    val params: ((PR?) -> Map<String, Any>)? = null,
    val testBody: (PR?) -> TR
) : AbstractTest<PR, TR>(
    name = name,
    preExecution = preExecution,
    postExecution = postExecution,
    testPostExecution = testPostExecution
) {

    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: PR?) {
        preconditionResult?.let { testResult = it as TR }
        testResult = testBody.invoke(preconditionResult)

        //TODO A.Stykalin [19.07.2020] Продумать взаимодействие PR -> testBody -> TR
        // т.к. тут мы инитим testResult результатом testBody, в случае когда мы падаем внутри testBody и не возвращаем результат,
        // postExecution не выполняется, т.к. testResult не инициализирован
        // Это особенно опасно в UI тестах на справочники, т.к. зачистка не происходит
    }

    override fun params(): Map<String, Any> = params?.invoke(preconditionResult) ?: emptyMap()
}