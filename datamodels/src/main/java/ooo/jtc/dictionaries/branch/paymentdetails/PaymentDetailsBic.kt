package ooo.jtc.dictionaries.branch.paymentdetails

import com.github.pozo.KotlinBuilder

@KotlinBuilder
data class PaymentDetailsBic(
    var bic: String? = null,
    var corrAccount: String? = null,
    var bankName: String? = null,
    var bankPlace: String? = null
)
