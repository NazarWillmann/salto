package ooo.jtc.api.letters.frombank.tests

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
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createDeliveredLetterFromBank
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createLetterFromBankDto
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveClientUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.asserts.assertEqualList
import ooo.jtc.core.LetterFromBankLifecycleConstants
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix.LETTER_FROM_BANK
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_LETTERS
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_LETTERS
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_LFB
import ooo.jtc.documents.SignatureDto
import ooo.jtc.documents.getBankOrClientStatus
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.getFilterData
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.generic.pageparams.toGetPageRequest
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.interfaces.getOrException
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankCategory
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterFromBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterFromBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterFromBankStatus.WRONG_ESIGNATURE
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.frombank.LetterFromBankControls
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams
import ooo.jtc.testdata.uaa.user.UaaUserData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.user.model.getUserDetails
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import java.util.*

//@formatter:off
private const val baseFolder = "$LETTER_FROM_BANK (letterFromBank)"

@Folder("$baseFolder/${SubFolder.CONTROLS}")    annotation class LetterFromBankFolderControls
@Folder("$baseFolder/${SubFolder.CRUD}")        annotation class LetterFromBankFolderCrud
@Folder("$baseFolder/${SubFolder.EXPORT}")      annotation class LetterFromBankFolderExport
@Folder("$baseFolder/${SubFolder.FILTRATION}")  annotation class LetterFromBankFolderFiltration
@Folder("$baseFolder/${SubFolder.LIFECYCLE}")   annotation class LetterFromBankFolderLifecycle
@Folder("$baseFolder/${SubFolder.OTHER}")       annotation class LetterFromBankFolderOther
@Folder("$baseFolder/${SubFolder.HISTORY}")     annotation class LetterFromBankFolderHistory
@Folder("$baseFolder/${SubFolder.SIGNATURE}")   annotation class LetterFromBankFolderSignatures
@Folder("$baseFolder/${SubFolder.PRINT}")       annotation class LetterFromBankFolderPrint
@Folder("$baseFolder/${SubFolder.SORTING}")     annotation class LetterFromBankFolderSorting

private const val STORY_LETTER_FROM_BANK_UC = "JTCSALTO-1979"
const val FEATURE_LETTER_FROM_BANK_DOC_API = "JTCSALTO-1981"
const val FEATURE_LETTER_FROM_BANK_PRINT = "JTCSALTO-2034"
const val FEATURE_LETTER_EXPORT = "JTCSALTO-1955"
const val LETTER_FROM_BANK_PRINT_DOC_AT_SUBTASK = "JTCSALTO-2038"
const val LETTER_FROM_BANK_PRINT_TABLE_AT_SUBTASK = "JTCSALTO-2043"
const val LETTER_FROM_BANK_EXPORT_AT_SUBTASK = "JTCSALTO-2694"
const val LETTER_FROM_BANK_LIFECYCLE_TASK = "JTCSALTO-1975"
const val LETTER_FROM_BANK_LIFECYCLE_AT_SUBTASK = "JTCSALTO-1978"

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_FROM_BANK_UC, AT_STORY_LETTERS, AT_STORY_LFB, FEATURE_LETTER_FROM_BANK_DOC_API])
annotation class LetterFromBankTaskIdsDocApi

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_FROM_BANK_UC, AT_STORY_LETTERS, AT_STORY_LFB,
    LETTER_FROM_BANK_LIFECYCLE_TASK, LETTER_FROM_BANK_LIFECYCLE_AT_SUBTASK])
annotation class LetterFromBankTaskIdsLifecycleApi

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_FROM_BANK_UC, AT_STORY_LETTERS, AT_STORY_LFB,
    FEATURE_LETTER_FROM_BANK_DOC_API, FEATURE_LETTER_FROM_BANK_PRINT])
annotation class LetterFromBankTaskIdsPrint

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_FROM_BANK_UC, AT_STORY_LETTERS, AT_STORY_LFB,
    FEATURE_LETTER_FROM_BANK_DOC_API, FEATURE_LETTER_FROM_BANK_PRINT, LETTER_FROM_BANK_PRINT_DOC_AT_SUBTASK])
