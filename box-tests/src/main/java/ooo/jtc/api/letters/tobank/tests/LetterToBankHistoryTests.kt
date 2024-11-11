@file:Suppress("ClassName")

package ooo.jtc.api.letters.tobank.tests

import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.documents.DocHistoryResponseDto
import ooo.jtc.documents.getBankOrClientStatus
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInRelativeOrder

@LetterToBankTaskIdsDoc
@LetterToBankFolderHistory
@ComponentFreeFormatDoc
@NormalPriority
open class LetterToBankHistoryTest(
    user: User,
    nameDetails: String,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DocumentNames.LETTER_TO_BANK}'. История изменений. Проверка перехода $nameDetails [${user.userType}]",
    params = { mapOf(PARAM_USER to user) },
    testBody = testBody
)

/**
 * Common history test block
 *
 * @param userSteps - authorized steps. Used for calling [getHistory()]-request
 * @param startingLtb - LetterToBank before change
 * @param expHistoryEntries - list of expected entries in [getHistory()]-response
 * @param ltbChangeFunc - LetterToBank change function (creation, update, signing, etc.)
 * @return LetterToBank after change
 */
private fun historyTestBlock(
    userSteps: LetterToBankSteps,
    startingLtb: LetterToBankDto,
    expHistoryEntries: List<DocHistoryResponseDto>,
    ltbChangeFunc: (LetterToBankDto) -> LetterToBankDto
): LetterToBankDto {
    val changedLtb = ltbChangeFunc.invoke(startingLtb)
    val historyResponse = userSteps.getHistory(changedLtb.id!!)
        .list.getOrException("Ошибка при получении истории документа [${changedLtb.id}]")
    historyResponse.map {
        it.statusChanged = null
        it.eventTime = null
    }

    assertThat(
        "Фактическая история изменений не совпадает с ожидаемой",
        historyResponse,
        containsInRelativeOrder(*expHistoryEntries.toTypedArray())
    )
    return changedLtb
}

private val docChecks = ApiDocumentChecks<LetterToBankDto>()
private val techUserId = TestConstants.TECH_USER_ID
private const val ERR_UPDATE_MSG_NEW2SIGNED = "Обновление: Новый-Подписан"
private const val BANK_RECALL_MSG = "AT-recalled(History)"

//region Client tests
class LTBHistoryClientTest_None2New(clientUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "none->NEW",
    testBody = {
        val userId = clientUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)

        val expHistoryEntries =
            listOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusClient))
        historyTestBlock(
            userSteps = clientSteps,
            startingLtb = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser),
            expHistoryEntries = expHistoryEntries,
            ltbChangeFunc = { noneLtb -> clientSteps.create(noneLtb).data.getOrException() }
        )
    }
)

class LTBHistoryClientTest_None2Draft(clientUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "none->DRAFT",
    testBody = {
        val userId = clientUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)

        val expHistoryEntries =
            listOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusClient))
        historyTestBlock(
            userSteps = clientSteps,
            startingLtb = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser),
            expHistoryEntries = expHistoryEntries,
            ltbChangeFunc = { noneLtb -> clientSteps.createWithoutCheck(noneLtb).data.getOrException() }
        )
    }
)

class LTBHistoryClientTest_Draft2New2Draft(clientUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "DRAFT->NEW->DRAFT",
    testBody = {
        val userId = clientUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        var testDto = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser)

        val expHistoryEntries =
            mutableListOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusClient))
        testDto = historyTestBlock(
            userSteps = clientSteps,
            startingLtb = testDto,
            expHistoryEntries = expHistoryEntries,
            ltbChangeFunc = { noneLtb -> clientSteps.createWithoutCheck(noneLtb).data.getOrException() }
        )

        expHistoryEntries
            .add(DocHistoryResponseDto(version = 2, userId = userId, targetStatus = NEW.statusClient))
        testDto = historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { draftLtb ->
                clientSteps.update(draftLtb)
                    .data.getOrException("Обновление: Черновик-Новый")
            }
        )

        expHistoryEntries
            .add(DocHistoryResponseDto(version = 3, userId = userId, targetStatus = DRAFT.statusClient))
        historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { newLtb ->
                clientSteps.updateWithoutCheck(newLtb)
                    .data.getOrException("Обновление: Новый-Черновик")
            }
        )
    }
)

class LTBHistoryClientTest_Signed2New2Signed(clientUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "SIGNED->NEW->SIGNED",
    testBody = {
        val userId = clientUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        var testDto = LetterToBankPrepareSteps.createSignedLetterToBank(clientUser)

        val expHistoryEntries = mutableListOf(
            DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusClient),
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusClient),
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = NEW.statusClient)
        )
        testDto = historyTestBlock(
            userSteps = clientSteps,
            startingLtb = testDto,
            expHistoryEntries = expHistoryEntries,
            ltbChangeFunc = { signed ->
                clientSteps.selfUnSignDocument(signed)
                    .data.getOrException("Обновление: Подписан-Новый")
            }
        )

        expHistoryEntries
            .add(DocHistoryResponseDto(version = 4, userId = userId, targetStatus = SIGNED.statusClient))
        historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { unSigned ->
                clientSteps.signDocumentBySms(unSigned)
                    .data.getOrException(ERR_UPDATE_MSG_NEW2SIGNED)
            }
        )
    }
)

