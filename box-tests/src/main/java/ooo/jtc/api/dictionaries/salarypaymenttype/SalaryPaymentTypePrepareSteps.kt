package ooo.jtc.api.dictionaries.salarypaymenttype

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeDto
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeData

object SalaryPaymentTypePrepareSteps {

    val availableSalaryPaymentTypeCodes by lazy {
        SalaryPaymentTypeData.generateUniqueValues(consume = { it.code }, generate = { (1..99).random().toString() })
    }

    fun getSalaryPaymentTypeDtoForCreate(nameGenerator: RandomData = allowedChars, code: String? = null) = SalaryPaymentTypeDto(
        id = null,
        version = 0,
        name = generateWithPrefix(generator = nameGenerator),
        incomeTypeCode = (1..3).random(),
        code = code ?: availableSalaryPaymentTypeCodes.remove()
    )

    fun getSalaryPaymentTypeDtoForUpdate(createdDto: SalaryPaymentTypeDto): SalaryPaymentTypeDto {
        return createdDto.copy(
            code = availableSalaryPaymentTypeCodes.remove(),
            name = generateWithPrefix(),
            incomeTypeCode = (1..3).random(),
        )
    }

    private val allowedChars by lazy {
        RandomData.builder()
            .withRussianAlphabet()
            .withSpecialCharacters()
            .build()
    }

    fun generateWithPrefix(generator: RandomData = allowedChars, length: Int = 60): String {
        return generator.random(length = length, prefix = AT_PREFIX_RUS)
    }


}