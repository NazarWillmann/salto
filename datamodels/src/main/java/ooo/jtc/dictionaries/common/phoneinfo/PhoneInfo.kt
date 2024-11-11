package ooo.jtc.dictionaries.common.phoneinfo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.util.UUID

@KotlinBuilder
data class PhoneInfo(
    override var id: UUID?,
    @NotRequiredForTest @JsonIgnore override var version: Int = 0,
    @JsonProperty("id_owner") var ownerId: UUID?,
    @JsonProperty("support_type") var supportType: String,
    @JsonProperty("phone_type") var phoneType: String,
    var phone: String,
    var ordering: Int? = null
): ITransferEntity {
    @NotRequiredForTest @JsonIgnore override val entityName: String = DictionaryNames.PHONE_INFO

    override fun toDto(): PhoneInfoDto = Mappers.phoneInfoMapper.toDto(this)
}