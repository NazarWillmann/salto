package ooo.jtc.rupayment.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PayerDto(
    var inn: String? = null,
    var kpp: String? = null,
    var name: String? = null,
    var account: String? = null,
    var bank: BankDto
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ReceiverDto(
    var inn: String? = null,
    var kpp: String? = null,
    var name: String? = null,
    var account: String? = null,
    var bank: BankDto
)