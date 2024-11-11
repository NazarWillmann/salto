package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_EXPORT
import ooo.jtc.api.letters.tobank.tests.LetterToBankExportDocsByFilterTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankExportFormatTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankExportMultipleDocsByIdTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankExportMultipleDocsFileNameTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankExportSingleDocByIdTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankExportSingleDocFileNameTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.generic.print.PrintExportFormat.CSV
import ooo.jtc.generic.print.PrintExportFormat.XLSX
import ooo.jtc.generic.print.PrintExportFormat.XML
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.STATUS
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams
import ooo.jtc.uaa.User
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_EXPORT)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' export suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_EXPORT
class LetterToBankExportTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4032") annotation class T4032
@Tag("JTCSALTO-T4033") annotation class T4033
@Tag("JTCSALTO-T4034") annotation class T4034
@Tag("JTCSALTO-T4035") annotation class T4035
@Tag("JTCSALTO-T4036") annotation class T4036
@Tag("JTCSALTO-T4037") annotation class T4037
@Tag("JTCSALTO-T4050") annotation class T4050
@Tag("JTCSALTO-T4051") annotation class T4051
@Tag("JTCSALTO-T4052") annotation class T4052
@Tag("JTCSALTO-T4053") annotation class T4053
@Tag("JTCSALTO-T4054") annotation class T4054
@Tag("JTCSALTO-T4055") annotation class T4055
@Tag("JTCSALTO-T4056") annotation class T4056
@Tag("JTCSALTO-T4057") annotation class T4057
@Tag("JTCSALTO-T4058") annotation class T4058
@Tag("JTCSALTO-T4059") annotation class T4059
@Tag("JTCSALTO-T4060") annotation class T4060
@Tag("JTCSALTO-T4061") annotation class T4061
@Tag("JTCSALTO-T4062") annotation class T4062
@Tag("JTCSALTO-T4063") annotation class T4063
@Tag("JTCSALTO-T4064") annotation class T4064
@Tag("JTCSALTO-T4065") annotation class T4065
@Tag("JTCSALTO-T4066") annotation class T4066
@Tag("JTCSALTO-T4067") annotation class T4067
@Tag("JTCSALTO-T4068") annotation class T4068
@Tag("JTCSALTO-T4069") annotation class T4069
@Tag("JTCSALTO-T4339") annotation class T4339
@Tag("JTCSALTO-T4340") annotation class T4340
@Tag("JTCSALTO-T4341") annotation class T4341
@Tag("JTCSALTO-T4342") annotation class T4342
@Tag("JTCSALTO-T4343") annotation class T4343
@Tag("JTCSALTO-T4344") annotation class T4344
@Tag("JTCSALTO-T4345") annotation class T4345
@Tag("JTCSALTO-T4346") annotation class T4346
@Tag("JTCSALTO-T4347") annotation class T4347
@Tag("JTCSALTO-T4348") annotation class T4348
@Tag("JTCSALTO-T4349") annotation class T4349
@Tag("JTCSALTO-T4350") annotation class T4350
@Tag("JTCSALTO-T4351") annotation class T4351
@Tag("JTCSALTO-T4352") annotation class T4352
@Tag("JTCSALTO-T4353") annotation class T4353
@Tag("JTCSALTO-T4354") annotation class T4354
@Tag("JTCSALTO-T4355") annotation class T4355
@Tag("JTCSALTO-T4356") annotation class T4356
@Tag("JTCSALTO-T4357") annotation class T4357
@Tag("JTCSALTO-T4358") annotation class T4358
@Tag("JTCSALTO-T4359") annotation class T4359
@Tag("JTCSALTO-T4360") annotation class T4360
@Tag("JTCSALTO-T4361") annotation class T4361
@Tag("JTCSALTO-T4362") annotation class T4362
@Tag("JTCSALTO-T4363") annotation class T4363
@Tag("JTCSALTO-T4364") annotation class T4364
@Tag("JTCSALTO-T4365") annotation class T4365
@Tag("JTCSALTO-T4366") annotation class T4366
@Tag("JTCSALTO-T4367") annotation class T4367
@Tag("JTCSALTO-T4368") annotation class T4368
@Tag("JTCSALTO-T4369") annotation class T4369
@Tag("JTCSALTO-T4370") annotation class T4370
@Tag("JTCSALTO-T4371") annotation class T4371
@Tag("JTCSALTO-T4372") annotation class T4372
@Tag("JTCSALTO-T4373") annotation class T4373
@Tag("JTCSALTO-T4374") annotation class T4374
@Tag("JTCSALTO-T4375") annotation class T4375
@Tag("JTCSALTO-T4376") annotation class T4376
@Tag("JTCSALTO-T4377") annotation class T4377
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client

    @TestFactory
    @T4062 //'Письмо в Банк'. Получить доступные форматы экспорта документа [CLIENT]
    @T4063 //'Письмо в Банк'. Получить доступные форматы экспорта документа [BANK]
    internal fun exportFormatsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankExportFormatTest(clientUser).withId(T4062::class),
                LetterToBankExportFormatTest(bankUser).withId(T4063::class)
            )
        )
    }

    @TestFactory
    @T4050 //'Письмо в Банк'. Экспортировать один документ в формате CSV (проверка имени файла) [CLIENT]
    @T4052 //'Письмо в Банк'. Экспортировать один документ в формате XLS (проверка имени файла) [CLIENT]
    @T4054 //'Письмо в Банк'. Экспортировать один документ в формате XML (проверка имени файла) [CLIENT]
    @T4056 //'Письмо в Банк'. Экспортировать один документ в формате CSV (проверка имени файла) [BANK]
    @T4058 //'Письмо в Банк'. Экспортировать один документ в формате XLS (проверка имени файла) [BANK]
    @T4060 //'Письмо в Банк'. Экспортировать один документ в формате XML (проверка имени файла) [BANK]
    internal fun exportSingleDocFileNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankExportSingleDocFileNameTest(clientUser, CSV).withId(T4050::class),
                LetterToBankExportSingleDocFileNameTest(clientUser, XLSX).withId(T4052::class),
                LetterToBankExportSingleDocFileNameTest(clientUser, XML).withId(T4054::class),

                LetterToBankExportSingleDocFileNameTest(bankUser, CSV).withId(T4056::class),
                LetterToBankExportSingleDocFileNameTest(bankUser, XLSX).withId(T4058::class),
                LetterToBankExportSingleDocFileNameTest(bankUser, XML).withId(T4060::class)
            )
        )
    }

    @TestFactory
    @T4051 //'Письмо в Банк'. Экспортировать несколько документов в формате CSV (проверка имени файла) [CLIENT]
    @T4053 //'Письмо в Банк'. Экспортировать несколько документов в формате XLS (проверка имени файла) [CLIENT]
    @T4055 //'Письмо в Банк'. Экспортировать несколько документов в формате XML (проверка имени файла) [CLIENT]
    @T4057 //'Письмо в Банк'. Экспортировать несколько документов в формате CSV (проверка имени файла) [BANK]
    @T4059 //'Письмо в Банк'. Экспортировать несколько документов в формате XLS (проверка имени файла) [BANK]
    @T4061 //'Письмо в Банк'. Экспортировать несколько документов в формате XML (проверка имени файла) [BANK]
    internal fun exportMultipleDocsFileNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankExportMultipleDocsFileNameTest(clientUser, CSV).withId(T4051::class),
                LetterToBankExportMultipleDocsFileNameTest(clientUser, XLSX).withId(T4052::class),
                LetterToBankExportMultipleDocsFileNameTest(clientUser, XML).withId(T4055::class),

                LetterToBankExportMultipleDocsFileNameTest(bankUser, CSV).withId(T4057::class),
                LetterToBankExportMultipleDocsFileNameTest(bankUser, XLSX).withId(T4059::class),
                LetterToBankExportMultipleDocsFileNameTest(bankUser, XML).withId(T4061::class)
            )
        )
    }

    @TestFactory
    @T4032 //'Письмо в Банк'. Экспортировать один документ в формате CSV [CLIENT]
    @T4033 //'Письмо в Банк'. Экспортировать один документ в формате XLS [CLIENT]
    @T4034 //'Письмо в Банк'. Экспортировать один документ в формате XML [CLIENT]
    @T4035 //'Письмо в Банк'. Экспортировать один документ в формате CSV [BANK]
    @T4036 //'Письмо в Банк'. Экспортировать один документ в формате XLS [BANK]
    @T4037 //'Письмо в Банк'. Экспортировать один документ в формате XML [BANK]
    internal fun exportSingleDocumentTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankExportSingleDocByIdTest(clientUser, CSV).withId(T4032::class),
                LetterToBankExportSingleDocByIdTest(clientUser, XLSX).withId(T4033::class),
                LetterToBankExportSingleDocByIdTest(clientUser, XML).withId(T4034::class),
                LetterToBankExportSingleDocByIdTest(bankUser, CSV).withId(T4035::class),
                LetterToBankExportSingleDocByIdTest(bankUser, XLSX).withId(T4036::class),
                LetterToBankExportSingleDocByIdTest(bankUser, XML).withId(T4037::class)
            )
        )
    }

    @TestFactory
    @T4064 //'Письмо в Банк'. Экспортировать несколько документов в формате CSV [CLIENT]
    @T4065 //'Письмо в Банк'. Экспортировать несколько документов в формате XLS [CLIENT]
    @T4066 //'Письмо в Банк'. Экспортировать несколько документов в формате XML [CLIENT]
    @T4067 //'Письмо в Банк'. Экспортировать несколько документов в формате CSV [BANK]
    @T4068 //'Письмо в Банк'. Экспортировать несколько документов в формате XLS [BANK]
    @T4069 //'Письмо в Банк'. Экспортировать несколько документов в формате XML [BANK]
    internal fun exportMultipleDocumentsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankExportMultipleDocsByIdTest(clientUser, CSV).withId(T4064::class),
                LetterToBankExportMultipleDocsByIdTest(clientUser, XLSX).withId(T4065::class),
                LetterToBankExportMultipleDocsByIdTest(clientUser, XML).withId(T4066::class),
                LetterToBankExportMultipleDocsByIdTest(bankUser, CSV).withId(T4067::class),
                LetterToBankExportMultipleDocsByIdTest(bankUser, XLSX).withId(T4068::class),
                LetterToBankExportMultipleDocsByIdTest(bankUser, XML).withId(T4069::class)
            )
        )
    }

    //region export by Filter (status)
    private val getRecentInStatusParams: (User, LetterToBankStatus) -> Params = { user, status ->
        recentDocFilterData.and(STATUS.eq(status.getUserStatus(user.userType)))
            .toParams(sort = LetterToBankSortingParams.DOCUMENT_NUMBER.asc())
    }

    @TestFactory
    @T4339 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DRAFT') [CLIENT]
    @T4340 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'NEW') [CLIENT]
    @T4341 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'SIGNED') [CLIENT]
    @T4342 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'WRONG_ESIGNATURE') [CLIENT]
    @T4343 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DETAILS_ERROR') [CLIENT]
    @T4344 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'RECALLED') [CLIENT]
    @T4345 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'PROCESSED') [CLIENT]

    @T4346 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'WRONG_ESIGNATURE') [BANK]
    @T4347 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DETAILS_ERROR') [BANK]
    @T4348 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'RECEIVED') [BANK]
    @T4349 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'IN_PROCESSING') [BANK]
    @T4350 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'RECALLED') [BANK]
    @T4351 //'Письмо в Банк'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'PROCESSED') [BANK]
    internal fun exportDocumentsByFilterCsvTests(): List<DynamicTest> {
        fun getCsvTestFor(user: User, status: LetterToBankStatus) = LetterToBankExportDocsByFilterTest(
            user, CSV, getRecentInStatusParams(user, status), " (недавние; статус '$status')"
        )

        return EntityTestGenerator.generate(
            listOf(
                getCsvTestFor(clientUser, LetterToBankStatus.DRAFT).withId(T4339::class),
                getCsvTestFor(clientUser, LetterToBankStatus.NEW).withId(T4340::class),
                getCsvTestFor(clientUser, LetterToBankStatus.SIGNED).withId(T4341::class),
                getCsvTestFor(clientUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4342::class),
                getCsvTestFor(clientUser, LetterToBankStatus.DETAILS_ERROR).withId(T4343::class),
                getCsvTestFor(clientUser, LetterToBankStatus.RECALLED).withId(T4344::class),
                getCsvTestFor(clientUser, LetterToBankStatus.PROCESSED).withId(T4345::class),

                getCsvTestFor(bankUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4346::class),
                getCsvTestFor(bankUser, LetterToBankStatus.DETAILS_ERROR).withId(T4347::class),
                getCsvTestFor(bankUser, LetterToBankStatus.RECEIVED).withId(T4348::class),
                getCsvTestFor(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4349::class),
                getCsvTestFor(bankUser, LetterToBankStatus.RECALLED).withId(T4350::class),
                getCsvTestFor(bankUser, LetterToBankStatus.PROCESSED).withId(T4351::class)
            )
        )
    }

    @TestFactory
    @T4352 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DRAFT') [CLIENT]
    @T4353 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'NEW') [CLIENT]
    @T4354 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'SIGNED') [CLIENT]
    @T4355 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'WRONG_ESIGNATURE') [CLIENT]
    @T4356 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DETAILS_ERROR') [CLIENT]
    @T4357 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'RECALLED') [CLIENT]
    @T4358 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'PROCESSED') [CLIENT]

    @T4359 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'WRONG_ESIGNATURE') [BANK]
    @T4360 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DETAILS_ERROR') [BANK]
    @T4361 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'RECEIVED') [BANK]
    @T4362 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'IN_PROCESSING') [BANK]
    @T4363 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'RECALLED') [BANK]
    @T4364 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'PROCESSED') [BANK]
    internal fun exportDocumentsByFilterXlsxTests(): List<DynamicTest> {
        fun getXlsxTestFor(user: User, status: LetterToBankStatus) = LetterToBankExportDocsByFilterTest(
            user, XLSX, getRecentInStatusParams(user, status), " (недавние; статус '$status')"
        )

        return EntityTestGenerator.generate(
            listOf(
                getXlsxTestFor(clientUser, LetterToBankStatus.DRAFT).withId(T4352::class),
                getXlsxTestFor(clientUser, LetterToBankStatus.NEW).withId(T4353::class),
                getXlsxTestFor(clientUser, LetterToBankStatus.SIGNED).withId(T4354::class),
                getXlsxTestFor(clientUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4355::class),
                getXlsxTestFor(clientUser, LetterToBankStatus.DETAILS_ERROR).withId(T4356::class),
                getXlsxTestFor(clientUser, LetterToBankStatus.RECALLED).withId(T4357::class),
                getXlsxTestFor(clientUser, LetterToBankStatus.PROCESSED).withId(T4358::class),

                getXlsxTestFor(bankUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4359::class),
                getXlsxTestFor(bankUser, LetterToBankStatus.DETAILS_ERROR).withId(T4360::class),
                getXlsxTestFor(bankUser, LetterToBankStatus.RECEIVED).withId(T4361::class),
                getXlsxTestFor(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4362::class),
                getXlsxTestFor(bankUser, LetterToBankStatus.RECALLED).withId(T4363::class),
                getXlsxTestFor(bankUser, LetterToBankStatus.PROCESSED).withId(T4364::class)
            )
        )
    }

    @TestFactory
    @T4365 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DRAFT') [CLIENT]
    @T4366 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'NEW') [CLIENT]
    @T4367 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'SIGNED') [CLIENT]
    @T4368 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'WRONG_ESIGNATURE') [CLIENT]
    @T4369 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DETAILS_ERROR') [CLIENT]
    @T4370 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'RECALLED') [CLIENT]
    @T4371 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'PROCESSED') [CLIENT]

    @T4372 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'WRONG_ESIGNATURE') [BANK]
    @T4373 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DETAILS_ERROR') [BANK]
    @T4374 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'RECEIVED') [BANK]
    @T4375 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'IN_PROCESSING') [BANK]
    @T4376 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'RECALLED') [BANK]
    @T4377 //'Письмо в Банк'. Экспортировать документы по фильтру в формате XML (недавние; статус 'PROCESSED') [BANK]
    internal fun exportDocumentsByFilterXmlTests(): List<DynamicTest> {
        fun getXmlTestFor(user: User, status: LetterToBankStatus) = LetterToBankExportDocsByFilterTest(
            user, XML, getRecentInStatusParams(user, status), " (недавние; статус '$status')"
        )

        return EntityTestGenerator.generate(
            listOf(
                getXmlTestFor(clientUser, LetterToBankStatus.DRAFT).withId(T4365::class),
                getXmlTestFor(clientUser, LetterToBankStatus.NEW).withId(T4366::class),
                getXmlTestFor(clientUser, LetterToBankStatus.SIGNED).withId(T4367::class),
                getXmlTestFor(clientUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4368::class),
                getXmlTestFor(clientUser, LetterToBankStatus.DETAILS_ERROR).withId(T4369::class),
                getXmlTestFor(clientUser, LetterToBankStatus.RECALLED).withId(T4370::class),
                getXmlTestFor(clientUser, LetterToBankStatus.PROCESSED).withId(T4371::class),

                getXmlTestFor(bankUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4372::class),
                getXmlTestFor(bankUser, LetterToBankStatus.DETAILS_ERROR).withId(T4373::class),
                getXmlTestFor(bankUser, LetterToBankStatus.RECEIVED).withId(T4374::class),
                getXmlTestFor(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4375::class),
                getXmlTestFor(bankUser, LetterToBankStatus.RECALLED).withId(T4376::class),
                getXmlTestFor(bankUser, LetterToBankStatus.PROCESSED).withId(T4377::class)
            )
        )
    }
    //endregion
}