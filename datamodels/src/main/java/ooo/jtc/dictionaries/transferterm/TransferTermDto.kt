package ooo.jtc.dictionaries.transferterm

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.TRANSFER_TERM)
data class TransferTermDto(
    override var id: UUID?,
    override var version: Int,

    var code: String?,
    var description: String?

) : UpdateIEntityDto<TransferTermDto> {

    override fun toModel(): TransferTerm = Mappers.transferTermMapper.toDomainModel(this)
}