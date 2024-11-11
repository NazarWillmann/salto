package ooo.jtc.ui.pages.dictionaries.paymenttype

import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.paymenttype.PaymentTypeView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Вид платежа'")
open class PaymentTypeFormPage : DictionaryCreatePage<PaymentTypeView>("rupayment/paymentType/create") {

    val code get() = input["code"].apply { title = "Код" }

    val description get() = textArea["description"].apply { title = "Вид платежа" }

    override fun fill(view: PaymentTypeView) {
        code.value = view.code
        description.value = view.description
    }

    override fun checkEditFromFilledCorrect(view: PaymentTypeView) {
        TODO("Not yet implemented")
    }
}

