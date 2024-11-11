package ooo.jtc.dictionaries.bankrepresentative

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IWithBlock
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.BANK_REPRESENTATIVE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankRepresentativeDto(
    override var id: UUID?,
    override var version: Int,
    var bankId: UUID?,
    var userId: UUID?,
    var position: String?,
    var email: String?,
    var phone: String?,
    override var block: BlockingInfoDto,
    var description: String?
) : UpdateIEntityDto<BankRepresentativeDto>, IWithBlock {

    override fun toModel(): BankRepresentative = Mappers.bankRepresentativeMapper.toDomainModel(this)
}
