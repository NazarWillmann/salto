package ooo.jtc.ui.common.pages

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.WithCheckBox
import ooo.jtc.core.elements.scroller.Scroller
import ooo.jtc.core.elements.scroller.ScrollerRow
import ooo.jtc.core.elements.scroller.Toolbar
import ooo.jtc.core.elements.scroller.defaultScrollerElement

@ElementType("Скроллер справочника")
open class DictionaryScroller(
    sElement: SelenideElement = defaultScrollerElement,
    var toolbar: Toolbar = Toolbar()
) : Scroller<DictionaryScrollerRow>(rowClass = DictionaryScrollerRow::class, sElement = sElement) {
    override fun createScrollerRow(sElement: SelenideElement): DictionaryScrollerRow {
        return DictionaryScrollerRow(sElement)
    }
}

@ElementType("Строка скроллера")
class DictionaryScrollerRow(sElement: SelenideElement) : ScrollerRow(sElement = sElement), WithCheckBox