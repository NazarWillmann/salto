package ooo.jtc.asserts;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u001a&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f\u001a>\u0010\u000e\u001a\u00020\b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u001a\'\u0010\u0014\u001a\u00020\b\"\b\b\u0000\u0010\u0015*\u00020\u00112\u0006\u0010\u0016\u001a\u0002H\u00152\u0006\u0010\u0017\u001a\u0002H\u0015H\u0007\u00a2\u0006\u0002\u0010\u0018\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0019"}, d2 = {"logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "getLogger", "()Lorg/slf4j/Logger;", "logger$delegate", "Lkotlin/Lazy;", "assertEqualList", "", "listName", "", "expList", "", "actList", "assertEqualMaps", "expMap", "", "", "actMap", "mapName", "assertObjectsEqual", "T", "expected", "actual", "(Ljava/lang/Object;Ljava/lang/Object;)V", "qa-utils"})
public final class CommonAssertsKt {
    private static final kotlin.Lazy logger$delegate = null;
    
    private static final org.slf4j.Logger getLogger() {
        return null;
    }
    
    /**
     * Assert that [actMap] map's values equals to [expMap] map's values.
     */
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public static final void assertEqualMaps(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> expMap, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> actMap, @org.jetbrains.annotations.Nullable()
    java.lang.String mapName) {
    }
    
    /**
     * Assert that elements [expList] are equals to [actList].
     * [listName] - name of list field.
     */
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public static final void assertEqualList(@org.jetbrains.annotations.NotNull()
    java.lang.String listName, @org.jetbrains.annotations.NotNull()
    java.util.List<?> expList, @org.jetbrains.annotations.NotNull()
    java.util.List<?> actList) {
    }
    
    @io.qameta.allure.Step(value = "\u0421\u0440\u0430\u0432\u043d\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u044b\u0439 \u0438 \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u043d\u044b\u0439 \u043e\u0431\u044a\u0435\u043a\u0442\u044b")
    public static final <T extends java.lang.Object>void assertObjectsEqual(@org.jetbrains.annotations.NotNull()
    T expected, @org.jetbrains.annotations.NotNull()
    T actual) {
    }
}