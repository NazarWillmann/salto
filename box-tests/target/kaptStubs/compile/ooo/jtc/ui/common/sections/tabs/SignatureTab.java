package ooo.jtc.ui.common.sections.tabs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0017J\u0012\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0017J\b\u0010\u0016\u001a\u00020\u0013H\u0017J\b\u0010\u0017\u001a\u00020\u0013H\u0017J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0016\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0017R\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Looo/jtc/ui/common/sections/tabs/SignatureTab;", "T", "Looo/jtc/ui/common/sections/tabs/TabSection;", "R", "Looo/jtc/ui/common/sections/tabs/SignatureRow;", "createRow", "Lkotlin/Function1;", "Lcom/codeborne/selenide/SelenideElement;", "getCreateRow", "()Lkotlin/jvm/functions/Function1;", "signatureRows", "", "getSignatureRows", "()Ljava/util/List;", "tabName", "", "getTabName", "()Ljava/lang/String;", "checkInfoForDeliveredPlus", "", "expSignToolText", "checkInfoForSigned", "checkMessageForDraft", "checkMessageForNew", "getRowByUser", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)Looo/jtc/ui/common/sections/tabs/SignatureRow;", "makeUnSignActionByUser", "box-tests"})
@ooo.jtc.core.elements.ElementType(name = "\u0417\u0430\u043a\u043b\u0430\u0434\u043a\u0430 \'\u041f\u043e\u0434\u043f\u0438\u0441\u0438\'")
public abstract interface SignatureTab<T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow> extends ooo.jtc.ui.common.sections.tabs.TabSection<T> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract java.lang.String getTabName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<com.codeborne.selenide.SelenideElement, R> getCreateRow();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<R> getSignatureRows();
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0432\u0435\u0440\u043d\u043e\u0433\u043e \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u044f \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \'\u0427\u0435\u0440\u043d\u043e\u0432\u0438\u043a\'")
    public abstract void checkMessageForDraft();
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0432\u0435\u0440\u043d\u043e\u0433\u043e \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u044f \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \'\u041d\u0430 \u043f\u043e\u0434\u043f\u0438\u0441\u044c\'")
    public abstract void checkMessageForNew();
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0441\u0432\u0435\u0434\u0435\u043d\u0438\u0439 \u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \u0432\u044b\u0448\u0435 \'\u041e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\'")
    public abstract void checkInfoForDeliveredPlus(@org.jetbrains.annotations.NotNull()
    java.lang.String expSignToolText);
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0441\u0432\u0435\u0434\u0435\u043d\u0438\u0439 \u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \'\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u043d/\u0427\u0430\u0441\u0442\u0438\u0447\u043d\u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\'")
    public abstract void checkInfoForSigned(@org.jetbrains.annotations.NotNull()
    java.lang.String expSignToolText);
    
    @org.jetbrains.annotations.NotNull()
    public abstract R getRowByUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user);
    
    @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \u0441\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f \'{user.login}\'")
    public abstract void makeUnSignActionByUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>java.util.List<R> getSignatureRows(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this) {
            return null;
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0432\u0435\u0440\u043d\u043e\u0433\u043e \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u044f \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \'\u0427\u0435\u0440\u043d\u043e\u0432\u0438\u043a\'")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>void checkMessageForDraft(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this) {
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0432\u0435\u0440\u043d\u043e\u0433\u043e \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u044f \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \'\u041d\u0430 \u043f\u043e\u0434\u043f\u0438\u0441\u044c\'")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>void checkMessageForNew(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this) {
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0441\u0432\u0435\u0434\u0435\u043d\u0438\u0439 \u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \u0432\u044b\u0448\u0435 \'\u041e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\'")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>void checkInfoForDeliveredPlus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        java.lang.String expSignToolText) {
        }
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043e\u0442\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0441\u0432\u0435\u0434\u0435\u043d\u0438\u0439 \u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0438 \u0434\u043b\u044f \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \'\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u043d/\u0427\u0430\u0441\u0442\u0438\u0447\u043d\u043e \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u043d\'")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>void checkInfoForSigned(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        java.lang.String expSignToolText) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>R getRowByUser(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.User user) {
            return null;
        }
        
        @io.qameta.allure.Step(value = "\u0412\u044b\u0431\u0440\u0430\u0442\u044c \u0434\u0435\u0439\u0441\u0442\u0432\u0438\u0435 \u0441\u043d\u044f\u0442\u044c \u043f\u043e\u0434\u043f\u0438\u0441\u044c \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f \'{user.login}\'")
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>void makeUnSignActionByUser(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.User user) {
        }
        
        /**
         * Ожидание загрузки элементов закладки.
         */
        @java.lang.Override()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>void waitTabOpens(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @java.lang.Override()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>T openTab(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static <T extends ooo.jtc.ui.common.sections.tabs.TabSection<T>, R extends ooo.jtc.ui.common.sections.tabs.SignatureRow>com.codeborne.selenide.SelenideElement getContext(@org.jetbrains.annotations.NotNull()
        ooo.jtc.ui.common.sections.tabs.SignatureTab<T, R> $this) {
            return null;
        }
    }
}