package ooo.jtc.api.rupayment.prepare

import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.account.isResidentAccount
import ooo.jtc.generic.amount
import ooo.jtc.rupayment.dto.PaymentGroundDto
import ooo.jtc.testdata.dictionaries.codevo.CodeVoData
import java.math.BigDecimal

object PaymentGroundDtoPrepareSteps

/** NOTES:
 * 1) values are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=12919992
 * 2) all values have "_AT" in field 'description', so that 'paymentGround' could be used to find AT-created RuPayments
 * 3) 'CheckPaymentGroundNDS' control (https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336938)
 *    checks 'description' for "НДС" / "налогнадобавленнуюстоимость"(ignoring spaces and case), if RuPayment considered
 *    non-budget. Thus - "НДС" in almost every PaymentGround
 */
enum class PaymentGrounds(
    private val description: String,
    private val nds: BigDecimal? = null,
    private val ndsCalculation: Int? = null,
    private val ndsPercent: String? = null
) {
    /**
     * Don't forget to update 'nds' when using this PG,
     * or you'll get a 'CheckPaymentGroundNDSSumm' error
     */
    NDS_INCLUDED_PAYMENT_GROUND(
        description = "НДС включается в сумму$AT_POSTFIX",
        nds = amount(0.0),
        ndsCalculation = 1,
        ndsPercent = "20"
    ),

    /** No NDS should be provided */
    NO_NDS_PAYMENT_GROUND(
        description = "НДС не облагается$AT_POSTFIX",
        ndsCalculation = 3
    ),

    /** No NDS should be provided */
    NO_NDS_CALC_PAYMENT_GROUND(
        description = "НДС не рассчитывается$AT_POSTFIX",
        ndsCalculation = 5
    ),
    ;

    fun getDto(operationCode: String?): PaymentGroundDto {
        val computedDescription = operationCode?.let { "{VO$operationCode} $description" } ?: description
        return PaymentGroundDto(operationCode, computedDescription, nds, ndsCalculation, ndsPercent)
    }

    fun getDto(
        payerAccNum: String,
        receiverAccNum: String
    ): PaymentGroundDto {
        var operationCode: String? = null
        if (!isResidentAccount(payerAccNum) || !isResidentAccount(receiverAccNum)) {
            operationCode = CodeVoData.random()?.code
        }
        return getDto(operationCode)
    }
}