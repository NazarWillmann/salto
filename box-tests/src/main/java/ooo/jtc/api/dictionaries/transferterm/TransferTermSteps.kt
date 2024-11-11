package ooo.jtc.api.dictionaries.transferterm

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.transferterm.TransferTerm
import ooo.jtc.dictionaries.transferterm.TransferTermDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class TransferTermSteps(user: User) :
    AbstractDictionarySteps<TransferTermDto, TransferTermDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = TransferTermDto::class.java,
        dictionaryName = "transferTerm"
    ) {

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.TRANSFER_TERM}'")
        fun checkDefaultEntity(actualEntity: TransferTerm, expectedEntity: TransferTerm) {
            Checks.checkFieldValue("код", actualEntity.code, expectedEntity.code)
            Checks.checkFieldValue("описание", actualEntity.description, expectedEntity.description)
        }
    }
}