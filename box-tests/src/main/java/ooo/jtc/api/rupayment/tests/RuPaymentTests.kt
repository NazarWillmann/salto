package ooo.jtc.api.rupayment.tests

import ooo.jtc.api.common.templates.entity.AddToFavoritesTestTemplate
import ooo.jtc.api.common.templates.entity.CategoryListTestTemplate
import ooo.jtc.api.common.templates.entity.CategorySummaryCountTestTemplate
import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteDocumentTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.PaginationTestTemplate
import ooo.jtc.api.common.templates.entity.RemoveFromFavoritesTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.rupayment.RuPaymentSteps
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps.createSentRuPaymentDto
import ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps.hasRuPaymentsInStatuses
import ooo.jtc.api.rupayment.prepare.RuPaymentTemplates
import ooo.jtc.api.rupayment.prepare.RuPaymentTemplates.getBusinessRuPayment
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.core.tm4j.ComponentRuPayment
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.documents.bankAvailableStatuses
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.interfaces.getOrException
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.rupayment.model.RuPaymentCategory
import ooo.jtc.rupayment.model.RuPaymentStatus
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.rupayment.RuPaymentFilterParams
import ooo.jtc.testdata.rupayment.RuPaymentSortingParams
import ooo.jtc.uaa.User
import java.util.*


//@formatter:off
@Folder(SubFolder.CRUD)          annotation class RuPaymentFolderCrud
@Folder(SubFolder.SORTING)       annotation class RuPaymentFolderSorting
@Folder(SubFolder.FILTRATION)    annotation class RuPaymentFolderFiltration
@Folder(SubFolder.OTHER)         annotation class RuPaymentFolderOther



private const val STORY_RU_PAYMENT_VIEW = "JTCSALTO-570"

private const val STORY_RU_PAYMENT_ADDITION = "JTCSALTO-944"
const val FEATURE_RU_PAYMENT_PREFILL = "JTCSALTO-959"
private const val FEATURE_RU_PAYMENT_COPY = "JTCSALTO-946"

private const val FEATURE_RU_PAYMENT_PREFILL_NDS = "JTCSALTO-232"
private const val FEATURE_RU_PAYMENT_GET_TOTAL = "JTCSALTO-527"

const val FEATURE_RU_PAYMENT_FAVORITES = "JTCSALTO-589"
private const val FEATURE_RU_PAYMENT_CAT_FILTER = "JTCSALTO-710"
private const val FEATURE_RU_PAYMENT_CATEGORY = "JTCSALTO-703"

private const val STORY_RU_PAYMENT_PRINT = "JTCSALTO-574"
private const val FEATURE_RU_PAYMENT_PRINT = "JTCSALTO-737"

//@formatter:on

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT])
@RuPaymentFolderCrud
@ComponentRuPayment
@HighPriority
class RuPaymentCreateTest(
    user: User = client,
    dtoForCreation: () -> RuPaymentDto,
    var nameDetails: String = ""
) : CreateTestTemplate<RuPaymentDto>(
    steps = RuPaymentSteps(user),
    preExecution = dtoForCreation
) {
    override fun name(): String {
        return "'${steps.entityName}'. CRUD: Создание рублевого платежного поручения$nameDetails"
    }
}

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, STORY_RU_PAYMENT_VIEW])
@RuPaymentFolderCrud
@ComponentRuPayment
@HighPriority
class RuPaymentGetTest(
    user: User = client
) : GetTestTemplate<RuPaymentDto>(
    steps = RuPaymentSteps(user),
    preExecution = {
        // 0 гарантий, что банковский пользователь будет иметь доступ к созданному ПП
        // (после обновления ЖЦ / требований к разработке банковской стороне)
        val clientUser = retrieveClientUser(user)
        val preparedDto = RuPaymentTemplates.getOtherRuPayment(clientUser)
        RuPaymentSteps(clientUser).create(preparedDto).data.getOrException()
    },
    postExecution = {
        val clientUser = retrieveClientUser(user)
        RuPaymentSteps(clientUser).delete(it.id!!)
    }
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, STORY_RU_PAYMENT_VIEW])
@RuPaymentFolderCrud
@ComponentRuPayment
@HighPriority
class RuPaymentGetPageTest(
    user: User = client
) : GetPageTestTemplate<RuPaymentDto>(
    preExecution = {
        if (!hasRuPaymentsInStatuses(*RuPaymentStatus.values.bankAvailableStatuses().toTypedArray())) {
            val clientUser = retrieveClientUser(user)
            repeat(REQUIRED_DATA_COUNT.toInt()) { createSentRuPaymentDto(clientUser, getBusinessRuPayment(user)) }
        }
        emptyList()
    },
    steps = RuPaymentSteps(user)
)


