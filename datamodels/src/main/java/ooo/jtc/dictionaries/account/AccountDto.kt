package ooo.jtc.dictionaries.account

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.accountype.AccountTypeDto
import ooo.jtc.dictionaries.currency.CurrencyDto
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.common.extid.ExtIdDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.ACCOUNT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountDto(
    override var id: UUID?,
    override var version: Int,

    var branchCustomerId: UUID?,
    var customerId: UUID?,
    var branchIndividualId: UUID?,
    var individualId: UUID?,
    var branchId: UUID?,

    var accountNumber: String,
    var accountKind: String,    // value of AccountKind
    var accountTypeId: UUID,

    var state: String,          // value of AccountState
    var name: String?,

    var reserveBeginDate: ZonedDateTime?,
    var reserveEndDate: ZonedDateTime?,
    var openDate: ZonedDateTime,
    var closeDate: ZonedDateTime?,
    var currencyAlphaCode: String?,
    var currencyDigitCode: String,
    @JvmField var isMarkInfo: Boolean,

    var actualBalance: BigDecimal,
    var planBalance: BigDecimal,
    var blockedAmount: BigDecimal?,
    var actualDate: ZonedDateTime,
    var description: String?,
    var cardAmount: BigDecimal?,

    var block: BlockingInfoDto,

    var extIds: List<ExtIdDto>,

    var accountType: AccountTypeDto?
) : UpdateIEntityDto<AccountDto> {

    override fun toModel(): Account = Mappers.accountMapper.toDomainModel(this)

    /**
     * Null fields [branchId, customerId, individualId, accountType].
     * These don't return in responses when editing account dictionary (calling Create/Update/Delete methods)
     */
    fun toReducedDto(): AccountDto {
        return this.copy(
            customerId = null,
            branchId = null,
            individualId = null,
            accountType = null
        )
    }
}
