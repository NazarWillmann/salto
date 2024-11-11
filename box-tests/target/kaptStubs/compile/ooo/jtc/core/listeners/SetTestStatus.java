package ooo.jtc.core.listeners;

import java.lang.System;

/**
 * Set test status if some child (inner) steps are failed or broken.
 * If test has issues it will have the status SKIPPED.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a8\u0006\t"}, d2 = {"Looo/jtc/core/listeners/SetTestStatus;", "Lio/qameta/allure/listener/TestLifecycleListener;", "()V", "afterTestStop", "", "result", "Lio/qameta/allure/model/TestResult;", "hasTestIssues", "", "box-tests"})
public final class SetTestStatus implements io.qameta.allure.listener.TestLifecycleListener {
    
    @java.lang.Override()
    public void afterTestStop(@org.jetbrains.annotations.Nullable()
    io.qameta.allure.model.TestResult result) {
    }
    
    private final boolean hasTestIssues(io.qameta.allure.model.TestResult result) {
        return false;
    }
    
    public SetTestStatus() {
        super();
    }
}