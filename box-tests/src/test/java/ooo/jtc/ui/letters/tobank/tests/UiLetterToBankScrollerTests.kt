package ooo.jtc.ui.letters.tobank.tests

import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionCustomerIdByStatus
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBPreExecutionNew
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions.LTBUiExpSentStatuses
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareExportSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareExportSteps.prepareExportFileNameRegexMultipleDocs
import ooo.jtc.api.letters.tobank.steps.LetterToBankPreparePrintSteps.preparePrintFileNameSingleDoc
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createDraftLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankDto
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankInStatus
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createNewLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getLetterToBankDtoForCreate
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getOrCreateLetterToBankDto
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.elements.scroller.UiSortDirection
import ooo.jtc.core.kexensions.getClientRepresentativePhone
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankActions
import ooo.jtc.letters.model.LetterToBankActions.PRINT_REGISTER
import ooo.jtc.letters.model.LetterToBankPrintExportFormat
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PARTLY_SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import ooo.jtc.testdata.letters.tobank.LetterToBankUiSortingParams
import ooo.jtc.testdata.letters.tobank.UiLetterToBankFiltrationParamsBank
import ooo.jtc.testdata.letters.tobank.UiLetterToBankFiltrationParamsClient
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lTBFormBasicRequisitesBank
import ooo.jtc.ui.application.BankApplication.lTBScrollerPageBank
import ooo.jtc.ui.application.ClientApplication.lTBFormBasicRequisitesClient
import ooo.jtc.ui.application.ClientApplication.lTBScrollerPageClient
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.actions.UiActionPlace.BY_EXPAND_PANEL
import ooo.jtc.ui.common.actions.UiActionPlace.BY_SINGLE_GROUP
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.common.templates.UiAddRemoveFavoriteTestTemplate
import ooo.jtc.ui.common.templates.UiFavoritesModeTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerCategoryTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerCopyTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerDeleteTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerEditTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerExportExpandPanelTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerExportGroupTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerExportTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerFiltrationTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSendToBankMultiDocTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSendToBankSingleDocTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSignFormTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSortingFieldTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerSortingTestTemplate
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiExport
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiFavorites
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiForm
import ooo.jtc.ui.letters.tobank.LTBTaskIdsUiScroller
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormBasicRequisitesTab
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerCategory
import ooo.jtc.ui.pages.documents.lettertobank.scroller.LetterToBankScrollerPage
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankModalSignDocument
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterBank
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterClient
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerRowBank
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerRowClient
import java.util.*
import java.util.stream.Stream
import kotlin.streams.toList

@LTBTaskIdsUiFavorites
@NormalPriority
class UiLetterToBankScrollerHistoryTest(
    user: User,
    preExecution: () -> LetterToBankDto,
    pageType: ApplicationPageType
) : AbstractUiTest<LetterToBankDto, Unit>(
    name = "${DocumentNames.LETTER_TO_BANK}. Просмотреть историю изменений документа из скроллера. [${pageType.uiName}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to it!!) },
    testBody = {
        val customerId = it!!.customerId!!
        val scrollerPage = if (pageType.isClient()) lTBScrollerPageClient else lTBScrollerPageBank
        val basicRequisitesTab = if (pageType.isClient()) lTBFormBasicRequisitesClient else lTBFormBasicRequisitesBank
        val historyTab = basicRequisitesTab.historyTab

        scrollerPage.openScrollerBy(user, customerId)
        val documentNumber = it.documentNumber
        scrollerPage.filterByDocumentNumber(documentNumber)
        scrollerPage.openTab(LetterToBankScrollerCategory.ALL)

        scrollerPage.scroller
            .getRowByText(documentNumber)
            .moreButtonMenu.clickByOption("Просмотреть историю")

        historyTab.checkHeader()
        historyTab.checkDocumentNumber(documentNumber)
        historyTab.checkHistoryExist()
        val expStatus = LetterToBankStatus.values.getDescriptionByStatus(it.status!!, user.userType)
        historyTab.checkLastStatus(expStatus)
    }
)

@LTBTaskIdsUiFavorites
@NormalPriority
class UiLetterToBankAddRemoveFavoriteClientTest(
    user: User
) : UiAddRemoveFavoriteTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    preExecution = {
        val clientUser = if (user.isClient) user else client
        val bankUser = if (user.isBank) user else bankAdmin
        val foundDto = getOrCreateLetterToBankDto(
            searchingUser = user,
            additionalFilter = { !it.isFavorites!! },
            createLtbFunc = { getLetterToBankDtoForCreate(clientUser, bankUser).apply { this.isFavorites = false } }
        )
        Mappers.letterToBankViewMapper.toView(foundDto)
    }
)

