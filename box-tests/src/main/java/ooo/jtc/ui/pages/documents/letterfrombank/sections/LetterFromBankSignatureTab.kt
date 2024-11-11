package ooo.jtc.ui.pages.documents.letterfrombank.sections

import com.codeborne.selenide.SelenideElement
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.SIGNATURES
import ooo.jtc.ui.common.sections.tabs.SignatureRow
import ooo.jtc.ui.common.sections.tabs.SignatureTab
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormPage

class LetterFromBankSignatureTab(override val sElement: SelenideElement, pageType: ApplicationPageType)
    : LetterFromBankFormPage(pageType = pageType), SignatureTab<LetterFromBankSignatureTab, SignatureRow>
{
    override val tabName: String = SIGNATURES.tabName
    override val createRow: (SelenideElement) -> SignatureRow = { SignatureRow(it) }
}