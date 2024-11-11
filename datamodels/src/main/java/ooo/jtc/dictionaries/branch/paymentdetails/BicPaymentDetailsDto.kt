package ooo.jtc.dictionaries.branch.paymentdetails

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BicPaymentDetailsDto(
    val bic: String,
    val corrAcc: String,
    val bankNameBic: String,
    val bankPlaceBic: String
)