@LTBTaskIdsUiFavorites
@NormalPriority
class UiLetterToBankFavoritesModeClientTest(
    user: User
) : UiFavoritesModeTestTemplate<LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    preExecution = {
        val clientUser = if (user.isClient) user else client
        val bankUser = if (user.isBank) user else bankAdmin
        val commonCustomersId = CustomerData.getOrCreateCommonCustomersId(clientUser, bankUser)
        val pageRequest = LetterToBankFilterParams.CUSTOMER_ID.eq(commonCustomersId).toPageRequest()
        val letterToBankSteps = LetterToBankSteps(clientUser)
        val letters = letterToBankSteps.getPageAll(pageRequest).page.getOrException()

        if (letters.size < 2 || letters.none { it.isFavorites!! } || letters.none { !it.isFavorites!! }) {
            when {
                letters.size < 2 -> {
                    val favoriteDtoForCreate = getLetterToBankDtoForCreate(commonCustomersId)
                    createNewLetterToBank(clientUser, bankUser, favoriteDtoForCreate)
                    val notFavoriteDtoForCreate = getLetterToBankDtoForCreate(commonCustomersId).apply { this.isFavorites = false }
                    createNewLetterToBank(clientUser, bankUser, notFavoriteDtoForCreate)
                }
                letters.none { it.isFavorites!! } -> {
                    val letterId = letters.random().id!!
                    letterToBankSteps.addToFavorites(letterId)
                }
                else -> {
                    val letterId = letters.random().id!!
                    letterToBankSteps.removeFromFavorites(letterId)
                }
            }
        }
        commonCustomersId
    }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLetterToBankDeleteTest(user: User) :
    UiScrollerDeleteTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
        user = user,
        scrollerPage = lTBScrollerPageClient,
        scrollerCategory = LetterToBankScrollerCategory.DRAFTS,
        entityName = DocumentNames.LETTER_TO_BANK,
        expRowContextActions = LetterToBankActions.getActionsBy(DRAFT).filterNot { it == PRINT_REGISTER }.map { it.getUiName() },
        preExecution = {
            val foundDto = createDraftLetterToBank(creatorClientUser = user)
            Mappers.letterToBankViewMapper.toView(foundDto)
        }
    )

@LTBTaskIdsUiScroller
@HighPriority
open class UiLTBScrollerSignFormSingleDocTest(
    user: User,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW,
    docCount: Int = 1,
    preExecution: () -> UUID = { LTBPreExecutionNew(user).customerId!! }
) : UiScrollerSignFormTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory, LetterToBankModalSignDocument>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.FOR_SIGNATURE,
    modalSignDocument = LetterToBankModalSignDocument(),
    entityName = DocumentNames.LETTER_TO_BANK,
    preExecution = preExecution,
    docCount = docCount,
    actionPlace = actionPlace
)

@LTBTaskIdsUiScroller
@LowPriority
open class UiLTBScrollerSignExpandPanelTest(user: User) : UiLTBScrollerSignFormSingleDocTest(user = user, actionPlace = BY_EXPAND_PANEL)

@LTBTaskIdsUiScroller
@LowPriority
open class UiLTBScrollerSignSingleGroupTest(user: User) : UiLTBScrollerSignFormSingleDocTest(user = user, actionPlace = BY_SINGLE_GROUP)

@LTBTaskIdsUiScroller
@HighPriority
open class UiLTBScrollerSignMultipleGroupTest(user: User) : UiLTBScrollerSignFormSingleDocTest(
    user = user,
    actionPlace = BY_SINGLE_GROUP,
    docCount = 2,
    preExecution = { LTBPreExecutionCustomerIdByStatus(user, 2, NEW) }
)

@LTBTaskIdsUiScroller
@HighPriority
open class UiLTBScrollerSendToBankSingleDocTest(user: User, actionPlace: UiActionPlace = UiActionPlace.BY_ROW) :
    UiScrollerSendToBankSingleDocTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
        user = user,
        scrollerPage = lTBScrollerPageClient,
        scrollerCategory = LetterToBankScrollerCategory.FOR_SEND,
        entityName = DocumentNames.LETTER_TO_BANK,
        beSteps = LetterToBankSteps(user),
        expStatuses = LTBUiExpSentStatuses(user),
        preExecution = { LetterToBankPreExecutions.LTBPreExecutionSigned(user) },
        actionPlace = actionPlace
    )

@LTBTaskIdsUiScroller
@LowPriority
open class UiLTBScrollerSendToBankExpandPanelTest(user: User) : UiLTBScrollerSendToBankSingleDocTest(user = user, actionPlace = BY_EXPAND_PANEL)

