package ooo.jtc.allure;

import java.lang.System;

/**
 * Class for collect common steps of suite.
 * Need to [createSystemSuiteTest] in beforeAll callback function and [finishSystemSuiteTest] in afterAll callback function.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0007\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Looo/jtc/allure/AllureSystemSuite;", "", "()V", "createSystemSuiteTest", "", "suiteName", "", "finishSystemSuiteTest", "Companion", "qa-utils"})
public final class AllureSystemSuite {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SYSTEM_SUITE_NAME = "SYSTEM PREPARATION";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SYSTEM_EPIC_NAME = "SYSTEM";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ALLURE_SYSTEM_SUITE_NAME = "AllureSystemSuite";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String testCaseId = null;
    private static boolean isInit = false;
    public static final ooo.jtc.allure.AllureSystemSuite.Companion Companion = null;
    
    public final void createSystemSuiteTest(@org.jetbrains.annotations.Nullable()
    java.lang.String suiteName) {
    }
    
    public final void finishSystemSuiteTest() {
    }
    
    public AllureSystemSuite() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/allure/AllureSystemSuite$Companion;", "", "()V", "ALLURE_SYSTEM_SUITE_NAME", "", "SYSTEM_EPIC_NAME", "SYSTEM_SUITE_NAME", "isInit", "", "()Z", "setInit", "(Z)V", "testCaseId", "getTestCaseId", "()Ljava/lang/String;", "addSystemStep", "T", "stepName", "runnable", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "qa-utils"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTestCaseId() {
            return null;
        }
        
        public final boolean isInit() {
            return false;
        }
        
        public final void setInit(boolean p0) {
        }
        
        public final <T extends java.lang.Object>T addSystemStep(@org.jetbrains.annotations.NotNull()
        java.lang.String stepName, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> runnable) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}