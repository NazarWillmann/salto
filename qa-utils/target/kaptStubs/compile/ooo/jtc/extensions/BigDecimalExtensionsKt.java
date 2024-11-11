package ooo.jtc.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"ANTIE_NUMBER_PATTERN", "", "DEFAULT_DECIMAL_DELIMITER", "", "DEFAULT_DIGIT_GROUP_DELIMITER", "DEFAULT_NUMBER_PATTERN", "formatNumber", "Ljava/math/BigDecimal;", "format", "groups", "decimal", "qa-utils"})
public final class BigDecimalExtensionsKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DEFAULT_NUMBER_PATTERN = ",##0.00";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ANTIE_NUMBER_PATTERN = ",##0";
    public static final char DEFAULT_DIGIT_GROUP_DELIMITER = ' ';
    public static final char DEFAULT_DECIMAL_DELIMITER = '.';
    
    /**
     * Convert number for need format.
     *
     * @param format return format.
     * @param groups discharge delimiter.
     * @param decimal decimal delimiter.
     * @return value in needed format.
     *
     * @see DecimalFormat
     * @see DecimalFormatSymbols
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatNumber(@org.jetbrains.annotations.NotNull()
    java.math.BigDecimal $this$formatNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String format, char groups, char decimal) {
        return null;
    }
}