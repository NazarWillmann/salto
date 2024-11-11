package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CURRENCY
import ooo.jtc.api.dictionaries.currency.CurrencyCreateTest
import ooo.jtc.api.dictionaries.currency.CurrencyDeleteTest
import ooo.jtc.api.dictionaries.currency.CurrencyFiltrationTest
import ooo.jtc.api.dictionaries.currency.CurrencyGetPageTest
import ooo.jtc.api.dictionaries.currency.CurrencyGetTest
import ooo.jtc.api.dictionaries.currency.CurrencySortingTest
import ooo.jtc.api.dictionaries.currency.CurrencyUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.currency.Currency
import ooo.jtc.dictionaries.currency.CurrencyDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.currency.CurrencyData
import ooo.jtc.testdata.dictionaries.currency.CurrencyFilterParams
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams.DIGIT_CODE
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams.ID
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams.MINOR_UNIT_COUNT
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams.NAME
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams.NAME_IN_OKV
import ooo.jtc.testdata.dictionaries.currency.CurrencySortingParams.ALPHA_CODE
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
@Story(DictionaryNames.CURRENCY)
@DisplayName("API '${DictionaryNames.CURRENCY}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CURRENCY
@TestInstance(PER_CLASS)
class CurrencyTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2696") annotation class T2696
@Tag("JTCSALTO-T2697") annotation class T2697
@Tag("JTCSALTO-T2698") annotation class T2698
@Tag("JTCSALTO-T2699") annotation class T2699
@Tag("JTCSALTO-T2700") annotation class T2700
@Tag("JTCSALTO-T2701") annotation class T2701
@Tag("JTCSALTO-T2702") annotation class T2702
@Tag("JTCSALTO-T2703") annotation class T2703
@Tag("JTCSALTO-T2704") annotation class T2704
@Tag("JTCSALTO-T2705") annotation class T2705
@Tag("JTCSALTO-T2706") annotation class T2706
@Tag("JTCSALTO-T2707") annotation class T2707
@Tag("JTCSALTO-T2708") annotation class T2708
@Tag("JTCSALTO-T2709") annotation class T2709
@Tag("JTCSALTO-T2710") annotation class T2710
@Tag("JTCSALTO-T2711") annotation class T2711
@Tag("JTCSALTO-T2712") annotation class T2712
@Tag("JTCSALTO-T2713") annotation class T2713
@Tag("JTCSALTO-T2714") annotation class T2714
@Tag("JTCSALTO-T2715") annotation class T2715
@Tag("JTCSALTO-T2716") annotation class T2716
@Tag("JTCSALTO-T2717") annotation class T2717
@Tag("JTCSALTO-T2718") annotation class T2718
@Tag("JTCSALTO-T2719") annotation class T2719
@Tag("JTCSALTO-T2720") annotation class T2720
@Tag("JTCSALTO-T2721") annotation class T2721
@Tag("JTCSALTO-T2722") annotation class T2722
@Tag("JTCSALTO-T2723") annotation class T2723
@Tag("JTCSALTO-T2724") annotation class T2724
@Tag("JTCSALTO-T2725") annotation class T2725
@Tag("JTCSALTO-T2726") annotation class T2726
@Tag("JTCSALTO-T2727") annotation class T2727
@Tag("JTCSALTO-T2728") annotation class T2728
@Tag("JTCSALTO-T2729") annotation class T2729
@Tag("JTCSALTO-T2730") annotation class T2730
@Tag("JTCSALTO-T2731") annotation class T2731
@Tag("JTCSALTO-T2732") annotation class T2732
@Tag("JTCSALTO-T2733") annotation class T2733
@Tag("JTCSALTO-T2734") annotation class T2734
@Tag("JTCSALTO-T2735") annotation class T2735
@Tag("JTCSALTO-T2736") annotation class T2736
@Tag("JTCSALTO-T2737") annotation class T2737
@Tag("JTCSALTO-T2738") annotation class T2738
@Tag("JTCSALTO-T2739") annotation class T2739
@Tag("JTCSALTO-T2740") annotation class T2740
@Tag("JTCSALTO-T2741") annotation class T2741
@Tag("JTCSALTO-T2742") annotation class T2742
//@formatter:on
//endregion

    private lateinit var dataForFilter: CurrencyDto
    private lateinit var testDataScope: TestDataScope<Currency>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = CurrencyData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T2696 //'Валюта'. CRUD: Создаем запись от пользователя [BANK]
    @T2697 //'Валюта'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2698 //'Валюта'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2699 //'Валюта'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2700 //'Валюта'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2701 //'Валюта'. CRUD: Удаляем запись от пользователя [BANK]
    @T2702 //'Валюта'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun currencyCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CurrencyCreateTest().withId(T2696::class),
                CurrencyGetTest(user = client).withId(T2697::class),
                CurrencyGetTest(user = bankAdmin).withId(T2698::class),
                CurrencyGetPageTest(user = client).withId(T2699::class),
                CurrencyGetPageTest(user = bankAdmin).withId(T2700::class),
                CurrencyDeleteTest().withId(T2701::class),
                CurrencyUpdateTest().withId(T2702::class)
            )
        )
    }

    @TestFactory
    @T2731 //'Валюта'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2732 //'Валюта'. Сортировка по полю 'digitCode, ASC' [CLIENT]
    @T2733 //'Валюта'. Сортировка по полю 'alphaCode, ASC' [CLIENT]
    @T2734 //'Валюта'. Сортировка по полю 'name, ASC' [CLIENT]
    @T2735 //'Валюта'. Сортировка по полю 'nameInOkv, ASC' [CLIENT]
    @T2736 //'Валюта'. Сортировка по полю 'minorUnitCount, ASC' [CLIENT]

    @T2737 //'Валюта'. Сортировка по полю 'id, DESC' [CLIENT]
    @T2738 //'Валюта'. Сортировка по полю 'digitCode, DESC' [CLIENT]
    @T2739 //'Валюта'. Сортировка по полю 'alphaCode, DESC' [CLIENT]
    @T2740 //'Валюта'. Сортировка по полю 'name, DESC' [CLIENT]
    @T2741 //'Валюта'. Сортировка по полю 'nameInOkv, DESC' [CLIENT]
    @T2742 //'Валюта'. Сортировка по полю 'minorUnitCount, DESC' [CLIENT]
    internal fun currencySortingClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                CurrencySortingTest(user, ID::asc).withId(T2731::class),
                CurrencySortingTest(user, DIGIT_CODE::asc).withId(T2732::class),
                CurrencySortingTest(user, ALPHA_CODE::asc).withId(T2733::class),
                CurrencySortingTest(user, NAME::asc).withId(T2734::class),
                CurrencySortingTest(user, NAME_IN_OKV::asc).withId(T2735::class),
                CurrencySortingTest(user, MINOR_UNIT_COUNT::asc).withId(T2736::class),

                CurrencySortingTest(user, ID::desc).withId(T2737::class),
                CurrencySortingTest(user, DIGIT_CODE::desc).withId(T2738::class),
                CurrencySortingTest(user, ALPHA_CODE::desc).withId(T2739::class),
                CurrencySortingTest(user, NAME::desc).withId(T2740::class),
                CurrencySortingTest(user, NAME_IN_OKV::desc).withId(T2741::class),
                CurrencySortingTest(user, MINOR_UNIT_COUNT::desc).withId(T2742::class)
            )
        )
    }

    @TestFactory
    @T2711 //'Валюта'. Сортировка по полю 'id, ASC' [BANK]
    @T2712 //'Валюта'. Сортировка по полю 'digitCode, ASC' [BANK]
    @T2713 //'Валюта'. Сортировка по полю 'alphaCode, ASC' [BANK]
    @T2714 //'Валюта'. Сортировка по полю 'name, ASC' [BANK]
    @T2715 //'Валюта'. Сортировка по полю 'nameInOkv, ASC' [BANK]
    @T2716 //'Валюта'. Сортировка по полю 'minorUnitCount, ASC' [BANK]

    @T2717 //'Валюта'. Сортировка по полю 'id, DESC' [BANK]
    @T2718 //'Валюта'. Сортировка по полю 'digitCode, DESC' [BANK]
    @T2719 //'Валюта'. Сортировка по полю 'alphaCode, DESC' [BANK]
    @T2720 //'Валюта'. Сортировка по полю 'name, DESC' [BANK]
    @T2721 //'Валюта'. Сортировка по полю 'nameInOkv, DESC' [BANK]
    @T2722 //'Валюта'. Сортировка по полю 'minorUnitCount, DESC' [BANK]
    internal fun currencySortingBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                CurrencySortingTest(user, ID::asc).withId(T2711::class),
                CurrencySortingTest(user, DIGIT_CODE::asc).withId(T2712::class),
                CurrencySortingTest(user, ALPHA_CODE::asc).withId(T2713::class),
                CurrencySortingTest(user, NAME::asc).withId(T2714::class),
                CurrencySortingTest(user, NAME_IN_OKV::asc).withId(T2715::class),
                CurrencySortingTest(user, MINOR_UNIT_COUNT::asc).withId(T2716::class),

                CurrencySortingTest(user, ID::desc).withId(T2717::class),
                CurrencySortingTest(user, DIGIT_CODE::desc).withId(T2718::class),
                CurrencySortingTest(user, ALPHA_CODE::desc).withId(T2719::class),
                CurrencySortingTest(user, NAME::desc).withId(T2720::class),
                CurrencySortingTest(user, NAME_IN_OKV::desc).withId(T2721::class),
                CurrencySortingTest(user, MINOR_UNIT_COUNT::desc).withId(T2722::class)
            )
        )
    }

    @TestFactory
    @T2723 //'Валюта'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2724 //'Валюта'. Фильтрация по полю 'digitCode' (eq) [CLIENT]
    @T2725 //'Валюта'. Фильтрация по полю 'alphaCode' (eq) [CLIENT]
    @T2726 //'Валюта'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T2727 //'Валюта'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T2728 //'Валюта'. Фильтрация по полю 'nameInOkv' (eq) [CLIENT]
    @T2729 //'Валюта'. Фильтрация по полю 'nameInOkv' (contains) [CLIENT]
    @T2730 //'Валюта'. Фильтрация по полю 'minorUnitCount' (eq) [CLIENT]
    internal fun currencyFiltrationClientTests(): List<DynamicTest> {
        val user = client
        return EntityTestGenerator.generate(
            listOf(
                CurrencyFiltrationTest("id equals", user, { dataForFilter },
                    { CurrencyFilterParams.ID.eq(it!!.id!!) }).withId(T2723::class),
                CurrencyFiltrationTest("digitCode equals", user, { dataForFilter },
                    { CurrencyFilterParams.DIGIT_CODE.eq(it!!.digitCode) }).withId(T2724::class),
                CurrencyFiltrationTest("alphaCode equals", user, { dataForFilter },
                    { CurrencyFilterParams.ALPHA_CODE.eq(it!!.alphaCode) }).withId(T2725::class),
                CurrencyFiltrationTest("name equals", user, { dataForFilter },
                    { CurrencyFilterParams.NAME.eq(it!!.name) }).withId(T2726::class),
                CurrencyFiltrationTest("name contains", user, { dataForFilter },
                    { CurrencyFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T2727::class),
                CurrencyFiltrationTest("nameInOkv equals", user, { dataForFilter },
                    { CurrencyFilterParams.NAME_IN_OKV.eq(it!!.nameInOkv) }).withId(T2728::class),
                CurrencyFiltrationTest("nameInOkv contains", user, { dataForFilter },
                    { CurrencyFilterParams.NAME_IN_OKV.contains(it!!.nameInOkv.randomSubstringPf()) }).withId(T2729::class),
                CurrencyFiltrationTest("minorUnitCount equals", user, { dataForFilter },
                    { CurrencyFilterParams.MINOR_UNIT_COUNT.eq(it!!.minorUnitCount) }).withId(T2730::class)
            )
        )
    }

    @TestFactory
    @T2703 //'Валюта'. Фильтрация по полю 'id' (eq) [BANK]
    @T2704 //'Валюта'. Фильтрация по полю 'digitCode' (eq) [BANK]
    @T2705 //'Валюта'. Фильтрация по полю 'alphaCode' (eq) [BANK]
    @T2706 //'Валюта'. Фильтрация по полю 'name' (eq) [BANK]
    @T2707 //'Валюта'. Фильтрация по полю 'name' (contains) [BANK]
    @T2708 //'Валюта'. Фильтрация по полю 'nameInOkv' (eq) [BANK]
    @T2709 //'Валюта'. Фильтрация по полю 'nameInOkv' (contains) [BANK]
    @T2710 //'Валюта'. Фильтрация по полю 'minorUnitCount' (eq) [BANK]
    internal fun currencyFiltrationBankTests(): List<DynamicTest> {
        val user = bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                CurrencyFiltrationTest("id equals", user, { dataForFilter },
                    { CurrencyFilterParams.ID.eq(it!!.id!!) }).withId(T2703::class),
                CurrencyFiltrationTest("digitCode equals", user, { dataForFilter },
                    { CurrencyFilterParams.DIGIT_CODE.eq(it!!.digitCode) }).withId(T2704::class),
                CurrencyFiltrationTest("alphaCode equals", user, { dataForFilter },
                    { CurrencyFilterParams.ALPHA_CODE.eq(it!!.alphaCode) }).withId(T2705::class),
                CurrencyFiltrationTest("name equals", user, { dataForFilter },
                    { CurrencyFilterParams.NAME.eq(it!!.name) }).withId(T2706::class),
                CurrencyFiltrationTest("name contains", user, { dataForFilter },
                    { CurrencyFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T2707::class),
                CurrencyFiltrationTest("nameInOkv equals", user, { dataForFilter },
                    { CurrencyFilterParams.NAME_IN_OKV.eq(it!!.nameInOkv) }).withId(T2708::class),
                CurrencyFiltrationTest("nameInOkv contains", user, { dataForFilter },
                    { CurrencyFilterParams.NAME_IN_OKV.contains(it!!.nameInOkv.randomSubstringPf()) }).withId(T2709::class),
                CurrencyFiltrationTest("minorUnitCount equals", user, { dataForFilter },
                    { CurrencyFilterParams.MINOR_UNIT_COUNT.eq(it!!.minorUnitCount) }).withId(T2710::class)
            )
        )
    }
}