package ooo.jtc.ui.common.sections.modals

import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow

@ElementType("Форма отправки документа в банк")
class ModalSendDocument : ModalWindow() {
    override val headerText: String = "Отправить в банк"
}