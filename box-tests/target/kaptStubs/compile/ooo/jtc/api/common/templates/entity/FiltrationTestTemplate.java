package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Base test for filtering entities
 *
 * @param steps  - steps for executing rest queries
 * @param checks - base entity checks for checking
 * @param filterRequestFunction - Function for creating filtering request
 * @param clazz - class of [IFilterParams] implementation for current entity
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00010\u0007Bo\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000605H\u0016J,\u00106\u001a\u00020/2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\u0006\u00103\u001a\u00020\rH\u0002R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"\u00a8\u00067"}, d2 = {"Looo/jtc/api/common/templates/entity/FiltrationTestTemplate;", "T", "Looo/jtc/interfaces/IEntityDto;", "F", "Looo/jtc/api/common/filter/IFilterParams;", "RT", "", "Looo/jtc/api/common/tests/AbstractTest;", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "Looo/jtc/interfaces/UpdateIEntityDto;", "filterRequestFunction", "Lkotlin/Function1;", "Looo/jtc/generic/pageparams/FilterData;", "clazz", "Ljava/lang/Class;", "name", "", "checks", "Looo/jtc/api/common/checks/ApiEntityChecks;", "preExecution", "Lkotlin/Function0;", "(Looo/jtc/api/common/steps/AbstractEntitySteps;Lkotlin/jvm/functions/Function1;Ljava/lang/Class;Ljava/lang/String;Looo/jtc/api/common/checks/ApiEntityChecks;Lkotlin/jvm/functions/Function0;)V", "getClazz", "()Ljava/lang/Class;", "setClazz", "(Ljava/lang/Class;)V", "getFilterRequestFunction", "()Lkotlin/jvm/functions/Function1;", "setFilterRequestFunction", "(Lkotlin/jvm/functions/Function1;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "setPreExecution", "(Lkotlin/jvm/functions/Function0;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractEntitySteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractEntitySteps;)V", "tempTestName", "getTempTestName", "setTempTestName", "execution", "", "preconditionResult", "(Looo/jtc/interfaces/IEntityDto;)V", "getFilterPredicate", "filterData", "params", "", "setAllureName", "box-tests"})
public class FiltrationTestTemplate<T extends ooo.jtc.interfaces.IEntityDto, F extends ooo.jtc.api.common.filter.IFilterParams<T>, RT extends java.lang.Object> extends ooo.jtc.api.common.tests.AbstractTest<T, T> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tempTestName;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super T, ooo.jtc.generic.pageparams.FilterData> filterRequestFunction;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Class<F> clazz;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    private ooo.jtc.api.common.checks.ApiEntityChecks<T> checks;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function0<? extends T> preExecution;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTempTestName() {
        return null;
    }
    
    public final void setTempTestName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String name() {
        return null;
    }
    
    /**
     * Generate filter request as [GetPageRequest] from filterRequestFunction and preconditionResult
     * Then consume list of entities, check than it not empty and check than is filtered correctly
     */
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    T preconditionResult) {
    }
    
    private final void setAllureName(ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps, ooo.jtc.generic.pageparams.FilterData filterData) {
    }
    
    /**
     * Retrieve filter description for filter data.
     */
    private final java.lang.String getFilterPredicate(ooo.jtc.generic.pageparams.FilterData filterData) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<T, ooo.jtc.generic.pageparams.FilterData> getFilterRequestFunction() {
        return null;
    }
    
    public final void setFilterRequestFunction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ooo.jtc.generic.pageparams.FilterData> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<F> getClazz() {
        return null;
    }
    
    public final void setClazz(@org.jetbrains.annotations.NotNull()
    java.lang.Class<F> p0) {
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
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    public void setPreExecution(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends T> p0) {
    }
    
    public FiltrationTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ooo.jtc.generic.pageparams.FilterData> filterRequestFunction, @org.jetbrains.annotations.NotNull()
    java.lang.Class<F> clazz, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.checks.ApiEntityChecks<T> checks, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends T> preExecution) {
        super(null, null, null, null);
    }
}