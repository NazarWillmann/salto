package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.visible
import io.qameta.allure.Step
import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow

@ElementType("Диалоговое окно 'Ошибка снятия подписи'")
class ModalUnSignError : ModalWindow() {

    override val headerText: String = "Ошибка снятия подписи"

    private val expErrorMessage = "Во время снятия подписи произошла непредвиденная ошибка. " +
            "Повторите операцию позже или обратитесь в службу технической поддержки банка"

    private val errorDetails = textButton["Информация для технической поддержки"]

    val closeBtn get() = textButton["Закрыть"]

    @Step("Проверяем, что форма {this.title} открылась")
    fun checkModalOpened() {
        header should visible
        elementByText[expErrorMessage] should visible
        closeBtn should enabled
        errorDetails should visible
        errorDetails.click(false)
        listOf(
            "Код ошибки",
            "Сообщение ошибки",
            "Запрос",
            "Ответ"
        )
            .forEach {
                elementByText[it] should visible
            }
    }
}