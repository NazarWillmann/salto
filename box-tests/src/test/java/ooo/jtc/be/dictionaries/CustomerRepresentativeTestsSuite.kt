package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CUSTOMERREPRESENTATIVE
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeBlockingTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeCreateTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeDeleteTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeFiltrationTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeGetForUser
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeGetPageTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeGetTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeSortingTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeUnblockingTest
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentative
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.BLOCK_DATE
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.BLOCK_USER
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.CUSTOMER_ID
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.EMAIL
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.ID
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.IS_BLOCKED
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.PHONE
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.POSITION
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeSortingParams.USER_ID
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
@Story(DictionaryNames.CUSTOMER_REPRESENTATIVE)
@DisplayName("API '${DictionaryNames.CUSTOMER_REPRESENTATIVE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CUSTOMERREPRESENTATIVE
@TestInstance(PER_CLASS)
class CustomerRepresentativeTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T3087") annotation class T3087
@Tag("JTCSALTO-T3088") annotation class T3088
@Tag("JTCSALTO-T3089") annotation class T3089
@Tag("JTCSALTO-T3090") annotation class T3090
@Tag("JTCSALTO-T3091") annotation class T3091
@Tag("JTCSALTO-T3092") annotation class T3092
@Tag("JTCSALTO-T3093") annotation class T3093
@Tag("JTCSALTO-T3094") annotation class T3094
@Tag("JTCSALTO-T3095") annotation class T3095
@Tag("JTCSALTO-T3096") annotation class T3096
@Tag("JTCSALTO-T3097") annotation class T3097
@Tag("JTCSALTO-T3098") annotation class T3098
@Tag("JTCSALTO-T3099") annotation class T3099
@Tag("JTCSALTO-T3100") annotation class T3100
@Tag("JTCSALTO-T3101") annotation class T3101
@Tag("JTCSALTO-T3102") annotation class T3102
@Tag("JTCSALTO-T3103") annotation class T3103
@Tag("JTCSALTO-T3104") annotation class T3104
@Tag("JTCSALTO-T3105") annotation class T3105
@Tag("JTCSALTO-T3106") annotation class T3106
@Tag("JTCSALTO-T3107") annotation class T3107
@Tag("JTCSALTO-T3108") annotation class T3108
@Tag("JTCSALTO-T3109") annotation class T3109
@Tag("JTCSALTO-T3110") annotation class T3110
@Tag("JTCSALTO-T3111") annotation class T3111
@Tag("JTCSALTO-T3112") annotation class T3112
@Tag("JTCSALTO-T3113") annotation class T3113
@Tag("JTCSALTO-T3114") annotation class T3114
@Tag("JTCSALTO-T3115") annotation class T3115
@Tag("JTCSALTO-T3116") annotation class T3116
@Tag("JTCSALTO-T3117") annotation class T3117
@Tag("JTCSALTO-T3118") annotation class T3118
@Tag("JTCSALTO-T3119") annotation class T3119
@Tag("JTCSALTO-T3121") annotation class T3121
@Tag("JTCSALTO-T5582") annotation class T5582
@Tag("JTCSALTO-T5583") annotation class T5583
@Tag("JTCSALTO-T5584") annotation class T5584
@Tag("JTCSALTO-T5585") annotation class T5585
@Tag("JTCSALTO-T5586") annotation class T5586
@Tag("JTCSALTO-T5587") annotation class T5587
@Tag("JTCSALTO-T5588") annotation class T5588
@Tag("JTCSALTO-T5589") annotation class T5589
@Tag("JTCSALTO-T5590") annotation class T5590
//@formatter:on
//endregion

    private val almightyUser = Users.superUser
    private val clientUser = Users.client
    private lateinit var dataForFilter: CustomerRepresentativeDto
    private lateinit var blockedDataForFilter: CustomerRepresentativeDto
    private lateinit var testDataScope: TestDataScope<CustomerRepresentative>

    @BeforeAll
    fun prepareCustomerRepresentativeTestData() {
        val allGeneratedCustomerRepresentatives = mutableListOf<CustomerRepresentative>()

        testDataScope = CustomerRepresentativeData.withRequiredFields(
            additionalFilter = { !it.isBlock },
            customCreator = {
                val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
                val preparedCustomerRepres = CustomerRepresentativePrepareSteps.getCustomerRepresentativeDtoForCreate(
                    uaaUserId = clientUser.uaaUserId!!,
                    customerId = newCustomer.id!!
                )
                val bankRepres = CustomerRepresentativePrepareSteps.createCustomerRepresentative(preparedCustomerRepres)
                bankRepres.toModel()
            }
        )
        dataForFilter = testDataScope.all.random().toDto()

        repeat(
            times = REQUIRED_DATA_COUNT.toInt(),
            action = {
                val newCustomer = CustomerPrepareSteps.createCustomerWithNoRelations()
                val preparedCustomerRepres = CustomerRepresentativePrepareSteps.getCustomerRepresentativeDtoForCreate(
                    uaaUserId = clientUser.uaaUserId!!,
                    customerId = newCustomer.id!!
                )
                val bankRepres = CustomerRepresentativePrepareSteps.createBlockedCustomerRepresentativeDto(preparedCustomerRepres)
                allGeneratedCustomerRepresentatives.add(bankRepres.toModel())
            }
        )
        blockedDataForFilter = allGeneratedCustomerRepresentatives.random().toDto()

        allGeneratedCustomerRepresentatives.addAll(testDataScope.generated)
        testDataScope.generated = allGeneratedCustomerRepresentatives
    }

    @AfterAll
    fun cleanCustomerRepresentativeTestData() {
        testDataScope.removeGenerated { CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId!!) }
    }

    @TestFactory
    @T3087 //'Представитель Клиента ЮЛ'. CRUD: Создаем запись от пользователя [BANK]
    @T3088 //'Представитель Клиента ЮЛ'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3089 //'Представитель Клиента ЮЛ'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3090 //'Представитель Клиента ЮЛ'. CRUD: Удаляем запись от пользователя [BANK]
    @T3091 //'Представитель Клиента ЮЛ'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun clientRepresentativeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CustomerRepresentativeCreateTest(runTestAsUser = almightyUser, createEntityForUser = clientUser).withId(T3087::class),
                CustomerRepresentativeGetTest(almightyUser).withId(T3088::class),
                CustomerRepresentativeGetTest(Users.bankAdmin).withId(T3088::class),
                CustomerRepresentativeGetPageTest(almightyUser).withId(T3089::class),
                CustomerRepresentativeDeleteTest(almightyUser, createEntityForUser = clientUser).withId(T3090::class),
                CustomerRepresentativeUpdateTest(almightyUser, createEntityForUser = clientUser).withId(T3091::class)
            )
        )
    }

    @TestFactory
    @T5582 //'Представитель Клиента ЮЛ'. Блокировка [BANK]
    @T5583 //'Представитель Клиента ЮЛ'. Разблокировка [BANK]
    internal fun branchRepresentativeBlockingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CustomerRepresentativeBlockingTest(almightyUser, createEntityForUser = clientUser).withId(T5582::class),
                CustomerRepresentativeUnblockingTest(almightyUser, createEntityForUser = clientUser).withId(T5583::class)
            //TODO Sergeyev [2021.04.13]: add tests for correct blocking logic (unavailable customers)
            //TODO Sergeyev [2021.04.13]: add accessibility tests for client users and operator/admin users
            )
        )
    }

    @TestFactory
    @T3092 //'Представитель Клиента ЮЛ'. Сортировка по полю 'id, ASC' [BANK]
    @T3093 //'Представитель Клиента ЮЛ'. Сортировка по полю 'customerId, ASC' [BANK]
    @T3094 //'Представитель Клиента ЮЛ'. Сортировка по полю 'userId, ASC' [BANK]
    @T3095 //'Представитель Клиента ЮЛ'. Сортировка по полю 'isBlock, ASC' [BANK]
    @T5584 //'Представитель Клиента ЮЛ'. Сортировка по полю 'block.blockDate, ASC' [BANK]
    @T5585 //'Представитель Клиента ЮЛ'. Сортировка по полю 'block.blockUser, ASC' [BANK]
    @T3096 //'Представитель Клиента ЮЛ'. Сортировка по полю 'description, ASC' [BANK]
    @T3097 //'Представитель Клиента ЮЛ'. Сортировка по полю 'position, ASC' [BANK]
    @T3098 //'Представитель Клиента ЮЛ'. Сортировка по полю 'email, ASC' [BANK]
    @T3099 //'Представитель Клиента ЮЛ'. Сортировка по полю 'phone, ASC' [BANK]

    @T3100 //'Представитель Клиента ЮЛ'. Сортировка по полю 'id, DESC' [BANK]
    @T3101 //'Представитель Клиента ЮЛ'. Сортировка по полю 'customerId, DESC' [BANK]
    @T3102 //'Представитель Клиента ЮЛ'. Сортировка по полю 'userId, DESC' [BANK]
    @T3103 //'Представитель Клиента ЮЛ'. Сортировка по полю 'isBlock, DESC' [BANK]
    @T5586 //'Представитель Клиента ЮЛ'. Сортировка по полю 'block.blockDate, DESC' [BANK]
    @T5587 //'Представитель Клиента ЮЛ'. Сортировка по полю 'block.blockUser, DESC' [BANK]
    @T3104 //'Представитель Клиента ЮЛ'. Сортировка по полю 'description, DESC' [BANK]
    @T3105 //'Представитель Клиента ЮЛ'. Сортировка по полю 'position, DESC' [BANK]
    @T3106 //'Представитель Клиента ЮЛ'. Сортировка по полю 'email, DESC' [BANK]
    @T3107 //'Представитель Клиента ЮЛ'. Сортировка по полю 'phone, DESC' [BANK]
    internal fun sortingTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerRepresentativeSortingTest(user, ID::asc).withId(T3092::class),
                CustomerRepresentativeSortingTest(user, CUSTOMER_ID::asc).withId(T3093::class),
                CustomerRepresentativeSortingTest(user, USER_ID::asc).withId(T3094::class),
                CustomerRepresentativeSortingTest(user, IS_BLOCKED::asc).withId(T3095::class),
                CustomerRepresentativeSortingTest(user, BLOCK_DATE::asc).withId(T5584::class),
                CustomerRepresentativeSortingTest(user, BLOCK_USER::asc).withId(T5585::class),
                CustomerRepresentativeSortingTest(user, DESCRIPTION::asc).withId(T3096::class),
                CustomerRepresentativeSortingTest(user, POSITION::asc).withId(T3097::class),
                CustomerRepresentativeSortingTest(user, EMAIL::asc).withId(T3098::class),
                CustomerRepresentativeSortingTest(user, PHONE::asc).withId(T3099::class),

                CustomerRepresentativeSortingTest(user, ID::desc).withId(T3100::class),
                CustomerRepresentativeSortingTest(user, CUSTOMER_ID::desc).withId(T3101::class),
                CustomerRepresentativeSortingTest(user, USER_ID::desc).withId(T3102::class),
                CustomerRepresentativeSortingTest(user, IS_BLOCKED::desc).withId(T3103::class),
                CustomerRepresentativeSortingTest(user, BLOCK_DATE::desc).withId(T5586::class),
                CustomerRepresentativeSortingTest(user, BLOCK_USER::desc).withId(T5587::class),
                CustomerRepresentativeSortingTest(user, DESCRIPTION::desc).withId(T3104::class),
                CustomerRepresentativeSortingTest(user, POSITION::desc).withId(T3105::class),
                CustomerRepresentativeSortingTest(user, EMAIL::desc).withId(T3106::class),
                CustomerRepresentativeSortingTest(user, PHONE::desc).withId(T3107::class)
            )
        )
    }

    @TestFactory
    @T3108 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'id' (eq) [BANK]
    @T3109 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'customerId' (eq) [BANK]
    @T3110 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'userId' (eq) [BANK]
    @T3111 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'isBlock' (eq) [BANK]
    @T5588 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'block.blockDate' (ge) [BANK]
    @T5589 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'block.blockDate' (le) [BANK]
    @T5590 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'block.blockUser' (eq) [BANK]
    @T3112 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'description' (eq) [BANK]
    @T3113 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'description' (contains) [BANK]
    @T3114 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'position' (eq) [BANK]
    @T3115 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'position' (contains) [BANK]
    @T3116 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'email' (eq) [BANK]
    @T3117 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'email' (contains) [BANK]
    @T3118 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'phone' (eq) [BANK]
    @T3119 //'Представитель Клиента ЮЛ'. Фильтрация по полю 'phone' (contains) [BANK]
    internal fun filtrationTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerRepresentativeFiltrationTest("id equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.ID.eq(it!!.id!!) }).withId(T3108::class),
                CustomerRepresentativeFiltrationTest("customerId equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.CUSTOMER_ID.eq(it!!.customerId!!) }).withId(T3109::class),
                CustomerRepresentativeFiltrationTest("userId equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.USER_ID.eq(it!!.userId!!) }).withId(T3110::class),
                CustomerRepresentativeFiltrationTest("isBlocked equals", user, { blockedDataForFilter },
                    { CustomerRepresentativeFilterParams.IS_BLOCKED.eq(it!!.block.isBlock) }).withId(T3111::class),
                CustomerRepresentativeFiltrationTest("blockDate greaterOrEquals", user, { blockedDataForFilter },
                    { CustomerRepresentativeFilterParams.BLOCK_DATE.ge(it!!.block.blockDate!!.minusSeconds(5)) }).withId(T5588::class),
                CustomerRepresentativeFiltrationTest("blockDate lesserOrEquals", user, { blockedDataForFilter },
                    { CustomerRepresentativeFilterParams.BLOCK_DATE.le(it!!.block.blockDate!!.plusSeconds(5)) }).withId(T5589::class),
                CustomerRepresentativeFiltrationTest("blockUser equals", user, { blockedDataForFilter },
                    { CustomerRepresentativeFilterParams.BLOCK_USER.eq(it!!.block.blockUser!!) }).withId(T5590::class),
                CustomerRepresentativeFiltrationTest("description equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T3112::class),
                CustomerRepresentativeFiltrationTest("description contains", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T3113::class),
                CustomerRepresentativeFiltrationTest("position equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.POSITION.eq(it!!.position!!) }).withId(T3114::class),
                CustomerRepresentativeFiltrationTest("position contains", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.POSITION.contains(it!!.position!!.randomSubstringPf()) }).withId(T3115::class),
                CustomerRepresentativeFiltrationTest("email equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.EMAIL.eq(it!!.email!!) }).withId(T3116::class),
                CustomerRepresentativeFiltrationTest("email contains", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T3117::class),
                CustomerRepresentativeFiltrationTest("phone equals", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.PHONE.eq(it!!.phone!!) }).withId(T3118::class),
                CustomerRepresentativeFiltrationTest("phone contains", user, { dataForFilter },
                    { CustomerRepresentativeFilterParams.PHONE.contains(it!!.phone!!.randomSubstringPf()) }).withId(T3119::class)
            )
        )
    }

    @TestFactory
    @T3121 //'Представитель Клиента ЮЛ'. Получение списка Представителей, доступных пользователю [BANK]
    internal fun getUserRepresentativesTest(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CustomerRepresentativeGetForUser(almightyUser, clientUser).withId(T3121::class)
            )
        )
    }
}