package ooo.jtc.api.common.steps

import com.fasterxml.jackson.databind.JavaType
import com.jayway.jsonpath.DocumentContext
import io.qameta.allure.Step
import ooo.jtc.annotations.EntityName
import ooo.jtc.core.api.CoreApi
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.GenericDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.generic.MetadataResponseDto
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Paging
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.serialization.SerializationUtils.JSON_PATH_CONTEXT
import ooo.jtc.serialization.SerializationUtils.constructType
import ooo.jtc.testdata.Service
import ooo.jtc.uaa.User
import java.util.*

/**
 * Base class for implements base steps for [IEntityDto]
 */
abstract class AbstractEntitySteps<T : IEntityDto, U : UpdateIEntityDto<T>>(user: User, service: Service, entityClass: Class<T>) :
    AbstractApiSteps(user, service) {

    abstract fun <T, R : GenericDto<T>> requestDtoWrapper(entity: T): GenericDto<T>
    protected var responseType: JavaType
    protected var responseListType: JavaType
    protected var responsePageType: JavaType

    var entityName: String
    protected var stepApi: CoreApi
    private var entity: Class<*>

    /**
     * Declare entity type for serialization/deserialization entity
     * Declare entity list type for serialization/deserialization entity
     * Declare entity name for using in steps description
     *
     * @param user as [User]. Steps execute by this use authorization.
     * @param document as [Class] Document's class
     * @param service as [Service]
     */
    init {
        this.user = user
        this.service = service
        this.entity = entityClass
        this.responseType = constructType(GenericResponseDto::class.java, entityClass)
        this.responseListType = constructType(GenericListResponseDto::class.java, entityClass)
        this.responsePageType = constructType(GenericPageResponseDto::class.java, entityClass)
        this.entityName = entityClass.getAnnotation(EntityName::class.java).name.ifEmpty { entityClass.simpleName }

        stepApi = user.bearer?.let { authorizedApi } ?: unAuthorizedApi
    }

    @Step("Создать '{this.entityName}'")
    open fun create(
        entity: T,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<T> {

        return stepApi.send(
            method = {
                body(requestDtoWrapper(entity))
                post("$servicePath/Create")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Получить '{this.entityName}' по id={id}")
    open fun getById(
        id: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<T> {
        return stepApi.send(
            method = {
                body("""{"id":"$id"}""")
                post("$servicePath/GetById")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Получить список '{this.entityName}'")
    open fun getPage(
        getPageRequest: GetPageRequest = GetPageRequest(),
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericPageResponseDto<T> {
        return stepApi.send(
            method = {
                body(getPageRequest)
                post("$servicePath/GetPage")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responsePageType)
    }

    @Step("Получить список всех записей '{this.entityName}'")
    fun getPageAll(
        getPageRequest: GetPageRequest = GetPageRequest(),
        limit: Int = 3000,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericPageResponseDto<T> {
        val initRequest = getPage(getPageRequest, withCheckResponseCode, statusCode)
        val totalEntitySize = initRequest.size!!
        if ((initRequest.page?.size ?: 0) == totalEntitySize)
            return initRequest

        if (totalEntitySize > limit) {
            throw RuntimeException("Количество документов больше $limit. Дейтсвительно ли нужно так много документов?")
        }
        getPageRequest.params.paging = Paging(0, totalEntitySize)
        return getPage(getPageRequest, withCheckResponseCode, statusCode)
    }

    @Step("Изменить '{this.entityName}' с id = {entity.id}")
    open fun update(
        entity: U,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<T> {
        return stepApi.send(
            method = {
                body(requestDtoWrapper(entity))
                post("$servicePath/Update")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Удалить '{this.entityName}' по id={id}")
    open fun delete(
        id: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<T> {
        return stepApi.send(
            method = {
                body("""{"id":"$id"}""")
                post("$servicePath/Delete")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Получить Metadata для '{this.entityName}'")
    open fun getMetadata(
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): MetadataResponseDto {
        return stepApi.send(
            method = {
                body("{}")
                post("$servicePath/GetMetadata")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(MetadataResponseDto::class.java)
    }

    @Step("Получить настройки по умолчанию контролей для '{this.entityName}'")
    fun getControlSettingsDescription(
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): DocumentContext {
        return JSON_PATH_CONTEXT.parse(
            stepApi.send(
                method = {
                    body("{}")
                    post("$servicePath/GetControlSettingsDescription")
                },
                check = defaultStatusCheck(withCheckResponseCode, statusCode)
            ).asInputStream()
        )
    }

    @Step("Редактировать настройки контролей для '{this.entityName}'")
    open fun setControlSettings(
        body: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): DocumentContext {
        return JSON_PATH_CONTEXT.parse(
            stepApi.send(
                method = {
                    body(body)
                    post("$servicePath/SetControlSettings")
                },
                check = defaultStatusCheck(withCheckResponseCode, statusCode)
            ).asInputStream()
        )
    }

    @Step("Добавить в избранное {this.entityName} [{entityId}]")
    open fun addToFavorites(entityId: UUID, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        return authorizedApi.send(
            method = {
                body("""{"entityId":"$entityId"}""")
                post("$servicePath/AddToFavorites")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }

    @Step("Удалить из избранного {this.entityName} [{entityId}]")
    open fun removeFromFavorites(entityId: UUID, withCheckResponseCode: Boolean = true): GenericResponseDto<T> {
        return authorizedApi.send(
            method = {
                body("""{"entityId":"$entityId"}""")
                post("$servicePath/RemoveFromFavorites")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }
}

