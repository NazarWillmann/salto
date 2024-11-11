package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.visible
import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.documentWordFormGenitiveFunc
import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.interfaces.IDocumentView

//based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729973
@Suppress("MemberVisibilityCanBePrivate")
@ElementType("Диалоговое окно 'Снять подпись' (отсечка)")
abstract class ModalUnSignCutOffDocument<V : IDocumentView> : ModalSignDocumentResult<V>() {

    override val headerText: String = "Снять подпись"
    val proceedBtn get() = textButton["Продолжить"]
    val cancelBtn get() = textButton["Отменить"]

    @Step("Проверяем, сообщение при снятии подписи")
    fun checkMessage(expDocCount: Int, isOwnSign: Boolean) {
        // based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729973 п.4
        val documentWordForm = documentWordFormGenitiveFunc(expDocCount)
        val ownSingOrAllText = if (isOwnSign) "свою подпись" else "все подписи"
        val expMessage = "Вы уверены, что хотите снять $ownSingOrAllText для $expDocCount $documentWordForm?"
        elementByText[expMessage] should visible
    }

    /**
     * @param canUnSign - признак, что на форме есть документы, с которых можно снять подпись
     */
    @Step("Проверяем, что форма {this.title} открылась")
    fun checkModalOpened(canUnSign: Boolean) {
        header should visible
        docCounterError should visible
        docCounterSuccess should visible
        if (canUnSign) {
            proceedBtn should enabled
            cancelBtn should enabled
        } else {
            closeBtn should enabled
        }
    }
}