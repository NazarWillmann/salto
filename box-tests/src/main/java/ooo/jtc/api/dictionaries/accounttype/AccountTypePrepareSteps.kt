package ooo.jtc.api.dictionaries.accounttype

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT
import ooo.jtc.dictionaries.accountype.AccountTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeData
import ooo.jtc.testdata.dictionaries.accounttype.FindAccountTypeBy
import kotlin.random.Random

object AccountTypePrepareSteps {

    @Step("Удалить созданные автотестами данные AccountType из БД")
    fun cleanAtCreated() {
        FindAccountTypeBy.AT_CREATED.get().forEach { accType ->
            AccountTypeData.removeRecord?.let { it(accType) }
        }
    }

    fun getAccountTypeDtoForCreate(): AccountTypeDto {
        val randNum = Random.nextInt(10000, 99999).toString()
        return AccountTypeDto(
            id = null,
            version = 0,
            fullName = "New Test Account Type / $randNum",
            shortName = "NTAT / $randNum",
            description = "Not-a-unique description",
            systemName = "TESTACCOUNTTYPESHBE30CH$randNum$AT",
            clientType = clientType.values().random().toString()
        )
    }

    fun getAccountTypeDtoForUpdate(createdDto: AccountTypeDto): AccountTypeDto {
        return createdDto.copy(
            fullName = "Updated ${createdDto.fullName}",
            shortName = "U ${createdDto.shortName}",
            description = "(updated) ${createdDto.description}"
        )
    }

    @Step("Создать ${DictionaryNames.CURRENCY}")
    fun createAccountTypeDto(dtoForCreate: AccountTypeDto = getAccountTypeDtoForCreate()): AccountTypeDto {
        return AccountTypeSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }

    enum class clientType {
        LEGAL, INDIVIDUAL
    }
}