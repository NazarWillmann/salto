package ooo.jtc.api.news.publication

import ooo.jtc.api.common.templates.entity.CategoryListTestTemplate
import ooo.jtc.api.common.templates.entity.CategorySummaryCountTestTemplate
import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteDocumentTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.ServerErrorTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.news.PublicationTaskIdsControls
import ooo.jtc.api.news.PublicationTaskIdsDocApi
import ooo.jtc.api.news.publication.PublicationPrepareSteps.createPublicationDto
import ooo.jtc.api.news.publication.PublicationPrepareSteps.getGeneralPublicationDtoForCreate
import ooo.jtc.api.news.publication.PublicationPrepareSteps.getPublicationDtoForUpdate
import ooo.jtc.core.tm4j.ComponentNews
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.generic.DocumentNames.PUBLICATION
import ooo.jtc.news.PublicationCategory
import ooo.jtc.news.PublicationStatus.DELETED
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.news.publication.PublicationControls
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "$PUBLICATION (publication)"

@Folder("$baseFolder/${SubFolder.CRUD}")          annotation class PublicationFolderCrud
@Folder("$baseFolder/${SubFolder.FILTRATION}")    annotation class PublicationFolderFiltration
@Folder("$baseFolder/${SubFolder.OTHER}")         annotation class PublicationFolderOther
@Folder("$baseFolder/${SubFolder.CONTROLS}")      annotation class PublicationFolderControls
@Folder("$baseFolder/${SubFolder.LIFECYCLE}")     annotation class PublicationFolderLifecycle
//@formatter:on

@PublicationTaskIdsDocApi
@PublicationFolderCrud
@ComponentNews
@HighPriority
class PublicationCreateTest(
    bankUser: User,
    val nameDetails: String = "",
    dtoForCreation: () -> PublicationDto = { getGeneralPublicationDtoForCreate(relatedBankUser = bankUser) }
) : CreateTestTemplate<PublicationDto>(
    steps = PublicationSteps(bankUser),
    preExecution = dtoForCreation
) {
    override fun name(): String = "'${steps.entityName}'. CRUD: Создаем запись от пользователя$nameDetails [${steps.user.userType}]"
}

@PublicationTaskIdsDocApi
@PublicationFolderCrud
@ComponentNews
@HighPriority
class PublicationGetTest(
    user: User
) : GetTestTemplate<PublicationDto>(
    steps = PublicationSteps(user),
    preExecution = { createPublicationDto(creatorBankUser = user) }
)

@PublicationTaskIdsDocApi
@PublicationFolderCrud
@ComponentNews
@HighPriority
class PublicationGetPageTest(
    user: User = Users.client,
    private val publSteps: PublicationSteps = PublicationSteps(user)
) : GetPageTestTemplate<PublicationDto>(
    steps = publSteps,
    preExecution = {
        PublicationPrepareSteps.getOrCreateDifferentPublicationDtoList(
            searchingUser = user,
            createDocFunc = { createPublicationDto(creatorBankUser = user) }
        )
    },
    postExecution = { list -> list.forEach { it.soft { publSteps.delete(it.id!!) } } }
)

@PublicationTaskIdsDocApi
@PublicationFolderCrud
@ComponentNews
@HighPriority
class PublicationUpdateTest(
    user: User,
    dtoForCreation: () -> PublicationDto = { getGeneralPublicationDtoForCreate(relatedBankUser = user) },
    dtoForUpdate: (PublicationDto) -> PublicationDto = { getPublicationDtoForUpdate(it) },
    preCheckingHandling: (PublicationDto) -> PublicationDto = { it },
    val nameDetails: String = ""
) : UpdateTestTemplate<PublicationDto, PublicationDto>(
    steps = PublicationSteps(user),
    preExecution = {
        val createdPublicationClient = createPublicationDto(creatorBankUser = user, dtoForCreate = dtoForCreation.invoke())
        dtoForUpdate.invoke(createdPublicationClient)
    },
    preCheckingHandling = preCheckingHandling
) {
    override fun name(): String = "'${steps.entityName}'. CRUD: Обновляем запись от пользователя$nameDetails [${steps.user.userType}]"
}

@PublicationTaskIdsDocApi
@PublicationFolderCrud
@ComponentNews
@HighPriority
class PublicationDeleteTest(
    user: User,
    preExecutionDto: () -> PublicationDto = { getGeneralPublicationDtoForCreate(relatedBankUser = user) }
) : DeleteDocumentTestTemplate<PublicationDto>(
    steps = PublicationSteps(user),
    preExecution = { createPublicationDto(creatorBankUser = user, dtoForCreate = preExecutionDto.invoke()) },
    deletedStatus = DELETED.getUserStatus(user.userType)
)

//TODO Sergeyev [2020.12.04]: update TMS links
@PublicationTaskIdsDocApi
@PublicationFolderFiltration
@ComponentNews
@NormalPriority
class PublicationCategorySummaryCountTest(
    user: User,
    ignoreCategories: List<String> = emptyList()
) : CategorySummaryCountTestTemplate<PublicationDto>(
    steps = PublicationSteps(user),
    ignoreCategories = ignoreCategories
)

//TODO Sergeyev [2020.12.04]: update TMS links
@PublicationTaskIdsDocApi
@PublicationFolderFiltration
@ComponentNews
@NormalPriority
class PublicationCategoryListTest(
    user: User,
    expCategories: List<PublicationCategory>
) : CategoryListTestTemplate<PublicationDto>(
    steps = PublicationSteps(user),
    expCategories = expCategories
)

@PublicationTaskIdsControls
@PublicationFolderControls
@ComponentNews
@HighPriority
class PublicationControlTest(
    testName: String,
    preExecution: (() -> PublicationDto)?,
    postExecution: ((PublicationDto) -> Unit)? = null,
    control: PublicationControls,
    steps: PublicationSteps = PublicationSteps(Users.bankOperator)
) : NestedControlTestTemplate<PublicationDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = steps
)

@PublicationTaskIdsControls
@PublicationFolderControls
@ComponentNews
@HighPriority
class PublicationServerErrorTest(
    testName: String,
    user: User = Users.bankOperator,
    preExecution: (() -> PublicationDto),
    expectedHttpCode: Int = 500,
    expectedCode: Int,
    expectedMessage: String,
) : ServerErrorTestTemplate<PublicationDto, PublicationDto>(
    testName = testName,
    user = user,
    preExecution = preExecution,
    steps = PublicationSteps(user),
    expectedHttpCode = expectedHttpCode,
    expectedCode = expectedCode,
    expectedMessage = expectedMessage
)