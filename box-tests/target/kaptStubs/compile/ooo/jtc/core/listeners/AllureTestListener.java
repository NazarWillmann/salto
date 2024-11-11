package ooo.jtc.core.listeners;

import java.lang.System;

/**
 * Attach steps to Allure report
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/core/listeners/AllureTestListener;", "Lio/qameta/allure/listener/TestLifecycleListener;", "()V", "beforeTestStop", "", "result", "Lio/qameta/allure/model/TestResult;", "box-tests"})
public final class AllureTestListener implements io.qameta.allure.listener.TestLifecycleListener {
    
    @java.lang.Override()
    public void beforeTestStop(@org.jetbrains.annotations.Nullable()
    io.qameta.allure.model.TestResult result) {
    }
    
    public AllureTestListener() {
        super();
    }
}