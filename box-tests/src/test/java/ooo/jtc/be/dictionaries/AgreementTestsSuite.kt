package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_AGREEMENT
import ooo.jtc.api.common.controls.IControls
import ooo.jtc.api.dictionaries.agreement.AgreementActivateDeactivateTest
import ooo.jtc.api.dictionaries.agreement.AgreementControlTest
import ooo.jtc.api.dictionaries.agreement.AgreementCreateTest
import ooo.jtc.api.dictionaries.agreement.AgreementDeleteTest
import ooo.jtc.api.dictionaries.agreement.AgreementFilterTest
import ooo.jtc.api.dictionaries.agreement.AgreementGetPageTest
import ooo.jtc.api.dictionaries.agreement.AgreementGetTest
import ooo.jtc.api.dictionaries.agreement.AgreementPrepareSteps
import ooo.jtc.api.dictionaries.agreement.AgreementSortingTest
import ooo.jtc.api.dictionaries.agreement.AgreementSteps
import ooo.jtc.api.dictionaries.agreement.AgreementUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.agreement.Agreement
import ooo.jtc.dictionaries.agreement.AgreementDto
import ooo.jtc.dictionaries.agreement.AgreementType
import ooo.jtc.dictionaries.agreement.AgreementTypeStatus
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.agreement.AgreementControls
import ooo.jtc.testdata.dictionaries.agreement.AgreementData
import ooo.jtc.testdata.dictionaries.agreement.AgreementFilterParams
import ooo.jtc.testdata.dictionaries.agreement.AgreementSortingParams
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.time.LocalDate

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.AGREEMENT)
@DisplayName("API '${DictionaryNames.AGREEMENT}' suite")
@Execution(ExecutionMode.SAME_THREAD)
@BE_DICTIONARY_AGREEMENT
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AgreementTestsSuite {

    private lateinit var dataForFilter: AgreementDto
    private lateinit var testDataScope: TestDataScope<Agreement>
    private val clientUser = Users.client
    private val bankUser = Users.bankAdmin

    @BeforeAll
    fun prepareTestData() {
        testDataScope = AgreementData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @TestFactory
    internal fun agreementCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AgreementCreateTest(bankUser),
                AgreementDeleteTest(bankUser),
                AgreementUpdateTest(bankUser),
                AgreementGetPageTest(bankUser),
                AgreementGetTest(bankUser),
                AgreementGetTest(clientUser),
                AgreementGetPageTest(clientUser)
            )
        )
    }

    @TestFactory
    internal fun agreementActivateDeactivateTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AgreementActivateDeactivateTest(
                    testBody = {
                        val expectedEntity = AgreementPrepareSteps.getDeactivateAgreementDto()
                        val createdEntity = AgreementSteps(bankUser).create(expectedEntity)
                        val actualEntity = AgreementSteps(bankUser).activateOrDeactivateAgreement(createdEntity.data?.id!!, true)
                        expectedEntity.status = AgreementTypeStatus.ACTIVE.name
                        assertThat(
                            "Соглашение не деактивировано: expected;actual {'${expectedEntity.status}'; '${actualEntity.data?.status}' }",
                            expectedEntity.status,
                            Matchers.equalTo(actualEntity.data?.status)
                            )
                    },
                isActivate = false),
                AgreementActivateDeactivateTest(
                    testBody = {
                        val expectedEntity = AgreementPrepareSteps.getActivateAgreementDto()
                        val createdEntity = AgreementSteps(bankUser).create(expectedEntity)
                        val actualEntity = AgreementSteps(bankUser).activateOrDeactivateAgreement(createdEntity.data?.id!!, false)
                        expectedEntity.status = AgreementTypeStatus.INACTIVE.name
                        assertThat(
                            "Соглашение не активировано: expected;actual {'${expectedEntity.status}'; '${actualEntity.data?.status}' }",
                            expectedEntity.status,
                            Matchers.equalTo(actualEntity.data?.status)
                        )
                    },
                isActivate = true)
            )
        )
    }

    @TestFactory
    internal fun agreementBankFilteringTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AgreementFilterTest("id equals", bankUser, { dataForFilter },
                    { AgreementFilterParams.ID.eq(it!!.id!!) }),
                AgreementFilterTest("agreement date equals value", bankUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_DATE.eq(it!!.agreementDate!!) }),
                AgreementFilterTest("agreement number equals", bankUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_NUMBER.eq(it!!.agreementNumber!!) }),
                AgreementFilterTest("agreement number contains", bankUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_NUMBER.contains(it!!.agreementNumber!!) }),
                AgreementFilterTest("agreement type eq", bankUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_TYPE.eq(it!!.agreementType!!) }),
                AgreementFilterTest("end date contains", bankUser, { dataForFilter },
                    { AgreementFilterParams.END_DATE.eq(it!!.endDate!!) }),
                AgreementFilterTest("agreement status eq", bankUser, { dataForFilter },
                    { AgreementFilterParams.STATUS.eq(it!!.status) }),
                AgreementFilterTest("description equals", bankUser, { dataForFilter },
                    { AgreementFilterParams.DESCRIPTION.eq(it!!.description!!) }),
                AgreementFilterTest("description contains", bankUser, { dataForFilter },
                    { AgreementFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) })
            )
        )
    }

    @TestFactory
    internal fun agreementClientFilteringTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AgreementFilterTest("id equals", clientUser, { dataForFilter },
                    { AgreementFilterParams.ID.eq(it!!.id!!) }),
                AgreementFilterTest("agreement date equals value", clientUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_DATE.eq(it!!.agreementDate!!) }),
                AgreementFilterTest("agreement number equals", clientUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_NUMBER.eq(it!!.agreementNumber!!) }),
                AgreementFilterTest("agreement number contains", clientUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_NUMBER.contains(it!!.agreementNumber!!) }),
                AgreementFilterTest("agreement type eq", clientUser, { dataForFilter },
                    { AgreementFilterParams.AGREEMENT_TYPE.eq(it!!.agreementType!!) }),
                AgreementFilterTest("end date contains", clientUser, { dataForFilter },
                    { AgreementFilterParams.END_DATE.eq(it!!.endDate!!) }),
                AgreementFilterTest("agreement status eq", clientUser, { dataForFilter },
                    { AgreementFilterParams.STATUS.eq(it!!.status) }),
                AgreementFilterTest("description equals", clientUser, { dataForFilter },
                    { AgreementFilterParams.DESCRIPTION.eq(it!!.description!!) }),
                AgreementFilterTest("description contains", clientUser, { dataForFilter },
                    { AgreementFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) })
            )
        )
    }

    @TestFactory
    internal fun agreementClientSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AgreementSortingTest(clientUser) { AgreementSortingParams.ID.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.AGREEMENT_DATE.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.AGREEMENT_NUMBER.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.AGREEMENT_TYPE.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.DESCRIPTION.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.END_DATE.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.CUSTOMER_ID.asc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.STATUS.asc() },

                AgreementSortingTest(clientUser) { AgreementSortingParams.ID.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.AGREEMENT_DATE.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.AGREEMENT_NUMBER.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.AGREEMENT_TYPE.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.DESCRIPTION.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.END_DATE.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.CUSTOMER_ID.desc() },
                AgreementSortingTest(clientUser) { AgreementSortingParams.STATUS.desc() }
            )
        )
    }

    @TestFactory
    internal fun agreementBankSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AgreementSortingTest(bankUser) { AgreementSortingParams.ID.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.AGREEMENT_DATE.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.AGREEMENT_NUMBER.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.AGREEMENT_TYPE.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.DESCRIPTION.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.END_DATE.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.CUSTOMER_ID.asc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.STATUS.asc() },

                AgreementSortingTest(bankUser) { AgreementSortingParams.ID.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.AGREEMENT_DATE.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.AGREEMENT_NUMBER.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.AGREEMENT_TYPE.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.DESCRIPTION.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.END_DATE.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.CUSTOMER_ID.desc() },
                AgreementSortingTest(bankUser) { AgreementSortingParams.STATUS.desc() }
            )
        )
    }

    @TestFactory
    internal fun agreementControlTests(): List<DynamicTest> {
        val invalidCode = RandomData.builder()
            .withLatinAlphabet()
            .withRussianSmallLetters()
            .withSpecialCharacters()
            .build()
            .random(length = 2)
        return EntityTestGenerator.generate(
            listOf(
                AgreementControlTest(
                    testName = "дата генерального соглашения на не пустоту (null)",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { agreementDate = null } },
                    control = AgreementControls.DATE_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "номер генерального соглашения на не пустоту (null)",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { agreementNumber = null } },
                    control = AgreementControls.NUMBER_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "номер генерального соглашения на не пустоту (пробельные символы)",
                    preExecution = {
                        AgreementPrepareSteps.getAgreementDtoForCreate().apply { agreementNumber = RandomData.getEmptyString(length = 2) }
                    },
                    control = AgreementControls.NUMBER_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "номер генерального соглашения (больше требуемого значения)",
                    preExecution = {
                        AgreementPrepareSteps.getAgreementDtoForCreate()
                            .apply { agreementNumber = AgreementPrepareSteps.codeChars.random(length = 16) }
                    },
                    control = AgreementControls.NUMBER_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "номер генерального соглашения на допустимые символы",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { agreementNumber = invalidCode } },
                    control = AgreementControls.NUMBER_ALLOWED_SYMBOLS.withParams("symbols" to IControls.getForbiddenSymbolsMessage(invalidCode))
                ),
                AgreementControlTest(
                    testName = "тип генерального соглашения на не пустоту (null)",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { agreementType = null } },
                    control = AgreementControls.AGREEMENT_TYPE_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "тип генерального соглашения на не пустоту (пробельные символы)",
                    preExecution = {
                        AgreementPrepareSteps.getAgreementDtoForCreate().apply { agreementType = RandomData.getEmptyString(length = 2) }
                    },
                    control = AgreementControls.AGREEMENT_TYPE_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "дата окончания генерального соглашения на не пустоту (null)",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { endDate = null } },
                    control = AgreementControls.END_DATE_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "описание генерального соглашения на не пустоту (null)",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { description = null } },
                    control = AgreementControls.DESCRIPTION_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "описание генерального соглашения на не пустоту (пробельные символы)",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { description = RandomData.getEmptyString(length = 2) } },
                    control = AgreementControls.DESCRIPTION_NOT_EMPTY
                ),
                AgreementControlTest(
                    testName = "описание генерального соглашения (больше требуемого значения)",
                    preExecution = {
                        AgreementPrepareSteps.getAgreementDtoForCreate().apply { description = AgreementPrepareSteps.codeChars.random(length = 256) }
                    },
                    control = AgreementControls.DESCRIPTION_LENGTH
                ),
                AgreementControlTest(
                    testName = "описание генерального соглашения на допустимые символы",
                    preExecution = { AgreementPrepareSteps.getAgreementDtoForCreate().apply { description = invalidCode } },
                    control = AgreementControls.DESCRIPTION_ALLOWED_SYMBOLS.withParams("symbols" to IControls.getForbiddenSymbolsMessage(invalidCode))
                )
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<Agreement> {
        var customer = CustomerData.getOrCreate(Users.client)
        return listOf(
            Agreement(
                id = null,
                description = "Генеральное соглашение 1",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101112",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 2",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101113",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ), Agreement(
                id = null,
                description = "Генеральное соглашение 3",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101114",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ), Agreement(
                id = null,
                description = "Генеральное соглашение 4",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101115",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ), Agreement(
                id = null,
                description = "Генеральное соглашение 5",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101116",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ), Agreement(
                id = null,
                description = "Генеральное соглашение 6",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101117",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 7",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101118",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 8",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101119",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 9",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101120",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 10",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101121",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 11",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101122",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 12",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101123",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 13",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101124",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 14",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101125",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 15",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101126",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 16",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101127",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 17",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101128",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 18",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101129",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.INACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 19",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101130",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 20",
                agreementType = AgreementType.SALARY,
                agreementNumber = "123456789101131",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            ),
            Agreement(
                id = null,
                description = "Генеральное соглашение 21",
                agreementType = AgreementType.OTHER,
                agreementNumber = "123456789101132",
                agreementDate = LocalDate.now(),
                status = AgreementTypeStatus.ACTIVE.name,
                endDate = LocalDate.now().plusYears(1),
                customerId = customer.id!!,
                customerShortName = customer.shortName,
                customerFullName = customer.fullName,
                version = 1,
                createdAt = null,
                deletedAt = null
            )
        )
    }
}

