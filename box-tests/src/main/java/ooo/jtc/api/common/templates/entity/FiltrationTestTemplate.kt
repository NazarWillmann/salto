package ooo.jtc.api.common.templates.entity

import io.qameta.allure.Allure
import ooo.jtc.allure.testContainer
import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.scripts.invoke
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

/**
 * Base test for filtering entities
 *
 * @param steps  - steps for executing rest queries
 * @param checks - base entity checks for checking
 * @param filterRequestFunction - Function for creating filtering request
 * @param clazz - class of [IFilterParams] implementation for current entity
 *
 */
open class FiltrationTestTemplate<T : IEntityDto, F : IFilterParams<T>, RT : Any>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    var filterRequestFunction: (T?) -> FilterData,
    var clazz: Class<F>,
    override var name: String,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var preExecution: (() -> T)? = null
) : AbstractTest<T, T>(preExecution = preExecution) {

    var tempTestName = "'${steps.entityName}'. Фильтрация по полю $name. [${steps.user.userType}]"
    override fun name(): String = tempTestName

    /**
     * Generate filter request as [GetPageRequest] from filterRequestFunction and preconditionResult
     * Then consume list of entities, check than it not empty and check than is filtered correctly
     */
    override fun execution(preconditionResult: T?) {
        testResult = preconditionResult!!
        val filterData = filterRequestFunction.invoke(preconditionResult)
        setAllureName(steps, filterData)
        val filterRequest = GetPageRequest(params = Params(filter = Filter(filterData)))
        val actList = steps.getPage(filterRequest).page!!
        checks.checkFilter(actList, filterRequest, clazz)
    }

    private fun setAllureName(steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>, filterData: FilterData) {
        val name = "'${steps.entityName}'. Фильтрация по полю %s [${steps.user.userType}]"
            .format(getFilterPredicate(filterData))

        val lifecycle = Allure.getLifecycle()
        lifecycle.updateTestContainer(lifecycle.testContainer().uuid) { it.name = name }
        lifecycle.updateTestCase { it.name = name }
        tempTestName = name
    }

    /**
     * Retrieve filter description for filter data.
     */
    private fun getFilterPredicate(filterData: FilterData): String {
        return filterData.operands?.joinToString(" ${filterData.type?.value} ") { "'${it.field}' ${it.predicate?.value}" }
            ?: "'${filterData.field}' (${filterData.predicate?.value})"
    }

    override fun params(): Map<String, Any> {
        val filterRequest = try {
            filterRequestFunction.invoke(preconditionResult)
        } catch (e: KotlinNullPointerException) {
            val filterField = name.split(" ")[0]
            throw KotlinNullPointerException("Can't invoke filterRequestFunction for '$filterField'. '$filterField' is null in Data for filtration:\n$preconditionResult")
        }
        return mapOf(
            PARAM_USER to steps.user,
            "Объект фильтрации" to steps.entityName,
            "Запрос фильтра" to filterRequest
        )
    }
}

/**
 * Test template for checking available categories list.
 *
 * @param steps - document steps; will be used for calling [getCount()]
 * @param filter - expected list of categories
 */
open class FiltrationCountTestTemplate<T : IDocument>(
    var steps: AbstractDocumentSteps<T, out UpdateIDocument<T>>,
    var filter: Filter
) : UnitBeTest(
    name = "this is shadowed",
    params = { mapOf(PARAM_USER to steps.user, "Фильтр" to filter) },
    testBody = {
        val countResponse = steps.getCount(filter)

        "Проверить, что полученное количество соответствует количеству getPage() от того же фильтра" {
            val expResult = steps.getPage(filter.toPageRequest())

            assertThat("Фактическое и ожидаемое количества не совпали", countResponse.count, equalTo(expResult.size!!))
        }
    }
) {
    private val filterFields = filter.data.operands?.let { operandList ->
        operandList
            .mapNotNull { it.field }
            .reduce { s1, s2 -> "$s1, $s2" }
    }
    var tempTestName = "'${steps.entityName}'. " +
            "Получение количества документов по фильтру (${filterFields ?: filter.data.field}) [${steps.user.userType}]"

    override fun name(): String = tempTestName
}