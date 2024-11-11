package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_GROUND
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.api.dictionaries.ground.GroundCreateTest
import ooo.jtc.api.dictionaries.ground.GroundDeleteTest
import ooo.jtc.api.dictionaries.ground.GroundFiltrationTest
import ooo.jtc.api.dictionaries.ground.GroundFolderOther
import ooo.jtc.api.dictionaries.ground.GroundGetPageTest
import ooo.jtc.api.dictionaries.ground.GroundGetTest
import ooo.jtc.api.dictionaries.ground.GroundPrepareSteps
import ooo.jtc.api.dictionaries.ground.GroundSortingTest
import ooo.jtc.api.dictionaries.ground.GroundSteps
import ooo.jtc.api.dictionaries.ground.GroundUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.tm4j.Tm4jComponent
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jPriority
import ooo.jtc.dictionaries.contractor.Contractor
import ooo.jtc.dictionaries.ground.GroundDto
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.ground.GroundFilterParams
import ooo.jtc.testdata.dictionaries.ground.GroundSortingParams.CONTRACTOR_ID
import ooo.jtc.testdata.dictionaries.ground.GroundSortingParams.CUSTOMER_ID
import ooo.jtc.testdata.dictionaries.ground.GroundSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.ground.GroundSortingParams.ID
import org.hamcrest.MatcherAssert.assertThat
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
@Story(DictionaryNames.GROUND)
@DisplayName("API '${DictionaryNames.GROUND}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_GROUND
@TestInstance(PER_CLASS)
class GroundTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2624") annotation class T2624
@Tag("JTCSALTO-T2625") annotation class T2625
@Tag("JTCSALTO-T2626") annotation class T2626
@Tag("JTCSALTO-T2627") annotation class T2627
@Tag("JTCSALTO-T2628") annotation class T2628
@Tag("JTCSALTO-T2629") annotation class T2629
@Tag("JTCSALTO-T2630") annotation class T2630
@Tag("JTCSALTO-T2631") annotation class T2631
@Tag("JTCSALTO-T2632") annotation class T2632
@Tag("JTCSALTO-T2633") annotation class T2633
@Tag("JTCSALTO-T2634") annotation class T2634
@Tag("JTCSALTO-T2635") annotation class T2635
@Tag("JTCSALTO-T2636") annotation class T2636
@Tag("JTCSALTO-T2637") annotation class T2637
@Tag("JTCSALTO-T2638") annotation class T2638
@Tag("JTCSALTO-T2639") annotation class T2639
@Tag("JTCSALTO-T2640") annotation class T2640
@Tag("JTCSALTO-T2641") annotation class T2641
@Tag("JTCSALTO-T2642") annotation class T2642
@Tag("JTCSALTO-T2643") annotation class T2643
@Tag("JTCSALTO-T2644") annotation class T2644
@Tag("JTCSALTO-T2645") annotation class T2645
@Tag("JTCSALTO-T2646") annotation class T2646
@Tag("JTCSALTO-T2647") annotation class T2647
@Tag("JTCSALTO-T2648") annotation class T2648
@Tag("JTCSALTO-T2649") annotation class T2649
@Tag("JTCSALTO-T2650") annotation class T2650
@Tag("JTCSALTO-T2651") annotation class T2651
@Tag("JTCSALTO-T2652") annotation class T2652
@Tag("JTCSALTO-T2653") annotation class T2653
@Tag("JTCSALTO-T2654") annotation class T2654
@Tag("JTCSALTO-T2655") annotation class T2655
@Tag("JTCSALTO-T2656") annotation class T2656
@Tag("JTCSALTO-T2657") annotation class T2657
@Tag("JTCSALTO-T2658") annotation class T2658
@Tag("JTCSALTO-T2659") annotation class T2659
@Tag("JTCSALTO-T2660") annotation class T2660
@Tag("JTCSALTO-T2661") annotation class T2661
@Tag("JTCSALTO-T2662") annotation class T2662
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val adminUser = Users.bankAdmin

    /* 'Common' means that [clientUser] and [adminUser] have relation with it Contractor. */
    private lateinit var commonContractorsScope: TestDataScope<Contractor>
    private lateinit var groundForContractorA: GroundDto
    private lateinit var groundForContractorB: GroundDto
    private lateinit var groundWithoutContractors: GroundDto
    private lateinit var dataForTests: List<GroundDto>

    @BeforeAll
    @DisplayName("Подготовка тестовых данных")
    fun groundPrepareTestData() {
        val commonCustomerId = CustomerData.getOrCreateCommonCustomersId(clientUser, adminUser)
        commonContractorsScope = ContractorData.withRequiredFields(
            additionalFilter = { commonCustomerId == it.customerId },
            customCreator = { ContractorPrepareSteps.createContractorDto(commonCustomerId).toModel() }
        )
        val contractorIds = commonContractorsScope.all.map { it.id!! }.shuffled()

        groundWithoutContractors = GroundPrepareSteps.createGroundDto(commonCustomerId, null)
        groundForContractorB = GroundPrepareSteps.createGroundDto(commonCustomerId, contractorIds[0])
        groundForContractorA = GroundPrepareSteps.createGroundDto(commonCustomerId, contractorIds[1])
        val oneMoreForSorting = GroundPrepareSteps.createGroundDto(commonCustomerId, contractorIds[2])
        dataForTests = listOf(
            groundWithoutContractors,
            groundForContractorB,
            groundForContractorA,
            oneMoreForSorting
        )
    }

    @AfterAll
    fun groundCleanTestData() {
        if (this::groundForContractorA.isInitialized) {
            val steps = GroundSteps(clientUser)
            dataForTests.forEach {
                steps.delete(it.id!!)
            }
        }
    }


    @TestFactory
    @T2629 //'Назначение платежа'. CRUD: Создаем запись от пользователя [CLIENT]
    @T2630 //'Назначение платежа'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2631 //'Назначение платежа'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2632 //'Назначение платежа'. CRUD: Удаляем запись от пользователя [CLIENT]
    @T2633 //'Назначение платежа'. CRUD: Обновляем запись от пользователя [CLIENT]
    internal fun groundCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                GroundCreateTest(clientUser).withId(T2629::class),
                GroundGetTest(clientUser) { groundForContractorA }.withId(T2630::class),
                GroundGetPageTest(clientUser).withId(T2631::class),
                GroundDeleteTest(clientUser).withId(T2632::class),
                GroundUpdateTest(clientUser).withId(T2633::class)
            )
        )
    }

    @TestFactory
    @T2624 //'Назначение платежа'. CRUD: Создаем запись от пользователя [BANK]
    @T2625 //'Назначение платежа'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2626 //'Назначение платежа'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2627 //'Назначение платежа'. CRUD: Удаляем запись от пользователя [BANK]
    @T2628 //'Назначение платежа'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun groundCrudBankTests(): List<DynamicTest> {
        val tests =
            listOf(
                GroundCreateTest(adminUser).withId(T2624::class),
                GroundGetTest(adminUser) { groundForContractorB }.withId(T2625::class),
                GroundGetPageTest(adminUser).withId(T2626::class),
                GroundDeleteTest(adminUser).withId(T2627::class),
                GroundUpdateTest(adminUser).withId(T2628::class)
            )

        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2655 //'Назначение платежа'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2656 //'Назначение платежа'. Сортировка по полю 'contractorId, ASC' [CLIENT]
    @T2657 //'Назначение платежа'. Сортировка по полю 'customerId, ASC' [CLIENT]
    @T2658 //'Назначение платежа'. Сортировка по полю 'description, ASC' [CLIENT]

    @T2659 //'Назначение платежа'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2660 //'Назначение платежа'. Сортировка по полю 'contractorId, DESC' [CLIENT]
    @T2661 //'Назначение платежа'. Сортировка по полю 'customerId, DESC' [CLIENT]
    @T2662 //'Назначение платежа'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun groundSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                GroundSortingTest(user, ID::asc).withId(T2655::class),
                /* т.к. поле contractorId не обязательное, может возникнуть такая ситуация,
                когда документов без этого поля больше значения лимита для сортировки [SortingTestTemplate.limit]
                и тест не найдет необходимых 3х записей для проверки сортировки.
                Временное решение - удалить все созданные (исторические) записи [GroundPrepareSteps.cleanAtCreated()] */
                GroundSortingTest(user, CONTRACTOR_ID::asc).withId(T2656::class),
                GroundSortingTest(user, CUSTOMER_ID::asc).withId(T2657::class),
                GroundSortingTest(user, DESCRIPTION::asc).withId(T2658::class),

                GroundSortingTest(user, ID::desc).withId(T2659::class),
                GroundSortingTest(user, CONTRACTOR_ID::desc).withId(T2660::class),
                GroundSortingTest(user, CUSTOMER_ID::desc).withId(T2661::class),
                GroundSortingTest(user, DESCRIPTION::desc).withId(T2662::class)
            )
        )
    }

    @TestFactory
    @T2634 //'Назначение платежа'. Сортировка по полю 'id, ASC' [BANK]
    @T2635 //'Назначение платежа'. Сортировка по полю 'contractorId, ASC' [BANK]
    @T2636 //'Назначение платежа'. Сортировка по полю 'customerId, ASC' [BANK]
    @T2637 //'Назначение платежа'. Сортировка по полю 'description, ASC' [BANK]

    @T2638 //'Назначение платежа'. Сортировка по полю 'id, DESC' [BANK]
    @T2639 //'Назначение платежа'. Сортировка по полю 'contractorId, DESC' [BANK]
    @T2640 //'Назначение платежа'. Сортировка по полю 'customerId, DESC' [BANK]
    @T2641 //'Назначение платежа'. Сортировка по полю 'description, DESC' [BANK]
    internal fun groundSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                GroundSortingTest(user, ID::asc).withId(T2634::class),
                GroundSortingTest(user, CONTRACTOR_ID::asc).withId(T2635::class),
                GroundSortingTest(user, CUSTOMER_ID::asc).withId(T2636::class),
                GroundSortingTest(user, DESCRIPTION::asc).withId(T2637::class),

                GroundSortingTest(user, ID::desc).withId(T2638::class),
                GroundSortingTest(user, CONTRACTOR_ID::desc).withId(T2639::class),
                GroundSortingTest(user, CUSTOMER_ID::desc).withId(T2640::class),
                GroundSortingTest(user, DESCRIPTION::desc).withId(T2641::class)
            )
        )
    }


    @TestFactory
    @T2642 //'Назначение платежа'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2643 //'Назначение платежа'. Фильтрация по полю 'contractorId' (eq) [CLIENT]
    @T2644 //'Назначение платежа'. Фильтрация по полю 'customerId' (eq) [CLIENT]
    @T2645 //'Назначение платежа'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T2646 //'Назначение платежа'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun groundFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                GroundFiltrationTest("id equals", user, { groundForContractorA },
                    { GroundFilterParams.ID.eq(it!!.id!!) }).withId(T2642::class),
                GroundFiltrationTest("contractorId equals", user, { groundForContractorA },
                    { GroundFilterParams.CONTRACTOR_ID.eq(it!!.contractorId!!) }).withId(T2643::class),
                GroundFiltrationTest("customerId equals", user, { groundForContractorA },
                    { GroundFilterParams.CUSTOMER_ID.eq(it!!.customerId) }).withId(T2644::class),
                GroundFiltrationTest("description equals", user, { groundForContractorA },
                    { GroundFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T2645::class),
                GroundFiltrationTest("description contains", user, { groundForContractorA },
                    { GroundFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T2646::class)
            )
        )
    }

    @TestFactory
    @T2650 //'Назначение платежа'. Фильтрация по полю 'id' (eq) [BANK]
    @T2651 //'Назначение платежа'. Фильтрация по полю 'contractorId' (eq) [BANK]
    @T2652 //'Назначение платежа'. Фильтрация по полю 'customerId' (eq) [BANK]
    @T2653 //'Назначение платежа'. Фильтрация по полю 'description' (eq) [BANK]
    @T2654 //'Назначение платежа'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun groundFiltrationBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                GroundFiltrationTest("id equals", user, { groundForContractorA },
                    { GroundFilterParams.ID.eq(it!!.id!!) }).withId(T2650::class),
                GroundFiltrationTest("contractorId equals", user, { groundForContractorA },
                    { GroundFilterParams.CONTRACTOR_ID.eq(it!!.contractorId!!) }).withId(T2651::class),
                GroundFiltrationTest("customerId equals", user, { groundForContractorA },
                    { GroundFilterParams.CUSTOMER_ID.eq(it!!.customerId) }).withId(T2652::class),
                GroundFiltrationTest("description equals", user, { groundForContractorA },
                    { GroundFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T2653::class),
                GroundFiltrationTest("description contains", user, { groundForContractorA },
                    { GroundFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T2654::class)
            )
        )
    }


    @TestFactory
    @T2647 //'Назначение платежа'. Получить список оснований платежа с учетом контрагента
    @T2648 //'Назначение платежа'. Получить список общих оснований платежа без контрагентов
    @T2649 //'Назначение платежа'. Получить страницу оснований платежа с учетом контрагента
    internal fun groundOtherTest(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UnitBeTest(
                    name = "'${DictionaryNames.GROUND}'. Получить список оснований платежа с учетом контрагента",
                    testBody = {
                        val steps = GroundSteps(clientUser)

                        val contractorAId = groundForContractorA.contractorId!!
                        val contractorBId = groundForContractorB.contractorId!!
                        val listForContractor = steps.getListForContractor(contractorAId)

                        "Проверить, что список содержит инфо о контрагенте 'А' ($contractorAId), но не 'Б' ($contractorBId)" {
                            listForContractor.list.assertIsNotEmpty()
                            val actualContractorIds = listForContractor.list!!.map { it.contractorId }
                            assertThat("Список не содержит $contractorAId", actualContractorIds.contains(contractorAId))
                            assertThat("Список содержит $contractorBId", actualContractorIds.none { it == contractorBId })
                        }
                    }
                ).withId(T2647::class),
                UnitBeTest(
                    name = "'${DictionaryNames.GROUND}'. Получить список общих оснований платежа без контрагентов",
                    testBody = {
                        val steps = GroundSteps(clientUser)

                        val listForContractor = steps.getListForContractor(null)

                        "Проверить, что список не содержит инфо о контрагентах" {
                            listForContractor.list.assertIsNotEmpty()
                            val actualContractorIds = listForContractor.list!!.mapNotNull { it.contractorId }
                            assertThat("Список не содержит ID контрагентов", actualContractorIds.isEmpty())
                        }
                    }
                ).withId(T2648::class),
                UnitBeTest(
                    name = "'${DictionaryNames.GROUND}'. Получить страницу оснований платежа с учетом контрагента",
                    testBody = {
                        val steps = GroundSteps(clientUser)

                        val contractorAId = groundForContractorA.contractorId!!
                        val contractorBId = groundForContractorB.contractorId!!
                        val listForContractor = steps.getPageForContractor(contractorAId)

                        "Проверить, что страница содержит инфо о контрагенте 'А' ($contractorAId), но не 'Б' ($contractorBId)" {
                            listForContractor.page.assertIsNotEmpty()
                            val actualContractorIds = listForContractor.page!!.map { it.contractorId }
                            assertThat("Список не содержит $contractorAId", actualContractorIds.contains(contractorAId))
                            assertThat("Список содержит $contractorBId", actualContractorIds.none { it == contractorBId })
                        }
                    }
                ).withId(T2649::class)
            ).map { it
                .withFolder(GroundFolderOther::class)
                .withPriority(Tm4jPriority.Normal)
                .withComponent(Tm4jComponent.DICTIONARY)
                .withTaskIds(Tm4jEpic.EPIC_R_RKO_DICTIONARY)
            }
        )
    }
}