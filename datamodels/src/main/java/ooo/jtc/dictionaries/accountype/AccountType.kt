package ooo.jtc.dictionaries.accountype

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*


@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountType(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("full_name") val fullName: String,
    @JsonProperty("short_name") var shortName: String,
    @JsonProperty("system_name") var systemName: String,
    var description: String,
    @JsonProperty("client_type") var clientType: String,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.ACCOUNT_TYPE

    override fun toDto(): AccountTypeDto = Mappers.accountTypeMapper.toDto(this)
}