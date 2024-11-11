package ooo.jtc.api.dictionaries.paymenttype

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.paymenttype.PaymentTypeDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class PaymentTypeSteps(user: User) :
    AbstractDictionarySteps<PaymentTypeDto, PaymentTypeDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = PaymentTypeDto::class.java,
        dictionaryName = "paymentType"
    ) {

    @Step("Получить {this.entityName} по коду ({code}) и описанию ({description})")
    fun getByCodeAndDescription(
        code: String,
        description: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<PaymentTypeDto> {
        val payload = """{
                           "code": "$code",
                           "description": "$description"
                          }"""
        return stepApi.send(
            method = {
                body(payload)
                post("$servicePath/GetByCodeAndDescription")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }

    @Step("Удалить {this.entityName} по коду ({code}) и описанию ({description})")
    fun deleteByCodeAndDescription(
        code: String,
        description: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ) {
        getByCodeAndDescription(code, description, withCheckResponseCode, statusCode).list?.map { it.id }?.forEach { delete(id = it!!) }
    }


    @Step("Получить {this.entityName} по описанию ({description})")
    fun getByDescription(
        description: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<PaymentTypeDto> {
        val payload = """{ "description": "$description" }"""
        return stepApi.send(
            method = {
                body(payload)
                post("$servicePath/GetByDescription")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }
}