package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_LIFECYCLE
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.api.letters.frombank.tests.LetterFromBankLifecycleTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.DRAFT
import ooo.jtc.letters.model.LetterFromBankStatus.NEW
import ooo.jtc.letters.model.LetterFromBankStatus.SIGNED
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
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
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_LIFECYCLE)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' lifecycle suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_LIFECYCLE
class LetterFromBankLifecycleTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4382") annotation class T4382
@Tag("JTCSALTO-T4383") annotation class T4383
@Tag("JTCSALTO-T4384") annotation class T4384
@Tag("JTCSALTO-T4385") annotation class T4385
@Tag("JTCSALTO-T4386") annotation class T4386
@Tag("JTCSALTO-T4387") annotation class T4387
@Tag("JTCSALTO-T4942") annotation class T4942
@Tag("JTCSALTO-T4943") annotation class T4943
@Tag("JTCSALTO-T4944") annotation class T4944
//@formatter:on
//endregion

    val bankUser = Users.bankOperator
    val clientUser = Users.client
    private val docChecks = ApiDocumentChecks<LetterFromBankDto>()

    @TestFactory
    @T4385 //'Письмо из Банка'. Жизненный цикл. Проверка перехода none -> DRAFT [BANK]
    @T4386 //'Письмо из Банка'. Жизненный цикл. Проверка перехода none -> NEW [BANK]
    @T4387 //'Письмо из Банка'. Жизненный цикл. Проверка перехода DRAFT -> NEW [BANK]
    internal fun letterToBankLifecycleBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "none -> DRAFT",
                    preExecution = { LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser) },
                    testBody = { bankNoneToDraft(bankUser, it!!) }
                ).withId(T4385::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "none -> NEW",
                    preExecution = { LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser) },
                    testBody = { bankNoneToNew(bankUser, it!!) }
                ).withId(T4386::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "DRAFT -> NEW",
                    preExecution = {
                        val dtoForCreation = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(bankUser)
                        val draft = LetterFromBankSteps(bankUser).createWithoutCheck(dtoForCreation).data.getOrException()
                        LetterFromBankPrepareSteps.getLetterFromBankDtoForUpdate(draft)
                    },
                    testBody = { bankDraftToNew(bankUser, it!!) }
                ).withId(T4387::class)
            )
        )
    }

    @Execution(ExecutionMode.SAME_THREAD)
    @TestFactory
    @T4382 //'Письмо из Банка'. Жизненный цикл. Проверка перехода NEW -> SIGNED [BANK]
    @T4383 //'Письмо из Банка'. Жизненный цикл. Проверка перехода SIGNED -> NEW [BANK]
    @T4384 //'Письмо из Банка'. Жизненный цикл. Проверка перехода SIGNED -> DELIVERED [BANK]
    @T4942 //'Письмо из Банка'. Жизненный цикл. Проверка перехода SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи цела) [BANK]
    @T4943 //'Письмо из Банка'. Жизненный цикл. Проверка перехода SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи испорчена) [BANK]
    @T4944 //'Письмо из Банка'. Жизненный цикл. Проверка перехода SIGNED -> .. -> DETAILS_ERROR [BANK]
    internal fun letterToBankLifecycleBankTestsWithSigning(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "NEW -> SIGNED",
                    preExecution = { LetterFromBankPrepareSteps.createNewLetterFromBank(bankUser) },
                    testBody = { bankNewToSigned(bankUser, it!!) }
                ).withId(T4382::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "SIGNED -> NEW",
                    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) },
                    testBody = { bankSignedToNew(bankUser, it!!) }
                ).withId(T4383::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "SIGNED -> DELIVERED",
                    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) },
                    testBody = { bankSignedToSent(bankUser, it!!) }
                ).withId(T4384::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи цела)",
                    preExecution = {
                        val signedLTB = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)
                        LetterFromBankPrepareSteps.makeDigestIncorrect_DIRTY(signedLTB)
                    },
                    testBody = { bankSignedToWrongESignature(bankUser, it!!) }
                ).withId(T4942::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "SIGNED -> .. -> WRONG_ESIGNATURE (структура подписи испорчена)",
                    preExecution = {
                        val signedLetter = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)
                        LetterFromBankPrepareSteps.makeSignatureCorrupt_DIRTY(signedLetter)
                    },
                    testBody = { bankSignedToWrongESignature(bankUser, it!!) }
                ).withId(T4943::class),
                LetterFromBankLifecycleTest(
                    user = bankUser, statusTransition = "SIGNED -> .. -> DETAILS_ERROR",
                    preExecution = {
                        val signedLTB = LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser)
                        LetterFromBankPrepareSteps.makeDetailsWrong_DIRTY(signedLTB)
                    },
                    testBody = { bankSignedToDetailsError(bankUser, it!!) }
                ).withId(T4944::class)
            )
        )
    }

    //region tests
    private fun bankNoneToDraft(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val response = LetterFromBankSteps(bankUser).createWithoutCheck(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(DRAFT.statusBank),
            additionalHandling = { _, actRes -> actRes.id.assertIsNotEmpty() }
        )
        return actResult
    }

    private fun bankNoneToNew(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val response = LetterFromBankSteps(bankUser).create(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(NEW.statusBank),
            additionalHandling = { _, actRes -> actRes.id.assertIsNotEmpty() }
        )
        return actResult
    }

    private fun bankDraftToNew(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val response = LetterFromBankSteps(bankUser).update(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            listOf(NEW.statusBank)
        )
        return actResult
    }

    private fun bankNewToSigned(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val steps = LetterFromBankSteps(bankUser)
        val response = steps.signDocumentByCertificate(documentDto)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(SIGNED.statusBank),
            additionalHandling = { _, actRes ->
                steps.getSignatures(actRes.id!!)
                    .list.getOrException()
                    .assertIsNotEmpty()
            }
        )
        return actResult
    }

    private fun bankSignedToNew(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val steps = LetterFromBankSteps(bankUser)
        val response = steps.batchSelfUnSign(documentDto.id!!)

        val actResultList = response.documentResults.getOrException()
        val actResult = actResultList[0].dto!!
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult, listOf(NEW.statusBank),
            additionalHandling = { docDto, _ ->
                docDto.signatures = null
            }
        )
        return actResult
    }

    private fun bankSignedToSent(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val response = LetterFromBankSteps(bankUser).send(documentDto.id!!)

        val actResult = response.data.getOrException()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            listOf(DELIVERED).map { it.statusBank }
        )
        return actResult
    }

    private fun bankSignedToWrongESignature(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val userSteps = LetterFromBankSteps(bankUser)
        val response = userSteps.send(documentDto.id!!)

        var actResult = response.data.getOrException()
        actResult = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(actResult.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = response.data!!,
            expStatuses = listOf(WRONG_ESIGNATURE.statusBank)
        )
        return actResult
    }

    private fun bankSignedToDetailsError(bankUser: User, documentDto: LetterFromBankDto): LetterFromBankDto {
        bankUser.checkIsBankUser()
        val userSteps = LetterFromBankSteps(bankUser)
        val response = userSteps.send(documentDto.id!!)

        var actResult = response.data.getOrException()
        actResult = docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { userSteps.getById(actResult.id!!).data.getOrException("Ошибка при получении") },
            preparedDto = documentDto,
            expStatuses = listOf(DETAILS_ERROR.statusBank)
        )
        return actResult
    }
    //endregion
}
