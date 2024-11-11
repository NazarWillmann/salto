package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_OKFS
import ooo.jtc.api.dictionaries.okfs.OkfsCreateTest
import ooo.jtc.api.dictionaries.okfs.OkfsDeleteTest
import ooo.jtc.api.dictionaries.okfs.OkfsFilterTests
import ooo.jtc.api.dictionaries.okfs.OkfsGetPageTest
import ooo.jtc.api.dictionaries.okfs.OkfsGetTest
import ooo.jtc.api.dictionaries.okfs.OkfsSortingTest
import ooo.jtc.api.dictionaries.okfs.OkfsUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.okfs.Okfs
import ooo.jtc.dictionaries.okfs.OkfsDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.okfs.OkfsData
import ooo.jtc.testdata.dictionaries.okfs.OkfsFilterParams
import ooo.jtc.testdata.dictionaries.okfs.OkfsSortingParams.CODE
import ooo.jtc.testdata.dictionaries.okfs.OkfsSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.okfs.OkfsSortingParams.ID
import ooo.jtc.testdata.dictionaries.okfs.OkfsSortingParams.PARENT_CODE
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
@Story(DictionaryNames.OKFS)
@DisplayName("API '${DictionaryNames.OKFS}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_OKFS
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OkfsTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4992") annotation class T4992
@Tag("JTCSALTO-T4993") annotation class T4993
@Tag("JTCSALTO-T4994") annotation class T4994
@Tag("JTCSALTO-T4995") annotation class T4995
@Tag("JTCSALTO-T4996") annotation class T4996
@Tag("JTCSALTO-T4997") annotation class T4997
@Tag("JTCSALTO-T4998") annotation class T4998
@Tag("JTCSALTO-T4999") annotation class T4999
@Tag("JTCSALTO-T5000") annotation class T5000
@Tag("JTCSALTO-T5001") annotation class T5001
@Tag("JTCSALTO-T5002") annotation class T5002
@Tag("JTCSALTO-T5003") annotation class T5003
@Tag("JTCSALTO-T5004") annotation class T5004
@Tag("JTCSALTO-T5005") annotation class T5005
@Tag("JTCSALTO-T5006") annotation class T5006
@Tag("JTCSALTO-T5007") annotation class T5007
@Tag("JTCSALTO-T5008") annotation class T5008
@Tag("JTCSALTO-T5009") annotation class T5009
@Tag("JTCSALTO-T5010") annotation class T5010
@Tag("JTCSALTO-T5011") annotation class T5011
@Tag("JTCSALTO-T5012") annotation class T5012
@Tag("JTCSALTO-T5013") annotation class T5013
@Tag("JTCSALTO-T5014") annotation class T5014
@Tag("JTCSALTO-T5015") annotation class T5015
@Tag("JTCSALTO-T5016") annotation class T5016
@Tag("JTCSALTO-T5017") annotation class T5017
@Tag("JTCSALTO-T5018") annotation class T5018
@Tag("JTCSALTO-T5019") annotation class T5019
@Tag("JTCSALTO-T5020") annotation class T5020
@Tag("JTCSALTO-T5021") annotation class T5021
@Tag("JTCSALTO-T5022") annotation class T5022
@Tag("JTCSALTO-T5023") annotation class T5023
@Tag("JTCSALTO-T5024") annotation class T5024
@Tag("JTCSALTO-T5025") annotation class T5025
@Tag("JTCSALTO-T5026") annotation class T5026
@Tag("JTCSALTO-T5027") annotation class T5027
@Tag("JTCSALTO-T5028") annotation class T5028
//@formatter:on
//endregion

    private lateinit var dataForFilter: OkfsDto
    private lateinit var testDataScope: TestDataScope<Okfs>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = OkfsData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    private val clientUser = client
    private val bankUser = bankAdmin

    @TestFactory
    @T4999 //'ОКФС (Форма собственности)'. CRUD: Создаем запись от пользователя [BANK]
    @T5000 //'ОКФС (Форма собственности)'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T5001 //'ОКФС (Форма собственности)'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5002 //'ОКФС (Форма собственности)'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T5003 //'ОКФС (Форма собственности)'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5004 //'ОКФС (Форма собственности)'. CRUD: Удаляем запись от пользователя [BANK]
    @T5005 //'ОКФС (Форма собственности)'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun okfsCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                OkfsCreateTest().withId(T4999::class),
                OkfsGetTest(user = clientUser).withId(T5000::class),
                OkfsGetTest(user = bankUser).withId(T5001::class),
                OkfsGetPageTest(user = clientUser).withId(T5002::class),
                OkfsGetPageTest(user = bankUser).withId(T5003::class),
                OkfsDeleteTest().withId(T5004::class),
                OkfsUpdateTest().withId(T5005::class)
            )
        )
    }

    @TestFactory
    @T5021 //'ОКФС (Форма собственности)'. Сортировка по полю 'id, ASC' [CLIENT]
    @T5022 //'ОКФС (Форма собственности)'. Сортировка по полю 'code, ASC' [CLIENT]
    @T5023 //'ОКФС (Форма собственности)'. Сортировка по полю 'parentCode, ASC' [CLIENT]
    @T5024 //'ОКФС (Форма собственности)'. Сортировка по полю 'description, ASC' [CLIENT]
    @T5025 //'ОКФС (Форма собственности)'. Сортировка по полю 'id, DESC' [CLIENT]
    @T5026 //'ОКФС (Форма собственности)'. Сортировка по полю 'code, DESC' [CLIENT]
    @T5027 //'ОКФС (Форма собственности)'. Сортировка по полю 'parentCode, DESC' [CLIENT]
    @T5028 //'ОКФС (Форма собственности)'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun okfsSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                OkfsSortingTest(user, ID::asc).withId(T5021::class),
                OkfsSortingTest(user, CODE::asc).withId(T5022::class),
                OkfsSortingTest(user, PARENT_CODE::asc).withId(T5023::class),
                OkfsSortingTest(user, DESCRIPTION::asc).withId(T5024::class),

                OkfsSortingTest(user, ID::desc).withId(T5025::class),
                OkfsSortingTest(user, CODE::desc).withId(T5026::class),
                OkfsSortingTest(user, PARENT_CODE::desc).withId(T5027::class),
                OkfsSortingTest(user, DESCRIPTION::desc).withId(T5028::class)
            )
        )
    }

    @TestFactory
    @T5006 //'ОКФС (Форма собственности)'. Сортировка по полю 'id, ASC' [BANK]
    @T5007 //'ОКФС (Форма собственности)'. Сортировка по полю 'code, ASC' [BANK]
    @T5008 //'ОКФС (Форма собственности)'. Сортировка по полю 'parentCode, ASC' [BANK]
    @T5009 //'ОКФС (Форма собственности)'. Сортировка по полю 'description, ASC' [BANK]
    @T5010 //'ОКФС (Форма собственности)'. Сортировка по полю 'id, DESC' [BANK]
    @T5011 //'ОКФС (Форма собственности)'. Сортировка по полю 'code, DESC' [BANK]
    @T5012 //'ОКФС (Форма собственности)'. Сортировка по полю 'parentCode, DESC' [BANK]
    @T5013 //'ОКФС (Форма собственности)'. Сортировка по полю 'description, DESC' [BANK]
    internal fun okfsSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                OkfsSortingTest(user, ID::asc).withId(T5006::class),
                OkfsSortingTest(user, CODE::asc).withId(T5007::class),
                OkfsSortingTest(user, PARENT_CODE::asc).withId(T5008::class),
                OkfsSortingTest(user, DESCRIPTION::asc).withId(T5009::class),

                OkfsSortingTest(user, ID::desc).withId(T5010::class),
                OkfsSortingTest(user, CODE::desc).withId(T5011::class),
                OkfsSortingTest(user, PARENT_CODE::desc).withId(T5012::class),
                OkfsSortingTest(user, DESCRIPTION::desc).withId(T5013::class)
            )
        )
    }

    @TestFactory
    @T5014 //'ОКФС (Форма собственности)'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T5015 //'ОКФС (Форма собственности)'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T5016 //'ОКФС (Форма собственности)'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T5017 //'ОКФС (Форма собственности)'. Фильтрация по полю 'parentCode' (eq) [CLIENT]
    @T5018 //'ОКФС (Форма собственности)'. Фильтрация по полю 'parentCode' (contains) [CLIENT]
    @T5019 //'ОКФС (Форма собственности)'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T5020 //'ОКФС (Форма собственности)'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun okfsFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                OkfsFilterTests("id equals", user, { dataForFilter },
                    { OkfsFilterParams.ID.eq(it!!.id!!) }).withId(T5014::class),
                OkfsFilterTests("code equals", user, { dataForFilter },
                    { OkfsFilterParams.CODE.eq(it!!.code!!) }).withId(T5015::class),
                OkfsFilterTests("code contains", user, { dataForFilter },
                    { OkfsFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T5016::class),
                OkfsFilterTests("parentCode equals", user, { dataForFilter },
                    { OkfsFilterParams.PARENT_CODE.eq(it!!.parentCode!!) }).withId(T5017::class),
                OkfsFilterTests("parentCode contains", user, { dataForFilter },
                    { OkfsFilterParams.PARENT_CODE.contains(it!!.parentCode!!.randomSubstringPf()) }).withId(T5018::class),
                OkfsFilterTests("description equals", user, { dataForFilter },
                    { OkfsFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T5019::class),
                OkfsFilterTests("description contains", user, { dataForFilter },
                    { OkfsFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T5020::class)
            )
        )
    }

    @TestFactory
    @T4992 //'ОКФС (Форма собственности)'. Фильтрация по полю 'id' (eq) [BANK]
    @T4993 //'ОКФС (Форма собственности)'. Фильтрация по полю 'code' (eq) [BANK]
    @T4994 //'ОКФС (Форма собственности)'. Фильтрация по полю 'code' (contains) [BANK]
    @T4995 //'ОКФС (Форма собственности)'. Фильтрация по полю 'parentCode' (eq) [BANK]
    @T4996 //'ОКФС (Форма собственности)'. Фильтрация по полю 'parentCode' (contains) [BANK]
    @T4997 //'ОКФС (Форма собственности)'. Фильтрация по полю 'description' (eq) [BANK]
    @T4998 //'ОКФС (Форма собственности)'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun okfsFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                OkfsFilterTests("id equals", user, { dataForFilter },
                    { OkfsFilterParams.ID.eq(it!!.id!!) }).withId(T4992::class),
                OkfsFilterTests("code equals", user, { dataForFilter },
                    { OkfsFilterParams.CODE.eq(it!!.code!!) }).withId(T4993::class),
                OkfsFilterTests("code contains", user, { dataForFilter },
                    { OkfsFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T4994::class),
                OkfsFilterTests("parentCode equals", user, { dataForFilter },
                    { OkfsFilterParams.PARENT_CODE.eq(it!!.parentCode!!) }).withId(T4995::class),
                OkfsFilterTests("parentCode contains", user, { dataForFilter },
                    { OkfsFilterParams.PARENT_CODE.contains(it!!.parentCode!!.randomSubstringPf()) }).withId(T4996::class),
                OkfsFilterTests("description equals", user, { dataForFilter },
                    { OkfsFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T4997::class),
                OkfsFilterTests("description contains", user, { dataForFilter },
                    { OkfsFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T4998::class)
            )
        )
    }
}