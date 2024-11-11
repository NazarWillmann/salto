package ooo.jtc.dictionaries.customer

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.common.address.Address
import ooo.jtc.dictionaries.customerkpp.CustomerKpp
import ooo.jtc.dictionaries.customertype.CustomerType
import ooo.jtc.extensions.DEFAULT_DATE_FORMAT
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.LocalDate
import java.util.*

@KotlinBuilder
data class Customer(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("full_name") var fullName: String,
    @JsonProperty("short_name") var shortName: String,
    @JsonProperty("int_name") var intName: String?,
    @JsonProperty("is_resident") @JvmField var isResident: Boolean,

    var inn: String,
    var okpo: String?,
    var ogrn: String?,
    @JsonProperty("ogrn_date") @JsonFormat(pattern = DEFAULT_DATE_FORMAT) var ogrnDate: LocalDate?,

    var okopf: String?,
    var okfs: String?,
    var email: String?,
    var phone: String?,
    var description: String?,
    @JsonProperty("is_agreed") @JvmField var isAgreed: Boolean,
    @JsonProperty("country_digit_code") var countryDigitCode: String?,
    @JsonProperty("is_block") @JvmField var isBlock: Boolean,

    @JsonProperty("id_block_user") var blockUserId: UUID?,
    @JsonProperty("block_date") var blockDate: Timestamp?,

    // filled in [dbResultPostProcessor]
    var addressLocation: Address?,
    var addressRegistration: Address?,
    @JsonProperty("id_customer_type") var customerTypeId: UUID,
    var customerType: CustomerType?,
    var kpp: List<CustomerKpp>,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.CUSTOMER

    override fun toDto(): CustomerDto = Mappers.customerMapper.toDto(this)
}