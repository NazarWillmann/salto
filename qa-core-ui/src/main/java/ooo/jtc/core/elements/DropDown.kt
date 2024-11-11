package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer

@ElementType("Выпадающий список")
class DropDown(override val dataName: String, sElement: SelenideElement) : SContainer(sElement = sElement), WithDropDownSelection {
    /**
     * Для открытия выпадающего списка, необязательно передавать какое-либо значение.
     */
    fun openOptions() {
        openOptions("")
    }

    override fun openOptions(searchOption: String) {
        if (!options.isDisplayed) {
            click(ignoreStep = true)
        }
    }

    override val selectBy = SelectBy.INNER_TEXT
}