package ooo.jtc.dictionaries.salaryemployee

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.address.RuAddressDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.SALARY_EMPLOYEE)
data class SalaryEmployeeDto(
    override var id: UUID?,
    override var version: Int = 0,
    var lastName: String,
    var firstName: String?,
    var middleName: String?,
    var fio: String?,
    var sex: String,
    var birthday: LocalDate?,
    var isResident: Boolean,
    var nationalityCode: String?,
    var inn: String?,
    var snils: String?,
    var personnelNumber: String?,
    var position: String?,
    var status: String,
    var isAgreement: Boolean,
    var customerId: UUID,
    var customerName: String?,
    var userId: UUID,
    var phone: String?,
    var mobilePhone: String?,
    var workPhone: String?,
    var homePhone: String?,
    var email: String?,
    var creatingDate: Instant,
    var inclusionDate: Instant?,
    var excludingDate: Instant?,
    var identityDocument: SalaryEmployeeIdentityDocumentDto?,
    var residencyPermitDocument: SalaryEmployeeResidencyPermitDocumentDto?,
    var paymentDetails: List<SalaryEmployeePaymentDetailsDto>,
    var addressRegistration: RuAddressDto,
    var addressLocation: RuAddressDto,
    var addressInfo: RuAddressDto,
    var isFavorites: Boolean
) : UpdateIEntityDto<SalaryEmployeeDto> {

    override fun toModel(): SalaryEmployee = Mappers.salaryEmployeeMapper.toDomainModel(this)
}


