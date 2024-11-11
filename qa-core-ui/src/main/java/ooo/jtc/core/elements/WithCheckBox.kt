package ooo.jtc.core.elements

import ooo.jtc.core.container.SContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.checkbox

/**
 * Интерфейс добавляет чекбокс к элементу реализующему этот интерфейс.
 */
interface WithCheckBox : SContext {
    val checkBox get() = getContext().checkbox.withTitle(title ?: "")
}