package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BRANCHREPRESENTATIVE
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeBlockingTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeCreateTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeDeleteTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeFiltrationTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeGetPageTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeGetTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeSortingTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeUnblockingTest
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentative
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentativeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.BLOCK_DATE
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.BLOCK_USER
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.BRANCH_ID
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.EMAIL
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.ID
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.IS_BLOCKED
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.PHONE
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.POSITION
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams.USER_ID
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
@Story(DictionaryNames.BRANCH_REPRESENTATIVE)
@DisplayName("API '${DictionaryNames.BRANCH_REPRESENTATIVE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BRANCHREPRESENTATIVE
@TestInstance(PER_CLASS)
class BranchRepresentativeTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T2560") annotation class T2560
@Tag("JTCSALTO-T2561") annotation class T2561
@Tag("JTCSALTO-T2562") annotation class T2562
@Tag("JTCSALTO-T2563") annotation class T2563
@Tag("JTCSALTO-T2566") annotation class T2566
@Tag("JTCSALTO-T2567") annotation class T2567
@Tag("JTCSALTO-T2568") annotation class T2568
@Tag("JTCSALTO-T2569") annotation class T2569
@Tag("JTCSALTO-T2570") annotation class T2570
@Tag("JTCSALTO-T2571") annotation class T2571
@Tag("JTCSALTO-T2574") annotation class T2574
@Tag("JTCSALTO-T2575") annotation class T2575
@Tag("JTCSALTO-T2576") annotation class T2576
@Tag("JTCSALTO-T2577") annotation class T2577
@Tag("JTCSALTO-T2579") annotation class T2579
@Tag("JTCSALTO-T2580") annotation class T2580
@Tag("JTCSALTO-T2581") annotation class T2581
@Tag("JTCSALTO-T2582") annotation class T2582
@Tag("JTCSALTO-T2583") annotation class T2583
@Tag("JTCSALTO-T2584") annotation class T2584
@Tag("JTCSALTO-T2585") annotation class T2585
@Tag("JTCSALTO-T2587") annotation class T2587
@Tag("JTCSALTO-T2588") annotation class T2588
@Tag("JTCSALTO-T2589") annotation class T2589
@Tag("JTCSALTO-T2590") annotation class T2590
@Tag("JTCSALTO-T2591") annotation class T2591
@Tag("JTCSALTO-T2592") annotation class T2592
@Tag("JTCSALTO-T2593") annotation class T2593
@Tag("JTCSALTO-T2594") annotation class T2594
@Tag("JTCSALTO-T5477") annotation class T5477
@Tag("JTCSALTO-T5478") annotation class T5478
@Tag("JTCSALTO-T5517") annotation class T5517
@Tag("JTCSALTO-T5518") annotation class T5518
@Tag("JTCSALTO-T5519") annotation class T5519
@Tag("JTCSALTO-T5520") annotation class T5520
@Tag("JTCSALTO-T5521") annotation class T5521
@Tag("JTCSALTO-T5522") annotation class T5522
@Tag("JTCSALTO-T5523") annotation class T5523
//@formatter:on
//endregion

    private val almightyUser = Users.superUser
    private val bankOperator = Users.bankOperator
    private lateinit var dataForFilter: BranchRepresentativeDto
    private lateinit var blockedDataForFilter: BranchRepresentativeDto
    private lateinit var testDataScope: TestDataScope<BranchRepresentative>

    @BeforeAll
    fun prepareTestData() {
        val allGeneratedBranchRepresentatives = mutableListOf<BranchRepresentative>()

        testDataScope = BranchRepresentativeData.withRequiredFields(
            additionalFilter = { !it.isBlock },
            customCreator = {
                val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
                val preparedBranchRepres = BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForCreate(
                    uaaUserId = bankOperator.uaaUserId!!,
                    branchId = newBranch.id!!
                )
                val blockedBranchRepres = BranchRepresentativePrepareSteps.createBranchRepresentativeDto(preparedBranchRepres)
                blockedBranchRepres.toModel()
            }
        )
        dataForFilter = testDataScope.all.random().toDto()

        repeat(
            times = REQUIRED_DATA_COUNT.toInt(),
            action = {
                val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
                val preparedBranchRepres = BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForCreate(
                    uaaUserId = bankOperator.uaaUserId!!,
                    branchId = newBranch.id!!
                )
                val blockedBranchRepres = BranchRepresentativePrepareSteps.createBlockedBranchRepresentativeDto(preparedBranchRepres)
                allGeneratedBranchRepresentatives.add(blockedBranchRepres.toModel())
            }
        )
        blockedDataForFilter = allGeneratedBranchRepresentatives.random().toDto()

        allGeneratedBranchRepresentatives.addAll(testDataScope.generated)
        testDataScope.generated = allGeneratedBranchRepresentatives
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.branchId!!) }
    }

    @TestFactory
    @T2590 //'Представитель подразделения'. CRUD: Создаем запись от пользователя [BANK]
    @T2591 //'Представитель подразделения'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2592 //'Представитель подразделения'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2593 //'Представитель подразделения'. CRUD: Удаляем запись от пользователя [BANK]
    @T2594 //'Представитель подразделения'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun branchRepresentativeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BranchRepresentativeCreateTest(runTestAsUser = almightyUser, createEntityForUser = bankOperator).withId(T2590::class),
                BranchRepresentativeGetTest(almightyUser).withId(T2591::class),
                BranchRepresentativeGetTest(bankOperator).withId(T2591::class),
                BranchRepresentativeGetPageTest(almightyUser).withId(T2592::class),
                BranchRepresentativeGetPageTest(bankOperator).withId(T2592::class),
                BranchRepresentativeDeleteTest(almightyUser, createEntityForUser = bankOperator).withId(T2593::class),
                BranchRepresentativeUpdateTest(almightyUser, createEntityForUser = bankOperator).withId(T2594::class)
            )
        )
    }

    @TestFactory
    @T5477 //'Представитель подразделения'. Блокировка [BANK]
    @T5478 //'Представитель подразделения'. Разблокировка [BANK]
    internal fun branchRepresentativeBlockingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BranchRepresentativeBlockingTest(almightyUser, createEntityForUser = bankOperator).withId(T5477::class),
                BranchRepresentativeUnblockingTest(almightyUser, createEntityForUser = bankOperator).withId(T5478::class)
            //TODO Sergeyev [2021.03.24]: add tests for correct blocking logic (unavailable branches)
            //TODO Sergeyev [2021.04.13]: add accessibility tests for client users and operator/admin users
            )
        )
    }

    @TestFactory
    @T2574 //'Представитель подразделения'. Сортировка по полю 'id, ASC' [BANK]
    @T2575 //'Представитель подразделения'. Сортировка по полю 'branchId, ASC' [BANK]
    @T2576 //'Представитель подразделения'. Сортировка по полю 'userId, ASC' [BANK]
    @T2579 //'Представитель подразделения'. Сортировка по полю 'position, ASC' [BANK]
    @T2580 //'Представитель подразделения'. Сортировка по полю 'email, ASC' [BANK]
    @T2581 //'Представитель подразделения'. Сортировка по полю 'phone, ASC' [BANK]

    @T2582 //'Представитель подразделения'. Сортировка по полю 'id, DESC' [BANK]
    @T2583 //'Представитель подразделения'. Сортировка по полю 'branchId, DESC' [BANK]
    @T2584 //'Представитель подразделения'. Сортировка по полю 'userId, DESC' [BANK]
    @T2587 //'Представитель подразделения'. Сортировка по полю 'position, DESC' [BANK]
    @T2588 //'Представитель подразделения'. Сортировка по полю 'email, DESC' [BANK]
    @T2589 //'Представитель подразделения'. Сортировка по полю 'phone, DESC' [BANK]
    internal fun branchRepresentativeSortingTests(): List<DynamicTest> {
        val user = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                BranchRepresentativeSortingTest(user, ID::asc).withId(T2574::class),
                BranchRepresentativeSortingTest(user, BRANCH_ID::asc).withId(T2575::class),
                BranchRepresentativeSortingTest(user, USER_ID::asc).withId(T2576::class),
                BranchRepresentativeSortingTest(user, POSITION::asc).withId(T2579::class),
                BranchRepresentativeSortingTest(user, EMAIL::asc).withId(T2580::class),
                BranchRepresentativeSortingTest(user, PHONE::asc).withId(T2581::class),

                BranchRepresentativeSortingTest(user, ID::desc).withId(T2582::class),
                BranchRepresentativeSortingTest(user, BRANCH_ID::desc).withId(T2583::class),
                BranchRepresentativeSortingTest(user, USER_ID::desc).withId(T2584::class),
                BranchRepresentativeSortingTest(user, POSITION::desc).withId(T2587::class),
                BranchRepresentativeSortingTest(user, EMAIL::desc).withId(T2588::class),
                BranchRepresentativeSortingTest(user, PHONE::desc).withId(T2589::class)
            )
        )
    }

    @TestFactory
    @T2576 //'Представитель подразделения'. Сортировка по полю 'userId, ASC' [BANK]
    @T2577 //'Представитель подразделения'. Сортировка по полю 'block.isBlock, ASC' [BANK]
    @T5517 //'Представитель подразделения'. Сортировка по полю 'block.blockDate, ASC' [BANK]
    @T5518 //'Представитель подразделения'. Сортировка по полю 'block.blockUser, ASC' [BANK]

    @T2584 //'Представитель подразделения'. Сортировка по полю 'userId, DESC' [BANK]
    @T2585 //'Представитель подразделения'. Сортировка по полю 'block.isBlock, DESC' [BANK]
    @T5519 //'Представитель подразделения'. Сортировка по полю 'block.blockDate, DESC' [BANK]
    @T5520 //'Представитель подразделения'. Сортировка по полю 'block.blockUser, DESC' [BANK]
    internal fun almightyBranchRepresentativeSortingTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                BranchRepresentativeSortingTest(user, USER_ID::asc).withId(T2576::class),
                BranchRepresentativeSortingTest(user, IS_BLOCKED::asc).withId(T2577::class),
                BranchRepresentativeSortingTest(user, BLOCK_DATE::asc).withId(T5517::class),
                BranchRepresentativeSortingTest(user, BLOCK_USER::asc).withId(T5518::class),

                BranchRepresentativeSortingTest(user, USER_ID::desc).withId(T2584::class),
                BranchRepresentativeSortingTest(user, IS_BLOCKED::desc).withId(T2585::class),
                BranchRepresentativeSortingTest(user, BLOCK_DATE::desc).withId(T5519::class),
                BranchRepresentativeSortingTest(user, BLOCK_USER::desc).withId(T5520::class)
            )
        )
    }

    @TestFactory
    @T2560 //'Представитель подразделения'. Фильтрация по полю 'id' (eq) [BANK]
    @T2561 //'Представитель подразделения'. Фильтрация по полю 'branchId' (eq) [BANK]
    @T2562 //'Представитель подразделения'. Фильтрация по полю 'userId' (eq) [BANK]
    @T2566 //'Представитель подразделения'. Фильтрация по полю 'position' (eq) [BANK]
    @T2567 //'Представитель подразделения'. Фильтрация по полю 'position' (contains) [BANK]
    @T2568 //'Представитель подразделения'. Фильтрация по полю 'email' (eq) [BANK]
    @T2569 //'Представитель подразделения'. Фильтрация по полю 'email' (contains) [BANK]
    @T2570 //'Представитель подразделения'. Фильтрация по полю 'phone' (eq) [BANK]
    @T2571 //'Представитель подразделения'. Фильтрация по полю 'phone' (contains) [BANK]
    internal fun branchRepresentativeFiltrationTests(): List<DynamicTest> {
        val user = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                BranchRepresentativeFiltrationTest("id equals", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.ID.eq(it!!.id!!) }).withId(T2560::class),
                BranchRepresentativeFiltrationTest("branchId equals", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.BRANCH_ID.eq(it!!.branchId!!) }).withId(T2561::class),
                BranchRepresentativeFiltrationTest("userId equals", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.USER_ID.eq(it!!.userId!!) }).withId(T2562::class),
                BranchRepresentativeFiltrationTest("position equals", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.POSITION.eq(it!!.position!!) }).withId(T2566::class),
                BranchRepresentativeFiltrationTest("position contains", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.POSITION.contains(it!!.position!!.randomSubstringPf()) }).withId(T2567::class),
                BranchRepresentativeFiltrationTest("email equals", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.EMAIL.eq(it!!.email!!) }).withId(T2568::class),
                BranchRepresentativeFiltrationTest("email contains", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T2569::class),
                BranchRepresentativeFiltrationTest("phone equals", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.PHONE.eq(it!!.phone!!) }).withId(T2570::class),
                BranchRepresentativeFiltrationTest("phone contains", user, { dataForFilter },
                    { BranchRepresentativeFilterParams.PHONE.contains(it!!.phone!!.randomSubstringPf()) }).withId(T2571::class)
            )
        )
    }

    @TestFactory
    @T2563 //'Представитель подразделения'. Фильтрация по полю 'block.isBlock' (eq) [BANK]
    @T5521 //'Представитель подразделения'. Фильтрация по полю 'block.blockDate' (ge) [BANK]
    @T5522 //'Представитель подразделения'. Фильтрация по полю 'block.blockDate' (le) [BANK]
    @T5523 //'Представитель подразделения'. Фильтрация по полю 'block.blockUser' (eq) [BANK]
    internal fun blockedBranchRepresentativeFiltrationTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                BranchRepresentativeFiltrationTest("isBlocked equals", user, { blockedDataForFilter },
                    { BranchRepresentativeFilterParams.IS_BLOCKED.eq(it!!.block.isBlock) }).withId(T2563::class),
                BranchRepresentativeFiltrationTest("blockDate greaterOrEqual", user, { blockedDataForFilter },
                    { BranchRepresentativeFilterParams.BLOCK_DATE.ge(it!!.block.blockDate!!.minusSeconds(5)) }).withId(T5521::class),
                BranchRepresentativeFiltrationTest("blockDate lesserOrEqual", user, { blockedDataForFilter },
                    { BranchRepresentativeFilterParams.BLOCK_DATE.le(it!!.block.blockDate!!.plusSeconds(5)) }).withId(T5522::class),
                BranchRepresentativeFiltrationTest("blockUser equals", user, { blockedDataForFilter },
                    { BranchRepresentativeFilterParams.BLOCK_USER.eq(it!!.block.blockUser!!) }).withId(T5523::class)
            )
        )
    }
}