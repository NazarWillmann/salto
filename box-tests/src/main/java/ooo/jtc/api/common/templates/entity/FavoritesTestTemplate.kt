package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

/**
 * AddToFavoritesTestTemplate.
 * [retrieveIsFavorites] - lambda-function for retrieving `IsFavorites` flag from DTO<[T]>.
 * [preExecution] should provide ID for add to favorites
 */
open class AddToFavoritesTestTemplate<T : IEntityDto>(
    var retrieveIsFavorites: (T) -> Boolean,
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> UUID)?,
    override var postExecution: ((UUID) -> Unit)? = {}
) : AbstractTest<UUID, UUID>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: UUID?) {
        testResult = preconditionResult!!
        val responseDto = steps.addToFavorites(preconditionResult)
        checks.checkAddFavorites(responseDto, retrieveIsFavorites)
    }

    override fun name(): String = "'${steps.entityName}': Добавить в избранное [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Id объекта для добавления в избранное" to "$preconditionResult"
        )
    }
}

/**
 * RemoveFromFavoritesTestTemplate.
 * [retrieveIsFavorites] - lambda-function for retrieving `IsFavorites` flag from DTO<[T]>.
 * [preExecution] should provide ID for add to favorites
 */
open class RemoveFromFavoritesTestTemplate<T : IEntityDto>(
    var retrieveIsFavorites: (T) -> Boolean,
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> UUID)?,
    override var postExecution: ((UUID) -> Unit)? = {}
) : AbstractTest<UUID, UUID>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: UUID?) {
        testResult = preconditionResult!!
        val responseDto = steps.removeFromFavorites(preconditionResult)
        checks.checkRemoveFromFavorites(responseDto, retrieveIsFavorites)
    }

    override fun name(): String = "'${steps.entityName}': Удалить из избранного [${steps.user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Id объекта для добавления в избранное" to "$preconditionResult"
        )
    }
}