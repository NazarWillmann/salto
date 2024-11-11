package ooo.jtc.api.dictionaries.contactor

import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps.getContractorDtoForCreate
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps.getContractorDtoForUpdate
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps.getContractorDtoForUpdateWithNewPaymentGroundContact
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.contractor.ContractorDto
import ooo.jtc.dictionaries.contractor.ContractorUpdateDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.contractor.ContractorFilterParams
import ooo.jtc.testdata.dictionaries.contractor.ContractorSortingParams
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.CONTRACTOR}\" (contractor)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class ContractorFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class ContractorFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class ContractorFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class ContractorFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class ContractorFolderOther

@TaskIds([Tm4jEpic.EPIC_R_RKO_CONTRACTOR,"JTCSALTO-835",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1123"]) annotation class ContractorTaskIdsCommon
//@formatter:on

@ContractorTaskIdsCommon
@ContractorFolderCrud
@ComponentDictionary
@HighPriority
class ContractorCreateTest(user: User) :
    CreateTestTemplate<ContractorDto>(
        preExecution = { getContractorDtoForCreate(user) },
        steps = ContractorSteps(user)
    )

@ContractorTaskIdsCommon
@ContractorFolderCrud
@ComponentDictionary
@HighPriority
class ContractorGetTest(user: User) :
    GetTestTemplate<ContractorDto>(
        preExecution = {
            ContractorData.getOrCreate(
                consumer = { ContractorData.searchBy(user) },
                provider = { ContractorPrepareSteps.createContractorDto(user).toModel() }).toDto()
        },
        steps = ContractorSteps(user)
    )

@ContractorTaskIdsCommon
@ContractorFolderCrud
@ComponentDictionary
@HighPriority
class ContractorGetPageTest(user: User) :
    GetPageTestTemplate<ContractorDto>(
        steps = ContractorSteps(user)
    )

@ContractorTaskIdsCommon
@ContractorFolderCrud
@ComponentDictionary
@HighPriority
class ContractorDeleteTest(user: User) :
    DeleteTestTemplate<ContractorDto>(
        preExecution = { ContractorPrepareSteps.createContractorDto(user) },
        steps = ContractorSteps(user)
    )

@ContractorTaskIdsCommon
@ContractorFolderCrud
@ComponentDictionary
@HighPriority
class ContractorUpdateTest(user: User) :
    UpdateTestTemplate<ContractorDto, ContractorUpdateDto>(
        preExecution = {
            val createdDto = ContractorPrepareSteps.createContractorDto(user)
            getContractorDtoForUpdate(createdDto)
        },
        steps = ContractorSteps(user)
    )

@ContractorTaskIdsCommon
@ContractorFolderCrud
@ComponentDictionary
@HighPriority
class ContractorUpdateWithRelatedTest(user: User) :
    UpdateTestTemplate<ContractorDto, ContractorUpdateDto>(

        preExecution = {
            val createdDto = ContractorPrepareSteps.createContractorDto(user)
            getContractorDtoForUpdateWithNewPaymentGroundContact(createdDto)
        },
        steps = ContractorSteps(user),
        postExecution = { ContractorPrepareSteps.deleteContractorAndRelatedEntities(it.id!!) }
    ) {
    override fun name(): String = "'${steps.entityName}'. CRUD: Обновляем запись (с вложенными сущностями) от пользователя [${steps.user.userType}]"
}


@ContractorTaskIdsCommon
@ContractorFolderSorting
@ComponentDictionary
@LowPriority
class ContractorSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<ContractorDto, ContractorSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = ContractorSteps(user),
    clazz = ContractorSortingParams::class.java
)

@ContractorTaskIdsCommon
@ContractorFolderFiltration
@ComponentDictionary
@NormalPriority
class ContractorFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> ContractorDto)?,
    filterRequestFunction: (ContractorDto?) -> FilterData
) : FiltrationTestTemplate<ContractorDto, ContractorFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ContractorSteps(user),
    clazz = ContractorFilterParams::class.java,
    preExecution = preExecution
)


// -=| Additional tests |=-

