package ooo.jtc.dictionaries.lettertypetobank

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.annotations.Unique
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class LetterTypeToBank(
    override var id: UUID?,
    override var version: Int,
    @Unique var code: String,
    @Unique var description: String,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.LETTER_TYPE_TO_BANK

    override fun toDto(): LetterTypeToBankDto = Mappers.letterTypeToBankMapper.toDto(this)
}