package ooo.jtc.interfaces

import ooo.jtc.generic.attachments.AttachmentDto

/**
 * IWithAttachments.
 * Interface for entities/documents with attachments.
 * Used mostly in *TestTemplates for null-ing attachments' access tokens
 * via call to [List &lt AttachmentDto &gt ?.nullAccessTokens()]
 */
interface IWithAttachments<A: AttachmentDto> {
    var attachments: List<A>?
}


/**
 * Update [this] list of attachments: set [accessToken] in all entries to [null]
 */
fun List<AttachmentDto>?.nullAccessTokens() {
    this?.forEach { it.accessToken = null }
}