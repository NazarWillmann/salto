package ooo.jtc.dictionaries.branch

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsBicDto
import ooo.jtc.dictionaries.branch.paymentdetails.PaymentDetailsSwiftDto
import ooo.jtc.dictionaries.common.address.RuAddressDto
import ooo.jtc.dictionaries.common.extid.ExtIdDto
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(DictionaryNames.BRANCH)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BranchDto(
    override var id: UUID?,
    override var version: Int,
    var branchType: String,     // "withBic" / "withoutBic"
    var kpp: String?,
    var shortName: String,      // unique, up to 50 symbols
    var fullName: String,       // unique, up to 200 symbols
    var uiName: String,         // unique, up to 200 symbols

    var paymentDetailsBic: PaymentDetailsBicDto?,
    var paymentDetailsSwift: PaymentDetailsSwiftDto?,

    var bankId: UUID?,
    var phoneSupports: List<PhoneInfoDto>,
    var email: String?,                     // up to 50 symbols
    var description: String?,
    var addressRegistration: RuAddressDto,
    var addressLocation: RuAddressDto,
    var extIds: List<ExtIdDto>,
    var parentBranchId: UUID?
) : UpdateIEntityDto<BranchDto> {

    override fun toModel(): Branch = Mappers.branchMapper.toDomainModel(this)
}