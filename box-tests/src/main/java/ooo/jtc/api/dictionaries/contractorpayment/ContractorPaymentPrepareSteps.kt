package ooo.jtc.api.dictionaries.contractorpayment

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentUpdateRequest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomRequisites
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.account.BalanceAccount
import ooo.jtc.testdata.dictionaries.bankru.BankRuData
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentData
import ooo.jtc.testdata.dictionaries.contractorpayment.FindContractorPaymentBy
import ooo.jtc.dictionaries.currency.DefaultCurrency
import ooo.jtc.uaa.User
import java.util.*

object ContractorPaymentPrepareSteps {

    @Step("Удалить созданные автотестами данные ContractorPayment из БД")
    fun cleanAtCreated() {
        FindContractorPaymentBy.AT_CREATED.get().forEach { contrPay ->
            ContractorPaymentData.removeRecord?.let { it(contrPay) }
        }
    }

    fun getContractorPaymentDtoForCreate(user: User, isDefault: Boolean = false): ContractorPaymentDto {
        val contractorId =
            ContractorData.getOrCreate(
                consumer = { ContractorData.searchBy(user) },
                provider = { ContractorPrepareSteps.createContractorDto(user).toModel() }
            ).id!!
        return getContractorPaymentDtoForCreate(contractorId = contractorId, isDefault = isDefault)
    }

    @Step("Подготовить тестовое DTO для создания '${DictionaryNames.CONTRACTOR_PAYMENT}' ")
    fun getContractorPaymentDtoForCreate(contractorId: UUID, balanceAccount: BalanceAccount = BalanceAccount.N_40702, isDefault: Boolean = false):
            ContractorPaymentDto {
        val bankRu = BankRuData.find { !it.corrAccount.isNullOrEmpty() && it.locationType != null }
        val bankName = bankRu.bankName
        val bankBic = bankRu.bic
        val bankAddress = "${bankRu.locationType!!.nameShort} ${bankRu.location}$AT_POSTFIX"
        val bankCorrAccount = bankRu.corrAccount!!
        val generatedAccount = RandomRequisites.generateAccountNumber(balanceAccount.value, DefaultCurrency.RUR.digitCode, bankBic)
        return ContractorPaymentDto(
            id = null,
            version = 0,
            contractorId = contractorId,
            bankName = bankName,
            bankAddress = bankAddress,
            bic = bankBic,
            account = generatedAccount,
            corrAccount = bankCorrAccount,
            isDefault = isDefault
        )
    }

    @Step("Подготовить тестовое DTO для обновления '${DictionaryNames.CONTRACTOR_PAYMENT}' ")
    fun getContractorPaymentDtoForUpdate(createdDto: ContractorPaymentDto, isDefault: Boolean = true): ContractorPaymentUpdateRequest {
        val bankRu = BankRuData.find { !it.corrAccount.isNullOrEmpty() && it.locationType != null }
        val bankName = bankRu.bankName
        val bankBic = bankRu.bic
        val bankAddress = "${bankRu.locationType!!.nameShort} ${bankRu.location}$AT_POSTFIX"
        val bankCorrAccount = bankRu.corrAccount!!
        val generatedAccount = RandomRequisites.generateAccountNumber(BalanceAccount.N_40702.value, DefaultCurrency.RUR.digitCode, bankBic)
        return ContractorPaymentUpdateRequest(
            id = createdDto.id,
            version = createdDto.version,
            bankName = bankName,
            bankAddress = bankAddress,
            bic = bankBic,
            account = generatedAccount,
            corrAccount = bankCorrAccount,
            isDefault = isDefault
        )
    }

    @Step("Создание ${DictionaryNames.CONTRACTOR_PAYMENT} для пользователя {user.login}")
    fun createContractorPaymentDto(user: User): ContractorPaymentDto {
        val dtoForCreate = getContractorPaymentDtoForCreate(user)
        return createContractorPaymentDto(dtoForCreate)
    }

    // [2020.05.26 Sergeyev]:
    // на случай, если мы будем в будущем создавать через конкретный contractorId.
    // Удалить, если не будет использоваться более месяца
    @Step("Создание ${DictionaryNames.CONTRACTOR_PAYMENT} для контрагента [{contractorId}]")
    fun createContractorPaymentDto(contractorId: UUID): ContractorPaymentDto {
        val dtoForCreate = getContractorPaymentDtoForCreate(contractorId)
        return createContractorPaymentDto(dtoForCreate)
    }

    fun createContractorPaymentDto(dtoForCreate: ContractorPaymentDto): ContractorPaymentDto {
        return ContractorPaymentSteps(Users.superUser).create(dtoForCreate).data.getOrException()
    }
}