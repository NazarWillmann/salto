package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Step
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CUSTOMER
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.dictionaries.customer.CustomerCreateTest
import ooo.jtc.api.dictionaries.customer.CustomerDeleteTest
import ooo.jtc.api.dictionaries.customer.CustomerFiltrationTest
import ooo.jtc.api.dictionaries.customer.CustomerGetPageTest
import ooo.jtc.api.dictionaries.customer.CustomerGetTest
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.createCustomerWithRelationsForUser
import ooo.jtc.api.dictionaries.customer.CustomerSortingTest
import ooo.jtc.api.dictionaries.customer.CustomerUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.dictionaries.customer.CustomerDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankOperator
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerFilterParams
import ooo.jtc.testdata.dictionaries.customer.CustomerSortingParams
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
@Story(DictionaryNames.CUSTOMER)
@DisplayName("API '${DictionaryNames.CUSTOMER}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CUSTOMER
@TestInstance(PER_CLASS)
class CustomerTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3612") annotation class T3612
@Tag("JTCSALTO-T3613") annotation class T3613
@Tag("JTCSALTO-T3614") annotation class T3614
@Tag("JTCSALTO-T3615") annotation class T3615
@Tag("JTCSALTO-T3616") annotation class T3616
@Tag("JTCSALTO-T3617") annotation class T3617
@Tag("JTCSALTO-T3618") annotation class T3618
@Tag("JTCSALTO-T3619") annotation class T3619
@Tag("JTCSALTO-T3620") annotation class T3620
@Tag("JTCSALTO-T3621") annotation class T3621
@Tag("JTCSALTO-T3622") annotation class T3622
@Tag("JTCSALTO-T3623") annotation class T3623
@Tag("JTCSALTO-T3624") annotation class T3624
@Tag("JTCSALTO-T3625") annotation class T3625
@Tag("JTCSALTO-T3626") annotation class T3626
@Tag("JTCSALTO-T3627") annotation class T3627
@Tag("JTCSALTO-T3628") annotation class T3628
@Tag("JTCSALTO-T3629") annotation class T3629
@Tag("JTCSALTO-T3630") annotation class T3630
@Tag("JTCSALTO-T3631") annotation class T3631
@Tag("JTCSALTO-T3632") annotation class T3632
@Tag("JTCSALTO-T3633") annotation class T3633
@Tag("JTCSALTO-T3634") annotation class T3634
@Tag("JTCSALTO-T3635") annotation class T3635
@Tag("JTCSALTO-T3636") annotation class T3636
@Tag("JTCSALTO-T3637") annotation class T3637
@Tag("JTCSALTO-T3638") annotation class T3638
@Tag("JTCSALTO-T3639") annotation class T3639
@Tag("JTCSALTO-T3640") annotation class T3640
@Tag("JTCSALTO-T3641") annotation class T3641
@Tag("JTCSALTO-T3642") annotation class T3642
@Tag("JTCSALTO-T3643") annotation class T3643
@Tag("JTCSALTO-T3644") annotation class T3644
@Tag("JTCSALTO-T3645") annotation class T3645
@Tag("JTCSALTO-T3646") annotation class T3646
@Tag("JTCSALTO-T3647") annotation class T3647
@Tag("JTCSALTO-T3648") annotation class T3648
@Tag("JTCSALTO-T3649") annotation class T3649
@Tag("JTCSALTO-T3650") annotation class T3650
@Tag("JTCSALTO-T3651") annotation class T3651
@Tag("JTCSALTO-T3652") annotation class T3652
@Tag("JTCSALTO-T3653") annotation class T3653
@Tag("JTCSALTO-T3654") annotation class T3654
@Tag("JTCSALTO-T3655") annotation class T3655
@Tag("JTCSALTO-T3656") annotation class T3656
@Tag("JTCSALTO-T3657") annotation class T3657
@Tag("JTCSALTO-T3658") annotation class T3658
@Tag("JTCSALTO-T3659") annotation class T3659
@Tag("JTCSALTO-T3660") annotation class T3660
@Tag("JTCSALTO-T3661") annotation class T3661
@Tag("JTCSALTO-T3662") annotation class T3662
@Tag("JTCSALTO-T3663") annotation class T3663
@Tag("JTCSALTO-T3664") annotation class T3664
@Tag("JTCSALTO-T3665") annotation class T3665
@Tag("JTCSALTO-T3666") annotation class T3666
@Tag("JTCSALTO-T3667") annotation class T3667
@Tag("JTCSALTO-T3668") annotation class T3668
@Tag("JTCSALTO-T3669") annotation class T3669
@Tag("JTCSALTO-T3670") annotation class T3670
@Tag("JTCSALTO-T3671") annotation class T3671
@Tag("JTCSALTO-T3672") annotation class T3672
@Tag("JTCSALTO-T3673") annotation class T3673
@Tag("JTCSALTO-T3674") annotation class T3674
@Tag("JTCSALTO-T3675") annotation class T3675
@Tag("JTCSALTO-T3676") annotation class T3676
@Tag("JTCSALTO-T3677") annotation class T3677
@Tag("JTCSALTO-T3678") annotation class T3678
@Tag("JTCSALTO-T3679") annotation class T3679
@Tag("JTCSALTO-T3680") annotation class T3680
@Tag("JTCSALTO-T3681") annotation class T3681
@Tag("JTCSALTO-T3682") annotation class T3682
@Tag("JTCSALTO-T3683") annotation class T3683
@Tag("JTCSALTO-T3684") annotation class T3684
@Tag("JTCSALTO-T3685") annotation class T3685
@Tag("JTCSALTO-T3686") annotation class T3686
@Tag("JTCSALTO-T3687") annotation class T3687
@Tag("JTCSALTO-T3688") annotation class T3688
@Tag("JTCSALTO-T3689") annotation class T3689
@Tag("JTCSALTO-T3690") annotation class T3690
@Tag("JTCSALTO-T3691") annotation class T3691
@Tag("JTCSALTO-T3692") annotation class T3692
@Tag("JTCSALTO-T3693") annotation class T3693
@Tag("JTCSALTO-T3694") annotation class T3694
@Tag("JTCSALTO-T3695") annotation class T3695
@Tag("JTCSALTO-T3696") annotation class T3696
@Tag("JTCSALTO-T3697") annotation class T3697
@Tag("JTCSALTO-T3698") annotation class T3698
@Tag("JTCSALTO-T3699") annotation class T3699
@Tag("JTCSALTO-T3700") annotation class T3700
@Tag("JTCSALTO-T3701") annotation class T3701
@Tag("JTCSALTO-T3702") annotation class T3702
@Tag("JTCSALTO-T3703") annotation class T3703
@Tag("JTCSALTO-T3704") annotation class T3704
@Tag("JTCSALTO-T3705") annotation class T3705
@Tag("JTCSALTO-T3706") annotation class T3706
@Tag("JTCSALTO-T3707") annotation class T3707
@Tag("JTCSALTO-T3708") annotation class T3708
@Tag("JTCSALTO-T3709") annotation class T3709
@Tag("JTCSALTO-T3710") annotation class T3710
//@formatter:on
//endregion
    private val clientUser = client
    private val bankUser = bankOperator

    private lateinit var clientTestDataScope: TestDataScope<Customer>
    private lateinit var bankTestDataScope: TestDataScope<Customer>

    @BeforeAll
    fun prepareCustomerTestsSuiteData() {
        val availableToClient = CustomerData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = CustomerData.withRequiredFields(
            additionalFilter = { it.id!! in availableToClient },
            customCreator = { createCustomerWithRelationsForUser(clientUser).toModel() }
        )
        val availableToBank = CustomerData.searchBy(bankUser).map { it.id!! }
        bankTestDataScope = CustomerData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBank },
            customCreator = { createCustomerWithRelationsForUser(bankUser).toModel() })
    }

    @AfterAll
    fun cleanCustomerTestsSuiteData() {
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

    @TestFactory
    @T3704 //'Клиент банка'. CRUD: Создаем запись от пользователя [BANK]
    @T3705 //'Клиент банка'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3706 //'Клиент банка'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3707 //'Клиент банка'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3708 //'Клиент банка'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3709 //'Клиент банка'. CRUD: Обновляем запись от пользователя [BANK]
    @T3710 //'Клиент банка'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun customerCrudTests(): List<DynamicTest> {
        val tests = listOf(
            CustomerCreateTest().withId(T3704::class),
            CustomerGetTest(user = clientUser).withId(T3705::class),
            CustomerGetTest(user = bankUser).withId(T3706::class),
            CustomerGetPageTest(user = clientUser).withId(T3707::class),
            CustomerGetPageTest(user = bankUser).withId(T3708::class),
            CustomerUpdateTest().withId(T3709::class),
            CustomerDeleteTest().withId(T3710::class)
        )

        return EntityTestGenerator.generate(tests)
    }
    //todo Khatmullin [2021.07.02] add kpp sorting and filtration tests
    @TestFactory
    @T3612 //'Клиент банка'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3613 //'Клиент банка'. Сортировка по полю 'inn, ASC' [CLIENT]
    @T3614 //'Клиент банка'. Сортировка по полю 'okpo, ASC' [CLIENT]
    @T3615 //'Клиент банка'. Сортировка по полю 'isBlock, ASC' [CLIENT]
    @T3616 //'Клиент банка'. Сортировка по полю 'fullName, ASC' [CLIENT]
    @T3617 //'Клиент банка'. Сортировка по полю 'shortName, ASC' [CLIENT]
    @T3618 //'Клиент банка'. Сортировка по полю 'isResident, ASC' [CLIENT]
    @T3619 //'Клиент банка'. Сортировка по полю 'customerTypeId, ASC' [CLIENT]
    @T3620 //'Клиент банка'. Сортировка по полю 'ogrn, ASC' [CLIENT]
    @T3621 //'Клиент банка'. Сортировка по полю 'oktmo, ASC' [CLIENT]
    @T3622 //'Клиент банка'. Сортировка по полю 'okved, ASC' [CLIENT]
    @T3623 //'Клиент банка'. Сортировка по полю 'email, ASC' [CLIENT]
    @T3624 //'Клиент банка'. Сортировка по полю 'phone, ASC' [CLIENT]
    @T3625 //'Клиент банка'. Сортировка по полю 'ogrnDate, ASC' [CLIENT]

    @T3626 //'Клиент банка'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3627 //'Клиент банка'. Сортировка по полю 'inn, DESC' [CLIENT]
    @T3628 //'Клиент банка'. Сортировка по полю 'okpo, DESC' [CLIENT]
    @T3629 //'Клиент банка'. Сортировка по полю 'isBlock, DESC' [CLIENT]
    @T3630 //'Клиент банка'. Сортировка по полю 'fullName, DESC' [CLIENT]
    @T3631 //'Клиент банка'. Сортировка по полю 'shortName, DESC' [CLIENT]
    @T3632 //'Клиент банка'. Сортировка по полю 'isResident, DESC' [CLIENT]
    @T3633 //'Клиент банка'. Сортировка по полю 'customerTypeId, DESC' [CLIENT]
    @T3634 //'Клиент банка'. Сортировка по полю 'ogrn, DESC' [CLIENT]
    @T3635 //'Клиент банка'. Сортировка по полю 'oktmo, DESC' [CLIENT]
    @T3636 //'Клиент банка'. Сортировка по полю 'okved, DESC' [CLIENT]
    @T3637 //'Клиент банка'. Сортировка по полю 'email, DESC' [CLIENT]
    @T3638 //'Клиент банка'. Сортировка по полю 'phone, DESC' [CLIENT]
    @T3639 //'Клиент банка'. Сортировка по полю 'ogrnDate, DESC' [CLIENT]
    internal fun customerSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerSortingTest(user, CustomerSortingParams.ID::asc).withId(T3612::class),
                CustomerSortingTest(user, CustomerSortingParams.INN::asc).withId(T3613::class),
                CustomerSortingTest(user, CustomerSortingParams.OKPO::asc).withId(T3614::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_BLOCKED::asc).withId(T3615::class),
                CustomerSortingTest(user, CustomerSortingParams.FULL_NAME::asc).withId(T3616::class),
                CustomerSortingTest(user, CustomerSortingParams.SHORT_NAME::asc).withId(T3617::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_RESIDENT::asc).withId(T3618::class),
