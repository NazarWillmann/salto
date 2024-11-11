package ooo.jtc.uaa.application.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u00a1\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0018J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010<\u001a\u00020\u0015H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0007H\u00c6\u0003J\t\u0010A\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nH\u00c6\u0003J\u0011\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nH\u00c6\u0003J\t\u0010F\u001a\u00020\u0010H\u00c6\u0003J\u00c8\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010KH\u00d6\u0003J\t\u0010L\u001a\u00020\u0005H\u00d6\u0001J\b\u0010M\u001a\u00020NH\u0016J\t\u0010O\u001a\u00020\u0007H\u00d6\u0001R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R&\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR&\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\'\"\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b2\u0010\u001aR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b3\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006P"}, d2 = {"Looo/jtc/uaa/application/dto/ApplicationDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "name", "", "description", "allowedFlows", "", "Looo/jtc/uaa/application/dto/AllowedFlows;", "redirectUrls", "availableResources", "availableCatalogs", "autoApproveScopes", "", "accessTokenLifeTime", "refreshTokenLifeTime", "sessionLifeTime", "loginSite", "Looo/jtc/uaa/application/dto/ApplicationLoginSiteDto;", "clientId", "clientSecret", "(Ljava/util/UUID;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Looo/jtc/uaa/application/dto/ApplicationLoginSiteDto;Ljava/util/UUID;Ljava/lang/String;)V", "getAccessTokenLifeTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAllowedFlows", "()Ljava/util/List;", "setAllowedFlows", "(Ljava/util/List;)V", "getAutoApproveScopes", "()Z", "getAvailableCatalogs", "setAvailableCatalogs", "getAvailableResources", "setAvailableResources", "getClientId", "()Ljava/util/UUID;", "getClientSecret", "()Ljava/lang/String;", "getDescription", "getId", "setId", "(Ljava/util/UUID;)V", "getLoginSite", "()Looo/jtc/uaa/application/dto/ApplicationLoginSiteDto;", "getName", "getRedirectUrls", "getRefreshTokenLifeTime", "getSessionLifeTime", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Looo/jtc/uaa/application/dto/ApplicationLoginSiteDto;Ljava/util/UUID;Ljava/lang/String;)Looo/jtc/uaa/application/dto/ApplicationDto;", "equals", "other", "", "hashCode", "toModel", "Looo/jtc/uaa/application/model/Application;", "toString", "datamodels"})
@ooo.jtc.annotations.EntityName(name = "\u041f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u0435")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.github.pozo.KotlinBuilder()
public final class ApplicationDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.uaa.application.dto.ApplicationDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    @ooo.jtc.annotations.NotRequiredForTest()
    private int version;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.util.List<? extends ooo.jtc.uaa.application.dto.AllowedFlows> allowedFlows;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String redirectUrls = null;
    @org.jetbrains.annotations.NotNull()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.util.List<java.util.UUID> availableResources;
    @org.jetbrains.annotations.NotNull()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.util.List<java.util.UUID> availableCatalogs;
    private final boolean autoApproveScopes = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer accessTokenLifeTime = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer refreshTokenLifeTime = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer sessionLifeTime = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto loginSite = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.UUID clientId = null;
    @org.jetbrains.annotations.Nullable()
    @ooo.jtc.annotations.NotRequiredForTest()
    private final java.lang.String clientSecret = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.uaa.application.model.Application toModel() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.uaa.application.dto.AllowedFlows> getAllowedFlows() {
        return null;
    }
    
    public final void setAllowedFlows(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.uaa.application.dto.AllowedFlows> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRedirectUrls() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> getAvailableResources() {
        return null;
    }
    
    public final void setAvailableResources(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> getAvailableCatalogs() {
        return null;
    }
    
    public final void setAvailableCatalogs(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> p0) {
    }
    
    public final boolean getAutoApproveScopes() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAccessTokenLifeTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRefreshTokenLifeTime() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSessionLifeTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto getLoginSite() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getClientId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getClientSecret() {
        return null;
    }
    
    public ApplicationDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.uaa.application.dto.AllowedFlows> allowedFlows, @org.jetbrains.annotations.Nullable()
    java.lang.String redirectUrls, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableResources, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableCatalogs, boolean autoApproveScopes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer accessTokenLifeTime, @org.jetbrains.annotations.Nullable()
    java.lang.Integer refreshTokenLifeTime, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sessionLifeTime, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto loginSite, @org.jetbrains.annotations.Nullable()
    java.util.UUID clientId, @org.jetbrains.annotations.Nullable()
    java.lang.String clientSecret) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public java.lang.String getEntityName() {
        return null;
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
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.uaa.application.dto.AllowedFlows> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.UUID> component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.application.dto.ApplicationDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends ooo.jtc.uaa.application.dto.AllowedFlows> allowedFlows, @org.jetbrains.annotations.Nullable()
    java.lang.String redirectUrls, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableResources, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> availableCatalogs, boolean autoApproveScopes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer accessTokenLifeTime, @org.jetbrains.annotations.Nullable()
    java.lang.Integer refreshTokenLifeTime, @org.jetbrains.annotations.Nullable()
    java.lang.Integer sessionLifeTime, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.application.dto.ApplicationLoginSiteDto loginSite, @org.jetbrains.annotations.Nullable()
    java.util.UUID clientId, @org.jetbrains.annotations.Nullable()
    java.lang.String clientSecret) {
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