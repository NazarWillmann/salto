package ooo.jtc.dictionaries.customertype

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
data class CustomerType(
    override var id: UUID?,
    override var version: Int,
    val name: String,
    @JsonProperty("system_name") val systemName: String,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.CUSTOMER_TYPE

    override fun toDto(): CustomerTypeDto = Mappers.customerTypeMapper.toDto(this)
}

object CustomerTypeShort {
    const val IP = "selfEmployed"
    const val UL = "corporate"
    const val PHL = "Individual"
}