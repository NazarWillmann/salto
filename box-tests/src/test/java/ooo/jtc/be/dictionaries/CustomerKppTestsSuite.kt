package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CUSTOMERKPP
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppCreateTest
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppDeleteTest
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppFiltrationTest
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppGetPageTest
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppGetTest
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppPrepareSteps
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppSortingTest
import ooo.jtc.api.dictionaries.customerkpp.CustomerKppUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.customerkpp.CustomerKpp
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppData
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppFilterParams
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppSortingParams.ID
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppSortingParams.IS_DEFAULT
import ooo.jtc.testdata.dictionaries.customerkpp.CustomerKppSortingParams.UNIT_NAME
import ooo.jtc.uaa.User
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.CUSTOMER_KPP)
@DisplayName("API '${DictionaryNames.CUSTOMER_KPP}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CUSTOMERKPP
@TestInstance(PER_CLASS)
class CustomerKppTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T2663") annotation class T2663
@Tag("JTCSALTO-T2664") annotation class T2664
@Tag("JTCSALTO-T2665") annotation class T2665
@Tag("JTCSALTO-T2666") annotation class T2666
@Tag("JTCSALTO-T2667") annotation class T2667
@Tag("JTCSALTO-T2668") annotation class T2668
@Tag("JTCSALTO-T2669") annotation class T2669
@Tag("JTCSALTO-T2670") annotation class T2670
@Tag("JTCSALTO-T2671") annotation class T2671
@Tag("JTCSALTO-T2672") annotation class T2672
@Tag("JTCSALTO-T2673") annotation class T2673
@Tag("JTCSALTO-T2674") annotation class T2674
@Tag("JTCSALTO-T2675") annotation class T2675
@Tag("JTCSALTO-T2676") annotation class T2676
@Tag("JTCSALTO-T2677") annotation class T2677
@Tag("JTCSALTO-T2678") annotation class T2678
@Tag("JTCSALTO-T2679") annotation class T2679
@Tag("JTCSALTO-T2680") annotation class T2680
@Tag("JTCSALTO-T2681") annotation class T2681
@Tag("JTCSALTO-T2682") annotation class T2682
@Tag("JTCSALTO-T2683") annotation class T2683
@Tag("JTCSALTO-T2684") annotation class T2684
@Tag("JTCSALTO-T2685") annotation class T2685
@Tag("JTCSALTO-T2686") annotation class T2686
@Tag("JTCSALTO-T2687") annotation class T2687
@Tag("JTCSALTO-T2688") annotation class T2688
@Tag("JTCSALTO-T2689") annotation class T2689
@Tag("JTCSALTO-T2690") annotation class T2690
@Tag("JTCSALTO-T2691") annotation class T2691
@Tag("JTCSALTO-T2692") annotation class T2692
@Tag("JTCSALTO-T2693") annotation class T2693
@Tag("JTCSALTO-T2694") annotation class T2694
@Tag("JTCSALTO-T2695") annotation class T2695
@Tag("JTCSALTO-T5257") annotation class T5257
@Tag("JTCSALTO-T5258") annotation class T5258
@Tag("JTCSALTO-T5259") annotation class T5259
@Tag("JTCSALTO-T5260") annotation class T5260
@Tag("JTCSALTO-T5261") annotation class T5261
@Tag("JTCSALTO-T5262") annotation class T5262
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val adminUser = Users.bankAdmin
    private lateinit var clientTestDataScope: TestDataScope<CustomerKpp>
    private lateinit var bankTestDataScope: TestDataScope<CustomerKpp>
    // Khatmullin [2021.07.06] not relevant, now it is a nested object
   // @BeforeAll
    fun prepareTestData() {
        val availableToClient = CustomerKppData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = CustomerKppData.withRequiredFields(
            customCreator = { CustomerKppPrepareSteps.createCustomerKppDto(clientUser).toModel() },
            additionalFilter = { it.id!! in availableToClient }
        )
        val availableToBank = CustomerKppData.searchBy(adminUser).map { it.id!! }
        bankTestDataScope = CustomerKppData.withRequiredFields(
            customCreator = { CustomerKppPrepareSteps.createCustomerKppDto(adminUser).toModel() },
            additionalFilter = { it.id!! in availableToBank }
        )
    }

  //  @AfterAll
    fun cleanTestData() {
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

 //   @TestFactory
    @T2685 //'КПП клиента'. CRUD: Создаем запись от пользователя [BANK]
    @T2686 //'КПП клиента'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2687 //'КПП клиента'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2688 //'КПП клиента'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2689 //'КПП клиента'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2690 //'КПП клиента'. CRUD: Удаляем запись от пользователя [BANK]
    @T2691 //'КПП клиента'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun customerKppCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CustomerKppCreateTest().withId(T2685::class),
                CustomerKppGetTest(user = clientUser).withId(T2686::class),
                CustomerKppGetTest(user = adminUser).withId(T2687::class),
                CustomerKppGetPageTest(user = clientUser).withId(T2688::class),
                CustomerKppGetPageTest(user = adminUser).withId(T2689::class),
                CustomerKppDeleteTest().withId(T2690::class),
                CustomerKppUpdateTest().withId(T2691::class)
            )
        )
    }

    //    @TestFactory
    @T2667 //'КПП клиента'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2668 //'КПП клиента'. Сортировка по полю 'kpp, ASC' [CLIENT]
    @T5257 //'КПП клиента'. Сортировка по полю 'unitName, ASC' [CLIENT]
    @T2669 //'КПП клиента'. Сортировка по полю 'customerId, ASC' [CLIENT]
    @T2670 //'КПП клиента'. Сортировка по полю 'isDefault, ASC' [CLIENT]

    @T2671 //'КПП клиента'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2672 //'КПП клиента'. Сортировка по полю 'kpp, DESC' [CLIENT]
    @T5258 //'КПП клиента'. Сортировка по полю 'unitName, DESC' [CLIENT]
    @T2673 //'КПП клиента'. Сортировка по полю 'customerId, DESC' [CLIENT]
    @T2674 //'КПП клиента'. Сортировка по полю 'isDefault, DESC' [CLIENT]
    internal fun customerKppSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerKppSortingTest(user, ID::asc).withId(T2667::class),
