package ooo.jtc.salary.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import java.util.*


@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class SalaryRegisterPayrollDto(
    var id: UUID?,
    var lastName: String,
    var firstName: String?,
    var middleName: String?,
    var inn: String?,
    var amount: String,
    var account: String?,
    var bic: String?,
    var corrAccount: String?,
    var bankName: String?,
    var bankAddress: String?,
    var checkResult: String,
    var comment: String?,
    var salaryRegisterId: String?,
    var employeeId: String?
)

