package ooo.jtc.core.container;

import java.lang.System;

/**
 * Динамическое создание элементов по входящему в локатор тексту.
 *
 * @param creator - функция, создающая элемент с учетом принимаемого параметра `param`.
 * e.g.
 * ```
 * creator: (String) -> Button = {it -> Button(sElement = find("[name='$it']"))}
 * ```
 * см. [ooo.jtc.core.elements.AllElements.buttonByName]
 * ```
 * val buttonByName get() = SElementGet { Button(sElement = this.find("[name='$it']")) => buttonByName["code"]
 * ```
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Looo/jtc/core/container/SElementGet;", "T", "Looo/jtc/core/container/SContainer;", "", "creator", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "getCreator", "()Lkotlin/jvm/functions/Function1;", "get", "param", "(Ljava/lang/String;)Looo/jtc/core/container/SContainer;", "qa-core-ui"})
public final class SElementGet<T extends ooo.jtc.core.container.SContainer> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, T> creator = null;
    
    @org.jetbrains.annotations.NotNull()
    public final T get(@org.jetbrains.annotations.NotNull()
    java.lang.String param) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.lang.String, T> getCreator() {
        return null;
    }
    
    public SElementGet(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, ? extends T> creator) {
        super();
    }
}