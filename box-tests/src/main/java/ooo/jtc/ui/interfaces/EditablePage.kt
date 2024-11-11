package ooo.jtc.ui.interfaces

import ooo.jtc.interfaces.IEntityView

interface EditablePage<V : IEntityView> {
    /**
     * Проверить, что поля на форме редактируемые.
     */
    fun checkFieldsEditable(view: V)
}