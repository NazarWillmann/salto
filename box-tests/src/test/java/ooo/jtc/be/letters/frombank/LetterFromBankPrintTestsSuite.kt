package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_PRINT
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintFormatTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintMultipleDocsByIdTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintMultipleDocsFileNameTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintSingleDocByIdTest_InStatus
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintSingleDocByIdTest_WithAttach
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintSingleDocByIdTest_WithSignature
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintSingleDocFileNameTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintSingleDocNoStampTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintTableDocsTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankPrintTableFormatTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.print.PrintExportFormat.HTML
import ooo.jtc.generic.print.PrintExportFormat.PDF
import ooo.jtc.generic.print.PrintExportFormat.RTF
import ooo.jtc.generic.print.PrintParams
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_PRINT)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' print suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_PRINT
class LetterFromBankPrintTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4462") annotation class T4462
@Tag("JTCSALTO-T4463") annotation class T4463
@Tag("JTCSALTO-T4464") annotation class T4464
@Tag("JTCSALTO-T4465") annotation class T4465
@Tag("JTCSALTO-T4466") annotation class T4466
@Tag("JTCSALTO-T4467") annotation class T4467
@Tag("JTCSALTO-T4468") annotation class T4468
@Tag("JTCSALTO-T4469") annotation class T4469
@Tag("JTCSALTO-T4470") annotation class T4470
@Tag("JTCSALTO-T4471") annotation class T4471
@Tag("JTCSALTO-T4472") annotation class T4472
@Tag("JTCSALTO-T4473") annotation class T4473
@Tag("JTCSALTO-T4474") annotation class T4474
@Tag("JTCSALTO-T4475") annotation class T4475
@Tag("JTCSALTO-T4476") annotation class T4476
@Tag("JTCSALTO-T4477") annotation class T4477
@Tag("JTCSALTO-T4478") annotation class T4478
@Tag("JTCSALTO-T4479") annotation class T4479
@Tag("JTCSALTO-T4480") annotation class T4480
@Tag("JTCSALTO-T4481") annotation class T4481
@Tag("JTCSALTO-T4482") annotation class T4482
@Tag("JTCSALTO-T4483") annotation class T4483
@Tag("JTCSALTO-T4484") annotation class T4484
@Tag("JTCSALTO-T4485") annotation class T4485
@Tag("JTCSALTO-T4486") annotation class T4486
@Tag("JTCSALTO-T4487") annotation class T4487
@Tag("JTCSALTO-T4488") annotation class T4488
@Tag("JTCSALTO-T4489") annotation class T4489
@Tag("JTCSALTO-T4490") annotation class T4490
@Tag("JTCSALTO-T4491") annotation class T4491
@Tag("JTCSALTO-T4492") annotation class T4492
@Tag("JTCSALTO-T4493") annotation class T4493
@Tag("JTCSALTO-T4494") annotation class T4494
@Tag("JTCSALTO-T4495") annotation class T4495
@Tag("JTCSALTO-T4496") annotation class T4496
@Tag("JTCSALTO-T4497") annotation class T4497
@Tag("JTCSALTO-T4498") annotation class T4498
@Tag("JTCSALTO-T4499") annotation class T4499
@Tag("JTCSALTO-T4500") annotation class T4500
@Tag("JTCSALTO-T4501") annotation class T4501
@Tag("JTCSALTO-T4502") annotation class T4502
@Tag("JTCSALTO-T4503") annotation class T4503
@Tag("JTCSALTO-T4504") annotation class T4504
@Tag("JTCSALTO-T4505") annotation class T4505
@Tag("JTCSALTO-T4506") annotation class T4506
@Tag("JTCSALTO-T4507") annotation class T4507
@Tag("JTCSALTO-T4508") annotation class T4508
@Tag("JTCSALTO-T4509") annotation class T4509
@Tag("JTCSALTO-T4510") annotation class T4510
@Tag("JTCSALTO-T4511") annotation class T4511
@Tag("JTCSALTO-T4512") annotation class T4512
@Tag("JTCSALTO-T4513") annotation class T4513
@Tag("JTCSALTO-T4514") annotation class T4514
@Tag("JTCSALTO-T4515") annotation class T4515
@Tag("JTCSALTO-T4516") annotation class T4516
@Tag("JTCSALTO-T4517") annotation class T4517
@Tag("JTCSALTO-T4518") annotation class T4518
@Tag("JTCSALTO-T4519") annotation class T4519
@Tag("JTCSALTO-T4520") annotation class T4520
@Tag("JTCSALTO-T4521") annotation class T4521
@Tag("JTCSALTO-T4522") annotation class T4522
@Tag("JTCSALTO-T4523") annotation class T4523
@Tag("JTCSALTO-T4524") annotation class T4524
@Tag("JTCSALTO-T4525") annotation class T4525
@Tag("JTCSALTO-T4526") annotation class T4526
@Tag("JTCSALTO-T4527") annotation class T4527
@Tag("JTCSALTO-T4528") annotation class T4528
@Tag("JTCSALTO-T4820") annotation class T4820
@Tag("JTCSALTO-T4821") annotation class T4821
@Tag("JTCSALTO-T4822") annotation class T4822
@Tag("JTCSALTO-T4823") annotation class T4823
@Tag("JTCSALTO-T4824") annotation class T4824
@Tag("JTCSALTO-T4825") annotation class T4825
@Tag("JTCSALTO-T4826") annotation class T4826
@Tag("JTCSALTO-T4827") annotation class T4827
@Tag("JTCSALTO-T4828") annotation class T4828
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client

    @TestFactory
    @T4462 //'Письмо из Банка'. Получить доступные форматы печати документа [CLIENT]
    @T4463 //'Письмо из Банка'. Получить доступные форматы печати документа [BANK]
    @T4464 //'Письмо из Банка'. Получить доступные форматы печати списка документов [CLIENT]
    @T4465 //'Письмо из Банка'. Получить доступные форматы печати списка документов [BANK]
    internal fun printFormatsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintFormatTest(clientUser).withId(T4462::class),
                LetterFromBankPrintFormatTest(bankUser).withId(T4463::class),
                LetterFromBankPrintTableFormatTest(clientUser).withId(T4464::class),
                LetterFromBankPrintTableFormatTest(bankUser).withId(T4465::class)
            )
        )
    }

    @TestFactory
    @T4466 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка имени файла) [CLIENT]
    @T4467 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка имени файла) [CLIENT]
    @T4468 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка имени файла) [CLIENT]
    @T4469 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка имени файла) [BANK]
    @T4470 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка имени файла) [BANK]
    @T4471 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка имени файла) [BANK]
    internal fun printSingleDocFileNameTests(): List<DynamicTest> {
        val printParams = PrintParams(needSignInfo = false)
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintSingleDocFileNameTest(clientUser, HTML, printParams).withId(T4466::class),
                LetterFromBankPrintSingleDocFileNameTest(clientUser, PDF, printParams).withId(T4467::class),
                LetterFromBankPrintSingleDocFileNameTest(clientUser, RTF, printParams).withId(T4468::class),
                LetterFromBankPrintSingleDocFileNameTest(bankUser, HTML, printParams).withId(T4469::class),
                LetterFromBankPrintSingleDocFileNameTest(bankUser, PDF, printParams).withId(T4470::class),
                LetterFromBankPrintSingleDocFileNameTest(bankUser, RTF, printParams).withId(T4471::class)
            )
        )
    }

    @TestFactory
    @T4472 //'Письмо из Банка'. Распечатать несколько документов в формате HTML (проверка имени файла) [CLIENT]
    @T4473 //'Письмо из Банка'. Распечатать несколько документов в формате PDF (проверка имени файла) [CLIENT]
    @T4474 //'Письмо из Банка'. Распечатать несколько документов в формате RTF (проверка имени файла) [CLIENT]
    @T4475 //'Письмо из Банка'. Распечатать несколько документов в формате HTML (проверка имени файла) [BANK]
    @T4476 //'Письмо из Банка'. Распечатать несколько документов в формате PDF (проверка имени файла) [BANK]
    @T4477 //'Письмо из Банка'. Распечатать несколько документов в формате RTF (проверка имени файла) [BANK]
    internal fun printMultipleDocsFileNameTests(): List<DynamicTest> {
        val printParams = PrintParams(needSignInfo = false)
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintMultipleDocsFileNameTest(clientUser, HTML, printParams).withId(T4472::class),
                LetterFromBankPrintMultipleDocsFileNameTest(clientUser, PDF, printParams).withId(T4473::class),
                LetterFromBankPrintMultipleDocsFileNameTest(clientUser, RTF, printParams).withId(T4474::class),
                LetterFromBankPrintMultipleDocsFileNameTest(bankUser, HTML, printParams).withId(T4475::class),
                LetterFromBankPrintMultipleDocsFileNameTest(bankUser, PDF, printParams).withId(T4476::class),
                LetterFromBankPrintMultipleDocsFileNameTest(bankUser, RTF, printParams).withId(T4477::class)
            )
        )
    }

    @TestFactory
    @T4478 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого без подписи и вложений) [CLIENT]
    @T4479 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого без подписи и вложений) [CLIENT]
    @T4480 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого без подписи и вложений) [CLIENT]
    @T4481 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого без подписи и вложений) [BANK]
    @T4482 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого без подписи и вложений) [BANK]
    @T4483 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого без подписи и вложений) [BANK]
    internal fun basicPrintSingleDocumentTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(clientUser, HTML).withId(T4478::class),
                LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(clientUser, PDF).withId(T4479::class),
                LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(clientUser, RTF).withId(T4480::class),
                LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(bankUser, HTML).withId(T4481::class),
                LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(bankUser, PDF).withId(T4482::class),
                LetterFromBankPrintSingleDocByIdTest_WithoutAttachAndSignature(bankUser, RTF).withId(T4483::class)
            )
        )
    }

    @TestFactory
    @T4484 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого с данными подписи) [CLIENT]
    @T4485 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого с данными подписи) [CLIENT]
    @T4486 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого с данными подписи) [CLIENT]
    @T4487 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого с данными подписи) [BANK]
    @T4488 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого с данными подписи) [BANK]
    @T4489 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого с данными подписи) [BANK]
    internal fun printSingleDocumentWithSignaturesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintSingleDocByIdTest_WithSignature(clientUser, HTML).withId(T4484::class),
                LetterFromBankPrintSingleDocByIdTest_WithSignature(clientUser, PDF).withId(T4485::class),
                LetterFromBankPrintSingleDocByIdTest_WithSignature(clientUser, RTF).withId(T4486::class),
                LetterFromBankPrintSingleDocByIdTest_WithSignature(bankUser, HTML).withId(T4487::class),
                LetterFromBankPrintSingleDocByIdTest_WithSignature(bankUser, PDF).withId(T4488::class),
                LetterFromBankPrintSingleDocByIdTest_WithSignature(bankUser, RTF).withId(T4489::class)
            )
        )
    }

    @TestFactory
    @T4490 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого с вложениями) [CLIENT]
    @T4491 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого с вложениями) [CLIENT]
    @T4492 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого с вложениями) [CLIENT]
    @T4493 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого с вложениями) [BANK]
    @T4494 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого с вложениями) [BANK]
    @T4495 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого с вложениями) [BANK]
    internal fun printSingleDocumentWithAttachmentsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintSingleDocByIdTest_WithAttach(clientUser, HTML).withId(T4490::class),
                LetterFromBankPrintSingleDocByIdTest_WithAttach(clientUser, PDF).withId(T4491::class),
                LetterFromBankPrintSingleDocByIdTest_WithAttach(clientUser, RTF).withId(T4492::class),
                LetterFromBankPrintSingleDocByIdTest_WithAttach(bankUser, HTML).withId(T4493::class),
                LetterFromBankPrintSingleDocByIdTest_WithAttach(bankUser, PDF).withId(T4494::class),
                LetterFromBankPrintSingleDocByIdTest_WithAttach(bankUser, RTF).withId(T4495::class)
            )
        )
    }

    //region print single by status
    @TestFactory
    @T4496 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DRAFT') [BANK]
    @T4497 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'NEW') [BANK]
    @T4498 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'SIGNED') [BANK]
    @T4499 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'WRONG_ESIGNATURE') [BANK]
    @T4500 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DETAILS_ERROR') [BANK]
    @T4501 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DELIVERED') [BANK]
    @T4502 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DELIVERED') [CLIENT]
    internal fun printSingleDocumentInStatusHtmlTests(): List<DynamicTest> {
        fun getHtmlTestFor(user: User, status: LetterFromBankStatus) =
            LetterFromBankPrintSingleDocByIdTest_InStatus(user, HTML, status)

        return EntityTestGenerator.generate(
            listOf(
                getHtmlTestFor(bankUser, LetterFromBankStatus.DRAFT).withId(T4496::class),
                getHtmlTestFor(bankUser, LetterFromBankStatus.NEW).withId(T4497::class),
                getHtmlTestFor(bankUser, LetterFromBankStatus.SIGNED).withId(T4498::class),
                getHtmlTestFor(bankUser, LetterFromBankStatus.WRONG_ESIGNATURE).withId(T4499::class),
                getHtmlTestFor(bankUser, LetterFromBankStatus.DETAILS_ERROR).withId(T4500::class),
                getHtmlTestFor(bankUser, LetterFromBankStatus.DELIVERED).withId(T4501::class),

                getHtmlTestFor(clientUser, LetterFromBankStatus.DELIVERED).withId(T4502::class)
            )
        )
    }

    @TestFactory
    @T4503 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DRAFT') [BANK]
    @T4504 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'NEW') [BANK]
    @T4505 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'SIGNED') [BANK]
    @T4506 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'WRONG_ESIGNATURE') [BANK]
    @T4507 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DETAILS_ERROR') [BANK]
    @T4508 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DELIVERED') [BANK]
    @T4509 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DELIVERED') [CLIENT]
    internal fun printSingleDocumentInStatusPdfTests(): List<DynamicTest> {
        fun getPdfTestFor(user: User, status: LetterFromBankStatus) =
            LetterFromBankPrintSingleDocByIdTest_InStatus(user, PDF, status)

        return EntityTestGenerator.generate(
            listOf(
                getPdfTestFor(bankUser, LetterFromBankStatus.DRAFT).withId(T4503::class),
                getPdfTestFor(bankUser, LetterFromBankStatus.NEW).withId(T4504::class),
                getPdfTestFor(bankUser, LetterFromBankStatus.SIGNED).withId(T4505::class),
                getPdfTestFor(bankUser, LetterFromBankStatus.WRONG_ESIGNATURE).withId(T4506::class),
                getPdfTestFor(bankUser, LetterFromBankStatus.DETAILS_ERROR).withId(T4507::class),
                getPdfTestFor(bankUser, LetterFromBankStatus.DELIVERED).withId(T4508::class),

                getPdfTestFor(clientUser, LetterFromBankStatus.DELIVERED).withId(T4509::class)
            )
        )
    }

    @TestFactory
    @T4510 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DRAFT') [BANK]
    @T4511 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'NEW') [BANK]
    @T4512 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'SIGNED') [BANK]
    @T4513 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'WRONG_ESIGNATURE') [BANK]
    @T4514 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DETAILS_ERROR') [BANK]
    @T4515 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DELIVERED') [BANK]
    @T4516 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DELIVERED') [CLIENT]
    internal fun printSingleDocumentInStatusRtfTests(): List<DynamicTest> {
        fun getRtfTestFor(user: User, status: LetterFromBankStatus) =
            LetterFromBankPrintSingleDocByIdTest_InStatus(user, RTF, status)

        return EntityTestGenerator.generate(
            listOf(
                getRtfTestFor(bankUser, LetterFromBankStatus.DRAFT).withId(T4510::class),
                getRtfTestFor(bankUser, LetterFromBankStatus.NEW).withId(T4511::class),
                getRtfTestFor(bankUser, LetterFromBankStatus.SIGNED).withId(T4512::class),
                getRtfTestFor(bankUser, LetterFromBankStatus.WRONG_ESIGNATURE).withId(T4513::class),
                getRtfTestFor(bankUser, LetterFromBankStatus.DETAILS_ERROR).withId(T4514::class),
                getRtfTestFor(bankUser, LetterFromBankStatus.DELIVERED).withId(T4515::class),

                getRtfTestFor(clientUser, LetterFromBankStatus.DELIVERED).withId(T4516::class)
            )
        )
    }
    //endregion

    @TestFactory
    @T4517 //'Письмо из Банка'. Распечатать несколько документов в формате HTML [CLIENT]
    @T4518 //'Письмо из Банка'. Распечатать несколько документов в формате PDF [CLIENT]
    @T4519 //'Письмо из Банка'. Распечатать несколько документов в формате RTF [CLIENT]
    @T4520 //'Письмо из Банка'. Распечатать несколько документов в формате HTML [BANK]
    @T4521 //'Письмо из Банка'. Распечатать несколько документов в формате PDF [BANK]
    @T4522 //'Письмо из Банка'. Распечатать несколько документов в формате RTF [BANK]
    internal fun printMultipleDocumentsTests(): List<DynamicTest> {
        val printParams = PrintParams(needSignInfo = false)
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintMultipleDocsByIdTest(clientUser, HTML, printParams).withId(T4517::class),
                LetterFromBankPrintMultipleDocsByIdTest(clientUser, PDF, printParams).withId(T4518::class),
                LetterFromBankPrintMultipleDocsByIdTest(clientUser, RTF, printParams).withId(T4519::class),
                LetterFromBankPrintMultipleDocsByIdTest(bankUser, HTML, printParams).withId(T4520::class),
                LetterFromBankPrintMultipleDocsByIdTest(bankUser, PDF, printParams).withId(T4521::class),
                LetterFromBankPrintMultipleDocsByIdTest(bankUser, RTF, printParams).withId(T4522::class)
            )
        )
    }

    @TestFactory
    @T4523 //'Письмо из Банка'. Распечатать реестр документов в формате HTML [CLIENT]
    @T4524 //'Письмо из Банка'. Распечатать реестр документов в формате PDF [CLIENT]
    @T4525 //'Письмо из Банка'. Распечатать реестр документов в формате RTF [CLIENT]
    @T4526 //'Письмо из Банка'. Распечатать реестр документов в формате HTML [BANK]
    @T4527 //'Письмо из Банка'. Распечатать реестр документов в формате PDF [BANK]
    @T4528 //'Письмо из Банка'. Распечатать реестр документов в формате RTF [BANK]
    internal fun printDocumentTableTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintTableDocsTest(clientUser, HTML).withId(T4523::class),
                LetterFromBankPrintTableDocsTest(clientUser, PDF).withId(T4524::class),
                LetterFromBankPrintTableDocsTest(clientUser, RTF).withId(T4525::class),
                LetterFromBankPrintTableDocsTest(bankUser, HTML).withId(T4526::class),
                LetterFromBankPrintTableDocsTest(bankUser, PDF).withId(T4527::class),
                LetterFromBankPrintTableDocsTest(bankUser, RTF).withId(T4528::class)
            )
        )
    }

    @TestFactory
    @T4820 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка отсутствия штампа для статуса 'DRAFT') [BANK]
    @T4821 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка отсутствия штампа для статуса 'NEW') [BANK]
    @T4822 //'Письмо из Банка'. Распечатать один документ в формате HTML (проверка отсутствия штампа для статуса 'SIGNED') [BANK]
    @T4823 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка отсутствия штампа для статуса 'DRAFT') [BANK]
    @T4824 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка отсутствия штампа для статуса 'NEW') [BANK]
    @T4825 //'Письмо из Банка'. Распечатать один документ в формате PDF (проверка отсутствия штампа для статуса 'SIGNED') [BANK]
    @T4826 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка отсутствия штампа для статуса 'DRAFT') [BANK]
    @T4827 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка отсутствия штампа для статуса 'NEW') [BANK]
    @T4828 //'Письмо из Банка'. Распечатать один документ в формате RTF (проверка отсутствия штампа для статуса 'SIGNED') [BANK]
    internal fun printSingleDocNoStampTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankPrintSingleDocNoStampTest(bankUser, HTML, LetterFromBankStatus.DRAFT).withId(T4820::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, HTML, LetterFromBankStatus.NEW).withId(T4821::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, HTML, LetterFromBankStatus.SIGNED).withId(T4822::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, PDF, LetterFromBankStatus.DRAFT).withId(T4823::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, PDF, LetterFromBankStatus.NEW).withId(T4824::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, PDF, LetterFromBankStatus.SIGNED).withId(T4825::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, RTF, LetterFromBankStatus.DRAFT).withId(T4826::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, RTF, LetterFromBankStatus.NEW).withId(T4827::class),
                LetterFromBankPrintSingleDocNoStampTest(bankUser, RTF, LetterFromBankStatus.SIGNED).withId(T4828::class),
            )
        )
    }
}
