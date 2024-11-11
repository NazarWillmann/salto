package ooo.jtc.dictionaries.account

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.accountype.AccountType
import ooo.jtc.dictionaries.common.extid.ExtId
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class Account(
    override var id: UUID?,
    override var version: Int,
    //TODO Sergeyev [2021.02.16]: potentially dangerous use of annotations, but only one of these can be non-null
    // in a single record
    @NotRequiredForTest @JsonProperty("id_branch_customer") var branchCustomerId: UUID?,
    @NotRequiredForTest @JsonProperty("id_branch_individual") var branchIndividualId: UUID?,

    @JsonProperty("account_number") var accountNumber: String,
    @JsonProperty("account_kind") var accountKind: String,
    @JsonProperty("id_account_type") var accountTypeId: UUID,

    var state: String,
    var name: String?,
    @JsonProperty("reserve_begin_date") var reserveBeginDate: Timestamp?,
    @JsonProperty("reserve_end_date") var reserveEndDate: Timestamp?,
    @JsonProperty("open_date") var openDate: Timestamp,
    @JsonProperty("close_date") var closeDate: Timestamp?,
    @JsonProperty("currency_alpha_code") var currencyAlphaCode: String?,
    @JsonProperty("currency_digit_code") var currencyDigitCode: String?,
    @JsonProperty("is_mark_info") @JvmField var isMarkInfo: Boolean,
    var description: String?,

    @JsonProperty("actual_balance") var actualBalance: BigDecimal,
    @JsonProperty("plan_balance") var planBalance: BigDecimal,
    @JsonProperty("blocked_amount") var blockedAmount: BigDecimal?,
    @JsonProperty("card_amount") var cardAmount: BigDecimal?,
    @JsonProperty("actual_date") var actualDate: Timestamp,



    @JsonProperty("is_block") @JvmField var isBlock: Boolean,
    @JsonProperty("id_block_user") var blockUserId: UUID?,
    @JsonProperty("block_date") var blockDate: Timestamp?,


    // filled in data [postProcessor]
    var customerId: UUID?,
    var branchId: UUID?,
    var individualId: UUID?,
    var accountType: AccountType?,
    var extIds: List<ExtId>,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.ACCOUNT

    override fun toDto(): AccountDto = Mappers.accountMapper.toDto(this)

    @get:JsonIgnore
    val isResident: Boolean
        get() = isResidentAccount(accountNumber)
}

/**
 * Means that an account belongs to a resident.
 * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336938 point 08.6.1
 */
fun isResidentAccount(accountNumber: String): Boolean {
    return !accountNumber.startsWith("40807")
}