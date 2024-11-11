package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.selenide.scrollIntoView
import ooo.jtc.core.elements.ElementType
import kotlin.reflect.KClass

@ElementType("Скроллер документа с раскрывающимися строками")
abstract class ExpandedScroller<R : ExpandedScrollerRow>(
    override var rowClass: KClass<R>,
    override val sElement: SelenideElement
) : DocumentScroller<R>(rowClass, sElement = sElement) {

    @Step("Получить значения из строки по локатору {searchLocator}")
    override fun getValuesFromRows(searchLocator: String, limitRows: Int?): List<String> {
        val action: (SelenideElement) -> String = {
            val foundElements = it.findAll(searchLocator)
            if (foundElements.isEmpty()) {
                val row = createScrollerRow(it)
                row.expand()
                it.find(searchLocator).scrollIntoView().text()
            } else {
                it.find(searchLocator).scrollTo().text()
            }
        }
        return makeActionWithSelenide(condition = anyRow, action = action, limitRows = limitRows)
    }
}