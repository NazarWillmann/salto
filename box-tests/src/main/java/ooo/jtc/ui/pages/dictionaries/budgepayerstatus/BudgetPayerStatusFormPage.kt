package ooo.jtc.ui.pages.dictionaries.budgepayerstatus

import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Показатель статуса плательщика'")
open class BudgetPayerStatusFormPage : DictionaryCreatePage<BudgetPayerStatusView>("rupayment/budgetPayerStatus/create") {

    val code get() = input["code"].apply { title = "Показатель статуса" }

    val description get() = textArea["description"].apply { title = "Описание" }

    val payType get() = dropdown["payType"].apply { title = "Тип платежа" }

    override fun fill(view: BudgetPayerStatusView) {
        code.value = view.code
        description.value = view.description
    }

    override fun checkEditFromFilledCorrect(view: BudgetPayerStatusView) {
        TODO("Not yet implemented")
    }
}

