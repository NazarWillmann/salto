package ooo.jtc.ui.common.sections.modals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u000eH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/ui/common/sections/modals/ModalUnSignDocument;", "Looo/jtc/core/elements/ModalWindow;", "()V", "cancelBtn", "Looo/jtc/core/elements/Button;", "getCancelBtn", "()Looo/jtc/core/elements/Button;", "headerText", "", "getHeaderText", "()Ljava/lang/String;", "unSignBtn", "getUnSignBtn", "checkMessage", "", "expDocCount", "", "isOwnSign", "", "checkModalOpened", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0414\u0438\u0430\u043b\u043e\u0433\u043e\u0432\u043e\u0435 \u043e\u043a\u043d\u043e \'\u0421\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c\'")
public final class ModalUnSignDocument extends ooo.jtc.core.elements.ModalWindow {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String headerText = "\u0421\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c";
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getHeaderText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getUnSignBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getCancelBtn() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043f\u0440\u0438 \u0441\u043d\u044f\u0442\u0438\u0438 \u043f\u043e\u0434\u043f\u0438\u0441\u0438")
    public final void checkMessage(int expDocCount, boolean isOwnSign) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0444\u043e\u0440\u043c\u0430 {this.title} \u043e\u0442\u043a\u0440\u044b\u043b\u0430\u0441\u044c")
    public final void checkModalOpened() {
    }
    
    public ModalUnSignDocument() {
        super(null);
    }
}