package ooo.jtc.aspectj;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Looo/jtc/aspectj/AllureTestInfoCollector;", "", "()V", "catchStartTest", "", "joinPoint", "Lorg/aspectj/lang/JoinPoint;", "catchStartTestContainer", "startTest", "startTestContainer", "Companion", "qa-utils"})
@org.aspectj.lang.annotation.Aspect()
public final class AllureTestInfoCollector {
    private static final java.util.concurrent.ConcurrentMap<java.lang.Thread, java.util.List<io.qameta.allure.model.TestResultContainer>> containers = null;
    private static final java.util.concurrent.ConcurrentMap<java.lang.Thread, java.util.List<java.lang.String>> tests = null;
    public static final ooo.jtc.aspectj.AllureTestInfoCollector.Companion Companion = null;
    
    @org.aspectj.lang.annotation.Pointcut(value = "execution(* io.qameta.allure.AllureLifecycle.startTestContainer(*))")
    public final void startTestContainer() {
    }
    
    @org.aspectj.lang.annotation.Pointcut(value = "execution(* io.qameta.allure.AllureLifecycle.startTestCase(*))")
    public final void startTest() {
    }
    
    @org.aspectj.lang.annotation.After(value = "startTestContainer()")
    public final void catchStartTestContainer(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.JoinPoint joinPoint) throws java.lang.Throwable {
    }
    
    @org.aspectj.lang.annotation.After(value = "startTest()")
    public final void catchStartTest(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.JoinPoint joinPoint) throws java.lang.Throwable {
    }
    
    public AllureTestInfoCollector() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Looo/jtc/aspectj/AllureTestInfoCollector$Companion;", "", "()V", "containers", "Ljava/util/concurrent/ConcurrentMap;", "Ljava/lang/Thread;", "", "Lio/qameta/allure/model/TestResultContainer;", "runningContainersInCurrentThread", "", "getRunningContainersInCurrentThread", "()Ljava/util/List;", "runningTestsInCurrentThread", "", "getRunningTestsInCurrentThread", "tests", "qa-utils"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<io.qameta.allure.model.TestResultContainer> getRunningContainersInCurrentThread() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getRunningTestsInCurrentThread() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}