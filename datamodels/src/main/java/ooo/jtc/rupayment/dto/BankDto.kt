package ooo.jtc.rupayment.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
open class BankDto(
    var address: String? = null,
    var name: String? = null,
    var bic: String? = null,
    var corrAccount: String? = null
)
