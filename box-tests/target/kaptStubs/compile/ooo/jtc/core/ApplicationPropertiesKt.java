package ooo.jtc.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"CHECK_PROPERTIES_STEP", "", "CONFIG_FILE_DEFAULT", "CONFIG_FILE_PROPERTY_NAME", "PROFILE_DEFAULT", "PROFILE_PROPERTY_NAME", "applicationProperties", "Looo/jtc/core/ApplicationProperties;", "getApplicationProperties", "()Looo/jtc/core/ApplicationProperties;", "queueSize", "", "getQueueSize", "()J", "queueSize$delegate", "Lkotlin/Lazy;", "box-tests"})
public final class ApplicationPropertiesKt {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONFIG_FILE_PROPERTY_NAME = "configFile";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CONFIG_FILE_DEFAULT = "../application.yml";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROFILE_PROPERTY_NAME = "profile";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PROFILE_DEFAULT = "test";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHECK_PROPERTIES_STEP = "\u0418\u043d\u0438\u0446\u0438\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u044f \u043f\u0440\u043e\u043f\u0435\u0440\u0442\u0435\u0439";
    
    /**
     * Uses for prepared data "queue" size.
     * Based on parallel threads count multiplied by expander for insurance that queue not empty.
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy queueSize$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private static final ooo.jtc.core.ApplicationProperties applicationProperties = null;
    
    /**
     * Uses for prepared data "queue" size.
     * Based on parallel threads count multiplied by expander for insurance that queue not empty.
     */
    public static final long getQueueSize() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final ooo.jtc.core.ApplicationProperties getApplicationProperties() {
        return null;
    }
}