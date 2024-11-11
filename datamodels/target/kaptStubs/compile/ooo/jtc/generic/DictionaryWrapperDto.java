package ooo.jtc.generic;

import java.lang.System;

/**
 * Generic wrapper for Dictionaries requests.
 * [failOnInvalid] - means how service will handle errors:
 * true - response status 500 with system error message
 * false - response 200 with control validationResult (default)
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00018\u0000X\u0096\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Looo/jtc/generic/DictionaryWrapperDto;", "T", "Looo/jtc/generic/GenericDto;", "data", "failOnInvalid", "", "(Ljava/lang/Object;Z)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getFailOnInvalid", "()Z", "setFailOnInvalid", "(Z)V", "component1", "component2", "copy", "(Ljava/lang/Object;Z)Looo/jtc/generic/DictionaryWrapperDto;", "equals", "other", "", "hashCode", "", "toString", "", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public final class DictionaryWrapperDto<T extends java.lang.Object> extends ooo.jtc.generic.GenericDto<T> {
    @org.jetbrains.annotations.Nullable()
    private T data;
    private boolean failOnInvalid;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public T getData() {
        return null;
    }
    
    public void setData(@org.jetbrains.annotations.Nullable()
    T p0) {
    }
    
    public final boolean getFailOnInvalid() {
        return false;
    }
    
    public final void setFailOnInvalid(boolean p0) {
    }
    
    public DictionaryWrapperDto(@org.jetbrains.annotations.Nullable()
    T data, boolean failOnInvalid) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T component1() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    /**
     * Generic wrapper for Dictionaries requests.
     * [failOnInvalid] - means how service will handle errors:
     * true - response status 500 with system error message
     * false - response 200 with control validationResult (default)
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.DictionaryWrapperDto<T> copy(@org.jetbrains.annotations.Nullable()
    T data, boolean failOnInvalid) {
        return null;
    }
    
    /**
     * Generic wrapper for Dictionaries requests.
     * [failOnInvalid] - means how service will handle errors:
     * true - response status 500 with system error message
     * false - response 200 with control validationResult (default)
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Generic wrapper for Dictionaries requests.
     * [failOnInvalid] - means how service will handle errors:
     * true - response status 500 with system error message
     * false - response 200 with control validationResult (default)
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Generic wrapper for Dictionaries requests.
     * [failOnInvalid] - means how service will handle errors:
     * true - response status 500 with system error message
     * false - response 200 with control validationResult (default)
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}