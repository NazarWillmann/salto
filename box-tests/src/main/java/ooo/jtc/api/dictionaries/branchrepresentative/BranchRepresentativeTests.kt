package ooo.jtc.api.dictionaries.branchrepresentative

import ooo.jtc.api.common.templates.entity.*
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForUpdate
import ooo.jtc.core.tm4j.*
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentativeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeSortingParams
import ooo.jtc.uaa.User

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BRANCH_REPRESENTATIVE}\" (branchRepresentative)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BranchRepresentativeFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BranchRepresentativeFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BranchRepresentativeFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class BranchRepresentativeFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class BranchRepresentativeFolderOther

@TaskIds([
    Tm4jEpic.EPIC_R_RKO_DICTIONARY, Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,
    Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES, "JTCSALTO-1117"
]) annotation class BranchRepresentativeTaskIdsCommon
//@formatter:on

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BranchRepresentativeCreateTest(
    runTestAsUser: User,
    createEntityForUser: User
) : CreateTestTemplate<BranchRepresentativeDto>(
    steps = BranchRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
        getBranchRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            branchId = newBranch.id!!
        )
    },
    postExecution = { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.branchId!!) },
    testPostExecution = null
)

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BranchRepresentativeGetTest(user: User) :
    GetTestTemplate<BranchRepresentativeDto>(
        preExecution = { BranchRepresentativeData.searchBy(user).filter { !it.isBlock }.random().toDto() },
        steps = BranchRepresentativeSteps(user)
    )

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BranchRepresentativeGetPageTest(user: User) :
    GetPageTestTemplate<BranchRepresentativeDto>(
        steps = BranchRepresentativeSteps(user)
    )

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BranchRepresentativeDeleteTest(
    runTestAsUser: User,
    createEntityForUser: User
) : DeleteTestTemplate<BranchRepresentativeDto>(
    steps = BranchRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
        val prepBranchRepres = getBranchRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            branchId = newBranch.id!!
        )
        val createdBranchRepres = BranchRepresentativeSteps(runTestAsUser).create(prepBranchRepres)
        createdBranchRepres.data!!
    },
    postExecution = { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.branchId!!) }
)

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderCrud
@ComponentDictionary
@HighPriority
class BranchRepresentativeUpdateTest(
    runTestAsUser: User,
    createEntityForUser: User
) : UpdateTestTemplate<BranchRepresentativeDto, BranchRepresentativeDto>(
    steps = BranchRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
        val prepBranchRepres = getBranchRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            branchId = newBranch.id!!
        )
        val createdBranchRepres = BranchRepresentativeSteps(runTestAsUser).create(prepBranchRepres)
        getBranchRepresentativeDtoForUpdate(createdBranchRepres.data!!)
    },
    postExecution = { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.branchId!!) },
    testPostExecution = null
)


@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderSorting
@ComponentDictionary
@LowPriority
class BranchRepresentativeSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<BranchRepresentativeDto, BranchRepresentativeSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BranchRepresentativeSteps(user),
    clazz = BranchRepresentativeSortingParams::class.java
)

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderFiltration
@ComponentDictionary
@NormalPriority
class BranchRepresentativeFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> BranchRepresentativeDto)?,
    filterRequestFunction: (BranchRepresentativeDto?) -> FilterData
) : FiltrationTestTemplate<BranchRepresentativeDto, BranchRepresentativeFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BranchRepresentativeSteps(user),
    clazz = BranchRepresentativeFilterParams::class.java,
    preExecution = preExecution
)

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderOther
@ComponentDictionary
@NormalPriority
class BranchRepresentativeBlockingTest(
    runTestAsUser: User,
    createEntityForUser: User
) : BlockingTestTemplate<BranchRepresentativeDto>(
    steps = BranchRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
        val prepBranchRepres = getBranchRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            branchId = newBranch.id!!
        )
        BranchRepresentativePrepareSteps.createBranchRepresentativeDto(prepBranchRepres)
    },
    postExecution = { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.branchId!!) }
)

@BranchRepresentativeTaskIdsCommon
@BranchRepresentativeFolderOther
@ComponentDictionary
@NormalPriority
class BranchRepresentativeUnblockingTest(
    runTestAsUser: User,
    createEntityForUser: User
) : UnblockingTestTemplate<BranchRepresentativeDto>(
    steps = BranchRepresentativeSteps(runTestAsUser),
    preExecution = {
        val newBranch = BranchPrepareSteps.createBranchWithoutRelatedEntities()
        val prepBranchRepres = getBranchRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            branchId = newBranch.id!!
        )
        BranchRepresentativePrepareSteps.createBlockedBranchRepresentativeDto(prepBranchRepres)
    },
    postExecution = { BranchPrepareSteps.deleteBranchAndRelatedEntities(it.branchId!!) }
)
