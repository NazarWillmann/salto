package ooo.jtc.api.dictionaries.bankrepresentative

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeDto
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import java.util.UUID

object BankRepresentativePrepareSteps {

    fun getBankRepresentativeDtoForCreate(
        uaaUserId: UUID,
        bankId: UUID
    ): BankRepresentativeDto {
        return BankRepresentativeDto(
            id = null,
            version = 0,
            userId = uaaUserId,
            position = regexWords.random(10, 15).trim() + AT_POSTFIX,
            email = RandomRequisites.generateEmail(),
            phone = digits.random(7, 12),
            block = BlockingInfoDto(isBlock = false),
            bankId = bankId,
            description = "desc$AT_POSTFIX"
        )
    }

    fun getBankRepresentativeDtoForUpdate(createdDto: BankRepresentativeDto): BankRepresentativeDto {
        return createdDto.copy(
            position = "updated ${createdDto.position}",
            email = "upd8d${createdDto.email}",
            phone = digits.random(7, 12),
            description = "updated ${createdDto.description}"
        )
    }

    @Step("Создать запись '${DictionaryNames.BANK_REPRESENTATIVE}'" +
            " для пользователя {dtoForCreate.userId} и банка {dtoForCreate.bankId}")
    fun createBankRepresentativeDto(dtoForCreate: BankRepresentativeDto): BankRepresentativeDto {
        val responseDto = BankRepresentativeSteps().create(dtoForCreate)
        return responseDto.data.getOrException()
    }

    fun createBankRepresentativeDto(uaaUserId: UUID, bankId: UUID): BankRepresentativeDto {
        val dtoForCreate = getBankRepresentativeDtoForCreate(uaaUserId = uaaUserId, bankId = bankId)
        return createBankRepresentativeDto(dtoForCreate = dtoForCreate)
    }

    @Step("Создать заблокированную запись '${DictionaryNames.BANK_REPRESENTATIVE}'" +
            " (пользователь [{dtoForCreate.userId}]; банк [{dtoForCreate.bankId}]")
    fun createBlockedBankRepresentativeDto(dtoForCreate: BankRepresentativeDto): BankRepresentativeDto {
        val createdDto = createBankRepresentativeDto(dtoForCreate)
        val blockingResponse = BankRepresentativeSteps().blockSingle(createdDto.id!!)
        return blockingResponse.list.getOrException()[0]
    }
}