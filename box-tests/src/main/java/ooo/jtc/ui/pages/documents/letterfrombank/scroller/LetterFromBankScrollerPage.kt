package ooo.jtc.ui.pages.documents.letterfrombank.scroller

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
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankScrollerBank
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankScrollerClient
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankScrollerFilterBank
import ooo.jtc.ui.pages.documents.letterfrombank.sections.LetterFromBankScrollerFilterClient

@ElementType("Скроллер 'Письма из банка'")
open class LetterFromBankScrollerPage(pageType: ApplicationPageType, endpoint: String = "letters/from-bank") :
    DocumentScrollerPage<ExpandedScroller<*>, ExpandedScrollerRow, LetterFromBankScrollerCategory, FilterForm>(
        endpoint = endpoint,
        pageType = pageType
    ) {

    override val scroller get() = if (pageType.isClient()) LetterFromBankScrollerClient() else LetterFromBankScrollerBank()

    override val filterForm get() = if (pageType.isClient()) LetterFromBankScrollerFilterClient() else LetterFromBankScrollerFilterBank()

    override fun waitLoading() {
        //TODO A.Stykalin [30.06.2020] wait for category count element
        elementByText["Выход"].apply { timeout = 10000L } wait Condition.visible
    }

    val createLetter get() = textButton["Написать письмо"]
}