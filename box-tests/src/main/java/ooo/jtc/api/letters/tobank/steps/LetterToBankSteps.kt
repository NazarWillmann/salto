package ooo.jtc.api.letters.tobank.steps

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.AvailableActionDto
import ooo.jtc.generic.GenericBatchProcessResponseDto
import ooo.jtc.generic.GenericDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.time.LocalDate
import java.util.*

class LetterToBankSteps(clientUser: User = Users.client) :
    AbstractDocumentSteps<LetterToBankDto, LetterToBankDto>(
        user = clientUser,
        service = Services.LETTER,
        document = LetterToBankDto::class.java
    ) {
    override val servicePath by lazy { service.baseEndpoint + "/lettertobank/" + user.userType.pathPrefix }

    @Step("Получить предзаполненное письмо для пользователя {this.user.login} и организации [{customerId}]")
    fun getPrefilledForCustomer(customerId: UUID): GenericResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body(mapOf("customerId" to customerId))
                post("$servicePath/PreFillForCustomer")
            }
        ).responseAs(responseType)
    }

    @Step("Получить список доступных действий с документом [{this.user.userType}]")
    fun getActions(): GenericResponseDto<AvailableActionDto> {
        return emptyBodyPostRequest("$servicePath/GetActions")
            .responseAs(avActionResponseType)
    }

    @Step("Взять набор Писем [{documentIds}] в обработку")
    fun startProcessing(documentIds: List<UUID>): GenericBatchProcessResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/StartProcessing")
            }
        ).responseAs(batchProcessResponseType)
    }

    @Step("Обработать письмо [{docId}]")
    fun process(docId: UUID, noteFromBank: String): GenericResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body(mapOf("id" to docId, "noteFromBank" to noteFromBank))
                post("$servicePath/Process")
            }
        ).responseAs(responseType)
    }

    @Step("Обработать набор Писем [{documentIds}]")
    fun batchProcess(documentIds: List<UUID>): GenericBatchProcessResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/BatchProcess")
            }
        ).responseAs(batchProcessResponseType)
    }

    @Step("Отозвать письмо [{docId}]")
    fun recall(docId: UUID, noteFromBank: String): GenericResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body(mapOf("id" to docId, "noteFromBank" to noteFromBank))
                post("$servicePath/Recall")
            }
        ).responseAs(responseType)
    }

    @Step("Отозвать набор Писем [{documentIds}]")
    fun batchRecall(documentIds: List<UUID>): GenericBatchProcessResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body(mapOf("documents" to documentIds))
                post("$servicePath/BatchRecall")
            }
        ).responseAs(batchProcessResponseType)
    }

    @Step("Получить следующий номер Письма для Клиента [{customerId}] (увеличить счётчик: {incrementValue})")
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

    @Step("Копировать с вложениями Письмо [{documentId}]")
    fun copyWithAttachment(documentId: UUID): GenericResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body("""{"id":"$documentId"}""")
                post("$servicePath/CopyWithAttachment")
            }
        ).responseAs(responseType)
    }

    @Step("Подготовить ответ на Письмо из Банка [{letterFromBankId}] без вложений")
    fun createAnswer(letterFromBankId: UUID): GenericResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body("""{"letterId":"$letterFromBankId"}""")
                post("$servicePath/CreateAnswer")
            }
        ).responseAs(responseType)
    }

    @Step("Подготовить ответ на Письмо из Банка [{letterFromBankId}] с вложением")
    fun createAnswerWithAttachment(letterFromBankId: UUID): GenericResponseDto<LetterToBankDto> {
        return stepApi.send(
            method = {
                body("""{"letterId":"$letterFromBankId"}""")
                post("$servicePath/CreateAnswerWithAttachment")
            }
        ).responseAs(responseType)
    }
}