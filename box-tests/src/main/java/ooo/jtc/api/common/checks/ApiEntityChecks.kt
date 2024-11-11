package ooo.jtc.api.common.checks

import io.qameta.allure.Step
import io.qameta.allure.model.Status
import ooo.jtc.allure.AllureUtils.setStepStatus
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.core.TestConstants.SORT_CONTROL_IGNORE
import ooo.jtc.db.DbExecutorJdbi
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.NOT_CHECKED
import ooo.jtc.documents.ControlCheckResult.VALID
import ooo.jtc.extensions.asserts.assertEq
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.deduplication
import ooo.jtc.generic.CheckResult
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.generic.ValidationResultDto
import ooo.jtc.generic.pageparams.Direction
import ooo.jtc.generic.pageparams.Direction.ASC
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Operand
import ooo.jtc.generic.pageparams.OperandType
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.logging.logComparison
import ooo.jtc.random.RandomData
import ooo.jtc.scripts.invoke
import ooo.jtc.serialization.SerializationUtils.OBJECT_MAPPER
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.empty
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import java.util.*
import java.util.Objects.nonNull


/**
 * Base asserts than can be applied for Entity
 */
open class ApiEntityChecks<T : IEntityDto> {
    protected val log by LoggerDelegate()

    /**
     * Check that received from service list of [entities] are filtered correctly.
     */
    @Step("Проверяем фильтрацию в ответе")
    fun <R : IFilterParams<T>> checkFilter(
        entities: List<T>,
        getPageRequest: GetPageRequest,
        filterParamsClass: Class<out R>
    ) {
        assertThat(entities, not(empty()))
        entities.forEach { checkOperands(it, getPageRequest.params.filter!!.data, filterParamsClass) }
    }

    @Step("Проверяем, что запись с id = '{entity.id}' удовлетворяет условиям фильтрации")
    fun <R : IFilterParams<T>> checkOperands(entity: T, filterData: FilterData, filterParamsClass: Class<out R>) {

        val operands = if (!filterData.operands.isNullOrEmpty()) {
            filterData.operands
        } else {
            listOf(
                Operand(
                    field = filterData.field,
                    type = filterData.type,
                    value = filterData.value,
                    predicate = filterData.predicate
                )
            )
        }

        when (filterData.type) {
            OperandType.AND -> operands!!.forEach { operand -> checkOperand(entity, operand, filterParamsClass) }
            OperandType.OR -> {
                var checkResult = false
                operands!!.forEach { operand ->
                    run {
                        val checkOperandResult = checkOperand(entity, operand, filterParamsClass, softAssert = true)
                        if (checkOperandResult) {
                            checkResult = true
                        }
                    }
                }
                assertThat("Одна из проверок по фильтру пройдена", checkResult)
            }
            else -> operands!!.forEach { operand -> checkOperand(entity, operand, filterParamsClass) }
        }
    }

    @Step("Проверяем, что запись с id = '{entity.id}'  {operand.predicate}  '{operand.value}'")
    private fun <R : IFilterParams<T>> checkOperand(
        entity: T,
        operand: Operand,
        filterParamsClass: Class<out R>,
        softAssert: Boolean = false
    ): Boolean {
        val predicate = operand.predicate
        val fieldGetter = IFilterParams.findByFiledName(operand.field!!, filterParamsClass)
        when (predicate) {
            Predicate.CONTAINS -> {
                check(entity, fieldGetter, Matchers::containsStringIgnoringCase, operand, softAssert)
            }
            Predicate.GE -> {
                check<T, Comparable<Any>>(entity, fieldGetter, Matchers::greaterThanOrEqualTo, operand, softAssert)
            }
            Predicate.LE -> {
                check<T, Comparable<Any>>(entity, fieldGetter, Matchers::lessThanOrEqualTo, operand, softAssert)
            }
            Predicate.EQ -> {
                check<T, Any>(entity, fieldGetter, Matchers::equalTo, operand, softAssert)
            }
        }
        return true
    }


