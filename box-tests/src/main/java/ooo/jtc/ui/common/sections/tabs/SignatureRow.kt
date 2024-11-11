package ooo.jtc.ui.common.sections.tabs

import com.codeborne.selenide.SelenideElement
import ooo.jtc.core.container.SContainer
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType

@ElementType("Строка на вкладке 'Подписи'")
open class SignatureRow(sElement: SelenideElement) : SContainer(sElement = sElement) {

    val eventTime get() = label["createdAt"].withTitle("Дата/время установки подписи")
    val userName get() = label["userName"].withTitle("ФИО пользователя")
    val signToolType get() = label["signTool"].withTitle("Описание типа средства подписи")

    val unSignBtn get() = textButton["Снять подпись"]
    val signBtn get() = textButton["Подписать"]
}