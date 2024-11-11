package ooo.jtc.core.elements

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.listElements

@ElementType("Главное меню")
open class SidebarMenu : SContainer() {

    fun selectCustomer(customerName: String) {
        MenuItem(sElement = `$x`("//button[@role='menuitem' and contains(., '$customerName')]"))
            .withTitle(customerName)
            .click()
    }

    val items get() = listElements("button[role='menuitem']") { MenuItem(it).withTitle(text) }

    val textItems get() = items.map { it.text }

    @ElementType("Пункт главное меню")
    class MenuItem(sElement: SelenideElement = Selenide.`$`("button[role='menuitem']")) : SContainer(sElement = sElement)
}