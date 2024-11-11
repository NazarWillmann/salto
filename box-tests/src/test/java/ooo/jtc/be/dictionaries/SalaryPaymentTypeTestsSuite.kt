package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_SALARYPAYMENTTYPE
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeControlTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeCreateTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeDefaultsTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeDeleteTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeFilterTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeGetPageTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeGetTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypePrepareSteps.generateWithPrefix
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeSortingTest
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeSteps
import ooo.jtc.api.dictionaries.salarypaymenttype.SalaryPaymentTypeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentType
import ooo.jtc.dictionaries.salarypaymenttype.SalaryPaymentTypeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.CODE_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.CODE_MAX_LENGTH
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.CODE_NOT_EMPTY
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.INCOME_TYPE_CODE_VALUE_RANGE
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.NAME_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.NAME_MAX_LENGTH
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeControls.NAME_NOT_EMPTY
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeData
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeFilterParams
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeSortingParams.CODE
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeSortingParams.INCOME_TYPE_CODE
import ooo.jtc.testdata.dictionaries.salarypaymenttype.SalaryPaymentTypeSortingParams.NAME
import ooo.jtc.testdata.dictionaries.salarypaymenttype.invalidCode
import ooo.jtc.testdata.dictionaries.salarypaymenttype.invalidName
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.SALARY_PAYMENT_TYPE)
@DisplayName("API '${DictionaryNames.SALARY_PAYMENT_TYPE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_SALARYPAYMENTTYPE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SalaryPaymentTypeTestsSuite {

    // TODO: сгенерировать ТК когда закроется дефект JSSP-197.

    private lateinit var dataForFilter: SalaryPaymentTypeDto
    private lateinit var testDataScope: TestDataScope<SalaryPaymentType>

    @BeforeAll
    fun prepareTestData() {
        SalaryPaymentTypeData.cleanAtCreated()
        testDataScope = SalaryPaymentTypeData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    internal fun salaryPaymentTypeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                SalaryPaymentTypeCreateTest(),
                SalaryPaymentTypeGetPageTest(user = client),
                SalaryPaymentTypeGetPageTest(user = bankAdmin),
                SalaryPaymentTypeGetTest(user = client),
                SalaryPaymentTypeGetTest(user = bankAdmin),
                SalaryPaymentTypeDeleteTest(),
                SalaryPaymentTypeUpdateTest()
            )
        )
    }

    @TestFactory
    internal fun salaryPaymentTypeSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                SalaryPaymentTypeSortingTest(user = client, sortRequestFunction = CODE::asc),
                SalaryPaymentTypeSortingTest(user = client, sortRequestFunction = CODE::desc),
                SalaryPaymentTypeSortingTest(user = client, sortRequestFunction = NAME::asc),
                SalaryPaymentTypeSortingTest(user = client, sortRequestFunction = NAME::desc),
                SalaryPaymentTypeSortingTest(user = client, sortRequestFunction = INCOME_TYPE_CODE::asc),
                SalaryPaymentTypeSortingTest(user = client, sortRequestFunction = INCOME_TYPE_CODE::desc),

                SalaryPaymentTypeSortingTest(user = bankAdmin, sortRequestFunction = CODE::asc),
                SalaryPaymentTypeSortingTest(user = bankAdmin, sortRequestFunction = CODE::desc),
                SalaryPaymentTypeSortingTest(user = bankAdmin, sortRequestFunction = NAME::asc),
                SalaryPaymentTypeSortingTest(user = bankAdmin, sortRequestFunction = NAME::desc),
                SalaryPaymentTypeSortingTest(user = bankAdmin, sortRequestFunction = INCOME_TYPE_CODE::asc),
                SalaryPaymentTypeSortingTest(user = bankAdmin, sortRequestFunction = INCOME_TYPE_CODE::desc),
            )
        )
    }

    @TestFactory
    internal fun salaryPaymentTypeFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                SalaryPaymentTypeFilterTest(
                    name = "name contains",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.NAME.contains(it!!.name!!.randomSubstringPf()) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "name equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.NAME.eq(it!!.name!!) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "code contains",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "code equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.CODE.eq(it!!.code!!) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "incomeTypeCode equals",
                    user = client,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.INCOME_TYPE_CODE.eq(it!!.incomeTypeCode!!) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "name contains",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.NAME.contains(it!!.name!!.randomSubstringPf()) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "name equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.NAME.eq(it!!.name!!) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "code contains",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "code equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.CODE.eq(it!!.code!!) }
                ),
                SalaryPaymentTypeFilterTest(
                    name = "incomeTypeCode equals",
                    user = bankAdmin,
                    preExecution = { dataForFilter },
                    filterRequestFunction = { SalaryPaymentTypeFilterParams.INCOME_TYPE_CODE.eq(it!!.incomeTypeCode!!) }
                )
            )
        )
    }

    private val getDto: SalaryPaymentTypeDto
        get() = SalaryPaymentTypePrepareSteps.getSalaryPaymentTypeDtoForCreate()

    @TestFactory
    internal fun salaryPaymentTypeControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                SalaryPaymentTypeControlTest(
                    testName = "кода на непустоту (null)",
                    preExecution = { getDto.apply { code = null } },
                    postExecution = null,
                    control = CODE_NOT_EMPTY
                ),
                SalaryPaymentTypeControlTest(
                    testName = "кода на непустоту (пустая строка)",
                    preExecution = { getDto.apply { code = "" } },
                    postExecution = null,
                    control = CODE_NOT_EMPTY
                ),
                SalaryPaymentTypeControlTest(
                    testName = "кода на непустоту (пробельные символы)",
                    preExecution = { getDto.apply { code = RandomData.getEmptyString(5) } },
                    postExecution = null,
                    control = CODE_NOT_EMPTY
                ),
                SalaryPaymentTypeControlTest(
                    testName = "длины кода",
                    preExecution = { getDto.apply { code = "100" } },
                    postExecution = null,
                    control = CODE_MAX_LENGTH
                ),
                SalaryPaymentTypeControlTest(
                    testName = "кода на допустимые символы",
                    preExecution = { getDto.apply { code = invalidCode } },
                    postExecution = null,
                    control = CODE_ALLOWED_SYMBOLS
                ),
                SalaryPaymentTypeControlTest(
                    testName = "наименования на непустоту (null)",
                    preExecution = { getDto.apply { name = null } },
                    postExecution = null,
                    control = NAME_NOT_EMPTY
                ),
                SalaryPaymentTypeControlTest(
                    testName = "наименования на непустоту (пустая строка)",
                    preExecution = { getDto.apply { name = "" } },
                    postExecution = null,
                    control = NAME_NOT_EMPTY
                ),
                SalaryPaymentTypeControlTest(
                    testName = "наименования на непустоту (пробельные символы)",
                    preExecution = { getDto.apply { name = RandomData.getEmptyString(5) } },
                    postExecution = null,
                    control = NAME_NOT_EMPTY
                ),
                SalaryPaymentTypeControlTest(
                    testName = "длины наименования",
                    preExecution = { getDto.apply { name = generateWithPrefix(length = 61) } },
                    postExecution = null,
                    control = NAME_MAX_LENGTH
                ),
                SalaryPaymentTypeControlTest(
                    testName = "наименования на допустимые символы",
                    preExecution = { getDto.apply { name = AT_PREFIX_RUS + invalidName } },
                    postExecution = null,
                    control = NAME_ALLOWED_SYMBOLS
                ),
                SalaryPaymentTypeControlTest(
                    testName = "кода вида дохода на допустимое значение",
                    preExecution = { getDto.apply { incomeTypeCode = 10 } },
                    postExecution = null,
                    control = INCOME_TYPE_CODE_VALUE_RANGE
                )
            )
        )
    }

    @TestFactory
    internal fun salaryPaymentTypeDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                SalaryPaymentTypeDefaultsTest(
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.code == expectedEntity.code }
                                SalaryPaymentTypeSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Тип выплаты со следующим кодом не найден: '${expectedEntity.code}'")
                            }
                        }
                    }
                )
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<SalaryPaymentType> {
        return listOf(
            SalaryPaymentType(code = "01", name = "Аванс", incomeTypeCode = 1),
            SalaryPaymentType(code = "02", name = "Заработная плата", incomeTypeCode = 1),
            SalaryPaymentType(code = "03", name = "Премия, иные поощрительные выплаты", incomeTypeCode = 1),
            SalaryPaymentType(code = "04", name = "Отпускные", incomeTypeCode = 1),
            SalaryPaymentType(code = "05", name = "Больничный", incomeTypeCode = 1),
            SalaryPaymentType(code = "06", name = "Выплата при увольнении", incomeTypeCode = 1),
            SalaryPaymentType(code = "07", name = "Оплата по ДГПХ", incomeTypeCode = 1),
            SalaryPaymentType(code = "08", name = "Командировочные", incomeTypeCode = 2),
            SalaryPaymentType(code = "09", name = "Пособия на детей", incomeTypeCode = 2),
            SalaryPaymentType(code = "10", name = "Прочие выплаты", incomeTypeCode = null),
        )
    }
}