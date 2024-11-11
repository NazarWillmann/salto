package ooo.jtc.core.elements

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.elements.AllElements.listElements
import ooo.jtc.core.elements.SelectBy.INNER_TEXT
import ooo.jtc.core.elements.SelectBy.VALUE
import ooo.jtc.core.selenide.attrSafe

/**
 * Тип поиска и выбора опции [ListBoxOptions]
 * [INNER_TEXT] - текст опции (`Дата документа`)
 * [VALUE] - значение в атрибуте value (`documentDate`)
 */
enum class SelectBy {
    INNER_TEXT,
    VALUE
}

/**
 * Items in drop down list
 */
@ElementType("Значения выпадающего списка")
class ListBoxOptions(
    dataName: String,
    sElement: SelenideElement = Selenide.element("ul[data-name='$dataName']"),
    private val selectBy: SelectBy
) : SContainer(sName = dataName, sElement = sElement) {

    val items
        get() = listElements("[role='listitem'],[role='option']") {
            ListItemElement(it).apply {
                sName = when (selectBy) {
                    INNER_TEXT -> innerText()
                    VALUE -> attrSafe("Value")
                }
            }
        }

    fun select(searchString: String) {
        when (selectBy) {
            INNER_TEXT -> items.find { it.innerText().contains(searchString) }?.click()
                ?: throw AssertionError("Не найдено значение '$searchString' в списке \n${items.joinToString(separator = "\n") { it.innerText() }}")
            VALUE -> items.find { it.attrSafe("Value").contains(searchString) }?.click()
                ?: throw AssertionError("Не найдено значение '$searchString' в списке ${items.joinToString(separator = "\n") { it.attrSafe("Value") }}")
        }

    }

}