package ooo.jtc.api.dictionaries.customerkpp

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestConstants.AT_NUM
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppData
import ooo.jtc.testdata.dictionaries.customerkpp.FindCustomerKppBy
import ooo.jtc.uaa.User
import java.util.*

object CustomerKppPrepareSteps {

    @Step("Удалить созданные автотестами данные CustomerKpp из БД")
    fun cleanAtCreated() {
        FindCustomerKppBy.AT_CREATED.get().forEach { kpp ->
            CustomerKppData.removeRecord?.let { it(kpp) }
        }
    }
    //todo Khatmullin [2021.07.05] refactor
    fun getCustomerKppDtoForCreate(customerRelatedUser: User): CustomerKppDto {
        return getCustomerKppDtoForCreate()
    }

    fun getCustomerKppDtoForCreate(): CustomerKppDto {
        return CustomerKppDto(
            id = null,
            version = 0,
            unitName = TestConstants.AT_PREFIX + UUID.randomUUID().toString(),
            kpp = "${digits.random(4, 4)}$AT_NUM", // up to 9 symbols (digits only)
            isDefault = false
        )
    }

    fun getCustomerKppDtoForUpdate(createdDto: CustomerKppDto): CustomerKppDto {
        return CustomerKppDto(
            createdDto.id, createdDto.version,
            unitName = createdDto.unitName,
            kpp = "${digits.random(4, 4)}$AT_NUM",
            isDefault = createdDto.isDefault
        )
    }

    @Step("Создать ${DictionaryNames.CUSTOMER_KPP} для любой организации, доступной {customerRelatedUser.login}")
    fun createCustomerKppDto(customerRelatedUser: User): CustomerKppDto {
        val dtoForCreate = getCustomerKppDtoForCreate(customerRelatedUser)
        return createCustomerKppDto(dtoForCreate)
    }

    @Step("Создать ${DictionaryNames.CUSTOMER_KPP} для организации [{customerId}]")
    fun createCustomerKppDto(customerId: UUID): CustomerKppDto {
        val dtoForCreate = getCustomerKppDtoForCreate()
        return createCustomerKppDto(dtoForCreate)
    }

    fun createCustomerKppDto(dtoForCreate: CustomerKppDto): CustomerKppDto {
        return CustomerKppSteps(Users.superUser).create(dtoForCreate).data.getOrException()
    }
}