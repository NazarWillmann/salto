package ooo.jtc.api.dictionaries.branch

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps.getBranchDtoForCreate
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps.getBranchDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.branch.BranchDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.interfaces.getOrException
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchFilterParams
import ooo.jtc.testdata.dictionaries.branch.BranchSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BRANCH}\" (branch)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BranchFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BranchFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BranchFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class BranchFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class BranchFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1133"]) annotation class BranchTaskIdsCommon
//@formatter:on

@BranchTaskIdsCommon
@BranchFolderCrud
@ComponentDictionary
@HighPriority
class BranchCreateTest(superUser: User = Users.superUser) :
    CreateTestTemplate<BranchDto>(
        preExecution = { getBranchDtoForCreate() },
        steps = BranchSteps(superUser)
    )

@BranchTaskIdsCommon
@BranchFolderCrud
@ComponentDictionary
@HighPriority
class BranchGetTest(user: User = Users.bankAdmin, preExecution: (() -> BranchDto)?) :
    GetTestTemplate<BranchDto>(
        preExecution = preExecution,
        steps = BranchSteps(user)
    )

@BranchTaskIdsCommon
@BranchFolderCrud
@ComponentDictionary
@HighPriority
class BranchGetPageTest(user: User = Users.bankAdmin) :
    GetPageTestTemplate<BranchDto>(
        steps = BranchSteps(user)
    )

@BranchTaskIdsCommon
@BranchFolderCrud
@ComponentDictionary
@HighPriority
class BranchDeleteTest(superUser: User = Users.superUser) :
    DeleteTestTemplate<BranchDto>(
        preExecution = { BranchSteps(superUser).create(getBranchDtoForCreate()).data.getOrException() },
        preCheckingHandling = { branchDto ->
            branchDto.apply {
                extIds = emptyList()
                phoneSupports = emptyList()
            }
        },
        steps = BranchSteps(superUser)
    )

@BranchTaskIdsCommon
@BranchFolderCrud
@ComponentDictionary
@HighPriority
class BranchUpdateTest(superUser: User = Users.superUser) :
    UpdateTestTemplate<BranchDto, BranchDto>(
        preExecution = {
            val createdDto = BranchSteps(superUser).create(getBranchDtoForCreate()).data.getOrException()
            getBranchDtoForUpdate(createdDto)
        },
        steps = BranchSteps(superUser)
    )

@BranchTaskIdsCommon
@BranchFolderSorting
@ComponentDictionary
@LowPriority
class BranchSortingTest(
    user: User = Users.bankAdmin,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<BranchDto, BranchSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BranchSteps(user),
    clazz = BranchSortingParams::class.java
)

@BranchTaskIdsCommon
@BranchFolderFiltration
@ComponentDictionary
@NormalPriority
class BranchFiltrationTest(
    name: String,
    user: User = Users.bankAdmin,
    preExecution: (() -> BranchDto)?,
    filterRequestFunction: (BranchDto?) -> FilterData
) : FiltrationTestTemplate<BranchDto, BranchFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BranchSteps(user),
    clazz = BranchFilterParams::class.java,
    preExecution = preExecution
)