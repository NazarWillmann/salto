package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.controls.IControls
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.INestedDictionaryControls
import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.VALID
import ooo.jtc.documents.ControlCheckResult.WARNING
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.scripts.invoke
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat

open class ControlTestTemplate<T : IEntityDto>(
    open var testName: String,
    var control: IControls,
    open var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)?,
    override var postExecution: ((T) -> Unit)? = null,
    override var testPostExecution: ((T) -> Unit)? = null
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution) {

    override fun execution(preconditionResult: T?) {
        val expCheckResult = control.getCheckResult()
        val responseDto = steps.create(preconditionResult!!)

        val resultStatus = responseDto
            .validationResult.getOrException()
            .result
        redefineTestPostExecution(resultStatus, preconditionResult, responseDto)
        checks.checkControl(expCheckResult, responseDto)
    }

    protected fun redefineTestPostExecution(resultStatus: ControlCheckResult?, preconditionResult: T?, responseDto: GenericResponseDto<T>) {
        testResult = preconditionResult
        if (responseDto.data?.id != null) testResult?.id = responseDto.data?.id
        if (null == resultStatus || VALID == resultStatus || WARNING == resultStatus) {
            testPostExecution = if (testPostExecution == null) {
                { steps.delete(it.id!!) }
            } else testPostExecution
        }
    }

    override fun name(): String = "'${steps.entityName}'. Контроль: $testName [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "DTO для проверки" to preconditionResult!!
        )
    }
}

open class NestedControlTestTemplate<T : IEntityDto>(
    override var testName: String,
    var docControl: INestedControls,
    override var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)?,
    override var postExecution: ((T) -> Unit)? = null,
    override var testPostExecution: ((T) -> Unit)? = null,
) : ControlTestTemplate<T>(
    testName = testName, control = docControl, steps = steps,
    preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution
) {

    override fun execution(preconditionResult: T?) {
        val expValidationResult = docControl.getInfoForChecks()
        val responseDto = steps.create(preconditionResult!!)

        val resultStatus = responseDto
            .validationResult.getOrException()
            .result
        redefineTestPostExecution(resultStatus, preconditionResult, responseDto)

        val controlCheckMessage = if (docControl.checkFieldName == null)
            "Проверяем контроль с id '${docControl.controlType.id}'"
        else
            "Проверяем контроль на поле ${docControl.checkFieldName}"

        controlCheckMessage {
            val actValidationResult = responseDto.validationResult
            assertThat("Отсутствует результат общей валидации 'validationResult'", null != actValidationResult)
            checks.checkNestedControl(expValidationResult, actValidationResult!!)
        }
    }
}

open class NestedDictionaryControlTestTemplate<T : IEntityDto>(
    override var testName: String,
    var dictControl: INestedDictionaryControls,
    override var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)?,
    override var postExecution: ((T) -> Unit)? = null,
    override var testPostExecution: ((T) -> Unit)? = null,
) : ControlTestTemplate<T>(
    testName = testName, control = dictControl, steps = steps,
    preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution
) {
    override fun execution(preconditionResult: T?) {
        val expValidationResult = dictControl.getInfoForChecks()
        val responseDto = steps.create(preconditionResult!!)

        val resultStatus = responseDto
            .validationResult.getOrException()
            .result
        redefineTestPostExecution(resultStatus, preconditionResult, responseDto)

        "Проверяем контроль на поле ${dictControl.checkFieldName}" {
            val actValidationResult = responseDto.validationResult
            assertThat("Отсутствует результат общей валидации 'validationResult'", null != actValidationResult)
            checks.checkNestedDictionaryControl(expValidationResult, actValidationResult!!)
        }
    }
}

/**
 * Template for testing BE validation that bypass controls.
 */
open class ServerErrorTestTemplate<T : IEntityDto, U : UpdateIEntityDto<T>>(
    testName: String,
    user: User,
    preExecution: (() -> T)?,
    postExecution: ((T) -> Unit)? = null,
    steps: AbstractEntitySteps<T, U>,
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
    testBody: (T?) -> Unit = { createEntityDto ->
        val createEntityResponse = steps.create(entity = createEntityDto!!, statusCode = expectedHttpCode)
        ApiEntityChecks<T>().checkErrorResponse(createEntityResponse, expectedCode, expectedMessage)
    }
) : AbstractBeTest<T, Unit>(
    name = "'${steps.entityName}'. Контроль: ${testName}. [${user.userType}]",
    preExecution = preExecution,
    postExecution = postExecution,
    testBody = testBody
)