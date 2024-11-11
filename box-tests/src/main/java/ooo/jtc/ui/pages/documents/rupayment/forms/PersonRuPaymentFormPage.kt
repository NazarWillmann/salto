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

@ElementType("Платеж физическому лицу")
open class PersonRuPaymentFormPage(endpoint: String = "rupayment/main/create/person") : CreatePaymentPage(endpoint = endpoint) {

    val receiverName get() = textAreaDropdown["receiver.name"].apply { title = "ФИО Физического лица" }

    val receiverInn get() = input["receiver.innKio"].apply { title = "ИНН Физического лица" }

    val receiverAccount get() = input["receiver.account"].apply { title = "Счет Физического лица" }

    val receiverBankBic
        get() = inputDropdown["receiver.bank.bic"].apply { title = "БИК или наименование банка" }

    val receiverBankName get() = label["receiver.bank.name"].apply { title = "Банк" }

    val receiverBankCorrAccount get() = label["receiver.bank.corrAccount"].apply { title = "к/с" }

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
    }

    override fun checkEditFromFilledCorrect(view: RuPaymentView) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

@ElementType("Форма редактирования 'Платеж физическому лицу'")
class PersonRuPaymentEditPage(uuid: UUID) : PersonRuPaymentFormPage(endpoint = "rupayment/main/edit/$uuid")

