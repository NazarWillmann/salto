package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_TREASURY_ACCOUNT_TAX
import ooo.jtc.api.common.checks.ControlChecks.checkDefaultControlLevel
import ooo.jtc.api.common.checks.ControlChecks.checkValidationResult
import ooo.jtc.api.common.controls.ControlLevel
import ooo.jtc.api.common.controls.ControlLevel.OFF
import ooo.jtc.api.common.controls.ControlLevel.WARNING
import ooo.jtc.api.common.controls.IControls.Companion.getForbiddenSymbolsMessage
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxControlTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxControlUnitBeTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxCreateTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxDeleteTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxFiltrationTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxFolderDefaults
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxFolderOther
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxGetPageTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxGetTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.ACCOUNT_CURRENCY
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.ACCOUNT_PREFIX
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.createBankBicAccount
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.deleteBankBicAccounts
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps.getTreasuryAccountTaxDtoForCreate
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingTest
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxSteps
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxTraceabilityTasks
import ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.tm4j.Tm4jComponent.DICTIONARY
import ooo.jtc.core.tm4j.Tm4jPriority.High
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum.CBRA
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum.DELETED
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTax
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users.autotest
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.ACCOUNT_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.ACCOUNT_CODE
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.ACCOUNT_CURRENCY_CODE
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.ACCOUNT_LENGTH
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.BANK_NAME_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.BANK_NAME_FORMAT
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.BANK_NAME_LENGTH
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.BIC_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.BIC_LENGTH
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.COMMON_ACCOUNT
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.COMMON_ACCOUNT_STATUS
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.COMMON_ACCOUNT_TYPE
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.COMMON_BANK_NAME
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.COMMON_BIC
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.TOFK_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.TOFK_LENGTH
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.UTRA_ACCOUNT_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.UTRA_ACCOUNT_EMPTY
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxControls.UTRA_ACCOUNT_LENGTH
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxData
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxFilterParams
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingParams.ACCOUNT
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingParams.BANK_NAME
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingParams.BIC
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingParams.TOFK
import ooo.jtc.testdata.dictionaries.treasuryaccounttax.TreasuryAccountTaxSortingParams.UTRA_ACCOUNT
import ooo.jtc.wait.Wait
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.atomic.AtomicInteger

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.TREASURY_ACCOUNT_TAX)
@DisplayName("API '${DictionaryNames.TREASURY_ACCOUNT_TAX}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_TREASURY_ACCOUNT_TAX
@TestInstance(PER_CLASS)
class TreasuryAccountTaxTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T6891") annotation class T6891
@Tag("JTCSALTO-T6892") annotation class T6892
@Tag("JTCSALTO-T6893") annotation class T6893
@Tag("JTCSALTO-T6894") annotation class T6894
@Tag("JTCSALTO-T6895") annotation class T6895
@Tag("JTCSALTO-T6896") annotation class T6896
@Tag("JTCSALTO-T6897") annotation class T6897
@Tag("JTCSALTO-T6898") annotation class T6898
@Tag("JTCSALTO-T6899") annotation class T6899
@Tag("JTCSALTO-T6900") annotation class T6900
@Tag("JTCSALTO-T6901") annotation class T6901
@Tag("JTCSALTO-T6902") annotation class T6902
@Tag("JTCSALTO-T6903") annotation class T6903
@Tag("JTCSALTO-T6904") annotation class T6904
@Tag("JTCSALTO-T6905") annotation class T6905
@Tag("JTCSALTO-T6906") annotation class T6906
@Tag("JTCSALTO-T6907") annotation class T6907
@Tag("JTCSALTO-T6908") annotation class T6908
@Tag("JTCSALTO-T6909") annotation class T6909
@Tag("JTCSALTO-T6910") annotation class T6910
@Tag("JTCSALTO-T6911") annotation class T6911
@Tag("JTCSALTO-T6912") annotation class T6912
@Tag("JTCSALTO-T6913") annotation class T6913
@Tag("JTCSALTO-T6914") annotation class T6914
@Tag("JTCSALTO-T6915") annotation class T6915
@Tag("JTCSALTO-T6916") annotation class T6916
@Tag("JTCSALTO-T6917") annotation class T6917
@Tag("JTCSALTO-T6918") annotation class T6918
@Tag("JTCSALTO-T6919") annotation class T6919
@Tag("JTCSALTO-T6920") annotation class T6920
@Tag("JTCSALTO-T6921") annotation class T6921
@Tag("JTCSALTO-T6922") annotation class T6922
@Tag("JTCSALTO-T6923") annotation class T6923
@Tag("JTCSALTO-T6924") annotation class T6924
@Tag("JTCSALTO-T6925") annotation class T6925
@Tag("JTCSALTO-T6926") annotation class T6926
@Tag("JTCSALTO-T6927") annotation class T6927
@Tag("JTCSALTO-T6928") annotation class T6928
@Tag("JTCSALTO-T6929") annotation class T6929
@Tag("JTCSALTO-T6930") annotation class T6930
@Tag("JTCSALTO-T6931") annotation class T6931
@Tag("JTCSALTO-T6932") annotation class T6932
@Tag("JTCSALTO-T6933") annotation class T6933
@Tag("JTCSALTO-T6934") annotation class T6934
@Tag("JTCSALTO-T6935") annotation class T6935
@Tag("JTCSALTO-T6936") annotation class T6936
@Tag("JTCSALTO-T6937") annotation class T6937
@Tag("JTCSALTO-T6938") annotation class T6938
@Tag("JTCSALTO-T6939") annotation class T6939
@Tag("JTCSALTO-T6940") annotation class T6940
@Tag("JTCSALTO-T6941") annotation class T6941
@Tag("JTCSALTO-T6942") annotation class T6942
@Tag("JTCSALTO-T6943") annotation class T6943
@Tag("JTCSALTO-T6944") annotation class T6944
@Tag("JTCSALTO-T6945") annotation class T6945
@Tag("JTCSALTO-T6946") annotation class T6946
@Tag("JTCSALTO-T6947") annotation class T6947
@Tag("JTCSALTO-T6948") annotation class T6948
@Tag("JTCSALTO-T6949") annotation class T6949
@Tag("JTCSALTO-T6950") annotation class T6950
@Tag("JTCSALTO-T6951") annotation class T6951
@Tag("JTCSALTO-T6952") annotation class T6952
@Tag("JTCSALTO-T6953") annotation class T6953
@Tag("JTCSALTO-T6954") annotation class T6954
@Tag("JTCSALTO-T6955") annotation class T6955
@Tag("JTCSALTO-T6956") annotation class T6956
@Tag("JTCSALTO-T6957") annotation class T6957
@Tag("JTCSALTO-T6958") annotation class T6958
@Tag("JTCSALTO-T6959") annotation class T6959
@Tag("JTCSALTO-T6960") annotation class T6960
@Tag("JTCSALTO-T6961") annotation class T6961
@Tag("JTCSALTO-T6962") annotation class T6962
@Tag("JTCSALTO-T6963") annotation class T6963
@Tag("JTCSALTO-T6964") annotation class T6964
//@formatter:on
//endregion

    companion object {
        private var treasuryAccountTaxSteps = TreasuryAccountTaxSteps(user = autotest)
    }

    // TODO: заменить костыль после перехода на версию JUnit поддерживающую @TestClassOrder.
    private val completedTestCount = AtomicInteger(0)

    private lateinit var testDataScope: TestDataScope<TreasuryAccountTax>
    private lateinit var dataForFilter: TreasuryAccountTaxDto

    @BeforeAll
    fun setUpTreasuryAccountTaxClass() {
        testDataScope = TreasuryAccountTaxData.withRequiredFields(fromCache = false)
        dataForFilter = testDataScope.all.random().toDto()
        treasuryAccountTaxSteps.setControlSettings(getControlSettingsJson(WARNING))
    }

    @AfterEach
    fun tearDownTreasuryAccountTaxMethod() {
        completedTestCount.incrementAndGet()
    }

    @AfterAll
    fun tearDownTreasuryAccountTaxClass() {
        treasuryAccountTaxSteps.setControlSettings(getControlSettingsJson(OFF))
        testDataScope.removeGenerated()
        deleteBankBicAccounts()
    }

    @Nested
    @Execution(ExecutionMode.SAME_THREAD)
    @TestInstance(PER_CLASS)
    inner class Nonparallel {

        @BeforeAll
        fun setUpTreasuryAccountTaxNonparallelClass() {
            Wait.until(supplier = { completedTestCount.get() == 7 })
        }

        @TestFactory
        internal fun treasuryAccountTaxImportTests(): List<DynamicTest> {
            return EntityTestGenerator.generate(
                listOf(
                    AbstractBeTest(
                        name = "Импорт казначейских счетов из csv-файла",
                        preExecution = {
                            TreasuryAccountTaxData.withRequiredFields(
                                fromCache = false,
                                requiredDataCount = 0,
                                additionalFilter = { !TreasuryAccountTaxData.atMarkerPredicate.invoke(it) }
                            )
                        },
                        testBody = {
                            treasuryAccountTaxSteps.importTreasuryAccountTax()
                            treasuryAccountTaxSteps.checkImportedEntity()
                        },
                        postExecution = { testDataScope ->
                            TreasuryAccountTaxData.cleanAtCreated()
                            Services.RKO_DICTIONARY.db.execute(
                                "INSERT INTO treasury_account_tax " +
                                        "(id, created_at, deleted_at, version, tofk, account, bank_name, bic, utra_account) " +
                                        "VALUES ${
                                            testDataScope.consumed.joinToString(separator = ",${System.lineSeparator()}") {
                                                "('${it.id}', NULL, NULL, ${it.version}, '${it.tofk}', " +
                                                        "'${it.account}', '${it.bankName}', '${it.bic}', '${it.utraAccount}')"
                                            }
                                        };"
                            )
                        }
                    ).withId(T6964::class)
                        .withTaskIds(TreasuryAccountTaxTraceabilityTasks::class)
                        .withComponent(DICTIONARY)
                        .withFolder(TreasuryAccountTaxFolderOther::class)
                        .withPriority(High)
                )
            )
        }
    }

    private fun getControlSettingsJson(controlLevel: ControlLevel): String {
        return """{
            |    "settings": {
            |        "GroupBankName": {
            |            "CheckBankNameFormat": {
            |                "level": "${controlLevel.value}"
            |            }
            |        }
            |    }
            |}""".trimMargin()
    }

    @TestFactory
    //region Test ID
    @T6892 //'Казначейский счет'. CRUD: Создаем запись от пользователя [BANK]
    @T6893 //'Казначейский счет'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T6894 //'Казначейский счет'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6895 //'Казначейский счет'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T6896 //'Казначейский счет'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6897 //'Казначейский счет'. CRUD: Обновляем запись от пользователя [BANK]
    @T6898 //'Казначейский счет'. CRUD: Удаляем запись от пользователя [BANK]
    //endregion
    internal fun treasuryAccountTaxCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TreasuryAccountTaxCreateTest(user = bankAdmin).withId(T6892::class),
                TreasuryAccountTaxGetTest(user = client).withId(T6893::class),
                TreasuryAccountTaxGetTest(user = bankAdmin).withId(T6894::class),
                TreasuryAccountTaxGetPageTest(user = client).withId(T6895::class),
                TreasuryAccountTaxGetPageTest(user = bankAdmin).withId(T6896::class),
                TreasuryAccountTaxUpdateTest(user = bankAdmin).withId(T6897::class),
                TreasuryAccountTaxDeleteTest(user = bankAdmin).withId(T6898::class)
            )
        )
    }

    @TestFactory
    //region Test ID
    @T6944 //'Казначейский счет'. Сортировка по полю 'tofk, ASC' [CLIENT]
    @T6945 //'Казначейский счет'. Сортировка по полю 'tofk, DESC' [CLIENT]
    @T6946 //'Казначейский счет'. Сортировка по полю 'account, ASC' [CLIENT]
    @T6947 //'Казначейский счет'. Сортировка по полю 'account, DESC' [CLIENT]
    @T6948 //'Казначейский счет'. Сортировка по полю 'bankName, ASC' [CLIENT]
    @T6949 //'Казначейский счет'. Сортировка по полю 'bankName, DESC' [CLIENT]
    @T6950 //'Казначейский счет'. Сортировка по полю 'bic, ASC' [CLIENT]
    @T6951 //'Казначейский счет'. Сортировка по полю 'bic, DESC' [CLIENT]
    @T6952 //'Казначейский счет'. Сортировка по полю 'utraAccount, ASC' [CLIENT]
    @T6953 //'Казначейский счет'. Сортировка по полю 'utraAccount, DESC' [CLIENT]
    //endregion
    internal fun treasuryAccountTaxSortingClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = TOFK::asc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = TOFK::desc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = ACCOUNT::asc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = ACCOUNT::desc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = BANK_NAME::asc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = BANK_NAME::desc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = BIC::asc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = BIC::desc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = UTRA_ACCOUNT::asc),
                TreasuryAccountTaxSortingTest(user = client, sortRequestFunction = UTRA_ACCOUNT::desc)
            )
        )
    }

    @TestFactory
    //region Test ID
    @T6954 //'Казначейский счет'. Сортировка по полю 'tofk, ASC' [BANK]
    @T6955 //'Казначейский счет'. Сортировка по полю 'tofk, DESC' [BANK]
    @T6956 //'Казначейский счет'. Сортировка по полю 'account, ASC' [BANK]
    @T6957 //'Казначейский счет'. Сортировка по полю 'account, DESC' [BANK]
    @T6958 //'Казначейский счет'. Сортировка по полю 'bankName, ASC' [BANK]
    @T6959 //'Казначейский счет'. Сортировка по полю 'bankName, DESC' [BANK]
    @T6960 //'Казначейский счет'. Сортировка по полю 'bic, ASC' [BANK]
    @T6961 //'Казначейский счет'. Сортировка по полю 'bic, DESC' [BANK]
    @T6962 //'Казначейский счет'. Сортировка по полю 'utraAccount, ASC' [BANK]
    @T6963 //'Казначейский счет'. Сортировка по полю 'utraAccount, DESC' [BANK]
    //endregion
    internal fun treasuryAccountTaxSortingBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = TOFK::asc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = TOFK::desc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = ACCOUNT::asc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = ACCOUNT::desc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = BANK_NAME::asc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = BANK_NAME::desc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = BIC::asc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = BIC::desc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = UTRA_ACCOUNT::asc),
                TreasuryAccountTaxSortingTest(user = bankAdmin, sortRequestFunction = UTRA_ACCOUNT::desc)
            )
        )
    }

    @TestFactory
    //region Test ID
    @T6924 //'Казначейский счет'. Фильтрация по полю 'tofk' (eq) [CLIENT]
    @T6925 //'Казначейский счет'. Фильтрация по полю 'tofk' (contains) [CLIENT]
    @T6926 //'Казначейский счет'. Фильтрация по полю 'account' (eq) [CLIENT]
    @T6927 //'Казначейский счет'. Фильтрация по полю 'account' (contains) [CLIENT]
    @T6928 //'Казначейский счет'. Фильтрация по полю 'bankName' (eq) [CLIENT]
    @T6929 //'Казначейский счет'. Фильтрация по полю 'bankName' (contains) [CLIENT]
    @T6930 //'Казначейский счет'. Фильтрация по полю 'bic' (eq) [CLIENT]
    @T6931 //'Казначейский счет'. Фильтрация по полю 'bic' (contains) [CLIENT]
    @T6932 //'Казначейский счет'. Фильтрация по полю 'utraAccount' (eq) [CLIENT]
    @T6933 //'Казначейский счет'. Фильтрация по полю 'utraAccount' (contains) [CLIENT]
    //endregion
    internal fun treasuryAccountTaxFiltrationClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TreasuryAccountTaxFiltrationTest(
                    name = "tofk equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.TOFK.eq(it!!.tofk!!) }
                ).withId(T6924::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "tofk contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.TOFK.contains(it!!.tofk!!.randomSubstringPf()) }
                ).withId(T6925::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "account equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.ACCOUNT.eq(it!!.account!!) }
                ).withId(T6926::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "account contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.ACCOUNT.contains(it!!.account!!.randomSubstringPf()) }
                ).withId(T6927::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bankName equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BANK_NAME.eq(it!!.bankName!!) }
                ).withId(T6928::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bankName contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BANK_NAME.contains(it!!.bankName!!.randomSubstringPf()) }
                ).withId(T6929::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bic equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BIC.eq(it!!.bic!!) }
                ).withId(T6930::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bic contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BIC.contains(it!!.bic!!.randomSubstringPf()) }
                ).withId(T6931::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "utraAccount equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.UTRA_ACCOUNT.eq(it!!.utraAccount!!) }
                ).withId(T6932::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "utraAccount contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.UTRA_ACCOUNT.contains(it!!.utraAccount!!.randomSubstringPf()) }
                ).withId(T6933::class)
            )
        )
    }

    @TestFactory
    //region Test ID
    @T6934 //'Казначейский счет'. Фильтрация по полю 'tofk' (eq) [BANK]
    @T6935 //'Казначейский счет'. Фильтрация по полю 'tofk' (contains) [BANK]
    @T6936 //'Казначейский счет'. Фильтрация по полю 'account' (eq) [BANK]
    @T6937 //'Казначейский счет'. Фильтрация по полю 'account' (contains) [BANK]
    @T6938 //'Казначейский счет'. Фильтрация по полю 'bankName' (eq) [BANK]
    @T6939 //'Казначейский счет'. Фильтрация по полю 'bankName' (contains) [BANK]
    @T6940 //'Казначейский счет'. Фильтрация по полю 'bic' (eq) [BANK]
    @T6941 //'Казначейский счет'. Фильтрация по полю 'bic' (contains) [BANK]
    @T6942 //'Казначейский счет'. Фильтрация по полю 'utraAccount' (eq) [BANK]
    @T6943 //'Казначейский счет'. Фильтрация по полю 'utraAccount' (contains) [BANK]
    //endregion
    internal fun treasuryAccountTaxFiltrationBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TreasuryAccountTaxFiltrationTest(
                    name = "tofk equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.TOFK.eq(it!!.tofk!!) }
                ).withId(T6934::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "tofk contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.TOFK.contains(it!!.tofk!!.randomSubstringPf()) }
                ).withId(T6935::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "account equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.ACCOUNT.eq(it!!.account!!) }
                ).withId(T6936::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "account contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.ACCOUNT.contains(it!!.account!!.randomSubstringPf()) }
                ).withId(T6937::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bankName equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BANK_NAME.eq(it!!.bankName!!) }
                ).withId(T6938::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bankName contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BANK_NAME.contains(it!!.bankName!!.randomSubstringPf()) }
                ).withId(T6939::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bic equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BIC.eq(it!!.bic!!) }
                ).withId(T6940::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "bic contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.BIC.contains(it!!.bic!!.randomSubstringPf()) }
                ).withId(T6941::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "utraAccount equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.UTRA_ACCOUNT.eq(it!!.utraAccount!!) }
                ).withId(T6942::class),
                TreasuryAccountTaxFiltrationTest(
                    name = "utraAccount contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TreasuryAccountTaxFilterParams.UTRA_ACCOUNT.contains(it!!.utraAccount!!.randomSubstringPf()) }
                ).withId(T6943::class)
            )
        )
    }

    @TestFactory
    //region Test ID
    @T6899 //'Казначейский счет'. Контроль: длины ТОФК [BANK]
    @T6900 //'Казначейский счет'. Контроль: ТОФК на допустимые символы [BANK]
    @T6901 //'Казначейский счет'. Контроль: длины казначейского счета [BANK]
    @T6902 //'Казначейский счет'. Контроль: казначейского счета на допустимые символы [BANK]
    @T6903 //'Казначейский счет'. Контроль: валюты казначейского счета [BANK]
    @T6904 //'Казначейский счет'. Контроль: казначейского счета на соответствие плану счетов [BANK]
    @T6905 //'Казначейский счет'. Контроль: длины наименования банка [BANK]
    @T6906 //'Казначейский счет'. Контроль: наименования банка на допустимые символы [BANK]
    @T6907 //'Казначейский счет'. Контроль: длины БИК [BANK]
    @T6908 //'Казначейский счет'. Контроль: БИК на допустимые символы [BANK]
    @T6909 //'Казначейский счет'. Контроль: счета, входящего в ЕКС на непустоту (null) [BANK]
    @T6910 //'Казначейский счет'. Контроль: счета, входящего в ЕКС на непустоту (пустая строка) [BANK]
    @T6911 //'Казначейский счет'. Контроль: счета, входящего в ЕКС на непустоту (пробельные символы) [BANK]
    @T6912 //'Казначейский счет'. Контроль: длины счета, входящего в ЕКС [BANK]
    @T6913 //'Казначейский счет'. Контроль: счета, входящего в ЕКС, на допустимые символы [BANK]
    @T6914 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (БИК) [BANK]
    @T6915 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (Счет участника) [BANK]
    @T6916 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (Тип счета) [BANK]
    @T6917 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (Статус счета) [BANK]
    @T6918 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (Наименование банка содержит Наименование БИК РФ) [BANK]
    @T6919 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (Наименование банка содержит Наименование типа населенного пункта) [BANK]
    @T6920 //'Казначейский счет'. Контроль: реквизитов на соответствие БИК РФ (Наименование банка содержит Наименование населенного пункта) [BANK]
    @T6921 //'Казначейский счет'. Контроль: формата наименования банка (отсутствие разделителя //) [BANK]
    @T6922 //Контроль формата наименования банка отключен по умолчанию
    @T6923 //Подстрока // в Наименовании структурного подразделения ЦБ РФ
    //endregion
    internal fun treasuryAccountTaxControlTests(): List<DynamicTest> {
        val invalidCharsValue = RandomData.invalidChars.random(length = 9, prefix = AT_PREFIX_RUS)
        val invalidAccount = RandomData.invalidChars.random(length = 20, prefix = ACCOUNT_PREFIX)
        val invalidUtraAccountValue = RandomData.latinWord.random(length = 20)
        val russianAlphabet = RandomData.builder().withRussianAlphabet().build()

        return EntityTestGenerator.generate(
            listOf(

                TreasuryAccountTaxControlTest(
                    testName = "длины ТОФК",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { tofk += RandomData.allAllowedChars.random(length = 1) }
                    },
                    control = TOFK_LENGTH.withParams("length" to "160")
                ).withId(T6899::class),

                TreasuryAccountTaxControlTest(
                    testName = "ТОФК на допустимые символы",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { tofk = invalidCharsValue }
                    },
                    control = TOFK_ALLOWED_SYMBOLS.withParams(
                        "symbols" to getForbiddenSymbolsMessage(
                            forbiddenSymbols = invalidCharsValue,
                            exclusions = AT_PREFIX_RUS
                        )
                    )
                ).withId(T6900::class),

                TreasuryAccountTaxControlTest(
                    testName = "длины казначейского счета",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { account += RandomData.digits.random(length = 1) }
                    },
                    control = ACCOUNT_LENGTH.withParams("length" to "20")
                ).withId(T6901::class),

                TreasuryAccountTaxControlTest(
                    testName = "казначейского счета на допустимые символы",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { account = invalidAccount }
                    },
                    control = ACCOUNT_ALLOWED_SYMBOLS.withParams(
                        "symbols" to getForbiddenSymbolsMessage(
                            forbiddenSymbols = invalidAccount,
                            exclusions = ACCOUNT_PREFIX
                        )
                    )
                ).withId(T6902::class),

                TreasuryAccountTaxControlTest(
                    testName = "валюты казначейского счета",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply {
                                account = RandomData.digits.random(
                                    length = 20,
                                    prefix = TreasuryAccountTaxPrepareSteps.ACCOUNT_CODE + "000"
                                )
                            }
                    },
                    control = ACCOUNT_CURRENCY_CODE.withParams(
                        "values" to ACCOUNT_CURRENCY,
                        "position" to "6"
                    )
                ).withId(T6903::class),

                TreasuryAccountTaxControlTest(
                    testName = "казначейского счета на соответствие плану счетов",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply {
                                account = RandomData.digits.random(
                                    length = 20,
                                    prefix = "00000$ACCOUNT_CURRENCY"
                                )
                            }
                    },
                    control = ACCOUNT_CODE.withParams(
                        "values" to TreasuryAccountTaxPrepareSteps.ACCOUNT_CODE,
                        "position" to "1"
                    )
                ).withId(T6904::class),

                TreasuryAccountTaxControlTest(
                    testName = "длины наименования банка",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { bankName += RandomData.allAllowedChars.random(length = 1) }
                    },
                    control = BANK_NAME_LENGTH.withParams("length" to "140")
                ).withId(T6905::class),

                TreasuryAccountTaxControlTest(
                    testName = "наименования банка на допустимые символы",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { bankName = invalidCharsValue }
                    },
                    control = BANK_NAME_ALLOWED_SYMBOLS.withParams(
                        "symbols" to getForbiddenSymbolsMessage(
                            forbiddenSymbols = invalidCharsValue,
                            exclusions = AT_PREFIX_RUS
                        )
                    )
                ).withId(T6906::class),

                TreasuryAccountTaxControlUnitBeTest(
                    name = "Контроль формата наименования банка отключен по умолчанию",
                    testBody = {
                        val defaultLevelPath =
                            "$..[?(@.name == 'GroupBankName')]..[?(@.name == 'CheckBankNameFormat')]..[?(@.name == 'level')].defaultValue"
                        val actualControlLevel = ControlLevel.findByValue(
                            treasuryAccountTaxSteps.getControlSettingsDescription().read<List<String>>(defaultLevelPath)[0]
                        )
                        checkDefaultControlLevel("Контроль формата наименования банка не отключен по умолчанию", actualControlLevel, OFF)
                    }
                ).withId(T6922::class),

                TreasuryAccountTaxControlTest(
                    testName = "формата наименования банка (отсутствие разделителя //)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { bankName = bankName!!.replace("//", " ") }
                    },
                    control = BANK_NAME_FORMAT
                ).withId(T6921::class),

                TreasuryAccountTaxControlUnitBeTest(
                    name = "Подстрока // в Наименовании структурного подразделения ЦБ РФ",
                    testBody = {
                        val createDto = getTreasuryAccountTaxDtoForCreate()
                            .apply {
                                val bankNamePrefix = bankName!!.substring(startIndex = 0, endIndex = bankName!!.lastIndexOf("//"))
                                bankName = bankName!!.replaceFirst(bankNamePrefix, "ы//s")
                            }
                        checkValidationResult(
                            actualValidationResult = treasuryAccountTaxSteps.create(createDto).validationResult!!.result!!.name,
                            expectedValidationResult = "VALID"
                        )
                    }
                ).withId(T6923::class),

                TreasuryAccountTaxControlTest(
                    testName = "длины БИК",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { bic += RandomData.digits.random(length = 1) }
                    },
                    control = BIC_LENGTH.withParams("length" to "9")
                ).withId(T6907::class),

                TreasuryAccountTaxControlTest(
                    testName = "БИК на допустимые символы",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { bic = invalidCharsValue }
                    },
                    control = BIC_ALLOWED_SYMBOLS
                        .withParams("symbols" to getForbiddenSymbolsMessage(invalidCharsValue))
                ).withId(T6908::class),

                TreasuryAccountTaxControlTest(
                    testName = "счета, входящего в ЕКС на непустоту (null)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { utraAccount = null }
                    },
                    control = UTRA_ACCOUNT_EMPTY
                ).withId(T6909::class),

                TreasuryAccountTaxControlTest(
                    testName = "счета, входящего в ЕКС на непустоту (пустая строка)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { utraAccount = "" }
                    },
                    control = UTRA_ACCOUNT_EMPTY
                ).withId(T6910::class),

                TreasuryAccountTaxControlTest(
                    testName = "счета, входящего в ЕКС на непустоту (пробельные символы)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { utraAccount = RandomData.getEmptyString(length = 5) }
                    },
                    control = UTRA_ACCOUNT_EMPTY
                ).withId(T6911::class),

                TreasuryAccountTaxControlTest(
                    testName = "длины счета, входящего в ЕКС",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { utraAccount += RandomData.digits.random(length = 1) }
                    },
                    control = UTRA_ACCOUNT_LENGTH.withParams("length" to "20")
                ).withId(T6912::class),

                TreasuryAccountTaxControlTest(
                    testName = "счета, входящего в ЕКС, на допустимые символы",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { utraAccount = invalidUtraAccountValue }
                    },
                    control = UTRA_ACCOUNT_ALLOWED_SYMBOLS
                        .withParams("symbols" to getForbiddenSymbolsMessage(invalidUtraAccountValue))
                ).withId(T6913::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (БИК)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply { bic = "000000000" }
                    },
                    control = COMMON_BIC
                ).withId(T6914::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (Счет участника)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate(utraAccount = RandomData.digits.random(length = 20))
                    },
                    control = COMMON_ACCOUNT
                ).withId(T6915::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (Тип счета)",
                    preExecution = {
                        val utraAccount = createBankBicAccount(accountType = CBRA)
                        getTreasuryAccountTaxDtoForCreate(utraAccount = utraAccount.account)
                    },
                    control = COMMON_ACCOUNT_TYPE
                ).withId(T6916::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (Статус счета)",
                    preExecution = {
                        val utraAccount = createBankBicAccount(status = DELETED)
                        getTreasuryAccountTaxDtoForCreate(utraAccount = utraAccount.account)
                    },
                    control = COMMON_ACCOUNT_STATUS
                ).withId(T6917::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (Наименование банка содержит Наименование БИК РФ)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply {
                                val bankBicName = TreasuryAccountTaxPrepareSteps.bankBic.name
                                bankName = bankName!!.replaceFirst(
                                    oldValue = bankBicName,
                                    newValue = russianAlphabet.random(length = bankBicName.length)
                                )
                            }
                    },
                    control = COMMON_BANK_NAME
                ).withId(T6918::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (Наименование банка содержит Наименование типа населенного пункта)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply {
                                val bankBic = TreasuryAccountTaxPrepareSteps.bankBic
                                bankName = bankName!!.replaceFirst(
                                    oldValue = bankBic.name + " " + bankBic.locationType!!,
                                    newValue = "${bankBic.name} ъ"
                                )
                            }
                    },
                    control = COMMON_BANK_NAME
                ).withId(T6919::class),

                TreasuryAccountTaxControlTest(
                    testName = "реквизитов на соответствие БИК РФ (Наименование банка содержит Наименование населенного пункта)",
                    preExecution = {
                        getTreasuryAccountTaxDtoForCreate()
                            .apply {
                                val location = TreasuryAccountTaxPrepareSteps.bankBic.location!!
                                bankName = bankName!!.replaceFirst(
                                    oldValue = location,
                                    newValue = russianAlphabet.random(length = location.length)
                                )
                            }
                    },
                    control = COMMON_BANK_NAME
                ).withId(T6920::class)
            )
        )
    }

    @TestFactory
    @T6891 //'Казначейский счет'. Наполнение
    internal fun treasuryAccountTaxDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UnitBeTest(
                    name = "'${DictionaryNames.TREASURY_ACCOUNT_TAX}'. Наполнение",
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.bankName == expectedEntity.bankName }
                                TreasuryAccountTaxSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Казначейский счет со следующим наименование банка не найден: '${expectedEntity.bankName}'")
                            }
                        }
                    }
                ).withId(T6891::class)
                    .withTaskIds(TreasuryAccountTaxTraceabilityTasks::class)
                    .withComponent(DICTIONARY)
                    .withFolder(TreasuryAccountTaxFolderDefaults::class)
                    .withPriority(High)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<TreasuryAccountTax> {
        return listOf(
            TreasuryAccountTax(
                tofk = "Межрегиональное операционное управление Федерального казначейства",
                account = "03100643000000019500",
                bankName = "ОПЕРАЦИОННЫЙ ДЕПАРТАМЕНТ БАНКА РОССИИ//Межрегиональное операционное управление Федерального казначейства г. Москва",
                bic = "024501901",
                utraAccount = "40102810045370000002"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Алтайскому краю",
                account = "03100643000000011700",
                bankName = "ОТДЕЛЕНИЕ БАРНАУЛ БАНКА РОССИИ//УФК по Алтайскому краю г. Барнаул",
                bic = "010173001",
                utraAccount = "40102810045370000009"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Амурской области",
                account = "03100643000000012300",
                bankName = "ОТДЕЛЕНИЕ БЛАГОВЕЩЕНСК БАНКА РОССИИ//УФК по Амурской области г. Благовещенск",
                bic = "011012100",
                utraAccount = "40102810245370000015"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Архангельской области и Ненецкому автономному округу (Архангельская область)",
                account = "03100643000000012400",
                bankName = "ОТДЕЛЕНИЕ АРХАНГЕЛЬСК БАНКА РОССИИ//УФК по Архангельской области и Ненецкому автономному округу г. Архангельск",
                bic = "011117401",
                utraAccount = "40102810045370000016"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Астраханской области",
                account = "03100643000000012500",
                bankName = "ОТДЕЛЕНИЕ АСТРАХАНЬ БАНКА РОССИИ//УФК по Астраханской области г. Астрахань",
                bic = "011203901",
                utraAccount = "40102810445370000017"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Белгородской области",
                account = "03100643000000012600",
                bankName = "ОТДЕЛЕНИЕ БЕЛГОРОД БАНКА РОССИИ//УФК по Белгородской области г. Белгород",
                bic = "011403102",
                utraAccount = "40102810745370000018"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Брянской области",
                account = "03100643000000012700",
                bankName = "ОТДЕЛЕНИЕ БРЯНСК БАНКА РОССИИ//УФК по Брянской области г. Брянск",
                bic = "011501101",
                utraAccount = "40102810245370000019"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Владимирской области",
                account = "03100643000000012800",
                bankName = "ОТДЕЛЕНИЕ ВЛАДИМИР БАНКА РОССИИ//УФК по Владимирской области г. Владимир",
                bic = "011708377",
                utraAccount = "40102810945370000020"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Волгоградской области",
                account = "03100643000000012900",
                bankName = "ОТДЕЛЕНИЕ ВОЛГОГРАД БАНКА РОССИИ//УФК по Волгоградской области г. Волгоград",
                bic = "011806101",
                utraAccount = "40102810445370000021"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Вологодской области",
                account = "03100643000000013000",
                bankName = "ОТДЕЛЕНИЕ ВОЛОГДА БАНКА РОССИИ//УФК по Вологодской области г. Вологда",
                bic = "011909101",
                utraAccount = "40102810445370000022"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Воронежской области",
                account = "03100643000000013100",
                bankName = "ОТДЕЛЕНИЕ ВОРОНЕЖ БАНКА РОССИИ//УФК по Воронежской области г. Воронеж",
                bic = "012007084",
                utraAccount = "40102810945370000023"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по г. Москве",
                account = "03100643000000017300",
                bankName = "ГУ БАНКА РОССИИ ПО ЦФО//УФК ПО Г. МОСКВЕ г. Москва",
                bic = "004525988",
                utraAccount = "40102810545370000003"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по г. Санкт-Петербургу",
                account = "03100643000000017200",
                bankName = "СЕВЕРО-ЗАПАДНОЕ ГУ БАНКА РОССИИ//УФК по г.Санкт-Петербургу г. Санкт-Петербург",
                bic = "014030106",
                utraAccount = "40102810945370000005"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по г. Севастополю",
                account = "03100643000000017400",
                bankName = "ОТДЕЛЕНИЕ СЕВАСТОПОЛЬ БАНКА РОССИИ//УФК по г. Севастополю г. Севастополь",
                bic = "016711001",
                utraAccount = "40102810045370000056"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Еврейской автономной области",
                account = "03100643000000017800",
                bankName = "ОТДЕЛЕНИЕ БИРОБИДЖАН БАНКА РОССИИ//УФК по Еврейской автономной области г. Биробиджан",
                bic = "019923923",
                utraAccount = "40102810445370000086"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Забайкальскому краю",
                account = "03100643000000019100",
                bankName = "ОТДЕЛЕНИЕ ЧИТА БАНКА РОССИИ//УФК по Забайкальскому краю г. Чита",
                bic = "017601329",
                utraAccount = "40102810945370000063"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ивановской области",
                account = "03100643000000013300",
                bankName = "ОТДЕЛЕНИЕ ИВАНОВО БАНКА РОССИИ//УФК ПО ИВАНОВСКОЙ ОБЛАСТИ г. Иваново",
                bic = "012406500",
                utraAccount = "40102810645370000025"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Иркутской области",
                account = "03100643000000013400",
                bankName = "ОТДЕЛЕНИЕ ИРКУТСК БАНКА РОССИИ//УФК ПО ИРКУТСКОЙ ОБЛАСТИ г. Иркутск",
                bic = "012520101",
                utraAccount = "40102810145370000026"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Кабардино-Балкарской Республике",
                account = "03100643000000010400",
                bankName = "ОТДЕЛЕНИЕ-НБ КАБАРДИНО-БАЛКАРСКАЯ РЕСПУБЛИКА БАНКА РОССИИ//УФК по Кабардино-Балкарской Республике г. Нальчик",
                bic = "018327106",
                utraAccount = "40102810145370000070"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Калининградской области",
                account = "03100643000000013500",
                bankName = "ОТДЕЛЕНИЕ КАЛИНИНГРАД БАНКА РОССИИ//УФК по Калининградской области г. Калининград",
                bic = "012748051",
                utraAccount = "40102810545370000028"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Калужской области",
                account = "03100643000000013700",
                bankName = "ОТДЕЛЕНИЕ КАЛУГА БАНКА РОССИИ//УФК по Калужской области г. Калуга",
                bic = "012908002",
                utraAccount = "40102810045370000030"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Камчатскому краю",
                account = "03100643000000013800",
                bankName = "ОТДЕЛЕНИЕ ПЕТРОПАВЛОВСК-КАМЧАТСКИЙ БАНКА РОССИИ//УФК по Камчатскому краю г. Петропавловск-Камчатский",
                bic = "013002402",
                utraAccount = "40102810945370000031"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Карачаево-Черкесской Республике",
                account = "03100643000000017900",
                bankName = "ОТДЕЛЕНИЕ-НБ КАРАЧАЕВО-ЧЕРКЕССКАЯ РЕСПУБЛИКА БАНКА РОССИИ//УФК по Карачаево-Черкесской Республике г. Черкесск",
                bic = "019133001",
                utraAccount = "40102810245370000078"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Кемеровской области - Кузбассу",
                account = "03100643000000013900",
                bankName = "ОТДЕЛЕНИЕ КЕМЕРОВО БАНКА РОССИИ//УФК по Кемеровской области - Кузбассу г. Кемерово",
                bic = "013207212",
                utraAccount = "40102810745370000032"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Кировской области",
                account = "03100643000000014000",
                bankName = "ОТДЕЛЕНИЕ КИРОВ БАНКА РОССИИ//УФК по Кировской области г. Киров",
                bic = "013304182",
                utraAccount = "40102810345370000033"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Костромской области",
                account = "03100643000000014100",
                bankName = "ОТДЕЛЕНИЕ КОСТРОМА БАНКА РОССИИ//УФК ПО КОСТРОМСКОЙ ОБЛАСТИ г. Кострома",
                bic = "013469126",
                utraAccount = "40102810945370000034"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Краснодарскому краю",
                account = "03100643000000011800",
                bankName = "ЮЖНОЕ ГУ БАНКА РОССИИ//УФК по Краснодарскому краю г. Краснодар",
                bic = "010349101",
                utraAccount = "40102810945370000010"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Красноярскому краю",
                account = "03100643000000011900",
                bankName = "ОТДЕЛЕНИЕ КРАСНОЯРСК  БАНКА РОССИИ//УФК по Красноярскому краю г. Красноярск",
                bic = "010407105",
                utraAccount = "40102810245370000011"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Курганской области",
                account = "03100643000000014300",
                bankName = "ОТДЕЛЕНИЕ КУРГАН  БАНКА РОССИИ//УФК по Курганской области г. Курган",
                bic = "013735150",
                utraAccount = "40102810345370000037"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Курской области",
                account = "03100643000000014400",
                bankName = "ОТДЕЛЕНИЕ КУРСК БАНКА РОССИИ//УФК ПО КУРСКОЙ ОБЛАСТИ г. Курск",
                bic = "013807906",
                utraAccount = "40102810545370000038"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ленинградской области",
                account = "03100643000000014500",
                bankName = "ОТДЕЛЕНИЕ ЛЕНИНГРАДСКОЕ  БАНКА РОССИИ//УФК по Ленинградской области г. Санкт-Петербург",
                bic = "014106101",
                utraAccount = "40102810745370000006"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Липецкой области",
                account = "03100643000000014600",
                bankName = "ОТДЕЛЕНИЕ ЛИПЕЦК БАНКА РОССИИ//УФК ПО ЛИПЕЦКОЙ ОБЛАСТИ г. Липецк",
                bic = "014206212",
                utraAccount = "40102810945370000039"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Магаданской области",
                account = "03100643000000014700",
                bankName = "ОТДЕЛЕНИЕ МАГАДАН БАНКА РОССИИ//УФК по Магаданской области г. Магадан",
                bic = "014442501",
                utraAccount = "40102810945370000040"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Московской области",
                account = "03100643000000014800",
                bankName = "ГУ БАНКА РОССИИ ПО ЦФО//УФК ПО МОСКОВСКОЙ ОБЛАСТИ г. Москва",
                bic = "004525987",
                utraAccount = "40102810845370000004"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Мурманской области",
                account = "03100643000000014900",
                bankName = "ОТДЕЛЕНИЕ МУРМАНСК БАНКА РОССИИ//УФК по Мурманской области г. Мурманск",
                bic = "014705901",
                utraAccount = "40102810745370000041"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Нижегородской области",
                account = "03100643000000013200",
                bankName = "ВОЛГО-ВЯТСКОЕ ГУ БАНКА РОССИИ//УФК по Нижегородской области г. Нижний Новгород",
                bic = "012202102",
                utraAccount = "40102810745370000024"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Новгородской области",
                account = "03100643000000015000",
                bankName = "ОТДЕЛЕНИЕ НОВГОРОД БАНКА РОССИИ//УФК ПО НОВГОРОДСКОЙ ОБЛАСТИ г. Великий Новгород",
                bic = "014959900",
                utraAccount = "40102810145370000042"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Новосибирской области",
                account = "03100643000000015100",
                bankName = "СИБИРСКОЕ ГУ БАНКА РОССИИ//УФК по Новосибирской области г. Новосибирск",
                bic = "015004950",
                utraAccount = "40102810445370000043"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Омской области",
                account = "03100643000000015200",
                bankName = "ОТДЕЛЕНИЕ ОМСК БАНКА РОССИИ//УФК по Омской области г. Омск",
                bic = "015209001",
                utraAccount = "40102810245370000044"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Оренбургской области",
                account = "03100643000000015300",
                bankName = "ОТДЕЛЕНИЕ ОРЕНБУРГ БАНКА РОССИИ//УФК по Оренбургской области г. Оренбург",
                bic = "015354008",
                utraAccount = "40102810545370000045"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Орловской области",
                account = "03100643000000015400",
                bankName = "ОТДЕЛЕНИЕ ОРЕЛ БАНКА РОССИИ//УФК по Орловской области г. Орел",
                bic = "015402901",
                utraAccount = "40102810545370000046"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Пензенской области",
                account = "03100643000000015500",
                bankName = "ОТДЕЛЕНИЕ ПЕНЗА БАНКА РОССИИ//УФК по Пензенской области г. Пенза",
                bic = "015655003",
                utraAccount = "40102810045370000047"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Пермскому краю",
                account = "03100643000000015600",
                bankName = "ОТДЕЛЕНИЕ ПЕРМЬ БАНКА РОССИИ//УФК по Пермскому краю г. Пермь",
                bic = "015773997",
                utraAccount = "40102810145370000048"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Приморскому краю",
                account = "03100643000000012000",
                bankName = "ДАЛЬНЕВОСТОЧНОЕ ГУ БАНКА РОССИИ//УФК по Приморскому краю г. Владивосток",
                bic = "010507002",
                utraAccount = "40102810545370000012"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Псковской области",
                account = "03100643000000015700",
                bankName = "ОТДЕЛЕНИЕ ПСКОВ  БАНКА РОССИИ//УФК по Псковской области г. Псков",
                bic = "015805002",
                utraAccount = "40102810145370000049"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Адыгея (Адыгея)",
                account = "03100643000000017600",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА АДЫГЕЯ  БАНКА РОССИИ//УФК по Республике Адыгея г. Майкоп",
                bic = "017908101",
                utraAccount = "40102810145370000066"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Алтай",
                account = "03100643000000017700",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА АЛТАЙ//УФК  по Республике Алтай г. Горно-Алтайск",
                bic = "018405033",
                utraAccount = "40102810045370000071"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Башкортостан",
                account = "03100643000000010100",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА БАШКОРТОСТАН  БАНКА РОССИИ//УФК по Республике Башкортостан г. Уфа",
                bic = "018073401",
                utraAccount = "40102810045370000067"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Бурятия",
                account = "03100643000000010200",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА БУРЯТИЯ  БАНКА РОССИИ//УФК по Республике Бурятия г. Улан-Удэ",
                bic = "018142016",
                utraAccount = "40102810545370000068"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Дагестан",
                account = "03100643000000010300",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА ДАГЕСТАН  БАНКА РОССИИ//УФК по Республике Дагестан г. Махачкала",
                bic = "018209001",
                utraAccount = "40102810945370000069"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Ингушетия",
                account = "03100643000000011400",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА ИНГУШЕТИЯ  БАНКА РОССИИ//УФК по Республике Ингушетия г. Магас",
                bic = "012618001",
                utraAccount = "40102810345370000027"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Калмыкия",
                account = "03100643000000010500",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА КАЛМЫКИЯ  БАНКА РОССИИ//УФК по Республике Калмыкия г. Элиста",
                bic = "018580010",
                utraAccount = "40102810245370000072"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Карелия",
                account = "03100643000000010600",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА КАРЕЛИЯ  БАНКА РОССИИ//УФК по Республике Карелия г. Петрозаводск",
                bic = "018602104",
                utraAccount = "40102810945370000073"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Коми",
                account = "03100643000000010700",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА КОМИ  БАНКА РОССИИ//УФК по Республике Коми г. Сыктывкар",
                bic = "018702501",
                utraAccount = "40102810245370000074"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Крым",
                account = "03100643000000017500",
                bankName = "ОТДЕЛЕНИЕ РЕСПУБЛИКА КРЫМ  БАНКА РОССИИ//УФК по Республике Крым г. Симферополь",
                bic = "013510002",
                utraAccount = "40102810645370000035"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Марий Эл",
                account = "03100643000000010800",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА МАРИЙ ЭЛ  БАНКА РОССИИ//УФК по Республике Марий Эл г. Йошкар-Ола",
                bic = "018860003",
                utraAccount = "40102810545370000075"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Мордовия",
                account = "03100643000000010900",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА МОРДОВИЯ  БАНКА РОССИИ//УФК по Республике Мордовия г. Саранск",
                bic = "018952501",
                utraAccount = "40102810345370000076"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Саха (Якутия)",
                account = "03100643000000011600",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА САХА (ЯКУТИЯ)  БАНКА РОССИИ// УФК по Республике Саха (Якутия) г. Якутск ",
                bic = "019805001",
                utraAccount = "40102810345370000085"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Северная Осетия - Алания",
                account = "03100643000000011000",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСП. СЕВЕРНАЯ ОСЕТИЯ-АЛАНИЯ  БАНКА РОССИИ//УФК по Республике Северная Осетия - Алания г. Владикавказ",
                bic = "019033100",
                utraAccount = "40102810945370000077"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Татарстан",
                account = "03100643000000011100",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА ТАТАРСТАН  БАНКА РОССИИ//УФК по Республике Татарстан г. Казань",
                bic = "019205400",
                utraAccount = "40102810445370000079"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Тыва",
                account = "03100643000000011200",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА ТЫВА БАНКА РОССИИ//УФК по РЕСПУБЛИКЕ ТЫВА г. Кызыл",
                bic = "019304100",
                utraAccount = "40102810945370000080"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Республике Хакасия",
                account = "03100643000000018000",
                bankName = "ОТДЕЛЕНИЕ-НБ РЕСПУБЛИКА ХАКАСИЯ БАНКА РОССИИ//УФК по Республике Хакасия г. Абакан",
                bic = "019514901",
                utraAccount = "40102810845370000082"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ростовской области",
                account = "03100643000000015800",
                bankName = "ОТДЕЛЕНИЕ РОСТОВ-НА-ДОНУ БАНКА РОССИИ//УФК по Ростовской области г. Ростов-на-Дону",
                bic = "016015102",
                utraAccount = "40102810845370000050"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Рязанской области",
                account = "03100643000000015900",
                bankName = "ОТДЕЛЕНИЕ РЯЗАНЬ БАНКА РОССИИ//УФК по Рязанской области г. Рязань",
                bic = "016126031",
                utraAccount = "40102810345370000051"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Самарской области",
                account = "03100643000000014200",
                bankName = "ОТДЕЛЕНИЕ САМАРА БАНКА РОССИИ//УФК по Самарской области г. Самара",
                bic = "013601205",
                utraAccount = "40102810545370000036"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Саратовской области",
                account = "03100643000000016000",
                bankName = "ОТДЕЛЕНИЕ САРАТОВ БАНКА РОССИИ//УФК по Саратовской области г. Саратов",
                bic = "016311121",
                utraAccount = "40102810845370000052"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Сахалинской области",
                account = "03100643000000016100",
                bankName = "ОТДЕЛЕНИЕ ЮЖНО-САХАЛИНСК БАНКА РОССИИ//УФК по Сахалинской области г. Южно-Сахалинск",
                bic = "016401800",
                utraAccount = "40102810845370000053"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Свердловской области",
                account = "03100643000000016200",
                bankName = "УРАЛЬСКОЕ ГУ БАНКА РОССИИ//УФК по Свердловской области г. Екатеринбург",
                bic = "016577551",
                utraAccount = "40102810645370000054"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Смоленской области",
                account = "03100643000000016300",
                bankName = "ОТДЕЛЕНИЕ СМОЛЕНСК БАНКА РОССИИ//УФК по Смоленской области г. Смоленск",
                bic = "016614901",
                utraAccount = "40102810445370000055"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ставропольскому краю",
                account = "03100643000000012100",
                bankName = "ОТДЕЛЕНИЕ СТАВРОПОЛЬ БАНКА РОССИИ//УФК по Ставропольскому краю г. Ставрополь",
                bic = "010702101",
                utraAccount = "40102810345370000013"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Тамбовской области",
                account = "03100643000000016400",
                bankName = "ОТДЕЛЕНИЕ ТАМБОВ БАНКА РОССИИ//УФК по Тамбовской области г. Тамбов",
                bic = "016850200",
                utraAccount = "40102810645370000057"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Тверской области",
                account = "03100643000000013600",
                bankName = "ОТДЕЛЕНИЕ ТВЕРЬ БАНКА РОССИИ//УФК по Тверской области г. Тверь",
                bic = "012809106",
                utraAccount = "40102810545370000029"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Томской области",
                account = "03100643000000016500",
                bankName = "ОТДЕЛЕНИЕ ТОМСК БАНКА РОССИИ//УФК по Томской области г. Томск",
                bic = "016902004",
                utraAccount = "40102810245370000058"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Тульской области",
                account = "03100643000000016600",
                bankName = "ОТДЕЛЕНИЕ ТУЛА БАНКА РОССИИ//УФК по Тульской области г. Тула",
                bic = "017003983",
                utraAccount = "40102810445370000059"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Тюменской области",
                account = "03100643000000016700",
                bankName = "ОТДЕЛЕНИЕ ТЮМЕНЬ БАНКА РОССИИ//УФК по Тюменской области г. Тюмень",
                bic = "017102101",
                utraAccount = "40102810945370000060"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Удмуртской Республике",
                account = "03100643000000011300",
                bankName = "ОТДЕЛЕНИЕ-НБ УДМУРТСКАЯ РЕСПУБЛИКА БАНКА РОССИИ//УФК по Удмуртской Республике г. Ижевск",
                bic = "019401100",
                utraAccount = "40102810545370000081"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ульяновской области",
                account = "03100643000000016800",
                bankName = "ОТДЕЛЕНИЕ УЛЬЯНОВСК БАНКА РОССИИ//УФК по Ульяновской области г. Ульяновск",
                bic = "017308101",
                utraAccount = "40102810645370000061"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Хабаровскому краю",
                account = "03100643000000012200",
                bankName = "ОТДЕЛЕНИЕ ХАБАРОВСК БАНКА РОССИИ//УФК по Хабаровскому краю г. Хабаровск",
                bic = "010813050",
                utraAccount = "40102810845370000014"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ханты-Мансийскому автономному округу - Югре",
                account = "03100643000000018700",
                bankName = "РКЦ ХАНТЫ-МАНСИЙСК//УФК по Ханты-Мансийскому автономному округу-Югре г. Ханты-Мансийск",
                bic = "007162163",
                utraAccount = "40102810245370000007"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Челябинской области",
                account = "03100643000000016900",
                bankName = "ОТДЕЛЕНИЕ ЧЕЛЯБИНСК БАНКА РОССИИ//УФК по Челябинской области г. Челябинск",
                bic = "017501500",
                utraAccount = "40102810645370000062"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Чеченской Республике",
                account = "03100643000000019400",
                bankName = "ОТДЕЛЕНИЕ-НБ ЧЕЧЕНСКАЯ РЕСПУБЛИКА БАНКА РОССИИ//УФК по Чеченской Республике г. Грозный",
                bic = "019690001",
                utraAccount = "40102810945370000083"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Чувашской Республике",
                account = "03100643000000011500",
                bankName = "ОТДЕЛЕНИЕ-НБ ЧУВАШСКАЯ РЕСПУБЛИКА БАНКА РОССИИ//УФК по Чувашской Республике г. Чебоксары",
                bic = "019706900",
                utraAccount = "40102810945370000084"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Чукотскому автономному округу",
                account = "03100643000000018800",
                bankName = "ОТДЕЛЕНИЕ АНАДЫРЬ БАНКА РОССИИ//УФК ПО ЧУКОТСКОМУ АВТОНОМНОМУ ОКРУГУ г. Анадырь",
                bic = "017719101",
                utraAccount = "40102810745370000064"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ямало-Ненецкому автономному округу",
                account = "03100643000000019000",
                bankName = "РКЦ САЛЕХАРД//УФК  ПО ЯМАЛО-НЕНЕЦКОМУ АВТОНОМНОМУ ОКРУГУ г. Салехард",
                bic = "007182108",
                utraAccount = "40102810145370000008"
            ),
            TreasuryAccountTax(
                tofk = "Управление Федерального казначейства по Ярославской области",
                account = "03100643000000017100",
                bankName = "ОТДЕЛЕНИЕ ЯРОСЛАВЛЬ БАНКА РОССИИ//УФК по Ярославской области г. Ярославль",
                bic = "017888102",
                utraAccount = "40102810245370000065"
            )
        )
    }
}