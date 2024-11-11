package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Base test for pagination entities
 *
 * @param steps  - steps for executing rest queries
 * @param checks - base entity checks for checking sorting
 * //TODO A.Stykalin [18.06.2020] update
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\n\u0002\u0010$\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005B\u0085\u0001\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00028\u0001\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u0017J\u0012\u00103\u001a\u00020\u00162\b\u00104\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000606H\u0016R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001c\u0010\u000e\u001a\u00028\u0001X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Looo/jtc/api/common/templates/entity/PaginationTestTemplate;", "T", "Looo/jtc/interfaces/IEntityDto;", "S", "Looo/jtc/api/common/sorting/ISortingParams;", "Looo/jtc/api/common/tests/AbstractTest;", "", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "Looo/jtc/interfaces/UpdateIEntityDto;", "createRecord", "Lkotlin/Function0;", "limit", "", "sortParam", "checks", "Looo/jtc/api/common/checks/ApiEntityChecks;", "name", "", "preExecution", "postExecution", "Lkotlin/Function1;", "", "(Looo/jtc/api/common/steps/AbstractEntitySteps;Lkotlin/jvm/functions/Function0;ILooo/jtc/api/common/sorting/ISortingParams;Looo/jtc/api/common/checks/ApiEntityChecks;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getCreateRecord", "()Lkotlin/jvm/functions/Function0;", "setCreateRecord", "(Lkotlin/jvm/functions/Function0;)V", "getLimit", "()I", "setLimit", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPostExecution", "()Lkotlin/jvm/functions/Function1;", "setPostExecution", "(Lkotlin/jvm/functions/Function1;)V", "getPreExecution", "setPreExecution", "getSortParam", "()Looo/jtc/api/common/sorting/ISortingParams;", "setSortParam", "(Looo/jtc/api/common/sorting/ISortingParams;)V", "Looo/jtc/api/common/sorting/ISortingParams;", "getSteps", "()Looo/jtc/api/common/steps/AbstractEntitySteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractEntitySteps;)V", "execution", "preconditionResult", "params", "", "box-tests"})
public class PaginationTestTemplate<T extends ooo.jtc.interfaces.IEntityDto, S extends ooo.jtc.api.common.sorting.ISortingParams<T>> extends ooo.jtc.api.common.tests.AbstractTest<java.lang.Object, java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function0<? extends T> createRecord;
    private int limit;
    @org.jetbrains.annotations.NotNull()
    private S sortParam;
    private ooo.jtc.api.common.checks.ApiEntityChecks<T> checks;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends java.lang.Object> preExecution;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> postExecution;
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    java.lang.Object preconditionResult) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<T> getCreateRecord() {
        return null;
    }
    
    public final void setCreateRecord(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> p0) {
    }
    
    public final int getLimit() {
        return 0;
    }
    
    public final void setLimit(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final S getSortParam() {
        return null;
    }
    
    public final void setSortParam(@org.jetbrains.annotations.NotNull()
    S p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override()
    public void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public final kotlin.jvm.functions.Function0<java.lang.Object> getPreExecution() {
        return null;
    }
    
    public final void setPreExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> getPostExecution() {
        return null;
    }
    
    public void setPostExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> p0) {
    }
    
    public PaginationTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> createRecord, int limit, @org.jetbrains.annotations.NotNull()
    S sortParam, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.checks.ApiEntityChecks<T> checks, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends java.lang.Object> preExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> postExecution) {
        super(null, null, null, null);
    }
}