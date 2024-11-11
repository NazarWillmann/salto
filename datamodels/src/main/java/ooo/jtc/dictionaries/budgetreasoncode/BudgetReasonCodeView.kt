package ooo.jtc.dictionaries.budgetreasoncode

import ooo.jtc.interfaces.IEntityView

data class BudgetReasonCodeView(var code: String = "", var description: String = "", var payType: String = "") : IEntityView {
    override val searchField: String
        get() = description
}