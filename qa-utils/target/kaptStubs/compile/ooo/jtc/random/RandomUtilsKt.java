package ooo.jtc.random;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007\u001a(\u0010\b\u001a\u00020\t*\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"GENEREX_MAX_LENGTH", "", "nextBigDecimal", "Ljava/math/BigDecimal;", "Lkotlin/random/Random;", "min", "max", "", "nextLocalDate", "Ljava/time/LocalDate;", "initialDate", "maxPlusDays", "", "maxMinusDays", "qa-utils"})
public final class RandomUtilsKt {
    
    /**
     * Maximum supported length for [String] generation.
     * [Generex] fails to generate long [String] with provided patterns (StackOverflowError).
     */
    public static final int GENEREX_MAX_LENGTH = 4100;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.math.BigDecimal nextBigDecimal(@org.jetbrains.annotations.NotNull()
    kotlin.random.Random $this$nextBigDecimal, double min, double max) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.math.BigDecimal nextBigDecimal(@org.jetbrains.annotations.NotNull()
    kotlin.random.Random $this$nextBigDecimal, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal min, @org.jetbrains.annotations.NotNull()
    java.math.BigDecimal max) {
        return null;
    }
    
    /**
     * Returns random date in range [[initialDate] - [maxMinusDays]; [initialDate] + [maxPlusDays]],
     * bounds included.
     *
     * @param maxMinusDays must be non-negative, if specified
     * @param maxPlusDays must be non-negative, if specified
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.time.LocalDate nextLocalDate(@org.jetbrains.annotations.NotNull()
    kotlin.random.Random $this$nextLocalDate, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate initialDate, long maxPlusDays, long maxMinusDays) {
        return null;
    }
}