@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT])
@RuPaymentFolderCrud
@ComponentRuPayment
@HighPriority
class RuPaymentUpdateTest(
    user: User = client,
    preExecutionDto: () -> RuPaymentDto = { RuPaymentTemplates.getOtherRuPayment(user) }
) : UpdateTestTemplate<RuPaymentDto, RuPaymentDto>(
    steps = RuPaymentSteps(user),
    preExecution = {
        user.checkIsClientUser("Only client users can create RuPayment docs.")
        val createdRuPayment = RuPaymentSteps(user).create(preExecutionDto.invoke()).data!!
        RuPaymentPrepareSteps.getDtoForUpdate(createdRuPayment)
    }
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT])
@RuPaymentFolderCrud
@ComponentRuPayment
@HighPriority
class RuPaymentDeleteTest(
    user: User = client,
    preExecutionDto: () -> RuPaymentDto = { RuPaymentTemplates.getOtherRuPayment(user) }
) : DeleteDocumentTestTemplate<RuPaymentDto>(
    steps = RuPaymentSteps(user),
    preExecution = {
        user.checkIsClientUser("Only client users can create RuPayment docs.")
        RuPaymentSteps(user).create(preExecutionDto.invoke()).data!!
    },
    deletedStatus = RuPaymentStatus.DELETED.getUserStatus(user.userType)
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT])
@RuPaymentFolderSorting
@ComponentRuPayment
@LowPriority
class RuPaymentSortingTest(
    user: User = client,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<RuPaymentDto, RuPaymentSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = RuPaymentSteps(user),
    clazz = RuPaymentSortingParams::class.java
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, FEATURE_RU_PAYMENT_CAT_FILTER])
@RuPaymentFolderFiltration
@ComponentRuPayment
@NormalPriority
class RuPaymentFiltrationTest(
    name: String,
    var user: User = client,
    preExecution: (() -> RuPaymentDto)?,
    filterRequestFunction: (RuPaymentDto?) -> FilterData
) : FiltrationTestTemplate<RuPaymentDto, RuPaymentFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = RuPaymentSteps(user),
    clazz = RuPaymentFilterParams::class.java,
    preExecution = preExecution
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, FEATURE_RU_PAYMENT_CAT_FILTER, FEATURE_RU_PAYMENT_CATEGORY])
@RuPaymentFolderFiltration
@ComponentRuPayment
@NormalPriority
class RuPaymentCategorySummaryCountTest(
    user: User
) : CategorySummaryCountTestTemplate<RuPaymentDto>(
    steps = RuPaymentSteps(user)
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, FEATURE_RU_PAYMENT_CAT_FILTER, FEATURE_RU_PAYMENT_CATEGORY])
@RuPaymentFolderFiltration
@ComponentRuPayment
@NormalPriority
class RuPaymentCategoryListTest(
    user: User
) : CategoryListTestTemplate<RuPaymentDto>(
    steps = RuPaymentSteps(user),
    expCategories = {
        val categoriesAndStatuses = if (user.isClient) RuPaymentCategory.clientCategoriesAndStatuses else RuPaymentCategory.bankCategoriesAndStatuses
        categoriesAndStatuses.keys.toList()
    }.invoke()
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT])
@RuPaymentFolderOther
@ComponentRuPayment
@LowPriority
class RuPaymentPaginationTest(
    user: User = client
) : PaginationTestTemplate<RuPaymentDto, RuPaymentSortingParams>(
    steps = RuPaymentSteps(user),
    sortParam = RuPaymentSortingParams.DOCUMENT_DATE,
    createRecord = {
        RuPaymentPrepareSteps.createRuPaymentDto(user)
    }
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, FEATURE_RU_PAYMENT_FAVORITES])
@RuPaymentFolderOther
@ComponentRuPayment
@NormalPriority
class RuPaymentAddToFavoritesTest(
    user: User,
    preExecution: (() -> UUID)?
) : AddToFavoritesTestTemplate<RuPaymentDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = RuPaymentSteps(user),
    preExecution = preExecution
)

@TaskIds([Tm4jEpic.EPIC_R_RKO_PAYMENT, FEATURE_RU_PAYMENT_FAVORITES])
@RuPaymentFolderOther
@ComponentRuPayment
@NormalPriority
class RuPaymentRemoveFromFavoritesTest(
    user: User,
    preExecution: (() -> UUID)?
) : RemoveFromFavoritesTestTemplate<RuPaymentDto>(
    retrieveIsFavorites = { it.isFavorites!! },
    steps = RuPaymentSteps(user),
    preExecution = preExecution
)

/**
 * Retrieve client user for creation.
 * Because only client user can create RuPayment.
 */
private fun retrieveClientUser(user: User): User {
    return if (user.isClient) user else client
}