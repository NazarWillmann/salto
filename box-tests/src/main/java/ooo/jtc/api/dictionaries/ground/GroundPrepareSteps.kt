package ooo.jtc.api.dictionaries.ground

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.core.RegexpConst
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.ground.GroundDto
import ooo.jtc.dictionaries.ground.GroundUpdateRequest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.ground.FindGroundBy
import ooo.jtc.testdata.dictionaries.ground.GroundData
import ooo.jtc.uaa.User
import java.util.*

object GroundPrepareSteps {

    @Step("Удалить созданные автотестами данные Ground из БД")
    fun cleanAtCreated() {
        FindGroundBy.AT_CREATED.get().forEach { grnd ->
            GroundData.removeRecord?.let { it(grnd) }
        }
    }

    /**
     * Prepares GroundDto for random [user]-related Customer
     *
     * @param user          - user that will have access to prepared GroundDto after creation (through available Customer)
     * @param forContractor - boolean flag; set as [false] if you need a GroundDto related directly to [user]-related Customer
     */
    fun getGroundDtoForCreate(
        user: User,
        forContractor: Boolean = true
    ): GroundDto {
        return if (forContractor) {
            val contractor = ContractorData.getOrCreate(
                consumer = { ContractorData.searchBy(user) },
                provider = { ContractorPrepareSteps.createContractorDto(user).toModel() }
            )
            getGroundDtoForCreate(contractor.customerId, contractor.id!!)
        } else {
            val customer = CustomerData.getOrCreate(user)
            getGroundDtoForCreate(customer.id!!, null)
        }
    }

    /**
     * Prepares GroundDto for specified [customerId] and specified [contractorId]
     *
     * @param customerId   - id of a customer to which prepared GroundDto will be related after creation
     * @param contractorId - id of a contractor to which prepared GroundDto will be related after creation;
     *                       Set as [null] if you need a GroundDto related directly to Customer
     */
    @Step("Подготовить тестовое DTO для создания ${DictionaryNames.GROUND} ")
    fun getGroundDtoForCreate(customerId: UUID, contractorId: UUID? = null): GroundDto {
        return GroundDto(
            id = null,
            version = 0,
            customerId = customerId,
            contractorId = contractorId,
            description = RandomData(RegexpConst.LAT_RUS_NUM).random(30, 185) + AT_POSTFIX
        )
    }

    @Step("Подготовить тестовое DTO для обновления ${DictionaryNames.GROUND} ")
    fun getDtoForUpdate(createdDto: GroundDto) =
        GroundUpdateRequest(
            id = createdDto.id,
            version = createdDto.version,
            description = "(updated desc) ${createdDto.description}"
        )

    @Step("Создать ${DictionaryNames.GROUND} для любой доступной организации пользователя {user.login}; 'для контрагента' = {forContractor}")
    fun createGroundDto(user: User, forContractor: Boolean = true): GroundDto {
        val dtoForCreate = getGroundDtoForCreate(user, forContractor)
        return createGroundDto(dtoForCreate)
    }

    @Step("Создать ${DictionaryNames.GROUND} для организации [{customerId}] и контрагента [{contractorId}]")
    fun createGroundDto(customerId: UUID, contractorId: UUID?): GroundDto {
        val dtoForCreate = getGroundDtoForCreate(customerId, contractorId)
        return createGroundDto(dtoForCreate)
    }

    fun createGroundDto(dtoForCreate: GroundDto): GroundDto {
        return GroundSteps(Users.superUser).create(dtoForCreate).data.getOrException()
    }
}