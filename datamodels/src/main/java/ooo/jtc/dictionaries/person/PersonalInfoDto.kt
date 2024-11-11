package ooo.jtc.dictionaries.person

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import java.time.LocalDate

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PersonalInfoDto(
    var firstName: String,
    var lastName: String,
    var middleName: String?,
    var sex: String?,
    var birthday: LocalDate?,
    var nationalityCountryDigitCode: String?,
    var isResident: Boolean,
    var inn: String?,
    var snils: String?,
    var mobilePhone: String?,
    var email: String?,
    var isPdAgreed: Boolean = true
)
