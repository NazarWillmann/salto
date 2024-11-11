package ooo.jtc.dictionaries.kbk

import ooo.jtc.interfaces.IEntityView

data class KbkView(var code: String = "", var description: String = "") : IEntityView {
    override val searchField: String
        get() = description
}