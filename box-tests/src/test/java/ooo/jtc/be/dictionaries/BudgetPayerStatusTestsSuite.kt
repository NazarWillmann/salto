package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BUDGETPAYERSTATUS
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusControlTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusCreateTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusDefaultsTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusDeleteTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusFiltrationTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusGetPageTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusGetTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps.availableCodes
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusPrepareSteps.getBudgetPayerStatusDtoForCreate
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusServerErrorTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusSortingTest
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusSteps
import ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.ServiceErrors
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_EXPECT
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_REQUEST
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatus
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusControls
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusData
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusFilterParams.CODE
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusFilterParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusFilterParams.ID
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusSortingParams
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
@Story(DictionaryNames.BUDGET_PAYER_STATUS)
@DisplayName("API '${DictionaryNames.BUDGET_PAYER_STATUS}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BUDGETPAYERSTATUS
@TestInstance(PER_CLASS)
class BudgetPayerStatusTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3017") annotation class T3017
@Tag("JTCSALTO-T3018") annotation class T3018
@Tag("JTCSALTO-T3019") annotation class T3019
@Tag("JTCSALTO-T3020") annotation class T3020
@Tag("JTCSALTO-T3021") annotation class T3021
@Tag("JTCSALTO-T3022") annotation class T3022
@Tag("JTCSALTO-T3023") annotation class T3023
@Tag("JTCSALTO-T3024") annotation class T3024
@Tag("JTCSALTO-T3025") annotation class T3025
@Tag("JTCSALTO-T3026") annotation class T3026
@Tag("JTCSALTO-T3027") annotation class T3027
@Tag("JTCSALTO-T3028") annotation class T3028
@Tag("JTCSALTO-T3029") annotation class T3029
@Tag("JTCSALTO-T3030") annotation class T3030
@Tag("JTCSALTO-T3031") annotation class T3031
@Tag("JTCSALTO-T3032") annotation class T3032
@Tag("JTCSALTO-T3033") annotation class T3033
@Tag("JTCSALTO-T3034") annotation class T3034
@Tag("JTCSALTO-T3035") annotation class T3035
@Tag("JTCSALTO-T3036") annotation class T3036
@Tag("JTCSALTO-T3037") annotation class T3037
@Tag("JTCSALTO-T3038") annotation class T3038
@Tag("JTCSALTO-T3039") annotation class T3039
@Tag("JTCSALTO-T3040") annotation class T3040
@Tag("JTCSALTO-T3041") annotation class T3041
@Tag("JTCSALTO-T3042") annotation class T3042
@Tag("JTCSALTO-T3043") annotation class T3043
@Tag("JTCSALTO-T3044") annotation class T3044
@Tag("JTCSALTO-T3045") annotation class T3045
@Tag("JTCSALTO-T6878") annotation class T6878
@Tag("JTCSALTO-T6879") annotation class T6879
@Tag("JTCSALTO-T6880") annotation class T6880
@Tag("JTCSALTO-T6881") annotation class T6881
@Tag("JTCSALTO-T6882") annotation class T6882
@Tag("JTCSALTO-T6883") annotation class T6883
@Tag("JTCSALTO-T6884") annotation class T6884
@Tag("JTCSALTO-T6885") annotation class T6885
@Tag("JTCSALTO-T6886") annotation class T6886
@Tag("JTCSALTO-T6887") annotation class T6887
@Tag("JTCSALTO-T6888") annotation class T6888
@Tag("JTCSALTO-T6889") annotation class T6889
@Tag("JTCSALTO-T6890") annotation class T6890
//@formatter:on
//endregion


    private val bankUser = Users.bankAdmin
    private val clientUser = Users.client
    private lateinit var dataForFilter: BudgetPayerStatusDto
    private lateinit var testDataScope: TestDataScope<BudgetPayerStatus>

    @BeforeAll
    fun prepareBudgetPayerStatusTestData() {
        testDataScope = BudgetPayerStatusData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanBudgetPayerStatusTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3017 //'Показатель статуса плательщика'. CRUD: Создаем запись от пользователя [BANK]
    @T3018 //'Показатель статуса плательщика'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3019 //'Показатель статуса плательщика'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3020 //'Показатель статуса плательщика'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3021 //'Показатель статуса плательщика'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3022 //'Показатель статуса плательщика'. CRUD: Удаляем запись от пользователя [BANK]
    @T3023 //'Показатель статуса плательщика'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun budgetPayerStatusCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusCreateTest().withId(T3017::class),
                BudgetPayerStatusGetTest(user = clientUser).withId(T3018::class),
                BudgetPayerStatusGetTest(user = bankUser).withId(T3019::class),
                BudgetPayerStatusGetPageTest(user = clientUser).withId(T3020::class),
                BudgetPayerStatusGetPageTest(user = bankUser).withId(T3021::class),
                BudgetPayerStatusDeleteTest().withId(T3022::class),
                BudgetPayerStatusUpdateTest().withId(T3023::class)
            )
        )
    }

    @TestFactory
    @T3024 //'Показатель статуса плательщика'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3025 //'Показатель статуса плательщика'. Сортировка по полю 'code, ASC' [CLIENT]
    @T3026 //'Показатель статуса плательщика'. Сортировка по полю 'description, ASC' [CLIENT]

    @T3027 //'Показатель статуса плательщика'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3028 //'Показатель статуса плательщика'. Сортировка по полю 'code, DESC' [CLIENT]
    @T3029 //'Показатель статуса плательщика'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun budgetPayerStatusSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.ID::asc).withId(T3024::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.CODE::asc).withId(T3025::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.DESCRIPTION::asc).withId(T3026::class),

                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.ID::desc).withId(T3027::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.CODE::desc).withId(T3028::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.DESCRIPTION::desc).withId(T3029::class)
            )
        )
    }

    @TestFactory
    @T3030 //'Показатель статуса плательщика'. Сортировка по полю 'id, ASC' [BANK]
    @T3031 //'Показатель статуса плательщика'. Сортировка по полю 'code, ASC' [BANK]
    @T3032 //'Показатель статуса плательщика'. Сортировка по полю 'description, ASC' [BANK]

    @T3033 //'Показатель статуса плательщика'. Сортировка по полю 'id, DESC' [BANK]
    @T3034 //'Показатель статуса плательщика'. Сортировка по полю 'code, DESC' [BANK]
    @T3035 //'Показатель статуса плательщика'. Сортировка по полю 'description, DESC' [BANK]
    internal fun budgetPayerStatusSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.ID::asc).withId(T3030::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.CODE::asc).withId(T3031::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.DESCRIPTION::asc).withId(T3032::class),

                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.ID::desc).withId(T3033::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.CODE::desc).withId(T3034::class),
                BudgetPayerStatusSortingTest(user, BudgetPayerStatusSortingParams.DESCRIPTION::desc).withId(T3035::class)
            )
        )
    }

    @TestFactory
    @T3036 //'Показатель статуса плательщика'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3037 //'Показатель статуса плательщика'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T3038 //'Показатель статуса плательщика'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T3039 //'Показатель статуса плательщика'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3040 //'Показатель статуса плательщика'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun budgetPayerStatusFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusFiltrationTest("id equals", user, { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3036::class),
                BudgetPayerStatusFiltrationTest("code equals", user, { dataForFilter },
                    { CODE.eq(it!!.code!!) }).withId(T3037::class),
                BudgetPayerStatusFiltrationTest("code contains", user, { dataForFilter },
                    { CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T3038::class),
                BudgetPayerStatusFiltrationTest("description equals", user, { dataForFilter },
                    { DESCRIPTION.eq(it!!.description!!) }).withId(T3039::class),
                BudgetPayerStatusFiltrationTest("description contains", user, { dataForFilter },
                    { DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T3040::class)
            )
        )
    }

    @TestFactory
    @T3041 //'Показатель статуса плательщика'. Фильтрация по полю 'id' (eq) [BANK]
    @T3042 //'Показатель статуса плательщика'. Фильтрация по полю 'code' (eq) [BANK]
    @T3043 //'Показатель статуса плательщика'. Фильтрация по полю 'code' (contains) [BANK]
    @T3044 //'Показатель статуса плательщика'. Фильтрация по полю 'description' (eq) [BANK]
    @T3045 //'Показатель статуса плательщика'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun budgetPayerStatusFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusFiltrationTest("id equals", user, { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3041::class),
                BudgetPayerStatusFiltrationTest("code equals", user, { dataForFilter },
                    { CODE.eq(it!!.code!!) }).withId(T3042::class),
                BudgetPayerStatusFiltrationTest("code contains", user, { dataForFilter },
                    { CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T3043::class),
                BudgetPayerStatusFiltrationTest("description equals", user, { dataForFilter },
                    { DESCRIPTION.eq(it!!.description!!) }).withId(T3044::class),
                BudgetPayerStatusFiltrationTest("description contains", user, { dataForFilter },
                    { DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T3045::class)
            )
        )
    }

    @TestFactory
    @T6878 //'Показатель статуса плательщика'. Контроль: Контроль показателя статуса плательщика на непустоту (null). [BANK]
    @T6879 //'Показатель статуса плательщика'. Контроль: Контроль показателя статуса плательщика на непустоту (пустая строка) [BANK]
    @T6880 //'Показатель статуса плательщика'. Контроль: Контроль показателя статуса плательщика на непустоту (пробельные символы) [BANK]
    @T6881 //'Показатель статуса плательщика'. Контроль: Контроль длины показателя статуса плательщика (1) [BANK]
    @T6882 //'Показатель статуса плательщика'. Контроль: Контроль длины показателя статуса плательщика (3) [BANK]
    @T6883 //'Показатель статуса плательщика'. Контроль: Контроль показателя статуса документа на допустимые символы [BANK]
    @T6884 //'Показатель статуса плательщика'. Контроль: Контроль описания показателя статуса плательщика на непустоту (null). [BANK]
    @T6885 //'Показатель статуса плательщика'. Контроль: Контроль описания показателя статуса плательщика на непустоту (пустая строка) [BANK]
    @T6886 //'Показатель статуса плательщика'. Контроль: Контроль описания показателя статуса плательщика на непустоту (пробельные символы) [BANK]
    @T6887 //'Показатель статуса плательщика'. Контроль: Контроль длины описания показателя статуса плательщика [BANK]
    @T6888 //'Показатель статуса плательщика'. Контроль: Контроль описания показателя статуса плательщика на допустимые символы [BANK]
    @T6889 //'Показатель статуса плательщика'. Контроль: Контроль уникальности записи. [BANK]
    internal fun budgetPayerStatusControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusServerErrorTest(
                    testName = "Контроль показателя статуса плательщика на непустоту (null)",
                    preExecution = { getBudgetPayerStatusDtoForCreate(code = null) },
                    expectedCode = 500,
                    expectedMessage = ServiceErrors.DESERIALIZE_ERROR.format("budgetPayerStatus/bank/Create", ".data.code")
                ).withId(T6878::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль показателя статуса плательщика на непустоту (пустая строка)",
                    preExecution = { getBudgetPayerStatusDtoForCreate(code = "") },
                    control = BudgetPayerStatusControls.CODE_NOT_EMPTY
                ).withId(T6879::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль показателя статуса плательщика на непустоту (пробельные символы)",
                    preExecution = { getBudgetPayerStatusDtoForCreate(code = "    ") },
                    control = BudgetPayerStatusControls.CODE_NOT_EMPTY
                ).withId(T6880::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль длины показателя статуса плательщика (1)",
                    preExecution = { getBudgetPayerStatusDtoForCreate(code = "1") },
                    control = BudgetPayerStatusControls.CODE_LENGTH
                ).withId(T6881::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль длины показателя статуса плательщика (3)",
                    preExecution = { getBudgetPayerStatusDtoForCreate(code = "333") },
                    control = BudgetPayerStatusControls.CODE_LENGTH
                ).withId(T6882::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль показателя статуса документа на допустимые символы",
                    preExecution = { getBudgetPayerStatusDtoForCreate(code = "rRыЫ |") },
                    control = BudgetPayerStatusControls.CODE_ALLOWED_SYMBOLS.withParams("symbols" to "r;R;ы;Ы; ;|")
                ).withId(T6883::class),
                BudgetPayerStatusServerErrorTest(
                    testName = "Контроль описания показателя статуса плательщика на непустоту (null)",
                    preExecution = { getBudgetPayerStatusDtoForCreate().copy(description = null) },
                    postExecution = { availableCodes.add(it.code!!) },
                    expectedCode = 500,
                    expectedMessage = ServiceErrors.DESERIALIZE_ERROR.format("budgetPayerStatus/bank/Create", ".data.description")
                ).withId(T6884::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль описания показателя статуса плательщика на непустоту (пустая строка)",
                    preExecution = { getBudgetPayerStatusDtoForCreate().copy(description = "") },
                    postExecution = { availableCodes.add(it.code!!) },
                    control = BudgetPayerStatusControls.DESCRIPTION_NOT_EMPTY
                ).withId(T6885::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль описания показателя статуса плательщика на непустоту (пробельные символы)",
                    preExecution = { getBudgetPayerStatusDtoForCreate().copy(description = "    ") },
                    postExecution = { availableCodes.add(it.code!!) },
                    control = BudgetPayerStatusControls.DESCRIPTION_NOT_EMPTY
                ).withId(T6886::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль длины описания показателя статуса плательщика",
                    preExecution = {
                        getBudgetPayerStatusDtoForCreate().copy(
                            description = RandomData("[а-яА-Я0-9]*")
                                .random(length = 501 - AT_POSTFIX_RUS_PARENTHESES.length) + AT_POSTFIX_RUS_PARENTHESES
                        )
                    },
                    postExecution = { availableCodes.add(it.code!!) },
                    control = BudgetPayerStatusControls.DESCRIPTION_LENGTH
                ).withId(T6887::class),
                BudgetPayerStatusControlTest(
                    testName = "Контроль описания показателя статуса плательщика на допустимые символы",
                    preExecution = { getBudgetPayerStatusDtoForCreate().copy(description = CONTROL_INVALID_CHARS_REQUEST) },
                    postExecution = { availableCodes.add(it.code!!) },
                    control = BudgetPayerStatusControls.DESCRIPTION_ALLOWED_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T6888::class),
                BudgetPayerStatusServerErrorTest(
                    testName = "Контроль уникальности записи",
                    preExecution = {
                        val existingBudgetPayerStatus = testDataScope.consumed.random().toDto()
                        existingBudgetPayerStatus.id = null
                        existingBudgetPayerStatus
                    },
                    expectedCode = 603,
                    expectedMessage = ServiceErrors.PSQL_EXCEPTION + ServiceErrors.UNIQUE_CONSTRAINT_VIOLATION.format("budget_payer_status_code_uk")
                ).withId(T6889::class)
            )
        )
    }

    @TestFactory
    @T6890 //'Показатель статуса плательщика'. Наполнение
    internal fun budgetPayerStatusDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BudgetPayerStatusDefaultsTest(
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.code == expectedEntity.code }
                                BudgetPayerStatusSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Показатель статуса плательщика со следующим кодом не найден: '${expectedEntity.code}'")
                            }
                        }
                    }
                ).withId(T6890::class)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<BudgetPayerStatus> {
        return listOf(
            BudgetPayerStatus(
                code = "01",
                description = "Налогоплательщик (плательщик сборов, страховых взносов и иных платежей, администрируемых налоговыми органами) - юридическое лицо"
            ),
            BudgetPayerStatus(
                code = "02",
                description = "Налоговый агент"
            ),
            BudgetPayerStatus(
                code = "03",
                description = "Организация федеральной почтовой связи, составившая распоряжение о переводе денежных средств по каждому платежу физического лица, за исключением уплаты таможенных платежей"
            ),
            BudgetPayerStatus(
                code = "04",
                description = "Налоговый орган"
            ),
            BudgetPayerStatus(
                code = "05",
                description = "Федеральная служба судебных приставов и ее территориальные органы"
            ),
            BudgetPayerStatus(
                code = "06",
                description = "Участник внешнеэкономической деятельности - юридическое лицо, за исключением получателя международного почтового отправления (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "07",
                description = "Таможенный орган (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "08",
                description = "Плательщик - юридическое лицо, индивидуальный предприниматель, нотариус, занимающийся частной практикой, адвокат, учредивший адвокатский кабинет, глава крестьянского (фермерского) хозяйства, осуществляющие перевод денежных средств в уплату платежей в бюджетную систему Российской Федерации (за исключением платежей, администрируемых налоговыми и таможенными органами)"
            ),
            BudgetPayerStatus(
                code = "13",
                description = "Налогоплательщик (плательщик сборов, страховых взносов и иных платежей, администрируемых налоговыми органами) - физическое лицо, индивидуальный предприниматель, нотариус, занимающийся частной практикой, адвокат, учредивший адвокатский кабинет, глава крестьянского (фермерского) хозяйства"
            ),
            BudgetPayerStatus(
                code = "15",
                description = "Кредитная организация (филиал кредитной организации), платежный агент, организация федеральной почтовой связи, составившие платежное поручение на общую сумму с реестром на перевод денежных средств, принятых от плательщиков - физических лиц"
            ),
            BudgetPayerStatus(
                code = "16",
                description = "Участник внешнеэкономической деятельности - физическое лицо (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "17",
                description = "Участник внешнеэкономической деятельности - индивидуальный предприниматель (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "19",
                description = "Организации и их филиалы (далее - организации), составившие распоряжение о переводе денежных средств, удержанных из заработной платы (дохода) должника - физического лица в счет погашения задолженности по платежам в бюджетную систему Российской Федерации на основании исполнительного документа, направленного в организацию в установленном порядке (за исключением платежей, администрируемых налоговыми и таможенными органами)"
            ),
            BudgetPayerStatus(
                code = "20",
                description = "Кредитная организация (филиал кредитной организации), платежный агент, составившие распоряжение о переводе денежных средств по каждому платежу физического лица (за исключением платежей, администрируемых налоговыми и таможенными органами)"
            ),
            BudgetPayerStatus(
                code = "23",
                description = "Фонд социального страхования Российской Федерации (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "24",
                description = "Плательщик - физическое лицо, осуществляющее перевод денежных средств в уплату сборов, страховых взносов, администрируемых Фондом социального страхования Российской Федерации, и иных платежей в бюджетную систему Российской Федерации (за исключением платежей, администрируемых налоговыми и таможенными органами)"
            ),
            BudgetPayerStatus(
                code = "27",
                description = "Кредитные организации (филиалы кредитных организаций), составившие распоряжение о переводе денежных средств, перечисленных из бюджетной системы Российской Федерации, не зачисленных получателю и подлежащих возврату в бюджетную систему Российской Федерации"
            ),
            BudgetPayerStatus(
                code = "28",
                description = "Участник внешнеэкономической деятельности - получатель международного почтового отправления (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "29",
                description = "Политическая партия, избирательное объединение, инициативная группа по проведению референдума, кандидат, зарегистрированный кандидат или уполномоченный представитель инициативной группы по проведению референдума, инициативная агитационная группа при перечислении денежных средств в бюджетную систему Российской Федерации со специальных избирательных счетов и специальных счетов фондов референдума (за исключением платежей, администрируемых налоговыми органами)"
            ),
            BudgetPayerStatus(
                code = "30",
                description = "Иностранное лицо, не состоящее на учете в налоговых органах Российской Федерации (при уплате платежей, администрируемых таможенными органами)"
            )
        )
    }
}