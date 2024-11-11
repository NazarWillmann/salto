package ooo.jtc.dictionaries.salarypaymenttype

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.SALARY_PAYMENT_TYPE)
data class SalaryPaymentTypeDto(
    override var id: UUID?,
    override var version: Int,

    var code: String?,
    var name: String?,
    var incomeTypeCode: Int?,
) : UpdateIEntityDto<SalaryPaymentTypeDto> {
    override fun toModel(): SalaryPaymentType = Mappers.salaryPaymentTypeMapper.toDomainModel(this)
}
