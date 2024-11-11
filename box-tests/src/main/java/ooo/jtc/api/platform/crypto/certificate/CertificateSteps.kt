package ooo.jtc.api.platform.crypto.certificate

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.responseAs
import ooo.jtc.crypto.CertificateDto
import ooo.jtc.generic.CryptoNames
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.time.ZonedDateTime
import java.util.*

class CertificateSteps(user: User) :
    AbstractDictionarySteps<CertificateDto, CertificateDto>(
        user = user,
        service = Services.CRYPTO,
        entity = CertificateDto::class.java,
        dictionaryName = CryptoNames.CERTIFICATE
    ) {
    override val servicePath by lazy { service.baseEndpoint + "/certificate" }

    @Step("Получить активный '${CryptoNames.CERTIFICATE}' по id криптопрофиля")
    fun getActiveByProfileId(profileId: UUID, date: ZonedDateTime = ZonedDateTime.now()):
            GenericResponseDto<CertificateDto> {
        return stepApi.send(
            method = {
                body(mapOf("profileId" to profileId, "date" to date))
                post("$servicePath/GetActiveByProfileId")
            }
        ).responseAs(responseType)
    }
}