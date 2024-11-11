package ooo.jtc.dictionaries.common

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import java.time.ZonedDateTime
import java.util.UUID

@KotlinBuilder
@EntityName(DictionaryNames.BLOCKING_INFO)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class BlockingInfoDto(
    @JvmField var isBlock: Boolean,
    var blockUser: UUID? = null,
    var blockDate: ZonedDateTime? = null
)