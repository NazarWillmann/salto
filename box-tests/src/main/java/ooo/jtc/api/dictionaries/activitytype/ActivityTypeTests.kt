package ooo.jtc.api.dictionaries.activitytype

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.activitytype.ActivityTypePrepareSteps.getActivityTypeDtoForCreate
import ooo.jtc.api.dictionaries.activitytype.ActivityTypePrepareSteps.getActivityTypeDtoForUpdate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix.DICTIONARY
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.activitytype.ActivityTypeDto
import ooo.jtc.generic.DictionaryNames.ACTIVITY_TYPE
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeData
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeFilterParams
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder = "$DICTIONARY \"$ACTIVITY_TYPE\" (activityType)"
@Folder("$baseFolder/${SubFolder.CRUD}")            annotation class ActivityTypeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")         annotation class ActivityTypeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}")      annotation class ActivityTypeFolderFiltration

private const val JTCSALTO_3126 = "JTCSALTO-3126"   // [JTCSALTO-3125] -> АТ. Справочники. Написание базового набора тестов для activity_type

@TaskIds([
    Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES,
    JTCSALTO_3126
])    annotation class ActivityTypeTaskIdsAll
//@formatter:on

@ActivityTypeTaskIdsAll
@ActivityTypeFolderCrud
@ComponentDictionary
@HighPriority
class ActivityTypeCreateTest(user: User = bankAdmin) :
    CreateTestTemplate<ActivityTypeDto>(
        preExecution = { getActivityTypeDtoForCreate() },
        steps = ActivityTypeSteps(user)
    )

@ActivityTypeTaskIdsAll
@ActivityTypeFolderCrud
@ComponentDictionary
@HighPriority
class ActivityTypeGetTest(user: User) :
    GetTestTemplate<ActivityTypeDto>(
        preExecution = { ActivityTypeData.randomOrException().toDto() },
        steps = ActivityTypeSteps(user)
    )

@ActivityTypeTaskIdsAll
@ActivityTypeFolderCrud
@ComponentDictionary
@HighPriority
class ActivityTypeGetPageTest(user: User) :
    GetPageTestTemplate<ActivityTypeDto>(
        steps = ActivityTypeSteps(user)
    )

@ActivityTypeTaskIdsAll
@ActivityTypeFolderCrud
@ComponentDictionary
@HighPriority
class ActivityTypeDeleteTest(user: User = bankAdmin) :
    DeleteTestTemplate<ActivityTypeDto>(
        preExecution = {
            val createdResponse = ActivityTypeSteps(user).create(getActivityTypeDtoForCreate())
            createdResponse.data!!
        },
        steps = ActivityTypeSteps(user)
    )

@ActivityTypeTaskIdsAll
@ActivityTypeFolderCrud
@ComponentDictionary
@HighPriority
class ActivityTypeUpdateTest(user: User = bankAdmin) :
    UpdateTestTemplate<ActivityTypeDto, ActivityTypeDto>(
        preExecution = {
            val createdDto = ActivityTypeSteps(user).create(getActivityTypeDtoForCreate()).data!!
            getActivityTypeDtoForUpdate(createdDto)
        },
        steps = ActivityTypeSteps(user)
    )

@ActivityTypeTaskIdsAll
@ActivityTypeFolderSorting
@ComponentDictionary
@LowPriority
class ActivityTypeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<ActivityTypeDto, ActivityTypeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ActivityTypeSteps(user),
    clazz = ActivityTypeSortingParams::class.java
)

@ActivityTypeTaskIdsAll
@ActivityTypeFolderFiltration
@ComponentDictionary
@NormalPriority
class ActivityTypeFilterTests(
    name: String,
    user: User,
    preExecution: (() -> ActivityTypeDto)?,
    filterRequestFunction: (ActivityTypeDto?) -> FilterData
) : FiltrationTestTemplate<ActivityTypeDto, ActivityTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ActivityTypeSteps(user),
    clazz = ActivityTypeFilterParams::class.java,
    preExecution = preExecution
)