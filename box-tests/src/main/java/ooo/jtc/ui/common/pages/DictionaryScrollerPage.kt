package ooo.jtc.ui.common.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.container.wait
import ooo.jtc.core.elements.AllElements.textButton

open class DictionaryScrollerPage(
    endpoint: String,
    sElement: SelenideElement = defaultContext
) : ScrollerPage<DictionaryScroller>(pageType = ApplicationPageType.BANK_PAGE, endpoint = endpoint, sElement = sElement) {

    override fun waitLoading() {
        textButton["Создать"].apply { timeout = 10000L } wait Condition.visible
    }

    override val scroller: DictionaryScroller get() = DictionaryScroller()
}