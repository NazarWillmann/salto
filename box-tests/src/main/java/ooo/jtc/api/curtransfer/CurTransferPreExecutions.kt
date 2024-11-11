package ooo.jtc.api.curtransfer

import ooo.jtc.api.curtransfer.steps.CurTransferPrepareSteps
import ooo.jtc.api.curtransfer.steps.CurTransferPrepareSteps.retrieveBankUser
import ooo.jtc.api.curtransfer.steps.CurTransferSteps
import ooo.jtc.curtransfer.dto.CurTransferDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.uaa.User

object CurTransferPreExecutions {

    fun createCurTransferDto(
        creatorClientUser: User,
        dtoForCreate: CurTransferDto = CurTransferPrepareSteps.getCurTransferDtoForCreate(
            creatorClientUser = creatorClientUser,
            receiverBankUser = retrieveBankUser(creatorClientUser)
        )
    ): CurTransferDto {
        return CurTransferSteps(creatorClientUser).create(dtoForCreate).data.getOrException()
    }
}