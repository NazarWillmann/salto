@file:Suppress("ClassName")

package ooo.jtc.api.letters.frombank.tests

import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.documents.DocHistoryResponseDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus.DELETED
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInRelativeOrder

/* !WARNING!
 * LetterFromBank history tests are written only for bank (operator) user.
 * Client user has no relation to LTB history (can't even get it).
 * When copying or writing tests that may be used for client user, do
 * remember to use proper [targetStatus] values, i.e.
 * not a [<status>.statusBank],
 * but a [<status>.getUserStatus(user.userType)]
 *
 * @author Pavel_Sergeyev [2020.11.11]
 */

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderHistory
@ComponentFreeFormatDoc
@NormalPriority
open class LetterFromBankHistoryTest(
    bankUser: User,
    nameDetails: String,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. История изменений. Проверка перехода $nameDetails [${bankUser.userType}]",
    params = { mapOf(PARAM_USER to bankUser) },
    testBody = testBody
)

/**
 * Common history test block
 *
 * @param userSteps - authorized steps. Used for calling [getHistory()]-request
 * @param startingLetter - LetterFromBank before change
 * @param expHistoryEntries - list of expected entries in [getHistory()]-response
 * @param letterChangeFunc - LetterFromBank change function (creation, update, signing, etc.)
 * @return LetterFromBank after change
 */
private fun historyTestBlock(
    userSteps: LetterFromBankSteps,
    startingLetter: LetterFromBankDto,
    expHistoryEntries: List<DocHistoryResponseDto>,
    letterChangeFunc: (LetterFromBankDto) -> LetterFromBankDto
): LetterFromBankDto {
    val changedLetter = letterChangeFunc.invoke(startingLetter)
    val historyResponse = userSteps.getHistory(changedLetter.id!!)
        .list.getOrException("Ошибка при получении истории документа [${changedLetter.id}]")
    historyResponse.map {
        it.statusChanged = null
        it.eventTime = null
    }

    assertThat(
        "Фактическая история изменений не совпадает с ожидаемой",
        historyResponse,
        containsInRelativeOrder(*expHistoryEntries.toTypedArray())
    )
    return changedLetter
}


class LFBHistoryTest_None2New(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "none->NEW",
    testBody = {
        val userId = bankUser.uaaUserId!!
        val userSteps = LetterFromBankSteps(bankUser)

        val expHistoryEntries =
            listOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusBank))
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser),
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { noneLetter -> userSteps.create(noneLetter).data.getOrException() }
        )
    }
)

class LFBHistoryTest_None2Draft(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "none->DRAFT",
    testBody = {
        val userId = bankUser.uaaUserId!!
        val userSteps = LetterFromBankSteps(bankUser)

        val expHistoryEntries =
            listOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusBank))
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser),
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { noneLetter -> userSteps.createWithoutCheck(noneLetter).data.getOrException() }
        )
    }
)

class LFBHistoryTest_Draft2New2Draft(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "DRAFT->NEW->DRAFT",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser)

        val expHistoryEntries =
            mutableListOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusBank))
        testDto = historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { noneLetter -> userSteps.createWithoutCheck(noneLetter).data.getOrException() }
        )

        expHistoryEntries.add(
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = NEW.statusBank)
        )
        testDto = historyTestBlock(
            userSteps, testDto, expHistoryEntries,
            letterChangeFunc = { draftLetter ->
                userSteps.update(draftLetter)
                    .data.getOrException("Обновление: Черновик-Новый")
            }
        )

        expHistoryEntries.add(
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = DRAFT.statusBank)
        )
        historyTestBlock(
            userSteps, testDto, expHistoryEntries,
            letterChangeFunc = { newLetter ->
                userSteps.updateWithoutCheck(newLetter)
                    .data.getOrException("Обновление: Новый-Черновик")
            }
        )
    }
)

class LFBHistoryTest_Signed2New2Signed(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "SIGNED->NEW->SIGNED",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)

        val expHistoryEntries = mutableListOf(
            DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusBank),
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusBank),
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = NEW.statusBank)
        )
        testDto = historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { signed ->
                userSteps.selfUnSignDocument(signed)
                    .data.getOrException("Обновление: Подписан-Новый")
            }
        )

        expHistoryEntries.add(
            DocHistoryResponseDto(version = 4, userId = userId, targetStatus = SIGNED.statusBank)
        )
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { unSigned ->
                userSteps.signDocumentByCertificate(unSigned)
                    .data.getOrException("Обновление: Новый-Подписан")
            }
        )
    }
)

