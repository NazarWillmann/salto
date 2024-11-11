package ooo.jtc.api.rupayment

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.rupayment.model.UserPaymentType
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class RuPaymentSteps(user: User) :
    AbstractDocumentSteps<RuPaymentDto, RuPaymentDto>(
        user = user,
        service = Services.RKO_RU_PAYMENT,
        document = RuPaymentDto::class.java
    ) {

    @Step("Получить презаполненное {this.entityName} по типу платежа")
    fun preFillForUserPaymentType(
        userPaymentType: UserPaymentType,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<RuPaymentDto> {
        return stepApi.send(
            method = {
                body(mapOf("userPaymentType" to userPaymentType.name))
                post("$servicePath/PreFillForUserPaymentType")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }
}