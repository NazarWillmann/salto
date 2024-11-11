package ooo.jtc.ui.pages.documents.rupayment.forms

import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.inputDropdown
import ooo.jtc.core.elements.ElementType

import ooo.jtc.core.selenide.visibleText
import ooo.jtc.rupayment.RuPaymentView
import java.util.*

@ElementType("Оплата налогов и сборов")
open class TaxRuPaymentFormPage(endpoint: String = "rupayment/main/create/tax") : BudgetRuPaymentFormPage(endpoint = endpoint) {

    val budgetReasonCode get() = inputDropdown["budget.reasonCode"].apply { title = "Основание платежа" }
    val budgetReasonDocumentDate get() = input["budget.reasonDocumentDate"].apply { title = "Дата документа" }
    val budgetBudgetField107 get() = input["budget.budgetField107"].apply { title = "Налоговый период" }

    override fun fill(view: RuPaymentView) {
        super.fill(view)
        budgetReasonCode.select(view.budgetReasonCode)
        budgetBudgetField107.value = view.budgetBudgetField107
        budgetReasonDocumentDate.value = view.budgetReasonDocumentDate
    }

    override fun checkEditFromFilledCorrect(view: RuPaymentView) {
        super.checkEditFromFilledCorrect(view)
        budgetReasonCode should visibleText(view.budgetReasonCode)
        budgetReasonDocumentDate should visibleText(view.budgetReasonDocumentDate)
        budgetBudgetField107 should visibleText(view.budgetBudgetField107)
    }
}

@ElementType("Форма редактирования 'Оплата налогов и сборов'")
class TaxRuPaymentEditPage(uuid: UUID) : TaxRuPaymentFormPage(endpoint = "rupayment/main/edit/$uuid")
