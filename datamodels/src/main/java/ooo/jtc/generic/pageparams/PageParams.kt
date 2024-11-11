package ooo.jtc.generic.pageparams

import com.fasterxml.jackson.annotation.JsonInclude

val defaultPaging = Paging(offset = 0, limit = 10)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Params(
    var filter: Filter? = null,
    var sort: List<Sort>? = listOf(),
    var paging: Paging? = defaultPaging
)


data class GetPageRequest(
    var params: Params = Params()
)

fun Params.toGetPageRequest(): GetPageRequest {
    return GetPageRequest(this)
}