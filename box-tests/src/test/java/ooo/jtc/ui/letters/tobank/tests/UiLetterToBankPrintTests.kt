package ooo.jtc.ui.letters.tobank.tests

import com.mifmif.common.regex.Generex
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionCustomerIdByStatus
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionReceived
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionReceivedWithMultipleAttach
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps.preparePrintExpContent
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps.preparePrintFileNameSingleDoc
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps.preparePrintTableExpContent
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createReceivedLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankPrintExportFormat
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lTBScrollerPageBank
import ooo.jtc.ui.application.ClientApplication.lTBScrollerPageClient
import ooo.jtc.ui.common.templates.UiScrollerPrintTableMultiplePageTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerPrintTableTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerPrintTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiScroller
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage
import java.util.UUID
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.dtoForCreateWithMultipleAttach
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankAvailableToUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveClientUser
import ooo.jtc.core.TestConstants
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.random.RandomData
import org.hamcrest.MatcherAssert.assertThat

@LTBTaskIdsUiScroller
@NormalPriority
open class UiLTBScrollerPrintTestTemplate(
    user: User,
    printFormat: LetterToBankPrintExportFormat,
    testName: String? = null,
    preExecution: () -> LetterToBankDto,
    getExpFileContentFunc: (LetterToBankDto) -> List<String> = { preparePrintExpContent(listOf(it), true, user) },
    additionalChecks: (dto: LetterToBankDto, actContent: String) -> Unit = { _: LetterToBankDto, _: String -> }
) : UiScrollerPrintTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    format = printFormat,
    testName = testName,
    preExecution = preExecution,
    scrollerPage = if (user.isClient) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    availableFormats = LetterToBankPrintExportFormat.printFormats,
    getExpFileName = { preparePrintFileNameSingleDoc(it) + "." + printFormat.format.name.toLowerCase() },
    getExpFileContentFunc = getExpFileContentFunc,
    additionalChecks = additionalChecks
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLTBScrollerPrintTest(
    user: User,
    printFormat: LetterToBankPrintExportFormat
) : UiLTBScrollerPrintTestTemplate(
    user = user,
    printFormat = printFormat,
    preExecution = { LTBPreExecutionReceived(user) }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLTBScrollerPrintWithManyAttachmentsTest(
    user: User,
    printFormat: LetterToBankPrintExportFormat,
) : UiLTBScrollerPrintTestTemplate(
    user = user,
    testName = "${DocumentNames.LETTER_TO_BANK}. Проверка наличия реквизитов в ПФ. (из скроллера)." +
            "[${printFormat.description}]. Количество вложений > 5. [${user.userType}]",
    printFormat = printFormat,
    preExecution = { LTBPreExecutionReceivedWithMultipleAttach(user, 30) }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLTBScrollerPrintMultiPageHugeDocTest(
    user: User,
    printFormat: LetterToBankPrintExportFormat,
) : UiLTBScrollerPrintTestTemplate(
    user = user,
    testName = "${DocumentNames.LETTER_TO_BANK}. Проверка наличия реквизитов в ПФ. (из скроллера)." +
            "[${printFormat.description}]. 2 страницы. [${user.userType}]",
    printFormat = printFormat,
    preExecution = {
        val hugeLetterMarker = "HUGE_LETTER"
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.and(LetterToBankFilterParams.DOC_THEME.contains(hugeLetterMarker)).toPageRequest() },
            createLtbFunc = {
                /* Особая подготовка данных письма (такая же, как в UiLetterFromBankPrintTests.kt) */
                val stringGenerator = RandomData(Generex("[0-9a-zA-Zа-яА-Я]*"))

                // 255 - макс. длина темы по фронтовым (и мягким бэковым) контролям
                // 2000 - макс. длина текста по фронтовым (и мягким бэковым) контролям
                val hugeDocTheme = stringGenerator.hugeString(255, 65, hugeLetterMarker, TestConstants.AT_POSTFIX)
                val hugeDocText = stringGenerator.hugeString(2000, 65, "HugeLtrBody", TestConstants.AT_POSTFIX)
                createLetterToBankAvailableToUser(
                    user = user,
                    // 6 вложений - потому что иначе не набирается на 2 страницы
                    dtoForCreate = dtoForCreateWithMultipleAttach(retrieveClientUser(user), "hugeDocTinyFile", 6)
                        .apply {
                            docTheme = hugeDocTheme
                            docText = hugeDocText
                        }
                )
            }
        )
    },
    getExpFileContentFunc = {
        val documentPlainValues = preparePrintExpContent(listOf(it), true, user)
        documentPlainValues
            .map { value -> if (value.length > 100) value.split(' ') else listOf(value) }
            .flatten()
    },
    additionalChecks = { _: LetterToBankDto, actContent: String ->
        val pageQty = "Страница 2"
        assertThat("В документе нет строки '$pageQty'", actContent.contains(pageQty))
    }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLTBScrollerPrintTableTest(
    user: User,
    printFormat: LetterToBankPrintExportFormat,
) : UiScrollerPrintTableTestTemplate<LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    preExecution = { LTBPreExecutionCustomerIdByStatus(user, 2, LetterToBankStatus.RECEIVED) },
    searchStatus = LetterToBankStatus.RECEIVED.getDescription(user.userType),
    entityName = DocumentNames.LETTER_TO_BANK,
    printFormat = printFormat,
    printAvailableFormats = LetterToBankPrintExportFormat.printFormats,
    getExpFileName = { LetterToBankPreparePrintSteps.preparePrintTableFileNameRegex() },
    getExpTableContentFunc = { actIds ->
        val steps = LetterToBankSteps(user)
        val listExpDto = actIds.map { steps.getById(it).data.getOrException() }
        preparePrintTableExpContent(listExpDto, user.userType)
    }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLTBScrollerPrintTableMultiPageTest(
    user: User,
    printFormat: LetterToBankPrintExportFormat,
) : UiScrollerPrintTableMultiplePageTestTemplate<LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    preExecution = {
        /* необходимо наличие >=30 документов на скроллере.
        т.к. на UI письма отображаются для конкретного клиента, ищем у всех доступных пользователю клиентов. */
        val docCountNeed = 30
        val availableCustomers = CustomerData.searchBy(user)

        var customerWithMaxDocs: Pair<UUID, Int>? = null

        val steps = LetterToBankSteps(user)
        val availableCustomer = availableCustomers.find {
            val filter = LetterToBankFilterParams.CUSTOMER_ID.eq(it.id!!).toFilter()
            val count = steps.getCount(filter = filter).count

            //region Optimization. Get customer with max (from customers) docs. For creating missing docs if can't find >=30.
            val maxDocCustomer = customerWithMaxDocs
            if (maxDocCustomer == null) customerWithMaxDocs = Pair(it.id!!, count) //first init
            else {
                if (count > maxDocCustomer.second) customerWithMaxDocs = Pair(it.id!!, count)
            }
            //endregion

            count >= docCountNeed
        }

        val createMissedDocsFunc: (User, Pair<UUID, Int>) -> UUID = { clientUser, maxDocCustomer ->
            val missedDocCount = docCountNeed - maxDocCustomer.second
            repeat(missedDocCount) { createReceivedLetterToBank(creatorClientUser = clientUser) }
            maxDocCustomer.first
        }

        val preparedCustomerId = availableCustomer?.id ?: createMissedDocsFunc(user, customerWithMaxDocs!!)
        preparedCustomerId
    },
    entityName = DocumentNames.LETTER_TO_BANK,
    printFormat = printFormat,
    getExpTableContentFunc = {
        // TODO Sergeyev [2020.11.03]: this shouldn't be an empty list; ?needs default sorting for document type
        val allExpContent = preparePrintTableExpContent(emptyList(), user.userType).toMutableList()
        allExpContent.add("Страница 2")
        allExpContent
    }
)
