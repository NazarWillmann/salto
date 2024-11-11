package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_LETTER_TYPE_FROM_BANK
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankControlTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankCreateTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankDeleteTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankFiltrationTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankGetPageTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankGetTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankPrepareSteps
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankSortingTest
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBank
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankControls
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankData
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankFilterParams
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankSortingParams.CODE
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankSortingParams.ID
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
@Story(DictionaryNames.LETTER_TYPE_FROM_BANK)
@DisplayName("API '${DictionaryNames.LETTER_TYPE_FROM_BANK}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_LETTER_TYPE_FROM_BANK
@TestInstance(PER_CLASS)
class LetterTypeFromBankTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3583") annotation class T3583
@Tag("JTCSALTO-T3584") annotation class T3584
@Tag("JTCSALTO-T3585") annotation class T3585
@Tag("JTCSALTO-T3586") annotation class T3586
@Tag("JTCSALTO-T3587") annotation class T3587
@Tag("JTCSALTO-T3588") annotation class T3588
@Tag("JTCSALTO-T3589") annotation class T3589
@Tag("JTCSALTO-T3590") annotation class T3590
@Tag("JTCSALTO-T3591") annotation class T3591
@Tag("JTCSALTO-T3592") annotation class T3592
@Tag("JTCSALTO-T3593") annotation class T3593
@Tag("JTCSALTO-T3594") annotation class T3594
@Tag("JTCSALTO-T3595") annotation class T3595
@Tag("JTCSALTO-T3596") annotation class T3596
@Tag("JTCSALTO-T3597") annotation class T3597
@Tag("JTCSALTO-T3598") annotation class T3598
@Tag("JTCSALTO-T3599") annotation class T3599
@Tag("JTCSALTO-T3600") annotation class T3600
@Tag("JTCSALTO-T3601") annotation class T3601
@Tag("JTCSALTO-T3602") annotation class T3602
@Tag("JTCSALTO-T3603") annotation class T3603
@Tag("JTCSALTO-T3604") annotation class T3604
@Tag("JTCSALTO-T3605") annotation class T3605
@Tag("JTCSALTO-T3606") annotation class T3606
@Tag("JTCSALTO-T3607") annotation class T3607
@Tag("JTCSALTO-T3608") annotation class T3608
@Tag("JTCSALTO-T3609") annotation class T3609
@Tag("JTCSALTO-T3610") annotation class T3610
@Tag("JTCSALTO-T3611") annotation class T3611
@Tag("JTCSALTO-T4225") annotation class T4225
@Tag("JTCSALTO-T4226") annotation class T4226
@Tag("JTCSALTO-T4227") annotation class T4227
@Tag("JTCSALTO-T4228") annotation class T4228
@Tag("JTCSALTO-T4229") annotation class T4229
//@formatter:on
//endregion

    private lateinit var dataForFilter: LetterTypeFromBankDto
    private lateinit var testDataScope: TestDataScope<LetterTypeFromBank>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = LetterTypeFromBankData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3583 //'Тип письма из банка'. CRUD: Создаем запись от пользователя [BANK]
    @T3584 //'Тип письма из банка'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3585 //'Тип письма из банка'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3586 //'Тип письма из банка'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3587 //'Тип письма из банка'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3588 //'Тип письма из банка'. CRUD: Удаляем запись от пользователя [BANK]
    @T3589 //'Тип письма из банка'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun letterTypeFromBankCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeFromBankCreateTest().withId(T3583::class),
                LetterTypeFromBankGetTest(user = Users.client).withId(T3584::class),
                LetterTypeFromBankGetTest(user = Users.bankOperator).withId(T3585::class),
                LetterTypeFromBankGetPageTest(user = Users.client).withId(T3586::class),
                LetterTypeFromBankGetPageTest(user = Users.bankOperator).withId(T3587::class),
                LetterTypeFromBankDeleteTest().withId(T3588::class),
                LetterTypeFromBankUpdateTest().withId(T3589::class)
            )
        )
    }

    @TestFactory
    @T3590 //'Тип письма из банка'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3591 //'Тип письма из банка'. Сортировка по полю 'code, ASC' [CLIENT]
    @T3592 //'Тип письма из банка'. Сортировка по полю 'description, ASC' [CLIENT]

    @T3593 //'Тип письма из банка'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3594 //'Тип письма из банка'. Сортировка по полю 'code, DESC' [CLIENT]
    @T3595 //'Тип письма из банка'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun letterTypeFromBankSortingClientTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeFromBankSortingTest(clientUser, ID::asc).withId(T3590::class),
                LetterTypeFromBankSortingTest(clientUser, CODE::asc).withId(T3591::class),
                LetterTypeFromBankSortingTest(clientUser, DESCRIPTION::asc).withId(T3592::class),

                LetterTypeFromBankSortingTest(clientUser, ID::desc).withId(T3593::class),
                LetterTypeFromBankSortingTest(clientUser, CODE::desc).withId(T3594::class),
                LetterTypeFromBankSortingTest(clientUser, DESCRIPTION::desc).withId(T3595::class)
            )
        )
    }

    @TestFactory
    @T3601 //'Тип письма из банка'. Сортировка по полю 'id, ASC' [BANK]
    @T3602 //'Тип письма из банка'. Сортировка по полю 'code, ASC' [BANK]
    @T3603 //'Тип письма из банка'. Сортировка по полю 'description, ASC' [BANK]

    @T3604 //'Тип письма из банка'. Сортировка по полю 'id, DESC' [BANK]
    @T3605 //'Тип письма из банка'. Сортировка по полю 'code, DESC' [BANK]
    @T3606 //'Тип письма из банка'. Сортировка по полю 'description, DESC' [BANK]
    internal fun letterTypeFromBankSortingBankTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeFromBankSortingTest(bankUser, ID::asc).withId(T3601::class),
                LetterTypeFromBankSortingTest(bankUser, CODE::asc).withId(T3602::class),
                LetterTypeFromBankSortingTest(bankUser, DESCRIPTION::asc).withId(T3603::class),

                LetterTypeFromBankSortingTest(bankUser, ID::desc).withId(T3604::class),
                LetterTypeFromBankSortingTest(bankUser, CODE::desc).withId(T3605::class),
                LetterTypeFromBankSortingTest(bankUser, DESCRIPTION::desc).withId(T3606::class)
            )
        )
    }

    @TestFactory
    @T3596 //'Тип письма из банка'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3597 //'Тип письма из банка'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T3598 //'Тип письма из банка'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T3599 //'Тип письма из банка'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3600 //'Тип письма из банка'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun letterTypeFromBankFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeFromBankFiltrationTest("id equals", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.ID.eq(it!!.id!!) }).withId(T3596::class),
                LetterTypeFromBankFiltrationTest("code equals", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.CODE.eq(it!!.code) }).withId(T3597::class),
                LetterTypeFromBankFiltrationTest("code contains", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.CODE.contains(it!!.code.randomSubstringPf()) }).withId(T3598::class),
                LetterTypeFromBankFiltrationTest("description equals", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T3599::class),
                LetterTypeFromBankFiltrationTest("description contains", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3600::class)
            )
        )
    }

    @TestFactory
    @T3607 //'Тип письма из банка'. Фильтрация по полю 'id' (eq) [BANK]
    @T3608 //'Тип письма из банка'. Фильтрация по полю 'code' (eq) [BANK]
    @T3609 //'Тип письма из банка'. Фильтрация по полю 'code' (contains) [BANK]
    @T3610 //'Тип письма из банка'. Фильтрация по полю 'description' (eq) [BANK]
    @T3611 //'Тип письма из банка'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun letterTypeFromBankFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeFromBankFiltrationTest("id equals", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.ID.eq(it!!.id!!) }).withId(T3607::class),
                LetterTypeFromBankFiltrationTest("code equals", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.CODE.eq(it!!.code) }).withId(T3608::class),
                LetterTypeFromBankFiltrationTest("code contains", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.CODE.contains(it!!.code.randomSubstringPf()) }).withId(T3609::class),
                LetterTypeFromBankFiltrationTest("description equals", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T3610::class),
                LetterTypeFromBankFiltrationTest("description contains", user, { dataForFilter },
                    { LetterTypeFromBankFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3611::class)
            )
        )
    }

    @TestFactory
    @T4225 //'Тип письма из банка'. Контроль: Контроль кода типа письма из банка на непустоту. [BANK]
    @T4226 //'Тип письма из банка'. Контроль: Контроль длины кода типа письма из банка. [BANK]
    @T4227 //'Тип письма из банка'. Контроль: Контроль кода типа письма из банка на допустимые символы. [BANK]
    @T4228 //'Тип письма из банка'. Контроль: Контроль описания типа письма из банка на непустоту. [BANK]
    @T4229 //'Тип письма из банка'. Контроль: Контроль длины описания типа письма из банка. [BANK]
    internal fun letterTypeFromBankControlTests(): List<DynamicTest> {
        val getDto = { LetterTypeFromBankPrepareSteps.getLetterTypeFromBankDtoForCreate() }
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeFromBankControlTest(
                    testName = "Контроль кода типа письма из банка на непустоту",
                    preExecution = { getDto.invoke().copy(code = "") },
                    control = LetterTypeFromBankControls.CODE_EMPTY
                ).withId(T4225::class),
                // [2020.08.10]: control is turned off
//                LetterTypeFromBankControlTest(
//                    testName = "Контроль длины кода типа письма из банка",
//                    preExecution = { getDto.invoke().copy(code = RandomData("[1-9]*").random(31)) },
//                    control = LetterTypeFromBankControls.CODE_MAX_LENGTH.withParams("length" to "30")
//                ).withId(T4226::class),
                LetterTypeFromBankControlTest(
                    testName = "Контроль кода типа письма из банка на допустимые символы",
                    preExecution = { getDto.invoke().copy(code = "Д1") },
                    control = LetterTypeFromBankControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "Д")
                ).withId(T4227::class),
                LetterTypeFromBankControlTest(
                    testName = "Контроль описания типа письма из банка на непустоту",
                    preExecution = { getDto.invoke().copy(description = "") },
                    control = LetterTypeFromBankControls.DESCRIPTION_EMPTY
                ).withId(T4228::class),
                LetterTypeFromBankControlTest(
                    testName = "Контроль длины описания типа письма из банка",
                    preExecution = { getDto.invoke().copy(description = RandomData("[0-9A-Z]*").random(length = 101)) },
                    control = LetterTypeFromBankControls.DESCRIPTION_MAX_LENGTH.withParams("length" to "100")
                ).withId(T4229::class)
            )
        )
    }
}