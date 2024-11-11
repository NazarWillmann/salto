package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CUSTOMERTYPE
import ooo.jtc.api.dictionaries.customertype.CustomerTypeCreateTest
import ooo.jtc.api.dictionaries.customertype.CustomerTypeDeleteTest
import ooo.jtc.api.dictionaries.customertype.CustomerTypeFiltrationTest
import ooo.jtc.api.dictionaries.customertype.CustomerTypeGetPageTest
import ooo.jtc.api.dictionaries.customertype.CustomerTypeGetTest
import ooo.jtc.api.dictionaries.customertype.CustomerTypeSortingTest
import ooo.jtc.api.dictionaries.customertype.CustomerTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.customertype.CustomerType
import ooo.jtc.dictionaries.customertype.CustomerTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeData
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeFilterParams
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeSortingParams.NAME
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeSortingParams.ID
import ooo.jtc.testdata.dictionaries.customertype.CustomerTypeSortingParams.SYSTEM_NAME
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
@Story(DictionaryNames.CUSTOMER_TYPE)
@DisplayName("API '${DictionaryNames.CUSTOMER_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CUSTOMERTYPE
@TestInstance(PER_CLASS)
class CustomerTypeTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2595") annotation class T2595
@Tag("JTCSALTO-T2596") annotation class T2596
@Tag("JTCSALTO-T2597") annotation class T2597
@Tag("JTCSALTO-T2598") annotation class T2598
@Tag("JTCSALTO-T2599") annotation class T2599
@Tag("JTCSALTO-T2600") annotation class T2600
@Tag("JTCSALTO-T2601") annotation class T2601
@Tag("JTCSALTO-T2602") annotation class T2602
@Tag("JTCSALTO-T2603") annotation class T2603
@Tag("JTCSALTO-T2604") annotation class T2604
@Tag("JTCSALTO-T2605") annotation class T2605
@Tag("JTCSALTO-T2606") annotation class T2606
@Tag("JTCSALTO-T2607") annotation class T2607
@Tag("JTCSALTO-T2608") annotation class T2608
@Tag("JTCSALTO-T2609") annotation class T2609
@Tag("JTCSALTO-T2610") annotation class T2610
@Tag("JTCSALTO-T2611") annotation class T2611
@Tag("JTCSALTO-T2612") annotation class T2612
@Tag("JTCSALTO-T2613") annotation class T2613
@Tag("JTCSALTO-T2614") annotation class T2614
@Tag("JTCSALTO-T2615") annotation class T2615
@Tag("JTCSALTO-T2616") annotation class T2616
@Tag("JTCSALTO-T2617") annotation class T2617
@Tag("JTCSALTO-T2618") annotation class T2618
@Tag("JTCSALTO-T2619") annotation class T2619
@Tag("JTCSALTO-T2620") annotation class T2620
@Tag("JTCSALTO-T2621") annotation class T2621
@Tag("JTCSALTO-T2622") annotation class T2622
@Tag("JTCSALTO-T2623") annotation class T2623
//@formatter:on
//endregion

    private lateinit var dataForFilter: CustomerTypeDto
    private lateinit var testDataScope: TestDataScope<CustomerType>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = CustomerTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2605 //'Тип клиента'. CRUD: Создаем запись от пользователя [BANK]
    @T2606 //'Тип клиента'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2607 //'Тип клиента'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2608 //'Тип клиента'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2609 //'Тип клиента'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2610 //'Тип клиента'. CRUD: Удаляем запись от пользователя [BANK]
    @T2611 //'Тип клиента'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun customerTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CustomerTypeCreateTest().withId(T2605::class),
                CustomerTypeGetTest(user = client).withId(T2606::class),
                CustomerTypeGetTest(user = bankAdmin).withId(T2607::class),
                CustomerTypeGetPageTest(user = client).withId(T2608::class),
                CustomerTypeGetPageTest(user = bankAdmin).withId(T2609::class),
                CustomerTypeDeleteTest().withId(T2610::class),
                CustomerTypeUpdateTest().withId(T2611::class)
            )
        )
    }

    @TestFactory
    @T2612 //'Тип клиента'. Сортировка по полю 'id, ASC' [BANK]
    @T2613 //'Тип клиента'. Сортировка по полю 'name, ASC' [BANK]
    @T2614 //'Тип клиента'. Сортировка по полю 'systemName, ASC' [BANK]

    @T2615 //'Тип клиента'. Сортировка по полю 'id, DESC' [BANK]
    @T2616 //'Тип клиента'. Сортировка по полю 'name, DESC' [BANK]
    @T2617 //'Тип клиента'. Сортировка по полю 'systemName, DESC' [BANK]
    internal fun customerTypeSortingBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                CustomerTypeSortingTest(user, ID::asc).withId(T2612::class),
                CustomerTypeSortingTest(user, NAME::asc).withId(T2613::class),
                CustomerTypeSortingTest(user, SYSTEM_NAME::asc).withId(T2614::class),

                CustomerTypeSortingTest(user, ID::desc).withId(T2615::class),
                CustomerTypeSortingTest(user, NAME::desc).withId(T2616::class),
                CustomerTypeSortingTest(user, SYSTEM_NAME::desc).withId(T2617::class)
            )
        )
    }

    @TestFactory
    @T2618 //'Тип клиента'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2619 //'Тип клиента'. Сортировка по полю 'name, ASC' [CLIENT]
    @T2620 //'Тип клиента'. Сортировка по полю 'systemName, ASC' [CLIENT]

    @T2621 //'Тип клиента'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2622 //'Тип клиента'. Сортировка по полю 'name, DESC' [CLIENT]
    @T2623 //'Тип клиента'. Сортировка по полю 'systemName, DESC' [CLIENT]
    internal fun customerTypeSortingClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                CustomerTypeSortingTest(user, ID::asc).withId(T2618::class),
                CustomerTypeSortingTest(user, NAME::asc).withId(T2619::class),
                CustomerTypeSortingTest(user, SYSTEM_NAME::asc).withId(T2620::class),

                CustomerTypeSortingTest(user, ID::desc).withId(T2621::class),
                CustomerTypeSortingTest(user, NAME::desc).withId(T2622::class),
                CustomerTypeSortingTest(user, SYSTEM_NAME::desc).withId(T2623::class)
            )
        )
    }

    @TestFactory
    @T2595 //'Тип клиента'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2596 //'Тип клиента'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T2597 //'Тип клиента'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T2598 //'Тип клиента'. Фильтрация по полю 'systemName' (eq) [CLIENT]
    @T2599 //'Тип клиента'. Фильтрация по полю 'systemName' (contains) [CLIENT]
    internal fun customerTypeFiltrationClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                CustomerTypeFiltrationTest("id equals", user, { dataForFilter },
                    { CustomerTypeFilterParams.ID.eq(it!!.id!!) }).withId(T2595::class),
                CustomerTypeFiltrationTest("name equals", user, { dataForFilter },
                    { CustomerTypeFilterParams.NAME.eq(it!!.name) }).withId(T2596::class),
                CustomerTypeFiltrationTest("name contains", user, { dataForFilter },
                    { CustomerTypeFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T2597::class),
                CustomerTypeFiltrationTest("systemName equals", user, { dataForFilter },
                    { CustomerTypeFilterParams.SYSTEM_NAME.eq(it!!.systemName) }).withId(T2598::class),
                CustomerTypeFiltrationTest("systemName contains", user, { dataForFilter },
                    { CustomerTypeFilterParams.SYSTEM_NAME.contains(it!!.systemName.randomSubstringPf()) }).withId(T2599::class)
            )
        )
    }

    @TestFactory
    @T2600 //'Тип клиента'. Фильтрация по полю 'id' (eq) [BANK]
    @T2601 //'Тип клиента'. Фильтрация по полю 'name' (eq) [BANK]
    @T2602 //'Тип клиента'. Фильтрация по полю 'name' (contains) [BANK]
    @T2603 //'Тип клиента'. Фильтрация по полю 'systemName' (eq) [BANK]
    @T2604 //'Тип клиента'. Фильтрация по полю 'systemName' (contains) [BANK]
    internal fun customerTypeFiltrationBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                CustomerTypeFiltrationTest("id equals", user, { dataForFilter },
                    { CustomerTypeFilterParams.ID.eq(it!!.id!!) }).withId(T2600::class),
                CustomerTypeFiltrationTest("name equals", user, { dataForFilter },
                    { CustomerTypeFilterParams.NAME.eq(it!!.name) }).withId(T2601::class),
                CustomerTypeFiltrationTest("name contains", user, { dataForFilter },
                    { CustomerTypeFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T2602::class),
                CustomerTypeFiltrationTest("systemName equals", user, { dataForFilter },
                    { CustomerTypeFilterParams.SYSTEM_NAME.eq(it!!.systemName) }).withId(T2603::class),
                CustomerTypeFiltrationTest("systemName contains", user, { dataForFilter },
                    { CustomerTypeFilterParams.SYSTEM_NAME.contains(it!!.systemName.randomSubstringPf()) }).withId(T2604::class)
            )
        )
    }
}