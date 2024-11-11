package ooo.jtc.ui.common.sections.modals

import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.visible
import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.documentWordFormGenitiveFunc
import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow

@ElementType("Диалоговое окно 'Снять подпись'")
class ModalUnSignDocument : ModalWindow() {

    override val headerText: String = "Снять подпись"
    val unSignBtn get() = textButton["Снять подпись"]
    val cancelBtn get() = textButton["Отмена"]

    @Step("Проверяем, сообщение при снятии подписи")
    fun checkMessage(expDocCount: Int, isOwnSign: Boolean) {
        // based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21730091 п.4
        val documentWordForm = documentWordFormGenitiveFunc(expDocCount)
        val ownSingOrAllText = if (isOwnSign) "свою подпись" else "все подписи"
        val expMessage = "Вы уверены, что хотите снять $ownSingOrAllText для $expDocCount $documentWordForm?"
        elementByText[expMessage] should visible
    }

    @Step("Проверяем, что форма {this.title} открылась")
    fun checkModalOpened() {
        header should visible
        unSignBtn should enabled
        cancelBtn should enabled
    }
}