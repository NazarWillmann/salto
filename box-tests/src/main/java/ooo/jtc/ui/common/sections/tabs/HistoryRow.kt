package ooo.jtc.ui.common.sections.tabs

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType

@ElementType("Строка на вкладке 'История изменений'")
open class HistoryRow(sElement: SelenideElement) : SContainer(sElement = sElement) {

    val eventTime get() = label["eventTime"].withTitle("Дата/время присвоения статуса")
    val status get() = label["targetStatus"].withTitle("Статус")
    val statusDescription get() = label["targetStatusDescription"].withTitle("Описание статуса")
    val userFullName get() = label["userFullName"].withTitle("ФИО пользователя, присвоившего статус")

    val detailBtn get() = textButton["Подробнее"]

}