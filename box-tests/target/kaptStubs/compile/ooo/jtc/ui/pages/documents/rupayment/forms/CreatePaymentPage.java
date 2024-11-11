package ooo.jtc.ui.pages.documents.rupayment.forms;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0011\u00a8\u0006&"}, d2 = {"Looo/jtc/ui/pages/documents/rupayment/forms/CreatePaymentPage;", "Looo/jtc/ui/common/pages/DocumentPage;", "Looo/jtc/ui/interfaces/CreatePage;", "Looo/jtc/rupayment/RuPaymentView;", "endpoint", "", "(Ljava/lang/String;)V", "amount", "Looo/jtc/core/elements/Input;", "getAmount", "()Looo/jtc/core/elements/Input;", "isUrgent", "Looo/jtc/core/elements/CheckBox;", "()Looo/jtc/core/elements/CheckBox;", "nds", "Looo/jtc/core/elements/ButtonWithDropdown;", "getNds", "()Looo/jtc/core/elements/ButtonWithDropdown;", "payerAccount", "Looo/jtc/core/elements/DropDown;", "getPayerAccount", "()Looo/jtc/core/elements/DropDown;", "payerInn", "Looo/jtc/core/elements/Label;", "getPayerInn", "()Looo/jtc/core/elements/Label;", "payerKpp", "getPayerKpp", "payerName", "getPayerName", "paymentGroundDescription", "Looo/jtc/core/elements/TextArea;", "getPaymentGroundDescription", "()Looo/jtc/core/elements/TextArea;", "priority", "getPriority", "waitLoading", "", "box-tests"})
public abstract class CreatePaymentPage extends ooo.jtc.ui.common.pages.DocumentPage implements ooo.jtc.ui.interfaces.CreatePage<ooo.jtc.rupayment.RuPaymentView> {
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DropDown getPayerAccount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Label getPayerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Label getPayerInn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Label getPayerKpp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.Input getAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.ButtonWithDropdown getNds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.ButtonWithDropdown getPriority() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.CheckBox isUrgent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.TextArea getPaymentGroundDescription() {
        return null;
    }
    
    @java.lang.Override()
    public void waitLoading() {
    }
    
    public CreatePaymentPage(@org.jetbrains.annotations.NotNull()
    java.lang.String endpoint) {
        super(null, null, null);
    }
}