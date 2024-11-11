package ooo.jtc.api.dictionaries.lettertypefrombank

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankPrepareSteps.getLetterTypeFromBankDtoForCreate
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankPrepareSteps.getLetterTypeFromBankDtoForUpdate
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
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBankDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankControls
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankData
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankFilterParams
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "${FolderPrefix.LETTER_FROM_BANK} (letterFromBank)/Справочники/${DictionaryNames.LETTER_TYPE_FROM_BANK} (letterTypeFromBank)"

@Folder("$baseFolder/${SubFolder.CRUD}")          annotation class LetterTypeFromBankFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")       annotation class LetterTypeFromBankFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")    annotation class LetterTypeFromBankFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")      annotation class LetterTypeFromBankFolderControls

private const val STORY_LETTERS_COMMON = "JTCSALTO-1092"
private const val STORY_LETTERS_DICTIONARY = "JTCSALTO-1093"
const val FEATURE_LETTER_TYPE_FROM_BANK_API = "JTCSALTO-1095"

@TaskIds([Tm4jEpic.EPIC_R_RKO_LETTERS, STORY_LETTERS_COMMON,STORY_LETTERS_DICTIONARY, FEATURE_LETTER_TYPE_FROM_BANK_API])
annotation class LetterTypeFromBankTaskIdsDocApi
//@formatter:on

@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeFromBankCreateTest(user: User = Users.bankOperator) :
    CreateTestTemplate<LetterTypeFromBankDto>(
        preExecution = { getLetterTypeFromBankDtoForCreate() },
        steps = LetterTypeFromBankSteps(user)
    )

@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeFromBankGetTest(user: User) :
    GetTestTemplate<LetterTypeFromBankDto>(
        preExecution = { LetterTypeFromBankData.randomOrException().toDto() },
        steps = LetterTypeFromBankSteps(user)
    )

@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeFromBankGetPageTest(user: User) :
    GetPageTestTemplate<LetterTypeFromBankDto>(
        steps = LetterTypeFromBankSteps(user)
    )

@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeFromBankDeleteTest(user: User = Users.bankOperator) :
    DeleteTestTemplate<LetterTypeFromBankDto>(
        preExecution = {
            val createdResponse = LetterTypeFromBankSteps(user).create(getLetterTypeFromBankDtoForCreate())
            createdResponse.data!!
        },
        steps = LetterTypeFromBankSteps(user)
    )

@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderCrud
@ComponentFreeFormatDoc
@HighPriority
class LetterTypeFromBankUpdateTest(user: User = Users.bankOperator) :
    UpdateTestTemplate<LetterTypeFromBankDto, LetterTypeFromBankDto>(
        preExecution = {
            val createdDto = LetterTypeFromBankSteps(user).create(getLetterTypeFromBankDtoForCreate()).data!!
            getLetterTypeFromBankDtoForUpdate(createdDto)
        },
        steps = LetterTypeFromBankSteps(user)
    )


@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderSorting
@ComponentFreeFormatDoc
@LowPriority
class LetterTypeFromBankSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<LetterTypeFromBankDto, LetterTypeFromBankSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = LetterTypeFromBankSteps(user),
    clazz = LetterTypeFromBankSortingParams::class.java
)

@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderFiltration
@ComponentFreeFormatDoc
@NormalPriority
class LetterTypeFromBankFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> LetterTypeFromBankDto)?,
    filterRequestFunction: (LetterTypeFromBankDto?) -> FilterData
) : FiltrationTestTemplate<LetterTypeFromBankDto, LetterTypeFromBankFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = LetterTypeFromBankSteps(user),
    clazz = LetterTypeFromBankFilterParams::class.java,
    preExecution = preExecution
)


@LetterTypeFromBankTaskIdsDocApi
@LetterTypeFromBankFolderControls
@ComponentDictionary
@HighPriority
class LetterTypeFromBankControlTest(
    testName: String,
    preExecution: (() -> LetterTypeFromBankDto)?,
    control: LetterTypeFromBankControls,
    steps: LetterTypeFromBankSteps = LetterTypeFromBankSteps(Users.bankOperator)
) : NestedControlTestTemplate<LetterTypeFromBankDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    steps = steps
)