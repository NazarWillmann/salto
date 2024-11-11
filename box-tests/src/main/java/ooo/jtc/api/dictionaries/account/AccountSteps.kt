package ooo.jtc.api.dictionaries.account

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.dictionaries.account.AccountDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.serialization.SerializationUtils.constructType
import ooo.jtc.uaa.User
import java.math.BigDecimal
import java.util.*

class AccountSteps(user: User) :
    AbstractDictionarySteps<AccountDto, AccountDto>(
        user = user,
        entity = AccountDto::class.java,
        dictionaryName = "account"
    ) {

    private val responseBigDecimalListType = constructType(GenericListResponseDto::class.java, BigDecimal::class.java)

    @Step("Получить баланс счёта по его реквизитам (номер '{accountNumber}', БИК '{bic}', организация [{customerId}])")
    fun getAccountBalance(
        accountNumber: String,
        bic: String,
        customerId: UUID,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<BigDecimal> {
        val args = mapOf(
            "accountNumber" to accountNumber,
            "bic" to bic,
            "customerId" to customerId
        )

        return stepApi.send(
            method = {
                body(args)
                post("$servicePath/GetAccountBalance")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseBigDecimalListType)
    }

    @Step("Получить счёт по его реквизитам (номер '{accountNumber}', организация [{customerId}], подразделение [{branchId}])")
    fun getByAccountNumber(
        accountNumber: String,
        branchId: UUID?,
        customerId: UUID?,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericListResponseDto<AccountDto> {
        val args = mutableMapOf("accountNumber" to accountNumber)
        branchId?.let { args["branchId"] = branchId.toString() }
        customerId?.let { args["customerId"] = customerId.toString() }

        return stepApi.send(
            method = {
                body(args)
                post("$servicePath/GetByAccountNumber")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseListType)
    }
}