package ooo.jtc.api.dictionaries.bankbic

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.api.dictionaries.swift.ImportResultDto
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.bankbic.BankBicDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.serialization.SerializationUtils
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.io.File
import java.util.UUID

class BankBicSteps(user: User = Users.superUser) :
    AbstractDictionarySteps<BankBicDto, BankBicDto>(
        user = user,
        entity = BankBicDto::class.java,
        dictionaryName = "bankBic"
    ) {

    private val importResultResponseType by lazy { SerializationUtils.constructType(GenericResponseDto::class.java, ImportResultDto::class.java) }
    private val notApplicableError = "Not applicable for BankBic dictionary. It can be changed only through import"

    @Suppress("UNUSED_PARAMETER")
    @Step("Загрузить (upload) список БИК РФ '{fileName}'")
    fun importBankBic(bankBicFile: File, fileName: String = bankBicFile.name): GenericResponseDto<ImportResultDto> {
        return uploadApi.send(
            method = {
                multiPart(bankBicFile)
                post("$servicePath/ImportBankBic")
            }
        ).responseAs(importResultResponseType)
    }

    @Suppress("UNUSED_PARAMETER")
    @Step("Асинхронно загрузить (upload) список БИК РФ '{fileName}'")
    fun importBankBicAsync(bankBicFile: File, fileName: String = bankBicFile.name): GenericResponseDto<ImportResultDto> {
        TODO("Write with dedicated test") //Sergeyev [2021.03.10]: makes sense only with dedicated test just for that API
    }

    @Step("Найти '{this.entityName}' по bic={bic}")
    fun findByBic(bic: String): GenericListResponseDto<BankBicDto> {
        return stepApi.send(
            method = {
                body(mapOf("bic" to bic))
                post("$servicePath/FindByBic")
            }
        ).responseAs(responseListType)
    }

    override fun create(entity: BankBicDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<BankBicDto> {
        throw RuntimeException(notApplicableError)
    }
    override fun update(entity: BankBicDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<BankBicDto> {
        throw RuntimeException(notApplicableError)
    }
    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<BankBicDto> {
        throw RuntimeException(notApplicableError)
    }
}
