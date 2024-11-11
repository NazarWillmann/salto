package ooo.jtc.generic.attachments

import java.util.UUID

data class FileStatusDto(
    var id: UUID,
    var status: FileStatus
)

enum class FileStatus {
    UPLOADED, CONSUMED, MALWARE, DELETED, STORED, CHECKED
}