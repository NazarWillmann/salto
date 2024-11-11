package ooo.jtc.api.dictionaries.controlcode

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.controlcode.ControlCodeDto
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeData
import ooo.jtc.testdata.dictionaries.controlcode.FindControlCodeBy

object ControlCodePrepareSteps {

    @Step("Удалить созданные автотестами данные ControlCode из БД")
    fun cleanAtCreated() {
        FindControlCodeBy.AT_CREATED.get().forEach { cc ->
            ControlCodeData.removeRecord?.let { it(cc) }
        }
    }

    fun getControlCodeDtoForCreate() = ControlCodeDto(
        id = null,
        version = 0,
        code = regexWord.random(1, 4),          // up to 4 symbols
        description = regexWords.random(30, 45) + AT_POSTFIX  // up to 60 symbols
    )

    fun getControlCodeDtoForUpdate(createdDto: ControlCodeDto) =
        ControlCodeDto(
            createdDto.id, createdDto.version,
            code = regexWord.random(1, 4),
            description = "Updated ${createdDto.description}"
        )
}