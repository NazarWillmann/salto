package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_OTHER
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.api.letters.tobank.tests.FEATURE_LETTER_TO_BANK_DOC_API
import ooo.jtc.api.letters.tobank.tests.LetterToBankAbstractOtherTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankOtherTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankSendTest
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.LetterToBankLifecycleConstants.RECEIVE_TICKET_FAILURE_DETAILS_MSG
import ooo.jtc.core.LetterToBankLifecycleConstants.RECEIVE_TICKET_FAILURE_ESIGN_MSG
import ooo.jtc.core.LetterToBankLifecycleConstants.RECEIVE_TICKET_SUCCESS_MSG
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.getOrException
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import ooo.jtc.testdata.uaa.user.UaaUserData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import ooo.jtc.uaa.user.model.getUserDetails
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
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_OTHER)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' other suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_OTHER
class LetterToBankOtherTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T1955") annotation class T1955
    @Tag("JTCSALTO-T1956") annotation class T1956
    @Tag("JTCSALTO-T1957") annotation class T1957
    @Tag("JTCSALTO-T1958") annotation class T1958
    @Tag("JTCSALTO-T3949") annotation class T3949
    @Tag("JTCSALTO-T3950") annotation class T3950
    @Tag("JTCSALTO-T3987") annotation class T3987
    @Tag("JTCSALTO-T3988") annotation class T3988
    @Tag("JTCSALTO-T3989") annotation class T3989
    @Tag("JTCSALTO-T3990") annotation class T3990
    @Tag("JTCSALTO-T3991") annotation class T3991
    @Tag("JTCSALTO-T3992") annotation class T3992
    @Tag("JTCSALTO-T3993") annotation class T3993
    @Tag("JTCSALTO-T3994") annotation class T3994
    @Tag("JTCSALTO-T3995") annotation class T3995
    @Tag("JTCSALTO-T3996") annotation class T3996
    @Tag("JTCSALTO-T3997") annotation class T3997
    @Tag("JTCSALTO-T3998") annotation class T3998
    @Tag("JTCSALTO-T3999") annotation class T3999
    @Tag("JTCSALTO-T4000") annotation class T4000
    @Tag("JTCSALTO-T4022") annotation class T4022
    @Tag("JTCSALTO-T4023") annotation class T4023
    @Tag("JTCSALTO-T1954") annotation class T1954
    @Tag("JTCSALTO-T4446") annotation class T4446
