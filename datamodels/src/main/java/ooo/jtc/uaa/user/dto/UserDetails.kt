package ooo.jtc.uaa.user.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDetails(
    var lastName: String? = null,
    var firstName: String? = null,
    var middleName: String? = null,
    var email: String? = null,
    var phoneNumber: String? = null
)