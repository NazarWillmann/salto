package ooo.jtc.ui.common.sections.modals

import io.qameta.allure.Step
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow
import ooo.jtc.extensions.toArray
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

@ElementType("Форма настройки экспорта")
class ModalExportDocument : ModalWindow() {

    override val headerText: String = "Настройки экспорта"
    val exportFormat get() = dropdown["extension"].withTitle("Формат экспорта")
    val exportBtn get() = textButton["Экспортировать"]
    val cancelBtn get() = textButton["Отменить"]

    @Step("Проверить, что в списке отображаются все допустимые форматы")
    fun checkAvailableFormats(expAvailableFormats: List<String>) {
        exportFormat.openOptions()
        val actFormatList = exportFormat.options.items.map { it.text }
        assertThat("Форматы экспорта на форме не соответствуют ожидаемым", actFormatList, Matchers.containsInAnyOrder(*expAvailableFormats.toArray()))
        exportFormat.closeOptions()
    }
}