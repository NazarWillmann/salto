package ooo.jtc.ui.pages.documents.lettertobank.sections;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Looo/jtc/ui/pages/documents/lettertobank/sections/LetterToBankHistoryTab;", "Looo/jtc/ui/pages/documents/lettertobank/form/LetterToBankFormPage;", "Looo/jtc/ui/common/sections/tabs/HistoryTab;", "Looo/jtc/ui/common/sections/tabs/HistoryRow;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "(Lcom/codeborne/selenide/SelenideElement;Looo/jtc/ui/common/pages/ApplicationPageType;)V", "createRow", "Lkotlin/Function1;", "getCreateRow", "()Lkotlin/jvm/functions/Function1;", "detailStatuses", "", "Looo/jtc/documents/IDocumentStatus;", "getDetailStatuses", "()Ljava/util/List;", "processingStatuses", "Looo/jtc/letters/model/LetterToBankStatus;", "receptionStatuses", "getSElement", "()Lcom/codeborne/selenide/SelenideElement;", "tabName", "", "getTabName", "()Ljava/lang/String;", "openProcessingModal", "Looo/jtc/ui/common/sections/modals/ModalProcessingResult;", "openReceptionModal", "Looo/jtc/ui/common/sections/modals/ModalReceptionResult;", "box-tests"})
public final class LetterToBankHistoryTab extends ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormPage implements ooo.jtc.ui.common.sections.tabs.HistoryTab<ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankHistoryTab, ooo.jtc.ui.common.sections.tabs.HistoryRow> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String tabName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.codeborne.selenide.SelenideElement, ooo.jtc.ui.common.sections.tabs.HistoryRow> createRow = null;
    
    /**
     * Статусы в которых должна отображаться кнопка "Подробнее"
     * для просмотра Сведений о результатах обработки в банке.
     */
    private final java.util.List<ooo.jtc.letters.model.LetterToBankStatus> processingStatuses = null;
    
    /**
     * Статусы в которых должна отображаться кнопка "Подробнее"
     * для просмотра Сведений о результатах приема в банке.
     */
    private final java.util.List<ooo.jtc.letters.model.LetterToBankStatus> receptionStatuses = null;
    @org.jetbrains.annotations.NotNull()
    private final com.codeborne.selenide.SelenideElement sElement = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTabName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<com.codeborne.selenide.SelenideElement, ooo.jtc.ui.common.sections.tabs.HistoryRow> getCreateRow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<ooo.jtc.documents.IDocumentStatus<?>> getDetailStatuses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0421\u0432\u0435\u0434\u0435\u043d\u0438\u044f \u043e \u0440\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442\u0430\u0445 \u043e\u0431\u0440\u0430\u0431\u043e\u0442\u043a\u0438 \u0432 \u0431\u0430\u043d\u043a\u0435")
    public final ooo.jtc.ui.common.sections.modals.ModalProcessingResult openProcessingModal(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0421\u0432\u0435\u0434\u0435\u043d\u0438\u044f \u043e \u0440\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442\u0430\u0445 \u043f\u0440\u0438\u0435\u043c\u043a\u0438 \u0432 \u0431\u0430\u043d\u043a\u0435")
    public final ooo.jtc.ui.common.sections.modals.ModalReceptionResult openReceptionModal(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.codeborne.selenide.SelenideElement getSElement() {
        return null;
    }
    
    public LetterToBankHistoryTab(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<ooo.jtc.ui.common.sections.tabs.HistoryRow> getHistoryRows() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0441\u0442\u0430\u0442\u0443\u0441\u044b \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0442\u0441\u044f \u0432 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044e\u0449\u0435\u043c \u0422\u0417 \u043f\u043e\u0440\u044f\u0434\u043a\u0435")
    public void checkStatusOrder(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatusOrder) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043f\u043e\u043b\u0435\u0439 \u0432\u043e \u0432\u0441\u0435\u0445 \u0441\u0442\u0430\u0442\u0443\u0441\u0430\u0445")
    public void checkAllFields(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432 \u0440\u0430\u0431\u043e\u0447\u0435\u0439 \u043e\u0431\u043b\u0430\u0441\u0442\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442\u0441\u044f \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u043e\u0434\u043d\u0430 \u0441\u0442\u0440\u043e\u043a\u0430")
    public void checkHistoryExist() {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432\u0435\u0440\u0445\u043d\u044f\u044f \u0441\u0442\u0440\u043e\u043a\u0430 \u0438\u0441\u0442\u043e\u0440\u0438\u0438 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u0442 \u0441\u0442\u0430\u0442\u0443\u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 = {expLastStatus}")
    public void checkLastStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String expLastStatus) {
    }
    
    public void clickDetailButton(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.documents.IDocumentStatus<?>> statuses, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
    }
    
    /**
     * Ожидание загрузки элементов закладки.
     */
    @java.lang.Override()
    public void waitTabOpens() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankHistoryTab openTab() {
        return null;
    }
}