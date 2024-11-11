package ooo.jtc.ui.letters.tobank.tests

import com.codeborne.selenide.Condition.visible
import ooo.jtc.api.common.controls.UiControlMessage
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.container.shouldNot
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.scripts.invoke
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication
import ooo.jtc.ui.application.BankApplication.lTBScrollerPageBank
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.sections.modals.ModalProcessDocument
import ooo.jtc.ui.common.sections.modals.ModalProcessDocument.Companion.UI_FIELD_NAME_PROCESS_RESULT
import ooo.jtc.ui.common.templates.UiBankProcessControlsTestTemplate
import ooo.jtc.ui.common.templates.UiFormBankProcessTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerBankProcessTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiForm
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiProcess
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiScroller
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormPage
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage

@LTBTaskIdsUiScroller
@LTBTaskIdsUiProcess
@HighPriority
open class UiLTBScrollerBankProcessTest(
    bankUser: User,
    status: LetterToBankStatus,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW
) : UiScrollerBankProcessTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    name = "${DocumentNames.LETTER_TO_BANK}. Обработка документа." +
            " Из скроллера (${actionPlace.description}). " +
            " Статус ${status.statusBank}. [${bankUser.userType}]",
    scrollerPage = lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.IN_PROCESSING,
    beSteps = LetterToBankSteps(bankUser),
    expBeStatuses = listOf(PROCESSED.statusBank),
    bankUser = bankUser,
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, status) },
    actionPlace = actionPlace,
    status = status
)

@LTBTaskIdsUiScroller
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBScrollerBankProcessSingleGroupTest(
    bankUser: User,
    status: LetterToBankStatus,
) : UiLTBScrollerBankProcessTest(
    bankUser = bankUser,
    status = status,
    actionPlace = UiActionPlace.BY_SINGLE_GROUP
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBFormBankProcessTest(
    bankUser: User,
    startingStatus: LetterToBankStatus
) : UiFormBankProcessTestTemplate<LetterToBankDto, LetterToBankFormPage>(
    name = "${DocumentNames.LETTER_TO_BANK}. Обработка документа. С формы просмотра." +
            " Статус ${startingStatus.statusBank}. [${bankUser.userType}]",
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, startingStatus) },
    bankUser = bankUser,
    status = startingStatus,
    formPage = BankApplication.lTBFormBasicRequisitesBank,
    beSteps = LetterToBankSteps(bankUser),
    expBeStatuses = listOf(PROCESSED.statusBank)
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBBankProcessControlProcessResultTooBigTest(
    bankUser: User,
    expCharLimit: Int = 2000
) : UiLTBBankProcessModalControlsTest(
    nameDetails = "Результат обработки. Слишком большое значение",
    bankUser = bankUser,
    actionsOnProcessModalFunc = { processModal ->
        processModal.processResult.value = digits.random(expCharLimit + 1, expCharLimit + 1)
        processModal.processBtn.click()
        "Проверить сообщение об ошибке (слишком большой результат обработки)" {
            val expErrorMsgResultIsTooBig =
                UiControlMessage.getFieldIsTooBigMsg(UI_FIELD_NAME_PROCESS_RESULT, expCharLimit)
            UiCommonChecks.checkTooltipMessage(expErrorMsgResultIsTooBig)
        }
    }
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
open class UiLTBBankProcessModalControlsTest(
    nameDetails: String,
    bankUser: User,
    status: LetterToBankStatus = LetterToBankStatus.IN_PROCESSING,
    actionsOnProcessModalFunc: (ModalProcessDocument) -> Unit
) : UiBankProcessControlsTestTemplate<LetterToBankDto, LetterToBankFormPage>(
    name = "${DocumentNames.LETTER_TO_BANK}. Обработка документа. Контроли формы. $nameDetails. [${bankUser.userType}]",
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, status) },
    formPage = BankApplication.lTBFormBasicRequisitesBank,
    bankUser = bankUser,
    actionsOnProcessModalFunc = actionsOnProcessModalFunc
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
open class UiLTBBankCancelProcessModalTest(
    bankUser: User,
    status: LetterToBankStatus = LetterToBankStatus.IN_PROCESSING,
    actionsOnProcessModalFunc: (ModalProcessDocument) -> Unit
) : UiBankProcessControlsTestTemplate<LetterToBankDto, LetterToBankFormPage>(
    name = "${DocumentNames.LETTER_TO_BANK}. Обработка документа. Кнопка Отменить. [${bankUser.userType}]",
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionInStatus(bankUser, status) },
    formPage = BankApplication.lTBFormBasicRequisitesBank,
    bankUser = bankUser,
    actionsOnProcessModalFunc = actionsOnProcessModalFunc
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBBankProcessControlEmptyResultTest(
    bankUser: User
) : UiLTBBankProcessModalControlsTest(
    nameDetails = "Результат обработки: пустое поле",
    bankUser = bankUser,
    actionsOnProcessModalFunc = { processModal ->
        processModal.processBtn.click()
        "Проверить сообщение об ошибке (пустое поле результат обработки)" {
            val expErrorMsgEmptyResult = UiControlMessage.getFieldIsEmptyMsg(UI_FIELD_NAME_PROCESS_RESULT)
            UiCommonChecks.checkTooltipMessage(expErrorMsgEmptyResult)
        }
    }
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBBankProcessControlSpacesOnlyTest(
    bankUser: User
) : UiLTBBankProcessModalControlsTest(
    nameDetails = "Результат обработки: только пробелы",
    bankUser = bankUser,
    actionsOnProcessModalFunc = { processModal ->
        processModal.processResult.sendKeys("     ")
        processModal.processBtn.click()
        "Проверить сообщение об ошибке (пустое поле результат обработки)" {
            val expErrorMsgEmptyReason = UiControlMessage.getFieldIsEmptyMsg(UI_FIELD_NAME_PROCESS_RESULT)
            UiCommonChecks.checkTooltipMessage(expErrorMsgEmptyReason)
        }
    }
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBBankCancelProcessTest(
    bankUser: User
) : UiLTBBankCancelProcessModalTest(
    bankUser = bankUser,
    actionsOnProcessModalFunc = { processModal ->
        processModal.cancelBtn.click()
        "Проверить, что модальное окно закрылось" {
            processModal shouldNot visible
        }
    }
)

@LTBTaskIdsUiForm
@LTBTaskIdsUiProcess
@LowPriority
class UiLTBBankProcessControlForbiddenSymbolsTest(
    bankUser: User,
    forbiddenSymbols: String = "Ђ"
) : UiLTBBankProcessModalControlsTest(
    nameDetails = "Результат обработки. Недопустимые символы",
    bankUser = bankUser,
    actionsOnProcessModalFunc = { processModal ->
        processModal.processResult.value = "$forbiddenSymbols FE AT-process (failure)"
        processModal.processBtn.click()
        "Проверить сообщение об ошибке (недопустимые символы в результате обработки)" {
            val expErrorMsgForbiddenSymbols =
                UiControlMessage.getFieldHasForbiddenSymbolsMsg(UI_FIELD_NAME_PROCESS_RESULT, forbiddenSymbols)
            UiCommonChecks.checkTooltipMessage(expErrorMsgForbiddenSymbols)
        }
    }
)