//                CustomerKppSortingTest(user, KPP::asc).withId(T2668::class),
                CustomerKppSortingTest(user, UNIT_NAME::asc).withId(T5257::class),
//                CustomerKppSortingTest(user, CUSTOMER_ID::asc).withId(T2669::class),
                CustomerKppSortingTest(user, IS_DEFAULT::asc).withId(T2670::class),

                CustomerKppSortingTest(user, ID::desc).withId(T2671::class),
//                CustomerKppSortingTest(user, KPP::desc).withId(T2672::class),
                CustomerKppSortingTest(user, UNIT_NAME::desc).withId(T5258::class),
//                CustomerKppSortingTest(user, CUSTOMER_ID::desc).withId(T2673::class),
                CustomerKppSortingTest(user, IS_DEFAULT::desc).withId(T2674::class)
            )
        )
    }

//    @TestFactory
    @T2675 //'КПП клиента'. Сортировка по полю 'id, ASC' [BANK]
    @T2676 //'КПП клиента'. Сортировка по полю 'kpp, ASC' [BANK]
    @T5259 //'КПП клиента'. Сортировка по полю 'unitName, ASC' [BANK]
    @T2677 //'КПП клиента'. Сортировка по полю 'customerId, ASC' [BANK]
    @T2678 //'КПП клиента'. Сортировка по полю 'isDefault, ASC' [BANK]

    @T2679 //'КПП клиента'. Сортировка по полю 'id, DESC' [BANK]
    @T2680 //'КПП клиента'. Сортировка по полю 'kpp, DESC' [BANK]
    @T5260 //'КПП клиента'. Сортировка по полю 'unitName, DESC' [BANK]
    @T2681 //'КПП клиента'. Сортировка по полю 'customerId, DESC' [BANK]
    @T2682 //'КПП клиента'. Сортировка по полю 'isDefault, DESC' [BANK]
    internal fun customerKppSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerKppSortingTest(user, ID::asc).withId(T2675::class),
//                CustomerKppSortingTest(user, KPP::asc).withId(T2676::class),
                CustomerKppSortingTest(user, UNIT_NAME::asc).withId(T5259::class),
//                CustomerKppSortingTest(user, CUSTOMER_ID::asc).withId(T2677::class),
                CustomerKppSortingTest(user, IS_DEFAULT::asc).withId(T2678::class),

                CustomerKppSortingTest(user, ID::desc).withId(T2679::class),
//                CustomerKppSortingTest(user, KPP::desc).withId(T2680::class),
                CustomerKppSortingTest(user, UNIT_NAME::desc).withId(T5260::class),
//                CustomerKppSortingTest(user, CUSTOMER_ID::desc).withId(T2681::class),
                CustomerKppSortingTest(user, IS_DEFAULT::desc).withId(T2682::class)
            )
        )
    }

    private val clientDataForFilter by lazy { clientTestDataScope.all.random().toDto() }
    private val adminDataForFilter by lazy { bankTestDataScope.all.random().toDto() }

    private fun getDataForFilter(user: User): CustomerKppDto {
        return when (user) {
            clientUser -> clientDataForFilter
            adminUser -> adminDataForFilter
            else -> throw RuntimeException("Unexpected user '${user.login}'[${user.userType}]")
        }
    }

//    @TestFactory
    @T2663 //'КПП клиента'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2664 //'КПП клиента'. Фильтрация по полю 'kpp' (eq) [CLIENT]
    @T5261 //'КПП клиента'. Фильтрация по полю 'unitName' (eq) [CLIENT]
    @T2665 //'КПП клиента'. Фильтрация по полю 'customerId' (eq) [CLIENT]
    @T2666 //'КПП клиента'. Фильтрация по полю 'isDefault' (eq) [CLIENT]
    internal fun customerKppFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerKppFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { CustomerKppFilterParams.ID.eq(it!!.id!!) }).withId(T2663::class),
