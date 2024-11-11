package ooo.jtc.ui.application

import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.pages.dictionaries.budgepayerstatus.BudgetPayerStatusFormPage
import ooo.jtc.ui.pages.dictionaries.budgepayerstatus.BudgetPayerStatusScrollerPage
import ooo.jtc.ui.pages.dictionaries.budgetreasoncode.BudgetReasonCodeFormPage
import ooo.jtc.ui.pages.dictionaries.budgetreasoncode.BudgetReasonCodeScrollerPage
import ooo.jtc.ui.pages.dictionaries.codevo.CodeVoFormPage
import ooo.jtc.ui.pages.dictionaries.codevo.CodeVoScrollerPage
import ooo.jtc.ui.pages.dictionaries.kbk.KbkFormPage
import ooo.jtc.ui.pages.dictionaries.kbk.KbkScrollerPage
import ooo.jtc.ui.pages.dictionaries.paymentpriority.PaymentPriorityFormPage
import ooo.jtc.ui.pages.dictionaries.paymentpriority.PaymentPriorityScrollerPage
import ooo.jtc.ui.pages.dictionaries.paymenttype.PaymentTypeFormPage
import ooo.jtc.ui.pages.dictionaries.paymenttype.PaymentTypeScrollerPage
import ooo.jtc.ui.pages.dictionaries.statementoperationtype.StatementOperationTypeFormPage
import ooo.jtc.ui.pages.dictionaries.statementoperationtype.StatementOperationTypeScrollerPage
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerPage
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage

/**
 * Pages on Bank side of Application
 */
object BankApplication {

    //region Scroller
    val budgetReasonCodeScrollerPage get() = BudgetReasonCodeScrollerPage()
    val paymentTypeScrollerPage get() = PaymentTypeScrollerPage()
    val codeVoScrollerPage get() = CodeVoScrollerPage()
    val budgetPayerStatusScrollerPage get() = BudgetPayerStatusScrollerPage()
    val paymentPriorityScrollerPage get() = PaymentPriorityScrollerPage()
    val statementOperationTypeScrollerPage get() = StatementOperationTypeScrollerPage()
    val kbkScrollerPage get() = KbkScrollerPage()

    val lTBScrollerPageBank get() = LetterToBankScrollerPage(BANK_PAGE)
    val lFBScrollerPageBank get() = LetterFromBankScrollerPage(BANK_PAGE)
    //endregion

    //region Dictionary Forms
    val paymentTypeFormPage get() = PaymentTypeFormPage()
    val budgetReasonCodeFormPage get() = BudgetReasonCodeFormPage()
    val kbkFormPage get() = KbkFormPage()
    val codeVoFormPage get() = CodeVoFormPage()
    val budgetPayerStatusFormPage get() = BudgetPayerStatusFormPage()
    val paymentPriorityFormPage get() = PaymentPriorityFormPage()
    val statementOperationTypeFormPage get() = StatementOperationTypeFormPage()
    //endregion

    //region Document Forms
    val lTBFormBasicRequisitesBank get() = LetterToBankFormBasicRequisitesTab(BANK_PAGE)
    val lFBFormBasicRequisitesBank get() = LetterFromBankFormBasicRequisitesTab(BANK_PAGE)
    //endregion

}