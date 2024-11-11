package ooo.jtc.api.curtransfer.steps

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.core.api.responseAs
import ooo.jtc.curtransfer.dto.CurTransferDto
import ooo.jtc.generic.AvailableActionDto
import ooo.jtc.generic.GenericBatchResponseDto
import ooo.jtc.generic.GenericDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.time.LocalDate
import java.util.UUID


class CurTransferSteps(clientUser: User = Users.client) :
    AbstractDocumentSteps<CurTransferDto, CurTransferDto>(
        user = clientUser,
        service = Services.CUR_RKO,
        document = CurTransferDto::class.java
    ) {
    override val servicePath by lazy { service.baseEndpoint + "/curtransfer/" + user.userType.pathPrefix }


    @Step("Получить предзаполненный документ '{this.entityName}' для организации [{customerId}]")
    fun preFillForCustomer(customerId: UUID): GenericResponseDto<CurTransferDto> {
        return stepApi.send(
            method = {
                body(mapOf("customerId" to customerId))
                post("$servicePath/PreFillForCustomer")
            }
        ).responseAs(responseType)
    }

    @Step("Получить список доступных действий с документом '{this.entityName}' [{this.user.userType}]")
    fun getActions(): GenericResponseDto<AvailableActionDto> {
        return emptyBodyPostRequest("$servicePath/GetActions")
            .responseAs(avActionResponseType)
    }

    @Step("Отозвать документ '{this.entityName}' [{docId}]")
    fun recall(docId: UUID, noteFromBank: String): GenericResponseDto<CurTransferDto> {
        return stepApi.send(
            method = {
                body(mapOf("docId" to docId, "noteFromBank" to noteFromBank))
                post("$servicePath/Recall")
            }
        ).responseAs(responseType)
    }

    @Step("Отозвать набор документов '{this.entityName}' [{documentIds}]")
    fun batchRecall(documentIds: List<UUID>): GenericBatchResponseDto<CurTransferDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/BatchRecall")
            }
        ).responseAs(batchResponseType)
    }

    @Step("Получить следующий номер документа '{this.entityName}' для Клиента [{customerId}] (увеличить счётчик: {incrementValue})")
    fun getNextIngoingDocumentNumber(
        customerId: UUID,
        documentDate: LocalDate = LocalDate.now(),
        incrementValue: Boolean = false
    ): String {
        val response = stepApi.send(
            method = {
                body(mapOf("customerId" to customerId, "documentDate" to documentDate, "incrementValue" to incrementValue))
                post("$servicePath/GetNextIngoingDocumentNumber")
            }
        ).responseAs(GenericDto::class.java)
        return response.data as String
    }
}