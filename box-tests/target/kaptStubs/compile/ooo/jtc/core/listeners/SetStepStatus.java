package ooo.jtc.core.listeners;

import java.lang.System;

/**
 * If step status updated on [Status.FAILED]
 * it will add in [failedSteps].
 * Also attach exceptions as test attach on steps.
 * If steps is failed or broken, parent steps must be failed/broken.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Looo/jtc/core/listeners/SetStepStatus;", "Lio/qameta/allure/listener/StepLifecycleListener;", "()V", "failedSteps", "", "Lio/qameta/allure/model/StepResult;", "Lio/qameta/allure/model/Status;", "afterStepStop", "", "result", "afterStepUpdate", "beforeStepStop", "box-tests"})
public final class SetStepStatus implements io.qameta.allure.listener.StepLifecycleListener {
    private final java.util.Map<io.qameta.allure.model.StepResult, io.qameta.allure.model.Status> failedSteps = null;
    
    @java.lang.Override()
    public void afterStepUpdate(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.StepResult result) {
    }
    
    @java.lang.Override()
    public void beforeStepStop(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.StepResult result) {
    }
    
    @java.lang.Override()
    public void afterStepStop(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.StepResult result) {
    }
    
    public SetStepStatus() {
        super();
    }
}