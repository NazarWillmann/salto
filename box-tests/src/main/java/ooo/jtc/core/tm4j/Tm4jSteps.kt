package ooo.jtc.core.tm4j

import io.qameta.allure.Step
import ooo.jtc.core.api.CoreApi
import ooo.jtc.core.api.responseAs
import ooo.jtc.core.applicationProperties
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.logging.LoggerDelegate
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import java.time.LocalDate


private val testRunKey by lazy { System.getProperty("testRun") }

private val baseUrl: String by lazy { applicationProperties.tms.host }
private val user: String by lazy { applicationProperties.tms.user }
private val userId: String by lazy { applicationProperties.tms.userId }
private val pass: String by lazy { applicationProperties.tms.password }

/**
 * TM4J API.
 * https://docs.adaptavist.io/tm4j/server/api/v1/
 */
class Tm4jSteps {
    private val log by LoggerDelegate()
    private val api = CoreApi(baseUrl).withBaseAuth(user, pass)


    @Step("Создать ТК в TM4J")
    fun createTestCase(payload: Tm4jTestCase): Tm4jTestCaseResult {
        val path = "/testcase"
        return try {
            api.send(
                method = {
                    body(payload)
                    post(path)
                },
                check = { assertThat("Wrong response code", statusCode(), Matchers.equalTo(201)) })
                .responseAs(Tm4jTestCaseResult::class.java)
        } catch (ex: Throwable) {
            log.error("Error while creating test case (${payload.name}) in TM4J.", ex)
            Tm4jTestCaseResult("error")
        }
    }

    @Step("Обновить ТК в TM4J")
    fun updateTestCase(testCaseKey: String, payload: Tm4jTestCase) {
        val path = "/testcase/$testCaseKey"
        try {
            api.send(
                method = {
                    body(payload)
                    put(path)
                },
                check = { assertThat("Wrong response code", statusCode(), Matchers.equalTo(200)) })
        } catch (ex: Throwable) {
            log.error("Error while updating test case ($testCaseKey) in TM4J.", ex)
        }
    }

    @Step("Создать Папку в TM4J")
    fun createFolder(folderName: String, folderType: Tm4jFolderType = Tm4jFolderType.TEST_CASE): Tm4jFolderResult {
        val payload = Tm4jFolderCreate(folderName, applicationProperties.tms.project, folderType)
        val path = "/folder"
        return try {
            api.send(
                method = {
                    body(payload)
                    post(path)
                }).responseAs(Tm4jFolderResult::class.java)
        } catch (ex: Throwable) {
            log.error("Error while creating test case (${payload.name}) in TM4J.", ex)
            Tm4jFolderResult("error")
        }
    }

    /**
     *The query syntax is similar to the JIRA JQL.
     * Available fields: projectKey, key, name, status, priority, component, folder, estimatedTime, labels, owner and custom fields.
     * When filtering by custom fields, the field name must be quoted.
     * Available operators: =, >, >=, <, <=, IN
     * For Single and Multi Choice custom fields, operator "=" is not supported, use "IN" instead
     * Available logical operators: AND
     *
     * For more details see https://docs.adaptavist.io/tm4j/server/api/v1/ [/testcase/search] GET
     */
    @Step("Найти ТК из TM4J")
    fun searchTestCases(query: String, maxResults: Int = 100, archived: Boolean = false, fields: String? = null): List<Map<String, Any?>> {
        val path = "/testcase/search"
        return try {
            api.send(
                method = {
                    fields?.let { queryParam("fields", fields) }
                    queryParam("archived", archived)
                    queryParam("maxResults", maxResults)
                    queryParam("query", "projectKey = \"${applicationProperties.tms.project}\" AND $query")
                    get(path)
                },
                check = { assertThat("Wrong response code", statusCode(), Matchers.equalTo(200)) })
                .responseAs<List<Map<String, Any?>>>(mutableListOf<Map<String, Any?>>()::class.java)
        } catch (ex: Throwable) {
            log.error("Error while search test cases from TM4J.", ex)
            listOf()
        }
    }


    fun findTestCaseByName(tesCaseName: String): String? {
        val safeTesCaseName = tesCaseName.replace("'", "\\'")
        return searchTestCases("name = \"$safeTesCaseName\"", fields = "name,key").ifNotEmpty { it.first()["key"].toString() }
    }

    /**
     * Main use function for update result from dynamic test.
     */
    @Step("Проставить результат выполнения теста {testCaseKey}")
    fun updateTestExecution(testCaseKey: String?, testName: String, error: Throwable?, explicitCustomFields: Map<String, Any>? = null) {

        if (testCaseKey.isNullOrBlank()) {
            log.error("testCaseKey is null or blank. Test '$testName' not updated in TM4J.")
            return
        }
        if (testRunKey.isNullOrBlank()) {
            log.error("testRunKey is null or blank.  Test '$testName' ($testCaseKey) not updated in TM4J.")
            return
        }

        val customFields: MutableMap<String, Any> = mutableMapOf("Allure" to "${System.getenv("BUILD_URL")}allure/")
        explicitCustomFields?.let { customFields.putAll(it) }

        val executionDate = LocalDate.now()
        val testResult = Tm4jTestResult(
            executedBy = userId,
            actualStartDate = executionDate.toString(),
            actualEndDate = executionDate.toString(),
            customFields = customFields
        )

        when (error) {
            null -> updateTestExecution(testRunKey, testCaseKey, testResult.apply { this.status = Tm4jStatus.PASS })
            else -> updateTestExecution(testRunKey, testCaseKey, testResult)
        }

    }

    /**
     * TM4J API function.
     * Update test execution (specific [testCaseKey] in specific [testRunKey] ).
     */
    fun updateTestExecution(testRunKey: String, testCaseKey: String, updateDto: Tm4jTestResult) {
        val path = "/testrun/$testRunKey/testcase/$testCaseKey/testresult"
        try {
            api.send(
                method = {
                    body(updateDto)
                    put(path)
                },
                check = { assertThat("Wrong response code", statusCode(), Matchers.equalTo(200)) })
        } catch (ex: Throwable) {
            log.error("Error while updating test ($testCaseKey) in TM4J run ($testRunKey).", ex)
        }
    }

}