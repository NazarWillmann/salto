package ooo.jtc.core.selenide

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Driver
import org.openqa.selenium.WebElement

fun innerTextCondition(innerText: String): Condition = InnerTextConditon(innerText)

class InnerTextConditon(val innerText: String) : Condition("текст: $innerText") {

    override fun apply(driver: Driver?, wrappedWebElement: WebElement?): Boolean =
        wrappedWebElement?.getAttribute("innerText")?.contains(innerText) ?: false

    override fun getName(): String {
        return "$name:$innerText"
    }
}


fun visibleText(visibleText: String): Condition = VisibleTextCondition(visibleText)

class VisibleTextCondition(val visibleText: String) : Condition("текст: $visibleText" ) {

    override fun apply(driver: Driver?, wrappedWebElement: WebElement?): Boolean {
        val innerText = wrappedWebElement?.getAttribute("innerText") ?: ""
        val value = wrappedWebElement?.getAttribute("value") ?: ""
        val dataValue = wrappedWebElement?.getAttribute("data-value") ?: ""
        val text = wrappedWebElement?.text ?: ""
        return listOf(innerText, value, text, dataValue).any { it.contains(visibleText) }
    }

}