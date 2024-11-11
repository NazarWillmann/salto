package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Test template for checking summary category count.
 *
 * @param steps - document steps; will be used for calling [getCategoriesCounts()]
 * @param ignoreCategories - list of categories' names(!).
 *                          Counters of these categories are ignored when checking 'ALL' category
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B1\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/common/templates/entity/CategorySummaryCountTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/api/common/tests/UnitBeTest;", "steps", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "Looo/jtc/interfaces/UpdateIDocument;", "ignoreCategories", "", "", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;Ljava/util/List;)V", "getIgnoreCategories", "()Ljava/util/List;", "setIgnoreCategories", "(Ljava/util/List;)V", "getSteps", "()Looo/jtc/api/common/steps/AbstractDocumentSteps;", "setSteps", "(Looo/jtc/api/common/steps/AbstractDocumentSteps;)V", "box-tests"})
public class CategorySummaryCountTestTemplate<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.api.common.tests.UnitBeTest {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> ignoreCategories;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getIgnoreCategories() {
        return null;
    }
    
    public final void setIgnoreCategories(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    public CategorySummaryCountTestTemplate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ? extends ooo.jtc.interfaces.UpdateIDocument<T>> steps, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> ignoreCategories) {
        super(null, null, null);
    }
}