package ooo.jtc.uaa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b8\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rB\u007f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u001aJ\u000b\u0010A\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\t\u0010D\u001a\u00020\u0018H\u00c6\u0003J\t\u0010E\u001a\u00020\u0018H\u00c6\u0003J\t\u0010F\u001a\u00020\u0011H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\t\u0010H\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\t\u0010M\u001a\u00020\u000fH\u00c6\u0003J\u0095\u0001\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010\u0015\u001a\u00020\u000f2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u00c6\u0001J\u0013\u0010O\u001a\u00020\u00182\b\u0010P\u001a\u0004\u0018\u00010QH\u00d6\u0003J\t\u0010R\u001a\u00020\u0011H\u00d6\u0001J\t\u0010S\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0015\u001a\u00020\u000fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u0016\u0010\'\u001a\u00020\u00038\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010\u0017\u001a\u00020\u0018X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0019\u001a\u00020\u0018X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010+\"\u0004\b.\u0010-R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006T"}, d2 = {"Looo/jtc/uaa/StoredUser;", "Looo/jtc/uaa/User;", "login", "", "password", "userType", "Looo/jtc/uaa/UserType;", "catalog", "Looo/jtc/uaa/catalog/model/Catalog;", "audience", "Looo/jtc/uaa/resource/model/Audience;", "userDetails", "Looo/jtc/uaa/user/dto/UserDetails;", "(Ljava/lang/String;Ljava/lang/String;Looo/jtc/uaa/UserType;Looo/jtc/uaa/catalog/model/Catalog;Looo/jtc/uaa/resource/model/Audience;Looo/jtc/uaa/user/dto/UserDetails;)V", "id", "Ljava/util/UUID;", "version", "", "domain", "bearer", "uaaUserId", "catalogId", "catalogName", "isBank", "", "isClient", "(Ljava/util/UUID;ILjava/lang/String;Looo/jtc/uaa/UserType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Ljava/util/UUID;Ljava/lang/String;Looo/jtc/uaa/user/dto/UserDetails;ZZ)V", "getBearer", "()Ljava/lang/String;", "setBearer", "(Ljava/lang/String;)V", "getCatalogId", "()Ljava/util/UUID;", "setCatalogId", "(Ljava/util/UUID;)V", "getCatalogName", "setCatalogName", "getDomain", "setDomain", "entityName", "getEntityName", "getId", "setId", "()Z", "setBank", "(Z)V", "setClient", "getLogin", "setLogin", "getPassword", "setPassword", "getUaaUserId", "setUaaUserId", "getUserDetails", "()Looo/jtc/uaa/user/dto/UserDetails;", "setUserDetails", "(Looo/jtc/uaa/user/dto/UserDetails;)V", "getUserType", "()Looo/jtc/uaa/UserType;", "setUserType", "(Looo/jtc/uaa/UserType;)V", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
public final class StoredUser implements ooo.jtc.uaa.User {
    @org.jetbrains.annotations.NotNull()
    @ooo.jtc.annotations.NotRequiredForTest()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    private final java.lang.String entityName = "Stored user";
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String domain;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.uaa.UserType userType;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String bearer;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String login;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String password;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID uaaUserId;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID catalogId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String catalogName;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.uaa.user.dto.UserDetails userDetails;
    private boolean isBank;
    private boolean isClient;
    
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
    @java.lang.Override()
    public java.lang.String getDomain() {
        return null;
    }
    
    @java.lang.Override()
    public void setDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.uaa.UserType getUserType() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserType(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getBearer() {
        return null;
    }
    
    @java.lang.Override()
    public void setBearer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getLogin() {
        return null;
    }
    
    @java.lang.Override()
    public void setLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getPassword() {
        return null;
    }
    
    @java.lang.Override()
    public void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.UUID getUaaUserId() {
        return null;
    }
    
    @java.lang.Override()
    public void setUaaUserId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.UUID getCatalogId() {
        return null;
    }
    
    @java.lang.Override()
    public void setCatalogId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCatalogName() {
        return null;
    }
    
    public final void setCatalogName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public ooo.jtc.uaa.user.dto.UserDetails getUserDetails() {
        return null;
    }
    
    @java.lang.Override()
    public void setUserDetails(@org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.user.dto.UserDetails p0) {
    }
    
    @java.lang.Override()
    public boolean isBank() {
        return false;
    }
    
    @java.lang.Override()
    public void setBank(boolean p0) {
    }
    
    @java.lang.Override()
    public boolean isClient() {
        return false;
    }
    
    @java.lang.Override()
    public void setClient(boolean p0) {
    }
    
    public StoredUser(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String domain, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType, @org.jetbrains.annotations.Nullable()
    java.lang.String bearer, @org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id_user")
    java.util.UUID uaaUserId, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id_catalog")
    java.util.UUID catalogId, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "cat_name")
    java.lang.String catalogName, @org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.user.dto.UserDetails userDetails, boolean isBank, boolean isClient) {
        super();
    }
    
    public StoredUser(@org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.catalog.model.Catalog catalog, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.resource.model.Audience audience, @org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.user.dto.UserDetails userDetails) {
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
    public final ooo.jtc.uaa.UserType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.uaa.user.dto.UserDetails component11() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.StoredUser copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String domain, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType, @org.jetbrains.annotations.Nullable()
    java.lang.String bearer, @org.jetbrains.annotations.NotNull()
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id_user")
    java.util.UUID uaaUserId, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id_catalog")
    java.util.UUID catalogId, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "cat_name")
    java.lang.String catalogName, @org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.user.dto.UserDetails userDetails, boolean isBank, boolean isClient) {
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