package ooo.jtc.core.container

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.WebDriverRunner
import com.codeborne.selenide.impl.BySelectorCollection
import org.openqa.selenium.By

/** Retrieve [ElementsCollection] (list of elements) by [xPath]. */
fun <T : SContainer> T.getElements(xPath: String): ElementsCollection {
    return ElementsCollection(BySelectorCollection(WebDriverRunner.driver(), this.getContext(), By.xpath(xPath)))
}

/**
 * Экстеншн-функция позволяет задавать часть [SContainer.title].
 */
fun <T : SContainer> T.withTitle(name: String): T {
    this.apply { title = name }
    return this
}