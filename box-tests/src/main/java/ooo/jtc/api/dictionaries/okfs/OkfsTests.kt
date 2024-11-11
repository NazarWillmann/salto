package ooo.jtc.api.dictionaries.okfs

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.okfs.OkfsPrepareSteps.getOkfsDtoForCreate
import ooo.jtc.api.dictionaries.okfs.OkfsPrepareSteps.getOkfsDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.okfs.OkfsDto
import ooo.jtc.generic.DictionaryNames.OKFS
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.okfs.OkfsData
import ooo.jtc.testdata.dictionaries.okfs.OkfsFilterParams
import ooo.jtc.testdata.dictionaries.okfs.OkfsSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY} \"$OKFS\" (okfs)"
@Folder("$baseFolder/${SubFolder.CRUD}") annotation class OkfsFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}") annotation class OkfsFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class OkfsFolderFiltration

private const val JTCSALTO_3127 = "JTCSALTO-3127"   // [JTCSALTO-3125] -> АТ. Справочники. Написание базового набора тестов для okfs

@TaskIds([
    Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES,
    JTCSALTO_3127
])    annotation class OkfsTaskIdsAll
//@formatter:on

@OkfsTaskIdsAll
@OkfsFolderCrud
@ComponentDictionary
@HighPriority
class OkfsCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<OkfsDto>(
        preExecution = { getOkfsDtoForCreate() },
        steps = OkfsSteps(user)
    )

@OkfsTaskIdsAll
@OkfsFolderCrud
@ComponentDictionary
@HighPriority
class OkfsGetTest(user: User) :
    GetTestTemplate<OkfsDto>(
        preExecution = { OkfsData.randomOrException().toDto() },
        steps = OkfsSteps(user)
    )

@OkfsTaskIdsAll
@OkfsFolderCrud
@ComponentDictionary
@HighPriority
class OkfsGetPageTest(user: User) :
    GetPageTestTemplate<OkfsDto>(
        steps = OkfsSteps(user)
    )

@OkfsTaskIdsAll
@OkfsFolderCrud
@ComponentDictionary
@HighPriority
class OkfsDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<OkfsDto>(
        preExecution = {
            val createdResponse = OkfsSteps(user).create(getOkfsDtoForCreate())
            createdResponse.data!!
        },
        steps = OkfsSteps(user)
    )

@OkfsTaskIdsAll
@OkfsFolderCrud
@ComponentDictionary
@HighPriority
class OkfsUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<OkfsDto, OkfsDto>(
        preExecution = {
            val createdDto = OkfsSteps(user).create(getOkfsDtoForCreate()).data!!
            getOkfsDtoForUpdate(createdDto)
        },
        steps = OkfsSteps(user)
    )

@OkfsTaskIdsAll
@OkfsFolderSorting
@ComponentDictionary
@LowPriority
class OkfsSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<OkfsDto, OkfsSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = OkfsSteps(user),
    clazz = OkfsSortingParams::class.java
)

@OkfsTaskIdsAll
@OkfsFolderFiltration
@ComponentDictionary
@NormalPriority
class OkfsFilterTests(
    name: String,
    user: User,
    preExecution: (() -> OkfsDto)?,
    filterRequestFunction: (OkfsDto?) -> FilterData
) : FiltrationTestTemplate<OkfsDto, OkfsFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = OkfsSteps(user),
    clazz = OkfsFilterParams::class.java,
    preExecution = preExecution
)