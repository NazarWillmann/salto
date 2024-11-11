package ooo.jtc.api.dictionaries.swift

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.pozo.KotlinBuilder
import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.swift.SwiftDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.serialization.SerializationUtils.constructType
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.io.File
import java.util.UUID

class SwiftSteps(bankUser: User) :
    AbstractDictionarySteps<SwiftDto, SwiftDto>(
        user = bankUser,
        service = Services.DICTIONARY,
        entity = SwiftDto::class.java,
        dictionaryName = "swift"
    ) {

    private val importResultResponseType by lazy { constructType(GenericResponseDto::class.java, ImportResultDto::class.java) }
    private val unexpectedChangesMsg = "SWIFT dictionary' contents can be changed only through import!"

    @Suppress("UNUSED_PARAMETER")
    @Step("Загрузить (upload) список SWIFT-кодов '{fileName}'")
    fun importSwift(
        swiftFile: File, fileName: String = swiftFile.name,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<ImportResultDto> {
        return uploadApi.send(
            method = {
                multiPart(swiftFile)
                post("$servicePath/ImportSwift")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(importResultResponseType)
    }

    override fun create(entity: SwiftDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<SwiftDto> {
        throw RuntimeException(unexpectedChangesMsg)
    }

    override fun update(entity: SwiftDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<SwiftDto> {
        throw RuntimeException(unexpectedChangesMsg)
    }

    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<SwiftDto> {
        throw RuntimeException(unexpectedChangesMsg)
    }
}

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
data class ImportResultDto(
    val total: Int
)