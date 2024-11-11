package ooo.jtc.uaa.resource.model;

import java.lang.System;

/**
 * Enum uses for 's-domain' parameter in API-request's header.
 * Also for modifying CoreApi.withDomain().
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u00020\u00038\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Looo/jtc/uaa/resource/model/Audience;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "CUSTOMER", "BANK", "INDIVIDUAL", "INTERNAL", "UAA", "MANAGEMENT_UAA", "FOR_TEST", "datamodels"})
public enum Audience {
    /*public static final*/ CUSTOMER /* = new CUSTOMER(null) */,
    /*public static final*/ BANK /* = new BANK(null) */,
    /*public static final*/ INDIVIDUAL /* = new INDIVIDUAL(null) */,
    /*public static final*/ INTERNAL /* = new INTERNAL(null) */,
    /*public static final*/ UAA /* = new UAA(null) */,
    /*public static final*/ MANAGEMENT_UAA /* = new MANAGEMENT_UAA(null) */,
    /*public static final*/ FOR_TEST /* = new FOR_TEST(null) */;
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
    
    Audience(java.lang.String value) {
    }
}