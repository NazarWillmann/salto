package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_OTHER
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.api.letters.frombank.tests.FEATURE_LETTER_FROM_BANK_DOC_API
import ooo.jtc.api.letters.frombank.tests.LetterFromBankAbstractOtherTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankCheckSelfUnSignTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankGetSignaturesTestBank
import ooo.jtc.api.letters.frombank.tests.LetterFromBankGetSignaturesTestClient
import ooo.jtc.api.letters.frombank.tests.LetterFromBankOtherTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankSelfUnSignTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankSendTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankSendTicketTest
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.getOrException
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.time.LocalDate

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_OTHER)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' other suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_OTHER
class LetterFromBankOtherTestsSuite {
 //region Tags
//@formatter:off
    @Tag("JTCSALTO-T4003") annotation class T4003
    @Tag("JTCSALTO-T4004") annotation class T4004
    @Tag("JTCSALTO-T4005") annotation class T4005
    @Tag("JTCSALTO-T4006") annotation class T4006
    @Tag("JTCSALTO-T4024") annotation class T4024
    @Tag("JTCSALTO-T4025") annotation class T4025
    @Tag("JTCSALTO-T4445") annotation class T4445
    @Tag("JTCSALTO-T4530") annotation class T4530
    @Tag("JTCSALTO-T4531") annotation class T4531
    @Tag("JTCSALTO-T4592") annotation class T4592
    @Tag("JTCSALTO-T4593") annotation class T4593
    @Tag("JTCSALTO-T4594") annotation class T4594
    @Tag("JTCSALTO-T4669") annotation class T4669
    @Tag("JTCSALTO-T4670") annotation class T4670
    @Tag("JTCSALTO-T5256") annotation class T5256
//@formatter:on
//endregion

    private val clientUser: User by lazy { Users.client }
    private val bankUser: User by lazy { Users.bankOperator }

    /**
     * Пользователь с ровно одной записью в таблице branch_representative.
     * Нужен для проверки условий предзаполнения полей документов с логикой,
     * которая зависит от количества записей.
     */
    private val uniqueBankRepresentative: User by lazy { Users.superBankOperator }

