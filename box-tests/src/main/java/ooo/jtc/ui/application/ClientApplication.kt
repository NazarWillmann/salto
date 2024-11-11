package ooo.jtc.ui.application

import ooo.jtc.ui.common.pages.ApplicationPageType.CLIENT_PAGE
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerPage
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage
import ooo.jtc.ui.pages.documents.rupayment.forms.BudgetRuPaymentFormPage
import ooo.jtc.ui.pages.documents.rupayment.forms.CustomRuPaymentFormPage
import ooo.jtc.ui.pages.documents.rupayment.forms.OrganizationRuPaymentFormPage
import ooo.jtc.ui.pages.documents.rupayment.forms.OtherRuPaymentFormPage
import ooo.jtc.ui.pages.documents.rupayment.forms.PersonRuPaymentFormPage
import ooo.jtc.ui.pages.documents.rupayment.forms.TaxRuPaymentFormPage
import ooo.jtc.ui.pages.documents.rupayment.scroller.RuPaymentScrollerPage

/**
 * Pages on Client side of Application
 */
object ClientApplication {

    //region Scroller
    val ruPaymentScrollerPage get() = RuPaymentScrollerPage()
    val lTBScrollerPageClient get() = LetterToBankScrollerPage(CLIENT_PAGE)
    val lFBScrollerPageClient get() = LetterFromBankScrollerPage(CLIENT_PAGE)
    //endregion

    //region Forms
    //region RuPayment Forms
    val budgetRuPaymentFormPage get() = BudgetRuPaymentFormPage()
    val taxRuPaymentFormPage get() = TaxRuPaymentFormPage()
    val personRuPaymentFormPage get() = PersonRuPaymentFormPage()
    val organizationRuPaymentFormPage get() = OrganizationRuPaymentFormPage()
    val customRuPaymentFormPage get() = CustomRuPaymentFormPage()
    val otherPaymentFormPage get() = OtherRuPaymentFormPage()
    //endregion

    val lTBFormBasicRequisitesClient get() = LetterToBankFormBasicRequisitesTab(CLIENT_PAGE)
    val lFBFormBasicRequisitesClient get() = LetterFromBankFormBasicRequisitesTab(CLIENT_PAGE)
    //endregion
}