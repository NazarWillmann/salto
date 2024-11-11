package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.VALID
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.IWithAttachments
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.interfaces.nullAccessTokens
import ooo.jtc.scripts.invoke
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.equalTo


/**
 * Basic test template for entity creating.
 * [preExecution] must return object (DTO) of [T] for creation.
 * [testPostExecution] calls [AbstractEntitySteps.delete] function for cleaning.
 * [testResult] must be set as it is passed to [postExecution] and [testPostExecution] after test's [execution].
 * [preCheckingHandlingExp] allows to change [preconditionResult] before checking against /Create-response.
 * [preCheckingHandlingAct] allows to change result of creation before checking against /GetById-response.
 */
open class CreateTestTemplate<T : IEntityDto>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)? = null,
    override var postExecution: ((T) -> Unit)? = null,
    override val testPostExecution: ((T) -> Unit)? = { steps.delete(it.id!!) },
    var preCheckingHandlingExp: ((T) -> T) = { it },
    var preCheckingHandlingAct: ((T) -> T) = { it.apply { if (it is IWithAttachments<*>) it.attachments.nullAccessTokens() } },
    var expValidationResult: ControlCheckResult = VALID
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution) {

    override fun execution(preconditionResult: T?) {
        val createdEntityResponse = steps.create(preconditionResult!!)
        val createdEntity = createdEntityResponse.data!!
        testResult = createdEntity

        preconditionResult.version++
        val handlingExpectedDto = preCheckingHandlingExp(preconditionResult)
        checks.checkIdExist(createdEntityResponse)
        checks.checkRequestResponseValid(handlingExpectedDto, createdEntityResponse, expValidationResult)

        val getByIdResponse = steps.getById(createdEntity.id!!)
        val handledActualDto = preCheckingHandlingAct(createdEntity)
        checks.checkRequestResponseValid(handledActualDto, getByIdResponse, expValidationResult)
    }

    override fun name(): String = "'${steps.entityName}'. CRUD: Создаем запись от пользователя [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Объект для генерации" to preconditionResult!!
        )
    }
}

/**
 * Basic test template for getting created entity.
 * [preExecution] must return object (DTO) of [T] with id
 * for get it by id.
 *
 */
open class GetTestTemplate<T : IEntityDto>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)?,
    override var postExecution: ((T) -> Unit)? = {}
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: T?) {
        testResult = preconditionResult!!
        val genericResponse = steps.getById(preconditionResult.id!!)
        if (preconditionResult is IWithAttachments<*>) preconditionResult.attachments.nullAccessTokens()
        checks.checkConsumeEntity(preconditionResult, genericResponse)
    }

    override fun name(): String = "'${steps.entityName}'. CRUD: Получаем запись по id от пользователя [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Id объекта для получения" to "${preconditionResult!!.id}"
        )
    }
}

/**
 * Basic test template for getting page of entities.
 * [preExecution] must return object (DTO) of [T]
 * for creating if .
 *
 */
open class GetPageTestTemplate<T : IEntityDto>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> List<T>)? = null,
    override var postExecution: ((List<T>) -> Unit)? = null
) : AbstractTest<List<T>, List<T>>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: List<T>?) {
        preconditionResult?.let { testResult = preconditionResult }
        val pageResponse = steps.getPage()
        checks.checkPageResponse(pageResponse)
    }

    override fun name(): String = "'${steps.entityName}'. CRUD: Получаем страницу записей от пользователя [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName
        )
    }
}

/**
 * Basic test template for updating entity.
 * [preExecution] must return created object (DTO) of [U] for update with id.
 * [postExecution] call [AbstractEntitySteps.delete] fun for cleaning
 * In test template must set [testResult] to pass it to [postExecution]
 * [preCheckingHandling] allows to change [preconditionResult] before checking
 */
@Suppress("UNCHECKED_CAST")
open class UpdateTestTemplate<T : IEntityDto, U : UpdateIEntityDto<T>>(
    var steps: AbstractEntitySteps<T, U>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> U)?,
    override var postExecution: ((U) -> Unit)? = { steps.delete(it.id!!) },
    override var testPostExecution: ((T) -> Unit)? = null,
    var preCheckingHandling: ((U) -> U) = { it }
) : AbstractTest<U, T>(preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution) {

    override fun execution(preconditionResult: U?) {
        testResult = preconditionResult!! as T
        val updatedResponse = steps.update(preconditionResult)
        updatedResponse.data?.let { testResult = it }
        preconditionResult.version++
        if (preconditionResult is IWithAttachments<*>) preconditionResult.attachments.nullAccessTokens()
        val handlingExpectedDto = preCheckingHandling(preconditionResult)
        checks.checkUpdated(handlingExpectedDto as T, updatedResponse)
    }

    override fun name(): String = "'${steps.entityName}'. CRUD: Обновляем запись от пользователя [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Объект для обновления" to preconditionResult!!
        )
    }
}

/**
 * Basic test template for deleting entity.
 * [preExecution] must return object (DTO) of [T] for delete it with id.
 * [preCheckingHandling] allows to change [preconditionResult] before checking
 *
 */
open class DeleteTestTemplate<T : IEntityDto>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)?,
    override var postExecution: ((T) -> Unit)? = null,
    open var preCheckingHandling: ((T) -> T) = { it }
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: T?) {
        preconditionResult?.let { testResult = preconditionResult }
        val entityId = preconditionResult!!.id!!
        val deletedResponse = steps.delete(entityId)
        val handlingExpectedDto = preCheckingHandling(preconditionResult)
        checks.checkRemoved(handlingExpectedDto, deletedResponse)
        val getByIdResponse = steps.getById(entityId, statusCode = 500)
        checks.checkNotFound(getByIdResponse)
    }

    override fun name(): String = "'${steps.entityName}'. CRUD: Удаляем запись от пользователя [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Объект для удаления" to preconditionResult!!
        )
    }
}

/**
 * Basic test template for deleting document.
 * [preExecution] must return object (DTO) of [T] for delete it with id.
 * [preCheckingHandling] allows to change [preconditionResult] before checking
 */
open class DeleteDocumentTestTemplate<T : IDocument>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)?,
    override var postExecution: ((T) -> Unit)? = null,
    open var preCheckingHandling: ((T) -> T) = { it },
    var deletedStatus: String
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: T?) {
        preconditionResult?.let { testResult = preconditionResult }
        val entityId = preconditionResult!!.id!!
        val deletedResponse = steps.delete(entityId)
        preconditionResult.version++
        preconditionResult.status = deletedStatus
        val handlingExpectedDto = preCheckingHandling(preconditionResult)
        checks.checkRemoved(handlingExpectedDto, deletedResponse)
        val getByIdResponse = steps.getById(entityId, withCheckResponseCode = true, statusCode = 500)
        "Проверяем, что удалённый документ не может быть получен пользователем" {
            assertThat("Код ответа не соответствует ожидаемому", getByIdResponse.code, equalTo(404))
            assertThat(
                "Сообщение об ошибке не соответствует ожидаемому",
                getByIdResponse.message,
                containsString("Document with id $entityId not found")
            )
        }
    }

    override fun name(): String = "'${steps.entityName}'. CRUD: Удаляем документ от пользователя [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Документ для удаления" to preconditionResult!!
        )
    }
}
