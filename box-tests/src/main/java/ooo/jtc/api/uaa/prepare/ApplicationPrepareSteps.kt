package ooo.jtc.api.uaa.prepare

import io.qameta.allure.Step
import ooo.jtc.api.uaa.steps.ApplicationSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.generic.UaaNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.uaa.catalog.CatalogData
import ooo.jtc.testdata.uaa.resource.ResourceData
import ooo.jtc.uaa.application.dto.AllowedFlows
import ooo.jtc.uaa.application.dto.ApplicationDto
import ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto
import kotlin.random.Random

object ApplicationPrepareSteps {

    @Step("Подготовить тестовый ${UaaNames.APPLICATION} по умолчанию")
    fun prepareApplicationDtoForCreate(): ApplicationDto {
        val randNum = Random.nextInt(4999)
        return ApplicationDto(
            id = null,
            version = 0,
            name = "TestApplicationName $randNum $AT_POSTFIX",
            description = "TestApplication Описание $randNum",
            allowedFlows = listOf(AllowedFlows.AuthorizationCode),
            redirectUrls = "https://redirectUrls.ru/$randNum",
            availableResources = ResourceData.getRandomIds(),
            availableCatalogs = CatalogData.getRandomIds(),
            autoApproveScopes = true,
            accessTokenLifeTime = Random.nextInt(9600000),
            refreshTokenLifeTime = Random.nextInt(9600000),
            sessionLifeTime = Random.nextInt(9600000),
            loginSite = ApplicationLoginSiteDto(
                baseUrl = RandomData.latinWord.random(length = 10),
                loginPath = RandomData.latinWord.random(length = 10),
                approvePath = RandomData.latinWord.random(length = 10),
                mfaPath = RandomData.latinWord.random(length = 10),
                smsMfaPath = RandomData.latinWord.random(length = 10),
                paramsViaFragment = Random.nextBoolean()
            ),
            clientId = null,
            clientSecret = null
        )
    }

    @Step("Подготовить ${UaaNames.APPLICATION} для обновления")
    fun getApplicationDtoForUpdate(createdDto: ApplicationDto): ApplicationDto {
        return ApplicationDto(
            id = createdDto.id,
            version = createdDto.version,
            name = "Changed ${createdDto.name}",
            description = "${createdDto.description} изменено",
            allowedFlows = listOf(AllowedFlows.Implicit, AllowedFlows.ResourceOwner),
            redirectUrls = "${createdDto.redirectUrls}/changes",
            availableResources = ResourceData.getRandomIds(),
            availableCatalogs = CatalogData.getRandomIds(),
            autoApproveScopes = false,
            accessTokenLifeTime = Random.nextInt(9600000),
            refreshTokenLifeTime = Random.nextInt(9600000),
            sessionLifeTime = Random.nextInt(9600000),
            loginSite = ApplicationLoginSiteDto(
                baseUrl = RandomData.latinWord.random(length = 10),
                loginPath = RandomData.latinWord.random(length = 10),
                approvePath = RandomData.latinWord.random(length = 10),
                mfaPath = RandomData.latinWord.random(length = 10),
                smsMfaPath = RandomData.latinWord.random(length = 10),
                paramsViaFragment = Random.nextBoolean()
            ),
            clientId = createdDto.clientId,
            clientSecret = createdDto.clientSecret
        )
    }

    @Step("Создать тестовый ${UaaNames.APPLICATION} по умолчанию")
    fun createTestDto(): ApplicationDto {
        val dtoForCreate = prepareApplicationDtoForCreate()
        val responseDto = ApplicationSteps().create(dtoForCreate)
        if (responseDto.validationResult != null || responseDto.data == null) {
            throw RuntimeException("Ошибка при создании записи тестового Application.")
        }
        return responseDto.data!!
    }
}