package ooo.jtc.core.container

import com.codeborne.selenide.SelenideElement


/**
 * Интерфейс для сохранения контекста в разрезе [sElement].
 * Позволяет осуществлять поиск от текущего селенид-элемента [sElement], предоставляя контекст.
 * Т.е. для вложенного элемента, текущий элемент является контекстом.
 * Преимущественно используется для создания интерфейсов элементов (компонентов),
 * где [sElement] является контекстом (родителем) создаваемого элемента.
 * <p>
 * см. interface [ooo.jtc.core.elements.WithCheckBox].
 */
interface SContext {
    val sElement: SelenideElement
    var title: String?

    fun getContext(): SelenideElement {
        return sElement
    }
}