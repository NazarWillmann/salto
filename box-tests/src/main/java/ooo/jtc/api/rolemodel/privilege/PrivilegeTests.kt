package ooo.jtc.api.rolemodel.privilege

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
import ooo.jtc.rolemodel.privilege.PrivilegeDto
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeData
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeFilterParams
import ooo.jtc.testdata.rolemodel.privilege.PrivilegeSortingParams

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY}\"${RoleModelNames.PRIVILEGE}\" (privilege)"

@Folder("$baseFolder/${SubFolder.CRUD}")
annotation class PrivilegeCrud

//Khatmullin [2021.08.13]: Только чтение https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262332
@Folder("${baseFolder}/${SubFolder.FILTRATION}")
annotation class PrivilegeFilter
@Folder("${baseFolder}/${SubFolder.SORTING}")
annotation class PrivilegeSorting

private const val AT_STORY_ROLEMODEL_AN = "JTCSALTO-3914"   // > Аналитика (уточнение требований)
private const val AT_STORY_ROLEMODEL_AT = "JTCSALTO-3917"   // > Тестирование (автотесты)
private const val AT_STORY_ROLEMODEL_DEV = "JTCSALTO-3482"  // > Разработка бэк (по уточнённым требованиям)

@TaskIds([Tm4jStoryAT.AT_STORY_ROLEMODEL, AT_STORY_ROLEMODEL_AN, AT_STORY_ROLEMODEL_AT, AT_STORY_ROLEMODEL_DEV])
annotation class PrivilegeTaskIdsCommon
//@formatter:on

@PrivilegeTaskIdsCommon
@PrivilegeCrud
@ComponentDictionary
@HighPriority
class PrivilegeGetTest : GetTestTemplate<PrivilegeDto>(
    preExecution = { PrivilegeData.randomOrException().toDto() },
    steps = PrivilegeSteps()
)

@PrivilegeTaskIdsCommon
@PrivilegeCrud
@ComponentDictionary
@HighPriority
class PrivilegeGetPageTest : GetPageTestTemplate<PrivilegeDto>(
    steps = PrivilegeSteps()
)

@PrivilegeTaskIdsCommon
@PrivilegeSorting
@ComponentDictionary
@NormalPriority
class PrivilegeSortingTest(sortRequestFunction: () -> List<Sort>) :
    SortingTestTemplate<PrivilegeDto, PrivilegeSortingParams, Any>(
        sortList = sortRequestFunction.invoke(),
        steps = PrivilegeSteps(),
        clazz = PrivilegeSortingParams::class.java
    )

@PrivilegeTaskIdsCommon
@PrivilegeFilter
@ComponentDictionary
@NormalPriority
class PrivilegeFilterTest(
    name: String,
    preExecution: (() -> PrivilegeDto),
    filterRequestFunction: (PrivilegeDto?) -> FilterData
) : FiltrationTestTemplate<PrivilegeDto, PrivilegeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = PrivilegeSteps(),
    clazz = PrivilegeFilterParams::class.java,
    preExecution = preExecution
)