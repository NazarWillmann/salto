package ooo.jtc.dictionaries.bankinfo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrl
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrl
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class BankInfo(
    override var id: UUID?,
    override var version: Int,

    @JsonProperty("full_name") var fullName: String,
    @JsonProperty("short_name") var shortName: String,
    @JsonProperty("license_type") var licenseType: String,
    @JsonProperty("license_number") var license: String,
     var inn: String?,
    @JsonProperty("id_file_logo") var logoFileId: UUID?,
    var website: String?,
    @NotRequiredForTest @JsonProperty("ui_settings") var uiSettings: String?,
    var description: String?,

    //filled in postProcessor
    var phoneSupports: List<PhoneInfo>?,
    var socialUrls: List<BankInfoSocialUrl>?,
    var applicationUrls: List<BankInfoApplicationUrl>?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.BANK_INFO

    override fun toDto(): BankInfoDto = Mappers.bankInfoMapper.toDto(this)
}