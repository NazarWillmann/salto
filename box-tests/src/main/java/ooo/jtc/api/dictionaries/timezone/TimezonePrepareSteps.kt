package ooo.jtc.api.dictionaries.timezone

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.timezone.TimezoneDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.timezone.FindTimezoneBy
import ooo.jtc.testdata.dictionaries.timezone.TimezoneData
import kotlin.random.Random

object TimezonePrepareSteps {

    @Step("Удалить созданные автотестами данные Timezone из БД")
    fun cleanAtCreated() {
        FindTimezoneBy.AT_CREATED.get().forEach { tz ->
            TimezoneData.removeRecord?.let { it(tz) }
        }
    }

    fun getTimezoneDtoForCreate() =
        TimezoneDto(
            id = null,
            version = 0,
            shift = Random.nextInt(25) - 12,
            name = regexWord.random(50, 255) + AT_POSTFIX // up to 255 symbols, unique
        )

    fun getTimezoneDtoForUpdate(createdDto: TimezoneDto) =
        TimezoneDto(
            createdDto.id, createdDto.version,
            shift = Random.nextInt(25) - 12,
            name = "Updated ${createdDto.name}"
        )

    @Step("Создать ${DictionaryNames.TIME_ZONE}")
    fun createTimezoneDto(dtoForCreate: TimezoneDto = getTimezoneDtoForCreate()): TimezoneDto {
        return TimezoneSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}