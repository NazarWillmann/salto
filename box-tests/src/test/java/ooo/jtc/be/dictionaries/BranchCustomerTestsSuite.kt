package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BRANCHCUSTOMER
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerCreateTest
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerDeleteTest
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerFiltrationTest
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerGetPageTest
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerGetTest
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSortingTest
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerFilterParams
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerSortingParams.BRANCH_ID
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerSortingParams.CUSTOMER_ID
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerSortingParams.ID
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
@Story(DictionaryNames.BRANCH_CUSTOMER)
@DisplayName("API '${DictionaryNames.BRANCH_CUSTOMER}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BRANCHCUSTOMER
@TestInstance(PER_CLASS)
class BranchCustomerTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2449") annotation class T2449
@Tag("JTCSALTO-T2450") annotation class T2450
@Tag("JTCSALTO-T2451") annotation class T2451
@Tag("JTCSALTO-T2452") annotation class T2452
@Tag("JTCSALTO-T2453") annotation class T2453
@Tag("JTCSALTO-T2454") annotation class T2454
@Tag("JTCSALTO-T2455") annotation class T2455
@Tag("JTCSALTO-T2456") annotation class T2456
@Tag("JTCSALTO-T2457") annotation class T2457
@Tag("JTCSALTO-T2458") annotation class T2458
@Tag("JTCSALTO-T2459") annotation class T2459
@Tag("JTCSALTO-T2460") annotation class T2460
@Tag("JTCSALTO-T2461") annotation class T2461
@Tag("JTCSALTO-T2462") annotation class T2462
//@formatter:on
//endregion


    @TestFactory
    @T2458 //'Связь подразделений и клиентов'. CRUD: Создаем запись от пользователя [BANK]
    @T2459 //'Связь подразделений и клиентов'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2460 //'Связь подразделений и клиентов'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2461 //'Связь подразделений и клиентов'. CRUD: Удаляем запись от пользователя [BANK]
    @T2462 //'Связь подразделений и клиентов'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun branchCustomerCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BranchCustomerCreateTest().withId(T2458::class),
                BranchCustomerGetTest().withId(T2459::class),
                BranchCustomerGetPageTest().withId(T2460::class),
                BranchCustomerDeleteTest().withId(T2461::class),
                BranchCustomerUpdateTest().withId(T2462::class)
            )
        )
    }

    @TestFactory
    @T2452 //'Связь подразделений и клиентов'. Сортировка по полю 'id, ASC' [BANK]
    @T2453 //'Связь подразделений и клиентов'. Сортировка по полю 'branchId, ASC' [BANK]
    @T2454 //'Связь подразделений и клиентов'. Сортировка по полю 'customerId, ASC' [BANK]
    @T2455 //'Связь подразделений и клиентов'. Сортировка по полю 'id, DESC' [BANK]
    @T2456 //'Связь подразделений и клиентов'. Сортировка по полю 'branchId, DESC' [BANK]
    @T2457 //'Связь подразделений и клиентов'. Сортировка по полю 'customerId, DESC' [BANK]
    internal fun branchCustomerSortingTests(): List<DynamicTest> {
        val tests =
            listOf(
                BranchCustomerSortingTest(ID::asc).withId(T2452::class),
                BranchCustomerSortingTest(BRANCH_ID::asc).withId(T2453::class),
                BranchCustomerSortingTest(CUSTOMER_ID::asc).withId(T2454::class),
                BranchCustomerSortingTest(ID::desc).withId(T2455::class),
                BranchCustomerSortingTest(BRANCH_ID::desc).withId(T2456::class),
                BranchCustomerSortingTest(CUSTOMER_ID::desc).withId(T2457::class)
            )

        return EntityTestGenerator.generate(tests)
    }

    private val dataForFilter by lazy { BranchCustomerData.searchBy(bankAdmin).random().toDto() }

    @TestFactory
    @T2449 //'Связь подразделений и клиентов'. Фильтрация по полю 'id' (eq) [BANK]
    @T2450 //'Связь подразделений и клиентов'. Фильтрация по полю 'branchId' (eq) [BANK]
    @T2451 //'Связь подразделений и клиентов'. Фильтрация по полю 'customerId' (eq) [BANK]
    internal fun branchCustomerFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BranchCustomerFiltrationTest(name = "id equals", preExecution = { dataForFilter },
                    filterRequestFunction = { BranchCustomerFilterParams.ID.eq(it!!.id!!) }).withId(T2449::class),
                BranchCustomerFiltrationTest(name = "branchId equals", preExecution = { dataForFilter },
                    filterRequestFunction = { BranchCustomerFilterParams.BRANCH_ID.eq(it!!.branchId) }).withId(T2450::class),
                BranchCustomerFiltrationTest(name = "customerId equals", preExecution = { dataForFilter },
                    filterRequestFunction = { BranchCustomerFilterParams.CUSTOMER_ID.eq(it!!.customerId) }).withId(T2451::class)
            )
        )
    }


    //TODO A.Stykalin [11.06.2020] Возможные ТК:
    // 1) Проверка видимости пользователм клиента, привязанного подразделения:
    // Предусловия в системе: клиентский пользователь [customerUser] без доступа к подразделению X.
    // Подготовка: Найти (или создать) клиента банка [idCustomer] (клиентского пользователя [customerUser]) не привязанного подразделению X.
    // Тест:
    // + Проверить, что пользователю [customerUser] не доступно подразделение X.
    // + Создать связь (запись BranchCustomer) для клиента из предусловия
    // + Проверить, что пользователю [customerUser] стало видно подразделение X.
    // ___
    // 2) Проверка видимости нового клиента, сотруднику подразделения [branchUser]:
    // Предусловия в системе: клиент банка [idCustomer] не обслуживающийся в подразделении X (где служит [branchUser]).
    // Тест:
    // + Проверить, что пользователю [branchUser] не доступен клиент [idCustomer].
    // + Создать связь (запись BranchCustomer) для клиента из предусловия
    // + Проверить, что пользователю [branchUser] стал доступен клиент [idCustomer].

}