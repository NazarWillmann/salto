package ooo.jtc.generic.pageparams

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("field", "direction")
data class Sort(
    @field:JsonProperty("field") var field: String? = null,
    @field:JsonProperty("direction") var direction: Direction? = null
) {
    override fun toString(): String {
        return "$field, $direction"
    }
}

enum class Direction() {
    ASC,
    DESC
}