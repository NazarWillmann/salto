package ooo.jtc.api.dictionaries.kbk

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.kbk.KbkDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.kbk.FindKbkBy
import ooo.jtc.testdata.dictionaries.kbk.KbkData

object KbkPrepareSteps {

    @Step("Удалить созданные автотестами данные Kbk из БД")
    fun cleanAtCreated() {
        FindKbkBy.AT_CREATED.get().forEach { kbk ->
            KbkData.removeRecord?.let { it(kbk) }
        }
    }

    fun getKbkDtoForCreate() = KbkDto(
        id = null,
        version = 0,
        code = digits.random(20, 20),
        description = regexWords.random(30, 3959).trim() + AT_POSTFIX
    )

    fun getKbkDtoForUpdate(createdDto: KbkDto) =
        KbkDto(
            createdDto.id, createdDto.version,
            code = digits.random(20, 20),
            description = "(updated desc) ${createdDto.description}"
        )

    @Step("Создать ${DictionaryNames.KBK}")
    fun createKbkDto(dtoForCreate: KbkDto = getKbkDtoForCreate()): KbkDto {
        return KbkSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}