package ooo.jtc.core.api;

import java.lang.System;

/**
 * Class for working with REST API.
 * @param baseUri - host value
 * @param port - host port
 * @param headers - map of String, String to adding in request headers
 * @param objectMapper - mapper for serialize/deserialize objects
 * @param contentType - content type (enum), Json by default
 * @param contentTypeStr - content type (string). Should be used only when there is no corresponding [contentType] enum
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 32\u00020\u0001:\u00013Bz\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0019\b\u0002\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u00a2\u0006\u0002\b\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013\u00a2\u0006\u0002\u0010\u0014J:\u0010\u001e\u001a\u00020\u001f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f0\u000e\u00a2\u0006\u0002\b\u00112\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00100\u000e\u00a2\u0006\u0002\b\u0011J\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0003J\u000e\u0010\'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0003J\u0016\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0003J\u0016\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003J\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0003R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Looo/jtc/core/api/CoreApi;", "", "baseUri", "", "port", "", "headers", "", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "contentType", "Lio/restassured/http/ContentType;", "contentTypeStr", "config", "Lkotlin/Function1;", "Lio/restassured/builder/RequestSpecBuilder;", "", "Lkotlin/ExtensionFunctionType;", "reAuthorize", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/fasterxml/jackson/databind/ObjectMapper;Lio/restassured/http/ContentType;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getReAuthorize", "()Lkotlin/jvm/functions/Function0;", "reAuthorizeAttempts", "requestVar", "Ljava/io/PrintStream;", "responseVar", "spec", "Lio/restassured/specification/RequestSpecification;", "specBaseState", "send", "Lio/restassured/response/Response;", "method", "check", "withBaseAuth", "userName", "password", "withBearerAuth", "bearer", "withDomain", "domain", "withHeader", "headerName", "headerValue", "withLanguage", "language", "withParam", "paramName", "paramValue", "withUserAuth", "user", "Companion", "qa-core-api"})
public final class CoreApi {
    private final java.io.PrintStream requestVar = null;
    private final java.io.PrintStream responseVar = null;
    private io.restassured.specification.RequestSpecification spec;
    private io.restassured.specification.RequestSpecification specBaseState;
    private int reAuthorizeAttempts = 1;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.lang.Object> reAuthorize = null;
    public static final ooo.jtc.core.api.CoreApi.Companion Companion = null;
    
    /**
     * Add basic authentication.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withBaseAuth(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    /**
     * Add bearer authorization in header
     *
     * @param bearer - Bearer key in format 'Bearer ...'
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withBearerAuth(@org.jetbrains.annotations.NotNull()
    java.lang.String bearer) {
        return null;
    }
    
    /**
     * Add domain in header
     *
     * @param domain - add s-domain in header
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String domain) {
        return null;
    }
    
    /**
     * Add user in header
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withUserAuth(@org.jetbrains.annotations.NotNull()
    java.lang.String user) {
        return null;
    }
    
    /**
     * Add Content-Language in header
     * E.g. "ru", "en"
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    /**
     * Add custom header
     *
     * @param headerName - custom header name
     * @param headerValue - custom header value
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withHeader(@org.jetbrains.annotations.NotNull()
    java.lang.String headerName, @org.jetbrains.annotations.NotNull()
    java.lang.String headerValue) {
        return null;
    }
    
    /**
     * Add custom parameter
     *
     * @param paramName - custom parameter name
     * @param paramValue - custom parameter value
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi withParam(@org.jetbrains.annotations.NotNull()
    java.lang.String paramName, @org.jetbrains.annotations.NotNull()
    java.lang.String paramValue) {
        return null;
    }
    
    /**
     * Main method for sending REST request
     *
     * @param build - lambda for adding need actions in RequestSpecBuilder
     * @param method - RestAssurded sending method
     * @param check - method for checking Response
     */
    @org.jetbrains.annotations.NotNull()
    public final io.restassured.response.Response send(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super io.restassured.specification.RequestSpecification, ? extends io.restassured.response.Response> method, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super io.restassured.response.Response, kotlin.Unit> check) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<java.lang.Object> getReAuthorize() {
        return null;
    }
    
    public CoreApi(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUri, @org.jetbrains.annotations.Nullable()
    java.lang.Integer port, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers, @org.jetbrains.annotations.NotNull()
    com.fasterxml.jackson.databind.ObjectMapper objectMapper, @org.jetbrains.annotations.Nullable()
    io.restassured.http.ContentType contentType, @org.jetbrains.annotations.NotNull()
    java.lang.String contentTypeStr, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super io.restassured.builder.RequestSpecBuilder, kotlin.Unit> config, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.lang.Object> reAuthorize) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u00a8\u0006\f"}, d2 = {"Looo/jtc/core/api/CoreApi$Companion;", "", "()V", "defaultStatusCheck", "Lkotlin/Function1;", "Lio/restassured/response/Response;", "", "Lkotlin/ExtensionFunctionType;", "withCheckResponseCode", "", "statusCode", "", "qa-core-api"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<io.restassured.response.Response, kotlin.Unit> defaultStatusCheck(boolean withCheckResponseCode, int statusCode) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}