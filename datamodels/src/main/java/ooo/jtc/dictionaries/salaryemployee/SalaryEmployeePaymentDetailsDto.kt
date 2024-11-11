package ooo.jtc.dictionaries.salaryemployee

import com.github.pozo.KotlinBuilder
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
data class SalaryEmployeePaymentDetailsDto(
    override var id: UUID?= null,
    override var version: Int = 0,
    var employeeId: UUID? = null,
    var account: String?= null,
    var bic: String?= null,
    var corrAccount: String?= null,
    var bankName: String?= null,
    var bankPlace: String?= null,

): UpdateIEntityDto<SalaryEmployeePaymentDetailsDto>
