package ooo.jtc.api.uaa.steps

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractApiSteps
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.serialization.SerializationUtils.constructType
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import ooo.jtc.uaa.user.dto.UserDetails

class UaaSelfSteps(user: User) : AbstractApiSteps(user, Services.UAA) {

    override val servicePath: String by lazy { """${service.baseEndpoint}/self""" }


    @Step("Получить инфо по текущему пользователю: {this.user.login}")
    fun getProfile(): GenericResponseDto<UserDetails> {
        val type = constructType(GenericResponseDto::class.java, UserDetails::class.java)
        return authorizedApi.send(
            method = {
                body("{}")
                post("$servicePath/GetProfile")
            }
        ).responseAs(type)
    }
}