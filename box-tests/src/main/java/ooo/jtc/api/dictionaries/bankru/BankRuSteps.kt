package ooo.jtc.api.dictionaries.bankru

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.bankru.BankRuDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.uaa.User

class BankRuSteps(user: User) :
    AbstractDictionarySteps<BankRuDto, BankRuDto>(
        user = user,
        entity = BankRuDto::class.java,
        dictionaryName = "bankRu"
    ) {

    @Step("Получение списка Банков РФ по предоставленному БИК'у {bic}")
    fun getBanksByBic(
        bic: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<BankRuDto> {
        return stepApi.send(
            method = {
                body("""{"bic":"$bic"}""")
                post("$servicePath/FindByBic")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }
}