package ooo.jtc.api.dictionaries.codevo

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.codevo.CodeVoDto
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.codevo.CodeVoData
import ooo.jtc.testdata.dictionaries.codevo.FindCodeVoBy

object CodeVoPrepareSteps {

    @Step("Удалить созданные автотестами данные CodeVo из БД")
    fun cleanAtCreated() {
        FindCodeVoBy.AT_CREATED.get().forEach { cvo ->
            CodeVoData.removeRecord?.let { it(cvo) }
        }
    }

    fun getCodeVoDtoForCreate() = CodeVoDto(
        id = null,
        version = 0,
        code = digits.random(5, 5),
        description = RandomData("[а-яА-Я0-9 ]*").random(20, 3899).trim() + AT_POSTFIX_RUS_PARENTHESES
    )

    fun getCodeVoDtoForUpdate(createdDto: CodeVoDto) =
        CodeVoDto(
            createdDto.id, createdDto.version,
            code = digits.random(5, 5),
            description = "Обновл. ${createdDto.description}"
        )
}