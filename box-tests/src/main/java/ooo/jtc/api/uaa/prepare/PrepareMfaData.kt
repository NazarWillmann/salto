package ooo.jtc.api.uaa.prepare

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.generic.UaaNames
import ooo.jtc.uaa.mfa.dto.MfaDto
import kotlin.random.Random

object PrepareMfaData {

    @Step("Подготовить тестовый ${UaaNames.MFA} по умолчанию")
    fun prepareMfaDtoForCreate(): MfaDto {
        val randNum = Random.nextInt(4999)
        return MfaDto(
            id = null,
            version = 0,
            name = "Test Mfa $randNum $AT_POSTFIX",
            description = "Mfa for AT $randNum",
            mfaType = "MfaTypeAT",
            title = "MfaTypeAT Title"
        )
    }

    @Step("Подготовить ${UaaNames.MFA} для обновления")
    fun getMfaDtoForUpdate(createdDto: MfaDto): MfaDto {
        val randNum = Random.nextInt(4999)
        return MfaDto(
            createdDto.id,
            createdDto.version,
            name = "Измененное название ${createdDto.name}",
            description = "Измененное название для AT $randNum",
            mfaType = "ChangedMfaTypeAT",
            title = "MfaTypeAT Changed Title"
        )
    }
}