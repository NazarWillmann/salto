package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer

@ElementType("Чекбокс")
class CheckBox(sElement: SelenideElement) : SContainer(sElement = sElement) {
    init {
        useJs = true
    }

    val isChecked get() = find("input").attr("data-checked")?.toBoolean() ?: false

    @Step("Отметить чекбокс '{this.title}'")
    fun check() {
        if (!isChecked) this.click(true)
    }

    @Step("Снять отметку с чекбокса '{this.title}'")
    fun unCheck() {
        if (isChecked) this.click(true)
    }
}