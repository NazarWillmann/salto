package ooo.jtc.uaa.scope.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import ooo.jtc.interfaces.Identifiable
import java.util.UUID

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ScopeDetails(
    override var id: UUID?,
    override var version: Int,
    var resourceId: UUID?,
    var name: String,
    var uiName: String,
    var description: String?,
    var needApprove: Boolean,
    var resource: ScopeResourceDto?
): Identifiable

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ScopeResourceDto(
    override var id: UUID?,
    override var version: Int,
    var name: String,
    var audience: String,
    var description: String?
): Identifiable