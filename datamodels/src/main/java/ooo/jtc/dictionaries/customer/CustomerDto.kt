package ooo.jtc.dictionaries.customer

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.common.address.AddressDto
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto
import ooo.jtc.dictionaries.customertype.CustomerTypeDto
import ooo.jtc.extensions.DEFAULT_DATE_FORMAT
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.CUSTOMER)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CustomerDto(
    override var id: UUID?,
    override var version: Int,
    var fullName: String,
    var shortName: String,
    var intName: String?,
    @JvmField var isResident: Boolean,

    var inn: String,
    var okpo: String?,
    var ogrn: String?,
    @JsonFormat(pattern = DEFAULT_DATE_FORMAT) var ogrnDate: LocalDate?,

    var email: String?,
    var phone: String?,
    var description: String? = null,
    @JvmField var isAgreed: Boolean = true,
    var countryDigitCode: String?,
    var okopf: String?,
    var kpp: List<CustomerKppDto>,
    var okfs: String?,
    var block: BlockingInfoDto,
    var addressRegistration: AddressDto?,
    var addressLocation: AddressDto?,
    var customerTypeId: UUID,
    var customerType: CustomerTypeDto?             //absent in ReducedDto
) : UpdateIEntityDto<CustomerDto> {

    override fun toModel(): Customer = Mappers.customerMapper.toDomainModel(this)

}