package ooo.jtc.allure;

import java.lang.System;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u001a0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f\u001a\u0006\u0010\u001a\u001a\u00020\b\u001a?\u0010\u001b\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001c0#H\u0002\u00a2\u0006\u0002\u0010$\u001a\"\u0010%\u001a\u00020\b*\u00020&2\b\b\u0002\u0010\'\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a\"\u0010)\u001a\u00020\b*\u00020&2\b\b\u0002\u0010\'\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u000e\u001a(\u0010,\u001a\u00020\b*\u00020&2\b\b\u0002\u0010\'\u001a\u00020\f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0.\u001a\"\u0010/\u001a\u00020\b*\u00020&2\b\b\u0002\u0010\'\u001a\u00020\f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u001a#\u00101\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d*\u0002H\u001c2\b\b\u0002\u00102\u001a\u00020\f\u00a2\u0006\u0002\u00103\u001a9\u00104\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d*\b\u0012\u0004\u0012\u0002H\u001c0#2\u0006\u00105\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u001f\u001a\u00020\f\u00a2\u0006\u0002\u00106\u001aG\u00104\u001a\u00020\u001d\"\b\b\u0000\u00107*\u00020\u001d*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u00020\u001d082\u0006\u00105\u001a\u00020\f2\u0006\u00109\u001a\u0002H72\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\u001f\u001a\u00020\f\u00a2\u0006\u0002\u0010:\u001a\n\u0010;\u001a\u00020\u0018*\u00020<\u001a\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e*\u00020&2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\f\u001a\n\u0010=\u001a\u00020>*\u00020&\u001a\u0016\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0@*\u00020>\u001a\u0014\u0010A\u001a\u00020<*\u00020&2\b\b\u0002\u0010\u0019\u001a\u00020\f\u001a\u0014\u0010\u0019\u001a\u00020\f*\u00020&2\b\b\u0002\u0010B\u001a\u00020C\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006D"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "logger$delegate", "Lkotlin/Lazy;", "failFixture", "", "throwable", "", "fixtureId", "", "getChildBrokenSteps", "", "list", "", "steps", "Lio/qameta/allure/model/StepResult;", "getChildFailedSteps", "getChildStepsWithStatus", "status", "Lio/qameta/allure/model/Status;", "isTestResultRunning", "", "testResultId", "printStorage", "proceedAllureFixture", "T", "", "currentTest", "fixtureName", "fixtureType", "Looo/jtc/allure/AllureFixtureType;", "function", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Looo/jtc/allure/AllureFixtureType;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "addIssues", "Lio/qameta/allure/AllureLifecycle;", "testCaseId", "issues", "addLabels", "labels", "Lio/qameta/allure/model/Label;", "addTestParams", "params", "", "addTmses", "tmses", "attachToAllure", "attachName", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "invokeInAllureFixture", "curTest", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Looo/jtc/allure/AllureFixtureType;Ljava/lang/String;)Ljava/lang/Object;", "R", "Lkotlin/Function1;", "value", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/Object;Looo/jtc/allure/AllureFixtureType;Ljava/lang/String;)Ljava/lang/Object;", "isRunning", "Lio/qameta/allure/model/TestResultContainer;", "storage", "Lio/qameta/allure/internal/AllureStorage;", "storageMap", "Ljava/util/concurrent/ConcurrentHashMap;", "testContainer", "timeout", "", "qa-utils"})
public final class AllureUtilsKt {
    private static final kotlin.Lazy logger$delegate = null;
    
    public static final boolean isTestResultRunning(@org.jetbrains.annotations.NotNull()
    java.lang.String testResultId) {
        return false;
    }
    
    public static final boolean isRunning(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.TestResultContainer $this$isRunning) {
        return false;
    }
    
    private static final org.slf4j.Logger getLogger() {
        return null;
    }
    
