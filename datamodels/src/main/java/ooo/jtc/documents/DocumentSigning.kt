package ooo.jtc.documents

import java.util.*

/**
 * Signature change (signing/removing signature) applicability
 * Request DTO
 */
open class GetSignChangeApplicability(open var documents: List<UUID>, val actionName: String)
data class GetSignApplicability(override var documents: List<UUID>) : GetSignChangeApplicability(documents = documents, actionName = "Sign")
data class GetUnSignApplicability(override var documents: List<UUID>) : GetSignChangeApplicability(documents = documents, actionName = "Unsign")
data class BatchSelfUnSign(var documents: List<UUID>)

/**
 * Signature change (signing/removing signature) applicability
 * Response DTO
 */
data class SignChangeApplicabilityResponse(var applicable: List<UUID>, var nonApplicable: List<UUID>)

/**
 * Response of active sign tools
 */
data class GetOwnSignToolsResponse(
    val list: List<SignTool>
)

/**
 * Signature tool
 */
data class SignTool(
    val enabled: Boolean,
    val id: UUID,
    val signKind: SignKind,
    val signKindId: UUID,
    val toolType: String,
    val userId: UUID,
    val version: Int,
    val refId: UUID?
)

/**
 * Signature kind
 */
data class SignKind(
    val id: UUID,
    val name: String,
    val description: String,
    val version: Int
)

/**
 * Request for preparing sms singing
 */
data class PrepareSmsSignRequest(var ids: List<UUID>, var signToolId: UUID)

/**
 * Response for preparing sms singing
 */
data class PrepareSmsSignResponse(var data: PrepareSmsSignResponseData)

data class PrepareSmsSignResponseData(
    var codeId: UUID,
    var codeLength: Long,
    var phoneNumber: String,
    var timeoutSec: Long,
    var allowedSymbols: String
)

/**
 * Response for checking sms code
 */
data class CheckSmsCodeResponse(var list: List<DocumentSignature>)

data class DocumentSignature(var documentId: UUID, var signature: String)

/**
 * Response by creating document digest
 */
data class DigestResponse(var digest: Digest)

data class Digest(var signFields: HashMap<String, Any>, var value: String, var version: Long)

/**
 * Request for singing document
 */
data class SignDocumentRequestDto(
    var digest: String,
    var documentId: UUID,
    var signature: String,
    var signToolId: UUID,
    var signToolRef: UUID?,
    var version: Long
)