    @Suppress("UNCHECKED_CAST")
    private fun <T : IEntityDto, R> check(
        entity: T,
        fieldGetter: IFilterParams<T>,
        matcherProvider: (R) -> Matcher<R>,
        operand: Operand,
        softAssert: Boolean
    ): Boolean {
        val actualValue = fieldGetter.fieldDataProvider.invoke(entity) as R
        var expectedValue = operand.value as R

        if (expectedValue is String) {
            expectedValue = filtrationStringHandling(expectedValue) as R
        }

        val matcher = matcherProvider.invoke(expectedValue)
        if (softAssert) {
            val matches = matcher.matches(actualValue)
            if (!matches) {
                setStepStatus(status = Status.FAILED)
            }
            return matches
        } else {
            assertThat(actualValue, matcher)
        }
        return true
    }

    @Step("Проверяем, что в записи есть id")
    fun checkIdExist(response: GenericResponseDto<T>): UUID {
        assertThat(response.data!!.id, notNullValue())
        return response.data!!.id!!
    }

    @Step("Проверяем, что сущность успешно создана/обновлена")
    fun checkRequestResponseValid(expectedEntity: T, actualResponse: GenericResponseDto<T>, expResult: ControlCheckResult = VALID) {
        actualResponse.validationResult?.result?.let { actResult: ControlCheckResult ->
            if (expResult != actResult) {
                val unExpResults = actualResponse.validationResult?.groupResults
                    ?.filter { it.result != expResult }
                    ?.flatMap { it.controlResults }
                    ?.filter { it.result != expResult && it.result != NOT_CHECKED }
                    ?.joinToString("\n") { (OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(it)) }
                unExpResults?.let { log.warn("\n$it") }
                unExpResults?.attachToAllure("unExpResults")
            }
            actResult.assertEq(expResult)
        }
        assertObjectsEqual(expectedEntity, actualResponse.data!!)
    }

    @Step("Проверяем, что сущность успешно удалена")
    fun checkRemoved(preparedDto: T, deletedResponse: GenericResponseDto<T>) {
        assertObjectsEqual(preparedDto, deletedResponse.data!!)
    }

    @Step("Проверяем, что сущность успешно обновлена")
    fun checkUpdated(preparedDto: T, updatedResponse: GenericResponseDto<T>) {
        assertObjectsEqual(preparedDto, updatedResponse.data!!)
    }


    @Step("Проверяем, что список сущностей отсортирован")
    fun <F : ISortingParams<T>> checkSorting(entities: List<T>, pageRequest: GetPageRequest, clazz: Class<F>, dbExecutor: DbExecutorJdbi) {
        assertThat(entities, not(empty()))
        val sort = pageRequest.params.sort?.get(0)!!
        val sortField = sort.field
        val dir = sort.direction ?: ASC
        val sortParams = clazz.enumConstants
        val sortParam =
            sortParams.find { it.field == sortField }
                ?: throw RuntimeException("$sortField not found in $sortParams")

        val actValueList = entities.map { sortParam.fieldDataProvider.invoke(it) }
        "Проверить, что список элементов для проверки сортировки содержит минимум $REQUIRED_DATA_COUNT элемента" {
            assertThat(
                "Не найдено ($REQUIRED_DATA_COUNT) значений '${sortParam.field}' для проверки сортировки",
                actValueList.filterNotNull().size >= REQUIRED_DATA_COUNT
            )
        }
        actValueList.joinToString("\n").attachToAllure("actValueList")
        checkSortList(dir, actValueList, dbExecutor)
    }

    @Suppress("UNCHECKED_CAST")
    fun checkSortList(dir: Direction, actualValues: List<Any?>, dbExecutor: DbExecutorJdbi) {
        val expectedValues = if (actualValues.first { it != null } is String) {
            sortUsingPsotgreSql(dir, actualValues as List<String>, dbExecutor)
        } else {
            val selector: (Any?) -> Comparable<*>? = {
                when (it) {
                    is Enum<*> -> it.name
                    is UUID -> it.toString()
                    else -> it
                } as Comparable<*>?
            }
            val sortedAsc = actualValues.sortedWith(nullsFirst(compareBy(selector)))
            if (dir == ASC) sortedAsc else sortedAsc.reversed()
        }
        logComparison(actualValues, expectedValues)
        assertThat(actualValues, CoreMatchers.equalTo(expectedValues))
    }

