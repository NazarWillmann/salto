package ooo.jtc.api.dictionaries.contactor

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactPrepareSteps
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactSteps
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps.createContractorPaymentDto
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps.getContractorPaymentDtoForCreate
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentSteps
import ooo.jtc.api.dictionaries.ground.GroundPrepareSteps
import ooo.jtc.api.dictionaries.ground.GroundSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.contractor.Contractor
import ooo.jtc.dictionaries.contractor.ContractorDto
import ooo.jtc.dictionaries.contractor.ContractorUpdateDto
import ooo.jtc.dictionaries.contractor.ContractorUpdateInfoDto
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomNameUtils
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.account.BalanceAccount
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.contractor.FindContractorBy
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import java.util.*

object ContractorPrepareSteps {
    private val almightyUser = Users.superUser

    @Step("Удалить созданные автотестами данные Contractor из БД")
    fun cleanAtCreated() {
        FindContractorBy.AT_CREATED.get(false).forEach { contractor ->
            ContractorData.removeRecord?.let { it(contractor) }
        }
    }

    fun getContractorDtoForCreate(user: User, isOrganization: Boolean = true): ContractorDto {
        val availableCustomerId = CustomerData.getOrCreate(user = user).id!!
        return getContractorDtoForCreate(availableCustomerId, isOrganization)
    }

    fun getContractorDtoForCreate(customerId: UUID, isOrganization: Boolean = true, forUi: Boolean = true): ContractorDto {
        val name = if (forUi) RandomNameUtils.companyShortName(isIP = !isOrganization) else regexWord.random(20, 25)
        val innKio = if (isOrganization) RandomRequisites.generateInnForUl() else RandomRequisites.generateInnForIp()
        return ContractorDto(
            id = null,
            version = 0,
            customerId = customerId,
            name = name + AT_POSTFIX_RUS_PARENTHESES,
            kpp = RandomRequisites.generateKpp(),
            inn = innKio,
            description = regexWords.random(100, 150),
            isFavorites = false,
            payments = emptyList(),
            grounds = emptyList(),
            contacts = emptyList()
        )
    }

    fun getContractorDtoForUpdate(createdDto: ContractorDto): ContractorUpdateDto {
        return ContractorUpdateDto(
            createdDto.id, createdDto.version,
            name = "Updated ${createdDto.name}",
            kpp = RandomRequisites.generateKpp(),
            inn = RandomRequisites.generateInnForUl(),
            description = "updated ${createdDto.description}",
            payments = emptyList(),
            grounds = emptyList(),
            contacts = emptyList()
        )
    }

    fun getContractorUpdateInfoDtoOf(createdDto: ContractorDto): ContractorUpdateInfoDto {
        return ContractorUpdateInfoDto(
            createdDto.id, createdDto.version,
            name = "Upd.Info ${createdDto.name}",
            kpp = createdDto.kpp,
            inn = createdDto.inn,
            description = "updated info of ${createdDto.description}",
            isFavorites = createdDto.isFavorites
        )
    }

    /**
     * Create new entities for contractor:
     * * 1 ContractorPayment
     * * 1 (Contractor)Ground
     * * 1 ContractorContact
     *
     * and link them all to provided contractor
     */
    @Step("Создать новые payment, ground, contact для контрагента и подготовить dto для обновления с их учётом")
    fun getContractorDtoForUpdateWithNewPaymentGroundContact(createdDto: ContractorDto): ContractorUpdateDto {
        val relatedGround = GroundPrepareSteps.getGroundDtoForCreate(createdDto.customerId, createdDto.id!!)
        val relatedContact = ContractorContactPrepareSteps.getContractorContactDtoForCreate(createdDto.id!!)
        val relatedPayment = getContractorPaymentDtoForCreate(createdDto.id!!)

        return ContractorUpdateDto(
            createdDto.id, createdDto.version,
            name = "Updated ${createdDto.name}",
            kpp = RandomRequisites.generateKpp(),
            inn = RandomRequisites.generateInnForUl(),
            description = "updated ${createdDto.description}",
            grounds = listOf(relatedGround),
            contacts = listOf(relatedContact),
            payments = listOf(relatedPayment)
        )
    }

    /**
     * Delete Contractor and related entities:
     * * ContractorContact - all related to provided Contractor;
     * * ContractorPayment - all related to provided Contractor;
     * * (Contractor)Ground - all related to provided Contractor.
     *
     * @param contractorId  id of a contractor with related entities
     */
    @Step("Удалить контрагента [{contractorId}] и связанные с ним данные")
    fun deleteContractorAndRelatedEntities(contractorId: UUID, deleteAtOnly: Boolean = true) {
        val steps = ContractorSteps(almightyUser)
        val contractorFullDto = steps.getById(contractorId).data.getOrException()
        if (deleteAtOnly && !FindContractorBy.AT_CREATED.predicate(contractorFullDto.toModel()))
            throw RuntimeException("This is not a AT-created Contractor")

        contractorFullDto.contacts.forEach { ContractorContactSteps(almightyUser).delete(it.id!!) }
        contractorFullDto.grounds.forEach { GroundSteps(almightyUser).delete(it.id!!) }
        contractorFullDto.payments.forEach { ContractorPaymentSteps(almightyUser).delete(it.id!!) }

        steps.delete(contractorId)
    }

    fun getContractorPaymentOrCreate(
        contractor: Contractor,
        balanceAccount: BalanceAccount
    ): ContractorPayment {
        return ContractorPaymentData.getOrCreate(
            consumer = { ContractorPaymentData.searchBy(contractor).filter { balanceAccount.isAccountBelong(it.account) } },
            provider = {
                createContractorPaymentDto(
                    dtoForCreate = getContractorPaymentDtoForCreate(
                        contractorId = contractor.id!!,
                        isDefault = true,
                        balanceAccount = balanceAccount
                    )
                ).toModel()
            }
        )


    }

    @Step("Создать ${DictionaryNames.CONTRACTOR} для любой доступной организации пользователя {user.login}")
    fun createContractorDto(user: User = Users.client, isOrganization: Boolean = true): ContractorDto {
        val dtoForCreate = getContractorDtoForCreate(user, isOrganization)
        return createContractorDto(dtoForCreate)
    }

    @Step("Создать ${DictionaryNames.CONTRACTOR} для организации [{customerId}]")
    fun createContractorDto(customerId: UUID, isOrganization: Boolean = true): ContractorDto {
        val dtoForCreate = getContractorDtoForCreate(customerId, isOrganization)
        return createContractorDto(dtoForCreate)
    }

    fun createContractorDto(dtoForCreate: ContractorDto): ContractorDto {
        return ContractorSteps(almightyUser).create(dtoForCreate).data.getOrException()
    }
}