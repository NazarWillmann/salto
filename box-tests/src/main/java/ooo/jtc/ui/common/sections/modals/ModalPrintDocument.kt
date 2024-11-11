package ooo.jtc.ui.common.sections.modals

import io.qameta.allure.Step
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

@ElementType("Форма настройки печати")
class ModalPrintDocument : ModalWindow() {

    override val headerText: String = "Настройки печати"
    val printFormat get() = dropdown["extension"].withTitle("Формат печати")
    val printBtn get() = textButton["Печатать"]
    val cancelBtn get() = textButton["Отменить"]

    @Step("Проверить, что в списке отображаются все допустимые форматы")
    fun checkAvailableFormats(expAvailableFormats: List<String>) {
        printFormat.openOptions()
        val actFormatList = printFormat.options.items.map { it.text }
        assertThat("Форматы печати на форме не соответствуют ожидаемым", actFormatList, Matchers.equalTo(expAvailableFormats))
        printFormat.closeOptions()
    }
}