package ooo.jtc.api.dictionaries.uer

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.bankru.BankType
import ooo.jtc.dictionaries.uer.UerDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.reflections.ReflectionUtils.anyOther
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.uer.FindUerBy
import ooo.jtc.testdata.dictionaries.uer.UerData
import java.util.concurrent.BlockingQueue
import kotlin.random.Random

object UerPrepareSteps {

    @Step("Удалить созданные автотестами данные Uer из БД")
    fun cleanAtCreated() {
        FindUerBy.AT_CREATED.get().forEach { uer ->
            UerData.removeRecord?.let { it(uer) }
        }
    }

    val availableUerCodes: BlockingQueue<String> by lazy {
        val defaultMaxExistingCode = 10
        val maxAvailableCode = 100
        UerData.generateUniqueValues(
            consume = { it.uer },
            generate = { Random.nextInt(defaultMaxExistingCode, maxAvailableCode).toString() }
        )
    }

    fun getUerDtoForCreate() =
        UerDto(
            id = null,
            version = 0,
            uer = availableUerCodes.remove().toString(),
            bankType = BankType.values().random(),
            description = regexWord.random(50, 50) + AT_POSTFIX
        )

    fun getUerDtoForUpdate(createdDto: UerDto): UerDto {
        availableUerCodes.add(createdDto.uer)
        return UerDto(
            createdDto.id, createdDto.version,
            uer = availableUerCodes.remove().toString(),
            bankType = createdDto.bankType.anyOther(),
            description = "Updated ${createdDto.description}"
        )
    }

    @Step("Создать ${DictionaryNames.UER}")
    fun createUerDto(dtoForCreate: UerDto = getUerDtoForCreate()): UerDto {
        return UerSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}