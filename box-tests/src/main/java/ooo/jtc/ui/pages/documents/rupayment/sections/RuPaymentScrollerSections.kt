package ooo.jtc.ui.pages.documents.rupayment.sections

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.scroller.ExpandedScroller
import ooo.jtc.core.elements.scroller.ExpandedScrollerRow
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.core.elements.scroller.defaultScrollerElement

class RuPaymentScroller : ExpandedScroller<RuPaymentScrollerRow>(RuPaymentScrollerRow::class, defaultScrollerElement) {
    override fun createScrollerRow(sElement: SelenideElement): RuPaymentScrollerRow {
        return RuPaymentScrollerRow(sElement)
    }
}

@ElementType("Строка скроллера")
class RuPaymentScrollerRow(sElement: SelenideElement) : ExpandedScrollerRow(sElement = sElement) {

    //todo Добавить элементы "Дата календаря", сейчас нормальные xpath не построить

}

@ElementType("Форма фильтра скроллера РПП")
class RuPaymentScrollerFilter : FilterForm() {

    val documentNumber get() = input["documentNumber"].apply { title = "Номер документа" }

    val paymentGroundDescription get() = input["paymentGroundDescription"].apply { title = "Назначение платежа" }

    val amountFrom get() = input["amountFrom"].apply { title = "Сумма от" }

    val amountTo get() = input["amountTo"].apply { title = "Сумма до" }

}


