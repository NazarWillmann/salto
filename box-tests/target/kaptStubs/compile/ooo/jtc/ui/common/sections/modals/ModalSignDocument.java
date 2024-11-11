package ooo.jtc.ui.common.sections.modals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H&J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014H&J\u001c\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0014H\u0007R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\b\u00a8\u0006)"}, d2 = {"Looo/jtc/ui/common/sections/modals/ModalSignDocument;", "V", "Looo/jtc/interfaces/IDocumentView;", "Looo/jtc/core/elements/ModalWindow;", "()V", "cancelBtn", "Looo/jtc/core/elements/Button;", "getCancelBtn", "()Looo/jtc/core/elements/Button;", "closeButton", "getCloseButton", "code", "Looo/jtc/core/elements/Input;", "getCode", "()Looo/jtc/core/elements/Input;", "docCounter", "Looo/jtc/core/elements/DocumentCounter;", "getDocCounter", "()Looo/jtc/core/elements/DocumentCounter;", "headerText", "", "getHeaderText", "()Ljava/lang/String;", "selectedCertificate", "Looo/jtc/core/elements/DropDown;", "getSelectedCertificate", "()Looo/jtc/core/elements/DropDown;", "signBtn", "getSignBtn", "checkDocsPreview", "", "expDocList", "", "checkModalOpened", "expDocCount", "", "expDocCounterText", "sign", "signToolType", "Looo/jtc/sign/SignToolType;", "certUserName", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0424\u043e\u0440\u043c\u0430 \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\u0438\u044f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430")
public abstract class ModalSignDocument<V extends ooo.jtc.interfaces.IDocumentView> extends ooo.jtc.core.elements.ModalWindow {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String headerText = "\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c";
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getHeaderText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DocumentCounter getDocCounter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getSignBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getCancelBtn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Button getCloseButton() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DropDown getSelectedCertificate() {
        return null;
    }
    
    public abstract void checkModalOpened(int expDocCount, @org.jetbrains.annotations.NotNull()
    java.lang.String expDocCounterText);
    
    public abstract void checkDocsPreview(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends V> expDocList);
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442(-\u044b) [{signToolType.type}]")
    public final void sign(@org.jetbrains.annotations.NotNull()
    ooo.jtc.sign.SignToolType signToolType, @org.jetbrains.annotations.Nullable()
    java.lang.String certUserName) {
    }
    
    public ModalSignDocument() {
        super(null);
    }
}