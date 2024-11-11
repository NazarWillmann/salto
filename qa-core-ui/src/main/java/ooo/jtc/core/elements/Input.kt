package ooo.jtc.core.elements

import com.codeborne.selenide.ClickOptions
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.selenide.scrollIntoView
import ooo.jtc.extensions.getOrException

/**
 * Text field
 * [sName] - value for attribute [@name='$name']
 */
@ElementType("Текстовое поле ввода")
open class Input(
    val name: String,
    sElement: SelenideElement
) : SContainer(sName = name, sElement = sElement) {

    private val clear get() = defaultContext.find("[data-name='$name'][data-action='clear']")

    override fun clear() {
        if (value.orEmpty().isNotEmpty()) {
            this.hover()
            clear.click(ClickOptions.usingDefaultMethod())
        }
    }

    override fun setValue(text: String?): SelenideElement {
        scrollIntoView()
        value?.let { if (it.isNotBlank()) clear() }
        return super.setValue(text)
    }


    override fun getText(): String {
        return value.getOrException("Ошибка получения текста из инпута ${this.sName}")
    }

    override fun innerText(): String = value.getOrException("Ошибка получения текста из инпута ${this.sName}")

}

/**
 * Text field with dropdown selection
 */
@ElementType("Текстовое поле ввода")
class InputWithDropdown(name: String, sElement: SelenideElement) : Input(name = name, sElement = sElement), WithDropDownSelection {
    override fun openOptions(searchOption: String) {
        value = searchOption
    }

    override val dataName: String get() = name
}



