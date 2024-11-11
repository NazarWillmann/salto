package ooo.jtc.dictionaries.agreement

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.AGREEMENT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AgreementDto(
    override var id: UUID?,
    override var version: Int,

    var agreementDate: LocalDate?,
    var agreementNumber: String?,
    var agreementType: String?,
    var endDate: LocalDate? = null,
    var description: String?,
    var customerId: UUID,
    var customerShortName: String?,
    var customerFullName: String?,
    var status: String
) : UpdateIEntityDto<AgreementDto> {

    override fun toModel(): Agreement = Mappers.agreementMapper.toDomainModel(this)

    fun toReducedDto(): AgreementDto {
        return this.copy(
            customerShortName = null,
            customerFullName = null
        )
    }
}