//                CustomerKppFiltrationTest("kpp equals", user, { getDataForFilter(user) },
//                    { CustomerKppFilterParams.KPP.eq(it!!.kpp) }).withId(T2664::class),
                CustomerKppFiltrationTest("unitName equals", user, { getDataForFilter(user) },
                    { CustomerKppFilterParams.UNIT_NAME.eq(it!!.unitName!!) }).withId(T5261::class),
//               CustomerKppFiltrationTest("customerId equals", user, { getDataForFilter(user) },
//                   { CustomerKppFilterParams.CUSTOMER_ID.eq(it!!.idCustomer) }).withId(T2665::class),
                CustomerKppFiltrationTest("isDefault equals", user, { getDataForFilter(user) },
                    { CustomerKppFilterParams.IS_DEFAULT.eq(it!!.isDefault) }).withId(T2666::class)
            )
        )
    }

//    @TestFactory
    @T2692 //'КПП клиента'. Фильтрация по полю 'id' (eq) [BANK]
    @T2693 //'КПП клиента'. Фильтрация по полю 'kpp' (eq) [BANK]
    @T5262 //'КПП клиента'. Фильтрация по полю 'unitName' (eq) [BANK]
    @T2694 //'КПП клиента'. Фильтрация по полю 'customerId' (eq) [BANK]
    @T2695 //'КПП клиента'. Фильтрация по полю 'isDefault' (eq) [BANK]
    internal fun customerKppFiltrationBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerKppFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { CustomerKppFilterParams.ID.eq(it!!.id!!) }).withId(T2692::class),
                CustomerKppFiltrationTest("kpp equals", user, { getDataForFilter(user) },
//                   { CustomerKppFilterParams.KPP.eq(it!!.kpp) }).withId(T2693::class),
//               CustomerKppFiltrationTest("unitName equals", user, { getDataForFilter(user) },
                    { CustomerKppFilterParams.UNIT_NAME.eq(it!!.unitName!!) }).withId(T5262::class),
//                CustomerKppFiltrationTest("customerId equals", user, { getDataForFilter(user) },
//                    { CustomerKppFilterParams.CUSTOMER_ID.eq(it!!.idCustomer) }).withId(T2694::class),
                CustomerKppFiltrationTest("isDefault equals", user, { getDataForFilter(user) },
                    { CustomerKppFilterParams.IS_DEFAULT.eq(it!!.isDefault) }).withId(T2695::class)
            )
        )
    }

//   private fun getDefaultCustomerKppBody(user: User, cKpp: CustomerKppDto) {
//       val response = CustomerKppSteps(user).getDefaultCustomerKppByCustomerId(cKpp.idCustomer)
//       val actResult = response.data!!

//       "Проверить, что в ответе вернулся КПП клиента по умолчанию для клиента с id = '${cKpp.idCustomer}'" {
//           assertThat("id клиента отличается от ожидаемого", actResult.idCustomer, equalTo(cKpp.idCustomer))
//           assertThat("В ответе не та запись, что ожидается", actResult.id!!, equalTo(cKpp.id!!))
//       }
//   }

  //  @TestFactory
    @T2683 //'КПП клиента'. Получение КПП клиента по умолчанию по id клиента [CLIENT]
    @T2684 //'КПП клиента'. Получение КПП клиента по умолчанию по id клиента [BANK]
    internal fun getDefaultCustomerKppTest(): List<DynamicTest> {
        val testName = "'${DictionaryNames.CUSTOMER_KPP}'. Получение КПП клиента по умолчанию по id клиента"
        val defaultKppClient = CustomerKppData.getOrCreateDefault(clientUser).toDto()
        val defaultKppBank = CustomerKppData.getOrCreateDefault(adminUser).toDto()

        return EntityTestGenerator.generate(
            listOf(
//                UnitBeTest(
//                    name = "$testName [${clientUser.userType}]",
//                    params = { mapOf(PARAM_USER to clientUser, "КПП" to defaultKppClient) },
//                    testBody = { getDefaultCustomerKppBody(clientUser, defaultKppClient) }
//                ).withId(T2683::class),
//                UnitBeTest(
//                    name = "$testName [${adminUser.userType}]",
//                    params = { mapOf(PARAM_USER to adminUser, "КПП" to defaultKppBank) },
//                    testBody = { getDefaultCustomerKppBody(adminUser, defaultKppBank) }
//                ).withId(T2684::class)
           //).map { it
           //    .withFolder(CustomerKppFolderOther::class)
           //    .withPriority(Tm4jPriority.Normal)
           //    .withComponent(Tm4jComponent.DICTIONARY)
           //    .withTaskIds(Tm4jEpic.EPIC_R_RKO_DICTIONARY)
           //}
        ))
    }
}