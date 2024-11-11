package ooo.jtc.api.dictionaries.okopf

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.okopf.OkopfDto
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.okopf.FindOkopfBy
import ooo.jtc.testdata.dictionaries.okopf.OkopfData

object OkopfPrepareSteps {

    @Step("Удалить созданные автотестами данные Okopf из БД")
    fun cleanAtCreated() {
        FindOkopfBy.AT_CREATED.get().forEach { okopf ->
            OkopfData.removeRecord?.let { it(okopf) }
        }
    }

    fun getOkopfDtoForCreate() = OkopfDto(
        id = null,
        version = 0,
        code = "00" + digits.random(3, 3),
        description = RandomData("[а-яА-Я0-9 ]*").random(20, 3899).trim() + TestConstants.AT_POSTFIX_RUS_PARENTHESES
    )

    fun getOkopfDtoForUpdate(createdDto: OkopfDto) =
        OkopfDto(
            createdDto.id, createdDto.version,
            code = digits.random(5, 5),
            description = "Обновл. ${createdDto.description}"
        )
}