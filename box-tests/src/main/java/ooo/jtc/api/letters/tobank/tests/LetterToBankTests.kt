package ooo.jtc.api.letters.tobank.tests

import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.templates.entity.AddToFavoritesTestTemplate
import ooo.jtc.api.common.templates.entity.CategoryListTestTemplate
import ooo.jtc.api.common.templates.entity.CategorySummaryCountTestTemplate
import ooo.jtc.api.common.templates.entity.CategoryTestTemplate
import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteDocumentTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationCountTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.PaginationTestTemplate
import ooo.jtc.api.common.templates.entity.RemoveFromFavoritesTestTemplate
import ooo.jtc.api.common.templates.entity.ServerErrorTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankDto
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createReceivedLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createSentLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getLetterToBankDtoForCreate
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix.LETTER_TO_BANK
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_LETTERS
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.getFilterData
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.generic.pageparams.toGetPageRequest
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.interfaces.getOrException
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankCategory
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.LetterToBankControls
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams
import ooo.jtc.uaa.User
import java.util.*

//@formatter:off
private const val baseFolder = "$LETTER_TO_BANK (letterToBank)"

@Folder("$baseFolder/${SubFolder.CRUD}")          annotation class LetterToBankFolderCrud
@Folder("$baseFolder/${SubFolder.CONTROLS}")      annotation class LetterToBankFolderControls
@Folder("$baseFolder/${SubFolder.SORTING}")       annotation class LetterToBankFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")    annotation class LetterToBankFolderFiltration
@Folder("$baseFolder/${SubFolder.LIFECYCLE}")     annotation class LetterToBankFolderLifecycle
@Folder("$baseFolder/${SubFolder.OTHER}")         annotation class LetterToBankFolderOther
@Folder("$baseFolder/${SubFolder.PRINT}")         annotation class LetterToBankFolderPrint
@Folder("$baseFolder/${SubFolder.EXPORT}")        annotation class LetterToBankFolderExport
@Folder("$baseFolder/${SubFolder.HISTORY}")       annotation class LetterToBankFolderHistory

private const val STORY_LETTER_TO_BANK_COMMON = "JTCSALTO-1092"
private const val STORY_LETTER_TO_BANK_DOC = "JTCSALTO-1097"
const val FEATURE_LETTER_TO_BANK_DOC_API = "JTCSALTO-1186"
private const val FEATURE_LETTER_TO_BANK_DOC_LIFECYCLE = "JTCSALTO-1130"
private const val FEATURE_LETTER_TO_BANK_DOC_CONTROLS = "JTCSALTO-1131"

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_TO_BANK_COMMON, STORY_LETTER_TO_BANK_DOC])
annotation class LetterToBankTaskIdsDoc
@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_TO_BANK_COMMON, STORY_LETTER_TO_BANK_DOC, FEATURE_LETTER_TO_BANK_DOC_API])
annotation class LetterToBankTaskIdsDocApi
@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_TO_BANK_COMMON, STORY_LETTER_TO_BANK_DOC, FEATURE_LETTER_TO_BANK_DOC_API,
    FEATURE_LETTER_TO_BANK_DOC_LIFECYCLE])
annotation class LetterToBankTaskIdsLifecycleApi
@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_TO_BANK_COMMON, STORY_LETTER_TO_BANK_DOC, FEATURE_LETTER_TO_BANK_DOC_API,
    FEATURE_LETTER_TO_BANK_DOC_CONTROLS])
annotation class LetterToBankTaskIdsControlApi

