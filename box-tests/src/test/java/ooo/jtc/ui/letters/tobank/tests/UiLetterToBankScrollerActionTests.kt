package ooo.jtc.ui.letters.tobank.tests

import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.generic.DocumentNames
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.ClientApplication
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.templates.UiScrollerUnSignFormTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiScroller
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage


@LTBTaskIdsUiScroller
@HighPriority
open class UiLTBScrollerUnSignFormSingleDocTest(
    user: User,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW,
    docCount: Int = 1,
    preExecution: () -> List<LetterToBankView> = { listOf(LetterToBankPreExecutions.LTBPreExecutionSelfSigned(user).toView()) }
) : UiScrollerUnSignFormTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = ClientApplication.lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.FOR_SEND,
    entityName = DocumentNames.LETTER_TO_BANK,
    preExecution = preExecution,
    docCount = docCount,
    actionPlace = actionPlace
)

@LTBTaskIdsUiScroller
@HighPriority
open class UiLTBScrollerUnSignFormMultipleDocTest(
    user: User,
    docCount: Int = 2
) : UiLTBScrollerUnSignFormSingleDocTest(
    user = user,
    preExecution = {
        val customerId = CustomerData.searchBy(user).random().id!!
        LetterToBankPreExecutions.LTBPreExecutionSelfSignedForCustomer(user, customerId, docCount).map { it.toView() }
    },
    docCount = docCount,
    actionPlace = UiActionPlace.BY_SINGLE_GROUP
)