package ooo.jtc.dictionaries.gozcontract

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.LocalDate
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.GOZ_CONTRACT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GozContractDto(
    override var id: UUID?,
    override var version: Int,
    var number: String,
    var date: LocalDate,
    var identity: String,
    var contractNumber: String?,
    var contractDate: LocalDate?,
) : UpdateIEntityDto<GozContractDto> {

    override fun toModel(): GozContract = Mappers.gozContractMapper.toDomainModel(this)
}