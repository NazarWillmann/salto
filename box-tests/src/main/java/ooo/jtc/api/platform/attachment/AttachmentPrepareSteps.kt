package ooo.jtc.api.platform.attachment

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.generic.attachments.AttachmentDto
import ooo.jtc.generic.attachments.FileStatus
import ooo.jtc.uaa.User
import java.io.File
import java.util.UUID

object AttachmentPrepareSteps {
    const val UPLOAD_DIR = "/upload"
    val DEFAULT_ATTACH_FILE by lazy { File(this::class.java.getResource("$UPLOAD_DIR/attach_at.txt").toURI()) }

    @Step("Загрузить (upload) файл и подготовить данные вложения")
    fun uploadFile(user: User, file: File): AttachmentDto {
        val attachSteps = AttachmentSteps(user)
        val uploadResponse = attachSteps.upload(file)
        val uploadedFileId = uploadResponse.id
        if (uploadResponse.status != FileStatus.STORED) {
            ooo.jtc.scripts.repeat(
                function = { attachSteps.getFileStatus(uploadedFileId) },
                condition = { it.status == FileStatus.STORED }
            )
        }

        return getAttachmentDto(uploadedFileId, file.name, file.length().toInt()).attachToAllure()
    }


    @Step("Подготовить данные вложения ([{fileId}] / '{fileName}' ({fileSize}))")
    fun getAttachmentDto(fileId: UUID?, fileName: String, fileSize: Int, fileHash: String = ""): AttachmentDto {
        return AttachmentDto(
            id = null, documentId = null, accessToken = null, contentType = null,
            fileId = fileId,
            fileName = fileName,
            dataHash = fileHash,
            dataSize = fileSize
        )
    }
}