annotation class LetterFromBankTaskIdsPrintDoc

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_FROM_BANK_UC, AT_STORY_LETTERS, AT_STORY_LFB,
    FEATURE_LETTER_FROM_BANK_DOC_API, FEATURE_LETTER_FROM_BANK_PRINT, LETTER_FROM_BANK_PRINT_TABLE_AT_SUBTASK])
annotation class LetterFromBankTaskIdsPrintTable

@TaskIds([EPIC_R_RKO_LETTERS, STORY_LETTER_FROM_BANK_UC, AT_STORY_LETTERS, AT_STORY_LFB,
    FEATURE_LETTER_FROM_BANK_DOC_API, FEATURE_LETTER_EXPORT, LETTER_FROM_BANK_EXPORT_AT_SUBTASK])
annotation class LetterFromBankTaskIdsExport
//@formatter:on

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankCreateTest(
    bankUser: User = Users.bankOperator,
    dtoForCreation: () -> LetterFromBankDto = { getLetterFromBankDtoForCreate(creatorBankUser = bankUser) }
) : CreateTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(bankUser),
    preExecution = dtoForCreation
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankWithAttachCreateTest(
    bankUser: User = Users.bankOperator,
    dtoForCreation: () -> LetterFromBankDto
) : CreateTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(bankUser),
    preExecution = dtoForCreation
) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val checks = ApiEntityChecks<LetterFromBankDto>()
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

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankUpdateTest(
    bankUser: User = Users.bankOperator,
    dtoForCreation: () -> LetterFromBankDto = { getLetterFromBankDtoForCreate(creatorBankUser = bankUser) },
    dtoForUpdate: (LetterFromBankDto) -> LetterFromBankDto = { createdDto ->
        LetterFromBankPrepareSteps.getLetterFromBankDtoForUpdate(createdDto)
    },
    preCheckingHandling: (LetterFromBankDto) -> LetterFromBankDto = { it },
    additionalNameDetails: String = ""
) : UpdateTestTemplate<LetterFromBankDto, LetterFromBankDto>(
    steps = LetterFromBankSteps(bankUser),
    preExecution = {
        val createdLetterFromBankClient = createLetterFromBankDto(bankUser, dtoForCreation.invoke())
        dtoForUpdate.invoke(createdLetterFromBankClient)
    },
    preCheckingHandling = preCheckingHandling
) {
    var tempTestName = "'${steps.entityName}'." +
            " CRUD: Обновляем запись от пользователя$additionalNameDetails [${steps.user.userType}]"

    override fun name(): String = tempTestName
}

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankDeleteTest(
    user: User = Users.bankOperator,
    preExecutionDto: () -> LetterFromBankDto = { getLetterFromBankDtoForCreate(creatorBankUser = user) }
) : DeleteDocumentTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    preExecution = { createLetterFromBankDto(user, preExecutionDto.invoke()) },
    deletedStatus = LetterFromBankStatus.DELETED.getUserStatus(user.userType)
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankGetTest(
    bankUser: User = Users.bankOperator,
    letterToGet: (() -> LetterFromBankDto) = {
        createLetterFromBankDto(receiverClientUser = Users.client, creatorBankUser = bankUser)
    }
) : GetTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(bankUser),
    preExecution = letterToGet,
    postExecution = {}
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankGetPageTest(
    bankUser: User = Users.bankOperator
) : GetPageTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(bankUser)
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderSorting
@ComponentFreeFormatDoc
@LowPriority
class LetterFromBankSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>,
    filterFunction: (() -> Filter)? = null
) : SortingTestTemplate<LetterFromBankDto, LetterFromBankSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    filter = filterFunction?.invoke(),
    steps = LetterFromBankSteps(user),
    clazz = LetterFromBankSortingParams::class.java
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankFiltrationTest(
    name: String,
    var user: User,
    preExecution: () -> LetterFromBankDto,
    filterRequestFunction: (LetterFromBankDto?) -> FilterData
) : FiltrationTestTemplate<LetterFromBankDto, LetterFromBankFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = LetterFromBankSteps(user),
    clazz = LetterFromBankFilterParams::class.java,
    preExecution = preExecution
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankFiltrationCountTest(
    user: User,
    filter: Filter
) : FiltrationCountTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    filter = filter
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankCategorySummaryCountTest(
    user: User,
    ignoreCategories: List<String> = emptyList()
) : CategorySummaryCountTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    ignoreCategories = ignoreCategories
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankCategoryListTest(
    user: User,
    expCategories: List<LetterFromBankCategory>
) : CategoryListTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    expCategories = expCategories
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankCategoryTest(
    user: User,
    category: LetterFromBankCategory,
    createLFBInStatus: LetterFromBankStatus? = null,
    sortBy: List<Sort> = LetterFromBankSortingParams.DOCUMENT_NUMBER.desc()
) : CategoryTestTemplate<LetterFromBankDto>(
    steps = LetterFromBankSteps(user),
    category = category,
    sortBy = sortBy,
    mapStatusToFilterDataFunction = { { LetterFromBankFilterParams.STATUS.eq(it.getUserStatus(user.userType)) } },
    preExecution = {
        // TODO Sergeyev [2020.08.21]: подготовка данных для теста использует тестируемый запрос!
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user,
            creatorBankUser = retrieveBankUser(user),
            getPageRequest = { category.getFilterData().toParams(sort = sortBy).toGetPageRequest() },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankInStatus(
                    creatorBankUser = retrieveBankUser(user),
                    receiverClientUser = retrieveClientUser(user),
                    status = createLFBInStatus ?: category.getStatuses(user.userType).random()
                )
            }
        )
    }
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankPaginationTest(
    user: User
) : PaginationTestTemplate<LetterFromBankDto, LetterFromBankSortingParams>(
    steps = LetterFromBankSteps(user),
    sortParam = LetterFromBankSortingParams.DOC_THEME,
    createRecord = {
        if (user.isBank) createLetterFromBankDto(creatorBankUser = user)
        else createDeliveredLetterFromBank(creatorBankUser = retrieveBankUser(user), receiverClientUser = user)
    }
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankOtherTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    params = params,
    testBody = testBody
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
open class LetterFromBankAbstractOtherTest<PR : Any, TR : Any>(
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

@LetterFromBankTaskIdsLifecycleApi
@LetterFromBankFolderLifecycle
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankLifecycleTest(
    user: User,
    statusTransition: String,
    preExecution: (() -> LetterFromBankDto),
    testBody: (LetterFromBankDto?) -> LetterFromBankDto
) : AbstractBeTest<LetterFromBankDto, LetterFromBankDto>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. Жизненный цикл. Проверка перехода $statusTransition [${user.userType}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to user, "'${DocumentNames.LETTER_FROM_BANK}' в исходном статусе" to it!!) },
    testBody = testBody
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderControls
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankControlTest(
    testName: String,
    preExecution: (() -> LetterFromBankDto)?,
    control: LetterFromBankControls,
    steps: LetterFromBankSteps = LetterFromBankSteps(Users.bankOperator)
) : NestedControlTestTemplate<LetterFromBankDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    testPostExecution = {
        if (it.id != null) steps.delete(it.id!!)
    },
    steps = steps
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderControls
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankServerErrorTest(
    testName: String,
    user: User = Users.bankOperator,
    preExecution: (() -> LetterFromBankDto),
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
) : ServerErrorTestTemplate<LetterFromBankDto, LetterFromBankDto>(
    testName = testName,
    user = user,
    preExecution = preExecution,
    steps = LetterFromBankSteps(user),
    expectedHttpCode = expectedHttpCode,
    expectedCode = expectedCode,
    expectedMessage = expectedMessage,
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankAddToFavoritesTest(
    user: User,
    preExecution: () -> UUID
) : AddToFavoritesTestTemplate<LetterFromBankDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = LetterFromBankSteps(user),
    preExecution = preExecution
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankRemoveFromFavoritesTest(
    user: User,
    preExecution: () -> UUID
) : RemoveFromFavoritesTestTemplate<LetterFromBankDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = LetterFromBankSteps(user),
    preExecution = preExecution
)

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderOther
@ComponentFreeFormatDoc
@HighPriority
class LetterFromBankSendTest(
    val bankUser: User,
    val clientUser: User,
) : AbstractTest<LetterFromBankDto, LetterFromBankDto>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. Отправка документа Клиенту. Проверка корректности статуса",
    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) },
) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val docChecks = ApiDocumentChecks<LetterFromBankDto>()
        bankUser.checkIsBankUser()
        val response = LetterFromBankSteps(bankUser).send(preconditionResult!!.id!!)
        val actResult = response.data.getOrException()
        docChecks.checkDocumentStatus(actResult, listOf(DELIVERED.statusBank))

        val clientResult = LetterFromBankSteps(clientUser).getById(actResult.id!!)
        docChecks.checkDocumentStatus(clientResult.data!!, listOf(DELIVERED.statusClient))
    }
}

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderSignatures
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankGetSignaturesTestBank(
    val bankUser: User,
    nameDetails: String,
) : AbstractTest<LetterFromBankDto, List<SignatureDto>>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. $nameDetails [${bankUser.userType}]",
    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) }

) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val expSign = preconditionResult!!.signatures
        expSign!!.forEach {
            it.apply {
                signTool = null
                signToolType = null
                signToolRef = null
                signKind = null
                userName = null
                isOwnSignature = false
            }
        }

        val actList = LetterFromBankSteps(bankUser).getSignatures(preconditionResult.id!!).list
        actList!!.forEach {
            it.apply {
                signTool = null
                signToolType = null
                signToolRef = null
                signKind = null
                userName = null
                isOwnSignature = false
            }
        }
        assertEqualList("Список подписей", expSign, actList)
    }
}

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderSignatures
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankCheckSelfUnSignTest(
    val bankUser: User,
) : AbstractTest<LetterFromBankDto, List<SignatureDto>>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. \"Проверка возможности снятия своей подписи под документами\" [${bankUser.userType}]",
    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) }
) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val steps = LetterFromBankSteps(bankUser)
        val documentId = preconditionResult!!.id!!
        val unSignApplicabilityResp = steps.getSelfUnSignApplicability(documentId)
        assertThat(
            "Пользователь ${bankUser.login} не может снять свою подпись",
            unSignApplicabilityResp.applicable.contains(documentId)
        )
    }
}

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderSignatures
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankSelfUnSignTest(
    val bankUser: User,
) : AbstractTest<LetterFromBankDto, List<SignatureDto>>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. \"Снятие своей подписи под документами\" [${bankUser.userType}]",
    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) }
) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val steps = LetterFromBankSteps(bankUser)
        val documentId = preconditionResult!!.id!!
        val response = steps.batchSelfUnSign(documentId)
        val actResult = response.documentResults.getOrException()
        val docChecks = ApiDocumentChecks<LetterFromBankDto>()
        docChecks.checkDocumentStatus(actResult[0].dto!!, listOf(LetterFromBankStatus.NEW.statusBank))
    }
}

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderSignatures
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankGetSignaturesTestClient(
    val bankUser: User,
    val clientUser: User,
    nameDetails: String,
) : AbstractTest<LetterFromBankDto, List<SignatureDto>>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. $nameDetails [${clientUser.userType}]",
    preExecution = { LetterFromBankPrepareSteps.createSignedLetterFromBank(bankUser) }

) {
    override fun execution(preconditionResult: LetterFromBankDto?) {
        val expSign = preconditionResult!!.signatures
        expSign!!.forEach {
            it.apply {
                signTool = null
                signToolType = null
                signToolRef = null
                signKind = null
                userName = null
                isOwnSignature = false
            }
        }
        val actList = LetterFromBankSteps(clientUser).getSignatures(preconditionResult.id!!).list
        actList!!.forEach {
            it.apply {
                signTool = null
                signToolType = null
                signToolRef = null
                signKind = null
                userName = null
                isOwnSignature = false
            }
        }
        assertEqualList("Список подписей", expSign, actList)
    }
}

