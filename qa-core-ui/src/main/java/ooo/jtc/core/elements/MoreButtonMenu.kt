package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure

@ElementType("Кнопка 'Ещё' с контекстным меню")
class MoreButtonMenu(val rowElement: SelenideElement) : ContextMenu() {
    private val moreButton: MoreButton get() = MoreButton(ctx = rowElement)

    @Step("Открыть контекстное меню")
    fun openMoreMenu(): MoreButtonMenu {
        moreButton.click()
        return this
    }

    @Step("Выбрать действие '{optionName}' в контекстном меню '...'")
    fun clickByOption(optionName: String) {
        openMoreMenu()
        item[optionName].click()
    }

    override fun selectOption(vararg optionName: String?) {
        clickByOption(optionName[0]!!)
    }

    override fun selectOption(vararg optionNum: Int) {
        openMoreMenu()
        items[optionNum[0]].click()
    }

    /**
     * Сокращение и оверрайд стандартного клика для избегания путаницы.
     */
    override fun click() {
        openMoreMenu()
    }

    @Step("Получить список доступных действий для строки")
    fun getAvailableActions(): List<String> {
        this.openMoreMenu()
        return this.itemsText.attachToAllure("rowAvailableActions")
    }
}