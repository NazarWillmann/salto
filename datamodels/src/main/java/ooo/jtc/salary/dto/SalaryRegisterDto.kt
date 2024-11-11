package ooo.jtc.salary.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.UpdateIDocument
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
@EntityName(DocumentNames.SALARY_REGISTER)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class SalaryRegisterDto(
    override var id: UUID? = null,
    override var version: Int = 0,
    override var status: String?,
    override var documentDate: LocalDate,
    override var documentNumber: String,
    override var customerId: UUID?,
    var createdAt: String?,
    var modifiedAt: String?,
    var schemeVersion: String?,
    var channel: String = "WEB",
    var customerName: String?,
    var branchId: UUID,
    var branchName: String?,
    var receiveDate: String?,
    var executionDate: String?,
    var executionMessage: String?,
    var isFavorites: Boolean,
    var payrolls: List<SalaryRegisterPayrollDto>,
    var userId: UUID,
    var customerInn: String?,
    var customerOkpo: String?,
    var accountDebet: String?,
    var accountId: UUID?,
    var official: String?,
    var officialPhone: String?,
    var periodMonth: String?,
    var periodYear: String?,
    var amount: String?,
    var currencyCode: String?,
    var recordsTotal: Int = 0,
    var payDocumentNumber: String?,
    var payDocumentDate: LocalDate?,
    var payDocumentGround: String?,
    var paymentId: String?,
) : UpdateIDocument<SalaryRegisterDto>
