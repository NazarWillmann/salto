package ooo.jtc.ui.pages.documents.letterfrombank.sections

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.listElements
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.Label
import ooo.jtc.core.elements.WithCheckBox
import ooo.jtc.core.elements.scroller.ExpandedScroller
import ooo.jtc.core.elements.scroller.ExpandedScrollerRow
import ooo.jtc.core.elements.scroller.defaultScrollerElement
import ooo.jtc.generic.DocumentNames

@ElementType("Скроллер ${DocumentNames.LETTER_FROM_BANK}")
class LetterFromBankScrollerClient :
    ExpandedScroller<LetterFromBankScrollerRowClient>(LetterFromBankScrollerRowClient::class, defaultScrollerElement) {
    override fun createScrollerRow(sElement: SelenideElement): LetterFromBankScrollerRowClient {
        return LetterFromBankScrollerRowClient(sElement)
    }
}

@ElementType("Строка скроллера ${DocumentNames.LETTER_FROM_BANK}")
class LetterFromBankScrollerRowClient(sElement: SelenideElement) : ExpandedScrollerRow(sElement = sElement), WithCheckBox {
    val documentNumber get() = label["documentNumber"]
    val contactName get() = label["contactName"]
    val docTheme get() = label["docTheme"]
    val docText get() = label["docText"]
    val branchName get() = label["branchName"]
    val attachments get() = listElements("[data-field^='attachments']") { Label(sElement = it).withTitle("Вложение") }
    val createdAt get() = label["createdAt"]
}

@ElementType("Скроллер ${DocumentNames.LETTER_FROM_BANK}")
class LetterFromBankScrollerBank : ExpandedScroller<LetterFromBankScrollerRowBank>(LetterFromBankScrollerRowBank::class, defaultScrollerElement) {
    override fun createScrollerRow(sElement: SelenideElement): LetterFromBankScrollerRowBank {
        return LetterFromBankScrollerRowBank(sElement)
    }
}

@ElementType("Строка скроллера ${DocumentNames.LETTER_FROM_BANK}")
class LetterFromBankScrollerRowBank(sElement: SelenideElement) : ExpandedScrollerRow(sElement = sElement), WithCheckBox {
    val documentNumber get() = label["documentNumber"]
    val documentDate get() = label["documentDate"]
    val isHasAttach get() = label["isHasAttach"]
    val docText get() = label["docText"]
    val docTheme get() = label["docTheme"]
    val branchName get() = label["branchName"]
    val customerName get() = label["customerName"]
    val attachIcon get() = label["isHasAttach"]
}
