package ooo.jtc.api.dictionaries.region

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.region.RuRegionDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.region.FindRuRegionBy
import ooo.jtc.testdata.dictionaries.region.RuRegionData
import kotlin.random.Random

object RuRegionPrepareSteps {

    @Step("Удалить созданные автотестами данные RuRegion из БД")
    fun cleanAtCreated() {
        FindRuRegionBy.AT_CREATED.get().forEach { region ->
            RuRegionData.removeRecord?.let { it(region) }
        }
    }

    fun getRuRegionDtoForCreate() =
        RuRegionDto(
            id = null,
            version = 0,
            code = Random.nextInt(90000, 100000).toString(),
            name = "RuRegion / " + regexWord.random(10, 15) + AT_POSTFIX
        )

    fun getRuRegionDtoForUpdate(createdDto: RuRegionDto) =
        RuRegionDto(
            createdDto.id, createdDto.version,
            "951${createdDto.code}",
            "(updated) ${createdDto.name}"
        )

    @Step("Создать ${DictionaryNames.RU_REGION}")
    fun createRuRegionDto(dtoForCreate: RuRegionDto = getRuRegionDtoForCreate()): RuRegionDto {
        return RuRegionSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}