@LTBTaskIdsUiScroller
@LowPriority
open class UiLTBScrollerSendToBankSingleGroupTest(user: User) : UiLTBScrollerSendToBankSingleDocTest(user = user, actionPlace = BY_SINGLE_GROUP)

@LTBTaskIdsUiScroller
@HighPriority
class UiLTBScrollerSendToBankMultiDocTest(
    user: User
) : UiScrollerSendToBankMultiDocTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.FOR_SEND,
    entityName = DocumentNames.LETTER_TO_BANK,
    beSteps = LetterToBankSteps(user),
    expStatuses = LTBUiExpSentStatuses(user),
    preExecution = { LTBPreExecutionCustomerIdByStatus(user, 2, SIGNED) },
)

@LTBTaskIdsUiForm
@HighPriority
open class UiLTBScrollerEditTest(
    user: User,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW
) : UiScrollerEditTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory, LetterToBankFormBasicRequisitesTab>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    entityName = DocumentNames.LETTER_TO_BANK,
    formPage = lTBFormBasicRequisitesClient,
    expHeaderText = "Письмо в банк",
    actionPlace = actionPlace,
    preExecution = {
        LTBPreExecutionNew(user).toView()
    },
    scrollerCategory = LetterToBankScrollerCategory.FOR_SIGNATURE,
)

@LTBTaskIdsUiScroller
@HighPriority
open class UiLTBScrollerCopyTest(
    user: User,
    actionPlace: UiActionPlace = UiActionPlace.BY_ROW
) : UiScrollerCopyTestTemplate<LetterToBankView, LetterToBankScrollerPage, LetterToBankScrollerCategory, LetterToBankFormBasicRequisitesTab>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.FOR_SIGNATURE,
    entityName = DocumentNames.LETTER_TO_BANK,
    preExecution = {
        LTBPreExecutionNew(user).toView()
            .apply {
                this.contactName = user.getFio()
                this.contactPhone = user.getClientRepresentativePhone(this.customerId) ?: ""
            }
    },
    formPage = lTBFormBasicRequisitesClient,
    expHeaderText = "Новое письмо в банк",
    actionPlace = actionPlace
)

@LTBTaskIdsUiScroller
@LowPriority
open class UiLTBScrollerCopyExpandPanelTest(user: User) : UiLTBScrollerCopyTest(user = user, actionPlace = BY_EXPAND_PANEL)

@LTBTaskIdsUiScroller
@LowPriority
open class UiLTBScrollerCopySingleGroupTest(user: User) : UiLTBScrollerCopyTest(user = user, actionPlace = BY_SINGLE_GROUP)

@LTBTaskIdsUiExport
@NormalPriority
class UiLTBScrollerExportTest(
    user: User,
    exportFormat: LetterToBankPrintExportFormat
) : UiScrollerExportTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    format = exportFormat,
    availableFormats = LetterToBankPrintExportFormat.exportFormats,
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived(user) },
    getExpFileName = { preparePrintFileNameSingleDoc(it) + "." + exportFormat.format.name.toLowerCase() },
    getExpFileContentFunc = { LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listOf(it), user.userType) }
)

@LTBTaskIdsUiExport
@NormalPriority
class UiLTBScrollerExportExpandPanelTest(
    user: User,
    exportFormat: LetterToBankPrintExportFormat
) : UiScrollerExportExpandPanelTestTemplate<LetterToBankDto, LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    format = exportFormat,
    availableFormats = LetterToBankPrintExportFormat.exportFormats,
    preExecution = { LetterToBankPreExecutions.LTBPreExecutionReceived(user) },
    getExpFileName = { preparePrintFileNameSingleDoc(it) + "." + exportFormat.format.name.toLowerCase() },
    getExpFileContentFunc = { LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listOf(it), user.userType) }
)

@LTBTaskIdsUiExport
@NormalPriority
class UiLTBScrollerExportGroupTest(
    user: User,
    exportFormat: LetterToBankPrintExportFormat,
) : UiScrollerExportGroupTestTemplate<LetterToBankScrollerPage, LetterToBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    preExecution = { LTBPreExecutionCustomerIdByStatus(user, 2, RECEIVED) },
    entityName = DocumentNames.LETTER_TO_BANK,
    format = exportFormat,
    availableFormats = LetterToBankPrintExportFormat.exportFormats,
    getExpFileName = { prepareExportFileNameRegexMultipleDocs() },
    getExpTableContentFunc = { actIds ->
        val steps = LetterToBankSteps(user)
        val listExpDto = actIds.map { steps.getById(it).data.getOrException() }
        LetterToBankPrepareExportSteps.getExportExpContentByFormat(exportFormat.format, listExpDto, user.userType)
    }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLetterToBankCategoryTest(
    user: User,
    scrollerCategory: LetterToBankScrollerCategory,
    expStatuses: List<LetterToBankStatus>
) :
    UiScrollerCategoryTestTemplate<LetterToBankScrollerPage, LetterToBankScrollerCategory>(
        user = user,
        scrollerPage = lTBScrollerPageClient,
        scrollerCategory = scrollerCategory,
        entityName = DocumentNames.LETTER_TO_BANK,
        expStatuses = expStatuses.map { it.getDescription(user.userType) },
        preExecution = {
            val foundDto = getOrCreateLetterToBankDto(
                searchingUser = user,
                additionalFilter = { dto -> dto.status in expStatuses.map { it.getUserStatus(user.userType) } },
                createLtbFunc = {
                    val excludedStatuses = listOf(PARTLY_SIGNED, DELIVERED, FOR_RECEIVING)
                    createLetterToBankInStatus(
                        creatorClientUser = user,
                        status = expStatuses.filterNot { it in excludedStatuses }.random()
                    )
                }
            )
            foundDto.customerId!!
        }
    )

