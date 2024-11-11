package ooo.jtc.api.dictionaries.codevo

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.codevo.CodeVoPrepareSteps.getCodeVoDtoForCreate
import ooo.jtc.api.dictionaries.codevo.CodeVoPrepareSteps.getCodeVoDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.FolderPrefix.DICTIONARY
import ooo.jtc.core.tm4j.SubFolder.CONTROLS
import ooo.jtc.core.tm4j.SubFolder.CRUD
import ooo.jtc.core.tm4j.SubFolder.FILTRATION
import ooo.jtc.core.tm4j.SubFolder.SORTING
import ooo.jtc.dictionaries.codevo.CodeVoDto
import ooo.jtc.generic.DictionaryNames.CODE_VO
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.codevo.CodeVoControls
import ooo.jtc.testdata.dictionaries.codevo.CodeVoData
import ooo.jtc.testdata.dictionaries.codevo.CodeVoFilterParams
import ooo.jtc.testdata.dictionaries.codevo.CodeVoSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "$DICTIONARY \"$CODE_VO\" (codeVo)"
@Folder("$baseFolder/$CRUD")            annotation class CodeVoFolderCrud
@Folder("$baseFolder/$SORTING")         annotation class CodeVoFolderSorting
@Folder("$baseFolder/$FILTRATION")      annotation class CodeVoFolderFiltration
@Folder("$baseFolder/$CONTROLS")        annotation class CodeVoFolderControls

private const val STORY_CONTROLS = "JTCSALTO-2193"
private const val AT_CONTROLS = "JTCSALTO-2197"
@TaskIds(["JTCSALTO-497",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1122"]) annotation class CodeVoTaskIdsAll

@CodeVoTaskIdsAll
@TaskIds([STORY_CONTROLS, AT_CONTROLS])
annotation class CodeVoTaskIdsControls
//@formatter:on

@CodeVoTaskIdsAll
@CodeVoFolderCrud
@ComponentDictionary
@HighPriority
class CodeVoCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<CodeVoDto>(
        preExecution = { getCodeVoDtoForCreate() },
        steps = CodeVoSteps(user)
    )

@CodeVoTaskIdsAll
@CodeVoFolderCrud
@ComponentDictionary
@HighPriority
class CodeVoGetTest(user: User) :
    GetTestTemplate<CodeVoDto>(
        preExecution = { CodeVoData.randomOrException().toDto() },
        steps = CodeVoSteps(user)
    )

@CodeVoTaskIdsAll
@CodeVoFolderCrud
@ComponentDictionary
@HighPriority
class CodeVoGetPageTest(user: User) :
    GetPageTestTemplate<CodeVoDto>(
        steps = CodeVoSteps(user)
    )

@CodeVoTaskIdsAll
@CodeVoFolderCrud
@ComponentDictionary
@HighPriority
class CodeVoDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<CodeVoDto>(
        preExecution = {
            val createdResponse = CodeVoSteps(user).create(getCodeVoDtoForCreate())
            createdResponse.data!!
        },
        steps = CodeVoSteps(user)
    )

@CodeVoTaskIdsAll
@CodeVoFolderCrud
@ComponentDictionary
@HighPriority
class CodeVoUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<CodeVoDto, CodeVoDto>(
        preExecution = {
            val createdDto = CodeVoSteps(user).create(getCodeVoDtoForCreate()).data!!
            getCodeVoDtoForUpdate(createdDto)
        },
        steps = CodeVoSteps(user)
    )

@CodeVoTaskIdsAll
@CodeVoFolderSorting
@ComponentDictionary
@LowPriority
class CodeVoSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<CodeVoDto, CodeVoSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = CodeVoSteps(user),
    clazz = CodeVoSortingParams::class.java
)

@CodeVoTaskIdsAll
@CodeVoFolderFiltration
@ComponentDictionary
@NormalPriority
class CodeVoFilterTests(
    name: String,
    user: User,
    preExecution: (() -> CodeVoDto)?,
    filterRequestFunction: (CodeVoDto?) -> FilterData
) : FiltrationTestTemplate<CodeVoDto, CodeVoFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = CodeVoSteps(user),
    clazz = CodeVoFilterParams::class.java,
    preExecution = preExecution
)

@CodeVoTaskIdsControls
@CodeVoFolderControls
@ComponentDictionary
@NormalPriority
class CodeVoControlTest(
    testName: String,
    user: User = bankAdmin,
    preExecution: (() -> CodeVoDto)?,
    control: CodeVoControls
) : ControlTestTemplate<CodeVoDto>(
    testName = testName,
    control = control,
    preExecution = preExecution,
    steps = CodeVoSteps(user)
)