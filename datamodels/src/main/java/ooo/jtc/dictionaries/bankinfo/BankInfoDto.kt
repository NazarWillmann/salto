package ooo.jtc.dictionaries.bankinfo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlDto
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlDto
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.BANK_INFO)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankInfoDto(
    override var id: UUID?,
    override var version: Int,
    var fullName: String,
    var shortName: String,
    var phoneSupports: List<PhoneInfoDto>?,                  //needed for creation
    var licenseType: String,
    var license: String,
    var inn: String?,
    var logoFileId: UUID?,
    var logoAccessToken: String?,
    var website: String?,
    var uiSettings: Map<String, Any?>?, // Sergeyev [2021.02.09]: treat settings as Map until we know exact 'uiSettings' fields
    var applicationUrls: List<BankInfoApplicationUrlDto>?,  //needed for creation
    var socialUrls: List<BankInfoSocialUrlDto>?,            //needed for creation
    var description: String?
) : UpdateIEntityDto<BankInfoDto> {

    override fun toModel(): BankInfo = Mappers.bankInfoMapper.toDomainModel(this)
}
