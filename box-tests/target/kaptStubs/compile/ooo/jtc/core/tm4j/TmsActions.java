package ooo.jtc.core.tm4j;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J \u0010\u0010\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J \u0010\u001f\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006 "}, d2 = {"Looo/jtc/core/tm4j/TmsActions;", "", "()V", "createdFolders", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "collectTmsAnnotation", "", "testCaseKey", "testName", "createTm4jTestCase", "test", "Looo/jtc/api/common/tests/AbstractTest;", "error", "", "logFolderErrors", "errorList", "", "prepareTestScript", "Looo/jtc/core/tm4j/TestScript;", "retrieveComponentName", "retrieveFolder", "componentName", "transformClassToTag", "transformMethodToTag", "updateTm4jTestCase", "box-tests"})
public final class TmsActions {
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    private static final java.util.concurrent.CopyOnWriteArrayList<java.lang.String> createdFolders = null;
    public static final ooo.jtc.core.tm4j.TmsActions INSTANCE = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    /**
     * Main function for creating test case in TMS.
     */
    public final void createTm4jTestCase(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.tests.AbstractTest<?, ?> test, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable error) {
    }
    
    /**
     * Main function for updating test case in TMS.
     */
    public final void updateTm4jTestCase(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.tests.AbstractTest<?, ?> test, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable error) {
    }
    
    private final java.lang.String retrieveFolder(java.lang.String componentName, ooo.jtc.api.common.tests.AbstractTest<?, ?> test) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String retrieveComponentName(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.tests.AbstractTest<?, ?> test) {
        return null;
    }
    
    /**
     * Log create folder error except 'already exist'.
     */
    private final void logFolderErrors(java.util.List<java.lang.String> errorList) {
    }
    
    private final ooo.jtc.core.tm4j.TestScript prepareTestScript(java.lang.String testName, java.lang.Throwable error) {
        return null;
    }
    
    /**
     * Collecting and accumulating test info to [tmsSuiteMap]
     */
    private final void collectTmsAnnotation(java.lang.String testCaseKey, java.lang.String testName) {
    }
    
    private final java.lang.String transformClassToTag(java.lang.String testCaseKey) {
        return null;
    }
    
    private final java.lang.String transformMethodToTag(java.lang.String testCaseKey, java.lang.String testName) {
        return null;
    }
    
    private TmsActions() {
        super();
    }
}