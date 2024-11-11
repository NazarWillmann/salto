package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_ACTIVITYTYPE
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeCreateTest
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeDeleteTest
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeFilterTests
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeGetPageTest
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeGetTest
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeSortingTest
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.activitytype.ActivityType
import ooo.jtc.dictionaries.activitytype.ActivityTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeData
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeFilterParams
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeSortingParams.CODE
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeSortingParams.ID
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.ACTIVITY_TYPE)
@DisplayName("API '${DictionaryNames.ACTIVITY_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_ACTIVITYTYPE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActivityTypeTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4963") annotation class T4963
@Tag("JTCSALTO-T4964") annotation class T4964
@Tag("JTCSALTO-T4965") annotation class T4965
@Tag("JTCSALTO-T4966") annotation class T4966
@Tag("JTCSALTO-T4967") annotation class T4967
@Tag("JTCSALTO-T4968") annotation class T4968
@Tag("JTCSALTO-T4969") annotation class T4969
@Tag("JTCSALTO-T4970") annotation class T4970
@Tag("JTCSALTO-T4971") annotation class T4971
@Tag("JTCSALTO-T4972") annotation class T4972
@Tag("JTCSALTO-T4973") annotation class T4973
@Tag("JTCSALTO-T4974") annotation class T4974
@Tag("JTCSALTO-T4975") annotation class T4975
@Tag("JTCSALTO-T4976") annotation class T4976
@Tag("JTCSALTO-T4977") annotation class T4977
@Tag("JTCSALTO-T4978") annotation class T4978
@Tag("JTCSALTO-T4979") annotation class T4979
@Tag("JTCSALTO-T4980") annotation class T4980
@Tag("JTCSALTO-T4981") annotation class T4981
@Tag("JTCSALTO-T4982") annotation class T4982
@Tag("JTCSALTO-T4983") annotation class T4983
@Tag("JTCSALTO-T4984") annotation class T4984
@Tag("JTCSALTO-T4985") annotation class T4985
@Tag("JTCSALTO-T4986") annotation class T4986
@Tag("JTCSALTO-T4987") annotation class T4987
@Tag("JTCSALTO-T4988") annotation class T4988
@Tag("JTCSALTO-T4989") annotation class T4989
@Tag("JTCSALTO-T4990") annotation class T4990
@Tag("JTCSALTO-T4991") annotation class T4991
//@formatter:on
//endregion

    private lateinit var dataForFilter: ActivityTypeDto
    private lateinit var testDataScope: TestDataScope<ActivityType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = ActivityTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    private val clientUser = client
    private val bankUser = bankAdmin

    @TestFactory
    @T4979 //'Вид деятельности ГОЗ'. CRUD: Создаем запись от пользователя [BANK]
    @T4980 //'Вид деятельности ГОЗ'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T4981 //'Вид деятельности ГОЗ'. CRUD: Получаем запись по id от пользователя [BANK]
    @T4982 //'Вид деятельности ГОЗ'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T4983 //'Вид деятельности ГОЗ'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T4984 //'Вид деятельности ГОЗ'. CRUD: Удаляем запись от пользователя [BANK]
    @T4985 //'Вид деятельности ГОЗ'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun activityTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ActivityTypeCreateTest().withId(T4979::class),
                ActivityTypeGetTest(user = clientUser).withId(T4980::class),
                ActivityTypeGetTest(user = bankUser).withId(T4981::class),
                ActivityTypeGetPageTest(user = clientUser).withId(T4982::class),
                ActivityTypeGetPageTest(user = bankUser).withId(T4983::class),
                ActivityTypeDeleteTest().withId(T4984::class),
                ActivityTypeUpdateTest().withId(T4985::class)
            )
        )
    }

    @TestFactory
    @T4968 //'Вид деятельности ГОЗ'. Сортировка по полю 'id, ASC' [CLIENT]
    @T4969 //'Вид деятельности ГОЗ'. Сортировка по полю 'code, ASC' [CLIENT]
    @T4970 //'Вид деятельности ГОЗ'. Сортировка по полю 'description, ASC' [CLIENT]
    @T4971 //'Вид деятельности ГОЗ'. Сортировка по полю 'id, DESC' [CLIENT]
    @T4972 //'Вид деятельности ГОЗ'. Сортировка по полю 'code, DESC' [CLIENT]
    @T4973 //'Вид деятельности ГОЗ'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun activityTypeSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ActivityTypeSortingTest(user, ID::asc).withId(T4968::class),
                ActivityTypeSortingTest(user, CODE::asc).withId(T4969::class),
                ActivityTypeSortingTest(user, DESCRIPTION::asc).withId(T4970::class),

                ActivityTypeSortingTest(user, ID::desc).withId(T4971::class),
                ActivityTypeSortingTest(user, CODE::desc).withId(T4972::class),
                ActivityTypeSortingTest(user, DESCRIPTION::desc).withId(T4973::class)
            )
        )
    }

    @TestFactory
    @T4986 //'Вид деятельности ГОЗ'. Сортировка по полю 'id, ASC' [BANK]
    @T4987 //'Вид деятельности ГОЗ'. Сортировка по полю 'code, ASC' [BANK]
    @T4988 //'Вид деятельности ГОЗ'. Сортировка по полю 'description, ASC' [BANK]
    @T4989 //'Вид деятельности ГОЗ'. Сортировка по полю 'id, DESC' [BANK]
    @T4990 //'Вид деятельности ГОЗ'. Сортировка по полю 'code, DESC' [BANK]
    @T4991 //'Вид деятельности ГОЗ'. Сортировка по полю 'description, DESC' [BANK]
    internal fun activityTypeSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                ActivityTypeSortingTest(user, ID::asc).withId(T4986::class),
                ActivityTypeSortingTest(user, CODE::asc).withId(T4987::class),
                ActivityTypeSortingTest(user, DESCRIPTION::asc).withId(T4988::class),

                ActivityTypeSortingTest(user, ID::desc).withId(T4989::class),
                ActivityTypeSortingTest(user, CODE::desc).withId(T4990::class),
                ActivityTypeSortingTest(user, DESCRIPTION::desc).withId(T4991::class)
            )
        )
    }

    @TestFactory
    @T4963 //'Вид деятельности ГОЗ'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T4964 //'Вид деятельности ГОЗ'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T4965 //'Вид деятельности ГОЗ'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T4966 //'Вид деятельности ГОЗ'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T4967 //'Вид деятельности ГОЗ'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun activityTypeFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ActivityTypeFilterTests("id equals", user, { dataForFilter },
                    { ActivityTypeFilterParams.ID.eq(it!!.id!!) }).withId(T4963::class),
                ActivityTypeFilterTests("code equals", user, { dataForFilter },
                    { ActivityTypeFilterParams.CODE.eq(it!!.code!!) }).withId(T4964::class),
                ActivityTypeFilterTests("code contains", user, { dataForFilter },
                    { ActivityTypeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T4965::class),
                ActivityTypeFilterTests("description equals", user, { dataForFilter },
                    { ActivityTypeFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T4966::class),
                ActivityTypeFilterTests("description contains", user, { dataForFilter },
                    { ActivityTypeFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T4967::class)
            )
        )
    }

    @TestFactory
    @T4974 //'Вид деятельности ГОЗ'. Фильтрация по полю 'id' (eq) [BANK]
    @T4975 //'Вид деятельности ГОЗ'. Фильтрация по полю 'code' (eq) [BANK]
    @T4976 //'Вид деятельности ГОЗ'. Фильтрация по полю 'code' (contains) [BANK]
    @T4977 //'Вид деятельности ГОЗ'. Фильтрация по полю 'description' (eq) [BANK]
    @T4978 //'Вид деятельности ГОЗ'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun activityTypeFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                ActivityTypeFilterTests("id equals", user, { dataForFilter },
                    { ActivityTypeFilterParams.ID.eq(it!!.id!!) }).withId(T4974::class),
                ActivityTypeFilterTests("code equals", user, { dataForFilter },
                    { ActivityTypeFilterParams.CODE.eq(it!!.code!!) }).withId(T4975::class),
                ActivityTypeFilterTests("code contains", user, { dataForFilter },
                    { ActivityTypeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T4976::class),
                ActivityTypeFilterTests("description equals", user, { dataForFilter },
                    { ActivityTypeFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T4977::class),
                ActivityTypeFilterTests("description contains", user, { dataForFilter },
                    { ActivityTypeFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T4978::class)
            )
        )
    }
}