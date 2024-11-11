package ooo.jtc.ui.dictionaries

import com.codeborne.selenide.Condition
import ooo.jtc.asserts.shouldTrue
import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.interfaces.IEntityView
import ooo.jtc.testdata.Users
import ooo.jtc.text.TextUtils.declensionByDigit
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.pages.DictionaryCreatePage
import ooo.jtc.ui.common.pages.DictionaryScrollerPage
import ooo.jtc.ui.common.sections.CommonSections.modalConfirmRemoving

object UiDictionaryTestsBody {


    fun <V : IEntityView> createEntity(
        view: V,
        scrollerPage: DictionaryScrollerPage,
        formPage: DictionaryCreatePage<V>
    ) = run {
        scrollerPage openScrollerBy Users.bankAdmin
        scrollerPage.textButton["Создать"].click()
        formPage.fill(view)
        formPage.save.click()
        UiCommonChecks.checkPushMessage("Запись успешно сохранена")
        formPage.back.click()
        scrollerPage.scroller.scrollToFirstRow()
        scrollerPage.scroller.getRowByText(view.searchField) should Condition.visible
        view
    }

    fun <V : IEntityView> deleteSomeEntities(
        views: List<V>,
        scrollerPage: DictionaryScrollerPage
    ) = run {
        scrollerPage openScrollerBy Users.bankAdmin
        val rowsText = views.map { it.searchField }
        scrollerPage.scroller.selectRowByText(rowTextList = rowsText)
        scrollerPage.makeAction("Удалить")
        modalConfirmRemoving should Condition.visible
        modalConfirmRemoving.confirm.click()

        val number = views.size
        val deleted = declensionByDigit(number, "Удалена", "Удалено", "Удалено")
        val records = declensionByDigit(number, "запись", "записи", "записей")
        val deleteText = "$deleted $number $records"
        scrollerPage.elementByText[deleteText].apply { timeout = 5000L } should Condition.visible
        val allRowsText = scrollerPage.scroller.allRowsText()
        rowsText.forEach { rowText ->
            "Строки с '$rowText' не существуют" shouldTrue {
                allRowsText.none { it.contains(rowText) }
            }
        }
    }
}