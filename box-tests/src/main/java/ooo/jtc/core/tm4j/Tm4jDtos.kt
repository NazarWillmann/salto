package ooo.jtc.core.tm4j

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonValue

/**
 * Test result dto for update test case in TM4J run.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Tm4jTestResult(
    var actualEndDate: String? = null,
    var actualStartDate: String? = null,
    var assignedTo: String? = null,
    var comment: String? = null,
    var customFields: Map<String, Any>? = null,
    var environment: String? = null,
    var executedBy: String? = null,
    var executionTime: Int? = null,
    var issueLinks: List<String>? = null,
    var scriptResults: List<StepResult>? = null,
    var status: Tm4jStatus = Tm4jStatus.FAIL
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class StepResult(
    /**
     * Step order number.
     */
    var index: Int,
    var comment: String?,
    var status: Tm4jStatus
)

enum class Tm4jStatus(@get:JsonValue val value: String) {
    NOT_EXECUTED("Not Executed"),
    IN_PROGRESS("In Progress"),
    PASS("Pass"),
    FAIL("Fail"),
    BLOCKED("Blocked"),
    PASS_ALL("Pass all"),
    FAIL_ALL("Fail all"),
    BLOCK_ALL("Block all"),

}

/**
 * Test case dto for create and update in TM4J.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Tm4jTestCase(
    var component: String? = null,
    var customFields: Map<String, Any>? = null,
    var estimatedTime: Int? = null,
    var folder: String? = null,
    var issueLinks: Set<String>? = null,
    var labels: List<String>? = null,
    var name: String? = null,
    var objective: String? = null,
    var owner: String? = null,
    var precondition: String? = null,
    var priority: String? = null,
    var projectKey: String? = null,
    var status: Tm4jTestCaseStatus? = Tm4jTestCaseStatus.Automated,
    var testScript: TestScript? = null
)

/**
 * Test scenario.
 */
data class TestScript(
    var steps: List<Step>,
    var type: TestScriptType
)

data class Step(
    var description: String,
    var expectedResult: String,
    var testData: String
)

enum class TestScriptType {
    STEP_BY_STEP,
    PLAIN_TEXT
}

enum class Tm4jTestCaseStatus {
    Draft,
    Approved,
    Deprecated,
    Automated,
    Need_AT
}

data class Tm4jTestCaseResult(val key: String?, var errorMessages: List<String>? = null)

data class Tm4jFolderCreate(
    val name: String,
    val projectKey: String,
    val type: Tm4jFolderType
)

enum class Tm4jFolderType {
    TEST_CASE,
    TEST_PLAN,
    TEST_RUN
}

data class Tm4jFolderResult(val id: String?, var errorMessages: List<String>? = null)