@LetterFromBankTaskIdsDocApi
@LetterFromBankFolderOther
@ComponentFreeFormatDoc
@NormalPriority
class LetterFromBankSendTicketTest(
    val bankUser: User,
    val clientUser: User,
    status: LetterFromBankStatus
) : AbstractBeTest<LetterFromBankDto, Unit>(
    name = "'${DocumentNames.LETTER_FROM_BANK}'. Получение квитка об отправке Письма в статусе '$status' [${bankUser.userType}]",
    preExecution = {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = bankUser,
            getPageRequest = { status.asFilterData(bankUser).toPageRequest() },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createLetterFromBankInStatus(receiverClientUser = clientUser, status = status)
            }
        )
    },
    params = { mapOf(PARAM_USER to bankUser, "Доставленное Письмо" to it!!) },
    testBody = { ltbDto ->
        val sentLetter = ltbDto!!
        val actExecTicket = LetterFromBankSteps(bankUser).getSendTicket(sentLetter.id!!)
            .data.getOrException("Ошибка при получении квитка об отправке")

        "Проверить, что фактические данные квитка соответствуют ожидаемым" {
            val letterHistory = LetterFromBankSteps(bankUser).getHistory(sentLetter.id!!, true)
                .list.getOrException("Ошибка при получении истории")
            val sendHistoryEntries = letterHistory
                .filter { entry ->
                    entry.targetStatus in listOf(DELIVERED, DETAILS_ERROR, WRONG_ESIGNATURE)
                        .map { it.getBankOrClientStatus() }
                }
            val currentEntry = sendHistoryEntries
                .firstOrNull { it.targetStatus == status.getBankOrClientStatus() }
            val sendUserName = currentEntry
                ?.let {
                    UaaUserData.get(fromCache = true) { it.id == currentEntry.userId }
                        .first().getUserDetails().getFio()
                }
                ?: ""

            val sendMessage = when (status) {
                DELIVERED -> LetterFromBankLifecycleConstants.RECEIVE_TICKET_SUCCESS_MSG
                DETAILS_ERROR -> LetterFromBankLifecycleConstants.RECEIVE_TICKET_FAILURE_DETAILS_MSG
                WRONG_ESIGNATURE -> LetterFromBankLifecycleConstants.RECEIVE_TICKET_FAILURE_ESIGN_MSG
                else -> throw RuntimeException("Unexpected sent status: $status")
            }

            assertThat("Некорректный id документа", actExecTicket.docId, equalTo(sentLetter.id))
            assertThat("Некорректный customerId документа", actExecTicket.customerId, equalTo(sentLetter.customerId))
            assertThat("Некорректный customerName документа", actExecTicket.customerName, equalTo(sentLetter.customerName))
            assertThat("Некорректный branchId документа", actExecTicket.branchId, equalTo(sentLetter.branchId))
            assertThat("Некорректный branchName документа", actExecTicket.branchName, equalTo(sentLetter.branchName))
            assertThat("Некорректный documentDate документа", actExecTicket.documentDate, equalTo(sentLetter.documentDate))
            assertThat("Некорректный documentNumber документа", actExecTicket.documentNumber, equalTo(sentLetter.documentNumber))
            assertThat("Некорректный sendUserName документа", actExecTicket.sendUserName, equalTo(sendUserName))
            assertThat("Некорректный sendMessage документа", actExecTicket.sendMessage, equalTo(sendMessage))
            assertThat("Некорректный status документа", actExecTicket.status, equalTo(status.getUserStatus(bankUser.userType)))
        }
    }
)