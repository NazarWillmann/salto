package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_NDSCALCULATION
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationCreateTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationDeleteTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationFiltrationTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationGetPageTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationGetTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationSortingTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationUpdateTest
import ooo.jtc.api.dictionaries.ndscalculation.NdsCalculationValidSymbolsTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.ndscalculation.NdsCalculation
import ooo.jtc.dictionaries.ndscalculation.NdsCalculationDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationData
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationFilterParams
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationSortingParams.CODE
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationSortingParams.ID
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationSortingParams.IS_DEFAULT_RU_PAYMENT
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationSortingParams.TEMPLATE
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
@Story(DictionaryNames.NDS_CALCULATION)
@DisplayName("API '${DictionaryNames.NDS_CALCULATION}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_NDSCALCULATION
@TestInstance(PER_CLASS)
class NdsCalculationTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2253") annotation class T2253
@Tag("JTCSALTO-T2254") annotation class T2254
@Tag("JTCSALTO-T2255") annotation class T2255
@Tag("JTCSALTO-T2256") annotation class T2256
@Tag("JTCSALTO-T2257") annotation class T2257
@Tag("JTCSALTO-T2258") annotation class T2258
@Tag("JTCSALTO-T2259") annotation class T2259
@Tag("JTCSALTO-T2260") annotation class T2260
@Tag("JTCSALTO-T2261") annotation class T2261
@Tag("JTCSALTO-T2262") annotation class T2262
@Tag("JTCSALTO-T2263") annotation class T2263
@Tag("JTCSALTO-T2264") annotation class T2264
@Tag("JTCSALTO-T2265") annotation class T2265
@Tag("JTCSALTO-T2266") annotation class T2266
@Tag("JTCSALTO-T2267") annotation class T2267
@Tag("JTCSALTO-T2268") annotation class T2268
@Tag("JTCSALTO-T2269") annotation class T2269
@Tag("JTCSALTO-T2270") annotation class T2270
@Tag("JTCSALTO-T2271") annotation class T2271
@Tag("JTCSALTO-T2272") annotation class T2272
@Tag("JTCSALTO-T2273") annotation class T2273
@Tag("JTCSALTO-T2274") annotation class T2274
@Tag("JTCSALTO-T2275") annotation class T2275
@Tag("JTCSALTO-T2276") annotation class T2276
@Tag("JTCSALTO-T2277") annotation class T2277
@Tag("JTCSALTO-T2278") annotation class T2278
@Tag("JTCSALTO-T2279") annotation class T2279
@Tag("JTCSALTO-T2280") annotation class T2280
@Tag("JTCSALTO-T2281") annotation class T2281
@Tag("JTCSALTO-T2282") annotation class T2282
@Tag("JTCSALTO-T2283") annotation class T2283
@Tag("JTCSALTO-T2284") annotation class T2284
@Tag("JTCSALTO-T2285") annotation class T2285
@Tag("JTCSALTO-T2286") annotation class T2286
@Tag("JTCSALTO-T2287") annotation class T2287
@Tag("JTCSALTO-T2288") annotation class T2288
@Tag("JTCSALTO-T2289") annotation class T2289
@Tag("JTCSALTO-T2290") annotation class T2290
@Tag("JTCSALTO-T2291") annotation class T2291
@Tag("JTCSALTO-T2292") annotation class T2292
@Tag("JTCSALTO-T2293") annotation class T2293
@Tag("JTCSALTO-T2294") annotation class T2294
//@formatter:on
//endregion

    private lateinit var dataForFilter: NdsCalculationDto
    private lateinit var testDataScope: TestDataScope<NdsCalculation>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = NdsCalculationData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2264 //'Способ расчета НДС'. CRUD: Создаем запись от пользователя [BANK]
    @T2265 //'Способ расчета НДС'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2266 //'Способ расчета НДС'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2267 //'Способ расчета НДС'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2268 //'Способ расчета НДС'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2269 //'Способ расчета НДС'. CRUD: Удаляем запись от пользователя [BANK]
    @T2270 //'Способ расчета НДС'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun ndsCalculationCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                NdsCalculationCreateTest().withId(T2264::class),
                NdsCalculationGetTest(user = Users.client).withId(T2265::class),
                NdsCalculationGetTest(user = bankAdmin).withId(T2266::class),
                NdsCalculationGetPageTest(user = Users.client).withId(T2267::class),
                NdsCalculationGetPageTest(user = bankAdmin).withId(T2268::class),
                NdsCalculationDeleteTest().withId(T2269::class),
                NdsCalculationUpdateTest().withId(T2270::class)
            )
        )
    }

    @TestFactory
    @T2271 //'Способ расчета НДС'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2272 //'Способ расчета НДС'. Сортировка по полю 'code, ASC' [CLIENT]
    @T2273 //'Способ расчета НДС'. Сортировка по полю 'template, ASC' [CLIENT]
    @T2274 //'Способ расчета НДС'. Сортировка по полю 'description, ASC' [CLIENT]
    @T2275 //'Способ расчета НДС'. Сортировка по полю 'isDefaultRuPayment, ASC' [CLIENT]
    @T2276 //'Способ расчета НДС'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2277 //'Способ расчета НДС'. Сортировка по полю 'code, DESC' [CLIENT]
    @T2278 //'Способ расчета НДС'. Сортировка по полю 'template, DESC' [CLIENT]
    @T2279 //'Способ расчета НДС'. Сортировка по полю 'description, DESC' [CLIENT]
    @T2280 //'Способ расчета НДС'. Сортировка по полю 'isDefaultRuPayment, DESC' [CLIENT]
    internal fun ndsCalculationSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                NdsCalculationSortingTest(user, ID::asc).withId(T2271::class),
                NdsCalculationSortingTest(user, CODE::asc).withId(T2272::class),
                NdsCalculationSortingTest(user, TEMPLATE::asc).withId(T2273::class),
                NdsCalculationSortingTest(user, DESCRIPTION::asc).withId(T2274::class),
                NdsCalculationSortingTest(user, IS_DEFAULT_RU_PAYMENT::asc).withId(T2275::class),

                NdsCalculationSortingTest(user, ID::desc).withId(T2276::class),
                NdsCalculationSortingTest(user, CODE::desc).withId(T2277::class),
                NdsCalculationSortingTest(user, TEMPLATE::desc).withId(T2278::class),
                NdsCalculationSortingTest(user, DESCRIPTION::desc).withId(T2279::class),
                NdsCalculationSortingTest(user, IS_DEFAULT_RU_PAYMENT::desc).withId(T2280::class)
            )
        )
    }

    @TestFactory
    @T2253 //'Способ расчета НДС'. Сортировка по полю 'id, ASC' [BANK]
    @T2254 //'Способ расчета НДС'. Сортировка по полю 'code, ASC' [BANK]
    @T2255 //'Способ расчета НДС'. Сортировка по полю 'template, ASC' [BANK]
    @T2256 //'Способ расчета НДС'. Сортировка по полю 'description, ASC' [BANK]
    @T2257 //'Способ расчета НДС'. Сортировка по полю 'isDefaultRuPayment, ASC' [BANK]
    @T2258 //'Способ расчета НДС'. Сортировка по полю 'id, DESC' [BANK]
    @T2259 //'Способ расчета НДС'. Сортировка по полю 'code, DESC' [BANK]
    @T2260 //'Способ расчета НДС'. Сортировка по полю 'template, DESC' [BANK]
    @T2261 //'Способ расчета НДС'. Сортировка по полю 'description, DESC' [BANK]
    @T2262 //'Способ расчета НДС'. Сортировка по полю 'isDefaultRuPayment, DESC' [BANK]
    internal fun ndsCalculationSortingBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                NdsCalculationSortingTest(user, ID::asc).withId(T2253::class),
                NdsCalculationSortingTest(user, CODE::asc).withId(T2254::class),
                NdsCalculationSortingTest(user, TEMPLATE::asc).withId(T2255::class),
                NdsCalculationSortingTest(user, DESCRIPTION::asc).withId(T2256::class),
                NdsCalculationSortingTest(user, IS_DEFAULT_RU_PAYMENT::asc).withId(T2257::class),

                NdsCalculationSortingTest(user, ID::desc).withId(T2258::class),
                NdsCalculationSortingTest(user, CODE::desc).withId(T2259::class),
                NdsCalculationSortingTest(user, TEMPLATE::desc).withId(T2260::class),
                NdsCalculationSortingTest(user, DESCRIPTION::desc).withId(T2261::class),
                NdsCalculationSortingTest(user, IS_DEFAULT_RU_PAYMENT::desc).withId(T2262::class)
            )
        )
    }

    @TestFactory
    @T2281 //'Способ расчета НДС'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2282 //'Способ расчета НДС'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T2283 //'Способ расчета НДС'. Фильтрация по полю 'template' (eq) [CLIENT]
    @T2284 //'Способ расчета НДС'. Фильтрация по полю 'template' (contains) [CLIENT]
    @T2285 //'Способ расчета НДС'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T2286 //'Способ расчета НДС'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T2287 //'Способ расчета НДС'. Фильтрация по полю 'isDefaultRuPayment' (eq) [CLIENT]
    internal fun ndsCalculationFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                NdsCalculationFiltrationTest("id equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.ID.eq(it!!.id!!) }).withId(T2281::class),
                NdsCalculationFiltrationTest("code equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.CODE.eq(it!!.code) }).withId(T2282::class),
                NdsCalculationFiltrationTest("template equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.TEMPLATE.eq(it!!.template ?: "") }).withId(T2283::class),
                NdsCalculationFiltrationTest("template contains", user, { dataForFilter },
                    { NdsCalculationFilterParams.TEMPLATE.contains((it!!.template ?: "").randomSubstringPf()) }).withId(T2284::class),
                NdsCalculationFiltrationTest("description equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T2285::class),
                NdsCalculationFiltrationTest("description contains", user, { dataForFilter },
                    { NdsCalculationFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T2286::class),
                NdsCalculationFiltrationTest("isDefaulRuPayment equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.IS_DEFAULT_RU_PAYMENT.eq(it!!.isDefaultRuPayment) }).withId(T2287::class)
            )
        )
    }

    @TestFactory
    @T2288 //'Способ расчета НДС'. Фильтрация по полю 'id' (eq) [BANK]
    @T2289 //'Способ расчета НДС'. Фильтрация по полю 'code' (eq) [BANK]
    @T2290 //'Способ расчета НДС'. Фильтрация по полю 'template' (eq) [BANK]
    @T2291 //'Способ расчета НДС'. Фильтрация по полю 'template' (contains) [BANK]
    @T2292 //'Способ расчета НДС'. Фильтрация по полю 'description' (eq) [BANK]
    @T2293 //'Способ расчета НДС'. Фильтрация по полю 'description' (contains) [BANK]
    @T2294 //'Способ расчета НДС'. Фильтрация по полю 'isDefaultRuPayment' (eq) [BANK]
    internal fun ndsCalculationFiltrationBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                NdsCalculationFiltrationTest("id equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.ID.eq(it!!.id!!) }).withId(T2288::class),
                NdsCalculationFiltrationTest("code equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.CODE.eq(it!!.code) }).withId(T2289::class),
                NdsCalculationFiltrationTest("template equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.TEMPLATE.eq(it!!.template ?: "") }).withId(T2290::class),
                NdsCalculationFiltrationTest("template contains", user, { dataForFilter },
                    { NdsCalculationFilterParams.TEMPLATE.contains((it!!.template ?: "").randomSubstringPf()) }).withId(T2291::class),
                NdsCalculationFiltrationTest("description equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T2292::class),
                NdsCalculationFiltrationTest("description contains", user, { dataForFilter },
                    { NdsCalculationFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T2293::class),
                NdsCalculationFiltrationTest("isDefaulRuPayment equals", user, { dataForFilter },
                    { NdsCalculationFilterParams.IS_DEFAULT_RU_PAYMENT.eq(it!!.isDefaultRuPayment) }).withId(T2294::class)
            )
        )
    }

    @TestFactory
    @T2263 //'Способ расчета НДС'. Проверка валидности допустимых символов в полях.
    internal fun ndsCalculationOtherTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                NdsCalculationValidSymbolsTest().withId(T2263::class)
            )
        )
    }
}