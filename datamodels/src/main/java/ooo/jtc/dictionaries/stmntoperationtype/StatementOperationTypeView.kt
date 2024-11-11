package ooo.jtc.dictionaries.stmntoperationtype

import ooo.jtc.interfaces.IEntityView

data class StatementOperationTypeView(var code: String = "", var description: String = "") : IEntityView {
    override val searchField: String
        get() = description
}
