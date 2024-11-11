package ooo.jtc.dictionaries.branch.paymentdetails

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames

@KotlinBuilder
@EntityName(DictionaryNames.PAYMENT_DETAILS_SWIFT)
data class PaymentDetailsSwiftDto(
    var swift: String? = null,
    var bankName: String? = null,
    var countryDigitCode: String? = null,
    var bankCity: String? = null,
    var bankAddress: String? = null
)
