package ooo.jtc.generic.parsers;

import java.lang.System;

/**
 * General methods for parsing printed and exported documents in different formats.
 * Used as a template for parser classes.
 * Every *Parser class should be set for its format in [ParserFacade]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0004J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u0013\u001a\u00020\u0014H$J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\u0005J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u0013\u001a\u00020\u0014R>\u0010\u0003\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/generic/parsers/FormatParser;", "", "()V", "isWordDashWrap", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "s1", "newDelimiter", "", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "", "content", "", "parse", "byteArray", "", "parseContent", "parseContentToListOfStrings", "datamodels"})
public abstract class FormatParser {
    
    /**
     * Check if the word [s1] ends with dash [-] and [newDelimiter] == " ".
     * Then we should skip this [newDelimiter], because it's very likely will affects our expects.
     * e.g.
     * ```
     * s1="Предложения по улучшению WEB-"
     * s2="версии системы"
     * ```
     * If [newDelimiter] == " " then we get "Предложения по улучшению WEB- версии системы",
     * but we expect "Предложения по улучшению WEB-версии системы".
     */
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, java.lang.Boolean> isWordDashWrap = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract org.slf4j.Logger getLog();
    
    @org.jetbrains.annotations.NotNull()
    protected abstract java.util.List<java.lang.String> parse(@org.jetbrains.annotations.NotNull()
    byte[] byteArray);
    
    protected final void log(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> content) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> parseContentToListOfStrings(@org.jetbrains.annotations.NotNull()
    byte[] byteArray) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String parseContent(@org.jetbrains.annotations.NotNull()
    byte[] byteArray, @org.jetbrains.annotations.NotNull()
    java.lang.String newDelimiter) {
        return null;
    }
    
    public FormatParser() {
        super();
    }
}