package ooo.jtc.api.common.steps;

import java.lang.System;

/**
 * Steps for REST API executing.
 * [service] Service information
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\n\u00a8\u0006\u001b"}, d2 = {"Looo/jtc/api/common/steps/AbstractApiSteps;", "Looo/jtc/api/common/steps/AbstractSteps;", "user", "Looo/jtc/uaa/User;", "service", "Looo/jtc/testdata/Service;", "(Looo/jtc/uaa/User;Looo/jtc/testdata/Service;)V", "authorizedApi", "Looo/jtc/core/api/CoreApi;", "getAuthorizedApi", "()Looo/jtc/core/api/CoreApi;", "reAuthorize", "Lkotlin/Function0;", "getService", "()Looo/jtc/testdata/Service;", "setService", "(Looo/jtc/testdata/Service;)V", "servicePath", "", "getServicePath", "()Ljava/lang/String;", "servicePath$delegate", "Lkotlin/Lazy;", "unAuthorizedApi", "getUnAuthorizedApi", "uploadApi", "getUploadApi", "box-tests"})
public abstract class AbstractApiSteps extends ooo.jtc.api.common.steps.AbstractSteps {
    
    /**
     * Base service endpoint
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy servicePath$delegate = null;
    private final kotlin.jvm.functions.Function0<ooo.jtc.uaa.User> reAuthorize = null;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.testdata.Service service;
    
    /**
     * Base service endpoint
     */
    @org.jetbrains.annotations.NotNull()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi getAuthorizedApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi getUnAuthorizedApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.api.CoreApi getUploadApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.testdata.Service getService() {
        return null;
    }
    
    public final void setService(@org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.Service p0) {
    }
    
    public AbstractApiSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.Service service) {
        super(null);
    }
}