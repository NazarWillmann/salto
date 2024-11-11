package ooo.jtc.api.dictionaries.kbk

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.kbk.KbkPrepareSteps.getKbkDtoForCreate
import ooo.jtc.api.dictionaries.kbk.KbkPrepareSteps.getKbkDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.FolderPrefix.DICTIONARY
import ooo.jtc.core.tm4j.SubFolder.CONTROLS
import ooo.jtc.core.tm4j.SubFolder.CRUD
import ooo.jtc.core.tm4j.SubFolder.FILTRATION
import ooo.jtc.core.tm4j.SubFolder.SORTING
import ooo.jtc.dictionaries.kbk.KbkDto
import ooo.jtc.generic.DictionaryNames.KBK
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.kbk.KbkControls
import ooo.jtc.testdata.dictionaries.kbk.KbkData
import ooo.jtc.testdata.dictionaries.kbk.KbkFilterParams
import ooo.jtc.testdata.dictionaries.kbk.KbkSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="$DICTIONARY \"$KBK\" (kbk)"
@Folder("$baseFolder/$CRUD")        annotation class KbkFolderCrud
@Folder("$baseFolder/$SORTING")     annotation class KbkFolderSorting
@Folder("$baseFolder/$FILTRATION")  annotation class KbkFolderFiltration
@Folder("$baseFolder/$CONTROLS")    annotation class KbkFolderControls

private const val STORY_KBK = "JTCSALTO-500"
private const val STORY_KBK_CONTROLS = "JTCSALTO-2176"
private const val AT_KBK_CONTROLS = "JTCSALTO-2180"
@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,STORY_KBK,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1145"]) annotation class KbkTaskIdsCommon

@KbkTaskIdsCommon
@TaskIds([STORY_KBK_CONTROLS, AT_KBK_CONTROLS]) annotation class KbkTaskIdsControls
//@formatter:on

@KbkTaskIdsCommon
@KbkFolderCrud
@ComponentDictionary
@HighPriority
class KbkCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<KbkDto>(
        preExecution = { getKbkDtoForCreate() },
        steps = KbkSteps(user)
    )

@KbkTaskIdsCommon
@KbkFolderCrud
@ComponentDictionary
@HighPriority
class KbkGetTest(user: User) :
    GetTestTemplate<KbkDto>(
        preExecution = { KbkData.randomOrException().toDto() },
        steps = KbkSteps(user)
    )

@KbkTaskIdsCommon
@KbkFolderCrud
@ComponentDictionary
@HighPriority
class KbkGetPageTest(user: User) :
    GetPageTestTemplate<KbkDto>(
        steps = KbkSteps(user)
    )

@KbkTaskIdsCommon
@KbkFolderCrud
@ComponentDictionary
@HighPriority
class KbkDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<KbkDto>(
        preExecution = {
            val createdResponse = KbkSteps(user).create(getKbkDtoForCreate())
            createdResponse.data!!
        },
        steps = KbkSteps(user)
    )

@KbkTaskIdsCommon
@KbkFolderCrud
@ComponentDictionary
@HighPriority
class KbkUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<KbkDto, KbkDto>(
        preExecution = {
            val createdDto = KbkSteps(user).create(getKbkDtoForCreate()).data!!
            getKbkDtoForUpdate(createdDto)
        },
        steps = KbkSteps(user)
    )

@KbkTaskIdsCommon
@KbkFolderSorting
@ComponentDictionary
@LowPriority
class KbkSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<KbkDto, KbkSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = KbkSteps(user),
    clazz = KbkSortingParams::class.java
)

@KbkTaskIdsCommon
@KbkFolderFiltration
@ComponentDictionary
@NormalPriority
class KbkFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> KbkDto)?,
    filterRequestFunction: (KbkDto?) -> FilterData
) : FiltrationTestTemplate<KbkDto, KbkFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = KbkSteps(user),
    clazz = KbkFilterParams::class.java,
    preExecution = preExecution
)

@KbkTaskIdsControls
@KbkFolderControls
@ComponentDictionary
@NormalPriority
class KbkControlTest(
    testName: String,
    user: User = bankAdmin,
    preExecution: (() -> KbkDto)?,
    control: KbkControls
) : ControlTestTemplate<KbkDto>(
    testName = testName,
    control = control,
    preExecution = preExecution,
    steps = KbkSteps(user)
)