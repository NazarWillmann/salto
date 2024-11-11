package ooo.jtc.generic.pageparams

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("offset", "limit")
data class Paging(
    @field:JsonProperty("offset") var offset: Int,
    @field:JsonProperty("limit") var limit: Int
) {
    override fun toString(): String {
        return "offset=$offset, limit=$limit"
    }
}
