package ooo.jtc.api.curtransfer.tests

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteDocumentTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.curtransfer.CurTransferPreExecutions.createCurTransferDto
import ooo.jtc.api.curtransfer.steps.CurTransferPrepareSteps
import ooo.jtc.api.curtransfer.steps.CurTransferPrepareSteps.getCurTransferDtoForCreate
import ooo.jtc.api.curtransfer.steps.CurTransferSteps
import ooo.jtc.core.tm4j.ComponentCurPayment
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_C_RKO_TRANSFER
import ooo.jtc.curtransfer.dto.CurTransferDto
import ooo.jtc.curtransfer.model.CurTransferStatus
import ooo.jtc.generic.DocumentNames
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${DocumentNames.CUR_TRANSFER} (curTransfer)"

@Folder("$baseFolder/${SubFolder.CRUD}")          annotation class CurTransferFolderCrud
@Folder("$baseFolder/${SubFolder.CONTROLS}")      annotation class CurTransferFolderControls
@Folder("$baseFolder/${SubFolder.SORTING}")       annotation class CurTransferFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")    annotation class CurTransferFolderFiltration
@Folder("$baseFolder/${SubFolder.LIFECYCLE}")     annotation class CurTransferFolderLifecycle
@Folder("$baseFolder/${SubFolder.OTHER}")         annotation class CurTransferFolderOther
@Folder("$baseFolder/${SubFolder.PRINT}")         annotation class CurTransferFolderPrint
@Folder("$baseFolder/${SubFolder.EXPORT}")        annotation class CurTransferFolderExport
@Folder("$baseFolder/${SubFolder.HISTORY}")       annotation class CurTransferFolderHistory

//TODO Sergeyev [2021.01.25]: update annotations when project structure is uploaded to Jira
private const val STORY_CUR_TRANSFER_COMMON = ""
private const val STORY_CUR_TRANSFER_DOC = ""
const val FEATURE_CUR_TRANSFER_DOC_API = ""
private const val FEATURE_CUR_TRANSFER_DOC_LIFECYCLE = ""
private const val FEATURE_CUR_TRANSFER_DOC_CONTROLS = ""

@TaskIds([EPIC_C_RKO_TRANSFER, STORY_CUR_TRANSFER_COMMON, STORY_CUR_TRANSFER_DOC])
annotation class CurTransferTaskIdsDoc
@TaskIds([EPIC_C_RKO_TRANSFER, STORY_CUR_TRANSFER_COMMON, STORY_CUR_TRANSFER_DOC, FEATURE_CUR_TRANSFER_DOC_API])
annotation class CurTransferTaskIdsDocApi
@TaskIds([EPIC_C_RKO_TRANSFER, STORY_CUR_TRANSFER_COMMON, STORY_CUR_TRANSFER_DOC, FEATURE_CUR_TRANSFER_DOC_LIFECYCLE])
annotation class CurTransferTaskIdsLifecycleApi
@TaskIds([EPIC_C_RKO_TRANSFER, STORY_CUR_TRANSFER_COMMON, STORY_CUR_TRANSFER_DOC, FEATURE_CUR_TRANSFER_DOC_CONTROLS])
annotation class CurTransferTaskIdsControlApi
//@formatter:on

@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class ClientCurTransferCreateTest(
    clientUser: User = Users.client,
    dtoForCreation: () -> CurTransferDto = { getCurTransferDtoForCreate(creatorClientUser = clientUser) }
) : CreateTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(clientUser),
    preExecution = dtoForCreation
)

@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class ClientCurTransferGetTest(
    user: User = Users.client
) : GetTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    preExecution = { createCurTransferDto(creatorClientUser = user) }
)

@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class ClientCurTransferGetPageTest(
    user: User = Users.client,
    private val ltbSteps: CurTransferSteps = CurTransferSteps(user)
) : GetPageTestTemplate<CurTransferDto>(
    steps = ltbSteps,
    preExecution = {
        CurTransferPrepareSteps.getOrCreateDifferentCurTransferDtoList(
            searchingUser = user,
            createLtbFunc = { createCurTransferDto(creatorClientUser = user) }
        )
    },
    postExecution = { list -> list.forEach { it.soft { ltbSteps.delete(it.id!!) } } }
)

@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class ClientCurTransferUpdateTest(
    user: User = Users.client,
    dtoForCreation: () -> CurTransferDto = { getCurTransferDtoForCreate(creatorClientUser = user) },
    dtoForUpdate: (CurTransferDto) -> CurTransferDto = { createdDto ->
        CurTransferPrepareSteps.getCurTransferDtoForUpdate(createdDto)
    },
    preCheckingHandling: (CurTransferDto) -> CurTransferDto = { it },
    additionalNameDetails: String = ""
) : UpdateTestTemplate<CurTransferDto, CurTransferDto>(
    steps = CurTransferSteps(user),
    preExecution = {
        val createdCurTransferClient = createCurTransferDto(user, dtoForCreation.invoke())
        dtoForUpdate.invoke(createdCurTransferClient)
    },
    preCheckingHandling = preCheckingHandling
) {
    var tempTestName = "'${steps.entityName}'." +
            " CRUD: Обновляем запись от пользователя$additionalNameDetails [${steps.user.userType}]"

    override fun name(): String = tempTestName
}

