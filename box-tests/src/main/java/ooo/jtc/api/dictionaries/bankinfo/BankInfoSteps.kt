package ooo.jtc.api.dictionaries.bankinfo

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeSteps
import ooo.jtc.dictionaries.bankinfo.BankInfoDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.uaa.User
import java.util.UUID

class BankInfoSteps(bankUser: User) : AbstractDictionarySteps<BankInfoDto, BankInfoDto>(
    user = bankUser,
    entity = BankInfoDto::class.java,
    dictionaryName = "bank"
) {

    @Step("Удалить '{this.entityName}' и связанных представителей по id={id}")
    override fun delete(
        id: UUID,
        withCheckResponseCode: Boolean,
        statusCode: Int
    ): GenericResponseDto<BankInfoDto> {
        val bankRepresentativeIds = BankRepresentativeData.get(
            fromCache = false,
            predicate = { it.bankId == id }
        )
        bankRepresentativeIds
            .map { it.id!! }
            .let { ids ->
                val bankRepresentativeSteps = BankRepresentativeSteps()
                ids.forEach { bankRepresentativeSteps.delete(it) }
            }
        return super.delete(id, withCheckResponseCode, statusCode)
    }

    @Step("Удалить '{this.entityName}' по id={id}")
    fun deleteOnlyBankInfo(
        id: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<BankInfoDto> {
        return super.delete(id, withCheckResponseCode, statusCode)
    }
}