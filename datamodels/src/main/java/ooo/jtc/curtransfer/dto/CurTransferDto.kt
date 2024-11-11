package ooo.jtc.curtransfer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.curtransfer.model.CurTrChargeType
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.UpdateIDocument
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

@KotlinBuilder
@EntityName(DocumentNames.CUR_TRANSFER)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurTransferDto(
    override var id: UUID? = null,
    override var version: Int = 0,
    override var documentNumber: String,
    override var documentDate: LocalDate,
    override var customerId: UUID?,
    override var status: String?,

    var createdAt: ZonedDateTime? = null,       // empty in Create/Update
    var modifiedAt: ZonedDateTime? = null,      // empty in Create/Update
    var receiveDate: ZonedDateTime? = null,     // empty in Create/Update
    var executionDate: ZonedDateTime? = null,   // empty in Create/Update
    @JvmField var isFavorites: Boolean? = null, // empty in Create/Update
    var messageFromBank: String? = null,        // empty in Create/Update; ?receiveMessage/executionMessage?

    var customerName: String?,
    var branchId: UUID,
    var branchName: String?,
    var debit: MoneyAmountDto,

    var valueDate: LocalDate?,
    var urgency: String,                    //CurTransferUrgencyType
    var transfer: MoneyAmountDto,
    var rateType: String?,                  //CurTransferRateType?
    var rate: Int?,
    var payer: CurTrPayerDto,
    var payerBank: CurTrPayerBankDto,
    var beneficiary: CurTrBeneficiaryDto,
    var beneficiaryBank: CurTrBeneficiaryBankDto,
    var intermediaryBank: CurTrIntermediaryBankDto,
    var paymentInformation: String?,
    var chargeType: CurTrChargeType?,
    var chargeAccount: String?,
    var chargeBic: String?,
    var paymentAddInformation: String?,
    var contactName: String?,
    var contactPhone: String?,

    // singleView-only visible fields (not present on PageView)
    var regulationInfos: List<CurRegulationInfoDto>?,

    // bank-only visible fields
    @JvmField var isReceived: Boolean? = null,
    @JvmField var isExecuted: Boolean? = null,
    @JvmField var isDeclined: Boolean? = null,
    @JvmField var isNotReceived: Boolean? = null,
    @JvmField var isRecalled: Boolean? = null,
) : UpdateIDocument<CurTransferDto>