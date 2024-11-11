package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition.text
import io.qameta.allure.Step
import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.Button
import ooo.jtc.core.elements.DocumentCounter
import ooo.jtc.core.elements.DocumentCounter.DocumentCounterType.ERROR
import ooo.jtc.core.elements.DocumentCounter.DocumentCounterType.INFO
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow
import ooo.jtc.interfaces.IDocumentView

@ElementType("Форма 'Результат подписи'")
abstract class ModalSignDocumentResult<V : IDocumentView> : ModalWindow() {

    override val headerText: String = "Результат подписи"

    val docCounterSuccess get() = DocumentCounter(parentElement = this, dataType = INFO)
    val docCounterError get() = DocumentCounter(parentElement = this, dataType = ERROR)
    abstract val sendBtn: Button
    val closeBtn get() = textButton["Закрыть"]

    abstract fun checkDocsPreview(expDocList: List<V>)

    @Step("Проверяем, что '{this.title}' открыта")
    abstract fun checkModalOpened()

    @Step("Проверяем счетчики документов")
    open fun checkCounters(expSuccessDocsCount: Int, expSuccessDocsText: String, expErrorDocsCount: Int, expErrorDocsText: String) {
        docCounterSuccess should text(expSuccessDocsCount.toString())
        docCounterSuccess should text(expSuccessDocsText)

        docCounterError should text(expErrorDocsCount.toString())
        docCounterError should text(expErrorDocsText)
    }
}