package ooo.jtc.news.mailgroup

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.extensions.toStringAsJson
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.news.dto.ReceiverCustomerDto
import java.sql.Timestamp
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.MAIL_GROUP)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class MailGroupDto(
    override var id: UUID?,
    override var version: Int,

    var branchId: UUID?,
    var branchName: String?,

    var channel: MailGroupChannel? = null,
    var createdAt: Timestamp? = null,
    var createdUserName: String? = null,
    var editedAt: Timestamp? = null,
    var editedUserName: String? = null,
    var customers: List<ReceiverCustomerDto>?,

    var isFavorites: Boolean? = false,

    var name: String?,
) : UpdateIEntityDto<MailGroupDto> {

    override fun toString(): String = toStringAsJson(DictionaryNames.MAIL_GROUP, this)

    override fun toModel(): MailGroup = Mappers.mailGroupMapper.toDomainModel(this)
}

enum class MailGroupChannel {
    WEB,
    MOBILE,
    ALL;
}