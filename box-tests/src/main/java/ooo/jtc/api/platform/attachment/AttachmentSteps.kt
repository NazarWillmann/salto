package ooo.jtc.api.platform.attachment

import io.qameta.allure.Step
import io.restassured.response.Response
import ooo.jtc.api.common.steps.AbstractApiSteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.attachments.FileStatusDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.io.File
import java.util.UUID

class AttachmentSteps(user: User) : AbstractApiSteps(user = user, service = Services.FS_SYSTEM) {
    private var stepApi = authorizedApi

    override val servicePath = service.baseEndpoint

    @Suppress("UNUSED_PARAMETER")
    @Step("Загрузить (upload) файл '{fileName}'")
    fun upload(file: File, fileName: String = file.name): FileStatusDto {
        return uploadApi.send(
            method = {
                multiPart(file)
                post("$servicePath/Upload")
            }
        ).responseAs(FileStatusDto::class.java)
    }

    @Step("Получить статус вложения [{fileId}]")
    fun getFileStatus(fileId: UUID): FileStatusDto {
        return stepApi.send(
            method = {
                body("""{"id":"$fileId"}""")
                post("$servicePath/GetFileStatus")
            }
        ).responseAs(FileStatusDto::class.java)
    }

    /**
     * [fileId] and [accessToken] retrieves from document with attachment response (getById or getPage).
     */
    @Step("Выгрузить (download) файл [{fileId}]")
    fun download(
        fileId: UUID,
        accessToken: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): Response {
        return stepApi.send(
            method = {
                body(mapOf("id" to fileId, "accessToken" to accessToken))
                post("$servicePath/Download")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        )
    }
}