    @TestFactory
    @T4003 //'Письмо из Банка'. Создать черновик [BANK]
    @T4004 //'Письмо из Банка'. Получение предзаполненного письма по id организации с множеством представителей [BANK]
    @T5256 //'Письмо из Банка'. Получение предзаполненного письма по id организации с единым представителем [BANK]
    internal fun otherTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                createDraftTest(bankUser, LetterFromBankPrepareSteps.createLetterFromBankDto(bankUser, clientUser))
                    .withId(T4003::class),
                getPrefillTest(bankUser, "с множеством представителей").withId(T4004::class),
                getPrefillTest(uniqueBankRepresentative, "с единым представителем").withId(T5256::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T4005 //'Письмо из Банка'. Копирование (без вложений) Письма [BANK]
    @T4006 //'Письмо из Банка'. Копирование (с вложениями) Письма [BANK]
    @T4024 //'Письмо из Банка'. Создание ответа на Письмо в Банк (без вложения) [BANK]
    @T4025 //'Письмо из Банка'. Создание ответа на Письмо в Банк (с вложением) [BANK]
    internal fun singleThreadOtherTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                copyWithoutAttachmentsTest(bankUser).withId(T4005::class),
                copyWithAttachmentsTest(uniqueBankRepresentative).withId(T4006::class),
                createAnswerWithoutAttachTest(uniqueBankRepresentative, clientUser).withId(T4024::class),
                //TODO Sergeyev [2021.02.11]: add tests for multibranched bankUser
                createAnswerWithAttachTest(bankUser, clientUser).withId(T4025::class)
            )
        )
    }

    @TestFactory
    @T4445 //'Письмо из Банка'. Отправка документа Клиенту. Проверка корректности статуса
    internal fun letterFromBankSendTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankSendTest(
                    bankUser = bankUser,
                    clientUser = clientUser
                ).withId(T4445::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.SAME_THREAD)
    @T4530 //'Письмо из Банка'. Просмотр списка подписей на Банке [BANK]
    @T4531 //'Письмо из Банка'. Просмотр списка подписей на Клиенте [CLIENT]
    internal fun getSignaturesTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankGetSignaturesTestBank(
                    bankUser,
                    "Просмотр списка подписей на Банке",
                ).withId(T4530::class),
                LetterFromBankGetSignaturesTestClient(
                    bankUser, clientUser,
                    "Просмотр списка подписей на Клиенте",
                ).withId(T4531::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T4592 //'Письмо из Банка'. Получение квитка об отправке Письма в статусе 'DELIVERED' [BANK]
    @T4593 //'Письмо из Банка'. Получение квитка об отправке Письма в статусе 'DETAILS_ERROR' [BANK]
    @T4594 //'Письмо из Банка'. Получение квитка об отправке Письма в статусе 'WRONG_ESIGNATURE' [BANK]
    internal fun ticketsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankSendTicketTest(bankUser, clientUser, DELIVERED).withId(T4592::class),
                LetterFromBankSendTicketTest(bankUser, clientUser, DETAILS_ERROR).withId(T4593::class),
                LetterFromBankSendTicketTest(bankUser, clientUser, WRONG_ESIGNATURE).withId(T4594::class)
            )
        )
    }

    @TestFactory
    @T4669 //'Письмо из Банка'. Проверка возможности снятия своей подписи под документами [BANK]
    @T4670 //'Письмо из Банка'. Снятие своей подписи под документами [BANK]
    internal fun selfUnSignTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankCheckSelfUnSignTest(bankUser).withId(T4669::class),
                LetterFromBankSelfUnSignTest(bankUser).withId(T4670::class)
            )
        )
    }

    //region Tests

    private val getPrefillTest = { bankUser: User, headerSuffix: String ->
        LetterFromBankOtherTest("'${DocumentNames.LETTER_FROM_BANK}'. " +
                "Получение предзаполненного письма по id организации ${headerSuffix} [${bankUser.userType}]",
            params = { mapOf(PARAM_USER to bankUser) },
            testBody = { getPrefilledForBankBody(bankUser) }
        ).withTaskIds(FEATURE_LETTER_FROM_BANK_DOC_API)
    }

    private fun getPrefilledForBankBody(bankUser: User) {
        val response = LetterFromBankSteps(bankUser).preFill()

        "Проверить, что в предзаполненном письме для организации вернулась ожидаемая информация" {
            // based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726830
            val actResult = response.data.getOrException("Error while trying to get prefilled LetterFromBank")
            val expDocumentDate = LocalDate.now()
            val bankRepresentative = BranchRepresentativeData.getOnlyOneOrNull(bankUser)
            val expContactName = bankUser.userDetails?.let { "${it.lastName} ${it.firstName} ${it.middleName ?: ""}".trim() }
            val expContactPhone = bankRepresentative?.phone

            assertThat("Неправильная дата", actResult.documentDate, equalTo(expDocumentDate))
            assertThat("Неправильное имя контакта", actResult.contactName, equalTo(expContactName))
            assertThat("Неправильный телефон контакта", actResult.contactPhone, equalTo(expContactPhone))
            assertThat("Неправильный id подразделения", actResult.branchId, equalTo(bankRepresentative?.branchId))

            actResult.branchId?.let { actResultBranchId ->
                val branch = BranchData.searchBy(bankUser).first { it.id == actResultBranchId }
                assertThat("Неправильное наим. подразделения", actResult.branchName, equalTo(branch.shortName))
            }
        }
    }

    private val createDraftTest = { bankUser: User, draftDto: LetterFromBankDto ->
        LetterFromBankAbstractOtherTest("'${DocumentNames.LETTER_FROM_BANK}'. " +
                "Создать черновик [${bankUser.userType}]",
            preExecution = { draftDto },
            params = { mapOf(PARAM_USER to bankUser, "Черновик" to draftDto) },
            testBody = {
                val response = LetterFromBankSteps(bankUser).createWithoutCheck(draftDto)
                val actResult = response.data.getOrException()
                "Проверить, что создан черновик" {
                    assertThat("Статус не '$DRAFT'", actResult.status, equalTo(DRAFT.statusBank))
                }
            }
        )
    }

    private val copyWithoutAttachmentsTest = { bankUser: User ->
        LetterFromBankAbstractOtherTest("'${DocumentNames.LETTER_FROM_BANK}'. " +
                "Копирование (без вложений) Письма [${bankUser.userType}]",
            preExecution = { LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(bankUser) },
            params = { mapOf(PARAM_USER to bankUser, "Исходное Письмо" to it!!) },
            testBody = {
                val sourceLetter = it!!
                val steps = LetterFromBankSteps(bankUser)
                val expDocNumber = steps.getNextOutgoingDocumentNumber(sourceLetter.branchId!!)
                val response = steps.copy(sourceLetter.id!!)

                val actResult = response.data.getOrException("Ошибка при копировании Письма")
                "Проверить, что Письмо, скопированное без вложений, соответствует исходному" {
                    val expResult = LetterFromBankPrepareSteps.getLetterFromBankDtoCopyDto(
                        bankUser, sourceLetter, expDocNumber,
                        copyWithAttachments = false
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }

    private val copyWithAttachmentsTest = { bankUser: User ->
        LetterFromBankAbstractOtherTest("'${DocumentNames.LETTER_FROM_BANK}'. " +
                "Копирование (с вложениями) Письма [${bankUser.userType}]",
            preExecution = {
                LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
                    searchingUser = bankUser,
                    getPageRequest = { LetterFromBankFilterParams.IS_HAS_ATTACH.eq(true).toPageRequest() },
                    createLfbFunc = {
                        LetterFromBankPrepareSteps.createLetterFromBankDto(
                            creatorBankUser = bankUser,
                            dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                                creatorBankUser = bankUser,
                                attachments = listOf(DEFAULT_ATTACH_FILE)
                            )
                        )
                    }
                )
            },
            params = { mapOf(PARAM_USER to bankUser, "Исходное Письмо" to it!!) },
            testBody = {
                val sourceLetter = it!!
                val steps = LetterFromBankSteps(bankUser)
                val expDocNumber = steps.getNextOutgoingDocumentNumber(sourceLetter.branchId!!)
                val response = steps.copyWithAttachment(sourceLetter.id!!)

                val actResult = response.data.getOrException("Ошибка при копировании Письма с вложениями")
                "Проверить, что Письмо, скопированное с вложениями, соответствует исходному" {
                    val expResult = LetterFromBankPrepareSteps.getLetterFromBankDtoCopyDto(
                        bankUser, sourceLetter, expDocNumber,
                        copyWithAttachments = true
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }

    private val createAnswerWithoutAttachTest = { bankLfbCreatorUser: User, clientUserWhoCreatedLtb: User ->
        LetterFromBankAbstractOtherTest("'${DocumentNames.LETTER_FROM_BANK}'. " +
                "Создание ответа на Письмо в Банк (без вложения) [${bankLfbCreatorUser.userType}]",
            preExecution = {
                LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                    searchingUser = bankLfbCreatorUser,
                    creatorClientUser = clientUserWhoCreatedLtb
                )
            },
            params = { mapOf(PARAM_USER to bankLfbCreatorUser, "Письмо в Банк" to it!!) },
            testBody = {
                val letterToBankDto = it!!
                val steps = LetterFromBankSteps(bankLfbCreatorUser)
                val expDocNumber = steps.getNextOutgoingDocumentNumber(letterToBankDto.branchId!!)
                val response = steps.createAnswer(letterToBankDto.id!!)

                val actResult = response
                    .data.getOrException("Ошибка при создании ответа на Письмо в Банк без вложений")
                "Проверить, что ответ на Письмо в Банк без вложений соответствует исходному Письму" {
                    val expResult = LetterFromBankPrepareSteps.prepareLFBAnswerForLetterToBankDto(
                        bankLfbCreatorUser, letterToBankDto, expDocNumber,
                        answerWithAttachments = false
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }

    private val createAnswerWithAttachTest = { bankLfbCreatorUser: User, clientUserWhoCreatedLtb: User ->
        LetterFromBankAbstractOtherTest("'${DocumentNames.LETTER_FROM_BANK}'. " +
                "Создание ответа на Письмо в Банк (с вложением) [${bankLfbCreatorUser.userType}]",
            preExecution = {
                LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                    searchingUser = bankLfbCreatorUser,
                    creatorClientUser = clientUserWhoCreatedLtb,
                    getPageRequest = { LetterToBankFilterParams.IS_HAS_ATTACH.eq(true).toPageRequest() },
                    createLtbFunc = {
                        LetterToBankPrepareSteps.createLetterToBankDto(
                            creatorClientUser = clientUserWhoCreatedLtb,
                            dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                                creatorClientUser = clientUserWhoCreatedLtb, receiverBankUser = bankLfbCreatorUser,
                                attachments = listOf(DEFAULT_ATTACH_FILE)
                            )
                        )
                    }
                )
            },
            params = { mapOf(PARAM_USER to bankLfbCreatorUser, "Письмо в Банк" to it!!) },
            testBody = {
                val letterToBankDto = it!!
                val steps = LetterFromBankSteps(bankLfbCreatorUser)
                val expDocNumber = steps.getNextOutgoingDocumentNumber(letterToBankDto.branchId!!)
                val response = steps.createAnswerWithAttachment(letterToBankDto.id!!)

                val actResult = response
                    .data.getOrException("Ошибка при создании ответа на Письмо в Банк с вложениями")
                "Проверить, что ответ на Письмо в Банк с вложениями соответствует исходному Письму" {
                    val expResult = LetterFromBankPrepareSteps.prepareLFBAnswerForLetterToBankDto(
                        bankLfbCreatorUser, letterToBankDto, expDocNumber,
                        answerWithAttachments = true
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }
    //endregion
}
