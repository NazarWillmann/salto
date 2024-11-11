package ooo.jtc.ui.letters.frombank.tests

import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionCustomerIdByStatus
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareExportSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareExportSteps.prepareExportFileNameRegexMultipleDocs
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps.preparePrintFileNameSingleDoc
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createDeliveredLetterFromBank
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createLetterFromBankDto
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getOrCreateDifferentLetterFromBankDtoList
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.core.elements.scroller.UiSortDirection
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import ooo.jtc.testdata.letters.frombank.UiLetterFromBankSortingParams
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lFBFormBasicRequisitesBank
import ooo.jtc.ui.application.BankApplication.lFBScrollerPageBank
import ooo.jtc.ui.application.ClientApplication.lFBFormBasicRequisitesClient
import ooo.jtc.ui.application.ClientApplication.lFBScrollerPageClient
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.common.templates.UiScrollerCategoryTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerExportGroupTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerExportTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSortingFieldTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSortingTestTemplate
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiChangeHistory
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiExport
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiScroller
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiSorting
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerCategory
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerPage

@LFBTaskIdsUiChangeHistory
@NormalPriority
class UiLetterFromBankScrollerHistoryTest(
    user: User,
    preExecution: () -> LetterFromBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterFromBankDto, Unit>(
    name = "${DocumentNames.LETTER_FROM_BANK}. Просмотреть историю изменений документа из скроллера. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = if (pageType.isClient()) lFBScrollerPageClient else lFBScrollerPageBank
        val basicRequisitesTab = if (pageType.isClient()) lFBFormBasicRequisitesClient else lFBFormBasicRequisitesBank
        val historyTab = basicRequisitesTab.historyTab

        scrollerPage.openScrollerBy(user, customerId)
        val documentNumber = it.documentNumber
        scrollerPage.filterByDocumentNumber(documentNumber)
        scrollerPage.openTab(LetterFromBankScrollerCategory.ALL)

        scrollerPage.scroller
            .getRowByText(documentNumber)
            .moreButtonMenu.clickByOption("Просмотреть историю")

        historyTab.checkHeader()
        historyTab.checkDocumentNumber(documentNumber)
        historyTab.checkHistoryExist()
        val expStatus = LetterFromBankStatus.values.getDescriptionByStatus(it.status!!, user.userType)
        historyTab.checkLastStatus(expStatus)
    }
)

@LFBTaskIdsUiExport
@ComponentFreeFormatDoc
@NormalPriority
class UiLetterScrollerExportTest(
    user: User,
    exportFormat: LetterFromBankPrintExportFormat
) : UiScrollerExportTestTemplate<LetterFromBankDto, LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isBank) lFBScrollerPageBank else lFBScrollerPageClient,
    scrollerCategory = if (user.isBank) LetterFromBankScrollerCategory.ALL else null,
    entityName = DocumentNames.LETTER_FROM_BANK,
    format = exportFormat,
    availableFormats = LetterFromBankPrintExportFormat.exportFormats,
    preExecution = { LetterFromBankPreExecutions.LFBPreExecutionDelivered(user) },
    getExpFileName = { preparePrintFileNameSingleDoc(it) + "." + exportFormat.format.name.toLowerCase() },
    getExpFileContentFunc = { LetterFromBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listOf(it), user.userType) }
)

@LFBTaskIdsUiExport
@ComponentFreeFormatDoc
@NormalPriority
class UiLetterScrollerExportGroupTest(
    user: User,
    exportFormat: LetterFromBankPrintExportFormat,
) : UiScrollerExportGroupTestTemplate<LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isBank) lFBScrollerPageBank else lFBScrollerPageClient,
    scrollerCategory = if (user.isBank) LetterFromBankScrollerCategory.ALL else null,
    preExecution = { LFBPreExecutionCustomerIdByStatus(user, 2, DELIVERED) },
    entityName = DocumentNames.LETTER_FROM_BANK,
    format = exportFormat,
    availableFormats = LetterFromBankPrintExportFormat.exportFormats,
    getExpFileName = { prepareExportFileNameRegexMultipleDocs() },
    getExpTableContentFunc = { actIds ->
        val steps = LetterFromBankSteps(user)
        val listExpDto = actIds.map { steps.getById(it).data.getOrException() }
        LetterFromBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listExpDto, user.userType)
    }
)

