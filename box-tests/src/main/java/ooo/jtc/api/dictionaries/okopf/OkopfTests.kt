package ooo.jtc.api.dictionaries.okopf

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.okopf.OkopfPrepareSteps.getOkopfDtoForCreate
import ooo.jtc.api.dictionaries.okopf.OkopfPrepareSteps.getOkopfDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.okopf.OkopfDto
import ooo.jtc.generic.DictionaryNames.OKOPF
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.okopf.OkopfData
import ooo.jtc.testdata.dictionaries.okopf.OkopfFilterParams
import ooo.jtc.testdata.dictionaries.okopf.OkopfSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY} \"$OKOPF\" (okopf)"
@Folder("$baseFolder/${SubFolder.CRUD}")            annotation class OkopfFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")         annotation class OkopfFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")      annotation class OkopfFolderFiltration

private const val JTCSALTO_3128 = "JTCSALTO-3128"   // [JTCSALTO-3125] -> АТ. Справочники. Написание базового набора тестов для okopf

@TaskIds([
    Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES,
    JTCSALTO_3128
])    annotation class OkopfTaskIdsAll
//@formatter:on

@OkopfTaskIdsAll
@OkopfFolderCrud
@ComponentDictionary
@HighPriority
class OkopfCreateTest(user: User = Users.bankAdmin) :
    CreateTestTemplate<OkopfDto>(
        preExecution = { getOkopfDtoForCreate() },
        steps = OkopfSteps(user)
    )

@OkopfTaskIdsAll
@OkopfFolderCrud
@ComponentDictionary
@HighPriority
class OkopfGetTest(user: User) :
    GetTestTemplate<OkopfDto>(
        preExecution = { OkopfData.randomOrException().toDto() },
        steps = OkopfSteps(user)
    )

@OkopfTaskIdsAll
@OkopfFolderCrud
@ComponentDictionary
@HighPriority
class OkopfGetPageTest(user: User) :
    GetPageTestTemplate<OkopfDto>(
        steps = OkopfSteps(user)
    )

@OkopfTaskIdsAll
@OkopfFolderCrud
@ComponentDictionary
@HighPriority
class OkopfDeleteTest(user: User = Users.bankAdmin) :
    DeleteTestTemplate<OkopfDto>(
        preExecution = {
            val createdResponse = OkopfSteps(user).create(getOkopfDtoForCreate())
            createdResponse.data!!
        },
        steps = OkopfSteps(user)
    )

@OkopfTaskIdsAll
@OkopfFolderCrud
@ComponentDictionary
@HighPriority
class OkopfUpdateTest(user: User = Users.bankAdmin) :
    UpdateTestTemplate<OkopfDto, OkopfDto>(
        preExecution = {
            val createdDto = OkopfSteps(user).create(getOkopfDtoForCreate()).data!!
            getOkopfDtoForUpdate(createdDto)
        },
        steps = OkopfSteps(user)
    )

@OkopfTaskIdsAll
@OkopfFolderSorting
@ComponentDictionary
@LowPriority
class OkopfSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<OkopfDto, OkopfSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = OkopfSteps(user),
    clazz = OkopfSortingParams::class.java
)

@OkopfTaskIdsAll
@OkopfFolderFiltration
@ComponentDictionary
@NormalPriority
class OkopfFilterTests(
    name: String,
    user: User,
    preExecution: (() -> OkopfDto)?,
    filterRequestFunction: (OkopfDto?) -> FilterData
) : FiltrationTestTemplate<OkopfDto, OkopfFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = OkopfSteps(user),
    clazz = OkopfFilterParams::class.java,
    preExecution = preExecution
)