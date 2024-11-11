package ooo.jtc.asserts;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aG\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000224\u0010\u0003\u001a\u001b\u0012\u0017\b\u0001\u0012\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u00070\u0004\"\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0007\u00a2\u0006\u0002\u0010\b\u001aC\u0010\t\u001a\u00020\u000126\u0010\u0003\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u0004\"\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\u0002\u0010\r\u001a&\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u001a-\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\u0002\b\u0007\"\u0004\b\u0000\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u001a\u000e\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0006\u001a1\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u00022\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0007\u001a1\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\b\u0000\u0010\u00022\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0007\u001aW\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0018\"\u0004\b\u0000\u0010\u0002*\u00020\u000624\u0010\u0003\u001a\u001b\u0012\u0017\b\u0001\u0012\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u00070\u0004\"\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0007\u00a2\u0006\u0002\u0010\u001a\u001aS\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0018*\u00020\u000626\u0010\u0003\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u0004\"\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\u0002\u0010\u001b\u001aG\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u0018\"\b\b\u0000\u0010\u0013*\u00020\u001c\"\u0004\b\u0001\u0010\u0002*\u0002H\u00132\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0007H\u0086\u0004\u00a2\u0006\u0002\u0010\u001d\u001a\u001b\u0010\u001e\u001a\u00020\u0001*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086\u0004\u001aG\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u0018\"\b\b\u0000\u0010\u0013*\u00020\u001c\"\u0004\b\u0001\u0010\u0002*\u0002H\u00132\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00020\u0005\u00a2\u0006\u0002\b\u0007H\u0086\u0004\u00a2\u0006\u0002\u0010\u001d\u001a\u001b\u0010\u001f\u001a\u00020\u0001*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086\u0004\u00a8\u0006 "}, d2 = {"allShould", "", "R", "scripts", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlin/jvm/functions/Function1;)V", "allShouldTrue", "Lkotlin/Pair;", "Lkotlin/Function0;", "", "([Lkotlin/Pair;)V", "assert", "isSoft", "reason", "script", "castToExt", "T", "infun", "checkSoftAsserts", "allureTestName", "must", "Looo/jtc/scripts/Invoke;", "should", "(Ljava/lang/String;[Lkotlin/jvm/functions/Function1;)Looo/jtc/scripts/Invoke;", "(Ljava/lang/String;[Lkotlin/Pair;)Looo/jtc/scripts/Invoke;", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Looo/jtc/scripts/Invoke;", "mustTrue", "shouldTrue", "qa-utils"})
public final class SoftAssertsKt {
    
    /**
     * Infix function for soft script execution.
     *
     * [script] will be executed with soft errors
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object>ooo.jtc.scripts.Invoke<T, R> should(@org.jetbrains.annotations.NotNull()
    T $this$should, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> script) {
        return null;
    }
    
    /**
     * function for soft script execution.
     */
    @org.jetbrains.annotations.NotNull()
    public static final <R extends java.lang.Object>ooo.jtc.scripts.Invoke<java.lang.String, R> should(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, ? extends R> script) {
        return null;
    }
    
    /**
     * Assert all boolean functions from [scripts] in soft mode.
     */
    public static final void allShouldTrue(@org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, ? extends kotlin.jvm.functions.Function0<java.lang.Boolean>>... scripts) {
    }
    
    /**
     * Assert all boolean functions from [scripts] in soft mode.
     * Can be package into common step
     */
    @org.jetbrains.annotations.NotNull()
    public static final ooo.jtc.scripts.Invoke<java.lang.String, kotlin.Unit> allShouldTrue(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$allShouldTrue, @org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, ? extends kotlin.jvm.functions.Function0<java.lang.Boolean>>... scripts) {
        return null;
    }
    
    /**
     * Execute all [scripts] in soft mode.
     */
    public static final <R extends java.lang.Object>void allShould(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, ? extends R>... scripts) {
    }
    
    /**
     * Execute all [scripts] in soft mode.
     * Can be package into common step
     */
    @org.jetbrains.annotations.NotNull()
    public static final <R extends java.lang.Object>ooo.jtc.scripts.Invoke<java.lang.String, kotlin.Unit> allShould(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$allShould, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, ? extends R>... scripts) {
        return null;
    }
    
    /**
     * Infix function for hard script execution.
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object>ooo.jtc.scripts.Invoke<T, R> must(@org.jetbrains.annotations.NotNull()
    T $this$must, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> script) {
        return null;
    }
    
    /**
     * Check [script] in hard mode.
     */
    @org.jetbrains.annotations.NotNull()
    public static final <R extends java.lang.Object>ooo.jtc.scripts.Invoke<java.lang.String, R> must(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, ? extends R> script) {
        return null;
    }
    
    /**
     * Check [script] in soft mode.
     */
    public static final void mustTrue(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$mustTrue, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> script) {
    }
    
    /**
     * Check boolean [script] in soft mode.
     */
    public static final void shouldTrue(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$shouldTrue, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<java.lang.Boolean> script) {
    }
    
    private static final <T extends java.lang.Object>kotlin.jvm.functions.Function1<T, java.lang.Boolean> castToExt(kotlin.jvm.functions.Function0<java.lang.Boolean> infun) {
        return null;
    }
    
    public static final void checkSoftAsserts(@org.jetbrains.annotations.NotNull()
    java.lang.String allureTestName) {
    }
}