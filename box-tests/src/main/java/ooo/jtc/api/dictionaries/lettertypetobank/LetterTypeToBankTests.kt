package ooo.jtc.api.dictionaries.lettertypetobank

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankPrepareSteps.getLetterTypeToBankDtoForCreate
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankPrepareSteps.getLetterTypeToBankDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.ComponentFreeFormatDoc
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBankDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankControls
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankData
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankFilterParams
import ooo.jtc.testdata.dictionaries.lettertypetobank.LetterTypeToBankSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.LETTER_TO_BANK} (letterToBank)/Справочники/${DictionaryNames.LETTER_TYPE_TO_BANK} (letterTypeToBank)"

@Folder("$baseFolder/${SubFolder.CRUD}")          annotation class LetterTypeToBankFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")       annotation class LetterTypeToBankFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")    annotation class LetterTypeToBankFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")      annotation class LetterTypeToBankFolderControls

private const val STORY_LETTERS_COMMON = "JTCSALTO-1092"
private const val STORY_LETTERS_DICTIONARY = "JTCSALTO-1093"
const val FEATURE_LETTER_TYPE_TO_BANK_API = "JTCSALTO-1127"

@TaskIds([Tm4jEpic.EPIC_R_RKO_LETTERS, STORY_LETTERS_COMMON,STORY_LETTERS_DICTIONARY, FEATURE_LETTER_TYPE_TO_BANK_API])
annotation class LetterTypeToBankTaskIdsDocApi
//@formatter:on

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeToBankCreateTest(user: User = Users.bankOperator) :
    CreateTestTemplate<LetterTypeToBankDto>(
        preExecution = { getLetterTypeToBankDtoForCreate() },
        steps = LetterTypeToBankSteps(user)
    )

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeToBankGetTest(user: User) :
    GetTestTemplate<LetterTypeToBankDto>(
        preExecution = { LetterTypeToBankData.randomOrException().toDto() },
        steps = LetterTypeToBankSteps(user)
    )

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeToBankGetPageTest(user: User) :
    GetPageTestTemplate<LetterTypeToBankDto>(
        steps = LetterTypeToBankSteps(user)
    )

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeToBankDeleteTest(user: User = Users.bankOperator) :
    DeleteTestTemplate<LetterTypeToBankDto>(
        preExecution = {
            LetterTypeToBankPrepareSteps.createLetterTypeToBankDto(user, getLetterTypeToBankDtoForCreate())
        },
        steps = LetterTypeToBankSteps(user)
    )

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeToBankUpdateTest(user: User = Users.bankOperator) :
    UpdateTestTemplate<LetterTypeToBankDto, LetterTypeToBankDto>(
        preExecution = {
            val createdDto = LetterTypeToBankSteps(user).create(getLetterTypeToBankDtoForCreate()).data!!
            getLetterTypeToBankDtoForUpdate(createdDto)
        },
        steps = LetterTypeToBankSteps(user)
    )

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderSorting
@ComponentFreeFormatDoc
@LowPriority
class LetterTypeToBankSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<LetterTypeToBankDto, LetterTypeToBankSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = LetterTypeToBankSteps(user),
    clazz = LetterTypeToBankSortingParams::class.java
)

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterTypeToBankFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> LetterTypeToBankDto)?,
    filterRequestFunction: (LetterTypeToBankDto?) -> FilterData
) : FiltrationTestTemplate<LetterTypeToBankDto, LetterTypeToBankFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = LetterTypeToBankSteps(user),
    clazz = LetterTypeToBankFilterParams::class.java,
    preExecution = preExecution
)

@LetterTypeToBankTaskIdsDocApi
@LetterTypeToBankFolderControls
@ComponentDictionary
@HighPriority
class LetterTypeToBankControlTest(
    testName: String,
    preExecution: (() -> LetterTypeToBankDto)?,
    control: LetterTypeToBankControls,
    steps: LetterTypeToBankSteps = LetterTypeToBankSteps(Users.bankOperator)
) : NestedControlTestTemplate<LetterTypeToBankDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    steps = steps
)