package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer

/**
 * Обертка для одного элемента списка.
 */
@ElementType("Пункт выпадающего списка")
open class ListItemElement(
    sElement: SelenideElement
) : SContainer(sElement = sElement) {

    val dataAction get() = attr("data-action")
    val dataDisabled get() = attr("data-disabled").toBoolean()
    val dataActive get() = attr("data-active").toBoolean()
    val dataSelected get() = attr("data-selected").toBoolean()

}