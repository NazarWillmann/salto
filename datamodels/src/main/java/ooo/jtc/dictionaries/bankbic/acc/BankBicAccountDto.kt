package ooo.jtc.dictionaries.bankbic.acc

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
@EntityName("Счёт ${DictionaryNames.BANK_BIC}")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankBicAccountDto(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    var account: String,
    var accountType: ValDescIEnumDto,
    var accountBic: String,
    var dateIn: LocalDate,
    var dateOut: LocalDate?,
    var status: ValDescIEnumDto,
    var restrictions: List<BankBicAccRestrictionDto>?
): UpdateIEntityDto<BankBicAccountDto> {

    override fun toModel(): BankBicAccount = Mappers.bankBicAccountMapper.toDomainModel(this)

    fun toED807Account() = Mappers.bankBicAccountMapper.toED807Account(this)
}
