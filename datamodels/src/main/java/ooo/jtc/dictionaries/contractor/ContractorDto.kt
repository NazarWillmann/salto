package ooo.jtc.dictionaries.contractor

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto
import ooo.jtc.dictionaries.ground.GroundDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.CONTRACTOR)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContractorDto(
    override var id: UUID? = null,
    override var version: Int = 0,
    var customerId: UUID,
    var name: String,
    var kpp: String?,
    var inn: String?,
    var description: String? = null,
    @JvmField var isFavorites: Boolean? = false,
    var payments: List<ContractorPaymentDto> = emptyList(),
    var grounds: List<GroundDto> = emptyList(),
    var contacts: List<ContractorContactDto> = emptyList()
) : IEntityDto {

    override fun toModel(): Contractor = Mappers.contractorMapper.toDomainModel(this)
}

@KotlinBuilder
@EntityName("${DictionaryNames.CONTRACTOR} (запрос на обновление; общий)")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContractorUpdateDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var kpp: String?,
    var inn: String?,
    var description: String?,
    var payments: List<ContractorPaymentDto>,
    var grounds: List<GroundDto>,
    var contacts: List<ContractorContactDto>
) : UpdateIEntityDto<ContractorDto>

@KotlinBuilder
@EntityName("${DictionaryNames.CONTRACTOR} (запрос на обновление информации)")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ContractorUpdateInfoDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var kpp: String?,
    var inn: String?,
    var description: String?,
    @JvmField var isFavorites: Boolean?
) : UpdateIEntityDto<ContractorDto>