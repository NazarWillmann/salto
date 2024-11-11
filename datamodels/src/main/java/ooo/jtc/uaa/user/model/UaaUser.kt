package ooo.jtc.uaa.user.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.uaa.user.dto.UaaUserDto
import ooo.jtc.uaa.user.dto.UserDetails
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class UaaUser(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    @JsonProperty("perm_block") val permBlock: Boolean,
    @JsonProperty("temp_block") val tempBlock: Boolean,
    @JsonProperty("temp_block_until") val tempBlockUntil: Timestamp?,
    @JsonProperty("block_reason") val blockReason: String?,
    @JsonProperty("block_user") val blockUser: UUID?,
    @JsonProperty("pref_locale") val prefLocale: String?,
    @JsonProperty("first_name") val firstName: String?,
    @JsonProperty("middle_name") val middleName: String?,
    @JsonProperty("last_name") val lastName: String?,
    @JsonProperty("phone_number") val phoneNumber: String?,
    val email: String?,
    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?,
    val scopes: List<UUID?>
) : ITransferEntity {
    override fun toDto(): UaaUserDto {
        return Mappers.userMapper.toDto(this)
    }

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = UaaNames.USER
}

/**
 * [UaaUser] to [UserDetails] converter extension.
 */
fun UaaUser.getUserDetails(): UserDetails {
    return UserDetails(
        lastName = this.lastName,
        firstName = this.firstName,
        middleName = this.middleName,
        email = this.email,
        phoneNumber = this.phoneNumber
    )
}