package ooo.jtc.api.dictionaries.customerrepresentative

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.customerrepresentative.FindCustomerRepresentativeBy
import ooo.jtc.uaa.User
import java.util.UUID

object CustomerRepresentativePrepareSteps {

    @Step("Удалить созданные автотестами данные CustomerRepresentative из БД")
    fun cleanAtCreated() {
        FindCustomerRepresentativeBy.AT_CREATED.get().forEach { clientRepres ->
            CustomerRepresentativeData.removeRecord?.let { it(clientRepres) }
        }
    }

    /**
     * Prepare CustomerRepresentativeDto
     * [bankUser] - user that will be creating prepared DTO.
     * CustomerRepresentative will be created for a random Customer, available to [bankUser].
     * [customerUser] - client user that will be used as a 'new' representative for [bankUser]'s Customer
     */
    fun getCustomerRepresentativeDtoForCreate(
        bankUser: User,
        customerUser: User = Users.client
    ): CustomerRepresentativeDto {
        customerUser.checkIsClientUser()
        val randomAvailableCustomerId = CustomerData.getOrCreate(
            consumer = { CustomerData.searchBy(bankUser) },
            provider = {
                CustomerPrepareSteps.createCustomerDto(customerUser = bankUser, withCustomerRepresentative = false).toModel()
            }).id!!
        return getCustomerRepresentativeDtoForCreate(customerUser.uaaUserId!!, randomAvailableCustomerId)
    }

    fun getCustomerRepresentativeDtoForCreate(uaaUserId: UUID, customerId: UUID, forUi: Boolean = true): CustomerRepresentativeDto {
        val position = if (forUi) "Тест-инженер" else regexWords.random(15, 20).trim()
        val descNumber = digits.random(10, 10)
        return CustomerRepresentativeDto(
            id = null,
            version = 0,
            customerId = customerId,
            userId = uaaUserId,
            position = position + AT_POSTFIX,
            email = RandomRequisites.generateEmail(),
            phone = RandomRequisites.generatePhoneNumber(),
            block = BlockingInfoDto(isBlock = false),
            description = "desc$descNumber$AT_POSTFIX"
        )
    }

    fun getCustomerRepresentativeDtoForUpdate(createdDto: CustomerRepresentativeDto): CustomerRepresentativeDto {
        return createdDto.copy(
            position = "updated ${createdDto.position}",
            email = "upd8d${createdDto.email}",
            phone = RandomRequisites.generatePhoneNumber()
        )
    }

    fun createCustomerRepresentative(uaaUserId: UUID, customerId: UUID): CustomerRepresentativeDto {
        val dtoForCreate = getCustomerRepresentativeDtoForCreate(uaaUserId, customerId)
        return createCustomerRepresentative(dtoForCreate)
    }

    @Step("Создать '${DictionaryNames.CUSTOMER_REPRESENTATIVE}'")
    fun createCustomerRepresentative(crDtoForCreate: CustomerRepresentativeDto): CustomerRepresentativeDto {
        val responseDto = CustomerRepresentativeSteps().create(crDtoForCreate)
        return responseDto.data
            .getOrException("Ошибка при создании связи Пользователя ${crDtoForCreate.userId} и Клиента ${crDtoForCreate.customerId}")
    }

    @Step("Создать заблокированный '${DictionaryNames.CUSTOMER_REPRESENTATIVE}'")
    fun createBlockedCustomerRepresentativeDto(crDtoForCreateAndBlock: CustomerRepresentativeDto): CustomerRepresentativeDto {
        val createdCrDto = createCustomerRepresentative(crDtoForCreateAndBlock)
        val blockingResponse = CustomerRepresentativeSteps().blockSingle(createdCrDto.id!!)
        return blockingResponse.list?.firstOrNull()
            .getOrException("Ошибка при блокировке связи Пользователя и Клиента [{${createdCrDto.id}]")
    }

    @Step("Найти id записей связей Представителей Клиента '{customerId}'")
    fun getCustomerRepresentativeIds(customerId: UUID): List<UUID?>? {
        val pageRequest = CustomerRepresentativeFilterParams.CUSTOMER_ID.eq(customerId).toPageRequest()
        return CustomerRepresentativeSteps().getPage(getPageRequest = pageRequest).page?.map { it.id }
    }
}