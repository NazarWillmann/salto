package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_COUNTRY
import ooo.jtc.api.dictionaries.country.CountryControlTest
import ooo.jtc.api.dictionaries.country.CountryCreateTest
import ooo.jtc.api.dictionaries.country.CountryDeleteTest
import ooo.jtc.api.dictionaries.country.CountryFiltrationTests
import ooo.jtc.api.dictionaries.country.CountryGetPageTest
import ooo.jtc.api.dictionaries.country.CountryGetTest
import ooo.jtc.api.dictionaries.country.CountryPrepareSteps
import ooo.jtc.api.dictionaries.country.CountrySortingTest
import ooo.jtc.api.dictionaries.country.CountryUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.CONTROL_NOT_IMPLEMENTED
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.country.Country
import ooo.jtc.dictionaries.country.CountryDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.country.CountryControls
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.dictionaries.country.CountryFilterParams
import ooo.jtc.testdata.dictionaries.country.CountrySortingParams
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
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
@Story(DictionaryNames.COUNTRY)
@DisplayName("API '${DictionaryNames.COUNTRY}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_COUNTRY
@TestInstance(PER_CLASS)
class CountryTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T3858") annotation class T3858
@Tag("JTCSALTO-T3859") annotation class T3859
@Tag("JTCSALTO-T3860") annotation class T3860
@Tag("JTCSALTO-T3861") annotation class T3861
@Tag("JTCSALTO-T3862") annotation class T3862
@Tag("JTCSALTO-T3863") annotation class T3863
@Tag("JTCSALTO-T3864") annotation class T3864
@Tag("JTCSALTO-T3865") annotation class T3865
@Tag("JTCSALTO-T3866") annotation class T3866
@Tag("JTCSALTO-T3867") annotation class T3867
@Tag("JTCSALTO-T3868") annotation class T3868
@Tag("JTCSALTO-T3869") annotation class T3869
@Tag("JTCSALTO-T3870") annotation class T3870
@Tag("JTCSALTO-T3871") annotation class T3871
@Tag("JTCSALTO-T3872") annotation class T3872
@Tag("JTCSALTO-T3873") annotation class T3873
@Tag("JTCSALTO-T3874") annotation class T3874
@Tag("JTCSALTO-T3875") annotation class T3875
@Tag("JTCSALTO-T3876") annotation class T3876
@Tag("JTCSALTO-T3877") annotation class T3877
@Tag("JTCSALTO-T3878") annotation class T3878
@Tag("JTCSALTO-T3879") annotation class T3879
@Tag("JTCSALTO-T3880") annotation class T3880
@Tag("JTCSALTO-T3881") annotation class T3881
@Tag("JTCSALTO-T3882") annotation class T3882
@Tag("JTCSALTO-T3883") annotation class T3883
@Tag("JTCSALTO-T3884") annotation class T3884
@Tag("JTCSALTO-T3885") annotation class T3885
@Tag("JTCSALTO-T3886") annotation class T3886
@Tag("JTCSALTO-T3887") annotation class T3887
@Tag("JTCSALTO-T3888") annotation class T3888
@Tag("JTCSALTO-T3889") annotation class T3889
@Tag("JTCSALTO-T3890") annotation class T3890
@Tag("JTCSALTO-T3891") annotation class T3891
@Tag("JTCSALTO-T3892") annotation class T3892
@Tag("JTCSALTO-T3893") annotation class T3893
@Tag("JTCSALTO-T3894") annotation class T3894
@Tag("JTCSALTO-T3895") annotation class T3895
@Tag("JTCSALTO-T3896") annotation class T3896
@Tag("JTCSALTO-T3897") annotation class T3897
@Tag("JTCSALTO-T3898") annotation class T3898
@Tag("JTCSALTO-T3899") annotation class T3899
@Tag("JTCSALTO-T3900") annotation class T3900
@Tag("JTCSALTO-T3901") annotation class T3901
@Tag("JTCSALTO-T3902") annotation class T3902
@Tag("JTCSALTO-T3903") annotation class T3903
@Tag("JTCSALTO-T3904") annotation class T3904
@Tag("JTCSALTO-T3905") annotation class T3905
@Tag("JTCSALTO-T3906") annotation class T3906
@Tag("JTCSALTO-T3907") annotation class T3907
@Tag("JTCSALTO-T3908") annotation class T3908
@Tag("JTCSALTO-T3909") annotation class T3909
@Tag("JTCSALTO-T3910") annotation class T3910
@Tag("JTCSALTO-T3911") annotation class T3911
@Tag("JTCSALTO-T3912") annotation class T3912
@Tag("JTCSALTO-T3913") annotation class T3913
@Tag("JTCSALTO-T3914") annotation class T3914
@Tag("JTCSALTO-T3915") annotation class T3915
@Tag("JTCSALTO-T3916") annotation class T3916
@Tag("JTCSALTO-T3917") annotation class T3917
@Tag("JTCSALTO-T3918") annotation class T3918

@Tag("JTCSALTO-T5547") annotation class T5547
@Tag("JTCSALTO-T5548") annotation class T5548
@Tag("JTCSALTO-T5549") annotation class T5549
@Tag("JTCSALTO-T5550") annotation class T5550
@Tag("JTCSALTO-T5551") annotation class T5551
@Tag("JTCSALTO-T5552") annotation class T5552
@Tag("JTCSALTO-T5553") annotation class T5553
@Tag("JTCSALTO-T5554") annotation class T5554
@Tag("JTCSALTO-T5555") annotation class T5555
@Tag("JTCSALTO-T5556") annotation class T5556
@Tag("JTCSALTO-T5557") annotation class T5557
@Tag("JTCSALTO-T5558") annotation class T5558
@Tag("JTCSALTO-T5559") annotation class T5559
@Tag("JTCSALTO-T5560") annotation class T5560
@Tag("JTCSALTO-T5561") annotation class T5561
@Tag("JTCSALTO-T5562") annotation class T5562
@Tag("JTCSALTO-T5563") annotation class T5563
@Tag("JTCSALTO-T5564") annotation class T5564
@Tag("JTCSALTO-T5565") annotation class T5565
@Tag("JTCSALTO-T5566") annotation class T5566
@Tag("JTCSALTO-T5567") annotation class T5567
@Tag("JTCSALTO-T5568") annotation class T5568
@Tag("JTCSALTO-T5569") annotation class T5569
@Tag("JTCSALTO-T5570") annotation class T5570
//@formatter:on
//endregion

    private lateinit var dataForFilter: CountryDto
    private lateinit var testDataScope: TestDataScope<Country>

    @BeforeAll
    fun prepareCountryTestData() {
        CountryPrepareSteps.cleanAtCreated()
        testDataScope = CountryData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanCountryTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3885 //'Страна'. CRUD: Создаем запись от пользователя [BANK]
    @T3886 //'Страна'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3887 //'Страна'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3888 //'Страна'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3889 //'Страна'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3890 //'Страна'. CRUD: Удаляем запись от пользователя [BANK]
    @T3891 //'Страна'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun countryCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CountryCreateTest().withId(T3885::class),
                CountryGetTest(user = Users.client).withId(T3886::class),
                CountryGetTest(user = Users.bankAdmin).withId(T3887::class),
                CountryGetPageTest(user = Users.client).withId(T3888::class),
                CountryGetPageTest(user = Users.bankAdmin).withId(T3889::class),
                CountryDeleteTest().withId(T3890::class),
                CountryUpdateTest().withId(T3891::class)
            )
        )
    }

    @TestFactory
    @T3871 //'Страна'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3872 //'Страна'. Сортировка по полю 'digitCode, ASC' [CLIENT]
    @T3873 //'Страна'. Сортировка по полю 'alpha2Code, ASC' [CLIENT]
    @T3874 //'Страна'. Сортировка по полю 'alpha3Code, ASC' [CLIENT]
    @T3875 //'Страна'. Сортировка по полю 'shortName, ASC' [CLIENT]
    @T3876 //'Страна'. Сортировка по полю 'fullName, ASC' [CLIENT]
    @T3877 //'Страна'. Сортировка по полю 'intNameIso, ASC' [CLIENT]

    @T3878 //'Страна'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3879 //'Страна'. Сортировка по полю 'digitCode, DESC' [CLIENT]
    @T3880 //'Страна'. Сортировка по полю 'alpha2Code, DESC' [CLIENT]
    @T3881 //'Страна'. Сортировка по полю 'alpha3Code, DESC' [CLIENT]
    @T3882 //'Страна'. Сортировка по полю 'shortName, DESC' [CLIENT]
    @T3883 //'Страна'. Сортировка по полю 'fullName, DESC' [CLIENT]
    @T3884 //'Страна'. Сортировка по полю 'intNameIso, DESC' [CLIENT]
    internal fun countrySortingClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                CountrySortingTest(user, CountrySortingParams.ID::asc).withId(T3871::class),
                CountrySortingTest(user, CountrySortingParams.DIGIT_CODE::asc).withId(T3872::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_2_CODE::asc).withId(T3873::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_3_CODE::asc).withId(T3874::class),
                CountrySortingTest(user, CountrySortingParams.SHORT_NAME::asc).withId(T3875::class),
                CountrySortingTest(user, CountrySortingParams.FULL_NAME::asc).withId(T3876::class),
                CountrySortingTest(user, CountrySortingParams.INT_NAME::asc).withId(T3877::class),

                CountrySortingTest(user, CountrySortingParams.ID::desc).withId(T3878::class),
                CountrySortingTest(user, CountrySortingParams.DIGIT_CODE::desc).withId(T3879::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_2_CODE::desc).withId(T3880::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_3_CODE::desc).withId(T3881::class),
                CountrySortingTest(user, CountrySortingParams.SHORT_NAME::desc).withId(T3882::class),
                CountrySortingTest(user, CountrySortingParams.FULL_NAME::desc).withId(T3883::class),
                CountrySortingTest(user, CountrySortingParams.INT_NAME::desc).withId(T3884::class)
            )
        )
    }

    @TestFactory
    @T3905 //'Страна'. Сортировка по полю 'id, ASC' [BANK]
    @T3906 //'Страна'. Сортировка по полю 'digitCode, ASC' [BANK]
    @T3907 //'Страна'. Сортировка по полю 'alpha2Code, ASC' [BANK]
    @T3908 //'Страна'. Сортировка по полю 'alpha3Code, ASC' [BANK]
    @T3909 //'Страна'. Сортировка по полю 'shortName, ASC' [BANK]
    @T3910 //'Страна'. Сортировка по полю 'fullName, ASC' [BANK]
    @T3911 //'Страна'. Сортировка по полю 'intNameIso, ASC' [BANK]

    @T3912 //'Страна'. Сортировка по полю 'id, DESC' [BANK]
    @T3913 //'Страна'. Сортировка по полю 'digitCode, DESC' [BANK]
    @T3914 //'Страна'. Сортировка по полю 'alpha2Code, DESC' [BANK]
    @T3915 //'Страна'. Сортировка по полю 'alpha3Code, DESC' [BANK]
    @T3916 //'Страна'. Сортировка по полю 'shortName, DESC' [BANK]
    @T3917 //'Страна'. Сортировка по полю 'fullName, DESC' [BANK]
    @T3918 //'Страна'. Сортировка по полю 'intNameIso, DESC' [BANK]
    internal fun countrySortingBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                CountrySortingTest(user, CountrySortingParams.ID::asc).withId(T3905::class),
                CountrySortingTest(user, CountrySortingParams.DIGIT_CODE::asc).withId(T3906::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_2_CODE::asc).withId(T3907::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_3_CODE::asc).withId(T3908::class),
                CountrySortingTest(user, CountrySortingParams.SHORT_NAME::asc).withId(T3909::class),
                CountrySortingTest(user, CountrySortingParams.FULL_NAME::asc).withId(T3910::class),
                CountrySortingTest(user, CountrySortingParams.INT_NAME::asc).withId(T3911::class),

                CountrySortingTest(user, CountrySortingParams.ID::desc).withId(T3912::class),
                CountrySortingTest(user, CountrySortingParams.DIGIT_CODE::desc).withId(T3913::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_2_CODE::desc).withId(T3914::class),
                CountrySortingTest(user, CountrySortingParams.ALPHA_3_CODE::desc).withId(T3915::class),
                CountrySortingTest(user, CountrySortingParams.SHORT_NAME::desc).withId(T3916::class),
                CountrySortingTest(user, CountrySortingParams.FULL_NAME::desc).withId(T3917::class),
                CountrySortingTest(user, CountrySortingParams.INT_NAME::desc).withId(T3918::class)
            )
        )
    }


    @TestFactory
    @T3858 //'Страна'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3859 //'Страна'. Фильтрация по полю 'digitCode' (eq) [CLIENT]
    @T3860 //'Страна'. Фильтрация по полю 'digitCode' (contains) [CLIENT]
    @T3861 //'Страна'. Фильтрация по полю 'alpha2Code' (eq) [CLIENT]
    @T3862 //'Страна'. Фильтрация по полю 'alpha2Code' (contains) [CLIENT]
    @T3863 //'Страна'. Фильтрация по полю 'alpha3Code' (eq) [CLIENT]
    @T3864 //'Страна'. Фильтрация по полю 'alpha3Code' (contains) [CLIENT]
    @T3865 //'Страна'. Фильтрация по полю 'shortName' (eq) [CLIENT]
    @T3866 //'Страна'. Фильтрация по полю 'shortName' (contains) [CLIENT]
    @T3867 //'Страна'. Фильтрация по полю 'fullName' (eq) [CLIENT]
    @T3868 //'Страна'. Фильтрация по полю 'fullName' (contains) [CLIENT]
    @T3869 //'Страна'. Фильтрация по полю 'intNameIso' (eq) [CLIENT]
    @T3870 //'Страна'. Фильтрация по полю 'intNameIso' (contains) [CLIENT]
    internal fun countryFiltrationClientTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                CountryFiltrationTests("id equals", user, { dataForFilter },
                    { CountryFilterParams.ID.eq(it!!.id!!) }).withId(T3858::class),
                CountryFiltrationTests("digitCode equals", user, { dataForFilter },
                    { CountryFilterParams.DIGIT_CODE.eq(it!!.digitCode) }).withId(T3859::class),
                CountryFiltrationTests("digitCode contains", user, { dataForFilter },
                    { CountryFilterParams.DIGIT_CODE.contains(it!!.digitCode.randomSubstringPf()) }).withId(T3860::class),
                CountryFiltrationTests("2-character code equals", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_2_CODE.eq(it!!.alpha2Code) }).withId(T3861::class),
                CountryFiltrationTests("2-character code contains", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_2_CODE.contains(it!!.alpha2Code.randomSubstringPf()) }).withId(T3862::class),
                CountryFiltrationTests("3-character code equals", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_3_CODE.eq(it!!.alpha3Code) }).withId(T3863::class),
                CountryFiltrationTests("3-character code contains", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_3_CODE.contains(it!!.alpha3Code.randomSubstringPf()) }).withId(T3864::class),
                CountryFiltrationTests("short name equals", user, { dataForFilter },
                    { CountryFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T3865::class),
                CountryFiltrationTests("short name contains", user, { dataForFilter },
                    { CountryFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T3866::class),
                CountryFiltrationTests("full name equals", user, { dataForFilter },
                    { CountryFilterParams.FULL_NAME.eq(it!!.fullName!!) }).withId(T3867::class),
                CountryFiltrationTests("full name contains", user, { dataForFilter },
                    { CountryFilterParams.FULL_NAME.contains(it!!.fullName!!.randomSubstringPf()) }).withId(T3868::class),
                CountryFiltrationTests("international name equals", user, { dataForFilter },
                    { CountryFilterParams.INT_NAME.eq(it!!.intNameIso!!) }).withId(T3869::class),
                CountryFiltrationTests("international name contains", user, { dataForFilter },
                    { CountryFilterParams.INT_NAME.contains(it!!.intNameIso!!.randomSubstringPf()) }).withId(T3870::class)
            )
        )
    }

    @TestFactory
    @T3892 //'Страна'. Фильтрация по полю 'id' (eq) [BANK]
    @T3893 //'Страна'. Фильтрация по полю 'digitCode' (eq) [BANK]
    @T3894 //'Страна'. Фильтрация по полю 'digitCode' (contains) [BANK]
    @T3895 //'Страна'. Фильтрация по полю 'alpha2Code' (eq) [BANK]
    @T3896 //'Страна'. Фильтрация по полю 'alpha2Code' (contains) [BANK]
    @T3897 //'Страна'. Фильтрация по полю 'alpha3Code' (eq) [BANK]
    @T3898 //'Страна'. Фильтрация по полю 'alpha3Code' (contains) [BANK]
    @T3899 //'Страна'. Фильтрация по полю 'shortName' (eq) [BANK]
    @T3900 //'Страна'. Фильтрация по полю 'shortName' (contains) [BANK]
    @T3901 //'Страна'. Фильтрация по полю 'fullName' (eq) [BANK]
    @T3902 //'Страна'. Фильтрация по полю 'fullName' (contains) [BANK]
    @T3903 //'Страна'. Фильтрация по полю 'intNameIso' (eq) [BANK]
    @T3904 //'Страна'. Фильтрация по полю 'intNameIso' (contains) [BANK]
    internal fun countryFiltrationBankTests(): List<DynamicTest> {
        val user = Users.bankAdmin
        return EntityTestGenerator.generate(
            listOf(
                CountryFiltrationTests("id equals", user, { dataForFilter },
                    { CountryFilterParams.ID.eq(it!!.id!!) }).withId(T3892::class),
                CountryFiltrationTests("digitCode equals", user, { dataForFilter },
                    { CountryFilterParams.DIGIT_CODE.eq(it!!.digitCode) }).withId(T3893::class),
                CountryFiltrationTests("digitCode contains", user, { dataForFilter },
                    { CountryFilterParams.DIGIT_CODE.contains(it!!.digitCode.randomSubstringPf()) }).withId(T3894::class),
                CountryFiltrationTests("2-character code equals", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_2_CODE.eq(it!!.alpha2Code) }).withId(T3895::class),
                CountryFiltrationTests("2-character code contains", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_2_CODE.contains(it!!.alpha2Code.randomSubstringPf()) }).withId(T3896::class),
                CountryFiltrationTests("3-character code equals", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_3_CODE.eq(it!!.alpha3Code) }).withId(T3897::class),
                CountryFiltrationTests("3-character code contains", user, { dataForFilter },
                    { CountryFilterParams.ALPHA_3_CODE.contains(it!!.alpha3Code.randomSubstringPf()) }).withId(T3898::class),
                CountryFiltrationTests("short name equals", user, { dataForFilter },
                    { CountryFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T3899::class),
                CountryFiltrationTests("short name contains", user, { dataForFilter },
                    { CountryFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T3900::class),
                CountryFiltrationTests("full name equals", user, { dataForFilter },
                    { CountryFilterParams.FULL_NAME.eq(it!!.fullName!!) }).withId(T3901::class),
                CountryFiltrationTests("full name contains", user, { dataForFilter },
                    { CountryFilterParams.FULL_NAME.contains(it!!.fullName!!.randomSubstringPf()) }).withId(T3902::class),
                CountryFiltrationTests("international name equals", user, { dataForFilter },
                    { CountryFilterParams.INT_NAME.eq(it!!.intNameIso!!) }).withId(T3903::class),
                CountryFiltrationTests("international name contains", user, { dataForFilter },
                    { CountryFilterParams.INT_NAME.contains(it!!.intNameIso!!.randomSubstringPf()) }).withId(T3904::class)
            )
        )
    }

    //region Controls
    //TODO Sergeyev [2021.04.06]: add 'null-necessary field' tests

    private val existingCountryDto by lazy { CountryData.randomOrException(seekAtCreated = false) }
    private val getDto = { CountryPrepareSteps.getCountryDtoForCreate() }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5547 //'Страна'. Контроль: краткого наименования на непустоту [BANK]
    @T5548 //'Страна'. Контроль: длины краткого наименования [BANK]
    @T5549 //'Страна'. Контроль: краткого наименования на допустимые символы [BANK]
    @T5550 //'Страна'. Контроль: краткого наименования на уникальность [BANK]
    internal fun countryControlShortNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                CountryControlTest(
//                    testName = "краткого наименования на непустоту (отсутствие значения)",
//                    preExecution = { getDto().apply { shortName = null } },
//                    control = CountryControls.SHORT_NAME_NOT_EMPTY
//                ).withId(T5547::class),
                CountryControlTest(
                    testName = "краткого наименования на непустоту",
                    preExecution = { getDto().apply { shortName = "" } },
                    control = CountryControls.SHORT_NAME_NOT_EMPTY
                ).withId(T5547::class),
                CountryControlTest(
                    testName = "краткого наименования на непустоту (пробелы)",
                    preExecution = { getDto().apply { shortName = "    " } },
                    control = CountryControls.SHORT_NAME_NOT_EMPTY
                ).withId(T5547::class),
                CountryControlTest(
                    testName = "длины краткого наименования",
                    preExecution = { getDto().apply { shortName = digits.random(51, 75) } },
                    control = CountryControls.SHORT_NAME_MAX_LENGTH.withParams("length" to "50")
                ).withId(T5548::class),
                CountryControlTest(
                    testName = "краткого наименования на допустимые символы",
                    preExecution = { getDto().apply { shortName = "bRГя1, -;!_" } },
                    control = CountryControls.SHORT_NAME_AVAILABLE_SYMBOLS.withParams("symbols" to "b;R;-;;;!;_")
                ).withId(T5549::class),
                CountryControlTest(
                    testName = "краткого наименования на уникальность",
                    preExecution = { getDto().apply { shortName = existingCountryDto.shortName } },
                    control = CountryControls.SHORT_NAME_UNIQUE
                ).withId(T5550::class),
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5551 //'Страна'. Контроль: полного наименования на непустоту [BANK]
    @T5552 //'Страна'. Контроль: длины полного наименования [BANK]
    @T5553 //'Страна'. Контроль: полного наименования на допустимые символы [BANK]
    @T5554 //'Страна'. Контроль: полного наименования на уникальность [BANK]
    internal fun countryControlFullNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                CountryControlTest(
//                    testName = "полного наименования на непустоту (отсутствие значения)",
//                    preExecution = { getDto().apply { fullName = null } },
//                    control = CountryControls.FULL_NAME_NOT_EMPTY
//                ).withId(T5551::class),
                CountryControlTest(
                    testName = "полного наименования на непустоту",
                    preExecution = { getDto().apply { fullName = "" } },
                    control = CountryControls.FULL_NAME_NOT_EMPTY
                ).withId(T5551::class),
                CountryControlTest(
                    testName = "полного наименования на непустоту (пробелы)",
                    preExecution = { getDto().apply { fullName = "    " } },
                    control = CountryControls.FULL_NAME_NOT_EMPTY
                ).withId(T5551::class),
                CountryControlTest(
                    testName = "длины полного наименования",
                    preExecution = { getDto().apply { fullName = digits.random(256, 350) } },
                    control = CountryControls.FULL_NAME_MAX_LENGTH.withParams("length" to "255")
                ).withId(T5552::class),
                CountryControlTest(
                    testName = "полного наименования на допустимые символы",
                    preExecution = { getDto().apply { fullName = "bRГя1, -;!_" } },
                    control = CountryControls.FULL_NAME_AVAILABLE_SYMBOLS.withParams("symbols" to "b;R;-;;;!;_")
                ).withId(T5553::class),
                CountryControlTest(
                    testName = "полного наименования на уникальность",
                    preExecution = { getDto().apply { fullName = existingCountryDto.fullName } },
                    control = CountryControls.FULL_NAME_UNIQUE
                ).withId(T5554::class),
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5555 //'Страна'. Контроль: международного наименования на непустоту [BANK]
    @T5556 //'Страна'. Контроль: длины международного наименования [BANK]
    @T5557 //'Страна'. Контроль: международного наименования на допустимые символы [BANK]
    @T5558 //'Страна'. Контроль: международного наименования на уникальность [BANK]
    internal fun countryControlIntNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                CountryControlTest(
//                    testName = "международного наименования на непустоту (отсутствие значения)",
//                    preExecution = { getDto().apply { intNameIso = null } },
//                    control = CountryControls.INT_NAME_NOT_EMPTY
//                ).withId(T5555::class),
                CountryControlTest(
                    testName = "международного наименования на непустоту",
                    preExecution = { getDto().apply { intNameIso = "" } },
                    control = CountryControls.INT_NAME_NOT_EMPTY
                ).withId(T5555::class),
                CountryControlTest(
                    testName = "международного наименования на непустоту (пробелы)",
                    preExecution = { getDto().apply { intNameIso = "    " } },
                    control = CountryControls.INT_NAME_NOT_EMPTY
                ).withId(T5555::class),
                CountryControlTest(
                    testName = "длины международного наименования",
                    preExecution = { getDto().apply { intNameIso = digits.random(256, 350) } },
                    control = CountryControls.INT_NAME_MAX_LENGTH.withParams("length" to "255")
                ).withId(T5556::class),
                CountryControlTest(
                    testName = "международного наименования на допустимые символы",
                    preExecution = { getDto().apply { intNameIso = "bRГя1, -;!_" } },
                    control = CountryControls.INT_NAME_AVAILABLE_SYMBOLS.withParams("symbols" to "Г;я;-;;;!;_")
                ).withId(T5557::class),
                CountryControlTest(
                    testName = "международного наименования на уникальность",
                    preExecution = { getDto().apply { intNameIso = existingCountryDto.intNameIso } },
                    control = CountryControls.INT_NAME_UNIQUE
                ).withId(T5558::class),
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5559 //'Страна'. Контроль: цифрового кода на непустоту [BANK]
    @T5560 //'Страна'. Контроль: длины цифрового кода [BANK]
    @T5561 //'Страна'. Контроль: цифрового кода на допустимые символы [BANK]
    @T5562 //'Страна'. Контроль: цифрового кода на уникальность [BANK]
    internal fun countryControlDigitCodeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                CountryControlTest(
//                    testName = "цифрового кода на непустоту (отсутствие значения)",
//                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveDigitCode = false) },
//                    preExecution = { getDto().apply { digitCode = null } },
//                    control = CountryControls.DIGIT_CODE_NOT_EMPTY
//                ).withId(T5559::class),
                CountryControlTest(
                    testName = "цифрового кода на непустоту",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveDigitCode = false) },
                    preExecution = { getDto().apply { digitCode = "" } },
                    control = CountryControls.DIGIT_CODE_NOT_EMPTY
                ).withId(T5559::class),
                CountryControlTest(
                    testName = "цифрового кода на непустоту (пробелы)",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveDigitCode = false) },
                    preExecution = { getDto().apply { digitCode = "    " } },
                    control = CountryControls.DIGIT_CODE_NOT_EMPTY
                ).withId(T5559::class),
                CountryControlTest(
                    testName = "длины цифрового кода",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveDigitCode = false) },
                    preExecution = { getDto().apply { digitCode = digits.random(51, 75) } },
                    control = CountryControls.DIGIT_CODE_MAX_LENGTH.withParams("length" to "50")
                ).withId(T5560::class),
                CountryControlTest(
                    testName = "цифрового кода на допустимые символы",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveDigitCode = false) },
                    preExecution = { getDto().apply { digitCode = "bRГя1, -;!_" } },
                    control = CountryControls.DIGIT_CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "b;R;Г;я-;;;!;_")
                ).withId(T5561::class),
                CountryControlTest(
                    testName = "цифрового кода на уникальность",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveDigitCode = false) },
                    preExecution = { getDto().apply { digitCode = existingCountryDto.digitCode } },
                    control = CountryControls.DIGIT_CODE_UNIQUE
                ).withId(T5562::class),
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5563 //'Страна'. Контроль: 2-хбуквенного кода на непустоту [BANK]
    @T5564 //'Страна'. Контроль: длины 2-хбуквенного кода [BANK]
    @T5565 //'Страна'. Контроль: 2-хбуквенного кода на допустимые символы [BANK]
    @T5566 //'Страна'. Контроль: 2-хбуквенного кода на уникальность [BANK]
    internal fun countryControlAlpha2CodeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                CountryControlTest(
//                    testName = "2-хбуквенного кода на непустоту (отсутствие значения)",
//                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha2Code = false) },
//                    preExecution = { getDto().apply { alpha2Code = null } },
//                    control = CountryControls.ALPHA_2_CODE_NOT_EMPTY
//                ).withId(T5563::class),
                CountryControlTest(
                    testName = "2-хбуквенного кода на непустоту",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha2Code = false) },
                    preExecution = { getDto().apply { alpha2Code = "" } },
                    control = CountryControls.ALPHA_2_CODE_NOT_EMPTY
                ).withId(T5563::class),
                CountryControlTest(
                    testName = "2-хбуквенного кода на непустоту (пробелы)",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha2Code = false) },
                    preExecution = { getDto().apply { alpha2Code = "    " } },
                    control = CountryControls.ALPHA_2_CODE_NOT_EMPTY
                ).withId(T5563::class),
                CountryControlTest(
                    testName = "длины 2-хбуквенного кода",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha2Code = false) },
                    preExecution = { getDto().apply { alpha2Code = digits.random(51, 75) } },
                    control = CountryControls.ALPHA_2_CODE_MAX_LENGTH.withParams("length" to "50")
                ).withId(T5564::class),
                CountryControlTest(
                    testName = "2-хбуквенного кода на допустимые символы",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha2Code = false) },
                    preExecution = { getDto().apply { alpha2Code = "bRГя1, -;!_" } },
                    control = CountryControls.ALPHA_2_CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "b;Г;я;1;-;;;!;_")
                ).withId(T5565::class),
                CountryControlTest(
                    testName = "2-хбуквенного кода на уникальность",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha2Code = false) },
                    preExecution = { getDto().apply { alpha2Code = existingCountryDto.alpha2Code } },
                    control = CountryControls.ALPHA_2_CODE_UNIQUE
                ).withId(T5566::class),
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5567 //'Страна'. Контроль: 3-хбуквенного кода на непустоту [BANK]
    @T5568 //'Страна'. Контроль: длины 3-хбуквенного кода [BANK]
    @T5569 //'Страна'. Контроль: 3-хбуквенного кода на допустимые символы [BANK]
    @T5570 //'Страна'. Контроль: 3-хбуквенного кода на уникальность [BANK]
    internal fun countryControlAlpha3CodeTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                CountryControlTest(
//                    testName = "3-хбуквенного кода на непустоту (отсутствие значения)",
//                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha3Code = false) },
//                    preExecution = { getDto().apply { alpha3Code = null } },
//                    control = CountryControls.ALPHA_3_CODE_NOT_EMPTY
//                ).withId(T5567::class),
                CountryControlTest(
                    testName = "3-хбуквенного кода на непустоту",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha3Code = false) },
                    preExecution = { getDto().apply { alpha3Code = "" } },
                    control = CountryControls.ALPHA_3_CODE_NOT_EMPTY
                ).withId(T5567::class),
                CountryControlTest(
                    testName = "3-хбуквенного кода на непустоту (пробелы)",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha3Code = false) },
                    preExecution = { getDto().apply { alpha3Code = "    " } },
                    control = CountryControls.ALPHA_3_CODE_NOT_EMPTY
                ).withId(T5567::class),
                CountryControlTest(
                    testName = "длины 3-хбуквенного кода",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha3Code = false) },
                    preExecution = { getDto().apply { alpha3Code = digits.random(51, 75) } },
                    control = CountryControls.ALPHA_3_CODE_MAX_LENGTH.withParams("length" to "50")
                ).withId(T5568::class),
                CountryControlTest(
                    testName = "3-хбуквенного кода на допустимые символы",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha3Code = false) },
                    preExecution = { getDto().apply { alpha3Code = "bRГя1, -;!_" } },
                    control = CountryControls.ALPHA_3_CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "b;Г;я;1;-;;;!;_")
                ).withId(T5569::class),
                CountryControlTest(
                    testName = "3-хбуквенного кода на уникальность",
                    postExecution = { CountryPrepareSteps.retrieveUsedCodes(it, retrieveAlpha3Code = false) },
                    preExecution = { getDto().apply { alpha3Code = existingCountryDto.alpha3Code } },
                    control = CountryControls.ALPHA_3_CODE_UNIQUE
                ).withId(T5570::class),
            )
        )
    }
    //endregion
}