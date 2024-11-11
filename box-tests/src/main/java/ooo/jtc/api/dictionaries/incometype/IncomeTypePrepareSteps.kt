package ooo.jtc.api.dictionaries.incometype

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.incometype.IncomeTypeDto
import ooo.jtc.random.RandomData
import ooo.jtc.wait.Wait

object IncomeTypePrepareSteps {

    private var validCodes = (4..9).toSortedSet()

    fun getValidCode(): Int {
        return Wait.forResult(supplier = {
            synchronized(validCodes) {
                if (validCodes.size > 0) {
                    val code = validCodes.last()
                    validCodes.remove(code)
                    return@forResult code
                }
                return@forResult null
            }
        })
    }

    fun addValidCode(code: Int) {
        synchronized(validCodes) {
            validCodes.add(code)
        }
    }

    fun getIncomeTypeDtoForCreate(textFieldGenerator: RandomData = allowedChars): IncomeTypeDto {
        val code = getValidCode()
        return getIncomeTypeDtoForCreate(textFieldGenerator, code)
    }

    fun getIncomeTypeDtoForCreate(textFieldGenerator: RandomData = allowedChars, code: Int?): IncomeTypeDto {
        return IncomeTypeDto(
            id = null,
            version = 0,
            code = code,
            name = generateWithPrefix(generator = textFieldGenerator, length = 60),
            description = generateWithPrefix(generator = textFieldGenerator, length = 255)
        )
    }

    fun getIncomeTypeDtoForUpdate(createdDto: IncomeTypeDto): IncomeTypeDto {
        return createdDto.copy(
            code = getValidCode(),
            name = generateWithPrefix(length = 60),
            description = generateWithPrefix(length = 255)
        )
    }

    private val allowedChars by lazy {
        RandomData.builder()
            .withRussianAlphabet()
            .withSpecialCharacters()
            .build()
    }

    fun generateWithPrefix(generator: RandomData = allowedChars, length: Int): String {
        return generator.random(length = length, prefix = AT_PREFIX_RUS)
    }

}