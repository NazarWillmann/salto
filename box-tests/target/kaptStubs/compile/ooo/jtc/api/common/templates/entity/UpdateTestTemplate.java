package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Basic test template for updating entity.
 * [preExecution] must return created object (DTO) of [U] for update with id.
 * [postExecution] call [AbstractEntitySteps.delete] fun for cleaning
 * In test template must set [testResult] to pass it to [postExecution]
 * [preCheckingHandling] allows to change [preconditionResult] before checking
 */
@kotlin.Suppress(names = {"UNCHECKED_CAST"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00010\u0005B\u007f\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\r\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00018\u0001H\u0016\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020&H\u0016J\u0014\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020)0(H\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015\u00a8\u0006*"}, d2 = {"Looo/jtc/api/common/templates/entity/UpdateTestTemplate;", "T", "Looo/jtc/interfaces/IEntityDto;", "U", "Looo/jtc/interfaces/UpdateIEntityDto;", "Looo/jtc/api/common/tests/AbstractTest;", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "checks", "Looo/jtc/api/common/checks/ApiEntityChecks;", "preExecution", "Lkotlin/Function0;", "postExecution", "Lkotlin/Function1;", "", "testPostExecution", "preCheckingHandling", "(Looo/jtc/api/common/steps/AbstractEntitySteps;Looo/jtc/api/common/checks/ApiEntityChecks;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getPostExecution", "()Lkotlin/jvm/functions/Function1;", "setPostExecution", "(Lkotlin/jvm/functions/Function1;)V", "getPreCheckingHandling", "setPreCheckingHandling", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "setPreExecution", "(Lkotlin/jvm/functions/Function0;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractEntitySteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractEntitySteps;)V", "getTestPostExecution", "setTestPostExecution", "execution", "preconditionResult", "(Looo/jtc/interfaces/UpdateIEntityDto;)V", "name", "", "params", "", "", "box-tests"})
public class UpdateTestTemplate<T extends ooo.jtc.interfaces.IEntityDto, U extends ooo.jtc.interfaces.UpdateIEntityDto<T>> extends ooo.jtc.api.common.tests.AbstractTest<U, T> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> steps;
    private ooo.jtc.api.common.checks.ApiEntityChecks<T> checks;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends U> preExecution;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super U, kotlin.Unit> postExecution;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super T, kotlin.Unit> testPostExecution;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super U, ? extends U> preCheckingHandling;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    U preconditionResult) {
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
    public final ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<U> getPreExecution() {
        return null;
    }
    
    public void setPreExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends U> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<U, kotlin.Unit> getPostExecution() {
        return null;
    }
    
    public void setPostExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super U, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<T, kotlin.Unit> getTestPostExecution() {
        return null;
    }
    
    public void setTestPostExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<U, U> getPreCheckingHandling() {
        return null;
    }
    
    public final void setPreCheckingHandling(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super U, ? extends U> p0) {
    }
    
    public UpdateTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.checks.ApiEntityChecks<T> checks, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends U> preExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super U, kotlin.Unit> postExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> testPostExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super U, ? extends U> preCheckingHandling) {
        super(null, null, null, null);
    }
}