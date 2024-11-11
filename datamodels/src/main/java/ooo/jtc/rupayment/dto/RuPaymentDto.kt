package ooo.jtc.rupayment.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.rupayment.model.BudgetType
import ooo.jtc.rupayment.model.UserPaymentType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@EntityName(DocumentNames.RU_PAYMENT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RuPaymentDto(
    override var id: UUID? = null,
    override var version: Int = 0,          //needed for creation
    override var documentNumber: String,    //needed for creation
    override var documentDate: LocalDate,   //needed for creation
    override var customerId: UUID?,         //needed for creation
    override var status: String?,
    var branchId: UUID?,                    //needed for creation

    var payer: PayerDto?,                   //needed for creation
    var receiver: ReceiverDto?,             //needed for creation
    var budget: BudgetDto?,                 //needed for creation
    var paymentGround: PaymentGroundDto?,   //needed for creation

    var amount: BigDecimal,                 //needed for creation
    var operationType: String?,
    var priority: String?,
    var uinUip: String?,
    var userPaymentType: UserPaymentType?,
    var channel: String?,
    var incomeTypeCode: Int? = null,
    var amountRecovery: BigDecimal? = null,
    var transferTermCode: String? = null,
    var transferTermDescription: String? = null,

    @JvmField var isFavorites: Boolean? = false,
    @JvmField var isReceived: Boolean? = false,
    @JvmField var isExecuted: Boolean? = false,
    @JvmField var isDeclined: Boolean? = false,

    var createdAt: ZonedDateTime?,

    @JsonIgnore var budgetType: BudgetType? = null
) : UpdateIDocument<RuPaymentDto>

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RuPaymentPreFilledForUserPaymentType(
    var userPaymentType: UserPaymentType,
    var priority: String,
    var paymentGround: PaymentGroundDto,
    var budget: BudgetDto? = null,
    var operationType: String = "01",
    var amount: BigDecimal = BigDecimal("0.00")
)