//@formatter:on

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class ClientLetterToBankCreateTest(
    clientUser: User = Users.client,
    dtoForCreation: () -> LetterToBankDto = { getLetterToBankDtoForCreate(creatorClientUser = clientUser) }
) : CreateTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(clientUser),
    preExecution = dtoForCreation
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class ClientLetterToBankWithAttachCreateTest(
    clientUser: User = Users.client,
    dtoForCreation: () -> LetterToBankDto
) : CreateTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(clientUser),
    preExecution = dtoForCreation
) {
    override fun execution(preconditionResult: LetterToBankDto?) {
        val checks = ApiEntityChecks<LetterToBankDto>()
        val createdEntityResponse = steps.create(preconditionResult!!)
        val createdEntity = createdEntityResponse.data!!
        testResult = createdEntity
        checks.checkIdExist(createdEntityResponse)
        preconditionResult.version++
        val handlingExpectedDto = preconditionResult.apply {
            attachments?.forEach {
                it.dataHash = null
                it.accessToken = null
            }
        }
        checks.checkRequestResponseValid(handlingExpectedDto, createdEntityResponse, expValidationResult)
    }

    override fun name(): String = "'${steps.entityName}'. " +
            "CRUD: Создаем запись с вложениями от пользователя [${steps.user.userType}]"
}

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class ClientLetterToBankGetTest(
    user: User = Users.client
) : GetTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    preExecution = { createLetterToBankDto(creatorClientUser = user) }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class ClientLetterToBankGetPageTest(
    user: User = Users.client,
    private val ltbSteps: LetterToBankSteps = LetterToBankSteps(user)
) : GetPageTestTemplate<LetterToBankDto>(
    steps = ltbSteps,
    preExecution = {
        LetterToBankPrepareSteps.getOrCreateDifferentLetterToBankDtoList(
            searchingUser = user,
            createLtbFunc = { createLetterToBankDto(creatorClientUser = user) }
        )
    },
    postExecution = { list -> list.forEach { it.soft { ltbSteps.delete(it.id!!) } } }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class ClientLetterToBankUpdateTest(
    user: User = Users.client,
    dtoForCreation: () -> LetterToBankDto = { getLetterToBankDtoForCreate(creatorClientUser = user) },
    dtoForUpdate: (LetterToBankDto) -> LetterToBankDto = { createdDto ->
        LetterToBankPrepareSteps.getLetterToBankDtoForUpdate(createdDto)
    },
    preCheckingHandling: (LetterToBankDto) -> LetterToBankDto = { it },
    additionalNameDetails: String = ""
) : UpdateTestTemplate<LetterToBankDto, LetterToBankDto>(
    steps = LetterToBankSteps(user),
    preExecution = {
        val createdLetterToBankClient = createLetterToBankDto(user, dtoForCreation.invoke())
        dtoForUpdate.invoke(createdLetterToBankClient)
    },
    preCheckingHandling = preCheckingHandling
) {
    private var tempTestName = "'${steps.entityName}'." +
            " CRUD: Обновляем запись от пользователя$additionalNameDetails [${steps.user.userType}]"

    override fun name(): String = tempTestName
}

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class ClientLetterToBankDeleteTest(
    user: User = Users.client,
    preExecutionDto: () -> LetterToBankDto = { getLetterToBankDtoForCreate(creatorClientUser = user) }
) : DeleteDocumentTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    preExecution = { createLetterToBankDto(user, preExecutionDto.invoke()) },
    deletedStatus = LetterToBankStatus.DELETED.getUserStatus(user.userType)
)


