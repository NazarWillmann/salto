package ooo.jtc.dictionaries.treasuryaccounttax

import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.TREASURY_ACCOUNT_TAX)
data class TreasuryAccountTaxDto(
    override var id: UUID? = null,
    override var version: Int = 0,

    var tofk: String?,
    var account: String?,
    var bankName: String?,
    var bic: String?,
    var utraAccount: String?

) : UpdateIEntityDto<TreasuryAccountTaxDto> {

    override fun toModel(): TreasuryAccountTax = Mappers.treasuryAccountTaxMapper.toDomainModel(this)
}