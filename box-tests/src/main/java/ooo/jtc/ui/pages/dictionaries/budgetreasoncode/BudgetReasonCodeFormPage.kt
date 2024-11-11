package ooo.jtc.ui.pages.dictionaries.budgetreasoncode

import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Показатель основания платежа'")
open class BudgetReasonCodeFormPage : DictionaryCreatePage<BudgetReasonCodeView>("rupayment/budgetReasonCode/create") {

    val code get() = input["code"].apply { title = "Показатель" }

    val description get() = textArea["description"].apply { title = "Описание" }

    val payType get() = dropdown["payType"].apply { title = "Тип платежа" }

    override fun fill(view: BudgetReasonCodeView) {
        code.value = view.code
        description.value = view.description
        payType.select(view.payType)
    }

    override fun checkEditFromFilledCorrect(view: BudgetReasonCodeView) {
        TODO("Not yet implemented")
    }
}

