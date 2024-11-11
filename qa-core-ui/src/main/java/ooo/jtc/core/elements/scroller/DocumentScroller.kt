package ooo.jtc.core.elements.scroller

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.elements.ElementType
import kotlin.reflect.KClass

@ElementType("Скроллер документа")
abstract class DocumentScroller<R : DocumentScrollerRow>(
    override var rowClass: KClass<R>,
    override val sElement: SelenideElement,
    open var toolbar: Toolbar = Toolbar()
) : Scroller<R>(rowClass = rowClass, sElement = sElement) {

    /** NB! на текущий момент [2020.10.01] если документов больше 50, выбираются только первые 50. */
    @Step("Выбрать все документы используя чекбокс")
    fun selectAll() {
        toolbar.scrollerCheckbox.check()
    }

    @Step("Найти первый документ в статусе '{status}'")
    fun getFirstInStatus(status: String): R {
        return getRow(conditionDescription = "status = $status", condition = { it.status.text == status })
    }

    @Step("Выбрать строки на скроллере")
    fun selectRows(limitRows: Int): List<R> {
        val rows = getRows(limitRows)
        rows.forEach { it.checkBox.check() }
        return rows
    }
}