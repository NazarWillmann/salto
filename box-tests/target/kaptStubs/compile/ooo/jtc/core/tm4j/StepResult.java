package ooo.jtc.core.tm4j;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/core/tm4j/StepResult;", "", "index", "", "comment", "", "status", "Looo/jtc/core/tm4j/Tm4jStatus;", "(ILjava/lang/String;Looo/jtc/core/tm4j/Tm4jStatus;)V", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "getIndex", "()I", "setIndex", "(I)V", "getStatus", "()Looo/jtc/core/tm4j/Tm4jStatus;", "setStatus", "(Looo/jtc/core/tm4j/Tm4jStatus;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "box-tests"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public final class StepResult {
    
    /**
     * Step order number.
     */
    private int index;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String comment;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.tm4j.Tm4jStatus status;
    
    /**
     * Step order number.
     */
    public final int getIndex() {
        return 0;
    }
    
    /**
     * Step order number.
     */
    public final void setIndex(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getComment() {
        return null;
    }
    
    public final void setComment(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.Tm4jStatus getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jStatus p0) {
    }
    
    public StepResult(int index, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jStatus status) {
        super();
    }
    
    /**
     * Step order number.
     */
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.Tm4jStatus component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.StepResult copy(int index, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}