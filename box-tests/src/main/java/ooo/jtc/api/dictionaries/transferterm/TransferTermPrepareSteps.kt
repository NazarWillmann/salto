package ooo.jtc.api.dictionaries.transferterm

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.transferterm.TransferTermDto
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.allAllowedChars

object TransferTermPrepareSteps {

    fun getTransferTermDtoForCreate(textFieldGenerator: RandomData = allAllowedChars): TransferTermDto {
        return TransferTermDto(
            id = null,
            version = 0,
            code = generateWithPrefix(generator = textFieldGenerator, length = 35),
            description = generateWithPrefix(generator = textFieldGenerator, length = 255)
        )
    }

    fun getTransferTermDtoForUpdate(createdDto: TransferTermDto): TransferTermDto {
        return createdDto.copy(
            code = generateWithPrefix(length = 35),
            description = generateWithPrefix(length = 255)
        )
    }

    fun generateWithPrefix(generator: RandomData = allAllowedChars, length: Int): String {
        return generator.random(length = length, prefix = AT_PREFIX_RUS)
    }
}