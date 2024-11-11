package ooo.jtc.api.uaa.prepare

import io.qameta.allure.Step
import ooo.jtc.api.uaa.steps.UaaUserSteps
import ooo.jtc.extensions.ofUTC
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.uaa.scope.ScopeData
import ooo.jtc.testdata.uaa.user.StoredUserData
import ooo.jtc.uaa.scope.dto.ScopeDetails
import ooo.jtc.uaa.user.dto.UaaUserDto
import ooo.jtc.uaa.user.dto.UserDetails
import kotlin.random.Random
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.util.UUID

object PrepareUaaUserData {

    @Step("Подготовить тестовый '${UaaNames.USER}' по умолчанию")
    fun prepareUaaUserDtoForCreate(
        scopes: List<UUID?> = ScopeData.getRandomIds(),
        userDetails: UserDetails = prepareTestUserDetails(),
        preferredLocale: String = "ru",
        blockReason: String? = null,
        blockUser: UUID? = null,
        scopeDetails: List<ScopeDetails> = emptyList(),
        permanentBlocked: Boolean = false,
        temporaryBlocked: Boolean = false,
        temporaryBlockedUntil: ZonedDateTime? = null
    ): UaaUserDto {
        return UaaUserDto(
            id = null,
            version = 0,
            blockReason = blockReason,
            blockUser = blockUser,
            permanentBlocked = permanentBlocked,
            preferredLocale = preferredLocale,
            scopes = scopes,
            scopeDetails = scopeDetails,
            temporaryBlocked = temporaryBlocked,
            temporaryBlockedUntil = temporaryBlockedUntil,
            userDetails = userDetails
        )
    }

    private fun prepareTestUserDetails(): UserDetails {
        val randNum = Random.nextInt(4999)
        return UserDetails(
            email = "user$randNum@at_mail.ooo",
            firstName = "Test UaaUser firstName $randNum",
            lastName = "Test UaaUser lastName $randNum",
            middleName = "Test UaaUser middleName $randNum",
            phoneNumber = "Test UaaUser phoneNumber $randNum"
        )
    }

    @Step("Подготовить '${UaaNames.USER}' для обновления")
    fun getUaaUserDtoForUpdate(createdDto: UaaUserDto): UaaUserDto {
        return createdDto.copy(
            blockReason = "some reason",
            permanentBlocked = true,
            preferredLocale = "en",
            scopes = ScopeData.getRandomIds(),
            userDetails = prepareTestUserDetails()
        )
    }

    private val defaultBlockedUserId by lazy {
        val id = StoredUserData.get().find { it.login == "client5" }?.id
        id ?: throw RuntimeException("Не найден ID пользователя с логином 'client5'.")
        id
    }

    @Step("Подготовить заблокированного '${UaaNames.USER}'")
    fun preparePermBlockedUaaUserDtoForCreate(blockedUserId: UUID? = defaultBlockedUserId): UaaUserDto {
        return prepareUaaUserDtoForCreate(
            blockReason = "Some block reason",
            blockUser = blockedUserId,
            permanentBlocked = true
        )
    }

    @Step("Подготовить временно заблокированного '${UaaNames.USER}'")
    fun prepareTempBlockedUaaUserDtoForCreate(blockedUserId: UUID? = defaultBlockedUserId): UaaUserDto {
        return prepareUaaUserDtoForCreate(
            blockReason = "Some block reason",
            blockUser = blockedUserId,
            preferredLocale = "en",
            temporaryBlocked = true,
            temporaryBlockedUntil = ZonedDateTime.now().withNano(123456000).ofUTC().plusMinutes(10)
        )
    }

    @Step("Создать УааПользователя {dtoForCreate.id}")
    fun createUaaUser(dtoForCreate: UaaUserDto): UaaUserDto {
        val genericResponseDto = UaaUserSteps().create(dtoForCreate)
        return genericResponseDto.data ?: throw RuntimeException("Ошибка при создании УааПользователя для тестов фильтрации")
    }
}