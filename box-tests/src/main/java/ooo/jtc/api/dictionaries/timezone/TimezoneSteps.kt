package ooo.jtc.api.dictionaries.timezone

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.timezone.TimezoneDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.uaa.User

class TimezoneSteps(user: User) :
    AbstractDictionarySteps<TimezoneDto, TimezoneDto>(
        user = user,
        entity = TimezoneDto::class.java,
        dictionaryName = "timeZone"
    ) {

    @Step("Получить часовой пояс но его наименованию '{name}'")
    fun getTimezoneByName(
        name: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<TimezoneDto> {
        return stepApi.send(
            method = {
                body("""{"name":"$name"}""")
                post("$servicePath/FindByName")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Получить все часовые пояса со сдвигом '{shift}'")
    fun getTimezonesByShift(
        shift: Int,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<TimezoneDto> {
        return stepApi.send(
            method = {
                body("""{"shift": $shift}""")
                post("$servicePath/GetAllByShift")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }
}