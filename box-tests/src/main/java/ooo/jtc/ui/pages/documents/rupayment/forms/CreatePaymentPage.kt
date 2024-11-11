package ooo.jtc.ui.pages.documents.rupayment.forms

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.wait
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.buttonDropdown
import ooo.jtc.core.elements.AllElements.checkboxByText
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.rupayment.RuPaymentView
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.interfaces.CreatePage

abstract class CreatePaymentPage(endpoint: String) :
    DocumentPage(pageType = ApplicationPageType.CLIENT_PAGE, endpoint = endpoint), CreatePage<RuPaymentView> {

    val payerAccount get() = dropdown["payer.account"].withTitle("Счет плательщика")

    val payerName get() = label["payer.name"].withTitle("Наименование плательщика")
    val payerInn get() = label["payer.inn"].withTitle("ИНН плательщика")
    val payerKpp get() = label["payer.kpp"].withTitle("КПП плательщика")

    val amount get() = input["amount"]

    //todo аттрибута name нет на кнопке. добавить при возвращении к тестированию ruPayment
    val nds get() = buttonDropdown["nds"].withTitle("НДС")
    val priority get() = buttonDropdown["priority"].withTitle("Очередность")

    val isUrgent get() = checkboxByText["Срочный платеж"]
    val paymentGroundDescription get() = textArea["paymentGround.description"]

    override fun waitLoading() {
        elementByText["Платежное поручение"] wait Condition.visible
    }
}