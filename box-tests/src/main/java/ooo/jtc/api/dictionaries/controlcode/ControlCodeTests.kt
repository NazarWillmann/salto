package ooo.jtc.api.dictionaries.controlcode

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.controlcode.ControlCodePrepareSteps.getControlCodeDtoForCreate
import ooo.jtc.api.dictionaries.controlcode.ControlCodePrepareSteps.getControlCodeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.controlcode.ControlCodeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeData
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeFilterParams
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CONTROL_CODE}\" (controlCode)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ControlCodeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ControlCodeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ControlCodeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class ControlCodeFolderControls

@TaskIds([Tm4jEpic.EPIC_R_RKO_DICTIONARY,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1138"]) annotation class ControlCodeTaskIdsCommon
//@formatter:on

@ControlCodeTaskIdsCommon
@ControlCodeFolderCrud
@ComponentDictionary
@HighPriority
class ControlCodeCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<ControlCodeDto>(
        preExecution = { getControlCodeDtoForCreate() },
        steps = ControlCodeSteps(user)
    )

@ControlCodeTaskIdsCommon
@ControlCodeFolderCrud
@ComponentDictionary
@HighPriority
class ControlCodeGetTest(user: User) :
    GetTestTemplate<ControlCodeDto>(
        preExecution = { ControlCodeData.randomOrException().toDto() },
        steps = ControlCodeSteps(user)
    )

@ControlCodeTaskIdsCommon
@ControlCodeFolderCrud
@ComponentDictionary
@HighPriority
class ControlCodeGetPageTest(user: User) :
    GetPageTestTemplate<ControlCodeDto>(
        steps = ControlCodeSteps(user)
    )

@ControlCodeTaskIdsCommon
@ControlCodeFolderCrud
@ComponentDictionary
@HighPriority
class ControlCodeDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<ControlCodeDto>(
        preExecution = {
            val createdResponse = ControlCodeSteps(user).create(getControlCodeDtoForCreate())
            createdResponse.data!!
        },
        steps = ControlCodeSteps(user)
    )

@ControlCodeTaskIdsCommon
@ControlCodeFolderCrud
@ComponentDictionary
@HighPriority
class ControlCodeUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<ControlCodeDto, ControlCodeDto>(
        preExecution = {
            val createdDto = ControlCodeSteps(user).create(getControlCodeDtoForCreate()).data!!
            getControlCodeDtoForUpdate(createdDto)
        },
        steps = ControlCodeSteps(user)
    )


@ControlCodeTaskIdsCommon
@ControlCodeFolderSorting
@ComponentDictionary
@LowPriority
class ControlCodeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<ControlCodeDto, ControlCodeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ControlCodeSteps(user),
    clazz = ControlCodeSortingParams::class.java
)

@ControlCodeTaskIdsCommon
@ControlCodeFolderFiltration
@ComponentDictionary
@NormalPriority
class ControlCodeFiltrationTests(
    name: String,
    user: User,
    preExecution: (() -> ControlCodeDto)?,
    filterRequestFunction: (ControlCodeDto?) -> FilterData
) : FiltrationTestTemplate<ControlCodeDto, ControlCodeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ControlCodeSteps(user),
    clazz = ControlCodeFilterParams::class.java,
    preExecution = preExecution
)