    private fun sortUsingPsotgreSql(dir: Direction, values: List<String?>, dbExecutor: DbExecutorJdbi): List<String?> {
        val escapeTag = RandomData.latinWord.random(length = 6)
        // Замена специальных JDBI символов на следующие по порядку сортировки.
        // '?', ':' - байндинг параметров
        // "<foo>" - шаблоны
        // '\' - символ экранирования удаляется JDBI
        val replaceBindingsMap = mutableMapOf<String, String>()
        values.forEach {
            if (it != null && !replaceBindingsMap.contains(it))
                replaceBindingsMap[it] = it.replace(':', ';')
                    .replace('?', '@')
                    .replace('<', '=')
                    .replace('\\', '[')
        }
        val sqlValues = values.asSequence()
            .map {
                "(${if (it == null) "NULL" else "$$escapeTag$${replaceBindingsMap[it]}$$escapeTag$"})"
            }
            .joinToString(", ")
        val sortedValues = mutableListOf<String?>()
        dbExecutor.execSql(
            sql = "SELECT c FROM (VALUES $sqlValues) AS t(c) " +
                    "ORDER BY c $dir NULLS ${if (ASC == dir) "FIRST" else "LAST"};",
            modelClass = String::class.java
        ).forEach { sortedValue ->
            val value = sortedValue?.let { replaceBindingsMap.entries.first { it.value == sortedValue }.key }
            sortedValues.add(value)
        }
        return sortedValues
    }

    @Step("Проверяем, что сущность получена")
    fun checkConsumeEntity(expDto: T, genericResponse: GenericResponseDto<T>) {
        assertThat(genericResponse.validationResult, nullValue())
        assertObjectsEqual(expDto, genericResponse.data!!)
    }

    @Step("Проверяем, что сущность не найдена")
    fun checkNotFound(response: GenericResponseDto<T>) {
        assertThat(response.code, equalTo(404))
        assertThat(response.message, containsString(" not found"))
    }

    @Step("Проверяем, что произошла ошибка")
    fun checkErrorResponse(response: GenericResponseDto<T>, expectedCode: Int = 500, expectedMessage: String) {
        assertThat(response.code, equalTo(expectedCode))
        assertThat(response.message, containsString(expectedMessage))
        assertThat(response.data, nullValue())
        assertThat(response.validationResult, nullValue())
    }

    @Step("Проверяем список записей из ответа")
    fun checkPageResponse(pageResponse: GenericPageResponseDto<T>) {
        assertThat(pageResponse.page, not(empty()))
        assertThat(pageResponse.size!!, greaterThanOrEqualTo(pageResponse.page!!.size))
    }

    @Step("Проверить контроль на поле {expCheckResult.fieldName}")
    fun checkControl(expCheckResult: CheckResult, responseDto: GenericResponseDto<T>) {
        responseDto.validationResult!!.checks.assertIsNotEmpty()
        val actCheckResult = responseDto.validationResult!!.checks!!
            .filter { it.fieldName == expCheckResult.fieldName }
            .filter { it.message?.message == expCheckResult.message!!.message }
        if (actCheckResult.isEmpty())
            throw AssertionError("В результатах проверки контролей не найдено проверки на поле ${expCheckResult.fieldName}")

        assertObjectsEqual(expCheckResult, actCheckResult[0])
    }

