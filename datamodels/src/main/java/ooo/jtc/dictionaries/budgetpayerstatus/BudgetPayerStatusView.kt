package ooo.jtc.dictionaries.budgetpayerstatus

import ooo.jtc.interfaces.IEntityView

data class BudgetPayerStatusView(var code: String = "", var description: String = "") : IEntityView {
    override val searchField: String
        get() = description
}