package ooo.jtc.api.uaa.prepare

import io.qameta.allure.Step
import ooo.jtc.api.uaa.steps.ResourceSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.generic.UaaNames
import ooo.jtc.uaa.resource.dto.ResourceDto
import ooo.jtc.uaa.resource.model.Audience
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import kotlin.random.Random

object ResourcePrepareSteps {

    @Step("Подготовить тестовый ${UaaNames.RESOURCE} по умолчанию")
    fun prepareResourceDtoForCreate(): ResourceDto {
        val randNum = Random.nextInt(4999)
        return ResourceDto(
            id = null,
            version = 0,
            name = "Test Resource $randNum $AT_POSTFIX",
            description = "Resource for AT $randNum",
            audience = Audience.FOR_TEST.value + randNum,
            scopes = emptyList()
        )
    }

    @Step("Создать тестовый ${UaaNames.RESOURCE} по умолчанию")
    fun createResourceDto(): ResourceDto {
        val dtoForCreate = prepareResourceDtoForCreate()
        val genericResponseDto = ResourceSteps().create(dtoForCreate)
        val dto = genericResponseDto.data
        assertThat(dto, notNullValue())
        return dto!!
    }

    fun getResourceDtoForUpdate(createdDto: ResourceDto): ResourceDto {
        return ResourceDto(
            createdDto.id,
            createdDto.version,
            "Changed ${createdDto.name}",
            "Измененное описание для Resource ${Random.nextInt(4999)}",
            Audience.FOR_TEST.value + Random.nextInt(4999),
            emptyList()
        )
    }

}
