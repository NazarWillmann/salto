package ooo.jtc.serialization;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J3\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u001a\u0010\u001c\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001d\"\u0006\u0012\u0002\b\u00030\u001b\u00a2\u0006\u0002\u0010\u001eR#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Looo/jtc/serialization/SerializationUtils;", "", "()V", "JSON_PATH_CONFIGURATION", "Lcom/jayway/jsonpath/Configuration;", "kotlin.jvm.PlatformType", "getJSON_PATH_CONFIGURATION", "()Lcom/jayway/jsonpath/Configuration;", "JSON_PATH_CONFIGURATION$delegate", "Lkotlin/Lazy;", "JSON_PATH_CONTEXT", "Lcom/jayway/jsonpath/ParseContext;", "getJSON_PATH_CONTEXT", "()Lcom/jayway/jsonpath/ParseContext;", "OBJECT_MAPPER", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "getOBJECT_MAPPER", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "OBJECT_MAPPER$delegate", "XML_MAPPER", "getXML_MAPPER", "XML_MAPPER$delegate", "applyDefaultMapperConfig", "Lkotlin/Function1;", "constructType", "Lcom/fasterxml/jackson/databind/JavaType;", "baseClass", "Ljava/lang/Class;", "classes", "", "(Ljava/lang/Class;[Ljava/lang/Class;)Lcom/fasterxml/jackson/databind/JavaType;", "qa-utils"})
public final class SerializationUtils {
    private static final kotlin.jvm.functions.Function1<com.fasterxml.jackson.databind.ObjectMapper, com.fasterxml.jackson.databind.ObjectMapper> applyDefaultMapperConfig = null;
    
    /**
     * XML-mapper
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy XML_MAPPER$delegate = null;
    
    /**
     * Default jackson Object Mapper
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy OBJECT_MAPPER$delegate = null;
    private static final kotlin.Lazy JSON_PATH_CONFIGURATION$delegate = null;
    public static final ooo.jtc.serialization.SerializationUtils INSTANCE = null;
    
    /**
     * XML-mapper
     */
    @org.jetbrains.annotations.NotNull()
    public final com.fasterxml.jackson.databind.ObjectMapper getXML_MAPPER() {
        return null;
    }
    
    /**
     * Default jackson Object Mapper
     */
    @org.jetbrains.annotations.NotNull()
    public final com.fasterxml.jackson.databind.ObjectMapper getOBJECT_MAPPER() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jayway.jsonpath.ParseContext getJSON_PATH_CONTEXT() {
        return null;
    }
    
    private final com.jayway.jsonpath.Configuration getJSON_PATH_CONFIGURATION() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.fasterxml.jackson.databind.JavaType constructType(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> baseClass, @org.jetbrains.annotations.NotNull()
    java.lang.Class<?>... classes) {
        return null;
    }
    
    private SerializationUtils() {
        super();
    }
}