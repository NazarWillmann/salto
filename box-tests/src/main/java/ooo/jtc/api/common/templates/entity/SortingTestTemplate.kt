package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Paging
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto

/**
 * Base test for filtering entities
 *
 * @param steps  - steps for executing rest queries
 * @param checks - base entity checks for checking sorting
 * @param sortList - sorting list for creating sorting request
 * @param filter - filter for creating sorting request. Use `[IFilterParams].contains("")`, when you need to filter non-null field.
 * @param limit - paging limit for creating sorting request
 * @param clazz - class of [ISortingParams] implementation for current entity
 */
open class SortingTestTemplate<T : IEntityDto, F : ISortingParams<T>, R : Any>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    var filter: Filter? = null,
    var sortList: List<Sort>,
    var clazz: Class<F>,
    var limit: Int = 100,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var name: String = "'${steps.entityName}'. Сортировка по полю %s%s [${steps.user.userType}]"
        .format(
            sortList.joinToString { "'${it.field}, ${it.direction}'" },
            filter?.let { " с фильтром по '${it.data.field}'" } ?: ""
        )
) : AbstractTest<Any, R>() {

    override fun execution(preconditionResult: Any?) {
        val sortingRequest = GetPageRequest(params = Params(filter = filter, sort = sortList, paging = Paging(0, limit)))
        val list = steps.getPage(sortingRequest).page!!
        checks.checkSorting(list, sortingRequest, clazz, steps.service.db)
    }

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user, "Объект сортировки" to steps.entityName,
            "Параметры сортировки" to sortList
        )
    }
}