package ooo.jtc.api.common.tests

open class AbstractBeTest<PR : Any, TR : Any>(
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

    override fun execution(preconditionResult: PR?) {
        //TODO Sergeyev [2021.03.23]: still no postExecution when test fails
        testResult = testBody.invoke(preconditionResult)
    }

    override fun params(): Map<String, Any> = params?.invoke(preconditionResult) ?: emptyMap()
}