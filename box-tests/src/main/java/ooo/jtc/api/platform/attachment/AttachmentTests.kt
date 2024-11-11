package ooo.jtc.api.platform.attachment

import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.platform.AttachmentTaskIdsCommon
import ooo.jtc.core.tm4j.ComponentPlatform
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.generic.FsNames
import ooo.jtc.generic.attachments.AttachmentDto
import ooo.jtc.uaa.User

@Folder("${FolderPrefix.ATTACHMENT} (attachments)")
annotation class AttachmentFolder

@ComponentPlatform
@AttachmentFolder
@AttachmentTaskIdsCommon
@HighPriority
class AttachmentDownloadTest(
    val user: User,
    preExecution: () -> AttachmentDto
) : AbstractTest<AttachmentDto, Unit>(
    name = "${FsNames.FS_SYSTEM}. Скачивание файла.",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: AttachmentDto?) {
        val attachment = preconditionResult!!
        val downloadResponse = AttachmentSteps(user = user).download(fileId = attachment.fileId!!, accessToken = attachment.accessToken!!)
        //TODO A.Stykalin [16.09.2020] add checks
    }
}