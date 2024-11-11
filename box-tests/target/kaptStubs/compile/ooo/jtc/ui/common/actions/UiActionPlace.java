package ooo.jtc.ui.common.actions;

import java.lang.System;

/**
 * Перечисление выбора действия.
 * Используется для оптимизации тестов для проверки действий на скроллере из разных мест вызова.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JG\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\n\"\u0018\b\u0001\u0010\u000b*\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\t2\u0006\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/ui/common/actions/UiActionPlace;", "", "description", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "makeAction", "", "R", "Looo/jtc/core/elements/scroller/DocumentScrollerRow;", "S", "Looo/jtc/ui/common/pages/DocumentScrollerPage;", "scrollerPage", "row", "action", "(Looo/jtc/ui/common/pages/DocumentScrollerPage;Looo/jtc/core/elements/scroller/DocumentScrollerRow;Ljava/lang/String;)V", "BY_ROW", "BY_EXPAND_PANEL", "BY_SINGLE_GROUP", "box-tests"})
public enum UiActionPlace {
    /*public static final*/ BY_ROW /* = new BY_ROW(null) */,
    /*public static final*/ BY_EXPAND_PANEL /* = new BY_EXPAND_PANEL(null) */,
    /*public static final*/ BY_SINGLE_GROUP /* = new BY_SINGLE_GROUP(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    
    public final <R extends ooo.jtc.core.elements.scroller.DocumentScrollerRow, S extends ooo.jtc.ui.common.pages.DocumentScrollerPage<?, ?, ?, ?>>void makeAction(@org.jetbrains.annotations.NotNull()
    S scrollerPage, @org.jetbrains.annotations.NotNull()
    R row, @org.jetbrains.annotations.NotNull()
    java.lang.String action) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    UiActionPlace(java.lang.String description) {
    }
}