package ooo.jtc.ui.pages.documents.lettertobank.form

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide
import ooo.jtc.core.elements.ElementType
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankHistoryTab
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankSignatureTab

@ElementType("Форма создания/редактирования/просмотра 'Письмо в банк'")
abstract class LetterToBankFormPage(pageType: ApplicationPageType) : DocumentPage(
    endpoint = "letters/to-bank",
    pageType = pageType
) {
    override var headerName: String = "Письмо в банк"

    override fun waitLoading() {
        Selenide.element(Selectors.ByText(BASIC_REQUISITES.tabName)).should(Condition.visible)
    }

    val basicRequisitesTab get() = LetterToBankFormBasicRequisitesTab(pageType)
    val historyTab get() = LetterToBankHistoryTab(find("[role='grid']"), pageType)
    val signaturesTab get() = LetterToBankSignatureTab(find("[role='grid']"), pageType)

}