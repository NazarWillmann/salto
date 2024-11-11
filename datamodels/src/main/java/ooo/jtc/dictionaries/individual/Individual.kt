package ooo.jtc.dictionaries.individual

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.dictionaries.common.address.Address
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.LocalDate
import java.util.*

@KotlinBuilder
data class Individual(
    override var id: UUID?,
    override var version: Int,

    @JsonProperty("id_person") var personId: UUID,
    @JsonProperty("first_name") var firstName: String,
    @JsonProperty("last_name") var lastName: String,
    @JsonProperty("middle_name") var middleName: String?,

    var sex: String?,
    var birthday: LocalDate?,
    @JsonProperty("nationality_country") var nationalityCountry: String?,
    @JsonProperty("is_resident") @JvmField var isResident: Boolean,

    var inn: String?,
    var snils: String?,
    @JsonProperty("mobile_phone") var mobilePhone: String?,
    var email: String?,
    @JsonProperty("is_pg_agreed") @JvmField var isPgAgreed: Boolean,

    @JsonProperty("is_block") @JvmField var isBlock: Boolean,
    @JsonProperty("id_block_user") var blockUser: UUID?,
    @JsonProperty("block_date") var blockDate: Timestamp?,
    var description: String?,
    // filled in [dbResultPostProcessor]
    var addressLocation: Address?,
    var addressRegistration: Address?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @NotRequiredForTest
    @JsonIgnore
    override val entityName: String = DictionaryNames.INDIVIDUAL

    override fun toDto(): IndividualDto = Mappers.individualMapper.toDto(this)
}
