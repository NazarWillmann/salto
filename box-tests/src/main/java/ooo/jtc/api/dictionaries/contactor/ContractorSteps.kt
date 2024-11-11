package ooo.jtc.api.dictionaries.contactor

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.contractor.ContractorDto
import ooo.jtc.dictionaries.contractor.ContractorUpdateDto
import ooo.jtc.dictionaries.contractor.ContractorUpdateInfoDto
import ooo.jtc.generic.GenericDtoWrapperDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.util.*

class ContractorSteps(user: User) :
    AbstractDictionarySteps<ContractorDto, ContractorUpdateDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = ContractorDto::class.java,
        dictionaryName = "contractor"
    ) {

    @Step("Обновить данные контрагента [{updateInfoDto.id}]")
    fun updateContractorInfo(
        updateInfoDto: ContractorUpdateInfoDto,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<ContractorDto> {
        return stepApi.send(
            method = {
                body(GenericDtoWrapperDto(updateInfoDto))
                post("$servicePath/UpdateInfo")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

}