//@formatter:on
//endregion


    private val clientUser = Users.client
    private val bankUser = Users.bankOperator

    @TestFactory
    @T1954 //'Письмо в Банк'. Создать черновик [CLIENT]
    @T1955 //'Письмо в Банк'. Получение предзаполненного письма [CLIENT]
    @T1956 //'Письмо в Банк'. Получение предзаполненного письма по id организации [CLIENT]
    @T1957 //'Письмо в Банк'. Получение списка доступных действий пользователя [CLIENT]
    @T1958 //'Письмо в Банк'. Получение списка доступных действий пользователя [BANK]
    internal fun otherTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                createDraftTest(clientUser, LetterToBankPrepareSteps.createLetterToBankDto(clientUser, bankUser))
                    .withId(T1954::class),
                getPrefilledTest(clientUser).withId(T1955::class),
                getPrefilledForCustomerTest(clientUser, CustomerData.searchBy(clientUser).random())
                    .withId(T1956::class),
                getActionsTest(clientUser).withId(T1957::class),
                getActionsTest(bankUser).withId(T1958::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3949 //'Письмо в Банк'. Копирование (без вложений) Письма [CLIENT]
    @T3950 //'Письмо в Банк'. Копирование (с вложениями) Письма [CLIENT]
    @T4022 //'Письмо в Банк'. Создание ответа на Письмо из Банка (без вложения) [CLIENT]
    @T4023 //'Письмо в Банк'. Создание ответа на Письмо из Банка (с вложением) [CLIENT]
    internal fun singleThreadOtherTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                copyWithoutAttachmentsTest(clientUser).withId(T3949::class),
                copyWithAttachmentsTest(clientUser).withId(T3950::class),
                createAnswerWithoutAttachTest(clientUser, bankUser).withId(T4022::class),
                createAnswerWithAttachTest(clientUser, bankUser).withId(T4023::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3987 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'RECEIVED' [CLIENT]
    @T3988 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'IN_PROCESSING' [CLIENT]
    @T3989 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'RECALLED' [CLIENT]
    @T3990 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'PROCESSED' [CLIENT]
    @T3991 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'DETAILS_ERROR' [CLIENT]
    @T3992 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'WRONG_ESIGNATURE' [CLIENT]
    @T3993 //'Письмо в Банк'. Получение квитка об обработке Письма [CLIENT]

    @T3994 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'RECEIVED' [BANK]
    @T3995 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'IN_PROCESSING' [BANK]
    @T3996 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'RECALLED' [BANK]
    @T3997 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'PROCESSED' [BANK]
    @T3998 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'DETAILS_ERROR' [BANK]
    @T3999 //'Письмо в Банк'. Получение квитка о приёме Письма в статусе 'WRONG_ESIGNATURE' [BANK]
    @T4000 //'Письмо в Банк'. Получение квитка об обработке Письма [BANK]
    internal fun ticketsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                receiveTicketClientTest(clientUser, RECEIVED).withId(T3987::class),
                receiveTicketClientTest(clientUser, IN_PROCESSING).withId(T3988::class),
                receiveTicketClientTest(clientUser, RECALLED).withId(T3989::class),
                receiveTicketClientTest(clientUser, PROCESSED).withId(T3990::class),
                receiveTicketClientTest(clientUser, DETAILS_ERROR).withId(T3991::class),
                receiveTicketClientTest(clientUser, WRONG_ESIGNATURE).withId(T3992::class),
                executionTicketClientTest(clientUser, bankUser).withId(T3993::class),

                receiveTicketBankTest(bankUser, RECEIVED).withId(T3994::class),
                receiveTicketBankTest(bankUser, IN_PROCESSING).withId(T3995::class),
                receiveTicketBankTest(bankUser, RECALLED).withId(T3996::class),
                receiveTicketBankTest(bankUser, PROCESSED).withId(T3997::class),
                receiveTicketBankTest(bankUser, DETAILS_ERROR).withId(T3998::class),
                receiveTicketBankTest(bankUser, WRONG_ESIGNATURE).withId(T3999::class),
                executionTicketBankTest(bankUser).withId(T4000::class)
            )
        )
    }

    @TestFactory
    @T4446 //'Письмо в Банк'. Отправка документов в Банк. Проверка корректности статуса
    internal fun letterToBankSendTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankSendTest(
                    bankUser = bankUser,
                    clientUser = clientUser
                ).withId(T4446::class)
            )
        )
    }

    //region Other tests
    private val getActionsTest = { user: User ->
        LetterToBankOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение списка доступных действий пользователя [${user.userType}]",
            params = { mapOf(PARAM_USER to user) },
            testBody = { getActionsBody(user) }
        ).withTaskIds("JTCSALTO-1449")
    }

    private fun getActionsBody(user: User) {
        //TODO: WiP
        LetterToBankSteps(user).getActions()
    }

    private val getPrefilledForCustomerTest = { clientUser: User, customer: Customer ->
        LetterToBankOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение предзаполненного письма по id организации [${clientUser.userType}]",
            params = { mapOf(PARAM_USER to clientUser, "Организация" to customer) },
            testBody = { getPrefilledForCustomerBody(clientUser, customer) }
        ).withTaskIds(FEATURE_LETTER_TO_BANK_DOC_API)
    }

    private fun getPrefilledForCustomerBody(user: User, customer: Customer) {
        val response = LetterToBankSteps(user).getPrefilledForCustomer(customer.id!!)

        "Проверить, что в предзаполненном письме для организации вернулась ожидаемая информация" {
            val actResult = response.data.getOrException("Error while trying to get Customer-prefilled LetterToBank")
            val expDocumentDate = LocalDate.now()
            val userRepresentative = CustomerRepresentativeData.searchBy(user).first { it.customerId == customer.id!! }
            val expContactName = user.getFio()
            val expContactPhone = userRepresentative.phone ?: user.userDetails?.phoneNumber

            assertThat("Неправильная дата", actResult.documentDate, equalTo(expDocumentDate))
            assertThat("Неправильное имя контакта", actResult.contactName, equalTo(expContactName))
            assertThat("Неправильный телефон контакта", actResult.contactPhone, equalTo(expContactPhone))
            assertThat("Неправильный id организации", actResult.customerId, equalTo(customer.id!!))
            assertThat("Неправильное наим. организации", actResult.customerName, equalTo(customer.shortName))

            val customerBranches = BranchCustomerData.searchByCustomersIds(customer.id!!)
            val shouldExpectBranchData = (1 == customerBranches.size)
            val expBranchId = if (shouldExpectBranchData) customerBranches.first().branchId else null
            val expBranchName = expBranchId?.let { BranchData.byId(it).shortName }

            assertThat("Неправильный id подразделения", actResult.branchId, equalTo(expBranchId))
            assertThat("Неправильное наим. подразделения", actResult.branchName, equalTo(expBranchName))
        }
    }

    private val getPrefilledTest = { clientUser: User ->
        LetterToBankOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение предзаполненного письма [${clientUser.userType}]",
            params = { mapOf(PARAM_USER to clientUser) },
            testBody = { getPrefilledBody(clientUser) }
        ).withTaskIds(FEATURE_LETTER_TO_BANK_DOC_API)
    }

    private fun getPrefilledBody(user: User) {
        val response = LetterToBankSteps(user).preFill()

        "Проверить, что в предзаполненном письме для пользователя вернулась ожидаемая информация" {
            val actResult = response.data.getOrException("Ошибка при получении предзаполненного Письма")
            val expDocumentDate = LocalDate.now()
            val expContactName = user.getFio()
            val expContactPhone = user.userDetails?.phoneNumber

            assertThat("Неправильная дата", actResult.documentDate, equalTo(expDocumentDate))
            assertThat("Неправильное имя контакта", actResult.contactName, equalTo(expContactName))
            assertThat("Неправильный телефон контакта", actResult.contactPhone, equalTo(expContactPhone))
        }
    }


    private val createDraftTest = { clientUser: User, draftDto: LetterToBankDto ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Создать черновик [${clientUser.userType}]",
            preExecution = { draftDto },
            params = { mapOf(PARAM_USER to clientUser, "Черновик" to draftDto) },
            testBody = {
                val response = LetterToBankSteps(clientUser).createWithoutCheck(draftDto)
                val actResult = response.data.getOrException()
                "Проверить, что создан черновик" {
                    assertThat("Статус не '$DRAFT'", actResult.status, equalTo(DRAFT.statusClient))
                }
            }
        )
    }

    private val copyWithoutAttachmentsTest = { clientUser: User ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Копирование (без вложений) Письма [${clientUser.userType}]",
            preExecution = { LetterToBankPrepareSteps.getOrCreateLetterToBankDto(searchingUser = clientUser) },
            params = { mapOf(PARAM_USER to clientUser, "Исходное Письмо" to it!!) },
            testBody = {
                val sourceLTB = it!!
                val steps = LetterToBankSteps(clientUser)
                val expDocNumber = steps.getNextIngoingDocumentNumber(sourceLTB.customerId!!)
                val response = steps.copy(sourceLTB.id!!)

                val actResult = response.data.getOrException("Ошибка при копировании Письма")
                "Проверить, что Письмо, скопированное без вложений, соответствует исходному" {
                    val expResult = LetterToBankPrepareSteps.prepareLetterToBankDtoCopyDto(
                        clientUser, sourceLTB, expDocNumber,
                        copyWithAttachments = false
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }

    private val copyWithAttachmentsTest = { clientUser: User ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Копирование (с вложениями) Письма [${clientUser.userType}]",
            preExecution = {
                LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                    searchingUser = clientUser,
                    getPageRequest = {
                        IFilterParams.and(
                            { recentDocFilterData },
                            { LetterToBankFilterParams.IS_HAS_ATTACH.eq(true) }
                        ).toPageRequest()
                    },
                    createLtbFunc = {
                        LetterToBankPrepareSteps.createLetterToBankDto(
                            creatorClientUser = clientUser,
                            dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                                creatorClientUser = clientUser,
                                attachments = listOf(DEFAULT_ATTACH_FILE)
                            )
                        )
                    }
                )
            },
            params = { mapOf(PARAM_USER to clientUser, "Исходное Письмо" to it!!) },
            testBody = {
                val sourceLTB = it!!
                val steps = LetterToBankSteps(clientUser)
                val expDocNumber = steps.getNextIngoingDocumentNumber(sourceLTB.customerId!!)
                val response = steps.copyWithAttachment(sourceLTB.id!!)

                val actResult = response.data.getOrException("Ошибка при копировании Письма с вложениями")
                "Проверить, что Письмо, скопированное с вложениями, соответствует исходному" {
                    val expResult = LetterToBankPrepareSteps.prepareLetterToBankDtoCopyDto(
                        clientUser, sourceLTB, expDocNumber,
                        copyWithAttachments = true
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }

    private val createAnswerWithoutAttachTest = { clientLtbCreatorUser: User, bankUserWhoCreatedLfb: User ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Создание ответа на Письмо из Банка (без вложения) [${clientLtbCreatorUser.userType}]",
            preExecution = {
                LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
                    searchingUser = clientLtbCreatorUser,
                    creatorBankUser = bankUserWhoCreatedLfb
                )
            },
            params = { mapOf(PARAM_USER to clientLtbCreatorUser, "Письмо из Банка" to it!!) },
            testBody = {
                val letterFromBankDto = it!!
                val steps = LetterToBankSteps(clientLtbCreatorUser)
                val expDocNumber = steps.getNextIngoingDocumentNumber(letterFromBankDto.customerId!!)
                val response = steps.createAnswer(letterFromBankDto.id!!)

                val actResult = response
                    .data.getOrException("Ошибка при создании ответа на Письмо из Банка без вложений")
                "Проверить, что ответ на Письмо из Банка без вложений соответствует исходному Письму" {
                    val expResult = LetterToBankPrepareSteps.prepareLTBAnswerForLetterFromBankDto(
                        clientLtbCreatorUser, letterFromBankDto, expDocNumber,
                        answerWithAttachments = false
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }

    private val createAnswerWithAttachTest = { clientLtbCreatorUser: User, bankUserWhoCreatedLfb: User ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Создание ответа на Письмо из Банка (с вложением) [${clientLtbCreatorUser.userType}]",
            preExecution = {
                LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
                    searchingUser = clientLtbCreatorUser,
                    creatorBankUser = bankUserWhoCreatedLfb,
                    getPageRequest = { LetterFromBankFilterParams.IS_HAS_ATTACH.eq(true).toPageRequest() },
                    createLfbFunc = {
                        LetterFromBankPrepareSteps.createLetterFromBankDto(
                            creatorBankUser = bankUserWhoCreatedLfb,
                            dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                                creatorBankUser = bankUserWhoCreatedLfb, receiverClientUser = clientLtbCreatorUser,
                                attachments = listOf(DEFAULT_ATTACH_FILE)
                            )
                        )
                    }
                )
            },
            params = { mapOf(PARAM_USER to clientLtbCreatorUser, "Письмо из Банка" to it!!) },
            testBody = {
                val letterFromBankDto = it!!
                val steps = LetterToBankSteps(clientLtbCreatorUser)
                val expDocNumber = steps.getNextIngoingDocumentNumber(letterFromBankDto.customerId!!)
                val response = steps.createAnswerWithAttachment(letterFromBankDto.id!!)

                val actResult = response
                    .data.getOrException("Ошибка при создании ответа на Письмо из Банка с вложениями")
                "Проверить, что ответ на Письмо из Банка с вложениями соответствует исходному Письму" {
                    val expResult = LetterToBankPrepareSteps.prepareLTBAnswerForLetterFromBankDto(
                        clientLtbCreatorUser, letterFromBankDto, expDocNumber,
                        answerWithAttachments = true
                    )
                    assertObjectsEqual(expResult, actResult)
                }
            }
        )
    }
    //endregion

    //region Ticket tests
    /**
     * Get-Or-Create PROCESSED LetterToBank for provided clientUser and bankUser.
     *
     * Short description:
     * 1) find common customer for provided users
     * 2) if there are no common customers - 'Create'
     * 3) if there is at least one common customer - 'Get' with complex filter
     *          (any of common customer's ids AND status = [status])
     * 3.1) if nothing is found - 'Create'
     */
    private fun getOrCreateLtbInStatus(clientUser: User, bankUser: User, status: LetterToBankStatus): LetterToBankDto {
        val ltbInStatus: LetterToBankDto
        val createNewLtbInStatusFunc =
            { LetterToBankPrepareSteps.createLetterToBankInStatus(clientUser, bankUser, status) }

        val availableCustomersIds = CustomerData.getCommonCustomersIds(clientUser, bankUser)

        ltbInStatus = if (availableCustomersIds.isNullOrEmpty()) {
            createNewLtbInStatusFunc.invoke()
        } else {
            val customerIdFilterParams: List<(() -> FilterData)> = availableCustomersIds
                .map { { LetterToBankFilterParams.CUSTOMER_ID.eq(it) } }
            val filterData = IFilterParams.and(
                { IFilterParams.or(*customerIdFilterParams.toTypedArray()) },
                { LetterToBankFilterParams.STATUS.eq(status.getUserStatus(clientUser.userType)) }
            )

            LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                searchingUser = clientUser,
                getPageRequest = { filterData.toPageRequest() },
                createLtbFunc = createNewLtbInStatusFunc
            )
        }

        return LetterToBankSteps(bankUser).getById(ltbInStatus.id!!)
            .data.getOrException("Ошибка при получении Письма пользователем ${bankUser.login}")
    }


    private val receiveTicketClientTest = { clientUser: User, status: LetterToBankStatus ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение квитка о приёме Письма в статусе '$status' [${clientUser.userType}]",
            preExecution = { getOrCreateLtbInStatus(clientUser, bankUser, status) },
            params = { mapOf(PARAM_USER to clientUser, "Доставленное Письмо" to it!!) },
            testBody = { receiveTicketBody(clientUser, it!!, status) }
        )
    }

    private val receiveTicketBankTest = { bankUser: User, status: LetterToBankStatus ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение квитка о приёме Письма в статусе '$status' [${bankUser.userType}]",
            preExecution = {
                LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                    searchingUser = bankUser,
                    getPageRequest = {
                        LetterToBankFilterParams.STATUS.eq(status.getUserStatus(bankUser.userType)).toPageRequest()
                    },
                    createLtbFunc = {
                        LetterToBankPrepareSteps.createLetterToBankInStatus(receiverBankUser = bankUser, status = status)
                    }
                )
            },
            params = { mapOf(PARAM_USER to bankUser, "Доставленное Письмо" to it!!) },
            testBody = { receiveTicketBody(bankUser, it!!, status) }
        )
    }

    private fun receiveTicketBody(user: User, sentLtb: LetterToBankDto, status: LetterToBankStatus) {
        val actExecTicket = LetterToBankSteps(user).getReceiveTicket(sentLtb.id!!)
            .data.getOrException("Ошибка при получении квитка о приёме")

        val ltbHistory = LetterToBankSteps(user).getHistory(sentLtb.id!!)
            .list.getOrException("Ошибка при получении истории")

        /* Sergeyev [2021.02.25]:
         * Согласно https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732097,
         * квиток о приёме формируется один раз при обработке документа в статусе ForReceiving.
         * Возможно получение трёх результатов:
         *  - статус WrongESignature + квиток о неправильной подписи;
         *  - статус DetailsError    + квиток о некорректных данных документа;
         *  - статус Received        + квиток об успешном приёме документа.
         * Все последующие статусы (в случае Received, i.e. InProcessing, Recalled, Processed)
         * возвращают сформированный ранее квиток. Следовательно, надо опираться на данные
         * пользователя, указанные в записи истории, следующей после записи о переводе документа в
         * статус ForReceiving.
         */
        val forReceiveHistoryEntry = ltbHistory.first { it.targetStatus == FOR_RECEIVING.getUserStatus(user.userType) }
        val ticketCreatedHistoryEntry = ltbHistory
            .first { it.version == (1 + forReceiveHistoryEntry.version!!) }

        val receiveUserName = UaaUserData.get(fromCache = true) { it.id == ticketCreatedHistoryEntry.userId }
            .first().getUserDetails().getFio()

        val receiveMsg = when (status) {
            DETAILS_ERROR -> RECEIVE_TICKET_FAILURE_DETAILS_MSG
            WRONG_ESIGNATURE -> RECEIVE_TICKET_FAILURE_ESIGN_MSG
            RECEIVED, IN_PROCESSING, RECALLED, PROCESSED -> RECEIVE_TICKET_SUCCESS_MSG
            else -> throw RuntimeException("Unexpected sent status: $status")
        }

        "Проверить, что фактические данные квитка соответствуют ожидаемым" {
            assertThat(wrongInDoc("id"), actExecTicket.docId, equalTo(sentLtb.id))
            assertThat(wrongInDoc("customerId"), actExecTicket.customerId, equalTo(sentLtb.customerId))
            assertThat(wrongInDoc("customerName"), actExecTicket.customerName, equalTo(sentLtb.customerName))
            assertThat(wrongInDoc("branchId"), actExecTicket.branchId, equalTo(sentLtb.branchId))
            assertThat(wrongInDoc("branchName"), actExecTicket.branchName, equalTo(sentLtb.branchName))
            assertThat(wrongInDoc("documentDate"), actExecTicket.documentDate, equalTo(sentLtb.documentDate))
            assertThat(wrongInDoc("documentNumber"), actExecTicket.documentNumber, equalTo(sentLtb.documentNumber))
            assertThat(wrongInDoc("status"), actExecTicket.status, equalTo(status.getUserStatus(user.userType)))
            //TODO?: search async tasks in DB for needed info
//            assertThat(wrongInDoc("receiveDate"), actExecTicket.receiveDate, equalTo(receiveDate))
            assertThat(wrongInDoc("receiveUserName"), actExecTicket.receiveUserName, equalTo(receiveUserName))
            assertThat(wrongInDoc("receiveMessage"), actExecTicket.receiveMessage, equalTo(receiveMsg))
        }
    }


    private val executionTicketClientTest = { clientUser: User, relatedBankUser: User ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение квитка об обработке Письма [${clientUser.userType}]",
            preExecution = { getOrCreateLtbInStatus(clientUser, relatedBankUser, PROCESSED) },
            params = { mapOf(PARAM_USER to clientUser, "Обработанное Письмо" to it!!) },
            testBody = { executionTicketBody(clientUser, it!!) }
        )
    }

    private val executionTicketBankTest = { bankUser: User ->
        LetterToBankAbstractOtherTest("'${DocumentNames.LETTER_TO_BANK}'. " +
                "Получение квитка об обработке Письма [${bankUser.userType}]",
            preExecution = {
                LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
                    searchingUser = bankUser,
                    getPageRequest = {
                        LetterToBankFilterParams.STATUS.eq(PROCESSED.getUserStatus(bankUser.userType)).toPageRequest()
                    },
                    createLtbFunc = { LetterToBankPrepareSteps.createProcessedLetterToBank(receiverBankUser = bankUser) }
                )
            },
            params = { mapOf(PARAM_USER to bankUser, "Обработанное Письмо" to it!!) },
            testBody = { executionTicketBody(bankUser, it!!) }
        )
    }

    private fun executionTicketBody(user: User, processedLtb: LetterToBankDto) {
        val actExecTicket = LetterToBankSteps(user).getExecutionTicket(processedLtb.id!!)
            .data.getOrException("Ошибка при получении квитка об исполнении")

        val ltbHistory = LetterToBankSteps(user).getHistory(processedLtb.id!!)
            .list.getOrException("Ошибка при получении истории")
        val executionHistoryEntry = ltbHistory.first { it.targetStatus == PROCESSED.getUserStatus(user.userType) }
        val executionUserFio = UaaUserData.get(fromCache = true) { it.id == executionHistoryEntry.userId }
            .first().getUserDetails().getFio()

        "Проверить, что фактические данные квитка соответствуют ожидаемым" {
            // Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21728413
            assertThat(wrongInDoc("id"), actExecTicket.docId, equalTo(processedLtb.id!!))
            assertThat(wrongInDoc("customerId"), actExecTicket.customerId, equalTo(processedLtb.customerId!!))
            assertThat(wrongInDoc("customerName"), actExecTicket.customerName, equalTo(processedLtb.customerName!!))
            assertThat(wrongInDoc("branchId"), actExecTicket.branchId, equalTo(processedLtb.branchId!!))
            assertThat(wrongInDoc("branchName"), actExecTicket.branchName, equalTo(processedLtb.branchName!!))
            assertThat(wrongInDoc("documentDate"), actExecTicket.documentDate, equalTo(processedLtb.documentDate))
            assertThat(wrongInDoc("documentNumber"), actExecTicket.documentNumber, equalTo(processedLtb.documentNumber))
            assertThat(wrongInDoc("status"), actExecTicket.status, equalTo(PROCESSED.getUserStatus(UserType.BANK)))
            assertThat(wrongInDoc("executionDate"), actExecTicket.executionDate, equalTo(processedLtb.executionDate!!))
            assertThat(wrongInDoc("executionUserName"), actExecTicket.executionUserName, equalTo(executionUserFio))
            assertThat(wrongInDoc("executionMessage"), actExecTicket.executionMessage, equalTo(processedLtb.executionMessage))
        }
    }
    //endregion

    private fun wrongInDoc(field: String): String = "Некорректное поле '$field' в документе"
}
