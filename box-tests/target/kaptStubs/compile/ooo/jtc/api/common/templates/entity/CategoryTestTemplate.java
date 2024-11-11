package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Test template for checking each category by its associated statuses list
 *
 * @param steps - document steps; will be used for calling [getCategoriesCounts()]
 * @param category - list of categories and their respective statuses
 * @param sortBy - param to sort documents in definite order (e.g. DOCUMENT_NUMBER)
 * e.g. [zonedDateTime -> { LetterToBankFilterParams.CREATED_AT.le(<zonedDateTime>) }]
 * @param mapStatusToFilterDataFunction - (documentStatus)->(() -> FilterData) mapping function,
 * e.g. [{ { LetterToBankFilterParams.STATUS.eq(it.getStatus(user.userType)) } }]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003Bm\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u001e\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0013R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R2\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006&"}, d2 = {"Looo/jtc/api/common/templates/entity/CategoryTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/tests/AbstractBeTest;", "", "steps", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/interfaces/UpdateIDocument;", "category", "Looo/jtc/generic/Category;", "sortBy", "", "Looo/jtc/generic/pageparams/Sort;", "mapStatusToFilterDataFunction", "Lkotlin/Function1;", "Looo/jtc/documents/IDocumentStatus;", "Lkotlin/Function0;", "Looo/jtc/generic/pageparams/FilterData;", "preExecution", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;Looo/jtc/generic/Category;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getCategory", "()Looo/jtc/generic/Category;", "setCategory", "(Looo/jtc/generic/Category;)V", "getMapStatusToFilterDataFunction", "()Lkotlin/jvm/functions/Function1;", "setMapStatusToFilterDataFunction", "(Lkotlin/jvm/functions/Function1;)V", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "getSortBy", "()Ljava/util/List;", "setSortBy", "(Ljava/util/List;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractDocumentSteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;)V", "box-tests"})
public class CategoryTestTemplate<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.tests.AbstractBeTest<T, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.generic.Category<? extends T> category;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<ooo.jtc.generic.pageparams.Sort> sortBy;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.documents.IDocumentStatus<? extends T>, ? extends kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.FilterData>> mapStatusToFilterDataFunction;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function0<T> preExecution = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.Category<T> getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.Category<? extends T> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.generic.pageparams.Sort> getSortBy() {
        return null;
    }
    
    public final void setSortBy(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.pageparams.Sort> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.documents.IDocumentStatus<? extends T>, kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.FilterData>> getMapStatusToFilterDataFunction() {
        return null;
    }
    
    public final void setMapStatusToFilterDataFunction(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.documents.IDocumentStatus<? extends T>, ? extends kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.FilterData>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    public CategoryTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.Category<? extends T> category, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.pageparams.Sort> sortBy, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.documents.IDocumentStatus<? extends T>, ? extends kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.FilterData>> mapStatusToFilterDataFunction, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends T> preExecution) {
        super(null, null, null, null, null, null);
    }
}