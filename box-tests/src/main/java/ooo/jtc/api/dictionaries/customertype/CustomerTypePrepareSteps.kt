package ooo.jtc.api.dictionaries.customertype

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.customertype.CustomerTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeData
import ooo.jtc.testdata.dictionaries.customertype.FindCustomerTypeBy

object CustomerTypePrepareSteps {

    @Step("Удалить созданные автотестами данные CustomerType из БД")
    fun cleanAtCreated() {
        FindCustomerTypeBy.AT_CREATED.get().forEach { type ->
            CustomerTypeData.removeRecord?.let { it(type) }
        }
    }

    fun getCustomerTypeDtoForCreate() =
        CustomerTypeDto(
            id = null,
            version = 0,
            name = regexWord.random(20, 50),            // up to 60 symbols, unique
            systemName = regexWord.random(5, 7) + AT_POSTFIX    // up to (100) symbols, unique
        )

    fun getCustomerTypeDtoForUpdate(createdDto: CustomerTypeDto) =
        CustomerTypeDto(
            createdDto.id, createdDto.version,
            name = "UPDATED ${createdDto.name}",
            systemName = "upd. ${createdDto.systemName}"
        )

    @Step("Найти в БД или создать сущность '${DictionaryNames.CUSTOMER_TYPE}'")
    fun getOrCreateCustomerTypeDto(
        getCondition: () -> CustomerTypeDto? = { CustomerTypeData.random()?.toDto() },
        dtoForCreate: CustomerTypeDto = getCustomerTypeDtoForCreate()
    ): CustomerTypeDto {
        return (getCondition.invoke() ?: createCustomerTypeDto(dtoForCreate)).attachToAllure()
    }

    @Step("Создать ${DictionaryNames.CUSTOMER_TYPE}")
    fun createCustomerTypeDto(dtoForCreate: CustomerTypeDto = getCustomerTypeDtoForCreate()): CustomerTypeDto {
        return CustomerTypeSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}