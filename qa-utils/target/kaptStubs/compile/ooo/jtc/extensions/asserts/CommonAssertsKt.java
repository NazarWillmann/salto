package ooo.jtc.extensions.asserts;

import java.lang.System;

@kotlin.Suppress(names = {"UNUSED_PARAMETER"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a)\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"assertEq", "", "T", "compareWith", "stepName", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)V", "assertIsNotEmpty", "(Ljava/lang/Object;Ljava/lang/String;)V", "qa-utils"})
public final class CommonAssertsKt {
    
    /**
     * Check two object equals.
     *
     * @param compareWith - Object to compare
     * @param stepName - hint message
     */
    @ooo.jtc.aspectj.IgnoreHamcrestAllureStep()
    @io.qameta.allure.Step(value = "{stepName}")
    public static final <T extends java.lang.Object>void assertEq(T $this$assertEq, T compareWith, @org.jetbrains.annotations.NotNull()
    java.lang.String stepName) {
    }
    
    /**
     * Check object is not null.
     *
     * Also, if it's a list, a map or a string - check that it's not empty
     *
     * @param stepName - hint message
     */
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @ooo.jtc.aspectj.IgnoreHamcrestAllureStep()
    @io.qameta.allure.Step(value = "{stepName}")
    public static final <T extends java.lang.Object>void assertIsNotEmpty(T $this$assertIsNotEmpty, @org.jetbrains.annotations.NotNull()
    java.lang.String stepName) {
    }
}