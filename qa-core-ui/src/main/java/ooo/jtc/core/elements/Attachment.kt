package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element

@ElementType("Вложение")
class Attachment(
    sElement: SelenideElement,
    override var timeout: Long = 1000
) : SContainer(sElement = sElement) {

    val attachName get() = element("[role='name']").withTitle("Название вложения")
    val attachSize get() = element("[role='note']").withTitle("Размер вложения")
    val attachRemove get() = element("[data-action='remove']").withTitle("Иконка удалить вложение")

}