class LTBHistoryClientTest_None2Received(clientUser: User,  bankUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "none->...->DELIVERED",
    testBody = {
        val userId = clientUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        var testDto = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser, bankUser)


        val expHistoryEntries =
            mutableListOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusClient))
        testDto = historyTestBlock(
            userSteps = clientSteps,
            startingLtb = testDto,
            expHistoryEntries = expHistoryEntries,
            ltbChangeFunc = { noneLtb -> clientSteps.create(noneLtb).data.getOrException() }
        )

        expHistoryEntries
            .add(DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusClient))
        testDto = historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { newLtb ->
                clientSteps.signDocumentBySms(newLtb)
                    .data.getOrException(ERR_UPDATE_MSG_NEW2SIGNED)
            }
        )

        expHistoryEntries.addAll(
            listOf(
                DocHistoryResponseDto(version = 3, userId = userId, targetStatus = DELIVERED.statusClient),
                DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.statusClient),
                DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.statusClient)
            )
        )
        historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { signedLtb ->
                val bankUserSteps = LetterToBankSteps(bankUser)
                val sentLtb = clientSteps.send(signedLtb.id!!)
                    .data.getOrException("Обновление: Подписан-Отправлен")

                docChecks.repeatableCheckDocumentLifecycleTransition(
                    getActResultFunc = { bankUserSteps.getById(sentLtb.id!!).data.getOrException("Ошибка при получении документа") },
                    preparedDto = sentLtb,
                    expStatuses = listOf(RECEIVED.statusBank)
                )
            }
        )
    }
)

class LTBHistoryClientTest_Received2Processed(clientUser: User, bankUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "RECEIVED->...->PROCESSED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankUserId = bankUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        val bankSteps = LetterToBankSteps(bankUser)
        var testDto = LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)


        val expHistoryEntries = mutableListOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.statusClient),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.statusClient),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.statusClient),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.statusClient),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.statusClient),
            DocHistoryResponseDto(version = 6, userId = bankUserId, targetStatus = IN_PROCESSING.statusClient)
        )
        testDto = historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { receivedLtb ->
                val inProcessList = bankSteps.startProcessing(listOf(receivedLtb.id!!))
                    .documentResults.getOrException("Обновление: Принят-Взят в обработку")

                inProcessList.first()
                    .dto.getOrException("Получение первого из списка взятых в обработку")
            }
        )

        expHistoryEntries
            .add(DocHistoryResponseDto(version = 7, userId = bankUserId, targetStatus = PROCESSED.statusClient))
        historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { inProcessLtb ->
                bankSteps.process(inProcessLtb.id!!, "AT-processed(History)")
                    .data.getOrException("Обновление: Взят в обработку-Обработан")
            }
        )
    }
)

class LTBHistoryClientTest_Received2Recalled(clientUser: User, bankUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "RECEIVED->RECALLED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankUserId = bankUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        val bankSteps = LetterToBankSteps(bankUser)
        val testDto = LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)


        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.statusClient),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.statusClient),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.statusClient),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.statusClient),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.statusClient),
            DocHistoryResponseDto(version = 6, userId = bankUserId, targetStatus = RECALLED.statusClient)
        )
        historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { receivedLtb ->
                bankSteps.recall(receivedLtb.id!!, BANK_RECALL_MSG)
                    .data.getOrException("Обновление: Принят-Отозван")
            }
        )
    }
)

class LTBHistoryClientTest_Received2InProcess2Recalled(clientUser: User, bankUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "RECEIVED->IN_PROCESS->RECALLED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankUserId = bankUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        val bankSteps = LetterToBankSteps(bankUser)
        val testDto = LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser)

        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.statusClient),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.statusClient),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.statusClient),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.statusClient),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.statusClient),
            DocHistoryResponseDto(version = 6, userId = bankUserId, targetStatus = IN_PROCESSING.statusClient),
            DocHistoryResponseDto(version = 7, userId = bankUserId, targetStatus = RECALLED.statusClient)
        )
        historyTestBlock(
            clientSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { inProcessLtb ->
                bankSteps.recall(inProcessLtb.id!!, BANK_RECALL_MSG)
                    .data.getOrException("Обновление: В обработке-Отозван")
            }
        )
    }
)

