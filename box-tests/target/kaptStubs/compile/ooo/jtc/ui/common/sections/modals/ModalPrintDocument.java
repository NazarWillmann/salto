package ooo.jtc.ui.common.sections.modals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/ui/common/sections/modals/ModalPrintDocument;", "Looo/jtc/core/elements/ModalWindow;", "()V", "cancelBtn", "Looo/jtc/core/elements/Button;", "getCancelBtn", "()Looo/jtc/core/elements/Button;", "headerText", "", "getHeaderText", "()Ljava/lang/String;", "printBtn", "getPrintBtn", "printFormat", "Looo/jtc/core/elements/DropDown;", "getPrintFormat", "()Looo/jtc/core/elements/DropDown;", "checkAvailableFormats", "", "expAvailableFormats", "", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0424\u043e\u0440\u043c\u0430 \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043f\u0435\u0447\u0430\u0442\u0438")
public final class ModalPrintDocument extends ooo.jtc.core.elements.ModalWindow {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String headerText = "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043f\u0435\u0447\u0430\u0442\u0438";
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getHeaderText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DropDown getPrintFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getPrintBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getCancelBtn() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432 \u0441\u043f\u0438\u0441\u043a\u0435 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0442\u0441\u044f \u0432\u0441\u0435 \u0434\u043e\u043f\u0443\u0441\u0442\u0438\u043c\u044b\u0435 \u0444\u043e\u0440\u043c\u0430\u0442\u044b")
    public final void checkAvailableFormats(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expAvailableFormats) {
    }
    
    public ModalPrintDocument() {
        super(null);
    }
}