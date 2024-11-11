package ooo.jtc.ui.pages.documents.lettertobank.scroller

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.wait
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.scroller.ExpandedScroller
import ooo.jtc.core.elements.scroller.ExpandedScrollerRow
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerBank
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerClient
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterBank
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterClient

@ElementType("Скроллер 'Письма в банк'")
open class LetterToBankScrollerPage(pageType: ApplicationPageType, endpoint: String = "letters/to-bank") :
    DocumentScrollerPage<ExpandedScroller<*>, ExpandedScrollerRow, LetterToBankScrollerCategory, FilterForm>(
        endpoint = endpoint,
        pageType = pageType
    ) {

    override val scroller get() = if (pageType.isClient()) LetterToBankScrollerClient() else LetterToBankScrollerBank()

    override val filterForm get() = if (pageType.isClient()) LetterToBankScrollerFilterClient() else LetterToBankScrollerFilterBank()

    override fun waitLoading() {
        //TODO A.Stykalin [30.06.2020] wait for category count element
        elementByText["Выход"].apply { timeout = 10000L } wait Condition.visible
    }

    val createLetter get() = textButton["Написать письмо"]
}