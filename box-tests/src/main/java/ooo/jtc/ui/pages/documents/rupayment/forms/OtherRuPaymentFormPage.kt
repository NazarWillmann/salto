package ooo.jtc.ui.pages.documents.rupayment.forms

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.should
import ooo.jtc.core.container.wait
import ooo.jtc.core.elements.AllElements.checkboxByText
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.inputDropdown
import ooo.jtc.core.elements.AllElements.radioGroupByDataName
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.AllElements.textAreaDropdown
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.selenide.visibleText
import ooo.jtc.rupayment.RuPaymentView
import ooo.jtc.rupayment.model.BudgetType
import java.util.*

@ElementType("Форма созданию РПП по свободным реквизитам")
open class OtherRuPaymentFormPage(endpoint: String = "rupayment/main/create/other") :
    CreatePaymentPage(endpoint = endpoint) {

    val receiverName
        get() = textAreaDropdown["receiver.name"]
            .apply { title = "Наименование бюджетной организации" }

    val receiverInn get() = input["receiver.innKio"].apply { title = "ИНН / КИО" }

    val receiverKpp get() = input["receiver.kpp"].apply { title = "КПП" }

    val receiverAccount get() = inputDropdown["receiver.account"].apply { title = "Счет" }

    val receiverBankName get() = textArea["receiver.bank.name"].apply { title = "Банк" }

    val isBudget get() = checkboxByText["Платеж в бюджет"]

    val budgetType get() = radioGroupByDataName["budget.budgetType"]

    val budgetPayerStatus get() = inputDropdown["budget.payerStatus"].apply { title = "Составитель документа" }

    val budgetKbk get() = inputDropdown["budget.kbk"].apply { title = "КБК" }

    val budgetOktmo get() = input["budget.oktmo"].apply { title = "ОКТМО" }

    val budgetReasonDocumentNumber get() = input["budget.reasonDocumentNumber"].apply { title = "№ документа" }

    val budgetReasonCode get() = inputDropdown["budget.reasonCode"].apply { title = "Основание платежа" }

    val budgetReasonDocumentDate get() = input["budget.reasonDocumentDate"].apply { title = "Дата документа" }

    val budgetBudgetField107 get() = input["budget.budgetField107"]

    override fun fill(view: RuPaymentView) {
        documentNumber.value = view.documentNumber
        receiverName.select(view.receiverName)
        receiverInn should visibleText(view.receiverInn)
        elementByText[view.receiverBankBic] should Condition.visible
        receiverBankName should visibleText(view.receiverBankName)
        receiverAccount.select(view.receiverAccount)
        elementByText[view.receiverBankMaskedCorrAccount] should Condition.visible
        amount.value = view.amount
        paymentGroundDescription.value = view.paymentGroundDescription
        view.budgetType?.let {
            isBudget.check()
            budgetType.selectByText(it.value)
            budgetPayerStatus.select(view.budgetPayerStatus)
            budgetKbk.select(view.budgetKbk)
            budgetOktmo.value = view.budgetOktmo
            budgetReasonDocumentNumber.value = view.budgetReasonDocumentNumber
            if (it == BudgetType.CUSTOM || it == BudgetType.TAX) {
                budgetReasonCode.select(view.budgetReasonCode)
                budgetBudgetField107.value = view.budgetBudgetField107
                budgetReasonDocumentDate.value = view.budgetReasonDocumentDate
            }
        }
    }

    override fun checkEditFromFilledCorrect(view: RuPaymentView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun waitLoading() {
        elementByText["Платежное поручение"] wait Condition.visible
    }

}

@ElementType("Форма редактирования РПП по свободным реквизитам")
class OtherRuPaymentEditPage(uuid: UUID) : OtherRuPaymentFormPage(endpoint = "rupayment/main/edit/$uuid")