    @Step("Проверить сработавший контроль согласно иерархии вложенности")
    fun checkNestedControl(expValidationResult: ValidationResultDto, actValidationResult: ValidationResultDto?) {
        //1. Check _validation_ result
        assertThat("Отсутствует результат общей валидации 'validationResult'", null != actValidationResult)
        assertThat(
            "Результат валидации 'validationResult.result' не совпадет с ожидаемым",
            actValidationResult!!.result, equalTo(expValidationResult.result)
        )
        //2. Find and check _group_ result
        val expGroupResult = expValidationResult.groupResults!!.first()
        assertThat("Отсутствует список групп контролей 'groupResults'", actValidationResult.groupResults, notNullValue())
        val actGroupResult = actValidationResult.groupResults!!.firstOrNull { actGroupResult ->
            val idMatches = expGroupResult.id == actGroupResult.id
            val nameMatches = expGroupResult.name == actGroupResult.name
            if (nonNull(expGroupResult.id) && nonNull(expGroupResult.name)) {
                return@firstOrNull idMatches && nameMatches
            }
            if (nonNull(expGroupResult.id)) {
                return@firstOrNull idMatches
            }
            if (nonNull(expGroupResult.name)) {
                return@firstOrNull nameMatches
            }
            return@firstOrNull false
        }
        assertThat("Не найдена ожидаемая группа контролей 'groupResults' (id:'${expGroupResult.id}')", actGroupResult, notNullValue())
        assertThat(
            "Результат проверки группы контролей 'groupResults.result' (id:'${expGroupResult.id}') не совпадает с ожидаемым",
            actGroupResult!!.result, equalTo(expGroupResult.result)
        )
        //3. Find and check _control_ result
        val expControlResult = expGroupResult.controlResults.first()
        val actControlResult = actGroupResult.controlResults.firstOrNull { actControlResult ->
            if (expControlResult.id.isNullOrBlank() && actControlResult.id.isNullOrBlank()) {
                val expectedFieldsAndMessages = expControlResult.checkResults.associate {
                    it.fieldName to it.message?.message
                }
                val controlResultPresent = actControlResult.checkResults.firstOrNull {
                    expectedFieldsAndMessages[it.fieldName] == it.message?.message
                }
                return@firstOrNull nonNull(controlResultPresent)
            }
            return@firstOrNull expControlResult.id == actControlResult.id
        }

        assertThat("Не найден ожидаемый контроль 'controlResult'", actControlResult, notNullValue())
        assertThat(
            "Результат проверки контроля 'controlResult.result' (id:'${expControlResult.id}') не совпадает с ожидаемым",
            actControlResult!!.result, equalTo(expControlResult.result)
        )
        //3.1. If control should not be checked - then it will have no check result
        if (NOT_CHECKED == expControlResult.result) return

        //4. Check _check_ result
        val expCheckResult = expControlResult.checkResults.first()
        if (null != expCheckResult.subResults) {
            //4.a If subResults are expected - initiate nested check with new validationResults
            val actCheckResult = actControlResult.checkResults
                .firstOrNull { null != it.subResults }
            assertThat("Не найдена ожидаемая проверка 'checkResult' со вложенным результатом валидации", actCheckResult, notNullValue())
            assertThat("Вложенный результат проверки 'subResults' оказался пустым", actCheckResult!!.subResults, notNullValue())
            checkNestedControl(expCheckResult.subResults!!.first(), actCheckResult.subResults!!.first())
        } else {
            //4.b Find and check _check_ result by specified 'message'
            val actCheckResult = actControlResult.checkResults
                .firstOrNull { expCheckResult.message!!.message == it.message?.message }
            assertThat(
                "Не найдена ожидаемая проверка 'checkResult' (by nested message:'${expCheckResult.message!!.message}')",
                actCheckResult, notNullValue()
            )
            assertObjectsEqual(expCheckResult, actCheckResult!!)
        }
    }

