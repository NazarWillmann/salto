package ooo.jtc.uaa.application.model;

import java.lang.System;

/**
 * Application model.
 * Has fields that fills in [ApplicationData#dbResultPostProcessor]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b\u0012\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b\u0012\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010LJ\u000b\u0010c\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u0010\u0010f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\t\u0010g\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u00c6\u0003J\u0011\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001bH\u00c6\u0003J\u0011\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001bH\u00c6\u0003J\t\u0010k\u001a\u00020\u0007H\u00c6\u0003J\t\u0010l\u001a\u00020\u0003H\u00c6\u0003J\t\u0010m\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010o\u001a\u00020\fH\u00c6\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\t\u0010q\u001a\u00020\u0007H\u00c6\u0003J\u009c\u0002\u0010r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u000e\u001a\u00020\u00072\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001bH\u00c6\u0001\u00a2\u0006\u0002\u0010sJ\u0013\u0010t\u001a\u00020\f2\b\u0010u\u001a\u0004\u0018\u00010vH\u00d6\u0003J\t\u0010w\u001a\u00020\u0005H\u00d6\u0001J\b\u0010x\u001a\u00020yH\u0016J\t\u0010z\u001a\u00020\u0007H\u00d6\u0001R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R\u0016\u0010A\u001a\u00020\u00078\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010(R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u00104\"\u0004\bD\u00106R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010(\"\u0004\bF\u0010*R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010(\"\u0004\bH\u0010*R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010*R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010O\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010(\"\u0004\bQ\u0010*R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\bR\u0010!\"\u0004\bS\u0010#R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\bT\u0010!\"\u0004\bU\u0010#R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010(\"\u0004\bW\u0010*R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[\u00a8\u0006{"}, d2 = {"Looo/jtc/uaa/application/model/Application;", "Looo/jtc/interfaces/ITransferEntity;", "id", "Ljava/util/UUID;", "version", "", "name", "", "clientId", "clientSecret", "redirectUrls", "autoApprove", "", "accessTokenLifeTime", "description", "baseUrl", "loginPath", "approvePath", "mfaPath", "smsMfaPath", "paramsViaFragment", "createdAt", "Ljava/sql/Timestamp;", "deletedAt", "sessionLifeTime", "refreshTokenLifeTime", "allowedFlows", "", "Looo/jtc/uaa/application/dto/AllowedFlows;", "availableResources", "availableCatalogs", "(Ljava/util/UUID;ILjava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/sql/Timestamp;Ljava/sql/Timestamp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAccessTokenLifeTime", "()Ljava/lang/Integer;", "setAccessTokenLifeTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAllowedFlows", "()Ljava/util/List;", "getApprovePath", "()Ljava/lang/String;", "setApprovePath", "(Ljava/lang/String;)V", "getAutoApprove", "()Z", "setAutoApprove", "(Z)V", "getAvailableCatalogs", "getAvailableResources", "getBaseUrl", "setBaseUrl", "getClientId", "()Ljava/util/UUID;", "setClientId", "(Ljava/util/UUID;)V", "getClientSecret", "setClientSecret", "getCreatedAt", "()Ljava/sql/Timestamp;", "setCreatedAt", "(Ljava/sql/Timestamp;)V", "getDeletedAt", "setDeletedAt", "getDescription", "setDescription", "entityName", "getEntityName", "getId", "setId", "getLoginPath", "setLoginPath", "getMfaPath", "setMfaPath", "getName", "setName", "getParamsViaFragment", "()Ljava/lang/Boolean;", "setParamsViaFragment", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRedirectUrls", "setRedirectUrls", "getRefreshTokenLifeTime", "setRefreshTokenLifeTime", "getSessionLifeTime", "setSessionLifeTime", "getSmsMfaPath", "setSmsMfaPath", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;ILjava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/sql/Timestamp;Ljava/sql/Timestamp;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Looo/jtc/uaa/application/model/Application;", "equals", "other", "", "hashCode", "toDto", "Looo/jtc/uaa/application/dto/ApplicationDto;", "toString", "datamodels"})
@com.github.pozo.KotlinBuilder()
public final class Application implements ooo.jtc.interfaces.ITransferEntity {
    @org.jetbrains.annotations.NotNull()
    @ooo.jtc.annotations.NotRequiredForTest()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    private final java.lang.String entityName = "\u041f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0435";
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID clientId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String clientSecret;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String redirectUrls;
    private boolean autoApprove;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer accessTokenLifeTime;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String baseUrl;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String loginPath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String approvePath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mfaPath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String smsMfaPath;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean paramsViaFragment;
    @org.jetbrains.annotations.Nullable()
    private java.sql.Timestamp createdAt;
    @org.jetbrains.annotations.Nullable()
    private java.sql.Timestamp deletedAt;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer sessionLifeTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer refreshTokenLifeTime;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<ooo.jtc.uaa.application.dto.AllowedFlows> allowedFlows = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.UUID> availableResources = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.UUID> availableCatalogs = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.uaa.application.dto.ApplicationDto toDto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.UUID getId() {
        return null;
    }
    
    @java.lang.Override()
    public void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @java.lang.Override()
    public int getVersion() {
        return 0;
    }
    
    @java.lang.Override()
    public void setVersion(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getClientId() {
        return null;
    }
    
    public final void setClientId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClientSecret() {
        return null;
    }
    
    public final void setClientSecret(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRedirectUrls() {
        return null;
    }
    
    public final void setRedirectUrls(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getAutoApprove() {
        return false;
    }
    
    public final void setAutoApprove(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAccessTokenLifeTime() {
        return null;
    }
    
    public final void setAccessTokenLifeTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBaseUrl() {
        return null;
    }
    
    public final void setBaseUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLoginPath() {
        return null;
    }
    
    public final void setLoginPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getApprovePath() {
        return null;
    }
    
    public final void setApprovePath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMfaPath() {
        return null;
    }
    
    public final void setMfaPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSmsMfaPath() {
        return null;
    }
    
    public final void setSmsMfaPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getParamsViaFragment() {
        return null;
    }
    
    public final void setParamsViaFragment(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getDeletedAt() {
        return null;
    }
    
    public final void setDeletedAt(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSessionLifeTime() {
        return null;
    }
    
    public final void setSessionLifeTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRefreshTokenLifeTime() {
        return null;
    }
    
    public final void setRefreshTokenLifeTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.uaa.application.dto.AllowedFlows> getAllowedFlows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> getAvailableResources() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> getAvailableCatalogs() {
        return null;
    }
    
    public Application(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "client_id")
    java.util.UUID clientId, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "client_secret")
    java.lang.String clientSecret, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "redirect_urls")
    java.lang.String redirectUrls, @com.fasterxml.jackson.annotation.JsonProperty(value = "auto_approve")
    boolean autoApprove, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "access_token_lifetime")
    java.lang.Integer accessTokenLifeTime, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "description")
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "base_url")
    java.lang.String baseUrl, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "login_path")
    java.lang.String loginPath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "approve_path")
    java.lang.String approvePath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "mfa_path")
    java.lang.String mfaPath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "sms_mfa_path")
    java.lang.String smsMfaPath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "params_via_fragment")
    java.lang.Boolean paramsViaFragment, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "created_at")
    java.sql.Timestamp createdAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deleted_at")
    java.sql.Timestamp deletedAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "session_lifetime")
    java.lang.Integer sessionLifeTime, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "refresh_token_lifetime")
    java.lang.Integer refreshTokenLifeTime, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.uaa.application.dto.AllowedFlows> allowedFlows, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableResources, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableCatalogs) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.uaa.application.dto.AllowedFlows> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> component22() {
        return null;
    }
    
    /**
     * Application model.
     * Has fields that fills in [ApplicationData#dbResultPostProcessor]
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.application.model.Application copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "client_id")
    java.util.UUID clientId, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "client_secret")
    java.lang.String clientSecret, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "redirect_urls")
    java.lang.String redirectUrls, @com.fasterxml.jackson.annotation.JsonProperty(value = "auto_approve")
    boolean autoApprove, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "access_token_lifetime")
    java.lang.Integer accessTokenLifeTime, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "description")
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "base_url")
    java.lang.String baseUrl, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "login_path")
    java.lang.String loginPath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "approve_path")
    java.lang.String approvePath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "mfa_path")
    java.lang.String mfaPath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "sms_mfa_path")
    java.lang.String smsMfaPath, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "params_via_fragment")
    java.lang.Boolean paramsViaFragment, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "created_at")
    java.sql.Timestamp createdAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deleted_at")
    java.sql.Timestamp deletedAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "session_lifetime")
    java.lang.Integer sessionLifeTime, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "refresh_token_lifetime")
    java.lang.Integer refreshTokenLifeTime, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.uaa.application.dto.AllowedFlows> allowedFlows, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableResources, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableCatalogs) {
        return null;
    }
    
    /**
     * Application model.
     * Has fields that fills in [ApplicationData#dbResultPostProcessor]
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Application model.
     * Has fields that fills in [ApplicationData#dbResultPostProcessor]
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Application model.
     * Has fields that fills in [ApplicationData#dbResultPostProcessor]
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}