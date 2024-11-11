package ooo.jtc.ui.common.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.container.wait
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.interfaces.IEntityView
import ooo.jtc.ui.interfaces.CreatePage

abstract class DictionaryCreatePage<V : IEntityView>(endpoint: String, sElement: SelenideElement = defaultContext) : ApplicationPage(
    pageType = ApplicationPageType.BANK_PAGE,
    endpoint = endpoint,
    sElement = sElement
), CreatePage<V> {

    override fun waitLoading() {
        save.apply { timeout = 10000L } wait Condition.visible
    }

    val save get() = textButton["Сохранить"]
    val decline get() = textButton["Отмена"]
    val back get() = textButton["Назад"]
}