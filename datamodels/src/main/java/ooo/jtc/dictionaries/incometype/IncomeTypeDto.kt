package ooo.jtc.dictionaries.incometype

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.INCOME_TYPE)
data class IncomeTypeDto(
    override var id: UUID?,
    override var version: Int,

    var code: Int?,
    var name: String,
    var description: String

) : UpdateIEntityDto<IncomeTypeDto> {

    override fun toModel(): IncomeType = Mappers.incomeTypeMapper.toDomainModel(this)
}