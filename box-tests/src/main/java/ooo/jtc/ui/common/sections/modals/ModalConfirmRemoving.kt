package ooo.jtc.ui.common.sections.modals

import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow

@ElementType("Диалоговое окно 'Подтверждение удаление записи'")
class ModalConfirmRemoving : ModalWindow() {

    override val headerText: String = "Удалить"
    val confirm get() = textButton["Удалить"]
    val decline get() = textButton["Отмена"]

}