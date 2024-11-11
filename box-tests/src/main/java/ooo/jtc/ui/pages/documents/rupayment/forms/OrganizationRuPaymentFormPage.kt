package ooo.jtc.ui.pages.documents.rupayment.forms

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.text
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

@ElementType("Перевод юридическим лицам и ИП")
open class OrganizationRuPaymentFormPage(endpoint: String = "rupayment/main/create/person") : CreatePaymentPage(endpoint = endpoint) {

    val receiverName
        get() = textAreaDropdown["receiver.name"]
            .apply { title = "Наименование организации или ИП" }

    val receiverInn get() = input["receiver.innKio"].apply { title = "ИНН организации или ИП" }

    val receiverKpp get() = input["receiver.kpp"].apply { title = "КПП организации" }

    val receiverAccount get() = input["receiver.account"].apply { title = "Счет организации или ИП" }

    val receiverBankBic
        get() = inputDropdown["receiver.bank.bic"]
            .apply { title = "БИК" }

    val receiverBankName get() = label["receiver.bank.name"].apply { title = "Банк" }

    val receiverBankCorrAccount get() = label["receiver.bank.corrAccount"].apply { title = "к/с" }

    override fun fill(view: RuPaymentView) {
        editDocumentNumber.click(ignoreStep = true)
        documentNumber.value = view.documentNumber
        payerAccount.select(view.payerHiddenMaskedAccount)
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
        receiverName should text(view.receiverName)
        receiverInn should text(view.receiverInn)
        receiverKpp should text(view.receiverKpp)
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
    }

}

@ElementType("Форма редактирования 'Перевод юридическим лицам и ИП'")
open class OrganizationRuPaymentEditPage(uuid: UUID) : OrganizationRuPaymentFormPage(endpoint = "rupayment/main/edit/$uuid")

