package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_CONTROLS
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.tests.LetterToBankControlTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankServerErrorTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.RegexpConst.UPPER_LAT
import ooo.jtc.core.RegexpConst.UPPER_LAT_NUM_SPC
import ooo.jtc.core.ServiceErrors.PSQL_EXCEPTION
import ooo.jtc.core.ServiceErrors.VARCHAR_VALUE_TOO_LONG
import ooo.jtc.core.TestConstants.DOC_DATE_ACCEPTABLE_FUTURE_DAYS
import ooo.jtc.core.TestConstants.DOC_DATE_ACCEPTABLE_PAST_DAYS
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.LetterToBankControls
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.time.LocalDate

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(DocumentNames.LETTER_TO_BANK)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' controls suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_CONTROLS
@TestInstance(PER_CLASS)
class LetterToBankControlsTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4389") annotation class T4389
@Tag("JTCSALTO-T4390") annotation class T4390
@Tag("JTCSALTO-T4391") annotation class T4391
@Tag("JTCSALTO-T4392") annotation class T4392
@Tag("JTCSALTO-T4393") annotation class T4393
@Tag("JTCSALTO-T4394") annotation class T4394
@Tag("JTCSALTO-T4395") annotation class T4395
@Tag("JTCSALTO-T4396") annotation class T4396
@Tag("JTCSALTO-T4397") annotation class T4397
@Tag("JTCSALTO-T4398") annotation class T4398
@Tag("JTCSALTO-T4399") annotation class T4399
@Tag("JTCSALTO-T4400") annotation class T4400
@Tag("JTCSALTO-T4401") annotation class T4401
@Tag("JTCSALTO-T4402") annotation class T4402
@Tag("JTCSALTO-T4403") annotation class T4403
@Tag("JTCSALTO-T4404") annotation class T4404
@Tag("JTCSALTO-T4405") annotation class T4405
@Tag("JTCSALTO-T4406") annotation class T4406
@Tag("JTCSALTO-T4407") annotation class T4407
@Tag("JTCSALTO-T4408") annotation class T4408
@Tag("JTCSALTO-T4409") annotation class T4409
@Tag("JTCSALTO-T4410") annotation class T4410
@Tag("JTCSALTO-T4411") annotation class T4411
@Tag("JTCSALTO-T4945") annotation class T4945
@Tag("JTCSALTO-T5524") annotation class T5524
@Tag("JTCSALTO-T5525") annotation class T5525
@Tag("JTCSALTO-T6515") annotation class T6515
//@formatter:on
//endregion


    private val getDto: LetterToBankDto
        get() = LetterToBankPrepareSteps.getLetterToBankDtoForCreate()

    @TestFactory
    @T4389 //'Письмо в Банк'. Контроль: Контроль номера документа на непустоту. [CLIENT]
    @T4390 //'Письмо в Банк'. Контроль: Контроль длины номера документа. [CLIENT]
    @T4391 //'Письмо в Банк'. Контроль: Контроль допустимых символов в номере документа: пробелы. [CLIENT]
    @T4392 //'Письмо в Банк'. Контроль: Контроль допустимых символов в номере документа: не цифры. [CLIENT]
    @T4393 //'Письмо в Банк'. Контроль: Контроль допустимых символов в номере документа: только нули. [CLIENT]
    @T4394 //'Письмо в Банк'. Контроль: Контроль уникальности номера документа за текущий год. [CLIENT]
    internal fun letterToBankDocNumberControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль номера документа на непустоту",
                    preExecution = { getDto.apply { documentNumber = "" } },
                    control = LetterToBankControls.DOC_NUMBER_EMPTY
                ).withId(T4389::class),
                LetterToBankControlTest(
                    testName = "Контроль длины номера документа",
                    preExecution = { getDto.apply { documentNumber = RandomData("[0-9]*").random(length = 11) } },
                    control = LetterToBankControls.DOC_NUMBER_MAX_LENGTH.withParams("length" to "10")
                ).withId(T4390::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в номере документа: пробелы",
                    preExecution = { getDto.apply { documentNumber = "1 2" } },
                    control = LetterToBankControls.DOC_NUMBER_AVAILABLE_SYMBOLS_SPACES
                ).withId(T4391::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в номере документа: не цифры",
                    preExecution = { getDto.apply { documentNumber = "A" } },
                    control = LetterToBankControls.DOC_NUMBER_AVAILABLE_SYMBOLS_DELETE.withParams("symbols" to "A")
                ).withId(T4392::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в номере документа: только нули",
                    preExecution = { getDto.apply { documentNumber = "000" } },
                    control = LetterToBankControls.DOC_NUMBER_AVAILABLE_SYMBOLS_ZEROS
                ).withId(T4393::class),
                LetterToBankControlTest(
                    testName = "Контроль уникальности номера документа за текущий год",
                    preExecution = {
                        val letterToBank = LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                            searchingUser = Users.client,
                            additionalFilter = { it.isInStatus(LetterToBankStatus.NEW.statusClient) }
                        )
                        getDto.apply {
                            documentNumber = letterToBank.documentNumber
                            customerId = letterToBank.customerId
                            customerName = letterToBank.customerName
                        }
                    },
                    control = LetterToBankControls.DOC_NUMBER_UNIQUE_IN_YEAR
                ).withId(T4394::class)
            )
        )
    }

    @TestFactory
    @T5524 //'Письмо в Банк'. Контроль: Контроль допустимости даты документа: дата меньше текущей более допустимого значения [CLIENT]
    @T5525 //'Письмо в Банк'. Контроль: Контроль допустимости даты документа: дата больше текущей более допустимого значения [CLIENT]
    internal fun letterToBankDocDateControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль допустимости даты документа: дата меньше текущей более допустимого значения",
                    preExecution = { getDto.apply { documentDate = LocalDate.now().minusDays(DOC_DATE_ACCEPTABLE_PAST_DAYS + 1) } },
                    control = LetterToBankControls.DOC_DATE_RANGE
                ).withId(T5524::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимости даты документа: дата больше текущей более допустимого значения",
                    preExecution = { getDto.apply { documentDate = LocalDate.now().plusDays(DOC_DATE_ACCEPTABLE_FUTURE_DAYS + 1) } },
                    control = LetterToBankControls.DOC_DATE_RANGE
                ).withId(T5525::class)
            )
        )
    }

    @TestFactory
    @T4395 //'Письмо в Банк'. Контроль: Контроль описания типа письма на непустоту. [CLIENT]
    @T4396 //'Письмо в Банк'. Контроль: Контроль типа письма на соответствие справочнику. [CLIENT]
    internal fun letterToBankDocTypeControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль описания типа письма на непустоту",
                    preExecution = { getDto.apply { docTypeDescription = "" } },
                    control = LetterToBankControls.DOC_TYPE_EMPTY
                ).withId(T4395::class),
                LetterToBankControlTest(
                    testName = "Контроль типа письма на соответствие справочнику",
                    preExecution = { getDto.apply { docTypeDescription = RandomData(UPPER_LAT).random(length = 13) } },
                    control = LetterToBankControls.DOC_TYPE_IN_DICTIONARY
                ).withId(T4396::class)
            )
        )
    }

    @TestFactory
    @T4397 //'Письмо в Банк'. Контроль: Контроль темы письма на непустоту. [CLIENT]
    @T4398 //'Письмо в Банк'. Контроль: Контроль длины темы письма. [CLIENT]
    @T4399 //'Письмо в Банк'. Контроль: Контроль допустимых символов в теме письма. [CLIENT]
    internal fun letterToBankDocThemeControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль темы письма на непустоту",
                    preExecution = { getDto.apply { docTheme = "" } },
                    control = LetterToBankControls.DOC_THEME_EMPTY
                ).withId(T4397::class),
                LetterToBankControlTest(
                    testName = "Контроль длины темы письма",
                    preExecution = { getDto.apply { docTheme = RandomData(UPPER_LAT_NUM_SPC).random(length = 256) } },
                    control = LetterToBankControls.DOC_THEME_MAX_LENGTH.withParams("length" to "255")
                ).withId(T4398::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в теме письма",
                    preExecution = { getDto.apply { docTheme = "€" } },
                    control = LetterToBankControls.DOC_THEME_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4399::class)
            )
        )
    }

    @TestFactory
    @T4400 //'Письмо в Банк'. Контроль: Контроль текста письма на непустоту. [CLIENT]
    @T4401 //'Письмо в Банк'. Контроль: Контроль длины текста письма. [CLIENT]
    @T4402 //'Письмо в Банк'. Контроль: Контроль допустимых символов в тексте письма. [CLIENT]
    internal fun letterToBankDocTextControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль текста письма на непустоту",
                    preExecution = { getDto.apply { docText = "" } },
                    control = LetterToBankControls.DOC_TEXT_EMPTY
                ).withId(T4400::class),
                LetterToBankControlTest(
                    testName = "Контроль длины текста письма",
                    preExecution = { getDto.apply { docText = RandomData(UPPER_LAT_NUM_SPC).random(length = 2001) } },
                    control = LetterToBankControls.DOC_TEXT_MAX_LENGTH.withParams("length" to "2000")
                ).withId(T4401::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в тексте письма",
                    preExecution = { getDto.apply { docText = "€" } },
                    control = LetterToBankControls.DOC_TEXT_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4402::class)
            )
        )
    }

    @TestFactory
    @T4403 //'Письмо в Банк'. Контроль: Контроль ФИО ответственного исполнителя на непустоту. [CLIENT]
    @T6515 //'Письмо в Банк'. Контроль: Контроль длины ФИО ответственного исполнителя. [CLIENT]
    @T4404 //'Письмо в Банк'. Контроль: Контроль допустимых символов в ФИО ответственного исполнителя. [CLIENT]
    internal fun letterToBankContactNameControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль ФИО ответственного исполнителя на непустоту",
                    preExecution = { getDto.apply { contactName = "" } },
                    control = LetterToBankControls.CONTACT_NAME_EMPTY
                ).withId(T4403::class),
                LetterToBankServerErrorTest(
                    testName = "Контроль длины ФИО ответственного исполнителя",
                    preExecution = { getDto.apply { contactName = RandomData(UPPER_LAT_NUM_SPC).random(length = 256) } },
                    expectedCode = 600,
                    expectedMessage = PSQL_EXCEPTION + VARCHAR_VALUE_TOO_LONG.format(255)
                ).withId(T6515::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в ФИО ответственного исполнителя",
                    preExecution = { getDto.apply { contactName = "€" } },
                    control = LetterToBankControls.CONTACT_NAME_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4404::class)
            )
        )
    }

    @TestFactory
    @T4405 //'Письмо в Банк'. Контроль: Контроль телефона ответственного исполнителя на непустоту. [CLIENT]
    @T4406 //'Письмо в Банк'. Контроль: Контроль длины телефона ответственного исполнителя. [CLIENT]
    @T4407 //'Письмо в Банк'. Контроль: Контроль допустимых символов в телефоне ответственного исполнителя. [CLIENT]
    internal fun letterToBankContactPhoneControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль телефона ответственного исполнителя на непустоту",
                    preExecution = { getDto.apply { contactPhone = "" } },
                    control = LetterToBankControls.CONTACT_PHONE_EMPTY
                ).withId(T4405::class),
                LetterToBankControlTest(
                    testName = "Контроль длины телефона ответственного исполнителя",
                    preExecution = { getDto.apply { contactPhone = RandomData("[0-9]*").random(length = 13) } },
                    control = LetterToBankControls.CONTACT_PHONE_MAX_LENGTH.withParams("length" to "12")
                ).withId(T4406::class),
                LetterToBankControlTest(
                    testName = "Контроль допустимых символов в телефоне ответственного исполнителя",
                    preExecution = { getDto.apply { contactPhone = "€" } },
                    control = LetterToBankControls.CONTACT_PHONE_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4407::class)
            )
        )
    }

    @TestFactory
    @T4408 //'Письмо в Банк'. Контроль: Контроль наименования Клиента на непустоту. [CLIENT]
    @T4409 //'Письмо в Банк'. Контроль: Контроль Клиента на соответствие справочнику. [CLIENT]
    internal fun letterToBankCustomerControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль наименования Клиента на непустоту",
                    preExecution = { getDto.apply { customerName = "" } },
                    control = LetterToBankControls.CUSTOMER_NAME_EMPTY
                ).withId(T4408::class),
                LetterToBankControlTest(
                    testName = "Контроль Клиента на соответствие справочнику",
                    preExecution = { getDto.apply { customerName = RandomData(UPPER_LAT).random(length = 12) } },
                    control = LetterToBankControls.CUSTOMER_IN_DICTIONARY
                ).withId(T4409::class)
            )
        )
    }

    @TestFactory
    @T4410 //'Письмо в Банк'. Контроль: Контроль наименования подразделения Банка на непустоту. [CLIENT]
    @T4411 //'Письмо в Банк'. Контроль: Контроль подразделения Банка на соответствие справочнику. [CLIENT]
    internal fun letterToBankBranchNameControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль наименования подразделения Банка на непустоту",
                    preExecution = { getDto.apply { branchName = "" } },
                    control = LetterToBankControls.BRANCH_NAME_EMPTY
                ).withId(T4410::class),
                LetterToBankControlTest(
                    testName = "Контроль подразделения Банка на соответствие справочнику",
                    preExecution = { getDto.apply { branchName = RandomData(UPPER_LAT).random(length = 12) } },
                    control = LetterToBankControls.BRANCH_IN_DICTIONARY
                ).withId(T4411::class)
            )
        )
    }

    @TestFactory
    @T4945 //'Письмо в Банк'. Контроль: Контроль уникальности документа. [CLIENT]
    internal fun letterToBankCommonControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankControlTest(
                    testName = "Контроль уникальности документа",
                    preExecution = {
                        val letterToBank = LetterToBankPrepareSteps.getOrCreateLetterToBankDto(searchingUser = Users.client)
                        getDto.apply {
                            documentNumber = letterToBank.documentNumber
                            documentDate = letterToBank.documentDate
                            customerId = letterToBank.customerId
                            customerName = letterToBank.customerName
                            branchId = letterToBank.branchId
                            branchName = letterToBank.branchName
                            docTheme = letterToBank.docTheme
                        }
                    },
                    control = LetterToBankControls.DOCUMENT_UNIQUE
                ).withId(T4945::class)
            )
        )
    }
}