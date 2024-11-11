package ooo.jtc.ui.pages.documents.rupayment.forms

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.should
import ooo.jtc.core.container.wait
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.inputDropdown
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.textAreaDropdown
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.selenide.visibleText
import ooo.jtc.rupayment.RuPaymentView
import java.util.*

@ElementType("Платеж в бюджетную организацию")
open class BudgetRuPaymentFormPage(endpoint: String = "rupayment/main/create/budget") : CreatePaymentPage(endpoint = endpoint) {

    val receiverName
        get() = textAreaDropdown["receiver.name"].apply { title = "Наименование бюджетной организации" }

    val receiverInn get() = input["receiver.innKio"].apply { title = "ИНН бюджетной организации" }

    val receiverKpp get() = input["receiver.kpp"].apply { title = "КПП бюджетной организации" }

    val receiverAccount get() = input["receiver.account"].apply { title = "Счет бюджетной организации" }

    val receiverBankBic
        get() = inputDropdown["receiver.bank.bic"].apply { title = "БИК" }

    val receiverBankName get() = label["receiver.bank.name"].apply { title = "Банк" }

    val receiverBankCorrAccount get() = label["receiver.bank.corrAccount"].apply { title = "к/с" }

    val budgetPayerStatus get() = inputDropdown["budget.payerStatus"].apply { title = "Составитель документа" }

    val budgetKbk get() = inputDropdown["budget.kbk"].apply { title = "КБК" }

    val budgetOktmo get() = input["budget.oktmo"].apply { title = "ОКТМО" }

    val budgetReasonDocumentNumber get() = input["budget.reasonDocumentNumber"].apply { title = "№ документа" }

    override fun fill(view: RuPaymentView) {
        editDocumentNumber.click(ignoreStep = true)
        documentNumber.value = view.documentNumber
        payerAccount.select(view.payerAccount)
        receiverName.openOptions(view.receiverName)
        receiverName.options wait Condition.visible
        receiverName.options.select(view.receiverMaskedAccount)
        receiverInn should visibleText(view.receiverInn)
        receiverBankBic should visibleText(view.receiverBankBic)
        receiverBankName should visibleText(view.receiverBankName)
        receiverBankCorrAccount should visibleText(view.receiverBankMaskedCorrAccount)
        amount.value = view.amount
        paymentGroundDescription.value = view.paymentGroundDescription

        budgetPayerStatus.select(view.budgetPayerStatus)
        budgetKbk.select(view.budgetKbk)
        budgetOktmo.value = view.budgetOktmo
        budgetReasonDocumentNumber.value = view.budgetReasonDocumentNumber
    }

    override fun checkEditFromFilledCorrect(view: RuPaymentView) {
        receiverName should visibleText(view.receiverName)
        receiverInn should visibleText(view.receiverInn)
        receiverKpp should visibleText(view.receiverKpp)
        receiverAccount should visibleText(view.receiverMaskedAccount)
        receiverBankBic should visibleText(view.receiverBankBic)
        receiverBankName should visibleText(view.receiverBankName)
        receiverBankCorrAccount should visibleText(view.receiverBankMaskedCorrAccount)
        payerName should visibleText(view.payerName)
        payerAccount should visibleText(view.payerAccount)
        payerInn should visibleText(view.payerInn)
        payerKpp should visibleText(view.payerKpp)
        amount should visibleText(view.amountMasked)
        paymentGroundDescription should visibleText(view.paymentGroundDescription)
        budgetPayerStatus should visibleText(view.budgetPayerStatus)
        budgetKbk should visibleText(view.budgetKbk)
        budgetOktmo should visibleText(view.budgetOktmo)
        budgetReasonDocumentNumber should visibleText(view.budgetReasonDocumentNumber)
    }

}

@ElementType("Форма редактирования 'Платеж в бюджетную организацию'")
class BudgetRuPaymentEditPage(uuid: UUID) : BudgetRuPaymentFormPage(endpoint = "rupayment/main/edit/$uuid")