class LFBHistoryTest_Signed2Delivered(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "SIGNED->DELIVERED",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        val testDto = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)

        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusBank),
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusBank),
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = DELIVERED.statusBank)
        )
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { signedLetter ->
                userSteps.send(signedLetter.id!!)
                    .data.getOrException("Отправка: Подписан-Доставлен")
            }
        )
    }
)

class LFBHistoryTest_Signed2WrongSignature(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "SIGNED->WRONG_ESIGNATURE (SignatureCorrupt)",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)

        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusBank),
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusBank),
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = WRONG_ESIGNATURE.statusBank)
        )
        testDto = LetterFromBankPrepareSteps.makeSignatureCorrupt_DIRTY(testDto)
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { signedLetter ->
                userSteps.send(signedLetter.id!!)
                    .data.getOrException("Отправка: Подписан-ЭП неверна")
            }
        )
    }
)

class LFBHistoryTest_Signed2WrongDigest(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "SIGNED->WRONG_ESIGNATURE (DigestIncorrect)",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)

        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusBank),
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusBank),
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = WRONG_ESIGNATURE.statusBank)
        )
        testDto = LetterFromBankPrepareSteps.makeDigestIncorrect_DIRTY(testDto)
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { signedLetter ->
                userSteps.send(signedLetter.id!!)
                    .data.getOrException("Отправка: Подписан-ЭП неверна")
            }
        )
    }
)

class LFBHistoryTest_Signed2DetailsError(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "SIGNED->DETAILS_ERROR",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)

        val expHistoryEntries = listOf(
            DocHistoryResponseDto(version = 1, userId = userId, targetStatus = NEW.statusBank),
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = SIGNED.statusBank),
            DocHistoryResponseDto(version = 3, userId = userId, targetStatus = DETAILS_ERROR.statusBank)
        )
        testDto = LetterFromBankPrepareSteps.makeDetailsWrong_DIRTY(testDto)
        historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expHistoryEntries,
            letterChangeFunc = { signedLetter ->
                userSteps.send(signedLetter.id!!)
                    .data.getOrException("Отправка: Подписан-Ошибка реквизитов")
            }
        )
    }
)

class LFBHistoryTest_Draft2New_MultipleSameChanges(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "DRAFT->DRAFT(x4)->NEW (только смена статуса)",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser)

        var expAllHistoryEntries =
            listOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusBank))
        testDto = historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expAllHistoryEntries,
            letterChangeFunc = { noneLetter -> userSteps.createWithoutCheck(noneLetter).data.getOrException() }
        )

        for (i in 2..5) {
            expAllHistoryEntries =
                listOf(DocHistoryResponseDto(version = i, userId = userId, targetStatus = DRAFT.statusBank))
            testDto = historyTestBlock(
                userSteps, testDto, expAllHistoryEntries,
                letterChangeFunc = { draftLetter ->
                    userSteps.updateWithoutCheck(draftLetter)
                        .data.getOrException("Обновление: Черновик-Черновик ($i)")
                }
            )
        }

        expAllHistoryEntries = listOf(
            DocHistoryResponseDto(version = 5, userId = userId, targetStatus = DRAFT.statusBank),
            DocHistoryResponseDto(version = 6, userId = userId, targetStatus = NEW.statusBank)
        )
        historyTestBlock(
            userSteps, testDto, expAllHistoryEntries,
            letterChangeFunc = { draftLetter ->
                userSteps.update(draftLetter)
                    .data.getOrException("Обновление: Черновик-Новый")
            }
        )
    }
)

class LFBHistoryTest_Draft2Deleted(bankUser: User) : LetterFromBankHistoryTest(
    bankUser = bankUser, nameDetails = "DRAFT->DELETED",
    testBody = {
        val userSteps = LetterFromBankSteps(bankUser)
        val userId = bankUser.uaaUserId!!
        var testDto = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser)

        val expAllHistoryEntries =
            mutableListOf(DocHistoryResponseDto(version = 1, userId = userId, targetStatus = DRAFT.statusBank))
        testDto = historyTestBlock(
            userSteps = userSteps,
            startingLetter = testDto,
            expHistoryEntries = expAllHistoryEntries,
            letterChangeFunc = { noneLetter -> userSteps.createWithoutCheck(noneLetter).data.getOrException() }
        )

        expAllHistoryEntries.add(
            DocHistoryResponseDto(version = 2, userId = userId, targetStatus = DELETED.statusBank)
        )
        historyTestBlock(
            userSteps, testDto, expAllHistoryEntries,
            letterChangeFunc = { draftLetter ->
                userSteps.delete(draftLetter.id!!)
                    .data.getOrException("Удаление: Черновик-Удален")
            }
        )
    }
)
