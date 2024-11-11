package ooo.jtc.api.dictionaries.uer

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.uer.UerDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.uaa.User

class UerSteps(user: User) :
    AbstractDictionarySteps<UerDto, UerDto>(
        user = user,
        entity = UerDto::class.java,
        dictionaryName = "uer"
    ) {

    @Step("Получить {this.entityName} по БИК'у банка РФ ({bic})")
    fun getUerByBankRuBic(
        bic: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<UerDto> {
        return stepApi.send(
            method = {
                body("""{"bic": "$bic"}""")
                post("$servicePath/FindUerByBankRuBic")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }

}