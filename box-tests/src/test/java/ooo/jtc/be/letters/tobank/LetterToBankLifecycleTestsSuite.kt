package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_LIFECYCLE
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.letters.tobank.tests.LetterToBankBatchLifecycleTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankLifecycleTest
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.removeAttachmentsTokens
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.LetterToBankLifecycleConstants.AT_PROCESS_MSG
import ooo.jtc.core.LetterToBankLifecycleConstants.AT_RECALL_MSG
import ooo.jtc.core.LetterToBankLifecycleConstants.DEFAULT_PROCESS_MSG
import ooo.jtc.core.LetterToBankLifecycleConstants.DEFAULT_RECALL_MSG
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_LIFECYCLE)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' lifecycle suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_LIFECYCLE
class LetterToBankLifecycleTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3833") annotation class T3833
@Tag("JTCSALTO-T3834") annotation class T3834
@Tag("JTCSALTO-T3835") annotation class T3835
@Tag("JTCSALTO-T3836") annotation class T3836
@Tag("JTCSALTO-T3837") annotation class T3837
@Tag("JTCSALTO-T3838") annotation class T3838
@Tag("JTCSALTO-T3839") annotation class T3839
@Tag("JTCSALTO-T3840") annotation class T3840
@Tag("JTCSALTO-T3959") annotation class T3959
@Tag("JTCSALTO-T3960") annotation class T3960
@Tag("JTCSALTO-T3961") annotation class T3961
@Tag("JTCSALTO-T3962") annotation class T3962
@Tag("JTCSALTO-T3963") annotation class T3963
@Tag("JTCSALTO-T3964") annotation class T3964
@Tag("JTCSALTO-T3965") annotation class T3965
@Tag("JTCSALTO-T3966") annotation class T3966
@Tag("JTCSALTO-T3967") annotation class T3967
//@formatter:on
//endregion

    val bankUser = Users.bankOperator
    val clientUser = Users.client
    private val docChecks = ApiDocumentChecks<LetterToBankDto>()

    @TestFactory
    @T3833 //'Письмо в Банк'. Жизненный цикл. Проверка перехода none -> DRAFT [CLIENT]
    @T3834 //'Письмо в Банк'. Жизненный цикл. Проверка перехода none -> NEW [CLIENT]
    @T3835 //'Письмо в Банк'. Жизненный цикл. Проверка перехода DRAFT -> NEW [CLIENT]
    internal fun letterToBankLifecycleClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "none -> DRAFT",
                    preExecution = { LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser) },
                    testBody = { clientNoneToDraft(clientUser, it!!) }
                ).withId(T3833::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "none -> NEW",
                    preExecution = { LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser) },
                    testBody = { clientNoneToNew(clientUser, it!!) }
                ).withId(T3834::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "DRAFT -> NEW",
                    preExecution = {
                        val dtoForCreation = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser)
                        val draft = LetterToBankSteps(clientUser).createWithoutCheck(dtoForCreation).data.getOrException()
                        LetterToBankPrepareSteps.getLetterToBankDtoForUpdate(draft)
                    },
                    testBody = { clientDraftToNew(clientUser, it!!) }
                ).withId(T3835::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3836 //'Письмо в Банк'. Жизненный цикл. Проверка перехода NEW -> SIGNED [CLIENT]
    @T3837 //'Письмо в Банк'. Жизненный цикл. Проверка перехода SIGNED -> NEW (одна подпись) [CLIENT]
    @T3838 //'Письмо в Банк'. Жизненный цикл. Проверка перехода SIGNED -> DELIVERED [CLIENT]
    @T3839 //'Письмо в Банк'. Жизненный цикл. Проверка перехода SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи цела) [CLIENT]
    @T3840 //'Письмо в Банк'. Жизненный цикл. Проверка перехода SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи испорчена) [CLIENT]
    @T3967 //'Письмо в Банк'. Жизненный цикл. Проверка перехода SIGNED -> .. -> DETAILS_ERROR [CLIENT]
    internal fun letterToBankLifecycleClientTestsWithSigning(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "NEW -> SIGNED",
                    preExecution = { LetterToBankPrepareSteps.createNewLetterToBank(clientUser) },
                    testBody = { clientNewToSigned(clientUser, it!!) }
                ).withId(T3836::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "SIGNED -> NEW (одна подпись)",
                    preExecution = { LetterToBankPrepareSteps.createSignedLetterToBank(clientUser) },
                    testBody = { clientSelfSignedToNewSingleSignature(clientUser, it!!) }
                ).withId(T3837::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "SIGNED -> DELIVERED",
                    preExecution = { LetterToBankPrepareSteps.createSignedLetterToBank(clientUser) },
                    testBody = { clientSignedToSent(clientUser, it!!) }
                ).withId(T3838::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи цела)",
                    preExecution = {
                        val signedLTB = LetterToBankPrepareSteps.createSignedLetterToBank(clientUser)
                        LetterToBankPrepareSteps.makeDigestIncorrect_DIRTY(signedLTB)
                    },
                    testBody = { clientSignedToWrongESignature(clientUser, it!!) }
                ).withId(T3839::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи испорчена)",
                    preExecution = {
                        val signedLTB = LetterToBankPrepareSteps.createSignedLetterToBank(clientUser)
                        LetterToBankPrepareSteps.makeSignatureCorrupt_DIRTY(signedLTB)
                    },
                    testBody = { clientSignedToWrongESignature(clientUser, it!!) }
                ).withId(T3840::class),
                LetterToBankLifecycleTest(
                    user = clientUser,
                    statusTransition = "SIGNED -> .. -> DETAILS_ERROR",
                    preExecution = {
                        val signedLTB = LetterToBankPrepareSteps.createSignedLetterToBank(clientUser)
                        LetterToBankPrepareSteps.makeDetailsWrong_DIRTY(signedLTB)
                    },
                    testBody = { clientSignedToDetailsError(clientUser, it!!) }
                ).withId(T3967::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T3959 //'Письмо в Банк'. Жизненный цикл. Проверка перехода RECEIVED -> IN_PROCESSING (один документ) [BANK]
    @T3960 //'Письмо в Банк'. Жизненный цикл. Проверка перехода RECEIVED -> RECALLED (один документ) [BANK]
    @T3961 //'Письмо в Банк'. Жизненный цикл. Проверка перехода IN_PROCESSING -> RECALLED (один документ) [BANK]
    @T3962 //'Письмо в Банк'. Жизненный цикл. Проверка перехода IN_PROCESSING -> PROCESSED (один документ) [BANK]
    @T3963 //'Письмо в Банк'. Жизненный цикл. Проверка перехода RECEIVED -> IN_PROCESSING (несколько документов) [BANK]
    @T3966 //'Письмо в Банк'. Жизненный цикл. Проверка перехода RECEIVED -> RECALLED (несколько документов) [BANK]
    @T3964 //'Письмо в Банк'. Жизненный цикл. Проверка перехода IN_PROCESSING -> RECALLED (несколько документов) [BANK]
    @T3965 //'Письмо в Банк'. Жизненный цикл. Проверка перехода IN_PROCESSING -> PROCESSED (несколько документов) [BANK]
    internal fun letterToBankLifecycleBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterToBankLifecycleTest(
                    user = bankUser,
                    statusTransition = "RECEIVED -> IN_PROCESSING (один документ)",
                    preExecution = { LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser) },
                    testBody = { bankSingleReceivedToInProcessing(bankUser, it!!) }
                ).withId(T3959::class),
                LetterToBankLifecycleTest(
                    user = bankUser,
                    statusTransition = "RECEIVED -> RECALLED (один документ)",
                    preExecution = { LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser) },
                    testBody = { bankSingleToRecalled(bankUser, it!!) }
                ).withId(T3960::class),
                LetterToBankLifecycleTest(
                    user = bankUser,
                    statusTransition = "IN_PROCESSING -> RECALLED (один документ)",
                    preExecution = { LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser) },
                    testBody = { bankSingleToRecalled(bankUser, it!!) }
                ).withId(T3961::class),
                LetterToBankLifecycleTest(
                    user = bankUser,
                    statusTransition = "IN_PROCESSING -> PROCESSED (один документ)",
                    preExecution = { LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser) },
                    testBody = { bankSingleInProcessingToProcessed(bankUser, it!!) }
                ).withId(T3962::class),
                LetterToBankBatchLifecycleTest(
                    user = bankUser,
                    statusTransition = "RECEIVED -> IN_PROCESSING (несколько документов)",
                    preExecution = {
                        listOf(
                            LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser),
                            LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)
                        )
                    },
                    testBody = { bankBatchReceivedToInProcessing(bankUser, it!!) }
                ).withId(T3963::class),
                LetterToBankBatchLifecycleTest(
                    user = bankUser,
                    statusTransition = "RECEIVED -> RECALLED (несколько документов)",
                    preExecution = {
                        listOf(
                            LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser),
                            LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)
                        )
                    },
                    testBody = { bankBatchToRecalled(bankUser, it!!) }
                ).withId(T3966::class),
                LetterToBankBatchLifecycleTest(
                    user = bankUser,
                    statusTransition = "IN_PROCESSING -> RECALLED (несколько документов)",
                    preExecution = {
                        listOf(
                            LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser),
                            LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser)
                        )
                    },
                    testBody = { bankBatchToRecalled(bankUser, it!!) }
                ).withId(T3964::class),
                LetterToBankBatchLifecycleTest(
                    user = bankUser,
                    statusTransition = "IN_PROCESSING -> PROCESSED (несколько документов)",
                    preExecution = {
                        listOf(
                            LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser),
                            LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser)
                        )
                    },
                    testBody = { bankBatchInProcessingToProcessed(bankUser, it!!) }
                ).withId(T3965::class)
            )
        )
    }


    //region ClientTests
    private fun clientNoneToDraft(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val response = LetterToBankSteps(user).createWithoutCheck(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(DRAFT.statusClient),
            additionalHandling = { _, actRes -> actRes.id.assertIsNotEmpty() }
        )
        return actResult
    }

    private fun clientNoneToNew(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val response = LetterToBankSteps(user).create(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(NEW.statusClient),
            additionalHandling = { _, actRes -> actRes.id.assertIsNotEmpty() }
        )
        return actResult
    }

    private fun clientDraftToNew(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val response = LetterToBankSteps(user).update(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            listOf(NEW.statusClient)
        )
        return actResult
    }

    private fun clientNewToSigned(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val steps = LetterToBankSteps(user)
        val response = steps.signDocumentBySms(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(SIGNED.statusClient),
            additionalHandling = { _, actRes -> steps.getDocSignaturesList(actRes.id!!).assertIsNotEmpty() }
        )
        return actResult
    }

    private fun clientSelfSignedToNewSingleSignature(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val steps = LetterToBankSteps(user)
        val response = steps.selfUnSignDocument(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(NEW.statusClient),
            additionalHandling = { _, actRes -> steps.getDocSignaturesList(actRes.id!!).isEmpty() }
        )
        return actResult
    }

    private fun clientSignedToSent(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val response = LetterToBankSteps(user).send(documentDto.id!!)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            listOf(DELIVERED, FOR_RECEIVING, RECEIVED).map { it.statusClient }
        )
        return actResult
    }

    private fun clientSignedToWrongESignature(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val userSteps = LetterToBankSteps(user)
        val response = userSteps.send(documentDto.id!!)

        var actResult = response.data.getOrException()
        actResult = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(actResult.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = documentDto,
            expStatuses = listOf(WRONG_ESIGNATURE.statusClient)
        )
        return actResult
    }

    private fun clientSignedToDetailsError(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val userSteps = LetterToBankSteps(user)
        val response = userSteps.send(documentDto.id!!)

        var actResult = response.data.getOrException()
        actResult = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(actResult.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = documentDto,
            expStatuses = listOf(DETAILS_ERROR.statusClient)
        )
        return actResult
    }
    //endregion

    //region BankTests
    private fun bankSingleReceivedToInProcessing(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val userSteps = LetterToBankSteps(user)
        val response = userSteps.startProcessing(listOf(documentDto.id!!))

        val actResult = response.documentResults.getOrException("Ошибка при взятии документов в обработку")
        var inProcessDocument = actResult[0].dto
            .getOrException("Ошибка при получении документа из списка взятых в обработку")
        inProcessDocument = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(inProcessDocument.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = documentDto,
            expStatuses = listOf(IN_PROCESSING.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        return inProcessDocument
    }

    private fun bankSingleInProcessingToProcessed(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val userSteps = LetterToBankSteps(user)
        val processMsg = AT_PROCESS_MSG
        val response = userSteps.process(documentDto.id!!, processMsg)

        var actResult = response.data.getOrException("Ошибка при обработке документа")
        actResult = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(actResult.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = documentDto,
            expStatuses = listOf(PROCESSED.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        assertThat("Сообщение при обработке корректно", actResult.executionMessage, equalTo(processMsg))
        return actResult
    }

    private fun bankSingleToRecalled(user: User, documentDto: LetterToBankDto): LetterToBankDto {
        val userSteps = LetterToBankSteps(user)
        val recallMsg = AT_RECALL_MSG
        val response = userSteps.recall(documentDto.id!!, recallMsg)

        var actResult = response.data.getOrException("Ошибка при отзыве документа")
        actResult = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(actResult.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = documentDto,
            expStatuses = listOf(RECALLED.statusBank),
            additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
        )
        assertThat("Сообщение при обработке корректно", actResult.executionMessage, equalTo(recallMsg))
        return actResult
    }

    private fun bankBatchReceivedToInProcessing(user: User, documentDtos: List<LetterToBankDto>): List<LetterToBankDto> {
        val userSteps = LetterToBankSteps(user)
        val docIds = documentDtos.map { it.id!! }
        val response = userSteps.startProcessing(docIds)

        val actResult = response.documentResults.getOrException("Ошибка при взятии документов в обработку")
        var inProcessDocumentList = actResult.map {
            it.dto.getOrException("Ошибка при извлечении документа из списка взятых в обработку")
        }

        inProcessDocumentList = inProcessDocumentList.map { documentInList ->
            docChecks.repeatableCheckDocumentLifecycleTransition(
                getActResultFunc = { userSteps.getById(documentInList.id!!).data.getOrException("Ошибка при получении") },
                preparedDto = documentInList,
                expStatuses = listOf(IN_PROCESSING.statusBank),
                additionalHandling = { prepDto, _ -> removeAttachmentsTokens(prepDto) }
            )
        }
        return inProcessDocumentList
    }

    private fun bankBatchInProcessingToProcessed(user: User, documentDtos: List<LetterToBankDto>): List<LetterToBankDto> {
        val userSteps = LetterToBankSteps(user)
        val docIds = documentDtos.map { it.id!! }
        val response = userSteps.batchProcess(docIds)

        val actResult = response.documentResults.getOrException("Ошибка при обработке документов")
        var processedDocumentList = actResult.map {
            it.dto.getOrException("Ошибка при извлечении документа из списка обработанных")
        }

        processedDocumentList = processedDocumentList.map { documentInList ->
            docChecks.repeatableCheckDocumentLifecycleTransition(
                getActResultFunc = { userSteps.getById(documentInList.id!!).data.getOrException("Ошибка при получении") },
                preparedDto = documentInList,
                expStatuses = listOf(PROCESSED.statusBank)
            )
        }
        processedDocumentList.forEach {
            assertThat("Сообщение об обработке не было указано", it.executionMessage, equalTo(DEFAULT_PROCESS_MSG))
        }
        return processedDocumentList
    }

    private fun bankBatchToRecalled(user: User, documentDtos: List<LetterToBankDto>): List<LetterToBankDto> {
        val userSteps = LetterToBankSteps(user)
        val docIds = documentDtos.map { it.id!! }
        val response = userSteps.batchRecall(docIds)

        val actResult = response.documentResults.getOrException("Ошибка при отзыве документов")
        var processedDocumentList = actResult.map {
            it.dto.getOrException("Ошибка при извлечении документа из списка отозванных")
        }

        processedDocumentList = processedDocumentList.map { documentInList ->
            docChecks.repeatableCheckDocumentLifecycleTransition(
                getActResultFunc = { userSteps.getById(documentInList.id!!).data.getOrException("Ошибка при получении") },
                preparedDto = documentInList,
                expStatuses = listOf(RECALLED.statusBank)
            )
        }
        processedDocumentList.forEach {
            assertThat("Причина отзыва не была указана", it.executionMessage, equalTo(DEFAULT_RECALL_MSG))
        }
        return processedDocumentList
    }
    //endregion
}
