package ooo.jtc.api.rupayment.prepare

import ooo.jtc.dictionaries.bankru.BankRu
import ooo.jtc.dictionaries.branch.Branch
import ooo.jtc.rupayment.dto.BankDto

object BankDtoPrepareSteps {

    fun getBankDto(bankRu: BankRu): BankDto {
        return BankDto(
            address = bankRu.address?.let { "AT_${it.take(197)}" },
            name = bankRu.bankName,
            bic = bankRu.bic,
            corrAccount = bankRu.corrAccount
        )
    }

    fun getBankDto(branch: Branch): BankDto {
        //TODO Sergeyev [2021.02.02]: default branch account
        val corrAccount = "00000000000000"//AccountData.
        return BankDto(
            address = branch.addressRegistration.fullAddress,
            name = branch.uiName,
            bic = branch.paymentDetailsBic!!.bic,
            corrAccount = corrAccount
        )
    }
}