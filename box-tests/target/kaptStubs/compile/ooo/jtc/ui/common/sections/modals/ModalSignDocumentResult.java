package ooo.jtc.ui.common.sections.modals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0010H\u0017J\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH&J\b\u0010\u001f\u001a\u00020\u0016H\'R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\b\u00a8\u0006 "}, d2 = {"Looo/jtc/ui/common/sections/modals/ModalSignDocumentResult;", "V", "Looo/jtc/interfaces/IDocumentView;", "Looo/jtc/core/elements/ModalWindow;", "()V", "closeBtn", "Looo/jtc/core/elements/Button;", "getCloseBtn", "()Looo/jtc/core/elements/Button;", "docCounterError", "Looo/jtc/core/elements/DocumentCounter;", "getDocCounterError", "()Looo/jtc/core/elements/DocumentCounter;", "docCounterSuccess", "getDocCounterSuccess", "headerText", "", "getHeaderText", "()Ljava/lang/String;", "sendBtn", "getSendBtn", "checkCounters", "", "expSuccessDocsCount", "", "expSuccessDocsText", "expErrorDocsCount", "expErrorDocsText", "checkDocsPreview", "expDocList", "", "checkModalOpened", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0424\u043e\u0440\u043c\u0430 \'\u0420\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442 \u043f\u043e\u0434\u043f\u0438\u0441\u0438\'")
public abstract class ModalSignDocumentResult<V extends ooo.jtc.interfaces.IDocumentView> extends ooo.jtc.core.elements.ModalWindow {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String headerText = "\u0420\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442 \u043f\u043e\u0434\u043f\u0438\u0441\u0438";
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getHeaderText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DocumentCounter getDocCounterSuccess() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DocumentCounter getDocCounterError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.core.elements.Button getSendBtn();
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getCloseBtn() {
        return null;
    }
    
    public abstract void checkDocsPreview(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends V> expDocList);
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c, \u0447\u0442\u043e \'{this.title}\' \u043e\u0442\u043a\u0440\u044b\u0442\u0430")
    public abstract void checkModalOpened();
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u0441\u0447\u0435\u0442\u0447\u0438\u043a\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
    public void checkCounters(int expSuccessDocsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String expSuccessDocsText, int expErrorDocsCount, @org.jetbrains.annotations.NotNull()
    java.lang.String expErrorDocsText) {
    }
    
    public ModalSignDocumentResult() {
        super(null);
    }
}