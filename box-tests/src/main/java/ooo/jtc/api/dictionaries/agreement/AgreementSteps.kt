package ooo.jtc.api.dictionaries.agreement

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.agreement.Agreement
import ooo.jtc.dictionaries.agreement.AgreementDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.uaa.User
import java.util.*

class AgreementSteps(user: User) :
    AbstractDictionarySteps<AgreementDto, AgreementDto>(
        user = user,
        entity = AgreementDto::class.java,
        dictionaryName = "agreement"
    ) {


    @Step("Проверка предзаполненной сущности '${DictionaryNames.AGREEMENT}'")
    fun checkDefaultEntity(actualEntity: Agreement, expectedEntity: Agreement) {
        Checks.checkFieldValue("дата соглашения", actualEntity.agreementDate, expectedEntity.agreementDate) //todo id?
        Checks.checkFieldValue("номер соглашения", actualEntity.agreementNumber, expectedEntity.agreementNumber)
        Checks.checkFieldValue("тип соглашения", actualEntity.agreementType, expectedEntity.agreementType)
        Checks.checkFieldValue("дата окончания срока действия соглашения", actualEntity.endDate, expectedEntity.endDate)
        Checks.checkFieldValue("описание назначения генерального соглашения", actualEntity.description, expectedEntity.description)
        Checks.checkFieldValue("клиент", actualEntity.customerId, expectedEntity.customerId)
        Checks.checkFieldValue("статус соглашения", actualEntity.status, expectedEntity.status)
    }

    @Step("Активация '${DictionaryNames.AGREEMENT}'")
    fun activateOrDeactivateAgreement(
        id: UUID,
        isActivate: Boolean,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<AgreementDto> {
        val path = if (isActivate) {
            "$servicePath/Activate"
        } else {
            "$servicePath/Deactivate"
        }
        return stepApi.send(
            method = {
                body("""{"id":"$id"}""")
                post(path)
            },
            check = CoreApi.defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }
}