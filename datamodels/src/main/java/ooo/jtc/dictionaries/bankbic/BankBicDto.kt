package ooo.jtc.dictionaries.bankbic

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto
import ooo.jtc.dictionaries.bankbic.ed807.ED807BicNode
import ooo.jtc.dictionaries.bankbic.innerenum.BankBicAllowedServicesIEnumDto
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.BANK_BIC)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankBicDto(
    override var id: UUID?,
    override var version: Int,
    var bic: String,
    var name: String,
    var countryAlpha2Code: String?,
    var zip: String?,
    var locationType: String?,
    var location: String?,
    var address: String?,
    var parentBic: String?,
    var participantTransferType: ValDescIEnumDto,
    var participantType: ValDescIEnumDto,
    var allowedServices: BankBicAllowedServicesIEnumDto,
    var dateIn: LocalDate,
    var dateOut: LocalDate?,
    var status: ValDescIEnumDto,
    var accounts: List<BankBicAccountDto>?,
    var restrictions: List<BankBicRestrictionDto>?
) : UpdateIEntityDto<BankBicDto> {

    override fun toModel(): BankBic = Mappers.bankBicMapper.toDomainModel(this)

    fun toReducedED807Node(): ED807BicNode {
        return ED807BicNode(
            bic = bic,
            participantInfo = Mappers.bankBicMapper.toED807ParticipantInfo(this),
            accounts = accounts?.map { it.toED807Account() }
        )
    }
}