package ooo.jtc.ui.interfaces;

import java.lang.System;

/**
 * Интерфейс для формирования объектов для проверки фильтрации на UI.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007J\u001d\u0010\u0018\u001a\u00020\u00152\u0006\u0010\f\u001a\u00028\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016\u00a2\u0006\u0002\u0010\u001aRB\u0010\b\u001a2\u0012\u0013\u0012\u00118\u0002\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010RB\u0010\u0011\u001a2\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u0015X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Looo/jtc/ui/interfaces/UiFiltrationParam;", "T", "Looo/jtc/interfaces/IDocument;", "F", "Looo/jtc/core/elements/scroller/FilterForm;", "SR", "Looo/jtc/core/elements/scroller/ScrollerRow;", "", "checkFilteredValue", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "row", "dto", "", "getCheckFilteredValue", "()Lkotlin/jvm/functions/Function2;", "fillFilterFields", "filterForm", "getFillFilterFields", "fpName", "", "getFpName", "()Ljava/lang/String;", "rfText", "dataName", "(Looo/jtc/core/elements/scroller/ScrollerRow;Ljava/lang/String;)Ljava/lang/String;", "box-tests"})
public abstract interface UiFiltrationParam<T extends ooo.jtc.interfaces.IDocument, F extends ooo.jtc.core.elements.scroller.FilterForm, SR extends ooo.jtc.core.elements.scroller.ScrollerRow> {
    
    /**
     * Наименование поля, по которому осуществляется фильтрация.
     * Используется преимущественно для читаемости отчета.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getFpName();
    
    /**
     * Функция заполнения нужного поля(-ей) на форме фильтрации [F].
     * Данные для заполнения берем из dto [T].
     * Это позволяет заполнить на форме несколько полей.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function2<F, T, kotlin.Unit> getFillFilterFields();
    
    /**
     * Функция проверки фильтрации для искомого значения из строки.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function2<SR, T, kotlin.Unit> getCheckFilteredValue();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String rfText(@org.jetbrains.annotations.NotNull()
    SR row, @org.jetbrains.annotations.NotNull()
    java.lang.String dataName);
    
    /**
     * Интерфейс для формирования объектов для проверки фильтрации на UI.
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IDocument, F extends ooo.jtc.core.elements.scroller.FilterForm, SR extends ooo.jtc.core.elements.scroller.ScrollerRow>java.lang.String rfText(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.interfaces.UiFiltrationParam<T, F, SR> $this, @org.jetbrains.annotations.NotNull()
        SR row, @org.jetbrains.annotations.NotNull()
        java.lang.String dataName) {
            return null;
        }
    }
}