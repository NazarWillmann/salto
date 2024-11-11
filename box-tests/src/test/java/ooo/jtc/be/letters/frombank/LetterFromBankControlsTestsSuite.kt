package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_CONTROLS
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.tests.LetterFromBankControlTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankServerErrorTest
import ooo.jtc.core.ServiceErrors.PSQL_EXCEPTION
import ooo.jtc.core.ServiceErrors.VARCHAR_VALUE_TOO_LONG
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.RegexpConst.UPPER_LAT
import ooo.jtc.core.RegexpConst.UPPER_LAT_NUM_SPC
import ooo.jtc.core.TestConstants.DOC_DATE_ACCEPTABLE_FUTURE_DAYS
import ooo.jtc.core.TestConstants.DOC_DATE_ACCEPTABLE_PAST_DAYS
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.frombank.LetterFromBankControls
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
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_CONTROLS)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' controls suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_CONTROLS
@TestInstance(PER_CLASS)
class LetterFromBankControlsTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4412") annotation class T4412
@Tag("JTCSALTO-T4413") annotation class T4413
@Tag("JTCSALTO-T4414") annotation class T4414
@Tag("JTCSALTO-T4415") annotation class T4415
@Tag("JTCSALTO-T4416") annotation class T4416
@Tag("JTCSALTO-T4417") annotation class T4417
@Tag("JTCSALTO-T4418") annotation class T4418
@Tag("JTCSALTO-T4419") annotation class T4419
@Tag("JTCSALTO-T4420") annotation class T4420
@Tag("JTCSALTO-T4421") annotation class T4421
@Tag("JTCSALTO-T4422") annotation class T4422
@Tag("JTCSALTO-T4423") annotation class T4423
@Tag("JTCSALTO-T4424") annotation class T4424
@Tag("JTCSALTO-T4425") annotation class T4425
@Tag("JTCSALTO-T4426") annotation class T4426
@Tag("JTCSALTO-T4427") annotation class T4427
@Tag("JTCSALTO-T4428") annotation class T4428
@Tag("JTCSALTO-T4429") annotation class T4429
@Tag("JTCSALTO-T4430") annotation class T4430
@Tag("JTCSALTO-T4431") annotation class T4431
@Tag("JTCSALTO-T4432") annotation class T4432
@Tag("JTCSALTO-T4433") annotation class T4433
@Tag("JTCSALTO-T4434") annotation class T4434
@Tag("JTCSALTO-T4435") annotation class T4435
@Tag("JTCSALTO-T4436") annotation class T4436
@Tag("JTCSALTO-T4437") annotation class T4437
@Tag("JTCSALTO-T4438") annotation class T4438
@Tag("JTCSALTO-T5527") annotation class T5527
@Tag("JTCSALTO-T5528") annotation class T5528
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val getDto: LetterFromBankDto
        get() = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate()

    @TestFactory
    @T4412 //'Письмо из Банка'. Контроль: номера документа на непустоту. [BANK]
    @T4413 //'Письмо из Банка'. Контроль: длины номера документа. [BANK]
    @T4414 //'Письмо из Банка'. Контроль: допустимых символов в номере документа: пробелы. [BANK]
    @T4415 //'Письмо из Банка'. Контроль: допустимых символов в номере документа: не цифры. [BANK]
    @T4416 //'Письмо из Банка'. Контроль: допустимых символов в номере документа: только нули. [BANK]
    @T4417 //'Письмо из Банка'. Контроль: уникальности номера документа за текущий год. [BANK]
    internal fun letterFromBankDocNumberControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "номера документа на непустоту",
                    preExecution = { getDto.apply { documentNumber = "" } },
                    control = LetterFromBankControls.DOC_NUMBER_EMPTY
                ).withId(T4412::class),
                LetterFromBankControlTest(
                    testName = "длины номера документа",
                    preExecution = { getDto.apply { documentNumber = RandomData("[0-9]*").random(length = 11) } },
                    control = LetterFromBankControls.DOC_NUMBER_MAX_LENGTH.withParams("length" to "10")
                ).withId(T4413::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в номере документа: пробелы",
                    preExecution = { getDto.apply { documentNumber = "1 2" } },
                    control = LetterFromBankControls.DOC_NUMBER_AVAILABLE_SYMBOLS_SPACES
                ).withId(T4414::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в номере документа: не цифры",
                    preExecution = { getDto.apply { documentNumber = "A;и" } },
                    control = LetterFromBankControls.DOC_NUMBER_AVAILABLE_SYMBOLS_DELETE.withParams("symbols" to "A;;;и")
                ).withId(T4415::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в номере документа: только нули",
                    preExecution = { getDto.apply { documentNumber = "000" } },
                    control = LetterFromBankControls.DOC_NUMBER_AVAILABLE_SYMBOLS_ZEROS
                ).withId(T4416::class),
                LetterFromBankControlTest(
                    testName = "уникальности номера документа за текущий год",
                    preExecution = {
                        val letterFromBank = LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(searchingUser = bankUser)
                        getDto.apply { documentNumber = letterFromBank.documentNumber }
                    },
                    control = LetterFromBankControls.DOC_NUMBER_UNIQUE_IN_YEAR
                ).withId(T4417::class)
            )
        )
    }

    @TestFactory
    @T4438 //'Письмо из Банка'. Контроль: допустимости даты документа: дата меньше текущей более допустимого значения [BANK]
    @T4418 //'Письмо из Банка'. Контроль: допустимости даты документа: дата больше текущей более допустимого значения [BANK]
    internal fun letterFromBankDocDateControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "допустимости даты документа: дата меньше текущей более допустимого значения",
                    preExecution = { getDto.apply { documentDate = LocalDate.now().minusDays(DOC_DATE_ACCEPTABLE_PAST_DAYS + 1) } },
                    control = LetterFromBankControls.DOC_DATE_RANGE
                ).withId(T4438::class),
                LetterFromBankControlTest(
                    testName = "допустимости даты документа: дата больше текущей более допустимого значения",
                    preExecution = { getDto.apply { documentDate = LocalDate.now().plusDays(DOC_DATE_ACCEPTABLE_FUTURE_DAYS + 1) } },
                    control = LetterFromBankControls.DOC_DATE_RANGE
                ).withId(T4418::class)
            )
        )
    }

    @TestFactory
    @T4419 //'Письмо из Банка'. Контроль: типа письма на непустоту. [BANK]
    @T4420 //'Письмо из Банка'. Контроль: типа письма на соответствие справочнику. [BANK]
    internal fun letterFromBankDocTypeControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "типа письма на непустоту",
                    preExecution = { getDto.apply { docTypeDescription = "" } },
                    control = LetterFromBankControls.DOC_TYPE_EMPTY
                ).withId(T4419::class),
                LetterFromBankControlTest(
                    testName = "типа письма на соответствие справочнику",
                    preExecution = { getDto.apply { docTypeDescription = RandomData(UPPER_LAT).random(length = 13) } },
                    control = LetterFromBankControls.DOC_TYPE_IN_DICTIONARY
                ).withId(T4420::class)
            )
        )
    }

    @TestFactory
    @T4421 //'Письмо из Банка'. Контроль: темы письма на непустоту. [BANK]
    @T4422 //'Письмо из Банка'. Контроль: длины темы письма. [BANK]
    @T4423 //'Письмо из Банка'. Контроль: допустимых символов в теме письма. [BANK]
    internal fun letterFromBankDocThemeControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "темы письма на непустоту",
                    preExecution = { getDto.apply { docTheme = "" } },
                    control = LetterFromBankControls.DOC_THEME_EMPTY
                ).withId(T4421::class),
                LetterFromBankControlTest(
                    testName = "длины темы письма",
                    preExecution = { getDto.apply { docTheme = RandomData(UPPER_LAT_NUM_SPC).random(length = 256) } },
                    control = LetterFromBankControls.DOC_THEME_MAX_LENGTH.withParams("length" to "255")
                ).withId(T4422::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в теме письма",
                    preExecution = { getDto.apply { docTheme = "€" } },
                    control = LetterFromBankControls.DOC_THEME_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4423::class)
            )
        )
    }

    @TestFactory
    @T4424 //'Письмо из Банка'. Контроль: текста письма на непустоту. [BANK]
    @T4425 //'Письмо из Банка'. Контроль: длины текста письма. [BANK]
    @T4426 //'Письмо из Банка'. Контроль: допустимых символов в тексте письма. [BANK]
    internal fun letterFromBankDocTextControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "текста письма на непустоту",
                    preExecution = { getDto.apply { docText = "" } },
                    control = LetterFromBankControls.DOC_TEXT_EMPTY
                ).withId(T4424::class),
                LetterFromBankControlTest(
                    testName = "длины текста письма",
                    preExecution = { getDto.apply { docText = RandomData(UPPER_LAT_NUM_SPC).random(length = 2001) } },
                    control = LetterFromBankControls.DOC_TEXT_MAX_LENGTH.withParams("length" to "2000")
                ).withId(T4425::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в тексте письма",
                    preExecution = { getDto.apply { docText = "€" } },
                    control = LetterFromBankControls.DOC_TEXT_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4426::class)
            )
        )
    }

    @TestFactory
    @T4427 //'Письмо из Банка'. Контроль: ФИО ответственного исполнителя на непустоту. [BANK]
    @T5527 //'Письмо из Банка'. Контроль: длины ФИО ответственного исполнителя [BANK]
    @T4428 //'Письмо из Банка'. Контроль: допустимых символов в ФИО ответственного исполнителя. [BANK]
    internal fun letterFromBankContactNameControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "ФИО ответственного исполнителя на непустоту",
                    preExecution = { getDto.apply { contactName = "" } },
                    control = LetterFromBankControls.CONTACT_NAME_EMPTY
                ).withId(T4427::class),
                LetterFromBankServerErrorTest(
                    testName = "длины ФИО ответственного исполнителя",
                    preExecution = { getDto.apply { contactName = RandomData(UPPER_LAT_NUM_SPC).random(length = 256) } },
                    expectedCode = 600,
                    expectedMessage = PSQL_EXCEPTION + VARCHAR_VALUE_TOO_LONG.format(255)
                ).withId(T5527::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в ФИО ответственного исполнителя",
                    preExecution = { getDto.apply { contactName = "€" } },
                    control = LetterFromBankControls.CONTACT_NAME_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4428::class)
            )
        )
    }

    @TestFactory
    @T4429 //'Письмо из Банка'. Контроль: телефона ответственного исполнителя на непустоту. [BANK]
    @T4430 //'Письмо из Банка'. Контроль: длины телефона ответственного исполнителя. [BANK]
    @T4431 //'Письмо из Банка'. Контроль: допустимых символов в телефоне ответственного исполнителя. [BANK]
    internal fun letterFromBankContactPhoneControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "телефона ответственного исполнителя на непустоту",
                    preExecution = { getDto.apply { contactPhone = "" } },
                    control = LetterFromBankControls.CONTACT_PHONE_EMPTY
                ).withId(T4429::class),
                LetterFromBankControlTest(
                    testName = "длины телефона ответственного исполнителя",
                    preExecution = { getDto.apply { contactPhone = RandomData("[0-9]*").random(length = 13) } },
                    control = LetterFromBankControls.CONTACT_PHONE_MAX_LENGTH.withParams("length" to "12")
                ).withId(T4430::class),
                LetterFromBankControlTest(
                    testName = "допустимых символов в телефоне ответственного исполнителя",
                    preExecution = { getDto.apply { contactPhone = "€" } },
                    control = LetterFromBankControls.CONTACT_PHONE_AVAILABLE_SYMBOLS.withParams("symbols" to "€")
                ).withId(T4431::class)
            )
        )
    }

    @TestFactory
    @T4432 //'Письмо из Банка'. Контроль: наименования Клиента на непустоту. [BANK]
    @T4433 //'Письмо из Банка'. Контроль: Клиента на соответствие справочнику. [BANK]
    @T5528 //'Письмо из Банка'. Контроль: отсутствия блокировки Клиента [BANK]
    internal fun letterFromBankCustomerNameControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "наименования Клиента на непустоту",
                    preExecution = { getDto.apply { customerName = "" } },
                    control = LetterFromBankControls.CUSTOMER_NAME_EMPTY
                ).withId(T4432::class),
                LetterFromBankControlTest(
                    testName = "Клиента на соответствие справочнику",
                    preExecution = { getDto.apply { customerName = RandomData(UPPER_LAT).random(length = 12) } },
                    control = LetterFromBankControls.CUSTOMER_IN_DICTIONARY
                ).withId(T4433::class),

                // TODO this
                LetterFromBankControlTest(
                    testName = "отсутствия блокировки Клиента",
                    preExecution = { getDto.apply { customerName = "€" } },
                    control = LetterFromBankControls.CUSTOMER_NOT_BLOCKED
                ).withId(T5528::class)
            )
        )
    }

    @TestFactory
    @T4434 //'Письмо из Банка'. Контроль: наименования подразделения Банка на непустоту. [BANK]
    @T4435 //'Письмо из Банка'. Контроль: подразделения Банка на соответствие справочнику. [BANK]
    @T4436 //'Письмо из Банка'. Контроль: подразделения Банка, обслуживающего Клиента. [BANK]
    internal fun letterFromBankBranchNameControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "наименования подразделения Банка на непустоту",
                    preExecution = { getDto.apply { branchName = "" } },
                    control = LetterFromBankControls.BRANCH_NAME_EMPTY
                ).withId(T4434::class),
                LetterFromBankControlTest(
                    testName = "подразделения Банка на соответствие справочнику",
                    preExecution = { getDto.apply { branchName = RandomData(UPPER_LAT).random(length = 12) } },
                    control = LetterFromBankControls.BRANCH_NAME_IN_DICTIONARY
                ).withId(T4435::class),
                LetterFromBankControlTest(
                    testName = "подразделения Банка, обслуживающего Клиента",
                    preExecution = { getDto.apply { customerName = RandomData(UPPER_LAT).random(length = 12) } },
                    control = LetterFromBankControls.CUSTOMER_IN_DICTIONARY
                ).withId(T4436::class)
            )
        )
    }

    @TestFactory
    @T4437 //'Письмо из Банка'. Контроль: уникальности документа. [BANK]
    internal fun letterFromBankCommonControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankControlTest(
                    testName = "уникальности документа",
                    preExecution = {
                        val letterFromBank = LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(searchingUser = bankUser)
                        getDto.apply {
                            documentNumber = letterFromBank.documentNumber
                            documentDate = letterFromBank.documentDate
                            customerId = letterFromBank.customerId
                            customerName = letterFromBank.customerName
                            branchId = letterFromBank.branchId
                            branchName = letterFromBank.branchName
                            docTheme = letterFromBank.docTheme
                        }
                    },
                    control = LetterFromBankControls.DOCUMENT_UNIQUE
                ).withId(T4437::class)
            )
        )
    }
}