package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_TIMEZONE
import ooo.jtc.api.dictionaries.timezone.TimezoneCreateTest
import ooo.jtc.api.dictionaries.timezone.TimezoneDeleteTest
import ooo.jtc.api.dictionaries.timezone.TimezoneFiltrationTest
import ooo.jtc.api.dictionaries.timezone.TimezoneGetByNameTest
import ooo.jtc.api.dictionaries.timezone.TimezoneGetByShiftTest
import ooo.jtc.api.dictionaries.timezone.TimezoneGetPageTest
import ooo.jtc.api.dictionaries.timezone.TimezoneGetTest
import ooo.jtc.api.dictionaries.timezone.TimezoneSortingTest
import ooo.jtc.api.dictionaries.timezone.TimezoneUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.timezone.Timezone
import ooo.jtc.dictionaries.timezone.TimezoneDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.timezone.TimezoneData
import ooo.jtc.testdata.dictionaries.timezone.TimezoneFilterParams
import ooo.jtc.testdata.dictionaries.timezone.TimezoneSortingParams.ID
import ooo.jtc.testdata.dictionaries.timezone.TimezoneSortingParams.NAME
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
@Story(DictionaryNames.TIME_ZONE)
@DisplayName("API '${DictionaryNames.TIME_ZONE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_TIMEZONE
@TestInstance(PER_CLASS)
class TimezoneTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T2178") annotation class T2178
@Tag("JTCSALTO-T2179") annotation class T2179
@Tag("JTCSALTO-T2180") annotation class T2180
@Tag("JTCSALTO-T2181") annotation class T2181
@Tag("JTCSALTO-T2182") annotation class T2182
@Tag("JTCSALTO-T2183") annotation class T2183
@Tag("JTCSALTO-T2184") annotation class T2184
@Tag("JTCSALTO-T2185") annotation class T2185
@Tag("JTCSALTO-T2186") annotation class T2186
@Tag("JTCSALTO-T2187") annotation class T2187
@Tag("JTCSALTO-T2188") annotation class T2188
@Tag("JTCSALTO-T2189") annotation class T2189
@Tag("JTCSALTO-T2190") annotation class T2190
@Tag("JTCSALTO-T2191") annotation class T2191
@Tag("JTCSALTO-T2192") annotation class T2192
@Tag("JTCSALTO-T2193") annotation class T2193
@Tag("JTCSALTO-T2194") annotation class T2194
@Tag("JTCSALTO-T2195") annotation class T2195
@Tag("JTCSALTO-T2196") annotation class T2196
@Tag("JTCSALTO-T5571") annotation class T5571
@Tag("JTCSALTO-T5572") annotation class T5572
@Tag("JTCSALTO-T5578") annotation class T5578
@Tag("JTCSALTO-T5579") annotation class T5579
@Tag("JTCSALTO-T5580") annotation class T5580
@Tag("JTCSALTO-T5581") annotation class T5581
//@formatter:on
//endregion

    private val clientUser by lazy { Users.client }
    private val bankUser by lazy { Users.bankAdmin }
    private lateinit var dataForFilter: TimezoneDto
    private lateinit var testDataScope: TestDataScope<Timezone>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = TimezoneData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2191 //'Часовой пояс'. CRUD: Создаем запись от пользователя [BANK]
    @T2190 //'Часовой пояс'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2193 //'Часовой пояс'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2192 //'Часовой пояс'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2181 //'Часовой пояс'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2185 //'Часовой пояс'. CRUD: Удаляем запись от пользователя [BANK]
    @T2188 //'Часовой пояс'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun timezoneCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TimezoneCreateTest().withId(T2191::class),
                TimezoneGetTest(user = clientUser).withId(T2190::class),
                TimezoneGetTest(user = bankUser).withId(T2193::class),
                TimezoneGetPageTest(user = clientUser).withId(T2192::class),
                TimezoneGetPageTest(user = bankUser).withId(T2181::class),
                TimezoneDeleteTest().withId(T2185::class),
                TimezoneUpdateTest().withId(T2188::class)
            )
        )
    }

    @TestFactory
    @T2179 //'Часовой пояс'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2183 //'Часовой пояс'. Сортировка по полю 'name, ASC' [CLIENT]
    @T2189 //'Часовой пояс'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2187 //'Часовой пояс'. Сортировка по полю 'name, DESC' [CLIENT]
    internal fun timezoneSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                TimezoneSortingTest(user, ID::asc).withId(T2179::class),
                TimezoneSortingTest(user, NAME::asc).withId(T2183::class),
                TimezoneSortingTest(user, ID::desc).withId(T2189::class),
                TimezoneSortingTest(user, NAME::desc).withId(T2187::class)
            )
        )
    }

    @TestFactory
    @T5578 //'Часовой пояс'. Сортировка по полю 'id, ASC' [BANK]
    @T5579 //'Часовой пояс'. Сортировка по полю 'name, ASC' [BANK]
    @T5580 //'Часовой пояс'. Сортировка по полю 'id, DESC' [BANK]
    @T5581 //'Часовой пояс'. Сортировка по полю 'name, DESC' [BANK]
    internal fun timezoneSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                TimezoneSortingTest(user, ID::asc).withId(T5578::class),
                TimezoneSortingTest(user, NAME::asc).withId(T5579::class),
                TimezoneSortingTest(user, ID::desc).withId(T5580::class),
                TimezoneSortingTest(user, NAME::desc).withId(T5581::class)
            )
        )
    }

    @TestFactory
    @T2178 //'Часовой пояс'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2184 //'Часовой пояс'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T2186 //'Часовой пояс'. Фильтрация по полю 'name' (contains) [CLIENT]
    internal fun timezoneFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                TimezoneFiltrationTest("id equals", user, { dataForFilter },
                    { TimezoneFilterParams.ID.eq(it!!.id!!) }).withId(T2178::class),
                TimezoneFiltrationTest("name equals", user, { dataForFilter },
                    { TimezoneFilterParams.NAME.eq(it!!.name) }).withId(T2184::class),
                TimezoneFiltrationTest("name contains", user, { dataForFilter },
                    { TimezoneFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T2186::class)
            )
        )
    }

    @TestFactory
    @T2194 //'Часовой пояс'. Фильтрация по полю 'name' (eq) [BANK]
    @T2196 //'Часовой пояс'. Фильтрация по полю 'id' (eq) [BANK]
    @T2195 //'Часовой пояс'. Фильтрация по полю 'name' (contains) [BANK]
    internal fun timezoneFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                TimezoneFiltrationTest("id equals", user, { dataForFilter },
                    { TimezoneFilterParams.ID.eq(it!!.id!!) }).withId(T2194::class),
                TimezoneFiltrationTest("name equals", user, { dataForFilter },
                    { TimezoneFilterParams.NAME.eq(it!!.name) }).withId(T2196::class),
                TimezoneFiltrationTest("name contains", user, { dataForFilter },
                    { TimezoneFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T2195::class)
            )
        )
    }

    @TestFactory
    @T5571 //'Часовой пояс'. Получение часового пояса по его наименованию [CLIENT]
    @T5572 //'Часовой пояс'. Получение часового пояса по его наименованию [BANK]
    internal fun timezoneGetByNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TimezoneGetByNameTest(clientUser).withId(T5571::class),
                TimezoneGetByNameTest(bankUser).withId(T5572::class)
            )
        )
    }

    @TestFactory
    @T2180 //'Часовой пояс'. Получение списка часовых поясов по сдвигу [CLIENT]
    @T2182 //'Часовой пояс'. Получение списка часовых поясов по сдвигу [BANK]
    internal fun timezonesGetByShiftTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TimezoneGetByShiftTest(clientUser).withId(T2180::class),
                TimezoneGetByShiftTest(bankUser).withId(T2182::class)
            )
        )
    }
}