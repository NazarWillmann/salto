package ooo.jtc.api.dictionaries.lettertypetobank

import io.qameta.allure.Step
import ooo.jtc.core.RegexpConst
import ooo.jtc.core.TestConstants.AT_POSTFIX_UNDERSCORE
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.lettertypetobank.FindLetterTypeToBankBy
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankData
import ooo.jtc.uaa.User

object LetterTypeToBankPrepareSteps {

    @Step("Удалить созданные автотестами данные '${DictionaryNames.LETTER_TYPE_TO_BANK}' из БД")
    fun cleanAtCreated() {
        FindLetterTypeToBankBy.AT_CREATED.get().forEach { ltbType ->
            LetterTypeToBankData.removeRecord?.let { it(ltbType) }
        }
    }

    fun getLetterTypeToBankDtoForCreate() =
        LetterTypeToBankDto(
            id = null,
            version = 0,
            code = RandomData(RegexpConst.UPPER_LAT_NUM_UND).random(10, 27) + AT_POSTFIX_UNDERSCORE,
            description = regexWord.random(20, 100)
        )

    fun getLetterTypeToBankDtoForUpdate(createdDto: LetterTypeToBankDto) =
        LetterTypeToBankDto(
            createdDto.id, createdDto.version,
            code = "UPD_${createdDto.code}",
            description = "Updated ${createdDto.description}"
        )

    @Step("Создать ${DictionaryNames.LETTER_TYPE_TO_BANK}")
    fun createLetterTypeToBankDto(
        user: User = Users.superUser,
        dtoForCreate: LetterTypeToBankDto = getLetterTypeToBankDtoForCreate()
    ): LetterTypeToBankDto {
        return LetterTypeToBankSteps(user).create(dtoForCreate).data.getOrException()
    }
}