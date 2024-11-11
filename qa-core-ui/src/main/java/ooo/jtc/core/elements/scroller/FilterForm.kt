package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.defaultDialogContext
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ModalWindow

open class FilterForm(sElement: SelenideElement = defaultDialogContext) : ModalWindow(sElement = sElement) {
    override val headerText: String get() = "Параметры фильтра"
    val apply get() = textButton["Применить"]
    val clear get() = textButton["Сбросить"]
}