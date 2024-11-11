package ooo.jtc.api.platform.crypto.profile

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.responseAs
import ooo.jtc.crypto.ProfileDto
import ooo.jtc.generic.CryptoNames
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.util.*

class ProfileSteps(user: User = Users.superUser) :
    AbstractDictionarySteps<ProfileDto, ProfileDto>(
        user = user,
        service = Services.CRYPTO,
        entity = ProfileDto::class.java,
        dictionaryName = CryptoNames.PROFILE
    ) {

    override val servicePath by lazy { service.baseEndpoint + "/profile" }

    @Step("Получить список '${CryptoNames.PROFILE}' по id пользователя")
    fun getByUserId(userId: UUID): GenericListResponseDto<ProfileDto> {
        return stepApi.send(
            method = {
                body(mapOf("userId" to userId))
                post("$servicePath/GetByUserId")
            }
        ).responseAs(responseListType)
    }
}