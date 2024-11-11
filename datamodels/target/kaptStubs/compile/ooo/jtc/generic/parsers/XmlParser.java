package ooo.jtc.generic.parsers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0015R\u001b\u0010\u0003\u001a\u00020\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/generic/parsers/XmlParser;", "Looo/jtc/generic/parsers/FormatParser;", "()V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "getNodeTextValues", "", "source", "Lorg/w3c/dom/Node;", "destination", "", "", "recursionDepth", "", "recursionDepthLimit", "parse", "", "byteArray", "", "datamodels"})
public final class XmlParser extends ooo.jtc.generic.parsers.FormatParser {
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    public static final ooo.jtc.generic.parsers.XmlParser INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.slf4j.Logger getLog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 XML \u043a\u0430\u043a \u0441\u043f\u0438\u0441\u043e\u043a \u0441\u0442\u0440\u043e\u043a")
    protected java.util.List<java.lang.String> parse(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
        return null;
    }
    
    /**
     * (!) Recursive function (!)
     * Used to get all text values of provided [source] XML node.
     *
     * @param source - XML node.
     * @param destination - mutable list of string. It will contain all of [source] fields' text values.
     * @param recursionDepth - recursion depth of current iteration. Starts at [0].
     * @param recursionDepthLimit - depth limit for this recursive function. Default value is [5].
     */
    private final void getNodeTextValues(org.w3c.dom.Node source, java.util.List<java.lang.String> destination, int recursionDepth, int recursionDepthLimit) {
    }
    
    private XmlParser() {
        super();
    }
}