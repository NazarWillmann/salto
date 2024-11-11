package ooo.jtc.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a<\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\u0010\u0005\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a\u0019\u0010\u0006\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0004H\u0086\b\u00a8\u0006\b"}, d2 = {"emptyLast", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "", "comparator", "isComparableTypeOf", "", "box-tests"})
public final class CustomComparatorsKt {
    
    /**
     * Provides a comparator of empty string [Comparable] values
     * considering `""` value greater than any other value.
     *
     * @sample samples.comparisons.Comparisons.nullsFirstLastComparator
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Comparable<? super T>>java.util.Comparator<T> emptyLast() {
        return null;
    }
    
    /**
     * Extends the given [comparator] of non-nullable values to a comparator of empty string values
     * considering `""` value greater than any other value.
     *
     * @sample samples.comparisons.Comparisons.nullsFirstLastWithComparator
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>java.util.Comparator<T> emptyLast(@org.jetbrains.annotations.NotNull()
    java.util.Comparator<? super T> comparator) {
        return null;
    }
}