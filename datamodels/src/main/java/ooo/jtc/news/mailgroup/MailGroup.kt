package ooo.jtc.news.mailgroup

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
data class MailGroup(
    override var id: UUID?,
    @NotRequiredForTest override var version: Int,
    @JsonProperty("id_branch") var branchId: UUID?,
    @JsonProperty("branch_name") var branchName: String?,
    @NotRequiredForTest val cpm: String?,
    @NotRequiredForTest var channel: MailGroupChannel? = null,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("modified_at") var modifiedAt: Timestamp?,
    var name: String?,

    @JsonProperty("created_at") var createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("id_created_user") var createdUserId: UUID?,
    @JsonProperty("created_user_name") var createdUserName: String?,

    @JsonProperty("edited_at") var editedAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("id_edited_user") var editedUserId: UUID?,
    @JsonProperty("edited_user_name") var editedUserName: String?,

    // filled in [dbResultPostProcessor]
    var customers: List<MailGroupReceiverCustomer>?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.MAIL_GROUP

    override fun toDto(): MailGroupDto = Mappers.mailGroupMapper.toDto(this)
}