@LTBTaskIdsUiScroller
@NormalPriority
class UiLetterToBankSortingTest(
    user: User,
    sortingParams: LetterToBankUiSortingParams,
    pageType: ApplicationPageType
) : UiScrollerSortingTestTemplate<LetterToBankScrollerPage, LetterToBankScrollerCategory, LetterToBankUiSortingParams>(
    user = user,
    scrollerPage = if (pageType.isClient()) lTBScrollerPageClient else lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    sortingParam = sortingParams,
    preExecution = {
        val customerId = CustomerData.searchBy(user).random().id!!
        val pageRequest = LetterToBankFilterParams.CUSTOMER_ID.eq(customerId).toPageRequest()
        val page = LetterToBankSteps(user).getPage(pageRequest).page
        if (page == null || page.size < REQUIRED_DATA_COUNT) {
            val clientUser = if (user.isClient) user else client
            CustomerPrepareSteps.ensureClientUserIsRelatedToCustomer(clientUser = clientUser, customerId = customerId)
            Stream.generate {
                createLetterToBankDto(
                    creatorClientUser = clientUser,
                    dtoForCreate = getLetterToBankDtoForCreate(customerId)
                )
            }.limit(REQUIRED_DATA_COUNT).toList()
        }
        customerId
    }
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLetterToBankSortingFieldsClientTest(
    clientUser: User
) : UiScrollerSortingFieldTestTemplate<LetterToBankScrollerPage>(
    user = clientUser,
    entityName = DocumentNames.LETTER_TO_BANK,
    scrollerPage = lTBScrollerPageClient,
    expDefaultDirection = UiSortDirection.DESC,
    expDefaultSortingField = LetterToBankUiSortingParams.CREATED_AT.fieldName,
    expSortingFields = LetterToBankUiSortingParams.clientFields
)

@LTBTaskIdsUiScroller
@NormalPriority
class UiLetterToBankSortingFieldsBankTest(
    bankUser: User
) : UiScrollerSortingFieldTestTemplate<LetterToBankScrollerPage>(
    user = bankUser,
    entityName = DocumentNames.LETTER_TO_BANK,
    scrollerPage = lTBScrollerPageBank,
    expDefaultDirection = UiSortDirection.DESC,
    expDefaultSortingField = LetterToBankUiSortingParams.B_DOCUMENT_DATE.fieldName,
    expSortingFields = LetterToBankUiSortingParams.bankFields
)

@LTBTaskIdsUiScroller
@HighPriority
class UiLetterToBankFiltrationClientTest(
    user: User,
    filtrationParam: UiLetterToBankFiltrationParamsClient,
    dtoForFiltration: LetterToBankDto
) : UiScrollerFiltrationTestTemplate<LetterToBankDto,
        LetterToBankScrollerPage,
        LetterToBankScrollerRowClient,
        LetterToBankScrollerCategory,
        LetterToBankScrollerFilterClient>(
    user = user,
    scrollerPage = lTBScrollerPageClient,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    filtrationParam = filtrationParam,
    preExecution = { dtoForFiltration }
)

@LTBTaskIdsUiScroller
@HighPriority
class UiLetterToBankFiltrationBankTest(
    user: User,
    filtrationParam: UiLetterToBankFiltrationParamsBank,
    dtoForFiltration: LetterToBankDto
) : UiScrollerFiltrationTestTemplate<LetterToBankDto,
        LetterToBankScrollerPage,
        LetterToBankScrollerRowBank,
        LetterToBankScrollerCategory,
        LetterToBankScrollerFilterBank>(
    user = user,
    scrollerPage = lTBScrollerPageBank,
    scrollerCategory = LetterToBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_TO_BANK,
    filtrationParam = filtrationParam,
    preExecution = { dtoForFiltration }
)