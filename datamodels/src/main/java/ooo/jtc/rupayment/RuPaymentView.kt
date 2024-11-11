package ooo.jtc.rupayment

import com.github.pozo.KotlinBuilder
import ooo.jtc.interfaces.IDocumentView
import ooo.jtc.rupayment.model.BudgetType
import ooo.jtc.rupayment.model.UserPaymentType
import java.util.UUID

@KotlinBuilder
data class RuPaymentView(
    override var id: UUID? = null,
    override var customerId: UUID,
    override var documentNumber: String = "",
    override var documentDate: String = "",
    override var statusSystem: String = "",
    override var statusClient: String = "",
    override var statusBank: String = "",
    var receiverName: String = "",
    var receiverInn: String = "",
    var receiverKpp: String = "",
    var receiverBankBic: String = "",
    var receiverBankName: String = "",
    var receiverBankCorrAccount: String = "",
    var receiverBankMaskedCorrAccount: String = "",
    var receiverAccount: String = "",
    var receiverMaskedAccount: String = "",
    var payerAccount: String = "",
    /*e.g. 40807.810.4.38602823436*/
    var payerMaskedAccount: String = "",
    /*e.g. 40807...3436*/
    var payerHiddenMaskedAccount: String = "",
    var payerName: String = "",
    var payerInn: String = "",
    var payerKpp: String = "",
    var amount: String = "",
    var amountMasked: String = "",
    var amountAntie: String = "",
    var paymentGroundDescription: String = "",
    var nds: String = "",
    var priority: String = "",
    var userPaymentType: UserPaymentType?,
    var budgetPayerStatus: String = "",
    var budgetKbk: String = "",
    var budgetOktmo: String = "",
    var budgetReasonCode: String = "",
    var budgetBudgetField107: String = "",
    var budgetReasonDocumentNumber: String = "",
    var budgetReasonDocumentDate: String = "",
    var budgetType: BudgetType? = null
) : IDocumentView {
    override val searchField: String
        get() = paymentGroundDescription
}