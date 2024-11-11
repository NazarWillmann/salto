package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_LETTER_TYPE_TO_BANK
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankControlTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankCreateTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankDeleteTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankFiltrationTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankGetPageTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankGetTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankPrepareSteps
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankSortingTest
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBank
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankControls
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankData
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankFilterParams
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankSortingParams.CODE
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankSortingParams.ID
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
@Story(DictionaryNames.LETTER_TYPE_TO_BANK)
@DisplayName("API '${DictionaryNames.LETTER_TYPE_TO_BANK}' suite")
@Execution(ExecutionMode.SAME_THREAD)
@BE_DICTIONARY_LETTER_TYPE_TO_BANK
@TestInstance(PER_CLASS)
class LetterTypeToBankTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3554") annotation class T3554
@Tag("JTCSALTO-T3555") annotation class T3555
@Tag("JTCSALTO-T3556") annotation class T3556
@Tag("JTCSALTO-T3557") annotation class T3557
@Tag("JTCSALTO-T3558") annotation class T3558
@Tag("JTCSALTO-T3559") annotation class T3559
@Tag("JTCSALTO-T3560") annotation class T3560
@Tag("JTCSALTO-T3561") annotation class T3561
@Tag("JTCSALTO-T3562") annotation class T3562
@Tag("JTCSALTO-T3563") annotation class T3563
@Tag("JTCSALTO-T3564") annotation class T3564
@Tag("JTCSALTO-T3565") annotation class T3565
@Tag("JTCSALTO-T3566") annotation class T3566
@Tag("JTCSALTO-T3567") annotation class T3567
@Tag("JTCSALTO-T3568") annotation class T3568
@Tag("JTCSALTO-T3569") annotation class T3569
@Tag("JTCSALTO-T3570") annotation class T3570
@Tag("JTCSALTO-T3571") annotation class T3571
@Tag("JTCSALTO-T3572") annotation class T3572
@Tag("JTCSALTO-T3573") annotation class T3573
@Tag("JTCSALTO-T3574") annotation class T3574
@Tag("JTCSALTO-T3575") annotation class T3575
@Tag("JTCSALTO-T3576") annotation class T3576
@Tag("JTCSALTO-T3577") annotation class T3577
@Tag("JTCSALTO-T3578") annotation class T3578
@Tag("JTCSALTO-T3579") annotation class T3579
@Tag("JTCSALTO-T3580") annotation class T3580
@Tag("JTCSALTO-T3581") annotation class T3581
@Tag("JTCSALTO-T3582") annotation class T3582
@Tag("JTCSALTO-T4230") annotation class T4230
@Tag("JTCSALTO-T4231") annotation class T4231
@Tag("JTCSALTO-T4232") annotation class T4232
@Tag("JTCSALTO-T4233") annotation class T4233
@Tag("JTCSALTO-T4234") annotation class T4234
//@formatter:on
//endregion

    private lateinit var dataForFilter: LetterTypeToBankDto
    private lateinit var testDataScope: TestDataScope<LetterTypeToBank>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = LetterTypeToBankData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3554 //'Тип письма в банк'. CRUD: Создаем запись от пользователя [BANK]
    @T3555 //'Тип письма в банк'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3556 //'Тип письма в банк'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3557 //'Тип письма в банк'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3558 //'Тип письма в банк'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3559 //'Тип письма в банк'. CRUD: Удаляем запись от пользователя [BANK]
    @T3560 //'Тип письма в банк'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun letterTypeToBankCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeToBankCreateTest().withId(T3554::class),
                LetterTypeToBankGetTest(user = Users.client).withId(T3555::class),
                LetterTypeToBankGetTest(user = Users.bankOperator).withId(T3556::class),
                LetterTypeToBankGetPageTest(user = Users.client).withId(T3557::class),
                LetterTypeToBankGetPageTest(user = Users.bankOperator).withId(T3558::class),
                LetterTypeToBankDeleteTest().withId(T3559::class),
                LetterTypeToBankUpdateTest().withId(T3560::class)
            )
        )
    }

    @TestFactory
    @T3561 //'Тип письма в банк'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3562 //'Тип письма в банк'. Сортировка по полю 'code, ASC' [CLIENT]
    @T3563 //'Тип письма в банк'. Сортировка по полю 'description, ASC' [CLIENT]

    @T3564 //'Тип письма в банк'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3565 //'Тип письма в банк'. Сортировка по полю 'code, DESC' [CLIENT]
    @T3566 //'Тип письма в банк'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun letterTypeToBankSortingClientTests(): List<DynamicTest> {
        val clientUser = Users.client
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeToBankSortingTest(clientUser, ID::asc).withId(T3561::class),
                LetterTypeToBankSortingTest(clientUser, CODE::asc).withId(T3562::class),
                LetterTypeToBankSortingTest(clientUser, DESCRIPTION::asc).withId(T3563::class),

                LetterTypeToBankSortingTest(clientUser, ID::desc).withId(T3564::class),
                LetterTypeToBankSortingTest(clientUser, CODE::desc).withId(T3565::class),
                LetterTypeToBankSortingTest(clientUser, DESCRIPTION::desc).withId(T3566::class)
            )
        )
    }

    @TestFactory
    @T3577 //'Тип письма в банк'. Сортировка по полю 'id, ASC' [BANK]
    @T3578 //'Тип письма в банк'. Сортировка по полю 'code, ASC' [BANK]
    @T3579 //'Тип письма в банк'. Сортировка по полю 'description, ASC' [BANK]

    @T3580 //'Тип письма в банк'. Сортировка по полю 'id, DESC' [BANK]
    @T3581 //'Тип письма в банк'. Сортировка по полю 'code, DESC' [BANK]
    @T3582 //'Тип письма в банк'. Сортировка по полю 'description, DESC' [BANK]
    internal fun letterTypeToBankSortingBankTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeToBankSortingTest(bankUser, ID::asc).withId(T3577::class),
                LetterTypeToBankSortingTest(bankUser, CODE::asc).withId(T3578::class),
                LetterTypeToBankSortingTest(bankUser, DESCRIPTION::asc).withId(T3579::class),

                LetterTypeToBankSortingTest(bankUser, ID::desc).withId(T3580::class),
                LetterTypeToBankSortingTest(bankUser, CODE::desc).withId(T3581::class),
                LetterTypeToBankSortingTest(bankUser, DESCRIPTION::desc).withId(T3582::class)
            )
        )
    }

    @TestFactory
    @T3567 //'Тип письма в банк'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3568 //'Тип письма в банк'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T3569 //'Тип письма в банк'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T3570 //'Тип письма в банк'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3571 //'Тип письма в банк'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun letterTypeToBankFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeToBankFiltrationTest("id equals", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.ID.eq(it!!.id!!) }).withId(T3567::class),
                LetterTypeToBankFiltrationTest("code equals", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.CODE.eq(it!!.code) }).withId(T3568::class),
                LetterTypeToBankFiltrationTest("code contains", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.CODE.contains(it!!.code.randomSubstringPf()) }).withId(T3569::class),
                LetterTypeToBankFiltrationTest("description equals", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T3570::class),
                LetterTypeToBankFiltrationTest("description contains", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3571::class)
            )
        )
    }

    @TestFactory
    @T3572 //'Тип письма в банк'. Фильтрация по полю 'id' (eq) [BANK]
    @T3573 //'Тип письма в банк'. Фильтрация по полю 'code' (eq) [BANK]
    @T3574 //'Тип письма в банк'. Фильтрация по полю 'code' (contains) [BANK]
    @T3575 //'Тип письма в банк'. Фильтрация по полю 'description' (eq) [BANK]
    @T3576 //'Тип письма в банк'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun letterTypeToBankFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankOperator
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeToBankFiltrationTest("id equals", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.ID.eq(it!!.id!!) }).withId(T3572::class),
                LetterTypeToBankFiltrationTest("code equals", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.CODE.eq(it!!.code) }).withId(T3573::class),
                LetterTypeToBankFiltrationTest("code contains", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.CODE.contains(it!!.code.randomSubstringPf()) }).withId(T3574::class),
                LetterTypeToBankFiltrationTest("description equals", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.DESCRIPTION.eq(it!!.description) }).withId(T3575::class),
                LetterTypeToBankFiltrationTest("description contains", user, { dataForFilter },
                    { LetterTypeToBankFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3576::class)
            )
        )
    }

    @TestFactory
    @T4230 //'Тип письма в банк'. Контроль: Контроль кода типа письма в банк на непустоту. [BANK]
    @T4231 //'Тип письма в банк'. Контроль: Контроль длины кода типа письма в банк. [BANK]
    @T4232 //'Тип письма в банк'. Контроль: Контроль кода типа письма в банк на допустимые символы. [BANK]
    @T4233 //'Тип письма в банк'. Контроль: Контроль описания типа письма в банк на непустоту. [BANK]
    @T4234 //'Тип письма в банк'. Контроль: Контроль длины описания типа письма в банк. [BANK]
    internal fun letterTypeToBankControlTests(): List<DynamicTest> {
        val getDto = { LetterTypeToBankPrepareSteps.getLetterTypeToBankDtoForCreate() }
        return EntityTestGenerator.generate(
            listOf(
                LetterTypeToBankControlTest(
                    testName = "Контроль кода типа письма в банк на непустоту",
                    preExecution = { getDto.invoke().copy(code = "") },
                    control = LetterTypeToBankControls.CODE_EMPTY
                ).withId(T4230::class),
                // [2020.08.10]: control is turned off
//                LetterTypeToBankControlTest(
//                    testName = "Контроль длины кода типа письма в банк",
//                    preExecution = { getDto.invoke().copy(code = RandomData("[1-9]*").random(31)) },
//                    control = LetterTypeToBankControls.CODE_MAX_LENGTH.withParams("length" to "30")
//                ).withId(T4231::class),
                LetterTypeToBankControlTest(
                    testName = "Контроль кода типа письма в банк на допустимые символы",
                    preExecution = { getDto.invoke().copy(code = "Д1") },
                    control = LetterTypeToBankControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "Д")
                ).withId(T4232::class),
                LetterTypeToBankControlTest(
                    testName = "Контроль описания типа письма в банк на непустоту",
                    preExecution = { getDto.invoke().copy(description = "") },
                    control = LetterTypeToBankControls.DESCRIPTION_EMPTY
                ).withId(T4233::class),
                LetterTypeToBankControlTest(
                    testName = "Контроль длины описания типа письма в банк",
                    preExecution = { getDto.invoke().copy(description = RandomData("[0-9A-Z]*").random(length = 101)) },
                    control = LetterTypeToBankControls.DESCRIPTION_MAX_LENGTH.withParams("length" to "100")
                ).withId(T4234::class)
            )
        )
    }
}