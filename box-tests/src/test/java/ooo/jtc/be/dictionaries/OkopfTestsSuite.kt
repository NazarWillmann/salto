package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_OKOPF
import ooo.jtc.api.dictionaries.okopf.OkopfCreateTest
import ooo.jtc.api.dictionaries.okopf.OkopfDeleteTest
import ooo.jtc.api.dictionaries.okopf.OkopfFilterTests
import ooo.jtc.api.dictionaries.okopf.OkopfGetPageTest
import ooo.jtc.api.dictionaries.okopf.OkopfGetTest
import ooo.jtc.api.dictionaries.okopf.OkopfSortingTest
import ooo.jtc.api.dictionaries.okopf.OkopfUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.okopf.Okopf
import ooo.jtc.dictionaries.okopf.OkopfDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.okopf.OkopfData
import ooo.jtc.testdata.dictionaries.okopf.OkopfFilterParams
import ooo.jtc.testdata.dictionaries.okopf.OkopfSortingParams.CODE
import ooo.jtc.testdata.dictionaries.okopf.OkopfSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.okopf.OkopfSortingParams.ID
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
@Story(DictionaryNames.OKOPF)
@DisplayName("API '${DictionaryNames.OKOPF}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_OKOPF
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OkopfTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T5029") annotation class T5029
@Tag("JTCSALTO-T5030") annotation class T5030
@Tag("JTCSALTO-T5031") annotation class T5031
@Tag("JTCSALTO-T5032") annotation class T5032
@Tag("JTCSALTO-T5033") annotation class T5033
@Tag("JTCSALTO-T5034") annotation class T5034
@Tag("JTCSALTO-T5035") annotation class T5035
@Tag("JTCSALTO-T5036") annotation class T5036
@Tag("JTCSALTO-T5037") annotation class T5037
@Tag("JTCSALTO-T5038") annotation class T5038
@Tag("JTCSALTO-T5039") annotation class T5039
@Tag("JTCSALTO-T5040") annotation class T5040
@Tag("JTCSALTO-T5041") annotation class T5041
@Tag("JTCSALTO-T5042") annotation class T5042
@Tag("JTCSALTO-T5043") annotation class T5043
@Tag("JTCSALTO-T5044") annotation class T5044
@Tag("JTCSALTO-T5045") annotation class T5045
@Tag("JTCSALTO-T5046") annotation class T5046
@Tag("JTCSALTO-T5047") annotation class T5047
@Tag("JTCSALTO-T5048") annotation class T5048
@Tag("JTCSALTO-T5049") annotation class T5049
@Tag("JTCSALTO-T5050") annotation class T5050
@Tag("JTCSALTO-T5051") annotation class T5051
@Tag("JTCSALTO-T5052") annotation class T5052
@Tag("JTCSALTO-T5053") annotation class T5053
@Tag("JTCSALTO-T5054") annotation class T5054
@Tag("JTCSALTO-T5055") annotation class T5055
@Tag("JTCSALTO-T5056") annotation class T5056
@Tag("JTCSALTO-T5057") annotation class T5057
//@formatter:on
//endregion

    private lateinit var dataForFilter: OkopfDto
    private lateinit var testDataScope: TestDataScope<Okopf>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = OkopfData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    private val clientUser = Users.client
    private val bankUser = Users.bankAdmin

    @TestFactory
    @T5051 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Создаем запись от пользователя [BANK]
    @T5052 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T5053 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5054 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T5055 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5056 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Удаляем запись от пользователя [BANK]
    @T5057 //'ОКОПФ (Организационно-правовая форма)'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun okopfCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                OkopfCreateTest().withId(T5051::class),
                OkopfGetTest(user = clientUser).withId(T5052::class),
                OkopfGetTest(user = bankUser).withId(T5053::class),
                OkopfGetPageTest(user = clientUser).withId(T5054::class),
                OkopfGetPageTest(user = bankUser).withId(T5055::class),
                OkopfDeleteTest().withId(T5056::class),
                OkopfUpdateTest().withId(T5057::class)
            )
        )
    }

    @TestFactory
    @T5034 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'id, ASC' [CLIENT]
    @T5035 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'code, ASC' [CLIENT]
    @T5036 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'description, ASC' [CLIENT]
    @T5037 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'id, DESC' [CLIENT]
    @T5038 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'code, DESC' [CLIENT]
    @T5039 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun okopfSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                OkopfSortingTest(user, ID::asc).withId(T5034::class),
                OkopfSortingTest(user, CODE::asc).withId(T5035::class),
                OkopfSortingTest(user, DESCRIPTION::asc).withId(T5036::class),

                OkopfSortingTest(user, ID::desc).withId(T5037::class),
                OkopfSortingTest(user, CODE::desc).withId(T5038::class),
                OkopfSortingTest(user, DESCRIPTION::desc).withId(T5039::class)

            )
        )
    }

    @TestFactory
    @T5045 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'id, ASC' [BANK]
    @T5046 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'code, ASC' [BANK]
    @T5047 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'description, ASC' [BANK]
    @T5048 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'id, DESC' [BANK]
    @T5049 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'code, DESC' [BANK]
    @T5050 //'ОКОПФ (Организационно-правовая форма)'. Сортировка по полю 'description, DESC' [BANK]
    internal fun okopfSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                OkopfSortingTest(user, ID::asc).withId(T5045::class),
                OkopfSortingTest(user, CODE::asc).withId(T5046::class),
                OkopfSortingTest(user, DESCRIPTION::asc).withId(T5047::class),

                OkopfSortingTest(user, ID::desc).withId(T5048::class),
                OkopfSortingTest(user, CODE::desc).withId(T5049::class),
                OkopfSortingTest(user, DESCRIPTION::desc).withId(T5050::class)
            )
        )
    }

    @TestFactory
    @T5029 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T5030 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T5031 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T5032 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T5033 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun okopfFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                OkopfFilterTests("id equals", user, { dataForFilter },
                    { OkopfFilterParams.ID.eq(it!!.id!!) }).withId(T5029::class),
                OkopfFilterTests("code equals", user, { dataForFilter },
                    { OkopfFilterParams.CODE.eq(it!!.code!!) }).withId(T5030::class),
                OkopfFilterTests("code contains", user, { dataForFilter },
                    { OkopfFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T5031::class),
                OkopfFilterTests("description equals", user, { dataForFilter },
                    { OkopfFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T5032::class),
                OkopfFilterTests("description contains", user, { dataForFilter },
                    { OkopfFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T5033::class)
            )
        )
    }

    @TestFactory
    @T5040 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'id' (eq) [BANK]
    @T5041 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'code' (eq) [BANK]
    @T5042 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'code' (contains) [BANK]
    @T5043 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'description' (eq) [BANK]
    @T5044 //'ОКОПФ (Организационно-правовая форма)'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun okopfFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                OkopfFilterTests("id equals", user, { dataForFilter },
                    { OkopfFilterParams.ID.eq(it!!.id!!) }).withId(T5040::class),
                OkopfFilterTests("code equals", user, { dataForFilter },
                    { OkopfFilterParams.CODE.eq(it!!.code!!) }).withId(T5041::class),
                OkopfFilterTests("code contains", user, { dataForFilter },
                    { OkopfFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T5042::class),
                OkopfFilterTests("description equals", user, { dataForFilter },
                    { OkopfFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T5043::class),
                OkopfFilterTests("description contains", user, { dataForFilter },
                    { OkopfFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T5044::class)
            )
        )
    }
}