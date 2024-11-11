package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_INCOME_TYPE
import ooo.jtc.api.dictionaries.incometype.IncomeTypeControlTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeCreateTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeDefaultsTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeDeleteTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeFiltrationTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeGetPageTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeGetTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.generateWithPrefix
import ooo.jtc.api.dictionaries.incometype.IncomeTypePrepareSteps.getIncomeTypeDtoForCreate
import ooo.jtc.api.dictionaries.incometype.IncomeTypeServerErrorTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeSortingTest
import ooo.jtc.api.dictionaries.incometype.IncomeTypeSteps
import ooo.jtc.api.dictionaries.incometype.IncomeTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.ServiceErrors
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.incometype.IncomeType
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeControls
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeData
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeFilterParams
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeSortingParams.CODE
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.incometype.IncomeTypeSortingParams.NAME
import ooo.jtc.testdata.dictionaries.incometype.invalidDescription
import ooo.jtc.testdata.dictionaries.incometype.invalidName
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
import kotlin.random.Random

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.INCOME_TYPE)
@DisplayName("API '${DictionaryNames.INCOME_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_INCOME_TYPE
@TestInstance(PER_CLASS)
class IncomeTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T6516") annotation class T6516
@Tag("JTCSALTO-T6517") annotation class T6517
@Tag("JTCSALTO-T6518") annotation class T6518
@Tag("JTCSALTO-T6519") annotation class T6519
@Tag("JTCSALTO-T6520") annotation class T6520
@Tag("JTCSALTO-T6521") annotation class T6521
@Tag("JTCSALTO-T6522") annotation class T6522
@Tag("JTCSALTO-T6523") annotation class T6523
@Tag("JTCSALTO-T6524") annotation class T6524
@Tag("JTCSALTO-T6525") annotation class T6525
@Tag("JTCSALTO-T6526") annotation class T6526
@Tag("JTCSALTO-T6527") annotation class T6527
@Tag("JTCSALTO-T6528") annotation class T6528
@Tag("JTCSALTO-T6529") annotation class T6529
@Tag("JTCSALTO-T6530") annotation class T6530
@Tag("JTCSALTO-T6531") annotation class T6531
@Tag("JTCSALTO-T6532") annotation class T6532
@Tag("JTCSALTO-T6533") annotation class T6533
@Tag("JTCSALTO-T6534") annotation class T6534
@Tag("JTCSALTO-T6535") annotation class T6535
@Tag("JTCSALTO-T6536") annotation class T6536
@Tag("JTCSALTO-T6537") annotation class T6537
@Tag("JTCSALTO-T6538") annotation class T6538
@Tag("JTCSALTO-T6539") annotation class T6539
@Tag("JTCSALTO-T6540") annotation class T6540
@Tag("JTCSALTO-T6541") annotation class T6541
@Tag("JTCSALTO-T6542") annotation class T6542
@Tag("JTCSALTO-T6543") annotation class T6543
@Tag("JTCSALTO-T6544") annotation class T6544
@Tag("JTCSALTO-T6545") annotation class T6545
@Tag("JTCSALTO-T6546") annotation class T6546
@Tag("JTCSALTO-T6547") annotation class T6547
@Tag("JTCSALTO-T6548") annotation class T6548
@Tag("JTCSALTO-T6549") annotation class T6549
@Tag("JTCSALTO-T6550") annotation class T6550
@Tag("JTCSALTO-T6551") annotation class T6551
@Tag("JTCSALTO-T6552") annotation class T6552
@Tag("JTCSALTO-T6691") annotation class T6691
//@formatter:on
//endregion

    private lateinit var testDataScope: TestDataScope<IncomeType>

    @BeforeAll
    fun prepareIncomeTypeTestData() {
        IncomeTypeData.cleanAtCreated()
        testDataScope = IncomeTypeData.withRequiredFields()
    }

    @AfterAll
    fun cleanIncomeTypeTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T6536 //'Вид дохода'. CRUD: Создаем запись от пользователя [BANK]
    @T6537 //'Вид дохода'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T6538 //'Вид дохода'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6539 //'Вид дохода'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T6540 //'Вид дохода'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6541 //'Вид дохода'. CRUD: Обновляем запись от пользователя [BANK]
    @T6542 //'Вид дохода'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun incomeTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IncomeTypeCreateTest(user = bankAdmin).withId(T6536::class),
                IncomeTypeGetTest(user = client).withId(T6537::class),
                IncomeTypeGetTest(user = bankAdmin).withId(T6538::class),
                IncomeTypeGetPageTest(user = client).withId(T6539::class),
                IncomeTypeGetPageTest(user = bankAdmin).withId(T6540::class),
                IncomeTypeUpdateTest(user = bankAdmin).withId(T6541::class),
                IncomeTypeDeleteTest(user = bankAdmin).withId(T6542::class)
            )
        )
    }

    @TestFactory
    @T6516 //'Вид дохода'. Контроль: кода на непустоту. [BANK]
    @T6517 //'Вид дохода'. Контроль: кода вида дохода на допустимое значение [BANK]
    @T6518 //'Вид дохода'. Контроль: наименования на непустоту [BANK]
    @T6519 //'Вид дохода'. Контроль: длины наименования [BANK]
    @T6520 //'Вид дохода'. Контроль: наименования на допустимые символы [BANK]
    @T6521 //'Вид дохода'. Контроль: описания на непустоту [BANK]
    @T6522 //'Вид дохода'. Контроль: длины описания [BANK]
    @T6523 //'Вид дохода'. Контроль: описания на допустимые символы [BANK]
    internal fun incomeTypeControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IncomeTypeServerErrorTest(
                    testName = "кода на непустоту",
                    preExecution = { getIncomeTypeDtoForCreate(code = null) },
                    expectedCode = 500,
                    expectedMessage = ServiceErrors.DESERIALIZE_ERROR.format("incomeType/bank/Create", ".data.code")
                ).withId(T6516::class),
                IncomeTypeControlTest(
                    testName = "кода вида дохода на допустимое значение",
                    preExecution = { getIncomeTypeDtoForCreate(code = 10) },
                    postExecution = null,
                    control = IncomeTypeControls.CODE_VALUE_RANGE
                ).withId(T6517::class),
                IncomeTypeControlTest(
                    testName = "наименования на непустоту",
                    preExecution = { getIncomeTypeDtoForCreate().apply { name = if (Random.nextBoolean()) "" else " " } },
                    control = IncomeTypeControls.NAME_NOT_EMPTY
                ).withId(T6518::class),
                IncomeTypeControlTest(
                    testName = "длины наименования",
                    preExecution = { getIncomeTypeDtoForCreate().apply { name = generateWithPrefix(length = 61) } },
                    control = IncomeTypeControls.NAME_MAX_LENGTH
                ).withId(T6519::class),
                IncomeTypeControlTest(
                    testName = "наименования на допустимые символы",
                    preExecution = { getIncomeTypeDtoForCreate().apply { name = AT_PREFIX_RUS + invalidName } },
                    control = IncomeTypeControls.NAME_ALLOWED_SYMBOLS
                ).withId(T6520::class),
                IncomeTypeControlTest(
                    testName = "описания на непустоту",
                    preExecution = { getIncomeTypeDtoForCreate().apply { description = if (Random.nextBoolean()) "" else " " } },
                    control = IncomeTypeControls.DESCRIPTION_NOT_EMPTY
                ).withId(T6521::class),
                IncomeTypeControlTest(
                    testName = "длины описания",
                    preExecution = { getIncomeTypeDtoForCreate().apply { description = generateWithPrefix(length = 256) } },
                    control = IncomeTypeControls.DESCRIPTION_MAX_LENGTH
                ).withId(T6522::class),
                IncomeTypeControlTest(
                    testName = "описания на допустимые символы",
                    preExecution = { getIncomeTypeDtoForCreate().apply { description = AT_PREFIX_RUS + invalidDescription } },
                    control = IncomeTypeControls.DESCRIPTION_ALLOWED_SYMBOLS
                ).withId(T6523::class)
            )
        )
    }

    @TestFactory
    @T6524 //'Вид дохода'. Сортировка по полю 'code, ASC' [CLIENT]
    @T6525 //'Вид дохода'. Сортировка по полю 'code, DESC' [CLIENT]
    @T6526 //'Вид дохода'. Сортировка по полю 'name, ASC' [CLIENT]
    @T6527 //'Вид дохода'. Сортировка по полю 'name, DESC' [CLIENT]
    @T6528 //'Вид дохода'. Сортировка по полю 'description, ASC' [CLIENT]
    @T6529 //'Вид дохода'. Сортировка по полю 'description, DESC' [CLIENT]
    @T6530 //'Вид дохода'. Сортировка по полю 'code, ASC' [BANK]
    @T6531 //'Вид дохода'. Сортировка по полю 'code, DESC' [BANK]
    @T6532 //'Вид дохода'. Сортировка по полю 'name, ASC' [BANK]
    @T6533 //'Вид дохода'. Сортировка по полю 'name, DESC' [BANK]
    @T6534 //'Вид дохода'. Сортировка по полю 'description, ASC' [BANK]
    @T6535 //'Вид дохода'. Сортировка по полю 'description, DESC' [BANK]
    internal fun incomeTypeSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IncomeTypeSortingTest(user = client, sortRequestFunction = CODE::asc).withId(T6524::class),
                IncomeTypeSortingTest(user = client, sortRequestFunction = CODE::desc).withId(T6525::class),
                IncomeTypeSortingTest(user = client, sortRequestFunction = NAME::asc).withId(T6526::class),
                IncomeTypeSortingTest(user = client, sortRequestFunction = NAME::desc).withId(T6527::class),
                IncomeTypeSortingTest(user = client, sortRequestFunction = DESCRIPTION::asc).withId(T6528::class),
                IncomeTypeSortingTest(user = client, sortRequestFunction = DESCRIPTION::desc).withId(T6529::class),
                IncomeTypeSortingTest(user = bankAdmin, sortRequestFunction = CODE::asc).withId(T6530::class),
                IncomeTypeSortingTest(user = bankAdmin, sortRequestFunction = CODE::desc).withId(T6531::class),
                IncomeTypeSortingTest(user = bankAdmin, sortRequestFunction = NAME::asc).withId(T6532::class),
                IncomeTypeSortingTest(user = bankAdmin, sortRequestFunction = NAME::desc).withId(T6533::class),
                IncomeTypeSortingTest(user = bankAdmin, sortRequestFunction = DESCRIPTION::asc).withId(T6534::class),
                IncomeTypeSortingTest(user = bankAdmin, sortRequestFunction = DESCRIPTION::desc).withId(T6535::class)
            )
        )
    }

    @TestFactory
    @T6543 //'Вид дохода'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T6544 //'Вид дохода'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T6545 //'Вид дохода'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T6546 //'Вид дохода'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T6547 //'Вид дохода'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T6548 //'Вид дохода'. Фильтрация по полю 'code' (eq) [BANK]
    @T6549 //'Вид дохода'. Фильтрация по полю 'name' (eq) [BANK]
    @T6550 //'Вид дохода'. Фильтрация по полю 'name' (contains) [BANK]
    @T6551 //'Вид дохода'. Фильтрация по полю 'description' (eq) [BANK]
    @T6552 //'Вид дохода'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun incomeTypeFiltrationTests(): List<DynamicTest> {
        val dataForFilter = testDataScope.all.random().toDto()
        return EntityTestGenerator.generate(
            listOf(
                IncomeTypeFiltrationTest(
                    name = "code equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.CODE.eq(it!!.code!!) }
                ).withId(T6543::class),
                IncomeTypeFiltrationTest(
                    name = "name equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.NAME.eq(it!!.name) }
                ).withId(T6544::class),
                IncomeTypeFiltrationTest(
                    name = "name contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }
                ).withId(T6545::class),
                IncomeTypeFiltrationTest(
                    name = "description equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.DESCRIPTION.eq(it!!.description) }
                ).withId(T6546::class),
                IncomeTypeFiltrationTest(
                    name = "description contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }
                ).withId(T6547::class),
                IncomeTypeFiltrationTest(
                    name = "code equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.CODE.eq(it!!.code!!) }
                ).withId(T6548::class),
                IncomeTypeFiltrationTest(
                    name = "name equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.NAME.eq(it!!.name) }
                ).withId(T6549::class),
                IncomeTypeFiltrationTest(
                    name = "name contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }
                ).withId(T6550::class),
                IncomeTypeFiltrationTest(
                    name = "description equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.DESCRIPTION.eq(it!!.description) }
                ).withId(T6551::class),
                IncomeTypeFiltrationTest(
                    name = "description contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { IncomeTypeFilterParams.DESCRIPTION.contains(it!!.description.randomSubstringPf()) }
                ).withId(T6552::class)
            )
        )
    }

    @TestFactory
    @T6691 //'Вид дохода'. Наполнение
    internal fun incomeTypeDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                IncomeTypeDefaultsTest(
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.code == expectedEntity.code }
                                IncomeTypeSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Вид дохода со следующим кодом не найден: '${expectedEntity.code}'")
                            }
                        }
                    }
                ).withId(T6691::class)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<IncomeType> {
        return listOf(
            IncomeType(
                code = 1,
                name = "Размер взыскания ограничен",
                description = "Зарплата, аванс, премия, компенсация за неиспользованный отпуск, отпускные, оплата больничного, вознаграждение по договору ГПХ"
            ), IncomeType(
                code = 2,
                name = "Взыскание невозможно",
                description = "Пособие по беременности и родам, пособие по уходу за ребенком, алименты, надбавки за вахтовый метод работы"
            ), IncomeType(
                code = 3,
                name = "Размер взыскания не ограничен",
                description = "Возмещение вреда здоровью, выплаты пострадавшим в результате радиационных или техногенных катастроф"
            )
        )
    }
}