    @Step("Проверить сработавший контроль справочника согласно иерархии вложенности")
    fun checkNestedDictionaryControl(expValidationResult: ValidationResultDto, actValidationResult: ValidationResultDto?) {
        //1. Check _validation_ result
        assertThat("Отсутствует результат общей валидации 'validationResult'", null != actValidationResult)
        assertThat(
            "Результат валидации 'validationResult.result' не совпадет с ожидаемым",
            actValidationResult!!.result, equalTo(expValidationResult.result)
        )
        //2. Find and check _group_ result
        val expGroupResult = expValidationResult.groupResults!!.first()
        assertThat("Отсутствует список групп контролей 'groupResults'", actValidationResult.groupResults, notNullValue())
        val actGroupResult = actValidationResult.groupResults!!.firstOrNull { expGroupResult.name == it.name }
        assertThat("Не найдена ожидаемая группа контролей 'groupResults' (name:'${expGroupResult.name}')", actGroupResult, notNullValue())
        assertThat(
            "Результат проверки группы контролей 'groupResults.result' (name:'${expGroupResult.name}') не совпадает с ожидаемым",
            actGroupResult!!.result, equalTo(expGroupResult.result)
        )
        //3. Find and check _control_ result
        val expControlResult = expGroupResult.controlResults.first()
        val actControlResult = actGroupResult.controlResults.firstOrNull { expControlResult.name == it.name }
        assertThat("Не найден ожидаемый контроль 'controlResult'", actControlResult, notNullValue())
        assertThat(
            "Результат проверки контроля 'controlResult.result' (name:'${expControlResult.name}') не совпадает с ожидаемым",
            actControlResult!!.result, equalTo(expControlResult.result)
        )
        //3.1. If control should not be checked - then it will have no check result
        if (NOT_CHECKED == expControlResult.result) return

        //4. Check _check_ result
        val expCheckResult = expControlResult.checkResults.first()
        if (null != expCheckResult.subResults) {
            //4.a If subResults are expected - initiate nested check with new validationResults
            val actCheckResult = actControlResult.checkResults
                .firstOrNull { null != it.subResults }
            assertThat("Не найдена ожидаемая проверка 'checkResult' со вложенным результатом валидации", actCheckResult, notNullValue())
            assertThat("Вложенный результат проверки 'subResults' оказался пустым", actCheckResult!!.subResults, notNullValue())
            checkNestedControl(expCheckResult.subResults!!.first(), actCheckResult.subResults!!.first())
        } else {
            //4.b Find and check _check_ result by specified 'message'
            val actCheckResult = actControlResult.checkResults
                .firstOrNull { expCheckResult.message!!.message == it.message?.message }
            assertThat(
                "Не найдена ожидаемая проверка 'checkResult' (by nested message:'${expCheckResult.message!!.message}')",
                actCheckResult, notNullValue()
            )
            assertObjectsEqual(expCheckResult, actCheckResult!!)
        }
    }

    @Step("Проверить корректность пагинации")
    fun checkPagination(expAllList: List<T>, actPagingList: List<T>, offset: Int, limit: Int) {
        val endElement = offset + limit
        val expPagingList = expAllList.subList(offset, endElement)

        assertThat(expPagingList.size, equalTo(actPagingList.size))

        val pairList = expPagingList.zip(actPagingList)
        pairList.forEach { (entity1, entity2) ->
            assertObjectsEqual(entity1, entity2)
        }
    }

    companion object {
        private const val POSTGRES_IGNORE_SYMBOLS = "[ \\\\.:;'`,\\-()_/#+=\\[\\]?@<>«^»$SORT_CONTROL_IGNORE]"
    }

    /**
     * List of transform functions for sorting string.
     */
    private val sortStringTransform = listOf<(String?) -> String?>(
        { it?.replace(POSTGRES_IGNORE_SYMBOLS.toRegex(), "") },
        { it?.deduplication("\"") },
        { it?.replace("Å", "A") },
        { it?.replace("№", "N") },
        { it?.replace("€", "&€") },//TODO Sergeyev [2020.10.06]: ?strange sorting order
        // http://www.asciitable.com/
        { it?.trim() }
    )

    /**
     * Handling for string in sorting checks.
     */
    private fun sortStringHandling(expectValue: String?): String? {
        var result = expectValue
        sortStringTransform.forEach {
            result = it.invoke(result)
        }
        return result
    }

    private val filtrationStringTransform = listOf<(String) -> String>(
        { it.replace("^_+".toRegex(), "") },
        { it.replace("_+$".toRegex(), "") }
    )

    /**
     * Handling for string in filtration checks.
     */
    private fun filtrationStringHandling(expectValue: String): String {
        var result = expectValue
        filtrationStringTransform.forEach {
            result = it.invoke(result)
        }
        return result
    }

    @Step("Проверить, что документ добавлен в избранное")
    fun checkAddFavorites(responseDto: GenericResponseDto<T>, retrieveIsFavorites: (T) -> Boolean) {
        val favoriteDto = responseDto.data
        favoriteDto ?: throw RuntimeException("Ошибка при добавлении в избранное")
        assertThat("Документ не в избранном", retrieveIsFavorites.invoke(favoriteDto))
    }

    @Step("Проверить, что документ удален из избранного")
    fun checkRemoveFromFavorites(responseDto: GenericResponseDto<T>, retrieveIsFavorites: (T) -> Boolean) {
        val favoriteDto = responseDto.data
        favoriteDto ?: throw RuntimeException("Ошибка при удалении из избранного")
        assertThat("Документ не в избранном", !retrieveIsFavorites.invoke(favoriteDto))
    }
}

