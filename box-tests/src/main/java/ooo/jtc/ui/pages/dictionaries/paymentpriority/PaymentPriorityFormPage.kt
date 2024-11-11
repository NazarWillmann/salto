package ooo.jtc.ui.pages.dictionaries.paymentpriority

import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Очередность платежа'")
open class PaymentPriorityFormPage : DictionaryCreatePage<PaymentPriorityView>("rupayment/paymentPriority/create") {

    val code get() = input["code"].apply { title = "Код" }

    val description get() = textArea["description"].apply { title = "Описание" }

    override fun fill(view: PaymentPriorityView) {
        code.value = view.code
        description.value = view.description
    }

    override fun checkEditFromFilledCorrect(view: PaymentPriorityView) {
        TODO("Not yet implemented")
    }
}

