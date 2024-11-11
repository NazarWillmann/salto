package ooo.jtc.api.common.tests

/**
 * Base class for test which not need pre-/post- executions.
 */
open class UnitBeTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : AbstractBeTest<Unit, Unit>(
    name = name,
    params = params,
    testBody = testBody
)