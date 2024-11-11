package ooo.jtc.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u00020\u00038\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Looo/jtc/core/TestDataStrategy;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "FROM_FILE", "FROM_DB", "box-tests"})
public enum TestDataStrategy {
    /*public static final*/ FROM_FILE /* = new FROM_FILE(null) */,
    /*public static final*/ FROM_DB /* = new FROM_DB(null) */;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value;
    
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonValue()
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    TestDataStrategy(java.lang.String value) {
    }
}