package ooo.jtc.api.dictionaries.customerrepresentative

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractBlockableDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.uaa.User
import java.util.UUID

class CustomerRepresentativeSteps(user: User = superUser) :
    AbstractBlockableDictionarySteps<CustomerRepresentativeDto, CustomerRepresentativeDto>(
        user = user,
        entity = CustomerRepresentativeDto::class.java,
        dictionaryName = "customerRepresentative"
    ) {

    @Step("Получить список представителей, связанных с организациями, для пользователя {id}")
    fun getUserRepresentatives(
        id: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<CustomerRepresentativeDto> {
        return stepApi.send(
            method = {
                body("""{"userId":"$id"}""")
                post("$servicePath/GetUserRepresentatives")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }
}