class LTBHistoryClientTest_Draft2New_MultipleSameChanges(clientUser: User) : LetterToBankHistoryTest(
    user = clientUser, nameDetails = "DRAFT->DRAFT(x4)->NEW (только смена статуса)",
    testBody = {
        val userId = clientUser.uaaUserId!!
        val clientSteps = LetterToBankSteps(clientUser)
        var testDto = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(clientUser)

        var expAllHistoryEntries =
            listOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusClient))
        testDto = historyTestBlock(
            userSteps = clientSteps,
            startingLtb = testDto,
            expHistoryEntries = expAllHistoryEntries,
            ltbChangeFunc = { noneLtb -> clientSteps.createWithoutCheck(noneLtb).data.getOrException() }
        )

        for (i in 2..5) {
            expAllHistoryEntries =
                listOf(DocHistoryResponseDto(version = i, userId = userId, targetStatus = DRAFT.statusClient))
            testDto = historyTestBlock(
                clientSteps, testDto, expAllHistoryEntries,
                ltbChangeFunc = { newLtb ->
                    clientSteps.updateWithoutCheck(newLtb)
                        .data.getOrException("Обновление: Черновик-Черновик ($i)")
                }
            )
        }

        expAllHistoryEntries = listOf(
            DocHistoryResponseDto(version = 5, userId = userId, targetStatus = DRAFT.statusClient),
            DocHistoryResponseDto(version = 6, userId = userId, targetStatus = NEW.statusClient)
        )
        historyTestBlock(
            clientSteps, testDto, expAllHistoryEntries,
            ltbChangeFunc = { draftLtb ->
                clientSteps.update(draftLtb)
                    .data.getOrException("Обновление: Черновик-Новый")
            }
        )
    }
)
//endregion

//region Bank tests
class LTBHistoryBankTest_None2Received(bankUser: User, clientUser: User) : LetterToBankHistoryTest(
    user = bankUser, nameDetails = "none->...->DELIVERED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankSteps = LetterToBankSteps(bankUser)
        val testDto = LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)


        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.getBankOrClientStatus()),
        )
        historyTestBlock(
            userSteps = bankSteps,
            startingLtb = testDto,
            expHistoryEntries = expHistoryEntries,
            ltbChangeFunc = { it } //проверка истории сразу, как письмо стало доступно
        )
    }
)

class LTBHistoryBankTest_Received2Processed(bankUser: User, clientUser: User) : LetterToBankHistoryTest(
    user = bankUser, nameDetails = "RECEIVED->...->PROCESSED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankUserId = bankUser.uaaUserId!!
        val bankSteps = LetterToBankSteps(bankUser)
        var testDto = LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)


        val expHistoryEntries = mutableListOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 6, userId = bankUserId, targetStatus = IN_PROCESSING.getBankOrClientStatus())
        )
        testDto = historyTestBlock(
            bankSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { receivedLtb ->
                bankSteps.startProcessing(listOf(receivedLtb.id!!))
                    .documentResults.getOrException("Обновление: Принят-В обработке")
                    .first()
                    .dto.getOrException("Получение первого из списка взятых в обработку")
            }
        )

        expHistoryEntries
            .add(DocHistoryResponseDto(version = 7, userId = bankUserId, targetStatus = PROCESSED.getBankOrClientStatus()))
        historyTestBlock(
            bankSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { inProcessLtb ->
                bankSteps.process(inProcessLtb.id!!, "AT-processed(History)")
                    .data.getOrException("Обновление: В обработке-Обработан")
            }
        )
    }
)

class LTBHistoryBankTest_Received2Recalled(bankUser: User, clientUser: User) : LetterToBankHistoryTest(
    user = bankUser, nameDetails = "RECEIVED->RECALLED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankUserId = bankUser.uaaUserId!!
        val bankSteps = LetterToBankSteps(bankUser)
        val testDto = LetterToBankPrepareSteps.createReceivedLetterToBank(clientUser, bankUser)


        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 6, userId = bankUserId, targetStatus = RECALLED.getBankOrClientStatus())
        )
        historyTestBlock(
            bankSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { receivedLtb ->
                bankSteps.recall(receivedLtb.id!!, BANK_RECALL_MSG)
                    .data.getOrException("Обновление: Принят-Отозван")
            }
        )
    }
)

class LTBHistoryBankTest_Received2InProcess2Recalled(bankUser: User, clientUser: User) : LetterToBankHistoryTest(
    user = bankUser, nameDetails = "RECEIVED->IN_PROCESS->RECALLED",
    testBody = {
        val clientUserId = clientUser.uaaUserId!!
        val bankUserId = bankUser.uaaUserId!!
        val bankSteps = LetterToBankSteps(bankUser)
        val testDto = LetterToBankPrepareSteps.createInProcessingLetterToBank(clientUser, bankUser)


        val expHistoryEntries = mutableListOf(
            DocHistoryResponseDto(version = 1, userId = clientUserId, targetStatus = NEW.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 2, userId = clientUserId, targetStatus = SIGNED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 3, userId = clientUserId, targetStatus = DELIVERED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 4, userId = techUserId, targetStatus = FOR_RECEIVING.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 5, userId = techUserId, targetStatus = RECEIVED.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 6, userId = bankUserId, targetStatus = IN_PROCESSING.getBankOrClientStatus()),
            DocHistoryResponseDto(version = 7, userId = bankUserId, targetStatus = RECALLED.getBankOrClientStatus())
        )
        historyTestBlock(
            bankSteps, testDto, expHistoryEntries,
            ltbChangeFunc = { inProcessLtb ->
                bankSteps.recall(inProcessLtb.id!!, BANK_RECALL_MSG)
                    .data.getOrException("Обновление: В обработке-Отозван")
            }
        )
    }
)
//endregion