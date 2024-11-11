package ooo.jtc.api.dictionaries.gozcontract

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.gozcontract.GozContractDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import java.time.LocalDate

object GozContractPrepareSteps {

    fun getGozContractDtoForCreate(): GozContractDto {
        val date = LocalDate.now()
        return GozContractDto(
            id = null,
            version = 0,
            number = regexWord.random(length = 50, prefix = "Goz Contract / ", postfix = TestConstants.AT_POSTFIX),
            date = date,
            identity = regexWord.random(length = 50),
            contractNumber = regexWord.random(length = 50),
            contractDate = date
        )
    }

    @Step("Создать ${DictionaryNames.GOZ_CONTRACT}")
    fun createGozContractDto(dto: GozContractDto = getGozContractDtoForCreate()): GozContractDto {
        return GozContractSteps(Users.bankAdmin).create(dto).data.getOrException()
    }
}