package ooo.jtc.api.rolemodel.accessobjecttype

import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeDto
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeData
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeFilterParams
import ooo.jtc.testdata.rolemodel.accessobjecttype.AccessObjectTypeSortingParams

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY}\"${RoleModelNames.ACCESS_OBJECT_TYPE}\" (accessObjectType)"

@Folder("$baseFolder/${SubFolder.CRUD}")
annotation class AccessObjectTypeCrud
//Khatmullin [2021.08.13]: Только чтение https://confluence.jtc.ooo/pages/viewpage.action?pageId=36867854
@Folder("$baseFolder/${SubFolder.FILTRATION}")
annotation class AccessObjectTypeFilter
@Folder("$baseFolder/${SubFolder.SORTING}")
annotation class AccessObjectTypeSorting

private const val AT_STORY_ROLEMODEL_AN = "JTCSALTO-3914"   // > Аналитика (уточнение требований)
private const val AT_STORY_ROLEMODEL_AT = "JTCSALTO-3917"   // > Тестирование (автотесты)
private const val AT_STORY_ROLEMODEL_DEV = "JTCSALTO-3482"  // > Разработка бэк (по уточнённым требованиям)

@TaskIds([Tm4jStoryAT.AT_STORY_ROLEMODEL, AT_STORY_ROLEMODEL_AN, AT_STORY_ROLEMODEL_AT, AT_STORY_ROLEMODEL_DEV])
annotation class AccessObjectTypeTaskIdsCommon
//@formatter:on

@AccessObjectTypeTaskIdsCommon
@AccessObjectTypeCrud
@ComponentDictionary
@HighPriority
class AccessObjectTypeGetTest : GetTestTemplate<AccessObjectTypeDto>(
    preExecution = { AccessObjectTypeData.randomOrException().toDto() },
    steps = AccessObjectTypeSteps()
)

@AccessObjectTypeTaskIdsCommon
@AccessObjectTypeCrud
@ComponentDictionary
@HighPriority
class AccessObjectTypeGetPageTest : GetPageTestTemplate<AccessObjectTypeDto>(
    steps = AccessObjectTypeSteps()
)

@AccessObjectTypeTaskIdsCommon
@AccessObjectTypeSorting
@ComponentDictionary
@NormalPriority
class AccessObjectTypeSortingTest(sortRequestFunction: () -> List<Sort>) :
    SortingTestTemplate<AccessObjectTypeDto, AccessObjectTypeSortingParams, Any>(
        sortList = sortRequestFunction.invoke(),
        steps = AccessObjectTypeSteps(),
        clazz = AccessObjectTypeSortingParams::class.java
    )

@AccessObjectTypeTaskIdsCommon
@AccessObjectTypeFilter
@ComponentDictionary
@NormalPriority
class AccessObjectTypeFilterTest(
    name: String,
    preExecution: (() -> AccessObjectTypeDto),
    filterRequestFunction: (AccessObjectTypeDto?) -> FilterData
) : FiltrationTestTemplate<AccessObjectTypeDto, AccessObjectTypeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = AccessObjectTypeSteps(),
    clazz = AccessObjectTypeFilterParams::class.java,
    preExecution = preExecution
)