package ooo.jtc.core.jextensions;

import java.lang.System;

/**
 * Listener that executed before dynamic test start
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/core/jextensions/BoxAllureTestInterceptor;", "Lorg/junit/jupiter/api/extension/BeforeAllCallback;", "Lorg/junit/jupiter/api/extension/AfterAllCallback;", "()V", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "addTmsIdsToTestSuites", "", "afterAll", "context", "Lorg/junit/jupiter/api/extension/ExtensionContext;", "beforeAll", "saveFailedTestIdsForRetry", "box-tests"})
public final class BoxAllureTestInterceptor implements org.junit.jupiter.api.extension.BeforeAllCallback, org.junit.jupiter.api.extension.AfterAllCallback {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
    @java.lang.Override()
    public void beforeAll(@org.jetbrains.annotations.Nullable()
    org.junit.jupiter.api.extension.ExtensionContext context) {
    }
    
    @java.lang.Override()
    public void afterAll(@org.jetbrains.annotations.Nullable()
    org.junit.jupiter.api.extension.ExtensionContext context) {
    }
    
    /**
     * Add [org.junit.jupiter.api.Tag]'s with TmsID to *TestSuites from [tmsSuiteMap].
     */
    private final void addTmsIdsToTestSuites() {
    }
    
    /**
     * Saves failed test ids to file for retry run.
     */
    private final void saveFailedTestIdsForRetry() {
    }
    
    public BoxAllureTestInterceptor() {
        super();
    }
}