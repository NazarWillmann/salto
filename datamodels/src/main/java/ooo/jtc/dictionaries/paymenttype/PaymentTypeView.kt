package ooo.jtc.dictionaries.paymenttype

import ooo.jtc.interfaces.IEntityView

data class PaymentTypeView(var code: String = "", var description: String = "") : IEntityView {
    override val searchField: String
        get() = description
}
