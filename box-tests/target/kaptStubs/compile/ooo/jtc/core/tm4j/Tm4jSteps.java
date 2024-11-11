package ooo.jtc.core.tm4j;

import java.lang.System;

/**
 * TM4J API.
 * https://docs.adaptavist.io/tm4j/server/api/v1/
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u000eJD\u0010\u0017\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J<\u0010#\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\'\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006+"}, d2 = {"Looo/jtc/core/tm4j/Tm4jSteps;", "", "()V", "api", "Looo/jtc/core/api/CoreApi;", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "createFolder", "Looo/jtc/core/tm4j/Tm4jFolderResult;", "folderName", "", "folderType", "Looo/jtc/core/tm4j/Tm4jFolderType;", "createTestCase", "Looo/jtc/core/tm4j/Tm4jTestCaseResult;", "payload", "Looo/jtc/core/tm4j/Tm4jTestCase;", "findTestCaseByName", "tesCaseName", "searchTestCases", "", "", "query", "maxResults", "", "archived", "", "fields", "updateTestCase", "", "testCaseKey", "updateTestExecution", "testRunKey", "updateDto", "Looo/jtc/core/tm4j/Tm4jTestResult;", "testName", "error", "", "explicitCustomFields", "box-tests"})
public final class Tm4jSteps {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    private final ooo.jtc.core.api.CoreApi api = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0422\u041a \u0432 TM4J")
    public final ooo.jtc.core.tm4j.Tm4jTestCaseResult createTestCase(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jTestCase payload) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0431\u043d\u043e\u0432\u0438\u0442\u044c \u0422\u041a \u0432 TM4J")
    public final void updateTestCase(@org.jetbrains.annotations.NotNull()
    java.lang.String testCaseKey, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jTestCase payload) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041f\u0430\u043f\u043a\u0443 \u0432 TM4J")
    public final ooo.jtc.core.tm4j.Tm4jFolderResult createFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String folderName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jFolderType folderType) {
        return null;
    }
    
    /**
     * The query syntax is similar to the JIRA JQL.
     * Available fields: projectKey, key, name, status, priority, component, folder, estimatedTime, labels, owner and custom fields.
     * When filtering by custom fields, the field name must be quoted.
     * Available operators: =, >, >=, <, <=, IN
     * For Single and Multi Choice custom fields, operator "=" is not supported, use "IN" instead
     * Available logical operators: AND
     *
     * For more details see https://docs.adaptavist.io/tm4j/server/api/v1/ [/testcase/search] GET
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0422\u041a \u0438\u0437 TM4J")
    public final java.util.List<java.util.Map<java.lang.String, java.lang.Object>> searchTestCases(@org.jetbrains.annotations.NotNull()
    java.lang.String query, int maxResults, boolean archived, @org.jetbrains.annotations.Nullable()
    java.lang.String fields) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String findTestCaseByName(@org.jetbrains.annotations.NotNull()
    java.lang.String tesCaseName) {
        return null;
    }
    
    /**
     * Main use function for update result from dynamic test.
     */
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0441\u0442\u0430\u0432\u0438\u0442\u044c \u0440\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442 \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u044f \u0442\u0435\u0441\u0442\u0430 {testCaseKey}")
    public final void updateTestExecution(@org.jetbrains.annotations.Nullable()
    java.lang.String testCaseKey, @org.jetbrains.annotations.NotNull()
    java.lang.String testName, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable error, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> explicitCustomFields) {
    }
    
    /**
     * TM4J API function.
     * Update test execution (specific [testCaseKey] in specific [testRunKey] ).
     */
    public final void updateTestExecution(@org.jetbrains.annotations.NotNull()
    java.lang.String testRunKey, @org.jetbrains.annotations.NotNull()
    java.lang.String testCaseKey, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jTestResult updateDto) {
    }
    
    public Tm4jSteps() {
        super();
    }
}