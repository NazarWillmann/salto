package ooo.jtc.api.dictionaries.branchrepresentative

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentativeDto
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import java.util.UUID

object BranchRepresentativePrepareSteps {

    fun getBranchRepresentativeDtoForCreate(uaaUserId: UUID, branchId: UUID): BranchRepresentativeDto {
        return BranchRepresentativeDto(
            id = null,
            version = 0,
            branchId = branchId,
            userId = uaaUserId,
            position = regexWords.random(10, 15).trim() + AT_POSTFIX,
            email = RandomRequisites.generateEmail(),
            phone = digits.random(7, 12),
            block = BlockingInfoDto(isBlock = false),
            description = regexWords.random(30, 3959).trim() + AT_POSTFIX
        )
    }

    fun getBranchRepresentativeDtoForUpdate(createdDto: BranchRepresentativeDto): BranchRepresentativeDto {
        return createdDto.copy(
            position = "updated ${createdDto.position}",
            email = "upd8d${createdDto.email}",
            phone = digits.random(7, 12),
            description = "updated ${createdDto.description}"
        )
    }

    @Step("Создать запись '${DictionaryNames.BRANCH_REPRESENTATIVE}' для пользователя {dtoForCreate.userId} и банка {dtoForCreate.branchId}")
    fun createBranchRepresentativeDto(dtoForCreate: BranchRepresentativeDto): BranchRepresentativeDto {
        val responseDto = BranchRepresentativeSteps().create(dtoForCreate)
        return responseDto.data.getOrException()
    }

    @Step("Создать заблокированную запись '${DictionaryNames.BRANCH_REPRESENTATIVE}'" +
            " (пользователь [{dtoForCreate.userId}]; банк [{dtoForCreate.branchId}]")
    fun createBlockedBranchRepresentativeDto(dtoForCreate: BranchRepresentativeDto): BranchRepresentativeDto {
        val createdDto = createBranchRepresentativeDto(dtoForCreate)
        val blockingResponse = BranchRepresentativeSteps().blockSingle(createdDto.id!!)
        return blockingResponse.list.getOrException().first()
    }
}