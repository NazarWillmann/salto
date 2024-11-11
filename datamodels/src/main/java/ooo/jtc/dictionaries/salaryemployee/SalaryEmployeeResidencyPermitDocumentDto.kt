package ooo.jtc.dictionaries.salaryemployee

import com.github.pozo.KotlinBuilder
import java.time.LocalDate

@KotlinBuilder
data class SalaryEmployeeResidencyPermitDocumentDto(
    var docType: String,
    var docTypeName: String,
    var series: String?,
    var number: String?,
    var issuingDate: LocalDate?,
    var issuingAuthority: String?,
    var departmentCode: String?,
    var beginDate: LocalDate?,
    var endDate: LocalDate?,
)
