package ooo.jtc.dictionaries.bankinfo.socialurl

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IEntityDto
import java.util.UUID

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BankInfoSocialUrlDto(
    override var id: UUID? = null,
    @NotRequiredForTest @JsonIgnore override var version: Int = 0,
    var name: String?,
    var bankId: UUID? = null, // not nullable in already existing records
    var socialType: String, //BankInfoSocialType
    var socialUrl: String,
    @JsonIgnore var ordering: Int? = null,
): IEntityDto {
    override fun toModel(): BankInfoSocialUrl = Mappers.bankInfoSocialUrlMapper.toDomainModel(this)
}