package ooo.jtc.core;

import java.lang.System;

@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n\"\u001b\u0010\f\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\n\"\u001b\u0010\u000f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\n\"\'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"failedTestIds", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "getFailedTestIds", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "failedTestIds$delegate", "Lkotlin/Lazy;", "needCreateTmsTestCase", "", "getNeedCreateTmsTestCase", "()Z", "needCreateTmsTestCase$delegate", "needUpdateResults", "getNeedUpdateResults", "needUpdateResults$delegate", "needUpdateTmsTestCase", "getNeedUpdateTmsTestCase", "needUpdateTmsTestCase$delegate", "tmsSuiteMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Looo/jtc/core/tm4j/TmsTestSuite;", "getTmsSuiteMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "tmsSuiteMap$delegate", "runTest", "", "Looo/jtc/api/common/tests/AbstractTest;", "box-tests"})
public final class EntityTestGeneratorKt {
    private static final kotlin.Lazy needUpdateResults$delegate = null;
    
    /**
     * Operations for create or update test cases in TMS should be manually control.
     * !Please watch out for value by default it should be FALSE.
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy needCreateTmsTestCase$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy needUpdateTmsTestCase$delegate = null;
    
    /**
     * Map for collecting info about tests for TMS.
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy tmsSuiteMap$delegate = null;
    
    /**
     * List of TmsIds of failed tests.
     * Need for retry.
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy failedTestIds$delegate = null;
    
    private static final boolean getNeedUpdateResults() {
        return false;
    }
    
    /**
     * Operations for create or update test cases in TMS should be manually control.
     * !Please watch out for value by default it should be FALSE.
     */
    public static final boolean getNeedCreateTmsTestCase() {
        return false;
    }
    
    public static final boolean getNeedUpdateTmsTestCase() {
        return false;
    }
    
    /**
     * Map for collecting info about tests for TMS.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.ConcurrentHashMap<java.lang.String, ooo.jtc.core.tm4j.TmsTestSuite> getTmsSuiteMap() {
        return null;
    }
    
    /**
     * List of TmsIds of failed tests.
     * Need for retry.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.concurrent.CopyOnWriteArrayList<java.lang.String> getFailedTestIds() {
        return null;
    }
    
    /**
     * Utility function for debug.
     * Allows to run [AbstractTest] from any place of code.
     * e.g.
     * ```
     * @Test
     * fun simpleTest(){
     *   UaaUserGetTest().runTest()
     * }
     * ```
     */
    public static final void runTest(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.tests.AbstractTest<?, ?> $this$runTest) {
    }
}