//                CustomerSortingTest(user, CustomerSortingParams.CUSTOMER_TYPE_ID::asc).withId(T3619::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN::asc).withId(T3620::class),
                CustomerSortingTest(user, CustomerSortingParams.EMAIL::asc).withId(T3623::class),
                CustomerSortingTest(user, CustomerSortingParams.PHONE::asc).withId(T3624::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN_DATE::asc).withId(T3625::class),

                CustomerSortingTest(user, CustomerSortingParams.ID::desc).withId(T3626::class),
                CustomerSortingTest(user, CustomerSortingParams.INN::desc).withId(T3627::class),
                CustomerSortingTest(user, CustomerSortingParams.OKPO::desc).withId(T3628::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_BLOCKED::desc).withId(T3629::class),
                CustomerSortingTest(user, CustomerSortingParams.FULL_NAME::desc).withId(T3630::class),
                CustomerSortingTest(user, CustomerSortingParams.SHORT_NAME::desc).withId(T3631::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_RESIDENT::desc).withId(T3632::class),
//              CustomerSortingTest(user, CustomerSortingParams.CUSTOMER_TYPE_ID::desc).withId(T3633::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN::desc).withId(T3634::class),
                CustomerSortingTest(user, CustomerSortingParams.EMAIL::desc).withId(T3637::class),
                CustomerSortingTest(user, CustomerSortingParams.PHONE::desc).withId(T3638::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN_DATE::desc).withId(T3639::class)
            )
        )
    }

    @TestFactory
    @T3640 //'Клиент банка'. Сортировка по полю 'id, ASC' [BANK]
    @T3641 //'Клиент банка'. Сортировка по полю 'inn, ASC' [BANK]
    @T3642 //'Клиент банка'. Сортировка по полю 'okpo, ASC' [BANK]
    @T3643 //'Клиент банка'. Сортировка по полю 'isBlock, ASC' [BANK]
    @T3644 //'Клиент банка'. Сортировка по полю 'fullName, ASC' [BANK]
    @T3645 //'Клиент банка'. Сортировка по полю 'shortName, ASC' [BANK]
    @T3646 //'Клиент банка'. Сортировка по полю 'isResident, ASC' [BANK]
    @T3647 //'Клиент банка'. Сортировка по полю 'customerTypeId, ASC' [BANK]
    @T3648 //'Клиент банка'. Сортировка по полю 'ogrn, ASC' [BANK]
    @T3649 //'Клиент банка'. Сортировка по полю 'oktmo, ASC' [BANK]
    @T3650 //'Клиент банка'. Сортировка по полю 'okved, ASC' [BANK]
    @T3651 //'Клиент банка'. Сортировка по полю 'email, ASC' [BANK]
    @T3652 //'Клиент банка'. Сортировка по полю 'phone, ASC' [BANK]
    @T3653 //'Клиент банка'. Сортировка по полю 'ogrnDate, ASC' [BANK]

    @T3654 //'Клиент банка'. Сортировка по полю 'id, DESC' [BANK]
    @T3655 //'Клиент банка'. Сортировка по полю 'inn, DESC' [BANK]
    @T3656 //'Клиент банка'. Сортировка по полю 'okpo, DESC' [BANK]
    @T3657 //'Клиент банка'. Сортировка по полю 'isBlock, DESC' [BANK]
    @T3658 //'Клиент банка'. Сортировка по полю 'fullName, DESC' [BANK]
    @T3659 //'Клиент банка'. Сортировка по полю 'shortName, DESC' [BANK]
    @T3660 //'Клиент банка'. Сортировка по полю 'isResident, DESC' [BANK]
    @T3661 //'Клиент банка'. Сортировка по полю 'customerTypeId, DESC' [BANK]
    @T3662 //'Клиент банка'. Сортировка по полю 'ogrn, DESC' [BANK]
    @T3663 //'Клиент банка'. Сортировка по полю 'oktmo, DESC' [BANK]
    @T3664 //'Клиент банка'. Сортировка по полю 'okved, DESC' [BANK]
    @T3665 //'Клиент банка'. Сортировка по полю 'email, DESC' [BANK]
    @T3666 //'Клиент банка'. Сортировка по полю 'phone, DESC' [BANK]
    @T3667 //'Клиент банка'. Сортировка по полю 'ogrnDate, DESC' [BANK]
    internal fun customerSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerSortingTest(user, CustomerSortingParams.ID::asc).withId(T3640::class),
                CustomerSortingTest(user, CustomerSortingParams.INN::asc).withId(T3641::class),
                CustomerSortingTest(user, CustomerSortingParams.OKPO::asc).withId(T3642::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_BLOCKED::asc).withId(T3643::class),
                CustomerSortingTest(user, CustomerSortingParams.FULL_NAME::asc).withId(T3644::class),
                CustomerSortingTest(user, CustomerSortingParams.SHORT_NAME::asc).withId(T3645::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_RESIDENT::asc).withId(T3646::class),
