package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.Favorite
import ooo.jtc.core.elements.MoreButtonMenu
import ooo.jtc.core.elements.WithCheckBox
import org.openqa.selenium.By

@ElementType("Строка скроллера документа")
open class DocumentScrollerRow(sElement: SelenideElement) : ScrollerRow(sElement = sElement), WithCheckBox {

    val favoriteStar
        get() = Favorite(sElement = find(By.xpath(".//*[./*[@data-field='isFavorites']]")))
            .withTitle("Элемент Избранное в строке (${this.text()})")

    val status get() = label["status"].withTitle("Статус")

    val moreButtonMenu: MoreButtonMenu get() = MoreButtonMenu(this)

    override fun isSelected(): Boolean {
        return this.checkBox.isChecked
    }

    @Step("Кликнуть на элемент 'три точки' (меню строки) и выбрать действие '{action}'")
    fun makeActionByMoreMenu(action: String) {
        moreButtonMenu.selectOption(action)
    }
}