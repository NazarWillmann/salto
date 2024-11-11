package ooo.jtc.dictionaries.branch

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBic
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwift
import ooo.jtc.dictionaries.common.address.RuAddress
import ooo.jtc.dictionaries.common.extid.ExtId
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfo
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class Branch(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("branch_type") var branchType: String,    // "withBic" / "withoutBic"
    var kpp: String?,
    @JsonProperty("short_name") var shortName: String,      // unique, up to 50 symbols
    @JsonProperty("full_name") var fullName: String,        // unique, up to 200 symbols
    @JsonProperty("ui_name") var uiName: String,            // unique, up to 200 symbols

    @JsonProperty("id_bank") var bankId: UUID?,
    var email: String?,                                     // up to 50 symbols
    var description: String?,
    @JsonProperty("id_parent_branch") var parentBranchId: UUID?,

    var paymentDetailsBic: PaymentDetailsBic?,
    var paymentDetailsSwift: PaymentDetailsSwift?,

    // filled in dbPostProcessor
    var addressLocation: RuAddress,
    var addressRegistration: RuAddress,
    var extIds: List<ExtId>,
    var phoneSupports: List<PhoneInfo>,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.BRANCH

    override fun toDto(): BranchDto = Mappers.branchMapper.toDto(this)
}