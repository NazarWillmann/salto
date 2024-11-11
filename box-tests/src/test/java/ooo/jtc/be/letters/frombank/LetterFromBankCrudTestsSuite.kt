package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_CRUD
import ooo.jtc.api.letters.frombank.tests.LetterFromBankCreateTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankDeleteTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankGetPageTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankGetTest
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createDeliveredLetterFromBank
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto
import ooo.jtc.api.letters.frombank.tests.LetterFromBankUpdateTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankWithAttachCreateTest
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
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
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_CRUD)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' CRUD suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_CRUD
class LetterFromBankCrudTestsSuite {
    //region Tags
    //@formatter:off
    @Tag("JTCSALTO-T3956") annotation class T3956
    @Tag("JTCSALTO-T3958") annotation class T3958
    @Tag("JTCSALTO-T3982") annotation class T3982
    @Tag("JTCSALTO-T3983") annotation class T3983
    @Tag("JTCSALTO-T3984") annotation class T3984
    @Tag("JTCSALTO-T3985") annotation class T3985
    @Tag("JTCSALTO-T3986") annotation class T3986
    @Tag("JTCSALTO-T3957") annotation class T3957
    @Tag("JTCSALTO-T4001") annotation class T4001
    @Tag("JTCSALTO-T4002") annotation class T4002
    //@formatter:on
    //endregion

    val bankUser by lazy { Users.bankOperator }
    val clientUser by lazy { Users.client }

    @TestFactory
    @T3956 //'Письмо из Банка'. CRUD: Создаем запись от пользователя [BANK]
    @T3957 //'Письмо из Банка'. CRUD: Обновляем запись от пользователя [BANK]
    @T3958 //'Письмо из Банка'. CRUD: Удаляем документ от пользователя [BANK]
    @T3982 //'Письмо из Банка'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3983 //'Письмо из Банка'. CRUD: Получаем страницу записей от пользователя [BANK]
    internal fun letterFromBankCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankCreateTest(bankUser).withId(T3956::class),
                LetterFromBankUpdateTest(bankUser).withId(T3957::class),
                LetterFromBankDeleteTest(bankUser).withId(T3958::class),
                LetterFromBankGetTest(bankUser).withId(T3982::class),
                LetterFromBankGetPageTest(bankUser).withId(T3983::class)
            )
        )
    }

    @TestFactory
    @T3984 //'Письмо из Банка'. CRUD: Создаем запись с вложениями от пользователя [BANK]
    @T3985 //'Письмо из Банка'. CRUD: Обновляем запись от пользователя (добавление вложений) [BANK]
    @T3986 //'Письмо из Банка'. CRUD: Обновляем запись от пользователя (удаление вложений) [BANK]
    internal fun letterFromBankAttachmentRelatedCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                createWithAttachmentTest(bankUser).withId(T3984::class),
                updateAddAttachmentsTest(bankUser).withId(T3985::class),
                updateRemoveAttachmentsTest(bankUser).withId(T3986::class)
            )
        )
    }

    @TestFactory
    @T4001 //'Письмо из Банка'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T4002 //'Письмо из Банка'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    internal fun letterFromBankCrudClientTests(): List<DynamicTest> {
        val letterFromBankSent = getOrCreateLetterFromBankDto(
            searchingUser = clientUser,
            creatorBankUser = bankUser,
            createLfbFunc = { createDeliveredLetterFromBank(bankUser, clientUser) }
        )
        val tests = listOf(
            LetterFromBankGetTest(clientUser, letterToGet = { letterFromBankSent }).withId(T4001::class),
            LetterFromBankGetPageTest(clientUser).withId(T4002::class)
        )
        return EntityTestGenerator.generate(tests)
    }

    //region attachment-related tests
    private val createWithAttachmentTest = { bankUser: User ->
        LetterFromBankWithAttachCreateTest(
            bankUser = bankUser,
            dtoForCreation = {
                getLetterFromBankDtoForCreate(creatorBankUser = bankUser, attachments = listOf(DEFAULT_ATTACH_FILE))
            }
        )
    }

    private val updateAddAttachmentsTest = { bankUser: User ->
        LetterFromBankUpdateTest(
            bankUser = bankUser,
            dtoForCreation = { getLetterFromBankDtoForCreate(creatorBankUser = bankUser) },
            dtoForUpdate = {
                LetterFromBankPrepareSteps.addAttachmentsToDto(it, bankUser, listOf(DEFAULT_ATTACH_FILE))
            },
            preCheckingHandling = { ltb -> ltb.apply { attachments?.forEach { it.dataHash = null } } },
            additionalNameDetails = " (добавление вложений)"
        )
    }

    private val updateRemoveAttachmentsTest = { bankUser: User ->
        LetterFromBankUpdateTest(
            bankUser = bankUser,
            dtoForCreation = {
                getLetterFromBankDtoForCreate(creatorBankUser = bankUser, attachments = listOf(DEFAULT_ATTACH_FILE))
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