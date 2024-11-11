package ooo.jtc.dictionaries.codevo

import ooo.jtc.interfaces.IEntityView

data class CodeVoView(var code: String = "", var description: String = "", var payType: String = "") : IEntityView {
    override val searchField: String
        get() = description
}