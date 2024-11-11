package ooo.jtc.crypto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.CryptoNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class Profile(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("auth_only") var authOnly: Boolean,
    @JsonProperty("profile_type") var profileType: ProfileType,
    var state: String,
    @JsonProperty("id_user") var userId: UUID,
    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?,
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = CryptoNames.PROFILE

    override fun toDto(): ProfileDto = Mappers.profileMapper.toDto(this)
}


enum class ProfileType {
    MESSAGE, CRYPTOPRO
}

object ProfileState {
    const val ENABLED = "Enabled"
    const val DISABLED = "Disabled"
}