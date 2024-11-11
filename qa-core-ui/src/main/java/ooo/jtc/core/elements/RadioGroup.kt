package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.elements.AllElements.listElements
import org.openqa.selenium.By


/**
 * Radio group
 */
class RadioGroup(sElement: SelenideElement) : SContainer(sElement = sElement) {

    private val items get() = listElements("button[role='radio']") { RadioGroupItem(it, text) }

    val textItems get() = items.map { it.text }

    val selected get() = items.find { it.isSelected } ?: throw NoSuchElementException("No one item selected in RadioGroup: $sName")

    @Step("Выбрать опцию '{itemText}")
    fun selectByText(itemText: String) {
        this.find(By.xpath(".//*[@role='radio'][text()='$itemText']")).click()
    }

    @Step("Выбрать опцию '{dataValue}")
    fun selectByDataValue(dataValue: String) {
        this.find("[role='radio'][data-value='$dataValue']").click()
    }
}

@ElementType("Радиокнопка")
class RadioGroupItem(sElement: SelenideElement, name: String) : SContainer(sName = name, sElement = sElement) {

    override fun isSelected(): Boolean = attr("data-checked")?.toBoolean() ?: false

    fun select() {
        if (!isSelected) click()
    }
}