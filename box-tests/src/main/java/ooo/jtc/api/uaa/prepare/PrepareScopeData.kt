package ooo.jtc.api.uaa.prepare

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.uaa.resource.ResourceData
import ooo.jtc.uaa.scope.dto.ScopeDto
import ooo.jtc.uaa.scope.dto.ScopeUpdateRequest
import kotlin.random.Random

object PrepareScopeData {

    @Step("Подготовить тестовый ${UaaNames.SCOPE} по умолчанию")
    fun prepareScopeDtoForCreate(): ScopeDto {
        val createdResourceDto = ResourceData.randomOrException().toDto()
        val rand = Random.nextInt(4999)
        return ScopeDto(
            id = null,
            version = 0,
            name = "Test Scope $rand",
            uiName = "UI Test Scope $rand",
            description = "Scope for AT $rand $AT_POSTFIX",
            resourceId = createdResourceDto.id!!,
            needApprove = true,
            resource = null
        )
    }

    @Step("Подготовить ${UaaNames.SCOPE} для обновления")
    fun getScopeDtoForUpdate(createdDto: ScopeDto): ScopeUpdateRequest {
        return ScopeUpdateRequest(
            id = createdDto.id,
            version = createdDto.version,
            uiName = createdDto.uiName + " updated",
            description = "Измененное описание для ${createdDto.description}",
            needApprove = false
        )
    }
}