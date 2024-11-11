package ooo.jtc.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0007\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0010"}, d2 = {"humanize", "", "getHumanize", "(Ljava/lang/String;)Ljava/lang/String;", "deduplication", "symbol", "reduceBatchesBy", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "ellipsis", "n", "postgresFormat", "randomSubstringPf", "toUUID", "Ljava/util/UUID;", "withoutSpaces", "qa-utils"})
public final class StringExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getHumanize(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$humanize) {
        return null;
    }
    
    /**
     * If string longer than [n], we take first [n] characters and add ellipsis points at the end.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ellipsis(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$ellipsis, int n) {
        return null;
    }
    
    /**
     * Returns substring with random starting position and length
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String randomSubstringPf(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$randomSubstringPf) {
        return null;
    }
    
    /**
     * Returns a new string with collapsed duplicated [symbol] (-s) to a single symbol in [this] string.
     *
     * @param symbol - symbol (or symbol sequence) that is duplicated in [this] string
     * @param reduceBatchesBy - size of batch that will be reduced to a single symbol. DEFAULT: [null]
     *
     * How to use:
     * 1) When [reduceBatchesBy] = [null] function collapses whole found batch, no matter its size.
     * E.g., "QQQwertyQQQQQeQQ".deduplication("Q") will result in "QwertyQeQ".
     * 2) When provided a certain number, function will collapse symbols only in batches of specified size.
     * E.g., "QQQwertyQQQQQeQQ".deduplication("Q", 3) will result in "QwertyQQQeQQ".
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String deduplication(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$deduplication, @org.jetbrains.annotations.NotNull()
    java.lang.String symbol, @org.jetbrains.annotations.Nullable()
    java.lang.Integer reduceBatchesBy) {
        return null;
    }
    
    /**
     * Remove duplication of Postgres ignoring symbols.
     * So far, there is only one symbol. But, if necessary, you can add others.
     * e.g. "1_ 2__ 3___ _4_" => "1_ 2_ 3_ _4"
     * removing underscore from begin and end of string
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String postgresFormat(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$postgresFormat) {
        return null;
    }
    
    /**
     * Returns new string without space characters
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String withoutSpaces(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$withoutSpaces) {
        return null;
    }
    
    /**
     * Returns uuid-string in uuid format.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.UUID toUUID(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$toUUID) {
        return null;
    }
}