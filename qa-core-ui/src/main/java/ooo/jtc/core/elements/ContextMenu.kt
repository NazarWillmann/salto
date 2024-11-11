package ooo.jtc.core.elements


import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.SElementGet
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.listElements
import org.openqa.selenium.By.xpath

/**
 * Для ContextMenu не нужен контекст, т.к. блок меню в DOM'e располагается не в контексте строки, а в контексте body.
 */
@ElementType("Контекстное меню")
open class ContextMenu : SContainer(sElement = `$`("ul[role='menu']")) {

    val item
        get() = SElementGet {
            val menuItemBy = xpath(".//li[@role='menuitem' and contains(., '$it')]")
            ContextMenuItem(sElement = this.find(menuItemBy)).withTitle(it)
        }

    val items get() = listElements("li[role='menuitem']") { ContextMenuItem(it).apply { title = text } }

    /**
     * Список текстовых значений всех элементов.
     */
    val itemsText get() = items.map { it.text }

}

@ElementType("Пункт контекстного меню")
class ContextMenuItem(sElement: SelenideElement) : ListItemElement(sElement = sElement)