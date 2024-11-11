package ooo.jtc.ui.pages.documents.rupayment.scroller

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.wait
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.pages.documents.rupayment.sections.RuPaymentScroller
import ooo.jtc.ui.pages.documents.rupayment.sections.RuPaymentScrollerFilter
import ooo.jtc.ui.pages.documents.rupayment.sections.RuPaymentScrollerRow

@ElementType("Скроллер 'Расчеты в рублях'")
open class RuPaymentScrollerPage(endpoint: String = "rupayment/main") :
    DocumentScrollerPage<RuPaymentScroller, RuPaymentScrollerRow, RuPaymentScrollerCategory, RuPaymentScrollerFilter>(
        endpoint = endpoint,
        pageType = ApplicationPageType.CLIENT_PAGE
    ) {

    override val scroller: RuPaymentScroller
        get() = RuPaymentScroller()

    override val filterForm: RuPaymentScrollerFilter get() = RuPaymentScrollerFilter()

    override fun waitLoading() {
        elementByText["Выход"].apply { timeout = 10000L } wait Condition.visible
    }

    val createPayment get() = textButton["Создать платеж"]
    val import get() = textButton["Импорт"]
    val statement get() = textButton["Выписка"]

    val createPaymentModalWindow get() = CreatePaymentModalWindow()

}