package ooo.jtc.core;

import java.lang.System;

/**
 * Object for generating JUnit Dynamic tests from
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\"\u0010\b\u0000\u0010\u0014*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\u0016\"\u0002H\u0014\u00a2\u0006\u0002\u0010\u0017J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\"\u0010\b\u0000\u0010\u0014*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0019JB\u0010\u001a\u001a\u00020\f\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J0\u0010 \u001a\u00020\u001f\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000eH\u0002J\u0018\u0010!\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J0\u0010$\u001a\u00020#\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000eH\u0002JB\u0010%\u001a\u00020\f\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J8\u0010&\u001a\u00020\f\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J:\u0010\'\u001a\u00020\f\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0010H\u0002J.\u0010(\u001a\u00020\u0013\"\b\b\u0000\u0010\u001b*\u00020\u0001\"\b\b\u0001\u0010\u001c*\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u000eJ\"\u0010)\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006*"}, d2 = {"Looo/jtc/core/EntityTestGenerator;", "", "()V", "MAX_RETRY", "", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "createOrUpdateTm4jTestCase", "", "test", "Looo/jtc/api/common/tests/AbstractTest;", "error", "", "generate", "", "Lorg/junit/jupiter/api/DynamicTest;", "T", "tests", "", "([Looo/jtc/api/common/tests/AbstractTest;)Ljava/util/List;", "testList", "", "postExecution", "RP", "RT", "rootCause", "currentTestCaseId", "", "processAllureInfo", "saveFailedIdForRetry", "skipIfHasIssues", "", "skipTestWhenCreateTmsTestCase", "testPostExecution", "testPreconditionExecution", "tm4jOperations", "toDynamicTest", "updateTm4jStatus", "box-tests"})
public final class EntityTestGenerator {
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    private static final int MAX_RETRY = 0;
    public static final ooo.jtc.core.EntityTestGenerator INSTANCE = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    /**
     * Generate [DynamicTest] test from  [AbstractTest]
     *
     * There are adding Tmses and issues links. Add test params.
     *
     * At first execute test precondition function (if it not equals EMPTY_FUNCTION)and store result in preconditionResult in Abstract Test
     *
     * Then will execute execution function from [AbstractTest] and store result in testResult
     *
     * And finally  execute test postcondition function (if it not equals EMPTY_FUNCTION_WITH_INPUT_PARAMS)
     */
    @org.jetbrains.annotations.NotNull()
    public final <RP extends java.lang.Object, RT extends java.lang.Object>org.junit.jupiter.api.DynamicTest toDynamicTest(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.tests.AbstractTest<RP, RT> test) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends ooo.jtc.api.common.tests.AbstractTest<?, ?>>java.util.List<org.junit.jupiter.api.DynamicTest> generate(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> testList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends ooo.jtc.api.common.tests.AbstractTest<?, ?>>java.util.List<org.junit.jupiter.api.DynamicTest> generate(@org.jetbrains.annotations.NotNull()
    T... tests) {
        return null;
    }
    
    /**
     * Optimization of test run time for tests with issues.
     */
    private final boolean skipIfHasIssues(java.lang.String currentTestCaseId) {
        return false;
    }
    
    /**
     * Prevention for fail and performance optimizations when create Tms TestCase.
     */
    private final <RP extends java.lang.Object, RT extends java.lang.Object>boolean skipTestWhenCreateTmsTestCase(ooo.jtc.api.common.tests.AbstractTest<RP, RT> test) {
        return false;
    }
    
    /**
     * Collects and sets info for Allure report from AbstractTest [test].
     */
    private final <RP extends java.lang.Object, RT extends java.lang.Object>java.lang.String processAllureInfo(ooo.jtc.api.common.tests.AbstractTest<RP, RT> test) {
        return null;
    }
    
    private final <RP extends java.lang.Object, RT extends java.lang.Object>void testPreconditionExecution(ooo.jtc.api.common.tests.AbstractTest<RP, RT> test, java.lang.String currentTestCaseId) {
    }
    
    /**
     * Actions for postExecution for preExecutionResult (preconditionResult).
     */
    private final <RP extends java.lang.Object, RT extends java.lang.Object>void postExecution(ooo.jtc.api.common.tests.AbstractTest<RP, RT> test, java.lang.Throwable rootCause, java.lang.String currentTestCaseId) {
    }
    
    /**
     * Actions for postExecution for testExecutionResult (testResult).
     */
    private final <RP extends java.lang.Object, RT extends java.lang.Object>void testPostExecution(ooo.jtc.api.common.tests.AbstractTest<RP, RT> test, java.lang.Throwable rootCause, java.lang.String currentTestCaseId) {
    }
    
    private final void saveFailedIdForRetry(ooo.jtc.api.common.tests.AbstractTest<?, ?> test) {
    }
    
    /**
     * All operations for test with Tm4j.
     */
    private final <RP extends java.lang.Object, RT extends java.lang.Object>void tm4jOperations(ooo.jtc.api.common.tests.AbstractTest<RP, RT> test, java.lang.Throwable rootCause) {
    }
    
    /**
     * Update status in TM4J when [needUpdateResults] is 'on'.
     */
    private final void updateTm4jStatus(ooo.jtc.api.common.tests.AbstractTest<?, ?> test, java.lang.Throwable error) {
    }
    
    /**
     * Create or update test case in TM4J.
     */
    private final void createOrUpdateTm4jTestCase(ooo.jtc.api.common.tests.AbstractTest<?, ?> test, java.lang.Throwable error) {
    }
    
    private EntityTestGenerator() {
        super();
    }
}