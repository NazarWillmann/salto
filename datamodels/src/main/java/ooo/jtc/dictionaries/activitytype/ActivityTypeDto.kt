package ooo.jtc.dictionaries.activitytype

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.ACTIVITY_TYPE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ActivityTypeDto(
    override var id: UUID?,
    override var version: Int,
    var code: String?,
    var description: String
) : UpdateIEntityDto<ActivityTypeDto> {

    override fun toModel(): ActivityType = Mappers.activityTypeMapper.toDomainModel(this)
}