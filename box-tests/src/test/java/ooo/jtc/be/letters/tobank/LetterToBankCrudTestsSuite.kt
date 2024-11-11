package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_CRUD
import ooo.jtc.api.letters.tobank.tests.BankLetterToBankGetPageTest
import ooo.jtc.api.letters.tobank.tests.BankLetterToBankGetTest
import ooo.jtc.api.letters.tobank.tests.ClientLetterToBankCreateTest
import ooo.jtc.api.letters.tobank.tests.ClientLetterToBankDeleteTest
import ooo.jtc.api.letters.tobank.tests.ClientLetterToBankGetPageTest
import ooo.jtc.api.letters.tobank.tests.ClientLetterToBankGetTest
import ooo.jtc.api.letters.tobank.tests.ClientLetterToBankUpdateTest
import ooo.jtc.api.letters.tobank.tests.ClientLetterToBankWithAttachCreateTest
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createSentLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getLetterToBankDtoForCreate
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getOrCreateLetterToBankDto
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
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
@Story(TestStoryLetterToBank.LETTER_TO_BANK_CRUD)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' CRUD suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_CRUD
class LetterToBankCrudTestsSuite {
    //region Tags
    //@formatter:off
    @Tag("JTCSALTO-T1931") annotation class T1931
    @Tag("JTCSALTO-T1932") annotation class T1932
    @Tag("JTCSALTO-T1933") annotation class T1933
    @Tag("JTCSALTO-T1934") annotation class T1934
    @Tag("JTCSALTO-T1935") annotation class T1935
    @Tag("JTCSALTO-T3951") annotation class T3951
    @Tag("JTCSALTO-T3952") annotation class T3952
    @Tag("JTCSALTO-T3953") annotation class T3953
    @Tag("JTCSALTO-T3954") annotation class T3954
    @Tag("JTCSALTO-T3955") annotation class T3955
    //@formatter:on
    //endregion

    val bankUser = Users.bankOperator
    val clientUser = Users.client

    @TestFactory
    @T1931 //'Письмо в Банк'. CRUD: Создаем запись от пользователя [CLIENT]
    @T1932 //'Письмо в Банк'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T1933 //'Письмо в Банк'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T1934 //'Письмо в Банк'. CRUD: Обновляем запись от пользователя [CLIENT]
    @T1935 //'Письмо в Банк'. CRUD: Удаляем запись от пользователя [CLIENT]
    internal fun letterToBankCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ClientLetterToBankCreateTest(clientUser).withId(T1931::class),
                ClientLetterToBankGetTest(clientUser).withId(T1932::class),
                ClientLetterToBankGetPageTest(clientUser).withId(T1933::class),
                ClientLetterToBankUpdateTest(clientUser).withId(T1934::class),
                ClientLetterToBankDeleteTest(clientUser).withId(T1935::class)
            )
        )
    }

    @TestFactory
    @T3951 //'Письмо в Банк'. CRUD: Создаем запись с вложениями от пользователя [CLIENT]
    @T3952 //'Письмо в Банк'. CRUD: Обновляем запись от пользователя (добавление вложений) [CLIENT]
    @T3953 //'Письмо в Банк'. CRUD: Обновляем запись от пользователя (удаление вложений) [CLIENT]
    internal fun letterToBankAttachmentRelatedCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                createWithAttachmentTest(clientUser).withId(T3951::class),
                updateAddAttachmentsTest(clientUser).withId(T3952::class),
                updateRemoveAttachmentsTest(clientUser).withId(T3953::class)
            )
        )
    }

    @TestFactory
    @T3954 //'Письмо в Банк'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3955 //'Письмо в Банк'. CRUD: Получаем страницу записей от пользователя [BANK]
    internal fun letterToBankCrudBankTests(): List<DynamicTest> {
        val letterToBankSent = getOrCreateLetterToBankDto(
            searchingUser = bankUser,
            creatorClientUser = clientUser,
            createLtbFunc = { createSentLetterToBank(clientUser, bankUser) }
        )
        val tests = listOf(
            BankLetterToBankGetTest(bankUser, letterToGet = { letterToBankSent }).withId(T3954::class),
            BankLetterToBankGetPageTest(bankUser).withId(T3955::class)
        )

        return EntityTestGenerator.generate(tests)
    }


    //region attachment-related tests
    private val createWithAttachmentTest = { clientUser: User ->
        ClientLetterToBankWithAttachCreateTest(
            clientUser = clientUser,
            dtoForCreation = {
                getLetterToBankDtoForCreate(creatorClientUser = clientUser, attachments = listOf(DEFAULT_ATTACH_FILE))
            }
        )
    }

    private val updateAddAttachmentsTest = { clientUser: User ->
        ClientLetterToBankUpdateTest(
            user = clientUser,
            dtoForCreation = { getLetterToBankDtoForCreate(clientUser) },
            dtoForUpdate = {
                LetterToBankPrepareSteps.addAttachmentsToDto(it, clientUser, listOf(DEFAULT_ATTACH_FILE))
            },
            preCheckingHandling = { ltb -> ltb.apply { attachments?.forEach { it.dataHash = null } } },
            additionalNameDetails = " (добавление вложений)"
        )
    }

    private val updateRemoveAttachmentsTest = { clientUser: User ->
        ClientLetterToBankUpdateTest(
            user = clientUser,
            dtoForCreation = {
                getLetterToBankDtoForCreate(creatorClientUser = clientUser, attachments = listOf(DEFAULT_ATTACH_FILE))
            },
            dtoForUpdate = {
                it.apply { attachments = emptyList() }
                it.apply { isHasAttach = false }
            },
            additionalNameDetails = " (удаление вложений)"
        )
    }
    //endregion
}