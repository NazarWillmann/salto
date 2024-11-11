package ooo.jtc.dictionaries.paymentpriority

import ooo.jtc.interfaces.IEntityView

data class PaymentPriorityView(var code: String = "", var description: String = "") : IEntityView {
    override val searchField: String
        get() = description
}
