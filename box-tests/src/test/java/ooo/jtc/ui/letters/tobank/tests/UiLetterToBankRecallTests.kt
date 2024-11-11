package ooo.jtc.ui.letters.tobank.tests

import ooo.jtc.api.common.controls.UiControlMessage
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.scripts.invoke
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lTBFormBasicRequisitesBank
import ooo.jtc.ui.application.BankApplication.lTBScrollerPageBank
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.sections.modals.ModalRecallDocument
import ooo.jtc.ui.common.sections.modals.ModalRecallDocument.Companion.UI_FIELD_NAME_RECALL_REASON
import ooo.jtc.ui.common.templates.UiFormBankRecallTestTemplate
import ooo.jtc.ui.common.templates.UiBankRecallControlsTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerBankRecallTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiForm
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiRecall
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiScroller
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormPage
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage

/* INFO
 * Recallable statuses are stored as [LetterToBankStatus.recallableStatuses]
 */

@LTBTaskIdsUiScroller
@LTBTaskIdsUiRecall
@HighPriority
open class UiLTBScrollerBankRecallTest(
    bankUser: User,
    status: LetterToBankStatus,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW
) : UiScrollerBankRecallTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    name = "${DocumentNames.LETTER_TO_BANK}. Отзыв документа." +
            " Из скроллера (${actionPlace.description}). " +
            " Статус ${status.statusBank}. [${bankUser.userType}]",
    scrollerPage = lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    beSteps = LetterToBankSteps(bankUser),
    expBeStatuses = listOf(RECALLED.statusBank),
    bankUser = bankUser,
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, status) },
    actionPlace = actionPlace,
    status = status
)

@LTBTaskIdsUiScroller
@LTBTaskIdsUiRecall
@LowPriority
class UiLTBScrollerBankRecallSingleGroupTest(
    bankUser: User,
    status: LetterToBankStatus,
) : UiLTBScrollerBankRecallTest(
    bankUser = bankUser,
    status = status,
    actionPlace = UiActionPlace.BY_SINGLE_GROUP
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiRecall
@LowPriority
class UiLTBFormBankRecallTest(
    bankUser: User,
    startingStatus: LetterToBankStatus
) : UiFormBankRecallTestTemplate<LetterToBankDto, LetterToBankFormPage>(
    name = "${DocumentNames.LETTER_TO_BANK}. Отзыв документа. С формы просмотра." +
            " Статус ${startingStatus.statusBank}. [${bankUser.userType}]",
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, startingStatus) },
    bankUser = bankUser,
    status = startingStatus,
    formPage = lTBFormBasicRequisitesBank,
    beSteps = LetterToBankSteps(bankUser),
    expBeStatuses = listOf(RECALLED.statusBank)
)


//region Modal controls
@LTBTaskIdsUiRecall
@NormalPriority
open class UiLTBBankRecallModalControlsTest(
    nameDetails: String,
    bankUser: User,
    status: LetterToBankStatus = LetterToBankStatus.recallableStatuses.random(),
    actionsOnRecallModalFunc: (ModalRecallDocument) -> Unit
) : UiBankRecallControlsTestTemplate<LetterToBankDto, LetterToBankFormPage>(
    name = "${DocumentNames.LETTER_TO_BANK}. Отзыв документа. Контроли формы. $nameDetails. [${bankUser.userType}]",
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, status) },
    formPage = lTBFormBasicRequisitesBank,
    bankUser = bankUser,
    actionsOnRecallModalFunc = actionsOnRecallModalFunc
)

class UiLTBBankRecallControlEmptyReasonTest(
    bankUser: User
) : UiLTBBankRecallModalControlsTest(
    nameDetails = "Причина отзыва. Пустое поле",
    bankUser = bankUser,
    actionsOnRecallModalFunc = { recallModal ->
        recallModal.recallBtn.click()
        "Проверить сообщение об ошибке (пустое поле причины отзыва)" {
            val expErrorMsgEmptyReason = UiControlMessage.getFieldIsEmptyMsg(UI_FIELD_NAME_RECALL_REASON)
            UiCommonChecks.checkTooltipMessage(expErrorMsgEmptyReason)
        }
// TODO [2020.10.16] Sergeyev: Передача символов элементу не отражает взаимодействие пользователя с фронтом.
//  При проверке руками контроль срабатывает, при проверке кодом - нет

//        recallModal.recallReason.sendKeys("     ")
//        recallModal.recallBtn.click()
//        "Проверить сообщение об ошибке (пустое поле причины отзыва)" {
//            val expErrorMsgEmptyReason = UiControlMessage.getFieldIsEmptyMsg(UI_FIELD_NAME_RECALL_REASON)
//            UiCommonChecks.checkTooltipMessage(expErrorMsgEmptyReason)
//        }
    }
)

class UiLTBBankRecallControlReasonTooBigTest(
    bankUser: User,
    expCharLimit: Int = 2000
) : UiLTBBankRecallModalControlsTest(
    nameDetails = "Причина отзыва. Слишком большое значение",
    bankUser = bankUser,
    actionsOnRecallModalFunc = { recallModal ->
        recallModal.recallReason.value = digits.random(expCharLimit + 1, expCharLimit + 1)
        recallModal.recallBtn.click()
        "Проверить сообщение об ошибке (слишком большая причина отзыва)" {
            val expErrorMsgReasonIsTooBig =
                UiControlMessage.getFieldIsTooBigMsg(UI_FIELD_NAME_RECALL_REASON, expCharLimit)
            UiCommonChecks.checkTooltipMessage(expErrorMsgReasonIsTooBig)
        }
    }
)

class UiLTBBankRecallControlForbiddenSymbolsTest(
    bankUser: User,
    forbiddenSymbols: String = "[@]"
) : UiLTBBankRecallModalControlsTest(
    nameDetails = "Причина отзыва. Недопустимые символы",
    bankUser = bankUser,
    actionsOnRecallModalFunc = { recallModal ->
        recallModal.recallReason.value = "$forbiddenSymbols FE AT-recall (failure)"
        recallModal.recallBtn.click()
        "Проверить сообщение об ошибке (недопустимые символы в причине отзыва)" {
            val expErrorMsgForbiddenSymbols =
                UiControlMessage.getFieldHasForbiddenSymbolsMsg(UI_FIELD_NAME_RECALL_REASON, forbiddenSymbols)
            UiCommonChecks.checkTooltipMessage(expErrorMsgForbiddenSymbols)
        }
    }
)
//endregion