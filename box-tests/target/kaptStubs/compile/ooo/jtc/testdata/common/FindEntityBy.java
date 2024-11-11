package ooo.jtc.testdata.common;

import java.lang.System;

/**
 * Predicate for searching entity
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005R$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Looo/jtc/testdata/common/FindEntityBy;", "T", "Looo/jtc/interfaces/IEntity;", "R", "Looo/jtc/testdata/common/TestData;", "", "predicate", "Lkotlin/Function1;", "", "getPredicate", "()Lkotlin/jvm/functions/Function1;", "setPredicate", "(Lkotlin/jvm/functions/Function1;)V", "box-tests"})
public abstract interface FindEntityBy<T extends ooo.jtc.interfaces.IEntity, R extends ooo.jtc.testdata.common.TestData<T>> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<T, java.lang.Boolean> getPredicate();
    
    public abstract void setPredicate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> p0);
}