package ooo.jtc.dictionaries.common.phoneinfo

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.IEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.PHONE_INFO)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PhoneInfoDto(
    override var id: UUID? = null,
    @NotRequiredForTest @JsonIgnore override var version: Int = 0,
    var ownerId: UUID? = null,
    var supportType: String = PhoneSupportType.values().random().value, //PhoneSupportType
    var phoneType: String = PhoneType.MAIN_NUMBER.value,                //PhoneType
    var phone: String
): IEntityDto {

    override fun toModel(): PhoneInfo = Mappers.phoneInfoMapper.toDomainModel(this)
}