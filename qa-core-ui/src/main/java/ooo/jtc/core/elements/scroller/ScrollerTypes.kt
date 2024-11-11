@file:Suppress("UNUSED_PARAMETER")

package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.Condition
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.WithCheckBox
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.scripts.StopWatch
import org.openqa.selenium.By
import org.openqa.selenium.By.xpath
import java.time.Duration
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

const val SCROLLER_SEARCH_TIMEOUT = 180000L

val defaultScrollerElement: SelenideElement = defaultContext.find(xpath(".//div[@role='grid']"))


@ElementType("Скроллер")
abstract class Scroller<R : ScrollerRow>(
    open var rowClass: KClass<R>,
    sElement: SelenideElement
) : SContainer(sElement = sElement) {

    companion object {
        val anyRow: (Any) -> Boolean = { true }
    }

    @PublishedApi
    internal val log by LoggerDelegate()

    private val rowBy: By = xpath(".//div[@role='row']")

    /**
     * Функция создания строки скроллера из элемента.
     */
    abstract fun createScrollerRow(sElement: SelenideElement): R

    private val createScrollerRowAction: (SelenideElement) -> R = { createScrollerRow(it) }

    fun selectRowByText(rowText: String) {
        selectRowByText(listOf(rowText))
    }

    @Suppress("UNCHECKED_CAST")
    @Step("Отметить чекбокс в строках с текстом {rowTextList}")
    fun selectRowByText(rowTextList: List<String>): List<R> {
        if (!rowClass.isSubclassOf(WithCheckBox::class)) throw RuntimeException(
            "Нельзя отметить чекбокс в строке на скроллере ${this.title}. " +
                    "Т.к. ${rowClass.simpleName} не имплементирует интерфейс WithCheckBox."
        )

        val condition: (SelenideElement) -> Boolean = { sEl -> rowTextList.any { sEl.has(Condition.text(it)) } }
        val action: (SelenideElement) -> R = {
            val row = createScrollerRow(it) as WithCheckBox
            row.checkBox.check()
            row as R
        }
        return makeActionWithSelenide(condition = condition, action = action, limitActions = rowTextList.size)
    }


    fun getRowByText(rowText: String): R {
        val condition: (SelenideElement) -> Boolean = { it.has(Condition.text(rowText)) }
        return getRowWithSelenide("строка содержит текст '$rowText'", condition)
    }

    /**
     * Ищем строку по [uuid].
     * Но, т.к. [uuid] не отображается на UI, передаем [documentNumber] для поиска и сопоставления на скрине.
     */
    @Step("Найти строку на скроллере по ID (documentNumber: {documentNumber})")
    fun getRowById(uuid: UUID, documentNumber: String): R {
        val condition: (SelenideElement) -> Boolean = { it.attr("data-id") == uuid.toString() }
        return getRowWithSelenide("id = $uuid", condition)
    }

    /**
     * Получаем первую подходящую под условие строку на скроллере.
     */
    @Step("Найти строку на скроллере по условию: {conditionDescription}")
    fun getRowWithSelenide(conditionDescription: String, condition: (SelenideElement) -> Boolean): R {
        return makeActionWithSelenide(condition, createScrollerRowAction, limitActions = 1).first()
    }

    @Step("Найти строку на скроллере по условию: {conditionDescription}")
    fun getRow(conditionDescription: String, condition: (R) -> Boolean): R {
        return makeActionWithRows(condition, { it }, limitActions = 1).first()
    }

    @Step("Найти первую строку")
    fun getFirstRow(): R {
        return makeActionWithSelenide(anyRow, createScrollerRowAction, limitActions = 1).first().attachToAllure()
    }

    @Step("Найти первую строку в избранном")
    fun getFirstFavoriteRow(): R {
        val condition: (SelenideElement) -> Boolean = { it.find("[data-field='isFavorites']").attr("id") == "Fill" }
        return makeActionWithSelenide(condition, createScrollerRowAction, limitActions = 1).first().attachToAllure()
    }

    @Step("Найти первую строку не в избранном")
    fun getFirstNotFavoriteRow(): R {
        val condition: (SelenideElement) -> Boolean = { it.find("[data-field='isFavorites']").attr("id") != "Fill" }
        return makeActionWithSelenide(condition, createScrollerRowAction, limitActions = 1).first().attachToAllure()
    }

    open fun getValuesFromRows(searchLocator: String, limitRows: Int? = null): List<String> {
        val action: (SelenideElement) -> String = { it.find(searchLocator).scrollTo().text() }
        return makeActionWithSelenide(condition = anyRow, action = action, limitRows = limitRows)
    }


    fun getRows(limitRows: Int): List<R> {
        return makeActionWithSelenide(anyRow, createScrollerRowAction, limitRows = limitRows)
    }

    /**
     * @return list of all rows text, not only visible
     */
    fun allRowsText(): List<String> {
        val action: (SelenideElement) -> String = { it.innerText() }
        return makeActionWithSelenide(anyRow, action)
    }

    fun <T> makeActionWithRows(
        condition: (R) -> Boolean,
        action: (R) -> T,
        limitActions: Int? = null,
        limitRows: Int? = null,
        timeout: Long = SCROLLER_SEARCH_TIMEOUT
    ): List<T> {
        return makeActionWithMapper(
            mapper = createScrollerRowAction,
            condition = condition,
            action = action,
            limitActions = limitActions,
            limitRows = limitRows,
            timeout = timeout
        )
    }

    fun <T> makeActionWithSelenide(
        condition: (SelenideElement) -> Boolean,
        action: (SelenideElement) -> T,
        limitActions: Int? = null,
        limitRows: Int? = null,
        timeout: Long = SCROLLER_SEARCH_TIMEOUT
    ): List<T> {
        return makeActionWithMapper(
            mapper = { it },
            condition = condition,
            action = action,
            limitActions = limitActions,
            limitRows = limitRows,
            timeout = timeout
        )
    }

    /**
     * Основной метод для взаимодействия со строками скроллера.
     *
     * Строки в DOM подгружаются динамически. Итерируемся по строкам ориентируясь на innerText в элементе.
     * !!Не пытайся даже думать, чтобы итерироваться по индексу. т.к. элементы в списке `visibleRows` меняются тоже динамически,
     * в зависимости от изменений на скроллере, и каких-то внутренних механизмов (не стал глубоко копать).
     * Поэтому каждую строку последовательно проверяем по предикату [condition] и в случае совпадения - выполняем действие.
     * Возвращаем список с результатами действия [action].
     *
     * @param mapper - функция для преобразования (SelenideElement) в тип [M],
     * после чего и [condition] и [action] будут взаимодействовать с этим типом.
     * @param condition - предикат для поиска.
     * @param action - действие с найденным элементом.
     * @param limitActions - лимит выполняемых действий.
     * Используется когда нужно выполнить действие только над заданным кол-вом найденных по [condition] строк.
     * @param limitRows - лимит проверяемых строк.
     * Используется когда нужно проверить по [condition] заданное кол-во строк от начала.
     * Если ни одна из строк не соответствует [condition], действие выполняться не будет.
     * @param timeout - максимальное время поиска на скроллере.
     */
    private fun <T, M> makeActionWithMapper(
        mapper: (SelenideElement) -> M,
        condition: (M) -> Boolean,
        action: (M) -> T,
        limitActions: Int? = null,
        limitRows: Int? = null,
        timeout: Long = SCROLLER_SEARCH_TIMEOUT
    ): List<T> {
        val start = LocalDateTime.now()
        val end = start.plus(timeout, ChronoUnit.MILLIS)
        val rowTextCollector: MutableList<String> = mutableListOf()
        val resultList: MutableList<T> = mutableListOf()

        val isRowLimitNotReached = { limitRows?.let { rowTextCollector.size < it } ?: true }
        val isActionLimitNotReached = { limitActions?.let { resultList.size < it } ?: true }

        log.info("Ищем строки на скроллере '${this.title}' по предикату")
        val visibleRows = findRows()
        var currentInnerText = visibleRows[0].innerText()

        do {
            val currentEl = visibleRows.find { it.innerText() == currentInnerText }!!
            currentEl.scrollIntoView(false)
            rowTextCollector.add(currentEl.innerText())

            val mElement = mapper.invoke(currentEl)
            if (StopWatch.stopWatch("invoke condition") { condition.invoke(mElement) }) {
                resultList.add(action.invoke(mElement))
            }

            //TODO A.Stykalin [25.07.2020] одна из долгих операций... стоит поискать вариант оптимизации
            // UPD. [19.10.2020] вариант с завязкой на атрибут 'data-id' дольше в среднем на 0.05 сек. на строку, т.е. ~ +10 сек. на 200 строк.
            val indexOfCurrent =
                StopWatch.stopWatch("get indexOfCurrent") { visibleRows.map { it.innerText() }.indexOf(currentEl.innerText()) }

            val isLast = currentEl.innerText() == visibleRows.last().innerText()
            if (isLast) return resultList

            val nextIndex = indexOfCurrent + 1
            currentInnerText = visibleRows[nextIndex].innerText()

        } while (isRowLimitNotReached.invoke()
            && isActionLimitNotReached.invoke()
            && LocalDateTime.now().isBefore(end).also { if (!it) log.info("isTimeLimitReached: $it") }
        )
        return resultList
    }

    /**
     * Скролим вниз до "последней" загруженной строки в DOM'e.
     * И предполагаем, что это (supposedLastRow) самая последняя строка.
     * Если после скрола до неё новых строк не подгружается (сравниваем строки по тексту),
     * то считаем, что это самая последняя строка и возвращаем `false`. (Как значение, что проскролить не удалось).
     * Соответственно, если проскролить удалось (подгрузились новые строки), возвращаем `true`
     */
    fun scrollPageDown(): Boolean {
        val currentRows = findRows()
        return if (currentRows.isNotEmpty()) {
            val supposedLastRow = currentRows.last()
            val supposedLastRowText = supposedLastRow.innerText()
            supposedLastRow.scrollIntoView(true)
            val scrolledLastRowText = findRows().last().innerText()
            val isNotLastRow = supposedLastRowText != scrolledLastRowText
            isNotLastRow
        } else {
            false
        }
    }

    /**
     * Скроллинг до самой нижней строки.
     */
    fun scrollToBottom() {
        do {
            scrollPageDown()
        } while (scrollPageDown())
    }

    /**
     * Скроллинг строк на скроллере до первого вверх.
     * Находим пердпалагаемую епрвую строку (supposedFirstRow);
     * Пытаемся проскролить её к низу.
     * Если после скрола первая строка (scrolledFirstRow) отличается от предполагаемой (supposedFirstRow),
     * то повторяем скролл наверх, через рекурсию.
     * [timeout] - Время для скрола. Зачита от зацикливания.
     */
    fun scrollToFirstRow(timeout: Long = SCROLLER_SEARCH_TIMEOUT) {
        val endTime = LocalDateTime.now().plus(timeout, ChronoUnit.MILLIS)
        val startTime = LocalDateTime.now()
        if (startTime.isAfter(endTime)) return

        val currentRows = findRows()
        if (currentRows.isNotEmpty()) {
            val supposedFirstRow = currentRows[0]
            supposedFirstRow.scrollIntoView(false)
            val scrolledFirstRow = findRows()[0]
            if (supposedFirstRow != scrolledFirstRow) {
                val timeoutLeft = Duration.between(LocalDateTime.now(), endTime).toMillis()
                scrollToFirstRow(timeoutLeft)
            }
        }
    }

    /**
     * Сокращение для поиска строк на скроллере.
     */
    private fun findRows(): ElementsCollection {
        this.find(rowBy).waitUntil(Condition.visible, this.timeout)
        return this.findAll(rowBy)
    }
}