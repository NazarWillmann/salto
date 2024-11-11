package ooo.jtc.dictionaries.identitydocument

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto
import java.time.LocalDate
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class IdentityDocumentDto(
    var id: UUID?,
    var version: Int,
    var docType: IdentityDocumentTypeDto?,
    var series: String?,
    var number: String,
    var issuingDate: LocalDate,
    var issuingAuthority: String?,
    var departmentCode: String?,
    var countryDigitCode: String?,
    var status: String
)
