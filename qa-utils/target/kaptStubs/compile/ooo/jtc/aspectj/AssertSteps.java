package ooo.jtc.aspectj;

import java.lang.System;

/**
 * Аспекты для динамического добавления шагов в Allure
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/aspectj/AssertSteps;", "", "()V", "addStep", "", "joinPoint", "Lorg/aspectj/lang/ProceedingJoinPoint;", "name", "", "params", "", "Lio/qameta/allure/model/Parameter;", "addStepMatherDescription", "addStepWithReason", "shouldIgnoreStep", "", "withMatcher", "withReason", "qa-utils"})
@org.aspectj.lang.annotation.Aspect()
public final class AssertSteps {
    
    /**
     * Перехват MatcherAssert.assertThat(String, boolean)
     */
    @org.aspectj.lang.annotation.Pointcut(value = "execution(* org.hamcrest.MatcherAssert.assertThat(String, boolean))")
    public final void withReason() {
    }
    
    /**
     * Перехват MatcherAssert.assertThat(String, Object, ..)
     */
    @org.aspectj.lang.annotation.Pointcut(value = "execution(* org.hamcrest.MatcherAssert.assertThat(String, Object, ..))")
    public final void withMatcher() {
    }
    
    /**
     * Добавление шага в Allure при срабатывании  MatcherAssert.assertThat(String, boolean)
     */
    @org.aspectj.lang.annotation.Around(value = "withReason()")
    public final void addStepWithReason(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.ProceedingJoinPoint joinPoint) throws java.lang.Throwable {
    }
    
    /**
     * Добавление шага в Allure при срабатывании  MatcherAssert.assertThat(String, Object, ..)
     */
    @org.aspectj.lang.annotation.Around(value = "withMatcher()")
    public final void addStepMatherDescription(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.ProceedingJoinPoint joinPoint) throws java.lang.Throwable {
    }
    
    /**
     * Формирование шага allure.
     */
    private final void addStep(org.aspectj.lang.ProceedingJoinPoint joinPoint, java.lang.String name, java.util.List<? extends io.qameta.allure.model.Parameter> params) {
    }
    
    private final boolean shouldIgnoreStep() {
        return false;
    }
    
    public AssertSteps() {
        super();
    }
}