package ooo.jtc.ui.common.templates;

import java.lang.System;

/**
 * @param actionsOnRecallModalFunc - user actions on recall modal (after it's opened).
 * E.g., if you want to recall document and check that modal is closed:
 *
 * `actionsOnRecallModalFunc = { recallModal ->
 *    recallModal.recallReason.value = "Changed my mind"
 *    recallModal.recallBtn.click()
 *    recallModal.shouldNot(exist)
 * }`
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005BI\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010#J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&0%H\u0016R\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006\'"}, d2 = {"Looo/jtc/ui/common/templates/UiBankRecallControlsTestTemplate;", "T", "Looo/jtc/interfaces/IDocument;", "F", "Looo/jtc/ui/common/pages/DocumentPage;", "Looo/jtc/api/common/tests/AbstractTest;", "", "name", "", "preExecution", "Lkotlin/Function0;", "bankUser", "Looo/jtc/uaa/User;", "formPage", "action", "actionsOnRecallModalFunc", "Lkotlin/Function1;", "Looo/jtc/ui/common/sections/modals/ModalRecallDocument;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Looo/jtc/uaa/User;Looo/jtc/ui/common/pages/DocumentPage;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Ljava/lang/String;", "getActionsOnRecallModalFunc", "()Lkotlin/jvm/functions/Function1;", "getBankUser", "()Looo/jtc/uaa/User;", "getFormPage", "()Looo/jtc/ui/common/pages/DocumentPage;", "Looo/jtc/ui/common/pages/DocumentPage;", "getName", "setName", "(Ljava/lang/String;)V", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "execution", "preconditionResult", "(Looo/jtc/interfaces/IDocument;)V", "params", "", "", "box-tests"})
public class UiBankRecallControlsTestTemplate<T extends ooo.jtc.interfaces.IDocument, F extends ooo.jtc.ui.common.pages.DocumentPage> extends ooo.jtc.api.common.tests.AbstractTest<T, kotlin.Unit> {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<T> preExecution = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.User bankUser = null;
    @org.jetbrains.annotations.NotNull()
    private final F formPage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String action = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<ooo.jtc.ui.common.sections.modals.ModalRecallDocument, kotlin.Unit> actionsOnRecallModalFunc = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Map<java.lang.String, java.lang.Object> params() {
        return null;
    }
    
    @java.lang.Override()
    public void execution(@org.jetbrains.annotations.Nullable()
    T preconditionResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override()
    public void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function0<T> getPreExecution() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User getBankUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final F getFormPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.ui.common.sections.modals.ModalRecallDocument, kotlin.Unit> getActionsOnRecallModalFunc() {
        return null;
    }
    
    public UiBankRecallControlsTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends T> preExecution, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser, @org.jetbrains.annotations.NotNull()
    F formPage, @org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.ui.common.sections.modals.ModalRecallDocument, kotlin.Unit> actionsOnRecallModalFunc) {
        super(null, null, null, null);
    }
}