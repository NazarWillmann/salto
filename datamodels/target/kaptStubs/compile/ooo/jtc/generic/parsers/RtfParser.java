package ooo.jtc.generic.parsers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u000eH\u0015J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/generic/parsers/RtfParser;", "Looo/jtc/generic/parsers/FormatParser;", "()V", "LINE_START", "", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "parse", "", "byteArray", "", "removeRtfInfo", "strings", "datamodels"})
public final class RtfParser extends ooo.jtc.generic.parsers.FormatParser {
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    private static final java.lang.String LINE_START = "fLine0";
    public static final ooo.jtc.generic.parsers.RtfParser INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.slf4j.Logger getLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 RTF \u043a\u0430\u043a \u0441\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0440\u043e\u043a")
    protected java.util.List<java.lang.String> parse(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
        return null;
    }
    
    private final java.util.List<java.lang.String> removeRtfInfo(java.util.List<java.lang.String> strings) {
        return null;
    }
    
    private RtfParser() {
        super();
    }
}