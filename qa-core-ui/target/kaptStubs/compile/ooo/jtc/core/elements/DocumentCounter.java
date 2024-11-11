package ooo.jtc.core.elements;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0006\u0010\u0010\u001a\u00020\u0005R\u0011\u0010\u0007\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/core/elements/DocumentCounter;", "Looo/jtc/core/container/SContainer;", "parentElement", "Lcom/codeborne/selenide/SelenideElement;", "dataType", "Looo/jtc/core/elements/DocumentCounter$DocumentCounterType;", "(Lcom/codeborne/selenide/SelenideElement;Looo/jtc/core/elements/DocumentCounter$DocumentCounterType;)V", "counter", "getCounter", "()Looo/jtc/core/container/SContainer;", "checkCounter", "", "docCount", "", "docCounterText", "", "getType", "DocumentCounterType", "qa-core-ui"})
@ElementType(name = "\u0421\u0447\u0435\u0442\u0447\u0438\u043a \u043a\u043e\u043b-\u0432\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
public final class DocumentCounter extends ooo.jtc.core.container.SContainer {
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.container.SContainer getCounter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.elements.DocumentCounter.DocumentCounterType getType() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u044f\u0435\u043c \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u0438 \u0442\u0435\u043a\u0441\u0442 \u0441\u0447\u0435\u0442\u0447\u0438\u043a\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
    public final void checkCounter(int docCount, @org.jetbrains.annotations.NotNull()
    java.lang.String docCounterText) {
    }
    
    public DocumentCounter(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement parentElement, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.elements.DocumentCounter.DocumentCounterType dataType) {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/core/elements/DocumentCounter$DocumentCounterType;", "", "(Ljava/lang/String;I)V", "INFO", "ERROR", "SUCCESS", "WARNING", "qa-core-ui"})
    public static enum DocumentCounterType {
        /*public static final*/ INFO /* = new INFO() */,
        /*public static final*/ ERROR /* = new ERROR() */,
        /*public static final*/ SUCCESS /* = new SUCCESS() */,
        /*public static final*/ WARNING /* = new WARNING() */;
        
        DocumentCounterType() {
        }
    }
}