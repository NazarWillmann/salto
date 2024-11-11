package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_ACCOUNT
import ooo.jtc.api.dictionaries.account.AccountCreateTest
import ooo.jtc.api.dictionaries.account.AccountDeleteTest
import ooo.jtc.api.dictionaries.account.AccountFiltrationTest
import ooo.jtc.api.dictionaries.account.AccountGetPageTest
import ooo.jtc.api.dictionaries.account.AccountGetTest
import ooo.jtc.api.dictionaries.account.AccountPrepareSteps
import ooo.jtc.api.dictionaries.account.AccountSortingTest
import ooo.jtc.api.dictionaries.account.AccountUpdateTest
import ooo.jtc.api.dictionaries.account.GetAccountBalanceTest
import ooo.jtc.api.dictionaries.account.GetAccountByAccInfoTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.account.AccountDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_KIND
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_NUMBER
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_TYPE_ID
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_TYPE_NESTED_DESCRIPTION
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_TYPE_NESTED_FULL_NAME
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_TYPE_NESTED_ID
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_TYPE_NESTED_SHORT_NAME
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACC_TYPE_NESTED_SYSTEM_NAME
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACTUAL_BALANCE
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ACTUAL_DATE
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.BLOCKED_AMOUNT
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.CARD_AMOUNT
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.CLOSE_DATE
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.CURRENCY_DIGIT_CODE
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.ID
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.IS_BLOCK
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.IS_MARK_INFO
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.NAME
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.OPEN_DATE
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.PLAN_BALANCE
import ooo.jtc.testdata.dictionaries.account.AccountFilterParams.STATE
import ooo.jtc.testdata.dictionaries.account.AccountSortingParams
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
@Story(DictionaryNames.ACCOUNT)
@DisplayName("API '${DictionaryNames.ACCOUNT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_ACCOUNT
@TestInstance(PER_CLASS)
class AccountTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2748") annotation class T2748
@Tag("JTCSALTO-T2749") annotation class T2749
@Tag("JTCSALTO-T2750") annotation class T2750
@Tag("JTCSALTO-T2751") annotation class T2751
@Tag("JTCSALTO-T2752") annotation class T2752
@Tag("JTCSALTO-T2753") annotation class T2753
@Tag("JTCSALTO-T2754") annotation class T2754
@Tag("JTCSALTO-T2755") annotation class T2755
@Tag("JTCSALTO-T2756") annotation class T2756
@Tag("JTCSALTO-T2757") annotation class T2757
@Tag("JTCSALTO-T2758") annotation class T2758
@Tag("JTCSALTO-T2759") annotation class T2759
@Tag("JTCSALTO-T2760") annotation class T2760
@Tag("JTCSALTO-T2761") annotation class T2761
@Tag("JTCSALTO-T2762") annotation class T2762
@Tag("JTCSALTO-T2763") annotation class T2763
@Tag("JTCSALTO-T2764") annotation class T2764
@Tag("JTCSALTO-T2765") annotation class T2765
@Tag("JTCSALTO-T2766") annotation class T2766
@Tag("JTCSALTO-T2767") annotation class T2767
@Tag("JTCSALTO-T2768") annotation class T2768
@Tag("JTCSALTO-T2769") annotation class T2769
@Tag("JTCSALTO-T2770") annotation class T2770
@Tag("JTCSALTO-T2771") annotation class T2771
@Tag("JTCSALTO-T2772") annotation class T2772
@Tag("JTCSALTO-T2773") annotation class T2773
@Tag("JTCSALTO-T2774") annotation class T2774
@Tag("JTCSALTO-T2775") annotation class T2775
@Tag("JTCSALTO-T2776") annotation class T2776
@Tag("JTCSALTO-T2777") annotation class T2777
@Tag("JTCSALTO-T2778") annotation class T2778
@Tag("JTCSALTO-T2779") annotation class T2779
@Tag("JTCSALTO-T2780") annotation class T2780
@Tag("JTCSALTO-T2781") annotation class T2781
@Tag("JTCSALTO-T2782") annotation class T2782
@Tag("JTCSALTO-T2783") annotation class T2783
@Tag("JTCSALTO-T2784") annotation class T2784
@Tag("JTCSALTO-T2785") annotation class T2785
@Tag("JTCSALTO-T2786") annotation class T2786
@Tag("JTCSALTO-T2787") annotation class T2787
@Tag("JTCSALTO-T2788") annotation class T2788
@Tag("JTCSALTO-T2789") annotation class T2789
@Tag("JTCSALTO-T2790") annotation class T2790
@Tag("JTCSALTO-T2791") annotation class T2791
@Tag("JTCSALTO-T2792") annotation class T2792
@Tag("JTCSALTO-T2793") annotation class T2793
@Tag("JTCSALTO-T2794") annotation class T2794
@Tag("JTCSALTO-T2795") annotation class T2795
@Tag("JTCSALTO-T2796") annotation class T2796
@Tag("JTCSALTO-T2797") annotation class T2797
@Tag("JTCSALTO-T2798") annotation class T2798
@Tag("JTCSALTO-T2799") annotation class T2799
@Tag("JTCSALTO-T2800") annotation class T2800
@Tag("JTCSALTO-T2801") annotation class T2801
@Tag("JTCSALTO-T2802") annotation class T2802
@Tag("JTCSALTO-T2803") annotation class T2803
@Tag("JTCSALTO-T2805") annotation class T2805
@Tag("JTCSALTO-T2806") annotation class T2806
@Tag("JTCSALTO-T2807") annotation class T2807
@Tag("JTCSALTO-T2808") annotation class T2808
@Tag("JTCSALTO-T2809") annotation class T2809
@Tag("JTCSALTO-T2810") annotation class T2810
@Tag("JTCSALTO-T2811") annotation class T2811
@Tag("JTCSALTO-T2812") annotation class T2812
@Tag("JTCSALTO-T2813") annotation class T2813
@Tag("JTCSALTO-T2814") annotation class T2814
@Tag("JTCSALTO-T2815") annotation class T2815
@Tag("JTCSALTO-T2816") annotation class T2816
@Tag("JTCSALTO-T2817") annotation class T2817
@Tag("JTCSALTO-T2818") annotation class T2818
@Tag("JTCSALTO-T2819") annotation class T2819
@Tag("JTCSALTO-T2821") annotation class T2821
@Tag("JTCSALTO-T2822") annotation class T2822
@Tag("JTCSALTO-T2823") annotation class T2823
@Tag("JTCSALTO-T2824") annotation class T2824
@Tag("JTCSALTO-T2825") annotation class T2825
@Tag("JTCSALTO-T2826") annotation class T2826
@Tag("JTCSALTO-T2827") annotation class T2827
@Tag("JTCSALTO-T2828") annotation class T2828
@Tag("JTCSALTO-T2829") annotation class T2829
@Tag("JTCSALTO-T2830") annotation class T2830
@Tag("JTCSALTO-T2831") annotation class T2831
@Tag("JTCSALTO-T2838") annotation class T2838
@Tag("JTCSALTO-T2839") annotation class T2839
@Tag("JTCSALTO-T2840") annotation class T2840
@Tag("JTCSALTO-T2841") annotation class T2841
@Tag("JTCSALTO-T2842") annotation class T2842
@Tag("JTCSALTO-T2843") annotation class T2843
@Tag("JTCSALTO-T2844") annotation class T2844
@Tag("JTCSALTO-T2845") annotation class T2845
@Tag("JTCSALTO-T2846") annotation class T2846
@Tag("JTCSALTO-T2847") annotation class T2847
@Tag("JTCSALTO-T2848") annotation class T2848
@Tag("JTCSALTO-T2855") annotation class T2855
@Tag("JTCSALTO-T2856") annotation class T2856
@Tag("JTCSALTO-T2857") annotation class T2857
@Tag("JTCSALTO-T2858") annotation class T2858
@Tag("JTCSALTO-T2859") annotation class T2859
@Tag("JTCSALTO-T2860") annotation class T2860
@Tag("JTCSALTO-T2861") annotation class T2861
@Tag("JTCSALTO-T2862") annotation class T2862
@Tag("JTCSALTO-T2863") annotation class T2863
@Tag("JTCSALTO-T2864") annotation class T2864
@Tag("JTCSALTO-T2865") annotation class T2865
@Tag("JTCSALTO-T2872") annotation class T2872
@Tag("JTCSALTO-T2873") annotation class T2873
@Tag("JTCSALTO-T2874") annotation class T2874
@Tag("JTCSALTO-T2875") annotation class T2875
@Tag("JTCSALTO-T2876") annotation class T2876
@Tag("JTCSALTO-T2877") annotation class T2877
@Tag("JTCSALTO-T2878") annotation class T2878
@Tag("JTCSALTO-T2879") annotation class T2879
@Tag("JTCSALTO-T2880") annotation class T2880
@Tag("JTCSALTO-T2881") annotation class T2881
@Tag("JTCSALTO-T2882") annotation class T2882
@Tag("JTCSALTO-T2889") annotation class T2889
@Tag("JTCSALTO-T2890") annotation class T2890
@Tag("JTCSALTO-T2891") annotation class T2891
@Tag("JTCSALTO-T2892") annotation class T2892
@Tag("JTCSALTO-T2893") annotation class T2893
@Tag("JTCSALTO-T2894") annotation class T2894
@Tag("JTCSALTO-T2895") annotation class T2895
@Tag("JTCSALTO-T2896") annotation class T2896
@Tag("JTCSALTO-T2897") annotation class T2897
@Tag("JTCSALTO-T2898") annotation class T2898
@Tag("JTCSALTO-T2899") annotation class T2899
@Tag("JTCSALTO-T2900") annotation class T2900
@Tag("JTCSALTO-T2901") annotation class T2901
@Tag("JTCSALTO-T2902") annotation class T2902
@Tag("JTCSALTO-T2903") annotation class T2903
@Tag("JTCSALTO-T2904") annotation class T2904
@Tag("JTCSALTO-T2905") annotation class T2905
@Tag("JTCSALTO-T2906") annotation class T2906
@Tag("JTCSALTO-T2907") annotation class T2907
@Tag("JTCSALTO-T2908") annotation class T2908
@Tag("JTCSALTO-T2909") annotation class T2909
@Tag("JTCSALTO-T2910") annotation class T2910
@Tag("JTCSALTO-T2911") annotation class T2911
@Tag("JTCSALTO-T2912") annotation class T2912
@Tag("JTCSALTO-T2913") annotation class T2913
@Tag("JTCSALTO-T2914") annotation class T2914
@Tag("JTCSALTO-T2915") annotation class T2915
@Tag("JTCSALTO-T2916") annotation class T2916
@Tag("JTCSALTO-T2917") annotation class T2917
@Tag("JTCSALTO-T2918") annotation class T2918
@Tag("JTCSALTO-T2919") annotation class T2919
@Tag("JTCSALTO-T2920") annotation class T2920
@Tag("JTCSALTO-T2921") annotation class T2921
@Tag("JTCSALTO-T2922") annotation class T2922
@Tag("JTCSALTO-T2923") annotation class T2923
@Tag("JTCSALTO-T2924") annotation class T2924
@Tag("JTCSALTO-T2926") annotation class T2926
@Tag("JTCSALTO-T2927") annotation class T2927
@Tag("JTCSALTO-T2928") annotation class T2928
@Tag("JTCSALTO-T2929") annotation class T2929
@Tag("JTCSALTO-T2930") annotation class T2930
@Tag("JTCSALTO-T2931") annotation class T2931
@Tag("JTCSALTO-T2932") annotation class T2932
@Tag("JTCSALTO-T2933") annotation class T2933
@Tag("JTCSALTO-T2934") annotation class T2934
@Tag("JTCSALTO-T2935") annotation class T2935
@Tag("JTCSALTO-T2936") annotation class T2936
@Tag("JTCSALTO-T2937") annotation class T2937
@Tag("JTCSALTO-T2938") annotation class T2938
@Tag("JTCSALTO-T2939") annotation class T2939
@Tag("JTCSALTO-T2940") annotation class T2940
@Tag("JTCSALTO-T2949") annotation class T2949
@Tag("JTCSALTO-T2950") annotation class T2950
@Tag("JTCSALTO-T2951") annotation class T2951
@Tag("JTCSALTO-T2952") annotation class T2952
@Tag("JTCSALTO-T2953") annotation class T2953
@Tag("JTCSALTO-T2954") annotation class T2954
@Tag("JTCSALTO-T2955") annotation class T2955
@Tag("JTCSALTO-T2956") annotation class T2956
@Tag("JTCSALTO-T2957") annotation class T2957
@Tag("JTCSALTO-T2958") annotation class T2958
@Tag("JTCSALTO-T2959") annotation class T2959
@Tag("JTCSALTO-T2960") annotation class T2960
@Tag("JTCSALTO-T2961") annotation class T2961
@Tag("JTCSALTO-T2962") annotation class T2962
@Tag("JTCSALTO-T2963") annotation class T2963
//@formatter:on
//endregion
    //TODO Sergeyev [2021.03.16]: add tests for individuals

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client
    private lateinit var clientDataForFilter: AccountDto
    private lateinit var clientTestDataScope: TestDataScope<Account>
    private lateinit var bankDataForFilter: AccountDto
    private lateinit var bankTestDataScope: TestDataScope<Account>

    @BeforeAll
    fun prepareTestData() {
        //TODO: ?метод на создание счёта, доступного пользователю клиента и пользователю банка
        val availableToClientAccountsIds = AccountData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = AccountData.withRequiredFields(
            additionalFilter = { it.id!! in availableToClientAccountsIds },
            customCreator = { AccountPrepareSteps.createNewAccountForUser(clientUser) }
        )
        val availableToBankAccountsIds = AccountData.searchBy(bankUser).map { it.id!! }
        bankTestDataScope = AccountData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBankAccountsIds },
            customCreator = { AccountPrepareSteps.createNewAccountForUser(bankUser) }
        )
        clientDataForFilter = clientTestDataScope.all.random().toDto()
        bankDataForFilter = bankTestDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        // TODO: разобраться с получением .withRequiredFields() и убрать AfterAll
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

    @T2748 //'Счет'. CRUD: Создаем запись от пользователя [BANK]
    @T2749 //'Счет'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2750 //'Счет'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2751 //'Счет'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2752 //'Счет'. CRUD: Получаем страницу записей от пользователя [BANK]'
    @T2753 //'Счет'. CRUD: Обновляем запись от пользователя [BANK]
    @T2754 //'Счет'. CRUD: Удаляем запись от пользователя [BANK]
    @TestFactory
    internal fun crudTests(): List<DynamicTest> {
        val tests = listOf(
            AccountCreateTest().withId(T2748::class),
            AccountGetTest(user = clientUser).withId(T2749::class),
            AccountGetTest(user = bankUser).withId(T2750::class),
            AccountGetPageTest(user = clientUser).withId(T2751::class),
            AccountGetPageTest(user = bankUser).withId(T2752::class),
            AccountUpdateTest().withId(T2753::class),
            AccountDeleteTest().withId(T2754::class)
        )

        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T2759 //'Счет'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2760 //'Счет'. Сортировка по полю 'name, ASC' [CLIENT]
    @T2761 //'Счет'. Сортировка по полю 'state, ASC' [CLIENT]
    @T2762 //'Счет'. Сортировка по полю 'accountKind, ASC' [CLIENT]
    @T2763 //'Счет'. Сортировка по полю 'accountNumber, ASC' [CLIENT]
    @T2764 //'Счет'. Сортировка по полю 'description, ASC' [CLIENT]
    @T2765 //'Счет'. Сортировка по полю 'actualBalance, ASC' [CLIENT]
    @T2766 //'Счет'. Сортировка по полю 'planBalance, ASC' [CLIENT]
    @T2767 //'Счет'. Сортировка по полю 'cardAmount, ASC' [CLIENT]
    @T2768 //'Счет'. Сортировка по полю 'blockedAmount, ASC' [CLIENT]
    @T2769 //'Счет'. Сортировка по полю 'openDate, ASC' [CLIENT]
    @T2770 //'Счет'. Сортировка по полю 'closeDate, ASC' [CLIENT]
    @T2771 //'Счет'. Сортировка по полю 'actualDate, ASC' [CLIENT]
    @T2772 //'Счет'. Сортировка по полю 'isBlock, ASC' [CLIENT]
    @T2773 //'Счет'. Сортировка по полю 'isMarkInfoAccount, ASC' [CLIENT]
    @T2831 //'Счет'. Сортировка по полю 'currencyDigitCode, ASC' [CLIENT]

    @T2774 //'Счет'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2775 //'Счет'. Сортировка по полю 'name, DESC' [CLIENT]
    @T2776 //'Счет'. Сортировка по полю 'state, DESC' [CLIENT]
    @T2777 //'Счет'. Сортировка по полю 'accountKind, DESC' [CLIENT]
    @T2778 //'Счет'. Сортировка по полю 'accountNumber, DESC' [CLIENT]
    @T2779 //'Счет'. Сортировка по полю 'description, DESC' [CLIENT]
    @T2780 //'Счет'. Сортировка по полю 'actualBalance, DESC' [CLIENT]
    @T2781 //'Счет'. Сортировка по полю 'planBalance, DESC' [CLIENT]
    @T2782 //'Счет'. Сортировка по полю 'cardAmount, DESC' [CLIENT]
    @T2783 //'Счет'. Сортировка по полю 'blockedAmount, DESC' [CLIENT]
    @T2784 //'Счет'. Сортировка по полю 'openDate, DESC' [CLIENT]
    @T2785 //'Счет'. Сортировка по полю 'closeDate, DESC' [CLIENT]
    @T2786 //'Счет'. Сортировка по полю 'actualDate, DESC' [CLIENT]
    @T2787 //'Счет'. Сортировка по полю 'isBlock, DESC' [CLIENT]
    @T2788 //'Счет'. Сортировка по полю 'isMarkInfoAccount, DESC' [CLIENT]
    @T2848 //'Счет'. Сортировка по полю 'currencyDigitCode, DESC' [CLIENT]
    internal fun clientBasicSortingTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                AccountSortingTest(user, AccountSortingParams.ID::asc).withId(T2759::class),
                AccountSortingTest(user, AccountSortingParams.NAME::asc).withId(T2760::class),
                AccountSortingTest(user, AccountSortingParams.STATE::asc).withId(T2761::class),
                AccountSortingTest(user, AccountSortingParams.ACC_KIND::asc).withId(T2762::class),
                AccountSortingTest(user, AccountSortingParams.ACC_NUMBER::asc).withId(T2763::class),
                AccountSortingTest(user, AccountSortingParams.DESCRIPTION::asc).withId(T2764::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_BALANCE::asc).withId(T2765::class),
                AccountSortingTest(user, AccountSortingParams.PLAN_BALANCE::asc, PLAN_BALANCE.contains("")).withId(T2766::class),
                AccountSortingTest(user, AccountSortingParams.CARD_AMOUNT::asc, CARD_AMOUNT.contains("")).withId(T2767::class),
                AccountSortingTest(user, AccountSortingParams.BLOCKED_AMOUNT::asc, BLOCKED_AMOUNT.contains("")).withId(T2768::class),
                AccountSortingTest(user, AccountSortingParams.OPEN_DATE::asc).withId(T2769::class),
                AccountSortingTest(user, AccountSortingParams.CLOSE_DATE::asc, CLOSE_DATE.contains("")).withId(T2770::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_DATE::asc).withId(T2771::class),
                AccountSortingTest(user, AccountSortingParams.IS_BLOCK::asc).withId(T2772::class),
                AccountSortingTest(user, AccountSortingParams.IS_MARK_INFO::asc).withId(T2773::class),
                AccountSortingTest(user, AccountSortingParams.CURRENCY_DIGIT_CODE::asc).withId(T2831::class),

                AccountSortingTest(user, AccountSortingParams.ID::desc).withId(T2774::class),
                AccountSortingTest(user, AccountSortingParams.NAME::desc).withId(T2775::class),
                AccountSortingTest(user, AccountSortingParams.STATE::desc).withId(T2776::class),
                AccountSortingTest(user, AccountSortingParams.ACC_KIND::desc).withId(T2777::class),
                AccountSortingTest(user, AccountSortingParams.ACC_NUMBER::desc).withId(T2778::class),
                AccountSortingTest(user, AccountSortingParams.DESCRIPTION::desc).withId(T2779::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_BALANCE::desc).withId(T2780::class),
                AccountSortingTest(user, AccountSortingParams.PLAN_BALANCE::desc).withId(T2781::class),
                AccountSortingTest(user, AccountSortingParams.CARD_AMOUNT::desc).withId(T2782::class),
                AccountSortingTest(user, AccountSortingParams.BLOCKED_AMOUNT::desc).withId(T2783::class),
                AccountSortingTest(user, AccountSortingParams.OPEN_DATE::desc).withId(T2784::class),
                AccountSortingTest(user, AccountSortingParams.CLOSE_DATE::desc).withId(T2785::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_DATE::desc).withId(T2786::class),
                AccountSortingTest(user, AccountSortingParams.IS_BLOCK::desc).withId(T2787::class),
                AccountSortingTest(user, AccountSortingParams.IS_MARK_INFO::desc).withId(T2788::class),
                AccountSortingTest(user, AccountSortingParams.CURRENCY_DIGIT_CODE::desc).withId(T2848::class)
            )
        )
    }

    @TestFactory
    @T2789 //'Счет'. Сортировка по полю 'id, ASC' [BANK]
    @T2790 //'Счет'. Сортировка по полю 'name, ASC' [BANK]
    @T2791 //'Счет'. Сортировка по полю 'state, ASC' [BANK]
    @T2792 //'Счет'. Сортировка по полю 'accountKind, ASC' [BANK]
    @T2793 //'Счет'. Сортировка по полю 'accountNumber, ASC' [BANK]
    @T2794 //'Счет'. Сортировка по полю 'description, ASC' [BANK]
    @T2795 //'Счет'. Сортировка по полю 'actualBalance, ASC' [BANK]
    @T2796 //'Счет'. Сортировка по полю 'planBalance, ASC' [BANK]
    @T2797 //'Счет'. Сортировка по полю 'cardAmount, ASC' [BANK]
    @T2798 //'Счет'. Сортировка по полю 'blockedAmount, ASC' [BANK]
    @T2799 //'Счет'. Сортировка по полю 'openDate, ASC' [BANK]
    @T2800 //'Счет'. Сортировка по полю 'closeDate, ASC' [BANK]
    @T2801 //'Счет'. Сортировка по полю 'actualDate, ASC' [BANK]
    @T2802 //'Счет'. Сортировка по полю 'isBlock, ASC' [BANK]
    @T2803 //'Счет'. Сортировка по полю 'isMarkInfoAccount, ASC' [BANK]
    @T2865 //'Счет'. Сортировка по полю 'currencyDigitCode, ASC' [BANK]

    @T2805 //'Счет'. Сортировка по полю 'id, DESC' [BANK]
    @T2806 //'Счет'. Сортировка по полю 'name, DESC' [BANK]
    @T2807 //'Счет'. Сортировка по полю 'state, DESC' [BANK]
    @T2808 //'Счет'. Сортировка по полю 'accountKind, DESC' [BANK]
    @T2809 //'Счет'. Сортировка по полю 'accountNumber, DESC' [BANK]
    @T2810 //'Счет'. Сортировка по полю 'description, DESC' [BANK]
    @T2811 //'Счет'. Сортировка по полю 'actualBalance, DESC' [BANK]
    @T2812 //'Счет'. Сортировка по полю 'planBalance, DESC' [BANK]
    @T2813 //'Счет'. Сортировка по полю 'cardAmount, DESC' [BANK]
    @T2814 //'Счет'. Сортировка по полю 'blockedAmount, DESC' [BANK]
    @T2815 //'Счет'. Сортировка по полю 'openDate, DESC' [BANK]
    @T2816 //'Счет'. Сортировка по полю 'closeDate, DESC' [BANK]
    @T2817 //'Счет'. Сортировка по полю 'actualDate, DESC' [BANK]
    @T2818 //'Счет'. Сортировка по полю 'isBlock, DESC' [BANK]
    @T2819 //'Счет'. Сортировка по полю 'isMarkInfoAccount, DESC' [BANK]
    @T2882 //'Счет'. Сортировка по полю 'currencyDigitCode, DESC' [BANK]
    internal fun bankBasicSortingTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                AccountSortingTest(user, AccountSortingParams.ID::asc).withId(T2789::class),
                AccountSortingTest(user, AccountSortingParams.NAME::asc).withId(T2790::class),
                AccountSortingTest(user, AccountSortingParams.STATE::asc).withId(T2791::class),
                AccountSortingTest(user, AccountSortingParams.ACC_KIND::asc).withId(T2792::class),
                AccountSortingTest(user, AccountSortingParams.ACC_NUMBER::asc).withId(T2793::class),
                AccountSortingTest(user, AccountSortingParams.DESCRIPTION::asc).withId(T2794::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_BALANCE::asc).withId(T2795::class),
                AccountSortingTest(user, AccountSortingParams.PLAN_BALANCE::asc, PLAN_BALANCE.contains("")).withId(T2796::class),
                AccountSortingTest(user, AccountSortingParams.CARD_AMOUNT::asc, CARD_AMOUNT.contains("")).withId(T2797::class),
                AccountSortingTest(user, AccountSortingParams.BLOCKED_AMOUNT::asc, BLOCKED_AMOUNT.contains("")).withId(T2798::class),
                AccountSortingTest(user, AccountSortingParams.OPEN_DATE::asc).withId(T2799::class),
                AccountSortingTest(user, AccountSortingParams.CLOSE_DATE::asc, CLOSE_DATE.contains("")).withId(T2800::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_DATE::asc).withId(T2801::class),
                AccountSortingTest(user, AccountSortingParams.IS_BLOCK::asc).withId(T2802::class),
                AccountSortingTest(user, AccountSortingParams.IS_MARK_INFO::asc).withId(T2803::class),
                AccountSortingTest(user, AccountSortingParams.CURRENCY_DIGIT_CODE::asc).withId(T2865::class),

                AccountSortingTest(user, AccountSortingParams.ID::desc).withId(T2805::class),
                AccountSortingTest(user, AccountSortingParams.NAME::desc).withId(T2806::class),
                AccountSortingTest(user, AccountSortingParams.STATE::desc).withId(T2807::class),
                AccountSortingTest(user, AccountSortingParams.ACC_KIND::desc).withId(T2808::class),
                AccountSortingTest(user, AccountSortingParams.ACC_NUMBER::desc).withId(T2809::class),
                AccountSortingTest(user, AccountSortingParams.DESCRIPTION::desc).withId(T2810::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_BALANCE::desc).withId(T2811::class),
                AccountSortingTest(user, AccountSortingParams.PLAN_BALANCE::desc).withId(T2812::class),
                AccountSortingTest(user, AccountSortingParams.CARD_AMOUNT::desc).withId(T2813::class),
                AccountSortingTest(user, AccountSortingParams.BLOCKED_AMOUNT::desc).withId(T2814::class),
                AccountSortingTest(user, AccountSortingParams.OPEN_DATE::desc).withId(T2815::class),
                AccountSortingTest(user, AccountSortingParams.CLOSE_DATE::desc).withId(T2816::class),
                AccountSortingTest(user, AccountSortingParams.ACTUAL_DATE::desc).withId(T2817::class),
                AccountSortingTest(user, AccountSortingParams.IS_BLOCK::desc).withId(T2818::class),
                AccountSortingTest(user, AccountSortingParams.IS_MARK_INFO::desc).withId(T2819::class),
                AccountSortingTest(user, AccountSortingParams.CURRENCY_DIGIT_CODE::desc).withId(T2882::class),
            )
        )
    }

    @TestFactory
    @T2821 //'Счет'. Сортировка по полю 'branchCustomerId, ASC' [CLIENT]
    @T2822 //'Счет'. Сортировка по полю 'branchCustomer.id, ASC' [CLIENT]
    @T2823 //'Счет'. Сортировка по полю 'branchCustomer.branchId, ASC' [CLIENT]
    @T2824 //'Счет'. Сортировка по полю 'branchCustomer.customerId, ASC' [CLIENT]
    @T2825 //'Счет'. Сортировка по полю 'accountTypeId, ASC' [CLIENT]
    @T2826 //'Счет'. Сортировка по полю 'accountType.id, ASC' [CLIENT]
    @T2827 //'Счет'. Сортировка по полю 'accountType.fullName, ASC' [CLIENT]
    @T2828 //'Счет'. Сортировка по полю 'accountType.shortName, ASC' [CLIENT]
    @T2829 //'Счет'. Сортировка по полю 'accountType.description, ASC' [CLIENT]
    @T2830 //'Счет'. Сортировка по полю 'accountType.accountTypeTag, ASC' [CLIENT]

    @T2838 //'Счет'. Сортировка по полю 'branchCustomerId, DESC' [CLIENT]
    @T2839 //'Счет'. Сортировка по полю 'branchCustomer.id, DESC' [CLIENT]
    @T2840 //'Счет'. Сортировка по полю 'branchCustomer.branchId, DESC' [CLIENT]
    @T2841 //'Счет'. Сортировка по полю 'branchCustomer.customerId, DESC' [CLIENT]
    @T2842 //'Счет'. Сортировка по полю 'accountTypeId, DESC' [CLIENT]
    @T2843 //'Счет'. Сортировка по полю 'accountType.id, DESC' [CLIENT]
    @T2844 //'Счет'. Сортировка по полю 'accountType.fullName, DESC' [CLIENT]
    @T2845 //'Счет'. Сортировка по полю 'accountType.shortName, DESC' [CLIENT]
    @T2846 //'Счет'. Сортировка по полю 'accountType.description, DESC' [CLIENT]
    @T2847 //'Счет'. Сортировка по полю 'accountType.accountTypeTag, DESC' [CLIENT]
    internal fun clientNestedFieldsSortingTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                AccountSortingTest(user, AccountSortingParams.BR_CUST_ID::asc).withId(T2821::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_ID::asc).withId(T2822::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_BRANCH_ID::asc).withId(T2823::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_CUSTOMER_ID::asc).withId(T2824::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_ID::asc).withId(T2825::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_ID::asc).withId(T2826::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_FULL_NAME::asc).withId(T2827::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SHORT_NAME::asc).withId(T2828::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_DESCRIPTION::asc).withId(T2829::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SYSTEM_NAME::asc).withId(T2830::class),

                AccountSortingTest(user, AccountSortingParams.BR_CUST_ID::desc).withId(T2838::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_ID::desc).withId(T2839::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_BRANCH_ID::desc).withId(T2840::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_CUSTOMER_ID::desc).withId(T2841::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_ID::desc).withId(T2842::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_ID::desc).withId(T2843::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_FULL_NAME::desc).withId(T2844::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SHORT_NAME::desc).withId(T2845::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_DESCRIPTION::desc).withId(T2846::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SYSTEM_NAME::desc).withId(T2847::class)
            )
        )
    }

    @TestFactory
    @T2855 //'Счет'. Сортировка по полю 'branchCustomerId, ASC' [BANK]
    @T2856 //'Счет'. Сортировка по полю 'branchCustomer.id, ASC' [BANK]
    @T2857 //'Счет'. Сортировка по полю 'branchCustomer.branchId, ASC' [BANK]
    @T2858 //'Счет'. Сортировка по полю 'branchCustomer.customerId, ASC' [BANK]
    @T2859 //'Счет'. Сортировка по полю 'accountTypeId, ASC' [BANK]
    @T2860 //'Счет'. Сортировка по полю 'accountType.id, ASC' [BANK]
    @T2861 //'Счет'. Сортировка по полю 'accountType.fullName, ASC' [BANK]
    @T2862 //'Счет'. Сортировка по полю 'accountType.shortName, ASC' [BANK]
    @T2863 //'Счет'. Сортировка по полю 'accountType.description, ASC' [BANK]
    @T2864 //'Счет'. Сортировка по полю 'accountType.systemName, ASC' [BANK]

    @T2872 //'Счет'. Сортировка по полю 'branchCustomerId, DESC' [BANK]
    @T2873 //'Счет'. Сортировка по полю 'branchCustomer.id, DESC' [BANK]
    @T2874 //'Счет'. Сортировка по полю 'branchCustomer.branchId, DESC' [BANK]
    @T2875 //'Счет'. Сортировка по полю 'branchCustomer.customerId, DESC' [BANK]
    @T2876 //'Счет'. Сортировка по полю 'accountTypeId, DESC' [BANK]
    @T2877 //'Счет'. Сортировка по полю 'accountType.id, DESC' [BANK]
    @T2878 //'Счет'. Сортировка по полю 'accountType.fullName, DESC' [BANK]
    @T2879 //'Счет'. Сортировка по полю 'accountType.shortName, DESC' [BANK]
    @T2880 //'Счет'. Сортировка по полю 'accountType.description, DESC' [BANK]
    @T2881 //'Счет'. Сортировка по полю 'accountType.systemName, DESC' [BANK]
    internal fun bankNestedFieldsSortingTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                AccountSortingTest(user, AccountSortingParams.BR_CUST_ID::asc).withId(T2855::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_ID::asc).withId(T2856::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_BRANCH_ID::asc).withId(T2857::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_CUSTOMER_ID::asc).withId(T2858::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_ID::asc).withId(T2859::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_ID::asc).withId(T2860::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_FULL_NAME::asc).withId(T2861::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SHORT_NAME::asc).withId(T2862::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_DESCRIPTION::asc).withId(T2863::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SYSTEM_NAME::asc).withId(T2864::class),

                AccountSortingTest(user, AccountSortingParams.BR_CUST_ID::desc).withId(T2872::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_ID::desc).withId(T2873::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_BRANCH_ID::desc).withId(T2874::class),
                AccountSortingTest(user, AccountSortingParams.BR_CUST_NESTED_CUSTOMER_ID::desc).withId(T2875::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_ID::desc).withId(T2876::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_ID::desc).withId(T2877::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_FULL_NAME::desc).withId(T2878::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SHORT_NAME::desc).withId(T2879::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_DESCRIPTION::desc).withId(T2880::class),
                AccountSortingTest(user, AccountSortingParams.ACC_TYPE_NESTED_SYSTEM_NAME::desc).withId(T2881::class),
            )
        )
    }

    @TestFactory
    @T2889 //'Счет'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2890 //'Счет'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T2891 //'Счет'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T2892 //'Счет'. Фильтрация по полю 'state' (eq) [CLIENT]
    @T2893 //'Счет'. Фильтрация по полю 'accountKind' (eq) [CLIENT]
    @T2894 //'Счет'. Фильтрация по полю 'accountNumber' (eq) [CLIENT]
    @T2895 //'Счет'. Фильтрация по полю 'accountNumber' (contains) [CLIENT]
    @T2896 //'Счет'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T2897 //'Счет'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T2898 //'Счет'. Фильтрация по полю 'actualBalance' (eq) [CLIENT]
    @T2899 //'Счет'. Фильтрация по полю 'planBalance' (eq) [CLIENT]
    @T2900 //'Счет'. Фильтрация по полю 'cardAmount' (eq) [CLIENT]
    @T2901 //'Счет'. Фильтрация по полю 'blockedAmount' (eq) [CLIENT]
    @T2902 //'Счет'. Фильтрация по полю 'openDate' (eq) [CLIENT]
    @T2903 //'Счет'. Фильтрация по полю 'closeDate' (eq) [CLIENT]
    @T2904 //'Счет'. Фильтрация по полю 'actualDate' (eq) [CLIENT]
    @T2905 //'Счет'. Фильтрация по полю 'isBlock' (eq) [CLIENT]
    @T2906 //'Счет'. Фильтрация по полю 'isMarkInfoAccount' (eq) [CLIENT]
    @T2940 //'Счет'. Фильтрация по полю 'currencyDigitCode' (eq) [CLIENT]
    internal fun clientFiltrationBasicFieldsTests(): List<DynamicTest> {
        val user = clientUser
        val dataForFilter = clientDataForFilter
        return EntityTestGenerator.generate(
            listOf(
                AccountFiltrationTest("id equals", user, { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T2889::class),
                AccountFiltrationTest("name equals", user, { dataForFilter },
                    { NAME.eq(it!!.name ?: "") }).withId(T2890::class),
                AccountFiltrationTest("name contains", user, { dataForFilter },
                    { NAME.contains((it!!.name ?: "").randomSubstringPf()) }).withId(T2891::class),
                AccountFiltrationTest("state equals", user, { dataForFilter },
                    { STATE.eq(it!!.state) }).withId(T2892::class),
                AccountFiltrationTest("accountKind equals", user, { dataForFilter },
                    { ACC_KIND.eq(it!!.accountKind) }).withId(T2893::class),
                AccountFiltrationTest("accountNumber equals", user, { dataForFilter },
                    { ACC_NUMBER.eq(it!!.accountNumber) }).withId(T2894::class),
                AccountFiltrationTest("accountNumber contains", user, { dataForFilter },
                    { ACC_NUMBER.contains(it!!.accountNumber.randomSubstringPf()) }).withId(T2895::class),
                AccountFiltrationTest("description equals", user, { dataForFilter },
                    { DESCRIPTION.eq(it!!.description ?: "") }).withId(T2896::class),
                AccountFiltrationTest("description contains", user, { dataForFilter },
                    { DESCRIPTION.contains((it!!.description ?: "").randomSubstringPf()) }).withId(T2897::class),

                AccountFiltrationTest("actualBalance equals", user, { dataForFilter },
                    { ACTUAL_BALANCE.eq(it!!.actualBalance) }).withId(T2898::class),
                AccountFiltrationTest("planBalance equals", user, { dataForFilter },
                    { PLAN_BALANCE.eq(it!!.planBalance) }).withId(T2899::class),
                AccountFiltrationTest("cardAmount equals", user, { dataForFilter },
                    { CARD_AMOUNT.eq(it!!.cardAmount ?: "") }).withId(T2900::class),
                AccountFiltrationTest("blockedAmount equals", user, { dataForFilter },
                    { BLOCKED_AMOUNT.eq(it!!.blockedAmount ?: "") }).withId(T2901::class),

                AccountFiltrationTest("openDate equals", user, { dataForFilter },
                    { OPEN_DATE.eq(it!!.openDate) }).withId(T2902::class),
                AccountFiltrationTest("closeDate equals", user, { dataForFilter },
                    { CLOSE_DATE.eq(it!!.closeDate ?: "") }).withId(T2903::class),
                AccountFiltrationTest("actualDate equals", user, { dataForFilter },
                    { ACTUAL_DATE.eq(it!!.actualDate) }).withId(T2904::class),

                AccountFiltrationTest("isBlock equals", user, { dataForFilter },
                    { IS_BLOCK.eq(it!!.block.isBlock) }).withId(T2905::class),
                AccountFiltrationTest("isMarkInfoAccount equals", user, { dataForFilter },
                    { IS_MARK_INFO.eq(it!!.isMarkInfo) }).withId(T2906::class),

                AccountFiltrationTest("currencyDigitCode equals", user, { dataForFilter },
                    { CURRENCY_DIGIT_CODE.eq(it!!.currencyDigitCode) }).withId(T2940::class),
            )
        )
    }

    @TestFactory
    @T2907 //'Счет'. Фильтрация по полю 'id' (eq) [BANK]
    @T2908 //'Счет'. Фильтрация по полю 'name' (eq) [BANK]
    @T2909 //'Счет'. Фильтрация по полю 'name' (contains) [BANK]
    @T2910 //'Счет'. Фильтрация по полю 'state' (eq) [BANK]
    @T2911 //'Счет'. Фильтрация по полю 'accountKind' (eq) [BANK]
    @T2912 //'Счет'. Фильтрация по полю 'accountNumber' (eq) [BANK]
    @T2913 //'Счет'. Фильтрация по полю 'accountNumber' (contains) [BANK]
    @T2914 //'Счет'. Фильтрация по полю 'description' (eq) [BANK]
    @T2915 //'Счет'. Фильтрация по полю 'description' (contains) [BANK]
    @T2916 //'Счет'. Фильтрация по полю 'actualBalance' (eq) [BANK]
    @T2917 //'Счет'. Фильтрация по полю 'planBalance' (eq) [BANK]
    @T2918 //'Счет'. Фильтрация по полю 'cardAmount' (eq) [BANK]
    @T2919 //'Счет'. Фильтрация по полю 'blockedAmount' (eq) [BANK]
    @T2920 //'Счет'. Фильтрация по полю 'openDate' (eq) [BANK]
    @T2921 //'Счет'. Фильтрация по полю 'closeDate' (eq) [BANK]
    @T2922 //'Счет'. Фильтрация по полю 'actualDate' (eq) [BANK]
    @T2923 //'Счет'. Фильтрация по полю 'isBlock' (eq) [BANK]
    @T2924 //'Счет'. Фильтрация по полю 'isMarkInfoAccount' (eq) [BANK]
    @T2963 //'Счет'. Фильтрация по полю 'currencyDigitCode' (eq) [BANK]
    internal fun bankFiltrationBasicFieldsTests(): List<DynamicTest> {
        val user = bankUser
        val dataForFilter = bankDataForFilter
        return EntityTestGenerator.generate(
            listOf(
                AccountFiltrationTest("id equals", user, { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T2907::class),
                AccountFiltrationTest("name equals", user, { dataForFilter },
                    { NAME.eq(it!!.name ?: "") }).withId(T2908::class),
                AccountFiltrationTest("name contains", user, { dataForFilter },
                    { NAME.contains((it!!.name ?: "").randomSubstringPf()) }).withId(T2909::class),
                AccountFiltrationTest("state equals", user, { dataForFilter },
                    { STATE.eq(it!!.state) }).withId(T2910::class),
                AccountFiltrationTest("accountKind equals", user, { dataForFilter },
                    { ACC_KIND.eq(it!!.accountKind) }).withId(T2911::class),
                AccountFiltrationTest("accountNumber equals", user, { dataForFilter },
                    { ACC_NUMBER.eq(it!!.accountNumber) }).withId(T2912::class),
                AccountFiltrationTest("accountNumber contains", user, { dataForFilter },
                    { ACC_NUMBER.contains(it!!.accountNumber.randomSubstringPf()) }).withId(T2913::class),
                AccountFiltrationTest("description equals", user, { dataForFilter },
                    { DESCRIPTION.eq(it!!.description ?: "") }).withId(T2914::class),
                AccountFiltrationTest("description contains", user, { dataForFilter },
                    { DESCRIPTION.contains((it!!.description ?: "").randomSubstringPf()) }).withId(T2915::class),

                AccountFiltrationTest("actualBalance equals", user, { dataForFilter },
                    { ACTUAL_BALANCE.eq(it!!.actualBalance) }).withId(T2916::class),
                AccountFiltrationTest("planBalance equals", user, { dataForFilter },
                    { PLAN_BALANCE.eq(it!!.planBalance) }).withId(T2917::class),
                AccountFiltrationTest("cardAmount equals", user, { dataForFilter },
                    { CARD_AMOUNT.eq(it!!.cardAmount ?: "") }).withId(T2918::class),
                AccountFiltrationTest("blockedAmount equals", user, { dataForFilter },
                    { BLOCKED_AMOUNT.eq(it!!.blockedAmount ?: "") }).withId(T2919::class),

                AccountFiltrationTest("openDate equals", user, { dataForFilter },
                    { OPEN_DATE.eq(it!!.openDate) }).withId(T2920::class),
                AccountFiltrationTest("closeDate equals", user, { dataForFilter },
                    { CLOSE_DATE.eq(it!!.closeDate ?: "") }).withId(T2921::class),
                AccountFiltrationTest("actualDate equals", user, { dataForFilter },
                    { ACTUAL_DATE.eq(it!!.actualDate) }).withId(T2922::class),

                AccountFiltrationTest("isBlock equals", user, { dataForFilter },
                    { IS_BLOCK.eq(it!!.block.isBlock) }).withId(T2923::class),
                AccountFiltrationTest("isMarkInfoAccount equals", user, { dataForFilter },
                    { IS_MARK_INFO.eq(it!!.isMarkInfo) }).withId(T2924::class),

                AccountFiltrationTest("currencyDigitCode equals", user, { dataForFilter },
                    { CURRENCY_DIGIT_CODE.eq(it!!.currencyDigitCode) }).withId(T2963::class),
            )
        )
    }

    @TestFactory
    @T2926 //'Счет'. Фильтрация по полю 'branchCustomerId' (eq) [CLIENT]
    @T2927 //'Счет'. Фильтрация по полю 'branchCustomer.id' (eq) [CLIENT]
    @T2928 //'Счет'. Фильтрация по полю 'branchCustomer.branchId' (eq) [CLIENT]
    @T2929 //'Счет'. Фильтрация по полю 'branchCustomer.customerId' (eq) [CLIENT]
    @T2930 //'Счет'. Фильтрация по полю 'accountTypeId' (eq) [CLIENT]
    @T2931 //'Счет'. Фильтрация по полю 'accountType.id' (eq) [CLIENT]
    @T2932 //'Счет'. Фильтрация по полю 'accountType.fullName' (eq) [CLIENT]
    @T2933 //'Счет'. Фильтрация по полю 'accountType.fullName' (contains) [CLIENT]
    @T2934 //'Счет'. Фильтрация по полю 'accountType.shortName' (eq) [CLIENT]
    @T2935 //'Счет'. Фильтрация по полю 'accountType.shortName' (contains) [CLIENT]
    @T2936 //'Счет'. Фильтрация по полю 'accountType.description' (eq) [CLIENT]
    @T2937 //'Счет'. Фильтрация по полю 'accountType.description' (contains) [CLIENT]
    @T2938 //'Счет'. Фильтрация по полю 'accountType.systemName' (eq) [CLIENT]
    @T2939 //'Счет'. Фильтрация по полю 'accountType.systemName' (contains) [CLIENT]
    internal fun clientFiltrationNestedFieldsTests(): List<DynamicTest> {
        val user = clientUser
        val dataForFilter = clientDataForFilter
        return EntityTestGenerator.generate(
            listOf(
                //TODO Sergeyev [2021.02.16]: improve these (branch/customer/individual)
//                AccountFiltrationTest("branchCustomerId equals", user, { dataForFilter },
//                    { BR_CUST_ID.eq(it!!.branchCustomerId) }).withId(T2926::class),
//                AccountFiltrationTest("branchCustomer.id equals", user, { dataForFilter },
//                    { BR_CUST_NESTED_ID.eq(it!!.branchCustomerId) }).withId(T2927::class),
//                AccountFiltrationTest("branchCustomer.branchId equals", user, { dataForFilter },
//                    { BR_CUST_NESTED_BRANCH_ID.eq(it!!.branchId!!) }).withId(T2928::class),
//                AccountFiltrationTest("branchCustomer.customerId equals", user, { dataForFilter },
//                    { BR_CUST_NESTED_CUSTOMER_ID.eq(it!!.customerId!!) }).withId(T2929::class),

                AccountFiltrationTest("accountTypeId equals", user, { dataForFilter },
                    { ACC_TYPE_ID.eq(it!!.accountTypeId) }).withId(T2930::class),
                AccountFiltrationTest("accountType.id equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_ID.eq(it!!.accountTypeId) }).withId(T2931::class),
                AccountFiltrationTest("accountType.fullName equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_FULL_NAME.eq(it!!.accountType?.fullName ?: "") }).withId(T2932::class),
                AccountFiltrationTest("accountType.fullName contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_FULL_NAME.contains((it!!.accountType?.fullName ?: "").randomSubstringPf()) }).withId(T2933::class),
                AccountFiltrationTest("accountType.shortName equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SHORT_NAME.eq(it!!.accountType?.shortName ?: "") }).withId(T2934::class),
                AccountFiltrationTest("accountType.shortName contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SHORT_NAME.contains((it!!.accountType?.shortName ?: "").randomSubstringPf()) }).withId(T2935::class),
                AccountFiltrationTest("accountType.description equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_DESCRIPTION.eq(it!!.accountType?.description ?: "") }).withId(T2936::class),
                AccountFiltrationTest("accountType.description contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_DESCRIPTION.contains((it!!.accountType?.description ?: "").randomSubstringPf()) }).withId(T2937::class),
                AccountFiltrationTest("accountType.systemName equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SYSTEM_NAME.eq(it!!.accountType?.systemName ?: "") }).withId(T2938::class),
                AccountFiltrationTest("accountType.systemName contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SYSTEM_NAME.contains((it!!.accountType?.systemName ?: "").randomSubstringPf()) }).withId(T2939::class),
            )
        )
    }

    @TestFactory
    @T2949 //'Счет'. Фильтрация по полю 'branchCustomerId' (eq) [BANK]
    @T2950 //'Счет'. Фильтрация по полю 'branchCustomer.id' (eq) [BANK]
    @T2951 //'Счет'. Фильтрация по полю 'branchCustomer.branchId' (eq) [BANK]
    @T2952 //'Счет'. Фильтрация по полю 'branchCustomer.customerId' (eq) [BANK]
    @T2953 //'Счет'. Фильтрация по полю 'accountTypeId' (eq) [BANK]
    @T2954 //'Счет'. Фильтрация по полю 'accountType.id' (eq) [BANK]
    @T2955 //'Счет'. Фильтрация по полю 'accountType.fullName' (eq) [BANK]
    @T2956 //'Счет'. Фильтрация по полю 'accountType.fullName' (contains) [BANK]
    @T2957 //'Счет'. Фильтрация по полю 'accountType.shortName' (eq) [BANK]
    @T2958 //'Счет'. Фильтрация по полю 'accountType.shortName' (contains) [BANK]
    @T2959 //'Счет'. Фильтрация по полю 'accountType.description' (eq) [BANK]
    @T2960 //'Счет'. Фильтрация по полю 'accountType.description' (contains) [BANK]
    @T2961 //'Счет'. Фильтрация по полю 'accountType.systemName' (eq) [BANK]
    @T2962 //'Счет'. Фильтрация по полю 'accountType.systemName' (contains) [BANK]
    internal fun bankFiltrationNestedFieldsTests(): List<DynamicTest> {
        val user = bankUser
        val dataForFilter = bankDataForFilter
        return EntityTestGenerator.generate(
            listOf(
                //TODO Sergeyev [2021.02.16]: improve these (branch/customer/individual)
//                AccountFiltrationTest("branchCustomerId equals", user, { dataForFilter },
//                    { BR_CUST_ID.eq(it!!.branchCustomerId) }).withId(T2949::class),
//                AccountFiltrationTest("branchCustomer.id equals", user, { dataForFilter },
//                    { BR_CUST_NESTED_ID.eq(it!!.branchCustomerId) }).withId(T2950::class),
//                AccountFiltrationTest("branchCustomer.branchId equals", user, { dataForFilter },
//                    { BR_CUST_NESTED_BRANCH_ID.eq(it!!.branchId!!) }).withId(T2951::class),
//                AccountFiltrationTest("branchCustomer.customerId equals", user, { dataForFilter },
//                    { BR_CUST_NESTED_CUSTOMER_ID.eq(it!!.customerId!!) }).withId(T2952::class),

                AccountFiltrationTest("accountTypeId equals", user, { dataForFilter },
                    { ACC_TYPE_ID.eq(it!!.accountTypeId) }).withId(T2953::class),
                AccountFiltrationTest("accountType.id equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_ID.eq(it!!.accountTypeId) }).withId(T2954::class),
                AccountFiltrationTest("accountType.fullName equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_FULL_NAME.eq(it!!.accountType?.fullName ?: "") }).withId(T2955::class),
                AccountFiltrationTest("accountType.fullName contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_FULL_NAME.contains((it!!.accountType?.fullName ?: "").randomSubstringPf()) }).withId(T2956::class),
                AccountFiltrationTest("accountType.shortName equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SHORT_NAME.eq(it!!.accountType?.shortName ?: "") }).withId(T2957::class),
                AccountFiltrationTest("accountType.shortName contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SHORT_NAME.contains((it!!.accountType?.shortName ?: "").randomSubstringPf()) }).withId(T2958::class),
                AccountFiltrationTest("accountType.description equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_DESCRIPTION.eq(it!!.accountType?.description ?: "") }).withId(T2959::class),
                AccountFiltrationTest("accountType.description contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_DESCRIPTION.contains((it!!.accountType?.description ?: "").randomSubstringPf()) }).withId(T2960::class),
                AccountFiltrationTest("accountType.systemName equals", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SYSTEM_NAME.eq(it!!.accountType?.systemName ?: "") }).withId(T2961::class),
                AccountFiltrationTest("accountType.systemName contains", user, { dataForFilter },
                    { ACC_TYPE_NESTED_SYSTEM_NAME.contains((it!!.accountType?.systemName ?: "").randomSubstringPf()) }).withId(T2962::class),
            )
        )
    }

    @TestFactory
    @T2755 //'Счет'. Получить баланс счёта по его реквизитам [CLIENT]
    @T2756 //'Счет'. Получить счёт по его реквизитам [CLIENT]
    @T2757 //'Счет'. Получить баланс счёта по его реквизитам [BANK]
    @T2758 //'Счет'. Получить счёт по его реквизитам [BANK]
    internal fun additionalTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                GetAccountBalanceTest(clientUser).withId(T2755::class),
                GetAccountByAccInfoTest(clientUser).withId(T2756::class),
                GetAccountBalanceTest(bankUser).withId(T2757::class),
                GetAccountByAccInfoTest(bankUser).withId(T2758::class)
            )
        )
    }
}