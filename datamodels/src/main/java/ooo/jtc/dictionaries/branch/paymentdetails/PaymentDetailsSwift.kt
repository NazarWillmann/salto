package ooo.jtc.dictionaries.branch.paymentdetails

import com.github.pozo.KotlinBuilder

@KotlinBuilder
data class PaymentDetailsSwift(
    var swift: String? = null,
    var bankName: String? = null,
    var countryDigitCode: String? = null,
    var bankCity: String? = null,
    var bankAddress: String? = null
)