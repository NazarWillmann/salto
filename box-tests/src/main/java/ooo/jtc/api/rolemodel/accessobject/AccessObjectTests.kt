package ooo.jtc.api.rolemodel.accessobject

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
import ooo.jtc.rolemodel.accessobject.AccessObjectDto
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectData
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectFilterParams
import ooo.jtc.testdata.rolemodel.accessojbect.AccessObjectSortingParams

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY}\"${RoleModelNames.ACCESS_OBJECT}\" (accessObject)"

@Folder("$baseFolder/${SubFolder.CRUD}")
annotation class AccessObjectCrud

//Khatmullin [2021.08.13]: Только чтение https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262621
@Folder("${baseFolder}/${SubFolder.FILTRATION}")
annotation class AccessObjectFilter

@Folder("${baseFolder}/${SubFolder.SORTING}")
annotation class AccessObjectSorting

private const val AT_STORY_ROLEMODEL_AN = "JTCSALTO-3914"   // > Аналитика (уточнение требований)
private const val AT_STORY_ROLEMODEL_AT = "JTCSALTO-3917"   // > Тестирование (автотесты)
private const val AT_STORY_ROLEMODEL_DEV = "JTCSALTO-3482"  // > Разработка бэк (по уточнённым требованиям)

@TaskIds([Tm4jStoryAT.AT_STORY_ROLEMODEL, AT_STORY_ROLEMODEL_AN, AT_STORY_ROLEMODEL_AT, AT_STORY_ROLEMODEL_DEV])
annotation class AccessObjectTaskIdsCommon
//@formatter:on

@AccessObjectTaskIdsCommon
@AccessObjectCrud
@ComponentDictionary
@HighPriority
class AccessObjectGetTest : GetTestTemplate<AccessObjectDto>(
    preExecution = { AccessObjectData.randomOrException().toDto() },
    steps = AccessObjectSteps()
)

@AccessObjectTaskIdsCommon
@AccessObjectCrud
@ComponentDictionary
@HighPriority
class AccessObjectGetPageTest : GetPageTestTemplate<AccessObjectDto>(
    steps = AccessObjectSteps()
)

@AccessObjectTaskIdsCommon
@AccessObjectSorting
@ComponentDictionary
@NormalPriority
class AccessObjectSortingTest(sortRequestFunction: () -> List<Sort>) :
    SortingTestTemplate<AccessObjectDto, AccessObjectSortingParams, Any>(
        sortList = sortRequestFunction.invoke(),
        steps = AccessObjectSteps(),
        clazz = AccessObjectSortingParams::class.java
    )

@AccessObjectTaskIdsCommon
@AccessObjectFilter
@ComponentDictionary
@NormalPriority
class AccessObjectFilterTest(
    name: String,
    preExecution: (() -> AccessObjectDto),
    filterRequestFunction: (AccessObjectDto?) -> FilterData
) : FiltrationTestTemplate<AccessObjectDto, AccessObjectFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = AccessObjectSteps(),
    clazz = AccessObjectFilterParams::class.java,
    preExecution = preExecution
)