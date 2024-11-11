package ooo.jtc.api.dictionaries.ground

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.ground.GroundDto
import ooo.jtc.dictionaries.ground.GroundUpdateRequest
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.pageparams.Paging
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.util.*

class GroundSteps(user: User) :
    AbstractDictionarySteps<GroundDto, GroundUpdateRequest>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = GroundDto::class.java,
        dictionaryName = "ground"
    ) {

    @Step("Получить список контрагентов по ID '{contractorId}'")
    fun getListForContractor(
        contractorId: UUID?,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<GroundDto> {
        val payload = mapOf("contractorId" to contractorId)
        return stepApi.send(
            method = {
                body(payload)
                post("$servicePath/GetListForContractor")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }

    @Step("Получить список контрагентов по ID '{contractorId}'")
    fun getPageForContractor(
        contractorId: UUID?,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200,
        params: Params = Params(paging = Paging(offset = 0, limit = 3000))
    ): GenericPageResponseDto<GroundDto> {
        val contractorPageRequest = GetContractorPageRequest(contractorId, params)
        return stepApi.send(
            method = {
                body(contractorPageRequest)
                post("$servicePath/GetPageForContractor")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responsePageType)
    }

}

data class GetContractorPageRequest(
    var contractorId: UUID?,
    var params: Params = Params()
)