package ooo.jtc.core.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.defaultDialogContext
import ooo.jtc.core.elements.AllElements.elementByText


/**
 * Любое модальное окно.
 * По умолчанию имеет role="dialog".
 * В DOM'е не может быть одновременно 2 модальных окна.
 */
abstract class ModalWindow(sElement: SelenideElement = defaultDialogContext) : SContainer(sElement = sElement) {

    /**
     * Текст заголовка окна.
     * Используется для поиска элемента.
     */
    abstract val headerText: String

    val header get() = elementByText[headerText]

    val close by lazy { SContainer(sName = "Закрыть окно", `$x`("//*[@aria-label='$sName']")) }

    @Step("Проверить, что заголовок формы отображается")
    fun checkHeader() {
        header.should(Condition.visible)
    }
}