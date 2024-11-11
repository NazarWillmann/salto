package ooo.jtc.dictionaries.salaryemployee

import com.github.pozo.KotlinBuilder
import java.time.LocalDate

@KotlinBuilder
data class SalaryEmployeeIdentityDocument(
    var docTypeCode: String,
    var docType: String,
    var docTypeName: String,
    var series: String?,
    var number: String?,
    var issuingAuthority: String?,
    var issuingDate: LocalDate?,
    var departmentCode: String?,
    var countryDigitCode: String?,
    var endDate: LocalDate?
)
