package ooo.jtc.api.dictionaries.stmntoperationtype

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.util.*

class StatementOperationTypeSteps(user: User) :
    AbstractDictionarySteps<StatementOperationTypeDto, StatementOperationTypeDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = StatementOperationTypeDto::class.java,
        dictionaryName = "statementOperationType"
    ) {

    @Step("Получить тип документа выписки по его коду '{code}'")
    fun getSoTypeByCode(
        code: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<StatementOperationTypeDto> {
        return stepApi.send(
            method = {
                body("""{"code": "$code"}""")
                post("$servicePath/GetByCode")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Получить тип документа выписки по его описанию '{description}'")
    fun getSoTypeByDescription(
        description: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<StatementOperationTypeDto> {
        return stepApi.send(
            method = {
                body("""{"description": "$description"}""")
                post("$servicePath/GetByDescription")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Удалить тип документа выписки по его описанию '{description}'")
    fun deleteSoTypeByDescription(
        description: String,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ) {
        delete(getSoTypeByDescription(description, withCheckResponseCode, statusCode).data?.id!!)
    }

    @Step("Проверить на корректность существующий тип документа выписки с id = '{id}'")
    fun validateSoTypeById(
        id: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<StatementOperationTypeDto> {
        return stepApi.send(
            method = {
                body("""{"id": "$id"}""")
                post("$servicePath/Validate")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

}