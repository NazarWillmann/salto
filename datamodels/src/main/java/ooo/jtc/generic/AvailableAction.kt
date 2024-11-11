package ooo.jtc.generic

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AvailableActionDto(
    var name: String,
    var statuses: List<String>, // IDocumentStatus.getStatus() values
    var customCheck: String?,
    var title: String
)