@LFBTaskIdsUiSorting
@NormalPriority
class UiLetterFromBankSortingTest(
    user: User,
    sortingParams: UiLetterFromBankSortingParams,
    pageType: ApplicationPageType
) : UiScrollerSortingTestTemplate<LetterFromBankScrollerPage, LetterFromBankScrollerCategory, UiLetterFromBankSortingParams>(
    user = user,
    scrollerPage = if (pageType.isClient()) lFBScrollerPageClient else lFBScrollerPageBank,
    scrollerCategory = if (pageType.isClient()) null else LetterFromBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_FROM_BANK,
    sortingParam = sortingParams,
    preExecution = {
        val branchCustomer = BranchCustomerData.searchBy(user).random()
        val customerId = branchCustomer.customerId
        getOrCreateDifferentLetterFromBankDtoList(
            searchingUser = user,
            getPageRequest = { LetterFromBankFilterParams.CUSTOMER_ID.eq(customerId).toPageRequest() },
            createLfbFunc = {
                val bankUser = retrieveBankUser(user)
                val branchId = branchCustomer.branchId
                if (pageType.isBank()) {
                    BranchPrepareSteps.ensureBankUserIsRelatedToBranch(bankUser, branchId)
                    createLetterFromBankDto(
                        creatorBankUser = bankUser,
                        dtoForCreate = getLetterFromBankDtoForCreate(customerId = customerId, branchId = branchId)
                    )
                } else {
                    val clientUser = retrieveClientUser(user)
                    CustomerPrepareSteps.ensureClientUserIsRelatedToCustomer(clientUser, customerId)
                    createDeliveredLetterFromBank(
                        creatorBankUser = bankUser,
                        dtoForCreate = getLetterFromBankDtoForCreate(customerId = customerId, branchId = branchId)
                    )
                }
            }
        )
        customerId
    }
)

@LFBTaskIdsUiSorting
@NormalPriority
class UiLetterFromBankSortingFieldsClientTest(
    clientUser: User
) : UiScrollerSortingFieldTestTemplate<LetterFromBankScrollerPage>(
    user = clientUser,
    entityName = DocumentNames.LETTER_FROM_BANK,
    scrollerPage = lFBScrollerPageClient,
    expDefaultDirection = UiSortDirection.DESC,
    expDefaultSortingField = UiLetterFromBankSortingParams.DOCUMENT_DATE.fieldName,
    expSortingFields = UiLetterFromBankSortingParams.clientFields
)

@LFBTaskIdsUiSorting
@NormalPriority
class UiLetterFromBankSortingFieldsBankTest(
    bankUser: User
) : UiScrollerSortingFieldTestTemplate<LetterFromBankScrollerPage>(
    user = bankUser,
    entityName = DocumentNames.LETTER_FROM_BANK,
    scrollerPage = lFBScrollerPageBank,
    expDefaultDirection = UiSortDirection.DESC,
    expDefaultSortingField = UiLetterFromBankSortingParams.B_DOCUMENT_DATE.fieldName,
    expSortingFields = UiLetterFromBankSortingParams.bankFields
)

@LFBTaskIdsUiScroller
@NormalPriority
class UiLetterFromBankCategoryTest(
    user: User,
    scrollerCategory: LetterFromBankScrollerCategory,
    expStatuses: List<LetterFromBankStatus>
) :
    UiScrollerCategoryTestTemplate<LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
        user = user,
        scrollerPage = lFBScrollerPageBank,
        scrollerCategory = scrollerCategory,
        entityName = DocumentNames.LETTER_FROM_BANK,
        expStatuses = expStatuses.map { it.getDescription(user.userType) },
        preExecution = {
            val foundDto = LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
                searchingUser = user,
                additionalFilter = { dto -> dto.status in expStatuses.map { it.getUserStatus(user.userType) } },
                createLfbFunc = {
                    LetterFromBankPrepareSteps.createLetterFromBankInStatus(
                        creatorBankUser = user,
                        status = expStatuses.random()
                    )
                }
            )
            foundDto.customerId!!
        }
    )