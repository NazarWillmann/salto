package ooo.jtc.dictionaries.bankbic.acc.restr

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
@EntityName("Ограничения на счёт ${DictionaryNames.BANK_BIC}")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankBicAccRestrictionDto(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    var restrictionCode: ValDescIEnumDto,
    var restrictionDate: LocalDate
): UpdateIEntityDto<BankBicAccRestrictionDto> {

    override fun toModel(): BankBicAccRestriction = Mappers.bankBicAccountRestrMapper.toDomainModel(this)
}