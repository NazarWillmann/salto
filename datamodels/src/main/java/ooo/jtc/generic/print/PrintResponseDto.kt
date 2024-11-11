package ooo.jtc.generic.print

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PrintResponseDto(
    var source: String,
    var fileName: String,
    var contentLength: Int,
    var contentType: String,
    var range: PrintRange
)

data class PrintRange(
    var rangeStart: Int,
    var rangeLength: Int
)