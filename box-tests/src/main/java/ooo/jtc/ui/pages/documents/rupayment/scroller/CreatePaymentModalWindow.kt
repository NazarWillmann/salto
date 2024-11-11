package ooo.jtc.ui.pages.documents.rupayment.scroller


import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow
import ooo.jtc.rupayment.RuPaymentView
import ooo.jtc.rupayment.model.UserPaymentType
import ooo.jtc.ui.application.ClientApplication
import ooo.jtc.ui.pages.documents.rupayment.forms.CreatePaymentPage

@ElementType("Модальное окно 'Новый платеж'")
class CreatePaymentModalWindow : ModalWindow() {
    override val headerText = "Новый платеж"
    val organization get() = textButton["Организации или ИП"]
    val person get() = textButton["Физическому лицу"]
    val owner get() = textButton["Между своими счетами"]
    val budget get() = textButton["Бюджетной организации"]
    val tax get() = textButton["Налоги и сборы"]
    val custom get() = textButton["Таможенные пошлины"]

    val free get() = textButton["Оформите новый платеж по свободным реквизитам"]

    fun selectRuPaymentType(view: RuPaymentView): CreatePaymentPage {
        when (view.userPaymentType) {
            UserPaymentType.BUDGET -> {
                budget.click()
                return ClientApplication.budgetRuPaymentFormPage
            }
            UserPaymentType.BUSINESS -> {
                organization.click()
                return ClientApplication.organizationRuPaymentFormPage
            }
            UserPaymentType.CUSTOM -> {
                custom.click()
                return ClientApplication.customRuPaymentFormPage
            }
            UserPaymentType.OTHER -> {
                free.click()
                return ClientApplication.otherPaymentFormPage
            }
            UserPaymentType.OWNACCOUNTS -> {
                owner.click()
                return ClientApplication.organizationRuPaymentFormPage
            }
            UserPaymentType.PERSON -> {
                person.click()
                return ClientApplication.personRuPaymentFormPage
            }
            UserPaymentType.TAX -> {
                tax.click()
                return ClientApplication.taxRuPaymentFormPage
            }
            null -> throw RuntimeException("No value in userPaymentType field in $view")
        }
    }

}