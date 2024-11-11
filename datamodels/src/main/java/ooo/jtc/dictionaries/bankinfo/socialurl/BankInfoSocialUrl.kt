package ooo.jtc.dictionaries.bankinfo.socialurl

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.util.UUID

@KotlinBuilder
data class BankInfoSocialUrl(
    override var id: UUID?,
    @JsonIgnore override var version: Int = 0,
    var name: String?,
    @JsonProperty("id_bank") var bankId: UUID?, // not nullable in already existing records
    @JsonProperty("social_type") var socialType: String, //BankInfoSocialType
    @JsonProperty("social_url") var socialUrl: String,
    @JsonIgnore var ordering: Int?
): ITransferEntity {
    @NotRequiredForTest @JsonIgnore override val entityName: String = "Ссылка на медиа ресурс"

    override fun toDto(): BankInfoSocialUrlDto = Mappers.bankInfoSocialUrlMapper.toDto(this)
}