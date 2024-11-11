package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.WithPanel

@ElementType("Раскрываемая строка скроллера документа")
open class ExpandedScrollerRow(sElement: SelenideElement) : DocumentScrollerRow(sElement = sElement), WithPanel {

    @Step("Развернуть панель быстрого просмотра и выбрать действие '{action}'")
    fun makeActionByExpandPanel(action: String) {
        expand()
        textButton[action].click(false)
    }
}