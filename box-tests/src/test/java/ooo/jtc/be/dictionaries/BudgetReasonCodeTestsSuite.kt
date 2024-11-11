package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BUDGETREASONCODE
import ooo.jtc.api.common.controls.IControls.Companion.getForbiddenSymbolsMessage
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeControlTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeCreateTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeDefaultsTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeDeleteTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeFilterTests
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeGetPageTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeGetTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodePrepareSteps.codeChars
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodePrepareSteps.getBudgetReasonCodeDtoForCreate
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeServerErrorTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeSortingTest
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeSteps
import ooo.jtc.api.dictionaries.budgetreasoncode.BudgetReasonCodeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.ServiceErrors.PSQL_EXCEPTION
import ooo.jtc.core.ServiceErrors.UNIQUE_CONSTRAINT_VIOLATION
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_EXPECT
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_REQUEST
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCode
import ooo.jtc.dictionaries.budgetreasoncode.BudgetReasonCodeDto
import ooo.jtc.dictionaries.budgetreasoncode.PayType
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.allAllowedChars
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.CODE_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.CODE_LENGTH
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.CODE_NOT_EMPTY
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.DESCRIPTION_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.DESCRIPTION_LENGTH
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.HINT_108_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.HINT_108_LENGTH
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.HINT_109_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeControls.HINT_109_LENGTH
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeData
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams.CODE
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams.ID
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeFilterParams.PAY_TYPE
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeSortingParams
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
@Story(DictionaryNames.BUDGET_REASON_CODE)
@DisplayName("API '${DictionaryNames.BUDGET_REASON_CODE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BUDGETREASONCODE
@TestInstance(PER_CLASS)
class BudgetReasonCodeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3052") annotation class T3052
@Tag("JTCSALTO-T3053") annotation class T3053
@Tag("JTCSALTO-T3054") annotation class T3054
@Tag("JTCSALTO-T3055") annotation class T3055
@Tag("JTCSALTO-T3056") annotation class T3056
@Tag("JTCSALTO-T3057") annotation class T3057
@Tag("JTCSALTO-T3058") annotation class T3058
@Tag("JTCSALTO-T3060") annotation class T3060
@Tag("JTCSALTO-T3061") annotation class T3061
@Tag("JTCSALTO-T3062") annotation class T3062
@Tag("JTCSALTO-T3064") annotation class T3064
@Tag("JTCSALTO-T3065") annotation class T3065
@Tag("JTCSALTO-T3066") annotation class T3066
@Tag("JTCSALTO-T3068") annotation class T3068
@Tag("JTCSALTO-T3069") annotation class T3069
@Tag("JTCSALTO-T3070") annotation class T3070
@Tag("JTCSALTO-T3072") annotation class T3072
@Tag("JTCSALTO-T3073") annotation class T3073
@Tag("JTCSALTO-T3074") annotation class T3074
@Tag("JTCSALTO-T3075") annotation class T3075
@Tag("JTCSALTO-T3076") annotation class T3076
@Tag("JTCSALTO-T3077") annotation class T3077
@Tag("JTCSALTO-T3078") annotation class T3078
@Tag("JTCSALTO-T3079") annotation class T3079
@Tag("JTCSALTO-T3080") annotation class T3080
@Tag("JTCSALTO-T3081") annotation class T3081
@Tag("JTCSALTO-T3082") annotation class T3082
@Tag("JTCSALTO-T3083") annotation class T3083
@Tag("JTCSALTO-T3084") annotation class T3084
@Tag("JTCSALTO-T3085") annotation class T3085
@Tag("JTCSALTO-T3086") annotation class T3086
@Tag("JTCSALTO-T5320") annotation class T5320
@Tag("JTCSALTO-T5321") annotation class T5321
@Tag("JTCSALTO-T5322") annotation class T5322
@Tag("JTCSALTO-T6676") annotation class T6676
@Tag("JTCSALTO-T6677") annotation class T6677
@Tag("JTCSALTO-T6678") annotation class T6678
@Tag("JTCSALTO-T6679") annotation class T6679
@Tag("JTCSALTO-T6680") annotation class T6680
@Tag("JTCSALTO-T6681") annotation class T6681
@Tag("JTCSALTO-T6682") annotation class T6682
@Tag("JTCSALTO-T6683") annotation class T6683
@Tag("JTCSALTO-T6684") annotation class T6684
@Tag("JTCSALTO-T6690") annotation class T6690
//@formatter:on
//endregion


    private lateinit var dataForFilter: BudgetReasonCodeDto
    private lateinit var testDataScope: TestDataScope<BudgetReasonCode>

    @BeforeAll
    fun prepareBudgetReasonCodeTestData() {
        BudgetReasonCodeData.cleanAtCreated()
        testDataScope = BudgetReasonCodeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanBudgetReasonCodeTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3052 //'Основание платежа'. CRUD: Создаем запись от пользователя [BANK]
    @T3053 //'Основание платежа'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3054 //'Основание платежа'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3055 //'Основание платежа'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3056 //'Основание платежа'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3057 //'Основание платежа'. CRUD: Удаляем запись от пользователя [BANK]
    @T3058 //'Основание платежа'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun budgetReasonCodeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeCreateTest().withId(T3052::class),
                BudgetReasonCodeGetTest(user = client).withId(T3053::class),
                BudgetReasonCodeGetTest(user = bankAdmin).withId(T3054::class),
                BudgetReasonCodeGetPageTest(user = client).withId(T3055::class),
                BudgetReasonCodeGetPageTest(user = bankAdmin).withId(T3056::class),
                BudgetReasonCodeDeleteTest(user = bankAdmin).withId(T3057::class),
                BudgetReasonCodeUpdateTest(user = bankAdmin).withId(T3058::class)
            )
        )
    }

    @TestFactory
    @T3060 //'Основание платежа'. Сортировка по полю 'code, ASC' [CLIENT]
    @T3061 //'Основание платежа'. Сортировка по полю 'payType, ASC' [CLIENT]
    @T3062 //'Основание платежа'. Сортировка по полю 'description, ASC' [CLIENT]
    @T3064 //'Основание платежа'. Сортировка по полю 'code, DESC' [CLIENT]
    @T3065 //'Основание платежа'. Сортировка по полю 'payType, DESC' [CLIENT]
    @T3066 //'Основание платежа'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun budgetReasonCodeSortingClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeSortingTest(
                    user = client,
                    sortRequestFunction = BudgetReasonCodeSortingParams.CODE::asc
                ).withId(T3060::class),
                BudgetReasonCodeSortingTest(
                    user = client,
                    sortRequestFunction = BudgetReasonCodeSortingParams.PAY_TYPE::asc
                ).withId(T3061::class),
                BudgetReasonCodeSortingTest(
                    user = client,
                    sortRequestFunction = BudgetReasonCodeSortingParams.DESCRIPTION::asc
                ).withId(T3062::class),
                BudgetReasonCodeSortingTest(
                    user = client,
                    sortRequestFunction = BudgetReasonCodeSortingParams.CODE::desc
                ).withId(T3064::class),
                BudgetReasonCodeSortingTest(
                    user = client,
                    sortRequestFunction = BudgetReasonCodeSortingParams.PAY_TYPE::desc
                ).withId(T3065::class),
                BudgetReasonCodeSortingTest(
                    user = client,
                    sortRequestFunction = BudgetReasonCodeSortingParams.DESCRIPTION::desc
                ).withId(T3066::class)
            )
        )
    }

    @TestFactory
    @T3068 //'Основание платежа'. Сортировка по полю 'code, ASC' [BANK]
    @T3069 //'Основание платежа'. Сортировка по полю 'payType, ASC' [BANK]
    @T3070 //'Основание платежа'. Сортировка по полю 'description, ASC' [BANK]
    @T3072 //'Основание платежа'. Сортировка по полю 'code, DESC' [BANK]
    @T3073 //'Основание платежа'. Сортировка по полю 'payType, DESC' [BANK]
    @T3074 //'Основание платежа'. Сортировка по полю 'description, DESC' [BANK]
    internal fun budgetReasonCodeSortingBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeSortingTest(
                    user = bankAdmin,
                    sortRequestFunction = BudgetReasonCodeSortingParams.CODE::asc
                ).withId(T3068::class),
                BudgetReasonCodeSortingTest(
                    user = bankAdmin,
                    sortRequestFunction = BudgetReasonCodeSortingParams.PAY_TYPE::asc
                ).withId(T3069::class),
                BudgetReasonCodeSortingTest(
                    user = bankAdmin,
                    sortRequestFunction = BudgetReasonCodeSortingParams.DESCRIPTION::asc
                ).withId(T3070::class),
                BudgetReasonCodeSortingTest(
                    user = bankAdmin,
                    sortRequestFunction = BudgetReasonCodeSortingParams.CODE::desc
                ).withId(T3072::class),
                BudgetReasonCodeSortingTest(
                    user = bankAdmin,
                    sortRequestFunction = BudgetReasonCodeSortingParams.PAY_TYPE::desc
                ).withId(T3073::class),
                BudgetReasonCodeSortingTest(
                    user = bankAdmin,
                    sortRequestFunction = BudgetReasonCodeSortingParams.DESCRIPTION::desc
                ).withId(T3074::class)
            )
        )
    }

    @TestFactory
    @T3075 //'Основание платежа'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3076 //'Основание платежа'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T3077 //'Основание платежа'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T3078 //'Основание платежа'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3079 //'Основание платежа'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T3080 //'Основание платежа'. Фильтрация по полю 'payType' (eq) [CLIENT]
    internal fun budgetReasonCodeFiltrationClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeFilterTests(
                    name = "id equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { ID.eq(it!!.id!!) }
                ).withId(T3075::class),
                BudgetReasonCodeFilterTests(
                    name = "code equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { CODE.eq(it!!.code!!) }
                ).withId(T3076::class),
                BudgetReasonCodeFilterTests(
                    name = "code contains",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { CODE.contains(it!!.code!!.randomSubstringPf()) }
                ).withId(T3077::class),
                BudgetReasonCodeFilterTests(
                    name = "description equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { DESCRIPTION.eq(it!!.description!!) }
                ).withId(T3078::class),
                BudgetReasonCodeFilterTests(
                    name = "description contains",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }
                ).withId(T3079::class),
                BudgetReasonCodeFilterTests(
                    name = "pay type equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { PAY_TYPE.eq(it!!.payType!!) }
                ).withId(T3080::class)
            )
        )
    }

    @TestFactory
    @T3081 //'Основание платежа'. Фильтрация по полю 'id' (eq) [BANK]
    @T3082 //'Основание платежа'. Фильтрация по полю 'code' (eq) [BANK]
    @T3083 //'Основание платежа'. Фильтрация по полю 'code' (contains) [BANK]
    @T3084 //'Основание платежа'. Фильтрация по полю 'description' (eq) [BANK]
    @T3085 //'Основание платежа'. Фильтрация по полю 'description' (contains) [BANK]
    @T3086 //'Основание платежа'. Фильтрация по полю 'payType' (eq) [BANK]
    internal fun budgetReasonCodeFiltrationBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeFilterTests(
                    name = "id equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { ID.eq(it!!.id!!) }
                ).withId(T3081::class),
                BudgetReasonCodeFilterTests(
                    name = "code equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { CODE.eq(it!!.code!!) }
                ).withId(T3082::class),
                BudgetReasonCodeFilterTests(
                    name = "code contains",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { CODE.contains(it!!.code!!.randomSubstringPf()) }
                ).withId(T3083::class),
                BudgetReasonCodeFilterTests(
                    name = "description equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { DESCRIPTION.eq(it!!.description!!) }
                ).withId(T3084::class),
                BudgetReasonCodeFilterTests(
                    name = "description contains",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }
                ).withId(T3085::class),
                BudgetReasonCodeFilterTests(
                    name = "pay type equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { PAY_TYPE.eq(it!!.payType!!) }
                ).withId(T3086::class)
            )
        )
    }

    @TestFactory
    @T6683 //'Основание платежа'. Контроль: показателя основания платежа на непустоту (null) [BANK]
    @T6684 //'Основание платежа'. Контроль: показателя основания платежа на непустоту (пробельные символы) [BANK]
    @T5320 //'Основание платежа'. Контроль: длины показателя основания платежа (меньше требуемого значения) [BANK]
    @T5321 //'Основание платежа'. Контроль: длины показателя основания платежа (больше требуемого значения) [BANK]
    @T5322 //'Основание платежа'. Контроль: показателя основания платежа на допустимые символы [BANK]
    @T6676 //'Основание платежа'. Контроль: длины описания показателя основания платежа [BANK]
    @T6682 //'Основание платежа'. Контроль: уникальности описания показателя основания платежа. [BANK]
    @T6677 //'Основание платежа'. Контроль: описания показателя основания платежа на допустимые символы [BANK]
    @T6678 //'Основание платежа'. Контроль: длины подсказки к полю 108 [BANK]
    @T6679 //'Основание платежа'. Контроль: подсказки к полю 108 на допустимые символы [BANK]
    @T6680 //'Основание платежа'. Контроль: длины подсказки к полю 109 [BANK]
    @T6681 //'Основание платежа'. Контроль: подсказки к полю 109 на допустимые символы [BANK]
    internal fun budgetReasonCodeControlTests(): List<DynamicTest> {
        val invalidCode = RandomData.builder()
            .withLatinAlphabet()
            .withRussianSmallLetters()
            .withSpecialCharacters()
            .build()
            .random(length = 2)

        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeControlTest(
                    testName = "показателя основания платежа на непустоту (null)",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { code = null } },
                    control = CODE_NOT_EMPTY
                ).withId(T6683::class),
                BudgetReasonCodeControlTest(
                    testName = "показателя основания платежа на непустоту (пробельные символы)",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { code = RandomData.getEmptyString(length = 2) } },
                    control = CODE_NOT_EMPTY
                ).withId(T6684::class),
                BudgetReasonCodeControlTest(
                    testName = "длины показателя основания платежа (меньше требуемого значения)",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { code = codeChars.random(length = 1) } },
                    control = CODE_LENGTH
                ).withId(T5320::class),
                BudgetReasonCodeControlTest(
                    testName = "длины показателя основания платежа (больше требуемого значения)",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { code = codeChars.random(length = 3) } },
                    control = CODE_LENGTH
                ).withId(T5321::class),
                BudgetReasonCodeControlTest(
                    testName = "показателя основания платежа на допустимые символы",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { code = invalidCode } },
                    control = CODE_ALLOWED_SYMBOLS.withParams("symbols" to getForbiddenSymbolsMessage(invalidCode))
                ).withId(T5322::class),
                BudgetReasonCodeControlTest(
                    testName = "длины описания показателя основания платежа",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { description = allAllowedChars.random(length = 501) } },
                    control = DESCRIPTION_LENGTH
                ).withId(T6676::class),
                BudgetReasonCodeServerErrorTest(
                    testName = "уникальности описания показателя основания платежа",
                    preExecution = {
                        val existingBudgetReasonCode = testDataScope.consumed.random().toDto()
                        existingBudgetReasonCode.id = null
                        existingBudgetReasonCode
                    },
                    expectedCode = 603,
                    expectedMessage = PSQL_EXCEPTION + UNIQUE_CONSTRAINT_VIOLATION.format("budget_reason_code_description_uk")
                ).withId(T6682::class),
                BudgetReasonCodeControlTest(
                    testName = "описания показателя основания платежа на допустимые символы",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { description = CONTROL_INVALID_CHARS_REQUEST } },
                    control = DESCRIPTION_ALLOWED_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T6677::class),
                BudgetReasonCodeControlTest(
                    testName = "длины подсказки к полю 108",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { hint108 = allAllowedChars.random(length = 601) } },
                    control = HINT_108_LENGTH
                ).withId(T6678::class),
                BudgetReasonCodeControlTest(
                    testName = "подсказки к полю 108 на допустимые символы",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { hint108 = CONTROL_INVALID_CHARS_REQUEST } },
                    control = HINT_108_ALLOWED_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T6679::class),
                BudgetReasonCodeControlTest(
                    testName = "длины подсказки к полю 109",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { hint109 = allAllowedChars.random(length = 601) } },
                    control = HINT_109_LENGTH
                ).withId(T6680::class),
                BudgetReasonCodeControlTest(
                    testName = "подсказки к полю 109 на допустимые символы",
                    preExecution = { getBudgetReasonCodeDtoForCreate().apply { hint109 = CONTROL_INVALID_CHARS_REQUEST } },
                    control = HINT_109_ALLOWED_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T6681::class)
            )
        )
    }

    @TestFactory
    @T6690 //'Основание платежа'. Наполнение
    internal fun budgetReasonCodeDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetReasonCodeDefaultsTest(
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.description == expectedEntity.description }
                                BudgetReasonCodeSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Основание платежа со следующим описанием не найдено: '${expectedEntity.description}'")
                            }
                        }
                    }
                ).withId(T6690::class)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<BudgetReasonCode> {
        return listOf(
            BudgetReasonCode(
                code = "ТП",
                description = "Платежи текущего года",
                payType = PayType.TAX,
                hint108 = "Номер документа, на основании которого осуществляется платеж. В случае отсутствия такого документа указывается \"0\"",
                hint109 = "Дата подписания налоговой декларации (расчета), представленной в налоговый орган, налогоплательщиком (уполномоченным лицом), или дата иного документа, на основании которого осуществляется платеж. В случае отсутствия такого документа указывается \"0\""
            ),
            BudgetReasonCode(
                code = "ЗД",
                description = "Погашение задолженности, по истекшим налоговым, расчетным (отчетным) периодам, в том числе добровольно",
                payType = PayType.TAX,
                hint108 = "Номер требования налогового органа об уплате налога, сбора, страховых взносов (ТР); номер решения о приостановлении взыскания (ПР); номер решения о привлечении к ответственности за совершение налогового правонарушения или об отказе в привлечении к ответственности за совершение налогового правонарушения (АП); номер исполнительного документа и возбужденного на основании его исполнительного производства (АР). Первые два знака номера обозначают тип документа (ТР, ПР, АП, АР). В случае добровольного погашения задолженности указывается \"0\"",
                hint109 = "Дата требования налогового органа об уплате налога (сбора, страховых взносов); дата решения о приостановлении взыскания; дата решения о привлечении к ответственности за совершение налогового правонарушения или об отказе в привлечении к ответственности за совершение налогового правонарушения; дата исполнительного документа и возбужденного на его основании исполнительного производства. В случае добровольного погашения задолженности указывается \"0\""
            ),
            BudgetReasonCode(
                code = "РС",
                description = "Погашение рассроченной задолженности",
                payType = PayType.TAX,
                hint108 = "Номер решения о рассрочке",
                hint109 = "Дата решения о рассрочке"
            ),
            BudgetReasonCode(
                code = "ОТ",
                description = "Погашение отсроченной задолженности",
                payType = PayType.TAX,
                hint108 = "Номер решения об отсрочке",
                hint109 = "Дата решения об отсрочке"
            ),
            BudgetReasonCode(
                code = "РТ",
                description = "Погашение реструктурируемой задолженности",
                payType = PayType.TAX,
                hint108 = "Номер решения о реструктуризации",
                hint109 = "Дата решения о реструктуризации"
            ),
            BudgetReasonCode(
                code = "ПБ",
                description = "Погашение должником задолженности в ходе процедур, применяемых в деле о банкротстве",
                payType = PayType.TAX,
                hint108 = "Номер дела или материала, рассмотренного арбитражным судом",
                hint109 = "Дата дела или материала, рассмотренного арбитражным судом"
            ),
            BudgetReasonCode(
                code = "ИН",
                description = "Погашение инвестиционного налогового кредита",
                payType = PayType.TAX,
                hint108 = "Номер решения о предоставлении инвестиционного налогового кредита",
                hint109 = "Дата решения о предоставлении инвестиционного налогового кредита"
            ),
            BudgetReasonCode(
                code = "ТЛ",
                description = "Погашение учредителем (участником) должника, собственником имущества должника-унитарного предприятия или третьим лицом требований к должнику об уплате обязательных платежей в ходе процедур, применяемых в деле о банкротстве",
                payType = PayType.TAX,
                hint108 = "Номер определения арбитражного суда об удовлетворении заявления о намерении погасить требования к должнику",
                hint109 = "Дата определения арбитражного суда об удовлетворении заявления о намерении погасить требования к должнику"
            ),
            BudgetReasonCode(
                code = "ЗТ",
                description = "Погашение текущей задолженности в ходе процедур, применяемых в деле о банкротстве",
                payType = PayType.TAX,
                hint108 = "Номер документа, предназначенного для погашения текущей задолженности в ходе процедуры банкротства. В случае отсутствия такого документа указывается \"0\"",
                hint109 = "Дата документа, предназначенного для погашения текущей задолженности в ходе процедуры банкротства. В случае отсутствия такого документа указывается \"0\""
            ),
            BudgetReasonCode(
                code = "ПК",
                description = "Таможенный приходный ордер",
                payType = PayType.CUSTOM,
                hint108 = "Последние 7 цифр номера таможенного приходного ордера",
                hint109 = "Дата таможенного приходного ордера"
            ),
            BudgetReasonCode(
                code = "КЭ",
                description = "Квитанция физического лица-получателя товаров, перемещаемых в качестве экспресс-грузов",
                payType = PayType.CUSTOM,
                hint108 = "Последний элемент квитанции физического лица-получателя товаров, перемещаемых в качестве экспресс-грузов, а в случае если элемент состоит более чем из 15 символов, указывается последние 15 символов последнего элемента квитанции получателя товаров, перемещаемых в качестве экспресс-грузов",
                hint109 = "Дата квитанции физического лица-получателя товаров, перемещаемых в качестве экспресс-грузов"
            ),
            BudgetReasonCode(
                code = "УВ",
                description = "Уведомление (уточнение к уведомлению) о не уплаченных в установленный срок суммах таможенных платежей, специальных, антидемпинговых, компенсационных пошлин, процентов и пеней, платежи по которому уплачиваются плательщиками таможенных платежей в соответствии со статьями 26 - 28 Федерального закона от 3 августа 2018 г. N 289-ФЗ \"О таможенном регулировании в Российской Федерации и о внесении изменений в отдельные законодательные акты Российской Федерации\"",
                payType = PayType.CUSTOM,
                hint108 = "Последние 7 цифр номера уведомления о не уплаченных в установленный срок суммах таможенных платежей, специальных, антидемпинговых, компенсационных пошлин, процентов и пеней",
                hint109 = "Дата уведомления о не уплаченных в установленный срок суммах таможенных платежей, специальных, антидемпинговых, компенсационных, пошлин, процентов и пени"
            ),
            BudgetReasonCode(
                code = "ИЛ",
                description = "Исполнительный лист",
                payType = PayType.CUSTOM,
                hint108 = "Номер исполнительного листа",
                hint109 = "Дата исполнительного листа"
            ),
            BudgetReasonCode(
                code = "ПБ",
                description = "Поручение таможенного органа на бесспорное взыскание",
                payType = PayType.CUSTOM,
                hint108 = "Номер поручения таможенного органа на бесспорное взыскание",
                hint109 = "Дата поручения таможенного органа на бесспорное взыскание"
            ),
            BudgetReasonCode(
                code = "ТГ",
                description = "Требование об уплате денежных средств гарантирующим объединением (ассоциацией)",
                payType = PayType.CUSTOM,
                hint108 = "Последние 7 цифр номера требования об уплате денежных средств гарантирующим объединением (ассоциацией)",
                hint109 = "Дата требования об уплате денежных средств гарантирующим объединением (ассоциацией)"
            ),
            BudgetReasonCode(
                code = "ТБ",
                description = "Требование об уплате суммы по банковской гарантии или договору поручительства, если уплата денежных средств производится по банковской гарантии",
                payType = PayType.CUSTOM,
                hint108 = "Последние 7 цифр номера требования об уплате денежной суммы по банковской гарантии или договору поручительства",
                hint109 = "Дата требования об уплате денежной суммы по банковской гарантии или договору поручительства"
            ),
            BudgetReasonCode(
                code = "ТД",
                description = "Требование об уплате суммы по банковской гарантии или договору поручительства, если уплата денежных средств производится по договору поручительства",
                payType = PayType.CUSTOM,
                hint108 = "Последние 7 цифр номера требования об уплате денежной суммы по банковской гарантии или договору поручительства",
                hint109 = "Дата требования об уплате денежной суммы по банковской гарантии или договору поручительства"
            ),
            BudgetReasonCode(
                code = "ПВ",
                description = "Постановление о взыскании таможенных платежей, специальных, антидемпинговых, компенсационных пошлин, процентов и пени за счет имущества",
                payType = PayType.CUSTOM,
                hint108 = "Последние 7 цифр номера постановления о взыскании таможенных платежей, специальных, антидемпинговых, компенсационных пошлин, процентов и пени за счет имущества",
                hint109 = "Дата постановления о взыскании таможенных платежей, специальных, антидемпинговых, компенсационных пошлин, процентов и пени за счет имущества"
            ),
            BudgetReasonCode(
                code = "ИН",
                description = "Документ инкассации",
                payType = PayType.CUSTOM,
                hint108 = "Номер документа инкассации",
                hint109 = "Дата документа инкассации"
            ),
            BudgetReasonCode(
                code = "00",
                description = "Иные случаи",
                payType = PayType.CUSTOM,
                hint108 = "Для иных случаев указывается \"00\"",
                hint109 = "Для иных случаев указывается \"00\""
            ),
            BudgetReasonCode(
                code = "0",
                description = "Не определен",
                payType = PayType.ALL,
                hint108 = "Номер документа основания платежа или \"0\"",
                hint109 = "Дата документа основания платежа или \"0\""
            )
        )
    }
}