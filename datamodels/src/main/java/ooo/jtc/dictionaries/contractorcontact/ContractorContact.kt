package ooo.jtc.dictionaries.contractorcontact

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
data class ContractorContact(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_contractor") var contractorId: UUID,
    var name: String,
    var position: String?,
    var email: String?,
    var telephone: String?,
    @JsonProperty("c_comment") var comment: String?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.CONTRACTOR_CONTACT

    override fun toDto(): ContractorContactDto = Mappers.contractorContactMapper.toDto(this)
}