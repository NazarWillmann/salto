package ooo.jtc.aspectj;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/aspectj/GenerexRandomControl;", "", "()V", "handleRandom", "", "joinPoint", "Lorg/aspectj/lang/ProceedingJoinPoint;", "qa-utils"})
@org.aspectj.lang.annotation.Aspect()
public final class GenerexRandomControl {
    
    /**
     * Formatting random generated by [Generex] data.
     */
    @org.jetbrains.annotations.NotNull()
    @org.aspectj.lang.annotation.Around(value = "execution(* com.mifmif.common.regex.Generex.random(..))")
    public final java.lang.String handleRandom(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.ProceedingJoinPoint joinPoint) throws java.lang.Throwable {
        return null;
    }
    
    public GenerexRandomControl() {
        super();
    }
}