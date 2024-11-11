package ooo.jtc.api.uaa.tests

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.uaa.prepare.ApplicationPrepareSteps.getApplicationDtoForUpdate
import ooo.jtc.api.uaa.prepare.ApplicationPrepareSteps.prepareApplicationDtoForCreate
import ooo.jtc.api.uaa.steps.ApplicationSteps
import ooo.jtc.core.tm4j.*
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_UAA
import ooo.jtc.generic.UaaNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.uaa.application.ApplicationData
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams
import ooo.jtc.testdata.uaa.application.ApplicationSortingParams
import ooo.jtc.uaa.application.dto.ApplicationDto

//@formatter:off
private const val baseFolder ="${FolderPrefix.UAA} \"${UaaNames.APPLICATION}\" (application)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ApplicationFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ApplicationFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ApplicationFolderFiltration

private const val STORY_UAA = "JTCSALTO-476"
@TaskIds([Tm4jEpic.EPIC_UAA, STORY_UAA,AT_STORY_UAA,"JTCSALTO-778"]) annotation class ApplicationTaskIdsCommon
//@formatter:on

@ApplicationTaskIdsCommon
@ApplicationFolderCrud
@ComponentUaa
@HighPriority
class ApplicationCreateTest :
    CreateTestTemplate<ApplicationDto>(
        preExecution = { prepareApplicationDtoForCreate() },
        steps = ApplicationSteps()
    )

@ApplicationTaskIdsCommon
@ApplicationFolderCrud
@ComponentUaa
@HighPriority
class ApplicationGetTest :
    GetTestTemplate<ApplicationDto>(
        preExecution = { ApplicationData.randomOrException().toDto() },
        steps = ApplicationSteps()
    )

@ApplicationTaskIdsCommon
@ApplicationFolderCrud
@ComponentUaa
@HighPriority
class ApplicationGetPageTest :
    GetPageTestTemplate<ApplicationDto>(
        steps = ApplicationSteps()
    )

@ApplicationTaskIdsCommon
@ApplicationFolderCrud
@ComponentUaa
@HighPriority
class ApplicationDeleteTest :
    DeleteTestTemplate<ApplicationDto>(
        preExecution = {
            val createdResponse = ApplicationSteps().create(prepareApplicationDtoForCreate())
            createdResponse.data!!
        },
        steps = ApplicationSteps(),
        preCheckingHandling = {
            it.availableCatalogs = emptyList()
            it.availableResources = emptyList()
            it.allowedFlows = emptyList()
            it
        }
    )

@ApplicationTaskIdsCommon
@ApplicationFolderCrud
@ComponentUaa
@HighPriority
class ApplicationUpdateTest :
    UpdateTestTemplate<ApplicationDto, ApplicationDto>(
        preExecution = {
            val dtoForCreate = prepareApplicationDtoForCreate()
            val createdDto = ApplicationSteps().create(dtoForCreate).data!!
            getApplicationDtoForUpdate(createdDto)
        },
        steps = ApplicationSteps()
    )

@ApplicationTaskIdsCommon
@ApplicationFolderSorting
@ComponentUaa
@LowPriority
class ApplicationSortingTest(sortRequestFunction: () -> List<Sort>) : SortingTestTemplate<ApplicationDto, ApplicationSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ApplicationSteps(),
    clazz = ApplicationSortingParams::class.java
)

@ApplicationTaskIdsCommon
@ApplicationFolderFiltration
@ComponentUaa
@NormalPriority
class ApplicationFilterTests(
    name: String,
    preExecution: (() -> ApplicationDto)?,
    filterRequestFunction: (ApplicationDto?) -> FilterData
) : FiltrationTestTemplate<ApplicationDto, ApplicationFilterParams, ApplicationDto>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ApplicationSteps(),
    clazz = ApplicationFilterParams::class.java,
    preExecution = preExecution
)