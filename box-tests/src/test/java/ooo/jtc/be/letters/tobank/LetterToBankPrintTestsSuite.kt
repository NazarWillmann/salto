package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_PRINT
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintFormatTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintMultipleDocsByIdTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintMultipleDocsFileNameTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintSingleDocByIdTest_InStatus
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintSingleDocByIdTest_WithAttach
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintSingleDocByIdTest_WithSignature
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintSingleDocFileNameTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintSingleDocNoStampTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintTableDocsTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankPrintTableFormatTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.print.PrintExportFormat.HTML
import ooo.jtc.generic.print.PrintExportFormat.PDF
import ooo.jtc.generic.print.PrintExportFormat.RTF
import ooo.jtc.generic.print.PrintParams
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_PRINT)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' print suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_PRINT
class LetterToBankPrintTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3937") annotation class T3937
@Tag("JTCSALTO-T3938") annotation class T3938
@Tag("JTCSALTO-T3939") annotation class T3939
@Tag("JTCSALTO-T3940") annotation class T3940
@Tag("JTCSALTO-T3941") annotation class T3941
@Tag("JTCSALTO-T3942") annotation class T3942
@Tag("JTCSALTO-T3943") annotation class T3943
@Tag("JTCSALTO-T3944") annotation class T3944
@Tag("JTCSALTO-T3945") annotation class T3945
@Tag("JTCSALTO-T3946") annotation class T3946
@Tag("JTCSALTO-T4038") annotation class T4038
@Tag("JTCSALTO-T4039") annotation class T4039
@Tag("JTCSALTO-T4040") annotation class T4040
@Tag("JTCSALTO-T4041") annotation class T4041
@Tag("JTCSALTO-T4042") annotation class T4042
@Tag("JTCSALTO-T4043") annotation class T4043
@Tag("JTCSALTO-T4044") annotation class T4044
@Tag("JTCSALTO-T4045") annotation class T4045
@Tag("JTCSALTO-T4046") annotation class T4046
@Tag("JTCSALTO-T4047") annotation class T4047
@Tag("JTCSALTO-T4048") annotation class T4048
@Tag("JTCSALTO-T4049") annotation class T4049
@Tag("JTCSALTO-T4070") annotation class T4070
@Tag("JTCSALTO-T4071") annotation class T4071
@Tag("JTCSALTO-T4072") annotation class T4072
@Tag("JTCSALTO-T4073") annotation class T4073
@Tag("JTCSALTO-T4074") annotation class T4074
@Tag("JTCSALTO-T4075") annotation class T4075
@Tag("JTCSALTO-T4187") annotation class T4187
@Tag("JTCSALTO-T4188") annotation class T4188
@Tag("JTCSALTO-T4189") annotation class T4189
@Tag("JTCSALTO-T4190") annotation class T4190
@Tag("JTCSALTO-T4191") annotation class T4191
@Tag("JTCSALTO-T4192") annotation class T4192
@Tag("JTCSALTO-T4235") annotation class T4235
@Tag("JTCSALTO-T4236") annotation class T4236
@Tag("JTCSALTO-T4237") annotation class T4237
@Tag("JTCSALTO-T4238") annotation class T4238
@Tag("JTCSALTO-T4239") annotation class T4239
@Tag("JTCSALTO-T4240") annotation class T4240
@Tag("JTCSALTO-T4294") annotation class T4294
@Tag("JTCSALTO-T4295") annotation class T4295
@Tag("JTCSALTO-T4296") annotation class T4296
@Tag("JTCSALTO-T4297") annotation class T4297
@Tag("JTCSALTO-T4298") annotation class T4298
@Tag("JTCSALTO-T4299") annotation class T4299
@Tag("JTCSALTO-T4300") annotation class T4300
@Tag("JTCSALTO-T4301") annotation class T4301
@Tag("JTCSALTO-T4302") annotation class T4302
@Tag("JTCSALTO-T4303") annotation class T4303
@Tag("JTCSALTO-T4304") annotation class T4304
@Tag("JTCSALTO-T4305") annotation class T4305
@Tag("JTCSALTO-T4306") annotation class T4306
@Tag("JTCSALTO-T4307") annotation class T4307
@Tag("JTCSALTO-T4308") annotation class T4308
@Tag("JTCSALTO-T4309") annotation class T4309
@Tag("JTCSALTO-T4310") annotation class T4310
@Tag("JTCSALTO-T4311") annotation class T4311
@Tag("JTCSALTO-T4312") annotation class T4312
@Tag("JTCSALTO-T4313") annotation class T4313
@Tag("JTCSALTO-T4314") annotation class T4314
@Tag("JTCSALTO-T4315") annotation class T4315
@Tag("JTCSALTO-T4316") annotation class T4316
@Tag("JTCSALTO-T4317") annotation class T4317
@Tag("JTCSALTO-T4318") annotation class T4318
@Tag("JTCSALTO-T4319") annotation class T4319
@Tag("JTCSALTO-T4320") annotation class T4320
@Tag("JTCSALTO-T4321") annotation class T4321
@Tag("JTCSALTO-T4322") annotation class T4322
@Tag("JTCSALTO-T4323") annotation class T4323
@Tag("JTCSALTO-T4324") annotation class T4324
@Tag("JTCSALTO-T4325") annotation class T4325
@Tag("JTCSALTO-T4326") annotation class T4326
@Tag("JTCSALTO-T4327") annotation class T4327
@Tag("JTCSALTO-T4328") annotation class T4328
@Tag("JTCSALTO-T4329") annotation class T4329
@Tag("JTCSALTO-T4330") annotation class T4330
@Tag("JTCSALTO-T4331") annotation class T4331
@Tag("JTCSALTO-T4332") annotation class T4332
@Tag("JTCSALTO-T4333") annotation class T4333
@Tag("JTCSALTO-T4334") annotation class T4334
@Tag("JTCSALTO-T4335") annotation class T4335
@Tag("JTCSALTO-T4336") annotation class T4336
@Tag("JTCSALTO-T4337") annotation class T4337
@Tag("JTCSALTO-T4338") annotation class T4338
@Tag("JTCSALTO-T4534") annotation class T4534
@Tag("JTCSALTO-T4535") annotation class T4535
@Tag("JTCSALTO-T4536") annotation class T4536
@Tag("JTCSALTO-T4537") annotation class T4537
@Tag("JTCSALTO-T4538") annotation class T4538
@Tag("JTCSALTO-T4539") annotation class T4539
@Tag("JTCSALTO-T4540") annotation class T4540
@Tag("JTCSALTO-T4541") annotation class T4541
@Tag("JTCSALTO-T4542") annotation class T4542
//@formatter:on
//endregion

    private val bankUser by lazy { Users.bankOperator }
    private val clientUser by lazy { Users.client }

    @TestFactory
    @T3937 //'Письмо в Банк'. Получить доступные форматы печати документа [CLIENT]
    @T3938 //'Письмо в Банк'. Получить доступные форматы печати документа [BANK]
    @T3939 //'Письмо в Банк'. Получить доступные форматы печати списка документов [CLIENT]
    @T3940 //'Письмо в Банк'. Получить доступные форматы печати списка документов [BANK]
    internal fun printFormatsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintFormatTest(clientUser).withId(T3937::class),
                LetterToBankPrintFormatTest(bankUser).withId(T3938::class),
                LetterToBankPrintTableFormatTest(clientUser).withId(T3939::class),
                LetterToBankPrintTableFormatTest(bankUser).withId(T3940::class)
            )
        )
    }

    @TestFactory
    @T4038 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка имени файла) [CLIENT]
    @T4040 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка имени файла) [CLIENT]
    @T4042 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка имени файла) [CLIENT]
    @T4044 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка имени файла) [BANK]
    @T4046 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка имени файла) [BANK]
    @T4048 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка имени файла) [BANK]
    internal fun printSingleDocFileNameTests(): List<DynamicTest> {
        val printParams = PrintParams(needSignInfo = false)
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintSingleDocFileNameTest(clientUser, HTML, printParams).withId(T4038::class),
                LetterToBankPrintSingleDocFileNameTest(clientUser, PDF, printParams).withId(T4040::class),
                LetterToBankPrintSingleDocFileNameTest(clientUser, RTF, printParams).withId(T4042::class),

                LetterToBankPrintSingleDocFileNameTest(bankUser, HTML, printParams).withId(T4044::class),
                LetterToBankPrintSingleDocFileNameTest(bankUser, PDF, printParams).withId(T4046::class),
                LetterToBankPrintSingleDocFileNameTest(bankUser, RTF, printParams).withId(T4048::class)
            )
        )
    }

    @TestFactory
    @T4039 //'Письмо в Банк'. Распечатать несколько документов в формате HTML (проверка имени файла) [CLIENT]
    @T4041 //'Письмо в Банк'. Распечатать несколько документов в формате PDF (проверка имени файла) [CLIENT]
    @T4043 //'Письмо в Банк'. Распечатать несколько документов в формате RTF (проверка имени файла) [CLIENT]
    @T4045 //'Письмо в Банк'. Распечатать несколько документов в формате HTML (проверка имени файла) [BANK]
    @T4047 //'Письмо в Банк'. Распечатать несколько документов в формате PDF (проверка имени файла) [BANK]
    @T4049 //'Письмо в Банк'. Распечатать несколько документов в формате RTF (проверка имени файла) [BANK]
    internal fun printMultipleDocsFileNameTests(): List<DynamicTest> {
        val printParams = PrintParams(needSignInfo = false)
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintMultipleDocsFileNameTest(clientUser, HTML, printParams).withId(T4039::class),
                LetterToBankPrintMultipleDocsFileNameTest(clientUser, PDF, printParams).withId(T4041::class),
                LetterToBankPrintMultipleDocsFileNameTest(clientUser, RTF, printParams).withId(T4043::class),

                LetterToBankPrintMultipleDocsFileNameTest(bankUser, HTML, printParams).withId(T4045::class),
                LetterToBankPrintMultipleDocsFileNameTest(bankUser, PDF, printParams).withId(T4047::class),
                LetterToBankPrintMultipleDocsFileNameTest(bankUser, RTF, printParams).withId(T4049::class)
            )
        )
    }

    @TestFactory
    @T3941 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого без подписи и вложений) [CLIENT]
    @T3942 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого без подписи и вложений) [CLIENT]
    @T3943 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого без подписи и вложений) [CLIENT]
    @T3944 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого без подписи и вложений) [BANK]
    @T3945 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого без подписи и вложений) [BANK]
    @T3946 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого без подписи и вложений) [BANK]
    internal fun basicPrintSingleDocumentTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(clientUser, HTML).withId(T3941::class),
                LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(clientUser, PDF).withId(T3942::class),
                LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(clientUser, RTF).withId(T3943::class),

                LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(bankUser, HTML).withId(T3944::class),
                LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(bankUser, PDF).withId(T3945::class),
                LetterToBankPrintSingleDocByIdTest_WithoutAttachAndSignature(bankUser, RTF).withId(T3946::class)
            )
        )
    }

    @TestFactory
    @T4235 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого с данными подписи) [CLIENT]
    @T4236 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого с данными подписи) [CLIENT]
    @T4237 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого с данными подписи) [CLIENT]
    @T4238 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого с данными подписи) [BANK]
    @T4239 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого с данными подписи) [BANK]
    @T4240 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого с данными подписи) [BANK]
    internal fun printSingleDocumentWithSignaturesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintSingleDocByIdTest_WithSignature(clientUser, HTML).withId(T4235::class),
                LetterToBankPrintSingleDocByIdTest_WithSignature(clientUser, PDF).withId(T4236::class),
                LetterToBankPrintSingleDocByIdTest_WithSignature(clientUser, RTF).withId(T4237::class),

                LetterToBankPrintSingleDocByIdTest_WithSignature(bankUser, HTML).withId(T4238::class),
                LetterToBankPrintSingleDocByIdTest_WithSignature(bankUser, PDF).withId(T4239::class),
                LetterToBankPrintSingleDocByIdTest_WithSignature(bankUser, RTF).withId(T4240::class)
            )
        )
    }

    @TestFactory
    @T4294 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого с вложениями) [CLIENT]
    @T4295 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого с вложениями) [CLIENT]
    @T4296 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого с вложениями) [CLIENT]
    @T4297 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого с вложениями) [BANK]
    @T4298 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого с вложениями) [BANK]
    @T4299 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого с вложениями) [BANK]
    internal fun printSingleDocumentWithAttachmentsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintSingleDocByIdTest_WithAttach(clientUser, HTML).withId(T4294::class),
                LetterToBankPrintSingleDocByIdTest_WithAttach(clientUser, PDF).withId(T4295::class),
                LetterToBankPrintSingleDocByIdTest_WithAttach(clientUser, RTF).withId(T4296::class),
                LetterToBankPrintSingleDocByIdTest_WithAttach(bankUser, HTML).withId(T4297::class),
                LetterToBankPrintSingleDocByIdTest_WithAttach(bankUser, PDF).withId(T4298::class),
                LetterToBankPrintSingleDocByIdTest_WithAttach(bankUser, RTF).withId(T4299::class)
            )
        )
    }

    //region print single by status
    @TestFactory
    @T4300 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DRAFT') [CLIENT]
    @T4301 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'NEW') [CLIENT]
    @T4302 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'SIGNED') [CLIENT]
    @T4303 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'WRONG_ESIGNATURE') [CLIENT]
    @T4304 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DETAILS_ERROR') [CLIENT]
    @T4305 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'RECALLED') [CLIENT]
    @T4306 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'PROCESSED') [CLIENT]

    @T4307 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'WRONG_ESIGNATURE') [BANK]
    @T4308 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'DETAILS_ERROR') [BANK]
    @T4309 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'RECEIVED') [BANK]
    @T4310 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'IN_PROCESSING') [BANK]
    @T4311 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'RECALLED') [BANK]
    @T4312 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка содержимого для статуса 'PROCESSED') [BANK]
    internal fun printSingleDocumentInStatusHtmlTests(): List<DynamicTest> {
        fun getHtmlTestFor(user: User, status: LetterToBankStatus) =
            LetterToBankPrintSingleDocByIdTest_InStatus(user, HTML, status)

        return EntityTestGenerator.generate(
            listOf(
                getHtmlTestFor(clientUser, LetterToBankStatus.DRAFT).withId(T4300::class),
                getHtmlTestFor(clientUser, LetterToBankStatus.NEW).withId(T4301::class),
                getHtmlTestFor(clientUser, LetterToBankStatus.SIGNED).withId(T4302::class),
                getHtmlTestFor(clientUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4303::class),
                getHtmlTestFor(clientUser, LetterToBankStatus.DETAILS_ERROR).withId(T4304::class),
                getHtmlTestFor(clientUser, LetterToBankStatus.RECALLED).withId(T4305::class),
                getHtmlTestFor(clientUser, LetterToBankStatus.PROCESSED).withId(T4306::class),

                getHtmlTestFor(bankUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4307::class),
                getHtmlTestFor(bankUser, LetterToBankStatus.DETAILS_ERROR).withId(T4308::class),
                getHtmlTestFor(bankUser, LetterToBankStatus.RECEIVED).withId(T4309::class),
                getHtmlTestFor(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4310::class),
                getHtmlTestFor(bankUser, LetterToBankStatus.RECALLED).withId(T4311::class),
                getHtmlTestFor(bankUser, LetterToBankStatus.PROCESSED).withId(T4312::class)
            )
        )
    }

    @TestFactory
    @T4313 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DRAFT') [CLIENT]
    @T4314 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'NEW') [CLIENT]
    @T4315 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'SIGNED') [CLIENT]
    @T4316 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'WRONG_ESIGNATURE') [CLIENT]
    @T4317 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DETAILS_ERROR') [CLIENT]
    @T4318 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'RECALLED') [CLIENT]
    @T4319 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'PROCESSED') [CLIENT]

    @T4320 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'WRONG_ESIGNATURE') [BANK]
    @T4321 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'DETAILS_ERROR') [BANK]
    @T4322 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'RECEIVED') [BANK]
    @T4323 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'IN_PROCESSING') [BANK]
    @T4324 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'RECALLED') [BANK]
    @T4325 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка содержимого для статуса 'PROCESSED') [BANK]
    internal fun printSingleDocumentInStatusPdfTests(): List<DynamicTest> {
        fun getPdfTestFor(user: User, status: LetterToBankStatus) =
            LetterToBankPrintSingleDocByIdTest_InStatus(user, PDF, status)

        return EntityTestGenerator.generate(
            listOf(
                getPdfTestFor(clientUser, LetterToBankStatus.DRAFT).withId(T4313::class),
                getPdfTestFor(clientUser, LetterToBankStatus.NEW).withId(T4314::class),
                getPdfTestFor(clientUser, LetterToBankStatus.SIGNED).withId(T4315::class),
                getPdfTestFor(clientUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4316::class),
                getPdfTestFor(clientUser, LetterToBankStatus.DETAILS_ERROR).withId(T4317::class),
                getPdfTestFor(clientUser, LetterToBankStatus.RECALLED).withId(T4318::class),
                getPdfTestFor(clientUser, LetterToBankStatus.PROCESSED).withId(T4319::class),

                getPdfTestFor(bankUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4320::class),
                getPdfTestFor(bankUser, LetterToBankStatus.DETAILS_ERROR).withId(T4321::class),
                getPdfTestFor(bankUser, LetterToBankStatus.RECEIVED).withId(T4322::class),
                getPdfTestFor(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4323::class),
                getPdfTestFor(bankUser, LetterToBankStatus.RECALLED).withId(T4324::class),
                getPdfTestFor(bankUser, LetterToBankStatus.PROCESSED).withId(T4325::class)
            )
        )
    }

    @TestFactory
    @T4326 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DRAFT') [CLIENT]
    @T4327 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'NEW') [CLIENT]
    @T4328 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'SIGNED') [CLIENT]
    @T4329 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'WRONG_ESIGNATURE') [CLIENT]
    @T4330 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DETAILS_ERROR') [CLIENT]
    @T4331 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'RECALLED') [CLIENT]
    @T4332 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'PROCESSED') [CLIENT]

    @T4333 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'WRONG_ESIGNATURE') [BANK]
    @T4334 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'DETAILS_ERROR') [BANK]
    @T4335 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'RECEIVED') [BANK]
    @T4336 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'IN_PROCESSING') [BANK]
    @T4337 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'RECALLED') [BANK]
    @T4338 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка содержимого для статуса 'PROCESSED') [BANK]
    internal fun printSingleDocumentInStatusRtfTests(): List<DynamicTest> {
        fun getRtfTestFor(user: User, status: LetterToBankStatus) =
            LetterToBankPrintSingleDocByIdTest_InStatus(user, RTF, status)

        return EntityTestGenerator.generate(
            listOf(
                getRtfTestFor(clientUser, LetterToBankStatus.DRAFT).withId(T4326::class),
                getRtfTestFor(clientUser, LetterToBankStatus.NEW).withId(T4327::class),
                getRtfTestFor(clientUser, LetterToBankStatus.SIGNED).withId(T4328::class),
                getRtfTestFor(clientUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4329::class),
                getRtfTestFor(clientUser, LetterToBankStatus.DETAILS_ERROR).withId(T4330::class),
                getRtfTestFor(clientUser, LetterToBankStatus.RECALLED).withId(T4331::class),
                getRtfTestFor(clientUser, LetterToBankStatus.PROCESSED).withId(T4332::class),

                getRtfTestFor(bankUser, LetterToBankStatus.WRONG_ESIGNATURE).withId(T4333::class),
                getRtfTestFor(bankUser, LetterToBankStatus.DETAILS_ERROR).withId(T4334::class),
                getRtfTestFor(bankUser, LetterToBankStatus.RECEIVED).withId(T4335::class),
                getRtfTestFor(bankUser, LetterToBankStatus.IN_PROCESSING).withId(T4336::class),
                getRtfTestFor(bankUser, LetterToBankStatus.RECALLED).withId(T4337::class),
                getRtfTestFor(bankUser, LetterToBankStatus.PROCESSED).withId(T4338::class)
            )
        )
    }
    //endregion

    @TestFactory
    @T4070 //'Письмо в Банк'. Распечатать несколько документов в формате HTML [CLIENT]
    @T4071 //'Письмо в Банк'. Распечатать несколько документов в формате PDF [CLIENT]
    @T4072 //'Письмо в Банк'. Распечатать несколько документов в формате RTF [CLIENT]
    @T4073 //'Письмо в Банк'. Распечатать несколько документов в формате HTML [BANK]
    @T4074 //'Письмо в Банк'. Распечатать несколько документов в формате PDF [BANK]
    @T4075 //'Письмо в Банк'. Распечатать несколько документов в формате RTF [BANK]
    internal fun printMultipleDocumentsTests(): List<DynamicTest> {
        val printParams = PrintParams(needSignInfo = false)
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintMultipleDocsByIdTest(clientUser, HTML, printParams).withId(T4070::class),
                LetterToBankPrintMultipleDocsByIdTest(clientUser, PDF, printParams).withId(T4071::class),
                LetterToBankPrintMultipleDocsByIdTest(clientUser, RTF, printParams).withId(T4072::class),

                LetterToBankPrintMultipleDocsByIdTest(bankUser, HTML, printParams).withId(T4073::class),
                LetterToBankPrintMultipleDocsByIdTest(bankUser, PDF, printParams).withId(T4074::class),
                LetterToBankPrintMultipleDocsByIdTest(bankUser, RTF, printParams).withId(T4075::class)
            )
        )
    }

    @TestFactory
    @T4187 //'Письмо в Банк'. Распечатать реестр документов в формате HTML [CLIENT]
    @T4188 //'Письмо в Банк'. Распечатать реестр документов в формате PDF [CLIENT]
    @T4189 //'Письмо в Банк'. Распечатать реестр документов в формате RTF [CLIENT]
    @T4190 //'Письмо в Банк'. Распечатать реестр документов в формате HTML [BANK]
    @T4191 //'Письмо в Банк'. Распечатать реестр документов в формате PDF [BANK]
    @T4192 //'Письмо в Банк'. Распечатать реестр документов в формате RTF [BANK]
    internal fun printDocumentTableTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintTableDocsTest(clientUser, HTML).withId(T4187::class),
                LetterToBankPrintTableDocsTest(clientUser, PDF).withId(T4188::class),
                LetterToBankPrintTableDocsTest(clientUser, RTF).withId(T4189::class),
                LetterToBankPrintTableDocsTest(bankUser, HTML).withId(T4190::class),
                LetterToBankPrintTableDocsTest(bankUser, PDF).withId(T4191::class),
                LetterToBankPrintTableDocsTest(bankUser, RTF).withId(T4192::class)
            )
        )
    }

    @TestFactory
    @T4537 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка отсутствия штампа для статуса 'DRAFT') [CLIENT]
    @T4534 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка отсутствия штампа для статуса 'NEW') [CLIENT]
    @T4536 //'Письмо в Банк'. Распечатать один документ в формате HTML (проверка отсутствия штампа для статуса 'SIGNED') [CLIENT]
    @T4540 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка отсутствия штампа для статуса 'DRAFT') [CLIENT]
    @T4541 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка отсутствия штампа для статуса 'NEW') [CLIENT]
    @T4539 //'Письмо в Банк'. Распечатать один документ в формате PDF (проверка отсутствия штампа для статуса 'SIGNED') [CLIENT]
    @T4542 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка отсутствия штампа для статуса 'DRAFT') [CLIENT]
    @T4535 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка отсутствия штампа для статуса 'NEW') [CLIENT]
    @T4538 //'Письмо в Банк'. Распечатать один документ в формате RTF (проверка отсутствия штампа для статуса 'SIGNED') [CLIENT]
    internal fun printSingleDocNoStampTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankPrintSingleDocNoStampTest(clientUser, HTML, LetterToBankStatus.DRAFT).withId(T4537::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, HTML, LetterToBankStatus.NEW).withId(T4534::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, HTML, LetterToBankStatus.SIGNED).withId(T4536::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, PDF, LetterToBankStatus.DRAFT).withId(T4540::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, PDF, LetterToBankStatus.NEW).withId(T4541::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, PDF, LetterToBankStatus.SIGNED).withId(T4539::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, RTF, LetterToBankStatus.DRAFT).withId(T4542::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, RTF, LetterToBankStatus.NEW).withId(T4535::class),
                LetterToBankPrintSingleDocNoStampTest(clientUser, RTF, LetterToBankStatus.SIGNED).withId(T4538::class),
            )
        )
    }
}
