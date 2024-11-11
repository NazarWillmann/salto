package ooo.jtc.documents

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ooo.jtc.generic.ValidationResultDto
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class SendTicketDto(
    var docId: UUID,
    var customerId: UUID,
    var customerName: String?,
    var branchId: UUID,
    var branchName: String?,
    var documentDate: LocalDate,
    var documentNumber: String,
    var status: String,
    var sendDate: ZonedDateTime?,
    var sendUserName: String?,
    var sendMessage: String?,
    var signCheckMessage: String?,
    var controlResults: ValidationResultDto?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ReceiveTicketDto(
    var docId: UUID,
    var customerId: UUID,
    var customerName: String?,
    var branchId: UUID,
    var branchName: String?,
    var documentDate: LocalDate,
    var documentNumber: String,
    var status: String,
    var receiveDate: ZonedDateTime?,
    var receiveUserName: String?,
    var receiveMessage: String?,
    var signCheckMessage: String?,
    var cpmString: String?
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExecutionTicketDto(
    var docId: UUID,
    var customerId: UUID,
    var customerName: String,
    var branchId: UUID,
    var branchName: String,
    var documentDate: LocalDate,
    var documentNumber: String,
    var status: String,
    var executionDate: ZonedDateTime,
    var executionUserName: String,
    var executionMessage: String
)