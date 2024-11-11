package ooo.jtc.api.dictionaries.lettertypefrombank

import io.qameta.allure.Step
import ooo.jtc.core.RegexpConst
import ooo.jtc.core.TestConstants.AT_POSTFIX_UNDERSCORE
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.lettertypefrombank.FindLetterTypeFromBankBy
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankData

object LetterTypeFromBankPrepareSteps {

    @Step("Удалить созданные автотестами данные '${DictionaryNames.LETTER_TYPE_FROM_BANK}' из БД")
    fun cleanAtCreated() {
        FindLetterTypeFromBankBy.AT_CREATED.get().forEach { lfbType ->
            LetterTypeFromBankData.removeRecord?.let { it(lfbType) }
        }
    }

    fun getLetterTypeFromBankDtoForCreate() =
        LetterTypeFromBankDto(
            id = null,
            version = 0,
            code = RandomData(RegexpConst.UPPER_LAT_NUM_UND).random(10, 27) + AT_POSTFIX_UNDERSCORE,
            description = regexWord.random(20, 100)
        )

    fun getLetterTypeFromBankDtoForUpdate(createdDto: LetterTypeFromBankDto) =
        LetterTypeFromBankDto(
            createdDto.id, createdDto.version,
            code = "UPD_${createdDto.code}",
            description = "Updated ${createdDto.description}"
        )

    @Step("Создать ${DictionaryNames.LETTER_TYPE_FROM_BANK}")
    fun createLetterTypeFromBankDto(
        dtoForCreate: LetterTypeFromBankDto = getLetterTypeFromBankDtoForCreate()
    ): LetterTypeFromBankDto {
        return LetterTypeFromBankSteps(Users.superUser).create(dtoForCreate).data.getOrException()
    }
}