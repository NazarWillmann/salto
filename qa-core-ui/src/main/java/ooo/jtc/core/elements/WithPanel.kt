package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.scripts.invoke

interface WithPanel : SContext {

    val onPanel: SelenideElement get() = getContext().element("[role='panel']")

    private val expandButton
        get() = getContext().element("[data-action='expand']")
            .withTitle("Разворачивание строки скроллера")

    private val collapseButton
        get() = getContext().element("[data-action='collapse']")
            .withTitle("Сворачивание строки скроллера")

    val isExpanded: Boolean get() = getContext().findAll("[data-action='collapse']").isNotEmpty()

    fun expand() {
        val rowText = getContext().text().substringBefore("\n")
        "Развернуть дополнительную информацию для строки $rowText" {
            if (!isExpanded) expandButton.click(ignoreStep = true)
        }
    }

    fun collapse() {
        val rowText = getContext().text().substringBefore("\n")
        "Свернуть дополнительную информацию для строки $rowText" {
            if (isExpanded) collapseButton.click(ignoreStep = true)
        }
    }
}