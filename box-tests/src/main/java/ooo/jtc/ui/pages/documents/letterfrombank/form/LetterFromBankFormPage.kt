package ooo.jtc.ui.pages.documents.letterfrombank.form

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import ooo.jtc.core.elements.ElementType
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankHistoryTab
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankSignatureTab

@ElementType("Форма создания/редактирования/просмотра 'Письмо из банка'")
abstract class LetterFromBankFormPage(pageType: ApplicationPageType) : DocumentPage(
    endpoint = "letters/from-bank",
    pageType = pageType
) {
    override var headerName: String = "Письмо из банка"

    override fun waitLoading() {
        Selenide.element(Selectors.ByText(BASIC_REQUISITES.tabName)).should(Condition.visible)
    }

    val basicRequisitesTab get() = LetterFromBankFormBasicRequisitesTab(pageType)
    val historyTab get() = LetterFromBankHistoryTab(find("[role='grid']"), pageType)
    val signaturesTab get() = LetterFromBankSignatureTab(find("[role='grid']"), pageType)
}