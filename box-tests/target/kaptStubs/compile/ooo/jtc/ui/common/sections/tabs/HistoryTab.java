package ooo.jtc.ui.common.sections.tabs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \"*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\"J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u0018H\u0017J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0010H\u0017J\u0016\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0017J\"\u0010 \u001a\u00020\u00182\u0010\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u0010X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006#"}, d2 = {"Looo/jtc/ui/common/sections/tabs/HistoryTab;", "T", "Looo/jtc/ui/common/sections/tabs/TabSection;", "R", "Looo/jtc/ui/common/sections/tabs/HistoryRow;", "createRow", "Lkotlin/Function1;", "Lcom/codeborne/selenide/SelenideElement;", "getCreateRow", "()Lkotlin/jvm/functions/Function1;", "detailStatuses", "", "Looo/jtc/documents/IDocumentStatus;", "getDetailStatuses", "()Ljava/util/List;", "headerName", "", "getHeaderName", "()Ljava/lang/String;", "setHeaderName", "(Ljava/lang/String;)V", "historyRows", "getHistoryRows", "checkAllFields", "", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "checkHistoryExist", "checkLastStatus", "expLastStatus", "checkStatusOrder", "expStatusOrder", "clickDetailButton", "statuses", "Companion", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0412\u043a\u043b\u0430\u0434\u043a\u0430 \'\u0418\u0441\u0442\u043e\u0440\u0438\u044f \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0438\u0439\'")
public abstract interface HistoryTab<T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow> extends ooo.jtc.ui.common.sections.tabs.TabSection<T> {
    public static final ooo.jtc.ui.common.sections.tabs.HistoryTab.Companion Companion = null;
    
    /**
     * Тип документа
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getHeaderName();
    
    /**
     * Тип документа
     */
    public abstract void setHeaderName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    /**
     * Функция, которая создает объект строки [R] из [SelenideElement].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<com.codeborne.selenide.SelenideElement, R> getCreateRow();
    
    /**
     * Статусы в которых должна отображаться кнопка "Подробнее".
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<ooo.jtc.documents.IDocumentStatus<?>> getDetailStatuses();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<R> getHistoryRows();
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0441\u0442\u0430\u0442\u0443\u0441\u044b \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0442\u0441\u044f \u0432 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044e\u0449\u0435\u043c \u0422\u0417 \u043f\u043e\u0440\u044f\u0434\u043a\u0435")
    public abstract void checkStatusOrder(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> expStatusOrder);
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043f\u043e\u043b\u0435\u0439 \u0432\u043e \u0432\u0441\u0435\u0445 \u0441\u0442\u0430\u0442\u0443\u0441\u0430\u0445")
    public abstract void checkAllFields(@org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType);
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432 \u0440\u0430\u0431\u043e\u0447\u0435\u0439 \u043e\u0431\u043b\u0430\u0441\u0442\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442\u0441\u044f \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u043e\u0434\u043d\u0430 \u0441\u0442\u0440\u043e\u043a\u0430")
    public abstract void checkHistoryExist();
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432\u0435\u0440\u0445\u043d\u044f\u044f \u0441\u0442\u0440\u043e\u043a\u0430 \u0438\u0441\u0442\u043e\u0440\u0438\u0438 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u0442 \u0441\u0442\u0430\u0442\u0443\u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 = {expLastStatus}")
    public abstract void checkLastStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String expLastStatus);
    
    public abstract void clickDetailButton(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.documents.IDocumentStatus<?>> statuses, @org.jetbrains.annotations.NotNull()
    ooo.jtc.ui.common.pages.ApplicationPageType pageType);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>java.util.List<R> getHistoryRows(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this) {
            return null;
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0441\u0442\u0430\u0442\u0443\u0441\u044b \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u044e\u0442\u0441\u044f \u0432 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044e\u0449\u0435\u043c \u0422\u0417 \u043f\u043e\u0440\u044f\u0434\u043a\u0435")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>void checkStatusOrder(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> expStatusOrder) {
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u043f\u043e\u043b\u0435\u0439 \u0432\u043e \u0432\u0441\u0435\u0445 \u0441\u0442\u0430\u0442\u0443\u0441\u0430\u0445")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>void checkAllFields(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432 \u0440\u0430\u0431\u043e\u0447\u0435\u0439 \u043e\u0431\u043b\u0430\u0441\u0442\u0438 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0430\u0435\u0442\u0441\u044f \u043c\u0438\u043d\u0438\u043c\u0443\u043c \u043e\u0434\u043d\u0430 \u0441\u0442\u0440\u043e\u043a\u0430")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>void checkHistoryExist(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this) {
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0432\u0435\u0440\u0445\u043d\u044f\u044f \u0441\u0442\u0440\u043e\u043a\u0430 \u0438\u0441\u0442\u043e\u0440\u0438\u0438 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u0442 \u0441\u0442\u0430\u0442\u0443\u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 = {expLastStatus}")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>void checkLastStatus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        java.lang.String expLastStatus) {
        }
        
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>void clickDetailButton(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        java.util.List<? extends ooo.jtc.documents.IDocumentStatus<?>> statuses, @org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
        }
        
        /**
         * Ожидание загрузки элементов закладки.
         */
        @java.lang.Override()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>void waitTabOpens(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @java.lang.Override()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>T openTab(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.HistoryRow>com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.HistoryTab<T, R> $this) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Looo/jtc/ui/common/sections/tabs/HistoryTab$Companion;", "", "()V", "getHistoryStatusTransform", "Lkotlin/Function1;", "Looo/jtc/documents/IDocumentStatus;", "", "pageType", "Looo/jtc/ui/common/pages/ApplicationPageType;", "box-tests"})
    public static final class Companion {
        
        /**
         * Возвращает функцию маппинга из IDocumentStatus<*> в значение, которое выводится на фронте,
         * в зависимости от [pageType].
         * e.g.: NEW -> На подпись.
         */
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<ooo.jtc.documents.IDocumentStatus<?>, java.lang.String> getHistoryStatusTransform(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.pages.ApplicationPageType pageType) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}