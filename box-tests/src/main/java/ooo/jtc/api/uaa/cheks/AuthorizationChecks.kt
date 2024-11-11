package ooo.jtc.api.uaa.cheks

import io.qameta.allure.Step
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.uaa.User
import ooo.jtc.uaa.user.dto.UserDetails

object AuthorizationChecks {

    @Step("Проверить, что авторизованый пользователь получил корректную информацию о себе")
    fun checkUserDetails(selfInfoResponse: GenericResponseDto<UserDetails>, user: User) {
        val selfInfoDto = selfInfoResponse.data
        selfInfoDto.assertIsNotEmpty()
        assertObjectsEqual(user.userDetails!!, selfInfoDto!!)
    }
}