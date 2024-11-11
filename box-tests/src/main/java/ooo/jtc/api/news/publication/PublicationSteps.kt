package ooo.jtc.api.news.publication

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.AvailableActionDto
import ooo.jtc.generic.GenericBatchProcessResponseDto
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.interfaces.getOrException
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.util.*

class PublicationSteps(bankUser: User = Users.bankOperator) :
    AbstractDocumentSteps<PublicationDto, PublicationDto>(
        user = bankUser,
        service = Services.NEWS,
        document = PublicationDto::class.java
    ) {
    override val servicePath by lazy { service.baseEndpoint + "/publication/" + user.userType.pathPrefix }

    @Step("Получить список доступных действий с публикацией")
    fun getActions(): GenericResponseDto<AvailableActionDto> {
        return emptyBodyPostRequest("$servicePath/GetActions")
            .responseAs(avActionResponseType)
    }

    //region Post
    fun postSingle(documentId: UUID, withCheckResponseCode: Boolean = true): PublicationDto {
        return post(listOf(documentId), withCheckResponseCode)
            .documentResults!!.first()
            .dto.getOrException()
    }

    @Step("Передать к размещению публикации {documentIds}")
    fun post(documentIds: List<UUID>, withCheckResponseCode: Boolean = true): GenericBatchProcessResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/Post")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(batchProcessResponseType)
    }

    fun postFromErrorSingle(documentId: UUID, withCheckResponseCode: Boolean = true): PublicationDto {
        return postFromError(listOf(documentId), withCheckResponseCode)
            .documentResults!!.first()
            .dto.getOrException()
    }

    @Step("Передать к размещению публикации в ошибке {documentIds}")
    fun postFromError(documentIds: List<UUID>, withCheckResponseCode: Boolean = true): GenericBatchProcessResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/PostFromError")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(batchProcessResponseType)
    }
    //endregion

    //region Finish
    fun finishPostSingle(documentId: UUID, withCheckResponseCode: Boolean = true): PublicationDto {
        return finishPost(listOf(documentId), withCheckResponseCode)
            .documentResults!!.first().dto.getOrException()
    }

    @Step("Завершить публикации {documentIds}")
    fun finishPost(documentIds: List<UUID>, withCheckResponseCode: Boolean = true): GenericBatchProcessResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/FinishPost")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(batchProcessResponseType)
    }

    fun finishPostFromErrorSingle(documentId: UUID, withCheckResponseCode: Boolean = true): PublicationDto {
        return finishFromErrorPost(listOf(documentId), withCheckResponseCode)
            .documentResults!!.first().dto.getOrException()
    }

    @Step("Завершить публикации в ошибке {documentIds}")
    fun finishFromErrorPost(documentIds: List<UUID>, withCheckResponseCode: Boolean = true): GenericBatchProcessResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/FinishFromError")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(batchProcessResponseType)
    }
    //endregion

    fun cancelPostSingle(documentId: UUID, withCheckResponseCode: Boolean = true): PublicationDto {
        return cancelPost(listOf(documentId), withCheckResponseCode)
            .documentResults!!.first().dto.getOrException()
    }

    @Step("Отменить публикации {documentIds}")
    fun cancelPost(documentIds: List<UUID>, withCheckResponseCode: Boolean = true): GenericBatchProcessResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/CancelPost")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(batchProcessResponseType)
    }

    override fun copy(documentId: UUID, withCheckResponseCode: Boolean): GenericResponseDto<PublicationDto> {
        return copy(documentId, isAttachment = true, isReceiverCustomers = true, withCheckResponseCode)
    }

    @Step("Копировать '{this.entityName}' (isAttachment={isAttachment}, isReceiverCustomers={isReceiverCustomers}) [{documentId}]")
    fun copy(
        documentId: UUID,
        isAttachment: Boolean = true,
        isReceiverCustomers: Boolean = true,
        withCheckResponseCode: Boolean = true
    ): GenericResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(
                    mapOf(
                        "id" to documentId,
                        "isAttachment" to isAttachment,
                        "isReceiverCustomers" to isReceiverCustomers
                    )
                )
                post("$servicePath/Copy")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode = 200)
        ).responseAs(responseType)
    }

    @Step("Получить список '{this.entityName}' для клиентской стороны")
    fun getCustomerPage(
        getPageRequest: GetPageRequest = GetPageRequest(),
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericPageResponseDto<PublicationDto> {
        return stepApi.send(
            method = {
                body(getPageRequest)
                post("$servicePath/GetCustomerPage")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responsePageType)
    }

    fun getPage(getPageRequest: GetPageRequest = GetPageRequest()): GenericPageResponseDto<PublicationDto> {
        return getPage(getPageRequest, withCheckResponseCode = true, statusCode = 200)
    }

    override fun getPage(getPageRequest: GetPageRequest, withCheckResponseCode: Boolean, statusCode: Int)
            : GenericPageResponseDto<PublicationDto> {
        return if (UserType.BANK == this.user.userType) {
            super.getPage(getPageRequest, withCheckResponseCode, statusCode)
        } else {
            getCustomerPage(getPageRequest, withCheckResponseCode, statusCode)
        }
    }
}