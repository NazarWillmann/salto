package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.asserts.assertEqualList
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.extensions.DEFAULT_DATETIME_FORMAT
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.string
import ooo.jtc.generic.Category
import ooo.jtc.generic.getFilterData
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.OperandType
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.generic.pageparams.toGetPageRequest
import ooo.jtc.generic.pageparams.toParams
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.IWithAttachments
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.interfaces.nullAccessTokens
import ooo.jtc.scripts.invoke
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.equalTo
import java.time.LocalDateTime

/**
 * Test template for checking each category by its associated statuses list
 *
 * @param steps - document steps; will be used for calling [getCategoriesCounts()]
 * @param category - list of categories and their respective statuses
 * @param sortBy - param to sort documents in definite order (e.g. DOCUMENT_NUMBER)
 * e.g. [zonedDateTime -> { LetterToBankFilterParams.CREATED_AT.le(<zonedDateTime>) }]
 * @param mapStatusToFilterDataFunction - (documentStatus)->(() -> FilterData) mapping function,
 * e.g. [{ { LetterToBankFilterParams.STATUS.eq(it.getStatus(user.userType)) } }]
 */
open class CategoryTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var category: Category<T>,
    var sortBy: List<Sort>,
    var mapStatusToFilterDataFunction: (IDocumentStatus<T>) -> (() -> FilterData),
    override val preExecution: (() -> T)?
) : AbstractBeTest<T, Unit>(
    name = "'${steps.entityName}'. Проверка категории [$category] [${steps.user.userType}]",
    params = {
        mapOf(
            PARAM_USER to steps.user,
            "Категория" to category,
            "Связанный список статусов" to category.getStatuses(steps.user.userType)
        )
    },
    testBody = {
        //TODO Sergeyev [2020.08.20]: идеальный вариант проверки, что пользователю доступны все
        // документы, которые должны быть ему доступны, - через получение ВСЕХ документов и фильтрацию по
        // доступным Клиентам / статусам. И в принципе это - истинно правильный способ проверять попадание
        // документов в категории, ОСОБЕННО в общую. Но для этого придётся лезть в БД
        val startTestTime = LocalDateTime.now().string(DEFAULT_DATETIME_FORMAT)
        /* используя этот фильтр, мы можем снизить влияние тестов друг на друга
        (чтобы параллельные тесты не хватали только что созданные документы других тестов)*/
        val startTestFilterData = FilterData(
            field = "createdAt",
            predicate = Predicate.LE,
            value = startTestTime,
            operands = null,
            type = OperandType.CONDITION
        )
        val getPageRequestFunc: (FilterData) -> GetPageRequest = { filterData ->
            IFilterParams.and(
                { filterData },
                { startTestFilterData }
            )
                .toParams(sort = sortBy)
                .toGetPageRequest()
        }

        val categoryPageRequest = getPageRequestFunc(category.getFilterData())
        val responseCategory = steps.getPage(categoryPageRequest)

        val statusOperands = category.getStatuses(steps.user.userType)
            .map(mapStatusToFilterDataFunction).toTypedArray()
        val statusesPageRequest = getPageRequestFunc(IFilterParams.or(*statusOperands))
        val responseStatuses = steps.getPage(statusesPageRequest)

        assertThat(
            "Количество документов в категории не совпадает с ожидаемым количеством для связанного списка статусов",
            responseCategory.size, equalTo(responseStatuses.size)
        )

        val categoryPage = responseCategory
            .page.getOrException("Ошибка при получении документов категории $category")
            .map { if (it is IWithAttachments<*>) it.attachments.nullAccessTokens()}
        val statusesPage = responseStatuses
            .page.getOrException("Ошибка при получении документов для статусов категории '${category}'")
            .map { if (it is IWithAttachments<*>) it.attachments.nullAccessTokens()}
        "Проверить, что данные, полученные по запросу категории, совпадают с данными по запросу статусов категории" {
            assertEqualList("Документы в категории $category", categoryPage, statusesPage)
        }
    }
)

/**
 * Test template for checking summary category count.
 *
 * @param steps - document steps; will be used for calling [getCategoriesCounts()]
 * @param ignoreCategories - list of categories' names(!).
 *                           Counters of these categories are ignored when checking 'ALL' category
 */
open class CategorySummaryCountTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var ignoreCategories: List<String> = emptyList(),
) : UnitBeTest(
    name = "'${steps.entityName}'. Проверка правильности включения документов в общую категорию [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, "Игнорируемые категории" to ignoreCategories) },
    testBody = {
        val response = steps.getCategoriesCounts()

        "Проверить, что общая категория корректно включает в себя все остальные категории" {
            val actResult = response
                .data.getOrException("Счётчики категорий не были получены")
                .toMutableMap()
            ignoreCategories.forEach { actResult.remove(it) }

            if (1 < actResult.size) {//[2020.07.22] на случай, когда доступна _только_ одна (ALL) категория
                val actSummaryCategoryCount: Int = actResult.values.maxOrNull()!!
                val expSummaryCategoryCount = actResult.values.sum() - actSummaryCategoryCount

                assertThat(
                    "Фактическое значение счётчика общей категории не совпадает с ожидаемым",
                    actSummaryCategoryCount, equalTo(expSummaryCategoryCount)
                )
            }
        }
    }
)

/**
 * Test template for checking available categories list.
 *
 * @param steps - document steps; will be used for calling [getCategoriesList()]
 * @param expCategories - expected list of categories
 */
open class CategoryListTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var expCategories: List<Category<T>>
) : UnitBeTest(
    name = "'${steps.entityName}'. Получение списка категорий [${steps.user.userType}]",
    params = { mapOf(PARAM_USER to steps.user, "Ожидаемый список категорий" to expCategories) },
    testBody = {
        val categoriesListResponse = steps.getCategoriesList()

        "Проверить, что полученный список категорий соответствует описанному в ТЗ" {
            val actResult = categoriesListResponse.data.getOrException("Список категорий не был получен")
            val expCategoriesNames = expCategories.map { it.category }

            assertThat(
                "Количество категорий не соответствует ожидаемому",
                actResult.size, equalTo(expCategories.size)
            )
            assertThat(
                "Список категорий не соответствует ожидаемому",
                actResult.map { it.name }, containsInAnyOrder(*expCategoriesNames.toTypedArray())
            )
        }
    }
)
