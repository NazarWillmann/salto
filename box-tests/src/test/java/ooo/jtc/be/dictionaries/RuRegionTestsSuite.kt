package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_RUREGION
import ooo.jtc.api.dictionaries.region.RuRegionCreateTest
import ooo.jtc.api.dictionaries.region.RuRegionDeleteTest
import ooo.jtc.api.dictionaries.region.RuRegionFiltrationTests
import ooo.jtc.api.dictionaries.region.RuRegionGetPageTest
import ooo.jtc.api.dictionaries.region.RuRegionGetTest
import ooo.jtc.api.dictionaries.region.RuRegionSortingTest
import ooo.jtc.api.dictionaries.region.RuRegionUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.region.RuRegion
import ooo.jtc.dictionaries.region.RuRegionDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.region.RuRegionData
import ooo.jtc.testdata.dictionaries.region.RuRegionFilterParams
import ooo.jtc.testdata.dictionaries.region.RuRegionSortingParams
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
@Story(DictionaryNames.RU_REGION)
@DisplayName("API '${DictionaryNames.RU_REGION}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_RUREGION
@TestInstance(PER_CLASS)
class RuRegionTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1904") annotation class T1904
@Tag("JTCSALTO-T1905") annotation class T1905
@Tag("JTCSALTO-T1906") annotation class T1906
@Tag("JTCSALTO-T1907") annotation class T1907
@Tag("JTCSALTO-T1908") annotation class T1908
@Tag("JTCSALTO-T1909") annotation class T1909
@Tag("JTCSALTO-T1910") annotation class T1910
@Tag("JTCSALTO-T1911") annotation class T1911
@Tag("JTCSALTO-T1912") annotation class T1912
@Tag("JTCSALTO-T1913") annotation class T1913
@Tag("JTCSALTO-T1914") annotation class T1914
@Tag("JTCSALTO-T1915") annotation class T1915
@Tag("JTCSALTO-T1916") annotation class T1916
@Tag("JTCSALTO-T1917") annotation class T1917
@Tag("JTCSALTO-T1918") annotation class T1918
@Tag("JTCSALTO-T1919") annotation class T1919
@Tag("JTCSALTO-T1920") annotation class T1920
@Tag("JTCSALTO-T1921") annotation class T1921
@Tag("JTCSALTO-T1922") annotation class T1922
@Tag("JTCSALTO-T1923") annotation class T1923
@Tag("JTCSALTO-T1924") annotation class T1924
@Tag("JTCSALTO-T1925") annotation class T1925
@Tag("JTCSALTO-T1926") annotation class T1926
@Tag("JTCSALTO-T1927") annotation class T1927
@Tag("JTCSALTO-T1928") annotation class T1928
@Tag("JTCSALTO-T1929") annotation class T1929
@Tag("JTCSALTO-T1930") annotation class T1930
//@formatter:on
//endregion


    private lateinit var dataForFilter: RuRegionDto
    private lateinit var testDataScope: TestDataScope<RuRegion>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = RuRegionData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T1914 //'Субъект РФ'. CRUD: Создаем запись от пользователя [BANK]
    @T1915 //'Субъект РФ'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T1916 //'Субъект РФ'. CRUD: Получаем запись по id от пользователя [BANK]
    @T1917 //'Субъект РФ'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T1918 //'Субъект РФ'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T1919 //'Субъект РФ'. CRUD: Удаляем запись от пользователя [BANK]
    @T1920 //'Субъект РФ'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun ruRegionCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                RuRegionCreateTest().withId(T1914::class),
                RuRegionGetTest(user = Users.client).withId(T1915::class),
                RuRegionGetTest(user = Users.bankAdmin).withId(T1916::class),
                RuRegionGetPageTest(user = Users.client).withId(T1917::class),
                RuRegionGetPageTest(user = Users.bankAdmin).withId(T1918::class),
                RuRegionDeleteTest().withId(T1919::class),
                RuRegionUpdateTest().withId(T1920::class)
            )
        )
    }

    @TestFactory
    @T1904 //'Субъект РФ'. Сортировка по полю 'id, ASC' [CLIENT]
    @T1905 //'Субъект РФ'. Сортировка по полю 'code, ASC' [CLIENT]
    @T1906 //'Субъект РФ'. Сортировка по полю 'name, ASC' [CLIENT]
    @T1907 //'Субъект РФ'. Сортировка по полю 'id, DESC' [CLIENT]
    @T1908 //'Субъект РФ'. Сортировка по полю 'code, DESC' [CLIENT]
    @T1909 //'Субъект РФ'. Сортировка по полю 'name, DESC' [CLIENT]
    internal fun ruRegionSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                RuRegionSortingTest(user, RuRegionSortingParams.ID::asc).withId(T1904::class),
                RuRegionSortingTest(user, RuRegionSortingParams.CODE::asc).withId(T1905::class),
                RuRegionSortingTest(user, RuRegionSortingParams.NAME::asc).withId(T1906::class),

                RuRegionSortingTest(user, RuRegionSortingParams.ID::desc).withId(T1907::class),
                RuRegionSortingTest(user, RuRegionSortingParams.CODE::desc).withId(T1908::class),
                RuRegionSortingTest(user, RuRegionSortingParams.NAME::desc).withId(T1909::class)
            )
        )
    }

    @TestFactory
    @T1921 //'Субъект РФ'. Сортировка по полю 'id, ASC' [BANK]
    @T1922 //'Субъект РФ'. Сортировка по полю 'code, ASC' [BANK]
    @T1923 //'Субъект РФ'. Сортировка по полю 'name, ASC' [BANK]
    @T1924 //'Субъект РФ'. Сортировка по полю 'id, DESC' [BANK]
    @T1925 //'Субъект РФ'. Сортировка по полю 'code, DESC' [BANK]
    @T1926 //'Субъект РФ'. Сортировка по полю 'name, DESC' [BANK]
    internal fun ruRegionSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                RuRegionSortingTest(user, RuRegionSortingParams.ID::asc).withId(T1921::class),
                RuRegionSortingTest(user, RuRegionSortingParams.CODE::asc).withId(T1922::class),
                RuRegionSortingTest(user, RuRegionSortingParams.NAME::asc).withId(T1923::class),

                RuRegionSortingTest(user, RuRegionSortingParams.ID::desc).withId(T1924::class),
                RuRegionSortingTest(user, RuRegionSortingParams.CODE::desc).withId(T1925::class),
                RuRegionSortingTest(user, RuRegionSortingParams.NAME::desc).withId(T1926::class)
            )
        )
    }

    @TestFactory
    @T1910 //'Субъект РФ'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T1911 //'Субъект РФ'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T1912 //'Субъект РФ'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T1913 //'Субъект РФ'. Фильтрация по полю 'name' (contains) [CLIENT]
    internal fun ruRegionFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                RuRegionFiltrationTests("id equals", user, { dataForFilter },
                    { RuRegionFilterParams.ID.eq(it!!.id!!) }).withId(T1910::class),
                RuRegionFiltrationTests("code equals", user, { dataForFilter },
                    { RuRegionFilterParams.CODE.eq(it!!.code) }).withId(T1911::class),
                RuRegionFiltrationTests("name equal", user, { dataForFilter },
                    { RuRegionFilterParams.NAME.eq(it!!.name) }).withId(T1912::class),
                RuRegionFiltrationTests("name contains", user, { dataForFilter },
                    { RuRegionFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T1913::class)
            )
        )
    }

    @TestFactory
    @T1927 //'Субъект РФ'. Фильтрация по полю 'id' (eq) [BANK]
    @T1928 //'Субъект РФ'. Фильтрация по полю 'code' (eq) [BANK]
    @T1929 //'Субъект РФ'. Фильтрация по полю 'name' (eq) [BANK]
    @T1930 //'Субъект РФ'. Фильтрация по полю 'name' (contains) [BANK]
    internal fun ruRegionFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                RuRegionFiltrationTests("id equals", user, { dataForFilter },
                    { RuRegionFilterParams.ID.eq(it!!.id!!) }).withId(T1927::class),
                RuRegionFiltrationTests("code equals", user, { dataForFilter },
                    { RuRegionFilterParams.CODE.eq(it!!.code) }).withId(T1928::class),
                RuRegionFiltrationTests("name equal", user, { dataForFilter },
                    { RuRegionFilterParams.NAME.eq(it!!.name) }).withId(T1929::class),
                RuRegionFiltrationTests("name contains", user, { dataForFilter },
                    { RuRegionFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T1930::class)
            )
        )
    }
}