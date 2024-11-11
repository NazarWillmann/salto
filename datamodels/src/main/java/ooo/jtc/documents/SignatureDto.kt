package ooo.jtc.documents

import com.github.pozo.KotlinBuilder
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
data class SignatureDto(
    var createdAt: ZonedDateTime?,

    var digest: String? = null,
    var digestVersion: Int,
    var documentId: UUID? = null,

    var id: UUID?,
    var isOwnSignature: Boolean? = true,

    var signTool: String?,
    var signToolId: UUID?,
    var signToolType: String?,
    var signToolRef: UUID? = null,
    var signKind: String?,
    var signKindId: UUID,
    var signStage: String? = null,
    var signature: String,

    var userName: String?
)