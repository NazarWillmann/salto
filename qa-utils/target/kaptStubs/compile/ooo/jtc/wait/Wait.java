package ooo.jtc.wait;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Looo/jtc/wait/Wait;", "", "()V", "Companion", "qa-utils"})
public final class Wait {
    public static final long DEFAULT_POLLING_RATE = 1L;
    public static final long DEFAULT_TIMEOUT = 60L;
    @org.jetbrains.annotations.NotNull()
    private static final java.time.temporal.ChronoUnit DEFAULT_TEMPORAL_UNITS = java.time.temporal.ChronoUnit.SECONDS;
    public static final ooo.jtc.wait.Wait.Companion Companion = null;
    
    public Wait() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002Ja\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0002\u0010\u0014JI\u0010\u0015\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0016J=\u0010\u0017\u001a\u00020\u00182\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/wait/Wait$Companion;", "", "()V", "DEFAULT_POLLING_RATE", "", "DEFAULT_TEMPORAL_UNITS", "Ljava/time/temporal/ChronoUnit;", "getDEFAULT_TEMPORAL_UNITS", "()Ljava/time/temporal/ChronoUnit;", "DEFAULT_TIMEOUT", "forCondition", "T", "supplier", "Lkotlin/Function0;", "condition", "Lkotlin/Function1;", "", "pollingRate", "timeout", "chronoUnits", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/Long;Ljava/lang/Long;Ljava/time/temporal/ChronoUnit;)Ljava/lang/Object;", "forResult", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Long;Ljava/lang/Long;Ljava/time/temporal/ChronoUnit;)Ljava/lang/Object;", "until", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Long;Ljava/lang/Long;Ljava/time/temporal/ChronoUnit;)V", "qa-utils"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.time.temporal.ChronoUnit getDEFAULT_TEMPORAL_UNITS() {
            return null;
        }
        
        public final void until(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<java.lang.Boolean> supplier, @org.jetbrains.annotations.Nullable()
        java.lang.Long pollingRate, @org.jetbrains.annotations.Nullable()
        java.lang.Long timeout, @org.jetbrains.annotations.Nullable()
        java.time.temporal.ChronoUnit chronoUnits) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>T forResult(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends T> supplier, @org.jetbrains.annotations.Nullable()
        java.lang.Long pollingRate, @org.jetbrains.annotations.Nullable()
        java.lang.Long timeout, @org.jetbrains.annotations.Nullable()
        java.time.temporal.ChronoUnit chronoUnits) {
            return null;
        }
        
        private final <T extends java.lang.Object>T forCondition(kotlin.jvm.functions.Function0<? extends T> supplier, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> condition, java.lang.Long pollingRate, java.lang.Long timeout, java.time.temporal.ChronoUnit chronoUnits) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}