package ooo.jtc.ui.common.sections.modals;

import java.lang.System;

@kotlin.Suppress(names = {"MemberVisibilityCanBePrivate"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014H\u0007R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/ui/common/sections/modals/ModalUnSignCutOffDocument;", "V", "Looo/jtc/interfaces/IDocumentView;", "Looo/jtc/ui/common/sections/modals/ModalSignDocumentResult;", "()V", "cancelBtn", "Looo/jtc/core/elements/Button;", "getCancelBtn", "()Looo/jtc/core/elements/Button;", "headerText", "", "getHeaderText", "()Ljava/lang/String;", "proceedBtn", "getProceedBtn", "checkMessage", "", "expDocCount", "", "isOwnSign", "", "checkModalOpened", "canUnSign", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0414\u0438\u0430\u043b\u043e\u0433\u043e\u0432\u043e\u0435 \u043e\u043a\u043d\u043e \'\u0421\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c\' (\u043e\u0442\u0441\u0435\u0447\u043a\u0430)")
public abstract class ModalUnSignCutOffDocument<V extends ooo.jtc.interfaces.IDocumentView> extends ooo.jtc.ui.common.sections.modals.ModalSignDocumentResult<V> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String headerText = "\u0421\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c";
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getHeaderText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getProceedBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getCancelBtn() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435 \u043f\u0440\u0438 \u0441\u043d\u044f\u0442\u0438\u0438 \u043f\u043e\u0434\u043f\u0438\u0441\u0438")
    public final void checkMessage(int expDocCount, boolean isOwnSign) {
    }
    
    /**
     * @param canUnSign - признак, что на форме есть документы, с которых можно снять подпись
     */
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \u0444\u043e\u0440\u043c\u0430 {this.title} \u043e\u0442\u043a\u0440\u044b\u043b\u0430\u0441\u044c")
    public final void checkModalOpened(boolean canUnSign) {
    }
    
    public ModalUnSignCutOffDocument() {
        super();
    }
}