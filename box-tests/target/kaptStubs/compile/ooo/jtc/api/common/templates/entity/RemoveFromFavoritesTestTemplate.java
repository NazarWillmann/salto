package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * RemoveFromFavoritesTestTemplate.
 * [retrieveIsFavorites] - lambda-function for retrieving `IsFavorites` flag from DTO<[T]>.
 * [preExecution] should provide ID for add to favorites
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003Bm\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010 \u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020&0%H\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006\'"}, d2 = {"Looo/jtc/api/common/templates/entity/RemoveFromFavoritesTestTemplate;", "T", "Looo/jtc/interfaces/IEntityDto;", "Looo/jtc/api/common/tests/AbstractTest;", "Ljava/util/UUID;", "retrieveIsFavorites", "Lkotlin/Function1;", "", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "Looo/jtc/interfaces/UpdateIEntityDto;", "checks", "Looo/jtc/api/common/checks/ApiEntityChecks;", "preExecution", "Lkotlin/Function0;", "postExecution", "", "(Lkotlin/jvm/functions/Function1;Looo/jtc/api/common/steps/AbstractEntitySteps;Looo/jtc/api/common/checks/ApiEntityChecks;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getPostExecution", "()Lkotlin/jvm/functions/Function1;", "setPostExecution", "(Lkotlin/jvm/functions/Function1;)V", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "setPreExecution", "(Lkotlin/jvm/functions/Function0;)V", "getRetrieveIsFavorites", "setRetrieveIsFavorites", "getSteps", "()Looo/jtc/api/common/steps/AbstractEntitySteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractEntitySteps;)V", "execution", "preconditionResult", "name", "", "params", "", "", "box-tests"})
public class RemoveFromFavoritesTestTemplate<T extends ooo.jtc.interfaces.IEntityDto> extends ooo.jtc.api.common.tests.AbstractTest<java.util.UUID, java.util.UUID> {
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> retrieveIsFavorites;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps;
    private ooo.jtc.api.common.checks.ApiEntityChecks<T> checks;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<java.util.UUID> preExecution;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super java.util.UUID, kotlin.Unit> postExecution;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    java.util.UUID preconditionResult) {
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
    public final kotlin.jvm.functions.Function1<T, java.lang.Boolean> getRetrieveIsFavorites() {
        return null;
    }
    
    public final void setRetrieveIsFavorites(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> p0) {
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
    public kotlin.jvm.functions.Function0<java.util.UUID> getPreExecution() {
        return null;
    }
    
    public void setPreExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<java.util.UUID> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<java.util.UUID, kotlin.Unit> getPostExecution() {
        return null;
    }
    
    public void setPostExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.util.UUID, kotlin.Unit> p0) {
    }
    
    public RemoveFromFavoritesTestTemplate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> retrieveIsFavorites, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.checks.ApiEntityChecks<T> checks, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<java.util.UUID> preExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.util.UUID, kotlin.Unit> postExecution) {
        super(null, null, null, null);
    }
}