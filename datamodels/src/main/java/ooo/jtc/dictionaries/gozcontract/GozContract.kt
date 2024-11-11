package ooo.jtc.dictionaries.gozcontract

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.LocalDate
import java.util.*

@KotlinBuilder
data class GozContract(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("c_number") var number: String,
    @JsonProperty("c_date") var date: LocalDate,
    var identity: String,
    @JsonProperty("contract_number") var contractNumber: String?,
    @JsonProperty("contract_date") var contractDate: LocalDate?,
    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.GOZ_CONTRACT

    override fun toDto(): GozContractDto = Mappers.gozContractMapper.toDto(this)
}