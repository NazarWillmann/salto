package ooo.jtc.api.dictionaries.currency

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.currency.CurrencyDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.currency.CurrencyData
import ooo.jtc.testdata.dictionaries.currency.FindCurrencyBy
import java.util.*

object CurrencyPrepareSteps {

    @Step("Удалить созданные автотестами данные Currency из БД")
    fun cleanAtCreated() {
        FindCurrencyBy.AT_CREATED.get().forEach { curr ->
            CurrencyData.removeRecord?.let { it(curr) }
        }
    }

    private val availableAlphabeticCodes by lazy {
        CurrencyData.generateUniqueValues(
            consume = { it.alphaCode },
            generate = { RandomData("(\\w|\\d)*").random(1, 3) })
    }

    private val availableDigitCodes by lazy {
        CurrencyData.generateUniqueValues(consume = { it.digitCode }, generate = { Random().nextInt(100).toString() })
    }

    fun getCurrencyDtoForCreate() =
        CurrencyDto(
            id = null,
            version = 0,
            digitCode = availableDigitCodes.remove(),       // unique, up to 3 symbols (digits only)
            alphaCode = availableAlphabeticCodes.remove(),  // unique, up to 3 symbols
            name = regexWord.random(50, 200) + AT_POSTFIX,  // up to 255 symbols
            nameInOkv = regexWord.random(50, 240),  // up to 255 symbols
            minorUnitCount = Random().nextInt(10)
        )

    fun getCurrencyDtoForUpdate(createdDto: CurrencyDto): CurrencyDto {
        availableDigitCodes.add(createdDto.digitCode)
        availableAlphabeticCodes.add(createdDto.alphaCode)
        return CurrencyDto(
            createdDto.id, createdDto.version,
            digitCode = availableDigitCodes.remove(),
            alphaCode = availableAlphabeticCodes.remove(),
            name = "UPDATED ${createdDto.name}",
            nameInOkv = "upd. ${createdDto.nameInOkv}",
            minorUnitCount = Random().nextInt(10)
        )
    }

    @Step("Создать ${DictionaryNames.CURRENCY}")
    fun createCurrencyDto(dtoForCreate: CurrencyDto = getCurrencyDtoForCreate()): CurrencyDto {
        return CurrencySteps(bankAdmin).create(dtoForCreate).data.getOrException()
    }
}