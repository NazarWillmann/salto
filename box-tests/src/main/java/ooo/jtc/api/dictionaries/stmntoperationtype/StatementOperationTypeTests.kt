package ooo.jtc.api.dictionaries.stmntoperationtype

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.NestedControlTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypePrepareSteps.availableSotCodes
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypePrepareSteps.getStatementOperationTypeDtoForCreate
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypePrepareSteps.getStatementOperationTypeDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_STATEMENT
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeControls
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeData
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeFilterParams
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.STATEMENT_OPERATION_TYPE}\" (statementOperationType)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class StatementOperationTypeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class StatementOperationTypeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class StatementOperationTypeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class StatementOperationTypeFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class StatementOperationTypeFolderOther

private const val STORY_S_O_T ="JTCSALTO-344"
private const val FEATURE_S_O_T_1 ="JTCSALTO-384"
private const val FEATURE_S_O_T_2 ="JTCSALTO-385"
@TaskIds([EPIC_R_RKO_STATEMENT, STORY_S_O_T, FEATURE_S_O_T_1, FEATURE_S_O_T_2,Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1152"]) annotation class StatementOperationTypeTaskIdsCommon
//@formatter:on

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderCrud
@ComponentDictionary
@HighPriority
class StatementOperationTypeCreateTest(
    user: User = Users.bankAdmin,
    steps: StatementOperationTypeSteps = StatementOperationTypeSteps(user)
) :
    CreateTestTemplate<StatementOperationTypeDto>(
        preExecution = { getStatementOperationTypeDtoForCreate() },
        steps = steps,
        testPostExecution = {
            availableSotCodes.add(it.code)
            steps.delete(it.id!!)
        }
    )

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderCrud
@ComponentDictionary
@HighPriority
class StatementOperationTypeGetTest(user: User) :
    GetTestTemplate<StatementOperationTypeDto>(
        preExecution = { StatementOperationTypeData.randomOrException().toDto() },
        steps = StatementOperationTypeSteps(user)
    )

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderCrud
@ComponentDictionary
@HighPriority
class StatementOperationTypeGetPageTest(user: User) :
    GetPageTestTemplate<StatementOperationTypeDto>(
        steps = StatementOperationTypeSteps(user)
    )

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderCrud
@ComponentDictionary
@HighPriority
class StatementOperationTypeDeleteTest(
    user: User = Users.bankAdmin,
    steps: StatementOperationTypeSteps = StatementOperationTypeSteps(user)
) :
    DeleteTestTemplate<StatementOperationTypeDto>(
        preExecution = {
            val createdResponse = steps.create(getStatementOperationTypeDtoForCreate())
            createdResponse.data!!
        },
        steps = steps,
        postExecution = { availableSotCodes.add(it.code) }
    )

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderCrud
@ComponentDictionary
@HighPriority
class StatementOperationTypeUpdateTest(
    user: User = Users.bankAdmin,
    steps: StatementOperationTypeSteps = StatementOperationTypeSteps(user)
) :
    UpdateTestTemplate<StatementOperationTypeDto, StatementOperationTypeDto>(
        preExecution = {
            val createdDto = steps.create(getStatementOperationTypeDtoForCreate()).data!!
            getStatementOperationTypeDtoForUpdate(createdDto)
        },
        steps = steps,
        postExecution = {
            availableSotCodes.add(it.code)
            steps.delete(it.id!!)
        }
    )

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderSorting
@ComponentDictionary
@LowPriority
class StatementOperationTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<StatementOperationTypeDto, StatementOperationTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = StatementOperationTypeSteps(user),
    clazz = StatementOperationTypeSortingParams::class.java
)

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class StatementOperationTypeFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> StatementOperationTypeDto)?,
    filterRequestFunction: (StatementOperationTypeDto?) -> FilterData
) : FiltrationTestTemplate<StatementOperationTypeDto, StatementOperationTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = StatementOperationTypeSteps(user),
    clazz = StatementOperationTypeFilterParams::class.java,
    preExecution = preExecution
)

//https://confluence.jtc.ooo/pages/viewpage.action?pageId=12915700
@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderControls
@ComponentDictionary
@HighPriority
class StatementOperationTypeControlTest(
    testName: String,
    preExecution: (() -> StatementOperationTypeDto)?,
    control: StatementOperationTypeControls,
    steps: StatementOperationTypeSteps = StatementOperationTypeSteps(Users.bankAdmin)
) : NestedControlTestTemplate<StatementOperationTypeDto>(
    testName = testName,
    docControl = control,
    preExecution = preExecution,
    steps = steps
)

@StatementOperationTypeTaskIdsCommon
@StatementOperationTypeFolderOther
@ComponentDictionary
@NormalPriority
class StatementOperationTypeOtherTest(
    name: String,
    params: ((Unit?) -> Map<String, Any>)? = null,
    testBody: (Unit?) -> Unit
) : UnitBeTest(
    name = name,
    params = params,
    testBody = testBody
)