@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class BankLetterToBankGetTest(
    user: User = Users.bankOperator,
    letterToGet: (() -> LetterToBankDto) = {
        createSentLetterToBank(creatorClientUser = Users.client, receiverBankUser = user)
    }
) : GetTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    preExecution = letterToGet,
    postExecution = {}
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class BankLetterToBankGetPageTest(
    user: User = Users.bankOperator
) : GetPageTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user)
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderSorting
@ComponentFreeFormatDoc
@LowPriority
class LetterToBankSortingTest(
    user: User = Users.client,
    sortRequestFunction: () -> List<Sort>,
    filterFunction: (() -> Filter)? = null
) : SortingTestTemplate<LetterToBankDto, LetterToBankSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    filter = filterFunction?.invoke(),
    steps = LetterToBankSteps(user),
    clazz = LetterToBankSortingParams::class.java
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankFiltrationTest(
    name: String,
    var user: User = Users.client,
    preExecution: () -> LetterToBankDto,
    filterRequestFunction: (LetterToBankDto?) -> FilterData
) : FiltrationTestTemplate<LetterToBankDto, LetterToBankFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = LetterToBankSteps(user),
    clazz = LetterToBankFilterParams::class.java,
    preExecution = preExecution
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankFiltrationCountTest(
    user: User = Users.client,
    filter: Filter
) : FiltrationCountTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    filter = filter
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankCategoryTest(
    user: User,
    category: LetterToBankCategory,
    createLTBInStatus: LetterToBankStatus? = null,
    sortBy: List<Sort> = LetterToBankSortingParams.DOCUMENT_NUMBER.desc()
) : CategoryTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    category = category,
    sortBy = sortBy,
    mapStatusToFilterDataFunction = { { LetterToBankFilterParams.STATUS.eq(it.getUserStatus(user.userType)) } },
    preExecution = {
        // TODO Sergeyev [2020.08.21]: подготовка данных для теста использует тестируемый запрос!
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = user,
            creatorClientUser = retrieveClientUser(user),
            getPageRequest = { category.getFilterData().toParams(sort = sortBy).toGetPageRequest() },
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankInStatus(
                    creatorClientUser = retrieveClientUser(user),
                    receiverBankUser = retrieveBankUser(user),
                    status = createLTBInStatus ?: category.getStatuses(user.userType).random()
                )
            }
        )
    }
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankCategorySummaryCountTest(
    user: User,
    ignoreCategories: List<String> = emptyList()
) : CategorySummaryCountTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    ignoreCategories = ignoreCategories,
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankCategoryListTest(
    user: User,
    expCategories: List<LetterToBankCategory>
) : CategoryListTestTemplate<LetterToBankDto>(
    steps = LetterToBankSteps(user),
    expCategories = expCategories
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankPaginationTest(
    user: User
) : PaginationTestTemplate<LetterToBankDto, LetterToBankSortingParams>(
    steps = LetterToBankSteps(user),
    sortParam = LetterToBankSortingParams.DOCUMENT_NUMBER,
    createRecord = {
        if (user.isClient) createLetterToBankDto(creatorClientUser = user)
        else createReceivedLetterToBank(creatorClientUser = retrieveClientUser(user), receiverBankUser = user)
    }
)

@LetterToBankTaskIdsLifecycleApi
@LetterToBankFolderLifecycle
@ComponentFreeFormatDoc
@HighPriority
class LetterToBankLifecycleTest(
    user: User,
    statusTransition: String,
    preExecution: () -> LetterToBankDto,
    testBody: (LetterToBankDto?) -> LetterToBankDto
) : AbstractBeTest<LetterToBankDto, LetterToBankDto>(
    name = "'${DocumentNames.LETTER_TO_BANK}'. Жизненный цикл. Проверка перехода $statusTransition [${user.userType}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, "'${DocumentNames.LETTER_TO_BANK}' в исходном статусе" to it!!) },
    testBody = testBody
)

@LetterToBankTaskIdsLifecycleApi
@LetterToBankFolderLifecycle
@ComponentFreeFormatDoc
@HighPriority
class LetterToBankBatchLifecycleTest(
    user: User,
    statusTransition: String,
    preExecution: () -> List<LetterToBankDto>,
    testBody: (List<LetterToBankDto>?) -> List<LetterToBankDto>
) : AbstractBeTest<List<LetterToBankDto>, List<LetterToBankDto>>(
    name = "'${DocumentNames.LETTER_TO_BANK}'. Жизненный цикл. Проверка перехода $statusTransition [${user.userType}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, "Набор '${DocumentNames.LETTER_TO_BANK}' в исходном статусе" to it!!) },
    testBody = testBody
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankAddToFavoritesTest(
    user: User,
    preExecution: () -> UUID
) : AddToFavoritesTestTemplate<LetterToBankDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = LetterToBankSteps(user),
    preExecution = preExecution
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankRemoveFromFavoritesTest(
    user: User,
    preExecution: () -> UUID
) : RemoveFromFavoritesTestTemplate<LetterToBankDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = LetterToBankSteps(user),
    preExecution = preExecution
)


@LetterToBankTaskIdsDoc
@LetterToBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankOtherTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    params = params,
    testBody = testBody
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterToBankAbstractOtherTest<PR : Any, TR : Any>(
    name: String,
    preExecution: (() -> PR)? = null,
    params: ((PR?) -> Map<String, Any>)? = null,
    testBody: (PR?) -> TR
) : AbstractBeTest<PR, TR>(
    name = name,
    preExecution = preExecution,
    params = params,
    testBody = testBody
)

@LetterToBankTaskIdsControlApi
@LetterToBankFolderControls
@ComponentFreeFormatDoc
@HighPriority
class LetterToBankControlTest(
    testName: String,
    preExecution: (() -> LetterToBankDto)?,
    control: LetterToBankControls,
    steps: LetterToBankSteps = LetterToBankSteps(Users.client)
) : NestedControlTestTemplate<LetterToBankDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    testPostExecution = {
        if (it.id != null) steps.delete(it.id!!)
    },
    steps = steps
)

@LetterToBankTaskIdsControlApi
@LetterToBankFolderControls
@ComponentFreeFormatDoc
@HighPriority
class LetterToBankServerErrorTest(
    testName: String,
    user: User = Users.client,
    preExecution: (() -> LetterToBankDto),
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
) : ServerErrorTestTemplate<LetterToBankDto, LetterToBankDto>(
    testName = testName,
    user = user,
    preExecution = preExecution,
    steps = LetterToBankSteps(user),
    expectedHttpCode = expectedHttpCode,
    expectedCode = expectedCode,
    expectedMessage = expectedMessage,
)

@LetterToBankTaskIdsDocApi
@LetterToBankFolderOther
@ComponentFreeFormatDoc
@HighPriority
class LetterToBankSendTest(
    val bankUser: User,
    val clientUser: User
) : AbstractTest<LetterToBankDto, LetterToBankDto>(
    name = "'${DocumentNames.LETTER_TO_BANK}'. Отправка документов в Банк. Проверка корректности статуса",
    preExecution = { LetterToBankPrepareSteps.createSignedLetterToBank(clientUser) },
) {
    override fun execution(preconditionResult: LetterToBankDto?) {
        val docChecks = ApiDocumentChecks<LetterToBankDto>()
        clientUser.checkIsClientUser()
        val response = LetterToBankSteps(clientUser).send(preconditionResult!!.id!!)
        val actResult = response.data.getOrException()
        docChecks.checkDocumentStatus(actResult, listOf(DELIVERED.statusClient))

        val bankResult = LetterToBankSteps(bankUser).getById(actResult.id!!)
        docChecks.checkDocumentStatus(bankResult.data!!, listOf(DELIVERED.statusBank, FOR_RECEIVING.statusBank))
    }
}