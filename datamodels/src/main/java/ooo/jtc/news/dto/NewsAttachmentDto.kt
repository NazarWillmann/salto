package ooo.jtc.news.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.generic.attachments.AttachmentDto
import java.util.UUID

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class NewsAttachmentDto(
    override var id: UUID?,
    override var documentId: UUID?,
    override var fileId: UUID?,          // needed for creation/update
    override var fileName: String,       // needed
    override var dataSize: Int,          // needed
    override var accessToken: String?,

    override var contentType: String? = null,
    override var dataHash: String? = null,

    var fileLinkText: String?
) : AttachmentDto(id, documentId, fileId, fileName, contentType, dataSize, dataHash, accessToken)

fun AttachmentDto.toNewsAttachmentDto(fileLinkText: String?): NewsAttachmentDto {
    return NewsAttachmentDto(
        id = this.id,
        documentId = this.documentId,
        fileId = this.fileId,
        fileName = this.fileName,
        dataSize = this.dataSize,
        accessToken = this.accessToken,
        contentType = null,
        dataHash = null,
        fileLinkText = fileLinkText
    )
}