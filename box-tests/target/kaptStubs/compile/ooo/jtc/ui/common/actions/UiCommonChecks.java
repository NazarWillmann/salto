package ooo.jtc.ui.common.actions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u0002H\u0005\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J/\u0010\u000e\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0007\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0007\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/ui/common/actions/UiCommonChecks;", "", "()V", "checkDocSystemStatusThroughBE", "", "T", "Looo/jtc/interfaces/IDocument;", "beSteps", "Looo/jtc/api/common/steps/AbstractDocumentSteps;", "dtoId", "Ljava/util/UUID;", "expStatuses", "", "", "checkDocumentCopiedSuccessfully", "Looo/jtc/interfaces/IDocumentView;", "formPage", "Looo/jtc/ui/common/pages/DocumentPage;", "view", "expHeaderText", "(Looo/jtc/ui/common/pages/DocumentPage;Looo/jtc/interfaces/IDocumentView;Ljava/lang/String;)V", "checkPushMessage", "message", "checkPushSuccessMessage", "checkTooltipMessage", "box-tests"})
public final class UiCommonChecks {
    public static final ooo.jtc.ui.common.actions.UiCommonChecks INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043e\u0431\u0440\u0430\u0437\u0438\u043b\u043e\u0441\u044c \u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u0435: {message}")
    public final void checkPushMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043e\u0431\u0440\u0430\u0437\u0438\u043b\u043e\u0441\u044c \u0443\u0432\u0435\u0434\u043e\u043c\u043b\u0435\u043d\u0438\u0435 \u043e\u0431 \u0443\u0441\u043f\u0435\u0448\u043d\u043e\u043c \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u0438 \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f")
    public final void checkPushSuccessMessage() {
    }
    
    @io.qameta.allure.Step(value = "\u041e\u0442\u043e\u0431\u0440\u0430\u0437\u0438\u043b\u0430\u0441\u044c \u043f\u043e\u0434\u0441\u043a\u0430\u0437\u043a\u0430: {message}")
    public final void checkTooltipMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 [{dtoId}] \u0432 \u043e\u0434\u043d\u043e\u043c \u0438\u0437 \u0441\u0442\u0430\u0442\u0443\u0441\u043e\u0432 {expStatuses}")
    public final <T extends ooo.jtc.interfaces.IDocument>void checkDocSystemStatusThroughBE(@org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractDocumentSteps<T, ?> beSteps, @org.jetbrains.annotations.NotNull()
    java.util.UUID dtoId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatuses) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \u0441\u043a\u043e\u043f\u0438\u0440\u043e\u0432\u0430\u043d \u0443\u0441\u043f\u0435\u0448\u043d\u043e")
    public final <T extends ooo.jtc.interfaces.IDocumentView>void checkDocumentCopiedSuccessfully(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.DocumentPage formPage, @org.jetbrains.annotations.NotNull()
    T view, @org.jetbrains.annotations.NotNull()
    java.lang.String expHeaderText) {
    }
    
    private UiCommonChecks() {
        super();
    }
}