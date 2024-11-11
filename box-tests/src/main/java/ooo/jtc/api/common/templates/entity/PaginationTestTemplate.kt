package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.checks.ApiEntityChecks
import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.api.common.steps.AbstractEntitySteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.generic.pageparams.Paging
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.toGetPageRequest
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.scripts.invoke

/**
 * Base test for pagination entities
 *
 * @param steps  - steps for executing rest queries
 * @param checks - base entity checks for checking sorting
 * //TODO A.Stykalin [18.06.2020] update
 *
 */
open class PaginationTestTemplate<T : IEntityDto, S : ISortingParams<T>>(
    var steps: AbstractEntitySteps<T, out UpdateIEntityDto<T>>,
    var createRecord: () -> T,
    var limit: Int = 5,
    var sortParam: S,
    private var checks: ApiEntityChecks<T> = ApiEntityChecks(),
    override var name: String = "'${steps.entityName}'. Проверка пагинации [${steps.user.userType}]",
    final override var preExecution: (() -> Any)? = {
        val size = steps.getPage().size!!
        if (size < limit) {
            val needToCreate = limit - size
            repeat(needToCreate) { createRecord.invoke() }
        }
    },
    override var postExecution: ((Any) -> Unit)? = null
) : AbstractTest<Any, Any>(preExecution = preExecution, postExecution = postExecution) {

    override fun execution(preconditionResult: Any?) {
        val sortList = sortParam.asc()
        val params = Params(sort = sortList, paging = Paging(0, limit))

        val expList = "Получить список с общим лимитом $limit" { steps.getPage(params.toGetPageRequest()).page!! }.output!!

        val firstOffset = 1
        val firstLimit: Int = limit / 2
        "Проверка пагинации с оффсетом $firstLimit" {
            val pageRequestOne = params.copy(paging = Paging(firstOffset, firstLimit)).toGetPageRequest()
            val actPagingList = steps.getPage(pageRequestOne).page!!
            checks.checkPagination(expList, actPagingList, firstOffset, firstLimit)
        }
        val secondOffset = firstOffset + firstLimit
        val secondLimit = limit - secondOffset
        "Проверка пагинации с оффсетом $secondOffset" {
            val pageRequestTwo = params.copy(paging = Paging(secondOffset, secondLimit)).toGetPageRequest()
            val actPagingList = steps.getPage(pageRequestTwo).page!!
            checks.checkPagination(expList, actPagingList, secondOffset, secondLimit)
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            "Параметр сортировки" to sortParam,
            "Размер выборки" to limit
        )
    }
}