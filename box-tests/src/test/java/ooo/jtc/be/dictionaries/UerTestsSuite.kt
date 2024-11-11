package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_UER
import ooo.jtc.api.dictionaries.uer.UerCreateTest
import ooo.jtc.api.dictionaries.uer.UerDeleteTest
import ooo.jtc.api.dictionaries.uer.UerFiltrationTest
import ooo.jtc.api.dictionaries.uer.UerGetPageTest
import ooo.jtc.api.dictionaries.uer.UerGetTest
import ooo.jtc.api.dictionaries.uer.UerOtherTest
import ooo.jtc.api.dictionaries.uer.UerSortingTest
import ooo.jtc.api.dictionaries.uer.UerSteps
import ooo.jtc.api.dictionaries.uer.UerUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.bankru.BankRu
import ooo.jtc.dictionaries.uer.Uer
import ooo.jtc.dictionaries.uer.UerDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.bankru.BankRuData
import ooo.jtc.testdata.dictionaries.uer.UerData
import ooo.jtc.testdata.dictionaries.uer.UerFilterParams
import ooo.jtc.testdata.dictionaries.uer.UerSortingParams.BANK_TYPE
import ooo.jtc.testdata.dictionaries.uer.UerSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.uer.UerSortingParams.ID
import ooo.jtc.testdata.dictionaries.uer.UerSortingParams.UER
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.UER)
@DisplayName("API '${DictionaryNames.UER}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_UER
@TestInstance(PER_CLASS)
class UerTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2135") annotation class T2135
@Tag("JTCSALTO-T2136") annotation class T2136
@Tag("JTCSALTO-T2137") annotation class T2137
@Tag("JTCSALTO-T2138") annotation class T2138
@Tag("JTCSALTO-T2139") annotation class T2139
@Tag("JTCSALTO-T2140") annotation class T2140
@Tag("JTCSALTO-T2141") annotation class T2141
@Tag("JTCSALTO-T2142") annotation class T2142
@Tag("JTCSALTO-T2143") annotation class T2143
@Tag("JTCSALTO-T2144") annotation class T2144
@Tag("JTCSALTO-T2145") annotation class T2145
@Tag("JTCSALTO-T2146") annotation class T2146
@Tag("JTCSALTO-T2147") annotation class T2147
@Tag("JTCSALTO-T2148") annotation class T2148
@Tag("JTCSALTO-T2149") annotation class T2149
@Tag("JTCSALTO-T2150") annotation class T2150
@Tag("JTCSALTO-T2151") annotation class T2151
@Tag("JTCSALTO-T2152") annotation class T2152
@Tag("JTCSALTO-T2153") annotation class T2153
@Tag("JTCSALTO-T2154") annotation class T2154
@Tag("JTCSALTO-T2155") annotation class T2155
@Tag("JTCSALTO-T2156") annotation class T2156
@Tag("JTCSALTO-T2157") annotation class T2157
@Tag("JTCSALTO-T2158") annotation class T2158
@Tag("JTCSALTO-T2159") annotation class T2159
@Tag("JTCSALTO-T2160") annotation class T2160
@Tag("JTCSALTO-T2161") annotation class T2161
@Tag("JTCSALTO-T2162") annotation class T2162
@Tag("JTCSALTO-T2163") annotation class T2163
@Tag("JTCSALTO-T2164") annotation class T2164
@Tag("JTCSALTO-T2165") annotation class T2165
@Tag("JTCSALTO-T2166") annotation class T2166
@Tag("JTCSALTO-T2167") annotation class T2167
@Tag("JTCSALTO-T2168") annotation class T2168
@Tag("JTCSALTO-T2169") annotation class T2169
//@formatter:on
//endregion

    private lateinit var dataForFilter: UerDto
    private lateinit var testDataScope: TestDataScope<Uer>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = UerData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2150 //'Участие в электронных расчетах'. CRUD: Создаем запись от пользователя [BANK]
    @T2154 //'Участие в электронных расчетах'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2158 //'Участие в электронных расчетах'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2162 //'Участие в электронных расчетах'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2136 //'Участие в электронных расчетах'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2142 //'Участие в электронных расчетах'. CRUD: Удаляем запись от пользователя [BANK]
    @T2143 //'Участие в электронных расчетах'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun uerCrudTests(): List<DynamicTest> {
        val tests = listOf(
            UerCreateTest().withId(T2150::class),
            UerGetTest(user = client).withId(T2154::class),
            UerGetTest(user = bankAdmin).withId(T2158::class),
            UerGetPageTest(user = client).withId(T2162::class),
            UerGetPageTest(user = bankAdmin).withId(T2136::class),
            UerDeleteTest().withId(T2142::class),
            UerUpdateTest().withId(T2143::class)
        )

        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2152 //'Участие в электронных расчетах'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2155 //'Участие в электронных расчетах'. Сортировка по полю 'uer, ASC' [CLIENT]
    @T2159 //'Участие в электронных расчетах'. Сортировка по полю 'bankType, ASC' [CLIENT]
    @T2164 //'Участие в электронных расчетах'. Сортировка по полю 'description, ASC' [CLIENT]

    @T2135 //'Участие в электронных расчетах'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2141 //'Участие в электронных расчетах'. Сортировка по полю 'uer, DESC' [CLIENT]
    @T2145 //'Участие в электронных расчетах'. Сортировка по полю 'bankType, DESC' [CLIENT]
    @T2148 //'Участие в электронных расчетах'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun uerSortingClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                UerSortingTest(user, ID::asc).withId(T2152::class),
                UerSortingTest(user, UER::asc).withId(T2155::class),
                UerSortingTest(user, BANK_TYPE::asc).withId(T2159::class),
                UerSortingTest(user, DESCRIPTION::asc).withId(T2164::class),

                UerSortingTest(user, ID::desc).withId(T2135::class),
                UerSortingTest(user, UER::desc).withId(T2141::class),
                UerSortingTest(user, BANK_TYPE::desc).withId(T2145::class),
                UerSortingTest(user, DESCRIPTION::desc).withId(T2148::class)
            )
        )
    }

    @TestFactory
    @T2165 //'Участие в электронных расчетах'. Сортировка по полю 'id, ASC' [BANK]
    @T2166 //'Участие в электронных расчетах'. Сортировка по полю 'uer, ASC' [BANK]
    @T2169 //'Участие в электронных расчетах'. Сортировка по полю 'bankType, ASC' [BANK]
    @T2168 //'Участие в электронных расчетах'. Сортировка по полю 'description, ASC' [BANK]

    @T2156 //'Участие в электронных расчетах'. Сортировка по полю 'id, DESC' [BANK]
    @T2161 //'Участие в электронных расчетах'. Сортировка по полю 'uer, DESC' [BANK]
    @T2167 //'Участие в электронных расчетах'. Сортировка по полю 'bankType, DESC' [BANK]
    @T2163 //'Участие в электронных расчетах'. Сортировка по полю 'description, DESC' [BANK]
    internal fun uerSortingBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                UerSortingTest(user, ID::asc).withId(T2165::class),
                UerSortingTest(user, UER::asc).withId(T2166::class),
                UerSortingTest(user, BANK_TYPE::asc).withId(T2169::class),
                UerSortingTest(user, DESCRIPTION::asc).withId(T2168::class),

                UerSortingTest(user, ID::desc).withId(T2156::class),
                UerSortingTest(user, UER::desc).withId(T2161::class),
                UerSortingTest(user, BANK_TYPE::desc).withId(T2167::class),
                UerSortingTest(user, DESCRIPTION::desc).withId(T2163::class)
            )
        )
    }

    @TestFactory
    @T2139 //'Участие в электронных расчетах'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2144 //'Участие в электронных расчетах'. Фильтрация по полю 'uer' (eq) [CLIENT]
    @T2149 //'Участие в электронных расчетах'. Фильтрация по полю 'bankType' (eq) [CLIENT]
    @T2151 //'Участие в электронных расчетах'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T2137 //'Участие в электронных расчетах'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun uerFiltrationClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                UerFiltrationTest("id equals", user, { dataForFilter },
                    { UerFilterParams.ID.eq(it!!.id!!) }).withId(T2139::class),
                UerFiltrationTest("uer equals", user, { dataForFilter },
                    { UerFilterParams.UER.eq(it!!.uer) }).withId(T2144::class),
                UerFiltrationTest("bankType equals", user, { dataForFilter },
                    { UerFilterParams.BANK_TYPE.eq(it!!.bankType) }).withId(T2149::class),
                UerFiltrationTest("description equals", user, { dataForFilter },
                    { UerFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T2151::class),
                UerFiltrationTest("description contains", user, { dataForFilter },
                    { UerFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T2137::class)
            )
        )
    }

    @TestFactory
    @T2153 //'Участие в электронных расчетах'. Фильтрация по полю 'id' (eq) [BANK]
    @T2157 //'Участие в электронных расчетах'. Фильтрация по полю 'uer' (eq) [BANK]
    @T2160 //'Участие в электронных расчетах'. Фильтрация по полю 'bankType' (eq) [BANK]
    @T2146 //'Участие в электронных расчетах'. Фильтрация по полю 'description' (eq) [BANK]
    @T2147 //'Участие в электронных расчетах'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun uerFiltrationBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                UerFiltrationTest("id equals", user, { dataForFilter },
                    { UerFilterParams.ID.eq(it!!.id!!) }).withId(T2153::class),
                UerFiltrationTest("uer equals", user, { dataForFilter },
                    { UerFilterParams.UER.eq(it!!.uer) }).withId(T2157::class),
                UerFiltrationTest("bankType equals", user, { dataForFilter },
                    { UerFilterParams.BANK_TYPE.eq(it!!.bankType) }).withId(T2160::class),
                UerFiltrationTest("description equals", user, { dataForFilter },
                    { UerFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T2146::class),
                UerFiltrationTest("description contains", user, { dataForFilter },
                    { UerFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T2147::class)
            )
        )
    }


    private fun getUerByBicTest(user: User, bankRu: BankRu) {
        val bic = bankRu.bic
        val expUerId = bankRu.idUer
        val response = UerSteps(user).getUerByBankRuBic(bic)

        "Проверить, что id УЭР'а в ответе соответствует ожидаемому" {
            assertThat("Ответ пуст", response.list, Matchers.not(Matchers.empty()))
            assertThat("В ответе более одной записи", response.list!!.size, Matchers.equalTo(1))
            assertThat("Вернулся УЭР с id, отличным от ожидаемого", response.list!![0].id!!, Matchers.equalTo(expUerId))
        }
    }

    @TestFactory
    @T2138 //'Участие в электронных расчетах'. Получение пользователем типа УЭР по БИКу банка РФ [CLIENT]
    @T2140 //'Участие в электронных расчетах'. Получение пользователем типа УЭР по БИКу банка РФ [BANK]
    internal fun uerGetByBicTests(): List<DynamicTest> {
        val testName = "'${DictionaryNames.UER}'. Получение пользователем типа УЭР по БИКу банка РФ"
        val bankRuClient = BankRuData.randomOrException()
        val bankRuBank = BankRuData.randomOrException()
        val clientUser = client
        val adminUser = bankAdmin
        val tests = listOf(
            UerOtherTest(
                name = "$testName [${clientUser.userType}]",
                params = { mapOf(PARAM_USER to clientUser, "Банк" to bankRuClient) },
                testBody = { getUerByBicTest(clientUser, bankRuClient) }
            ).withId(T2138::class),
            UerOtherTest(
                name = "$testName [${adminUser.userType}]",
                params = { mapOf(PARAM_USER to adminUser, "Банк" to bankRuBank) },
                testBody = { getUerByBicTest(adminUser, bankRuBank) }
            ).withId(T2140::class)
        )
        return EntityTestGenerator.generate(tests)
    }
}