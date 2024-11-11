package ooo.jtc.core;

import java.lang.System;

/**
 * Object for store Application Properties
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0011H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\t\u0010-\u001a\u00020\tH\u00c6\u0003J\t\u0010.\u001a\u00020\u000bH\u00c6\u0003J\t\u0010/\u001a\u00020\rH\u00c6\u0003J\t\u00100\u001a\u00020\u000fH\u00c6\u0003J\t\u00101\u001a\u00020\u0011H\u00c6\u0003J\t\u00102\u001a\u00020\u0013H\u00c6\u0003Jm\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0011H\u00c6\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u000e\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011J\t\u00109\u001a\u00020\u0013H\u00d6\u0001J\u0006\u0010:\u001a\u000205J\t\u0010;\u001a\u00020\u0011H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(\u00a8\u0006<"}, d2 = {"Looo/jtc/core/ApplicationProperties;", "", "testdata", "Looo/jtc/core/TestDataProps;", "server", "Looo/jtc/core/Server;", "db", "Looo/jtc/core/Db;", "services", "Looo/jtc/core/ServicesInfo;", "cryptoPluginStub", "Looo/jtc/core/Api;", "ui", "Looo/jtc/properties/UiTestProperties;", "tms", "Looo/jtc/core/Tms;", "failedTestsFile", "", "maxRetry", "", "i18nLocale", "(Looo/jtc/core/TestDataProps;Looo/jtc/core/Server;Looo/jtc/core/Db;Looo/jtc/core/ServicesInfo;Looo/jtc/core/Api;Looo/jtc/properties/UiTestProperties;Looo/jtc/core/Tms;Ljava/lang/String;ILjava/lang/String;)V", "getCryptoPluginStub", "()Looo/jtc/core/Api;", "getDb", "()Looo/jtc/core/Db;", "getFailedTestsFile", "()Ljava/lang/String;", "getI18nLocale", "getMaxRetry", "()I", "getServer", "()Looo/jtc/core/Server;", "getServices", "()Looo/jtc/core/ServicesInfo;", "getTestdata", "()Looo/jtc/core/TestDataProps;", "getTms", "()Looo/jtc/core/Tms;", "getUi", "()Looo/jtc/properties/UiTestProperties;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getSystem", "propName", "hashCode", "isUiRemote", "toString", "box-tests"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public final class ApplicationProperties {
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.TestDataProps testdata = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.Server server = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.Db db = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.ServicesInfo services = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.Api cryptoPluginStub = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.properties.UiTestProperties ui = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.core.Tms tms = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String failedTestsFile = null;
    private final int maxRetry = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String i18nLocale = null;
    
    /**
     * Exception handler for [System.getProperty].
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSystem(@org.jetbrains.annotations.NotNull()
    java.lang.String propName) {
        return null;
    }
    
    /**
     * Flag for UI-test running mode.
     * If is remote then - true.
     */
    public final boolean isUiRemote() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.TestDataProps getTestdata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Server getServer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Db getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServicesInfo getServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Api getCryptoPluginStub() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.properties.UiTestProperties getUi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Tms getTms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFailedTestsFile() {
        return null;
    }
    
    public final int getMaxRetry() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getI18nLocale() {
        return null;
    }
    
    public ApplicationProperties(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.TestDataProps testdata, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Server server, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Db db, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServicesInfo services, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Api cryptoPluginStub, @org.jetbrains.annotations.NotNull()
    ooo.jtc.properties.UiTestProperties ui, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Tms tms, @org.jetbrains.annotations.NotNull()
    java.lang.String failedTestsFile, int maxRetry, @org.jetbrains.annotations.NotNull()
    java.lang.String i18nLocale) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.TestDataProps component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Server component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Db component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ServicesInfo component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Api component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.properties.UiTestProperties component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.Tms component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    /**
     * Object for store Application Properties
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.ApplicationProperties copy(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.TestDataProps testdata, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Server server, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Db db, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServicesInfo services, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Api cryptoPluginStub, @org.jetbrains.annotations.NotNull()
    ooo.jtc.properties.UiTestProperties ui, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.Tms tms, @org.jetbrains.annotations.NotNull()
    java.lang.String failedTestsFile, int maxRetry, @org.jetbrains.annotations.NotNull()
    java.lang.String i18nLocale) {
        return null;
    }
    
    /**
     * Object for store Application Properties
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Object for store Application Properties
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Object for store Application Properties
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}