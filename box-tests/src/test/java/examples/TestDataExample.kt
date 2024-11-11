import io.qameta.allure.junit5.AllureJunit5
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCode
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeMapper
import ooo.jtc.extensions.asserts.assertEq
import ooo.jtc.testdata.common.random
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeData
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.uaa.user.FindStoredUserBy
import ooo.jtc.testdata.uaa.user.StoredUserData
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mapstruct.factory.Mappers

@Suppress("UNUSED_VARIABLE")
@ExtendWith(AllureJunit5::class)
class TestDataExample {

    @Test
    fun testTestData() {
        val database = StoredUserData.get().first()
        println(database)
    }


    @Test
    fun bankClientUserSearchByTest() {
        val clientUser = FindStoredUserBy.CLIENT_USER.random()
        clientUser.login.assertEq("client")
        val bankUser = FindStoredUserBy.BANK_OPERATOR_USER.random()
        bankUser.login.assertEq("admin")
    }

    @Test
    fun loadCountryTest() {
        val fromDatabase = CountryData.get()
        println(fromDatabase.size)
    }

    @Test
    fun toDtoMapperTest() {
        val budgetReasonCode1 = BudgetReasonCodeData.randomOrException()
        val explicitMapper = Mappers.getMapper(BudgetReasonCodeMapper::class.java)
        val budgetReasonCodeDto1 = explicitMapper.toDto(budgetReasonCode1)
        checkBudgetReasonCodeMappings(budgetReasonCodeDto1, budgetReasonCode1)

        val budgetReasonCode2 = BudgetReasonCodeData.randomOrException()
        val lazyMapper = ooo.jtc.generic.Mappers.budgetReasonCodeMapper
        val budgetReasonCodeDto2 = lazyMapper.toDto(budgetReasonCode2)
        checkBudgetReasonCodeMappings(budgetReasonCodeDto2, budgetReasonCode2)

        val budgetReasonCode3 = BudgetReasonCodeData.randomOrException()
        val budgetReasonCodeDto3 = budgetReasonCode3.toDto()
        checkBudgetReasonCodeMappings(budgetReasonCodeDto3, budgetReasonCode3)
    }

    private fun checkBudgetReasonCodeMappings(budgetReasonCodeDto: BudgetReasonCodeDto, budgetReasonCode: BudgetReasonCode) {
        MatcherAssert.assertThat(budgetReasonCodeDto, Matchers.notNullValue())
        MatcherAssert.assertThat(budgetReasonCodeDto.code, Matchers.equalTo(budgetReasonCode.code))
        MatcherAssert.assertThat(budgetReasonCodeDto.description, Matchers.equalTo(budgetReasonCode.description))
        MatcherAssert.assertThat(budgetReasonCodeDto.payType, Matchers.equalTo(budgetReasonCode.payType))
        MatcherAssert.assertThat(budgetReasonCodeDto.version, Matchers.equalTo(budgetReasonCode.version))
    }
}