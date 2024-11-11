package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer

/**
 * Text field
 */
@ElementType("Текстовое поле")
open class Label(sElement: SelenideElement) : SContainer(sElement = sElement)