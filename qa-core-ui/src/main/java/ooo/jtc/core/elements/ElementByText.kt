package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import org.openqa.selenium.By

/**
 * Text element
 */
@ElementType("Текст")
open class ElementByText(parentElement: SelenideElement, text: String) :
    SContainer(sElement = parentElement.find(By.xpath(".//*[contains(text(),'$text')]")), sName = text)