package ooo.jtc.dictionaries.branch.paymentdetails

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames

@KotlinBuilder
@EntityName(DictionaryNames.PAYMENT_DETAILS_BIC)
data class PaymentDetailsBicDto(
    var bic: String? = null,
    var corrAccount: String? = null,
    var bankName: String? = null,
    var bankPlace: String? = null
)
