package ooo.jtc.core.selenide

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.formatXPathBy
import org.openqa.selenium.By

fun SelenideElement.scrollIntoView(behavior: String = "auto", block: String = "center", inline: String = "nearest"): SelenideElement =
    this.scrollIntoView("""{behavior : "$behavior", block: "$block", inline: "$inline"}""")

fun SelenideElement.findSafe(by: By): SelenideElement {
    return this.find(formatXPathBy(by))
}

fun SelenideElement.executeJS(script: String) = apply {
    Selenide.executeJavaScript<Any>(script, this.wrappedElement)
}

/**
 * Вернет значение атрибута [attrName].
 * Если атрибут отсутствует, то пустоту.
 */
fun SelenideElement.attrSafe(attrName: String): String = attr(attrName) ?: ""