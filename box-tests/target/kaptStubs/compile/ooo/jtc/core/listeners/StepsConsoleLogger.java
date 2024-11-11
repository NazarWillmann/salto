package ooo.jtc.core.listeners;

import java.lang.System;

/**
 * Logged allure steps to console
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/core/listeners/StepsConsoleLogger;", "Lio/qameta/allure/listener/StepLifecycleListener;", "()V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "afterStepStart", "", "result", "Lio/qameta/allure/model/StepResult;", "afterStepStop", "processStep", "desc", "", "box-tests"})
public final class StepsConsoleLogger implements io.qameta.allure.listener.StepLifecycleListener {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    @java.lang.Override()
    public void afterStepStart(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.StepResult result) {
    }
    
    @java.lang.Override()
    public void afterStepStop(@org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.StepResult result) {
    }
    
    private final void processStep(io.qameta.allure.model.StepResult result, java.lang.String desc) {
    }
    
    public StepsConsoleLogger() {
        super();
    }
}