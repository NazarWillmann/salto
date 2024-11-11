package ooo.jtc.api.news.mailgroup

import ooo.jtc.api.common.templates.entity.AddToFavoritesTestTemplate
import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.RemoveFromFavoritesTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.news.MailGroupTaskIdsControls
import ooo.jtc.api.news.MailGroupTaskIdsDocApi
import ooo.jtc.api.news.mailgroup.MailGroupPrepareSteps.getGeneralMailGroupDtoForCreate
import ooo.jtc.core.tm4j.ComponentNews
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames.MAIL_GROUP
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.news.mailgroup.MailGroupDto
import ooo.jtc.scripts.soft
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.news.mailgroup.MailGroupControls
import ooo.jtc.testdata.news.mailgroup.MailGroupFilterParams
import ooo.jtc.testdata.news.mailgroup.MailGroupSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "$MAIL_GROUP (mailgroup)"

@Folder("$baseFolder/${SubFolder.CRUD}")          annotation class MailGroupFolderCrud
@Folder("$baseFolder/${SubFolder.CONTROLS}")      annotation class MailGroupFolderControls
@Folder("$baseFolder/${SubFolder.FILTRATION}")    annotation class MailGroupFolderFiltration
@Folder("$baseFolder/${SubFolder.SORTING}")       annotation class MailGroupFolderSorting

//@formatter:on

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupCreateTest(
    bankUser: User,
    dtoForCreation: () -> MailGroupDto = { getGeneralMailGroupDtoForCreate(creatorBankUser = bankUser) }
) : CreateTestTemplate<MailGroupDto>(
    steps = MailGroupSteps(bankUser),
    preExecution = dtoForCreation,
    expValidationResult = ControlCheckResult.VALID
)

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupGetTest(
    user: User
) : GetTestTemplate<MailGroupDto>(
    steps = MailGroupSteps(user),
    preExecution = { MailGroupPrepareSteps.createMailGroup(creatorBankUser = user) }
)

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupAddToFavoritesTest(
    user: User,
    steps: MailGroupSteps = MailGroupSteps(user)
) : AddToFavoritesTestTemplate<MailGroupDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = steps,
    preExecution = { MailGroupPrepareSteps.createMailGroup(creatorBankUser = user).id!!},
    postExecution = { createdMailGroupId -> steps.delete(createdMailGroupId) }
)

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupRemoveFromFavoritesTest(
    user: User,
    steps: MailGroupSteps = MailGroupSteps(user)
) : RemoveFromFavoritesTestTemplate<MailGroupDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = steps,
    preExecution = {
        val newMailGroup = MailGroupPrepareSteps.createMailGroup(creatorBankUser = user)
        val favoriteMailGroup = steps.addToFavorites(newMailGroup.id!!)
            .data.getOrException("Ошибка при добавлении группы рассылки в избранное")
        favoriteMailGroup.id!!
    },
    postExecution = { createdMailGroupId -> steps.delete(createdMailGroupId) }
)

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupGetPageTest(
    user: User = Users.client,
    private val mailGroupSteps: MailGroupSteps = MailGroupSteps(user)
) : GetPageTestTemplate<MailGroupDto>(
    steps = mailGroupSteps,
    preExecution = {
        MailGroupPrepareSteps.getOrCreateDifferentMailGroupDtoList(
            searchingUser = user,
            createDocFunc = { MailGroupPrepareSteps.createMailGroup(creatorBankUser = user) }
        )
    },
    postExecution = { list -> list.forEach { it.soft { mailGroupSteps.delete(it.id!!) } } }
)

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupUpdateTest(
    user: User,
    dtoForCreation: () -> MailGroupDto = { getGeneralMailGroupDtoForCreate(creatorBankUser = user) },
    dtoForUpdate: (MailGroupDto) -> MailGroupDto = { createdDto ->
        MailGroupPrepareSteps.getMailGroupDtoForUpdate(createdDto)
    }
) : UpdateTestTemplate<MailGroupDto, MailGroupDto>(
    steps = MailGroupSteps(user),
    preExecution = {
        val createdMailGroupClient = MailGroupPrepareSteps.createMailGroup(creatorBankUser = user, dtoForCreate = dtoForCreation.invoke())
        dtoForUpdate.invoke(createdMailGroupClient)
    },
    preCheckingHandling = { mgDto -> mgDto.apply { customers?.forEach { it.id = null } } }
) {
    override fun name(): String = "'${steps.entityName}'. CRUD: Обновляем запись от пользователя [${steps.user.userType}]"
}

@MailGroupTaskIdsDocApi
@MailGroupFolderCrud
@ComponentNews
@HighPriority
class MailGroupDeleteTest(
    user: User,
    preExecutionDto: () -> MailGroupDto = { getGeneralMailGroupDtoForCreate(creatorBankUser = user) }
) : DeleteTestTemplate<MailGroupDto>(
    preExecution = { MailGroupPrepareSteps.createMailGroup(creatorBankUser = user, dtoForCreate = preExecutionDto.invoke()) },
    steps = MailGroupSteps(user),
    preCheckingHandling = { it.apply { customers = emptyList() } }
)

@MailGroupTaskIdsControls
@MailGroupFolderControls
@ComponentNews
@HighPriority
class MailGroupControlTest(
    testName: String,
    preExecution: (() -> MailGroupDto)?,
    postExecution: ((MailGroupDto) -> Unit)? = null,
    control: MailGroupControls,
    steps: MailGroupSteps = MailGroupSteps(Users.bankOperator)
) : NestedControlTestTemplate<MailGroupDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    postExecution = postExecution,
    steps = steps
)

@MailGroupTaskIdsDocApi
@MailGroupFolderSorting
@ComponentNews
@LowPriority
class MailGroupSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<MailGroupDto, MailGroupSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = MailGroupSteps(user),
    clazz = MailGroupSortingParams::class.java
)

@MailGroupTaskIdsDocApi
@MailGroupFolderFiltration
@ComponentNews
@NormalPriority
class MailGroupFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> MailGroupDto)?,
    filterRequestFunction: (MailGroupDto?) -> FilterData
) : FiltrationTestTemplate<MailGroupDto, MailGroupFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = MailGroupSteps(user),
    clazz = MailGroupFilterParams::class.java,
    preExecution = preExecution
)