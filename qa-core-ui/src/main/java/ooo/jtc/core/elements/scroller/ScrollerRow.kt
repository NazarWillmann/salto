package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.getElements
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.Row

@ElementType("Строка скроллера")
abstract class ScrollerRow(sElement: SelenideElement) : SContainer(sElement = sElement), Row {

    val dataFields get() = this.getElements(".//*[@data-field]").map { it.attr("data-field") to it }.toMap()
}