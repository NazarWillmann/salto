package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CONTROLCODE
import ooo.jtc.api.dictionaries.controlcode.ControlCodeCreateTest
import ooo.jtc.api.dictionaries.controlcode.ControlCodeDeleteTest
import ooo.jtc.api.dictionaries.controlcode.ControlCodeFiltrationTests
import ooo.jtc.api.dictionaries.controlcode.ControlCodeGetPageTest
import ooo.jtc.api.dictionaries.controlcode.ControlCodeGetTest
import ooo.jtc.api.dictionaries.controlcode.ControlCodeSortingTest
import ooo.jtc.api.dictionaries.controlcode.ControlCodeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.controlcode.ControlCode
import ooo.jtc.dictionaries.controlcode.ControlCodeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeData
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeFilterParams
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeSortingParams
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
@Story(DictionaryNames.CONTROL_CODE)
@DisplayName("API '${DictionaryNames.CONTROL_CODE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CONTROLCODE
@TestInstance(PER_CLASS)
class ControlCodeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3525") annotation class T3525
@Tag("JTCSALTO-T3526") annotation class T3526
@Tag("JTCSALTO-T3527") annotation class T3527
@Tag("JTCSALTO-T3528") annotation class T3528
@Tag("JTCSALTO-T3529") annotation class T3529
@Tag("JTCSALTO-T3530") annotation class T3530
@Tag("JTCSALTO-T3531") annotation class T3531
@Tag("JTCSALTO-T3532") annotation class T3532
@Tag("JTCSALTO-T3533") annotation class T3533
@Tag("JTCSALTO-T3534") annotation class T3534
@Tag("JTCSALTO-T3535") annotation class T3535
@Tag("JTCSALTO-T3536") annotation class T3536
@Tag("JTCSALTO-T3537") annotation class T3537
@Tag("JTCSALTO-T3538") annotation class T3538
@Tag("JTCSALTO-T3539") annotation class T3539
@Tag("JTCSALTO-T3540") annotation class T3540
@Tag("JTCSALTO-T3541") annotation class T3541
@Tag("JTCSALTO-T3542") annotation class T3542
@Tag("JTCSALTO-T3543") annotation class T3543
@Tag("JTCSALTO-T3544") annotation class T3544
@Tag("JTCSALTO-T3545") annotation class T3545
@Tag("JTCSALTO-T3546") annotation class T3546
@Tag("JTCSALTO-T3547") annotation class T3547
@Tag("JTCSALTO-T3548") annotation class T3548
@Tag("JTCSALTO-T3549") annotation class T3549
@Tag("JTCSALTO-T3550") annotation class T3550
@Tag("JTCSALTO-T3551") annotation class T3551
@Tag("JTCSALTO-T3552") annotation class T3552
@Tag("JTCSALTO-T3553") annotation class T3553
//@formatter:on
//endregion

    private lateinit var dataForFilter: ControlCodeDto
    private lateinit var testDataScope: TestDataScope<ControlCode>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = ControlCodeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3535 //'Код контроля'. CRUD: Создаем запись от пользователя [BANK]
    @T3536 //'Код контроля'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3537 //'Код контроля'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3538 //'Код контроля'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3539 //'Код контроля'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3540 //'Код контроля'. CRUD: Удаляем запись от пользователя [BANK]
    @T3541 //'Код контроля'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun controlCodeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ControlCodeCreateTest().withId(T3535::class),
                ControlCodeGetTest(user = Users.client).withId(T3536::class),
                ControlCodeGetTest(user = Users.bankAdmin).withId(T3537::class),
                ControlCodeGetPageTest(user = Users.client).withId(T3538::class),
                ControlCodeGetPageTest(user = Users.bankAdmin).withId(T3539::class),
                ControlCodeDeleteTest().withId(T3540::class),
                ControlCodeUpdateTest().withId(T3541::class)
            )
        )
    }

    @TestFactory
    @T3542 //'Код контроля'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3543 //'Код контроля'. Сортировка по полю 'code, ASC' [CLIENT]
    @T3544 //'Код контроля'. Сортировка по полю 'description, ASC' [CLIENT]

    @T3545 //'Код контроля'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3546 //'Код контроля'. Сортировка по полю 'code, DESC' [CLIENT]
    @T3547 //'Код контроля'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun controlCodeSortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                ControlCodeSortingTest(user, ControlCodeSortingParams.ID::asc).withId(T3542::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.CODE::asc).withId(T3543::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.DESCRIPTION::asc).withId(T3544::class),

                ControlCodeSortingTest(user, ControlCodeSortingParams.ID::desc).withId(T3545::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.CODE::desc).withId(T3546::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.DESCRIPTION::desc).withId(T3547::class)
            )
        )
    }

    @TestFactory
    @T3548 //'Код контроля'. Сортировка по полю 'id, ASC' [BANK]
    @T3549 //'Код контроля'. Сортировка по полю 'code, ASC' [BANK]
    @T3550 //'Код контроля'. Сортировка по полю 'description, ASC' [BANK]

    @T3551 //'Код контроля'. Сортировка по полю 'id, DESC' [BANK]
    @T3552 //'Код контроля'. Сортировка по полю 'code, DESC' [BANK]
    @T3553 //'Код контроля'. Сортировка по полю 'description, DESC' [BANK]
    internal fun controlCodeSortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                ControlCodeSortingTest(user, ControlCodeSortingParams.ID::asc).withId(T3548::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.CODE::asc).withId(T3549::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.DESCRIPTION::asc).withId(T3550::class),

                ControlCodeSortingTest(user, ControlCodeSortingParams.ID::desc).withId(T3551::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.CODE::desc).withId(T3552::class),
                ControlCodeSortingTest(user, ControlCodeSortingParams.DESCRIPTION::desc).withId(T3553::class)
            )
        )
    }

    @TestFactory
    @T3530 //'Код контроля'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3531 //'Код контроля'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T3532 //'Код контроля'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T3533 //'Код контроля'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3534 //'Код контроля'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun controlCodeFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                ControlCodeFiltrationTests("id equals", user, { dataForFilter },
                    { ControlCodeFilterParams.ID.eq(it!!.id!!) }).withId(T3530::class),
                ControlCodeFiltrationTests("code equals", user, { dataForFilter },
                    { ControlCodeFilterParams.CODE.eq(it!!.code!!) }).withId(T3531::class),
                ControlCodeFiltrationTests("code contains", user, { dataForFilter },
                    { ControlCodeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T3532::class),
                ControlCodeFiltrationTests("description equals", user, { dataForFilter },
                    { ControlCodeFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T3533::class),
                ControlCodeFiltrationTests("description contains", user, { dataForFilter },
                    { ControlCodeFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T3534::class)
            )
        )
    }

    @TestFactory
    @T3525 //'Код контроля'. Фильтрация по полю 'id' (eq) [BANK]
    @T3526 //'Код контроля'. Фильтрация по полю 'code' (eq) [BANK]
    @T3527 //'Код контроля'. Фильтрация по полю 'code' (contains) [BANK]
    @T3528 //'Код контроля'. Фильтрация по полю 'description' (eq) [BANK]
    @T3529 //'Код контроля'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun controlCodeFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                ControlCodeFiltrationTests("id equals", user, { dataForFilter },
                    { ControlCodeFilterParams.ID.eq(it!!.id!!) }).withId(T3525::class),
                ControlCodeFiltrationTests("code equals", user, { dataForFilter },
                    { ControlCodeFilterParams.CODE.eq(it!!.code!!) }).withId(T3526::class),
                ControlCodeFiltrationTests("code contains", user, { dataForFilter },
                    { ControlCodeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T3527::class),
                ControlCodeFiltrationTests("description equals", user, { dataForFilter },
                    { ControlCodeFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T3528::class),
                ControlCodeFiltrationTests("description contains", user, { dataForFilter },
                    { ControlCodeFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T3529::class)
            )
        )
    }
}