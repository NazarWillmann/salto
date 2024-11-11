package ooo.jtc.api.platform.crypto.profile

import io.qameta.allure.Step
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.crypto.ProfileDto
import ooo.jtc.crypto.ProfileState
import ooo.jtc.crypto.ProfileType
import ooo.jtc.generic.CryptoNames
import ooo.jtc.uaa.User

object ProfilePrepareSteps {

    @Step("Подготовить '${CryptoNames.PROFILE}' DTO для пользователя {bankUser.login}")
    fun getProfileDtoForUserForCreate(
        bankUser: User,
        authOnly: Boolean = false,
        profileType: ProfileType = ProfileType.CRYPTOPRO,
        state: String = ProfileState.ENABLED
    ): ProfileDto {
        bankUser.checkIsBankUser()

        return ProfileDto(
            id = null, version = 0,
            authOnly, profileType, state,
            userId = bankUser.uaaUserId!!
        )
    }

    fun getProfileDtoForUpdate(profileDto: ProfileDto): ProfileDto {
        return profileDto.copy(authOnly = !profileDto.authOnly)
    }
}