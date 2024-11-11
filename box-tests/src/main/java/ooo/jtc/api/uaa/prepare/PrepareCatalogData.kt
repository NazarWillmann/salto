package ooo.jtc.api.uaa.prepare

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.uaa.mfa.MfaData
import ooo.jtc.uaa.catalog.dto.CatalogDto
import ooo.jtc.uaa.catalog.dto.UserCatalogMfaDto
import ooo.jtc.uaa.catalog.model.UserCatalogKind
import kotlin.random.Random

object PrepareCatalogData {

    @Step("Подготовить тестовый ${UaaNames.MFA} по умолчанию")
    fun prepareCatalogDtoForCreate(): CatalogDto {
        val mfa = listOf(getRandomUserCatalogMfaDto())
        val randNum = Random.nextInt(4999)
        return CatalogDto(
            id = null,
            version = 0,
            name = "Test Catalog $randNum $AT_POSTFIX",
            description = "Catalog for AT $randNum",
            catalogType = "CatalogTypeAT",
            title = "CatalogTypeAT Title",
            appearance = "AT",
            catalogKind = UserCatalogKind.values().random(),
            enabled = true,
            mfa = mfa
        )
    }

    private fun getRandomUserCatalogMfaDto(): UserCatalogMfaDto {
        val mfaData = MfaData.randomOrException()
        return UserCatalogMfaDto(
            id = null,
            mfaId = mfaData.id!!,
            lifetimeSec = Random.nextInt(50000).toLong(),
            maxAttempts = Random.nextInt(50000).toLong()
        )
    }

    @Step("Подготовить ${UaaNames.MFA} для обновления")
    fun getCatalogDtoForUpdate(createdDto: CatalogDto): CatalogDto {
        val randNum = Random.nextInt(4999)
        return CatalogDto(
            createdDto.id,
            createdDto.version,
            name = "Измененное название ${createdDto.name}",
            description = "Измененное название для AT $randNum",
            catalogType = "ChangedCatalogTypeAT",
            title = "CatalogTypeAT Changed Title",
            appearance = "AT Changed",
            catalogKind = UserCatalogKind.values().filterNot { it == createdDto.catalogKind }[0],
            enabled = false,
            mfa = createdDto.mfa
        )
    }
}