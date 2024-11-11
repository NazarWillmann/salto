package ooo.jtc.dictionaries.bankrepresentative

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class BankRepresentative(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_bank") var bankId: UUID?,
    @JsonProperty("id_user") var userId: UUID?,
    @JsonProperty("position_name") var position: String?,
    @JsonProperty("e_mail") var email: String?,
    var phone: String?,

    @JsonProperty("is_block") @JvmField var isBlock: Boolean,
    @JsonProperty("block_date") var blockDate: Timestamp?,
    @JsonProperty("id_block_user") var blockUserId: UUID?,
    var description: String?,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.BANK_REPRESENTATIVE

    override fun toDto(): BankRepresentativeDto = Mappers.bankRepresentativeMapper.toDto(this)
}