@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class ClientCurTransferDeleteTest(
    user: User = Users.client,
    preExecutionDto: () -> CurTransferDto = { getCurTransferDtoForCreate(creatorClientUser = user) }
) : DeleteDocumentTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    preExecution = { createCurTransferDto(user, preExecutionDto.invoke()) },
    deletedStatus = CurTransferStatus.DELETED.getUserStatus(user.userType)
)


@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class BankCurTransferGetTest(
    user: User = Users.bankOperator,
    letterToGet: (() -> CurTransferDto) = {
        TODO("Create sent CurTransfer")
        ///createSentCurTransfer(creatorClientUser = Users.defaultClientUser, receiverBankUser = user)
    }
) : GetTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    preExecution = letterToGet,
    postExecution = {}
)

@CurTransferTaskIdsDocApi
@CurTransferFolderCrud
@ComponentCurPayment
@HighPriority
class BankCurTransferGetPageTest(
    user: User = Users.bankOperator
) : GetPageTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user)
)

/*TODO Sergeyev [2021.01.25]: WiP
@CurTransferTaskIdsDocApi
@CurTransferFolderSorting
@ComponentCurPayment
@LowPriority
class CurTransferSortingTest(
    user: User = Users.defaultClientUser,
    sortRequestFunction: () -> List<Sort>,
    filterFunction: (() -> Filter)? = null,
    preExecution: (() -> Any)? = null,
    postExecution: ((Any) -> Unit)? = null
) : SortingTestTemplate<CurTransferDto, CurTransferSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    filter = filterFunction?.invoke(),
    steps = CurTransferSteps(user),
    clazz = CurTransferSortingParams::class.java,
    preExecution = preExecution,
    postExecution = postExecution
)

@CurTransferTaskIdsDocApi
@CurTransferFolderFiltration
@ComponentCurPayment
@NormalPriority
class CurTransferFiltrationTest(
    name: String,
    var user: User = Users.defaultClientUser,
    preExecution: () -> CurTransferDto,
    filterRequestFunction: (CurTransferDto?) -> FilterData
) : FiltrationTestTemplate<CurTransferDto, CurTransferFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CurTransferSteps(user),
    clazz = CurTransferFilterParams::class.java,
    preExecution = preExecution
)

@CurTransferTaskIdsDocApi
@CurTransferFolderFiltration
@ComponentCurPayment
@NormalPriority
class CurTransferFiltrationCountTest(
    user: User = Users.defaultClientUser,
    filter: Filter
) : FiltrationCountTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    filter = filter
)

@CurTransferTaskIdsDocApi
@CurTransferFolderFiltration
@ComponentCurPayment
@NormalPriority
class CurTransferCategoryTest(
    user: User,
    category: CurTransferCategory,
    createLTBInStatus: CurTransferStatus? = null,
    sortBy: List<Sort> = CurTransferSortingParams.DOCUMENT_NUMBER.desc()
) : CategoryTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    category = category,
    sortBy = sortBy,
    mapStatusToFilterDataFunction = { { CurTransferFilterParams.STATUS.eq(it.getUserStatus(user.userType)) } },
    preExecution = {
        CurTransferPrepareSteps.getOrCreateCurTransferDto(
            searchingUser = user,
            creatorClientUser = retrieveClientUser(user),
            getPageRequest = { category.getFilterData().toParams(sort = sortBy).toGetPageRequest() },
            createCurTrFunc = {
                CurTransferPrepareSteps.createCurTransferInStatus(
                    creatorClientUser = retrieveClientUser(user),
                    receiverBankUser = retrieveBankUser(user),
                    status = createLTBInStatus ?: category.getStatuses(user.userType).random()
                )
            }
        )
    }
)

@CurTransferTaskIdsDocApi
@CurTransferFolderFiltration
@ComponentCurPayment
@NormalPriority
class CurTransferCategorySummaryCountTest(
    user: User,
    ignoreCategories: List<String> = emptyList()
) : CategorySummaryCountTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    ignoreCategories = ignoreCategories,
)

@CurTransferTaskIdsDocApi
@CurTransferFolderFiltration
@ComponentCurPayment
@NormalPriority
class CurTransferCategoryListTest(
    user: User,
    expCategories: List<CurTransferCategory>
) : CategoryListTestTemplate<CurTransferDto>(
    steps = CurTransferSteps(user),
    expCategories = expCategories
)

@CurTransferTaskIdsDocApi
@CurTransferFolderFiltration
@ComponentCurPayment
@NormalPriority
class CurTransferPaginationTest(
    user: User
) : PaginationTestTemplate<CurTransferDto, CurTransferSortingParams>(
    steps = CurTransferSteps(user),
    sortParam = CurTransferSortingParams.DOCUMENT_NUMBER,
    createRecord = { CurTransferPrepareSteps.createCurTransferAvailableToUser(user) }
)

@CurTransferTaskIdsLifecycleApi
@CurTransferFolderLifecycle
@ComponentCurPayment
@HighPriority
class CurTransferLifecycleTest(
    user: User,
    statusTransition: String,
    preExecution: () -> CurTransferDto,
    testBody: (CurTransferDto?) -> CurTransferDto
) : AbstractBeTest<CurTransferDto, CurTransferDto>(
    name = "'${DocumentNames.CUR_TRANSFER}'. Жизненный цикл. Проверка перехода $statusTransition [${user.userType}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, "'${DocumentNames.CUR_TRANSFER}' в исходном статусе" to it!!) },
    testBody = testBody
)

@CurTransferTaskIdsLifecycleApi
@CurTransferFolderLifecycle
@ComponentCurPayment
@HighPriority
class CurTransferBatchLifecycleTest(
    user: User,
    statusTransition: String,
    preExecution: () -> List<CurTransferDto>,
    testBody: (List<CurTransferDto>?) -> List<CurTransferDto>
) : AbstractBeTest<List<CurTransferDto>, List<CurTransferDto>>(
    name = "'${DocumentNames.CUR_TRANSFER}'. Жизненный цикл. Проверка перехода $statusTransition [${user.userType}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, "Набор '${DocumentNames.CUR_TRANSFER}' в исходном статусе" to it!!) },
    testBody = testBody
)

@CurTransferTaskIdsDocApi
@CurTransferFolderOther
@ComponentCurPayment
@NormalPriority
class CurTransferAddToFavoritesTest(
    user: User,
    preExecution: () -> UUID
) : AddToFavoritesTestTemplate<CurTransferDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = CurTransferSteps(user),
    preExecution = preExecution
)

@CurTransferTaskIdsDocApi
@CurTransferFolderOther
@ComponentCurPayment
@NormalPriority
class CurTransferRemoveFromFavoritesTest(
    user: User,
    preExecution: () -> UUID
) : RemoveFromFavoritesTestTemplate<CurTransferDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = CurTransferSteps(user),
    preExecution = preExecution
)


@CurTransferTaskIdsDoc
@CurTransferFolderOther
@ComponentCurPayment
@NormalPriority
class CurTransferOtherTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    params = params,
    testBody = testBody
)

@CurTransferTaskIdsDocApi
@CurTransferFolderOther
@ComponentCurPayment
@NormalPriority
class CurTransferAbstractOtherTest<PR : Any, TR : Any>(
    name: String,
    preExecution: (() -> PR)? = null,
    postExecution: ((TR) -> Unit)? = null,
    params: ((PR?) -> Map<String, Any>)? = null,
    testBody: (PR?) -> TR
) : AbstractBeTest<PR, TR>(
    name = name,
    preExecution = preExecution,
    params = params,
    testBody = testBody,
    postExecution = postExecution
)

@CurTransferTaskIdsControlApi
@CurTransferFolderControls
@ComponentCurPayment
@HighPriority
class CurTransferControlTest(
    testName: String,
    preExecution: (() -> CurTransferDto)?,
    control: CurTransferControls,
    steps: CurTransferSteps = CurTransferSteps(Users.defaultClientUser)
) : DocumentControlTestTemplate<CurTransferDto>(
    testName = testName,
    control = control,
    preExecution = preExecution,
    steps = steps
)

@CurTransferTaskIdsDocApi
@CurTransferFolderOther
@ComponentCurPayment
@HighPriority
class CurTransferSendTest(
    val bankUser: User,
    val clientUser: User
) : AbstractTest<CurTransferDto, CurTransferDto>(
    name = "'${DocumentNames.CUR_TRANSFER}'. Отправка документов в Банк. Проверка корректности статуса",
    preExecution = { CurTransferPrepareSteps.createSignedCurTransfer(clientUser) },
) {
    override fun execution(preconditionResult: CurTransferDto?) {
        val docChecks = ApiDocumentChecks<CurTransferDto>()
        clientUser.checkIsClientUser()
        val response = CurTransferSteps(clientUser).send(preconditionResult!!.id!!)
        val actResult = response.data.getOrException()
        docChecks.checkDocumentStatus(actResult, listOf(CurTransferStatus.DELIVERED.statusClient))

        val bankResult = CurTransferSteps(bankUser).getById(actResult.id!!)
        docChecks.checkDocumentStatus(bankResult.data!!, listOf(CurTransferStatus.DELIVERED.statusBank))
    }
}*/