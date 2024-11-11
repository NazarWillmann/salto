package ooo.jtc.dictionaries.person

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
data class Person(
    override var id: UUID?, // person.id == user.uaaUserId
    override var version: Int,
    @JsonProperty("first_name") var firstName: String,
    @JsonProperty("last_name") var lastName: String,
    @NotRequiredForTest @JsonProperty("middle_name") var middleName: String?,
    @NotRequiredForTest @JsonProperty("full_name") var fullName: String?,
    @NotRequiredForTest @JsonProperty("mobile_phone") var mobilePhone: String?,
    @NotRequiredForTest var email: String?,
    @NotRequiredForTest var sex: String?,
    @NotRequiredForTest var birthdate: LocalDate?,
    @NotRequiredForTest var description: String?,
    @JsonProperty("phone_confirmed") var phoneConfirmed: Boolean,
    @JsonProperty("email_confirmed") var emailConfirmed: Boolean,
    @NotRequiredForTest var category: String?, // value of PersonCategory enum

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {
    @JsonIgnore override val entityName: String = DictionaryNames.PERSON
    @JsonIgnore override fun toDto(): PersonDto = Mappers.personMapper.toDto(this)
}
