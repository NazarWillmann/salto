package ooo.jtc.ui.common.pages


import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.Favorite
import ooo.jtc.core.elements.scroller.DocumentScroller
import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.core.elements.scroller.ScrollerCategory
import ooo.jtc.core.elements.scroller.ScrollerTab
import org.openqa.selenium.By

abstract class DocumentScrollerPage<S : DocumentScroller<out SR>, SR : DocumentScrollerRow, C : ScrollerCategory, F : FilterForm>(
    endpoint: String,
    pageType: ApplicationPageType,
    sElement: SelenideElement = defaultContext
) : ScrollerPage<S>(endpoint = endpoint, pageType = pageType, sElement = sElement) {

    abstract val filterForm: F

    @Step("Открыть панель фильтрации")
    fun openFilter() {
        val textButton = textButton["Фильтр"]
        textButton.click()
    }

    val activeTab: ScrollerTab
        get() = ScrollerTab(
            sName = "Активная вкладка",
            sElement = find("[role='tablist'] [type = 'button'][role = 'TAB'][disabled]")
        )

    fun getTab(category: C): ScrollerTab {
        val categoryName = category.categoryName
        val sTab = find(By.xpath(".//*[@role=\"tablist\"]//*[@role=\"TAB\" and .//*[text()='$categoryName']]"))
        return ScrollerTab(sName = categoryName, sTab)
    }

    @Step("Перейти на вкладку {category.categoryName}")
    fun openTab(category: C): ScrollerTab {
        val tab = getTab(category)
        tab.click()
        return tab
    }

    val favoriteStar
        get() = Favorite(sElement = find(By.xpath(".//*[@role='button' and .//*[text()='Избранное']]")))
            .withTitle("Кнопка Избранное на скроллере ${this.title}")

    @Step("Отфильтровать документ на скроллере по номеру документа {documentNumber}")
    fun filterByDocumentNumber(documentNumber: String) {
        openFilter()
        element("[role='dialog'] [name='documentNumber']").value = documentNumber
        filterForm.apply.click()
        loader.shouldNot(visible)
    }

    @Step("Отфильтровать документ на скроллере по статусу {searchStatus}")
    fun filterByStatus(searchStatus: String) {
        openFilter()
        dropdown["status"].withTitle("Статус").select(searchStatus)
        filterForm.apply.click()
        loader.shouldNot(visible)
    }

    @Step("Найти строку на скроллере по номеру документа {documentNumber}")
    open fun findDocumentRowByNumber(documentNumber: String): SR {
        filterByDocumentNumber(documentNumber)
        return scroller.getFirstRow()
    }

    @Step("Выбрать {docCount} документа(-ов) в статусе '{searchStatus}'")
    open fun selectDocumentsByStatus(searchStatus: String, docCount: Int): List<SR> {
        filterByStatus(searchStatus)
        return scroller.selectRows(docCount)
    }
}