    /**
     * Extension for function than has no input params and return  [Any] for invoking it in one of [AllureFixtureType]
     *
     * @param fixtureType - one of [AllureFixtureType]
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>T invokeInAllureFixture(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> $this$invokeInAllureFixture, @org.jetbrains.annotations.NotNull()
    java.lang.String curTest, @org.jetbrains.annotations.NotNull()
    ooo.jtc.allure.AllureFixtureType fixtureType, @org.jetbrains.annotations.NotNull()
    java.lang.String fixtureName) {
        return null;
    }
    
    /**
     * Extension for function than has one [Any] input params and return  [Any] for invoking it in one of [AllureFixtureType]
     *
     * @param fixtureType - one of [AllureFixtureType]
     */
    @org.jetbrains.annotations.NotNull()
    public static final <R extends java.lang.Object>java.lang.Object invokeInAllureFixture(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super R, ? extends java.lang.Object> $this$invokeInAllureFixture, @org.jetbrains.annotations.NotNull()
    java.lang.String curTest, @org.jetbrains.annotations.NotNull()
    R value, @org.jetbrains.annotations.NotNull()
    ooo.jtc.allure.AllureFixtureType fixtureType, @org.jetbrains.annotations.NotNull()
    java.lang.String fixtureName) {
        return null;
    }
    
    private static final <T extends java.lang.Object>T proceedAllureFixture(java.lang.String currentTest, java.lang.String fixtureName, ooo.jtc.allure.AllureFixtureType fixtureType, kotlin.jvm.functions.Function0<? extends T> function) {
        return null;
    }
    
    /**
     * Set FAILED or BROKEN status in fixture.
     */
    private static final void failFixture(java.lang.Throwable throwable, java.lang.String fixtureId) {
    }
    
    /**
     * @return storage as [AllureStorage] from [AllureLifecycle] using reflection
     */
    @org.jetbrains.annotations.NotNull()
    public static final io.qameta.allure.internal.AllureStorage storage(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$storage) {
        return null;
    }
    
    /**
     * @return storage map as [ConcurrentHashMap<String, Object>] from [AllureStorage] using reflection
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> storageMap(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.internal.AllureStorage $this$storageMap) {
        return null;
    }
    
    /**
     * @param testCaseId - testCase id as [String], by default current testCase id
     *
     * @return list of [StepResult] from
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<io.qameta.allure.model.StepResult> steps(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$steps, @org.jetbrains.annotations.Nullable()
    java.lang.String testCaseId) {
        return null;
    }
    
    /**
     * @return testContainerId as [String] for current testCase
     */
    @org.jetbrains.annotations.NotNull()
    public static final io.qameta.allure.model.TestResultContainer testContainer(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$testContainer, @org.jetbrains.annotations.NotNull()
    java.lang.String testResultId) {
        return null;
    }
    
    /**
     * @return testContainerId as [String] for current testCase
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String testResultId(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$testResultId, long timeout) {
        return null;
    }
    
    /**
     * Added tmses links for testCase in Allure report
     *
     * @param testCaseId as [String], by default current testCase id
     * @param tmses - list of tms id as [String]
     */
    public static final void addTmses(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$addTmses, @org.jetbrains.annotations.NotNull()
    java.lang.String testCaseId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tmses) {
    }
    
    /**
     * Added issues links for testCase in Allure report
     *
     * @param testCaseId as [String], by default current testCase id
     * @param issues - list of issues id as [String]
     */
    public static final void addIssues(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$addIssues, @org.jetbrains.annotations.NotNull()
    java.lang.String testCaseId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> issues) {
    }
    
    /**
     * Added labels for testCase in Allure report
     *
     * @param testCaseId as [String], by default current testCase id
     * @param labels - list of [Label]
     */
    public static final void addLabels(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$addLabels, @org.jetbrains.annotations.NotNull()
    java.lang.String testCaseId, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends io.qameta.allure.model.Label> labels) {
    }
    
    /**
     * Added test params for testCase in Allure report
     *
     * @param testCaseId as [String], by default current trstCase id
     * @param params - map of params as [Map]
     */
    public static final void addTestParams(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.AllureLifecycle $this$addTestParams, @org.jetbrains.annotations.NotNull()
    java.lang.String testCaseId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> params) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> getChildFailedSteps(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends io.qameta.allure.model.StepResult> steps) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> getChildBrokenSteps(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends io.qameta.allure.model.StepResult> steps) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> getChildStepsWithStatus(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends io.qameta.allure.model.StepResult> steps, @org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.Status status) {
        return null;
    }
    
    /**
     * Extension for add any to allure report as attachment
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>T attachToAllure(@org.jetbrains.annotations.NotNull()
    T $this$attachToAllure, @org.jetbrains.annotations.NotNull()
    java.lang.String attachName) {
        return null;
    }
    
    /**
     * Debug function.
     */
    public static final void printStorage() {
    }
}