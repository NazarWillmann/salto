package ooo.jtc.api.dictionaries.okfs

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.okfs.OkfsDto
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.okfs.FindOkfsBy
import ooo.jtc.testdata.dictionaries.okfs.OkfsData

object OkfsPrepareSteps {

    @Step("Удалить созданные автотестами данные Okfs из БД")
    fun cleanAtCreated() {
        FindOkfsBy.AT_CREATED.get().forEach { okfs ->
            OkfsData.removeRecord?.let { it(okfs) }
        }
    }

    fun getOkfsDtoForCreate(parentCode: String? = null) = OkfsDto(
        id = null,
        version = 0,
        parentCode = parentCode,
        code = digits.random(3, 3),
        description = RandomData("[а-яА-Я0-9 ]*").random(20, 3899).trim() + TestConstants.AT_POSTFIX_RUS_PARENTHESES
    )

    fun getOkfsDtoForUpdate(createdDto: OkfsDto) =
        createdDto.copy(
            code = digits.random(3, 3),
            description = "Обновл. ${createdDto.description}"
        )
}