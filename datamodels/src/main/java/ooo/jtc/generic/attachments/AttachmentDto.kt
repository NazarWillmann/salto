package ooo.jtc.generic.attachments

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
open class AttachmentDto(
    open var id: UUID?,
    open var documentId: UUID?,
    open var fileId: UUID?,          // needed for creation/update
    open var fileName: String,       // needed
    open var contentType: String?,
    open var dataSize: Int,          // needed
    open var dataHash: String?,      // needed, even if empty

    open var accessToken: String?
)

fun AttachmentDto.dataSizeInKb(): Int = this.dataSize / 1024

/**
 * Get all [fileName]s of attachments in [this] list in a single string, divided by [delimiter]
 */
fun List<AttachmentDto>.concatFileNames(delimiter: String = "|"): String {
    return this.map { it.fileName }.reduce { s1, s2 -> "$s1$delimiter$s2" }
}