//              CustomerSortingTest(user, CustomerSortingParams.CUSTOMER_TYPE_ID::asc).withId(T3647::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN::asc).withId(T3648::class),
                CustomerSortingTest(user, CustomerSortingParams.EMAIL::asc).withId(T3651::class),
                CustomerSortingTest(user, CustomerSortingParams.PHONE::asc).withId(T3652::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN_DATE::asc).withId(T3653::class),

                CustomerSortingTest(user, CustomerSortingParams.ID::desc).withId(T3654::class),
                CustomerSortingTest(user, CustomerSortingParams.INN::desc).withId(T3655::class),
                CustomerSortingTest(user, CustomerSortingParams.OKPO::desc).withId(T3656::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_BLOCKED::desc).withId(T3657::class),
                CustomerSortingTest(user, CustomerSortingParams.FULL_NAME::desc).withId(T3658::class),
                CustomerSortingTest(user, CustomerSortingParams.SHORT_NAME::desc).withId(T3659::class),
                CustomerSortingTest(user, CustomerSortingParams.IS_RESIDENT::desc).withId(T3660::class),
//              CustomerSortingTest(user, CustomerSortingParams.CUSTOMER_TYPE_ID::desc).withId(T3661::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN::desc).withId(T3662::class),
                CustomerSortingTest(user, CustomerSortingParams.EMAIL::desc).withId(T3665::class),
                CustomerSortingTest(user, CustomerSortingParams.PHONE::desc).withId(T3666::class),
                CustomerSortingTest(user, CustomerSortingParams.OGRN_DATE::desc).withId(T3667::class)
            )
        )
    }

    @Step("Получить ожидааемое dto для проверки фильтрации")
    private fun getDataForFilter(user: User): CustomerDto {
        return when (user) {
            clientUser -> clientTestDataScope.all.random().toDto()
            bankUser -> bankTestDataScope.all.random().toDto()
            else -> throw RuntimeException("Unexpected user '${user.login}'[${user.userType}]")
        }.attachToAllure()
    }

    @TestFactory
    @T3686 //'Клиент банка'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3687 //'Клиент банка'. Фильтрация по полю 'inn' (eq) [CLIENT]
    @T3688 //'Клиент банка'. Фильтрация по полю 'okpo' (eq) [CLIENT]
    @T3689 //'Клиент банка'. Фильтрация по полю 'isBlock' (eq) [CLIENT]
    @T3690 //'Клиент банка'. Фильтрация по полю 'fullName' (eq) [CLIENT]
    @T3691 //'Клиент банка'. Фильтрация по полю 'fullName' (contains) [CLIENT]
    @T3692 //'Клиент банка'. Фильтрация по полю 'shortName' (eq) [CLIENT]
    @T3693 //'Клиент банка'. Фильтрация по полю 'shortName' (contains) [CLIENT]
    @T3694 //'Клиент банка'. Фильтрация по полю 'isResident' (eq) [CLIENT]
    @T3695 //'Клиент банка'. Фильтрация по полю 'customerTypeId' (eq) [CLIENT]
    @T3696 //'Клиент банка'. Фильтрация по полю 'ogrn' (eq) [CLIENT]
    @T3697 //'Клиент банка'. Фильтрация по полю 'oktmo' (eq) [CLIENT]
    @T3698 //'Клиент банка'. Фильтрация по полю 'okved' (eq) [CLIENT]
    @T3699 //'Клиент банка'. Фильтрация по полю 'email' (eq) [CLIENT]
    @T3700 //'Клиент банка'. Фильтрация по полю 'email' (contains) [CLIENT]
    @T3701 //'Клиент банка'. Фильтрация по полю 'phone' (eq) [CLIENT]
    @T3702 //'Клиент банка'. Фильтрация по полю 'phone' (contains) [CLIENT]
    @T3703 //'Клиент банка'. Фильтрация по полю 'ogrnDate' (eq) [CLIENT]
    internal fun customerFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.ID.eq(it!!.id!!) }).withId(T3686::class),
                CustomerFiltrationTest("inn equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.INN.eq(it!!.inn) }).withId(T3687::class),
                CustomerFiltrationTest("okpo equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.OKPO.eq(it!!.okpo!!) }).withId(T3688::class),
                CustomerFiltrationTest("isBlock equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.IS_BLOCKED.eq(it!!.block.isBlock) }).withId(T3689::class),
                CustomerFiltrationTest("fullName equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.FULL_NAME.eq(it!!.fullName) }).withId(T3690::class),
                CustomerFiltrationTest("fullName contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T3691::class),
                CustomerFiltrationTest("shortName equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T3692::class),
                CustomerFiltrationTest("shortName contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T3693::class),
                CustomerFiltrationTest("isResident equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.IS_RESIDENT.eq(it!!.isResident) }).withId(T3694::class),
//              CustomerFiltrationTest("customerTypeId equals", user, { getDataForFilter(user) },
//                  { CustomerFilterParams.CUSTOMER_TYPE_ID.eq(it!!.customerTypeId) }).withId(T3695::class),

                CustomerFiltrationTest("ogrn equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.OGRN.eq(it!!.ogrn!!) }).withId(T3696::class),
                CustomerFiltrationTest("email equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.EMAIL.eq(it!!.email!!) }).withId(T3699::class),
                CustomerFiltrationTest("email contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.EMAIL.contains((it!!.email ?: "").randomSubstringPf()) }).withId(T3700::class),
                CustomerFiltrationTest("phone equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.PHONE.eq(it!!.phone!!) }).withId(T3701::class),
                CustomerFiltrationTest("phone contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.PHONE.contains((it!!.phone ?: "").randomSubstringPf()) }).withId(T3702::class),
                CustomerFiltrationTest("ogrnDate equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.OGRN_DATE.eq(it!!.ogrnDate!!) }).withId(T3703::class)
            )
        )
    }

    @TestFactory
    @T3668 //'Клиент банка'. Фильтрация по полю 'id' (eq) [BANK]
    @T3669 //'Клиент банка'. Фильтрация по полю 'inn' (eq) [BANK]
    @T3670 //'Клиент банка'. Фильтрация по полю 'okpo' (eq) [BANK]
    @T3671 //'Клиент банка'. Фильтрация по полю 'isBlock' (eq) [BANK]
    @T3672 //'Клиент банка'. Фильтрация по полю 'fullName' (eq) [BANK]
    @T3673 //'Клиент банка'. Фильтрация по полю 'fullName' (contains) [BANK]
    @T3674 //'Клиент банка'. Фильтрация по полю 'shortName' (eq) [BANK]
    @T3675 //'Клиент банка'. Фильтрация по полю 'shortName' (contains) [BANK]
    @T3676 //'Клиент банка'. Фильтрация по полю 'isResident' (eq) [BANK]
    @T3677 //'Клиент банка'. Фильтрация по полю 'customerTypeId' (eq) [BANK]
    @T3678 //'Клиент банка'. Фильтрация по полю 'ogrn' (eq) [BANK]
    @T3679 //'Клиент банка'. Фильтрация по полю 'oktmo' (eq) [BANK]
    @T3680 //'Клиент банка'. Фильтрация по полю 'okved' (eq) [BANK]
    @T3681 //'Клиент банка'. Фильтрация по полю 'email' (eq) [BANK]
    @T3682 //'Клиент банка'. Фильтрация по полю 'email' (contains) [BANK]
    @T3683 //'Клиент банка'. Фильтрация по полю 'phone' (eq) [BANK]
    @T3684 //'Клиент банка'. Фильтрация по полю 'phone' (contains) [BANK]
    @T3685 //'Клиент банка'. Фильтрация по полю 'ogrnDate' (eq) [BANK]
    internal fun customerFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                CustomerFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.ID.eq(it!!.id!!) }).withId(T3668::class),
                CustomerFiltrationTest("inn equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.INN.eq(it!!.inn) }).withId(T3669::class),
                CustomerFiltrationTest("okpo equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.OKPO.eq(it!!.okpo!!) }).withId(T3670::class),
                CustomerFiltrationTest("isBlock equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.IS_BLOCKED.eq(it!!.block.isBlock) }).withId(T3671::class),
                CustomerFiltrationTest("fullName equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.FULL_NAME.eq(it!!.fullName) }).withId(T3672::class),
                CustomerFiltrationTest("fullName contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T3673::class),
                CustomerFiltrationTest("shortName equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T3674::class),
                CustomerFiltrationTest("shortName contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T3675::class),
                CustomerFiltrationTest("isResident equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.IS_RESIDENT.eq(it!!.isResident) }).withId(T3676::class),
//                CustomerFiltrationTest("customerTypeId equals", user, { getDataForFilter(user) },
//                    { CustomerFilterParams.CUSTOMER_TYPE_ID.eq(it!!.customerTypeId) }).withId(T3677::class),

                CustomerFiltrationTest("ogrn equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.OGRN.eq(it!!.ogrn!!) }).withId(T3678::class),
                CustomerFiltrationTest("email equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.EMAIL.eq(it!!.email!!) }).withId(T3681::class),
                CustomerFiltrationTest("email contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.EMAIL.contains((it!!.email ?: "").randomSubstringPf()) }).withId(T3682::class),
                CustomerFiltrationTest("phone equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.PHONE.eq(it!!.phone!!) }).withId(T3683::class),
                CustomerFiltrationTest("phone contains", user, { getDataForFilter(user) },
                    { CustomerFilterParams.PHONE.contains((it!!.phone ?: "").randomSubstringPf()) }).withId(T3684::class),
                CustomerFiltrationTest("ogrnDate equals", user, { getDataForFilter(user) },
                    { CustomerFilterParams.OGRN_DATE.eq(it!!.ogrnDate!!) }).withId(T3685::class)
            )
        )
    }
}