package ooo.jtc.ui.common.sections.tabs

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.RegexpConst.UI_EVENT_TIME_REGEX
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.listElements
import ooo.jtc.core.elements.ElementType
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.documents.getBankOrClientDescription
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.ApplicationPageType.BANK_PAGE
import ooo.jtc.ui.common.pages.ApplicationPageType.CLIENT_PAGE
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

@ElementType("Вкладка 'История изменений'")
interface HistoryTab<T : TabSection<T>, R : HistoryRow> : TabSection<T> {

    /**
     * Тип документа
     */
    var headerName: String

    /**
     * Функция, которая создает объект строки [R] из [SelenideElement].
     */
    val createRow: (SelenideElement) -> R

    /**
     * Статусы в которых должна отображаться кнопка "Подробнее".
     */
    val detailStatuses: List<IDocumentStatus<*>>

    /**
     * Строки на закладке, отражающие историю изменений.
     */
    val historyRows: List<R> get() = getContext().listElements("[role='row']") { createRow(it).withTitle(it.find("[role='status']").text) }


    @Step("Проверить, что статусы отображаются в соответствующем ТЗ порядке")
    fun checkStatusOrder(expStatusOrder: List<String>) {
        val actStatusOrder = historyRows.map { it.status.text }
        assertThat(
            "статусы отображаются не в соответствующем ТЗ порядке",
            actStatusOrder, Matchers.equalTo(expStatusOrder)
        )
    }

    @Step("Проверить отображение полей во всех статусах")
    fun checkAllFields(pageType: ApplicationPageType) {
        val hasDetailBtn: (HistoryRow) -> Boolean = { row ->
            val statusTransform: (IDocumentStatus<*>) -> String = getHistoryStatusTransform(pageType)
            detailStatuses.map(statusTransform).contains(row.status.text)
        }

        historyRows.forEach {
            it.eventTime.should(Condition.matchText(UI_EVENT_TIME_REGEX))
            it.status.should(Condition.visible)
            it.statusDescription.should(Condition.visible)
            it.userFullName.should(Condition.visible)

            if (hasDetailBtn.invoke(it)) {
                it.detailBtn.should(Condition.visible)
            }
        }
    }

    @Step("Проверить, что в рабочей области документа отображается минимум одна строка")
    fun checkHistoryExist() {
        assertThat("ни одной строки с историей не найдено", historyRows.size, Matchers.greaterThan(0))
    }

    @Step("Проверить, что верхняя строка истории содержит статус документа = {expLastStatus}")
    fun checkLastStatus(expLastStatus: String) {
        assertThat(
            "Верхняя строка истории содержит статус отличный от $expLastStatus",
            historyRows[0].status.text, Matchers.equalTo(expLastStatus)
        )
    }

    fun clickDetailButton(statuses: List<IDocumentStatus<*>>, pageType: ApplicationPageType) {
        val hasDetailBtn: (HistoryRow) -> Boolean = { row ->
            val statusTransform = getHistoryStatusTransform(pageType)
            statuses.map(statusTransform).contains(row.status.text)
        }
        ooo.jtc.scripts.repeat(function = { historyRows }, condition = { it.isNotEmpty() }, 4)
        historyRows.first(hasDetailBtn).detailBtn.click()
    }

    companion object {
        /**
         * Возвращает функцию маппинга из IDocumentStatus<*> в значение, которое выводится на фронте,
         * в зависимости от [pageType].
         * e.g.: NEW -> На подпись.
         */
        fun getHistoryStatusTransform(pageType: ApplicationPageType): (IDocumentStatus<*>) -> String {
            return when (pageType) {
                CLIENT_PAGE -> { it: IDocumentStatus<*> -> it.descriptionClient }
                BANK_PAGE -> { it: IDocumentStatus<*> -> it.getBankOrClientDescription() }
            }
        }
    }
}

