package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.elements.ElementType

/**
 * Получить Вкладку категории скроллера можно по наименованию.
 * e.g. scrollerPage.scrollerTab["Все"]
 */
@ElementType("Вкладка категории скроллера")
class ScrollerTab(
    sName: String,
    sElement: SelenideElement
) : SContainer(sName = sName, sElement = sElement) {
    val isActive get() = attr("disabled") ?: false

    @Step("Получить значение счетчика вкладки категории")
    fun getCount(): String {
        return find("[role='note']").innerText()
    }
}