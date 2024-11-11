package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Basic test template for deleting document.
 * [preExecution] must return object (DTO) of [T] for delete it with id.
 * [preCheckingHandling] allows to change [preconditionResult] before checking
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0003Bw\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010&J\b\u0010\'\u001a\u00020\u0010H\u0016J\u0014\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020*0)H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Looo/jtc/api/common/templates/entity/DeleteDocumentTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/tests/AbstractTest;", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "Looo/jtc/interfaces/UpdateIEntityDto;", "checks", "Looo/jtc/api/common/checks/ApiEntityChecks;", "preExecution", "Lkotlin/Function0;", "postExecution", "Lkotlin/Function1;", "", "preCheckingHandling", "deletedStatus", "", "(Looo/jtc/api/common/steps/AbstractEntitySteps;Looo/jtc/api/common/checks/ApiEntityChecks;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getDeletedStatus", "()Ljava/lang/String;", "setDeletedStatus", "(Ljava/lang/String;)V", "getPostExecution", "()Lkotlin/jvm/functions/Function1;", "setPostExecution", "(Lkotlin/jvm/functions/Function1;)V", "getPreCheckingHandling", "setPreCheckingHandling", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "setPreExecution", "(Lkotlin/jvm/functions/Function0;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractEntitySteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractEntitySteps;)V", "execution", "preconditionResult", "(Looo/jtc/interfaces/IDocument;)V", "name", "params", "", "", "box-tests"})
public class DeleteDocumentTestTemplate<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.tests.AbstractTest<T, T> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps;
    private ooo.jtc.api.common.checks.ApiEntityChecks<T> checks;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends T> preExecution;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super T, kotlin.Unit> postExecution;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super T, ? extends T> preCheckingHandling;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String deletedStatus;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    T preconditionResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String name() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Map<java.lang.String, java.lang.Object> params() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    public void setPreExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends T> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<T, kotlin.Unit> getPostExecution() {
        return null;
    }
    
    public void setPostExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public kotlin.jvm.functions.Function1<T, T> getPreCheckingHandling() {
        return null;
    }
    
    public void setPreCheckingHandling(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends T> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeletedStatus() {
        return null;
    }
    
    public final void setDeletedStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public DeleteDocumentTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.checks.ApiEntityChecks<T> checks, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends T> preExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> postExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends T> preCheckingHandling, @org.jetbrains.annotations.NotNull()
    java.lang.String deletedStatus) {
        super(null, null, null, null);
    }
}