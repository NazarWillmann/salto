package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement

@ElementType("Текстовое поле ввода")
open class TextArea(sElement: SelenideElement) : Input(name = "", sElement = sElement)

@ElementType("Текстовое поле ввода с выпадающим списком")
class TextAreaWithDropdown(override val dataName: String, sElement: SelenideElement) : TextArea(sElement = sElement), WithDropDownSelection {
    override fun openOptions(searchOption: String) {
        value = searchOption
    }
}