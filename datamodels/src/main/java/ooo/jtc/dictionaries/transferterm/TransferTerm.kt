package ooo.jtc.dictionaries.transferterm

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class TransferTerm(
    override var id: UUID? = null,
    override var version: Int = 0,

    var code: String?,
    var description: String?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp? = null,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp? = null
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.TRANSFER_TERM

    override fun toDto(): TransferTermDto = Mappers.transferTermMapper.toDto(this)
}