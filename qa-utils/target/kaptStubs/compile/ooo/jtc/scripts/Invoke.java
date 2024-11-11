package ooo.jtc.scripts;

import java.lang.System;

/**
 * Class for invoking lambdas
 *
 * @param isSoft - soft/hard script executing
 * @param target - object on that [script] will executed
 * @param script - lambda script for executing
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B.\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u00a2\u0006\u0002\b\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J\u0015\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0086\u0002J\u001e\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0003R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u0004\u0018\u00018\u00012\b\u0010\u000b\u001a\u0004\u0018\u00018\u0001@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u00a2\u0006\u0002\b\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Looo/jtc/scripts/Invoke;", "T", "", "R", "isSoft", "", "target", "script", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(ZLjava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "error", "getError", "()Ljava/lang/Throwable;", "output", "getOutput", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getScript", "()Lkotlin/jvm/functions/Function1;", "Looo/jtc/scripts/InvokeStatus;", "status", "getStatus", "()Looo/jtc/scripts/InvokeStatus;", "getTarget", "title", "", "convertToAllureStatus", "Lio/qameta/allure/model/Status;", "invokeStatus", "executeScript", "invoke", "step", "qa-utils"})
public final class Invoke<T extends java.lang.Object, R extends java.lang.Object> {
    private final java.lang.String title = null;
    @org.jetbrains.annotations.Nullable()
    private R output;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Throwable error;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.scripts.InvokeStatus status = ooo.jtc.scripts.InvokeStatus.UNDEFINED;
    private final boolean isSoft = false;
    @org.jetbrains.annotations.NotNull()
    private final T target = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<T, R> script = null;
    
    @org.jetbrains.annotations.Nullable()
    public final R getOutput() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Throwable getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.scripts.InvokeStatus getStatus() {
        return null;
    }
    
    /**
     * Execute [script]. If [target] is not empty String, script will be execute into new allure step [title], else new step will not created.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.scripts.Invoke<T, R> invoke() {
        return null;
    }
    
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @io.qameta.allure.Step(value = "{title}")
    private final ooo.jtc.scripts.Invoke<T, R> step(java.lang.String title) {
        return null;
    }
    
    /**
     * Execute [script].
     * if there no exception into script, [status] will be [PASSED]
     * if there will be [AssertionError] status will be [FAILED]
     * if there will be [Exception] status will be [BROKEN]
     *
     * After [script] execution status of current allure step will be updated
     *
     * if [isSoft] is true, exceptions won't throws, else it will be throw
     */
    private final ooo.jtc.scripts.Invoke<T, R> executeScript() {
        return null;
    }
    
    private final io.qameta.allure.model.Status convertToAllureStatus(ooo.jtc.scripts.InvokeStatus invokeStatus) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final T getTarget() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<T, R> getScript() {
        return null;
    }
    
    public Invoke(boolean isSoft, @org.jetbrains.annotations.NotNull()
    T target, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> script) {
        super();
    }
}