package ooo.jtc.dictionaries.bankinfo.applicationurl

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IEntityDto
import java.util.UUID

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BankInfoApplicationUrlDto(
        override var id: UUID? = null,
        @NotRequiredForTest @JsonIgnore override var version: Int = 0,
        var bankId: UUID? = null,
        var name: String,
        var appType: String,    //ApplicationType
        var storeType: String,  //ApplicationStoreType
        var downloadUrl: String,
        @JsonIgnore var ordering: Int? = null
): IEntityDto {
    override fun toModel(): BankInfoApplicationUrl = Mappers.bankInfoApplicationUrlMapper.toDomainModel(this)
}