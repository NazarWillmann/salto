package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_EXPORT
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createLetterFromBankInStatus
import ooo.jtc.api.letters.frombank.tests.LetterFromBankExportDocsByFilterTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankExportFormatTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankExportMultipleDocsByIdTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankExportMultipleDocsFileNameTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankExportSingleDocByIdTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankExportSingleDocFileNameTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.generic.print.PrintExportFormat.CSV
import ooo.jtc.generic.print.PrintExportFormat.XML
import ooo.jtc.generic.print.PrintExportFormat.XLSX
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.STATUS
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams
import ooo.jtc.uaa.User
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_EXPORT)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' export suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_EXPORT
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LetterFromBankExportTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4543") annotation class T4543
@Tag("JTCSALTO-T4544") annotation class T4544
@Tag("JTCSALTO-T4545") annotation class T4545
@Tag("JTCSALTO-T4546") annotation class T4546
@Tag("JTCSALTO-T4547") annotation class T4547
@Tag("JTCSALTO-T4548") annotation class T4548
@Tag("JTCSALTO-T4549") annotation class T4549
@Tag("JTCSALTO-T4550") annotation class T4550
@Tag("JTCSALTO-T4551") annotation class T4551
@Tag("JTCSALTO-T4552") annotation class T4552
@Tag("JTCSALTO-T4553") annotation class T4553
@Tag("JTCSALTO-T4554") annotation class T4554
@Tag("JTCSALTO-T4555") annotation class T4555
@Tag("JTCSALTO-T4556") annotation class T4556
@Tag("JTCSALTO-T4557") annotation class T4557
@Tag("JTCSALTO-T4558") annotation class T4558
@Tag("JTCSALTO-T4559") annotation class T4559
@Tag("JTCSALTO-T4560") annotation class T4560
@Tag("JTCSALTO-T4561") annotation class T4561
@Tag("JTCSALTO-T4562") annotation class T4562
@Tag("JTCSALTO-T4563") annotation class T4563
@Tag("JTCSALTO-T4564") annotation class T4564
@Tag("JTCSALTO-T4565") annotation class T4565
@Tag("JTCSALTO-T4566") annotation class T4566
@Tag("JTCSALTO-T4567") annotation class T4567
@Tag("JTCSALTO-T4568") annotation class T4568
@Tag("JTCSALTO-T4569") annotation class T4569
@Tag("JTCSALTO-T4570") annotation class T4570
@Tag("JTCSALTO-T4571") annotation class T4571
@Tag("JTCSALTO-T4572") annotation class T4572
@Tag("JTCSALTO-T4573") annotation class T4573
@Tag("JTCSALTO-T4574") annotation class T4574
@Tag("JTCSALTO-T4575") annotation class T4575
@Tag("JTCSALTO-T4576") annotation class T4576
@Tag("JTCSALTO-T4577") annotation class T4577
@Tag("JTCSALTO-T4578") annotation class T4578
@Tag("JTCSALTO-T4579") annotation class T4579
@Tag("JTCSALTO-T4580") annotation class T4580
@Tag("JTCSALTO-T4581") annotation class T4581
@Tag("JTCSALTO-T4582") annotation class T4582
@Tag("JTCSALTO-T4583") annotation class T4583
@Tag("JTCSALTO-T4584") annotation class T4584
@Tag("JTCSALTO-T4585") annotation class T4585
@Tag("JTCSALTO-T4586") annotation class T4586
@Tag("JTCSALTO-T4587") annotation class T4587
@Tag("JTCSALTO-T4588") annotation class T4588
@Tag("JTCSALTO-T4589") annotation class T4589
//@formatter:on
//endregion

    private val bankUser by lazy { Users.bankOperator }
    private val clientUser by lazy { Users.client }

    @BeforeAll
    fun createSomeLetters() {
        createLetterFromBankInStatus(creatorBankUser = bankUser, receiverClientUser = clientUser, status = DRAFT)
        createLetterFromBankInStatus(bankUser, clientUser, DRAFT)
        createLetterFromBankInStatus(bankUser, clientUser, DRAFT)
        createLetterFromBankInStatus(bankUser, clientUser, NEW)
        createLetterFromBankInStatus(bankUser, clientUser, SIGNED)
        createLetterFromBankInStatus(bankUser, clientUser, WRONG_ESIGNATURE)
        createLetterFromBankInStatus(bankUser, clientUser, DETAILS_ERROR)
        createLetterFromBankInStatus(bankUser, clientUser, DELIVERED)
    }

    @TestFactory
    @T4543 //'Письмо из Банка'. Получить доступные форматы экспорта документа [CLIENT]
    @T4544 //'Письмо из Банка'. Получить доступные форматы экспорта документа [BANK]
    internal fun exportFormatsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankExportFormatTest(clientUser).withId(T4543::class),
                LetterFromBankExportFormatTest(bankUser).withId(T4544::class)
            )
        )
    }

    @TestFactory
    @T4545 //'Письмо из Банка'. Экспортировать один документ в формате CSV (проверка имени файла) [CLIENT]
    @T4546 //'Письмо из Банка'. Экспортировать один документ в формате XLSX (проверка имени файла) [CLIENT]
    @T4547 //'Письмо из Банка'. Экспортировать один документ в формате XML (проверка имени файла) [CLIENT]
    @T4548 //'Письмо из Банка'. Экспортировать один документ в формате CSV (проверка имени файла) [BANK]
    @T4549 //'Письмо из Банка'. Экспортировать один документ в формате XLSX (проверка имени файла) [BANK]
    @T4550 //'Письмо из Банка'. Экспортировать один документ в формате XML (проверка имени файла) [BANK]
    internal fun exportSingleDocFileNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankExportSingleDocFileNameTest(clientUser, CSV).withId(T4545::class),
                LetterFromBankExportSingleDocFileNameTest(clientUser, XLSX).withId(T4546::class),
                LetterFromBankExportSingleDocFileNameTest(clientUser, XML).withId(T4547::class),
                LetterFromBankExportSingleDocFileNameTest(bankUser, CSV).withId(T4548::class),
                LetterFromBankExportSingleDocFileNameTest(bankUser, XLSX).withId(T4549::class),
                LetterFromBankExportSingleDocFileNameTest(bankUser, XML).withId(T4550::class)
            )
        )
    }

    @TestFactory
    @T4551 //'Письмо из Банка'. Экспортировать несколько документов в формате CSV (проверка имени файла) [CLIENT]
    @T4552 //'Письмо из Банка'. Экспортировать несколько документов в формате XLSX (проверка имени файла) [CLIENT]
    @T4553 //'Письмо из Банка'. Экспортировать несколько документов в формате XML (проверка имени файла) [CLIENT]
    @T4554 //'Письмо из Банка'. Экспортировать несколько документов в формате CSV (проверка имени файла) [BANK]
    @T4555 //'Письмо из Банка'. Экспортировать несколько документов в формате XLSX (проверка имени файла) [BANK]
    @T4556 //'Письмо из Банка'. Экспортировать несколько документов в формате XML (проверка имени файла) [BANK]
    internal fun exportMultipleDocsFileNameTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankExportMultipleDocsFileNameTest(clientUser, CSV).withId(T4551::class),
                LetterFromBankExportMultipleDocsFileNameTest(clientUser, XLSX).withId(T4552::class),
                LetterFromBankExportMultipleDocsFileNameTest(clientUser, XML).withId(T4553::class),
                LetterFromBankExportMultipleDocsFileNameTest(bankUser, CSV).withId(T4554::class),
                LetterFromBankExportMultipleDocsFileNameTest(bankUser, XLSX).withId(T4555::class),
                LetterFromBankExportMultipleDocsFileNameTest(bankUser, XML).withId(T4556::class)
            )
        )
    }

    @TestFactory
    @T4557 //'Письмо из Банка'. Экспортировать один документ в формате CSV [CLIENT]
    @T4558 //'Письмо из Банка'. Экспортировать один документ в формате XLSX [CLIENT]
    @T4559 //'Письмо из Банка'. Экспортировать один документ в формате XML [CLIENT]
    @T4560 //'Письмо из Банка'. Экспортировать один документ в формате CSV [BANK]
    @T4561 //'Письмо из Банка'. Экспортировать один документ в формате XLSX [BANK]
    @T4562 //'Письмо из Банка'. Экспортировать один документ в формате XML [BANK]
    internal fun exportSingleDocumentTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankExportSingleDocByIdTest(clientUser, CSV).withId(T4557::class),
                LetterFromBankExportSingleDocByIdTest(clientUser, XLSX).withId(T4558::class),
                LetterFromBankExportSingleDocByIdTest(clientUser, XML).withId(T4559::class),
                LetterFromBankExportSingleDocByIdTest(bankUser, CSV).withId(T4560::class),
                LetterFromBankExportSingleDocByIdTest(bankUser, XLSX).withId(T4561::class),
                LetterFromBankExportSingleDocByIdTest(bankUser, XML).withId(T4562::class)
            )
        )
    }

    @TestFactory
    @T4563 //'Письмо из Банка'. Экспортировать несколько документов в формате CSV [CLIENT]
    @T4564 //'Письмо из Банка'. Экспортировать несколько документов в формате XLSX [CLIENT]
    @T4565 //'Письмо из Банка'. Экспортировать несколько документов в формате XML [CLIENT]
    @T4566 //'Письмо из Банка'. Экспортировать несколько документов в формате CSV [BANK]
    @T4567 //'Письмо из Банка'. Экспортировать несколько документов в формате XLSX [BANK]
    @T4568 //'Письмо из Банка'. Экспортировать несколько документов в формате XML [BANK]
    internal fun exportMultipleDocumentsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankExportMultipleDocsByIdTest(clientUser, CSV).withId(T4563::class),
                LetterFromBankExportMultipleDocsByIdTest(clientUser, XLSX).withId(T4564::class),
                LetterFromBankExportMultipleDocsByIdTest(clientUser, XML).withId(T4565::class),
                LetterFromBankExportMultipleDocsByIdTest(bankUser, CSV).withId(T4566::class),
                LetterFromBankExportMultipleDocsByIdTest(bankUser, XLSX).withId(T4567::class),
                LetterFromBankExportMultipleDocsByIdTest(bankUser, XML).withId(T4568::class)
            )
        )
    }

    //region export by Filter (status)
    private val getRecentInStatusParams: (User, LetterFromBankStatus) -> Params = { user, status ->
        recentDocFilterData.and(STATUS.eq(status.getUserStatus(user.userType)))
            .toParams(sort = LetterFromBankSortingParams.DOCUMENT_NUMBER.desc())
    }

    @TestFactory
    @T4569 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DRAFT') [BANK]
    @T4570 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'NEW') [BANK]
    @T4571 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'SIGNED') [BANK]
    @T4572 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'WRONG_ESIGNATURE') [BANK]
    @T4573 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DETAILS_ERROR') [BANK]
    @T4574 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DELIVERED') [BANK]
    @T4575 //'Письмо из Банка'. Экспортировать документы по фильтру в формате CSV (недавние; статус 'DELIVERED') [CLIENT]
    internal fun exportDocumentsByFilterCsvTests(): List<DynamicTest> {
        fun getCsvTestFor(user: User, status: LetterFromBankStatus) = LetterFromBankExportDocsByFilterTest(
            user, CSV, getRecentInStatusParams(user, status), " (недавние; статус '$status')"
        )

        return EntityTestGenerator.generate(
            listOf(
                getCsvTestFor(bankUser, status = DRAFT).withId(T4569::class),
                getCsvTestFor(bankUser, status = NEW).withId(T4570::class),
                getCsvTestFor(bankUser, status = SIGNED).withId(T4571::class),
                getCsvTestFor(bankUser, status = WRONG_ESIGNATURE).withId(T4572::class),
                getCsvTestFor(bankUser, status = DETAILS_ERROR).withId(T4573::class),
                getCsvTestFor(bankUser, status = DELIVERED).withId(T4574::class),

                getCsvTestFor(clientUser, status = DELIVERED).withId(T4575::class)
            )
        )
    }

    @TestFactory
    @T4576 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DRAFT') [BANK]
    @T4577 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'NEW') [BANK]
    @T4578 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'SIGNED') [BANK]
    @T4579 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'WRONG_ESIGNATURE') [BANK]
    @T4580 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DETAILS_ERROR') [BANK]
    @T4581 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DELIVERED') [BANK]
    @T4582 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XLSX (недавние; статус 'DELIVERED') [CLIENT]
    internal fun exportDocumentsByFilterXlsxTests(): List<DynamicTest> {
        fun getXlsxTestFor(user: User, status: LetterFromBankStatus) = LetterFromBankExportDocsByFilterTest(
            user, XLSX, getRecentInStatusParams(user, status), " (недавние; статус '$status')"
        )

        return EntityTestGenerator.generate(
            listOf(
                getXlsxTestFor(bankUser, status = DRAFT).withId(T4576::class),
                getXlsxTestFor(bankUser, status = NEW).withId(T4577::class),
                getXlsxTestFor(bankUser, status = SIGNED).withId(T4578::class),
                getXlsxTestFor(bankUser, status = WRONG_ESIGNATURE).withId(T4579::class),
                getXlsxTestFor(bankUser, status = DETAILS_ERROR).withId(T4580::class),
                getXlsxTestFor(bankUser, status = DELIVERED).withId(T4581::class),

                getXlsxTestFor(clientUser, status = DELIVERED).withId(T4582::class)
            )
        )
    }

    @TestFactory
    @T4583 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DRAFT') [BANK]
    @T4584 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'NEW') [BANK]
    @T4585 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'SIGNED') [BANK]
    @T4586 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'WRONG_ESIGNATURE') [BANK]
    @T4587 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DETAILS_ERROR') [BANK]
    @T4588 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DELIVERED') [BANK]
    @T4589 //'Письмо из Банка'. Экспортировать документы по фильтру в формате XML (недавние; статус 'DELIVERED') [CLIENT]
    internal fun exportDocumentsByFilterXmlTests(): List<DynamicTest> {
        fun getXmlTestFor(user: User, status: LetterFromBankStatus) = LetterFromBankExportDocsByFilterTest(
            user, XML, getRecentInStatusParams(user, status), " (недавние; статус '$status')"
        )

        return EntityTestGenerator.generate(
            listOf(
                getXmlTestFor(bankUser, status = DRAFT).withId(T4583::class),
                getXmlTestFor(bankUser, status = NEW).withId(T4584::class),
                getXmlTestFor(bankUser, status = SIGNED).withId(T4585::class),
                getXmlTestFor(bankUser, status = WRONG_ESIGNATURE).withId(T4586::class),
                getXmlTestFor(bankUser, status = DETAILS_ERROR).withId(T4587::class),
                getXmlTestFor(bankUser, status = DELIVERED).withId(T4588::class),

                getXmlTestFor(clientUser, status = DELIVERED).withId(T4589::class)
            )
        )
    }
    //endregion
}