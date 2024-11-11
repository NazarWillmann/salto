package ooo.jtc.api.dictionaries.customerkpp

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.uaa.User
import java.util.*

class CustomerKppSteps(user: User) :
    AbstractDictionarySteps<CustomerKppDto, CustomerKppDto>(
        user = user,
        entity = CustomerKppDto::class.java,
        dictionaryName = "customerKpp"
    ) {

    @Step("Получить КПП по умолчанию для клиента по id клиента = '{customerId}'")
    fun getDefaultCustomerKppByCustomerId(
        customerId: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<CustomerKppDto> {
        return stepApi.send(
            method = {
                body("""{"customerId": "$customerId"}""")
                post("$servicePath/GetDefaultForCustomer")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }


}