package ooo.jtc.api.dictionaries.contractorcontact

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactData
import ooo.jtc.testdata.dictionaries.contractorcontact.FindContractorContactBy
import ooo.jtc.uaa.User
import java.util.*

object ContractorContactPrepareSteps {

    @Step("Удалить созданные автотестами данные ContractorContact из БД")
    fun cleanAtCreated() {
        FindContractorContactBy.AT_CREATED.get().forEach { contrContact ->
            ContractorContactData.removeRecord?.let { it(contrContact) }
        }
    }

    fun getContractorContactDtoForCreate(user: User): ContractorContactDto {
        val availableContractor = ContractorData.getOrCreate(
            consumer = { ContractorData.searchBy(user) },
            provider = { ContractorPrepareSteps.createContractorDto(user).toModel() }
        )
        return getContractorContactDtoForCreate(availableContractor.id!!)
    }

    fun getContractorContactDtoForCreate(contractorId: UUID) =
        ContractorContactDto(
            id = null,
            version = 0,
            contractorId = contractorId,
            name = regexWord.random(50, 150) + AT_POSTFIX,  // (WiP) up to 200 symbols
            email = regexWord.random(50, 150),      // (WiP) up to 200 symbols
            position = regexWord.random(50, 150),   // (WiP) up to 200 symbols
            telephone = regexWord.random(50, 150),  // (WiP) up to 200 symbols
            comment = regexWord.random(200, 3000)   // (WiP) up to 4000 symbols
        )

    fun getContractorContactDtoForUpdate(createdDto: ContractorContactDto) =
        ContractorContactDto(
            createdDto.id, createdDto.version,
            contractorId = createdDto.contractorId,
            name = "updated ${createdDto.name}",
            email = "updated ${createdDto.email}",
            position = "updated ${createdDto.position}",
            telephone = "000${createdDto.telephone}000",
            comment = "updated ${createdDto.comment}"
        )

    @Step("Создание ${DictionaryNames.CONTRACTOR_CONTACT} для пользователя {user.login}")
    fun createContractorContactDto(user: User): ContractorContactDto {
        val dtoForCreate = getContractorContactDtoForCreate(user)
        return createContractorContactDto(dtoForCreate)
    }

    // [2020.05.26 Sergeyev]:
    // на случай, если мы будем в будущем создавать через конкретный contractorId.
    // Удалить, если не будет использоваться более месяца
    @Step("Создание ${DictionaryNames.CONTRACTOR_CONTACT} для контрагента [{contractorId}]")
    fun createContractorContactDto(contractorId: UUID): ContractorContactDto {
        val dtoForCreate = getContractorContactDtoForCreate(contractorId)
        return createContractorContactDto(dtoForCreate)
    }

    fun createContractorContactDto(dtoForCreate: ContractorContactDto): ContractorContactDto {
        return ContractorContactSteps(Users.superUser).create(dtoForCreate).data.getOrException()
    }
}
