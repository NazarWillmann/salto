package ooo.jtc.api.dictionaries.budgetreasoncode

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto
import ooo.jtc.dictionaries.budgetreasoncode.PayType
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.allAllowedChars

object BudgetReasonCodePrepareSteps {

    val codeChars by lazy {
        RandomData.builder()
            .withRussianCapitalLetters()
            .withDigits()
            .build()
    }

    fun getBudgetReasonCodeDtoForCreate(textFieldGenerator: RandomData = allAllowedChars) = BudgetReasonCodeDto(
        id = null,
        version = 0,
        code = codeChars.random(length = 2),
        description = textFieldGenerator.random(length = 500, prefix = AT_PREFIX_RUS),
        payType = PayType.values().random(),
        hint108 = textFieldGenerator.random(length = 600, prefix = AT_PREFIX_RUS),
        hint109 = textFieldGenerator.random(length = 600, prefix = AT_PREFIX_RUS)
    )

    fun getBudgetReasonCodeDtoForUpdate(createdDto: BudgetReasonCodeDto): BudgetReasonCodeDto {
        val updateDto = getBudgetReasonCodeDtoForCreate()
        updateDto.id = createdDto.id
        updateDto.version = createdDto.version
        return updateDto
    }
}