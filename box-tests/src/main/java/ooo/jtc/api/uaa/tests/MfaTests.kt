package ooo.jtc.api.uaa.tests

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.uaa.prepare.PrepareMfaData.getMfaDtoForUpdate
import ooo.jtc.api.uaa.prepare.PrepareMfaData.prepareMfaDtoForCreate
import ooo.jtc.api.uaa.steps.MfaSteps
import ooo.jtc.core.tm4j.*
import ooo.jtc.generic.UaaNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.uaa.mfa.MfaData
import ooo.jtc.testdata.uaa.mfa.MfaFilterParams
import ooo.jtc.testdata.uaa.mfa.MfaSortingParams
import ooo.jtc.uaa.mfa.dto.MfaDto

//@formatter:off
private const val baseFolder ="${FolderPrefix.UAA} \"${UaaNames.MFA}\" (mfa)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class MfaFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class MfaFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class MfaFolderFiltration

private const val STORY_UAA = "JTCSALTO-476"
@TaskIds([Tm4jEpic.EPIC_UAA, STORY_UAA,Tm4jStoryAT.AT_STORY_UAA,"JTCSALTO-781"]) annotation class MfaTaskIdsCommon
//@formatter:on

@MfaTaskIdsCommon
@MfaFolderCrud
@ComponentUaa
@HighPriority
class MfaCreateTest :
    CreateTestTemplate<MfaDto>(
        preExecution = { prepareMfaDtoForCreate() },
        steps = MfaSteps()
    )

@MfaTaskIdsCommon
@MfaFolderCrud
@ComponentUaa
@HighPriority
class MfaGetTest :
    GetTestTemplate<MfaDto>(
        preExecution = { MfaData.randomOrException().toDto() },
        steps = MfaSteps()
    )

@MfaTaskIdsCommon
@MfaFolderCrud
@ComponentUaa
@HighPriority
class MfaGetPageTest :
    GetPageTestTemplate<MfaDto>(
        steps = MfaSteps()
    )

@MfaTaskIdsCommon
@MfaFolderCrud
@ComponentUaa
@HighPriority
class MfaDeleteTest :
    DeleteTestTemplate<MfaDto>(
        preExecution = {
            val createdResponse = MfaSteps().create(prepareMfaDtoForCreate())
            createdResponse.data!!
        },
        steps = MfaSteps()
    )

@MfaTaskIdsCommon
@MfaFolderCrud
@ComponentUaa
@HighPriority
class MfaUpdateTest :
    UpdateTestTemplate<MfaDto, MfaDto>(
        preExecution = {
            val dtoForCreate = prepareMfaDtoForCreate()
            val createdDto = MfaSteps().create(dtoForCreate).data!!
            getMfaDtoForUpdate(createdDto)
        },
        steps = MfaSteps()
    )

@MfaTaskIdsCommon
@MfaFolderSorting
@ComponentUaa
@LowPriority
class MfaSortingTest(sortRequestFunction: () -> List<Sort>) : SortingTestTemplate<MfaDto, MfaSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = MfaSteps(),
    clazz = MfaSortingParams::class.java
)

@MfaTaskIdsCommon
@MfaFolderFiltration
@ComponentUaa
@NormalPriority
class MfaFilterTests(
    name: String,
    preExecution: (() -> MfaDto)?,
    filterRequestFunction: (MfaDto?) -> FilterData
) : FiltrationTestTemplate<MfaDto, MfaFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = MfaSteps(),
    clazz = MfaFilterParams::class.java,
    preExecution = preExecution
)