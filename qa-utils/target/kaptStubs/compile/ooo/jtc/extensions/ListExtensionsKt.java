package ooo.jtc.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004\u001a=\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u0002H\u00060\b\u00a2\u0006\u0002\u0010\t\u001aE\u0010\n\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\f\"\u0002H\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"createOrEmpty", "", "T", "provider", "Lkotlin/Function0;", "ifNotEmpty", "R", "block", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "randomAnother", "providedEntities", "", "filterByField", "", "(Ljava/util/List;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "qa-utils"})
public final class ListExtensionsKt {
    
    /**
     * Create List from provider. Return empty list if it failed.
     *
     * @return created list as [List]
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>java.util.List<T> createOrEmpty(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends T>> provider) {
        return null;
    }
    
    /**
     * Get random entity from list, that is not one of [providedEntities].
     * Entities in list can be mapped with [filterByField], if additional mapping is needed
     */
    public static final <T extends java.lang.Object>T randomAnother(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> $this$randomAnother, @org.jetbrains.annotations.NotNull()
    T[] providedEntities, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> filterByField) {
        return null;
    }
    
    /**
     * Like [let] for list.
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object, R extends java.lang.Object>R ifNotEmpty(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> $this$ifNotEmpty, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, ? extends R> block) {
        return null;
    }
}