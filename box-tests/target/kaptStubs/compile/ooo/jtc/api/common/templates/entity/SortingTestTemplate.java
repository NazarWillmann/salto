package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Base test for filtering entities
 *
 * @param steps  - steps for executing rest queries
 * @param checks - base entity checks for checking sorting
 * @param sortList - sorting list for creating sorting request
 * @param filter - filter for creating sorting request. Use `[IFilterParams].contains("")`, when you need to filter non-null field.
 * @param limit - paging limit for creating sorting request
 * @param clazz - class of [ISortingParams] implementation for current entity
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00050\u0007Bm\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0002\u0010\u0018J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000605H\u0016R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0016\u001a\u00020\u0017X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Looo/jtc/api/common/templates/entity/SortingTestTemplate;", "T", "Looo/jtc/interfaces/IEntityDto;", "F", "Looo/jtc/api/common/sorting/ISortingParams;", "R", "", "Looo/jtc/api/common/tests/AbstractTest;", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "Looo/jtc/interfaces/UpdateIEntityDto;", "filter", "Looo/jtc/generic/pageparams/Filter;", "sortList", "", "Looo/jtc/generic/pageparams/Sort;", "clazz", "Ljava/lang/Class;", "limit", "", "checks", "Looo/jtc/api/common/checks/ApiEntityChecks;", "name", "", "(Looo/jtc/api/common/steps/AbstractEntitySteps;Looo/jtc/generic/pageparams/Filter;Ljava/util/List;Ljava/lang/Class;ILooo/jtc/api/common/checks/ApiEntityChecks;Ljava/lang/String;)V", "getClazz", "()Ljava/lang/Class;", "setClazz", "(Ljava/lang/Class;)V", "getFilter", "()Looo/jtc/generic/pageparams/Filter;", "setFilter", "(Looo/jtc/generic/pageparams/Filter;)V", "getLimit", "()I", "setLimit", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSortList", "()Ljava/util/List;", "setSortList", "(Ljava/util/List;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractEntitySteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractEntitySteps;)V", "execution", "", "preconditionResult", "params", "", "box-tests"})
public class SortingTestTemplate<T extends ooo.jtc.interfaces.IEntityDto, F extends ooo.jtc.api.common.sorting.ISortingParams<T>, R extends java.lang.Object> extends ooo.jtc.api.common.tests.AbstractTest<java.lang.Object, R> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.generic.pageparams.Filter filter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<ooo.jtc.generic.pageparams.Sort> sortList;
    @org.jetbrains.annotations.NotNull()
    private java.lang.Class<F> clazz;
    private int limit;
    private ooo.jtc.api.common.checks.ApiEntityChecks<T> checks;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    
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
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.generic.pageparams.Filter getFilter() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.Nullable()
    ooo.jtc.generic.pageparams.Filter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.generic.pageparams.Sort> getSortList() {
        return null;
    }
    
    public final void setSortList(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.pageparams.Sort> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Class<F> getClazz() {
        return null;
    }
    
    public final void setClazz(@org.jetbrains.annotations.NotNull()
    java.lang.Class<F> p0) {
    }
    
    public final int getLimit() {
        return 0;
    }
    
    public final void setLimit(int p0) {
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
    
    public SortingTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, ? extends ooo.jtc.interfaces.UpdateIEntityDto<T>> steps, @org.jetbrains.annotations.Nullable()
    ooo.jtc.generic.pageparams.Filter filter, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.pageparams.Sort> sortList, @org.jetbrains.annotations.NotNull()
    java.lang.Class<F> clazz, int limit, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.checks.ApiEntityChecks<T> checks, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        super(null, null, null, null);
    }
}