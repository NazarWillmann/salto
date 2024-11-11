package ooo.jtc.api.uaa.tests

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.uaa.prepare.ResourcePrepareSteps.getResourceDtoForUpdate
import ooo.jtc.api.uaa.prepare.ResourcePrepareSteps.prepareResourceDtoForCreate
import ooo.jtc.api.uaa.steps.ResourceSteps
import ooo.jtc.core.tm4j.*
import ooo.jtc.generic.UaaNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.uaa.resource.ResourceData
import ooo.jtc.testdata.uaa.resource.ResourceFilterParams
import ooo.jtc.testdata.uaa.resource.ResourceSortingParams
import ooo.jtc.uaa.resource.dto.ResourceDto

//@formatter:off
private const val baseFolder ="${FolderPrefix.UAA} \"${UaaNames.RESOURCE}\" (resource)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ResourceFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ResourceFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ResourceFolderFiltration

private const val STORY_UAA = "JTCSALTO-476"
@TaskIds([Tm4jEpic.EPIC_UAA, STORY_UAA,Tm4jStoryAT.AT_STORY_UAA,"JTCSALTO-780"]) annotation class ResourceTaskIdsCommon
//@formatter:on

@ResourceTaskIdsCommon
@ResourceFolderCrud
@ComponentUaa
@HighPriority
class ResourceCreateTest :
    CreateTestTemplate<ResourceDto>(
        preExecution = { prepareResourceDtoForCreate() },
        steps = ResourceSteps()
    )

@ResourceTaskIdsCommon
@ResourceFolderCrud
@ComponentUaa
@HighPriority
class ResourceGetTest :
    GetTestTemplate<ResourceDto>(
        preExecution = { ResourceData.randomOrException().toDto() },
        steps = ResourceSteps()
    )

@ResourceTaskIdsCommon
@ResourceFolderCrud
@ComponentUaa
@HighPriority
class ResourceGetPageTest :
    GetPageTestTemplate<ResourceDto>(
        steps = ResourceSteps()
    )

@ResourceTaskIdsCommon
@ResourceFolderCrud
@ComponentUaa
@HighPriority
class ResourceDeleteTest :
    DeleteTestTemplate<ResourceDto>(
        preExecution = {
            val createdResponse = ResourceSteps().create(prepareResourceDtoForCreate())
            createdResponse.data!!
        },
        steps = ResourceSteps()
    )

@ResourceTaskIdsCommon
@ResourceFolderCrud
@ComponentUaa
@HighPriority
class ResourceUpdateTest :
    UpdateTestTemplate<ResourceDto, ResourceDto>(
        preExecution = {
            val createdDto = ResourceSteps().create(prepareResourceDtoForCreate()).data!!
            getResourceDtoForUpdate(createdDto)
        },
        steps = ResourceSteps()
    )


@ResourceTaskIdsCommon
@ResourceFolderSorting
@ComponentUaa
@LowPriority
class ResourceSortingTest(sortRequestFunction: () -> List<Sort>) :
    SortingTestTemplate<ResourceDto, ResourceSortingParams, Any>(
        sortList = sortRequestFunction.invoke(),
        steps = ResourceSteps(),
        clazz = ResourceSortingParams::class.java
    )

@ResourceTaskIdsCommon
@ResourceFolderFiltration
@ComponentUaa
@NormalPriority
class ResourceFilterTest(
    name: String,
    preExecution: (() -> ResourceDto)?,
    filterRequestFunction: (ResourceDto?) -> FilterData
) : FiltrationTestTemplate<ResourceDto, ResourceFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ResourceSteps(),
    clazz = ResourceFilterParams::class.java,
    preExecution = preExecution
)