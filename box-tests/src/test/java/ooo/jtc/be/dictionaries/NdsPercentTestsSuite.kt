package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_NDSPERCENT
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentCreateTest
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentDeleteTest
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentFiltrationTest
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentGetPageTest
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentGetTest
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentSortingTest
import ooo.jtc.api.dictionaries.ndspercent.NdsPercentUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.ndspercent.NdsPercent
import ooo.jtc.dictionaries.ndspercent.NdsPercentDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentData
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentFilterParams
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentSortingParams.ID
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentSortingParams.IS_DEFAULT_RU_PAYMENT
import ooo.jtc.testdata.dictionaries.ndspercent.NdsPercentSortingParams.PERCENT
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
@Story(DictionaryNames.NDS_PERCENT)
@DisplayName("API '${DictionaryNames.NDS_PERCENT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_NDSPERCENT
@TestInstance(PER_CLASS)
class NdsPercentTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2228") annotation class T2228
@Tag("JTCSALTO-T2229") annotation class T2229
@Tag("JTCSALTO-T2230") annotation class T2230
@Tag("JTCSALTO-T2231") annotation class T2231
@Tag("JTCSALTO-T2232") annotation class T2232
@Tag("JTCSALTO-T2233") annotation class T2233
@Tag("JTCSALTO-T2234") annotation class T2234
@Tag("JTCSALTO-T2235") annotation class T2235
@Tag("JTCSALTO-T2236") annotation class T2236
@Tag("JTCSALTO-T2237") annotation class T2237
@Tag("JTCSALTO-T2238") annotation class T2238
@Tag("JTCSALTO-T2239") annotation class T2239
@Tag("JTCSALTO-T2240") annotation class T2240
@Tag("JTCSALTO-T2241") annotation class T2241
@Tag("JTCSALTO-T2242") annotation class T2242
@Tag("JTCSALTO-T2243") annotation class T2243
@Tag("JTCSALTO-T2244") annotation class T2244
@Tag("JTCSALTO-T2245") annotation class T2245
@Tag("JTCSALTO-T2246") annotation class T2246
@Tag("JTCSALTO-T2247") annotation class T2247
@Tag("JTCSALTO-T2248") annotation class T2248
@Tag("JTCSALTO-T2249") annotation class T2249
@Tag("JTCSALTO-T2250") annotation class T2250
@Tag("JTCSALTO-T2251") annotation class T2251
@Tag("JTCSALTO-T2252") annotation class T2252
//@formatter:on
//endregion

    private lateinit var dataForFilter: NdsPercentDto
    private lateinit var testDataScope: TestDataScope<NdsPercent>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = NdsPercentData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2234 //'Ставка НДС'. CRUD: Создаем запись от пользователя [BANK]
    @T2235 //'Ставка НДС'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2236 //'Ставка НДС'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2237 //'Ставка НДС'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2238 //'Ставка НДС'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2239 //'Ставка НДС'. CRUD: Удаляем запись от пользователя [BANK]
    @T2240 //'Ставка НДС'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun ndsPercentCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                NdsPercentCreateTest().withId(T2234::class),
                NdsPercentGetTest(user = Users.client).withId(T2235::class),
                NdsPercentGetTest(user = Users.bankAdmin).withId(T2236::class),
                NdsPercentGetPageTest(user = Users.client).withId(T2237::class),
                NdsPercentGetPageTest(user = Users.bankAdmin).withId(T2238::class),
                NdsPercentDeleteTest().withId(T2239::class),
                NdsPercentUpdateTest().withId(T2240::class)
            )
        )
    }

    @TestFactory
    @T2228 //'Ставка НДС'. Сортировка по полю 'id, ASC' [BANK]
    @T2229 //'Ставка НДС'. Сортировка по полю 'percent, ASC' [BANK]
    @T2230 //'Ставка НДС'. Сортировка по полю 'isDefaultRuPayment, ASC' [BANK]
    @T2231 //'Ставка НДС'. Сортировка по полю 'id, DESC' [BANK]
    @T2232 //'Ставка НДС'. Сортировка по полю 'percent, DESC' [BANK]
    @T2233 //'Ставка НДС'. Сортировка по полю 'isDefaultRuPayment, DESC' [BANK]
    internal fun ndsPercentSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                NdsPercentSortingTest(user, ID::asc).withId(T2228::class),
                NdsPercentSortingTest(user, PERCENT::asc).withId(T2229::class),
                NdsPercentSortingTest(user, IS_DEFAULT_RU_PAYMENT::asc).withId(T2230::class),

                NdsPercentSortingTest(user, ID::desc).withId(T2231::class),
                NdsPercentSortingTest(user, PERCENT::desc).withId(T2232::class),
                NdsPercentSortingTest(user, IS_DEFAULT_RU_PAYMENT::desc).withId(T2233::class)
            )
        )
    }

    @TestFactory
    @T2247 //'Ставка НДС'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2248 //'Ставка НДС'. Сортировка по полю 'percent, ASC' [CLIENT]
    @T2249 //'Ставка НДС'. Сортировка по полю 'isDefaultRuPayment, ASC' [CLIENT]
    @T2250 //'Ставка НДС'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2251 //'Ставка НДС'. Сортировка по полю 'percent, DESC' [CLIENT]
    @T2252 //'Ставка НДС'. Сортировка по полю 'isDefaultRuPayment, DESC' [CLIENT]
    internal fun ndsPercentSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                NdsPercentSortingTest(user, ID::asc).withId(T2247::class),
                NdsPercentSortingTest(user, PERCENT::asc).withId(T2248::class),
                NdsPercentSortingTest(user, IS_DEFAULT_RU_PAYMENT::asc).withId(T2249::class),

                NdsPercentSortingTest(user, ID::desc).withId(T2250::class),
                NdsPercentSortingTest(user, PERCENT::desc).withId(T2251::class),
                NdsPercentSortingTest(user, IS_DEFAULT_RU_PAYMENT::desc).withId(T2252::class)

            )
        )
    }

    @TestFactory
    @T2241 //'Ставка НДС'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2242 //'Ставка НДС'. Фильтрация по полю 'percent' (eq) [CLIENT]
    @T2243 //'Ставка НДС'. Фильтрация по полю 'isDefaultRuPayment' (eq) [CLIENT]
    internal fun ndsPercentFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                NdsPercentFiltrationTest("id equals", user, { dataForFilter },
                    { NdsPercentFilterParams.ID.eq(it!!.id!!) }).withId(T2241::class),
                NdsPercentFiltrationTest("percent equals", user, { dataForFilter },
                    { NdsPercentFilterParams.PERCENT.eq(it!!.percent) }).withId(T2242::class),
                NdsPercentFiltrationTest("isDefaulRuPayment equals", user, { dataForFilter },
                    { NdsPercentFilterParams.IS_DEFAULT_RU_PAYMENT.eq(it!!.isDefaultRuPayment) }).withId(T2243::class)
            )
        )
    }

    @TestFactory
    @T2244 //'Ставка НДС'. Фильтрация по полю 'id' (eq) [BANK]
    @T2245 //'Ставка НДС'. Фильтрация по полю 'percent' (eq) [BANK]
    @T2246 //'Ставка НДС'. Фильтрация по полю 'isDefaultRuPayment' (eq) [BANK]
    internal fun ndsPercentFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                NdsPercentFiltrationTest("id equals", user, { dataForFilter },
                    { NdsPercentFilterParams.ID.eq(it!!.id!!) }).withId(T2244::class),
                NdsPercentFiltrationTest("percent equals", user, { dataForFilter },
                    { NdsPercentFilterParams.PERCENT.eq(it!!.percent) }).withId(T2245::class),
                NdsPercentFiltrationTest("isDefaulRuPayment equals", user, { dataForFilter },
                    { NdsPercentFilterParams.IS_DEFAULT_RU_PAYMENT.eq(it!!.isDefaultRuPayment) }).withId(T2246::class)
            )
        )
    }
}