@ContractorTaskIdsCommon
@ContractorFolderOther
@ComponentDictionary
@NormalPriority
class AddContractorToFavoritesTest(
    val user: User,
    private val steps: ContractorSteps = ContractorSteps(user)
) : AbstractTest<ContractorDto, ContractorDto>(
    preExecution = { steps.create(getContractorDtoForCreate(user)).data!! },
    postExecution = { steps.delete(it.id!!) }
) {

    override fun execution(preconditionResult: ContractorDto?) {
        val checks = ApiEntityChecks<ContractorDto>()
        preconditionResult?.let { testResult = preconditionResult }
        val entityId = preconditionResult!!.id!!

        val response = ContractorSteps(user).addToFavorites(entityId)
        checks.checkIdExist(response)
        val updatedContractor = response.data!!
        val getByIdResponse = steps.getById(entityId)
        checks.checkUpdated(updatedContractor, getByIdResponse)
        assertThat("Контрагент не был добавлен в избранные", updatedContractor.isFavorites!!, Matchers.`is`(true))
    }

    override fun name(): String = "'${DictionaryNames.CONTRACTOR}'. Добавить контрагента в список избранных пользователя [${user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Контрагент для добавления в избранное" to preconditionResult!!
        )
    }
}

@ContractorTaskIdsCommon
@ContractorFolderOther
@ComponentDictionary
@NormalPriority
class RemoveContractorFromFavoritesTest(
    val user: User,
    private val steps: ContractorSteps = ContractorSteps(user)
) : AbstractTest<ContractorDto, ContractorDto>(
    preExecution = {
        val createdContractor = steps.create(getContractorDtoForCreate(user)).data!!
        val favoriteContractorResponse = steps.addToFavorites(createdContractor.id!!)
        favoriteContractorResponse.data!!
    },
    postExecution = { steps.delete(it.id!!) }
) {

    override fun execution(preconditionResult: ContractorDto?) {
        val checks = ApiEntityChecks<ContractorDto>()
        preconditionResult?.let { testResult = preconditionResult }
        val entityId = preconditionResult!!.id!!

        val response = ContractorSteps(user).removeFromFavorites(entityId)
        checks.checkIdExist(response)
        val updatedContractor = response.data!!
        val getByIdResponse = steps.getById(entityId)
        checks.checkUpdated(updatedContractor, getByIdResponse)
        assertThat("Контрагент не был исключён из избранных", updatedContractor.isFavorites!!, Matchers.`is`(false))
    }

    override fun name(): String = "'${DictionaryNames.CONTRACTOR}'. Исключить контрагента из списка избранных пользователя [${user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Контрагент для исключения из избранных" to preconditionResult!!
        )
    }
}

@ContractorTaskIdsCommon
@ContractorFolderOther
@ComponentDictionary
@NormalPriority
class UpdateContractorInfoTest(
    val user: User,
    private val steps: ContractorSteps = ContractorSteps(user)
) : AbstractTest<ContractorDto, ContractorDto>(
    preExecution = { steps.create(getContractorDtoForCreate(user)).data!! },
    postExecution = { steps.delete(it.id!!) }
) {

    override fun execution(preconditionResult: ContractorDto?) {
        val checks = ApiEntityChecks<ContractorDto>()
        val createdDto = preconditionResult ?: throw RuntimeException("preCondition didn't succeed")
        testResult = createdDto
        val entityId = createdDto.id!!
        val updateInfoDto = ContractorPrepareSteps.getContractorUpdateInfoDtoOf(createdDto)
        val expResult = createdDto.copy(
            id = createdDto.id,
            version = 1 + createdDto.version,
            name = updateInfoDto.name,
            kpp = updateInfoDto.kpp,
            inn = updateInfoDto.inn,
            description = updateInfoDto.description,
            isFavorites = updateInfoDto.isFavorites
        )

        val response = ContractorSteps(user).updateContractorInfo(updateInfoDto)
        checks.checkIdExist(response)
        val getByIdResponse = steps.getById(entityId)
        checks.checkUpdated(expResult, getByIdResponse)
    }

    override fun name(): String = "'${DictionaryNames.CONTRACTOR}'. Изменить информацию о контрагенте [${user.userType}]"

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Контрагент для редактирования" to preconditionResult!!
        )
    }
}
