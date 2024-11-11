package ooo.jtc.api.dictionaries.ndspercent

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_PERCENTAGE
import ooo.jtc.dictionaries.ndspercent.NdsPercentDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.amount
import ooo.jtc.interfaces.getOrException
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.ndspercent.FindNdsPercentBy
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentData
import kotlin.random.Random

object NdsPercentPrepareSteps {

    @Step("Удалить созданные автотестами данные NdsPercent из БД")
    fun cleanAtCreated() {
        FindNdsPercentBy.AT_CREATED.get().forEach { ndsPerc ->
            NdsPercentData.removeRecord?.let { it(ndsPerc) }
        }
    }

    fun getNdsPercentDtoForCreate() =
        NdsPercentDto(
            id = null,
            version = 0,
            percent = amount(Random.nextDouble(0.01, 0.99) + AT_PERCENTAGE),
            isDefaultRuPayment = false
        )

    fun getNdsPercentDtoForUpdate(createdDto: NdsPercentDto) =
        createdDto.copy(
            percent = amount(Random.nextDouble(0.01, 0.99) + AT_PERCENTAGE)
        )

    @Step("Создать ${DictionaryNames.NDS_PERCENT}")
    fun createNdsPercentDto(dtoForCreate: NdsPercentDto = getNdsPercentDtoForCreate()): NdsPercentDto {
        return NdsPercentSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}