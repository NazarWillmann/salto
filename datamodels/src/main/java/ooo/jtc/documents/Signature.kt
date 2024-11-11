package ooo.jtc.documents

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.CustomConverter
import ooo.jtc.interfaces.IEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class Signature(
    override var id: UUID?,
    @JsonProperty("id_document") var documentId: UUID,
    override var version: Int,
    @JsonProperty("id_sign_tool") var signToolId: UUID,
    @JsonProperty("sign_tool_ref") var signToolRef: UUID?,
    @JsonProperty("id_sign_kind") var signKindId: UUID,
    var digest: String,
    var signature: String,
    @JsonProperty("created_at") val createdAt: Timestamp?
): IEntity {
    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = "Эл. подпись"

    @JsonIgnore
    private val mappedFromDB = "[mappedFromDB]"

    fun toDto(): SignatureDto {
        return SignatureDto(
            id = this.id,
            digestVersion = 1,
            signToolId = this.signToolId,
            signKindId = this.signKindId,
            signature = this.signature,
            createdAt = CustomConverter().timestampToZonedDateTime(this.createdAt),
            signKind = mappedFromDB,
            signTool = mappedFromDB,
            signToolType = mappedFromDB,
            userName = mappedFromDB
        )
    }
}