package ooo.jtc.api.letters.frombank.steps

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.core.api.responseAs
import ooo.jtc.documents.ExecutionTicketDto
import ooo.jtc.documents.ReceiveTicketDto
import ooo.jtc.documents.SendTicketDto
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.GenericDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.serialization.SerializationUtils.constructType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.time.LocalDate
import java.util.*

class LetterFromBankSteps(bankUser: User = Users.bankOperator) :
        AbstractDocumentSteps<LetterFromBankDto, LetterFromBankDto>(
                user = bankUser,
                service = Services.LETTER,
                document = LetterFromBankDto::class.java
        ) {
    override val servicePath by lazy { service.baseEndpoint + "/letterfrombank/" + user.userType.pathPrefix }
    private val sendTicketResponseType = constructType(GenericResponseDto::class.java, SendTicketDto::class.java)

    @Step("Получить следующий номер Письма из Банка [{branchId}] (увеличить счётчик: {incrementValue})")
    fun getNextOutgoingDocumentNumber(
            branchId: UUID,
            documentDate: LocalDate = LocalDate.now(),
            incrementValue: Boolean = false
    ): String {
        val response = stepApi.send(
                method = {
                    body(mapOf("branchId" to branchId, "documentDate" to documentDate, "incrementValue" to incrementValue))
                    post("$servicePath/GetNextOutgoingDocumentNumber")
                }
        ).responseAs(GenericDto::class.java)
        return response.data as String
    }

    @Step("Копировать с вложениями Письмо [{documentId}]")
    fun copyWithAttachment(documentId: UUID): GenericResponseDto<LetterFromBankDto> {
        return stepApi.send(
                method = {
                    body("""{"id":"$documentId"}""")
                    post("$servicePath/CopyWithAttachment")
                }
        ).responseAs(responseType)
    }

    @Step("Подготовить ответ на Письмо в Банк [{letterToBankId}] без вложений")
    fun createAnswer(letterToBankId: UUID): GenericResponseDto<LetterFromBankDto> {
        return stepApi.send(
            method = {
                body("""{"letterId":"$letterToBankId"}""")
                post("$servicePath/CreateAnswer")
            }
        ).responseAs(responseType)
    }

    @Step("Подготовить ответ на Письмо в Банк [{letterToBankId}] с вложением")
    fun createAnswerWithAttachment(letterToBankId: UUID): GenericResponseDto<LetterFromBankDto> {
        return stepApi.send(
            method = {
                body("""{"letterId":"$letterToBankId"}""")
                post("$servicePath/CreateAnswerWithAttachment")
            }
        ).responseAs(responseType)
    }

    override fun getReceiveTicket(documentId: UUID): GenericResponseDto<ReceiveTicketDto> {
        throw RuntimeException("Inapplicable to ${DocumentNames.LETTER_FROM_BANK}")
    }

    override fun getExecutionTicket(documentId: UUID): GenericResponseDto<ExecutionTicketDto> {
        throw RuntimeException("Inapplicable to ${DocumentNames.LETTER_FROM_BANK}")
    }

    @Step("Получить квиток об отправке '{this.entityName}' [{documentId}]")
    fun getSendTicket(documentId: UUID): GenericResponseDto<SendTicketDto> {
        return stepApi.send(
            method = {
                body("""{"docId":"$documentId"}""")
                post("$servicePath/GetSendTicket")
            }
        ).responseAs(sendTicketResponseType)
    }
}