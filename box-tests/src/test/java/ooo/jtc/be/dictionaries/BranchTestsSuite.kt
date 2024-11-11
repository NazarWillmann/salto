package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BRANCH
import ooo.jtc.api.dictionaries.branch.BranchCreateTest
import ooo.jtc.api.dictionaries.branch.BranchDeleteTest
import ooo.jtc.api.dictionaries.branch.BranchFiltrationTest
import ooo.jtc.api.dictionaries.branch.BranchGetPageTest
import ooo.jtc.api.dictionaries.branch.BranchGetTest
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branch.BranchSortingTest
import ooo.jtc.api.dictionaries.branch.BranchUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.branch.Branch
import ooo.jtc.dictionaries.branch.BranchDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branch.BranchFilterParams
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.BANK_ID
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.BIC
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.BRANCH_TYPE
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.EMAIL
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.FULL_NAME
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.ID
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.PARENT_BRANCH_ID
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.SHORT_NAME
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.SWIFT
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams.UI_NAME
import ooo.jtc.uaa.User
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
@Story(DictionaryNames.BRANCH)
@DisplayName("API '${DictionaryNames.BRANCH}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BRANCH
@TestInstance(PER_CLASS)
class BranchTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2463") annotation class T2463
@Tag("JTCSALTO-T2464") annotation class T2464
@Tag("JTCSALTO-T2465") annotation class T2465
@Tag("JTCSALTO-T2466") annotation class T2466
@Tag("JTCSALTO-T2467") annotation class T2467
@Tag("JTCSALTO-T2468") annotation class T2468
@Tag("JTCSALTO-T2469") annotation class T2469
@Tag("JTCSALTO-T2470") annotation class T2470
@Tag("JTCSALTO-T2471") annotation class T2471
@Tag("JTCSALTO-T2472") annotation class T2472
@Tag("JTCSALTO-T2473") annotation class T2473
@Tag("JTCSALTO-T2474") annotation class T2474
@Tag("JTCSALTO-T2475") annotation class T2475
@Tag("JTCSALTO-T2476") annotation class T2476
@Tag("JTCSALTO-T2477") annotation class T2477
@Tag("JTCSALTO-T2478") annotation class T2478
@Tag("JTCSALTO-T2481") annotation class T2481
@Tag("JTCSALTO-T2484") annotation class T2484
@Tag("JTCSALTO-T2485") annotation class T2485
@Tag("JTCSALTO-T2486") annotation class T2486
@Tag("JTCSALTO-T2487") annotation class T2487
@Tag("JTCSALTO-T2488") annotation class T2488
@Tag("JTCSALTO-T2489") annotation class T2489
@Tag("JTCSALTO-T2490") annotation class T2490
@Tag("JTCSALTO-T2491") annotation class T2491
@Tag("JTCSALTO-T2492") annotation class T2492
@Tag("JTCSALTO-T2493") annotation class T2493
@Tag("JTCSALTO-T2495") annotation class T2495
@Tag("JTCSALTO-T2496") annotation class T2496
@Tag("JTCSALTO-T2497") annotation class T2497
@Tag("JTCSALTO-T2498") annotation class T2498
@Tag("JTCSALTO-T2499") annotation class T2499
@Tag("JTCSALTO-T2500") annotation class T2500
@Tag("JTCSALTO-T2501") annotation class T2501
@Tag("JTCSALTO-T2502") annotation class T2502
@Tag("JTCSALTO-T2503") annotation class T2503
@Tag("JTCSALTO-T2504") annotation class T2504
@Tag("JTCSALTO-T2505") annotation class T2505
@Tag("JTCSALTO-T2507") annotation class T2507
@Tag("JTCSALTO-T2510") annotation class T2510
@Tag("JTCSALTO-T2511") annotation class T2511
@Tag("JTCSALTO-T2512") annotation class T2512
@Tag("JTCSALTO-T2513") annotation class T2513
@Tag("JTCSALTO-T2514") annotation class T2514
@Tag("JTCSALTO-T2515") annotation class T2515
@Tag("JTCSALTO-T2516") annotation class T2516
@Tag("JTCSALTO-T2517") annotation class T2517
@Tag("JTCSALTO-T2518") annotation class T2518
@Tag("JTCSALTO-T2519") annotation class T2519
@Tag("JTCSALTO-T2521") annotation class T2521
@Tag("JTCSALTO-T2522") annotation class T2522
@Tag("JTCSALTO-T2523") annotation class T2523
@Tag("JTCSALTO-T2524") annotation class T2524
@Tag("JTCSALTO-T2525") annotation class T2525
@Tag("JTCSALTO-T2526") annotation class T2526
@Tag("JTCSALTO-T2527") annotation class T2527
@Tag("JTCSALTO-T2528") annotation class T2528
@Tag("JTCSALTO-T2529") annotation class T2529
@Tag("JTCSALTO-T2530") annotation class T2530
@Tag("JTCSALTO-T2531") annotation class T2531
@Tag("JTCSALTO-T2533") annotation class T2533
@Tag("JTCSALTO-T2534") annotation class T2534
@Tag("JTCSALTO-T2535") annotation class T2535
@Tag("JTCSALTO-T2536") annotation class T2536
@Tag("JTCSALTO-T2537") annotation class T2537
@Tag("JTCSALTO-T2538") annotation class T2538
@Tag("JTCSALTO-T2539") annotation class T2539
@Tag("JTCSALTO-T2540") annotation class T2540
@Tag("JTCSALTO-T2541") annotation class T2541
@Tag("JTCSALTO-T2542") annotation class T2542
@Tag("JTCSALTO-T2543") annotation class T2543
@Tag("JTCSALTO-T2544") annotation class T2544
@Tag("JTCSALTO-T2545") annotation class T2545
@Tag("JTCSALTO-T2546") annotation class T2546
@Tag("JTCSALTO-T2547") annotation class T2547
@Tag("JTCSALTO-T2548") annotation class T2548
@Tag("JTCSALTO-T2549") annotation class T2549
@Tag("JTCSALTO-T2550") annotation class T2550
@Tag("JTCSALTO-T2551") annotation class T2551
@Tag("JTCSALTO-T2552") annotation class T2552
@Tag("JTCSALTO-T2553") annotation class T2553
@Tag("JTCSALTO-T2554") annotation class T2554
@Tag("JTCSALTO-T2555") annotation class T2555
@Tag("JTCSALTO-T2556") annotation class T2556
@Tag("JTCSALTO-T2559") annotation class T2559
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val adminUser = Users.bankAdmin
    private lateinit var clientTestDataScope: TestDataScope<Branch>
    private lateinit var bankTestDataScope: TestDataScope<Branch>

    @BeforeAll
    fun prepareBranchTestData() {
        val availableToClient = BranchData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = BranchData.withRequiredFields(
            additionalFilter = { it.id!! in availableToClient },
            customCreator = { BranchPrepareSteps.createBranchWithRelatedEntitiesForUsers(clientUser, withParent = true).toModel() }
        )
        val availableToBank = BranchData.searchBy(adminUser).map { it.id!! }
        bankTestDataScope = BranchData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBank },
            customCreator = { BranchPrepareSteps.createBranchWithRelatedEntitiesForUsers(adminUser, withParent = true).toModel() }
        )
    }
    //TODO Khatmullin [2021.06.08] check how removeGenerated() works with deletion tests
    @AfterAll
    fun cleanBranchTestData() {
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

    // [2020.05.27] До уточнения постановки:
    // проводить операции создания, обновления и удаления подразделений может только супер-пользователь
    @TestFactory
    @T2534 //'Подразделение банка'. CRUD: Создаем запись от пользователя [BANK]
    @T2535 //'Подразделение банка'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2536 //'Подразделение банка'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2537 //'Подразделение банка'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2538 //'Подразделение банка'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2539 //'Подразделение банка'. CRUD: Обновляем запись от пользователя [BANK]
    @T2540 //'Подразделение банка'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun branchCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BranchCreateTest(Users.superUser).withId(T2534::class),
                BranchGetTest(clientUser) { clientTestDataScope.all.random().toDto() }.withId(T2535::class),
                BranchGetTest(adminUser) { bankTestDataScope.all.random().toDto() }.withId(T2536::class),
                BranchGetPageTest(clientUser).withId(T2537::class),
                BranchGetPageTest(adminUser).withId(T2538::class),
                BranchUpdateTest(Users.superUser).withId(T2539::class),
                BranchDeleteTest(Users.superUser).withId(T2540::class)
            )
        )
    }

    @TestFactory
    @T2510 //'Подразделение банка'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2511 //'Подразделение банка'. Сортировка по полю 'bic, ASC' [CLIENT]
    @T2512 //'Подразделение банка'. Сортировка по полю 'name, ASC' [CLIENT]
    @T2513 //'Подразделение банка'. Сортировка по полю 'fullName, ASC' [CLIENT]
    @T2514 //'Подразделение банка'. Сортировка по полю 'shortName, ASC' [CLIENT]
    @T2515 //'Подразделение банка'. Сортировка по полю 'branchType, ASC' [CLIENT]
    @T2516 //'Подразделение банка'. Сортировка по полю 'email, ASC' [CLIENT]
    @T2517 //'Подразделение банка'. Сортировка по полю 'description, ASC' [CLIENT]
    @T2518 //'Подразделение банка'. Сортировка по полю 'swift, ASC' [CLIENT]
    @T2519 //'Подразделение банка'. Сортировка по полю 'bankId, ASC' [CLIENT]
    @T2521 //'Подразделение банка'. Сортировка по полю 'parentBranchId, ASC' [CLIENT]

    @T2522 //'Подразделение банка'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2523 //'Подразделение банка'. Сортировка по полю 'bic, DESC' [CLIENT]
    @T2524 //'Подразделение банка'. Сортировка по полю 'name, DESC' [CLIENT]
    @T2525 //'Подразделение банка'. Сортировка по полю 'fullName, DESC' [CLIENT]
    @T2526 //'Подразделение банка'. Сортировка по полю 'shortName, DESC' [CLIENT]
    @T2527 //'Подразделение банка'. Сортировка по полю 'branchType, DESC' [CLIENT]
    @T2528 //'Подразделение банка'. Сортировка по полю 'email, DESC' [CLIENT]
    @T2529 //'Подразделение банка'. Сортировка по полю 'description, DESC' [CLIENT]
    @T2530 //'Подразделение банка'. Сортировка по полю 'swift, DESC' [CLIENT]
    @T2531 //'Подразделение банка'. Сортировка по полю 'bankId, DESC' [CLIENT]
    @T2533 //'Подразделение банка'. Сортировка по полю 'parentBranchId, DESC' [CLIENT]
    internal fun branchSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BranchSortingTest(user, ID::asc).withId(T2510::class),
                BranchSortingTest(user, BIC::asc).withId(T2511::class),
                BranchSortingTest(user, UI_NAME::asc).withId(T2512::class),
                BranchSortingTest(user, FULL_NAME::asc).withId(T2513::class),
                BranchSortingTest(user, SHORT_NAME::asc).withId(T2514::class),
                BranchSortingTest(user, BRANCH_TYPE::asc).withId(T2515::class),
                BranchSortingTest(user, EMAIL::asc).withId(T2516::class),
                BranchSortingTest(user, DESCRIPTION::asc).withId(T2517::class),
                BranchSortingTest(user, SWIFT::asc).withId(T2518::class),
                BranchSortingTest(user, BANK_ID::asc).withId(T2519::class),
                BranchSortingTest(user, PARENT_BRANCH_ID::asc).withId(T2521::class),

                BranchSortingTest(user, ID::desc).withId(T2522::class),
                BranchSortingTest(user, BIC::desc).withId(T2523::class),
                BranchSortingTest(user, UI_NAME::desc).withId(T2524::class),
                BranchSortingTest(user, FULL_NAME::desc).withId(T2525::class),
                BranchSortingTest(user, SHORT_NAME::desc).withId(T2526::class),
                BranchSortingTest(user, BRANCH_TYPE::desc).withId(T2527::class),
                BranchSortingTest(user, EMAIL::desc).withId(T2528::class),
                BranchSortingTest(user, DESCRIPTION::desc).withId(T2529::class),
                BranchSortingTest(user, SWIFT::desc).withId(T2530::class),
                BranchSortingTest(user, BANK_ID::desc).withId(T2531::class),
                BranchSortingTest(user, PARENT_BRANCH_ID::desc).withId(T2533::class)
            )
        )
    }

    @TestFactory
    @T2484 //'Подразделение банка'. Сортировка по полю 'id, ASC' [BANK]
    @T2485 //'Подразделение банка'. Сортировка по полю 'bic, ASC' [BANK]
    @T2486 //'Подразделение банка'. Сортировка по полю 'name, ASC' [BANK]
    @T2487 //'Подразделение банка'. Сортировка по полю 'fullName, ASC' [BANK]
    @T2488 //'Подразделение банка'. Сортировка по полю 'shortName, ASC' [BANK]
    @T2489 //'Подразделение банка'. Сортировка по полю 'branchType, ASC' [BANK]
    @T2490 //'Подразделение банка'. Сортировка по полю 'email, ASC' [BANK]
    @T2491 //'Подразделение банка'. Сортировка по полю 'description, ASC' [BANK]
    @T2492 //'Подразделение банка'. Сортировка по полю 'swift, ASC' [BANK]
    @T2493 //'Подразделение банка'. Сортировка по полю 'bankId, ASC' [BANK]
    @T2495 //'Подразделение банка'. Сортировка по полю 'parentBranchId, ASC' [BANK]

    @T2496 //'Подразделение банка'. Сортировка по полю 'id, DESC' [BANK]
    @T2497 //'Подразделение банка'. Сортировка по полю 'bic, DESC' [BANK]
    @T2498 //'Подразделение банка'. Сортировка по полю 'name, DESC' [BANK]
    @T2499 //'Подразделение банка'. Сортировка по полю 'fullName, DESC' [BANK]
    @T2500 //'Подразделение банка'. Сортировка по полю 'shortName, DESC' [BANK]
    @T2501 //'Подразделение банка'. Сортировка по полю 'branchType, DESC' [BANK]
    @T2502 //'Подразделение банка'. Сортировка по полю 'email, DESC' [BANK]
    @T2503 //'Подразделение банка'. Сортировка по полю 'description, DESC' [BANK]
    @T2504 //'Подразделение банка'. Сортировка по полю 'swift, DESC' [BANK]
    @T2505 //'Подразделение банка'. Сортировка по полю 'bankId, DESC' [BANK]
    @T2507 //'Подразделение банка'. Сортировка по полю 'parentBranchId, DESC' [BANK]
    internal fun branchSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                BranchSortingTest(user, ID::asc).withId(T2484::class),
                BranchSortingTest(user, BIC::asc).withId(T2485::class),
                BranchSortingTest(user, UI_NAME::asc).withId(T2486::class),
                BranchSortingTest(user, FULL_NAME::asc).withId(T2487::class),
                BranchSortingTest(user, SHORT_NAME::asc).withId(T2488::class),
                BranchSortingTest(user, BRANCH_TYPE::asc).withId(T2489::class),
                BranchSortingTest(user, EMAIL::asc).withId(T2490::class),
                BranchSortingTest(user, DESCRIPTION::asc).withId(T2491::class),
                BranchSortingTest(user, SWIFT::asc).withId(T2492::class),
                BranchSortingTest(user, BANK_ID::asc).withId(T2493::class),
                BranchSortingTest(user, PARENT_BRANCH_ID::asc).withId(T2495::class),

                BranchSortingTest(user, ID::desc).withId(T2496::class),
                BranchSortingTest(user, BIC::desc).withId(T2497::class),
                BranchSortingTest(user, UI_NAME::desc).withId(T2498::class),
                BranchSortingTest(user, FULL_NAME::desc).withId(T2499::class),
                BranchSortingTest(user, SHORT_NAME::desc).withId(T2500::class),
                BranchSortingTest(user, BRANCH_TYPE::desc).withId(T2501::class),
                BranchSortingTest(user, EMAIL::desc).withId(T2502::class),
                BranchSortingTest(user, DESCRIPTION::desc).withId(T2503::class),
                BranchSortingTest(user, SWIFT::desc).withId(T2504::class),
                BranchSortingTest(user, BANK_ID::desc).withId(T2505::class),
                BranchSortingTest(user, PARENT_BRANCH_ID::desc).withId(T2507::class),
            )
        )
    }

    private val clientDataForFilter: BranchDto by lazy { clientTestDataScope.all.random().toDto() }
    private val bankDataForFilter: BranchDto by lazy { bankTestDataScope.all.random().toDto() }

    private fun getDataForFilter(user: User): BranchDto {
        return when (user) {
            adminUser -> bankDataForFilter
            clientUser -> clientDataForFilter
            else -> throw RuntimeException("Unexpected user :${user.login}")
        }
    }

    @TestFactory
    @T2541 //'Подразделение банка'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2542 //'Подразделение банка'. Фильтрация по полю 'bic' (eq) [CLIENT]
    @T2543 //'Подразделение банка'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T2544 //'Подразделение банка'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T2545 //'Подразделение банка'. Фильтрация по полю 'fullName' (eq) [CLIENT]
    @T2546 //'Подразделение банка'. Фильтрация по полю 'fullName' (contains) [CLIENT]
    @T2547 //'Подразделение банка'. Фильтрация по полю 'shortName' (eq) [CLIENT]
    @T2548 //'Подразделение банка'. Фильтрация по полю 'shortName' (contains) [CLIENT]
    @T2549 //'Подразделение банка'. Фильтрация по полю 'branchType' (eq) [CLIENT]
    @T2550 //'Подразделение банка'. Фильтрация по полю 'email' (eq) [CLIENT]
    @T2551 //'Подразделение банка'. Фильтрация по полю 'email' (contains) [CLIENT]
    @T2552 //'Подразделение банка'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T2553 //'Подразделение банка'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T2554 //'Подразделение банка'. Фильтрация по полю 'swift' (eq) [CLIENT]
    @T2555 //'Подразделение банка'. Фильтрация по полю 'swift' (contains) [CLIENT]
    @T2556 //'Подразделение банка'. Фильтрация по полю 'bankId' (eq) [CLIENT]
    @T2559 //'Подразделение банка'. Фильтрация по полю 'parentBranchId' (eq) [CLIENT]
    internal fun branchFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BranchFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.ID.eq(it!!.id!!) }).withId(T2541::class),
                BranchFiltrationTest("bic equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.BIC.eq(it!!.paymentDetailsBic!!.bic!!) }).withId(T2542::class),
                BranchFiltrationTest("name equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.UI_NAME.eq(it!!.uiName) }).withId(T2543::class),
                BranchFiltrationTest("name contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.UI_NAME.contains(it!!.uiName.randomSubstringPf()) }).withId(T2544::class),
                BranchFiltrationTest("fullName equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.FULL_NAME.eq(it!!.fullName) }).withId(T2545::class),
                BranchFiltrationTest("fullName contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T2546::class),
                BranchFiltrationTest("shortName equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T2547::class),
                BranchFiltrationTest("shortName contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T2548::class),
                BranchFiltrationTest("branchType equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.BRANCH_TYPE.eq(it!!.branchType) }).withId(T2549::class),

                BranchFiltrationTest("email equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.EMAIL.eq(it!!.email!!) }).withId(T2550::class),
                BranchFiltrationTest("email contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T2551::class),
                BranchFiltrationTest("description equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T2552::class),
                BranchFiltrationTest("description contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T2553::class),
                BranchFiltrationTest("swift equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.SWIFT.eq(it!!.paymentDetailsSwift!!.swift!!) }).withId(T2554::class),
                BranchFiltrationTest("swift contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.SWIFT.contains(it!!.paymentDetailsSwift!!.swift!!.randomSubstringPf()) }).withId(T2555::class),
                BranchFiltrationTest("bankId equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.BANK_ID.eq(it!!.bankId!!) }).withId(T2556::class),
                BranchFiltrationTest("parentBranchId equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.PARENT_BRANCH_ID.eq(it!!.parentBranchId!!) }).withId(T2559::class)
            )
        )
    }

    @TestFactory
    @T2463 //'Подразделение банка'. Фильтрация по полю 'id' (eq) [BANK]
    @T2464 //'Подразделение банка'. Фильтрация по полю 'bic' (eq) [BANK]
    @T2465 //'Подразделение банка'. Фильтрация по полю 'name' (eq) [BANK]
    @T2466 //'Подразделение банка'. Фильтрация по полю 'name' (contains) [BANK]
    @T2467 //'Подразделение банка'. Фильтрация по полю 'fullName' (eq) [BANK]
    @T2468 //'Подразделение банка'. Фильтрация по полю 'fullName' (contains) [BANK]
    @T2469 //'Подразделение банка'. Фильтрация по полю 'shortName' (eq) [BANK]
    @T2470 //'Подразделение банка'. Фильтрация по полю 'shortName' (contains) [BANK]
    @T2471 //'Подразделение банка'. Фильтрация по полю 'branchType' (eq) [BANK]
    @T2472 //'Подразделение банка'. Фильтрация по полю 'email' (eq) [BANK]
    @T2473 //'Подразделение банка'. Фильтрация по полю 'email' (contains) [BANK]
    @T2474 //'Подразделение банка'. Фильтрация по полю 'description' (eq) [BANK]
    @T2475 //'Подразделение банка'. Фильтрация по полю 'description' (contains) [BANK]
    @T2476 //'Подразделение банка'. Фильтрация по полю 'swift' (eq) [BANK]
    @T2477 //'Подразделение банка'. Фильтрация по полю 'swift' (contains) [BANK]
    @T2478 //'Подразделение банка'. Фильтрация по полю 'bankId' (eq) [BANK]
    @T2481 //'Подразделение банка'. Фильтрация по полю 'parentBranchId' (eq) [BANK]
    internal fun branchFiltrationBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                BranchFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.ID.eq(it!!.id!!) }).withId(T2463::class),
                BranchFiltrationTest("bic equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.BIC.eq(it!!.paymentDetailsBic!!.bic!!) }).withId(T2464::class),
                BranchFiltrationTest("name equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.UI_NAME.eq(it!!.uiName) }).withId(T2465::class),
                BranchFiltrationTest("name contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.UI_NAME.contains(it!!.uiName.randomSubstringPf()) }).withId(T2466::class),
                BranchFiltrationTest("fullName equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.FULL_NAME.eq(it!!.fullName) }).withId(T2467::class),
                BranchFiltrationTest("fullName contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T2468::class),
                BranchFiltrationTest("shortName equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T2469::class),
                BranchFiltrationTest("shortName contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T2470::class),
                BranchFiltrationTest("branchType equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.BRANCH_TYPE.eq(it!!.branchType) }).withId(T2471::class),

                BranchFiltrationTest("email equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.EMAIL.eq(it!!.email!!) }).withId(T2472::class),
                BranchFiltrationTest("email contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T2473::class),
                BranchFiltrationTest("description equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T2474::class),
                BranchFiltrationTest("description contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T2475::class),
                BranchFiltrationTest("swift equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.SWIFT.eq(it!!.paymentDetailsSwift!!.swift!!) }).withId(T2476::class),
                BranchFiltrationTest("swift contains", user, { getDataForFilter(user) },
                    { BranchFilterParams.SWIFT.contains(it!!.paymentDetailsSwift!!.swift!!.randomSubstringPf()) }).withId(T2477::class),
                BranchFiltrationTest("bankId equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.BANK_ID.eq(it!!.bankId!!) }).withId(T2478::class),
                BranchFiltrationTest("parentBranchId equals", user, { getDataForFilter(user) },
                    { BranchFilterParams.PARENT_BRANCH_ID.eq(it!!.parentBranchId!!) }).withId(T2481::class),
            )
        )
    }
}