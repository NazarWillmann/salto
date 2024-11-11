package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_LOCATIONTYPE
import ooo.jtc.api.dictionaries.locationtype.LocationTypeCreateTest
import ooo.jtc.api.dictionaries.locationtype.LocationTypeDeleteTest
import ooo.jtc.api.dictionaries.locationtype.LocationTypeFilterTests
import ooo.jtc.api.dictionaries.locationtype.LocationTypeGetPageTest
import ooo.jtc.api.dictionaries.locationtype.LocationTypeGetTest
import ooo.jtc.api.dictionaries.locationtype.LocationTypeSortingTest
import ooo.jtc.api.dictionaries.locationtype.LocationTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.locationtype.LocationType
import ooo.jtc.dictionaries.locationtype.LocationTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeData
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeFilterParams
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeSortingParams.ID
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeSortingParams.TYPE
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
@Story(DictionaryNames.LOCATION_TYPE)
@DisplayName("API '${DictionaryNames.LOCATION_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_LOCATIONTYPE
@TestInstance(PER_CLASS)
class LocationTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2295") annotation class T2295
@Tag("JTCSALTO-T2296") annotation class T2296
@Tag("JTCSALTO-T2297") annotation class T2297
@Tag("JTCSALTO-T2298") annotation class T2298
@Tag("JTCSALTO-T2299") annotation class T2299
@Tag("JTCSALTO-T2300") annotation class T2300
@Tag("JTCSALTO-T2301") annotation class T2301
@Tag("JTCSALTO-T2302") annotation class T2302
@Tag("JTCSALTO-T2303") annotation class T2303
@Tag("JTCSALTO-T2304") annotation class T2304
@Tag("JTCSALTO-T2305") annotation class T2305
@Tag("JTCSALTO-T2306") annotation class T2306
@Tag("JTCSALTO-T2307") annotation class T2307
@Tag("JTCSALTO-T2308") annotation class T2308
@Tag("JTCSALTO-T2309") annotation class T2309
@Tag("JTCSALTO-T2310") annotation class T2310
@Tag("JTCSALTO-T2311") annotation class T2311
@Tag("JTCSALTO-T2312") annotation class T2312
@Tag("JTCSALTO-T2313") annotation class T2313
@Tag("JTCSALTO-T2314") annotation class T2314
@Tag("JTCSALTO-T2315") annotation class T2315
//@formatter:on
//endregion

    private lateinit var dataForFilter: LocationTypeDto
    private lateinit var testDataScope: TestDataScope<LocationType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = LocationTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2295 //'Тип населенного пункта'. CRUD: Создаем запись от пользователя [BANK]
    @T2296 //'Тип населенного пункта'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2297 //'Тип населенного пункта'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2298 //'Тип населенного пункта'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2299 //'Тип населенного пункта'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2300 //'Тип населенного пункта'. CRUD: Удаляем запись от пользователя [BANK]
    @T2301 //'Тип населенного пункта'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun locationTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LocationTypeCreateTest().withId(T2295::class),
                LocationTypeGetTest(user = Users.client).withId(T2296::class),
                LocationTypeGetTest(user = Users.bankAdmin).withId(T2297::class),
                LocationTypeGetPageTest(user = Users.client).withId(T2298::class),
                LocationTypeGetPageTest(user = Users.bankAdmin).withId(T2299::class),
                LocationTypeDeleteTest().withId(T2300::class),
                LocationTypeUpdateTest().withId(T2301::class)
            )
        )
    }

    @TestFactory
    @T2308 //'Тип населенного пункта'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2309 //'Тип населенного пункта'. Сортировка по полю 'locationType, ASC' [CLIENT]
    @T2310 //'Тип населенного пункта'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2311 //'Тип населенного пункта'. Сортировка по полю 'locationType, DESC' [CLIENT]
    internal fun locationTypeSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                LocationTypeSortingTest(user, ID::asc).withId(T2308::class),
                LocationTypeSortingTest(user, TYPE::asc).withId(T2309::class),
                LocationTypeSortingTest(user, ID::desc).withId(T2310::class),
                LocationTypeSortingTest(user, TYPE::desc).withId(T2311::class)
            )
        )
    }

    @TestFactory
    @T2312 //'Тип населенного пункта'. Сортировка по полю 'id, ASC' [BANK]
    @T2313 //'Тип населенного пункта'. Сортировка по полю 'locationType, ASC' [BANK]
    @T2314 //'Тип населенного пункта'. Сортировка по полю 'id, DESC' [BANK]
    @T2315 //'Тип населенного пункта'. Сортировка по полю 'locationType, DESC' [BANK]
    internal fun locationTypeSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                LocationTypeSortingTest(user, ID::asc).withId(T2312::class),
                LocationTypeSortingTest(user, TYPE::asc).withId(T2313::class),
                LocationTypeSortingTest(user, ID::desc).withId(T2314::class),
                LocationTypeSortingTest(user, TYPE::desc).withId(T2315::class)
            )
        )
    }


    @TestFactory
    @T2305 //'Тип населенного пункта'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2306 //'Тип населенного пункта'. Фильтрация по полю 'locationType' (eq) [CLIENT]
    @T2307 //'Тип населенного пункта'. Фильтрация по полю 'locationType' (contains) [CLIENT]
    internal fun locationTypeFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                LocationTypeFilterTests("id equals", user, { dataForFilter },
                    { LocationTypeFilterParams.ID.eq(it!!.id!!) }).withId(T2305::class),
                LocationTypeFilterTests("type equals", user, { dataForFilter },
                    { LocationTypeFilterParams.TYPE.eq(it!!.locationType!!) }).withId(T2306::class),
                LocationTypeFilterTests("type contains", user, { dataForFilter },
                    { LocationTypeFilterParams.TYPE.contains(it!!.locationType!!.randomSubstringPf()) }).withId(T2307::class)
            )
        )
    }

    @TestFactory
    @T2302 //'Тип населенного пункта'. Фильтрация по полю 'id' (eq) [BANK]
    @T2303 //'Тип населенного пункта'. Фильтрация по полю 'locationType' (eq) [BANK]
    @T2304 //'Тип населенного пункта'. Фильтрация по полю 'locationType' (contains) [BANK]
    internal fun locationTypeFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                LocationTypeFilterTests("id equals", user, { dataForFilter },
                    { LocationTypeFilterParams.ID.eq(it!!.id!!) }).withId(T2302::class),
                LocationTypeFilterTests("type equals", user, { dataForFilter },
                    { LocationTypeFilterParams.TYPE.eq(it!!.locationType!!) }).withId(T2303::class),
                LocationTypeFilterTests("type contains", user, { dataForFilter },
                    { LocationTypeFilterParams.TYPE.contains(it!!.locationType!!.randomSubstringPf()) }).withId(T2304::class)
            )
        )
    }
}