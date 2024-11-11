package ooo.jtc.generic.parsers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0015J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0003R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/generic/parsers/HtmlParser;", "Looo/jtc/generic/parsers/FormatParser;", "()V", "STRANGE_SYMBOLS", "", "", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "parse", "", "", "byteArray", "", "replaceSymbols", "str", "datamodels"})
public final class HtmlParser extends ooo.jtc.generic.parsers.FormatParser {
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    private static final java.util.Map<java.lang.Character, java.lang.Character> STRANGE_SYMBOLS = null;
    public static final ooo.jtc.generic.parsers.HtmlParser INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.slf4j.Logger getLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 HTML \u043a\u0430\u043a \u0441\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0440\u043e\u043a")
    protected java.util.List<java.lang.String> parse(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0417\u0430\u043c\u0435\u043d\u0438\u0442\u044c \u0441\u0442\u0440\u0430\u043d\u043d\u044b\u0435 \u0441\u0438\u043c\u0432\u043e\u043b\u044b")
    private final java.lang.String replaceSymbols(java.lang.String str) {
        return null;
    }
    
    private HtmlParser() {
        super();
    }
}